from django.shortcuts import render
from django.http import HttpResponseRedirect

from .forms import NameForm


def get_name(request):
	context = {}

	if request.method == 'POST':
		form = NameForm(request.POST)
		if form.is_valid():
			context['your_name'] = request.POST['your_name']
			return render(request, 'app1/thanks.html', context)

	else:
		form = NameForm()

	return render(request, 'app1/name.html', {'form': form})