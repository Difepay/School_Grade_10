IDEAL
MODEL small
STACK 100h
DATASEG
    ;-----VARS-----:
    arrl db 9,8,7,6
    arr2 db 6,7,8,9
    result db 4 dup (0)

CODESEG
start:
	mov ax, @data
	mov ds, ax
	
    ;-----CODE-----:
	mov bx, offset arrl
	mov di, offset arr2
	mov si, offset result
	
	mov al, [byte ptr bx]
	sub al, [byte ptr di]
	mov [byte ptr si], al
	
	mov al, [byte ptr bx + 1]
	sub al, [byte ptr di + 1]
	mov [byte ptr si + 1], al
	
	mov al, [byte ptr bx + 2]
	sub al, [byte ptr di + 2]
	mov [byte ptr si + 2], al
	
	mov al, [byte ptr bx + 3]
	sub al, [byte ptr di + 3]
	mov [byte ptr si + 3], al
	
exit:
	mov ax, 4c00h
	int 21h
END start
