package com.skillsoft.reflection;

import java.util.Random;

public class Employee {

    private static final Random employeeIdGenerator = new Random();

    private int employeeId;
    private String name = "Unknown";
    private String title = "Unknown";
    private double salary = 0.0;

    public Employee() {
        this.employeeId = Math.abs(employeeIdGenerator.nextInt());
    }

    private Employee(String name) {
        this();

        this.name = name;
    }

    protected Employee(String name, String title) {
        this(name);

        this.title = title;
    }

    public Employee(String name, String title, double salary) {
        this(name, title);

        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private double computeBonusInternal(float bonusPercentage) {
        return salary * bonusPercentage;
    }

    public double computeTotalSalary(float bonusPercentage) {
        return salary + computeBonusInternal(bonusPercentage);
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Title: %s, Salary: %.1f",
                employeeId, name, title, salary);
    }
}
