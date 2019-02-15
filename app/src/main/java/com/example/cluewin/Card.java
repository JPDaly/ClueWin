package com.example.cluewin;

public class Card {

    public static final int PERSON = 0;
    public static final int WEAPON = 1;
    public static final int ROOM = 2;

    private int type;
    private String name;
    private int id;
    public boolean selected;

    public Card(int type, String name, int id) {
        this.type = type;
        this.name = name;
        this.id = id;
        this.selected = false;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
