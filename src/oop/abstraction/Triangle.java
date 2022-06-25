package oop.abstraction;

public class Triangle extends Shape {

    @Override
    public void draw() {
        System.out.println("I am drawing a triangle");
    }

    public void showScales() {
        System.out.printf("%d Scales", 34);
    }

    @Override
    public String verifyTemperature1(String animalWarmth) {
        return "";
    }

    @Override
    public String verifyTemperature2(String animalWarmth) {
        return "";
    }
}
