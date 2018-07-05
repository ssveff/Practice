var user = new userObject("mjs", "sylvia");
function userObject(userid, password) {...}

this.userid = userid;
this.salt = computeSalt;

function getList() {
	var req = new XMLHttpRequest();
	req.onreadystatechange = function(){
		if (req.readyState != 4) return;
		if (req.status != 200) return;
		var items = JSON.parse(req.responseText);
		updateList(items);
	}
	req.open("GET", "/ajax-todolist/get-list-json", true);
	req.send();
}

function updateList(items){
	var list = document.getElementsByID("todo-list");
	while(list.hasChildNodes()){
		list.removeChild(list.firstChild);
	}
}

var myNode = document.getElementsByID("myID");
var myJQObj = $(myNode);

var myJQObj = $("#myId");

//2018-03-15
var names = ['Alice', 'Emily', 'Kate'];


//<div id="app"></div>

function Person(props) {
	return(
		<div className="person">
			<h1>{props.name}</h1>
			<p>Your Age:{props.age}</p>
		</div>
	);
}

// var app = (
// 	<div>
// 		<Person name="Max" age="28" />
// 		<Person name="Aoran age="24" />
// 	</div>
// );

ReactDom.render(app, document.querySelect('#app'));

<!DOCTYPE html>
<html>
<body>
<script>
var person = {
	firstName: "john",
	lastName: "Doe",
	age: 50,
	eyeColor: "blue"
};
document.getElementById("demo").innerHTML = person.firstName + " is " + person.age + " years old.";
</script>
</body>
</html>

///03-23
import React, { Component } from 'React';
import classes from './App.css';
import Person from './Person/Person';
import ErrorBoundary from './ErrorBoudary/ErrorBoundary';

class App extends Component{
	state = {
		persons: [
			{id: 'asfa1', name: 'Max', age: 28}
			{id: 'lkjdf', name: 'Manu', age: 29}
		],
		otherState: 'some other value',
		showPersons: false
	}

	switchNameHandler = (newName) => {
		this.setState({
			persons: [
			{name: newName, age: 28},
			{name: 'Manu', age: 29}
			]
		})
	}

	nameChangedHandler = (event, id) => {
		const personIndex = this.state.persons.findIndex(p => {
			return p.id === id;
		})

		const person = {
			...this.state.persons[personIndex]
		}

		person.name = event.target.value;

		const persons = [...this.state.persons];
		persons[personIndex] = person;

		this.setState({persons: persons});
	}

	deletePersonHandler = (personIndex) => {
		const doesShow = this.state.showPersons;
		this.doesShow({showPerson: !doesShow});
	}

	render(){
		let persons = null;
		let btnClass = '';

		if (this.state.showPerson) {
			persons = (
				<div>
					{this.state.persons.map((person, index) => {
						return <ErrorBoundary key = {person.id}><Person
							click = {() => this.deletePersonHanderler(index)}
							name = {person.name}
							age = {person.age}
							changed = {(event) => this.nameChangedHandler(event, person.id)}
					})}
				</div>
			)

			btnClass = classes.Red;
		}

		const assignedClassess = [];
		if(this.state.persons.length <= 2) {
			assignedClassess.push(clases.red);
		}
		if(this.state.persons.length <= 1) {
			assignedClassess.push(classes.bold);
		}

		return (
			<div className = {classes.App}>
				<h1> Hi, I'm a React App</h1>
				<p className = {assignedClassess.join(' ')}>This is really working.</p>
				<button
					className = {btnClass}
					onClick = {this.togglePersonsHandler}>Toggle Persons</button>
					{persons}
			</div>
		);
	}
}
export default App;

import React from 'react';
import classes from './Person.css';
const person = (props) => {
	return (
		<div className = {classes.Person}>
			<p> onClick = {props.click}>I'm a {props.name}</p>
			<p>{props.childern}</p>
			<input type="text" onChange={props.changed} value = {props.name}
		</div>)
};
export default person;

//03-26
export const ADD_TODO = "ADD_TODO"
export const TOGGLE_TODO = 'TOGGLE_TODO'
export const SET_VISIBILITY_FILTER = 'SET_VISIBILITY_FILTER'

export const VisibilityFilters = {
	SHOW_ALL: 'SHOW_ALL',
	SHOW_COMPLETED: 'SHOW_COMPLETED',
	SHOW_ACTIVE: 'SHOW_ACTIVE'
}

