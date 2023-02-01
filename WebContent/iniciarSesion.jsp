<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>

<!-- <body>
	<div class="container">
		<div class="row">
			<div class="col">
			</div>
		</div>
	</div>
</body> -->

<body
	class="bg-info d-flex justify-content-center align-items-center vh-100">

	<%
		String x = (String) request.getAttribute("msj");
	String a = "";
	if (x != null) {
		a = x;
	}
	%>

	<form action="ServletUsuario?tipo=login" name="frmSesion"
		method="post">
		<div class="bg-white p-5 rounded-5 text-secondary shadow"
			style="width: 25rem">
			<div class="d-flex justify-content-center">
				<img src="img/login-icon.svg" alt="login-icon" style="height: 7rem" />
			</div>
			<div class="text-center fs-1 fw-bold">Login</div>
			<div class="input-group mt-4">
				<div class="input-group-text bg-info">
					<img src="img/username-icon.svg" alt="username-icon"
						style="height: 1rem" />
				</div>
				<input class="form-control bg-light" type="text" name="txt_email"
					placeholder="Email" />
			</div>
			<div class="input-group mt-1">
				<div class="input-group-text bg-info">
					<img src="img/password-icon.svg" alt="password-icon"
						style="height: 1rem" />
				</div>
				<input class="form-control bg-light" type="password" name="txt_pass"
					placeholder="Password" />
			</div>
			<input type="submit"
				class="btn btn-info text-white w-100 mt-4 fw-semibold shadow-sm"
				value="Login">
			<div class="d-flex gap-1 justify-content-center mt-1">
				<div>No tienes una cuenta?</div>
				<a href="registrarUsuario.jsp" class="text-decoration-none text-info fw-semibold">Registrate</a>
			</div>
			
			<h5 align="center"><%=a%></h5>
		</div>

		
	</form>
</body>



</html>