package br.com.logic.trilha.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 *
 * @author douglas
 */
public class Conexao {

    @Resource(lookup = "jboss/datasources/trilhaDS")
    private DataSource trilhaDS;

    protected Connection conecta() {

        try {
            return trilhaDS.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ERRO: " + Conexao.class.getName() + " :: " + ex.getMessage());
            return null;
        }
    }

    protected void close(Connection con, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }

            close(con, stmt, rs);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void close(Connection con, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
