package Utils;

import Business.LoginPerson.LoginPerson;
import Business.Roles.WarehouseCoordinator;
import static Utils.Constants.roles;
import static Utils.CreateRoles.warehouseCoordinatorList;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import static Utils.Hashing.hashPassword;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author deepakviswanadh
 */
public class CreateUsers {

    public static List<LoginPerson> generateUsers(byte[] salt) {
        List<LoginPerson> usersList = new ArrayList<>();
        try {
            usersList.add(new LoginPerson("CropPlanner1", genHash("1", salt), roles[0]));
            usersList.add(new LoginPerson("CropPlanner2", genHash("1", salt), roles[0]));
            usersList.add(new LoginPerson("DataAnalyst", genHash("2", salt), roles[1]));
            usersList.add(new LoginPerson("DeliveryDriver1", genHash("3", salt), roles[2]));
            usersList.add(new LoginPerson("DeliveryDriver2", genHash("3", salt), roles[2]));
            usersList.add(new LoginPerson("DeliveryDriver3", genHash("3", salt), roles[2]));
            usersList.add(new LoginPerson("HarvestTechnician1", genHash("4", salt), roles[3]));
            usersList.add(new LoginPerson("HarvestTechnician2", genHash("4", salt), roles[3]));
            usersList.add(new LoginPerson("SalesAssociate", genHash("5", salt), roles[4]));

            usersList.add(new LoginPerson("WHC1", genHash("6", salt), roles[5]));
            usersList.add(new LoginPerson("WHC2", genHash("6", salt), roles[5]));

        } catch (Exception e) {

        } finally {
            return usersList;
        }
    }

    public static String genHash(String pass, byte[] salt) throws NoSuchAlgorithmException {

        // Hash the password with the salt
        String hashedPassword = hashPassword(pass, salt);

        // Print the salt and hashed password
        return hashedPassword;

    }
}
