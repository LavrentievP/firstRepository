package com.lvlev.oop.lesson2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();

        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат ввода. Пожалуйста, введите выражение в формате 'a [операция] b'.");
        }

        int a = parseInt(parts[0]);
        String operator = parts[1];
        int b = parseInt(parts[2]);

        int result;
        switch (operator) {
            case "+":
                result = a + b;
                System.out.printf("%d + %d = %d\n", a, b, result);
                break;
            case "-":
                result = a - b;
                System.out.printf("%d - %d = %d\n", a, b, result);
                break;
            case "*":
                result = a * b;
                System.out.printf("%d * %d = %d\n", a, b, result);
                break;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Ошибка: деление на ноль");
                }
                result = a / b;
                System.out.printf("%d / %d = %d\n", a, b, result);
                break;
            default:
                throw new IllegalArgumentException("Неверный оператор. Пожалуйста, используйте +, -, *, /.");
        }
    }

    private static int parseInt(String input) {
        int value = Integer.parseInt(input);
        if (value < 1 || value > 10) {
            throw new IllegalArgumentException("Число должно быть от 1 до 10 включительно");
        }
        return value;
    }
}