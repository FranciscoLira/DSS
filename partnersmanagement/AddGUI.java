/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partnersmanagement;

import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class AddGUI extends javax.swing.JFrame {
    
    private PartnersList partners;
    /**
     * Creates new form AddGUI
     */
    public AddGUI(){
        initComponents();
    }
    public AddGUI(PartnersList p) {
        initComponents();
        this.partners = p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addNameText = new javax.swing.JTextField();
        addAdressText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addCourseText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addMailText = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        addYear = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        addPhoneNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nome");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel2.setText("Morada");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));
        getContentPane().add(addNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 250, -1));
        getContentPane().add(addAdressText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 250, -1));

        jLabel3.setText("Curso");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));
        getContentPane().add(addCourseText, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 250, -1));

        jLabel4.setText("Mail");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, -1));
        getContentPane().add(addMailText, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 250, -1));

        confirmButton.setText("Confirmar");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        getContentPane().add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, -1, -1));

        jLabel6.setText("Ano de inscrição");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));
        getContentPane().add(addYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 250, -1));

        phoneLabel.setText("Nº Telefone");
        getContentPane().add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));
        getContentPane().add(addPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 250, -1));

        jLabel7.setFont(new java.awt.Font("Malayalam MN", 1, 24)); // NOI18N
        jLabel7.setText("REGISTAR SÓCIO");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private boolean check() {
        boolean empty = this.addNameText.getText().equals("") || this.addCourseText.getText().equals("")
              || this.addAdressText.getText().equals("") || this.addMailText.getText().equals("");
        
        if (empty)
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor preencha todos os dados.", "Dados incompletos", 0);
        
        return !empty;
    }
    
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:
        if(this.check()){
            String mail = this.addMailText.getText();
            if(this.partners.containsPartner(mail)){
                JOptionPane.showMessageDialog(null, "Nome já existente no sistema!");
            }
            else{
                if(this.partners.size()==0){
                    this.partners.setN(1);
                }
                Partner p = new Partner(addNameText.getText(), addCourseText.getText(), addAdressText.getText(), addMailText.getText(), addPhoneNumber.getText(), addYear.getText());
                p.setNumber(this.partners.getN());
                this.partners.setN(this.partners.getN()+1);
                this.partners.addPartner(p);
                
            }
            setVisible(false);
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addAdressText;
    private javax.swing.JTextField addCourseText;
    private javax.swing.JTextField addMailText;
    private javax.swing.JTextField addNameText;
    private javax.swing.JTextField addPhoneNumber;
    private javax.swing.JTextField addYear;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel phoneLabel;
    // End of variables declaration//GEN-END:variables
}
