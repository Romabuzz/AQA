package org.example;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
    }

    // Массив до 5
    public static void task1() {
        int[] numbers = new int[7];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        System.out.println();
        for (int num : numbers) {
            System.out.println(num);
            if (num == 5) {
                break;
            }
        }
    }

    // 10 значений
    public static void task2() {
        String[] stringArray = {
                "Колбаса", "Сыр", "Сосиски", "Сухарики", "Помидоры",
                "Огурцы", "Капуста", "Сельдерей", "Редис", "Картошка"
        };

        System.out.println();
        for (String str : stringArray) {
            System.out.println(str);
        }
    }
}

