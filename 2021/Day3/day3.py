import re

lines = [x for x in open("2021/Day3/input.txt").read().rsplit("\n")]


def most_common_bit(lines, char):
    count = 0
    for line in lines:
        if line[char] == "1":
            count += 1
    return 1 if count >= len(lines) / 2 else 0


def sol_1():
    gamma = epsilon = ""
    for c in range(12):
        gamma += str(most_common_bit(lines, c))
        epsilon += "0" if most_common_bit(lines, c) == 1 else "1"
    return int(gamma, 2) * int(epsilon, 2)


def sol_2():
    ox = lines.copy()
    co = lines.copy()
    ox_val, co_val = 0, 0

    for c in range(12):
        ox_val = str(most_common_bit(ox, c))
        co_val = "0" if most_common_bit(co, c) == 1 else "1"
        if len(ox) > 1:
            ox = [l for l in ox if l[c] == ox_val]
        if len(co) > 1:
            co = [l for l in co if l[c] == co_val]

    return int(co[0], 2) * int(ox[0], 2)


print(sol_1())
print(sol_2())
