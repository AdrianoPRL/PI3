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
import java.util.ArrayList;
import java.util.List;


public class FilialDAO {
    public List<Filial> listarFiliais(){
        String query = "SELECT * FROM FILIAIS ORDER BY NOME";
        List<Filial> lista = new ArrayList();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet resultados = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            resultados = stmt.executeQuery();
            
            while (resultados.next()) {
                Filial fil = new Filial();
                fil.setId(resultados.getInt("ID"));
                fil.setNome(resultados.getString("NOME"));
                fil.setLocal(resultados.getString("LOCAL"));
                
                lista.add(fil);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return lista;
    }
    
    public Filial getFilial(Integer id){
        String query = "SELECT * FROM FILIAIS WHERE ID = ? ORDER BY NOME";
        Filial fil = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet resultados = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            resultados = stmt.executeQuery();
            
            while (resultados.next()) {
                fil = new Filial();
                fil.setId(resultados.getInt("ID"));
                fil.setNome(resultados.getString("NOME"));
                fil.setLocal(resultados.getString("LOCAL"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return fil;
    }
    
    public Filial pesquisarPorNome(String nome){
        String query = "SELECT * FROM FILIAIS WHERE NOME = ? ORDER BY NOME";
        Filial fil = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet resultados = null;
        try {
            con = BDConexao.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setString(1, nome);
            resultados = stmt.executeQuery();
            
            while (resultados.next()) {
                fil = new Filial();
                fil.setId(resultados.getInt("ID"));
                fil.setNome(resultados.getString("NOME"));
                fil.setLocal(resultados.getString("LOCAL"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return fil;
    }
}
