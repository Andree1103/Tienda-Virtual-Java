<%@page import="beans.Marca"%>
<%@page import="beans.Categoria"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
    ArrayList<Categoria> datos = new ArrayList<Categoria>();
	Class.forName("com.mysql.jdbc.Driver");
	try {
		Connection miCX = DriverManager.getConnection("jdbc:mysql://localhost/tienda_gamer2022","root","mysql");
		Statement miStatement = miCX.createStatement();
		String comandoSQL = "select * from tb_categorias";
		ResultSet rs = miStatement.executeQuery(comandoSQL);
		while (rs.next()) {
			Categoria cat =new Categoria();
			cat.setIdcategoria(rs.getInt(1));
			cat.setDescripción(rs.getString(2));
			datos.add(cat);
			}
		rs.close();
		miCX.close();
	}
	catch (Exception e) {
		out.println("Ocurrió un error...!!!!");
	}
	pageContext.setAttribute("lasCategorias", datos);
%>
 <%
    ArrayList<Marca> mar = new ArrayList<Marca>();
	Class.forName("com.mysql.jdbc.Driver");
	try {
		Connection miCX = DriverManager.getConnection("jdbc:mysql://localhost/tienda_gamer2022","root","mysql");
		Statement miStatement = miCX.createStatement();
		String comandoSQL = "select * from tb_marcas";
		ResultSet rs = miStatement.executeQuery(comandoSQL);
		while (rs.next()) {
			Marca marc=new Marca();
			marc.setIdmarca(rs.getInt(1));
			marc.setNombremarca(rs.getString(2));
			mar.add(marc);
		}
		rs.close();
		miCX.close();
	}
	catch (Exception e) {
		out.println("Ocurrió un error...!!!!");
	}
	pageContext.setAttribute("lasMarcas", mar);
%>

<!doctype html>
<html lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Reportes</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="./estilo/archi.css">
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
</head>
<script>

</script>

<body>
<jsp:include page="NavMan.jsp"/>
  <div class="tittle">
    <h1>REPORTES</h1>
  </div>
  <hr>
  <main class="cuerpo">
    <section class="contenedor">
    		<div  class="tabla1">
                <h2>Reporte Categoria</h2>
                <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">Codigo</th>
                      <th scope="col">Nombre Categoria</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="Catemporal" items="${lasCategorias}">
                  	<tr>
      					<th scope="row">${Catemporal.idcategoria}</th>
      					<td>${Catemporal.descripción}</td>
    				</tr>
                    </c:forEach>
                  </tbody>
                </table> 
                </div>
    			<div class="tabla1">
    			<h2>Reporte Marcas</h2>
                  <table class="table">
                    <thead>
                      <tr>
                        <th scope="col">Codigo</th>
                        <th scope="col">Nombre Marca</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="Martemporal" items="${lasMarcas}">
                  	<tr>
      					<th scope="row">${Martemporal.idmarca}</th>
      					<td>${Martemporal.nombremarca}</td>
    				</tr>
                    </c:forEach>
                    </tbody>
                  </table> 
                </div>
    </section> 
  </main>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
    crossorigin="anonymous"></script>
</body>

</html>
