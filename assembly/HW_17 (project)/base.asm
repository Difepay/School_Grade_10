IDEAL
MODEL small
STACK 100h

DATASEG
	;-----VARS-----:	
	gameBoard	db 4 dup (0, 'b')
				db 4 dup ('b', 0)
				db 4 dup (0, 'b')
				db 16 dup (0)
				db 4 dup ('w', 0)
				db 4 dup (0, 'w')
				db 4 dup ('w', 0)


	rowCount db 8
	colCount db 8
	checkestCount dw 24
	placesCount dw 64		; Rows * Columns
	currentMove dw 0		; 0 - white, 1 - black
	
	indexToReturn dw 0
	indexToReturnFunc dw 0

	tempMemory dw 0

	currRowFrom dw 0
	currColFrom dw 0
	currRowTo dw 0
	currColTo dw 0

	validator db 0		; flag: 0 - no errors, 1 - there is error
	canGoLinier db 0
	moveDirectionRow db 0
	moveDirectionCol db 0
	enemyChar db 0
	containsWhite db 0
	containsBlack db 0

	lettersStr db "    A   B   C   D   E   F   G   H", '$'
	topLineStr db "  +---+---+---+---+---+---+---+---+", '$'
	leftOutNumber db "| ", '$'
	freePlace db "  ", '$'

	whiteMove db "White's move", '$'
	blackMove db "Black's move", '$'

	enterRowFromString db "Enter a row of checker: ", '$'
	enterColFromString db "Enter a column of checker: ", '$'

	enterRowToString db "Enter a row to move the checker: ", '$'
	enterColToString db "Enter a column to move the checker: ", '$'

	winnerString db "WE HAVE WINNER!", '$'
	whiteWinnerString db "Congratulations WHITE checkers!", '$'
	blackWinnerString db "Congratulations BLACK checkers!", '$'

	myNumber dw 0
