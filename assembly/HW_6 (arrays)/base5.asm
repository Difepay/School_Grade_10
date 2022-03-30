IDEAL
MODEL small
STACK 100h
DATASEG
	;-----VARS-----:
	arr db 1,2,3,4
CODESEG
start:
	mov ax, @data
	mov ds, ax
	
	;-----CODE-----:
	mov bx, offset arr
    add [byte ptr bx], 10h
    add [byte ptr bx + 1], 10h
    add [byte ptr bx + 2], 10h
    add [byte ptr bx + 3], 10h
exit:
    mov ax, 4c00h
    int 21h
END start
