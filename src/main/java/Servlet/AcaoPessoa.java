/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.PessoaDAO;
import Entidade.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yNot
 */
public class AcaoPessoa extends HttpServlet {

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
            out.println("<title>Servlet AcaoPessoa</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AcaoPessoa at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);

        String param = request.getParameter("param");

        if (param.equals("EdPessoa")) {
            String id = request.getParameter("id");

            Pessoa pes = new PessoaDAO().consultarId(Integer.parseInt(id));

            request.setAttribute("objPessoa", pes);

            System.out.println(pes.getNome());

            encaminharPagina("/DAOPessoa/AtualizaPessoas.jsp", request, response);

        } else if (param.equals("ExcluirPessoa")) {

            PessoaDAO b = new PessoaDAO();
            b.excluir1(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect("/ControleDespesas/DAOPessoa/ListarPessoas.jsp");

        } else if (param.equals("ListarPessoa")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("Nome");
            String cpf = request.getParameter("CPF");
            String status = request.getParameter("x");

            Pessoa tl = new Pessoa();
            tl.setId_pessoa(id);
            tl.setNome(nome);
            tl.setCpf(cpf);
            tl.setX(status);

            response.sendRedirect("/ControleDespesas/DAOPessoa/ListarPessoas.jsp");

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
        // processRequest(request, response);

        String param = request.getParameter("param");
        String Nome = request.getParameter("Nome");
        String CPF = request.getParameter("CPF");

        if (param.equals("SalvarPessoa")) {

            Pessoa u = new Pessoa();
            u.setNome(Nome);
            u.setCpf(CPF);
            u.setX("A");

            PessoaDAO c = new PessoaDAO();
            c.salvar1(u);
            response.sendRedirect("/ControleDespesas/DAOPessoa/ListarPessoas.jsp");
            
        } else if (param.equals("EditarPessoa")) {
            Pessoa u = new Pessoa();
            u.setId_pessoa(Integer.parseInt(request.getParameter("id_Pessoa")));
            u.setNome(request.getParameter("Nome"));
            u.setCpf(request.getParameter("CPF"));
            u.setX("A");

            PessoaDAO a = new PessoaDAO();
            a.atualizar(u);
            response.sendRedirect("/ControleDespesas/DAOPessoa/ListarPessoa.jsp");

        }

    }

    private void encaminharPagina(String pagina, HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("Erro ao encaminhar: " + e);
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
