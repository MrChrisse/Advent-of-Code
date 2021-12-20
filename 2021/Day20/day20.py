import numpy as np

parts = [x for x in open("2021/Day20/test_input.txt").read().rsplit("\n\n")]

image_algo = parts[0]
first_image = parts[1]

first_image_arr = [[char for char in x] for x in first_image.rsplit("\n")]

padded_image = np.array(first_image_arr)
padded_image = np.pad(padded_image, 5, mode="constant")
print(padded_image)


def surroundings_to_binary(lines, line_no, col_no):
    surroundings_binary = ""
    # top
    for line_idx in range(3):
        for col_idx in range(3):
            if lines[line_no - 1 + line_idx][col_no - 1 + col_idx] == "#":
                surroundings_binary = surroundings_binary + "1"
            else:
                surroundings_binary = surroundings_binary + "0"
    return int(surroundings_binary, 2)


def sol_1():
    result_1 = 0
    working_image = padded_image.copy()
    new_working_image = padded_image.copy()
    for round in range(2):
        for line_no in range(2, len(working_image) - 4):
            for col_no in range(2, len(working_image) - 4):
                algo_num = surroundings_to_binary(working_image, line_no, col_no)
                new_working_image[line_no][col_no] = image_algo[algo_num]
        working_image = new_working_image
        print("Finished:")
        print(working_image)
    for line_no in range(len(working_image)):
        for col_no in range(len(working_image)):
            if working_image[line_no][col_no] == "#":
                result_1 += 1
    return result_1


def sol_2():
    result_2 = 0
    return result_2


print("Solution 1: " + str(sol_1()))
print("Solution 2: " + str(sol_2()))
