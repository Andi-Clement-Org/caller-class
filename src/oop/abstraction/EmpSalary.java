package oop.abstraction;

public class EmpSalary extends Employee {

    private double salary;

    public EmpSalary(String name, String address, int number, double salary) {
        super(name, address, number);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double computePay() {
        return salary / 52;
    }

    @Override
    public void checkMailBox() {
        System.out.println("\n\nInside the EmpSalary Class");
        System.out.printf("Emailing a check of %f to %s", salary, getName());
    }

    public void simpleProgram() {
        for (int i = 20; i > 0; i--) {
//            if (i < 2) continue;
//            if (i >= 12) continue;
            if (i < 2) break;
//            if (i > 16) break;
            System.out.printf("Count Number %d \n\n", i);
        }
    }

}
