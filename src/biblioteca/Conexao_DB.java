package biblioteca;

import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Conexao_DB extends javax.swing.JDialog {

    public Conexao_DB(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jLabel20.setVisible(false);
        jLabel8.setVisible(false);
        jLabel29.addMouseListener(popupListener);
        fieldHost.setEnabled(false);
        fieldAlias.setEnabled(false);
        fieldPort.setEnabled(false);
        this.setIconImage(new ImageIcon(System.getProperty("user.dir") + "\\imagens\\system_icon.png").getImage());
        getRootPane().setDefaultButton(buttonOK);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        buttonOK = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        buttonSair = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        fieldHost = new javax.swing.JTextField();
        fieldPort = new javax.swing.JTextField();
        fieldAlias = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        fieldLogin = new javax.swing.JTextField();
        fieldPassword = new javax.swing.JPasswordField();
        jLabel23 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(Constantes.getVersion());
        setMinimumSize(new java.awt.Dimension(380, 380));
        setPreferredSize(new java.awt.Dimension(380, 380));
        setResizable(false);

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel30);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Entre com as informações de login");
        jPanel2.add(jLabel21);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.GridLayout(2, 5));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(jLabel10);

        buttonOK.setText("OK");
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });
        jPanel3.add(buttonOK);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(jLabel11);

        buttonSair.setText("Sair");
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });
        jPanel3.add(buttonSair);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(jLabel12);

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(jLabel25);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(jLabel26);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(jLabel27);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(jLabel28);

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(jLabel29);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel5.setLayout(new java.awt.GridLayout(8, 1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel5.add(jLabel7);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Server:   ");
        jPanel5.add(jLabel1);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Port:    ");
        jPanel5.add(jLabel2);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Alias:    ");
        jPanel5.add(jLabel6);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("EnfeiteEnfeite");
        jPanel5.add(jLabel8);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Usuario:   ");
        jPanel5.add(jLabel5);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Senha:    ");
        jPanel5.add(jLabel4);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel5.add(jLabel9);

        getContentPane().add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel6.setLayout(new java.awt.GridLayout(8, 1));

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel6.add(jLabel31);

        fieldHost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldHostFocusGained(evt);
            }
        });
        jPanel6.add(fieldHost);

        fieldPort.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldPortFocusGained(evt);
            }
        });
        jPanel6.add(fieldPort);

        fieldAlias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldAliasFocusGained(evt);
            }
        });
        jPanel6.add(fieldAlias);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel6.add(jLabel22);

        fieldLogin.setText("adm");
        fieldLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldLoginFocusGained(evt);
            }
        });
        jPanel6.add(fieldLogin);

        fieldPassword.setText("1");
        fieldPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldPasswordFocusGained(evt);
            }
        });
        jPanel6.add(fieldPassword);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel6.add(jLabel23);

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridLayout(8, 0));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Enf");
        jPanel4.add(jLabel20);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(jLabel13);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(jLabel14);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(jLabel15);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(jLabel16);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(jLabel17);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(jLabel18);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(jLabel19);

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        if ("voltar".equals(buttonSair.getText().toLowerCase())) {
            Limpa(false);
            this.setVisible(false);
        } else {
            System.exit(1);
        }

    }//GEN-LAST:event_buttonSairActionPerformed

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        if (!("".equals(fieldPort.getText())) && (!("".equals(fieldHost.getText()))) && (!("".equals(fieldLogin.getText()))
                && (!("".equals(Constantes.getMet().passToString(fieldPassword.getPassword())))) && (!("".equals(fieldAlias.getText()))))) {

            Constantes.setHost(fieldHost.getText());
            Constantes.setPortNumber(fieldPort.getText());
            Constantes.setServico(fieldAlias.getText());

            try {
                if (Constantes.getMet().isConnected(fieldLogin.getText().toUpperCase(), fieldPassword.getPassword())) {
                    Limpa(true);
                    buttonSair.setText("Voltar");
                    this.setVisible(false);
                } else {
                    if (Constantes.isConectou()) {
                        JOptionPane.showMessageDialog(this, "Usuário e/ou Senha Inválida!\n\n"
                                + "Usuário inativo/inexistente!");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Conexao_DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Preencha os dados corretamente!");
        }
    }//GEN-LAST:event_buttonOKActionPerformed

    private void fieldHostFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldHostFocusGained
        fieldHost.selectAll();
    }//GEN-LAST:event_fieldHostFocusGained

    private void fieldPortFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldPortFocusGained
        fieldPort.selectAll();
    }//GEN-LAST:event_fieldPortFocusGained

    private void fieldAliasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldAliasFocusGained
        fieldAlias.selectAll();
    }//GEN-LAST:event_fieldAliasFocusGained

    private void fieldLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldLoginFocusGained
        fieldLogin.selectAll();
    }//GEN-LAST:event_fieldLoginFocusGained

    private void fieldPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldPasswordFocusGained
        fieldPassword.selectAll();
    }//GEN-LAST:event_fieldPasswordFocusGained
    // <editor-fold defaultstate="collapsed" desc="Declarações">  
    MouseListener popupListener = new PopupListener();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonOK;
    private javax.swing.JButton buttonSair;
    private javax.swing.JTextField fieldAlias;
    private javax.swing.JTextField fieldHost;
    private javax.swing.JTextField fieldLogin;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JTextField fieldPort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getFieldAlias() {
        return fieldAlias;
    }

    public javax.swing.JTextField getFieldHost() {
        return fieldHost;
    }

    public javax.swing.JTextField getFieldPort() {
        return fieldPort;
    }
// </editor-fold>  

    private void Limpa(boolean troca_usuario) {
        if ("voltar".equals(buttonSair.getText().toLowerCase())) {
            if (!troca_usuario) {
                if (JOptionPane.showOptionDialog(Constantes.getMain(),
                        "Deseja Limpar a tela principal?",
                        "Atenção", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null) == JOptionPane.YES_OPTION) {
                    Constantes.getMain().getJtpMain().removeAll();
                }
            } else {
                Constantes.getMain().getJtpMain().removeAll();
            }

        }
        fieldLogin.setText("");
        fieldPassword.setText("");
    }

    class PopupListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                switch (e.getModifiersEx()) {
                    case (InputEvent.CTRL_DOWN_MASK):
                        buttonOK.setEnabled(fieldHost.isEnabled());
                        fieldLogin.setEnabled(buttonOK.isEnabled());
                        fieldPassword.setEnabled(buttonOK.isEnabled());
                        fieldHost.setEnabled(!buttonOK.isEnabled());
                        fieldAlias.setEnabled(!buttonOK.isEnabled());
                        fieldPort.setEnabled(!buttonOK.isEnabled());
                        if (buttonOK.isEnabled()) {
                            Constantes.getMet().SaveFile(fieldHost.getText(), fieldAlias.getText(), fieldPort.getText());
                        }
                        break;
                    //case (InputEvent.SHIFT_DOWN_MASK):
                    //System.out.println("O shift estava pressionado "
                    //+"enquanto clicou com o mouse");
                    //break;
                    //case (InputEvent.ALT_DOWN_MASK):
                    //System.out.println("O alt estava pressionado "
                    //+ "enquanto clicou com o mouse");
                    //break;
                    default:
                        //System.out.println("Nenhum modificador...");
                        break;
                }

            }
        }
    }
}
