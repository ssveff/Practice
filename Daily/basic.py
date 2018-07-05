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

# 02-17-2018


class Course(models.Model):
    name = models.CharField(max_length=200)
    number = models.CharField(max_length=200)
    lname =


# 02-24-2018
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

# urls.py
from django.conf.urls import url
from django.contrib import admin
from calculator import views

urlpatterns = [
    url(r'^admin/', admin.site.urls),
    url(r'^$', views.calculator),
]

# models.py
from django.db import models

# views.py
from django.shortcuts import render


def calculator(request):
    context = {'newVal': 0, 'preVal': 0, 'preOp': "+", 'result': 0}
    if request.method != 'POST':
        return render(request, 'calculator/index.html', context)

    newVal = int(request.POST['newVal'])
    preVal = int(request.POST['preVal'])
    preOp = request.POST['preOp']

    if 'digits' in request.POST:
        newVal = int(request.POST['digits']) + newVal * 10
        context['newVal'] = newVal
        context['preVal'] = preVal
        context['preOp'] = preOp
        context['result'] = newVal
        return render(request, 'calculator/index.html', context)


def repeat(s, exclaim):
    result = s + s + s
    if exclaim:
        result = result + '!!!'
    return result


def main():
    print repeat('Yay', false)
    print('Woo Hoo', True)


colors = ['red', 'blue', 'green']
print colors[0]
print colors[2]
print len(colors)

sqaures = [1, 4, 9, 16]
sum = 0
for num in sqaures:
    sum += num
print sum

list = ['larry', 'curly', 'moe']
if 'curly' in list:
    print 'yay'

for i in range(100):
    print i

i = 0
while i < len(a):
    print a[i]
    i = i + 3

list.append(elem)
list.insert(index, elem)
list.extend(list2)
list.index(elem)
list.remove(elem)
list.sort()
list.reverse()
list.pop(index)

list = ['larry', 'curly', 'moe']
list.append('shemp')

strs = ['ccc', 'aaaa', 'd', 'bbb']
print sorted(strs, key=len)

tuple = (1, 2, 'hi')
print len(tuple)
print tuple[2]
tuple[2] = 'bye'
tuple = (1, 2, 'bye')

dict = {}
dict['a'] = 'alpha'
dict['g'] = 'gamma'
dict['o'] = 'omega'

print dict

print dict['a']
dict['a'] = 6
'a' in dict
if 'z' in dict:
    print dict['z']
print dict.get('z')

for key in dict:
    print key
for key in dict.keys():
    print key

print dict.keys()
print dict.values()
for key in sorted(dict.keys()):
    print key, dict[key]

print dict.items()
for k, v in dict.items():
    print k, '>', v

hash = {}
hash['word'] = 'garfield'
hash['count'] = 42
s = 'I want %(count)d copies of %(word)s' % hash

from django import forms


class NameForm(forms.Form):
    your_name = forms.CharField(label='Your Name', max_length=100)


from django.shortcuts import render
from django.http import HttpRequestRedirect

from .forms import NameForm


def get_name(request):
    if request.method == 'POST':
        form = NameForm(request.POST)
        if form.is_valid():
            return HttpResponseRedirect('/thanks')

    else:
        form = NameForm()

    return render(request, 'name.html', {'form': form})


from django import forms


class ContactForm(forms.Form):
    subject = forms.CharField(max_length=100)
    message = forms.CharField(widget=forms.Textarea)
    sender = forms.EmailField()
    cc_myself = forms.BooleanField(required=false)


TITLE_CHOICES = (
    ('MR', 'Mr.'),
    ('MRS', 'Mrs'),
    ('MS', 'Ms.'),
)


class Author(models.Model):
    name = models.CharField(max_length=100)
    title = models.CharField(max_length=3, choices=TITLE_CHOICES)
    birth_date = models.DateField(blank=True, null=True)

    def __str__(self):
        return self.name


class Book(model.Models):
    name = models.CharField(max_length=100)
    authors = models.ManyToManyField(Author)


class AuthorForm(ModelForm):
    class Meta:
        model = Author
        fields = ['name', 'title', 'birth_date']


class BookForm(ModelForm):
    class Meta:
        model = Book
        fields = ['name', 'authors']


