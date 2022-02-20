package JavaBasic.DesignPatterns.FactoryPattern;

import java.util.Scanner;

public class EnemyShipTesting {

    public static void main(String[] args) {
        EnemyShip theEnemy = null;

        Scanner userInput = new Scanner(System.in);

        String enemyShipOption = "";

        System.out.println("What type of ship ? (U / R) ");

        if(userInput.hasNext()){
            enemyShipOption = userInput.nextLine();
        }

        if(enemyShipOption.equals("U")){
            theEnemy = new UFOEnemyShip();
        }else if(enemyShipOption.equals("R")){
            theEnemy = new RocketEnemyShip();
        }

        doStuffEnemy(theEnemy);
    }

    private static void doStuffEnemy(EnemyShip enemyShip) {
        enemyShip.displayEnemyShip();
        enemyShip.followingHeroShip();
        enemyShip.enemyShipShoots();
    }
}
