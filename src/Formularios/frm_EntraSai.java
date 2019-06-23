
package Formularios;

import Dao.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Andre Franklin
 */
public class frm_EntraSai extends javax.swing.JInternalFrame {
    
    private static frm_EntraSai frm_entsai;
    
    public static frm_EntraSai getInstancia(){
        if(frm_entsai == null){
           frm_entsai = new frm_EntraSai(); 
        }
        return frm_entsai;
    }
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form frm_sisOperacional
     */
    public frm_EntraSai() {
        initComponents();
        conexao = ModuloConexao.Conector(); 
        
    }

    //---------------------------------------------------------------------------------------------------------------------------------
    //Método adicionar novo usuário
    private void adicionar() {
        String sql = "insert into tb_entrasai(patri_equip, gerencia_equip, tipo_equip, status_equip, chamado_equip, defeito_equip, data_entrada_equip, data_saida_equip) values(?,?,?,?,?,?,?,?)";
                        
        try {
            pst = conexao.prepareStatement(sql);            
            
            pst.setString(1, txt_patrominioPS.getText());
            pst.setString(2, txt_gerencia.getText().toUpperCase());            
            pst.setString(3, cbb_tipoEquip.getSelectedItem().toString());
            pst.setString(4, cbb_status.getSelectedItem().toString());                        
            pst.setString(5, txt_chamado.getText());
            pst.setString(6, txt_defeito.getText().toUpperCase());
            pst.setString(7, txt_dataEntrada.getText());
            pst.setString(8, txt_dataSaida.getText());            
            
            //VALIDAÇÃO DOS CAMPOS OBRIGATÓRIOS
        

            if ((txt_patrominioPS.getText().isEmpty()) || (txt_gerencia.getText().isEmpty()) || (txt_defeito.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");  
                
                    txt_pesquisarPS.requestFocus();//Aponta cursor para o campo matricula.
                    txt_idPS.setText(null);
                    txt_patrominioPS.setText(null);
                    txt_gerencia.setText(null);
                    txt_chamado.setText(null);
                    txt_defeito.setText(null);
                    txt_dataEntrada.setText(null);  
                    txt_dataSaida.setText(null);
                    txt_pesquisarPS.setText(null); 
                    txt_pesquisarPS.requestFocus();//Aponta cursor para o campo matricula.
                
            } else {
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Registro adicionado com sucesso!");

                    txt_idPS.setText(null);
                    txt_patrominioPS.setText(null);
                    txt_gerencia.setText(null);
                    txt_chamado.setText(null);
                    txt_defeito.setText(null);
                    txt_dataEntrada.setText(null);  
                    txt_dataSaida.setText(null);
                    tb_entsaiEquip.setModel(new DefaultTableModel(null, new String[]{"ID", "PATRIMÔNIO", "GERENCIA", "TIPO", "STATUS", "Nº CHAMADO", "DEFEITO", "DATA ENTRADA", "DATA SAIDA"}));
                    txt_pesquisarPS.requestFocus();//Aponta cursor para o campo matricula.
                    
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }              
    }

    //---------------------------------------------------------------------------------------------------------------------------------
    //Método pesquisar Equip
    private void pesquisar_equip() {

        //String Sql = "select * from tb_entrasai where matricula_usu like?";
        /*String sql = "Select id_equip as ID, patri_equip as PATRIMONIO, gerencia_equip as GERENCIA, tipo_equip as TIPO, status_equip as STATUS, "
                + "chamado_equip as CHAMADO, defeito_equip as DEFEITO, data_entrada_equip as DATA_ENTRADA, data_saida_equip as DATA_SAIDA from tb_entrasai"
                + "where patri_equip like?";*/        
        String sql = "Select id_equip as ID, patri_equip as PATRIMONIO, gerencia_equip as GERENCIA, tipo_equip as TIPO, status_equip as STATUS, chamado_equip as CHAMADO, defeito_equip as DEFEITO, data_entrada_equip as DATA_ENTRADA, data_saida_equip as DATA_SAIDA from tb_entrasai where patri_equip like?";

        try {
            pst = conexao.prepareStatement(sql);
            //Passando o conteudo da caixa de pesquisa para o ?
            //atenção ao % - continuação da string SQL.
            pst.setString(1, txt_pesquisarPS.getText() + "%");
            rs = pst.executeQuery();
            //A linha abaixo usa a biblioteca para preencher a tabela.
            tb_entsaiEquip.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------    
//METODOS SETAR CAMPOS
    public void SetarCamposEquip() {

        int setar = tb_entsaiEquip.getSelectedRow();

        txt_idPS.setText(tb_entsaiEquip.getModel().getValueAt(setar, 0).toString());
        txt_patrominioPS.setText(tb_entsaiEquip.getModel().getValueAt(setar, 1).toString());
        txt_gerencia.setText(tb_entsaiEquip.getModel().getValueAt(setar, 2).toString().toUpperCase());
        cbb_tipoEquip.setSelectedItem(tb_entsaiEquip.getModel().getValueAt(setar, 3).toString());        
        cbb_status.setSelectedItem(tb_entsaiEquip.getModel().getValueAt(setar, 4).toString());        
        txt_chamado.setText(tb_entsaiEquip.getModel().getValueAt(setar, 5).toString());
        txt_defeito.setText(tb_entsaiEquip.getModel().getValueAt(setar, 6).toString().toUpperCase());
        txt_dataEntrada.setText(tb_entsaiEquip.getModel().getValueAt(setar, 7).toString());
        txt_dataSaida.setText(tb_entsaiEquip.getModel().getValueAt(setar, 8).toString());

        //A linha abaixo desabilitar o botão adicionar.
        //btn_novoUsu.setEnabled(false);
    }

    //---------------------------------------------------------------------------------------------------------------------------------
    //Método alterar registro
    private void alterar() {

        String sql = "update tb_entrasai set patri_equip=?, gerencia_equip=?, tipo_equip=?, status_equip=?, chamado_equip=?, defeito_equip=?, data_entrada_equip=?, data_saida_equip=? where id_equip=?";

        try {
            pst = conexao.prepareStatement(sql);
            
            
            pst.setString(1, txt_patrominioPS.getText());
            pst.setString(2, txt_gerencia.getText().toUpperCase());            
            pst.setString(3, cbb_tipoEquip.getSelectedItem().toString());
            pst.setString(4, cbb_status.getSelectedItem().toString());                        
            pst.setString(5, txt_chamado.getText());
            pst.setString(6, txt_defeito.getText().toUpperCase());
            pst.setString(7, txt_dataEntrada.getText());
            pst.setString(8, txt_dataSaida.getText());
            pst.setString(9, txt_idPS.getText());
            

            if ((txt_patrominioPS.getText().isEmpty()) || (txt_gerencia.getText().isEmpty()) || (txt_defeito.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");

            } else {

                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
                                        
                txt_idPS.setText(null);
                txt_patrominioPS.setText(null);
                txt_gerencia.setText(null);
                txt_chamado.setText(null);
                txt_defeito.setText(null);
                txt_dataEntrada.setText(null);  
                txt_dataSaida.setText(null);
                tb_entsaiEquip.setModel(new DefaultTableModel(null, new String[]{"ID", "PATRIMÔNIO", "GERENCIA", "TIPO", "STATUS", "Nº CHAMADO", "DEFEITO", "DATA ENTRADA", "DATA SAIDA"}));
                txt_pesquisarPS.requestFocus();//Aponta cursor para o campo matricula.
                                
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

        txt_idPS.setText(null);
        txt_patrominioPS.setText(null);
        txt_gerencia.setText(null);
        txt_chamado.setText(null);
        txt_defeito.setText(null);
        txt_dataEntrada.setText(null);  
        txt_dataSaida.setText(null);
        tb_entsaiEquip.setModel(new DefaultTableModel(null, new String[]{"ID", "PATRIMÔNIO", "GERENCIA", "TIPO", "STATUS", "Nº CHAMADO", "DEFEITO", "DATA ENTRADA", "DATA SAIDA"}));
        txt_pesquisarPS.setText(null);
        txt_pesquisarPS.requestFocus();//Aponta cursor para o campo matricula.
                
    }

    //---------------------------------------------------------------------------------------------------------------------------------    
    //Método remover usuário
    private void remover() {

        int confirma = JOptionPane.showConfirmDialog(null, " Tem certeza que deseja remover este registro?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tb_entrasai where id_equip=?";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txt_idPS.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Registro removido com sucesso!");

                    txt_idPS.setText(null);
                    txt_patrominioPS.setText(null);
                    txt_gerencia.setText(null);
                    txt_chamado.setText(null);
                    txt_defeito.setText(null);
                    txt_dataEntrada.setText(null);  
                    txt_dataSaida.setText(null);
                    tb_entsaiEquip.setModel(new DefaultTableModel(null, new String[]{"ID", "PATRIMÔNIO", "GERENCIA", "TIPO", "STATUS", "Nº CHAMADO", "DEFEITO", "DATA ENTRADA", "DATA SAIDA"}));
                    //txt_patrominioPS.requestFocus();//Aponta cursor para o campo matricula.
                    txt_pesquisarPS.setText(null);
                    txt_pesquisarPS.requestFocus();//Aponta cursor para o campo matricula.
                    
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

        jLabel2 = new javax.swing.JLabel();
        btn_alterarPS = new javax.swing.JButton();
        btn_cancelarPS = new javax.swing.JButton();
        btn_removerPS = new javax.swing.JButton();
        btn_novoPS = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbb_tipoEquip = new javax.swing.JComboBox<>();
        cbb_status = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_patrominioPS = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_entsaiEquip = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txt_pesquisarPS = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_idPS = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_chamado = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_gerencia = new javax.swing.JTextField();
        txt_dataSaida = new javax.swing.JFormattedTextField();
        txt_dataEntrada = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_defeito = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setTitle("Entrada e Saida de Equipamentos");
        getContentPane().setLayout(null);

        jLabel2.setText("* Patrimônio");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 70, 90, 14);

        btn_alterarPS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/editar.png"))); // NOI18N
        btn_alterarPS.setToolTipText("Alterar");
        btn_alterarPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterarPSActionPerformed(evt);
            }
        });
        btn_alterarPS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_alterarPSKeyPressed(evt);
            }
        });
        getContentPane().add(btn_alterarPS);
        btn_alterarPS.setBounds(360, 440, 90, 40);

        btn_cancelarPS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Cancelar.png"))); // NOI18N
        btn_cancelarPS.setToolTipText("Cancelar");
        btn_cancelarPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarPSActionPerformed(evt);
            }
        });
        btn_cancelarPS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_cancelarPSKeyPressed(evt);
            }
        });
        getContentPane().add(btn_cancelarPS);
        btn_cancelarPS.setBounds(510, 440, 100, 40);

        btn_removerPS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/excluir.png"))); // NOI18N
        btn_removerPS.setToolTipText("Excluir");
        btn_removerPS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_removerPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removerPSActionPerformed(evt);
            }
        });
        btn_removerPS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_removerPSKeyPressed(evt);
            }
        });
        getContentPane().add(btn_removerPS);
        btn_removerPS.setBounds(680, 440, 100, 40);

        btn_novoPS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/adicionar.png"))); // NOI18N
        btn_novoPS.setToolTipText("Novo");
        btn_novoPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoPSActionPerformed(evt);
            }
        });
        getContentPane().add(btn_novoPS);
        btn_novoPS.setBounds(220, 440, 90, 40);

        jLabel4.setText("* Defeito do equipamento e solução do técnico");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(290, 130, 340, 14);

        jLabel5.setText("Tipo de  Equipamento");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(290, 70, 140, 14);

        cbb_tipoEquip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Desktop", "Notebook", "Estabilizador", "Nobreak", "Tablet", "Smartphone", "Monitor" }));
        getContentPane().add(cbb_tipoEquip);
        cbb_tipoEquip.setBounds(290, 90, 140, 30);

        cbb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Aguardando atendimento", "Em análise", "Aguardando peça", "Aguardando garantia", "Liberado", "Entregue" }));
        getContentPane().add(cbb_status);
        cbb_status.setBounds(450, 90, 180, 30);

        jLabel6.setText("Status");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(450, 70, 120, 14);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/not-100x100.png"))); // NOI18N
        jLabel1.setText(".");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(770, 50, 130, 110);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pc-100x100.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(640, 40, 130, 110);

        jLabel8.setText("* Gerência");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(110, 70, 160, 14);

        txt_patrominioPS.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("000000"))));
        txt_patrominioPS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_patrominioPS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_patrominioPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_patrominioPSActionPerformed(evt);
            }
        });
        getContentPane().add(txt_patrominioPS);
        txt_patrominioPS.setBounds(10, 90, 80, 30);

        tb_entsaiEquip.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "PATRIMÔNIO", "TIPO  EQUIP", "GERENCIA", "STATUS", "NUM CHAMADO", "DEFEITO", "DATA ENTRADA", "DATA SAIDA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_entsaiEquip.getTableHeader().setReorderingAllowed(false);
        tb_entsaiEquip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_entsaiEquipMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_entsaiEquip);
        if (tb_entsaiEquip.getColumnModel().getColumnCount() > 0) {
            tb_entsaiEquip.getColumnModel().getColumn(0).setResizable(false);
            tb_entsaiEquip.getColumnModel().getColumn(1).setResizable(false);
            tb_entsaiEquip.getColumnModel().getColumn(2).setResizable(false);
            tb_entsaiEquip.getColumnModel().getColumn(3).setResizable(false);
            tb_entsaiEquip.getColumnModel().getColumn(4).setResizable(false);
            tb_entsaiEquip.getColumnModel().getColumn(5).setResizable(false);
            tb_entsaiEquip.getColumnModel().getColumn(6).setResizable(false);
            tb_entsaiEquip.getColumnModel().getColumn(7).setResizable(false);
            tb_entsaiEquip.getColumnModel().getColumn(8).setResizable(false);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 260, 990, 160);

        jLabel9.setText("Pesquisar");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 10, 130, 14);

        txt_pesquisarPS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_pesquisarPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pesquisarPSActionPerformed(evt);
            }
        });
        txt_pesquisarPS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pesquisarPSKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisarPSKeyReleased(evt);
            }
        });
        getContentPane().add(txt_pesquisarPS);
        txt_pesquisarPS.setBounds(10, 30, 80, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/search.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(100, 30, 24, 30);

        jLabel11.setText("* Campos Obrigatórios");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(720, 0, 130, 20);

        txt_idPS.setBorder(null);
        try {
            txt_idPS.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_idPS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_idPS.setEnabled(false);
        txt_idPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idPSActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idPS);
        txt_idPS.setBounds(450, 30, 120, 30);

        jLabel12.setText("ID");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(450, 10, 90, 14);

        jLabel13.setText("Data de saida");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(150, 190, 120, 14);

        jLabel14.setText("Número do Chamado");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(10, 130, 230, 14);

        txt_chamado.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(txt_chamado);
        txt_chamado.setBounds(10, 150, 260, 30);

        jLabel15.setText("Data de Entrada");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 190, 120, 14);

        txt_gerencia.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(txt_gerencia);
        txt_gerencia.setBounds(110, 90, 160, 30);

        try {
            txt_dataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataSaida.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(txt_dataSaida);
        txt_dataSaida.setBounds(150, 210, 120, 30);

        try {
            txt_dataEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataEntrada.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(txt_dataEntrada);
        txt_dataEntrada.setBounds(10, 210, 120, 30);

        txt_defeito.setColumns(20);
        txt_defeito.setLineWrap(true);
        txt_defeito.setRows(5);
        txt_defeito.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txt_defeito);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(290, 150, 340, 90);

        setBounds(0, 0, 1028, 520);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_alterarPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarPSActionPerformed
        // Chamar o método alterar
        alterar();
    }//GEN-LAST:event_btn_alterarPSActionPerformed

    private void btn_alterarPSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_alterarPSKeyPressed
        // Chamar metodo alterar pressionando enter
        alterar();
    }//GEN-LAST:event_btn_alterarPSKeyPressed

    private void btn_cancelarPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarPSActionPerformed
        // Chamar o método cancelar
        cancelar();
    }//GEN-LAST:event_btn_cancelarPSActionPerformed

    private void btn_cancelarPSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_cancelarPSKeyPressed
        // Chamar o método cancelar
        cancelar();
    }//GEN-LAST:event_btn_cancelarPSKeyPressed

    private void btn_removerPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerPSActionPerformed
        // Chamar o método remover
        remover();
    }//GEN-LAST:event_btn_removerPSActionPerformed

    private void btn_removerPSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_removerPSKeyPressed
        // Chamar o método remover pressionando enter
        remover();
    }//GEN-LAST:event_btn_removerPSKeyPressed

    private void btn_novoPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoPSActionPerformed
        // Chamar o metodo adicionar
        adicionar();
        
    }//GEN-LAST:event_btn_novoPSActionPerformed

    private void txt_pesquisarPSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisarPSKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_pesquisarPSKeyPressed

    private void txt_pesquisarPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesquisarPSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesquisarPSActionPerformed

    private void txt_pesquisarPSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisarPSKeyReleased
        //PESQUISAR CLIENTES
        pesquisar_equip();
    }//GEN-LAST:event_txt_pesquisarPSKeyReleased

    private void tb_entsaiEquipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_entsaiEquipMouseClicked
        // TODO add your handling code here:
        SetarCamposEquip();
    }//GEN-LAST:event_tb_entsaiEquipMouseClicked

    private void txt_patrominioPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_patrominioPSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_patrominioPSActionPerformed

    private void txt_idPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idPSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idPSActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alterarPS;
    private javax.swing.JButton btn_cancelarPS;
    private javax.swing.JButton btn_novoPS;
    private javax.swing.JButton btn_removerPS;
    private javax.swing.JComboBox<String> cbb_status;
    private javax.swing.JComboBox<String> cbb_tipoEquip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_entsaiEquip;
    private javax.swing.JTextField txt_chamado;
    private javax.swing.JFormattedTextField txt_dataEntrada;
    private javax.swing.JFormattedTextField txt_dataSaida;
    private javax.swing.JTextArea txt_defeito;
    private javax.swing.JTextField txt_gerencia;
    private javax.swing.JFormattedTextField txt_idPS;
    private javax.swing.JFormattedTextField txt_patrominioPS;
    private javax.swing.JTextField txt_pesquisarPS;
    // End of variables declaration//GEN-END:variables
}