class AuthorForm(ModelForm):
    class Meta:
        model = Author
        fields = ['name', 'title', 'birth_date']
        widgets = {
            'name': Textarea(attrs={'cols': 80, 'rows': 20}),
        }


from blog.models import Post
from django.contrib.auth.models import User
# add a post from user ola
User.objects.all()
me = User.objects.get(username='ola')
Post.objects.create(author=me, title='Sample title', text='Test')
Post.objects.all()
# filter all posts from user ola
Post.objects.filter(author=me)
# filter all posts that contain the word 'title' in title field
Post.objects.filter(title__contains='title')
# get a list of all published posts
from django.utils import timezone
Post.objects.filter(published_date__lte=timezone.now())
# Post the newly added post
post = Post.objects.get(title='Sample title')
post.publish()
# Order posts by created_date field
Post.objects.order_by('created_date')
# Reverse the ordering
Post.objects.order_by('-created_date')
# Chaining QuerySet
Post.objects.filter(published_date__lte=timezone.now()
                    ).order_by('published_date')

urlpatterns=[
    url(r'^$', views.home),
    url(r'^add-item', view.add_item, name='add-item'),
    url(r'^delete-item/(?P<item_id>\d+)$', view.delete_item, name='delete-item')
]

class Item(models.Model):
    text = models.CharField(max_lenth=200)
    user = models.ForeignKey(User, default=None)
    ip_addr = models.GenericIPAddressField()

    def __str__(self):
        return 'id=' + str(self.id) + ', text="' + self.text + '"'

class RegistrationForm(forms.Form):
    first_name = forms.CharField(max_length=20)
    last_name = forms.CharField(max_length=20)
    email = forms.CharField(max_length=50, widget=forms.EmailInput())
    username = forms.CharField(max_length=20)
    password1 = forms.CharField(max_length=200, label='Password', widget=forms.PasswordInput())
    password2 = forms.CharField(max_length=200, label='Confirm Password', widget=forms.PasswordInput())

    def clean(self):
        cleaned_data = super(RegistrationForm, self).clean()

        password1 = cleaned_data['password1']
        password2 = cleaned_data['password2']
        if password1 and password2 and password1 != password2:
            raise forms.ValidationError("Password did not match")
        return cleaned_data

    def clean_username(self):
        username = self.cleaned_data.get('username')
        if User.objects.filter(username__exact=username):
            raise forms.ValidationError("username is already taken")

@login_required
def home(request):
    all_items=Item.objects.all()
    render(request, 'todolist2/index.html', {'items': all_items})

@login_required
def add_item(request):
    errors=[]
    if 'item' not in request.POST or not request.POST['item']:
        errors.append('You must enter an item to add.')
    else:
        new_item = Item(text=request.POST['item'],
                        user = request.user,
                        ip_addr=request.META['REMOTE_ADDR'])
        new_item.save()

    items = Item.objects.all()
    context = {'items': items, 'errors': errors}
    return render(request, 'todolist2/index.html', context)

@login_required
def delete_item(request, item_id):
    errors=[]
    if request.method != 'POST':
        errors.append('Deletes must use POST request')
    else:
        try:
            item_to_delete = Item.objects.filter(id=item_id)
            item_to_delete.delete()
        except ObjectDoesNotExist:
            errors.append('The item did not exist')

    items = Item.objects.all()
    context = {'items': items, 'errors': errors}
    return render(request, 'todolist2/index.html', context)

urlpatterns=[
    url(r'^delete-item/(?P<id>\d+)$', views.delete_item, name='delete'),
    url(r'^photo/(?P<id>\d+)$', views.get_photo, name='photo')
]

class Item(models.Model):
    text = models.CharField(max_length=200)
    picture=models.FileField(blank=True)
    content_type=models.CharField(max_length=50)

    def __unicode__(self):

class ItemForm(forms.ModelForm):
    class Meta:
        model = Item
        fields = ('picture', 'text')

    def clean_picture(self):
        picture = self.cleaned_date['picture']
        if not picture:
            raise forms.ValidationError('You must upload a picture')
        if not picture.content_type or not picture.content_type.startwith('image'):
            raise forms.ValidationError('File type is not image')
        if picture.size > MAX_UPLOAD_SIZE:
            raise forms.ValidationError('File too big (max size is {0} bytes)'.format(MAX_UPLOAD_SIZE))
        return picture

