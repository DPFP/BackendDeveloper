package JavaBasic.DesignPatterns.CommandPattern;

public class TVRemote {

    public static ElectronicDevice getDevice(){
        return new Television();
    }
}
