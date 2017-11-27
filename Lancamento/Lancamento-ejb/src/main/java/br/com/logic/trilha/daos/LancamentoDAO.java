/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.daos;

import br.com.logic.trilha.models.Lancamento;
import br.com.logic.trilha.models.TipoLancamentoENUM;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;

/**
 *
 * @author douglas
 */
@Stateless
@Dependent
public class LancamentoDAO extends Conexao {

    private Connection con;
    private ResultSet rs;
    private Statement stmt;
    StringBuilder sql = new StringBuilder();

    public List<Lancamento> buscar() {
        List<Lancamento> lista = new ArrayList<>();
     
        sql = new StringBuilder();
        try {
            con = conecta();
            
            if (con == null)
                return lista;
            
            stmt = con.createStatement();

            sql.append("\n select lm.id, lm.nome, lm.datalancamento, lm.valorlancamento, lm.idtipolancamento");
            sql.append("\n from lancamentomensal lm");
            sql.append("\n join tipolancamento tl on lm.idtipolancamento = tl.id");
            sql.append("\n order by lm.id desc limit 10");

            rs = stmt.executeQuery(sql.toString());

            while (rs.next()) {
                Lancamento lancamento = new Lancamento();

                lancamento.setId(rs.getInt("id"));
                lancamento.setNome(rs.getString("nome"));
                lancamento.setData(rs.getString("data"));
                lancamento.setValor(rs.getDouble("valor"));
                // TODO: tratar enum
                lancamento.setTipoLancamento(TipoLancamentoENUM.getTipo(rs.getInt("idtipolancamento")));

                lista.add(lancamento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con, stmt, rs);
        }

        return lista;
    }

    public void contasMes(Lancamento lancamento) {
        sql = new StringBuilder();
        try {
            //<editor-fold defaultstate="collapsed" desc="Conexão">
            con = conecta();
            stmt = con.createStatement();
            //</editor-fold>
            
            sql.append("insert into conta values (");
            sql.append(lancamento.getId()).append(",");
            sql.append("'").append(lancamento.getNome()).append("',");
            sql.append("'").append(lancamento.getData()).append("',");
            sql.append(lancamento.getValor()).append(",");
            sql.append(lancamento.getTipoLancamento().getTipo());
            sql.append(")");

            stmt.execute(sql.toString());
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
//            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con, stmt, null);
        }
    }
    
    public Boolean testMethod(){
        return Boolean.TRUE;
    }
}
