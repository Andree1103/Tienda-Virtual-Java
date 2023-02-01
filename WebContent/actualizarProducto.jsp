<%@page import="beans.Producto"%>
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

	<%
		Producto obj = (Producto) request.getAttribute("Producto");
	%>
	
	<div class="container">
		<form class="mt-3" action="ServletProducto?tipo=actualizar" id="frmactualizar" method="post">
			<input class="form-control"type="hidden" name="txt_IdProducto" value="${requestScope.Producto.codigo}">
			
			<div class="row mb-3">
				<label class="col-2 col-form-label">Nombre de Producto</label>
				<div class="col-10">
				<input class="form-control"type="text" name="txt_NombreProducto"
					value="${requestScope.Producto.descripcion}">
				</div>
			</div>
						
			<div class="row mb-3">
				<label class="col-2 col-form-label">Precio Unidad</label>
				<div class="col-10">
				<input class="form-control"type="text" name="txt_PrecioUnidad"
					value="${requestScope.Producto.precio}">
				</div>
			</div>
						
			<div class="row mb-3">
				<label class="col-2 col-form-label">Stock Producto</label>
				<div class="col-10">
				<input class="form-control"type="text" name="txt_StockProducto"
					value="${requestScope.Producto.stock}">
				</div>
			</div>
						
			<div class="row mb-3">
				<label class="col-2 col-form-label">Marca</label>
				<div class="col-10">
					<select class="form-control" name="txt_IdMarca">
						<%
						String marcas[] = { 
								"", "HP", "SAMSUNG", "KINGSTON", "SanDisk", 
								"INTEL", "AMD", "MSI", "NVIDIA", "ACER", 
								"ASUS", "LOGITECH", "DELL", "GIGABYTE", "LENOVO", 
								"ALIENWARE" 	
						};
						String estados = "";
						for (int i = 1; i < marcas.length; i++) {
							System.out.println("objeto:" + obj.getNombreMarca());
							System.out.println("array" + marcas[i]);
							if (Integer.parseInt(obj.getNombreMarca()) == i) {
								System.out.println("en selected");
								estados = "selected";
							} else {
								estados = "";
							}
						%>
						<option value="<%=i%>" <%=estados%>>
							<%=marcas[i]%></option>
						<%
						}
						%>
					</select>
				</div>
			</div>

			<div class="row mb-3">
				<label class="col-2 col-form-label">Categoria</label>
				<div class="col-10">
					<select class="form-control" name="txt_IdCategoria">
						<%
						String categorias[] = 
					{ "", "Laptop", "Mouse", "Pantalla", "Teclado",
							"Fuente poder", "Audifono", "Procesador", "Memoria RAM", "Memoria Almacenamiento",
							"Case", "Placa madre", "Tarjeta grafica", "Microfono", "Parlantes",	"Otros"
						};
						String valor = "";
						for (int i = 1; i < categorias.length; i++) {
							System.out.println("objeto:" + obj.getNombreCategoria());
							System.out.println("array" + categorias[i]);
							if (Integer.parseInt(obj.getNombreCategoria()) == i) {
								System.out.println("en selected");
								valor = "selected";
							} else {
								valor = "";
							}
						%>
						<option value="<%=i%>" <%=valor%>>
							<%=categorias[i]%></option>
						<%
						}
						%>
					</select>
				</div>
			</div>

			<div class="row mb-3">
			<input class="btn btn-primary"type="submit" value="Actualizar">
			</div>
		</form>
	</div> 
	
</body>
</html>