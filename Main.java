package lesson6_HW;

import java.util.Scanner;

public class Main {

    public static final int COUNT_CATS = 2;
    public static final int COUNT_DOGS = 3;
    public static final int COUNT_ANIMALS = COUNT_CATS + COUNT_DOGS;
    public static final int MAX_AGE = 30;   // Будем считать, что коты и собаки не живут более 30 лет


    public static Scanner sc = new Scanner(System.in);
    private static final Animal[] animals = new Animal[COUNT_ANIMALS];

    public static void main(String[] args) {

        startProgram();

    }

    private static void startProgram() {

        enterAnimalsData();

        boolean flag = true;
        while(flag){
            printMenu();

            switch (sc.next()) {
                case "1" -> printInfo();
                case "2" -> runningCheck();
                case "3" -> jumpCheck();
                case "4" -> swimmingCheck();
                case "0" -> flag = false;
                default -> System.out.println("Некорректная команда!");
            }
        }
    }

    private static void enterAnimalsData() {

        enterCatsData();
        enterDogsData();

    }

    private static void enterCatsData() {
        for (int i = 0; i < COUNT_CATS; i++) {
            System.out.println("Введите данные о " + (i + 1) + " коте");
            animals[i] = new Cat(enterName(), enterColor(), enterAge());

            System.out.println("Ввести уникальные ограничения? y/n");
            String answer = sc.next();
            if(answer.equals("y")){
                enterUniqueRestrictions(i);
            }
        }
    }

    private static String enterName() {
        System.out.print("Введите имя: ");
        return sc.next();
    }

    private static String enterColor() {
        System.out.print("Введите цвет: ");
        return sc.next();
    }

    private static int enterAge() {
        int age;

        do{
            System.out.print("Введите возраст: ");
            age = sc.nextInt();
        }while(!isAgeValid(age));

        return age;
    }

    private static boolean isAgeValid(int age) {
        return age > 0 && age <= MAX_AGE;
    }

    private static void enterUniqueRestrictions(int i) {
        enterDistanceRunning(i);
        enterJumpHeight(i);

        if(!(animals[i] instanceof Cat)){
            enterDistanceSwimming(i);
        }
    }

    private static void enterDistanceRunning(int i) {
        System.out.println("Ввести дистанцию бега? y/n");
        String answer = sc.next();
        if(answer.equals("y")){
            int distance;

            do{
                System.out.print("Введите дистанцию бега(м): ");
                distance = sc.nextInt();
            } while(distance <= 0);

            animals[i].setDistanceRunning(distance);
        }
    }

    private static void enterJumpHeight(int i) {
        System.out.println("Ввести высоту прыжка? y/n");
        String answer = sc.next();
        if(answer.equals("y")){
            double height;

            do{
                System.out.print("Введите высоту прыжка(м): ");
                height = sc.nextDouble();
            } while(height <= 0.0);

            animals[i].setJumpHeight(height);
        }
    }

    private static void enterDistanceSwimming(int i) {
        System.out.println("Ввести дистанцию плавания? y/n");
        String answer = sc.next();
        if(answer.equals("y")){
            int distance;

            do{
                System.out.print("Введите дистанцию плавания(м): ");
                distance = sc.nextInt();
            } while(distance <= 0);

            animals[i].setDistanceSwimming(distance);
        }
    }

    private static void enterDogsData() {
        for (int i = COUNT_CATS; i < COUNT_ANIMALS; i++) {
            System.out.println("Введите данные о " + (i + 1 - COUNT_CATS) + " собаке");
            animals[i] = new Dog(enterName(), enterColor(), enterAge());

            System.out.println("Ввести уникальные ограничения? y/n");
            String answer = sc.next();
            if(answer.equals("y")){
                enterUniqueRestrictions(i);
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n\nВыберите действие");
        System.out.println("1. Вывести данные о животных");
        System.out.println("2. Задать дистанцию бега");
        System.out.println("3. Задать высоту прыжка");
        System.out.println("4. Задать дистанцию заплыва");
        System.out.println("0. Выход");
    }

    private static void printInfo() {
        for (int i = 0; i < COUNT_ANIMALS; i++) {
            if(animals[i] instanceof Cat){
                System.out.print("Кот - ");
            } else if(animals[i] instanceof Dog){
                System.out.print("Собака - ");
            }
            System.out.println(animals[i]);
        }
        System.out.println();
        System.out.println();
    }

    private static void runningCheck() {
        System.out.print("Введите дистанцию: ");
        int distance = sc.nextInt();

        for (int i = 0; i < COUNT_ANIMALS; i++) {
            animals[i].run(distance);
        }
    }

    private static void jumpCheck() {
        System.out.print("Введите высоту: ");
        double height = sc.nextDouble();

        for (int i = 0; i < COUNT_ANIMALS; i++) {
           animals[i].jump(height);
        }
    }

    private static void swimmingCheck() {
        System.out.print("Введите дистанцию: ");
        int distance = sc.nextInt();

        for (int i = 0; i < COUNT_ANIMALS; i++) {
            animals[i].swim(distance);
        }
    }
}
