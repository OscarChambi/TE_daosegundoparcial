
<%
    String opcion = request.getParameter("opcion");
%>
<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link <%=(opcion.equals("participantes")? "active":"") %>" aria-current="page" href="participantes.jsp">Participantes</a>
  </li>
  <li class="nav-item">
    <a class="nav-link <%=(opcion.equals("seminarios")? "active":"") %>" href="seminarios.jsp">Seminarios</a>
  </li>
 
</ul>
<p></p>
