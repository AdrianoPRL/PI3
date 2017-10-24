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
        UserSistem user=new UserSistem();
        user.setUsuario(login);
        user.setNomeCompleto(nome);
        user.setHashSenha(senha);
        LoginDAO dao = new LoginDAO();
        dao.incluirComTransacao(user);
        
    }
}
