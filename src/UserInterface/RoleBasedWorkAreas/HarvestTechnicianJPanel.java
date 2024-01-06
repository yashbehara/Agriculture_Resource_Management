/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.RoleBasedWorkAreas;

import Business.LoginPerson.LoginPerson;
import Business.Models.Crop;
import Business.Models.CropScheduleTechniqueRelation;
import Business.Roles.CropPlanner;
import Business.Roles.DataAnalyst;
import Business.Roles.HarvestTechnician;
import UserInterface.RoleBasedWorkAreas.CropPlannerPanels.CPAnalyseForecastDemandJPanel;
import static UserInterface.RoleBasedWorkAreas.DataAnalystJPanel.cropPlannerList;
import UserInterface.RoleBasedWorkAreas.HarvestTechnicianPanels.CropsHarvestPlanJPanel;
import static Utils.HistoricalData.seasonBasedData;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;

/**
 *
 * @author yash
 */
public class HarvestTechnicianJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HarvestTechnicianJPanel
     */
    JPanel MainJPanel;
    HashMap<CropPlanner,HashMap<Crop, List<CropScheduleTechniqueRelation>>> cropPlannerScheduleList;
    List<HarvestTechnician> harvestTechnicianList = new ArrayList<>();
    LoginPerson person;
    HarvestTechnician loggedInHarvestTechnician;
    public HarvestTechnicianJPanel(LoginPerson person,List<HarvestTechnician> harvestTechnicianList, JPanel MainJPanel) {
        initComponents();
        this.MainJPanel = MainJPanel;
        this.harvestTechnicianList = harvestTechnicianList;
        this.person = person;
        this.loggedInHarvestTechnician = getHarvestTechnicianObject();

        cropPlannerScheduleList = new HashMap<CropPlanner,HashMap<Crop, List<CropScheduleTechniqueRelation>>>();
        cropPlannerScheduleList = DataAnalystJPanel.cropPlannerList;
        
//        loadDropDownValues();
        this.MainJPanel = MainJPanel;
        
        loadDropDownValues();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cropsListLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cropsListTable = new javax.swing.JTable();
        plannerComboBox = new javax.swing.JComboBox<>();
        comboBoxLbl = new javax.swing.JLabel();
        logOutBtn = new javax.swing.JButton();
        finalisePlanBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(null);

        cropsListLbl.setBackground(new java.awt.Color(204, 255, 255));
        cropsListLbl.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        cropsListLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cropsListLbl.setText("List of Crops to be harvested");
        cropsListLbl.setOpaque(true);
        add(cropsListLbl);
        cropsListLbl.setBounds(260, 40, 308, 18);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setOpaque(false);

        cropsListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Crop", "Technique", "Schedule", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cropsListTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(198, 101, 432, 399);

        plannerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plannerComboBoxActionPerformed(evt);
            }
        });
        add(plannerComboBox);
        plannerComboBox.setBounds(39, 218, 110, 22);

        comboBoxLbl.setBackground(new java.awt.Color(204, 255, 255));
        comboBoxLbl.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        comboBoxLbl.setText("Select Crop Planner");
        comboBoxLbl.setOpaque(true);
        add(comboBoxLbl);
        comboBoxLbl.setBounds(24, 167, 140, 18);

        logOutBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\deepa\\OneDrive\\Desktop\\cross.png")); // NOI18N
        logOutBtn.setText("Log Out");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });
        add(logOutBtn);
        logOutBtn.setBounds(30, 290, 120, 36);

        finalisePlanBtn.setText("Finalise plan");
        finalisePlanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalisePlanBtnActionPerformed(evt);
            }
        });
        add(finalisePlanBtn);
        finalisePlanBtn.setBounds(360, 530, 95, 22);
    }// </editor-fold>//GEN-END:initComponents

    private void plannerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plannerComboBoxActionPerformed
        // TODO add your handling code here:
        populateCropTable();
    }//GEN-LAST:event_plannerComboBoxActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        // TODO add your handling code here:
    MainJPanel.remove(this);
    CardLayout layout = (CardLayout) MainJPanel.getLayout();
    layout.previous(MainJPanel);
    }//GEN-LAST:event_logOutBtnActionPerformed

    public HarvestTechnician getHarvestTechnicianObject(){
        for (HarvestTechnician harvestTech : harvestTechnicianList) {
            if(harvestTech.getUserName().equalsIgnoreCase(person.getUserName())){
                return harvestTech;
            }
        }
        return null;
    }
    private void finalisePlanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalisePlanBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) cropsListTable.getModel();

        int row = cropsListTable.getSelectedRow();
        if(row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
         }

        ArrayList<String> selectedRowData = new ArrayList();
        
        // Get data from all elements in the selected row
        for (int col = 0; col < model.getColumnCount(); col++) {
            selectedRowData.add(String.valueOf(model.getValueAt(row, col)));
        }
        
        // Get the crop planner name from combo box
        String selectedCropPlanner = (String) plannerComboBox.getSelectedItem();
        
        
        CropsHarvestPlanJPanel cropPanel = new CropsHarvestPlanJPanel(MainJPanel,selectedRowData, selectedCropPlanner);
        MainJPanel.add("cropPanel", cropPanel);

        CardLayout layout = (CardLayout) MainJPanel.getLayout();
        layout.next(MainJPanel);
    }//GEN-LAST:event_finalisePlanBtnActionPerformed

    public void loadDropDownValues() {


       for (CropPlanner planner : cropPlannerList.keySet()) {
            String plannerName = planner.getName();
            plannerComboBox.addItem(plannerName);
        }
       plannerComboBox.setSelectedIndex(0);

    }
    
    public void populateCropTable(){
        // Loop through each crop planner
     String plannerName = (String) plannerComboBox.getSelectedItem();

     DefaultTableModel model = (DefaultTableModel) cropsListTable.getModel();
     model.setRowCount(0);

        // Loop through each crop planner
        for (CropPlanner planner : cropPlannerScheduleList.keySet()) {
            if (planner.getName().equals(plannerName)) {

               // Loop through each crop for the current planner
                for (Crop crop : cropPlannerScheduleList.get(planner).keySet()) {
                    // Loop through each relation for the current crop
                     for (CropScheduleTechniqueRelation relation : cropPlannerScheduleList.get(planner).get(crop)) {

                        // Add data to the table
                        Object[] row = new Object[4];
                        row[0] = crop.getName();
                        row[1] = relation.getTechnique();
                        row[2] = relation.getCropSchedule().getDayNTime(); 
                        row[3] = relation.getHarvestTechnicianStatus();


                        model.addRow(row);
                    }
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel comboBoxLbl;
    private javax.swing.JLabel cropsListLbl;
    private javax.swing.JTable cropsListTable;
    private javax.swing.JButton finalisePlanBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JComboBox<String> plannerComboBox;
    // End of variables declaration//GEN-END:variables
}