/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.model;

import br.com.candt.model.BDConexao;
import br.com.candt.model.UserSistem;
import static br.com.candt.model.BDConexao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Phantom
 */
public class LoginDAO extends BDConexao {
 

    public void incluirComTransacao(UserSistem log) throws SQLException   {
        String query = "INSERT INTO LOGIN "
                + "(USERNAME,SENHA,NOME,TIPODEUSER) "
                + "VALUES (?, ?, ?, ?)";                
     Connection con = null;
     PreparedStatement stmt=null;
         try {
              con = BDConexao.getConnection();
            
             stmt=con.prepareStatement(query);
             stmt.setString(1,log.getUsuario());
             stmt.setString(2,log.getHashSenha());
             stmt.setString(3,log.getNomeCompleto());
             stmt.setString(4,log.getTipoDeUser());
             stmt.execute();
         }catch (SQLException e){
            
         }finally {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }


    

    public UserSistem procurar(String username,String senha) {
        String query = "SELECT * FROM LOGIN WHERE (USERNAME=?) AND"
                + "(SENHA=?)";

        UserSistem log = null;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2,senha);
            try (ResultSet resultados = stmt.executeQuery()) {

                if (resultados.next()) {
                    log = new UserSistem();
                    log.setUsuario(resultados.getString("USERNAME"));
                    log.setHashSenha(resultados.getString("SENHA"));
                    log.setNomeCompleto(resultados.getString("NOME"));
                    log.setTipoDeUser(resultados.getString("TIPODEUSER"));
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return log;
    }

    public void excluir(String user) {
        String sql = "DELETE FROM LOGIN WHERE (USERNAME=?)";
        Connection connection = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {;
            stmt.setString(1, user);
            stmt.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
    }

    public void Atualizar(UserSistem log) {
        String sql = "UPDATE produto SET USERNAME=?, SENHA=? NOME=? TIPOUSUARIO=?"
                + "WHERE (USUARIO=?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, log.getUsuario());
            stmt.setString(2, log.getHashSenha());
            stmt.setString(3, log.getNomeCompleto());
            stmt.setString(4, log.getTipoDeUser());

            stmt.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        
        }
    }
}
