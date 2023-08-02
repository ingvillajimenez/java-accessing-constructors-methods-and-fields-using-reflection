package com.skillsoft.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> employeeClass = Class.forName("com.skillsoft.reflection.Employee");

        System.out.println("***************** public constructors");

        Constructor<?>[] constructors = employeeClass.getConstructors(); // only returns the public constructors

        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
            // public com.skillsoft.reflection.Employee()
            // public com.skillsoft.reflection.Employee(java.lang.String,java.lang.String,double)
        }

        System.out.println();

        System.out.println("***************** public + protected + private constructors");

        constructors = employeeClass.getDeclaredConstructors(); // returns public + protected + private constructors

        for (Constructor<?> constructor : constructors) {
            System.out.println("--- Constructor + Parameter types");
            System.out.println(constructor);

            Class<?>[] parameters = constructor.getParameterTypes(); // gets a list of all the parameters of the constructor object
            for (Class<?> parameter : parameters) {
                System.out.println(parameter);
            }
            // --- Constructor + Parameter types
            // public com.skillsoft.reflection.Employee()
            //--- Constructor + Parameter types
            // public com.skillsoft.reflection.Employee(java.lang.String,java.lang.String,double)
            // class java.lang.String
            // class java.lang.String
            // double
            //--- Constructor + Parameter types
            // protected com.skillsoft.reflection.Employee(java.lang.String,java.lang.String)
            // class java.lang.String
            // class java.lang.String
            //--- Constructor + Parameter types
            // private com.skillsoft.reflection.Employee(java.lang.String)
            // class java.lang.String
        }

//        for (Constructor<?> constructor : constructors) {
//            System.out.println(constructor);
//            // public com.skillsoft.reflection.Employee()
//            // public com.skillsoft.reflection.Employee(java.lang.String,java.lang.String,double)
//            // protected com.skillsoft.reflection.Employee(java.lang.String,java.lang.String)
//            // private com.skillsoft.reflection.Employee(java.lang.String)
//        }

        System.out.println();

        System.out.println("************* No argument constructor");

        Constructor<?> noArgumentConstructor = employeeClass.getConstructor(); // return no argument constructor

        System.out.println(noArgumentConstructor); // public com.skillsoft.reflection.Employee()

        Object object = noArgumentConstructor.newInstance(); // create an object of a specific class
        System.out.println("Object: " + object); // Object: ID: 2087279790, Name: Unknown, Title: Unknown, Salary: 0.0

        Employee employee = (Employee) noArgumentConstructor.newInstance();
        System.out.println("Employee: " + employee); // Employee: ID: 678603294, Name: Unknown, Title: Unknown, Salary: 0.

        System.out.println();

        System.out.println("*************** 3 argument constructor");

        Constructor<?> threeArgumentConstructor = employeeClass.getConstructor( // return 3 argument constructor
                String.class, String.class, double.class);

        Employee dorian = (Employee) threeArgumentConstructor.newInstance("Dorian", "MD", 89000);
        System.out.println("Dorian: " + dorian); // Dorian: ID: 393469625, Name: Dorian, Title: MD, Salary: 89000.0

        System.out.println();

        System.out.println("***************** private constructor");

        Constructor<?> privateConstructor = employeeClass.getDeclaredConstructor(String.class); // get handles to private and protected constructors

//        Employee nancy = (Employee) privateConstructor.newInstance("Nancy"); // java.lang.IllegalAccessException
//        System.out.println("Nancy: " + nancy);
//
//        System.out.println();

        privateConstructor.setAccessible(true); // change the accessibility level of this constructor object

        Employee nancy = (Employee) privateConstructor.newInstance("Nancy");
        System.out.println("Nancy: " + nancy); // Nancy: ID: 1313337698, Name: Nancy, Title: Unknown, Salary: 0.0

        System.out.println();

        Employee julian = (Employee) threeArgumentConstructor.newInstance("Julian", "MD"); // incorrect number or type of input arguments
                                                                        // java.lang.IllegalArgumentException
    }
}

// https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/reflect/Constructor.html
// Java Docs for Reflection APIs for java.lang.reflect.Constructor