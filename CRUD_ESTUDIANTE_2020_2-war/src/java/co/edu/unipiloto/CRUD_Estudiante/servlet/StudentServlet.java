/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.CRUD_Estudiante.servlet;

import co.edu.unipiloto.CRUD_ESTUDIANTE.entity.Estudiantes;
import co.edu.unipiloto.CRUD_ESTUDIANTE.session.EstudiantesFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manuel martinez
 */
public class StudentServlet extends HttpServlet {

    @EJB
    private EstudiantesFacadeLocal estudiantesFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        String action = request.getParameter("action");
        String studentIdStr = request.getParameter("studentId");
        int studentId=0;
        if(studentIdStr!=null && !studentIdStr.equals("")){
            studentId=Integer.parseInt(studentIdStr);    
        }
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String yearLevelStr = request.getParameter("yearLevel");
        int yearLevel=0;
        if(yearLevelStr!=null && !yearLevelStr.equals("")){
            yearLevel=Integer.parseInt(yearLevelStr);
        }
        
        System.out.println(studentId+"-"+action);
        
        
        Estudiantes est=new Estudiantes(studentId,firstName,lastName,yearLevel);
        //estudiantesFacade.create(est);
           
           if("Add".equalsIgnoreCase(action)){
            estudiantesFacade.create(est);
        }else if("Edit".equalsIgnoreCase(action)){
            estudiantesFacade.edit(est);
        }else if("Delete".equalsIgnoreCase(action)){
            estudiantesFacade.remove(est);
        }else if("Search".equalsIgnoreCase(action)){
            est = estudiantesFacade.find(studentId);
        }
        
           
           
           
         
        request.setAttribute("student", est);
        request.setAttribute("allStudents", estudiantesFacade.findAll());
        request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
          
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
