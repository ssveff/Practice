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

#02-17-2018
class Course(models.Model):
	name = models.CharField(max_length=200)
	number = models.CharField(max_length=200)
	lname = 

#02-24-2018
from blog.models import blog, Entry
b = Blog(name='Beatles Blog', tagline='All the latest Beatles news.')
b.save()
b5.name = 'New name'
b5.save()

entry = Entry.objects.get(pk=1)
cheese_blog = Blog.objects.get(name="Cheddar Talk")
entry.blog = cheese_blogentry.save()
joe = Author.objects.create(name="joe")
entry.authors.add(joe)






























