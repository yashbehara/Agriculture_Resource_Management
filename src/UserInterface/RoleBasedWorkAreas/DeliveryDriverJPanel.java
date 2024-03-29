/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.RoleBasedWorkAreas;

import Business.LoginPerson.LoginPerson;
import Business.Roles.DeliveryDriver;
import Business.Roles.WarehouseCoordinator;
import UserInterface.RoleBasedWorkAreas.DataAnalystPanels.FutureDemandJPanel;
import UserInterface.RoleBasedWorkAreas.DeliveryDriver.DeliverPlanJPanel;
import UserInterface.RoleBasedWorkAreas.DeliveryDriver.UpdateStatusJPanel;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author yash
 */
public class DeliveryDriverJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DeliveryDriverJPanel
     */
    DeliveryDriver loggedInDriverObj;
    LoginPerson person;
    List<DeliveryDriver> deliveryDriverList;
    JPanel MainJPanel;
    String loggedInPersonName;

    public DeliveryDriverJPanel(LoginPerson person, List<DeliveryDriver> deliveryDriverList,
            JPanel MainJPanel) {
        initComponents();
        this.deliveryDriverList = deliveryDriverList;
        this.person = person;
        this.MainJPanel = MainJPanel;
        loggedInDriverObj = loggedInDriver();
        loggedInPersonName = this.loggedInDriverObj.getName();
    }

    public DeliveryDriver loggedInDriver() {
        for (DeliveryDriver whc : deliveryDriverList) {
            if (whc.getUserName().equalsIgnoreCase(person.getUserName())) {
                return whc;
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        buttonJPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        workaAreaJPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(null);

        jSplitPane1.setBackground(new java.awt.Color(255, 255, 255));
        jSplitPane1.setOpaque(false);

        buttonJPanel.setBackground(new java.awt.Color(255, 255, 255));
        buttonJPanel.setOpaque(false);

        jButton1.setText("Get Delivery Plan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update Status");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnLogout.setIcon(new javax.swing.ImageIcon("C:\\Users\\deepa\\OneDrive\\Desktop\\cross.png")); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\deepa\\OneDrive\\Desktop\\welcome.png")); // NOI18N
        jLabel1.setText("Welcome !");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout buttonJPanelLayout = new javax.swing.GroupLayout(buttonJPanel);
        buttonJPanel.setLayout(buttonJPanelLayout);
        buttonJPanelLayout.setHorizontalGroup(
            buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        buttonJPanelLayout.setVerticalGroup(
            buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonJPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(60, 60, 60)
                .addComponent(jButton2)
                .addGap(53, 53, 53)
                .addComponent(btnLogout)
                .addGap(121, 121, 121))
        );

        jSplitPane1.setLeftComponent(buttonJPanel);

        workaAreaJPanel.setBackground(new java.awt.Color(255, 255, 255));
        workaAreaJPanel.setOpaque(false);
        workaAreaJPanel.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(workaAreaJPanel);

        add(jSplitPane1);
        jSplitPane1.setBounds(6, 0, 827, 423);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

         DeliverPlanJPanel deliverPlanJPanel = new DeliverPlanJPanel(this.person.getUserName());
        workaAreaJPanel.add("deliverPlanJPanel", deliverPlanJPanel);
        CardLayout layout = (CardLayout) workaAreaJPanel.getLayout();
        layout.next(workaAreaJPanel);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        UpdateStatusJPanel updateStatusJPanel = new UpdateStatusJPanel(loggedInPersonName);
        workaAreaJPanel.add("updateStatusJPanel", updateStatusJPanel);
        CardLayout layout = (CardLayout) workaAreaJPanel.getLayout();
        layout.next(workaAreaJPanel);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        MainJPanel.remove(this);
        CardLayout layout = (CardLayout) MainJPanel.getLayout();
        layout.previous(MainJPanel);
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JPanel buttonJPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel workaAreaJPanel;
    // End of variables declaration//GEN-END:variables
}
