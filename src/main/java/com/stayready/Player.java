package com.stayready;

import java.util.Objects;

public class Player {
    private String name;
    private Integer age;
    private Double money;
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

