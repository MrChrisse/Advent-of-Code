targetAreaX = range(85, 146)
targetAreaY = range(-163, -107)


def throwProbe(xAmount, yAmount):
    highestYPos = 0
    curXPos = 0
    curYPos = 0
    for _ in range(800):
        curXPos = curXPos + xAmount
        curYPos = curYPos + yAmount
        if xAmount > 0:
            xAmount -= 1
        if xAmount < 0:
            xAmount += 1
        yAmount -= 1
        if curYPos > highestYPos:
            highestYPos = curYPos
        if curXPos in targetAreaX and curYPos in targetAreaY:
            return (highestYPos, True)
    return (0, False)


def sol_1():
    highestY = 0
    for x in range(12, 20):
        for y in range(80, 100):
            (newY, inTargetArea) = throwProbe(x, y)
            if newY > highestY and inTargetArea:
                highestY = newY

    return highestY


def sol_2():
    result_2 = 0
    for x in range(10, 150):
        for y in range(-170, 1000):
            (newY, inTargetArea) = throwProbe(x, y)
            if inTargetArea:
                result_2 += 1
    return result_2


print("Solution 1: " + str(sol_1()))
print("Solution 2: " + str(sol_2()))
