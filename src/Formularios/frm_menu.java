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
        MenCadastro = new javax.swing.JMenu();
        MenUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuEntraSai = new javax.swing.JMenuItem();
        MenuHistorico = new javax.swing.JMenuItem();
        MenRel = new javax.swing.JMenu();
        MenRelCli = new javax.swing.JMenuItem();
        MenOpc = new javax.swing.JMenu();
        MenuAjuda = new javax.swing.JMenuItem();
        MenuSobre = new javax.swing.JMenuItem();
        MenuSair = new javax.swing.JMenuItem();

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

        MenCadastro.setText("Cadastro");
        MenCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadastroActionPerformed(evt);
            }
        });

        MenUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        MenUsuario.setText("Usuários");
        MenUsuario.setEnabled(false);
        MenUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenUsuarioActionPerformed(evt);
            }
        });
        MenCadastro.add(MenUsuario);

        jMenuBar1.add(MenCadastro);

        jMenu2.setText("Manutenção");

        MenuEntraSai.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        MenuEntraSai.setText("Entrada e Saida de  Equip.");
        MenuEntraSai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEntraSaiActionPerformed(evt);
            }
        });
        jMenu2.add(MenuEntraSai);

        MenuHistorico.setText("Histórico de Equip.");
        MenuHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuHistoricoActionPerformed(evt);
            }
        });
        jMenu2.add(MenuHistorico);

        jMenuBar1.add(jMenu2);

        MenRel.setText("Relatórios");
        MenRel.setEnabled(false);

        MenRelCli.setText("Rel.Patrimônios");
        MenRel.add(MenRelCli);

        jMenuBar1.add(MenRel);

        MenOpc.setText("Opções");
        MenOpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenOpcActionPerformed(evt);
            }
        });

        MenuAjuda.setText("Ajuda");
        MenuAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAjudaActionPerformed(evt);
            }
        });
        MenOpc.add(MenuAjuda);

        MenuSobre.setText("Sobre");
        MenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSobreActionPerformed(evt);
            }
        });
        MenOpc.add(MenuSobre);

        MenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        MenuSair.setText("Sair");
        MenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSairActionPerformed(evt);
            }
        });
        MenOpc.add(MenuSair);

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

    private void MenuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSobreActionPerformed
        // Chamar o frm_Sobre
        frm_sobre sobre = new frm_sobre();
        sobre.setVisible(true);
        desktop.add(sobre);

    }//GEN-LAST:event_MenuSobreActionPerformed

    private void MenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSairActionPerformed
        // Sair do sistema
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair do Sistema?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_MenuSairActionPerformed

    private void MenUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenUsuarioActionPerformed
        // a linha abaixo vai  abrir a tela usuario dentro do Desktop Pane.
        frm_usuario usuario = new frm_usuario();
        usuario.setVisible(true);
        desktop.add(usuario);
    }//GEN-LAST:event_MenUsuarioActionPerformed

    private void MenuAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAjudaActionPerformed
        // TODO add your handling code here:
        frm_ajuda ajuda = new frm_ajuda();
        ajuda.setVisible(true);
        desktop.add(ajuda);
    }//GEN-LAST:event_MenuAjudaActionPerformed

    private void MenuEntraSaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEntraSaiActionPerformed
        // Abri o formulario de entrada e saida de equip.
        frm_EntraSai EntradaSaida = new frm_EntraSai();
        EntradaSaida.setVisible(true);
        desktop.add(EntradaSaida);        
    }//GEN-LAST:event_MenuEntraSaiActionPerformed

    private void MenuHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuHistoricoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuHistoricoActionPerformed

    private void MenCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenCadastroActionPerformed

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
    private javax.swing.JMenu MenCadastro;
    private javax.swing.JMenu MenOpc;
    public static javax.swing.JMenu MenRel;
    private javax.swing.JMenuItem MenRelCli;
    public static javax.swing.JMenuItem MenUsuario;
    private javax.swing.JMenuItem MenuAjuda;
    private javax.swing.JMenuItem MenuEntraSai;
    private javax.swing.JMenuItem MenuHistorico;
    private javax.swing.JMenuItem MenuSair;
    private javax.swing.JMenuItem MenuSobre;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbl_dataMenu;
    public static javax.swing.JLabel lbl_usuarioMenu;
    // End of variables declaration//GEN-END:variables
}
