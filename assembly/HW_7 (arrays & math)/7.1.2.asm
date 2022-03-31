IDEAL
MODEL small
STACK 100h
DATASEG
    ;-----VARS-----:
    arr dw 25, 50, 75, 100, 125, 150
CODESEG
start:
	mov ax, @data
	mov ds, ax
	
    ;-----CODE-----:
    xor ax, ax
    lea bx, [arr]
	
    mov ax, [word ptr bx]
    add ax, [word ptr bx + 2]
	add ax, [word ptr bx + 4]
	add ax, [word ptr bx + 6]
	add ax, [word ptr bx + 8]
	add ax, [word ptr bx + 10]
exit:
    mov ax, 4c00h
    int 21h
END start
