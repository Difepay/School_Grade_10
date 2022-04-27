IDEAL
MODEL small
STACK 100h
DATASEG
    ;-----VARS-----:
	iterationCount db 3
    binaryKey db 00000001b

CODESEG
start:
    mov ax, @data
    mov ds, ax
   
	;-----CODE-----:
    xor ax, ax
	mov cl, [iterationCount]        ; Save to cl count of numbers to input
	
	mainLoop:
		; Ask to enter number and convert it to a number
		mov ah, 1h
		int 21h
		sub al, '0'

        and al, [binaryKey]         ; Save to al 1 if a number is odd and 0 if a number is even
        mov bl, al                  ; Save value of al to bl

        ; New line between number and letter
        mov dl, 0ah
		mov ah, 2h
		int 21h

        cmp bl, 0
		je printEven    ; If bl (al) is even - jump to 'printEven' label. Else - continue code

        ; This label print letter 'O' (Odd) and jumps to 'newLine' label
        printOdd:
		    mov dl, 'O'
		    mov ah, 2h
		    int 21h

            jmp newLine

        ; This label prints letter 'E' (Even)
        printEven:
		    mov dl, 'E'
		    mov ah, 2h
		    int 21h

        ; New line between letter and next number
        newLine:
		    mov dl, 0ah
		    mov ah, 2h
		    int 21h
		
		loop mainLoop

exit:
    mov ax, 4c00h
    int 21h
END start
