/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.RoleBasedWorkAreas.CropPlannerPanels;

import Business.Models.Crop;
import Business.Models.CropSalesRelation;
import Utils.HistoricalData;
import static Utils.HistoricalData.marketBasedData;
import static Utils.HistoricalData.seasonBasedData;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yash
 */
public class CPAnalyseForecastDemandJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CPAnalyseForecastDemandJPanel
     */
    ArrayList<CropSalesRelation> data;
    LinkedHashMap<String, Integer> bestCropsMap;
    JPanel workAreaJPanel;
    ArrayList<Crop> selectedCrops;
    List<Crop> topCropsList = new ArrayList<>();
    
    public CPAnalyseForecastDemandJPanel(JPanel workAreaJPanel, ArrayList<Crop> selectedCrops) {
        initComponents();
        
        this.workAreaJPanel = workAreaJPanel;
//        Data for Best crops based on Market 
        bestCropsMap = new LinkedHashMap<>();
        data = HistoricalData.marketBasedData;
        this.selectedCrops = selectedCrops;
        populateMarketTable();
        
//        Data for Best crops based on Seasons 

        loadDropDownValues();
        populateSeasonTable();
        seasonsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seasonsComboBoxActionPerformed(evt);
            }
        });
    }

        
    private void populateMarketTable(){
        getCropsWithHighestSales(data);
        
        DefaultTableModel model = (DefaultTableModel) bestCropsMarketTable.getModel();
        model.setRowCount(0);
        
        for (String key : bestCropsMap.keySet()) {        
            Object[] row = new Object[2];
            row[0] = key;
            row[1] = bestCropsMap.get(key);
            model.addRow(row);
        }
    }
    
    public void getCropsWithHighestSales(ArrayList<CropSalesRelation> marketBasedData) {
        // Step 1: Sort marketBasedData based on the quantity of sales in descending order
        Collections.sort(marketBasedData, new Comparator<CropSalesRelation>() {
            @Override
            public int compare(CropSalesRelation o1, CropSalesRelation o2) {
                // Compare in descending order based on sales quantity
                return Integer.compare(o2.getSales().getQuantity(), o1.getSales().getQuantity());
            }
        });


        for (int i = 0; i < Math.min(5, marketBasedData.size()); i++) {
            CropSalesRelation obj = marketBasedData.get(i);
            bestCropsMap.put(obj.getCrop().getName(), obj.getSales().getQuantity());
            topCropsList.add(obj.getCrop());
        }

    }
    
    private void seasonsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // Call loadTableData when the combobox selection changes
        populateSeasonTable();
    }
    
    public void loadDropDownValues() {

        Set<String> uniqueSeasons = new HashSet<>(seasonBasedData.keySet());
        List<String> seasonsList = new ArrayList<>(uniqueSeasons);
        for (String season : seasonsList) {
            seasonsComboBox.addItem(season);
        }
        seasonsComboBox.setSelectedIndex(0);

    }
    
    public void populateSeasonTable() {
        String season = (String) seasonsComboBox.getSelectedItem();
        List<CropSalesRelation> filteredCrops = marketBasedData.stream()
                .filter(market -> market.getCrop().getSeason().equalsIgnoreCase(season))
                .collect(Collectors.toList());
        
        Collections.sort(filteredCrops,
                (CropSalesRelation o1, CropSalesRelation o2)
                -> Integer.compare(o2.getSales().getQuantity(), o1.getSales().getQuantity()));
        
        DefaultTableModel model = (DefaultTableModel) bestCropsSeasonTable.getModel();
        model.setRowCount(0);

        for (int i = 0; i < Math.min(5, filteredCrops.size()); i++) {
            CropSalesRelation data = filteredCrops.get(i);
            Object[] row = new Object[2];
            row[0] = data.getCrop().getName();
            row[1] = data.getSales().getQuantity();
            model.addRow(row);
            topCropsList.add(data.getCrop());

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

        bestCropsMarketLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bestCropsMarketTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        bestCropsSeasonTable = new javax.swing.JTable();
        seasonsComboBox = new javax.swing.JComboBox<>();
        bestCropsSeasonLabel = new javax.swing.JLabel();
        forecastDataBtn = new javax.swing.JButton();
        addToScheduleMarketBtn = new javax.swing.JButton();
        addToScheduleSeasonBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        bestCropsMarketLabel.setBackground(new java.awt.Color(204, 255, 255));
        bestCropsMarketLabel.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        bestCropsMarketLabel.setText("Top 5 crops based on Market Demand");
        bestCropsMarketLabel.setOpaque(true);

        bestCropsMarketTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Crop", "Sales Quantity"
            }
        ));
        bestCropsMarketTable.setOpaque(false);
        jScrollPane1.setViewportView(bestCropsMarketTable);

        bestCropsSeasonTable.setModel(new javax.swing.table.DefaultTableModel(
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
        bestCropsSeasonTable.setOpaque(false);
        jScrollPane2.setViewportView(bestCropsSeasonTable);

        bestCropsSeasonLabel.setBackground(new java.awt.Color(204, 255, 255));
        bestCropsSeasonLabel.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        bestCropsSeasonLabel.setText("Top 5 crops based on Season");
        bestCropsSeasonLabel.setOpaque(true);

        forecastDataBtn.setText("Get Forecast Data for In-Demand Crops ");
        forecastDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forecastDataBtnActionPerformed(evt);
            }
        });

        addToScheduleMarketBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\deepa\\OneDrive\\Desktop\\plus.png")); // NOI18N
        addToScheduleMarketBtn.setText("Add to Schedule");
        addToScheduleMarketBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToScheduleMarketBtnActionPerformed(evt);
            }
        });

        addToScheduleSeasonBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\deepa\\OneDrive\\Desktop\\plus.png")); // NOI18N
        addToScheduleSeasonBtn.setText("Add to Schedule");
        addToScheduleSeasonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToScheduleSeasonBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(bestCropsMarketLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(121, 121, 121)
                                        .addComponent(addToScheduleMarketBtn)))))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bestCropsSeasonLabel)
                                .addGap(18, 18, 18)
                                .addComponent(seasonsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(addToScheduleSeasonBtn))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(forecastDataBtn)
                        .addGap(290, 290, 290)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bestCropsMarketLabel)
                    .addComponent(bestCropsSeasonLabel)
                    .addComponent(seasonsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addToScheduleMarketBtn)
                    .addComponent(addToScheduleSeasonBtn))
                .addGap(50, 50, 50)
                .addComponent(forecastDataBtn)
                .addContainerGap(129, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void forecastDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forecastDataBtnActionPerformed
        // TODO add your handling code here:
        ForecastInDemandCrops forecastPanel = new ForecastInDemandCrops(selectedCrops);
        workAreaJPanel.add("forecastPanel", forecastPanel);

        CardLayout layout = (CardLayout) workAreaJPanel.getLayout();
        layout.next(workAreaJPanel);
        
    }//GEN-LAST:event_forecastDataBtnActionPerformed

    private void addToScheduleMarketBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToScheduleMarketBtnActionPerformed
        // TODO add your handling code here:
        int row = bestCropsMarketTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String cropName = (String) bestCropsMarketTable.getValueAt(row, 0);

        // Check if a crop with the same name already exists in selectedCrops
        boolean cropAlreadyExists = false;
        for (Crop crop : selectedCrops) {
            if (crop.getName().equalsIgnoreCase(cropName)) {
                cropAlreadyExists = true;
                return; // Exit the loop if a matching crop is found
            }
        }

        if (cropAlreadyExists) {
            JOptionPane.showMessageDialog(null, "Crop with the same name already exists in the list", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            // Search for the crop in topCropsList and add it to selectedCrops if found
            for (Crop crop : topCropsList) {
                if (crop.getName().equalsIgnoreCase(cropName)) {
                    selectedCrops.add(crop);
                    JOptionPane.showMessageDialog(null, "Crop successfully added to schedule", "Information", JOptionPane.INFORMATION_MESSAGE);
                    return; // Exit the loop once the crop is added
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Crop not found in the top crops list", "Error", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_addToScheduleMarketBtnActionPerformed

    private void addToScheduleSeasonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToScheduleSeasonBtnActionPerformed
        // TODO add your handling code here:
        int row = bestCropsSeasonTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String cropName = (String) bestCropsSeasonTable.getValueAt(row, 0);

        // Check if a crop with the same name already exists in selectedCrops
        boolean cropAlreadyExists = false;
        for (Crop crop : selectedCrops) {
            if (crop.getName().equalsIgnoreCase(cropName)) {
                cropAlreadyExists = true;
                return; // Exit the loop if a matching crop is found
            }
        }

        if (cropAlreadyExists) {
            JOptionPane.showMessageDialog(null, "Crop with the same name already exists in the list", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            // Search for the crop in topCropsList and add it to selectedCrops if found
            for (Crop crop : topCropsList) {
                if (crop.getName().equalsIgnoreCase(cropName)) {
                    selectedCrops.add(crop);
                    JOptionPane.showMessageDialog(null, "Crop successfully added to schedule", "Information", JOptionPane.INFORMATION_MESSAGE);
                    return; // Exit the loop once the crop is added
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Crop not found in the top crops list", "Error", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_addToScheduleSeasonBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToScheduleMarketBtn;
    private javax.swing.JButton addToScheduleSeasonBtn;
    private javax.swing.JLabel bestCropsMarketLabel;
    private javax.swing.JTable bestCropsMarketTable;
    private javax.swing.JLabel bestCropsSeasonLabel;
    private javax.swing.JTable bestCropsSeasonTable;
    private javax.swing.JButton forecastDataBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> seasonsComboBox;
    // End of variables declaration//GEN-END:variables
}
