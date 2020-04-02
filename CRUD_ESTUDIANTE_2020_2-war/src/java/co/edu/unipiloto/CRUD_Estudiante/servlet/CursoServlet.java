/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.CRUD_Estudiante.servlet;

import co.edu.unipiloto.CRUD_ESTUDIANTE.entity.Curso;
import co.edu.unipiloto.CRUD_ESTUDIANTE.session.CursoFacadeLocal;
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
public class CursoServlet extends HttpServlet {

    @EJB
    private CursoFacadeLocal cursoFacade;

    
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
            /* TODO output your page here. You may use following sample code. */
            
        String action = request.getParameter("action");
        String cursoIdStr = request.getParameter("codigocurso");
        int cursoId=0;
        if(cursoIdStr!=null && !cursoIdStr.equals("")){
            cursoId=Integer.parseInt(cursoIdStr);    
        }
        String nombre = request.getParameter("nombrecurso");
        String creditosStr = request.getParameter("creditos");
        int creditos=0;
        if(creditosStr!=null && !creditosStr.equals("")){
            creditos=Integer.parseInt(creditosStr);
        }
        String semestreStr = request.getParameter("semestre");
        int semestre=0;
        if(semestreStr!=null && !semestreStr.equals("")){
            semestre=Integer.parseInt(semestreStr);
        }
        String admitidosStr = request.getParameter("admitidos");
        int admitidos=0;
        if(admitidosStr!=null && !admitidosStr.equals("")){
            admitidos=Integer.parseInt(admitidosStr);
        }
        
        //System.out.println(cursoId+"-"+action);
        
        
        Curso cur=new Curso(cursoId, nombre, creditos, semestre, admitidos);
        //estudiantesFacade.create(est);
           
           if("Add".equalsIgnoreCase(action)){
            cursoFacade.create(cur);
        }else if("Edit".equalsIgnoreCase(action)){
            cursoFacade.edit(cur);
        }else if("Delete".equalsIgnoreCase(action)){
            cursoFacade.remove(cur);
        }else if("Search".equalsIgnoreCase(action)){
            cur = cursoFacade.find(cursoId);
        }
        
           
           
           
         
        request.setAttribute("curs",cur);
        request.setAttribute("allCursos",cursoFacade.findAll());
        request.getRequestDispatcher("/curso.jsp").forward(request, response);
          
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
