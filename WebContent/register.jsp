
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Registration Page</title>
</head>
<body>
	<center>
		<div id="mystyle" class="myform">
			<form id="form" name="form" method="post" action="register">
				<h1>Registration</h1>
				<p>Please enter the following information</p>

				<label>First Name <span class="small">Enter your
						first name</span>
				</label> <input type="text" name="firstName" id="firstName" /> <label>Middle
					Name <span class="small">Enter your middle name</span>
				</label> <input type="text" name="middleName" id="middleName" /> <label>Last
					Name <span class="small">Enter your last name</span>
				</label> <input type="text" name="lastName" id="lastName" /> <label>Email
					<span class="small">Ex: test@gmail.com</span>
				</label> <input type="email" name="email" id="email" /> <label>User
					ID <span class="small">Enter your user ID</span>
				</label> <input type="text" name="Id" id="Id" /> <label>Password
					<span class="small">Password min. 6 chars</span>
				</label> <input type="password" name="password" id="password" />

				<button type="submit">Register</button>
				<div class="spacer"></div>

			</form>
		</div>
	</center>
</body>
</html>