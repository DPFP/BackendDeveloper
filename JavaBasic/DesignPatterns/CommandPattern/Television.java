package JavaBasic.DesignPatterns.CommandPattern;

//Receiver
public class Television implements ElectronicDevice {
    private int vol = 0;

    @Override
    public void on() {
        System.out.println("TV is on ");
    }

    @Override
    public void off() {
        System.out.println("TV is off ");
    }

    @Override
    public void volumeUp() {
        vol++;
        System.out.println("volume is at " + vol);
    }

    @Override
    public void volumeDown() {
        vol--;
        System.out.println("volume is at " + vol);
    }
}
