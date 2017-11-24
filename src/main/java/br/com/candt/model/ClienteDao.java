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

        String query = "SELECT * FROM CLIENTEF";
        List<ClienteFisico> lista = new ArrayList();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                ClienteFisico c = new ClienteFisico();
                c.setCPF(resultados.getString("CPF"));
                c.setNomeCompleto(resultados.getString("NOME"));
                c.setSexo(resultados.getString("SEXO"));
                c.setTelefone(resultados.getString("TELEFONE"));
                c.setEmail(resultados.getString("EMAIL"));
                c.setNumeroCnh(resultados.getString("NUMEROCNH"));
                c.setEnd(resultados.getString("ENDERECO"));
                c.setComplemento(resultados.getString("COMPLEMENTO"));
                c.setNumero(resultados.getString("NUMERO"));
                c.setBairro(resultados.getString("BAIRRO"));
                c.setCEP(resultados.getString("CEP"));
                c.setCidade(resultados.getString("CIDADE"));
                c.setDataNasc(resultados.getString("DATANASCIMENTO"));
                c.setUF(resultados.getString("ESTADO"));

                lista.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return lista;
    }

    public void incluirComTransacao(ClienteFisico cli) throws SQLException {
        String query = "INSERT INTO CLIENTEF "
                + "(NOME,CPF,SEXO,TELEFONE,EMAIL,NUMEROCNH,ENDERECO,COMPLEMENTO,NUMERO,BAIRRO,CEP,"
                + "CIDADE,DATANASCIMENTO,ESTADO)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);

            stmt.setString(1, cli.getCPF());
            stmt.setString(2, cli.getNomeCompleto());
            stmt.setString(3, cli.getSexo());
            stmt.setString(4, cli.getTelefone());
            stmt.setString(5, cli.getEmail());

            stmt.setString(6, cli.getNumeroCnh());
            stmt.setString(7, cli.getEnd());
            stmt.setString(8, cli.getComplemento());
            stmt.setString(9, cli.getNumero());
            stmt.setString(10, cli.getBairro());
            stmt.setString(11, cli.getCEP());

            stmt.setString(12, cli.getCidade());

            stmt.setString(13, cli.getDataNasc());
            stmt.setString(14, cli.getUF());
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
        String query = "SELECT * FROM CLIENTEF "
                + "WHERE (CPF=?)";

        ClienteFisico c = null;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, CPF);

            try (ResultSet resultados = stmt.executeQuery()) {

                if (resultados.next()) {
                    c = new ClienteFisico();
                    c.setCPF(resultados.getString("CPF"));
                    c.setNomeCompleto(resultados.getString("NOME"));
                    c.setSexo(resultados.getString("SEXO"));
                    c.setTelefone(resultados.getString("TELEFONE"));
                    c.setEmail(resultados.getString("EMAIL"));
                    c.setNumeroCnh(resultados.getString("NUMEROCNH"));
                    c.setEnd(resultados.getString("ENDERECO"));
                    c.setComplemento(resultados.getString("COMPLEMENTO"));
                    c.setNumero(resultados.getString("NUMERO"));
                    c.setBairro(resultados.getString("BAIRRO"));
                    c.setCEP(resultados.getString("CEP"));
                    c.setCidade(resultados.getString("CIDADE"));
                    c.setDataNasc(resultados.getString("DATANASCIMENTO"));
                    c.setUF(resultados.getString("ESTADO"));
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
        String query = "UPDATE CLIENTEF SET CPF=?,NOME=?SEXO=?,TELEFONE=?,EMAIL=?"
                + "NUMEROCNH=?,ENDEREÇO=?,COMPLEMENTO=?,NUMERO=?,BAIRRO=?,CEP=?,CIDADE=?,"
                + "DATANASCIMENTO=?,ESTADO=?"
                + "WHERE (CPF=?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setString(1, cli.getCPF());
            stmt.setString(2, cli.getNomeCompleto());
            stmt.setString(3, cli.getSexo());
            stmt.setString(4, cli.getTelefone());
            stmt.setString(5, cli.getEmail());

            stmt.setString(6, cli.getNumeroCnh());
            stmt.setString(7, cli.getEnd());
            stmt.setString(8, cli.getComplemento());
            stmt.setString(9, cli.getNumero());
            stmt.setString(10, cli.getBairro());
            stmt.setString(11, cli.getCEP());

            stmt.setString(12, cli.getCidade());

            stmt.setString(13, cli.getDataNasc());
            stmt.setString(14, cli.getUF());
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
