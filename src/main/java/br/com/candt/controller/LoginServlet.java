package br.com.candt.controller;

import br.com.candt.model.LoginDAO;
import br.com.candt.model.UserSistem;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        String login = request.getParameter("username");
        String senha = request.getParameter("password");

        LoginDAO dao = new LoginDAO();
        UserSistem usuario = dao.procurar(login, senha);

        if (usuario == null) {
            request.setAttribute("msgErro", "Erro no login");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
        } else {
            if (usuario.getTipoDeUser() != null) {

                if (usuario.getTipoDeUser().equalsIgnoreCase("admin")) {
//                    HttpSession sessao = request.getSession(true);
//                    sessao.setAttribute("username", usuario);
                    response.sendRedirect(request.getContextPath()
                            + "/home");
                } else if (usuario.getTipoDeUser().equalsIgnoreCase("gerente")) {
//                    HttpSession sessao = request.getSession(true);
//                    sessao.setAttribute("username", usuario);
                    response.sendRedirect(request.getContextPath()
                            + "/home");
                } else if (usuario.getTipoDeUser().equalsIgnoreCase("funcionario")) {
//                    HttpSession sessao = request.getSession(true);
//                    sessao.setAttribute("username", usuario);
                    response.sendRedirect(request.getContextPath()
                            + "/home");
                }
            } else {
                response.sendRedirect(request.getContextPath()
                        + "/login");
            }

        }
    }
}
