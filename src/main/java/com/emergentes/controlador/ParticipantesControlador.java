package com.emergentes.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import com.emergentes.dao.ParticipantesDAO;
import com.emergentes.dao.ParticipantesDAOimpl;
import com.emergentes.modelo.Participantes;
import com.emergentes.modelo.Seminarios;
import com.emergentes.dao.SeminariosDAO;
import com.emergentes.dao.SeminariosDAOimpl;

@WebServlet(name = "ParticipantesControlador", urlPatterns = {"/ParticipantesControlador"})
public class ParticipantesControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ParticipantesDAO dao = new ParticipantesDAOimpl();
           
            SeminariosDAO daoSeminario = new SeminariosDAOimpl();
            List<Seminarios> sem = daoSeminario.getAll();
            Participantes par = new Participantes();
            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("seminarios", sem);
                    request.setAttribute("participantes", par);
                    request.getRequestDispatcher("frmParticipantes").forward(request, response);
                    break;
                case "edit":
                    request.setAttribute("seminarios", sem);
                    id = Integer.parseInt(request.getParameter("id"));
                    par = dao.getById(id);
                    request.setAttribute("participantes", par);
                    request.getRequestDispatcher("frmParticipantes.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ParticipantesControlador");
                    break;
                case "view":
                    List<Participantes> lista = dao.getAll();
                    request.setAttribute("participantes", lista);
                    request.getRequestDispatcher("frmParticipantes.jsp").forward(request, response);
                    break;                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        int id_seminario = Integer.parseInt(request.getParameter("id_sem"));
        int confirmado = Integer.parseInt(request.getParameter("confirmado"));
        Participantes par = new Participantes();
        par.setId(id);
        par.setNombres(nombres);
        par.setApellidos(apellidos);
        par.setIdSeminario(id_seminario);
        par.setConfirmado(confirmado);
        ParticipantesDAO dao = new ParticipantesDAOimpl();
            if (id == 0) {
            try {
                dao.insert(par);
            } catch (Exception ex) {
                System.out.println("Error al insertar: "  + ex.getMessage());
            }
        } else {
            try {
                dao.update(par);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("ParticipantesControlador");
    }

}
