from collections import defaultdict


lines = [x for x in open("2021/Day5/input.txt").read().rsplit("\n")]


def sol_1():
    arr = [[0 for i in range(1000)] for j in range(1000)]

    for line in lines:
        start, end = line.split("->")
        x1, y1 = start.split(",")
        x2, y2 = end.split(",")
        x1 = int(x1.strip())
        y1 = int(y1.strip())
        x2 = int(x2.strip())
        y2 = int(y2.strip())
        print(x1, y1, x2, y2)
        if x1 == x2:
            while y1 != y2:
                arr[x1][y1] += 1
                if y1 < y2:
                    y1 += 1
                else:
                    y1 -= 1
        elif y1 == y2:
            while x1 != x2:
                arr[x1][y1] += 1
                if x1 < x2:
                    x1 += 1
                else:
                    x1 -= 1

    result_1 = 0
    for i in range(999):
        for j in range(999):
            if arr[i][j] > 1:
                result_1 += 1
    return result_1

    G1 = defaultdict(int)
    G2 = defaultdict(int)
    for line in lines:
        start, end = line.split("->")
        x1, y1 = start.split(",")
        x2, y2 = end.split(",")
        x1 = int(x1.strip())
        y1 = int(y1.strip())
        x2 = int(x2.strip())
        y2 = int(y2.strip())

        dx = x2 - x1
        dy = y2 - y1

        for i in range(1 + max(abs(dx), abs(dy))):
            x = x1 + (1 if dx > 0 else (-1 if dx < 0 else 0)) * i
            y = y1 + (1 if dy > 0 else (-1 if dy < 0 else 0)) * i
            if dx == 0 or dy == 0:
                G1[(x, y)] += 1
            G2[(x, y)] += 1

    return len([k for k in G1 if G1[k] > 1])


print(sol_1())
