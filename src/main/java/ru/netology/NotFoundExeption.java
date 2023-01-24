package ru.netology;

public class NotFoundExeption extends RuntimeException {
    public NotFoundExeption(String msg){
        super(msg);
    }
}
