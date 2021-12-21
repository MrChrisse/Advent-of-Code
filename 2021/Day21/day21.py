scores = [0, 0]
cur_die = 1
board_pos = [3, 7]
rolled_die = 0


def play_round(player_no):
    global rolled_die, cur_die, board_pos
    steps = cur_die * 3 + 3
    board_pos[player_no] = (board_pos[player_no] + steps - 1) % 10 + 1
    scores[player_no] += board_pos[player_no]
    cur_die = (cur_die % 100) + 3
    rolled_die += 3


def sol_1():
    playing = True
    while playing:
        for player_no in range(2):
            if max(scores) >= 1000:
                playing = False
            play_round(player_no)
    return rolled_die * min(scores)


print("Solution 1: " + str(sol_1()))