def home(request):
    context = {}
    context['items'] = Item.objects.all()
    context['form'] = ItemForm()
    render(request, 'picture_list/index.html', context)

def add_item(request):
    context={}
    new_item = Item(ip_addr=request.META['REMOTE_ADDR'])
    form = ItemForm(request.POST, request.Files, instance=new_item)
    if not form.is_valid():
        context['form'] = form
    else:
        new_item.content_type=form.cleaned_data['picture'].content_type
        form.save()
        context['message'] = 'Item #{0} saved.'.format(new_item.id)
        context['form'] = ItemForm()
    context['items'] = Item.Objects.all()
    return render(request, 'picture_list/index.html', context)

def delete_item(request, id):
    item = get_object_or_404(Item, id=id)
    context = {}

    if request.method != 'POST':
        context['messages'] = 'Deletes must be done using post method'
    else:
        item = Item.objects.filter(id=id)
        item.picture.delete()
        item.delete()
        context['message'] = 'Item deleted'
    context['items'] = Item.objects.all()
    context['form'] = ItemForm()
    return (request, 'picture_list/index.html', context)

def get_photo(request, id):
    item = get_object_or_404(Item, id=id)

    if not item.picture:
        raise Http404
    return HttpResponse(item.picture, content_type=item.content_type)

from django import forms
class UploadFileForm(forms.Form):
    title = forms.CharField(max_length=50)
    file = forms.FileField()

def upload_file(request):
    if request.method == 'POST':
        form = UploadFileForm(request.POST, request.FILES)
        if form.is_valid():
            handle_uploaded_file(request.FILES['file'])
            return HttpResponseRedirect('/sucess/url/')
    else:
        form = UploadFileForm()
    return render(request, 'upload.html', {'form': form})

def handle_uploaded_file(f):
    with open('some/file/name.txt', 'wb+') as destination:
        for chunk in f.chunks():
            destination.write(chunk)

def upload_file(request):
    if request.method == 'POST':
        form = ModelFormWithFileField(request.POST, request.FILES)
        if form.is_valid():
            # file is saved
            form.save()
            return HttpResponseRedirect('/sucess/url/')
    else:
        form = ModelFormWithFileField()
    return render(request, 'upload.html', {'form': form})

squares = [1, 4, 9, 16]
sum = 0
for num in squares:
    sum += num
print sum

list = ['larry', 'curly', 'moe']
if 'curly' in list:
    print 'yay'

s = 'hello world'
for ch in s:
    print ch
for i in range(100):
    print i

i = 0
while i < len(a):
    print a[i]
    i = i + 3

list = ['larry', 'curly', 'moe']
list.append('shemp')
list.insert(0, 'xxx')
list.extend(['yyy', 'zzz'])
print list
print list.index('curly')

list.remove('curly')
list.pop(1)
print list

list = []
list.append('a')
list.append('b')

dict = {}
dict['a'] = 'alpha'
dict['g'] = 'gamma'
dict['o'] = 'omega'

print dict
print dict['a']
dict['a'] = 6
'a' in dict
if 'z' in dict:
    print dict['z']
print dict.get('z')

for key in dict:
    print key
for key in dict.keys():
    print key

print dict.keys()
print dict.values()
for key in sorted(dict.keys()):
    print key, dict[key]
print dict.items
for k, v in dict.items():
    print k, '>', v

hash = {}
hash['word'] = 'garfield'
hash['count'] = 42
s = 'I want %(count)d copies of %(word)s' % hash

class ArticalForm(ModelForm):
    class Meta:
        model = Artical
        fields = ['pub_date', 'headline', 'content', 'reporter']

form = ArticalForm()
article = Article.objects.get(pk=1)
form = ActionForm(instance = article)

user = User.objects.create_user('john', '@.com', 'lpw')

user.last_name = 'Lennon'
user.save()
u = User.objects.get(username='john')
u.set_password('new pw')
u.save()
user = authenticate(username='john', pw='secret')

urlpatterns = [
    url(r'^article/2003/$', views.special_case_2003),
    url(r'^article/([0-9]{4})/$', views.year_archive),
    url(r'^article/([0-9]{4}/([0-9]{2})/$', views.month_archieve),
    url(r'^article.([0-9]{4})/([0-9]{3})/([0-9]+)/$', views.article_detail),
]

