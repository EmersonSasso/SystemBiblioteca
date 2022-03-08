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
public class Metodos_Usuario {

    private String slv_text;
    private ResultSet rs;

    public long doUser(Object obj, boolean delete) throws SQLException {
        if (obj instanceof VwUsuario) {
            VwUsuario user = (VwUsuario) obj;
            slv_text = "Select sf_t_login("
                    + user.getUsuarioId()
                    + ", '" + user.getNome() + "'";
            if (user.getAtivo()) {
                slv_text = slv_text + ", '1'";
            } else {
                slv_text = slv_text + ", '0'";
            }
            slv_text = slv_text + ", '" + user.getLogin() + "'"
                    + ", '" + user.getSenha() + "'";

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

    public void makeJCBusuario(JComboBox<String> combousuario, boolean editar) throws SQLException {
        combousuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Selecione o Usuario:"}));
        slv_text = "SELECT usuario_id"
                + ", nome"
                + ", login"
                + ", ativo"
                + " FROM vw_usuario";
        if (!editar) {
            slv_text = slv_text + " WHERE ativo = '1'";
        }
        slv_text = slv_text + " ORDER BY usuario_id ASC";
        rs = Constantes.getMbd().Executar(slv_text);
        try {
            Constantes.getLusuario().clear();
            while (rs.next()) {
                Constantes.getLusuario().add(new VwUsuario());
                combousuario.addItem(rs.getString("login"));
                Constantes.getLusuario().get(Constantes.getLusuario().size() - 1).setNome(rs.getString("nome"));
                Constantes.getLusuario().get(Constantes.getLusuario().size() - 1).setAtivo(rs.getBoolean("ativo"));
                Constantes.getLusuario().get(Constantes.getLusuario().size() - 1).setLogin(rs.getString("login"));
                Constantes.getLusuario().get(Constantes.getLusuario().size() - 1).setUsuarioId(BigInteger.valueOf(rs.getLong("usuario_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metodos_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close();
        }
    }
}
