/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.controller;

import br.com.candt.model.Automovel;
import br.com.candt.model.AutomovelDAO;
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

/**
 *
 * @author Phantom
 */
@WebServlet(name = "editarAuto", urlPatterns = {"/editarAuto"})
public class editarAuto extends HttpServlet {

       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/editarAutomovel.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Automovel auto = new Automovel();
        AutomovelDAO dao = new AutomovelDAO();
        auto.setMarca(request.getParameter("marca"));
        auto.setModelo(request.getParameter("model"));
        auto.setAno(request.getParameter("anoAuto"));
        auto.setPlaca(request.getParameter("placa"));
        auto.setCategoria(request.getParameter("categoria"));
        auto.setRenavam(request.getParameter("renavam"));
        auto.setNumeroChassi(request.getParameter("nchassi"));
        auto.setCor(request.getParameter("cor"));
        auto.setPortas(request.getParameter("portas"));
        auto.setCombusitvel(request.getParameter("combustivel"));
        auto.setKilometragem(request.getParameter("KMs"));
        auto.setDescrição(request.getParameter("desc"));
        String atualRenavam=(request.getParameter("atualRenavam"));
           try {
               dao.Atualizar(auto,atualRenavam);
           } catch (SQLException ex) {
               Logger.getLogger(editarAuto.class.getName()).log(Level.SEVERE, null, ex);
           }
        
        response.sendRedirect(request.getContextPath() + "/consultarAutomovel");
    }
    
}

