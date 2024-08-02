## Agricultural Eco-system Management:

## Tech : 
• Core Java
• Java Swing
• Apache Netbeans
• MongoDB, MongoDB Atlas

## Project Description

The Agricultural Eco-system Management is a comprehensive solution designed to revolutionize the agricultural sector by integrating four enterprises—Farms, Distribution, Analytics, and Marts—alongside six key organizations and diverse roles. 

At its core, the system optimizes agricultural operations through data-driven insights and efficient coordination. The Data Analyst extracts valuable information to inform decision-making, while the Crop Planner strategically aligns crop planting with market demands. 

Warehouse Coordinators manage inventory and facilitate seamless deliveries, and Delivery Drivers ensure timely transportation. 

Sales Associates promote products, and Harvest Technicians implement cultivation techniques. Together, these roles create a cohesive framework, enhancing the overall efficiency, sustainability, and success of modern agricultural practices.	


## Architecture : 
<img width="1710" alt="Screenshot 2024-08-02 at 10 30 37 AM" src="https://github.com/user-attachments/assets/fe3ba8c7-1c60-4af1-8482-899c464d287d">


## Implementation : 

• Designed an architecture to streamline agricultural operations, incorporating data-driven insights and coordination among
multiple enterprises
• Integrated with MVC (Model, View, Controller), factory, and singleton design patterns to organize code effectively
• Utilized MongoDB Atlas to establish a fully cloud-hosted database infrastructure, ensuring scalable and efficient data management for the application

## It has 4 Enterprises:

•	Farms Enterprise
•	Distribution Enterprise
•	Analytics Enterprise
•	Marts Enterprise

## It has 6 Organizations:
•	Crop Planning Organization
•	Harvest Operation Organization
•	Regional Distribution Organization
•	Data Analytics and Farm Management Organization
•	Logistics Organization
•	Customer Relation Organization

## It has 6 Roles:
•	Crop Planner
•	Harvest Technician
•	Warehouse Manager
•	Data Analyst
•	Delivery Driver
•	Sales Associates


## Validations : 
•	A user assigned to a specific role cannot access the portals of other roles.
•	Portal will not allow the user to login if the input credentials are not valid.

1.	Sales Associate:
 
•	Sales Associate cannot add duplicate crop requirement per store and location once the requirement is published to the Data Analyst Org.

2.	Warehouse Coordinator:
 
•	The warehouse coordinator cannot create a delivery schedule if the overall crop requirement is more than the inventory quantity for a given crop.

3.	Crop planner validations:
 
•	When adding the crops to the list, if crop is already added, the user will get a notification that the crop is already added to schedule.
•	Crop Planner will only be able to forecast future data and not for previous years data in the Forecast Panel
•	Crop Planner cannot finalize the schedule until all the crop plans have been added.

4.	Harvest Technician: 

•	Only when the Status of the crop plan is updated to ‘completed’ , user will be able to add the Quantity of the crop produced.

## Contributors: 

## Kameswara Krishna Sai Praneeth Kattamuri: NUID (002294248)
## Yashwanth Behara: NUID (002299461)
## Venkata Deepak Viswanadha: NUID (002299829)
