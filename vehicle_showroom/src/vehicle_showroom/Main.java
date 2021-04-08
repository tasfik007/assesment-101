/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle_showroom;

/**
 *
 * @author RootOver
 */
public class Main {
    
    public static void main(String[] args) {
        
        VehicleShowRoom vroom1 = new VehicleShowRoom();
        
        //initial testing starts (adding items manually)
        //engine power, tire size, engine type
        Vehicle vehicle1 = new NormalVehicle(207,55,"oil");
        //engine power, tire size, engine type, Supports Turbo=true, Only Oil Engine=true
        Vehicle vehicle2 = new SportsVehicle(107,45,"gas",true, true);
        
        vroom1.addVehicle(vehicle1);
        vroom1.addVehicle(vehicle2);
        
        vroom1.currentAvailableVehicles();
        vroom1.removeVehicle(vehicle1);
        //--------------------- initial testing ends ---------------------
        
        //shows the user what he/she can do
        //walks him through the options
        Menu menu = new Menu();
        while(true){
            menu.showInitialOptions(vroom1);
        }
    }
    
}
