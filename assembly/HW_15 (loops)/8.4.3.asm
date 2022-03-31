IDEAL
MODEL small
STACK 100h
DATASEG
    ;-----VARS-----:
    arrWord db 5 dup(0)
CODESEG
start:
    mov ax, @data
    mov ds, ax
   
    ;-----CODE-----:
    xor cx, cx
    xor ax, ax
   
    mov cl, 5           ; Iterations count
    lea bx, [arrWord]   ; First index to change
 
    ; If count of iterations equals to zero - exit program
    cmp cl, 0
    je exit
 
    getChar:
        ; Wait for entering char
        mov ah, 1h
        int 21h
        mov [byte ptr bx], al           ; Save char to current array item
 
        ; Adding 1 to the index
        inc bx
        loop getChar
 
exit:
    mov ax, 4c00h
    int 21h
END start
