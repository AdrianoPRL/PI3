/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.ClienteJuridico;
import br.com.candt.model.ClienteJuridicoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "editarClienteJuridico", urlPatterns = {"/editarClienteJ"})
public class editarClienteJuridico extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/editarClienteJuridico.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteJuridico cli = new ClienteJuridico();
        String Atualcnpj = request.getParameter("atualCNPJ");
        cli.setRazaoSocial(request.getParameter("razao"));
        cli.setNomeFantasia(request.getParameter("nome"));
        cli.setInscricaoEstadual(request.getParameter("inscricaoE"));
        cli.setCNPJ(request.getParameter("cnpj"));
        cli.setCidade(request.getParameter("cidade"));
        cli.setEnd(request.getParameter("endereco"));
        cli.setUF(request.getParameter("UF"));
        cli.setNumero(request.getParameter("numerocasa"));
        cli.setComplemento(request.getParameter("complemento"));
        cli.setCEP(request.getParameter("CEP"));
        cli.setBairro(request.getParameter("bairro"));
        cli.setTelefone(request.getParameter("tel"));
        cli.setEmail(request.getParameter("email"));
        ClienteJuridicoDAO cliDao = new ClienteJuridicoDAO();
        try {
            cliDao.Atualizar(cli, Atualcnpj);
        } catch (SQLException ex) {
            Logger.getLogger(editarClienteJuridico.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/consultarClienteJuridico.jsp");
        dispatcher.forward(request, response);
    }

}
