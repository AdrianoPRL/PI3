
package br.com.candt.model;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(filterName = "Autorizacao", urlPatterns = {"/home", "/selecionarCliente", "/criarLogin"})
public class Autorizacao implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession sessao = httpRequest.getSession();
        if (sessao != null && sessao.getAttribute("usuario") != null) {

            String paginaAcessada = httpRequest.getRequestURI();
            String funcionalidade = paginaAcessada.replace(httpRequest.getContextPath(), "");

            UsuarioService service = new UsuarioService();
            UserSistem usuario = (UserSistem) sessao.getAttribute("usuario");
            if (service.usuarioAutorizado(usuario, funcionalidade)) {
                chain.doFilter(request, response);
            } else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro-nao-autorizado.jsp");
            }
        } else {

            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {

    }

}
