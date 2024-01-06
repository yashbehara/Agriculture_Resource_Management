/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UserInterface;

import Business.LoginPerson.LoginPerson;
import Business.Models.Crop;
import Business.Models.CropScheduleTechniqueRelation;
import Business.Roles.CropPlanner;
import Business.Roles.DataAnalyst;
import Business.Roles.DeliveryDriver;
import Business.Roles.WarehouseCoordinator;
import Business.Roles.HarvestTechnician;
import Business.Roles.SalesAssociate;
import UserInterface.RoleBasedWorkAreas.CropPlannerJPanel;
import UserInterface.RoleBasedWorkAreas.CropPlannerPanels.CropPlantingScheduleJPanel;
import UserInterface.RoleBasedWorkAreas.DataAnalystJPanel;
import UserInterface.RoleBasedWorkAreas.DeliveryDriverJPanel;
import UserInterface.RoleBasedWorkAreas.HarvestTechnicianJPanel;
import UserInterface.RoleBasedWorkAreas.SalesAssociateJPanel;
import UserInterface.RoleBasedWorkAreas.WarehouseCoordinatorJPanel;
import Utils.CreateRoles;
import static Utils.CreateUsers.generateUsers;
import static Utils.Hashing.checkPassword;
import static Utils.Hashing.generateSalt;
import Utils.HistoricalData;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.*;
import java.util.logging.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.bson.Document;
import com.github.javafaker.Faker;
import java.io.IOException;
import javax.imageio.ImageIO;

class BackgroundPanel extends JPanel {

    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

/**
 *
 * @author yash
 */
public class MainJFrame extends javax.swing.JFrame {

    ImageIcon dataAnalystImage = new ImageIcon("D://NEU_GIT//FALL_2023//INFO 5100//final-project-team-endgame//src//images//dataAnalyst.png");
    ImageIcon cropPlannerImage = new ImageIcon("D://NEU_GIT//FALL_2023//INFO 5100//final-project-team-endgame//src//images//cropPlanner.png");
    ImageIcon harvestTechnicianImage = new ImageIcon("D://NEU_GIT//FALL_2023//INFO 5100//final-project-team-endgame//src//images//harvestTechnician.png");
    ImageIcon warehouseCoordinatorImage = new ImageIcon("D://NEU_GIT//FALL_2023//INFO 5100//final-project-team-endgame//src//images//warehouseCoordinator.png");
    ImageIcon salesAssociateImage = new ImageIcon("D://NEU_GIT//FALL_2023//INFO 5100//final-project-team-endgame//src//images//salesAssociate.png");
    ImageIcon deliveryDriverImage = new ImageIcon("D://NEU_GIT//FALL_2023//INFO 5100//final-project-team-endgame//src//images//deliveryDriver.png");
    ImageIcon backgroundImage = new ImageIcon("D://NEU_GIT//FALL_2023//INFO 5100//final-project-team-endgame//src//images//image.png");

    
    
    /**
     * Creates new form MainJFrame
     */
    HashMap<Crop, List<CropScheduleTechniqueRelation>> scheduleOfAllCrops;
    List<LoginPerson> usersList = new ArrayList<>();
    byte[] salt = generateSalt();
    List<CropPlanner> cropPlannerList = new ArrayList<>();
    List<DataAnalyst> dataAnalystList = new ArrayList<>();
    List<WarehouseCoordinator> warehouseCoordinatorList = new ArrayList<>();
    List<DeliveryDriver> deliveryDriverList = new ArrayList<>();
    List<HarvestTechnician> harvestTechnicianList = new ArrayList<>();
    List<SalesAssociate> salesAssociateList = new ArrayList<>();

    public MainJFrame() {
        initComponents();

//       BackgroundPanel backgroundPanel = new BackgroundPanel("Users/yash/Downloads/image.png");
//        setContentPane(backgroundPanel);
//        backgroundPanel.setLayout(new BorderLayout()); // Use BorderLayout or any layout as per your need
//        backgroundPanel.add(MainJPanel1, BorderLayout.CENTER); // Add your main panel to the background panel
//        mongo();
//        HistoricalData.generateMarketnSeasonBasedData();
//        HistoricalData.generatePreviousYearsMarketData();
//        HistoricalData.futureCropDataPrediction();
//        HistoricalData.generateMarketBasedDatafromJSON();
//        HistoricalData.generateSeasonBasedDatafromJSON();
        HistoricalData.generatePreviousYearsMarketDataNew();
        HistoricalData.generateMarketnSeasonBasedData();
        HistoricalData.futureCropDataPredictionNew();
        scheduleOfAllCrops = new HashMap<>();
          HistoricalData data = new HistoricalData();
        usersList = generateUsers(salt);
        cropPlannerList = CreateRoles.generateCropPlanner(salt);
        dataAnalystList = CreateRoles.generateDataAnalyst(salt);
        warehouseCoordinatorList = CreateRoles.generateWareHouseCoordinator(salt);
        deliveryDriverList = CreateRoles.generateDeliveryDriverList(salt);
        System.out.println("deliveryDriverList" + deliveryDriverList.size());
        harvestTechnicianList = CreateRoles.generateHarvestTechnician(salt);
        salesAssociateList = CreateRoles.generateSalesAssociate(salt);
        jLabel1.setIcon(backgroundImage);

    }

//    private void updateLabelIcon() {
//        CardLayout cardLayout = (CardLayout) MainJPanel.getLayout();
//        String cardName = cardLayout.get
//
//        if ("card2".equals(cardName)) {
//            jLabel1.setIcon(new ImageIcon("path_to_image2.png")); // Update with the path to the new image
//        } else {
//            jLabel1.setIcon(new ImageIcon("path_to_image1.png")); // Update with the path to the default image
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainJPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        MainJPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtLoginUserName = new javax.swing.JTextField();
        txtLoginPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainJPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Wide Latin", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Agri Synergy");
        jLabel2.setOpaque(true);
        MainJPanel1.add(jLabel2);
        jLabel2.setBounds(570, 10, 410, 60);

