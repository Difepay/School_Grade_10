IDEAL
MODEL small
STACK 100h
DATASEG
  ;----VARS----
  var db 0
CODESEG 
start: 
	mov ax, @data 
	mov ds, ax
	
	;----CODE----
	mov [var], 5

	
exit: 
	mov ax, 4c00h 
	int 21h 
END start
