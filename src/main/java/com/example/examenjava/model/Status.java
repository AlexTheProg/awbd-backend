package com.example.examenjava.model;

public enum Status {
    NEW("NEW"),
    PROCESSED("PROCESSED"),
    CANCELLED("CANCELLED");

    private final String name;

     Status(String s){
        name = s;
    }

    public boolean equalsName(String otherName){
         return name.equals(otherName);
    }

    public String toString(){
         return this.name;
    }

}
