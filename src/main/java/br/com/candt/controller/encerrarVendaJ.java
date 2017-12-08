/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.AutomovelDAO;
import br.com.candt.model.JuridicaDAO;
import br.com.candt.model.VendaJuridica;
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

/**
 *
 * @author Junior
 */
@WebServlet(name = "encerrarVendaJ", urlPatterns = {"/encerrarVendaJ"})
public class encerrarVendaJ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/encerrarVendaJ.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JuridicaDAO venda = new JuridicaDAO();
        String procura = request.getParameter("procurar");
        String terminar = request.getParameter("terminar");
        String id = request.getParameter("id");
        String renavam = request.getParameter("renavam");
        AutomovelDAO autoDao = new AutomovelDAO();
        List<VendaJuridica> vendaF = new ArrayList();
        if (!"encerrar".equals(terminar)) {
            if (procura.isEmpty()) {
                vendaF = venda.listarAbertas();
                request.setAttribute("vendas", vendaF);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/encerrarVendaJ.jsp");
                dispatcher.forward(request, response);

            } else {

            }
        } else if (terminar.equals("encerrar")) {
            venda.finalizarVendaJ(Integer.parseInt(id));
            autoDao.receberAuto(renavam);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/encerrarVendaJ.jsp");
            dispatcher.forward(request, response);

        }
    }

}
