lines = [int(x) for x in open("2021/Day1/input_1.txt")]


def sol_1():
    result_1 = 0

    for line in range(len(lines)):
        if lines[line] > lines[line - 1]:
            result_1 += 1

    print("Result 1: " + str(result_1))


def sol_2():
    result_2 = 0

    for i in range(len(lines)):
        if (
            i >= 3
            and lines[i] + lines[i - 1] + lines[i - 2]
            > lines[i - 1] + lines[i - 2] + lines[i - 3]
        ):
            result_2 += 1

    print("Result 2: " + str(result_2))


sol_1()
sol_2()
