package oop.inheritance.in1;

public class Animal {
    private int eyes;
    private int hinds;
    private String name;
    private String type;

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }

    protected int getEyes() {
        return eyes;
    }

    protected void setEyes(int eyes) {
        this.eyes = eyes;
    }

    protected int getHinds() {
        return hinds;
    }

    protected void setHinds(int hinds) {
        this.hinds = hinds;
    }
}
