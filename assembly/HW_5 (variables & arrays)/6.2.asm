IDEAL
MODEL small
STACK 100h
DATASEG
	;----VARS----
	var1 db 'I'
	var2 dw 'am'
	var3 dd 'Dima'
CODESEG
start:
	mov ax, @data
	mov ds, ax
	
	;----CODE----
exit:
	mov ax, 4c00h
	int 21h
END start
