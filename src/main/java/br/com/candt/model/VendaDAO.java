/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.model;

import br.com.candt.model.Automovel;
import br.com.candt.model.BDConexao;
import br.com.candt.model.Venda;
import static br.com.candt.model.BDConexao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VendaDAO {
      public List<Automovel> listar() {

        String query = "SELECT * FROM Automovel";
        List<Automovel> lista = new ArrayList();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                Automovel auto = new Automovel();
                auto.setMarca(resultados.getString("MARCA"));
                auto.setModelo(resultados.getString("MODELO"));
                auto.setAno(resultados.getString("ANO"));
                auto.setCategoria(resultados.getString("CATEGORIA"));
                auto.setPlaca(resultados.getString("PLACA"));
                auto.setRenavam(resultados.getString("RENAVAM"));
                auto.setKilometragem(resultados.getString("KILOMETRAGEM"));
                auto.setNumeroChassi(resultados.getString("NUMEROCHASSI"));
                auto.setCor(resultados.getString("COR"));
                auto.setPortas(resultados.getString("PORTAS"));
                auto.setCombusitvel(resultados.getString("COMBUSTIVEL"));
                auto.setDescrição(resultados.getString("DESCRICAO"));

                lista.add(auto);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return lista;
    }

    public void incluirComTransacao(Venda venda) throws SQLException {
        String query = "INSERT INTO VENDA "
                + "(CPFCLI,RENAVAM,DATAENTREGA,DATADEVOLUCAO,VALORUNITARIO,VALORTOTAL) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setString(1, venda.getCliente());
            stmt.setString(2, venda.getRenavam());
            stmt.setString(3, venda.getDatadeEntrega());
            stmt.setString(4, venda.getDataDeDevolucao());
            stmt.setFloat(5, venda.getValorUnitario());
            stmt.setFloat(6, venda.getValorTotal());
           
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

    public Automovel procurar(String Renavam) {
        String query = "SELECT * FROM AUTOMOVEL "
                + "WHERE (RENAVAM=?)";

     Automovel auto = new Automovel();
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, Renavam);

            try (ResultSet resultados = stmt.executeQuery()) {

                if (resultados.next()) {
               
                    auto.setMarca(resultados.getString("MARCA"));
                    auto.setModelo(resultados.getString("MODELO"));
                    auto.setAno(resultados.getString("ANO"));
                    auto.setCategoria(resultados.getString("CATEGORIA"));
                    auto.setPlaca(resultados.getString("PLACA"));
                    auto.setRenavam(resultados.getString("RENAVAM"));
                    auto.setKilometragem(resultados.getString("KILOMETRAGEM"));
                    auto.setNumeroChassi(resultados.getString("NUMEROCHASSI"));
                    auto.setCor(resultados.getString("COR"));
                    auto.setPortas(resultados.getString("PORTAS"));
                    auto.setCombusitvel(resultados.getString("COMBUSTIVEL"));
                    auto.setDescrição(resultados.getString("DESCRICAO"));

                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return auto;
    }

    public void excluir(String user) {
        String sql = "DELETE FROM LOGIN WHERE (USUARIO=?)";
        Connection connection = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {;
            stmt.setString(1, user);
            stmt.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