urlpatterns = [
    url(r'^community/', include('django_website.aggregator.urls')),
]

class Manufactory(models.Model):

class Car(models.Model):
    manufactory = models.ForeignKey(Manufactory, on_delete=models.CASCADE)

class Pizza(models.Model):
    toppings = models.ManyToManyField(Topping)

def upload_file(request):
    if request.method == 'POST':
        form = UploadedFileForm(request.POST, request.FILES)
        if form.is_valid():
            handle_uploaded_file(request.FILES['file'])
            return HttpResponseRedirect('/sucess/url/')
    else:
        form = UploadFileForm()
    return render(request, 'upload.html', {'form': form})

def greet(request):
    context = {}
    if 'name' in request.GET:
        context['person_name'] = request.GET['name']
    return render(request, 'intro/get.html', context)

urlpatterns= [
    url(r'^greet$', views.greet)
]

urlpatterns=[
    url(r'^$', welcome_views.home),
    url(r'^hidden/', include(hidden_urls)),
    url(r'^shared/', include(shared_urls)),
]

shared_list = []
lock = lock()

def home(request):
    with lock:
        my_copy = list(shared_list)
    context = {'items': my_copy}

def add_item(request):
    errors = []
    if not 'item' in request.POST or not request.POST['item']:
        errors.append('You must provide an item to add')
    else:
        item = request.POST['item']


urlpatterns = [
    url(r'^register$', welcome_views.register, name='register'),
    url(r'^login$', auth_views.login, {'template_name': 'welcome/login.html'}, name='login'),
    url(r'^logout$', auth_views.logout_then_login, name='logout')
]

class RegistrationForm(forms.Form):
    username = forms.CharField(max_length=20)
    email = forms.CharField(max_length=50, widget=forms.EmailInput())

    def clean(self):
        cleaned_data = super(RegistrationForm, self).clean()
        password1 = cleaned_data.get('password1')
        password2 = cleaned_data.get('password2')
        if password1 and password2 and password1 != password2:
            raise forms.ValidationError("Password did not match")
        return cleaned_data

    def clean(self):
        cleaned_data = super(RegistrationForm, self).clean()
        =cleaned_data.get('password1')
        if not match:
            raise forms.ValidationError("not match")

    def clean_username(self):
        username = self.cleaned_data.get('username')
        if User.objects.filter(username__exact=username):
            raise forms.ValidationError("Username is already taken.")
        return username

@transaction.atomic
def register(request):
    context = {}
    if request.method == 'GET':
        context['form'] = RegistrationForm()
        return render(request, 'welcome/register.html', context)

    form = RegistrationForm(request.POST)
    context['form'] = form

    #validate the form
    if not form.is_valid():
        return render(request, 'welcome/register.html', context)

    new_user = User.objects.create_user(username = form.cleaned_data['username'])

config = ConfigParser()
config.read(os.path.join(BASE_DIR, 'config.ini'))

EMAIL_HOST = config.get('Email', 'Host')
EMAIL_PORT = int(config.get('Email', 'Port'))
EMAIL_HOST_USER = config.get('Email', 'User')
EMAIL_HOST_PASSWORD = config.get('Email', 'Password')
EMAIL_USE_SSL = True

from django.contrib.auth.models import User

class Item(models.Model):
    text = models.CharField(max_length=500)
    user = models.ForeignKey(User, default=None)
    ip_addr = models.GenericIpAddressField()

    def __str__(self):
        return 'id=' + str(self.id) + ',text="' + self.text + '"'

@login_required
def home(request):
    all_items = Item.objects.all();
    return render(request, 'todolist2/index.html', {'items': all_items})

@login_required
def add_item(request):
    errors=[]

    if 'item' not in request.POST or not request.POST['item']:
        errors.append('You must enter an item to add')
    else:
        new_item = Item(text = request.POST['item'],
                        user = request.user,
                        ip_addr = request.META['REMOTE_ADDR'])
        new_item.save()

    items = Item.objects.all()
    context = {'items': items, 'errors': errors}
    return render(request, 'todolist2/index.html', context)

