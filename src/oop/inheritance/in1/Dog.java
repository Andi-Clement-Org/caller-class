package oop.inheritance.in1;

public class Dog extends Animal {

    public Dog() {
        this.setEyes(3);
        this.setHinds(8);
        this.setType("Dog");
        this.setName("Bruno");
    }

    public void browseDog() {
        System.out.println("Hi, My name is " + this.getName() + " and I am a " + this.getType() + ".\nI have " + this.getEyes() + " eyes");
    }

}
