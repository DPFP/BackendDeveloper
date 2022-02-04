package DesignPatterns;

public class Singleton {

    // private constructor --> so nobody can initial obj with this class via
    // construtor
    private Singleton() {

    }

    private static final Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    public void printMethod(String s) {
        System.out.println("Print method from singleton:" + s);
    }

    public static void main(String[] args) {
        Singleton.instance.printMethod("hello");

        Singleton single = Singleton.getInstance();
        single.printMethod("world");
    }
}
