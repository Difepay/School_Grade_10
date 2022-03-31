IDEAL
MODEL small
STACK 100h
DATASEG
	;-----VARS-----:
	varl dw 1000
	var2 dw 3
	result_quo dw 0
	result_rem dw 0
CODESEG
start:
	mov ax,@data
	mov ds, ax
    
	;-----CODE-----:
	xor ax, ax
	mov ax, [varl]
	div [var2]
	
	mov [result_quo], ax
	mov [result_rem], dx
exit:
	mov ax, 4c00h
	int 21h
END start
