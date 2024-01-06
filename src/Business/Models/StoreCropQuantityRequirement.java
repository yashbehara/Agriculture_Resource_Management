/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Models;

import static Utils.Constants.deliveryStatuses;
import java.util.HashMap;

/**
 *
 * @author deepakviswanadh
 */
public class StoreCropQuantityRequirement {

    Store store;
    HashMap<Crop, Integer> cropQuantityRelation;
    String deliveryStatus;

    public StoreCropQuantityRequirement() {
        cropQuantityRelation = new HashMap<>();
        deliveryStatus = deliveryStatuses.get(0);
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public HashMap<Crop, Integer> getCropQuantityRelation() {
        return cropQuantityRelation;
    }

    public void setCropQuantityRelation(HashMap<Crop, Integer> cropQuantityRelation) {
        this.cropQuantityRelation = cropQuantityRelation;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    @Override
    public String toString() {
        return this.getStore().getStoreName();
    }

}
