IDEAL
MODEL small
STACK 100h
DATASEG
	max db 0
	len db 0
	buf db 16 dup(0)

	text1	db 'Please indicate your weight (number of full kg) and press the Enter:', 13, 10, '$'

	dose dw 0					; Daily dose * 10 per 1 kg

	weight dw 0				; Weight

	text2	db	13, 10, 'Are you spinning for more than one year? (Y - yes, N - no)', 13, 10,'$'

	text3	db	13, 10, 'Do you have compensation? (Y - constant, N - no, S - sometimes)', 13, 10,'$'

	text4	db  	13, 10, 'Dose of long - acting insulin:', 13, 10
			db		'Breakfast: '
	rez1	db		'         mg', 13, 10
			db		'Dinner:    '
	rez2	db		'         mg', 13, 10

			db		'Dose of short - acting insulin:', 13, 10
			db		'Breakfast: '
	rez3	db		'         mg', 13, 10
			db		'Lunch:     '
	rez4	db		'         mg', 13, 10
			db		'Dinner:    '
	rez5	db		'         mg', 13, 10, '$'
; --------------------------
CODESEG
proc Str2Num
		push bx
		push cx
		push dx

		xor ax, ax
		mov cx, 10
		add si, 2		; To start with number chars (first and second chars are not numbers)
	Str2Num_loop:
		xor bh, bh
		mov bl, [byte ptr si]

		cmp bl, 0			; If string is empty
		je	Str2Num_end

		sub bl, '0'
		js	Str2Num_end		; If char less than '0'
		cmp bl,9			; If (char - '0') bigger than 9
		ja	Str2Num_end

		mul cx
		add ax, bx

		inc si
		jmp		Str2Num_loop

	Str2Num_end:
		pop		dx
		pop		cx
		pop		bx
		ret
endp Str2Num

proc Num2Str
	; Save register values and flags
	pushf
	push ax
	push bx
	push cx
	push dx
	push si
	push di
	
	std				; flag df = 1. Set direction of string usage (from right to left). Indexes are decrease
	add di, 8		; Move our pointer to the last digit before 'mg'
	mov bx, 10		; Divider
	xor cx, cx

	Num2Str_loop:		
		xor dx, dx
		div bx			; ax = ax / 10
		xchg ax, dx		; ax = dx, dx = ax. Now ax - remainder, dx - integer from division
		add al, '0'		; Convert remainder number to the char
		stosb
	; If the second symbol is printed, then put the point in front of it
		cmp cl, 1
		jne Num2Str_nodot		

		mov [byte ptr es:di], '.'		; Print dot between numbers
		dec di								; di = di - 1. Move pointer to the left

	Num2Str_nodot:
		inc cx
		mov ax, dx
		test ax, ax
		jnz Num2Str_loop					; If ax isn't zero
	
	;if there were few signs, then print zeros
		cmp cl, 2
		jbe Num2Str_loop

	; Return values to registers and flags
	Num2Str_end:
		pop di
		pop si
		pop dx
		pop cx
		pop bx
		pop ax
		popf
	ret
endp Num2Str

; Program start
start:
	mov ax, @data
	mov ds, ax

	; Включаем текстовый режим с очисткой экрана
	mov ax, 3   ;Устанавливается символьный видеорежим
	int 10h

	start_input:
; Submit an information line (weight request)
		mov		dx, offset text1		;Link to the first message
		mov		ah,09h				; Printing 
		int		21h					; the end
; We expect the input of age
		mov dx, offset buf		; DX - a link to the buffer for entering the line. 
		mov bx, dx
		mov [byte ptr bx], 4
		mov ah, 0ah				; Link to the line 
		;The first byte is the maximum length, the second byte at the output will indicate the real number of introduced characters
		int		21h					; the end 
; Check that the user has an introduction
		mov al, [byte ptr bx + 1]
		cmp al, 0						; If length of string is 0
		je	start_input

; We convert the line to the text
		mov si, offset buf
		call Str2Num

		cmp ax, 0
		je start_input

		mov [weight], ax

; We will find out how long a person was sick
		mov dx, offset text2		; Link to the message
		mov ah, 09h					; Printing
		int 21h						; the end

; We are waiting for the introduction of the symbol
	symbol00_start:
		mov ah, 01h
		int 21h

		and al, 11011111b			; If input is small letter - convert it to the big letter
		cmp al, 'N'
		jne check_for_y

		; Compensation not needed
		mov ax, 5
		jmp comp_end		; If you are pressed N or n, the disease lasted less than a year		

		check_for_y:
			cmp al, 'Y'
			jne symbol00_start		; If you are pressed Y or y, the disease lasted more than a year
	
; If a person was sick for more than one year, then it is necessary to clarify whether the patient has compensation
; We learn the status of compensation
		mov dx, offset text3			; Link to the  message
		mov ah, 09h						; Printing
		int 21h							; the end

	symbol10_start:
		mov ah, 01h
		int 21h
		
		and al, 11011111b			; If input is small letter - convert it to the big letter

		cmp al,'N'
		jne symbol11
		mov ax, 8
		jmp comp_end

	symbol11:
		cmp al,'Y'
		jne symbol12
		mov ax, 6
		jmp comp_end

	symbol12:
		cmp al,'S'
		jne symbol10_start
		mov ax, 7

comp_end:
; at this stage, in our AX - a daily dose per 1 kg per mg * 10
; Determine the daily dose * 10
		mul [weight]
		mov [dose], ax
; Dose of long - acting insulin for breakfast 1/2 * 0.6 = 0.3
		mov dx, ax
		add ax, ax
		add ax, dx
		mov di, offset rez1
		call Num2Str
; Dose of long - acting insulin for dinner 1/2 * 0.4 = 0.2
		mov ax,dx
		add ax,ax
		mov di, offset rez2
		call Num2Str
; Dose of short - acting insulin for breakfast 1/2 * 0.4 = 0.2
		mov di,offset rez3
		call Num2Str
;Dose of short - acting insulin for lunch 1/2 * 0.3 = 0.15 or 0.2 * 3/4
		mov dx,ax
		add ax,ax
		add ax,dx 
		mov di,offset rez4
		call Num2Str
; Dose of short - acting insulin for dinner 1/2 * 0.3 = 0.15
		mov di,offset rez5
		call Num2Str

; Print result
		mov dx, offset text4		; Link to the  message
		mov ah, 09h				; Printing
		int 21h					; the end

; End of programm 
exit:
	mov ax, 4c00h
	int 21h
END start


;; line translation
;; At the entrance to DS: Si - the address of the buffer with the party
;; At the output AX - number


;;transfer of number into line
;; At the input AX - number
;; At the exit in ES: Di - the address of the buffer with the party. The number is displayed with a point in front of the two last discharges. The output of the number begins with a displacement of 8



