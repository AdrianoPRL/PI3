
 
package br.com.candt.controller;

import br.com.candt.model.Automovel;
import br.com.candt.model.AutomovelDAO;
import br.com.candt.model.ClienteDao;
import br.com.candt.model.ClienteFisico;
import br.com.candt.model.Filial;
import br.com.candt.model.FilialDAO;
import br.com.candt.model.VendaFisica;
import br.com.candt.model.VendaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

@WebServlet(name = "concluirVenda", urlPatterns = {"/venda"})
public class concluirVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/concluirVenda.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          HttpSession sessao = request.getSession(true);
        FilialDAO filiDao=new FilialDAO();
        List<Filial> fili= new ArrayList<>();
        fili.addAll(filiDao.listarFiliais());
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date E=new Date();
        Date D=new Date();
        String DataEntrega=(request.getParameter("dataE"));
        String dataDevolucao=(request.getParameter("dataD"));
        try {
            E=simpleDateFormat.parse(DataEntrega);
            D=simpleDateFormat.parse(dataDevolucao);
        } catch (ParseException ex) {
            Logger.getLogger(concluirVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        Automovel auto = new Automovel();
        AutomovelDAO dao = new AutomovelDAO();
        String renavam=(request.getParameter("auto"));
        auto = dao.procurar(renavam);
        ClienteDao clidao=new ClienteDao();
        ClienteFisico cli=new ClienteFisico();
        String total = (request.getParameter("total"));
        String tarifa = (request.getParameter("tarifa"));
        String cpf=(request.getParameter("cli"));
        cli=clidao.procurar(cpf);
        
        VendaFisica v = new VendaFisica();
        VendaDAO d = new VendaDAO();
        v.setCliente(cli);
        v.setDataDeDevolucao(D);
        v.setDatadeEntrega(E);
        v.setServico(request.getParameter("Servico"));
        String seg = (request.getParameter("seguro"));
        v.setSeguro(Boolean.parseBoolean(seg));
        v.setValorTotal(Double.parseDouble(total));
        v.setAuto(auto);
        v.setTarifa(Double.parseDouble(tarifa));
        String filia = (request.getParameter("filial"));
        System.out.println("aaa"+filia);
        Filial filial = new Filial();
        filial = filiDao.getFilial(Integer.parseInt(filia));
        v.setFilial(filial);
        try {
            d.incluirComTransacao(v);
//            d.itensDeVenda(v);
        } catch (SQLException ex) {
            Logger.getLogger(concluirVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect(request.getContextPath() + "/selecionarCliente");
    }
}
