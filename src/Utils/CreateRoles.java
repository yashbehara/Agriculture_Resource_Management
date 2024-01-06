/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Business.Roles.CropPlanner;
import Business.Roles.DataAnalyst;
import Business.Roles.DeliveryDriver;
import Business.Roles.WarehouseCoordinator;
import Business.Roles.HarvestTechnician;
import Business.Roles.SalesAssociate;
import static Utils.Constants.roles;
import static Utils.CreateUsers.genHash;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yash
 */
public class CreateRoles {

    static List<CropPlanner> cropPlannerList = new ArrayList<>();
    static List<DataAnalyst> dataAnalystList = new ArrayList<>();
    static List<WarehouseCoordinator> warehouseCoordinatorList = new ArrayList<>();
    static List<DeliveryDriver> deliveryDriverList = new ArrayList<>();
    static List<HarvestTechnician> harvestTechnicianList = new ArrayList<>();
    static List<SalesAssociate> salesAssociateList = new ArrayList<>();

    public static List<CropPlanner> generateCropPlanner(byte[] salt) {

        try {
            cropPlannerList.add(new CropPlanner("CropPlanner1", genHash("1", salt), roles[0], "CropPlanner1"));
            cropPlannerList.add(new CropPlanner("CropPlanner2", genHash("1", salt), roles[0], "CropPlanner2"));


        } catch (Exception e) {

        } finally {
            return cropPlannerList;
        }
    }

    public static List<DataAnalyst> generateDataAnalyst(byte[] salt) {

        try {
            dataAnalystList.add(new DataAnalyst("DataAnalyst", genHash("2", salt), roles[1], "DataAnalyst"));

        } catch (Exception e) {

        } finally {
            return dataAnalystList;
        }
    }

    public static List<WarehouseCoordinator> generateWareHouseCoordinator(byte[] salt) {

        try {
            warehouseCoordinatorList.add(new WarehouseCoordinator("WHC1", genHash("6", salt), roles[5], "WHC1"));
            warehouseCoordinatorList.add(new WarehouseCoordinator("WHC2", genHash("6", salt), roles[5], "WHC2"));

        } catch (Exception e) {

        } finally {
            return warehouseCoordinatorList;
        }
    }

    public static List<DeliveryDriver> generateDeliveryDriverList(byte[] salt) {

        try {
            deliveryDriverList.add(new DeliveryDriver("DeliveryDriver1", genHash("3", salt), roles[2], "DeliveryDriver1"));
            deliveryDriverList.add(new DeliveryDriver("DeliveryDriver2", genHash("3", salt), roles[2], "DeliveryDriver2"));
            deliveryDriverList.add(new DeliveryDriver("DeliveryDriver3", genHash("3", salt), roles[2], "DeliveryDriver3"));

        } catch (Exception e) {

        } finally {
            return deliveryDriverList;
        }
    }

    
    public static List<HarvestTechnician> generateHarvestTechnician(byte[] salt){
       
        try{
            harvestTechnicianList.add(new HarvestTechnician("HarvestTechnician1", genHash("4", salt), roles[3], "HarvestTechnician1")); 
            harvestTechnicianList.add(new HarvestTechnician("HarvestTechnician2", genHash("4", salt), roles[3], "HarvestTechnician2")); 
        }
         catch (Exception e) {

        } finally {
            return harvestTechnicianList;
        }
    
    }

    public static List<SalesAssociate> generateSalesAssociate(byte[] salt) {
        try {
            salesAssociateList.add(new SalesAssociate("SalesAssociate1", genHash("5", salt), roles[4], "SalesAssociate1"));
           
          
        } catch (Exception e) {

        } finally {
            return salesAssociateList;
        }
    }

}
