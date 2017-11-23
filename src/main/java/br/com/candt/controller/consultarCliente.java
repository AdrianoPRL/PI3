/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.Automovel;
import br.com.candt.model.ClienteDao;
import br.com.candt.model.ClienteFisico;
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

/**
 *
 * @author Phantom
 */
@WebServlet(name = "consultarCliente", urlPatterns = {"/consultarCliente"})
public class consultarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/consultarCliente.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteDao cli = new ClienteDao();
        String search = request.getParameter("procurar");
        String btn = request.getParameter("tipodeuser");
        if (!"editar".equals(btn)) {
            List<ClienteFisico> clientes = new ArrayList();
            if (search.isEmpty()) {

                clientes = cli.listar();
                request.setAttribute("model", clientes);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/consultarCliente.jsp");
                dispatcher.forward(request, response);
            }
        } 
        else {

            HttpSession sessao = request.getSession(true);

            search = request.getParameter("repeat");
            ClienteFisico cliente = cli.procurar(search);
            sessao.setAttribute("usuario", cliente);
          response.sendRedirect(request.getContextPath() + "/editarCliente");
   
        }
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/consultarCliente.jsp");
//        dispatcher.forward(request, response);
    }
}
