package DesignPatterns;

import javax.management.RuntimeErrorException;

public class Singleton {

    // private constructor --> so nobody can initial obj with this class via
    // construtor
    private Singleton() {
    }

    // private static instance for the class
    private static Singleton instance;

    // public static method that returns the instance of the class
    public synchronized static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void printMethod(String s) {
        System.out.println("Print method from singleton:" + s);
    }

}
