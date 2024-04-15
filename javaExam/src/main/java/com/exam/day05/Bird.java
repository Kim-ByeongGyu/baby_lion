package com.exam.day05;

public class Bird extends Animal{

    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " 쨱쨱");
    }
}
