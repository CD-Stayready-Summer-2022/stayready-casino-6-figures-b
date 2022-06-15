package com.stayready.games;

import com.stayready.craps.Craps;

public class CrapsGame implements Game {





    @Override
    public void startGame() {
        System.out.println("Roll the dice!");
        new Craps();


    }

}
