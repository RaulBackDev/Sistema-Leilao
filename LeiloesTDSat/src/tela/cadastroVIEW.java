package tela;

import banco.ProdutosDAO;
import dados.ProdutosDTO;
import javax.swing.JOptionPane;

public class CadastroVIEW extends javax.swing.JFrame {

    public CadastroVIEW() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSistemaLeiloes = new javax.swing.JLabel();
        lbCadNovoProduto = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbValor = new javax.swing.JLabel();
        fdNome = new javax.swing.JTextField();
        fdValor = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btCadastrar = new javax.swing.JButton();
        btProdutos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbSistemaLeiloes.setFont(new java.awt.Font("Lucida Fax", 0, 24)); // NOI18N
        lbSistemaLeiloes.setText("Sistema de Leilões");

        lbCadNovoProduto.setText("Cadastre um novo produto");

        lbNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNome.setText("Nome:");

        lbValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbValor.setText("Valor:");

        btCadastrar.setBackground(new java.awt.Color(153, 255, 255));
        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btProdutos.setText("Consultar Produtos");
        btProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProdutosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(btCadastrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(lbSistemaLeiloes)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(202, 202, 202)
                            .addComponent(lbCadNovoProduto))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbNome)
                                .addComponent(lbValor))
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fdNome)
                                .addComponent(fdValor, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lbSistemaLeiloes)
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCadNovoProduto)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(fdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValor)
                    .addComponent(fdValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btCadastrar)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btProdutos)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        if(verificarPreenchimentoCampos() && verificarExceptionValor()) {
            ProdutosDTO produto = gerarProduto();
            boolean res = new ProdutosDAO().cadastrarProduto(produto); 
            
            if(res) {
                JOptionPane.showMessageDialog(this, "O produto foi cadastrado.");
            }
            else {
                JOptionPane.showMessageDialog(this, "Falha ao tentar cadastrar o produto.");
            }
        }    
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProdutosActionPerformed
        ListagemVIEW listagem = new ListagemVIEW(); 
        listagem.setVisible(true);
    }//GEN-LAST:event_btProdutosActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btProdutos;
    private javax.swing.JTextField fdNome;
    private javax.swing.JTextField fdValor;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbCadNovoProduto;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbSistemaLeiloes;
    private javax.swing.JLabel lbValor;
    // End of variables declaration//GEN-END:variables

    private boolean verificarPreenchimentoCampos() {  
        if(!fdNome.getText().isEmpty() && !fdValor.getText().isEmpty()) {
            return true;
        }
        else {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos para cadastrar o produto.");
            return false;
        }
    }  
    
    private boolean verificarExceptionValor() {
        try {
            float valor = Float.valueOf(fdValor.getText());
            
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Informe o campo \"valor\" apenas com números, e use ponto ao invés de vírgula. Exemplo: 3.50");
            return false;
        }
        return true;
    }
    
    private ProdutosDTO gerarProduto() {
        ProdutosDTO produto = new ProdutosDTO();
        produto.setNome(fdNome.getText());
        produto.setValor(Float.parseFloat(fdValor.getText()));
        produto.setStatus("A Venda");
        
        return produto;
    }      
}
