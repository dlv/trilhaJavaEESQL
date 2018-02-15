package br.com.logic.trilha.dao;

import br.com.logic.trilha.model.Lancamento;
import br.com.logic.trilha.models.TipoLancamentoENUM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author douglas
 */
@Stateless
public class LancamentoDAO extends Conexao {

    private Connection con;
    private ResultSet rs;
    private Statement stmt;
    private PreparedStatement pstmt;
    StringBuilder sql = new StringBuilder();

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

    private String montarConsulta(String consultar) {
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
