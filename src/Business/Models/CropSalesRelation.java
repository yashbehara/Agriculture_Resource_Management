/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Models;

/**
 *
 * @author kpraneeth
 */
public class CropSalesRelation {
    
    Crop crop;
    Sales sales;

    public CropSalesRelation(Crop crop, Sales sales) {
        this.crop = crop;
        this.sales = sales;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }
}
