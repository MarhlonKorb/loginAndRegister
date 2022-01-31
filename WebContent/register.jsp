<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link rel="stylesheet" href="css/style.css"> 
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

</head>
<body style="background-image: linear-gradient(to bottom, #63c3ff, #4cd0e3, #7ed5bd, #b4d4a3, #e0d0a2);  background-repeat: no-repeat; background-attachment: fixed; background-size: cover; ">

<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="login.jsp">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="register.jsp">Register</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit" style="background-color: activeborder;">Search</button>
    </form>
  </div>
</nav>

	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header text-center">
						<i class='fas fa-user-plus' style='font-size:40px'></i>
						<h5>Registration Page</h5>
					</div>
					<div class="card-body">
				<form>
					
						<div class="form.group">
							<label for="exampleInputName">Enter name</label><input
							type="text" class="form-control" id="exampleInputName"
							aria-describedby="emailHelp">	
						</div>
					
						<div class="form.group">
							<label for="exampleInputEmail1">Enter email</label><input
							type="text" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp">
						</div>
						
							<div class="form.group" >
								<label for="exampleInputPassword1" >Enter password</label><input
									type="password" class="form-control" id="exampleInputPassword"
									aria-describedby="emailHelp">
							</div>
							
								<button type="submit" class="btn btn-primary btn-block badge-pill" style="margin-top: 15px;">Register</button>
						</form>
					</div>
					</div>
					</div>
				</div>
		</div>	
		
</body>
</html>