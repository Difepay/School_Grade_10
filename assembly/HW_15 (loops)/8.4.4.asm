IDEAL
MODEL small
STACK 100h
DATASEG
    ;-----VARS-----:
    var1 db 7
    var2 db 50
    result dw 0
CODESEG
start:
    mov ax, @data
    mov ds, ax
   
    ;-----CODE-----:
    xor cx, cx
    xor ax, ax
   
    mov cl, [var2]          ; Iterations count
 
    ; If count of iterations equals to zero - exit program
    cmp cl, 0
    je exit
 
    multiplicate:
        ; Add to current result var1 value
        mov al, [var1]
        add [result], ax
 
        loop multiplicate
 
exit:
    mov ax, 4c00h
    int 21h
END start
