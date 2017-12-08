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

        String nomeCompleto = request.getParameter("nomecompleto");
        String cpf = request.getParameter("cpf");
        String DataNasc = request.getParameter("datanasc");
        String setSexo = request.getParameter("sexo");
        String setNumeroCNH = request.getParameter("CNHNumber");
        String setEnd = request.getParameter("endereco");
        String setCEP = request.getParameter("cep");
        String setUF = request.getParameter("UF");
        String setNumero = request.getParameter("numerocasa");
        String setComplemento = request.getParameter("complemento");
        String setBairro = request.getParameter("bairro");
        String setTelefone = request.getParameter("tel");
        String setEmail = request.getParameter("email");
        String setCidade = request.getParameter("cidade");
        
        if (nomeCompleto==null||cpf==null||DataNasc==null||setNumeroCNH==null||setEnd==null||setCEP==null||
                setNumero==null||setBairro==null||setTelefone==null||setEmail==null||setCidade==null)
                { 
                                   
                    
            request.setAttribute("erro", "Campo(s) nulo(s)");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/cadastroFisico.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (nomeCompleto.isEmpty()||cpf.isEmpty()||DataNasc.isEmpty()||setNumeroCNH.isEmpty()||
                setEnd.isEmpty()||setCEP.isEmpty()||setNumero.isEmpty()||setBairro.isEmpty()||setTelefone.isEmpty()||setEmail.isEmpty()
                ||setCidade.isEmpty())
                { 

            request.setAttribute("erro", "Campo(s) vazio(s)");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/cadastroFisico.jsp");
            dispatcher.forward(request, response);
            return;
        }
        

        ClienteFisico cli = new ClienteFisico();
        cli.setCPF(cpf);

        cli.setNomeCompleto(request.getParameter("nomecompleto"));
        cli.setDataNasc(request.getParameter("datanasc"));
        cli.setSexo(request.getParameter("sexo"));
        cli.setNumeroCNH(request.getParameter("CNHNumber"));
        cli.setEnd(request.getParameter("endereco"));
        cli.setCEP(request.getParameter("cep"));
        cli.setUF(request.getParameter("UF"));
        cli.setNumero(request.getParameter("numerocasa"));
        cli.setComplemento(request.getParameter("complemento"));
        cli.setBairro(request.getParameter("bairro"));
        cli.setTelefone(request.getParameter("tel"));
        cli.setEmail(request.getParameter("email"));
        cli.setCidade(request.getParameter("cidade"));
        ClienteDao cliDao = new ClienteDao();
        try {
            cliDao.incluirComTransacao(cli);
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastraClienteFisico.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("sucess","Sucesso");
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/cadastroFisico.jsp");
        dispatcher.forward(request, response);

    }

}
