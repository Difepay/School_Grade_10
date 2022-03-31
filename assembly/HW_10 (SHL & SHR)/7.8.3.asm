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
	
	; Task C
	mov al, 10d
	mov ah, 10d
	
	mov cl, 2
	shl al, cl
	mov cl, 4
	shl ah, cl
	add al, ah
	xor ah, ah

exit:
	mov ax, 4c00h
	int 21h
END start
