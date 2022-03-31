IDEAL
MODEL small
STACK 100h
DATASEG
    ;-----VARS-----:
    rows db 0
    cols db 0
    address dw 003Ch
 
CODESEG
start:
    mov ax, @data
    mov ds, ax
   
    ;-----CODE-----:
    xor cx, cx
    xor ax, ax
    xor bx, bx
 
    ; Wait for enter count of rows
    mov ah, 1h
    int 21h
    sub al, '0'
    mov [rows], al      ; Save value to the variable rows
 
    ; New line
    mov dl, 0ah
    mov ah, 2h
    int 21h
 
    ; Wait for enter count of cols
    mov ah, 1h
    int 21h
    sub al, '0'
    mov [cols], al      ; Save value to the variable cols
 
 
    ; Getting count of all chars to print
    mov al, [rows]
    mul [cols]
    mov cx, ax          ; Iterations count  
 
    ; If count of iterations equals to zero - exit program
    cmp cx, 0
    je exit
 
    printSquare:
        ; Copy current cx to ax and div it by [cols]
        mov ax, cx
        div [cols]
 
        ; If current ax is divide to [cols] without remainder - jump to newLine label
        cmp ah, 0
        je newLine
 
        ; Print 'x'
        mov dl, 'x'
        mov ah, 2h
        int 21h
 
        loop printSquare
 
    ; Program end
    jmp exit
 
    ; Label that print new line and then jump to 56 line
    newLine:
        mov dl, 0ah
        mov ah, 2h
        int 21h
        jmp [address]
 
exit:
    mov ax, 4c00h
    int 21h
END start
