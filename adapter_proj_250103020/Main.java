import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    LegacyBulbRO legacyBulb = new LegacyBulbRO();
    LegacyThermostatRO legacyThermostat = new LegacyThermostatRO();

    SmartDeviceRO bulbAdapter = new BulbAdapter(legacyBulb); 
    SmartDeviceRO thermostatAdapter = new ThermostatAdapter(legacyThermostat); 
    List<SmartDeviceRO> deviceList = new ArrayList<>();
    deviceList.add(bulbAdapter);
    deviceList.add(thermostatAdapter);


    //bad device list for testing
    List<LegacyBulbRO> baddeviceList = new ArrayList<>();
    baddeviceList.add(legacyBulb);




    ModernHubRO hub = new ModernHubRO(deviceList);
    hub.activateAll();
    System.out.println("All devices have been activated");

    System.out.println("Average usage of device: "+hub.calculateAveragePowerUsage());

    hub.emergencyShutdown();
    System.out.println("All devices have been deactivated");



    
    //ModernHubRO badHub = new ModernHubRO(baddeviceList);
    /*
    * The Java rejects this call because ModernHub strictly requires a list of SmartDevice instances, 
    * making the incompatible interface of LegacyBulb a strong mistake. The Object Adapter pattern 
    * resolves this by wrapping the legacyBulb inside a BulbAdapter class that implements SmartDevice
    * This creates a compatible layer that delegates commands without modifying the original legacy code
    */

    }
}
