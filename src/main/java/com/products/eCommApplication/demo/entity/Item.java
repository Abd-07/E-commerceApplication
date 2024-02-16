package com.products.eCommApplication.demo.entity;

public class Item {
    private String name;
    private String color;
    private float price;
    private int size;
    private int quantity;

    public Item(String name, String color, float price, int size, int quantity) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
    }

    public void setName(String name) {this.name = name;}
    public void setColor(String color) {this.color = color;}
    public void setPrice(float price) {this.price = price;}
    public void setSize(int size) {this.size = size;}
    public void setQuantity(int quantity) {this.quantity = quantity;}


    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public float getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void itemName () {

        System.out.println("The item's name is: " + name);
    }
    public void itemColor () {
        System.out.println("The "+ name + "'s color is: " + color);
    }
    public void itemPrice () {

        System.out.println("The "+ name + "'s price is: " + price + " GBP");
    }
    public void itemSize () {

        System.out.println("The "+ name + "'s size is: " + size);
    }
    public void itemQuantity () {
        System.out.println("The "+ name + "'s quantity is: " + quantity);
    }
}
