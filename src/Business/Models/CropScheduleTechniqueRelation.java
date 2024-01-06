/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Models;

import static Utils.Constants.harvestingStatus;

/**
 *
 * @author deepakviswanadh
 */
public class CropScheduleTechniqueRelation {

    CropSchedule cropSchedule;
    String technique;
    String HarvestTechnicianStatus;

    public CropScheduleTechniqueRelation() {

    }

    public CropScheduleTechniqueRelation(CropSchedule cropSchedule, String technique) {
        this.cropSchedule = cropSchedule;
        this.technique = technique;
        this.HarvestTechnicianStatus = harvestingStatus.get(0);
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public CropSchedule getCropSchedule() {
        return cropSchedule;
    }

    public void setCropSchedule(CropSchedule cropSchedule) {
        this.cropSchedule = cropSchedule;
    }

    public String getHarvestTechnicianStatus() {
        return HarvestTechnicianStatus;
    }

    public void setHarvestTechnicianStatus(String HarvestTechnicianStatus) {
        this.HarvestTechnicianStatus = HarvestTechnicianStatus;
    }

}
