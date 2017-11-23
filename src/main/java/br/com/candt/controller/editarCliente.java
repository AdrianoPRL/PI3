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
import java.util.ArrayList;
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


@WebServlet(name = "editarCliente", urlPatterns = {"/editarCliente"})
public class editarCliente extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/editarCliente.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     String cpf = request.getParameter("cpf");
          String Atualcpf = request.getParameter("atualCPF");
         if (cpf.isEmpty()) {
            request.setAttribute("msgErro", "campo não pode ser vazio");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/editarCliente.jsp");
            dispatcher.forward(request, response);
         }
        ClienteFisico cli = new ClienteFisico();
        cli.setCPF(cpf);
        cli.setNomeCompleto(request.getParameter("nomecompleto"));
        cli.setDataNasc(request.getParameter("dateofbirth"));
        cli.setSexo(request.getParameter("sexo"));
        cli.setNumeroCnh(request.getParameter("CNHNumber"));
        cli.setEnd(request.getParameter("address"));
        cli.setUF(request.getParameter("UF"));
        cli.setNumero(request.getParameter("numerocasa"));
        cli.setComplemento(request.getParameter("complemento"));
        cli.setBairro(request.getParameter("bairro"));
        cli.setTelefone(request.getParameter("tel"));
        cli.setEmail(request.getParameter("email"));
          cli.setCidade(request.getParameter("cidade"));
        ClienteDao cliDao= new ClienteDao(); 
        try {
            cliDao.Atualizar(cli,Atualcpf);
        } catch (SQLException ex) {
            Logger.getLogger(CadastraClienteFisico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
