/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.ClienteDao;
import br.com.candt.model.ClienteFisico;
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


@WebServlet(name = "CadastraClienteJuridico", urlPatterns = {"/CadastrarClienteJ"})
public class CadastraClienteJuridico extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         RequestDispatcher dispatcher
	    = request.getRequestDispatcher("/WEB-INF/jsp/cadastroclientejuridico.jsp");
    dispatcher.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
       
        ClienteJuridico cli = new ClienteJuridico();
        cli.setRazaoSocial(request.getParameter("razao"));
        cli.setNomeFantasia(request.getParameter("nome"));
        cli.setInscricaoEstadual(request.getParameter("inscricaoE"));
        cli.setCNPJ(request.getParameter("cnpj"));
        cli.setNumeroCnh(request.getParameter("CNHNumber"));
        cli.setCidade(request.getParameter("cidade"));
        cli.setEnd(request.getParameter("address"));
        cli.setUF(request.getParameter("UF"));
        cli.setComplemento(request.getParameter("complemento"));
        cli.setBairro(request.getParameter("bairro"));
        cli.setTelefone(request.getParameter("tel"));
        cli.setEmail(request.getParameter("email"));
        ClienteJuridicoDAO cliDao= new ClienteJuridicoDAO(); 
     
       try {
           cliDao.incluirComTransacao(cli);
       } catch (SQLException ex) {
           Logger.getLogger(CadastraClienteJuridico.class.getName()).log(Level.SEVERE, null, ex);
       }
      
                 response.sendRedirect(request.getContextPath()
              + "/CadastrarClienteJ");
            
            
        }
    
    }


