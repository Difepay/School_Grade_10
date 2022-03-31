IDEAL
MODEL small
STACK 100h
DATASEG
    ;-----VARS-----:
    arr db 2, 4, 5, 1, 9, 3
CODESEG
start:
	mov ax, @data
	mov ds, ax
	
    ;-----CODE-----:
    xor ax, ax
    mov bx, offset arr
	
    add al, [byte ptr bx]
    add al, [byte ptr bx + 1]
    add al, [byte ptr bx + 2]
    add al, [byte ptr bx + 3]
    add al, [byte ptr bx + 4]
    add al, [byte ptr bx + 5]
exit:
    mov ax, 4c00h
    int 21h
END start
