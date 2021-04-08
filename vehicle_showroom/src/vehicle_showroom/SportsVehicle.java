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
public class SportsVehicle extends Vehicle {
    
    boolean isTurbo;
    boolean isEngineOilOnly;
    
    public SportsVehicle(int enginePower, int tireSize, String engineType, boolean isTurbo, boolean isEngineOilOnly){
        super(enginePower, tireSize, engineType);
        this.vehicleType = this.getClass().getSimpleName();
        this.isTurbo = isTurbo;
        this.isEngineOilOnly = isEngineOilOnly;
    }
    
   
    
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Supports Turbo : "+isTurbo);
        System.out.println("Engine is only oil type : "+isEngineOilOnly);
    }
    
}
