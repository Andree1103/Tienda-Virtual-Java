<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link href="estilo/estilo.css" rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<div>
		<nav class="navbar navbar-expand-lg navbar-light bg-dark navbar-dark">
			<div class="container">
				<a class="navbar-brand" href="Menu.jsp">MENÚ
					MANTENIMIENTO</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">

					<!-- Navegador del lado izquierdo -->
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Clientes </a>
							<ul class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<li><a class="dropdown-item"
									href="ServletCliente?tipo=listar">Lista de Clientes</a></li>
								<li><a class="dropdown-item" href="RegistrarCliente.jsp">Registrar
										Clientes</a></li>
							</ul></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Productos </a>
							<ul class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<li><a class="dropdown-item"
									href="ServletProducto?tipo=listar">Lista de Productos</a></li>
								<li><a class="dropdown-item" href="registrarProducto.jsp">Registrar
										Productos</a></li>
							</ul></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Categoria </a>
							<ul class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<li><a class="dropdown-item"
									href="ServletCategoria?tipo=listar">Lista de Categorias</a></li>
								<li><a class="dropdown-item" href="registrarCategoria.jsp">Registrar
										Categorias</a></li>
							</ul></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Marcas </a>
							<ul class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<li><a class="dropdown-item"
									href="ServletMarca?tipo=listar">Lista de Marcas</a></li>
								<li><a class="dropdown-item" href="registrarMarca.jsp">Registrar
										Marcas</a></li>
							</ul></li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Reportes </a>
							<ul class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<li><a class="dropdown-item"
									href="reporteMarcaCategoria.jsp">Marca y Categoria</a></li>
								<li><a class="dropdown-item"
									href="ServletCliente?tipo=reporte">Clientes</a></li>
								<li><a class="dropdown-item" href="ServletProducto?tipo=reporte">Productos</a></li>
								<li><a class="dropdown-item" href="ServletUsuario?tipo=reporte">Usuarios</a></li>
							</ul></li>
					</ul>
					
					<ul class="navbar-nav ms-auto">
						<li class="nav-item"><a class="nav-link"
							href="Index.html">Cerrar sesión</a></li>
					</ul>
					
				</div>
			</div>
			</nav>
			</div>
</body>
</html>