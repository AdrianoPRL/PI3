/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.Automovel;
import br.com.candt.model.AutomovelDAO;
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

@WebServlet(name = "alocacao", urlPatterns = {"/alocacao"})
public class alocacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/Locação.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String btn = request.getParameter("tipodeuser");
        AutomovelDAO dao = new AutomovelDAO();
        String search = request.getParameter("procurar");
        if (!"selecionar".equals(btn)) {
            if (search.isEmpty()) {
                List<Automovel> automoveis = dao.listar();

                request.setAttribute("autos", automoveis);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Locação.jsp");
                dispatcher.forward(request, response);

            } else {
                List<Automovel> automoveis2 = new ArrayList<>();
                Automovel auto = dao.procurar(search);
                automoveis2.add(auto);

                request.setAttribute("autos", automoveis2);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Locação.jsp");
                dispatcher.forward(request, response);

            }
        } else if (btn.equals("selecionar")) {
            ClienteDao cli = new ClienteDao();
            HttpSession sessao = request.getSession(true);
            HttpSession sessao2 = request.getSession(true);
            
            search = request.getParameter("auto");
            Automovel auto = dao.procurar(search);
            sessao.setAttribute("automovel", auto);
            
            String search2 = request.getParameter("cli");
            ClienteFisico clienteS = cli.procurar(search2);
            sessao2.setAttribute("usuario", clienteS);

            response.sendRedirect(request.getContextPath() + "/venda");
        }
    }
}
