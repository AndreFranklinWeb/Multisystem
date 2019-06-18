//CONEXAO COM BANCO DE DADOS - MySQL
package Dao;

import java.sql.*;

public class ModuloConexao {

    public static Connection Conector;

    //Método responsavel por estabelecer conexão com banco de dados.
    public static Connection Conector() {
        java.sql.Connection conexao = null;
        // A linha abaixo chama o Driver.
        String Driver = "com.mysql.jdbc.Driver";
        //Armazenando informaçoes referente ao banco.   
        //----------------------------------------------------------
        String url = "jdbc:mysql://localhost:3306/db_multisystem";
        String user = "root";
        String password = ""; 
        //----------------------------------------------------------
        //String url = "jdbc:mysql://172.30.70.18/db_multisystem";
        //String user = "tecnico";
        //String password = "123mudar!";
        //---------------------------------------------------------------------
        //String url = "jdbc:mysql://mysql995.umbler.com:41890/db_multisystem"; 
                
        //Estabelecendo conexao com o Banco.
        try {
            Class.forName(Driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {

            return null;
        }
    }
}