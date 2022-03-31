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
	xor cl, cl
	
	mov al, 120d
	mov cl, 3
	shr al, cl

exit:
	mov ax, 4c00h
	int 21h
END start
