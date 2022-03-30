IDEAL
MODEL small
STACK 100h
DATASEG
	;----VARS----
	arr1 db 10 dup(5)
	arr2 dw 10 dup(5)
CODESEG 
start: 
	mov ax, @data 
	mov ds, ax
	
	;----CODE----
exit: 
	mov ax, 4c00h 
	int 21h
END start
