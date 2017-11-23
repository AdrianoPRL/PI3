/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.model;

import br.com.candt.model.BDConexao;
import br.com.candt.model.ClienteJuridico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteJuridicoDAO {

    public void incluirComTransacao(ClienteJuridico cli) throws SQLException {
        String query = "INSERT INTO CLIENTEJURIDICO "
                + "(RAZAOSOCIAL,CNPJ,ENDEREÇO,UF,COMPLEMENTO,BAIRRO"
                + ",TELEFONE,EMAIL,CNH,CIDADE,NOMEFANTSIA,INSCRICAOESTADUAL) "
                + "VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setString(1, cli.getRazaoSocial());
            stmt.setString(2, cli.getCNPJ());

            stmt.setString(3, cli.getEnd());
            stmt.setString(4, cli.getUF());
            stmt.setString(5, cli.getComplemento());
//            stmt.setString(6, cli.getCategoriaCnh());
            stmt.setString(6, cli.getBairro());
            stmt.setString(7, cli.getTelefone());
            stmt.setString(8, cli.getEmail());
            stmt.setString(9, cli.getNumeroCnh());
            stmt.setString(10, cli.getCidade());
            stmt.setString(11, cli.getNomeFantasia());
            stmt.setString(12, cli.getInscricaoEstadual());

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

    public List<ClienteJuridico> listar() {

        String query = "SELECT * FROM ClienteJuridico";
        List<ClienteJuridico> lista = new ArrayList();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                ClienteJuridico c = new ClienteJuridico();
                c.setRazaoSocial(resultados.getString("RAZAOSOCIAL"));
                c.setCNPJ(resultados.getString("CNPJ"));
                c.setNumeroCnh(resultados.getString("CNH"));
                c.setEnd(resultados.getString("ENDEREÇO"));
                c.setUF(resultados.getString("UF"));
                c.setCidade(resultados.getString("CIDADE"));
                c.setComplemento(resultados.getString("COMPLEMENTO"));
                c.setBairro(resultados.getString("BAIRRO"));
                c.setTelefone(resultados.getString("TELEFONE"));

//                c.setNumero(resultados.getString("NUMERO"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return lista;
    }
}
