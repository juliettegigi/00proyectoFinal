<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="modelo.Cerro"%>
<%@ page import="java.io.File" %>
<%@ page import ="interfaces.Constantes"%>
<%@ page import="modelo.Usuario"%>
<%@ page import="baseDatos.CerrosDAO"%>
<%@ page import="java.util.ArrayList"%>  
<%@ page import="java.util.List"%>     
<%@ page import="java.util.Arrays"%>  
<%@ page import ="java.util.Enumeration"%>
<%@ page import ="java.util.HashMap"%>
<%@ page import ="java.util.Map"%>
<%@ page import=" java.util.Comparator"%>
<%@page import="java.util.Collections" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="css/estilo.css">
 <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
   <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <title>index</title>
</head>
<body>

<%

int flag=0;
Map<String, String> result = new HashMap<>();
Enumeration parameterNames = request.getParameterNames();
while (parameterNames.hasMoreElements()) {
  String parameterName = (String) parameterNames.nextElement();
   if(parameterName.equals("id")){
	   flag=1;
	   break;
    }
}
	   if(flag==1){
		   int id=Integer.parseInt(request.getParameter("id"));
		   File archivo=new File(Constantes.RUTA_IMAGENES+CerrosDAO.buscarPorId(id).getImg());
		   archivo.delete();
		   CerrosDAO.eliminar(id);
	   }
	   
	   Usuario u=(Usuario)session.getAttribute("usuario");	   
%>


<%@include file="header.jsp" %>


<div>
  <div class="rightcolumn"> 
       <div class="card" style="height:300px; ">
           <h3>Popular Post</h3>
           <% List <Cerro> l =CerrosDAO.listar(u.getUsuario());    
              if(l!=null){  // si l distinta de null hago el carrusel %>
                   <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false" style="height:100%;width: 100%; ">
                       <div class="carousel-indicators" style="margin-bottom:50%; " >
                           <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1" ></button>
                             <% for(int j=1;j<l.size();j++)        
                out.print("<button type=\"button\" data-bs-target=\"#carouselExampleCaptions\" data-bs-slide-to=\""+j+"\" aria-label=\"Slide" +(j+1)+"\"></button>");%>
                       </div>                          
                       <% Cerro c=l.get(0); %>
 <!-- contiene a las img --> 
                      <div class="carousel-inner" style="height:100%;width: 100%; ">
                            <div class="carousel-item active" style="height:100%;width:100%; ">
                   <% out.print("<img src=\""+  Constantes.SRC_IMG+c.getImg()   +"\" class=\"d-block w-100\"  alt=\"   \"  style=\"height: 100%; width:100%\">");%>
                                 <h5 class="position-absolute bottom-0 start-50 translate-middle-x carruselLink">
                    <%out.print("<a href=\"#a"+c.getId()+"\" class=\"link-primary\">IR</a> ");%>
                                </h5>
                            </div>
                    <% if(l.size()!=1){ 
                          for(int i=1;i<l.size();i++){
                              c=l.get(i);%>
<!-- bucle para todas las img -->                                    
                             <div class="carousel-item" style="height: 100%;width:100%; ">
                      <%out.print("<img src=\""+  Constantes.SRC_IMG+c.getImg()   +"\" class=\"d-block w-100\"  alt=\"   \"  style=\"height: 100%; width:100%\">");%>
                                   <h5 class="position-absolute bottom-0 start-50 translate-middle-x carruselLink">
                                      <%out.print("<a href=\"#a"+c.getId()+"\" class=\"link-primary\">IR</a> ");%>
                                   </h5>
                             </div>
<!--cierra el bucle for  --> <% }  
//cierre if
                             }%>
                        </div>
                        <button class="carousel-control-prev badge text-bg-info" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
					          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					          <span class="visually-hidden">Previous</span>
       				    </button>
				        <button class="carousel-control-next badge text-bg-info" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
				          <span class="carousel-control-next-icon" aria-hidden="true"></span>
				          <span class="visually-hidden">Next</span>
				        </button>
     			 </div>
          <%} %>
        
    </div>
   

 <div class="card">
      <h2>About Me</h2>
      <div class="fakeimg" style="height:100px">Image</div>
      <p>Hola me llamo Julieta,este es mi proyecto, consiste en subir imágenes con una descripción,tipo blog, en este caso escogí la temática"trekking" porque es una actividad que me gusta hacer. </p>
    </div>
   
    <div class="card">
      <h3>Contacto</h3>
      <p><a>mar9ina@gmail.com</a></p>
      <p>264877098</p>
    </div>
  </div>
</div>


<!--  parte del medio -->




<div class="row">
     <div class="leftcolumn">
     <%
       
           
          if(l!=null){ 
        	  Comparator<Cerro> porFecha=(Cerro c1,Cerro c2)->c1.getFechaSubida().compareTo(c2.getFechaSubida());
              Collections.sort(l,porFecha); 
        	  for(int i=l.size()-1;i>=0;i--){
             	  Cerro c=l.get(i);
     %>        <div class="card ">
                   <%out.print("<span id=\"a"+ c.getId() +"\"></span>");%>
                   <h2><%=c.getTitulo() %></h2>
                   <h5><%=Constantes.FechaString(c.getFechaSubida(),Constantes.f2) %></h5>     
                   <div class="fakeimg" style="height:300px;">
                      <img src=<%=Constantes.SRC_IMG+c.getImg() %>>
                   </div>
                  
                   <p><%=c.getDescripcion() %></p>
                   <div class="position-absolute bottom-0 start-50 translate-middle-x" >    
	                     <a href="home.jsp?id=<%=c.getId()%>"  >
	                        <% out.print("<button type=\"button\" class=\"btn btn-danger\"  name=\"idEliminar\"  value=\""+  c.getId()  +"\""+" action=\"EliminarServlet\" >Eliminar</button>");%>
	                     </a>
	                     <%String descripcion=c.getDescripcion().replace( "<br>","99988877712"); %>
	                    <a href="editar.jsp?id=<%=c.getId()%>&titulo=<%=c.getTitulo() %>&imagen=<%=c.getImg() %>&descripcion=<%=descripcion %>&fecha=<%=Constantes.FechaString(c.getFechaSubida(),Constantes.f2) %>"  >
	                         <button type="button" class="btn btn-success">Editar</button>
	                   </a>
                   </div>  
               </div>
    
       <%
               }
          }
          %>
    
</div>
</div>

<div class="footer">
  <h2>Footer</h2>
   <img src="C:\xampp\htdocs\img\1.jpg">
   <img src="..\imagenes\1.jpg">
</div>

</body>
</html>
