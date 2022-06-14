package com.stayready.cards;

public enum CardValue {
    TWO(2, "Two"), THREE(3,"Three"), FOUR(4,"Four"), FIVE(5,"Five"),
    SIX(6,"Six"), SEVEN(7,"Seven"), EIGHT(8,"Eight"), NINE(9,"Nine"),
    TEN(10,"Ten"), JACK(10,"Jack"),
    QUEEN(10,"Queen"), KING(10,"King"), ACE(11,"Ace");

    public final Integer value;
    public final String name;

    CardValue(Integer value, String name){
        this.value = value;
        this.name = name;
    }


    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
