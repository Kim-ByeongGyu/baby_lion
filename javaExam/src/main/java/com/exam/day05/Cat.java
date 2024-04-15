package com.exam.day05;

public class Cat extends Animal{

    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " 야옹야옹");
    }
}
