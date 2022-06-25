package oop.abstraction;

public class Rectangle extends Shape {

    @Override
    public void draw() {
        System.out.println("I am drawing a rectangle");
    }

    @Override
    public void showScales() { }

    @Override
    public String verifyTemperature1(String animalWarmth)
    {
        if (animalWarmth.equalsIgnoreCase("coldblooded")) {
            return "Reptile";
        }
        else if (animalWarmth.equalsIgnoreCase("warmblooded")) {
            return "Mammal";
        }
        else {
            return "Could not process temperature";
        }
    }

    @Override
    public String verifyTemperature2(String animalWarmth)
    {
        if (animalWarmth.equalsIgnoreCase("coldblooded")) {
            return "Reptile";
        }
        if (animalWarmth.equalsIgnoreCase("warmblooded")) {
            return "Mammal";
        }
        return "Could not process temperature";
    }

}
