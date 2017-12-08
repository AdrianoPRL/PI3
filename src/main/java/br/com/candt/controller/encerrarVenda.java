/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.AutomovelDAO;
import br.com.candt.model.VendaDAO;
import br.com.candt.model.VendaFisica;
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


@WebServlet(name = "encerrarVenda", urlPatterns = {"/encerrarVenda"})
public class encerrarVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/encerrarVenda.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VendaDAO venda = new VendaDAO();
        String procura = request.getParameter("procurar");
        String terminar = request.getParameter("terminar");
        String id = request.getParameter("id");
        String renavam = request.getParameter("renavam");
        AutomovelDAO autoDao = new AutomovelDAO();
        List<VendaFisica> vendaF = new ArrayList();
        if (!"encerrar".equals(terminar)) {
            if (procura.isEmpty()) {
                vendaF = venda.listarAbertas();
                request.setAttribute("vendas", vendaF);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/encerrarVenda.jsp");
                dispatcher.forward(request, response);

            } else {

                vendaF = venda.listarAbertasCPF(procura);
                request.setAttribute("vendas", vendaF);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/encerrarVenda.jsp");
                dispatcher.forward(request, response);
            }
        } else if (terminar.equals("encerrar")) {
            venda.finalizarVenda(Integer.parseInt(id));
            autoDao.receberAuto(renavam);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/encerrarVenda.jsp");
            dispatcher.forward(request, response);

        }
    }
}
