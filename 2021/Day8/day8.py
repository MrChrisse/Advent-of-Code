lines = [x for x in open("2021/Day8/input.txt").read().rsplit("\n")]

cat = "".join


def sol_1():
    result_1 = 0
    for line in lines:
        outputs = line.split("|")[1].strip().split(" ")
        for output in outputs:
            if len(output) in [2, 4, 3, 7]:
                result_1 += 1
    return result_1


def sol_2():
    result_2 = 0
    for line in lines:
        d = dict()
        inputs = line.split("|")[0].strip().split(" ")
        outputs = line.split("|")[1].strip().split(" ")
        for word in sorted(inputs, key=len):
            word = set(word)
            l = len(word)
            if l == 2:
                d[1] = word
            elif l == 3:
                d[7] = word
            elif l == 4:
                d[4] = word
            elif l == 7:
                d[8] = word
            elif l == 5:
                if len(word & d[7]) == 3:
                    d[3] = word
                elif len(word & d[4]) == 3:
                    d[5] = word
                else:
                    d[2] = word
            elif l == 6:
                if len(word & d[5]) == 5:
                    if len(word & d[7]) == 2:
                        d[6] = word
                    else:
                        d[9] = word
                else:
                    d[0] = word
        digits = (str(k) for digit in outputs for k, v in d.items() if set(digit) == v)
        result_2 += int(cat(digits))
    return result_2


print(sol_1())
print(sol_2())
