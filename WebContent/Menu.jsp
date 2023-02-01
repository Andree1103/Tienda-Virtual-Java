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
<title>Insert title here</title>
</head>
<body>

	<!-- container
	<a href="ServletCliente?tipo=listar">Lista de clientes</a>
	<a href="RegistrarCliente.jsp">Registra clientes</a>
	<a href="ServletProducto?tipo=listar">Lista de productos</a>
	<a href="registrarProducto.jsp">Registra productos</a>
	<a href="ServletCategoria?tipo=listar">Listar Categorias</a>
	<a href="registrarCategoria.jsp">Registra Categoria</a>
	<a href="ServletMarca?tipo=listar">Listar Marcas</a>
	<a href="registrarMarca.jsp">Registra Marca</a>
 -->
	<!-- container -->


	<div class="">
		<div>
			<nav class="navbar navbar-expand-lg navbar-light bg-dark navbar-dark">
				<div class="container">
					<a class="navbar-brand" href="Menu.jsp">MENÚ MANTENIMIENTO</a>
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
							<li class="nav-item"><a class="nav-link" href="Index.html">Cerrar
									sesión</a></li>
						</ul>

					</div>
				</div>
			</nav>
		</div>


		<!-- Carrusel -->
		<div id="carouselExampleControls" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="img/ban1.png" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="img/ban2.png" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="img/ban3.png" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="img/ban4.png" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="img/ban5.png" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="img/ban6.png" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="img/ban7.png" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="img/ban8.png" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="img/ban9.png" class="d-block w-100" alt="...">
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</div>
</body>
</html>

