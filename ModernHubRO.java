import java.util.List;

public class ModernHubRO {
    private final List<SmartDeviceRO> devices;

    public ModernHubRO(List<SmartDeviceRO> devices) {
        this.devices = devices;
    }

    public void activateAll() {
        for (SmartDeviceRO d : devices) {
            d.turnOn();
        }
    }

    public void emergencyShutdown() {
        for (SmartDeviceRO d : devices) {
            d.turnOff();
        }
    }

    public double calculateAveragePowerUsage() {
        if (devices.isEmpty())
            return 0.0;
        int sum = 0;
        for (SmartDeviceRO d : devices) {
            sum += d.getPowerPercent();
        }
        return (double) sum / devices.size();
    }
}
