<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

	<%
	String x = (String) request.getAttribute("msj");
	String a = "";
	if (x != null)
		a = x;
	%>
<jsp:include page="NavMan.jsp"/>
	<h2 align="center">REGISTRO DE CLIENTES</h2>
	
	<div class="container">
			<form class="mt-3" action="ServletCliente?tipo=registrar" id="frmregistro" method="post">
		 
			
			<div class="row mb-3">
				<label class="col-2 col-form-label">Nombre de Cliente</label>
				<div class="col-10">
				<input class="form-control"type="text" name="txt_nom"   required autofocus> 
				</div>
			</div>
						
			<div class="row mb-3">
				<label class="col-2 col-form-label">Apellido de Cliente</label>
				<div class="col-10">
				<input class="form-control"type="text" name="txt_ape"  required autofocus> 
				</div>
			</div>
						
			<div class="row mb-3">
				<label class="col-2 col-form-label">Telefono</label>
				<div class="col-10">
				<input class="form-control"type="text" name="txt_telf"   required autofocus> 
				</div>
			</div>
						
			<div class="row mb-3">
				<label class="col-2 col-form-label">Correo</label>
				<div class="col-10">
				<input class="form-control"type="text" name="txt_co"   required autofocus>
				</div>
			</div>

			<div class="row mb-3">
				<label class="col-2 col-form-label">Direccion</label>
				<div class="col-10">
					<input class="form-control" type="text" name="txt_dir" required autofocus> 
				</div>
			</div>

			<div class="row mb-3">
			<input class="btn btn-primary"type="submit" value="Actualizar">
			</div>
			<h5 align="center"><%=a%></h5>
		</form>
	</div>
	
</body>
</html>