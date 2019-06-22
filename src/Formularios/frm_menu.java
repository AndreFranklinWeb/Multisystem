/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre Franklin
 */
public class frm_menu extends javax.swing.JFrame {

    /**
     * Creates new form frm_menu
     */
    public frm_menu() {
        initComponents();
    }
    
    
    /**

     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        lbl_dataMenu = new javax.swing.JLabel();
        lbl_usuarioMenu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        MenRel = new javax.swing.JMenu();
        MenRelCli = new javax.swing.JMenuItem();
        MenOpc = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        MenSobre = new javax.swing.JMenuItem();
        MenSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MultiSystem");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(desktop);
        desktop.setBounds(0, 0, 1110, 670);

        lbl_dataMenu.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lbl_dataMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dataMenu.setText("Data");
        getContentPane().add(lbl_dataMenu);
        lbl_dataMenu.setBounds(1120, 340, 220, 40);

        lbl_usuarioMenu.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lbl_usuarioMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_usuarioMenu.setText("Usuário");
        getContentPane().add(lbl_usuarioMenu);
        lbl_usuarioMenu.setBounds(1120, 130, 220, 40);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/LogoMultiSystem.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1120, 430, 220, 220);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/usuario3-100x100 (2).png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1140, 20, 180, 110);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/calendario-100x100.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1180, 230, 110, 110);

        jMenuBar1.setAlignmentX(0.0F);

        jMenu1.setText("Cadastros");

        MenUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        MenUsuario.setText("Usuários");
        MenUsuario.setEnabled(false);
        MenUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(MenUsuario);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Manutenção");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem2.setText("Entrada e Saida de  Equip.");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem4.setText("Histórico de Equip.");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        MenRel.setText("Relatórios");
        MenRel.setEnabled(false);

        MenRelCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        MenRelCli.setText("Rel.Patrimônios");
        MenRel.add(MenRelCli);

        jMenuBar1.add(MenRel);

        MenOpc.setText("Opções");
        MenOpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenOpcActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        jMenuItem1.setText("Ajuda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenOpc.add(jMenuItem1);

        MenSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        MenSobre.setText("Sobre");
        MenSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenSobreActionPerformed(evt);
            }
        });
        MenOpc.add(MenSobre);

        MenSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        MenSair.setText("Sair");
        MenSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenSairActionPerformed(evt);
            }
        });
        MenOpc.add(MenSair);

        jMenuBar1.add(MenOpc);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleName("");

        setSize(new java.awt.Dimension(1366, 719));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // A linha abaixo troca o lbl_data pela data atual
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lbl_dataMenu.setText(formatador.format(data));


    }//GEN-LAST:event_formWindowActivated

    private void MenOpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenOpcActionPerformed
        // TESTE

    }//GEN-LAST:event_MenOpcActionPerformed

    private void MenSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenSobreActionPerformed
        // Chamar o frm_Sobre
        frm_sobre sobre = new frm_sobre();
        sobre.setVisible(true);

    }//GEN-LAST:event_MenSobreActionPerformed

    private void MenSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenSairActionPerformed
        // Sair do sistema
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair do Sistema?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_MenSairActionPerformed

    private void MenUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenUsuarioActionPerformed
        // a linha abaixo vai  abrir a tela usuario dentro do Desktop Pane.
        frm_usuario usuario = new frm_usuario();
        usuario.setVisible(true);
        desktop.add(usuario);
    }//GEN-LAST:event_MenUsuarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // Abri o formulario de entrada e saida de equip.
        frm_EntraSai EntradaSaida = new frm_EntraSai();
        EntradaSaida.setVisible(true);
        desktop.add(EntradaSaida);        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(frm_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenOpc;
    public static javax.swing.JMenu MenRel;
    private javax.swing.JMenuItem MenRelCli;
    private javax.swing.JMenuItem MenSair;
    private javax.swing.JMenuItem MenSobre;
    public static javax.swing.JMenuItem MenUsuario;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JLabel lbl_dataMenu;
    public static javax.swing.JLabel lbl_usuarioMenu;
    // End of variables declaration//GEN-END:variables
}
