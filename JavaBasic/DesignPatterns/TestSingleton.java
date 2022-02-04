package DesignPatterns;

public class TestSingleton {
    public static void main(String[] args) {
        // Singleton.instance.printMethod("hello");

        Singleton single = Singleton.getInstance();
        single.printMethod("world");
    }
}
