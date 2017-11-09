/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author douglas
 */
public abstract class Conexao implements Serializable {

    private final String url = "jdbc:hsqldb:file:"+System.getProperty("user.dir")+"/src/main/resources/lancamento";

    protected Connection conecta() {

        try {
            Class.forName("org.hsqldb.jdbcDriver");
            return DriverManager.getConnection(url, "sa", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ERRO: "+ Conexao.class.getName() +" :: "+ex.getMessage());
            return null;
        }
    }
    
    protected void close(Connection con, Statement stmt, ResultSet rs){
        try {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (con != null)
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
