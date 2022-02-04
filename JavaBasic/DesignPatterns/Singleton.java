package DesignPatterns;

import javax.management.RuntimeErrorException;

public class Singleton {

    // private constructor --> so nobody can initial obj with this class via
    // construtor
    private Singleton() {
    }

    // private static final instance for the class
    private static final Singleton instance;

    static {
        try {
            instance = new Singleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception while creating singleton object" + e.getMessage());
        }
    }

    // public static method that returns the instance of the class
    public static Singleton getInstance() {
        return instance;
    }

    public void printMethod(String s) {
        System.out.println("Print method from singleton:" + s);
    }

}
