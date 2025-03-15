package b_structure;

interface TV {
    void turnOn();

    void turnOff();

    void setChannel(int num);
}

class SonyTv implements TV {

    @Override
    public void turnOn() {
        System.out.println("SonyTv Turn On");
    }

    @Override
    public void turnOff() {
        System.out.println("SonyTv Turn Off");

    }

    @Override
    public void setChannel(int num) {
        System.out.println("SonyTv channel set to " + num);
    }
}

class SamsungTv implements TV {

    @Override
    public void turnOn() {
        System.out.println("SamsungTv Turn On");
    }

    @Override
    public void turnOff() {
        System.out.println("SamsungTv Turn Off");

    }

    @Override
    public void setChannel(int num) {
        System.out.println("SamsungTv channel set to " + num);
    }
}

//Abstraction - RemoteControl
abstract class RemoteControl {

    protected TV tv;

    RemoteControl(TV tv) {
        this.tv = tv;
    }

    abstract void turnOn();

    abstract void turnOff();

    abstract void setChannel(int num);
}

class UniversalRemote extends RemoteControl {

    UniversalRemote(TV tv) {
        super(tv);
    }

    @Override
    public void turnOn() {
        tv.turnOn();
    }

    @Override
    public void turnOff() {
        tv.turnOff();
    }

    @Override
    public void setChannel(int num) {
        tv.setChannel(num);
    }
}


/*Design Pattern of BRIDGE: Imagine a TV remote controlling different types of TVs (Samsung, Sony, etc.).
The remote (abstraction) should work with any TV (implementation) without modifying its core logic.*/
public class Bridge {

    public static void main(String[] args) {
        TV sonyTv = new SonyTv();
        RemoteControl remoteControl = new UniversalRemote(sonyTv);
        remoteControl.turnOn();
        remoteControl.turnOff();
        remoteControl.setChannel(499);

        TV samsungTv = new SamsungTv();
        remoteControl = new UniversalRemote(samsungTv);
        remoteControl.turnOn();
        remoteControl.turnOff();
        remoteControl.setChannel(499);
    }

}
