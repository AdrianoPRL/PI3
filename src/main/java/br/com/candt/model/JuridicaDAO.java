/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class JuridicaDAO {

    public void incluirComTransacao(VendaJuridica venda) throws SQLException {
        String query = "INSERT INTO VENDAJ "
                + "(CLIENTECNPJ,DATAENTREGA,DATADEVOLUCAO,VALORTOTAL,TARIFA,"
                + "SEGURO, SERVICO, AUTORENAVAM, FINALIZADA, FILIAL) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String query2 = "UPDATE AUTO "
                + "SET DISPONIVEL = ? "
                + "WHERE RENAVAM = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {

            con = BDConexao.getConnection();
            stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, venda.getCliente().getCNPJ());
            Timestamp t = new Timestamp(venda.getDatadeEntrega().getTime());
            stmt.setTimestamp(2, t);
            Timestamp t1 = new Timestamp(venda.getDataDeDevolucao().getTime());
            stmt.setTimestamp(3, t1);
            stmt.setDouble(4, venda.getValorTotal());
            stmt.setDouble(5, venda.getTarifa());
            stmt.setBoolean(6, venda.getSeguro());
            stmt.setString(7, venda.getServico());
            stmt.setString(8, venda.getAuto().getRenavam());
            stmt.setBoolean(9, venda.getFinalizada());
            stmt.setInt(10, venda.getFilial().getId());
            stmt.execute();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idNovo = generatedKeys.getInt(1);
                    venda.setId(idNovo);
                }
            }
            stmt = con.prepareStatement(query2);
            stmt.setBoolean(1, false);
            stmt.setString(2, venda.getAuto().getRenavam());
            stmt.execute();
            
        } catch (SQLException e) {

        } finally {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();

            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    
    public List<VendaJuridica> Relatorio(Date dataProcuraincio, Date dataProcuraFim) throws SQLException {

        String query = "SELECT * FROM VENDAJ WHERE DATAENTREGA BETWEEN ? AND ? ";
        String sql2 = "SELECT * FROM CLIENTEJ WHERE CNPJ = ?";
        String sql3 = "SELECT * FROM AUTO WHERE RENAVAM = ?";
        String sql4 = "SELECT * FROM FILIAIS WHERE ID = ?";
        
        List<VendaJuridica> relatorio = null;

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet resultV = null;
        ResultSet resultC = null;
        ResultSet resultP = null;
        ResultSet resultF = null;
        System.out.println("LINHA119");
        try {
            con = BDConexao.getConnection();
            stmt = con.prepareStatement(query);
            Timestamp t1 = new Timestamp(dataProcuraincio.getTime());
            stmt.setTimestamp(1, t1);
            Timestamp t2 = new Timestamp(dataProcuraFim.getTime());
            stmt.setTimestamp(2, t2);

            resultV = stmt.executeQuery();
            System.out.println("LINHA129S");
            while (resultV.next()) {
                if (relatorio == null) {
                    System.out.println("LINHA131");
                    relatorio = new ArrayList();
                }
                ClienteJuridico c = new ClienteJuridico();
                System.out.println("LINHA134");
                VendaJuridica venda = new VendaJuridica();
                venda.setId(resultV.getInt("ID"));

                Date d = new Date(resultV.getTimestamp("DATAENTREGA").getTime());
                Date E = new Date(resultV.getTimestamp("DATADEVOLUCAO").getTime());
                venda.setDataDeDevolucao(d);
                venda.setDatadeEntrega(E);
                venda.setValorTotal(resultV.getDouble("VALORTOTAL"));
                venda.setTarifa(resultV.getDouble("TARIFA"));
                venda.setSeguro(resultV.getBoolean("SEGURO"));
                venda.setServico(resultV.getString("SERVICO"));
                String idC = (resultV.getString("CLIENTECNPJ"));
                System.out.println("148" + idC);
                stmt = con.prepareStatement(sql2);
                stmt.setString(1, idC);
                resultC = stmt.executeQuery();
                while (resultC.next()) {
                    c.setRazaoSocial(resultC.getString("RAZAOSOCIAL"));
                    c.setNomeFantasia(resultC.getString("NOMEFANTASIA"));
                    c.setCNPJ(resultC.getString("CNPJ"));
                    c.setEnd(resultC.getString("ENDERECO"));
                    c.setUF(resultC.getString("UF"));
                    c.setCidade(resultC.getString("CIDADE"));
                    c.setComplemento(resultC.getString("COMPLEMENTO"));
                    c.setBairro(resultC.getString("BAIRRO"));
                    c.setTelefone(resultC.getString("TELEFONE"));
                    c.setEmail(resultC.getString("EMAIL"));
                    c.setNumero(resultC.getString("NUMERO"));
                    c.setCEP(resultC.getString("CEP"));
                    c.setInscricaoEstadual(resultC.getString("INSCRICAOESTADUAL"));
                }
                venda.setCliente(c);
                venda.setFinalizada(resultV.getBoolean("FINALIZADA"));

                stmt = con.prepareStatement(sql3);
                String renavam = resultV.getString("AUTORENAVAM");
                stmt.setString(1, renavam);
                resultP = stmt.executeQuery();

                while (resultP.next()) {
                    Automovel auto = new Automovel();
                    auto.setMarca(resultP.getString("MARCA"));
                    auto.setModelo(resultP.getString("MODELO"));
                    auto.setAno(resultP.getString("ANO"));
                    auto.setCategoria(resultP.getString("CATEGORIA"));
                    auto.setPlaca(resultP.getString("PLACA"));
                    auto.setRenavam(resultP.getString("RENAVAM"));
                    auto.setKilometragem(resultP.getString("KILOMETRAGEM"));
                    auto.setNumeroChassi(resultP.getString("NUMEROCHASSI"));
                    auto.setCor(resultP.getString("COR"));
                    auto.setPortas(resultP.getString("PORTAS"));
                    auto.setCombustivel(resultP.getString("COMBUSTIVEL"));
                    auto.setDescricao(resultP.getString("DESCRICAO"));
                    auto.setValorDeLocacao(resultP.getDouble("VALORDELOCACAO"));
                    System.out.println("AUTO LINHA 200" + auto.getRenavam());
                    venda.setAuto(auto);
                }
                stmt = con.prepareStatement(sql4);
                Integer idF = resultV.getInt("FILIAL");
                stmt.setInt(1, idF);
                resultF = stmt.executeQuery();
                
                while(resultF.next()){
                    Filial fil = new Filial();
                    fil.setId(resultF.getInt("ID"));
                    fil.setNome(resultF.getString("NOME"));
                    fil.setLocal(resultF.getString("LOCAL"));
                    venda.setFilial(fil);
                }
                relatorio.add(venda);
            }

        } catch (SQLException e) {

        } finally {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
        return relatorio;
    }
    
    public List<VendaJuridica> listarAbertas()  {
        String sql = "SELECT * FROM VENDAJ WHERE FINALIZADA = ?";
        String sql2 = "SELECT * FROM CLIENTEJ WHERE CNPJ = ?";
        String sql3 = "SELECT * FROM AUTO WHERE RENAVAM = ?";
        String sql4 = "SELECT * FROM FILIAIS WHERE ID = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        List<VendaJuridica> lista = new ArrayList<>();
        ResultSet resultV = null;
        ResultSet resultC = null;
        ResultSet resultP = null;
        ResultSet resultF = null;
        try {
            con = BDConexao.getConnection();
            stmt = con.prepareStatement(sql);

            stmt.setBoolean(1, false);
            resultV = stmt.executeQuery();
            System.out.println("LINHA129S");
            while (resultV.next()) {
                if (lista == null) {
                    System.out.println("LINHA131");
                    lista = new ArrayList();
                }
                ClienteJuridico c = new ClienteJuridico();
                System.out.println("LINHA134");
                VendaJuridica venda = new VendaJuridica();
                venda.setId(resultV.getInt("ID"));

                Date d = new Date(resultV.getTimestamp("DATAENTREGA").getTime());
                Date E = new Date(resultV.getTimestamp("DATADEVOLUCAO").getTime());
                venda.setDataDeDevolucao(d);
                venda.setDatadeEntrega(E);
                venda.setValorTotal(resultV.getDouble("VALORTOTAL"));
                venda.setTarifa(resultV.getDouble("TARIFA"));
                venda.setSeguro(resultV.getBoolean("SEGURO"));
                venda.setServico(resultV.getString("SERVICO"));
                String idC = (resultV.getString("CLIENTECNPJ"));
                System.out.println("148" + idC);
                stmt = con.prepareStatement(sql2);
                stmt.setString(1, idC);
                resultC = stmt.executeQuery();
                while (resultC.next()) {
                    c.setRazaoSocial(resultC.getString("RAZAOSOCIAL"));
                    c.setNomeFantasia(resultC.getString("NOMEFANTASIA"));
                    c.setCNPJ(resultC.getString("CNPJ"));
                    c.setEnd(resultC.getString("ENDERECO"));
                    c.setUF(resultC.getString("UF"));
                    c.setCidade(resultC.getString("CIDADE"));
                    c.setComplemento(resultC.getString("COMPLEMENTO"));
                    c.setBairro(resultC.getString("BAIRRO"));
                    c.setTelefone(resultC.getString("TELEFONE"));
                    c.setEmail(resultC.getString("EMAIL"));
                    c.setNumero(resultC.getString("NUMERO"));
                    c.setCEP(resultC.getString("CEP"));
                    c.setInscricaoEstadual(resultC.getString("INSCRICAOESTADUAL"));
                }
                venda.setCliente(c);
                venda.setFinalizada(resultV.getBoolean("FINALIZADA"));

                stmt = con.prepareStatement(sql3);
                String renavam = resultV.getString("AUTORENAVAM");
                stmt.setString(1, renavam);
                resultP = stmt.executeQuery();

                while (resultP.next()) {
                    Automovel auto = new Automovel();
                    auto.setMarca(resultP.getString("MARCA"));
                    auto.setModelo(resultP.getString("MODELO"));
                    auto.setAno(resultP.getString("ANO"));
                    auto.setCategoria(resultP.getString("CATEGORIA"));
                    auto.setPlaca(resultP.getString("PLACA"));
                    auto.setRenavam(resultP.getString("RENAVAM"));
                    auto.setKilometragem(resultP.getString("KILOMETRAGEM"));
                    auto.setNumeroChassi(resultP.getString("NUMEROCHASSI"));
                    auto.setCor(resultP.getString("COR"));
                    auto.setPortas(resultP.getString("PORTAS"));
                    auto.setCombustivel(resultP.getString("COMBUSTIVEL"));
                    auto.setDescricao(resultP.getString("DESCRICAO"));
                    auto.setValorDeLocacao(resultP.getDouble("VALORDELOCACAO"));
                    System.out.println("AUTO LINHA 200" + auto.getRenavam());
                    venda.setAuto(auto);
                }
                stmt = con.prepareStatement(sql4);
                Integer idF = resultV.getInt("FILIAL");
                stmt.setInt(1, idF);
                resultF = stmt.executeQuery();
                
                while(resultF.next()){
                    Filial fil = new Filial();
                    fil.setId(resultF.getInt("ID"));
                    fil.setNome(resultF.getString("NOME"));
                    fil.setLocal(resultF.getString("LOCAL"));
                    venda.setFilial(fil);
                }
                lista.add(venda);
            }
        } catch (SQLException e) {

        } 
        return lista;
    }

    public void finalizarVendaJ(Integer id)   {
        String query = "UPDATE VENDAJ SET FINALIZADA = ? WHERE ID = ?";

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = BDConexao.getConnection();
            stmt = con.prepareStatement(query);

            stmt.setBoolean(1, true);
            stmt.setInt(2, id);
            stmt.execute();
            
        } catch (SQLException e) {

        } 
    }
    
    public List<VendaJuridica> listarAbertasCNPJ(String CNPJ) throws SQLException {
        String sql = "SELECT * FROM VENDAJ WHERE FINALIZADA = ? AND CLIENTECNPJ LIKE ?";
        String sql2 = "SELECT * FROM CLIENTEJ WHERE CNPJ = ?";
        String sql3 = "SELECT * FROM AUTO WHERE RENAVAM = ?";
        String sql4 = "SELECT * FROM FILIAIS WHERE ID = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        List<VendaJuridica> lista = new ArrayList<>();
        ResultSet resultV = null;
        ResultSet resultC = null;
        ResultSet resultP = null;
        ResultSet resultF = null;
        try {
            con = BDConexao.getConnection();
            stmt = con.prepareStatement(sql);
            
            stmt.setBoolean(1, false);
            stmt.setString(2, "%"+CNPJ+"%");
            resultV = stmt.executeQuery();
            System.out.println("LINHA129S");
            while (resultV.next()) {
                if (lista == null) {
                    System.out.println("LINHA131");
                    lista = new ArrayList();
                }
                ClienteJuridico c = new ClienteJuridico();
                System.out.println("LINHA134");
                VendaJuridica venda = new VendaJuridica();
                venda.setId(resultV.getInt("ID"));

                Date d = new Date(resultV.getTimestamp("DATAENTREGA").getTime());
                Date E = new Date(resultV.getTimestamp("DATADEVOLUCAO").getTime());
                venda.setDataDeDevolucao(d);
                venda.setDatadeEntrega(E);
                venda.setValorTotal(resultV.getDouble("VALORTOTAL"));
                venda.setTarifa(resultV.getDouble("TARIFA"));
                venda.setSeguro(resultV.getBoolean("SEGURO"));
                venda.setServico(resultV.getString("SERVICO"));
                String idC = (resultV.getString("CLIENTECNPJ"));
                System.out.println("148" + idC);
                stmt = con.prepareStatement(sql2);
                stmt.setString(1, idC);
                resultC = stmt.executeQuery();
                while (resultC.next()) {
                    c.setRazaoSocial(resultC.getString("RAZAOSOCIAL"));
                    c.setNomeFantasia(resultC.getString("NOMEFANTASIA"));
                    c.setCNPJ(resultC.getString("CNPJ"));
                    c.setEnd(resultC.getString("ENDERECO"));
                    c.setUF(resultC.getString("UF"));
                    c.setCidade(resultC.getString("CIDADE"));
                    c.setComplemento(resultC.getString("COMPLEMENTO"));
                    c.setBairro(resultC.getString("BAIRRO"));
                    c.setTelefone(resultC.getString("TELEFONE"));
                    c.setEmail(resultC.getString("EMAIL"));
                    c.setNumero(resultC.getString("NUMERO"));
                    c.setCEP(resultC.getString("CEP"));
                    c.setInscricaoEstadual(resultC.getString("INSCRICAOESTADUAL"));
                }
                venda.setCliente(c);
                venda.setFinalizada(resultV.getBoolean("FINALIZADA"));

                stmt = con.prepareStatement(sql3);
                String renavam = resultV.getString("AUTORENAVAM");
                stmt.setString(1, renavam);
                resultP = stmt.executeQuery();

                while (resultP.next()) {
                    Automovel auto = new Automovel();
                    auto.setMarca(resultP.getString("MARCA"));
                    auto.setModelo(resultP.getString("MODELO"));
                    auto.setAno(resultP.getString("ANO"));
                    auto.setCategoria(resultP.getString("CATEGORIA"));
                    auto.setPlaca(resultP.getString("PLACA"));
                    auto.setRenavam(resultP.getString("RENAVAM"));
                    auto.setKilometragem(resultP.getString("KILOMETRAGEM"));
                    auto.setNumeroChassi(resultP.getString("NUMEROCHASSI"));
                    auto.setCor(resultP.getString("COR"));
                    auto.setPortas(resultP.getString("PORTAS"));
                    auto.setCombustivel(resultP.getString("COMBUSTIVEL"));
                    auto.setDescricao(resultP.getString("DESCRICAO"));
                    auto.setValorDeLocacao(resultP.getDouble("VALORDELOCACAO"));
                    System.out.println("AUTO LINHA 200" + auto.getRenavam());
                    venda.setAuto(auto);
                }
                stmt = con.prepareStatement(sql4);
                Integer idF = resultV.getInt("FILIAL");
                stmt.setInt(1, idF);
                resultF = stmt.executeQuery();
                
                while(resultF.next()){
                    Filial fil = new Filial();
                    fil.setId(resultF.getInt("ID"));
                    fil.setNome(resultF.getString("NOME"));
                    fil.setLocal(resultF.getString("LOCAL"));
                    venda.setFilial(fil);
                }
                lista.add(venda);
            }
        } catch (SQLException e) {

        } finally {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();

            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
        return lista;
    }
}
