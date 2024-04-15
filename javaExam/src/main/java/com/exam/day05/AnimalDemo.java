package com.exam.day05;

public class AnimalDemo {
    public static void main(String[] args) {
        Animal bird = new Bird("짹짹이");
        bird.makeSound();

        Animal cat = new Cat("야옹이");
        cat.makeSound();
    }
}
