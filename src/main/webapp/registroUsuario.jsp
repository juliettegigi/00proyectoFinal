<%@ page import="baseDatos.CerrosDAO"%>
<!DOCTYPE html>
<html lang="en" style="height:100%;">
<head>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
   <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/estilo.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SL trekkig</title>
</head>

<body class="bodyLogin">


<div class="login">
<h4>Cre� un nombre de usuario y contrase�a</h4>
<form action="RegistrateServlet" method="post"  class="bg-success p-2 text-dark bg-opacity-50">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Nombre de usuario</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"  name="user"  required >
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Contrase�a</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="pass"  required>
  </div>
  <button type="submit" class="btn btn-primary">Registrar</button>

  <%  if(request.getAttribute("mensaje")!=null)
        out.print("<h5 style=\"color:red\">"+request.getAttribute("mensaje")+"</h5>");
  
  %>
</form>
</div>





</body>
</html>