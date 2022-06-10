IDEAL
MODEL small
STACK 100h

DATASEG
	; Variables
	board db 0, 0, 0
			db 0, 0, 0
			db 0, 0, 0

	places dw 9						; All places amount
	side dw 3						; Each board side length
	index_to_return dw 0			; If function have parameter

	move db 1						; Current move: 1 - 'X', 2 - 'O'

	move_row db 0					; Row to do move
	move_col db 0					; Columb to do move
	winner_flag db 0				; Flag of win: 0 - no win, 1 - someone win

	empty_char db '_'				; Char to print empty space between bordeds
	vertical_line db '|'			; Char to print vertical line to separate chars 
	
	welcome_msg db 09h, 09h, 'Welcome to the tic-tac-toe game by Artem!', 0ah, 0ah, '$'
	rules_str db 'Player [1] - X', 0ah, 'Player [2] - O', 0ah, 0ah, '$'

	player_1_move_str db 0ah, 'Player [1] move (X)', 0ah, '$'
	player_2_move_str db 0ah, 'Player [2] move (O)', 0ah, '$'

	enter_row_str db 'Enter row: ', '$'
	enter_col_str db 'Enter column: ', '$'

	winner_str db 0ah, 'Winner - ', '$'
	draw_str db 0ah, 'Draw!', '$'

CODESEG
	; Procedures
	proc cls
		; Save used values
		push ax

		; Clear screen
		mov ax, 03h
		int 10h

		; Return used values
		pop ax
		ret
	endp cls

	proc new_line
		; Save used values
		push ax
		push dx

		; Print new line
		mov dl, 0ah
      mov ah, 02h
      int 21h

		; Return used values
		pop dx
		pop ax
		ret
	endp new_line

	proc print_msg
		; Save used values
		push ax
		push dx

		; This block of code prints welcome message
		lea dx, [welcome_msg]
		mov ah, 09h
		int 21h

		; This block of code prints game rules
		lea dx, [rules_str]
		mov ah, 09h
		int 21h

		; Return used values
		pop dx
		pop ax
		ret
	endp print_msg

	proc print_board
		; Save used values
		push ax
		push bx
		push cx
		push dx
		push si

		lea bx, [board]		; [bx] pointer to the [board]
		mov cx, [places]		; Loop iterations = 9
		mov si, 0				; [si] = printing column
		print_places:
			; Prints vertical line
			mov dl, [vertical_line]
			mov ah, 02h
			int 21h

			mov al, [byte ptr bx]		; Save to [al] char of place from the board
			cmp al, 0
			je set_empty_char				; If [al] is empty - jump to set_empty_char

			; Else - save to [dl] char of place from the board (not empty)
			mov dl, al
			jmp print_curr_char

			set_empty_char:
				mov dl, [empty_char]

			; Print [dl]
			print_curr_char:
				mov ah, 02h
				int 21h

			inc si		; Next column

			cmp si, [side]					
			jne continue_bord_print		; If column not equals to 3

			; If column is 3 (last)
			mov dl, [vertical_line]
			mov ah, 02h
			int 21h

			call new_line
			xor si, si

			continue_bord_print:
				inc bx
		loop print_places

		; Return used values
		pop si
		pop dx
		pop cx
		pop bx
		pop ax
		ret
	endp print_board

	proc print_move
		push ax
		push dx

		cmp [move], 1
		je player_1_move		; If current move - 'X'

		; Else (current move - 'O')
		lea dx, [player_2_move_str]			; Save to dx pointer to the string 'Player [2] move (O)'
		jmp print_player_move					; Print this string

		player_1_move:
			lea dx, [player_1_move_str]		; Save to dx pointer to the string 'Player [1] move (X)'
		
		print_player_move:
			; Print [dx] string
			mov ah, 09h
			int 21h

		; Return used values
		pop dx
		pop ax
		ret
	endp print_move

	proc enter_row_col
		; Save used values
		push ax
		push dx

		; Ask to enter a row
		lea dx, [enter_row_str]
		mov ah, 09h
		int 21h

		; Waiting for enter char
		mov ah, 01h
		int 21h
		sub al, '0'					; Convert row char to the number
		mov [move_row], al		; Save it to the [move_row] variable

		call new_line				; Print new line

		; Ask to enter a column
		lea dx, [enter_col_str]
		mov ah, 09h
		int 21h

		; Waiting for enter char
		mov ah, 01h
		int 21h
		sub al, '0'					; Convert column char to the number
		mov [move_col], al		; Save it to the [move_col] variable

		; Return used values
		pop dx
		pop ax
		ret
	endp enter_row_col

	proc check_win
		; Save ip to return after procedure
		pop [index_to_return]

		; Getting procedure parameters
		pop ax							; Now [ax] contains a paramter ('X' or 'O')

		; Save used values
		push bx
		push cx
		push dx
		push si

		mov [winner_flag], 0			; Annulize [winner_flag]

		lea bx, [board]				; [bx] = pointer to the [board]
		mov cx, 3						; Column count
		mov si, 0						; Current column
		
		; Go over {0, 1, 2} indexes
		check_win_row_1:
			mov ah, [byte ptr bx + si]
			cmp al, ah
			jne check_row_2_prepare
			inc si
		loop check_win_row_1

		mov [winner_flag], 1
		jmp proc_ret


		check_row_2_prepare:
			add bx, [side]					; Shift [bx] to the the row by adding 3
			mov cx, 3						; Column count
			mov si, 0						; Current column
			
		; Go over {3, 4, 5} indexes
		check_win_row_2:
			mov ah, [byte ptr bx + si]
			cmp al, ah
			jne check_row_3_prepare
			inc si
		loop check_win_row_2

		mov [winner_flag], 1
		jmp proc_ret


		check_row_3_prepare:
			add bx, [side]					; Shift [bx] to the the row by adding 3
			mov cx, 3						; Column count
			mov si, 0						; Current column

		; Go over {6, 7, 8} indexes
		check_win_row_3:
			mov ah, [byte ptr bx + si]
			cmp al, ah
			jne check_col_1_prepare
			inc si
		loop check_win_row_3
		
		mov [winner_flag], 1
		jmp proc_ret

		check_col_1_prepare:
			lea bx, [board]				; [bx] = pointer to the [board]

			mov cx, 3						; Iteration count
			mov si, 0						; Current column

		; Go over {0, 3, 6} indexes
		check_win_col_1:
			mov ah, [byte ptr bx + si]
			cmp al, ah
			jne check_col_2_prepare
			add si, [side]
		loop check_win_col_1

		mov [winner_flag], 1
		jmp proc_ret

		check_col_2_prepare:
			inc bx							; Shift [bx] to the the column by adding 1

			mov cx, 3						; Iteration count
			mov si, 0						; Current column

		; Go over {1, 4, 7} indexes
		check_win_col_2:
			mov ah, [byte ptr bx + si]
			cmp al, ah
			jne check_col_3_prepare
			add si, [side]
		loop check_win_col_2

		mov [winner_flag], 1
		jmp proc_ret


		check_col_3_prepare:
			inc bx							; Shift [bx] to the the column by adding 1

			mov cx, 3						; Iteration count
			mov si, 0						; Current column

		check_win_col_3:
			mov ah, [byte ptr bx + si]
			cmp al, ah
			jne check_diagonale_1_prepare
			add si, [side]
		loop check_win_col_3

		mov [winner_flag], 1
		jmp proc_ret

		check_diagonale_1_prepare:
			lea bx, [board]				; [bx] = pointer to the [board]

			mov cx, 3						; Iteration count
			mov si, 0						; Current index

		; Go over {0, 4, 8}
		check_win_diagonale_1:
			mov ah, [byte ptr bx + si]
			cmp al, ah
			jne check_diagonale_2_prepare
			add si, 4
		loop check_win_diagonale_1

		mov [winner_flag], 1
		jmp proc_ret

		check_diagonale_2_prepare:
			lea bx, [board]				; [bx] = pointer to the [board]

			mov cx, 3						; Iteration count
			mov si, 2						; Current index

		; Go over {2, 4, 6}
		check_win_diagonale_2:
			mov ah, [byte ptr bx + si]
			cmp al, ah
			jne proc_ret
			add si, 2
		loop check_win_diagonale_2

		mov [winner_flag], 1
		jmp proc_ret

		; Return uned values
		proc_ret:
			pop si
			pop dx
			pop cx
			pop bx

			push [index_to_return]
			ret
	endp check_win

