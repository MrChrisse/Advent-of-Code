import numpy as np

lines = [x for x in open("2021/Day22/input.txt").read().rsplit("\n")]
max = 101
area = np.full((max, max, max), 0)


def sol_1():
    for line in lines:
        items = line.split(" ")
        status = 1 if line.startswith("on") else 0

        ranges = [x[2:] for x in items[1].split(",")]

        x_start, x_end = [int(x) + 50 for x in ranges[0].split("..")]
        y_start, y_end = [int(x) + 50 for x in ranges[1].split("..")]
        z_start, z_end = [int(x) + 50 for x in ranges[2].split("..")]

        area[x_start : x_end + 1, y_start : y_end + 1, z_start : z_end + 1] = status

    return np.sum(area)


print("Solution 1: " + str(sol_1()))
