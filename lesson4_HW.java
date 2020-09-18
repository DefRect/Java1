package lesson4;

import java.util.Random;
import java.util.Scanner;

public class lesson4_HW {

    private static final int SIZE = 5;
    private static final int DOTS_TO_WIN = 3;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char EMPTY = ' ';

    private static Scanner sc = new Scanner(System.in);
    private static char[][] map = new char[SIZE][SIZE];
    private static int countEmptyDots = SIZE * SIZE;

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        initMap();
        printMap();

        while(true){
            humanTurn();
            printMap();
            if(isWin(DOT_HUMAN)){
                System.out.println("Вы победили!");
                break;
            }
            if(isDraw()){
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            printMap();
            if(isWin(DOT_AI)){
                System.out.println("Победил компьютер!");
                break;
            }
            if(isDraw()){
                System.out.println("Ничья!");
                break;
            }
        }
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeader();
        printRow();
    }

    private static void printHeader() {
        System.out.print("♫ ");
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%d%c", i + 1, EMPTY);
        }
        System.out.println();
    }

    private static void printRow() {
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%d%c", (i + 1), EMPTY);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%c%c", map[i][j], EMPTY);
            }
            System.out.println();
        }
    }

    private static void humanTurn() {
        int x, y;
        do{
            System.out.println("Введите координаты для постановки фишки");
            System.out.print("Строка: ");
            x = sc.nextInt() - 1;
            System.out.print("Столбец: ");
            y = sc.nextInt() - 1;
        }while (!isCellValid(x, y));

        map[x][y] = DOT_HUMAN;
    }

    private static boolean isCellValid(int x, int y, boolean isAI) {
        if((x < 0) || (x >= SIZE) || (y < 0) || (y >= SIZE)) {
            if(!isAI)
                System.out.println("Введенные координаты некорректны! Повторите ввод!");
            return false;
        }

        if(map[x][y] != DOT_EMPTY){
            if(!isAI)
                System.out.println("Указанная ячейка занята! Попробуйте указать другую!");
            return false;
        }

        return true;
    }

    private static boolean isCellValid(int x, int y) {
        return isCellValid(x, y, false);
    }

    private static boolean isDraw() {
        return --countEmptyDots == 0;
    }

    private static boolean isWin(char symbol) {
        if(isWinRow(symbol))
            return true;

        if(isWinColumn(symbol))
            return true;

        return isWinDiagonal(symbol);
    }

    private static boolean isWinRow(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            for (int j = 0; j < SIZE; j++) {
                count = (map[i][j] == symbol) ? count + 1 : 0;
                if(count == DOTS_TO_WIN)
                    return true;
            }
        }

        return false;
    }

    private static boolean isWinColumn(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            for (int j = 0; j < SIZE; j++) {
                count = (map[j][i] == symbol) ? count + 1 : 0;
                if(count == DOTS_TO_WIN)
                    return true;
            }
        }

        return false;
    }

    private static boolean isWinDiagonal(char symbol) {

        if(isMainDiagonal(symbol)){
            return true;
        }

        if(isDiagonalParallelMain(symbol)){
            return true;
        }

        if(isSideDiagonal(symbol)){
            return true;
        }

        return isDiagonalParallelSide(symbol);

    }

    private static boolean isMainDiagonal(char symbol) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            count = (map[i][i] == symbol) ? count + 1 : 0;
            if(count == DOTS_TO_WIN)
                return true;
        }

        return false;
    }

    private static boolean isDiagonalParallelMain(char symbol) {
        if(isDiagonalBelowMain(symbol)){
            return true;
        }

        return isDiagonalHigherMain(symbol);
    }

    private static boolean isDiagonalBelowMain(char symbol) {
        for (int i = 1; i < SIZE - DOTS_TO_WIN + 1; i++) {
            int count = 0;
            for (int j = i; j < SIZE; j++) {
                count = (map[j][j - i] == symbol) ? count + 1 : 0;
                if(count == DOTS_TO_WIN)
                    return true;
            }
        }

        return false;
    }

    private static boolean isDiagonalHigherMain(char symbol) {
        for (int i = 1; i < SIZE - DOTS_TO_WIN + 1; i++) {
            int count = 0;
            for (int j = 0; j < SIZE - i; j++) {
                count = (map[j][j + i] == symbol) ? count + 1 : 0;
                if(count == DOTS_TO_WIN)
                    return true;
            }
        }

        return false;
    }

    private static boolean isSideDiagonal(char symbol) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            count = (map[i][SIZE - 1 - i] == symbol) ? count + 1 : 0;
            if(count == DOTS_TO_WIN)
                return true;
        }

        return false;
    }

    private static boolean isDiagonalParallelSide(char symbol) {
        if(isDiagonalBelowSide(symbol)){
            return true;
        }

        return isDiagonalHigherSide(symbol);
    }

    private static boolean isDiagonalBelowSide(char symbol) {
        for (int i = 1; i < SIZE - DOTS_TO_WIN + 1; i++) {
            int count = 0;
            for (int j = i; j < SIZE; j++) {
                count = (map[j][SIZE - 1 - j + i] == symbol) ? count + 1 : 0;
                if(count == DOTS_TO_WIN)
                    return true;
            }
        }

        return false;
    }

    private static boolean isDiagonalHigherSide(char symbol) {
        for (int i = 1; i < SIZE - DOTS_TO_WIN + 1; i++) {
            int count = 0;
            for (int j = 0; j < SIZE - i; j++) {
                count = (map[j][SIZE - 1 - j - i] == symbol) ? count + 1 : 0;
                if(count == DOTS_TO_WIN)
                    return true;
            }
        }

        return false;
    }

    private static void aiTurn() {
        if(!isAiWin()){             //Может ли компьютер выиграть на текущем ходе
            if(!isAiBlock()) {      //Нужно ли блокировать ход человека, чтобы он не выиграл
                int x, y;
                Random random = new Random();
                do {
                    x = random.nextInt(SIZE);
                    y = random.nextInt(SIZE);
                } while (!isCellValid(x, y, true));

                map[x][y] = DOT_AI;
            }
        }
    }

    private static boolean isAiWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(isCellValid(i, j, true)) {
                    map[i][j] = DOT_AI;
                    if (isWin(DOT_AI)) {
                        return true;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }

        return false;
    }

    private static boolean isAiBlock() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(isCellValid(i, j, true)) {
                    map[i][j] = DOT_HUMAN;
                    if (isWin(DOT_HUMAN)) {
                        map[i][j] = DOT_AI;
                        return true;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }

        return false;
    }

}
