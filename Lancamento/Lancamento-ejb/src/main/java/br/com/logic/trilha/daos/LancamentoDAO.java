/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.daos;

import br.com.logic.trilha.models.Lancamento;
import br.com.logic.trilha.models.TipoLancamentoENUM;
import br.com.logic.trilha.util.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
    private PreparedStatement pstmt;
    
    StringBuilder sql = new StringBuilder();
    
    public List<Lancamento> buscar() {
        List<Lancamento> lista = new ArrayList<>();
        
        sql = new StringBuilder();
        try {
            con = conecta();
            
            if (con == null) {
                return lista;
            }
            
            stmt = con.createStatement();
            
            sql.append("\n select lm.id, lm.descricaolancamento, lm.datalancamento, lm.valorlancamento, lm.idtipolancamento");
            sql.append("\n from lancamentomensal lm");
            sql.append("\n join tipolancamento tl on lm.idtipolancamento = tl.id");
            sql.append("\n order by lm.id desc limit 10");
            
            rs = stmt.executeQuery(sql.toString());
            
            while (rs.next()) {
                Lancamento lancamento = new Lancamento();
                
                lancamento.setId(rs.getInt("id"));
                lancamento.setDescricaoLancamento(rs.getString("descricaolancamento"));
                lancamento.setData(rs.getDate("datalancamento"));
                lancamento.setValor(rs.getDouble("valorlancamento"));
                lancamento.setTipoLancamento(TipoLancamentoENUM.getTipoLancamentoENUM(rs.getInt("idtipolancamento")));
                
                lista.add(lancamento);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con, stmt, rs);
        }
        
        return lista;
    }
    
    public void lancamentoMensal(Lancamento lancamento) {
        sql = new StringBuilder();
        sql.append("insert into lancamentomensal(descricaolancamento, datalancamento, valorlancamento, idtipolancamento) values (?,?,?,?)");
        lancamento.setId(0);
        try {
            //<editor-fold defaultstate="collapsed" desc="Conexão">
            con = conecta();
            pstmt = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            //</editor-fold>

            pstmt.setString(1, lancamento.getDescricaoLancamento());
            pstmt.setDate(2, new java.sql.Date(lancamento.getData().getTime()));
            pstmt.setDouble(3, lancamento.getValor());
            pstmt.setInt(4, lancamento.getTipoLancamento().getId());
            
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            
            while (rs.next()) {
                lancamento.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            close(con, stmt, pstmt, rs);
        }
    }
    
    public Lancamento buscar(Integer id) {
        Lancamento lancamento = new Lancamento();

        try {
            //<editor-fold defaultstate="collapsed" desc="Conexão">
            con = conecta();
            pstmt = con.prepareStatement(montarConsulta("idlancamento"));
            //</editor-fold>

            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                lancamento.setId(rs.getInt("id"));
                lancamento.setDescricaoLancamento(rs.getString("descricaolancamento"));
                lancamento.setData(rs.getDate("datalancamento"));
                lancamento.setValor(rs.getDouble("valorlancamento"));
                lancamento.setTipoLancamento(TipoLancamentoENUM.getTipoLancamentoENUM(rs.getInt("idtipolancamento")));
            }
            
            return lancamento;
        } catch (SQLException ex) {
            System.err.println("ERRO - LancamentoDAO.buscar: " + ex.getMessage());
            return null;
        } finally {
            close(con, stmt, pstmt, rs);
        }
    }
    
    public List<Lancamento> pesquisarPorPeriodo(Date data) {
        List<Lancamento> listaLancamento = new ArrayList<>();

        try {
            //<editor-fold defaultstate="collapsed" desc="Conexão">
            con = conecta();
            pstmt = con.prepareStatement(montarConsulta("periodolancamento"));
            //</editor-fold>
            
            pstmt.setDate(1, new java.sql.Date(data.getTime()));

            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Lancamento l = new Lancamento();
                l.setId(rs.getInt("id"));
                l.setDescricaoLancamento(rs.getString("descricaolancamento"));
                l.setData(rs.getDate("datalancamento"));
                l.setValor(rs.getDouble("valorlancamento"));
                l.setTipoLancamento(TipoLancamentoENUM.getTipoLancamentoENUM(rs.getInt("idtipolancamento")));
                
                listaLancamento.add(l);
            }
            
            return listaLancamento;
        } catch (Exception ex) {
            System.err.println("ERRO - LancamentoDAO.pesquisarPorPeriodo: " + ex.getMessage());
            return null;
        } finally {
            close(con, stmt, pstmt, rs);
        }
    }
    
    public List<Lancamento> pesquisarPorNome(String descricaoLancamento) {
        List<Lancamento> listaLancamento = new ArrayList<>();

        try {
            //<editor-fold defaultstate="collapsed" desc="Conexão">
            con = conecta();
            pstmt = con.prepareStatement(montarConsulta("descricaolancamento"));
            //</editor-fold>
            
            pstmt.setString(1, "%"+descricaoLancamento.toUpperCase()+"%");

            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Lancamento l = new Lancamento();
                l.setId(rs.getInt("id"));
                l.setDescricaoLancamento(rs.getString("descricaolancamento"));
                l.setData(rs.getDate("datalancamento"));
                l.setValor(rs.getDouble("valorlancamento"));
                l.setTipoLancamento(TipoLancamentoENUM.getTipoLancamentoENUM(rs.getInt("idtipolancamento")));
                
                listaLancamento.add(l);
            }
            
            return listaLancamento;
        } catch (SQLException ex) {
            System.err.println("ERRO - LancamentoDAO.pesquisarPorPeriodo: " + ex.getMessage());
            return null;
        } finally {
            close(con, stmt, pstmt, rs);
        }
    }
    
    public List<Lancamento> pesquisarPorTipo(String tipo) {
        List<Lancamento> listaLancamento = new ArrayList<>();

        try {
            //<editor-fold defaultstate="collapsed" desc="Conexão">
            con = conecta();
            pstmt = con.prepareStatement(montarConsulta("tipolancamento"));
            //</editor-fold>
            
            pstmt.setInt(1, TipoLancamentoENUM.valueOf(tipo.toUpperCase()).getId());

            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Lancamento l = new Lancamento();
                l.setId(rs.getInt("id"));
                l.setDescricaoLancamento(rs.getString("descricaolancamento"));
                l.setData(rs.getDate("datalancamento"));
                l.setValor(rs.getDouble("valorlancamento"));
                l.setTipoLancamento(TipoLancamentoENUM.getTipoLancamentoENUM(rs.getInt("idtipolancamento")));
                
                listaLancamento.add(l);
            }
            
            return listaLancamento;
        } catch (SQLException ex) {
            System.err.println("ERRO - LancamentoDAO.pesquisarPorPeriodo: " + ex.getMessage());
            return null;
        } finally {
            close(con, stmt, pstmt, rs);
        }
    }
    
    private String montarConsulta(String consultar){
        sql = new StringBuilder();
        sql.append("\n select id, descricaolancamento, datalancamento, valorlancamento, idtipolancamento");
        sql.append("\n from lancamentomensal");
        
        switch (consultar) {
            case "datalancamento":
                sql.append("\n where datalancamento = ?");
                break;
            case "tipolancamento":
                sql.append("\n where idtipolancamento = ?");
                break;
            case "descricaolancamento":
                sql.append("\n where UPPER(descricaolancamento) like ?");
                break;
            case "periodolancamento":
                sql.append("\n where datalancamento = ?");
                break;
            case "idlancamento":
                sql.append("\n where id = ?");
                break;
        }
        sql.append("\n order by id");
        
        return sql.toString();
    }
}
