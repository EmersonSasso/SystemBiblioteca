/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Usuário
 */
public class Metodos_Livro {

    private ResultSet rs;
    private String slv_text;

    public void makeJCBLivro(JComboBox<String> comboLivro, boolean editar) throws SQLException {
        comboLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Selecione o Livro:"}));
        slv_text = "SELECT livro_id"
                + ", isbn"
                + ", livro"
                + ", editora"
                + ", autor"
                + ", genero"
                + ", ativo"
                + ", publicado"
                + " FROM vw_livro";
        slv_text = slv_text + " ORDER BY livro_id ASC";
        rs = Constantes.getMbd().Executar(slv_text);
        try {
            Constantes.getLlivro().clear();
            while (rs.next()) {
                Constantes.getLlivro().add(new VwLivro());
                comboLivro.addItem(rs.getString("livro"));
                Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setLivroId(BigInteger.valueOf(rs.getLong("livro_id")));
                Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setIsbn(BigInteger.valueOf(rs.getLong("isbn")));
                Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setLivro(rs.getString("livro").toUpperCase());
                Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setEditora(rs.getString("editora").toUpperCase());
                Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setAutor(rs.getString("autor").toUpperCase());
                Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setGenero(rs.getString("genero").toUpperCase());
                Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setPublicado(rs.getDate("publicado"));
                Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setAtivo(rs.getBoolean("ativo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metodos_Comum.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close();
        }
    }

    public long doLivro(Object obj, String genero, boolean delete) throws SQLException {
        if (obj instanceof VwLivro) {
            VwLivro livro = (VwLivro) obj;
            slv_text = "Select sf_t_livro("
                    + livro.getLivroId()
                    + ", " + livro.getIsbn()
                    + ", '" + livro.getLivro() + "'"
                    + ", sf_checkEditor('" + livro.getEditora() + "', " + Constantes.getVwusuarioLogado().getUsuarioId() + ")"
                    + ", sf_checkAutor('" + livro.getAutor() + "', " + Constantes.getVwusuarioLogado().getUsuarioId() + ")"
                    + ", " + genero;
            if (livro.getAtivo()) {
                slv_text = slv_text + ", '1'";
            } else {
                slv_text = slv_text + ", '0'";
            }
            slv_text = slv_text + ", '" + livro.getPublicado() + "'"
                    + ", " + Constantes.getVwusuarioLogado().getUsuarioId();
            if (delete) {
                slv_text = slv_text + ", '1'";
            } else {
                slv_text = slv_text + ", '0'";
            }
            slv_text = slv_text + ")";
            rs = Constantes.getMbd().Executar(slv_text);
            if (rs != null) {
                try {
                    while (rs.next()) {
                        return rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Metodos_Genero.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    rs.close();
                }
            }
        }
        return 0;
    }
}
