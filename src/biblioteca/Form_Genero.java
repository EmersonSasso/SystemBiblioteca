/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hemerson Mendes
 */
public class Form_Genero extends javax.swing.JPanel {

    /**
     * Creates new form Form_Genero
     *
     */
    public Form_Genero() {
        initComponents();
        enfeite.setVisible(false);
    }
    private long resultado;
    private String text;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lcTitulo = new javax.swing.JLabel();
        jcbGenero = new javax.swing.JComboBox<>();
        ltTitulo = new javax.swing.JLabel();
        jtGenero = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cbAtivo = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        enfeite = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(7, 2, 0, 2));
        jPanel1.add(jLabel7);
        jPanel1.add(jLabel8);
        jPanel1.add(jLabel10);
        jPanel1.add(jLabel9);

        lcTitulo.setText("Genero:");
        lcTitulo.setPreferredSize(new java.awt.Dimension(6, 20));
        jPanel1.add(lcTitulo);

        jcbGenero.setPreferredSize(new java.awt.Dimension(6, 20));
        jcbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGeneroActionPerformed(evt);
            }
        });
        jPanel1.add(jcbGenero);

        ltTitulo.setText("Genero:");
        ltTitulo.setPreferredSize(new java.awt.Dimension(6, 20));
        jPanel1.add(ltTitulo);
        jPanel1.add(jtGenero);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("G E N E R O");
        jPanel2.add(jLabel1);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        cbAtivo.setText("Ativo");
        cbAtivo.setEnabled(false);
        cbAtivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cbAtivo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(cbAtivo);

        add(jPanel4, java.awt.BorderLayout.LINE_END);

        jPanel5.setLayout(new java.awt.GridLayout());

        enfeite.setText("Enf.");
        jPanel5.add(enfeite);

        add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        btnSalvar.setText("SALVAR");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalvar);
        jPanel3.add(jLabel4);

        btnDeletar.setText("DELETAR");
        btnDeletar.setEnabled(false);
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        jPanel3.add(btnDeletar);
        jPanel3.add(jLabel6);

        jButton2.setText("FECHAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        add(jPanel3, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Constantes.getMain().getJtpMain().remove(Constantes.getMain().getJtpMain().getSelectedComponent());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (jtGenero.getText().equals("") && btnSalvar.getText().equals("SALVAR")) {
            text = "Por gentileza preencher o campo para GENERO";
        } else {
            try {
                if (btnSalvar.getText().equals("EDITAR")) {
                    Constantes.getLgenero().get(jcbGenero.getSelectedIndex() - 1).setAtivo(cbAtivo.isSelected());
                    resultado = Constantes.getMg().doGenero(Constantes.getLgenero().get(jcbGenero.getSelectedIndex() - 1), false);
                } else {
                    Constantes.setTg(new TGenero((long) 0));
                    Constantes.getTg().setNome(jtGenero.getText());
                    Constantes.getTg().setAtivo(cbAtivo.isSelected());
                    resultado = Constantes.getMg().doGenero(Constantes.getTg(), false);
                }

                if (btnSalvar.getText().equals("EDITAR")) {
                    if (resultado == 0) {
                        text = "Problema ao realizar a edi????o de " + Constantes.getLgenero().get(jcbGenero.getSelectedIndex() - 1).getNome();
                    } else {
                        text = Constantes.getLgenero().get(jcbGenero.getSelectedIndex() - 1).getNome() + " editado com sucesso!";
                        Limpa();
                    }
                } else {
                    if (resultado == 0) {
                        text = "Problema ao realizar o cadastro de " + Constantes.getTg().getNome().toUpperCase() + " genero ja existente!";
                    } else {
                        text = Constantes.getTg().getNome().toUpperCase() + " Cadastrado com sucesso!";
                        Limpa();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Form_Genero.class.getName()).log(Level.SEVERE, null, ex);
                text = "Erro ao " + btnSalvar.getText().toLowerCase() + "!";
            }
        }
        JOptionPane.showMessageDialog(this, text);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        try {
            resultado = Constantes.getMg().doGenero(Constantes.getLgenero().get(jcbGenero.getSelectedIndex() - 1), true);

            if (resultado == 0) {
                text = "Problema ao deletar " + Constantes.getLgenero().get(jcbGenero.getSelectedIndex() - 1).getNome();
            } else {
                text = Constantes.getLgenero().get(jcbGenero.getSelectedIndex() - 1).getNome() + " deletado com sucesso!";
                Limpa();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Form_Genero.class.getName()).log(Level.SEVERE, null, ex);
            text = "Erro ao executar o delete!";
        }
        JOptionPane.showMessageDialog(this, text);
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void jcbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGeneroActionPerformed
        btnDeletar.setEnabled(jcbGenero.getSelectedIndex() != 0);
        btnSalvar.setEnabled(jcbGenero.getSelectedIndex() != 0);
        cbAtivo.setEnabled(jcbGenero.getSelectedIndex() != 0);
        if (jcbGenero.getSelectedIndex() != 0) {
            cbAtivo.setSelected(Constantes.getLgenero().get(jcbGenero.getSelectedIndex() - 1).getAtivo());
        }
    }//GEN-LAST:event_jcbGeneroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbAtivo;
    private javax.swing.JLabel enfeite;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JComboBox<String> jcbGenero;
    private javax.swing.JTextField jtGenero;
    private javax.swing.JLabel lcTitulo;
    private javax.swing.JLabel ltTitulo;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JComboBox<String> getJcbGenero() {
        return jcbGenero;
    }

    public javax.swing.JLabel getLcTitulo() {
        return lcTitulo;
    }

    public javax.swing.JTextField getJtGenero() {
        return jtGenero;
    }

    public javax.swing.JLabel getLtTitulo() {
        return ltTitulo;
    }

    public javax.swing.JButton getBtnSalvar() {
        return btnSalvar;
    }

    public javax.swing.JButton getBtnDeletar() {
        return btnDeletar;
    }

    public javax.swing.JCheckBox getCbAtivo() {
        return cbAtivo;
    }

    private void Limpa() {
        try {
            Constantes.getMet().makeJCBGenero(jcbGenero, true);
            cbAtivo.setSelected(false);
            jtGenero.setText("");
            cbAtivo.setEnabled(btnSalvar.getText().equals("SALVAR"));
        } catch (SQLException ex) {
            Logger.getLogger(Form_Genero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
