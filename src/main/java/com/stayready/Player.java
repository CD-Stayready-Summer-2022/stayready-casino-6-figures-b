package com.stayready;

public class Player {
    private String name;
    private Integer age;
    private Double money;
    protected Hand hand;

    public Player(String name, Integer age, Double money) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return name+" "+age+" "+money;
    }
}

