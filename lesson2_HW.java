public class lesson2_HW {
    final static int SIZE_ARRAY_FOR_TASK_4 = 9;
    final static int[] ARRAY_FOR_TASK_6 = new int[] {20, 2, 2, 1, 2, 2, 10, 1};
    final static int[] ARRAY_FOR_TASK_7 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    final static int SHIFT = -88;

    public static void main(String[] args) {
        System.out.println("Задание №1");
        firstTask();
        System.out.printf("%n%n");

        System.out.println("Задание №2");
        secondTask();
        System.out.printf("%n%n");

        System.out.println("Задание №3");
        thirdTask();
        System.out.printf("%n%n");

        System.out.println("Задание №4");
        fourthTask();
        System.out.printf("%n%n");

        System.out.println("Задание №5");
        fifthTask();
        System.out.printf("%n%n");

        System.out.println("Задание №6");
        if(sixthTask(ARRAY_FOR_TASK_6)) {
            System.out.print("Нужное место есть");
        } else{
            System.out.print("Нужного места нет");
        }
        System.out.printf("%n%n");

        System.out.println("Задание №7");
        seventhTask(ARRAY_FOR_TASK_7, SHIFT);
        System.out.printf("%n%n");
    }

    // Задание №1
    public static void firstTask() {
        int[] array = {0, 1, 1, 1, 0, 1, 0, 0};

        // В первом цикле выводим исходные значения элементов, а потом сразу меняем их
        System.out.print("Исходный массив:");
        for (int i = 0; i < array.length; i++){
            System.out.printf(" %d", array[i]);
            array[i] = (array[i] == 0) ? 1 : 0;
        }

        System.out.printf("%n");    // Для вывода итогового массива на новой строке

        System.out.print("Итоговый массив:");
        for (int element : array) {
            System.out.printf(" %d", element);
        }
    }

    // Задание №2
    public static void secondTask(){
        int[] array = new int[8];

        System.out.print("Полученный массив:");
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
            System.out.printf(" %d", array[i]);
        }
    }

    // Задание №3
    public static void thirdTask(){
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        // В первом цикле выводим исходные значения элементов и при необходимости меняем их
        System.out.print("Исходный массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.printf(" %2d", array[i]);
            if(array[i] < 6){
                array[i] *= 2;
            }
        }

        System.out.printf("%n");
        System.out.print("Итоговый массив:");
        for (int element : array) {
            System.out.printf(" %2d", element);
        }
    }

    // Задание №4
    public static void fourthTask(){
        int[][] array = new int[SIZE_ARRAY_FOR_TASK_4][SIZE_ARRAY_FOR_TASK_4];

        // Присваивание '1' элементам главной и побочной диагоналей
        for (int i = 0; i < SIZE_ARRAY_FOR_TASK_4; i++) {
            array[i][i] = 1;
            array[i][SIZE_ARRAY_FOR_TASK_4 - 1 - i] = 1;
        }

        // Вывод квадратной матрицы
        System.out.printf("Полученная квадратная матрица %dx%d%n", SIZE_ARRAY_FOR_TASK_4, SIZE_ARRAY_FOR_TASK_4);
        for (int[] i : array) {
            for (int j : i) {
                System.out.printf("%d ", j);
            }
            System.out.printf("%n");
        }
    }

    // Задание №5
    public static void fifthTask(){
        int[] array = {1, 5, 3, -2, 11, 4, 5, -10, 0, 8, 9, 11};

        // Изначально будем считать, что элемент массива с индексом 0 max и min
        int max = array[0];
        int min = array[0];
        int indexMax = 0;
        int indexMin = 0;

        // Проверяем оставшиеся элементы на max и min
        // В выводе уже присутствует первый элемент массива, так как дальнейшая проверка на нахождения max и min
        // начнется со второго элемента
        // Если будет несколько максимальных/минимальных элементов, то в качестве ответа будет представлен элемент,
        // который первый встретился
        System.out.printf("Массив: %d", array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.printf(" %d", array[i]);
            if(array[i] > max) {
                max = array[i];
                indexMax = i;
            } else if(array[i] < min){
                min = array[i];
                indexMin = i;
            }
        }

        System.out.printf("%n");
        System.out.printf("Максимальный элемент находится под индексом %d и равен %d%n", indexMax, max);
        System.out.printf("Минимальный элемент находится под индексом %d и равен %d%n", indexMin, min);
    }

    // Задание №6
    public static boolean sixthTask(int[] array){
        boolean flag = false;   // Флаг для возврата значения из функции
        int right = 0;
        int left = 0;

        // Суммируем все элементы и записываем в правую часть
        for (int element : array) {
            right += element;
        }

        int i = 0;
        // Сравниваем суммы левой и правой частей
        // Если суммы равны, меняем flag на true, тем саммы цикл закончится и вернется true
        // Если суммы не равны, то вычитаем очередной элемент из правой части и добавляем его в левую
        // Повторяем сравнение, пока не найдем нужное место или элементы не закончатся
        while(!flag && (i < array.length)){
            if(left == right){
                flag = true;
            } else{
                right -= array[i];
                left += array[i];
                i++;
            }
        }

        return flag;
    }

    // Задание №7
    public static void seventhTask(int[] array, int n){

        System.out.print("Исходный массив:");
        for (int element : array) {
            System.out.printf(" %2d", element);
        }

        // Любой сдвиг больше длины массива можно оптимизировать до меньшего сдвига через деление по модулю
        n %= array.length;

        if(n > 0){
            for (int i = 0; i < n; i++) {
                int buffer = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = buffer;
            }
        } else if(n < 0){
            for (int i = 0; i > n; i--) {
                int buffer = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = buffer;
            }
        }

        System.out.printf("%n");
        System.out.print("Итоговый массив:");
        for (int element : array) {
            System.out.printf(" %2d", element);
        }
    }
}
