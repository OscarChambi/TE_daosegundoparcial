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
        <h1>
            <c:if test="${seminarios.id==0}"> NUEVOS </c:if>
            <c:if test="${seminarios.id!=0}"> EDITAR </c:if>
             REGISTROS
        </h1>
            <form action="SeminariosControlador" method="post">
                <input type="hidden" name="id" value="${seminarios.id}">
                <table border="1" align="center" class="table table-bordered">
                    <tr>
                        <td>Titulo: </td>
                        <td><input type="text" name="titulo" value="${seminarios.titulo}" placeholder="Ingrese el titulo" required></td>
                    </tr>

                    <tr>
                        <td>Fecha: </td>
                        <td><input type="text" name="fecha" value="${seminarios.fecha}" placeholder="AAAA-MM-DD" required></td>
                    </tr>

                    <tr>
                        <td>Cupo: </td>
                        <td><input type="number"  min = 0 name="cupo" value="${seminarios.cupo}" required></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit"value="Enviar"></td>
                    </tr>
                </table>
                     </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
            </form>
    </body>
</html>
