package JavaBasic.DesignPatterns.CommandPattern;

public class Radio implements ElectronicDevice{
    private int vol = 0;

    @Override
    public void on() {
        System.out.println("Radio is on ");
    }

    @Override
    public void off() {
        System.out.println("Radio is off ");
    }

    @Override
    public void volumeUp() {
        vol++;
        System.out.println("Radio volume is at " + vol);
    }

    @Override
    public void volumeDown() {
        vol--;
        System.out.println("Radio volume is at " + vol);
    }
}
