package com.skillsoft.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchFieldException {

        Class<?> employeeClass = Class.forName("com.skillsoft.reflection.Employee");

        Employee employee = (Employee) employeeClass.getConstructor().newInstance();

        System.out.println(employee); // 167349396, Name: Unknown, Title: Unknown, Salary: 0.0, Dept: null, Committees: null, Type: FULLTIME

        System.out.println("************** setting name and title");

        Field nameField = employeeClass.getField("name"); // get public name field
        nameField.set(employee, "Jason");

        Field titleField = employeeClass.getField("title"); // get public name field
        titleField.set(employee, "Analyst");

        System.out.println(employee); //  167349396, Name: Jason, Title: Analyst, Salary: 0.0, Dept: null, Committees: null, Type: FULLTIME

        System.out.println("Name: " + nameField.get(employee)); // Name: Jason
        System.out.println("Title: " + titleField.get(employee)); // Title: Analyst

        System.out.println();

        System.out.println("*************** setting salary");

        Field salaryField = employeeClass.getDeclaredField("salary"); // get private salary field

        salaryField.setAccessible(true); // salary field is now accessible
        salaryField.setDouble(employee, 125000); // set double salary field

        System.out.println(employee); // ID: 2096532896, Name: Jason, Title: Analyst, Salary: 125000.0, Dept: null, Committees: null, Type: FULLTIME
        System.out.println("Salary: " + salaryField.getDouble(employee)); // Salary: 125000.0

        System.out.println();

        System.out.println("**************** setting employee ID");

        Field employeeIdField = employeeClass.getDeclaredField("employeeId");

        employeeIdField.setAccessible(true); // set accessibility level
        employeeIdField.setInt(employee, 1001); // set int employeeId field

        System.out.println(employee); // ID: 1001, Name: Jason, Title: Analyst, Salary: 125000.0, Dept: null, Committees: null, Type: FULLTIME
        System.out.println("Employee ID: " + employeeIdField.getInt(employee)); // Employee ID: 1001

        System.out.println();

        System.out.println("*************** setting employee department, committees, type");

        Field deparmentField = employeeClass.getDeclaredField("department");
        Field committeesField = employeeClass.getDeclaredField("committees");
        Field employeeTypeField = employeeClass.getDeclaredField("employeeType");

        class Engineering extends Department {

            Engineering() {
                super("Engineering");
            }
        }

        deparmentField.setAccessible(true);
        deparmentField.set(employee, new Engineering());

        List<String> committeesList = new ArrayList<>();
        committeesList.add("Promotion");
        committeesList.add("Christmas");

        committeesField.set(employee, committeesList);

        employeeTypeField.setAccessible(true);
        employeeTypeField.set(employee, Employee.Type.CONTRACT);

        System.out.println(employee); // ID: 1001, Name: Jason, Title: Analyst, Salary: 125000.0, Dept: Engineering, Committees: [Promotion, Christmas], Type: CONTRACT
        System.out.println("Employee department: " + deparmentField.get(employee)); // Employee department: Engineering
        System.out.println("Employee committees: " + committeesField.get(employee)); // Employee committees: [Promotion, Christmas]
        System.out.println("Employee type: " + employeeTypeField.get(employee)); // Employee type: CONTRACT

        System.out.println();

//        Class<?> employeeClass = Class.forName("com.skillsoft.reflection.Employee");
//
//        System.out.println("*********** field modifiers");
//
//        Field[] fields = employeeClass.getDeclaredFields();
//
//        for (Field field : fields) {
//
//            int modifier = field.getModifiers();
//            System.out.println("---------------");
//            System.out.println(field.getName());
//            System.out.println(Integer.toBinaryString(modifier));
//            System.out.println(Modifier.toString(modifier)); // get all the modifiers as String representation for the int modifier value
//            // ---------------
//            //employeeIdGenerator
//            //10011010
//            //private static final transient
//            //---------------
//            //employeeId
//            //10010
//            //private final
//            //---------------
//            //name
//            //1
//            //public
//            //---------------
//            //title
//            //1
//            //public
//            //---------------
//            //salary
//            //10
//            //private
//            //---------------
//            //department
//            //10
//            //private
//            //---------------
//            //committees
//            //1000001
//            //public volatile
//            //---------------
//            //employeeType
//            //100
//            //protected
//        }
//
//        System.out.println();
    }
}

// https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/reflect/Constructor.html
// Java Docs for Reflection APIs for java.lang.reflect.Constructor

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/FIeld.html
// Java Docs for Reflection APIs for java.lang.reflect.Field