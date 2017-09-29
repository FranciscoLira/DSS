/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partnersmanagement;

/**
 *
 * @author Tiago
 */
public class updatePartnerGUI extends javax.swing.JFrame {
    
    private String mail;
    private PartnersList partners;
    /**
     * Creates new form updatePartnerGUI
     */
    public updatePartnerGUI() {
        initComponents();
    }
    
    public updatePartnerGUI(PartnersList l, String mail){
        initComponents();
        this.partners = l;
        this.mail = mail;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        courseField = new javax.swing.JTextField();
        mailField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel1.setText("Curso");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 92, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel2.setText("Mail");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 138, -1, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel3.setText("Nº Tlf.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 188, -1, -1));

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel4.setText("Morada");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 234, -1, -1));
        getContentPane().add(courseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 88, 89, -1));
        getContentPane().add(mailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 134, 89, -1));
        getContentPane().add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 184, 91, -1));
        getContentPane().add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 230, 90, -1));

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel5.setText("Atualização de dados");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 28, -1, -1));

        updateButton.setText("Atualizar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 86, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean check() {
        boolean empty = this.mailField.getText().equals("") || this.courseField.getText().equals("")
              || this.addressField.getText().equals("") || this.phoneField.getText().equals("");
        
        if (empty)
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor preencha todos os dados.", "Dados incompletos", 0);
        
        return !empty;
    }
    
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        if(this.check()){
            this.partners.updatePartner(this.mail, courseField.getText(), mailField.getText(), phoneField.getText(), addressField.getText());
            this.mail = mailField.getText();
        }
        new partnersListGUI(this.partners).setVisible(true);
        new partnersViewGUI(this.partners, this.mail).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(updatePartnerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updatePartnerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updatePartnerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updatePartnerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updatePartnerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField courseField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField mailField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}