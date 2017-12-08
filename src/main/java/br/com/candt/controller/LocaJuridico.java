/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.Automovel;
import br.com.candt.model.AutomovelDAO;
import br.com.candt.model.ClienteFisico;
import br.com.candt.model.ClienteJuridico;
import br.com.candt.model.ClienteJuridicoDAO;
import br.com.candt.model.Filial;
import br.com.candt.model.FilialDAO;
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
@WebServlet(name = "LocaJuridico", urlPatterns = {"/LocaJuridica"})
public class LocaJuridico extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/LocaJ.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession(true);
         HttpSession sessaoFilial = request.getSession(true);
        String btn = request.getParameter("tipodeuser");
        FilialDAO filiDao = new FilialDAO();
        List<Filial> fili = new ArrayList<>();
        Automovel auto = new Automovel();
//        List<Automovel> ei = (List) sessao.getAttribute("automoveis");
        AutomovelDAO dao = new AutomovelDAO();
//        String search = request.getParameter("procurar");
//        String btn2 = request.getParameter("enviar");
//        List<Automovel> automoveis = new ArrayList();
//        List<ClienteFisico> fisicos = (List) sessao.getAttribute("selecionados");
/*        if (btn2.equals("envio")) {
            ClienteJuridicoDAO cli = new ClienteJuridicoDAO();
            String Cliente = request.getParameter("cli");
            ClienteJuridico c = cli.buscar(Cliente);
            HttpSession sessaocli = request.getSession(true);

            sessao.setAttribute("automoveis", ei);

            sessaocli.setAttribute("username", c);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/ConcluirVendaJuridica.jsp");
            dispatcher.forward(request, response);
        } else */
        if (btn.equals("selecionar")) {
//            if (ei == null) {
//                ei = new ArrayList();
//                sessao.setAttribute("automoveis", ei);
//
//            }
            ClienteJuridicoDAO cli = new ClienteJuridicoDAO();
            String Cliente = request.getParameter("cli");
            ClienteJuridico c = cli.buscar(Cliente);

            String renavamAuto = request.getParameter("autot");
            auto = dao.procurar(renavamAuto);
            fili = filiDao.listarFiliais();
            sessaoFilial.setAttribute("filiais", fili);
//            ei.add(auto);
            sessao.setAttribute("automovel", auto);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/ConcluirVendaJuridica.jsp");
            dispatcher.forward(request, response);
//            response.sendRedirect(request.getContextPath() + "/LocaJuridica");
        }
        /*else if (btn.equals("remover")) {
            int i = 0;
            String renavam = request.getParameter("autott");
            auto = new Automovel();
//            for (i = 0; i < ei.size(); i++) {
//                auto = ei.get(i);
//                if (auto.getRenavam().equals(renavam)) {
//                    ei.remove(i);
//                }

            }
            response.sendRedirect(request.getContextPath() + "/LocaJuridica");
        }*/
    }

}
