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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phantom
 */
public class LoginDAO extends BDConexao {
//    public Login listar() {
//
//    String query = "SELECT id, nome, descricao, "
//	    + "vl_compra, vl_venda, categoria, "
//	    + "dt_cadastro FROM produto";
//
//    
//    try (Connection conn = obterConexao();
//	    PreparedStatement stmt = conn.prepareStatement(query);
//	    ResultSet resultados = stmt.executeQuery()) {
//
//      lista = new ArrayList<Produto>();
//      while (resultados.next()) {
//	Produto p = new Produto();
//	p.setId(resultados.getLong("id"));
//	p.setNome(resultados.getString("nome"));
//	p.setDescricao(resultados.getString("descricao"));
//	p.setValorCompra(resultados.getBigDecimal("vl_compra"));
//	p.setValorVenda(resultados.getBigDecimal("vl_venda"));
//	p.setDescricao(resultados.getString("categoria"));
//	p.setDtCadastro(resultados.getTimestamp("dt_cadastro"));
//	lista.add(p);
//      }
//    } catch (SQLException ex) {
//      System.err.println(ex.getMessage());
//    } catch (ClassNotFoundException ex) {
//      System.err.println(ex.getMessage());
//    }
//    return lista;
//  }
//
//  public Produto obter(long id) {
//    String query = "SELECT * FROM produto WHERE (id=?)";
//
//    Produto prod = new Produto();
//    try (Connection conn = obterConexao();
//	    PreparedStatement stmt = conn.prepareStatement(query)) {
//
//      stmt.setLong(1, id);
//      try (ResultSet resultados = stmt.executeQuery()) {
//
//	if (resultados.next()) {
//	  prod = new Produto();
//	  prod.setId(resultados.getLong("id"));
//	  prod.setNome(resultados.getString("nome"));
//	  prod.setDescricao(resultados.getString("descricao"));
//	  prod.setValorCompra(resultados.getBigDecimal("vl_compra"));
//	  prod.setValorVenda(resultados.getBigDecimal("vl_venda"));
//	  prod.setDescricao(resultados.getString("categoria"));
//	  prod.setDtCadastro(resultados.getTimestamp("dt_cadastro"));
//	}
//      }
//    } catch (SQLException ex) {
//      System.err.println(ex.getMessage());
//    } catch (ClassNotFoundException ex) {
//      System.err.println(ex.getMessage());
//    }
//    return prod;
//  }
//

    public void incluirComTransacao(UserSistem log) {

        String query = "INSERT INTO LOGIN "
                + "(USUARIO,SENHA,NOME,TIPOUSUARIO) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt
                    = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, log.getUsuario());
                stmt.setString(2, log.getHashSenha());
                stmt.setString(3, log.getNomeCompleto());
                stmt.setString(4, log.getTipoDeUser());
                stmt.executeUpdate();

                conn.commit();
            } catch (SQLException ex) {
                conn.rollback();
                System.err.println(ex.getMessage());
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public UserSistem procurar(String nome) {
        String query = "SELECT * FROM LOGIN WHERE (USUARIO=?)";

        UserSistem log = null;
        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nome);
            try (ResultSet resultados = stmt.executeQuery()) {

                if (resultados.next()) {
                    log = new UserSistem();
                    log.setUsuario(resultados.getString("USUARIO"));
                    log.setHashSenha(resultados.getString("SENHA"));
                    log.setNomeCompleto(resultados.getString("NOME"));
                    log.setTipoDeUser(resultados.getString("TIPOUSUARIO"));
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return log;
    }

    public void excluir(String user) {
        String sql = "DELETE FROM LOGIN WHERE (USUARIO=?)";
        Connection connection = null;

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {;
            stmt.setString(1, user);
            stmt.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void Atualizar(UserSistem log) {
        String sql = "UPDATE produto SET USUARIO=?, SENHA=? NOME=? TIPOUSUARIO=?"
                + "WHERE (USUARIO=?)";

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, log.getUsuario());
            stmt.setString(2, log.getHashSenha());
            stmt.setString(3, log.getNomeCompleto());
            stmt.setString(4, log.getTipoDeUser());

            stmt.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
