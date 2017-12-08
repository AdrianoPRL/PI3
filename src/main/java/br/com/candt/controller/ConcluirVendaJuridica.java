/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.Automovel;
import br.com.candt.model.AutomovelDAO;
import br.com.candt.model.ClienteJuridico;
import br.com.candt.model.ClienteJuridicoDAO;
import br.com.candt.model.Filial;
import br.com.candt.model.FilialDAO;
import br.com.candt.model.JuridicaDAO;
import br.com.candt.model.VendaJuridica;
import java.io.IOException;
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
@WebServlet(name = "ConcluirVendaJuridica", urlPatterns = {"/ConcluirVendaJuridica"})
public class ConcluirVendaJuridica extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConcluirVendaJuridica.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession(true);
        FilialDAO filiDao = new FilialDAO();
        List<Filial> fili = new ArrayList<>();
        fili.addAll(filiDao.listarFiliais());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date E = new Date();
        Date D = new Date();
        String DataEntrega = (request.getParameter("dataE"));
        String dataDevolucao = (request.getParameter("dataD"));
        try {
            E = simpleDateFormat.parse(DataEntrega);
            D = simpleDateFormat.parse(dataDevolucao);
        } catch (ParseException ex) {
            Logger.getLogger(concluirVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        String Tarifa = (request.getParameter("tarifa"));
        ClienteJuridicoDAO clidao = new ClienteJuridicoDAO();
        ClienteJuridico cli = new ClienteJuridico();
        AutomovelDAO dao = new AutomovelDAO();
        Automovel auto = new Automovel();
        String total = (request.getParameter("total"));
        String cnpj = (request.getParameter("cli"));
        cli = clidao.buscar(cnpj);
        String renavam = (request.getParameter("autot"));
        auto = dao.procurar(renavam);
        VendaJuridica juridicaCli = new VendaJuridica();
        JuridicaDAO juridica = new JuridicaDAO();
        juridicaCli.setCliente(cli);
        juridicaCli.setDataDeDevolucao(D);
        juridicaCli.setDatadeEntrega(E);
        juridicaCli.setServico(request.getParameter("Servico"));
        juridicaCli.setValorTotal(Double.parseDouble(total));
        juridicaCli.setTarifa(Double.parseDouble(Tarifa));
        juridicaCli.setAuto(auto);
        String seg = (request.getParameter("seguro"));
        juridicaCli.setSeguro(Boolean.parseBoolean(seg));
        String filia = (request.getParameter("filial"));
        Filial filial = new Filial();
        filial = filiDao.getFilial(Integer.parseInt(filia));
        juridicaCli.setFilial(filial);
        try {
            juridica.incluirComTransacao(juridicaCli);
        } catch (SQLException ex) {
            Logger.getLogger(concluirVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect(request.getContextPath() + "/selecionarCliente");
    }

}
