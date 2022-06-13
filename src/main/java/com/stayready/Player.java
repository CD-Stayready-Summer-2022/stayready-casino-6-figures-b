package com.stayready;

import com.stayready.cards.Hand;

import java.util.Objects;

public class Player {
    private String name;
    protected Hand hand;
    private int countFour;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountFour() {
        return countFour;
    }

    public void setCountFour(int countFour) {
        this.countFour = countFour;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