export function addTodo(text) {
	return { type: ADD_TODO, text}
}

export function toggleTodo(index) {
	return { type: TOGGLE_TODO, index }
}

export function setVisibilityFilter(filter) {
	return { type: SET_VISIBILITY_FILTER, filter }
}

import { combineReducers } from "redux"
import {
	ADD_TODO,
	TOGGLE_TODO,
	SET_VISIBILITY_FILTER,
	VisibilityFilters
} from './actions'
const { SHOW_ALL } = VisibilityFilters

function visibilityFilter(state = SHOW_ALL, action){
	switch (action.type) {
		case SET_VISIBILITY_FILTER:
			return action.filter
		default:
			return state
	}
}

function todos(state=[], action){
	switch(action.type) {
		case ADD_TODO:
			return [
				...state,
				{
					text: action.text,
					completed: false
				}
			]
		case TOGGLE_TODO:
			return state.map((todo, index) => {
				if(index == action.index) {
					return Object.assign({}, todo, {
						completed: !todo.completed
					})
				}
				return todo
			})
			default:
				return state
	}
}

const todoApp = combineReducers({
	visibilityFilter,
	todos
})

export default todoApp

console.log(sotre.getState())
const unsubscribe = store.subscribe(() =>
	console.log(store.getState())
)

sotre.dispatch(addTodo('Learn about actions'))
store.dispatch(toggleTodo(0))
store.dispatch(setVisibilityFilter(VisibilityFilters.SHOW_COMPLETED))
unsubscribe()

import { create Store } from 'redux'
import todoApp from './reducers'

let store = createStore(todoApp)

function first() {
	setTimeout( function(){
		console.log(1);
	}, 500);
}

function second() {
	console.log(2);
}

first();
second();

import React from 'react';
import axios from 'axios';

export default class PersonList extends React.Component{
	state={
		persons: []
	}

	componentDidMount(){
		axios.get('https:typiccode.com/users')
			.then(res=>{
				const persons = res.data;
				this.setState({persons});
			})
	}
}

render() {
	return (
		<ul>
			{this.state.persons.map(person => <li>{person.name}</li>)}
		</ul>
	)
}

export default class PersonList extends React.Component {
	state = {
		name: '',
	}

	handleChange = event => {
		this.setState({ name: event.target.value });
	}

	handleSubmit = event => {
		event.preventDefault();
		const user = {
			name: this.state.name
		};

		axios.post(`https://jsonplaceholder.com/users`, { user })
			.then( res => {
				console.log(res);
				console.log(res.data);
			})
	}

	render() {
		return (
			<div>
				<form onSubmit={this.handleSubmit}>
					<label>
						Person Name:
						<input type="text" name="name" onChange={this.handleChange} />
					</label>
					<button type="submit">Add</button>
				</form>
			</div>
		)
	}
}

//03-28

import React from 'react'
import PropTypes from 'prop-types'

const Todo = ({ onClick, completed, text }) => {
	<li
		onClick={onClick}
		style={ {
			textDecoration: completed ? 'line-through' : 'none'
		}}
	>
		{text}
	</li>
}

Todo.propTypes = {
	onClick: PropTypes.func.isRequired,
	completed: PropTypes.bool.isRequired,
	text: PropTypes.string.isRequired
}

export default Todo
const TodoList = ({ todos, onTodoClick }) => (
	<ul>
		{todos.map((todo, index ) => (
			<Todo key={index} {...todo} onClick={ ()=> onTodoClick(index)} />

		))}
	</ul>
)

TodoList.propTypes = {
	todos: PropTypes.arrayOf(
		PropTypes.shape({
			id: PropTypes.number.isRequired,
			completed: PropTypes.bool.isRequired,
			text: PropTypes.string.isRequired
		})).isRequired
}

const Link = ({active, children, onClick }) => {
	if (active) {
		return <span>{children}</span>
	}

	return (
		<a
			href = ""
			onClick={e => {
				e.preventDefault()
				onClick()
			}}
		>
			{children}
		</a>
	)

}

const getVisibleTodos = (todos, filter) => {
	switch (filter) :
		case 'SHOW_COMPLETED':
			return todos.filter(t => t.completed)
		case 'SHOW_ACTIVE':
			return todos.filter(t => !t.completed)
		case 'SHOW_ALL':
		default:
			return todos
}

const mapStateToProps = state => {
	return {
		todos: getVisibleTodos(state.todos, state.visibilityFilter)
	}
}

