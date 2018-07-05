from django.conf.urls import url
from app1 import views

urlpatterns = [
	url(r'^$', views.get_name),
	url(r'^name$', views.get_name),
	url(r'^thanks$', views.get_name),
]