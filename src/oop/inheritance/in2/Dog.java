package oop.inheritance.in2;

public class Dog extends Animal {

    public void display() {
        super.eat();
        System.out.println("My name is " + name);
    }

    @Override
    public void eat() {
        System.out.println(name + " can eat a lot...");
    }

    public void bark() {
        System.out.println(name + " is barking...");
    }

    public void setMyName(String name) {
        this.name = name;
    }

}