CODESEG
	;-----PROC-----:
	proc clearScreen
		; Save values
		push ax

		mov ax, 03h
		int 10h

		; Return values
		pop ax
		ret
	endp clearScreen

	proc newLine
		; Save the values
		push dx
		push ax

		mov dl, 0ah
      mov ah, 2h
      int 21h

		; Return the values
		pop ax
		pop dx
		ret
	endp newLine

	proc printBoardRow
		; Save the values
		push ax
		push bx
		push cx
		push dx
		push si

		; Printing top horizontal line
		lea dx, [topLineStr]
		mov ah, 09h
		int 21h
		call newLine

		mov dx, 8
		sub dx, di
		add dl, '0'
		mov ah, 02h
		int 21h

		mov dl, ' '
		mov ah, 02h
		int 21h

		mov cl, [colCount]	; Set counter value to 8 
		mov si, 0				; Current col

		; Printing board row
		printRows:
			; This block set value of bx to (array offset + columns * current row + current column)
			lea bx, [gameBoard]
			mov ax, di
			mul [colCount]
			add bx, ax
			add bx, si

			; Print separating vertical line
			lea dx, [leftOutNumber]
			mov ah, 09h
			int 21h

			mov dl, [byte ptr bx]	; Set value of dl to the current board char 
			cmp dl, 0					
			je printFreePlace		; If current place is 0
			jmp printPlace

			; Prints two spaces
			printFreePlace:
				lea dx, [freePlace]
				mov ah, 09h
				jmp finishRowPrinting

			; Prints current char and one space
			printPlace:
				mov ah, 02h
				int 21h

				mov dl, ' '
				mov ah, 02h

			finishRowPrinting:
				int 21h
		
			cmp cx, 1
			je printLastVerticalLine	; If this is the last iteration of the loop
			jmp printRowContinue

			; Prints last vertical line
			printLastVerticalLine:
				mov dl, '|'
				mov ah, 02h
				int 21h

			printRowContinue:
				inc si
		loop printRows

		; Return the values
		pop si
		pop dx
		pop cx
		pop bx
		pop ax
		ret
	endp printBoardRow

	proc printBoard
		; Save the values
		push ax
		push cx
		push dx
		push di

		lea dx, [lettersStr]
		mov ah, 09h
		int 21h

		call newLine

		mov cl, [rowCount]
		mov di, 0				; Current row
		
		printBoardRows:
			call printBoardRow
			call newLine

			inc di
		loop printBoardRows

		; Printing top line
		lea dx, [topLineStr]
		mov ah, 09h
		int 21h
		call newLine

		; Return the values
		pop di
		pop dx
		pop cx
		pop ax
		ret
	endp printBoard

	proc printMove
		pop [indexToReturn]

		mov [tempMemory], bx
		pop bx					; bx now is parameter

		; Save the values
		push ax
		push dx

		; Compare paramter with 0. 0 - whites, 1 - blacks
		cmp bx, 0
		je setWhiteMove
		jmp setBlackMove

		setWhiteMove:
			lea dx, [whiteMove]
			jmp printCurrMove
			
		setBlackMove:
			lea dx, [blackMove]
		
		printCurrMove:
			mov ah, 09h
			int 21h
		call newLine

		; Return the values
		mov bx, [tempMemory]
		pop dx
		pop ax
		push [indexToReturn]

		ret
	endp printMove

	proc getValuesFrom
		; Save the values
		push ax
		push dx

		; Ask to enter a row
		lea dx, [enterRowFromString]
		mov ah, 09h
		int 21h
		
		mov ah, 1h
   	int 21h
		sub al, '0'
		xor ah, ah
		mov [currRowFrom], ax

		call newLine

		; Ask to enter a column
		lea dx, [enterColFromString]
		mov ah, 09h
		int 21h
		
		mov ah, 1h
   	int 21h
		xor ah, ah
		mov [currColFrom], ax
		and [currColFrom], 11011111b
	
		call newLine
	
		; Return the values
		pop dx
		pop ax
		ret
	endp getValuesFrom

	proc getValuesTo
		; Save the values
		push ax
		push dx

		; Ask to enter a row
		lea dx, [enterRowToString]
		mov ah, 09h
		int 21h
		
		mov ah, 1h
   	int 21h
		sub al, '0'
		xor ah, ah
		mov [currRowTo], ax

		call newLine

		; Ask to enter a column
		lea dx, [enterColToString]
		mov ah, 09h
		int 21h
		
		mov ah, 1h
   	int 21h
		xor ah, ah
		mov [currColTo], ax
		and [currColTo], 11011111b
	
		call newLine
	
		; Return the values
		pop dx
		pop ax
		ret
	endp getValuesTo

	proc getCurrentPlace
		pop [indexToReturnFunc]

		; Save the values
		mov di, ax
		mov si, cx

		pop cx	; Column parameter
		pop ax	; Row parameter

		lea bx, [gameBoard]
		mul [colCount]
		add bx, [placesCount]
		sub bx, ax
		add bx, cx

		cmp cx, 'A'
		jae subtracA
		jmp return_values_GET

		subtracA:
			sub bx, 'A'

		; Return the values
		return_values_GET:
			mov ax, di
			mov cx, si
			push [indexToReturnFunc]
		ret
	endp getCurrentPlace

	proc checkValidPlaceFrom
		pop [indexToReturn]

		mov [tempMemory], ax
		pop ax					; Now ax contains parameter 

		; Save the values
		push bx
		push cx

		cmp ax, 0
		je save_white_char_FROM
		jmp save_black_char_FROM

		save_white_char_FROM:
			mov cl, 'W'
			jmp start_check_FROM

		save_black_char_FROM:
			mov cl, 'B'
		
		start_check_FROM:
			mov [validator], 0

		cmp [currRowFrom], 1
		jl change_validator_FROM

		cmp [currRowFrom], 8
		ja change_validator_FROM

		cmp [currColFrom], 'A'
		jl change_validator_FROM

		cmp [currColFrom], 'H'
		ja change_validator_FROM
	
		push [currRowFrom]
		push [currColFrom]
		call getCurrentPlace

		mov al, [byte ptr bx]
		and al, 11011111b

		; Compare with lower case
		cmp al, cl
		je return_values_FROM

		change_validator_FROM:
			mov [validator], 1
		
		return_values_FROM:
			mov ax, [tempMemory]
			pop cx
			pop bx
			push [indexToReturn]
		ret
	endp checkValidPlaceFrom

	proc checkValidPlaceTo
		pop [indexToReturn]

		mov [tempMemory], ax
		pop ax					; Now ax contains parameter 
		
		; Save the values
		push bx
		push cx

		cmp ax, 0
		je set_pos_direction_TO
		jmp set_neg_diretction_TO

		set_pos_direction_TO:
			mov [enemyChar], 'B'
			mov [moveDirectionRow], 1
			jmp start_check_TO

		set_neg_diretction_TO:
			mov [enemyChar], 'W'
			mov [moveDirectionRow], -1

		start_check_TO:
			cmp [currRowTo], 1
			jl change_validator_syntax_TO

		cmp [currRowTo], 8
		ja change_validator_syntax_TO

		cmp [currColTo], 'A'
		jl change_validator_syntax_TO

		cmp [currColTo], 'H'
		ja change_validator_syntax_TO

		push [currRowTo]
		push [currColTo]
		call getCurrentPlace

		mov cl, [byte ptr bx]
		cmp cl, 0
		je attack_logic

		change_validator_syntax_TO:
			mov [validator], 1
			jmp return_values_TO

		; Attack logic
		attack_logic:	
			mov ax, [currRowFrom]
			sub ax, [currRowTo]

			or ax, ax
			jns diff_row_positive
			not ax
			inc ax
			
			diff_row_positive:
				cmp ax, 2
				jne check_common_move

		attack_row_correct:
			mov ax, [currColFrom]
			sub ax, [currColTo]

			or ax, ax
			jns diff_col_positive
			not ax
			inc ax

		diff_col_positive:
			cmp ax, 2
			jne change_validator_move_TO

		mov ax, [currRowFrom]
		mov bx, [currRowTo]
		add ax, bx
		shr ax, 1
		push ax

		mov ax, [currColFrom]
		mov bx, [currColTo]
		add ax, bx
		shr ax, 1
		push ax

		call getCurrentPlace

		mov cl, [byte ptr bx]
		and cl, 11011111b
		cmp cl, [enemyChar]
		je remove_curr_char
		jne change_validator_move_TO

		remove_curr_char:
			mov [byte ptr bx], 0
			jmp return_values_TO

		change_validator_move_TO:
			mov [validator], 1
			jmp return_values_TO

		check_common_move:
			mov ax, [currRowFrom]
			add al, [moveDirectionRow]

			cmp ax, [currRowTo]
			jne change_validator_move_pac_TO

			mov ax, [currColFrom]
			mov bx, ax

			inc ax
			dec bx

			cmp ax, [currColTo]
			je return_values_TO

			cmp bx, [currColTo]
			je return_values_TO

		change_validator_move_pac_TO:
			mov [validator], 1

		; Return the values
		return_values_TO:
			mov ax, [tempMemory]
			pop cx
			pop bx
			push [indexToReturn]
		ret
	endp checkValidPlaceTo

	proc updateBoard
		; Save values
		push bx
		push cx

      push [currRowFrom]
		push [currColFrom]
		call getCurrentPlace

		mov cl, [byte ptr bx]
		mov [byte ptr bx], 0

		push [currRowTo]
		push [currColTo]
		call getCurrentPlace
	
		mov [byte ptr bx], cl

		; Return the values
		pop cx
		pop bx

		ret
	endp updateBoard

	proc checkWinner
		push ax
		push dx

		; Save the values
		mov cl, [rowCount]		; cl = 8 (row)
		mov [containsWhite], 0	; Annul containsWhite variable
		mov [containsBlack], 0	; Annul containsBlack variable

		goOverBoardRows:
			xor dx, dx		; dl = 0 
			
			goOverBoardCols:
				push cx
				push dx
				call getCurrentPlace

				mov al, [byte ptr bx]
				and al, 11011111b

				cmp al, 'W'
				je changeWhiteContains

				cmp al, 'B'
				je changeBlackContains
				jmp continueColChecking

				changeWhiteContains:
					mov [containsWhite], 1
					jmp continueColChecking

				changeBlackContains:
					mov [containsBlack], 1

				continueColChecking:
					inc dl

				cmp dl, [colCount]
				jne goOverBoardCols
		loop goOverBoardRows

		returnValuesCheck:
			pop dx
			pop ax

			mov cl, [containsWhite]
			and cl, [containsBlack]
			inc cl
		ret
	endp checkWinner

	proc printWinner
		; Save the values
		push ax
		push dx

		lea dx, [winnerString]
		mov ah, 09h
		int 21h
		call newLine

		inc [currentMove]
		and [currentMove], 1

		cmp [currentMove], 0
		je saveWhiteWinner

		lea dx, [blackWinnerString]
		jmp printWinnerString

		saveWhiteWinner:
			lea dx, [whiteWinnerString]

		printWinnerString:
			mov ah, 09h
			int 21h
		call newLine

		; Return the values
		pop dx
		pop ax
		ret
	endp printWinner

start:
	mov ax, @data
	mov ds, ax

	;-----CODE-----:
	mov cx, 1
	mov [currentMove], 1

	mainLoop:
		call clearScreen
		call printBoard

		push [currentMove]
		call printMove

		call getValuesFrom
		push [currentMove]
		call checkValidPlaceFrom

		call getValuesTo
		push [currentMove]
		call checkValidPlaceTo

		cmp [validator], 1
		je mainLoop

		call updateBoard
		call checkWinner

		; This block of code swithcing value of currentMove between 0 and 1
		inc [currentMove]
		and [currentMove], 1
	loop mainLoop

	call clearScreen
	call printBoard
	call printWinner

exit:
	mov ax, 4c00h
	int 21h
END start
