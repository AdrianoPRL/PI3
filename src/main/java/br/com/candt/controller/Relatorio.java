/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.Automovel;
import br.com.candt.model.JuridicaDAO;
import br.com.candt.model.VendaFisica;
import br.com.candt.model.VendaDAO;
import br.com.candt.model.VendaJuridica;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Relatorio", urlPatterns = {"/Relatorio"})
public class Relatorio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/Relatorio.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession(true);
        VendaDAO vendaDao = new VendaDAO();
        JuridicaDAO juridico = new JuridicaDAO();
        List<VendaFisica> ei = (List) sessao.getAttribute("vendas");
        List<VendaJuridica> Juri = (List) sessao.getAttribute("vendasJ");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
        Date E = new Date();
        Date D = new Date();
        String DataEntrega = (request.getParameter("dataI"));
        String dataDevolucao = (request.getParameter("dataF"));
        if(DataEntrega==null || dataDevolucao==null || DataEntrega.isEmpty() || dataDevolucao.isEmpty()){
            request.setAttribute("erroDatas", "Datas inválidas!");
            RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/Relatorio.jsp");
        dispatcher.forward(request, response);
        return;
        }
        try {
            E = formato.parse(DataEntrega);
            D = formato.parse(dataDevolucao);
        } catch (ParseException ex) {
            Logger.getLogger(concluirVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ei == null) {
            ei = new ArrayList();

        }
        if(Juri==null){
            Juri=new ArrayList();
        
        }
        
        if(E.after(D)){
            Date temp = E;
            E = D;
            D = temp;
        }
        
        try {
            ei = vendaDao.Relatorio(E, D);
        } catch (SQLException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Juri=juridico.Relatorio(E, D);
        } catch (SQLException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("vendas", ei);
        request.setAttribute("vendasJ", Juri);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/Relatorio.jsp");
        dispatcher.forward(request, response);
    }

}
