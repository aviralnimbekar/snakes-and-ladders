package com.tech.model;

public class Player {

    private final String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int nextPosition) {
        position = position + nextPosition;
        System.out.println(name + " moves to :: " + position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
