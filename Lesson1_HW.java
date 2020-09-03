package lesson1;

public class Lesson1_HW {

    //Задание №1
    public static void main(String[] args) {
        System.out.println("Задание №2");
        variables();

        //Так как тип задания переменных не указан, задаём их константно в самой программе
        System.out.println("\nЗадание №3");
        System.out.println("Значение выражения a * (b + (c / d)) для long: " + calculationExpression(2, 100, -84, 42));
        System.out.println("Значение выражения a * (b + (c / d)) для double: " + calculationExpression(25.45, 0.452, -4.54201, 85.45));

        System.out.println("\nЗадание №4");
        int a = 34;
        int b = -20;
        if(isAmountIncluded(a, b))
            System.out.printf("Сумма чисел %d и %d лежит в пределах от 10 до 20 включительно%n", a, b);
        else
            System.out.printf("Сумма чисел %d и %d не лежит в пределах от 10 до 20 включительно%n", a, b);

        System.out.println("\nЗадание №5");
        numberPositive(-0.123456789);

        System.out.println("\nЗадание №6");
        double number = 0;
        if(isNumberNegative(number))
            System.out.printf("%f - отрицательное число%n", number);
        else
            System.out.printf("%f - положительное число%n", number);

        System.out.println("\nЗадание №7");
        helloName("Nikita");

        System.out.println("\nЗадание №8");
        leapYear(2020);
    }

    //Задание №2
    public static void variables(){

        //Целочисленные
        byte valueByte = 1;
        short valueShort = -300;
        int valueInt = 2000000000;
        long valueLong = 999999999999L;

        //Вещественные
        float valueFloat = 1.9f;
        double valueDouble = -20.005;

        //Символьные
        char valueChar = 'y';
        String valueString = "Hello, World!";

        System.out.println("Целочисленные переменные");
        System.out.println("Переменная типа byte: " +  valueByte);
        System.out.println("Переменная типа short: " +  valueShort);
        System.out.println("Переменная типа int: " +  valueInt);
        System.out.println("Переменная типа long: " +  valueLong);

        System.out.println("\nВещественные переменные");
        System.out.println("Переменная типа float: " +  valueFloat);
        System.out.println("Переменная типа double: " +  valueDouble);

        System.out.println("\nСимвольные переменные");
        System.out.println("Переменная типа char: " +  valueChar);
        System.out.println("Переменная типа String: " +  valueString);

    }

    //Задание №3
    // Не сказанно для каких типов, реализовано для long и double, так как на лекции проскользнуло, вроде бы, для разных
    //Для типа long
    public static long calculationExpression(long a, long b, long c, long d){
        return a * (b + (c / d));
    }

    //Для типа double
    public static double calculationExpression(double a, double b, double c, double d){
        return a * (b + (c / d));
    }

    //Задание №4
    public static boolean isAmountIncluded(int a, int b){
        return (a + b) >=10 && (a + b) <= 20;
    }

    //Задание №5
    public static void numberPositive(double number) {
        if(number >= 0)
            System.out.printf("%f - положительное число%n", number);
        else
            System.out.printf("%f - отрицательное число%n", number);
    }

    //Задание №6
    public static boolean isNumberNegative(double number) {
        return number < 0;
    }

    //Задание №7
    public static void helloName(String name){
        System.out.printf("Привет, %s%n", name);
    }

    //Задание №8
    public static void leapYear(int year){
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
            System.out.printf("Год %d високосный%n", year);
        else
            System.out.printf("Год %d не високосный%n", year);
    }
}
