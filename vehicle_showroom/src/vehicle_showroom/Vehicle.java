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
public abstract class Vehicle {
    private static final int BASE_MODEL = 1001;
    private static int counter = 0;
    private final int modelNumber;
    int enginePower;
    int tireSize;
    protected String vehicleType;
    private String engineType;
    
    public Vehicle(int enginePower, int tireSize, String engineType){
        this.modelNumber = BASE_MODEL+counter;
        counter++;
        this.enginePower = enginePower;
        this.tireSize = tireSize;
        this.engineType = engineType;
    }
    
    public int getModelNumber(){
        return modelNumber;
    }
    
    public String getVehicleType(){
        return vehicleType;
    }
    public void setVehicleType(String type){
        this.vehicleType = type;
    }
    public boolean isValidEngineType(String engineType){
        return (engineType.equalsIgnoreCase("oil") || engineType.equalsIgnoreCase("gas") || engineType.equalsIgnoreCase("diesel"));
    }
    public boolean isValidVehicleType(String vehcileType){
        return (vehcileType.equalsIgnoreCase("normal") || vehcileType.equalsIgnoreCase("sports") || vehcileType.equalsIgnoreCase("heavy"));
    }
    
    public void setEngineType(String engineType){
        if(isValidEngineType(engineType)){
            this.engineType = engineType;
        }
        else{
            System.out.println("Entered Engine Type is Not Valid!!");
        }
    }
    public String getEngineType(){
        return engineType;
    }
    
    public void displayInfo(){
        System.out.println("Model Number: "+modelNumber);
        System.out.println("Vehicle Type: "+vehicleType);
        System.out.println("Engine Type: "+engineType);
        System.out.println("Engine Power: "+enginePower);
        System.out.println("Tire Size: "+tireSize);
    };
}
