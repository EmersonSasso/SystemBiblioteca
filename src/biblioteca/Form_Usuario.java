/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hemerson Mendes
 */
public class Form_Usuario extends javax.swing.JPanel {

    /**
     * Creates new form Usuario
     */
    public Form_Usuario() {
        initComponents();
        Enfeite.setVisible(false);

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
        lcUsuario = new javax.swing.JLabel();
        jcbUsuario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        ltUsuario = new javax.swing.JLabel();
        jtUsuario = new javax.swing.JTextField();
        lSenha = new javax.swing.JLabel();
        jpSenha = new javax.swing.JPasswordField();
        lConfSenha = new javax.swing.JLabel();
        jpConfSenha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        cbSenha = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cbAtivo = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        Enfeite = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(6, 2));

        lcUsuario.setText("Usuario:");
        jPanel1.add(lcUsuario);

        jcbUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(jcbUsuario);

        jLabel3.setText("Nome:");
        jPanel1.add(jLabel3);
        jPanel1.add(jtNome);

        ltUsuario.setText("Usuario");
        jPanel1.add(ltUsuario);
        jPanel1.add(jtUsuario);

        lSenha.setText("Senha:");
        jPanel1.add(lSenha);
        jPanel1.add(jpSenha);

        lConfSenha.setText("Confirme Senha:");
        jPanel1.add(lConfSenha);
        jPanel1.add(jpConfSenha);
        jPanel1.add(jLabel5);

