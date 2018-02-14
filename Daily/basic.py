def multiply(x):
    return (x * x)


def add(x):
    return (x + x)


funcs = [multiply, add]
for i in range(5):
    value = list(map(lambda x: x(i), funcs))
    print(value)

items = [1, 2, 3, 4, 5]
squared = list(map(lambda x: x**2, items))


def f(x):
    return x ** 2


print f(8)


def cube(y):
    return y * y * y


g = lambada x: x * x * x

print(g(7))
print(cube(5))
