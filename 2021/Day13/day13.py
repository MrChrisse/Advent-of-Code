# 1D String Array
lines = [x for x in open("2021/Day13/input.txt").read().rsplit("\n")]


def sol():
    divide = lines.index("")
    dots = set(tuple(map(int, line.split(","))) for line in lines[:divide])
    round = 0
    for instruction in lines[divide + 1 :]:
        axis, position = instruction.split()[2].split("=")
        position = int(position)
        update = set()
        for x, y in dots:
            if axis == "x" and x > position:
                update.add((2 * position - x, y))
            elif axis == "y" and y > position:
                update.add((x, 2 * position - y))
            else:
                update.add((x, y))
        dots = update
        if round == 0:
            round = +1

    xmin = min(x for x, y in dots)
    xmax = max(x for x, y in dots)
    ymin = min(y for x, y in dots)
    ymax = max(y for x, y in dots)
    for y in range(ymin, ymax + 1):
        print("".join("X" if (x, y) in dots else " " for x in range(xmin, xmax + 1)))
    print("Solution 2: " + str(len(dots)))


sol()
