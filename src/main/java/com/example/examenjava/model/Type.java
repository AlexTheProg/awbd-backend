package com.example.examenjava.model;

public enum Type {
    ONLINE("ONLINE"),
    POS("POS");

    private final String name;

    Type(String s){
        name = s;
    }

    public boolean equalsName(String otherName){
        return name.equals(otherName);
    }

    public String toString(){
        return this.name;
    }
}
