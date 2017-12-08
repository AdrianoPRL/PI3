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

@WebServlet(name = "locacao2", urlPatterns = {"/selecionarCliente"})
public class locacao2 extends HttpServlet {

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
        String search = request.getParameter("procurar");
        String btn = request.getParameter("tipodeuser");

        if (!"selecionar".equals(btn)) {
            List<Cliente> clientes = new ArrayList();
            List<ClienteFisico> clientesF = new ArrayList();
            List<ClienteJuridico> clientesJ = new ArrayList();
            if (search.isEmpty()) {

                clientes = cli.listarTodos();
                for (Cliente c : clientes) {
                    if (c instanceof ClienteFisico) {

                        clientesF.add((ClienteFisico) c);
                    } else if (c instanceof ClienteJuridico) {

                        clientesJ.add((ClienteJuridico) c);
                    }
                }
                request.setAttribute("fisico", clientesF);
                request.setAttribute("juridico", clientesJ);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/selecionarCliente.jsp");
                dispatcher.forward(request, response);

            } else {

                ClienteFisico cliente = cli.procurar(search);
                clientesF.add(cliente);
                request.setAttribute("fisico", clientesF);

                ClienteJuridico juri = cliJ.buscar(search);

                clientesJ.add(juri);

                request.setAttribute("juridico", clientesJ);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/selecionarCliente.jsp");
                dispatcher.forward(request, response);

            }
        }
    }

}
