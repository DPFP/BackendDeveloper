package JavaBasic.DesignPatterns.FactoryPattern;

import java.util.Scanner;

public class EnemyShipTesting {

    public static void main(String[] args) {
        EnemyShipFactory enemyShipFactory = new EnemyShipFactory();
        EnemyShip theEnemy = null;

        System.out.println("what type ? R U B");

        Scanner userInput = new Scanner(System.in);

        if(userInput.hasNext()){
            String typeOfShip = userInput.nextLine();

            theEnemy = enemyShipFactory.makeEnemyShip(typeOfShip);
        }
        if(theEnemy != null){
            doStuffEnemy(theEnemy);
        }else{
            throw new IllegalArgumentException("Enemy is null");
        }

    }

    private static void doStuffEnemy(EnemyShip enemyShip) {
        enemyShip.displayEnemyShip();
        enemyShip.followingHeroShip();
        enemyShip.enemyShipShoots();
    }
}
