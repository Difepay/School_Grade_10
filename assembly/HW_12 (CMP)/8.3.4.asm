IDEAL
MODEL small
STACK 100h
DATASEG
	;----VARS----
	var1 db 3
	var2 db 3
CODESEG 
start: 
	mov ax, @data 
	mov ds, ax
	;----CODE----
	xor ax, ax
	mov bl, [var2]
	mov bh, [var1]
	
	cmp bh, bl
	je axadd
	jne axsub
	
	axadd:
		mov al, bh
		shl ax, 1
		jmp exit

	axsub:
		mov al, bh
		sub al, bl
		jmp exit
	
exit: 
	mov ax, 4c00h 
	int 21h 
END start 
