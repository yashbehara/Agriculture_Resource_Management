/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Models;

import Business.Roles.DeliveryDriver;
import java.util.*;

/**
 *
 * @author deepakviswanadh
 */
public class DeliveryShipment {

    DeliveryDriver deliveryDriver;
    List<StoreCropQuantityRequirement> storesListInThatShipment;

    public DeliveryDriver getDeliveryDriver() {
        return deliveryDriver;
    }

    public void setDeliveryDriver(DeliveryDriver deliveryDriver) {
        this.deliveryDriver = deliveryDriver;
    }

    public List<StoreCropQuantityRequirement> getStoresListInThatShipment() {
        return storesListInThatShipment;
    }

    public void setStoresListInThatShipment(List<StoreCropQuantityRequirement> storesListInThatShipment) {
        this.storesListInThatShipment = storesListInThatShipment;
    }

    public DeliveryShipment() {
        this.storesListInThatShipment = new ArrayList<>();
    }

}
