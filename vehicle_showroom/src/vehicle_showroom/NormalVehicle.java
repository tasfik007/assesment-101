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
public class NormalVehicle extends Vehicle {
    
    public NormalVehicle(int enginePower, int tireSize, String engineType){
        super(enginePower, tireSize, engineType);
        this.vehicleType = this.getClass().getSimpleName();
    }
    
    
    @Override
    public void displayInfo(){
        super.displayInfo();
    }
    
}
