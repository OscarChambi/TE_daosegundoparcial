<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Participantes"%>
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
            <c:if test="${participantes.id==0}"> NUEVOS </c:if>
            <c:if test="${participantes.id!=0}"> EDITAR </c:if>
             REGISTROS
        </h1>
 
   
    <form action="ParticipantesControlador" method="post">
        <centro><table border = "1">
                <input type="hidden" name="id" value="${participantes.id}">
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellidos" value="${participantes.apellidos}"></td>
                </tr>
                <tr>
                    <td>nombres</td>
                    <td><input type="text" name="nombres" value="${participantes.apellidos}"></td>
                </tr>
                <tr>
                    <td>id_seminario</td>
                    <td><input type="text" name="id_seminarios" value="${participantes.apellidos}"></td>
                </tr>
                <tr>
                    <td>confirmado</td>
                    <td><input type="text" name="confirmado" value="${participantes.apellidos}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="enviar"></td>
                </tr>          
            </table>
           </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </form>

</body>
</html>