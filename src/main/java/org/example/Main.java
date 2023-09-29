package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Главный класс игры. Осуществляет запуск и управление игрой "VideoGame".
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в косольную игру \"VideoGame\"!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите действие:");
        while (true) {
            System.out.println("1. Начать игру");
            System.out.println("2. Выход");
            try {
                int num = sc.nextInt();
                switch (num) {
                    case 1 -> new Game().start();
                    case 2 -> {
                        System.out.println("До встречи!");
                        System.exit(0);
                    }
                    default -> System.out.println("Такого действия нет. Выберите верное дествие.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введите число \"1\" либо \"2\".");
                sc.next();
            }
        }
    }
}