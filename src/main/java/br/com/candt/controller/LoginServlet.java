/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.candt.model.LoginDAO;

import br.com.candt.model.UserSistem;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        LoginDAO dao = new LoginDAO();
        UserSistem usuario = new UserSistem();
        String login = request.getParameter("usuario");
        usuario = dao.procurar(login);
    
        if (usuario.getTipoDeUser() != null) {
            HttpSession sessao = request.getSession(true);
            sessao.setAttribute("user", usuario);

            if ("ADMIN".equalsIgnoreCase(usuario.getTipoDeUser())) {
                request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp").forward(request, response);
            } else if ("GERENTE".equalsIgnoreCase(usuario.getTipoDeUser())) {
                request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp").forward(request, response);
            } else if ("FUNCIONARIO".equalsIgnoreCase(usuario.getTipoDeUser())) {
                request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp").forward(request, response);
        }
        
       
    }
    
}
