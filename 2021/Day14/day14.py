from collections import Counter
import time

# 1D String Array
lines = [x for x in open("2021/Day14/input.txt").read().rsplit("\n")]
template = lines[0]
rules = [[x for x in y.split(" -> ")] for y in lines[2:]]


def sol_1():
    cur_word = template
    for round in range(40):
        start = time.time()
        new_word = ""
        for i in range(len(cur_word)):
            for rule in rules:
                if cur_word[i : i + 2] == rule[0]:
                    new_word = new_word + cur_word[i] + rule[1]
        new_word = new_word + cur_word[-1]
        cur_word = new_word
        end = time.time()
        print("Round " + str(round) + ": " + str(end - start))

    print(len(new_word))
    data = Counter(new_word)
    return max(data.values()) - min(data.values())


def sol_2():
    result_2 = 0
    return result_2


print("Solution 1: " + str(sol_1()))
print("Solution 2: " + str(sol_2()))
