IDEAL
MODEL small
STACK 100h
DATASEG
    ;-----VARS-----:
    var1 db 200
	var2 db 70
	sum dw 0
CODESEG
start:
	mov ax, @data
	mov ds, ax
	
    ;-----CODE-----:
    xor ax, ax
	
    mov al, [var1]
	mov [sum], ax
	mov al, [var2]
	add [sum], ax
exit:
    mov ax, 4c00h
    int 21h
END start
