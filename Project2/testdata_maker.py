import random
import sys
from faker import Faker
faker = Faker(locale='en_US')

n = int(sys.argv[1]) if len(sys.argv) > 1 else 10
print(n)

for i in range(0, n):
    op = random.randint(1, 4)
    string = faker.first_name()
    length = len(string)
    print(op)
    if op == 1:
        print(string)
    elif op == 2:
        print(string)
        print(faker.last_name())
    elif op == 3:
        print(string)
        index = random.randint(0, length);
        print(index)
    elif op == 4:
        begin = random.randint(0, length)
        end = begin + random.randint(0, length - begin)
        print(string)
        print("%d %d" % (begin, end))
    else:
        # never reached
        pass
