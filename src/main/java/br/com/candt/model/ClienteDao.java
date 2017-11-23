/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.model;

import static br.com.candt.model.BDConexao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class ClienteDao {

    public List<ClienteFisico> listar() {

        String query = "SELECT * FROM CLIENTEFISICO";
        List<ClienteFisico> lista = new ArrayList();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                ClienteFisico c = new ClienteFisico();
                c.setNomeCompleto(resultados.getString("NOMECOMPLETO"));
                c.setCPF(resultados.getString("CPF"));
                c.setDataNasc(resultados.getString("DATANASC"));
                c.setSexo(resultados.getString("SEXO"));
                c.setNumeroCnh(resultados.getString("CNH"));
                c.setEnd(resultados.getString("ENDEREÇO"));
                c.setCEP(resultados.getString("CEP"));
                c.setCidade(resultados.getString("CIDADE"));
                c.setUF(resultados.getString("UF"));
                c.setComplemento(resultados.getString("COMPLEMENTO"));
                c.setBairro(resultados.getString("BAIRRO"));
                c.setTelefone(resultados.getString("TELEFONE"));
                c.setEmail(resultados.getString("EMAIL"));
                c.setNumero(resultados.getString("NUMERO"));

                lista.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return lista;
    }

    public void incluirComTransacao(ClienteFisico cli) throws SQLException {
        String query = "INSERT INTO CLIENTEFISICO "
                + "(CPF,NOMECOMPLETO,DATANASC,SEXO,CNH,ENDEREÇO,UF,COMPLEMENTO,"
                + "BAIRRO,TELEFONE,EMAIL,CIDADE,NUMERO,CEP) "
                + "VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setString(1, cli.getCPF());
            stmt.setString(2, cli.getNomeCompleto());
            stmt.setString(3, cli.getDataNasc());
            stmt.setString(4, cli.getSexo());
            stmt.setString(5, cli.getNumeroCnh());
            stmt.setString(6, cli.getEnd());
            stmt.setString(7, cli.getUF());
            stmt.setString(8, cli.getComplemento());
            stmt.setString(9, cli.getBairro());
            stmt.setString(10, cli.getTelefone());
            stmt.setString(11, cli.getEmail());
            stmt.setString(12, cli.getCidade());
            stmt.setString(13, cli.getNumero());
            stmt.setString(14, cli.getCEP());
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

    public ClienteFisico procurar(String CPF) {
        String query = "SELECT * FROM CLIENTEFISICO "
                + "WHERE (CPF=?)";

        ClienteFisico c = null;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, CPF);

            try (ResultSet resultados = stmt.executeQuery()) {

                if (resultados.next()) {
                    c = new ClienteFisico();
                    c.setNomeCompleto(resultados.getString("NOMECOMPLETO"));
                    c.setCPF(resultados.getString("CPF"));
                    c.setDataNasc(resultados.getString("DATANASC"));
                    c.setSexo(resultados.getString("SEXO"));
                    c.setNumeroCnh(resultados.getString("CNH"));
                    c.setEnd(resultados.getString("ENDEREÇO"));
                    c.setCidade(resultados.getString("CIDADE"));
                    c.setCEP(resultados.getString("CEP"));
                    c.setUF(resultados.getString("UF"));
                    c.setComplemento(resultados.getString("COMPLEMENTO"));
                    c.setBairro(resultados.getString("BAIRRO"));
                    c.setTelefone(resultados.getString("TELEFONE"));
                    c.setEmail(resultados.getString("EMAIL"));
                    c.setNumero(resultados.getString("NUMERO"));

                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return c;
    }

//    public void excluir(String user) {
//        String sql = "DELETE FROM LOGIN WHERE (USUARIO=?)";
//        Connection connection = null;
//
//        try (Connection conn = getConnection();
//                PreparedStatement stmt = conn.prepareStatement(sql)) {;
//            stmt.setString(1, user);
//            stmt.execute();
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//    }

    public void Atualizar(ClienteFisico cli, String CPF) throws SQLException {
        String query = "UPDATE CLIENTEFISICO SET CPF=?,NOMECOMPLETO=?,DATANASC=?,SEXO=?,"
                + "CNH=?,ENDEREÇO=?,UF=?,COMPLEMENTO=?,"
                + "CEP=?,BAIRRO=?,TELEFONE=?,EMAIL=?,CIDADE=?,NUMERO=?"
                + "WHERE (CPF=?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setString(1, cli.getCPF());
            stmt.setString(2, cli.getNomeCompleto());
            stmt.setString(3, cli.getDataNasc());
            stmt.setString(4, cli.getSexo());
            stmt.setString(5, cli.getNumeroCnh());
            stmt.setString(6, cli.getEnd());
            stmt.setString(7, cli.getUF());
            stmt.setString(8, cli.getComplemento());
            stmt.setString(9, cli.getCEP());
            stmt.setString(10, cli.getBairro());
            stmt.setString(11, cli.getTelefone());
            stmt.setString(12, cli.getEmail());
            stmt.setString(13, cli.getCidade());
            stmt.setString(14, cli.getNumero());
            stmt.setString(15, CPF);
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
}
