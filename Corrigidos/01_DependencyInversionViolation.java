interface Device {
    void turnOn();
    void turnOff();
}

class LightBulb implements Device {
    @Override
    public void turnOn() {
        System.out.println("LightBulb is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("LightBulb is OFF");
    }
}

class Switch {
    private Device device;

    public Switch(Device device) {
        this.device = device;
    }

    public void turnOn() {
        device.turnOn();
    }

    public void turnOff() {
        device.turnOff();
    }
}

public class DependencyInversionSolved {
    public static void main(String[] args) {
        Device bulb = new LightBulb();
        Switch lightSwitch = new Switch(bulb);
        lightSwitch.turnOn();
    }
}
