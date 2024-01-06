/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Models;

/**
 *
 * @author deepakviswanadh
 */
public class CropSchedule {
    String day;
    String time;

    public CropSchedule(){
        
    }

    public CropSchedule(String day, String time) {
        this.day = day;
        this.time = time;
    }
    
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public String getDayNTime() {
        return day + " " + time;
    }
    
}
