/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.LoginDAO;

import br.com.candt.model.UserSistem;
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "NewLoginServlet", urlPatterns = {"/criarLogin"})
public class NewLoginServlet extends HttpServlet {
@Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
             RequestDispatcher dispatcher
	    = request.getRequestDispatcher("/WEB-INF/jsp/criarLogin.jsp");
    dispatcher.forward(request, response);
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        String login = request.getParameter("username");
        String senha = request.getParameter("password");
        String nome = request.getParameter("nome");
        String opcao=request.getParameter("tipodeuser");
        if(login.isEmpty()||senha.isEmpty()||nome.isEmpty()||opcao.isEmpty()){
         request.setAttribute("msgErro", "Erro no login");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/criarLogin.jsp");
            dispatcher.forward(request, response);
        }
        UserSistem user=new UserSistem();
        user.setUsuario(login);
        user.setNomeCompleto(nome);
        user.setHashSenha(senha);
        user.setTipoDeUser(opcao);
        LoginDAO dao = new LoginDAO(); 
         HttpSession sessao = request.getSession(true);
         
            sessao.setAttribute("opcao", opcao);
         response.sendRedirect(request.getContextPath() + "/criarLogin");
        
    try {
        dao.incluirComTransacao(user);
    } catch (SQLException ex) {
        Logger.getLogger(NewLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
}

