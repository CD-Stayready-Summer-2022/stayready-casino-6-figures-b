package com.stayready;

import com.stayready.cards.Hand;

import java.util.Objects;

public class Player {
    private String name;
    private Integer age;
    private Double money;

    protected Hand hand;

    private Integer bookNum = 0;

    public Player(String name, Integer age, Double money) {
        this.name = name;
        this.age = age;
        this.money = money;
        hand = new Hand();
    }

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    public Hand getHand(){
        return hand;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money){
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
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

