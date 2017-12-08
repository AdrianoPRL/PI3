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

    public List<Cliente> listarTodos() {

        String query = "SELECT * FROM CLIENTEF WHERE DISABLED = ?";
        List<Cliente> lista = new ArrayList();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet resultados = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setBoolean(1, false);
            resultados = stmt.executeQuery();
            
            while (resultados.next()) {
                ClienteFisico c = new ClienteFisico();
                c.setCPF(resultados.getString("CPF"));
                c.setNomeCompleto(resultados.getString("NOME"));
                c.setSexo(resultados.getString("SEXO"));
                c.setTelefone(resultados.getString("TELEFONE"));
                c.setEmail(resultados.getString("EMAIL"));
                c.setNumeroCNH(resultados.getString("NUMEROCNH"));
                c.setEnd(resultados.getString("ENDERECO"));
                c.setComplemento(resultados.getString("COMPLEMENTO"));
                c.setNumero(resultados.getString("NUMERO"));
                c.setBairro(resultados.getString("BAIRRO"));
                c.setCEP(resultados.getString("CEP"));
                c.setCidade(resultados.getString("CIDADE"));
                c.setDataNasc(resultados.getString("DATANASCIMENTO"));
                c.setUF(resultados.getString("ESTADO"));
                c.setDisabled(resultados.getBoolean("DISABLED"));
                
                lista.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        String queryJ = "SELECT * FROM CLIENTEJ WHERE DISABLED = ?";
        con = null;
        stmt = null;
        resultados = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(queryJ);
            stmt.setBoolean(1, false);
            resultados = stmt.executeQuery();

            while (resultados.next()) {
                ClienteJuridico cj = new ClienteJuridico();
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

    public List<ClienteFisico> listar() {

        String query = "SELECT * FROM CLIENTEF WHERE DISABLED = ?";
        List<ClienteFisico> lista = new ArrayList();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setBoolean(1, false);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                ClienteFisico c = new ClienteFisico();
                c.setCPF(resultados.getString("CPF"));
                c.setNomeCompleto(resultados.getString("NOME"));
                c.setSexo(resultados.getString("SEXO"));
                c.setTelefone(resultados.getString("TELEFONE"));
                c.setEmail(resultados.getString("EMAIL"));
                c.setNumeroCNH(resultados.getString("NUMEROCNH"));
                c.setEnd(resultados.getString("ENDERECO"));
                c.setComplemento(resultados.getString("COMPLEMENTO"));
                c.setNumero(resultados.getString("NUMERO"));
                c.setBairro(resultados.getString("BAIRRO"));
                c.setCEP(resultados.getString("CEP"));
                c.setCidade(resultados.getString("CIDADE"));
                c.setDataNasc(resultados.getString("DATANASCIMENTO"));
                c.setUF(resultados.getString("ESTADO"));
                c.setDisabled(resultados.getBoolean("DISABLED"));

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
                + "CIDADE,DATANASCIMENTO,ESTADO, DISABLED) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);

            stmt.setString(1, cli.getNomeCompleto());
            stmt.setString(2, cli.getCPF());
            stmt.setString(3, cli.getSexo());
            stmt.setString(4, cli.getTelefone());
            stmt.setString(5, cli.getEmail());
            stmt.setString(6, cli.getNumeroCNH());
            stmt.setString(7, cli.getEnd());
            stmt.setString(8, cli.getComplemento());
            stmt.setString(9, cli.getNumero());
            stmt.setString(10, cli.getBairro());
            stmt.setString(11, cli.getCEP());
            stmt.setString(12, cli.getCidade());
            stmt.setString(13, cli.getDataNasc());
            stmt.setString(14, cli.getUF());
            stmt.setBoolean(15, false);
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
                + "WHERE (CPF=?) AND DISABLED = ?";

        ClienteFisico c = null;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, CPF);
            stmt.setBoolean(2, false);
            
            try (ResultSet resultados = stmt.executeQuery()) {

                if (resultados.next()) {
                    c = new ClienteFisico();
                    c.setCPF(resultados.getString("CPF"));
                    c.setNomeCompleto(resultados.getString("NOME"));
                    c.setSexo(resultados.getString("SEXO"));
                    c.setTelefone(resultados.getString("TELEFONE"));
                    c.setEmail(resultados.getString("EMAIL"));
                    c.setNumeroCNH(resultados.getString("NUMEROCNH"));
                    c.setEnd(resultados.getString("ENDERECO"));
                    c.setComplemento(resultados.getString("COMPLEMENTO"));
                    c.setNumero(resultados.getString("NUMERO"));
                    c.setBairro(resultados.getString("BAIRRO"));
                    c.setCEP(resultados.getString("CEP"));
                    c.setCidade(resultados.getString("CIDADE"));
                    c.setDataNasc(resultados.getString("DATANASCIMENTO"));
                    c.setUF(resultados.getString("ESTADO"));
                    c.setDisabled(resultados.getBoolean("DISABLED"));
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return c;
    }
    
     public List<ClienteFisico> procurarEspecial(String CPF) {
        String query = "SELECT * FROM CLIENTEF "
                + "WHERE (CPF LIKE ?) AND DISABLED = ?";
        List<ClienteFisico> lista = new ArrayList<>();
        ClienteFisico c = null;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "%"+CPF+"%");
            stmt.setBoolean(2, false);

            try (ResultSet resultados = stmt.executeQuery()) {

                while (resultados.next()) {
                    c = new ClienteFisico();
                    c.setCPF(resultados.getString("CPF"));
                    c.setNomeCompleto(resultados.getString("NOME"));
                    c.setSexo(resultados.getString("SEXO"));
                    c.setTelefone(resultados.getString("TELEFONE"));
                    c.setEmail(resultados.getString("EMAIL"));
                    c.setNumeroCNH(resultados.getString("NUMEROCNH"));
                    c.setEnd(resultados.getString("ENDERECO"));
                    c.setComplemento(resultados.getString("COMPLEMENTO"));
                    c.setNumero(resultados.getString("NUMERO"));
                    c.setBairro(resultados.getString("BAIRRO"));
                    c.setCEP(resultados.getString("CEP"));
                    c.setCidade(resultados.getString("CIDADE"));
                    c.setDataNasc(resultados.getString("DATANASCIMENTO"));
                    c.setUF(resultados.getString("ESTADO"));
                    c.setDisabled(resultados.getBoolean("DISABLED"));
                    lista.add(c);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return lista;
    }
    
    public void excluir(String cpf) {
        String sql = "UPDATE CLIENTEF SET DISABLED = ? WHERE (CPF=?)";
        Connection connection = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, true);
            stmt.setString(2, cpf);
            stmt.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void Atualizar(ClienteFisico cli, String CPF) throws SQLException {
        String query = "UPDATE CLIENTEF SET NOME=?,SEXO=?,TELEFONE=?,EMAIL=?, "
                + "NUMEROCNH=?,ENDERECO=?,COMPLEMENTO=?,NUMERO=?,BAIRRO=?,CEP=?,CIDADE=?, "
                + "DATANASCIMENTO=?,ESTADO=?, DISABLED=? "
                + "WHERE (CPF=?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, cli.getNomeCompleto());
            stmt.setString(2, cli.getSexo());
            stmt.setString(3, cli.getTelefone());
            stmt.setString(4, cli.getEmail());
            stmt.setString(5, cli.getNumeroCNH());
            stmt.setString(6, cli.getEnd());
            stmt.setString(7, cli.getComplemento());
            stmt.setString(8, cli.getNumero());
            stmt.setString(9, cli.getBairro());
            stmt.setString(10, cli.getCEP());
            stmt.setString(11, cli.getCidade());
            stmt.setString(12, cli.getDataNasc());
            stmt.setString(13, cli.getUF());
            stmt.setBoolean(14, false);
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
