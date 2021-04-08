/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle_showroom;
import java.util.Scanner;

/**
 *
 * @author RootOver
 */
public final class Menu {
    public void showInitialOptions(VehicleShowRoom vroom){
        Scanner input = new Scanner(System.in);
        System.out.println("Choose an option (a/b/c) from below:");
        System.out.println("=======================================");
        System.out.println("        a. Create & add vehicle");
        System.out.println("        b. Remove a vehicle");
        System.out.println("        c. Display Showroom's current status");
        System.out.println("        d. Press d to exit");
        char option = input.next().charAt(0);
        while(option!='a' && option!='b' && option!='c' && option!='d'){
            System.out.println("Option not valid!!");
            System.out.println("Choose again:");
            option = input.next().charAt(0);
        }
        
        switch(option){
            case 'a':
                vroom.addVehicle(createVehicle());
                break;
            case 'b':
                System.out.println("Choose a vehicle model from below to remove:");
                vroom.currentAvailableVehicles();
                System.out.println("");
                int vehicleModel = input.nextInt();
                vroom.removeVehicle(vehicleModel);
                break;
            case 'c':
                vroom.currentAvailableVehicles();
                break;
            default:
                System.exit(0);
        }
    }
    
    public static void engineEnterMsg(){
        System.out.println("Choose engine type (a/b/c) from below:");
        System.out.println("=======================================");
        System.out.println("        a. Oil");
        System.out.println("        b. Gas");
        System.out.println("        c. Diesel");
    }
    public static void vehicleEnterMsg(){
        System.out.println("Choose vehicle type (a/b/c) from below:");
        System.out.println("=======================================");
        System.out.println("        a. Normal");
        System.out.println("        b. Sports");
        System.out.println("        c. Heavy");
    }
    
    public static Vehicle createVehicle(){
        Scanner input = new Scanner(System.in);
        
        engineEnterMsg();
        char engineOption = input.next().charAt(0);
        while(engineOption!='a' && engineOption!='b' && engineOption!='c'){
            System.out.println("Option not valid!!");
            System.out.println("Choose again:");
            engineOption = input.next().charAt(0);
            //engineEnterMsg();
        }
        String engineType;
        switch(engineOption){
            case 'a':
                engineType = "oil";
                break;
            case 'b':
                engineType = "gas";
                break;
            case 'c':
                engineType = "diesel";
                break;
            default:
                engineType = "";
        }
        System.out.println("");
        System.out.print("Enter engine power:");
        int enginePower = input.nextInt();
        System.out.println("");
        System.out.print("Enter tire size:");
        int tireSize = input.nextInt();
        System.out.println("");
        
        vehicleEnterMsg();
        char vehicleOption = input.next().charAt(0);
        while(vehicleOption!='a' && vehicleOption!='b' && vehicleOption!='c'){
            System.out.println("Option not valid!!");
            System.out.println("Choose again:");
            vehicleOption = input.next().charAt(0);
            //vehicleEnterMsg();
        }
        System.out.println("");
        
        Vehicle vehicle;
        
        switch(vehicleOption){
            case 'a':
                vehicle = new NormalVehicle(enginePower, tireSize, engineType);
                break;
            case 'b':
                System.out.println("Does this sports car has Turbo Mode? choose(1/2)");
                System.out.println("        1. Yes");
                System.out.println("        2. No");
                int turboOption = input.nextInt();
                while(turboOption!=1 && turboOption!=2){
                    System.out.println("Not a valid option!!");
                    System.out.println("Choose again.");
                    turboOption = input.nextInt();
                }
                boolean isTurbo = (turboOption==1);
                
                System.out.println("Besides oil engine type, does it supports any others? choose(1/2)");
                System.out.println("        1. Yes");
                System.out.println("        2. No");
                int extraEngineTypeSports = input.nextInt();
                while(extraEngineTypeSports!=1 && extraEngineTypeSports!=2){
                    System.out.println("Not a valid option!!");
                    System.out.println("Choose again.");
                    extraEngineTypeSports = input.nextInt();
                }
                boolean onlyOilEngineSports = (extraEngineTypeSports!=1);
                vehicle = new SportsVehicle(enginePower, tireSize, engineType, isTurbo, onlyOilEngineSports);
                break;
            case 'c':
                System.out.println("Enter the weight: ");
                int weight  = input.nextInt();
                System.out.println("Besides diesel engine type, does it supports any others? choose(1/2)");
                System.out.println("        1. Yes");
                System.out.println("        2. No");
                int extraEngineTypeHeavy = input.nextInt();
                while(extraEngineTypeHeavy!=1 && extraEngineTypeHeavy!=2){
                    System.out.println("Not a valid option!!");
                    System.out.println("Choose again.");
                    extraEngineTypeHeavy = input.nextInt();
                }
                boolean onlyDieselEngineHeavy = (extraEngineTypeHeavy!=1);
                vehicle = new HeavyVehicle(enginePower, tireSize, engineType, weight, onlyDieselEngineHeavy);
                break;
            default:
                vehicle = null; 
        }
        
        return vehicle;
        
    }
    public static void mainMenu(VehicleShowRoom vroom){
        Scanner input = new Scanner(System.in);
        System.out.println("Choose an option (a/b/c) from below:");
        System.out.println("=======================================");
        System.out.println("        a. Create & add vehicle");
        System.out.println("        b. Remove a vehicle");
        System.out.println("        c. Display Showroom's current status");
        System.out.println("        d. Press d to exit");
        char option = input.next().charAt(0);
        while(option!='a' && option!='b' && option!='c' && option!='d'){
            System.out.println("Option not valid!!");
            System.out.println("Choose again:");
            option = input.next().charAt(0);
        }
        
        switch(option){
            case 'a':
                vroom.addVehicle(createVehicle());
                break;
            case 'b':
                
                break;
            case 'c':
                vroom.currentAvailableVehicles();
                break;
            default:
                System.exit(0);
        }
        
    }
}
