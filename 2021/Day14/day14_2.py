from collections import Counter
import fileinput

lines = [x for x in open("2021/Day14/input.txt").read().rsplit("\n")]


pairs = {}
polymer_str = None
for line in lines:
    if "->" in line:
        reagents, result = line.split(" -> ")
        pairs[tuple(reagents)] = result
    elif line:
        polymer_str = line

# NOTE: this does not include the last character, account for this later
polymer = Counter(zip(polymer_str, polymer_str[1:]))
for _ in range(40):
    new_polymer = Counter()
    for pair in polymer:
        # Turns out no pairs ever don't react :)
        result = pairs[pair]
        a, b = pair
        new_polymer[(a, result)] += polymer[pair]
        new_polymer[(result, b)] += polymer[pair]
    polymer = new_polymer

# There's a potential off by one, because the last element of the
# original polymer chain wasn't added. Add it here.
counts = Counter(polymer_str[-1])
for pair, count in polymer.items():
    a, b = pair
    counts[a] += count
    counts[b] += count

most = max(counts.values())
least = min(counts.values())
print((most - least) // 2)
