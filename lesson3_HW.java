package lesson3;

import java.util.Random;
import java.util.Scanner;

public class lesson3_HW {
    static Scanner sc = new Scanner(System.in);

    static String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                             "avocado", "broccoli", "carrot", "cherry", "garlic",
                             "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                             "nut", "olive", "pea", "peanut", "pear", "pepper",
                             "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
            startProgram();
    }

    public static void startProgram(){
        boolean flagExit = true;

        while (flagExit){
            int hiddenWords = guessingWord();
            char[] answer = {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'};
            boolean flagWord = true;

            while(flagWord){
                System.out.println("Попробуйте угадать слово!");
                System.out.println("Ответ: " + String.valueOf(answer));
                printMenu();

                switch (sc.next()) {
                    case "1" -> flagWord = checkAnswer(hiddenWords, answer);
                    case "2" -> flagWord = fail(hiddenWords);
                    case "0" -> flagExit = flagWord = false;
                    default -> System.out.printf("Некорректный ввод%n%n%n");
                }
            }
        }
    }

    public static int guessingWord(){
        return new Random().nextInt(words.length);
    }

    private static void printMenu() {
        System.out.printf("1. Отгадать слово%n");
        System.out.printf("2. Сдаться, узнать слово%n");
        System.out.printf("0. Выход из программы%n");
        System.out.print("Выбор: ");
    }

    // Ввод ответа и его проверка
    // Если ответ правильный, то поздравляем игрока и предлагаем угадать новове слово
    private static boolean checkAnswer(int indexAnswer, char[] answer) {
        System.out.print("Введите Ваш ответ: ");
        String userAnswer = sc.next();
        boolean flag = comparisonAnswers(indexAnswer, answer, userAnswer);

        if(flag){
            System.out.printf("Вы угадали!%nПопробуйте отгадать новое слово%n%n%n");
        } else {
            System.out.printf("Введенное слово неправильное%n%n%n");
        }

        // Возвращаем отрицание для того, чтобы цикл для одного слово продолжил выполняться
        // так как flag = false, если введенное слово неправильное, а цикл работает когда flag = true
        return !flag;
    }

    private static boolean comparisonAnswers(int indexAnswer, char[] answer, String userAnswer) {
        // Изначально будем считать, что слова совпадают
        boolean flag = true;
        int length = userAnswer.length();

        // Узнаем, какой ответ короче, и в цикле проходимся по меньшей длине
        // при этом мы узнаем, что слова не совпадают по длине
        if(userAnswer.length() > words[indexAnswer].length()){
            length = words[indexAnswer].length();
            flag = false;
        } else if (userAnswer.length() < words[indexAnswer].length()){
            flag = false;
        }

        // Пробигаемя по всему ответу игрока
        for (int i = 0; i < length; i++) {
            // Если символы равны, то заменяем соответсвующий символ в слове, которое выводится как подсказка игроку
            // если символы не равны, значит слова не совпадают
            if(userAnswer.charAt(i) == words[indexAnswer].charAt(i)){
                answer[i] = userAnswer.charAt(i);
            } else {
                flag = false;
            }
        }

        return flag;
    }

    private static boolean fail(int hiddenWords) {
        System.out.printf("Загаданное слово: %s%nПопробуйте угадать новое слово%n%n%n",words[hiddenWords]);
        return false;
    }
}