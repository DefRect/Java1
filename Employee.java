package lesson5;

public class Employee {

    // Employee data
    private String firstName;
    private String lastName;
    private String middleName;
    private String position;
    private String eMail;
    private String phoneNumber;

    private int salary;
    private int age;

    public Employee(String firstName, String lastName, String middleName, String position, String eMail, String phoneNumber, int salary, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void getInfo(){
        System.out.println("First name: " + this.firstName);
        System.out.println("Last name: " + this.lastName);
        System.out.println("Middle name: " + this.middleName);
        System.out.println("Position: " + this.position);
        System.out.println("eMail: " + this.eMail);
        System.out.println("Phone number: " + this.phoneNumber);
        System.out.println("Salary: " + this.salary);
        System.out.println("Age: " + this.age);
    }

    public int getAge() {
        return age;
    }
}
