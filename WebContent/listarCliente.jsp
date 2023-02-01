<%@page import="beans.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="NavMan.jsp"/>
	<div class="container"> 
		<br>
		<div class="row">
			<div class="row">
				<form action="ServletCliente?tipo=BuscarxNombrexApellido"
					id="frmconsultar" method="post">

					Consultar cliente: <input type="text" name="Buscar" required
						autofocus> <select class="btn btn-light" name="Elegir">
						<option value="1">Nombre</option>
						<option value="2">Apellido</option>
					</select> <input class="btn btn-success" type="submit" value="Buscar">
					<a href="ServletCliente?tipo=listar" class="btn btn-warning">Mostrar
						Lista</a>
				</form>
			</div>
		</div>
		<br>
		
		<div class="row">
			<div class="col">
				<table class="table table-striped table-hover" align="center">
					<tr>
						<th>CÓDIGO</th>
						<th>NOMBRE</th>
						<th>APELLIDO</th>
						<th>TELEFONO</th>
						<th>CORREO</th>
						<th>DIRECCION</th>
						<th colspan="2">ACCIONES</th>
					</tr>

					<%
         ArrayList<Cliente> lista = (ArrayList<Cliente>) request.getAttribute("data");
      if (lista != null) {
         for (Cliente c : lista) {
            out.println("<tr>");
            out.println("<td>" + c.getCodigo() + "</td>");
            out.println("<td>" + c.getNombre() + "</td>");
            out.println("<td>" + c.getApellido() + "</td>");
            out.println("<td>" + c.getTelefono() + "</td>");
            out.println("<td>" + c.getCorreo() + "</td>");
            out.println("<td>" + c.getDireccion() + "</td>");
            out.println("<td align='center'><a href='ServletCliente?tipo=buscar&cod=" + c.getCodigo() + "'>"
            + "<img width='30%' src='img/iconModificar.png' title='Editar'></a></td>");
            out.println("<td align='center'><a href='ServletCliente?tipo=eliminar&cod=" + c.getCodigo() + "'>"
            + "<img width='30%' src='img/iconEliminar.png' title='Eliminar'></a></td>");
         }
      }
      %>
				</table>
			</div>
		</div>
	</div>
</body>

</html>