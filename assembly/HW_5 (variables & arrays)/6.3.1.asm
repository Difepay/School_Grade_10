IDEAL
MODEL small
STACK 100h
DATASEG
	;----VARS----
	arr1 db 3 dup(0)
	arr2 db 5 dup(0)
	arr3 db 7 dup(0)
CODESEG 
start: 
	mov ax, @data 
	mov ds, ax
	
	;----CODE----
exit: 
	mov ax, 4c00h 
	int 21h 
END start 
