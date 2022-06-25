package oop.encapsulation;

public class Supplier {

    private Integer supplierIndex = 78;
    private String supplierName;
    private String supplierAddress;

    public Supplier() {}

    public Supplier(Integer supplierIndex) {
        this.supplierIndex = supplierIndex;
    }

    public void show() {
        System.out.printf("This is the Index: %d", this.supplierIndex);
    }
}
