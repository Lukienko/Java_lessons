
package ru.geekbrains.guess_the_number;

import java.util.Scanner;

public class Main {
    private static Scanner scanner= new Scanner(System.in);

    private static int answersCount= 2;
    private static boolean restartGame=true;

    public static void main(String[] args) {

        while (restartGame) {
            int range = 9;
            int number=(int)(Math.random()*range);
            playLevel(range, number);
            reStartGame();
        }

    }
    private static void reStartGame() {
        String scannerText;
        if (restartGame) {
            System.out.println("Заново? Введите \"Да\", если хотите продолжить игру.");

            scannerText= scanner.next();

            if (scannerText.equals("Да")) {
                System.out.println("продолжаем..."); answersCount=3;
            } else {
                restartGame=false; scanner.close();
                System.out.println("Игра завершена!");
            }
        }
    }

    private static void playLevel(int range, int number) {
        System.out.println("Угадайте число от 0 до " + range + ". У вас на это " + (answersCount + 1) + "попытки ");
        while (true) {
            if (answersCount < 0) {
                System.out.println("Вы проиграли");
                break;
            }
            int input_number=scanner.nextInt();
            if (input_number==number) {
                System.out.println("Вы угадали");
                break;
            } else if (input_number>number) {
                System.out.println("Загаданное число меньше");
                System.out.println("Осталось попыток: " +  answersCount +  "." );
                answersCount--;
            } else {
                System.out.println("Загаданное число больше");
                System.out.println("Осталось попыток: " +  answersCount +  "." );
                answersCount--;
            }
        }

    }
}