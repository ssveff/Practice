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











































