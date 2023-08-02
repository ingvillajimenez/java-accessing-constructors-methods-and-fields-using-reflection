package com.skillsoft.reflection;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Class<?> employeeClass = Class.forName("com.skillsoft.reflection.Employee");

        System.out.println("************* public fields");

        Field[] fields = employeeClass.getFields(); // gets public fields

        for (Field field : fields) {
            System.out.println(field);
            // public java.lang.String com.skillsoft.reflection.Employee.name
            // public java.lang.String com.skillsoft.reflection.Employee.title
            // public volatile java.util.List com.skillsoft.reflection.Employee.committees
        }

        System.out.println();

        System.out.println("************* public + protected + private fields");

        fields = employeeClass.getDeclaredFields(); // gets public + protected + private fields

        for (Field field: fields) {
            System.out.println(field);
            // private static final transient java.util.Random com.skillsoft.reflection.Employee.employeeIdGenerator
            // private final int com.skillsoft.reflection.Employee.employeeId
            // public java.lang.String com.skillsoft.reflection.Employee.name
            // public java.lang.String com.skillsoft.reflection.Employee.title
            // private double com.skillsoft.reflection.Employee.salary
            // private com.skillsoft.reflection.Department com.skillsoft.reflection.Employee.department
            // public volatile java.util.List com.skillsoft.reflection.Employee.committees
            // protected com.skillsoft.reflection.Employee$Type com.skillsoft.reflection.Employee.employeeType
        }

        System.out.println();

        System.out.println("***************** field names, types, generic types");

        for (Field field : fields) {
            System.out.println("-----");
            System.out.println("Name: " + field.getName()); // get name of the fields
            System.out.println("Type: " + field.getType()); // get type of the fields
            System.out.println("Generic Type: " + field.getGenericType()); // get type parameter of the fields
            // -----
            //Name: employeeIdGenerator
            //Type: class java.util.Random
            //Generic Type: class java.util.Random
            //-----
            //Name: employeeId
            //Type: int
            //Generic Type: int
            //-----
            //Name: name
            //Type: class java.lang.String
            //Generic Type: class java.lang.String
            //-----
            //Name: title
            //Type: class java.lang.String
            //Generic Type: class java.lang.String
            //-----
            //Name: salary
            //Type: double
            //Generic Type: double
            //-----
            //Name: department
            //Type: class com.skillsoft.reflection.Department
            //Generic Type: class com.skillsoft.reflection.Department
            //-----
            //Name: committees
            //Type: interface java.util.List
            //Generic Type: java.util.List<java.lang.String>
            //-----
            //Name: employeeType
            //Type: class com.skillsoft.reflection.Employee$Type
            //Generic Type: class com.skillsoft.reflection.Employee$Type
        }

        System.out.println();

        System.out.println("*************** accessing fields by name");

        Field nameField = employeeClass.getField("name"); // get public name field
        Field titleField = employeeClass.getField("title"); // get public title field
        Field committessField = employeeClass.getField("committees"); // get committees field

        System.out.println(nameField); // public java.lang.String com.skillsoft.reflection.Employee.name
        System.out.println(titleField); // public java.lang.String com.skillsoft.reflection.Employee.title
        System.out.println(committessField); // public volatile java.util.List com.skillsoft.reflection.Employee.committees

        System.out.println();

//        System.out.println("************* accessing private fields by name (error)");
//
//        Field salaryField = employeeClass.getField("salary"); // Field 'salary' is not public, java.lang.NoSuchFieldException
//        Field employeeIdField = employeeClass.getField("employeeId"); // Field 'employeeId' is not public, java.lang.NoSuchFieldException

        System.out.println("*************** accessing private fields by name");

        Field salaryField = employeeClass.getDeclaredField("salary"); // get private salary field
        Field employeeIdField = employeeClass.getDeclaredField("employeeId"); // get private employeeId field

        System.out.println(salaryField); // private double com.skillsoft.reflection.Employee.salary
        System.out.println(employeeIdField); // private final int com.skillsoft.reflection.Employee.employeeId

        System.out.println();
    }
}

// https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/reflect/Constructor.html
// Java Docs for Reflection APIs for java.lang.reflect.Constructor

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/FIeld.html
// Java Docs for Reflection APIs for java.lang.reflect.Field