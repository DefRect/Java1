package lesson5;

public class ArrayEmployees {
    private final int NUMBER_EMPLOYEES = 5;
    private final int AGE_FOR_COMPARISON = 40;

    private Employee[] employee = new Employee[NUMBER_EMPLOYEES];

    public void run() {
        addEmployees();
        findEmployees();
    }

    private void addEmployees() {
        this.employee[0] = new Employee("Ivanov", "Ivan", "Ivanovich", "Engineer", "Ivanov1254@yandex.ru", "89451245486", 45000, 45);
        this.employee[1] = new Employee("Petrov", "Artem", "Alexeyevich", "Teacher", "APetr@mail.ru", "89046548514", 20000, 21);
        this.employee[2] = new Employee("Smirnov", "Dmitry", "Evgenyevich", "Electrician", "SDE1975@mail.ru", "89129184521", 70000, 52);
        this.employee[3] = new Employee("Volkina", "Ekaterina", "Sergeevna", "Administrator", "EkaV@gmail.com", "89084875321", 42000, 28);
        this.employee[4] = new Employee("Frolov", "Ilya", "Mikhailovich", "Programmer", "Frolysha@mail.ru", "89154587652", 55000, 40);
    }

    private void findEmployees() {
        for (int i = 0; i < NUMBER_EMPLOYEES; i++) {
            if(this.employee[i].getAge() > AGE_FOR_COMPARISON){
                System.out.println("Employee " + (i + 1));
                this.employee[i].getInfo();
                System.out.println();
            }
        }
    }
}
