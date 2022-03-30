IDEAL
MODEL small
STACK 100h
DATASEG
; --------------------------
; Your variables here
; --------------------------
	var1 db 8
	var2 db 6
CODESEG
start:
	mov ax, @data
	mov ds, ax
; --------------------------
; Your code here
; --------------------------
	
	mov cl, [var2]
	sub [var1], cl
	
	mov cl, [var1]
exit:
	mov ax, 4c00h
	int 21h
END start
