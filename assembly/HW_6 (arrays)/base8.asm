IDEAL
MODEL small
STACK 100h
DATASEG
    ;-----VARS-----:
    numbers db 1, 2, 1, 2, 1, 2, 1, 2, 1, 2
CODESEG
start:
    mov ax, @data
    mov ds, ax

    ;-----CODE-----:
	mov bx, offset numbers
	
	mov al, [byte ptr bx]
	mov ah, [byte ptr bx + 1]
	mov [byte ptr bx], ah
	mov [byte ptr bx + 1], al
	
	mov al, [byte ptr bx + 2]
	mov ah, [byte ptr bx + 3]
	mov [byte ptr bx + 2], ah
	mov [byte ptr bx + 3], al
	
	mov al, [byte ptr bx + 4]
	mov ah, [byte ptr bx + 5]
	mov [byte ptr bx + 4], ah
	mov [byte ptr bx + 5], al
	
	mov al, [byte ptr bx + 6]
	mov ah, [byte ptr bx + 7]
	mov [byte ptr bx + 6], ah
	mov [byte ptr bx + 7], al
	
exit:
    mov ax, 4c00h
    int 21h
END start
