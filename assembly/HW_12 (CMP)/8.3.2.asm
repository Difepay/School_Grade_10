IDEAL
MODEL small
STACK 100h
DATASEG
	;-----VARS-----: 
CODESEG
start:
	mov ax, @data
	mov ds, ax
	
	;-----CODE-----:
	xor ax, ax
	xor bx, bx
	
	mov ax, 2
	mov bx, 2
	
	cmp ax, bx
	jne notequals
	je exit
	
	notequals:
		mov ax, bx

exit:
	mov ax, 4c00h
	int 21h
END start
