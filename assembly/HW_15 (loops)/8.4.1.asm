IDEAL
MODEL small
STACK 100h
DATASEG
    ;-----VARS-----:
    fibb db 0, 1, 8 dup(0)
CODESEG
start:
    mov ax, @data
    mov ds, ax
   
    ;-----CODE-----:
    xor cx, cx
    xor ax, ax
    xor bx, bx
   
    mov cl, 8       ; Iterations count
    mov bx, 2       ; First index to change
 
    ; If count of iterations equals to zero - exit program
    cmp cl, 0
    je exit
 
    initFibb:
        ; Getting current value
        mov al, [byte ptr bx - 1]
        add al, [byte ptr bx - 2]
        mov [byte ptr bx], al
 
        ; Adding 1 to the index
        inc bx
        loop initFibb
 
exit:
    mov ax, 4c00h
    int 21h
END start
