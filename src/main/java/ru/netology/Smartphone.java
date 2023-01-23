package ru.netology;

public class Smartphone extends Product {
    String manufacture;

    public Smartphone(int id, String name, int price, String manufacture) {
        super(id, name, price);
        this.manufacture = manufacture;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (manufacture.contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
