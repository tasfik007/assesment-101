/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle_showroom;
import java.util.*;

/**
 *
 * @author RootOver
 */
public class VehicleShowRoom {
    HashMap<Integer,Vehicle> vehicles;
    private int visitors;

    public VehicleShowRoom() {
        this.vehicles = new HashMap<>();
        this.visitors = 30;
    }
    
    
    public int getVisitors(){
        return this.visitors;
    }
    
    public void addVehicle(Vehicle vehicle){
        if(this.vehicles.containsKey(vehicle.getModelNumber())){
            System.out.println("Log MSG: Vehicle with same ID already exists!!");
        }
        else{
            this.vehicles.put(vehicle.getModelNumber(), vehicle);
            if(vehicle.getVehicleType().equalsIgnoreCase("sportsVehicle")){
                this.visitors+=20;
            }
            System.out.println("Log MSG: Vehicle with Model Number = "+vehicle.getModelNumber()+" got added!!");
        }
    }
    
    public void removeVehicle(Vehicle vehicle){
        if(!this.vehicles.containsKey(vehicle.getModelNumber())){
            System.out.println("Log MSG: Mentioned vehicle do not exists!!");
        }
        else{
            this.vehicles.remove(vehicle.getModelNumber(), vehicle);
            System.out.println("Log MSG: Vehicle with Model Number = "+vehicle.getModelNumber()+" got removed!!");
        }
    }
    public void removeVehicle(int vehicleModelNumber){
        if(!this.vehicles.containsKey(vehicleModelNumber)){
            System.out.println("Log MSG: Mentioned vehicle do not exists!!");
        }
        else{
            this.vehicles.remove(vehicleModelNumber);
            System.out.println("Log MSG: Vehicle with Model Number = "+vehicleModelNumber+" got removed!!");
        }
    }
    
    public void currentAvailableVehicles(){
        
        System.out.println("");
        System.out.println("Currently expected visitors count: "+this.visitors);
        System.out.println("");
        System.out.println("Currently Available Vehicles Are:");
        System.out.println("=================================");
        for(Map.Entry vehicle:vehicles.entrySet()){  
           Vehicle v = (Vehicle)vehicle.getValue();
           v.displayInfo();
            System.out.println("-------------------------------");
         }  
        System.out.println("");
    }
    
    
    
}
