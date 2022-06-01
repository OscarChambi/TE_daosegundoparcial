<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
          <div class="container">
        <table border="1" align="center" cellspacing="0" >
            <tr>
                <td>SEGUNDO PARCIAL TEM-742<br>Nombre: Oscar Mollericona Chambi<br>Carnet: 7074687LP</td>
            </tr>
        </table>
              <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="cuenta"/>
            </jsp:include>
        <h1 align="center">SEMINARIOS DISPONIBLES</h1>
         
        <a href="SeminariosControlador?action=add">Nuevo</a>
        <table border="1" align="center" class="table table-bordered">
            <tr>
                <th>Id</th>
                <th>Título</th>             
                <th>Fecha</th>
                <th>Cupos</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${seminarios}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td>
                    <td>${item.fecha}</td>
                    <td>${item.cupo}</td>
                    <td><a href="SeminariosControlador?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="SeminariosControlador?action=delete&id=${item.id}" onclick="return(confirm ('Está seguro de eliminar el registro???'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
