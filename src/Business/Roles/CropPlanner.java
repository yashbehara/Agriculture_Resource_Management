/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.Models.Crop;
import Business.Models.CropScheduleTechniqueRelation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author deepakviswanadh
 */
public class CropPlanner extends Person {

    //add CropPlanner attributes
    public HashMap<Crop, List<CropScheduleTechniqueRelation>> scheduleOfAllCropsOfPlanner;
    public ArrayList<Crop> selectedCropsList;
    
    public CropPlanner() {
        scheduleOfAllCropsOfPlanner = new HashMap<>();
    }

    public CropPlanner(String userName, String password, String role, String name) {
        super(userName, password, role, name);
        selectedCropsList = new ArrayList<>();
        scheduleOfAllCropsOfPlanner = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<Crop> getSelectedCropsList() {
        return selectedCropsList;
    }

    public void setSelectedCropsList(ArrayList<Crop> selectedCropsList) {
        this.selectedCropsList = selectedCropsList;
    }
    
    public HashMap<Crop, List<CropScheduleTechniqueRelation>> getScheduleOfAllCropsOfPlanner() {
        return scheduleOfAllCropsOfPlanner;
    }

    public void setScheduleOfAllCropsOfPlanner(HashMap<Crop, List<CropScheduleTechniqueRelation>> scheduleOfAllCropsOfPlanner) {
        this.scheduleOfAllCropsOfPlanner = scheduleOfAllCropsOfPlanner;
    }
}


