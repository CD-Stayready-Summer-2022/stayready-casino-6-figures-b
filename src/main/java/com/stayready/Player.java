package com.stayready;

import com.stayready.cards.Hand;

import java.util.Objects;

public class Player {
    private String name;
<<<<<<< HEAD
    private Integer age;
    private Double money;
=======
>>>>>>> Renato
    protected Hand hand;

    public Player(String name) {
        this.name = name;
        this.age = age;
        this.money = money;
        hand = new Hand();
    }

    public Hand getHand(){
        return hand;

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

