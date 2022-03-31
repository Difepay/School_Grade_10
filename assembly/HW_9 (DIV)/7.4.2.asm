IDEAL
MODEL small
STACK 100h
DATASEG
	;-----VARS-----:
	varl db -10
	var2 db 4
	result_quo db 0
	result_rem db 0
CODESEG
start:
	mov ax, @data
	mov ds, ax
   
	;-----CODE-----:
	xor ax, ax
	mov al, [varl]
	idiv [var2]

	mov [result_quo], al
	mov [result_rem], ah
exit:
	mov ax,4c00h
	int 21h
END start
