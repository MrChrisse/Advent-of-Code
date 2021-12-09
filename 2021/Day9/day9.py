lines = [
    [int(digit) for digit in x] for x in open("2021/Day9/input.txt").read().rsplit("\n")
]


def surroundingsHigher(num, line, num_index):
    if line > 0 and lines[line - 1][num_index] <= num:
        return False
    if line < len(lines) - 1 and lines[line + 1][num_index] <= num:
        return False
    if num_index > 0 and lines[line][num_index - 1] <= num:
        return False
    if num_index < len(lines[0]) - 1 and lines[line][num_index + 1] <= num:
        return False
    return True


def sol_1():
    result_1 = 0
    for line in range(len(lines)):
        for num_index in range(len(lines[0])):
            if surroundingsHigher(lines[line][num_index], line, num_index):
                result_1 = result_1 + lines[line][num_index] + 1
                print(lines[line][num_index])

    return result_1


def sol_2():
    result_2 = 0

    return result_2


print(sol_1())
print(sol_2())
