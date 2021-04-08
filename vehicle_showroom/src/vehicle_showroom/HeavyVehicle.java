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
public class HeavyVehicle extends Vehicle {
    private int weight;
    boolean isEngineDieselOnly;
    public HeavyVehicle(int enginePower, int tireSize, String engineType, int weight, boolean isEngineDieselOnly){
        super(enginePower, tireSize, engineType);
        this.vehicleType = this.getClass().getSimpleName();
        this.weight = weight;
        this.isEngineDieselOnly = isEngineDieselOnly;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return this.weight;
    }
    
    @Override
    public void displayInfo(){
        super.displayInfo();
    }
}