const mapDispatchToProps = dispatch => {
	return (
		onTodoClick: id=> {
			dispatch(toggleTodo(id))
		}
	)
}

const VisibleTodoList = connect (mapStateToProps, mapDispatchToProps)(TodoList)

export default VisibleTodoList

import React from 'react'
import { connect } from 'react-redux'
import { addTodo } from '../actions'

let AddTodo = ({dispatch}) => {
	let input 

	return (
		<div>
			<form
				onSubmit={e => {
					e.preventDefault()
					if(!input.value.trim()){
						return
					}
					dispatch(addTodo(input.value))
					input.value = ''
				}}
			>
				<input
					ref={node => {
						input = node
					}}
				/>
				<button type="submit">
					Add Todo
				</button>
			</form>
		</div>
	)	
}
AddTodo = connect()(AddTodo)
export default AddTodo

//03-29
@Component ({
	selector: 'app-users',
	template: `
		<p>I'm in the UsersComponent</p>
		<button (click)="showInfo = true">Show Info</button>
		<p *ngIf="showInfo">Some extra user information!</p>
		<p [ngStyle]="{'background-color': color}">This is green!</p>
	`
})
export class UsersComponent{
	showInfo = false;
	color = 'green';
	users = ['Max', 'Anna', 'Chris'];
}

//04-08
function visibilityFilter(state='SHOW_ALL', action){
	if(action.type == 'SET_VISIBILITY_FILTER'){
		return action.filter
	}
	else{
		return state
	}
}

function todos(state=[], action){
	switch(action.type){
		case 'ADD_TODO':
			return state.concat([{text: action.text, completed: false}])
		case 'TOGGLE_TODO':
			return state.map(
				(todo, index) =>
					action.index == index
					 ? { text: todo.text, completed: !todo.compelted}
					 : todo
			)
		defatul:
			return state
	}
}

function todoApp(state = {}, action){
	return {
		todos: todos(state.todos, action),
		visibilityFilter: visibilityFilter(state.visibilityFilter, action)
	}
}

console.log(store.getState())

{
	visibilityFilter: 'SHOW_ALL',
	todos: [
		{
			text: 'Consider using Redux',
			completed: true,
		},
		{
			text: 'Keep all state in a single tree',
			completed: true,
		}
	]
}

store.dispatch({
	type: 'COMPLETED_TODO',
	index: 1
})

store.dispatch({
	type: 'SET_VISIBILITY_FILTER',
	filter: 'SHOW_COMPLETED'
})

function visibilityFilter(state="SHOW_ALL", action){
	switch (action.type) {
		case 'SET_VISIBILITY_FILTER':
			return action.filter
		defatul:
			return state
	}
}

function todos(state=[], action){
	switch(action.type){
		case 'ADD_TODO':
			return [
				...state,
				{
					text: action.text,
					compelted: false
				}
			]
		case 'COMPLETED_TODO':
			return state.map((todo, index)) => {
				if(index == action.index) {
					return Object.assign({}, todo, {
						completed: true
					})
				}
				return todo
			}
		default:
			return state
	}
}

import { combineReducers, createStore}
const reducer = combineReducers ({visibilityFilter, todos })
const store = createStore(reducer)

state.posts {
	currentPostId: "",
	isFetching: false,
	allPosts: {}
}

const Posts = ({posts}) => {
	<div>
		{}
	</div>
}

const Posts = ({isFetching, allPosts}) => (
	
)

connect(state=>state.posts)(Posts)

connect(state => state.posts, dispatch=> bindActionCreators({fetchPosts, deltedPost}, dispatch)(Posts))
const Post = ({isFetching, allPosts, fetchPosts, deletedPost}) => (
	<div>
		<button onClick={() => fetchPosts()} /> Fetch posts</button>
	</div>
)

var user = new userObject('mjs', 'sylvia')
function userObject(userid, password){

}

this.userid = user.id;
this.salt = computeSalt;

myObj = {'name':'John', 'age':31, 'city': 'New York'};
myJSON = myObj.stringify(myObj);
localStorage.setItem('testJSON', myJSON);

text = localStorage.getItem('testJSON');
obj = JSON.parse(text);
document.getElementsByID('demo').innerHTML = obj.name;

$.ajax({
	url: '/shared/get-list-json',
	type: 'GET',
	dataType: 'json',
	sucess: function(jsons) {...}
	error: function(xhr, status, err) {...}
});

$("div").height(100);
$(document).ready();






















