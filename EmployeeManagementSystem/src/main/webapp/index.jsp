<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login and Registration</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, sans-serif;
}

body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background: linear-gradient(135deg, #4facfe, #00f2fe);
}

.container {
	width: 350px;
	background: #fff;
	padding: 30px;
	border-radius: 12px;
	box-shadow: 0 10px 25px rgba(0, 0, 0, .2);
}

input[type="radio"] {
	display: none;
}

.tabs {
	display: flex;
	margin-bottom: 20px;
}

.tabs label {
	width: 50%;
	text-align: center;
	padding: 10px;
	background: #ddd;
	cursor: pointer;
	font-weight: bold;
}

#login:checked ~ .tabs .login-tab, #register:checked ~ .tabs .register-tab
	{
	background: #4facfe;
	color: #fff;
}

.form {
	display: none;
}

#login:checked ~ .login-form {
	display: block;
}

#register:checked ~ .register-form {
	display: block;
}

input {
	width: 100%;
	padding: 12px;
	margin: 10px 0;
	border: 1px solid #ccc;
	border-radius: 6px;
}

button {
	width: 100%;
	padding: 12px;
	background: #4facfe;
	color: #fff;
	border: none;
	border-radius: 6px;
	cursor: pointer;
	font-size: 16px;
}

button:hover {
	background: #007bff;
}
</style>

</head>
<body>

	<div class="container">

		<input type="radio" name="tab" id="login" checked> <input
			type="radio" name="tab" id="register">

		<div class="tabs">
			<label for="login" class="login-tab">Login</label> <label
				for="register" class="register-tab">Register</label>
		</div>

		<!-- Login Form -->
		<div class="form login-form">
			<form action="Login" method="post">
				<h2>Admin Login</h2>
				<input type="email" name="email" placeholder="Email"> <input
					type="password" name="password" placeholder="Password">
				<button>Login</button>
			</form>
		</div>

		<!-- Registration Form -->
		<div class="form register-form">
			<form action="Registration" method="get">
				<h2>Admin Register</h2>
				<input type="text" name="fullname" placeholder="Full Name">
				<input type="email" name="email" placeholder="Email"> <input
					type="password" name="password" placeholder="Password"> <input
					type="password" name="cpassword" placeholder="Confirm Password">
				<button>Register</button>
			</form>	
		</div>
		
			
			
		<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
		%>

		<h3 style="color: green; text-align: center; margin-bottom: 15px;">
			<%=msg%>
		</h3>

		<%
		}
		%>

	</div>

</body>
</html>