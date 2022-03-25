IDEAL
MODEL small
STACK 100h
DATASEG
	;-----VARS-----:
	TimesToPrintX db 5
CODESEG
start:
	mov ax, @data
	mov ds, ax
	
	;-----CODE-----:

	return:
		cmp [TimesToPrintX], 0
		je exit
		jne printx
	
	printx:
		mov dl, 'x'
		mov ah, 2h
		int 21h
		dec [TimesToPrintX]
		jmp return
exit:
	mov ax, 4c00h
	int 21h
END start