        cbSenha.setText("Resetar Senha");
        cbSenha.setEnabled(false);
        cbSenha.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        cbSenha.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        cbSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(cbSenha);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("U S U A R I O");
        jPanel2.add(jLabel1);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.GridLayout());

        cbAtivo.setText("Ativo");
        cbAtivo.setEnabled(false);
        cbAtivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cbAtivo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(cbAtivo);

        add(jPanel4, java.awt.BorderLayout.LINE_END);

        jPanel5.setLayout(new java.awt.GridLayout());

        Enfeite.setText("Enf.");
        jPanel5.add(Enfeite);

        add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));
        jPanel6.add(jLabel4);

        btnSalvar.setText("SALVAR");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel6.add(btnSalvar);
        jPanel6.add(jLabel6);

        jButton2.setText("FECHAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2);
        jPanel6.add(jLabel2);

        add(jPanel6, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        text = "";
        if (jtUsuario.getText().equals("") && btnSalvar.getText().equals("SALVAR")) {
            text = text + "- Preencher o Usuario\n";
        }
        if (jtNome.getText().equals("") && btnSalvar.getText().equals("SALVAR")) {
            text = text + "- Preencher o Nome\n";
        }
        if ((!(Constantes.getMet().passToString(jpSenha.getPassword()).equals(Constantes.getMet().passToString(jpConfSenha.getPassword())))
                || Constantes.getMet().passToString(jpSenha.getPassword()).equals("")) && btnSalvar.getText().equals("SALVAR") && cbSenha.isSelected()) {
            text = text + "- As senhas digitadas nao sao Iguais ou estão em branco\n";
        }
        if ("".equals(text)) {
            try {
                if (btnSalvar.getText().equals("EDITAR")) {
                    Constantes.getLusuario().get(jcbUsuario.getSelectedIndex() - 1).setNome(jtNome.getText());
                    Constantes.getLusuario().get(jcbUsuario.getSelectedIndex() - 1).setAtivo(cbAtivo.isSelected());
                    Constantes.getLusuario().get(jcbUsuario.getSelectedIndex() - 1).setSenha(Constantes.getMet().passToString(jpSenha.getPassword()));
                    Constantes.getLusuario().get(jcbUsuario.getSelectedIndex() - 1).setLogin(jtUsuario.getText());
                    resultado = Constantes.getMu().doUser(Constantes.getLusuario().get(jcbUsuario.getSelectedIndex() - 1), false);
                } else {
                    Constantes.setVwusuario(new VwUsuario());
                    Constantes.getVwusuario().setLogin(jtUsuario.getText());
                    Constantes.getVwusuario().setUsuarioId(BigInteger.valueOf(0));
                    Constantes.getVwusuario().setNome(jtNome.getText());
                    Constantes.getVwusuario().setSenha(Constantes.getMet().passToString(jpSenha.getPassword()));
                    Constantes.getVwusuario().setAtivo(cbAtivo.isSelected());
                    resultado = Constantes.getMu().doUser(Constantes.getVwusuario(), false);
                }

                if (btnSalvar.getText().equals("EDITAR")) {
                    if (resultado == 0) {
                        text = "Problema ao realizar a edição de " + Constantes.getLusuario().get(jcbUsuario.getSelectedIndex() - 1).getLogin().toUpperCase();
                    } else {
                        text = Constantes.getLusuario().get(jcbUsuario.getSelectedIndex() - 1).getLogin().toUpperCase() + " editado com sucesso!";
                        Limpa();
                    }
                } else {
                    if (resultado == 0) {
                        text = "Problema ao realizar o cadastro de " + Constantes.getVwusuario().getNome().toUpperCase() + " Login ja existente!";
                    } else {
                        text = Constantes.getVwusuario().getNome().toUpperCase() + " Cadastrado com sucesso!";
                        Limpa();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Form_Genero.class.getName()).log(Level.SEVERE, null, ex);
                text = "Erro ao " + btnSalvar.getText().toLowerCase() + "!";
            }
        } else {
            text = "Por favor se atentar ao seguinte: \n\n" + text;
        }
        JOptionPane.showMessageDialog(this, text);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Constantes.getMain().getJtpMain().remove(Constantes.getMain().getJtpMain().getSelectedComponent());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jcbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbUsuarioActionPerformed
        if (cbSenha.isSelected()) {
            cbSenha.doClick();
        }
        btnSalvar.setEnabled(jcbUsuario.getSelectedIndex() != 0);
        cbAtivo.setEnabled(jcbUsuario.getSelectedIndex() != 0);
        cbSenha.setEnabled(jcbUsuario.getSelectedIndex() != 0);
        jtNome.setText("");
        cbAtivo.setSelected(false);

        if (jcbUsuario.getSelectedIndex() != 0) {
            cbAtivo.setSelected(Constantes.getLusuario().get(jcbUsuario.getSelectedIndex() - 1).getAtivo());
            jtNome.setText(Constantes.getLusuario().get(jcbUsuario.getSelectedIndex() - 1).getNome());
            jtUsuario.setText(Constantes.getLusuario().get(jcbUsuario.getSelectedIndex() - 1).getLogin());
        }
    }//GEN-LAST:event_jcbUsuarioActionPerformed

    private void cbSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSenhaActionPerformed
        jpSenha.setEnabled(cbSenha.isSelected());
        jpConfSenha.setEnabled(cbSenha.isSelected());
    }//GEN-LAST:event_cbSenhaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Enfeite;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbAtivo;
    private javax.swing.JCheckBox cbSenha;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JComboBox<String> jcbUsuario;
    private javax.swing.JPasswordField jpConfSenha;
    private javax.swing.JPasswordField jpSenha;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtUsuario;
    private javax.swing.JLabel lConfSenha;
    private javax.swing.JLabel lSenha;
    private javax.swing.JLabel lcUsuario;
    private javax.swing.JLabel ltUsuario;
    // End of variables declaration//GEN-END:variables
 private void Limpa() {
        try {
            Constantes.getMu().makeJCBusuario(jcbUsuario, true);
            cbAtivo.setSelected(false);
            jtUsuario.setText("");
            jtNome.setText("");
            jpConfSenha.setText("");
            jpSenha.setText("");
            cbSenha.setSelected(!btnSalvar.getText().equals("EDITAR"));
        } catch (SQLException ex) {
            Logger.getLogger(Form_Genero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public javax.swing.JButton getBtnSalvar() {
        return btnSalvar;
    }

    public javax.swing.JComboBox<String> getJcbUsuario() {
        return jcbUsuario;
    }

    public javax.swing.JPasswordField getJpConfSenha() {
        return jpConfSenha;
    }

    public javax.swing.JPasswordField getJpSenha() {
        return jpSenha;
    }

    public javax.swing.JTextField getJtUsuario() {
        return jtUsuario;
    }

    public javax.swing.JLabel getLcUsuario() {
        return lcUsuario;
    }

    public javax.swing.JCheckBox getCbAtivo() {
        return cbAtivo;
    }

    public javax.swing.JLabel getLtUsuario() {
        return ltUsuario;
    }

    public javax.swing.JLabel getlConfSenha() {
        return lConfSenha;
    }

    public javax.swing.JLabel getlSenha() {
        return lSenha;
    }

    public javax.swing.JCheckBox getCbSenha() {
        return cbSenha;
    }
}
