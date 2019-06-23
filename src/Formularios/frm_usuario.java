
package Formularios;

import Dao.ModuloConexao;
import java.awt.Image;
//import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/*
  CRUD DA TABELA USUÁRIOS
  @author Andre Franklin
*/
public class frm_usuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

/**
 * Creates new form frm_usuario
*/
    public frm_usuario() {
        initComponents();
        conexao = ModuloConexao.Conector();
    }

//---------------------------------------------------------------------------------------------------------------------------------
    //Método adicionar novo usuário
    private void adicionar() {
        String sql = "insert into tb_usuario( matricula_usu, login_usu, senha_usu, perfil_usu) values(?,?,?,?)";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, txt_matriculaUsu.getText());
            pst.setString(2, txt_loginUsu.getText());
            pst.setString(3, txt_senhaUsu.getText());
            pst.setString(4, cbb_perfil.getSelectedItem().toString());

            if ((txt_matriculaUsu.getText().isEmpty()) || (txt_loginUsu.getText().isEmpty()) || (txt_senhaUsu.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");

                txt_Pesq_usuario.requestFocus();
                txt_matriculaUsu.setText(null);
                txt_loginUsu.setText(null);
                txt_senhaUsu.setText(null);
                txt_matriculaUsu.requestFocus();//Aponta cursor para o campo matricula.

            } else {
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso!");

                    txt_matriculaUsu.setText(null);
                    txt_loginUsu.setText(null);
                    txt_senhaUsu.setText(null);
                    tb_usuario.setModel(new DefaultTableModel(null, new String[]{"ID", "MATRICULA", "LOGIN", "SENHA", "PERFIL"}));
                    txt_Pesq_usuario.setText(null);
                    txt_Pesq_usuario.requestFocus();//Aponta cursor para o campo matricula.
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

//---------------------------------------------------------------------------------------------------------------------------------
    //Método pesquisar usuário
    private void pesquisar_usuario() {

        //String Sql = "select * from tb_usuario where matricula_usu like?";
        String sql = "Select id_usu as ID, matricula_usu as MATRICULA, login_usu as LOGIN, senha_usu as SENHA, perfil_usu as PERFIL from tb_usuario where login_usu like?";

        try {
            pst = conexao.prepareStatement(sql);
            //Passando o conteudo da caixa de pesquisa para o ?
            //atenção ao % - continuação da string SQL.
            pst.setString(1, txt_Pesq_usuario.getText() + "%");
            rs = pst.executeQuery();
            //A linha abaixo usa a biblioteca para preencher a tabela.
            tb_usuario.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

//---------------------------------------------------------------------------------------------------------------------------------    
//METODOS SETAR CAMPOS
    public void SetarCamposUsuarios() {

        int setar = tb_usuario.getSelectedRow();

        txt_IdUsu.setText(tb_usuario.getModel().getValueAt(setar, 0).toString());
        txt_matriculaUsu.setText(tb_usuario.getModel().getValueAt(setar, 1).toString());
        txt_loginUsu.setText(tb_usuario.getModel().getValueAt(setar, 2).toString());
        txt_senhaUsu.setText(tb_usuario.getModel().getValueAt(setar, 3).toString());
        cbb_perfil.setSelectedItem(tb_usuario.getModel().getValueAt(setar, 4).toString());

        //A linha abaixo desabilitar o botão adicionar.
        //btn_novoUsu.setEnabled(false);
    }

//---------------------------------------------------------------------------------------------------------------------------------
    //Método alterar usuário
    private void alterar() {

        String sql = "update tb_usuario set matricula_usu=?, login_usu=?, senha_usu=?, perfil_usu=? where id_usu=?";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, txt_matriculaUsu.getText());
            pst.setString(2, txt_loginUsu.getText());
            pst.setString(3, txt_senhaUsu.getText());
            pst.setString(4, cbb_perfil.getSelectedItem().toString());
            pst.setString(5, txt_IdUsu.getText());

            if ((txt_matriculaUsu.getText().isEmpty()) || (txt_loginUsu.getText().isEmpty()) || (txt_senhaUsu.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");

            } else {

                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do usuário alterados com sucesso!");
                    
                     
                    txt_matriculaUsu.setText(null);
                    txt_loginUsu.setText(null);
                    txt_senhaUsu.setText(null);
                    tb_usuario.setModel(new DefaultTableModel(null, new String[]{"ID", "MATRICULA", "LOGIN", "SENHA", "PERFIL"}));
                    txt_Pesq_usuario.setText(null);
                    txt_Pesq_usuario.requestFocus();//Aponta cursor para o campo matricula. 
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

//---------------------------------------------------------------------------------------------------------------------------------    
    //Método cancelar usuário    
    //Apaga os campos do cadastro
    private void cancelar() {

        txt_matriculaUsu.setText(null);
        txt_loginUsu.setText(null);
        txt_senhaUsu.setText(null);
        tb_usuario.setModel(new DefaultTableModel(null, new String[]{"ID", "MATRICULA", "LOGIN", "SENHA", "PERFIL"}));
        txt_Pesq_usuario.setText(null);
        txt_Pesq_usuario.requestFocus();//Aponta cursor para o campo matricula.

    }

//---------------------------------------------------------------------------------------------------------------------------------    
    //Método remover usuário
    private void remover() {

        int confirma = JOptionPane.showConfirmDialog(null, " Tem certeza que deseja remover este Usuário?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tb_usuario where id_usu=?";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txt_IdUsu.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados removidos com sucesso!");

                    txt_Pesq_usuario.setText(null);
                    txt_IdUsu.setText(null);
                    txt_matriculaUsu.setText(null);
                    txt_loginUsu.setText(null);
                    txt_senhaUsu.setText(null);                    
                    tb_usuario.setModel(new DefaultTableModel(null, new String[]{"ID", "MATRICULA", "LOGIN", "SENHA", "PERFIL"}));
                    txt_matriculaUsu.requestFocus(); //Aponta cursor para o campo Pesquisar usuário.
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_alterarUsu = new javax.swing.JButton();
        btn_cancelarUsu = new javax.swing.JButton();
        btn_removerUsu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_novoUsu = new javax.swing.JButton();
        txt_senhaUsu = new javax.swing.JTextField();
        txt_loginUsu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbb_perfil = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_matriculaUsu = new javax.swing.JFormattedTextField();
        txt_Pesq_usuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_usuario = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txt_IdUsu = new javax.swing.JFormattedTextField();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("Usuários");
        setToolTipText("");
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setPreferredSize(new java.awt.Dimension(95, 35));
        getContentPane().setLayout(null);

        btn_alterarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/editar.png"))); // NOI18N
        btn_alterarUsu.setToolTipText("Alterar");
        btn_alterarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterarUsuActionPerformed(evt);
            }
        });
        btn_alterarUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_alterarUsuKeyPressed(evt);
            }
        });
        getContentPane().add(btn_alterarUsu);
        btn_alterarUsu.setBounds(120, 350, 80, 40);

        btn_cancelarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Cancelar.png"))); // NOI18N
        btn_cancelarUsu.setToolTipText("Cancelar");
        btn_cancelarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarUsuActionPerformed(evt);
            }
        });
        btn_cancelarUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_cancelarUsuKeyPressed(evt);
            }
        });
        getContentPane().add(btn_cancelarUsu);
        btn_cancelarUsu.setBounds(220, 350, 90, 40);

        btn_removerUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/excluir.png"))); // NOI18N
        btn_removerUsu.setToolTipText("Excluir");
        btn_removerUsu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_removerUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removerUsuActionPerformed(evt);
            }
        });
        btn_removerUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_removerUsuKeyPressed(evt);
            }
        });
        getContentPane().add(btn_removerUsu);
        btn_removerUsu.setBounds(330, 350, 90, 40);

        jLabel1.setText("Matricula*");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 210, 100, 14);

        jLabel3.setText("Senha*");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 270, 75, 20);

        btn_novoUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/adicionar.png"))); // NOI18N
        btn_novoUsu.setToolTipText("Novo");
        btn_novoUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoUsuActionPerformed(evt);
            }
        });
        getContentPane().add(btn_novoUsu);
        btn_novoUsu.setBounds(20, 350, 80, 40);
        getContentPane().add(txt_senhaUsu);
        txt_senhaUsu.setBounds(20, 290, 170, 30);

        txt_loginUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_loginUsuActionPerformed(evt);
            }
        });
        getContentPane().add(txt_loginUsu);
        txt_loginUsu.setBounds(150, 230, 240, 30);

        jLabel4.setText("Login*");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(150, 210, 71, 20);

        jLabel5.setText("Perfil");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(210, 270, 120, 20);

        cbb_perfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Atendente", "Administrador" }));
        getContentPane().add(cbb_perfil);
        cbb_perfil.setBounds(210, 290, 180, 30);

        jLabel2.setText("* Campos Obrigatórios");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 180, 270, 20);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/usuario2-100x100.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(440, 230, 110, 100);

        try {
            txt_matriculaUsu.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txt_matriculaUsu);
        txt_matriculaUsu.setBounds(20, 230, 110, 30);

        txt_Pesq_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Pesq_usuarioActionPerformed(evt);
            }
        });
        txt_Pesq_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Pesq_usuarioKeyReleased(evt);
            }
        });
        getContentPane().add(txt_Pesq_usuario);
        txt_Pesq_usuario.setBounds(20, 30, 360, 30);

        jLabel7.setText("Pesquisar Login");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 10, 260, 20);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/search.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(390, 30, 24, 30);

        tb_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "LOGIN", "SENHA", "PERFIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_usuario.getTableHeader().setReorderingAllowed(false);
        tb_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_usuarioMouseClicked(evt);
            }
        });
        tb_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_usuarioKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tb_usuario);
        if (tb_usuario.getColumnModel().getColumnCount() > 0) {
            tb_usuario.getColumnModel().getColumn(0).setResizable(false);
            tb_usuario.getColumnModel().getColumn(0).setPreferredWidth(20);
            tb_usuario.getColumnModel().getColumn(1).setPreferredWidth(60);
            tb_usuario.getColumnModel().getColumn(2).setPreferredWidth(60);
            tb_usuario.getColumnModel().getColumn(3).setPreferredWidth(40);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 80, 560, 100);

        jLabel9.setText("ID*");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(470, 10, 100, 14);

        txt_IdUsu.setBorder(null);
        try {
            txt_IdUsu.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_IdUsu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_IdUsu.setEnabled(false);
        txt_IdUsu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txt_IdUsu);
        txt_IdUsu.setBounds(470, 30, 110, 30);

        setBounds(0, 0, 602, 431);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_alterarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarUsuActionPerformed
        // Chamar o método alterar
        alterar();
    }//GEN-LAST:event_btn_alterarUsuActionPerformed

    private void btn_removerUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerUsuActionPerformed
        // Chamar o método remover
        remover();
    }//GEN-LAST:event_btn_removerUsuActionPerformed

    private void btn_novoUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoUsuActionPerformed
        // Chamar o metodo adicionar
        adicionar();
    }//GEN-LAST:event_btn_novoUsuActionPerformed

    private void txt_loginUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_loginUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_loginUsuActionPerformed

    private void btn_alterarUsuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_alterarUsuKeyPressed
        // Chamar metodo alterar pressionando enter
        alterar();
    }//GEN-LAST:event_btn_alterarUsuKeyPressed

    private void btn_removerUsuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_removerUsuKeyPressed
        // Chamar o método remover pressionando enter
        remover();
    }//GEN-LAST:event_btn_removerUsuKeyPressed

    private void btn_cancelarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarUsuActionPerformed
        // Chamar o método cancelar
        cancelar();
    }//GEN-LAST:event_btn_cancelarUsuActionPerformed

    private void btn_cancelarUsuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_cancelarUsuKeyPressed
        // Chamar o método cancelar
        cancelar();
    }//GEN-LAST:event_btn_cancelarUsuKeyPressed

    private void txt_Pesq_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Pesq_usuarioActionPerformed
        // TODO add your handling code here:
        pesquisar_usuario();
    }//GEN-LAST:event_txt_Pesq_usuarioActionPerformed

    private void txt_Pesq_usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Pesq_usuarioKeyReleased
        // Metodo Pesquisar usuário
        pesquisar_usuario();
    }//GEN-LAST:event_txt_Pesq_usuarioKeyReleased

    private void tb_usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_usuarioKeyReleased

    }//GEN-LAST:event_tb_usuarioKeyReleased

    private void tb_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_usuarioMouseClicked
        // Setar campos da tabela clicando com o mouse
        SetarCamposUsuarios();
    }//GEN-LAST:event_tb_usuarioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alterarUsu;
    private javax.swing.JButton btn_cancelarUsu;
    private javax.swing.JButton btn_novoUsu;
    private javax.swing.JButton btn_removerUsu;
    private javax.swing.JComboBox<String> cbb_perfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_usuario;
    private javax.swing.JFormattedTextField txt_IdUsu;
    private javax.swing.JTextField txt_Pesq_usuario;
    private javax.swing.JTextField txt_loginUsu;
    private javax.swing.JFormattedTextField txt_matriculaUsu;
    private javax.swing.JTextField txt_senhaUsu;
    // End of variables declaration//GEN-END:variables

    private void setIconImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
