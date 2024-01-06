/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.*;

/**
 *
 * @author deepakviswanadh
 */
public class Constants {

        public static final String[] roles = new String[] { "CropPlanner", "DataAnalyst", "DeliveryDriver",
                        "HarvestTechnician",
                        "SalesAssociate", "WarehouseCoordinator" };
        public final static List<String> days = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        public final static List<String> harvestingStatus = Arrays.asList("Not Planned", "Started", "In Progress",
                        "Completed", "Failure");
        public static final List<String> stores = Arrays.asList("Vijetha", "Vijetha", "Vijetha");
        public static final List<String> locations = Arrays.asList("Nad", "Gajuwaka", "Muralinagar");
        public static final List<String> deliveryDriverNames = Arrays.asList("John", "Doe", "Mama", "Mia");
        public static final List<String> deliveryStatuses = Arrays.asList("Scheduled", "In-Progress", "Delivered");
}
