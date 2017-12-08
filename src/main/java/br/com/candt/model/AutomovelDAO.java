/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.model;

import br.com.candt.model.Automovel;
import br.com.candt.model.BDConexao;
import static br.com.candt.model.BDConexao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutomovelDAO {

    public List<Automovel> listarAll() {

        String query = "SELECT * FROM AUTO";
        List<Automovel> lista = new ArrayList();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                Automovel auto = new Automovel();
                auto.setRenavam(resultados.getString("RENAVAM"));
                auto.setPlaca(resultados.getString("PLACA"));
                auto.setMarca(resultados.getString("MARCA"));
                auto.setModelo(resultados.getString("MODELO"));
                auto.setAno(resultados.getString("ANO"));
                auto.setCategoria(resultados.getString("CATEGORIA"));
                auto.setKilometragem(resultados.getString("KILOMETRAGEM"));
                auto.setNumeroChassi(resultados.getString("NUMEROCHASSI"));
                auto.setPortas(resultados.getString("PORTAS"));
                auto.setCor(resultados.getString("COR"));
                auto.setCombustivel(resultados.getString("COMBUSTIVEL"));
                auto.setDescricao(resultados.getString("DESCRICAO"));
                auto.setValorDeLocacao(resultados.getDouble("VALORDELOCACAO"));

                lista.add(auto);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return lista;
    }

    public List<Automovel> listar() {

        String query = "SELECT * FROM AUTO WHERE DISPONIVEL = ?";
        List<Automovel> lista = new ArrayList();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setBoolean(1, true);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                Automovel auto = new Automovel();
                auto.setRenavam(resultados.getString("RENAVAM"));
                auto.setPlaca(resultados.getString("PLACA"));
                auto.setMarca(resultados.getString("MARCA"));
                auto.setModelo(resultados.getString("MODELO"));
                auto.setAno(resultados.getString("ANO"));
                auto.setCategoria(resultados.getString("CATEGORIA"));
                auto.setKilometragem(resultados.getString("KILOMETRAGEM"));
                auto.setNumeroChassi(resultados.getString("NUMEROCHASSI"));
                auto.setPortas(resultados.getString("PORTAS"));
                auto.setCor(resultados.getString("COR"));
                auto.setCombustivel(resultados.getString("COMBUSTIVEL"));
                auto.setDescricao(resultados.getString("DESCRICAO"));
                auto.setValorDeLocacao(resultados.getDouble("VALORDELOCACAO"));

                lista.add(auto);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return lista;
    }

    public void incluirComTransacao(Automovel auto) throws SQLException {
        String query = "INSERT INTO AUTO "
                + "(RENAVAM,PLACA,MARCA,MODELO,ANO,CATEGORIA,KILOMETRAGEM,"
                + "NUMEROCHASSI,COR,PORTAS,COMBUSTIVEL,DESCRICAO,VALORDELOCACAO, DISPONIVEL) "
                + "VALUES (?, ?, ?, ?, ?, ? ,? ,? ,? ,?, ? ,? , ?, ?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);

            stmt.setString(1, auto.getRenavam());
            stmt.setString(2, auto.getPlaca());
            stmt.setString(3, auto.getMarca());
            stmt.setString(4, auto.getModelo());
            stmt.setString(5, auto.getAno());
            stmt.setString(6, auto.getCategoria());
            stmt.setString(7, auto.getKilometragem());
            stmt.setString(8, auto.getNumeroChassi());
            stmt.setString(9, auto.getCor());
            stmt.setString(10, auto.getPortas());
            stmt.setString(11, auto.getCombustivel());
            stmt.setString(12, auto.getDescricao());
            stmt.setDouble(13, auto.getValorDeLocacao());
            stmt.setBoolean(14, auto.getDisponivel());

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
        String query = "SELECT * FROM AUTO "
                + "WHERE (RENAVAM=?) AND (DISPONIVEL=?)";

        Automovel auto = new Automovel();
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, Renavam);
            stmt.setBoolean(2, true);

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
                    auto.setCombustivel(resultados.getString("COMBUSTIVEL"));
                    auto.setDescricao(resultados.getString("DESCRICAO"));
                    auto.setValorDeLocacao(resultados.getDouble("VALORDELOCACAO"));
                    auto.setDisponivel(resultados.getBoolean("DISPONIVEL"));
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return auto;
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
    public void Atualizar(Automovel auto, String renavamAtual) throws SQLException {
        String query = "UPDATE AUTO SET MARCA=?, MODELO=?,ANO=?,CATEGORIA=?, "
                + "PLACA=?,KILOMETRAGEM=?,NUMEROCHASSI=?,COR=?, "
                + "PORTAS=?,COMBUSTIVEL=?,DESCRICAO=?,VALORDELOCACAO=? "
                + "WHERE RENAVAM=? ";
        Connection con = null;
        PreparedStatement stmt = null;
        try {

            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setString(1, auto.getMarca());
            stmt.setString(2, auto.getModelo());
            stmt.setString(3, auto.getAno());
            stmt.setString(4, auto.getCategoria());
            stmt.setString(5, auto.getPlaca());
            stmt.setString(6, auto.getKilometragem());
            stmt.setString(7, auto.getNumeroChassi());
            stmt.setString(8, auto.getCor());
            stmt.setString(9, auto.getPortas());
            stmt.setString(10, auto.getCombustivel());
            stmt.setString(11, auto.getDescricao());
            stmt.setDouble(12, auto.getValorDeLocacao());
            stmt.setString(13, renavamAtual);
            stmt.execute();
        } finally {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    public void receberAuto(String renavam) {
        String query = "UPDATE AUTO SET DISPONIVEL = ? WHERE RENAVAM = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setBoolean(1, true);
            stmt.setString(2, renavam);

            stmt.execute();
        } catch (SQLException e) {

        }

    }
    
    public void retirarAuto(String renavam) {
        String query = "UPDATE AUTO SET DISPONIVEL = ? WHERE RENAVAM = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setBoolean(1, false);
            stmt.setString(2, renavam);

            stmt.execute();
        } catch (SQLException e) {

        }

    }
}
