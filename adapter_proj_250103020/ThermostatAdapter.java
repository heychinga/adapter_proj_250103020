public class ThermostatAdapter implements SmartDeviceRO{
    private final LegacyThermostatRO thermostat;
    public ThermostatAdapter(LegacyThermostatRO thermostat){
        if (thermostat == null) {
            throw new IllegalArgumentException("Legacythermostat can't be null");
        }
        this.thermostat=thermostat;
    }

    @Override 
    public void turnOff(){
        thermostat.rotateDial("IDLE");
    }

    @Override 
    public void turnOn(){
        if(thermostat.checkDial().equals("IDLE")){
            thermostat.rotateDial("LOW");
        }
    }

    @Override 
    public boolean isOn(){
        if(thermostat.checkDial().equals("IDLE")){
            return false;
        }
        return true;
        
    }

    @Override 
    public int getPowerPercent(){
        if(thermostat.checkDial().equals("LOW")){
            return 33;
        }
        if(thermostat.checkDial().equals("MEDIUM")){
            return 66;
        }
        if(thermostat.checkDial().equals("MAX")){
            return 100;
        }
        return 0;
        
    }
}
