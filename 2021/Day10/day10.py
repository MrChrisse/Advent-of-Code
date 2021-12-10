lines = [x for x in open("2021/Day10/input.txt").read().rsplit("\n")]

openings = ["(", "[", "{", "<"]
closings = [")", "]", "}", ">"]
points = [3, 57, 1197, 25137]


def checkLineCorrupted(line):
    symbolStack = []
    for char in line:
        if char in openings:
            symbolStack.append(char)
        elif char in closings:
            for symIdx in range(4):
                if char == closings[symIdx] and symbolStack[-1] != openings[symIdx]:
                    symbolStack.pop()
                    return [points[symIdx], symbolStack]
            symbolStack.pop()
    return [0, symbolStack]


def sol_1():
    result_1 = 0
    for line in lines:
        result_1 += checkLineCorrupted(line)[0]
    return result_1


def sol_2():
    results = []
    for line in lines:
        line_score = 0
        [res, symbolStack] = checkLineCorrupted(line)
        if res == 0:
            symbolStack.reverse()
            for remainingsymbol in symbolStack:
                line_score = line_score * 5
                line_score += openings.index(remainingsymbol) + 1
            results.append(line_score)
    results.sort()
    return results[int((len(results) - 1) / 2)]


print(sol_1())
print(sol_2())
