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
	mov ax, 2
	
	cmp ax, 0
	jle exit
	jg decax
	
	decax:
		dec ax

exit:
	mov ax, 4c00h
	int 21h
END start
