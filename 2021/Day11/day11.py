lines = [
    [int(digit) for digit in x]
    for x in open("2021/Day11/input.txt").read().rsplit("\n")
]


def increase_surrounding(line_no, col_no):
    # top
    if line_no != 0 and col_no != 0:
        lines[line_no - 1][col_no - 1] += 1
    if line_no != 0:
        lines[line_no - 1][col_no] += 1
    if line_no != 0 and col_no != 9:
        lines[line_no - 1][col_no + 1] += 1
    # same line
    if col_no != 0:
        lines[line_no][col_no - 1] += 1
    if col_no != 9:
        lines[line_no][col_no + 1] += 1
    # bottom
    if line_no != 9 and col_no != 0:
        lines[line_no + 1][col_no - 1] += 1
    if line_no != 9:
        lines[line_no + 1][col_no] += 1
    if line_no != 9 and col_no != 9:
        lines[line_no + 1][col_no + 1] += 1


def increase_items_by_one():
    for line_no in range(len(lines)):
        for col_no in range(len(lines[0])):
            lines[line_no][col_no] += 1


def flash_items(flashes, flashed):
    for _ in range(20):
        for line_no in range(len(lines)):
            for col_no in range(len(lines[0])):
                if flashed[line_no][col_no] != True and lines[line_no][col_no] > 9:
                    increase_surrounding(line_no, col_no)
                    flashes += 1
                    flashed[line_no][col_no] = True
    return [flashes, flashed]


def reset_flashed_ones():
    for line_no in range(len(lines)):
        for col_no in range(len(lines[0])):
            if lines[line_no][col_no] > 9:
                lines[line_no][col_no] = 0


def sol_1():
    flashes = 0
    for _ in range(100):
        flashed = [[False for _ in range(10)] for _ in range(10)]
        increase_items_by_one()
        [flashes, flashed] = flash_items(flashes, flashed)
        reset_flashed_ones()

    return flashes


def sol_2():
    flashes = 0
    for round in range(400):
        flashed = [[False for i in range(10)] for j in range(10)]
        increase_items_by_one()
        [flashes, flashed] = flash_items(flashes, flashed)
        reset_flashed_ones()

        if all(
            all(flashed_item for flashed_item in flashed_line)
            for flashed_line in flashed
        ):
            break
    return round + 1


print("Solution 1: " + str(sol_1()))
print("Solution 1: " + str(sol_2()))
