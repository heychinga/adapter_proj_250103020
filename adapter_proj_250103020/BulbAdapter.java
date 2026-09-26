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
        if(!legacyBulb.hasPower()){
            return 0;
        }
        
        int raw_percent = (int) ((legacyBulb.readBrightness()/255.0) * 100);
        int cal_percent=raw_percent+0; //250103020 <
        return cal_percent;
    }
}