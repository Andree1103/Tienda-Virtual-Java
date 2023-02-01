<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="beans.Producto"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<Producto> lista = (ArrayList<Producto>) request.getAttribute("productos");
	%>
	<div class="container">
		<div class="row row-cols-1 row-cols-md-4 g-4">
		
		<%
		if (lista != null) {
			for (Producto xPro : lista) {
				
				String xtitulo = xPro.getDescripcion()+" "+xPro.getNombreMarca();
				%>
			<div class="col">
				<div class="card h-100">
					<img width="300px" height="300px" src="img/productos/prod<%=xPro.getCodigo()%>.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title"><%=xtitulo%></h5>
						<p class="card-text">Precio: <%=xPro.getPrecio() %></p>
						<p class="card-text">Stock: <%=xPro.getStock() %></p>
					</div>
					<div class="card-footer">
						<button class="btn btn-primary">Agregar</button>
					</div>
				</div>
			</div>
			<%
			}
		}
		%>		
		</div>
	</div>
</body>
</html>