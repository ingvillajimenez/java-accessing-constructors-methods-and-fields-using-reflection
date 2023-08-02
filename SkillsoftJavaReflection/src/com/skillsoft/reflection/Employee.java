package com.skillsoft.reflection;

import java.util.List;
import java.util.Random;

public class Employee {

    enum Type {
        FULLTIME,
        CONTRACT
    }

    private static final transient Random employeeIdGenerator = new Random();
    // transient keyword tells Java not to try and write out or serialize or deserialize this particular member variable
    private final int employeeId;
    public String name = "Unknown";
    public String title = "Unknown";
    private double salary = 0.0;

    private Department department;

    public volatile List<String> committees; // volatile keyword in Java is used for atomic access
    // volatile, reduces the risk of memory consistency errors for multi-threaded applications
    protected Type employeeType = Type.FULLTIME;

    public Employee() {
        this.employeeId = Math.abs(employeeIdGenerator.nextInt());
    }

    public Employee(String name, String title, double salary) {
        this();

        this.name = name;
        this.title = title;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Title: %s, Salary: %.1f, Dept: %s, Committees: %s, Type: %s",
                employeeId, name, title, salary, department, committees, employeeType);
    }
}
