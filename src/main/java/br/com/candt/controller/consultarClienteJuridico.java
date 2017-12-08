/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.ClienteJuridico;
import br.com.candt.model.ClienteJuridicoDAO;
import br.com.candt.model.JuridicaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "consultarClienteJuridico", urlPatterns = {"/consultarClienteJ"})
public class consultarClienteJuridico extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/consultarClienteJuridico.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteJuridicoDAO dao = new ClienteJuridicoDAO();
        String search = request.getParameter("procurar");
        String btn = request.getParameter("tipodeuser");
        if (!"editar".equals(btn) && !"excluir".equals(btn)) {
            List<ClienteJuridico> clientes = new ArrayList();
            if (search.isEmpty()) {

                clientes = dao.listar();
                request.setAttribute("model", clientes);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/consultarClienteJuridico.jsp");
                dispatcher.forward(request, response);
            } else {

                clientes = dao.procurarEspecial(search);
                request.setAttribute("model", clientes);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/consultarClienteJuridico.jsp");
                dispatcher.forward(request, response);
            }
        } else if (btn.equals("editar")) {

            HttpSession sessao = request.getSession(true);

            search = request.getParameter("repeat");
            ClienteJuridico cliente = dao.buscar(search);
            sessao.setAttribute("usuario", cliente);
            response.sendRedirect(request.getContextPath() + "/editarClienteJ");

        } else if (btn.equals("excluir")) {
            HttpSession sessao = request.getSession(true);

            String getCnpJ = request.getParameter("repeat");
//            ClienteFisico cliente = cli.procurar(search);
            dao.excluir(getCnpJ);
            request.setAttribute("excluir", "Excluido");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/consultarClienteJuridico.jsp");
            dispatcher.forward(request, response);
        }
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/consultarCliente.jsp");
//        dispatcher.forward(request, response);
    }
}
