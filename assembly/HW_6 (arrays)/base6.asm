IDEAL
MODEL small
STACK 100h
DATASEG
	;-----VARS-----:
	letters db 'a', 'b', 'c', 'd', 'e'
	diff db 32d
CODESEG
start:
    mov ax, @data
    mov ds, ax
	
    ;-----CODE-----:
	mov bx, offset letters
	mov al, [diff]

    sub [byte ptr bx], al
    sub [byte ptr bx + 1], al
    sub [byte ptr bx + 2], al
    sub [byte ptr bx + 3], al
    sub [byte ptr bx + 4], al

exit:
	mov ax, 4c00h
	int 21h
END start