        MainJPanel.setOpaque(false);
        MainJPanel.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Password:");

        btnLogin.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon("C:\\Users\\deepa\\OneDrive\\Desktop\\6.png")); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("User Name:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(241, 241, 241)
                            .addComponent(txtLoginUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(81, 81, 81)
                            .addComponent(btnLogin)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(1165, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4, txtLoginPassword, txtLoginUserName});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLoginUserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addContainerGap(779, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4, txtLoginPassword, txtLoginUserName});

        MainJPanel.add(jPanel1, "card2");

        MainJPanel1.add(MainJPanel);
        MainJPanel.setBounds(20, 40, 1550, 940);
        MainJPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1580, 950);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String userName = txtLoginUserName.getText();
        String password = String.valueOf(txtLoginPassword.getPassword());
        //blank checks
        if (userName.isBlank() || password.isBlank()) {
            JOptionPane.showMessageDialog(null, "Cannot add empty fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Boolean matchPassword = false;
        //check if a valid user
        for (LoginPerson person : usersList) {
            if (person.isActive) {
                person.isActive = false;
            }

            try {
                matchPassword = checkPassword(password, person.getPassword(), salt);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (person.getUserName().equals(userName) && matchPassword) {
                person.isActive = true;
                String role = person.getRole();
                CardLayout layout = (CardLayout) MainJPanel.getLayout();
                //role based redirect
                switch (role) {

                    case "CropPlanner":
                        JOptionPane.showMessageDialog(null, "Login success", "Information",
                                JOptionPane.INFORMATION_MESSAGE);
                        CropPlannerJPanel cropPlannerJPanel = new CropPlannerJPanel(scheduleOfAllCrops, person, cropPlannerList, MainJPanel);
                        MainJPanel.add("cropPlannerJPanel", cropPlannerJPanel);
                        jLabel1.setIcon(cropPlannerImage);

                        layout.next(MainJPanel);
                        break;

                    case "DataAnalyst":
                        JOptionPane.showMessageDialog(null, "Login success", "Information",
                                JOptionPane.INFORMATION_MESSAGE);
                        DataAnalystJPanel dataAnalystJPanel = new DataAnalystJPanel(person, dataAnalystList, MainJPanel);
                        MainJPanel.add("dataAnalystJPanel", dataAnalystJPanel);
                        jLabel1.setIcon(dataAnalystImage);
                        layout.next(MainJPanel);
                        break;

                    case "WarehouseCoordinator":
                        JOptionPane.showMessageDialog(null, "Login success", "Information",
                                JOptionPane.INFORMATION_MESSAGE);
                        WarehouseCoordinatorJPanel warehouseCoordinatorJPanel = new WarehouseCoordinatorJPanel(person, warehouseCoordinatorList, MainJPanel,
                                deliveryDriverList);
                        MainJPanel.add("warehouseCoordinatorJPanel", warehouseCoordinatorJPanel);
                        jLabel1.setIcon(warehouseCoordinatorImage);

                        layout.next(MainJPanel);
                        break;

                    case "HarvestTechnician":
                        JOptionPane.showMessageDialog(null, "Login success", "Information",
                                JOptionPane.INFORMATION_MESSAGE);
                        HarvestTechnicianJPanel harvestTechJPanel = new HarvestTechnicianJPanel(person, harvestTechnicianList, MainJPanel);
                        MainJPanel.add("harvestTechJPanel", harvestTechJPanel);
                        jLabel1.setIcon(harvestTechnicianImage);

                        layout.next(MainJPanel);
                        break;

                    case "DeliveryDriver":
                        JOptionPane.showMessageDialog(null, "Login success", "Information",
                                JOptionPane.INFORMATION_MESSAGE);
                        DeliveryDriverJPanel deliveryDriverJPanel = new DeliveryDriverJPanel(person, deliveryDriverList, MainJPanel);
                        MainJPanel.add("deliveryDriverJPanel", deliveryDriverJPanel);
                        jLabel1.setIcon(deliveryDriverImage);

                        layout.next(MainJPanel);
                        break;

                    case "SalesAssociate":
                        JOptionPane.showMessageDialog(null, "Login success", "Information",
                                JOptionPane.INFORMATION_MESSAGE);
                        SalesAssociateJPanel salesAssociateJPanel = new SalesAssociateJPanel(person, salesAssociateList, MainJPanel);
                        MainJPanel.add("salesAssociateJPanel", salesAssociateJPanel);
                        jLabel1.setIcon(salesAssociateImage);

                        layout.next(MainJPanel);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Unidentified user type", "Error", JOptionPane.ERROR_MESSAGE);
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Incorrect Credentials", "Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainJPanel;
    private javax.swing.JPanel MainJPanel1;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtLoginPassword;
    private javax.swing.JTextField txtLoginUserName;
    // End of variables declaration//GEN-END:variables

    private void mongo() {
        MongoClient mongo = new MongoClient("localhost", 27017);
        System.out.println("Connected!!");

        MongoDatabase db = mongo.getDatabase("local");

        MongoCursor<String> dbsCusor = mongo.listDatabaseNames().iterator();
//        while(dbsCusor.hasNext()){
//            System.out.println("Mongo "+dbsCusor.next());
//        }
        MongoCollection<Document> col = db.getCollection("users");
        FindIterable<Document> iterDoc = col.find();
//      Iterator it = iterDoc.iterator();
        for (Document doc : iterDoc) {
            System.out.println(doc.get("name"));
        }

    }
}
