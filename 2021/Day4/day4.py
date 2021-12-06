def wins(board, calls):
    for i in range(5):
        if all(board[i][j] in calls for j in range(5)):
            return True
        if all(board[j][i] in calls for j in range(5)):
            return True
    return False


def solve(inp):
    sequence, *boards = inp.split("\n\n")

    sequence = [int(x) for x in sequence.split(",")]
    boards = [
        [[int(el) for el in ln.split()] for ln in board.strip().split("\n")]
        for board in boards
    ]

    win_board = None
    win_calls = None
    won_counter = 0

    for i in range(1, len(sequence)):
        calls = set(sequence[:i])

        for board in boards:
            if wins(board, calls):
                won_counter += 1
                win_board = board
                win_calls = sequence[:i]
                if won_counter > 99:
                    break
        else:
            continue
        break

    unmarked = 0
    for i in range(5):
        for j in range(5):
            if win_board[i][j] not in win_calls:
                unmarked += win_board[i][j]

    print(unmarked)
    print(win_calls[-1])
    return unmarked * win_calls[-1]


print(solve(open("2021/Day4/input.txt").read()))
