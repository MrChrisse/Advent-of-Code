nums = [int(x) for x in open("2021/Day7/input.txt").read().split(",")]


def sol_1():
    results = []
    for i in range(max(nums)):
        dif = 0
        for num in nums:
            dif = abs(num - i)
        results.append(dif)
    return min(results)


def sol_2():
    results = []
    for i in range(max(nums)):
        dif = 0
        for num in nums:
            dif_norm = abs(num - i)
            dif += dif_norm * (dif_norm + 1) / 2
        results.append(dif)
    return min(results)


print("Result 1: " + sol_1())
print("Result 2: " + sol_2())
