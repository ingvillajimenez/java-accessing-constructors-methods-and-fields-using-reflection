package com.skillsoft.reflection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class Employee {

    private static final Random employeeIdGenerator = new Random();

    private int employeeId;
    public String name = "Unknown";
    public String title = "Unknown";
    private double salary = 0.0;

    private Employee() {
    }

    public static Employee createEmployee(String name, String title, double salary) {
        Employee employee = new Employee();

        employee.employeeId = Math.abs(employeeIdGenerator.nextInt());
        employee.name = name;
        employee.title = title;
        employee.salary = salary;

        return employee;
    }

    public int getEmployeeId() {
        return employeeId;
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

    public void incrementSalary(float percentageIncrement) {
        salary = salary + percentageIncrement * salary;
    }

    public boolean save()
            throws IllegalAccessException {
        System.out.println("save() with no arguments saves to the default location");

        return true;
    }

    public boolean save(String file)
            throws IllegalAccessException, InterruptedException {
        // NOTE: Assume that this saves to a file on your local machine
        System.out.println("save(filename): " + file);

        return true;
    }

    protected boolean save(String connectionString, String username, String password)
            throws IllegalAccessException, InterruptedException, ExecutionException {
        // NOTE: Assume that this saves to a database
        System.out.println("save(connectionString, username, password)");

        return true;
    }

    @Deprecated
    @SuppressWarnings("unchecked") // tells Java not to throw warnings for operations which work with a raw types
    public void printEmployeeDetails() {
        System.out.println(employeeId + name);

        List someList = new ArrayList(); // we have not specified a type parameter, ArrayList is not type safe
        someList.add("element in unchecked list");
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Title: %s, Salary: %.1f",
                employeeId, name, title, salary);
    }
}
