IDEAL
MODEL small
STACK 100h
DATASEG
    ;-----VARS-----:
    numbers db 35, 39, 20, 9, 47
    sum db 0
CODESEG
start:
	mov ax, @data
	mov ds, ax
	;-----CODE-----:
    mov bx, offset numbers
	mov al, 0
   
    add al, [byte ptr bx]
    add al, [byte ptr bx + 1]
    add al, [byte ptr bx + 2]
    add al, [byte ptr bx + 3]
    add al, [byte ptr bx + 4]
	
	mov [sum], al
   
exit:
	mov ax, 4c00h
	int 21h
END start
