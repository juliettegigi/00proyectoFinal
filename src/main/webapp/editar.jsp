<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
   <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/estilo.css">
   
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@include file="header.jsp" %>

<% 	
//HttpSession session2 = request.getSession();
int var= Integer.parseInt(request.getParameter("id"));
session.setAttribute("idEditar", var); 
String des=request.getParameter("descripcion").replace("99988877712", "\n");

System.out.println("request de la desctiopcion "+des);
session.setAttribute("descripcion",des.replace("\n","<br"));
 %>
 
 


<form action="EditarServlet" method="post" enctype="multipart/form-data">
       <div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">Título</span>
  <input type="text" class="form-control"  aria-label="Username" aria-describedby="basic-addon1" name="titulo" value=<%=request.getParameter("titulo") %>>
</div>

   <div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">Fecha: <%=request.getParameter("fecha") %></span>
  <input type="date" class="form-control"  aria-label="Username" aria-describedby="basic-addon1" name="fecha" value=<%=request.getParameter("fecha") %>>
</div>

<div class="input-group">
  <span class="input-group-text">Descripción</span>
  <textarea class="form-control" aria-label="With textarea"  name="descripcion"  ><%=des %></textarea>
</div>

<div class="input-group mb-3">
    <h5>Imagen actual</h5>
    <img src=<%=request.getParameter("imagen") %> >
  <label class="input-group-text" for="inputGroupFile01">Upload</label>
  <input type="file" class="form-control" id="inputGroupFile01"  name="file">
</div>
 <p><label><input type="submit" value="Editar"> </label></p>

</form>


   
</body>
</html>