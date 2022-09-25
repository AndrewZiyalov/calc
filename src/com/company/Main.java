package com.company;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    /**
     * @see #calc() метод для калькулятора
     * @see #maxWordInArray() метод для поиска самого длинного слова в массиве
     * @see #sum(float, float) метод для сложения
     * @see #minus(float, float) метод для вычитания
     * @see #multiply(float, float) метод для умножения
     * @see #div(float, float) метод для деления
     */
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите число из списка:\n 1: Калькулятор; \n 2: Поиск максимального элемента в массиве.");
            int a = 0;
            if (scanner.hasNextInt()) {
                a = scanner.nextInt();
                if (a == 1) {
                    calc();
                } else if (a == 2) {
                    maxWordInArray();
                }
            }
        }

    }

    public static void maxWordInArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длинну массива");
        if (scanner.hasNextInt()) {
            int size = scanner.nextInt();
            String[] dict = new String[size];
            int maxLength = -1;
            int maxCount = -1;
            for (int i = 0; i < dict.length; i++) {
                Scanner newWord = new Scanner(System.in);
                System.out.println("Введите слово №" + i);
                dict[i] = newWord.nextLine();
            }
            for (int i = 0; i < dict.length; i++) {
                if (maxLength < dict[i].length()) {
                    maxLength = dict[i].length();
                    maxCount = i;
                }
            }
            if (maxCount > -1) {
                System.out.println("Самое длинное слово в массиве: " + dict[maxCount] + " длинной " + maxLength);
            }
        }
    }

    public static void calc() {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([0-9]*[.,]?[0-9]+)[ ]*?([+\\-*/])[ ]*?([0-9]*[.,]?[0-9]+)");

        float a = 0;
        float b = 0;
        String sign;
        float result;


        System.out.println("Введите выражение типа А+B, A*B, A/B, A-B:");
        String ex = scanner.nextLine();

        Matcher matcher = pattern.matcher(ex);
        if (matcher.matches()) {
            try {
                a = Float.parseFloat(matcher.group(1).replace(',', '.'));
            } catch (NumberFormatException e) {
                System.err.println("Значение A не является числом");
            }
            try {
                b = Float.parseFloat(matcher.group(3).replace(',', '.'));
            } catch (NumberFormatException e) {
                System.err.println("Значение b не является числом");
            }
            sign = matcher.group(2);
            System.out.print(matcher.group(1) + matcher.group(2) + matcher.group(3) + "=");

            switch (sign) {
                case "+":
                    result = sum(a, b);
                    System.out.printf("%.4f\n", result);
                    break;
                case "-":
                    result = minus(a, b);
                    System.out.printf("%.4f\n", result);
                    break;
                case "/":
                    result = div(a, b);
                    System.out.printf("%.4f\n", result);
                    break;
                case "*":
                    result = multiply(a, b);
                    System.out.printf("%.4f\n", result);
                    break;
                default:
                    System.out.println("Неверный знак препинания");
                    break;
            }
        } else {
            System.err.println("Неверный формат выражения");
        }
    }

    /**
     * @param a первое число в выражении
     * @param b второе число в ывыражении
     * @return возвращает результат вычисления
     */
    public static float sum(float a, float b) {
        return a + b;
    }

    /**
     * @param a первое число в выражении
     * @param b второе число в ывыражении
     * @return возвращает результат вычисления
     */
    public static float minus(float a, float b) {
        return a - b;
    }

    /**
     * @param a первое число в выражении
     * @param b второе число в ывыражении
     * @return возвращает результат вычисления
     */
    public static float div(float a, float b) {
        float res = 0;
        try {
            res = a / b;
        } catch (ArithmeticException e) {
            System.err.println("Деление на ноль");
        }
        return res;
    }

    /**
     * @param a первое число в выражении
     * @param b второе число в ывыражении
     * @return возвращает результат вычисления
     */
    public static float multiply(float a, float b) {
        return a * b;
    }

}
