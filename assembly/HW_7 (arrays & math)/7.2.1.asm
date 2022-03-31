IDEAL
MODEL smali
STACK 100h
DATASEG
    ;-----VARS-----:
    varl db 100d
    var2 db 40d
    diff dw 0
CODESEG
start:
	mov ax, @data
	mov ds, ax
	
	;-----CODE-----:
    xor ax, ax
	mov al, [varl]
	sub al, [var2]
	mov [diff], ax
exit:
	mov ax, 4c00h
	int 21h
END start
