public interface SmartDeviceRO {
    void turnOn();

    void turnOff();

    boolean isOn();

    int getPowerPercent(); // Standard range: 0 to 100
}