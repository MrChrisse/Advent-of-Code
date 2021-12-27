lines = [
    [digit for digit in x]
    for x in open("2021/Day25/test_input.txt").read().rsplit("\n")
]
cur_positions = lines.copy()


def sol_1():

    for round in range(1, 1000):
        moved = False
        print("Rounds: " + str(round))
        for i in lines:
            for j in i:
                print(j, end="")
            print()
        print("Cur_Pos" + str(round))

        for i in cur_positions:
            for j in i:
                print(j, end="")
            print()

        for row in range(len(lines)):
            for col in range(len(lines[row])):
                right_element = 0 if col + 1 == len(lines[row]) else col + 1
                if lines[row][col] == ">" and lines[row][right_element] == ".":
                    cur_positions[row][right_element] = ">"
                    cur_positions[row][col] = "."
                    moved = True
        for row in range(len(lines)):
            for col in range(len(lines[row])):
                below_element = 0 if row + 1 == len(lines) else row + 1
                if lines[row][col] == "v" and lines[row][below_element] == ".":
                    cur_positions[below_element][col] = "v"
                    cur_positions[row][col] = "."
                    moved = True
        print(cur_positions == lines)
        if not moved:
            return round


def sol_2():
    result_2 = 0
    return result_2


print("Solution 1: " + str(sol_1()))
print("Solution 2: " + str(sol_2()))
