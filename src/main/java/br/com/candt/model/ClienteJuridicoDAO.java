/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.model;

import br.com.candt.model.BDConexao;
import static br.com.candt.model.BDConexao.getConnection;
import br.com.candt.model.ClienteJuridico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteJuridicoDAO {

    public void incluirComTransacao(ClienteJuridico cli) throws SQLException {
        String query = "INSERT INTO CLIENTEJ "
                + "(RAZAOSOCIAL,NOMEFANTASIA,CNPJ,ENDERECO,UF,CIDADE,COMPLEMENTO,BAIRRO,"
                + "TELEFONE,EMAIL,NUMERO,CEP,INSCRICAOESTADUAL, DISABLED) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setString(1, cli.getRazaoSocial());
            stmt.setString(2, cli.getNomeFantasia());
            stmt.setString(3, cli.getCNPJ());
            stmt.setString(4, cli.getEnd());
            stmt.setString(5, cli.getUF());
            stmt.setString(6, cli.getCidade());
            stmt.setString(7, cli.getComplemento());
            stmt.setString(8, cli.getBairro());
            stmt.setString(9, cli.getTelefone());
            stmt.setString(10, cli.getEmail());
            stmt.setString(11, cli.getNumero());
            stmt.setString(12, cli.getCEP());
            stmt.setString(13, cli.getInscricaoEstadual());
            stmt.setBoolean(14, false);
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

    public ClienteJuridico buscar(String Cnpj) {

        String query = "SELECT * FROM CLIENTEJ"
                + " WHERE (CNPJ=?) AND DISABLED = ?";
        ClienteJuridico cj = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setString(1, Cnpj);
            stmt.setBoolean(2, false);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                cj = new ClienteJuridico();
                cj.setRazaoSocial(resultados.getString("RAZAOSOCIAL"));
                cj.setNomeFantasia(resultados.getString("NOMEFANTASIA"));
                cj.setCNPJ(resultados.getString("CNPJ"));
                cj.setEnd(resultados.getString("ENDERECO"));
                cj.setUF(resultados.getString("UF"));
                cj.setCidade(resultados.getString("CIDADE"));
                cj.setComplemento(resultados.getString("COMPLEMENTO"));
                cj.setBairro(resultados.getString("BAIRRO"));
                cj.setTelefone(resultados.getString("TELEFONE"));
                cj.setEmail(resultados.getString("EMAIL"));
                cj.setNumero(resultados.getString("NUMERO"));
                cj.setCEP(resultados.getString("CEP"));
                cj.setInscricaoEstadual(resultados.getString("INSCRICAOESTADUAL"));
                cj.setDisabled(resultados.getBoolean("DISABLED"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return cj;
    }

    public void Atualizar(ClienteJuridico cli, String CNPJ) throws SQLException {
        String query = "UPDATE CLIENTEJ SET RAZAOSOCIAL=?,NOMEFANTASIA=?,ENDERECO=?,"
                + "UF=?,CIDADE=?,COMPLEMENTO=?,BAIRRO=?,TELEFONE=?,EMAIL=?,NUMERO=?,CEP=?,"
                + "INSCRICAOESTADUAL=?, DISABLED=?"
                + "WHERE (CNPJ=?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, cli.getRazaoSocial());
            stmt.setString(2, cli.getNomeFantasia());
            stmt.setString(3, cli.getEnd());
            stmt.setString(4, cli.getUF());
            stmt.setString(5, cli.getCidade());
            stmt.setString(6, cli.getComplemento());
            stmt.setString(7, cli.getBairro());
            stmt.setString(8, cli.getTelefone());
            stmt.setString(9, cli.getEmail());
            stmt.setString(10, cli.getNumero());
            stmt.setString(11, cli.getCEP());
            stmt.setString(12, cli.getInscricaoEstadual());
            stmt.setBoolean(13, false);
            stmt.setString(14, CNPJ);
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

    public void excluir(String cnpj) {
        String sql = "UPDATE CLIENTEJ SET DISABLED = ? WHERE (CNPJ=?)";
        Connection connection = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, true);
            stmt.setString(2, cnpj);
            stmt.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<ClienteJuridico> listar() {

        String query = "SELECT * FROM CLIENTEJ WHERE DISABLED = ?";
        List<ClienteJuridico> lista = new ArrayList();
        ClienteJuridico cj = new ClienteJuridico();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setBoolean(1, false);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                cj = new ClienteJuridico();
                cj.setRazaoSocial(resultados.getString("RAZAOSOCIAL"));
                cj.setNomeFantasia(resultados.getString("NOMEFANTASIA"));
                cj.setCNPJ(resultados.getString("CNPJ"));
                cj.setEnd(resultados.getString("ENDERECO"));
                cj.setUF(resultados.getString("UF"));
                cj.setCidade(resultados.getString("CIDADE"));
                cj.setComplemento(resultados.getString("COMPLEMENTO"));
                cj.setBairro(resultados.getString("BAIRRO"));
                cj.setTelefone(resultados.getString("TELEFONE"));
                cj.setEmail(resultados.getString("EMAIL"));
                cj.setNumero(resultados.getString("NUMERO"));
                cj.setCEP(resultados.getString("CEP"));
                cj.setInscricaoEstadual(resultados.getString("INSCRICAOESTADUAL"));
                cj.setDisabled(resultados.getBoolean("DISABLED"));

                lista.add(cj);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return lista;
    }

    public List<ClienteJuridico> procurarEspecial(String CNPJ) {
        String query = "SELECT * FROM CLIENTEJ "
                + "WHERE (CNPJ LIKE ?) AND DISABLED = ?";
        List<ClienteJuridico> lista = new ArrayList<>();
        ClienteJuridico cj = null;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "%" + CNPJ + "%");
            stmt.setBoolean(2, false);

            try (ResultSet resultados = stmt.executeQuery()) {

                while (resultados.next()) {
                    cj = new ClienteJuridico();
                    cj.setRazaoSocial(resultados.getString("RAZAOSOCIAL"));
                    cj.setNomeFantasia(resultados.getString("NOMEFANTASIA"));
                    cj.setCNPJ(resultados.getString("CNPJ"));
                    cj.setEnd(resultados.getString("ENDERECO"));
                    cj.setUF(resultados.getString("UF"));
                    cj.setCidade(resultados.getString("CIDADE"));
                    cj.setComplemento(resultados.getString("COMPLEMENTO"));
                    cj.setBairro(resultados.getString("BAIRRO"));
                    cj.setTelefone(resultados.getString("TELEFONE"));
                    cj.setEmail(resultados.getString("EMAIL"));
                    cj.setNumero(resultados.getString("NUMERO"));
                    cj.setCEP(resultados.getString("CEP"));
                    cj.setInscricaoEstadual(resultados.getString("INSCRICAOESTADUAL"));
                    cj.setDisabled(resultados.getBoolean("DISABLED"));

                    lista.add(cj);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return lista;
    }
}
