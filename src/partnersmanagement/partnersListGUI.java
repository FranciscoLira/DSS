/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partnersmanagement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Tiago
 */
public class partnersListGUI extends javax.swing.JFrame implements Observer{
    
    private PartnersList partners;
    private DefaultListModel dlm = null;
    
    /**
     * Creates new form partnersListGUI
     */
    
    public partnersListGUI(){
        initComponents();
    }
    
    public partnersListGUI(PartnersList p){
        this.partners = p;
        initComponents();
        this.partners.addObserver(this);
    }
   
    private DefaultListModel getListModel(PartnersList l){
        if(dlm == null){
            dlm = new DefaultListModel();
            for(Partner p: l.getGroup().values()){
                dlm.addElement(p.getMail());
            }
        }
        return dlm;
    }
   
    private JList getList(){
        if(jLdemo == null){
            jLdemo = new JList();
            jLdemo.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    // Note que "e.getValueIsAdjusting" e "lstList.getSelectedValue() != null" abaixo
                    // não são enfeite: se você não tratar essa condição, você vai tomar um NullPointerException
                    if (e.getClickCount() == 2 && jLdemo.getSelectedValue() != null) {
                        String mail = jLdemo.getSelectedValue().toString();
                        openViewPartnerWindow(mail);
                    }
                }
            });
            jLdemo.setModel(getListModel(this.partners));
            jLdemo.setFocusCycleRoot(true);
            jLdemo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
        return jLdemo;
    }
    
    
    private void openViewPartnerWindow(String mail){
        new partnersViewGUI(this, this.partners, mail).setVisible(true);
        setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLdemo = getList();
        jLabel1 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        observButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Sócios");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLdemo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(jLdemo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 600, 170));

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de Sócios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        deleteButton.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 13)); // NOI18N
        deleteButton.setText("Remover Sócio");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, -1, -1));

        observButton.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 13)); // NOI18N
        observButton.setText("Ver Detalhes");
        observButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                observButtonActionPerformed(evt);
            }
        });
        getContentPane().add(observButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        addButton.setText("Adicionar Sócio");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, -1));

        closeButton.setText("Fechar");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, -1, -1));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        if(jLdemo.getSelectedValue() != null){
            String mail = jLdemo.getSelectedValue().toString();
            this.partners.removePartner(mail);
            setVisible(false);
            new partnersListGUI(this.partners).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Sem sócios para remover!");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void observButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_observButtonActionPerformed
        // TODO add your handling code here:
        if(jLdemo.getSelectedValue() != null){
            String mail = jLdemo.getSelectedValue().toString();
            openViewPartnerWindow(mail);
        }
        else{
            JOptionPane.showMessageDialog(null, "Ainda sem sócios para observar!");
        }
    }//GEN-LAST:event_observButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AddGUI(this.partners, this).setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(partnersListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(partnersListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(partnersListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(partnersListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new partnersListGUI().setVisible(true);
        });
    }
    
    @Override
    public void update(Observable o, Object arg) {
        this.partners = (PartnersList) o;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jLdemo;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton observButton;
    // End of variables declaration//GEN-END:variables
}
