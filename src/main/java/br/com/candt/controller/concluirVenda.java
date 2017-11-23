/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.Venda;
import br.com.candt.model.VendaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "concluirVenda", urlPatterns = {"/venda"})
public class concluirVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/concluirVenda.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Venda venda = new Venda();
        VendaDAO dao = new VendaDAO();
        venda.setRenavam(request.getParameter("renavam"));
        venda.setCliente(request.getParameter("cpf"));
        venda.setDataDeDevolucao(request.getParameter("dataD"));
         venda.setDatadeEntrega(request.getParameter("dataE"));
        venda.setServico(request.getParameter("servico"));
        venda.setValorUnitario(Float.parseFloat(request.getParameter("preco")));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/concluirVenda.jsp");
        dispatcher.forward(request, response);
    }
}
