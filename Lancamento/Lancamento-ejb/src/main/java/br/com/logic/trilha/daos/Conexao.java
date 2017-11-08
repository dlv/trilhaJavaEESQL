/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author douglas
 */
public abstract class Conexao implements Serializable {

    private final String url = "jdbc:hsqldb:file:<path>";

    protected Connection conecta() {

        try {
            Class.forName("org.hsqldb.jdbcDriver");
            return DriverManager.getConnection(url, "sa", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
