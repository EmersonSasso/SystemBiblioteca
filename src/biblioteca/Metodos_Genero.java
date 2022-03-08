/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hemerson Mendes
 */
public class Metodos_Genero {

    private String slv_text;
    private ResultSet rs;

    public long doGenero(Object obj, boolean delete) throws SQLException {
        if (obj instanceof TGenero) {
            TGenero genero = (TGenero) obj;
            slv_text = "Select sf_t_genero("
                    + genero.getGeneroId()
                    + ", '" + genero.getNome() + "'";
            if (genero.getAtivo()) {
                slv_text = slv_text + ", '1'";
            } else {
                slv_text = slv_text + ", '0'";
            }
            slv_text = slv_text + ", " + Constantes.getVwusuarioLogado().getUsuarioId();
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
