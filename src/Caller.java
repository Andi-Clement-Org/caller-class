import oop.abstraction.*;
import oop.encapsulation.Supplier;
import oop.inheritance.in2.Animal;
import oop.inheritance.in2.Dog;
import oop.inheritance.in2.Horse;
import oop.recursion.Base;
import oop.recursion.Factorial;

import java.util.Arrays;
import java.util.Scanner;

public class Caller {

    public static void main(String[] args) {
//        Supplier nSupplier = new Supplier();
//        nSupplier.show();

        Caller nCaller = new Caller();
        nCaller.horseCaller();
    }

    public void abstractCaller02() {
        Shape triangle = new Triangle();
        triangle.draw();
        triangle.showScales();

        System.out.println("\n\n\n\n");

        Shape rectangle = new Rectangle();
        rectangle.draw();
        rectangle.showScales();

        System.out.println("\n\n\n\n");
        System.out.printf("Temp 1: \t\tThis is a %s", rectangle.verifyTemperature1("nothingness"));
        System.out.println("\n\n\n\n");
        System.out.printf("Temp 2: \t\tThis is a %s", rectangle.verifyTemperature2("nothingness"));
    }

    public void abstractCaller01() {
        EmpSalary emp = new EmpSalary("John", "Lives in Wick Estate", 41, 510000.00);
        System.out.printf("%s earned %f weekly", emp.getName(), emp.computePay());
        emp.checkMailBox();
    }

    public void palindromeCaller() {
        try {
            System.out.println("Please Enter a text to check if it is a palindrome");
            Scanner reader = new Scanner(System.in);
            String text = reader.nextLine();
            boolean isPalindrome = Base.isPalindrome(text);
            System.out.printf("Is this a Palindrome?: %s", isPalindrome);
        }
        catch (Exception ex) {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
    }

    public void factorialCaller() {
        Factorial.findFactorial();
        System.out.println(Factorial.findFactorial(5));
    }

    public void dogCaller() {
        Animal dog = new Dog();
        dog.eat();

        Dog dog1 = new Dog();
        dog1.setMyName("Bruno");
//        dog1.name = "Bruno";
        dog1.display();
        dog1.bark();

        Dog dog2 = new Dog();
        dog2.setMyName("Chukwudi");
//        dog2.name = "Chukwudi";
        dog2.display();
        dog2.eat();
    }

    public void horseCaller() {
        Animal horse = new Horse();
        horse.eat();
    }

}
