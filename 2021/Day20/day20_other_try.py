import itertools

with open("2021/Day20/input.txt") as fp:
    algorithm, rest = fp.read().split("\n\n")

algorithm = [str(".#".index(x)) for x in algorithm]
data = {
    (x, y): str(".#".index(pixel))
    for y, row in enumerate(rest.split("\n"))
    for x, pixel in enumerate(row)
}
grid = list(itertools.product((-1, 0, 1), repeat=2))
adj = lambda d: {(x + dx, y + dy) for x, y in d for dy, dx in grid}


def enhance(x, y, values, i):
    index = [values.get((x + dx, y + dy), "01"[i % 2]) for dy, dx in grid]
    return algorithm[int("".join(index), 2)]


for i in range(50):  # Replace with 50 for part 2
    data = {(x, y): enhance(x, y, data, i) for x, y in adj(data)}

print(sum(p == "1" for p in data.values()))
