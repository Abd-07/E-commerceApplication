package com.products.eCommApplication.demo.entity;

public class Order {
    private Status status;
    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void printStatus () {
        System.out.println("The item is: " + status);
    }

    public void printSeparator() {
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        Order order = new Order();

        System.out.println("ITEM:");
        Item item1 = new Item("Laptop", "red", 1500,20,4);
        item1.itemName();
        item1.itemQuantity();
        item1.itemSize();
        item1.itemColor();
        item1.itemPrice();
        order.printSeparator();

        System.out.println("PAYMENT:");
        Payment payment = new Payment("1234-5678-9012-3456", 123, "12/23", item1);
        payment.processingAndAuth();
        payment.paid();
        order.printSeparator();

        System.out.println("STATUS:");
        order.setStatus(Status.DISPATCHED);
        order.printStatus();
        order.printSeparator();
    }

}
