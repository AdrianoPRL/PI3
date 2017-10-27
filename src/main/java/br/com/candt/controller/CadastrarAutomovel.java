
package br.com.candt.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author Natalia
 */

@WebServlet(name = "CadastrarAutomovel", urlPatterns = {"/CadastroDeAutomovel"})
public class CadastrarAutomovel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/cadastroautomovel.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/cadastroautomovel.jsp");
        dispatcher.forward(request, response);
    }
}
