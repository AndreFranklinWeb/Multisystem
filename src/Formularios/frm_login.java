package Formularios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Dao.ModuloConexao;
import java.awt.Color;
//import java.awt.Toolkit;
//import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Andre Franklin
 */
public class frm_login extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public frm_login() {
        initComponents();
        conexao = ModuloConexao.Conector();
        if (conexao != null) {
            lbl_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/database_accept.png")));
        } else {
            lbl_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/database_remove.png")));
        }
    }
    
   
    public void logar() {

        String sql = "select * from tb_usuario where login_usu=? and senha_usu=?";
        /*As linhas abaixo preparam a consulta ao banco, em função dos dados digitados nas caixa de texto.
        é substituido pelo conteudo das variaveis.*/

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_usuariolog.getText());
            pst.setString(2, txt_senhalog.getText());
            //a linha abaixo executa a query
            rs = pst.executeQuery();
            //se existir usuario e senha correspondente
            if (rs.next()) {
                //a linha abaixo obtem o conteúdo do campo perfil da tabela de usuario.
                String perfil = rs.getString(5);
                //System.out.println(perfil);
                //a estrutura abaixo faz o tratamento do perfil do usuario.
                if (perfil.equals("Administrador")) {
                    frm_menu principal = new frm_menu();
                    principal.setVisible(true);
                    
                    frm_menu.MenRel.setEnabled(true);
                    frm_menu.MenUsuario.setEnabled(true);
                    frm_menu.lbl_usuarioMenu.setText(rs.getString(3));
                    frm_menu.lbl_usuarioMenu.setForeground(Color.BLUE);
                    this.dispose();
                    conexao.close();
                } else {
                    // a linha abaixo abri o menu principal com as opcões desativadas.
                    frm_menu principal = new frm_menu();
                    principal.setVisible(true);
                    frm_menu.lbl_usuarioMenu.setText(rs.getString(3));
                    frm_menu.lbl_usuarioMenu.setForeground(Color.RED);
                    this.dispose();
                   
                }
            } else {
                JOptionPane.showMessageDialog(null, " Usuário ou senha inválida(os) ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_acessarlog = new javax.swing.JButton();
        txt_senhalog = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_usuariolog = new javax.swing.JTextField();
        lbl_status = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AUTENTICAÇÃO DO USUÁRIO");
        setResizable(false);
        getContentPane().setLayout(null);

        btn_acessarlog.setText("Login");
        btn_acessarlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acessarlogActionPerformed(evt);
            }
        });
        btn_acessarlog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_acessarlogKeyPressed(evt);
            }
        });
        getContentPane().add(btn_acessarlog);
        btn_acessarlog.setBounds(80, 350, 80, 30);

        txt_senhalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_senhalogActionPerformed(evt);
            }
        });
        txt_senhalog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_senhalogKeyPressed(evt);
            }
        });
        getContentPane().add(txt_senhalog);
        txt_senhalog.setBounds(20, 300, 190, 30);

        jLabel1.setText("Login ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 220, 80, 14);

        jLabel2.setText("Senha");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 280, 120, 14);
        getContentPane().add(txt_usuariolog);
        txt_usuariolog.setBounds(20, 240, 190, 30);

        lbl_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/database_accept.png"))); // NOI18N
        getContentPane().add(lbl_status);
        lbl_status.setBounds(20, 340, 30, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/login (1).png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(220, 210, 120, 140);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/LogoMultiSystem.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 10, 340, 190);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Versão 1.2 - Junho 2019");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(230, 410, 130, 20);

        setSize(new java.awt.Dimension(375, 465));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_acessarlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acessarlogActionPerformed
        // MÉTODO LOGAR
        logar();
    }//GEN-LAST:event_btn_acessarlogActionPerformed

    private void btn_acessarlogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_acessarlogKeyPressed
        // Botão Logar do login
        logar();
    }//GEN-LAST:event_btn_acessarlogKeyPressed

    private void txt_senhalogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_senhalogKeyPressed
        // Abrir teclando enter           
        
    }//GEN-LAST:event_txt_senhalogKeyPressed

    private void txt_senhalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_senhalogActionPerformed
        // TODO add your handling code here:
        logar();
    }//GEN-LAST:event_txt_senhalogActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_acessarlog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JPasswordField txt_senhalog;
    private javax.swing.JTextField txt_usuariolog;
    // End of variables declaration//GEN-END:variables
}
