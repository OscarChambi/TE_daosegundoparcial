package com.emergentes.controlador;

import com.emergentes.dao.SeminariosDAOimpl;
import com.emergentes.modelo.Seminarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.SeminariosDAO;

@WebServlet(name = "SeminariosControlador", urlPatterns = {"/SeminariosControlador"})
public class SeminariosControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SeminariosDAO dao = new SeminariosDAOimpl();
            Seminarios sem = new Seminarios();
            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("seminarios", sem);
                    request.getRequestDispatcher("frmSeminarios.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    sem=dao.getById(id);
                    request.setAttribute("seminarios", sem);
                    request.getRequestDispatcher("frmSeminarios.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("SeminariosControlador");   
                    break;
                case "view":
                    List<Seminarios> lista = dao.getAll();
                    request.setAttribute("seminarios", lista);
                    request.getRequestDispatcher("seminarios.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SeminariosDAO dao = new SeminariosDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String fecha = request.getParameter("fecha");
        int cupo = Integer.parseInt(request.getParameter("cupo"));
        Seminarios sem = new Seminarios();
        sem.setId(id);
        sem.setTitulo(titulo);
        sem.setFecha(fecha);
        sem.setCupo(cupo);
        if (id==0) {
            try {
                dao.insert(sem);
                response.sendRedirect("SeminariosControlador");
            } catch (Exception ex) {
                System.out.println("Error"+ex.getMessage());
            }
            
        }else{
            try {
                dao.update(sem);
                response.sendRedirect("SeminariosControlador");
            } catch (Exception ex) {
                System.out.println("Error"+ex.getMessage());
            }
            
        }
      
    }
}