start:
	mov ax, @data
	mov ds, ax
	
	; Main
	mov cx, [places]

	game_loop:
		call cls					; Clear screen
		call print_msg			; Print welcome message and rules
		call print_board 		; Print game board
		call print_move		; Print current move 'X' or 'O'
		call enter_row_col	; Ask to enter row and column

		cmp [move_row], 1
		jb game_loop			; If input row less than 1

		cmp [move_row], 3
		ja game_loop			; If input row bigger than 3

		cmp [move_col], 1
		jb game_loop			; If input column less than 1

		cmp [move_col], 3
		ja game_loop			; If input column bigger than 3

		; Decrement variables - easier work with indexes
		dec [move_row]
		dec [move_col]

		; Get current index of input
		lea bx, [board]
		mov al, [move_row]
		mul [side]
		add al, [move_col]
		add bl, al

		; If this cell is already taken
		mov al, [byte ptr bx]
		cmp al, 0
		jne game_loop
		
		cmp [move], 1
		jne change_to_O			; If current move is 'O'
		
		; Else (current move is 'X')
		mov [byte ptr bx], 'X'
		jmp switch_move

		change_to_O:
			mov [byte ptr bx], 'O'

		switch_move:
			xor ah, ah
			mov al, [byte ptr bx]
			push ax						; Push 'X' or 'O' as a procedure parameter
			call check_win

			cmp [winner_flag], 1		; If procedure [check_win] changed [winner_flag] variable to 1
			je end_game					; Jump to [end_game] label

			; Swith value of move between 1 and 2
			and [move], 1
			inc [move]
	loop game_loop

	end_game:
		call cls
		call print_msg			; Print welcome message and rules
		call print_board		; After loop print last board condition

	; If game ended by win
	cmp [winner_flag], 1
	je print_winner			; Print winner

	; Else - print about draw
	lea dx, [draw_str]
	mov ah, 09h
	int 21h
	jmp exit

	print_winner:
		; Print winner string
		lea dx, [winner_str]
		mov ah, 09h
		int 21h

		; Print winner char
		mov dl, [byte ptr bx]
		mov ah, 02h
		int 21h

exit:
	mov ax, 4c00h
	int 21h
END start
