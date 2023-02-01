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
		<form class="mt-3" action="ServletProducto?tipo=registrar" id="frmagregar"
		method="post">

			<div class="row mb-3">
				<label class="col-2 col-form-label">Nombre de Producto:</label>
				<div class="col-10">
				<input class="form-control"type="text" name="txt_NombreProducto" required="required">
				</div>
			</div>
						
			<div class="row mb-3">
				<label class="col-2 col-form-label">Precio Unidad:</label>
				<div class="col-10">
				<input class="form-control"type="text" name="txt_PrecioUnidad" required="required"
				>
				</div>
			</div>
						
			<div class="row mb-3">
				<label class="col-2 col-form-label">Stock Producto:</label>
				<div class="col-10">
				<input class="form-control"type="text" name="txt_StockProducto" required="required">
				</div>
			</div>
						
			<div class="row mb-3">
				<label class="col-2 col-form-label">Id Marca:</label>
				<div class="col-10">
					<select class="form-control" name="txt_IdMarca">
						<option value="1">HP</option>
						<option value="2">SAMSUNG</option>
						<option value="3">KINGSTON</option>
						<option value="4">SanDisk</option>
						<option value="5">INTEL</option>
						<option value="6">AMD</option>
						<option value="7">MSI</option>
						<option value="8">NVIDIA</option>
						<option value="9">ACER</option>
						<option value="10">ASUS</option>
						<option value="11">LOGITECH</option>
						<option value="12">DELL</option>
						<option value="13">GIGABYTE</option>
						<option value="14">LENOVO</option>
						<option value="15">ALIENWARE</option>
					</select>
				</div>
			</div>

			<div class="row mb-3">
				<label class="col-2 col-form-label">Id Categoria:</label>
				<div class="col-10">
					<select class="form-control" name="txt_IdCategoria">
						<option value="1">Laptop</option>
						<option value="2">Mouse</option>
						<option value="3">Pantalla</option>
						<option value="4">Teclado</option>
						<option value="5">Fuente poder</option>
						<option value="6">Audifono</option>
						<option value="7">Procesador</option>
						<option value="8">Memoria RAM</option>
						<option value="9">Memoria Almacenamiento</option>
						<option value="10">Case</option>
						<option value="11">Placa madre</option>
						<option value="12">Tarjeta grafica</option>
						<option value="13">Microfono</option>
						<option value="14">Parlantes</option>
						<option value="15">Otros</option>
					</select>
				</div>
			</div>

			<div class="row mb-3">
			<input class="btn btn-primary"type="submit" value="Registrar">
			</div>
			
		</form>
	</div> 
	
</body>
</html>