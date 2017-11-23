/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.ClienteDao;
import br.com.candt.model.ClienteFisico;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
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
 * @author Phantom
 */
@WebServlet(name = "CadastraClienteFisico", urlPatterns = {"/CadastrarClienteF"})
public class CadastraClienteFisico extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/cadastroFisico.jsp");
        dispatcher.forward(request, response);
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
         if (cpf.isEmpty()) {
            request.setAttribute("msgErro", "campo não pode ser vazio");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/cadastroFisico.jsp");
            dispatcher.forward(request, response);
         }
        ClienteFisico cli = new ClienteFisico();
        cli.setCPF(cpf);
        cli.setNomeCompleto(request.getParameter("nomecompleto"));
        cli.setDataNasc(request.getParameter("datanasc"));
        cli.setSexo(request.getParameter("sexo"));
        cli.setNumeroCnh(request.getParameter("CNHNumber"));
        cli.setEnd(request.getParameter("address"));
        cli.setCEP(request.getParameter("cep"));
        cli.setUF(request.getParameter("UF"));
        cli.setNumero(request.getParameter("numerocasa"));
        cli.setComplemento(request.getParameter("complemento"));
        cli.setBairro(request.getParameter("bairro"));
        cli.setTelefone(request.getParameter("tel"));
        cli.setEmail(request.getParameter("email"));
          cli.setCidade(request.getParameter("cidade"));
        ClienteDao cliDao= new ClienteDao(); 
        try {
            cliDao.incluirComTransacao(cli);
        } catch (SQLException ex) {
            Logger.getLogger(CadastraClienteFisico.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
    
}

