/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.RoleBasedWorkAreas.DataAnalystPanels;

import Business.Models.CropSalesRelation;
import static Utils.HistoricalData.marketBasedData;
import static Utils.HistoricalData.seasonBasedData;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deepakviswanadh
 */
public class BestSeasonsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BestSeasonsJPanel
     */
    public BestSeasonsJPanel() {
        initComponents();
        loadDropDownValues();
        loadTableData();
        seasonsComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            seasonsComboBoxActionPerformed(evt);
        }
    });
    }

   
    
    public void loadDropDownValues() {

        Set<String> uniqueSeasons = new HashSet<>(seasonBasedData.keySet());
        List<String> seasonsList = new ArrayList<>(uniqueSeasons);
        for (String season : seasonsList) {
            seasonsComboBox.addItem(season);
        }
        seasonsComboBox.setSelectedIndex(0);

    }

    public void loadTableData() {
        String season = (String) seasonsComboBox.getSelectedItem();
        List<CropSalesRelation> filteredCrops = marketBasedData.stream()
                .filter(market -> market.getCrop().getSeason().equalsIgnoreCase(season))
                .collect(Collectors.toList());
        Collections.sort(filteredCrops,
                (CropSalesRelation o1, CropSalesRelation o2)
                -> Integer.compare(o2.getSales().getQuantity(), o1.getSales().getQuantity()));
        DefaultTableModel model = (DefaultTableModel) BestCropsTable.getModel();
        model.setRowCount(0);

        for (CropSalesRelation data : filteredCrops) {
            Object[] row = new Object[2];
            row[0] = data.getCrop().getName();
            row[1]=data.getSales().getQuantity();
            model.addRow(row);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        BestCropsTable = new javax.swing.JTable();
        seasonsComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Best Crops Based on Season");
        jLabel1.setOpaque(true);

        BestCropsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Crop Name", "Sales"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BestCropsTable.setOpaque(false);
        jScrollPane1.setViewportView(BestCropsTable);

        seasonsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seasonsComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel1))
                    .addComponent(seasonsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(247, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(seasonsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void seasonsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seasonsComboBoxActionPerformed
        // TODO add your handling code here:
        loadTableData();
    }//GEN-LAST:event_seasonsComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BestCropsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> seasonsComboBox;
    // End of variables declaration//GEN-END:variables
}
