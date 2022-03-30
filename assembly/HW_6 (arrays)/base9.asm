IDEAL
MODEL small
STACK 100h
DATASEG
    ;-----VARS-----:
    arrl db 1, 2, 3, 4, 5, 6, 7, 8
    arr2 db 2, з, 4, 5, 6, 7, 8, 9
    result db 8 dup (0)
CODESEG
start:
    mov ax, @data
    mov ds, ax

    ;-----CODE-----:
	mov bx, offset arr1
    mov di, offset arr2
    mov si, offset result
    хor ax, aх

    mov al, [byte ptr bx]
    add al, [byte ptr di]
    mov [byte ptr si], al

    mov al, [byte ptr bx + 1]
    add al, [byte ptr di + 1]
    mov [byte ptr si + 1], al

    mov al, [byte ptr bx + 2]
    add al, [byte ptr di + 2]
    mov [byte ptr si + 2], al

    mov al, [byte ptr bx + 3]
    add al, [byte ptr di + 3]
    mov [byte ptr si + 3], al

    mov al, [byte ptr bx + 4]
    add al, [byte ptr di + 4]
    mov [byte ptr si + 4], al

    mov al, [byte ptr bx + 5]
    add al, [byte ptr di + 5]
    mov [byte ptr si + 5], al
    
    mov al, [byte ptr bx + 6]
    add al, [byte ptr di + 6]
    mov [byte ptr si + 6], al

    mov al, [byte ptr bx + 7]
    add al, [byte ptr di + 7]
    mov [byte ptr si + 7], al

exit:
    mov ax, 4c00h
    int 21h
END start
