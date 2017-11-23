/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.Automovel;
import br.com.candt.model.AutomovelDAO;
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


@WebServlet(name = "consultarAutomovel", urlPatterns = {"/consultarAutomovel"})
public class consultarAutomovel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/consultarAutomovel.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Automovel auto = new Automovel();
        AutomovelDAO dao = new AutomovelDAO();
        String search = request.getParameter("procurar");
        String btn = request.getParameter("tipodeuser");
        if (!"editar".equals(btn)) {
            List<Automovel> automoveis = dao.listar();

            request.setAttribute("autos", automoveis);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/consultarAutomovel.jsp");
            dispatcher.forward(request, response);
        } else {
         HttpSession sessao = request.getSession(true);
                   search = request.getParameter("auto");
             auto = dao.procurar(search);
            sessao.setAttribute("automovel", auto);
            response.sendRedirect(request.getContextPath() + "/editarAuto");
        }
    }
}
