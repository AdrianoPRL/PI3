/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.Automovel;
import br.com.candt.model.AutomovelDAO;
import java.io.IOException;
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
@WebServlet(name = "selecionarAuto", urlPatterns = {"/selecionarAuto"})
public class selecionarAuto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/loca.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("procurar");
        List<Automovel> automoveis = new ArrayList();
        AutomovelDAO dao = new AutomovelDAO();
        Automovel auto = new Automovel();
        if (search.isEmpty()) {
            automoveis = dao.listar();
            request.setAttribute("autos", automoveis);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loca.jsp");
            dispatcher.forward(request, response);
        } else if (!search.isEmpty()) {

            auto = dao.procurar(search);

            automoveis.add(auto);

            request.setAttribute("autos", automoveis);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loca.jsp");
            dispatcher.forward(request, response);
        }
    }

}
