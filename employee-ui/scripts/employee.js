$(function(){
getAllEmployees()
// addNewEmployee
$( "#employeeForm" ).submit(function( event ) {
	event.preventDefault()
  //create the employee object
  var employee = {
  	name : $('#fullname').val(),
  	email : $('#email').val(),
  	salary : $('#salary').val()
  }

//chec for null employee object
//and proceed only if the object is valid otherwise inform user with
//proper message
  if(employee){
  	addNewEmployee(employee)
  }else{
  	alert('enter employee details')
  }
});

$('#employeeSearchForm').submit(function(event){
	event.preventDefault()
	$.ajax({
		url:'http://localhost:8181/api/v1/employee/search',
		type:'GET',
		data : {
			salary : $('#salary').val(),
			filter : $('#filter').val()
		},
		crossOrigin: true,
		contentType : 'application/json',
		success : function(data){
			var response = data.employees;
			alert(data.message)
			if(response.status == 200){
				$('#employeeSearchForm')[0].reset()
				$("#employeeSalaryDetails").empty();
			}
			//populate the tables with records
			$.each(response, function(i, data){
     		$("#employeeSalaryDetails")
     		.append("<tr><td>" + data.id + "</td><td>" + data.name + "</td><td>"+data.email+"</td><td>"+data.salary+"<td></tr>");
})
		},
		error : function(error){
			console.log(error)
		}
	})
})
//add new employee function which post employee data to 
//server and fetches response back
	function addNewEmployee(employee){
		$.ajax({
		url:'http://localhost:8181/api/v1/employee/',
		type:'POST',
		data : JSON.stringify(employee),
		crossOrigin: true,
		contentType : 'application/json',
		success : function(data){
			console.log(data)
			alert(data.message)
			if(data.status == 200){
				$('#employeeForm')[0].reset()
				getAllEmployees()
			}
		},error:function(error){
			console.log(error)
		}
		})
	}
//on successful response the lates employee details gets populated
//in the table
	function getAllEmployees(){
			$.ajax({
		url:'http://localhost:8181/api/v1/employee/',
		type:'GET',
		crossOrigin: true,
		contentType : 'application/json',
		success : function(data){
			var response = data.employees;
			if(data.status == 200)
				$("#employeeDetails").empty();
			$.each(response, function(i, data){
     		$("#employeeDetails")
     		.append("<tr><td>" + data.id + "</td><td>" + data.name + "</td><td>"+data.email+"</td><td>"+data.salary+"<td></tr>");
})
		},
		error : function(error){
			console.log(error)
		}
	})
	}
})