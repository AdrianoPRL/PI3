/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BDConexao {
    public static String status = "Não conectou...";
    
    //Construtor
    public BDConexao() {
        
    }
    
    //Metodo de conexao
    public static java.sql.Connection getConnection() {
        Connection connection = null;
        try {
            //Carregand o JDBC
            String driverName = "org.apache.derby.jdbc.ClientDataSource";
            Class.forName(driverName);
//             jdbc:derby://localhost:1527/teste 
            //Configurando a conexao com o banco de dados
//            String serveName = "localhost:1527"; // Caminho do servidor do BD
//            String mydatabase = "teste"; // Nome do banco de dados
            String url ="jdbc:derby://localhost:1527/new ";
            String username = "adm"; // Nome de usuario
            String password = "adm"; // Senha de acesso
            connection = DriverManager.getConnection(url, username, password);
            
            //Teste de conexao
            if (connection != null) {
                status = ("STATUS ----> Conectado com sucesso!");
            } else {
                status = ("STATUS ----> Não foi possivel realizar a conexão!");
            }
            
            return connection;
            
        } catch (ClassNotFoundException e) {
            
            //Driver nao encontrado
            System.out.println("O driver expecificado não foi encontrado.");
            return null;
        } catch (SQLException f) {
            
            //Nao conseguindo conectar ao banco
            System.out.println("Não foi possivel conectar ao Banco de Dados");
            return null;
        } 
    }
    
    //Metodo que retorna o status da conexao
    public static String statusConection() {
        return status;
    }
    
    //Metodo que fecha a conexao
    public static boolean fecharConexao() {
        try {
            BDConexao.getConnection().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    //metodo que reinicia sua conexao
    public static java.sql.Connection reiniciarConexao() {
        fecharConexao();
        return BDConexao.getConnection();
    }
}

