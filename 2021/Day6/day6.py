lines = [x for x in open("2021/Day6/input.txt").read().rsplit("\n")]


def sol_1(rounds):
    nums = [int(x) for x in open("2021/Day6/input.txt").read().split(",")]
    print(nums)
    for j in range(rounds):
        for i in range(len(nums)):
            if nums[i] == 0:
                nums.append(8)
                nums[i] = 6
            else:
                nums[i] = nums[i] - 1
        print(j, len(nums))
    return len(nums)


def sol_2(rounds):
    ages = [0] * 9
    for age in open("2021/Day6/input.txt").read().split(","):
        ages[int(age)] += 1

    for i in range(rounds):
        first = ages.pop(0)
        ages[6] += first
        ages.append(first)

    return sum(ages)


# print(sol_1(80))
print(sol_2(256))
