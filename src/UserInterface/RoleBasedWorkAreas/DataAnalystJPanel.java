/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.RoleBasedWorkAreas;

import Business.LoginPerson.LoginPerson;
import Business.Models.Store;
import Business.Roles.DeliveryDriver;
import Business.Models.Crop;
import Business.Models.CropScheduleTechniqueRelation;
import Business.Roles.CropPlanner;
import Business.Roles.DataAnalyst;
import Business.Roles.Person;
import UserInterface.RoleBasedWorkAreas.DataAnalystPanels.BestSeasonsJPanel;
import UserInterface.RoleBasedWorkAreas.DataAnalystPanels.DABestCropsJPanel;
import UserInterface.RoleBasedWorkAreas.DataAnalystPanels.FutureDemandJPanel;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Arrays;
import Business.Models.DeliveryShipment;
import Business.Models.StoreCropQuantityRequirement;
import UserInterface.RoleBasedWorkAreas.DataAnalystPanels.FetchStoreRequirementsJPanel;
import static Utils.Constants.locations;
import static Utils.Constants.stores;
//import static Utils.HistoricalData.plannedCrops;
import java.util.HashMap;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author deepakviswanadh
 */
public class DataAnalystJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DataAnalystWorkAreaJPanel
     */
    List<DataAnalyst> dataAnalystList = new ArrayList<>();
    DataAnalyst loggedInDataAnalyst;
    LoginPerson person;

    public static List<StoreCropQuantityRequirement> eachStoreRequirement = new ArrayList<>();
    public static List<DeliveryShipment> deliveriesMasterList;
    public JPanel MainJPanel;
    public static HashMap<String, Integer> customerVotesForCrops;
    public static ArrayList<String> newCustomerChoiceOfCrops;
    public static HashMap<String,String> customerFeedback;
    public static HashMap<DeliveryDriver, ArrayList<Store>> deliveryPlan;
    public static HashMap<DeliveryDriver, HashMap<Store, String>> driverDeliveryStatus;
    public static HashMap<CropPlanner, HashMap<Crop, List<CropScheduleTechniqueRelation>>> cropPlannerList;
    public static ArrayList<Crop> plannedCrops;

    // Object containing the Crop and the Qty produced ( received from Harvest Tech.
    // )
    public static HashMap<Crop, Integer> quantityGeneratedPerCrop;

    public DataAnalystJPanel(LoginPerson person, List<DataAnalyst> dataAnalystList, JPanel MainJPanel) {
        initComponents();
        this.MainJPanel = MainJPanel;
        this.dataAnalystList = dataAnalystList;
        this.person = person;
        this.loggedInDataAnalyst = getDataAnalystObject();
        cropPlannerList = new HashMap<CropPlanner, HashMap<Crop, List<CropScheduleTechniqueRelation>>>();
        loadCustomerVotesForCrops();
        deliveryPlan = new HashMap();
        quantityGeneratedPerCrop = new HashMap<>();
        deliveriesMasterList = new ArrayList<>();

        // plannedCrops.forEach(eachCrop -> quantityGeneratedPerCrop.put(eachCrop, 30));
        // generateStoreCropRequirements();
    }

    public static void generateStoreCropRequirements() {
        List<String> storeNames = stores;
        int i=0;
        for (String storeName : storeNames) {
            Store store = new Store(storeName, locations.get(i));
            for (Crop crop : plannedCrops) {
                StoreCropQuantityRequirement requirement = new StoreCropQuantityRequirement();
                requirement.setStore(store);
                HashMap<Crop, Integer> cropQuantityRelation = new HashMap<>();
                cropQuantityRelation.put(crop, (int) (Math.random() * 100));
                requirement.setCropQuantityRelation(cropQuantityRelation);
                eachStoreRequirement.add(requirement);
            }
            i++;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        buttonJPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBestCrops = new javax.swing.JButton();
        btnBestSeasons = new javax.swing.JButton();
        btnFutureDemand = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        btnFetchReq = new javax.swing.JButton();
        workAreaJPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        splitPane.setOpaque(false);

        buttonJPanel.setBackground(new java.awt.Color(255, 255, 255));
        buttonJPanel.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\deepa\\OneDrive\\Desktop\\welcome.png")); // NOI18N
        jLabel1.setText("Welcome Data Analyst");
        jLabel1.setOpaque(true);

        btnBestCrops.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        btnBestCrops.setText("Best Crops");
        btnBestCrops.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBestCropsActionPerformed(evt);
            }
        });

        btnBestSeasons.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        btnBestSeasons.setText("Best Seasons");
        btnBestSeasons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBestSeasonsActionPerformed(evt);
            }
        });

        btnFutureDemand.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        btnFutureDemand.setText("Future Demand");
        btnFutureDemand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFutureDemandActionPerformed(evt);
            }
        });

        logoutBtn.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        logoutBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\deepa\\OneDrive\\Desktop\\cross.png")); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        btnFetchReq.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        btnFetchReq.setText("Fetch Store Requirements");
        btnFetchReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFetchReqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonJPanelLayout = new javax.swing.GroupLayout(buttonJPanel);
        buttonJPanel.setLayout(buttonJPanelLayout);
        buttonJPanelLayout.setHorizontalGroup(
            buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonJPanelLayout.createSequentialGroup()
                .addGroup(buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buttonJPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnBestCrops, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBestSeasons, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFutureDemand)
                            .addComponent(btnFetchReq)
                            .addComponent(logoutBtn)))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, buttonJPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonJPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBestCrops, btnBestSeasons, btnFetchReq, btnFutureDemand, logoutBtn});

        buttonJPanelLayout.setVerticalGroup(
            buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonJPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btnBestCrops)
                .addGap(34, 34, 34)
                .addComponent(btnBestSeasons)
                .addGap(32, 32, 32)
                .addComponent(btnFutureDemand)
                .addGap(47, 47, 47)
                .addComponent(btnFetchReq)
                .addGap(41, 41, 41)
                .addComponent(logoutBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonJPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBestCrops, btnBestSeasons, btnFetchReq, btnFutureDemand, logoutBtn});

        splitPane.setLeftComponent(buttonJPanel);

        workAreaJPanel.setBackground(new java.awt.Color(255, 255, 255));
        workAreaJPanel.setOpaque(false);
        workAreaJPanel.setLayout(new java.awt.CardLayout());
        splitPane.setRightComponent(workAreaJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFetchReqActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFetchReqActionPerformed
        // TODO add your handling code here:
        FetchStoreRequirementsJPanel fetchStoreRequirementsJPanel = new FetchStoreRequirementsJPanel();
        workAreaJPanel.add("fetchStoreRequirementsJPanel", fetchStoreRequirementsJPanel);
        CardLayout layout = (CardLayout) workAreaJPanel.getLayout();
        layout.next(workAreaJPanel);
    }// GEN-LAST:event_btnFetchReqActionPerformed

    private void btnFutureDemandActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFutureDemandActionPerformed
        // TODO add your handling code here:
        // CardLayout layout = (CardLayout) workAreaJPanel.getLayout();
        FutureDemandJPanel futureDemandJPanel = new FutureDemandJPanel();
        // workAreaJPanel.add("futureDemandJPanel", futureDemandJPanel);
        // CardLayout layout = (CardLayout) workAreaJPanel.getLayout();
        // layout.next(workAreaJPanel);
    }

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        MainJPanel.remove(this);
        CardLayout layout = (CardLayout) MainJPanel.getLayout();
        layout.previous(MainJPanel);
    }// GEN-LAST:event_logoutBtnActionPerformed

    public DataAnalyst getDataAnalystObject() {
        for (DataAnalyst dataAnalyst : dataAnalystList) {
            if (dataAnalyst.getUserName().equalsIgnoreCase(person.getUserName())) {
                return dataAnalyst;
            }
        }
        return null;
    }

    public HashMap<CropPlanner, HashMap<Crop, List<CropScheduleTechniqueRelation>>> getCropPlannerList() {
        return cropPlannerList;
    }

    public void setCropPlannerList(
            HashMap<CropPlanner, HashMap<Crop, List<CropScheduleTechniqueRelation>>> cropPlannerList) {
        this.cropPlannerList = cropPlannerList;
    }

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        MainJPanel.remove(this);
        CardLayout layout = (CardLayout) MainJPanel.getLayout();
        layout.previous(MainJPanel);
    }// GEN-LAST:event_btnLogoutActionPerformed

    private void btnBestSeasonsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBestSeasonsActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) workAreaJPanel.getLayout();
        BestSeasonsJPanel bestSeasonsJPanel = new BestSeasonsJPanel();
        workAreaJPanel.add("bestSeasonsJPanel", bestSeasonsJPanel);
        layout.next(workAreaJPanel);

    }// GEN-LAST:event_btnBestSeasonsActionPerformed

    private void btnBestCropsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBestCropsActionPerformed
        // TODO add your handling code here:
        DABestCropsJPanel bestCropsJPanel = new DABestCropsJPanel();
        workAreaJPanel.add("bestCropsJPanel", bestCropsJPanel);

        CardLayout layout = (CardLayout) workAreaJPanel.getLayout();
        layout.next(workAreaJPanel);
    }// GEN-LAST:event_btnBestCropsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBestCrops;
    private javax.swing.JButton btnBestSeasons;
    private javax.swing.JButton btnFetchReq;
    private javax.swing.JButton btnFutureDemand;
    private javax.swing.JPanel buttonJPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JPanel workAreaJPanel;
    // End of variables declaration//GEN-END:variables

    private void loadCustomerVotesForCrops() {
        List<String> cropNames = new ArrayList<>(Arrays.asList(
                "Wheat", "Tomato", "Corn", "Lettuce", "Rice",
                "Potato", "Cucumber", "Strawberry", "Carrot", "Spinach",
                "Orange", "Broccoli", "Avocado", "Blueberries", "Pumpkin"));
        customerVotesForCrops = new HashMap();
        for (String crop : cropNames) {
            customerVotesForCrops.put(crop, 0);
        }
        newCustomerChoiceOfCrops = new ArrayList();
        customerFeedback = new HashMap();
    }
}