def delete_item(request, item_id):
    errors = []
    if request.method!= 'POST':
        errors.append('Deletes must be done using the POST method')
    else:
        try:
            item_to_delete = Item.objects.get(id=item.id)
            item_to_delete.delete()
        except ObjectDoesNotExist:
            errors.append('The item did not exist')
    items = Item.objects.all()
    context={'items': items, 'errors': errors}
    return render(request, 'todolist2/index.html', context)

class Entry(models.Model):
    last_name = models.CharField(max_length=200)
    birthday = models.DateField(blank=True, null=True)
    created_by = models.ForeignKey(User, related_name='entry_creators')
    creation_time = models.DateTimeField()

    def __unicode__(self):
        return 'Entry(id=' + str(self.id) +')'

class CreateForm(forms.Form):
    class Meta:
        model = Entry
        fields = '__all__'

class EditForm(forms.ModelForm):
    class Meta:
        model = Entry
        exclude = ['created_by', 'creation_time', 'updated_by']

        widgets = {
            'update_time': forms.HiddenInput(),
        }

@login_required
def create(request):
    if request.method == 'GET':
        context = {'form': CreateForm()}
        return render(request, 'addrbook2/create.html', context)

    entry = Entry(created_by=request.user, creation_time = timezone.now())
    create_form = CreateForm(request.POST, instance=entry)
    if not create_form.is_valid():
        context = {'form': create_form}
        return render(request, 'addrbook2/create.html', context)
    create_form.save()

    message = 'Entry Created'
    edit_form = EditForm(instance=entry)
    context = {'message': message, 'entry': entry, 'form': edit_form}
    return render(request, 'addrbook2/edit.html', context)

@login_require
def delete(request, id):
    if request.method != 'POST'
        message = "Invalid request, POST method must be used"
        return ...

    entry = get_object_or_404(Entry, id=id)
    entry.delete()
    message = 'Entry for {0}, {1} has been deleted'.format(entry.last_name, entry.first_name)

@login_required
@transaction.atomic
def edit(request, id):
    try:
        if request.method == 'GET':
            entry = Entry.objects.get(id=id)
            form = EditForm(instance=entry)
            context = {'entry': entry, 'form': form}
            return ...abs
        entry = Entry.objects.select_for_update().get(id=id)
        db_update_time = entry.update_time
        form = EditForm(request.POST, instance=entry)
        if not form.is_valid():
            context={'...'}

        if db_update_time != form.cleaned_data['update_time']
            entry = Entry.objects.get(id=id)
            form = EditForm(instance=entry)
        entry.ObjectDoesNotExist

urlpatterns=[
    url(r'^photo/(?P<id>\d+)$', views.get_photo, name='photo')
]

class Item(models.Model):
    text = models.CharField(max_lenght=200)
    picture = models.FileField(blank=True)
    content_type = models.CharField(max_lenght=50)

    def __unicode__(self):
        return ...ab

class ItemForm(forms.ModelForm):
    class Meta:
        model = Item
        fields = ['picture', 'text']

    def clean_picture(self):
        picture = self.cleaned_data['picture']
        if not picture:
            raise forms.ValidationError("need upload")
        if not picture.content_type or not picture.content_type.startswith('image'):
            ...
        if picture_size>MAX
    return picture

def add_item(request):
    context = []
    new_item = Item(ip_addr = request.META['REMOTE_ADDR'])
    form = ItemForm(request.POST, instance=new_item)
    if not form.is_valid():
        context['form'] = form
    else:
        new_item.content_type=form.cleaned_data['picture'].content_type
        form.save()
        context['message'] = 'Item {0} saved.'.format(new_item.id)
        context['form'] = ItemForm()
    context['items'] = Item.Objects.all()
    return render(request, '...', context)

def delete_item(request, id):
    context={}
    item = get_object_or_404(Item, id=id)

    if request.method != 'POST'
        context['message']= '...'
    else:
        item = Item.objects.get(id=id)
        item.picture.delete()
        item.delete()
        context['message'] = 'deleted'
    context['items'] = Item.Objects.all()
    context['form'] = ItemForm()

def get_photo(request, id):
    item = get_object_or_404(id=id)
    if not item.picture:
        raise Http404
    return Httpresponse(item.picture, content_type=item.content_type)

