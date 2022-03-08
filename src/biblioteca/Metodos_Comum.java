/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

/**
 *
 * @author Hemerson Mendes
 */
public class Metodos_Comum {

    private ResultSet rs;
    private String slv_text;
    private final SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

    public boolean isConnected(String user, char[] password) throws SQLException {
        rs = Constantes.getMbd().Executar("SELECT usuario_id"
                + ", nome"
                + ", login"
                + ", senha"
                + ", ativo"
                + " FROM vw_usuario"
                + " WHERE login = '" + user + "'"
                + " AND senha = md5('" + passToString(password) + "')"
                + " AND ativo = '1'");
        try {
            if (null != rs) {
                while (rs.next()) {
                    Constantes.setVwusuarioLogado(new VwUsuario());
                    Constantes.getVwusuarioLogado().setUsuarioId(BigInteger.valueOf(rs.getInt("usuario_id")));
                    Constantes.getVwusuarioLogado().setNome(rs.getString("nome"));
                    Constantes.getVwusuarioLogado().setLogin(rs.getString("login"));
                    Constantes.getVwusuarioLogado().setSenha(rs.getString("senha"));
                    Constantes.getVwusuarioLogado().setAtivo(rs.getBoolean("ativo"));
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metodos_Banco_Post.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close();
        }
        return false;
    }

    public static void InserirIcone(JFrame frm, String Icone) {
        try {
            frm.setIconImage(new ImageIcon(System.getProperty("user.dir") + "\\imagens\\" + Icone).getImage());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void Config(Conexao_DB cdb) {
        try {
            try (FileReader arq = new FileReader(System.getProperty("user.dir") + "\\Config\\Config.txt")) {
                BufferedReader lerArq = new BufferedReader(arq);
                String linha = lerArq.readLine();
                while (linha != null) {
                    if (linha.contains("Server:")) {
                        linha = lerArq.readLine();
                        cdb.getFieldHost().setText(linha);
                    } else if (linha.contains("Port:")) {
                        linha = lerArq.readLine();
                        cdb.getFieldPort().setText(linha);
                    } else if (linha.contains("Alias:")) {
                        linha = lerArq.readLine();
                        cdb.getFieldAlias().setText(linha);
                    } else {
                        linha = lerArq.readLine();
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir " + System.getProperty("user.dir")
                    + "\\Config\\Config.txt, arquivo invalido ou inexistente!");
            Logger.getLogger(Metodos_Comum.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void SaveFile(String server, String alias, String port) {
        try {
            File arquivo = new File(System.getProperty("user.dir") + "\\Config\\Config.txt");
            try (FileWriter fw = new FileWriter(arquivo)) {
                fw.write("Server:\n"
                        + server + "\n"
                        + "Alias:\n"
                        + alias + "\n"
                        + "Port:\n"
                        + port);
                fw.flush();
                fw.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir " + System.getProperty("user.dir")
                    + "\\Config\\Config.txt, arquivo invalido ou inexistente!");
            Logger.getLogger(Metodos_Comum.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void doLogin(Conexao_DB cdb, Main main) {
        main.setVisible(true);
        cdb.setVisible(true);
    }

    public String passToString(char[] theAray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < theAray.length; i++) {
            char item = theAray[i];
            sb.append(item);
        }
        return sb.toString();
    }

    public Date ajusteData(String data1) {
        java.util.Date d1;
        try {
            d1 = f.parse(ajustaData(data1));
            f.applyPattern("yyyy-MM-dd");
        } catch (ParseException ex) {
            Logger.getLogger(Metodos_Comum.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return d1;
    }

    public java.sql.Date converteData(String data1) {
        java.sql.Date dt1 = java.sql.Date.valueOf(f.format(ajusteData(data1)));
        return dt1;
    }

    private String ajustaData(String data) {
        //October 1, 1988
        String data_ajustada[] = data.split(" ");
        data_ajustada[0] = mudaMes(data_ajustada[0]);
        return data_ajustada[1].replace(",", "") + "/" + data_ajustada[0] + "/" + data_ajustada[2];
    }

    private String mudaMes(String mes) {
        switch (mes.toLowerCase().substring(0, 3)) {
            case "jan":
                return "01";
            case "feb":
                return "02";
            case "mar":
                return "03";
            case "apr":
                return "04";
            case "may":
                return "05";
            case "jun":
                return "06";
            case "jul":
                return "07";
            case "aug":
                return "08";
            case "sep":
                return "09";
            case "oct":
                return "10";
            case "nov":
                return "11";
            case "dec":
                return "12";
            default:
                return "00";
        }
    }

    public void makeJCBGenero(JComboBox<String> comboGenero, boolean editar) throws SQLException {
        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Selecione o Genero:"}));
        slv_text = "SELECT genero_id"
                + ", nome"
                + ", ativo"
                + ", created_by"
                + ", creation_date"
                + ", last_updated_by"
                + ", last_updated_time"
                + " FROM t_genero";
        if (!editar) {
            slv_text = slv_text + " WHERE ativo = '1'";
        }
        slv_text = slv_text + " ORDER BY genero_id ASC";
        rs = Constantes.getMbd().Executar(slv_text);
        try {
            Constantes.getLgenero().clear();
            while (rs.next()) {
                Constantes.getLgenero().add(new TGenero(rs.getLong("genero_id")));
                comboGenero.addItem(rs.getString("nome"));
                Constantes.getLgenero().get(Constantes.getLgenero().size() - 1).setNome(rs.getString("nome"));
                Constantes.getLgenero().get(Constantes.getLgenero().size() - 1).setAtivo(rs.getBoolean("ativo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metodos_Comum.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close();
        }
    }

    public boolean CallApi(String isbn) {
        try {

            JSONObject jo = Constantes.getCa().callapi("isbn", isbn);

            if (jo != null) {
                Constantes.getVwlivro().setIsbn(BigInteger.valueOf(Long.parseLong(isbn)));
                Constantes.getVwlivro().setLivro(Constantes.getJson().ReadJson(jo, "title").toUpperCase());
                Constantes.getVwlivro().setPublicado(Constantes.getMet().converteData(Constantes.getJson().ReadJson(jo, "publish_date")));
                Constantes.getVwlivro().setEditora(Constantes.getJson().ReadJson(jo, "publishers").substring(2, Constantes.getJson().ReadJson(jo, "publishers").length() - 2).toUpperCase());
                Constantes.getVwlivro().setAutor(Constantes.getJson().ReadJson(Constantes.getCa().callapi("authors", Constantes.getJson().ReadJson(jo, "authors").split("/")[Constantes.getJson().ReadJson(jo, "authors").split("/").length - 1].replace("\"}]", "")), "name").toUpperCase());
                return true;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Constantes.getMain(), "OpenLibrary fora do ar, tente novamente mais tarde!");

        }
        return false;
    }

    public int checkGenero(String genero) {
        for (int i = 0; i < Constantes.getLgenero().size(); i++) {
            if (Constantes.getLgenero().get(i).getNome().equals(genero)) {
                return i+1;
            }
        }
        return 0;
    }

}
