/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.CategoriaDAO;
import Entidade.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yNot
 */
public class AcaoCategoria extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AcaoCategoria</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AcaoCategoria at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        // processRequest(request, response);
        String param = request.getParameter("param");
        
        if (param.equals("EditarCategoria")) {
            Categoria u = new Categoria();
            u.setId_categoria(Integer.parseInt(request.getParameter("id")));
            u.setNome(request.getParameter("Nome"));
            u.setDescricao(request.getParameter("Descricao"));
            u.setX("A");
            
            CategoriaDAO a = new CategoriaDAO();
            a.atualizar(u);
            
        } else if (param.equals("ExcluirCategoria")) {
            
            CategoriaDAO b = new CategoriaDAO();
            b.excluir(Integer.parseInt(request.getParameter("id")));
            
        } else if (param.equals("ListarCategoria")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("Nome");
            String descricao = request.getParameter("Descricao");
            String status = request.getParameter("x");
            
            Categoria tl = new Categoria();
            tl.setId_categoria(id);
            tl.setNome(nome);
            tl.setDescricao(descricao);
            tl.setX(status);
            
            response.sendRedirect("/ControleDespesas/DAOPessoa/ListarCategoria.jsp");
            
        }
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
        //processRequest(request, response);

        String param = request.getParameter("param");
        String Nome = request.getParameter("Nome");
        String Descricao = request.getParameter("Descricao");
        
        if (param.equals("SalvarCategoria")) {
            
            Categoria u = new Categoria();
            u.setNome(Nome);
            u.setDescricao(Descricao);
            u.setX("A");
            
            CategoriaDAO c = new CategoriaDAO();
            c.salvar(u);
            response.sendRedirect("/ControleDespesas/DAOCategoria/CadastroCategorias.jsp");
        }
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
