/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.Cliente;
import br.com.candt.model.ClienteDao;
import br.com.candt.model.ClienteFisico;
import br.com.candt.model.ClienteJuridico;
import br.com.candt.model.ClienteJuridicoDAO;

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
 * @author Junior
 */
@WebServlet(name = "loca", urlPatterns = {"/loca"})
public class loca extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/selecionarCliente.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteDao cli = new ClienteDao();
        ClienteJuridicoDAO cliJ = new ClienteJuridicoDAO();
        String btn = request.getParameter("tipodeuser");

        if (btn.equals("fis")) {
            String search = request.getParameter("cli");
            HttpSession sessao = request.getSession(true);
            ClienteFisico cliente = cli.procurar(search);
            sessao.setAttribute("usuario", cliente);
            response.sendRedirect(request.getContextPath() + "/locacao");
        }
        if (btn.equals("juri")) {
            String search = request.getParameter("cli");
            HttpSession sessao = request.getSession(true);
            ClienteJuridico cliente = cliJ.buscar(search);
            sessao.setAttribute("usuario", cliente);
            response.sendRedirect(request.getContextPath() + "/LocaJuridica");
        }

    }

}
