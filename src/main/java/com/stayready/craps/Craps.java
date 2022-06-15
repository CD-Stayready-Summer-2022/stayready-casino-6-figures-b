package com.stayready.craps;
import com.stayready.games.Game;

import java.util.Random;
import java.util.Scanner;

public class Craps implements Game {


    private Integer dice1;
    private Integer dice2;
    private Random random;
    private Random random2;
    private CrapsPlayer player;
    private Scanner Scanner;

   //Create a method for PlayerStakes that takes in the money waged by the Craps player

    //Dice implementing random number generator
    //role dice
    //if statements to set up situations

    public Craps() {
        this.dice1 = dice1;
        this.dice2 = dice2;
        RollDie();


    }
    @Override
    public void startGame() {
        System.out.println("Roll Dice");
        RollDie();

    }
    public Integer RollDie() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Random random2 = new Random();
        dice1 = random.nextInt(6) + 1;
        dice2 = random2.nextInt(6) + 1;
        Integer sum = dice1 + dice2;
        System.out.println(String.format("You rolled a %d and %d", dice1, dice2));
        System.out.println(String.format("Therefore you rolled %d", sum));

        if (sum == 2 || sum == 3 || sum == 2) {
            System.out.println("Sorry you lose!");

        }
        else if (sum == 7 || sum == 11)
            System.out.println("You WIN!!");
        else
            //if(sum == 4 || sum ==5 || sum ==6 || sum ==8 || sum ==9 || sum ==10){
            System.out.println(String.format("You rolled a %d so your point is: %d", sum, sum));
        System.out.println();

        // }
        Integer point = sum;
        //set up while loop for more rolls
        while (true) {
            System.out.println("Type any letter to roll again");
            String nextRoll = scanner.nextLine();
            dice1 = random.nextInt(6) + 1;
            dice2 = random2.nextInt(6) + 1;

            System.out.println("You rolled a " + dice1 + " and a " + dice2);
            point = dice1 + dice2;
            if (point == sum) {
                System.out.println("You Win!");
                break;
            }
            if (point == 7 || point == 11) {
                System.out.println("You Lose");
                break;
            }
            System.out.println("Game Over");

        }
        return null;
    }


}
