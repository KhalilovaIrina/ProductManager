package ru.netology;

public class Smartphone extends Product {
    String manufacture;

    public Smartphone(int id, String name, int price, String manufacture) {
        super(id, name, price);
        this.manufacture = manufacture;
    }
}
