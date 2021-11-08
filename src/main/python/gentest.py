import random
import math

for i in {1, 10, 10000}:
    f1 = open("/Users/pajehyk/Documents/projects/java2021/src/test/resources/input" + str(i) + ".txt", "w")
    f2 = open("/Users/pajehyk/Documents/projects/java2021/src/test/resources/expectedOutput" + str(i) + ".txt", "w")
    for j in range(i):
        a = random.uniform(-1, 1)
        print(a, file=f1)
        print(math.tan(a), file=f2)