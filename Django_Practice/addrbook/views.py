from __future__ import unicode_literals

from django.shortcuts import render, redirect

from django.core.urlresolvers import reverse
from django.contrib.auth.decorators import login_required
from django.contrib.auth.models import User
from django.contrib.auth import login, authenticate
from django.utils import timezone

from addrbook.forms import RegistrationForm, CreateForm, EditForm


@login_required
def search(request):
	if not 'last' in request.GET:
		return render(request, 'addrbook/search', {})

	last = request.GET['last']

	if last == 'T':
		entry = TRUMP_ENTRY
		entry['created_by'] = request.username
		entry['creation_time'] = timezone.now()
		entry['updated_by'] = request.username
		entry['update_time'] = timezone.now()

		form = EditForm(entry)
		context = {'entry': entry, 'form': form}

		return render(request, 'addrbook/edit.html', context)

	if last == 'B':
		entries = [BUSH_41_ENTRY, BUSH_43_ENTRY]
		context = {'entries': entries}

		return render(request, 'addrbook/list.html', context)

	message = 'No entires with last name = "{0}"'.form(last)
	return render(request, 'addrbook/search.html', {'message': message})


@login_required
def create(request):
	if request.method == 'GET':
		context = {'form': CreateForm()}
		return render(request, 'addrbook/create.html', context)

	create_form = CreateForm(request.POST)
	if not create_form.is_valid():
		context = {'form': create_form}
		return render(request, 'addrbook/create.html', context)

	dummy_entry = {'id': 1}

	for field in ['last_name', 'first_name', 'birthday',
				'address', 'city', 'state', 'zip_code', 'country',
				'email', 'home_phone', 'cell_phone', 'fax',
				'spouse_last', 'spouse_first', 'spouse_birth', 'spouse_cell', 'spouse_email' ]:
				dummy_entry[filed] = create_form.cleaned_data[field]

	dummy_entry['created_by'] = request.user
	dummy_entry['creation_time'] = timezone.now()
	dummy_entry['updated_by'] = request.user
	dummy_entry['update_time'] = timezone.now()

	message = 'Entry Created'
	edit_form = EditForm(dummy_entry)
	context = {'message': message, 'entry': dummy_entry, 'form': edit_form}
	return render(request, 'addrbook/edit.html', context)

@login_required
def delete(request):
	if request.method != 'POST':
		message = 'Invalid request, POST method must be used.'
		return render(request, 'addrbook/search.html', {'message': message})

	message = 'Entry for {0}, {1} has been deleted.'.format('Last Name', 'First Name')
	return render(request, 'addrbook/search.html', {'message': message})

@login_required
def edit(request, id):

    if request.method == 'GET':

        if id == '41':
            entry = BUSH_41_ENTRY
        elif id == '43':
            entry = BUSH_43_ENTRY
        else:
            entry = None

        if entry == None:
            context = { 'message': 'Record with id={0} does not exist'.format(id) }
            return render(request, 'addrbook/search.html', context)

        # Fill in dummy time and user data
        entry['created_by']    = request.user
        entry['creation_time'] = timezone.now()
        entry['updated_by']    = request.user
        entry['update_time']  = timezone.now()

        form = EditForm(entry)
        context = { 'entry': entry, 'form': form }
        return render(request, 'addrbook/edit.html', context)


    edit_form = EditForm(request.POST)
    if not edit_form.is_valid():
        # Fill in dummy time and user data
        entry = {'id': id }
        entry['created_by']    = request.user
        entry['creation_time'] = timezone.now()
        entry['updated_by']    = request.user
        entry['update_time']  = timezone.now()

        context = { 'form': edit_form, 'entry': entry }
        return render(request, 'addrbook/edit.html', context)

    entry = { 'id': id }
    for field in [ 'last_name', 'first_name', 'birthday',
                'address', 'city', 'state', 'zip_code', 'country',
                'email', 'home_phone', 'cell_phone', 'fax',
                'spouse_last', 'spouse_first', 'spouse_birth', 'spouse_cell', 'spouse_email' ]:
        entry[field] = edit_form.cleaned_data[field]

    entry['created_by']    = request.user
    entry['creation_time'] = timezone.now()
    entry['updated_by']    = request.user
    entry['update_time']  = timezone.now()

    message = 'Entry Updated'
    context = { 'message': message, 'entry': entry, 'form': edit_form }
    return render(request, 'addrbook/edit.html', context)

def register(request):
	context = {}

	if request.method == 'GET':
		context['form'] = RegistrationForm()
		return render(request, 'addrbook/register.html', context)

	form = RegistrationForm(request.POST)
	context['form'] = form

	if not form.is_valid():
		return render(request, 'addrbook/register.html', context)

	new_user = User.objects.create_user(username=form.cleaned_data['username'], 
										password=form.cleaned_data['password1'],
										email=form.cleaned_data['email'],
										first_name=form.cleaned_data['first_name'],
										last_name=form.cleaned_data['last_name'])
	
	new_user.save()

	login(request, new_user)
	return redirect(reverse('home'))

TRUMP_ENTRY = {
    'id': 45,
    'last_name':    'Trump',
    'first_name':   'Donald',
    'address':      '1600 Pennsylvania Avenue',
    'city':         'Washington',
    'state':        'DC',
    'spouse_last':  'Trump',
    'spouse_first': 'Melania',
}

BUSH_41_ENTRY = {
    'id': 41,
    'last_name':    'Bush',
    'first_name':   'George',
    'spouse_last':  'Bush',
    'spouse_first': 'Barbara',
}

BUSH_43_ENTRY = {
    'id': 43,
    'last_name':    'Bush',
    'first_name':   'George',
    'spouse_last':  'Bush',
    'spouse_first': 'Laura',
}

