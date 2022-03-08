/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

/**
 *
 * @author Usuário
 */
public class Metodos_Importacao {

    private String aux_txt;

    private String fileChooser(int tipo) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter;
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        if (tipo == 1) {
            filter = new FileNameExtensionFilter(
                    "Pasta de Trabalho do Excel 97-2003", "xls");
        } else {
            filter = new FileNameExtensionFilter(
                    "Arquivo Texto", "txt");
        }
        chooser.setFileFilter(filter);
        //int returnVal = chooser.showSaveDialog(main);
        int returnVal = chooser.showOpenDialog(Constantes.getMain());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        } else {
            return "";
        }
    }


    public void doImportacao(String[] dados) {
        String erro = "";
        if (dados == null) {
            try {
                aux_txt = fileChooser(0);
                if (!"".equals(aux_txt)) {
                    try (FileReader arq = new FileReader(aux_txt)) {
                        BufferedReader lerArq = new BufferedReader(arq);
                        String linha = lerArq.readLine();
                        while (linha != null) {
                            doListaLivro(linha.split(";"));
                            linha = lerArq.readLine();
                        }
                    }
                } else {
                    erro = "Selecione um Arquivo!";
                }
            } catch (IOException e) {
                erro = "Erro ao abrir o arquivo selecionado!";
                Logger.getLogger(Metodos_Importacao.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            for (String dado : dados) {
                doListaLivro(dado.split(";"));
            }
        }
        if ("".equals(erro)) {
            for (VwLivro vw : Constantes.getLlivro()) {
                try {
                    Constantes.getMl().doLivro(vw, "SF_t_genero(0"
                            + " , '" + vw.getGenero() + "' "
                            + " , '1'"
                            + " , " + Constantes.getVwusuarioLogado().getUsuarioId()
                            + " , '0')", false);
                } catch (SQLException ex) {
                    Logger.getLogger(Metodos_Importacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(Constantes.getMain(), erro);
        }
    }

    private void doListaLivro(String[] dados) {
        Constantes.getLlivro().clear();
        Constantes.getLlivro().add(new VwLivro());
        Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setLivroId(BigInteger.valueOf(0));
        Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setIsbn(BigInteger.valueOf(Long.parseLong(dados[0])));
        Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setLivro(dados[1].toUpperCase());
        Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setEditora(dados[2].toUpperCase());
        Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setAutor(dados[3].toUpperCase());
        Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setGenero(dados[4].toUpperCase());
        try {
            Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setPublicado(new SimpleDateFormat("dd-MM-yyyy").parse(dados[5]));
        } catch (ParseException ex) {
            Logger.getLogger(Metodos_Importacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Constantes.getLlivro().get(Constantes.getLlivro().size() - 1).setAtivo(Boolean.parseBoolean(dados[6]));
    }

    public String[] doImportacaoXLS() {
        Workbook workbook = null;
        aux_txt = "";
        try {
            aux_txt = fileChooser(1);
            if (!"".equals(aux_txt)) {
                File file = new File(aux_txt);
                aux_txt = "";
                WorkbookSettings wbSettings = new WorkbookSettings();
                wbSettings.setLocale(new Locale("pt", "BR"));
                wbSettings.setEncoding("ISO-8859-1");
                workbook = Workbook.getWorkbook(file, wbSettings);
                Sheet sheet;
                sheet = workbook.getSheet(0);
                int i = 1;
                while (sheet.getRows() > i) {
                    aux_txt = aux_txt + sheet.getCell(0, i).getContents() + ";"
                            + sheet.getCell(1, i).getContents() + ";"
                            + sheet.getCell(2, i).getContents() + ";"
                            + sheet.getCell(3, i).getContents() + ";"
                            + sheet.getCell(4, i).getContents() + ";"
                            + sheet.getCell(5, i).getContents() + ";"
                            + sheet.getCell(6, i).getContents() + ";"
                            + "@";
                    i++;
                }
            } else {
                JOptionPane.showMessageDialog(Constantes.getMain(), "Selecione um Arquivo!");
            }
        } catch (IOException | BiffException ex) {
            Logger.getLogger(Metodos_Importacao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            workbook.close();
        }
        return aux_txt.substring(0, aux_txt.length() - 1).split("@");
    }

}
