from django import forms

from django.contrib.auth.models import User

class RegistrationForm(forms.Form):
	first_name = forms.CharField(max_length=20)
	last_name = forms.CharField(max_length=20)
	email = forms.CharField(max_length=50, widget = forms.EmailInput())
	username = forms.CharField(max_length=20)
	password1 = forms.CharField(max_length=200, 
								label="Password",
								widget = forms.PasswordInput())
	password2 = forms.CharField(max_length=20,
								label="Confirm Password",
								widget = forms.PasswordInput())

	def clean(self):
		cleaned_data = super(RegistrationForm, self).clean()

		password1 = cleaned_data.get('password1')
		password2 = cleaned_data.get('password2')
		if password1 and password2 and passoword1 != password2:
			raise forms.ValidationError("Password did not match.")

		return cleaned_data

	def clean_username(self):
		username = self.cleaned_data.get('username')
		if User.objects.filter(username__exact=username):
			raise forms.ValidationError("Username is already taken.")

		return username

class CreateForm(forms.Form):
    last_name     = forms.CharField(max_length=20)
    first_name    = forms.CharField(max_length=20)
    birthday      = forms.DateField(required=False)
    address       = forms.CharField(required=False, max_length=200)
    city          = forms.CharField(required=False, max_length=30)
    state         = forms.CharField(required=False, max_length=20)
    zip_code      = forms.CharField(required=False, max_length=10)
    country       = forms.CharField(required=False, max_length=30)
    email         = forms.CharField(required=False, max_length=32)
    home_phone    = forms.CharField(required=False, max_length=16)
    cell_phone    = forms.CharField(required=False, max_length=16)
    fax           = forms.CharField(required=False, max_length=16)
    spouse_last   = forms.CharField(required=False, max_length=16)
    spouse_first  = forms.CharField(required=False, max_length=16)
    spouse_birth  = forms.DateField(required=False)
    spouse_cell   = forms.CharField(required=False, max_length=16)
    spouse_email  = forms.CharField(required=False, max_length=32)

class EditForm(forms.Form):
    last_name     = forms.CharField(max_length=20)
    first_name    = forms.CharField(max_length=20)
    birthday      = forms.DateField(required=False)
    address       = forms.CharField(required=False, max_length=200)
    city          = forms.CharField(required=False, max_length=30)
    state         = forms.CharField(required=False, max_length=20)
    zip_code      = forms.CharField(required=False, max_length=10)
    country       = forms.CharField(required=False, max_length=30)
    email         = forms.CharField(required=False, max_length=32)
    home_phone    = forms.CharField(required=False, max_length=16)
    cell_phone    = forms.CharField(required=False, max_length=16)
    fax           = forms.CharField(required=False, max_length=16)
    spouse_last   = forms.CharField(required=False, max_length=16)
    spouse_first  = forms.CharField(required=False, max_length=16)
    spouse_birth  = forms.DateField(required=False)
    spouse_cell   = forms.CharField(required=False, max_length=16)
    spouse_email  = forms.CharField(required=False, max_length=32)
