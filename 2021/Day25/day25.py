lines = [
    [digit for digit in x]
    for x in open("2021/Day25/test_input.txt").read().rsplit("\n")
]


def move_east(cur_positions):
    global lines
    for row in range(len(lines)):
        for col in range(len(lines[row])):
            if lines[row][col + 1] == ".":
                cur_positions[row][col + 1] = ">"
                cur_positions[row][col] = "."
    lines = cur_positions


def sol_1():
    result_1 = 0
    for round in range(100):
        cur_positions = lines.copy()
        move_east(cur_positions)
        move_south()
    return result_1


def sol_2():
    result_2 = 0
    return result_2


print("Solution 1: " + str(sol_1()))
print("Solution 2: " + str(sol_2()))
