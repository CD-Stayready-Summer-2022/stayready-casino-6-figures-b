package com.stayready.cards;

public enum CardValue {

    TWO(2, "Two", 2), THREE(3,"Three", 3), FOUR(4,"Four", 4), FIVE(5,"Five", 5),
    SIX(6,"Six", 6), SEVEN(7,"Seven", 7), EIGHT(8,"Eight", 8), NINE(9,"Nine", 9),
    TEN(10,"Ten", 10), JACK(11,"Jack", 11),
    QUEEN(10,"Queen", 12), KING(10,"King", 13), ACE(11,"Ace", 14);

    public final Integer value;
    public final String name;
    public final Integer id;

    CardValue(Integer value, String name, Integer id){
        this.value = value;
        this.name = name;
        this.id = id;
    }


    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public Integer getId(){
        return id;
    }
}
