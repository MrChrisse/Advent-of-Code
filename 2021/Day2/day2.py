import re

lines = [x for x in open("2021/Day2/input_2.txt").read().rsplit("\n")]


def sol_1():
    hor_pos = 0
    depth = 0
    for line in lines:
        if line.startswith("forward"):
            hor_pos += int(re.findall(r"\d+", line)[0])
        elif line.startswith("down"):
            depth += int(re.findall(r"\d+", line)[0])
        elif line.startswith("up"):
            depth -= int(re.findall(r"\d+", line)[0])
    result_1 = hor_pos * depth
    print(result_1)


def sol_2():
    hor_pos = 0
    depth = 0
    aim = 0
    for line in lines:
        if line.startswith("forward"):
            num_value = int(re.findall(r"\d+", line)[0])
            hor_pos += num_value
            depth += aim * num_value
        elif line.startswith("down"):
            aim += int(re.findall(r"\d+", line)[0])
        elif line.startswith("up"):
            aim -= int(re.findall(r"\d+", line)[0])
    print(hor_pos, depth)
    result_2 = hor_pos * depth
    print(result_2)


sol_1()
sol_2()
