IDEAL
MODEL small
STACK 100h
DATASEG
	;-----VARS-----: 
	var1 db 2
	var2 db 4

CODESEG
start:
	mov ax, @data
	mov ds, ax
	
	;-----CODE-----:
	mov bh, [var1]
	mov bl, [var2]
	
	cmp bh, bl
	ja var1bigger
	jbe var2bigger
	


	var1bigger:
		mov ax, 1
		jmp exit

	var2bigger:
		mov ax, 0
		jmp exit

exit:
	mov ax, 4c00h
	int 21h
END start
