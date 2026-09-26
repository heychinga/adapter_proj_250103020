public class BulbAdapter implements SmartDeviceRO {
    private LegacyBulbRO legacyBulb;

    public BulbAdapter(LegacyBulbRO legacyBulb) {
        this.legacyBulb = legacyBulb;
    }

    @Override
    public void turnOn() {
        legacyBulb.setBrightness(255);
    }

    @Override
    public void turnOff() {
        legacyBulb.setBrightness(0);
    }

    @Override
    public boolean isOn() {
        return legacyBulb.hasPower();
    }

    @Override
    public int getPowerPercent() {
        return (int) ((legacyBulb.readBrightness() / 255.0) * 100);
    }
}