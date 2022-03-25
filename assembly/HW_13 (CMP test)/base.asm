IDEAL
MODEL small
STACK 100h
DATASEG
	;-----VARS-----: 
	arr db 2, 1, 3, 4

CODESEG
start:
	mov ax, @data
	mov ds, ax
	
	;-----CODE-----:
	lea bx, [arr]
	xor ax, ax
	xor cx, cx
	
	; Bet
	mov cl, [byte ptr bx]
	sub cl, [byte ptr bx + 1]
	
	jz zeroflag
	jnz notzeroflag
	
	
	; Gimel
	continue:
		xor ax, ax
		add al, [byte ptr bx + 2]
		mul [byte ptr bx + 3]
	
		jp evenflag
		jnp noteventflag
	
	
	; Labels
	zeroflag:
		mov al, 1
		jmp continue
	
	notzeroflag:
		mov ah, 1
		jmp continue

	evenflag:
		mov dl, 1
		jmp exit
		
	noteventflag:
		mov dh, 1
		jmp exit

exit:
	mov ax, 4c00h
	int 21h
END start
