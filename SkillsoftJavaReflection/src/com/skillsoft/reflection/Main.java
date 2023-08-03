package com.skillsoft.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> employeeClass = Class.forName("com.skillsoft.reflection.Employee");

        System.out.println("************** accessing method properties");

        Method[] methods = employeeClass.getDeclaredMethods(); // gets public, protected, private methods

        for (Method method: methods) {
            System.out.println("-------------");
            System.out.println(method.getName());
            System.out.println("Parameter count: " + method.getParameterCount());
            System.out.println("Parameter types: " + Arrays.toString(method.getParameterTypes()));
            System.out.println("Return type: " + method.getReturnType());
            System.out.println("Exception types: " + Arrays.toString(method.getExceptionTypes()));
            // -------------
            //getName
            //Parameter count: 0
            //Parameter types: []
            //Return type: class java.lang.String
            //Exception types: []
            //-------------
            //toString
            //Parameter count: 0
            //Parameter types: []
            //Return type: class java.lang.String
            //Exception types: []
            //-------------
            //setName
            //Parameter count: 1
            //Parameter types: [class java.lang.String]
            //Return type: void
            //Exception types: []
            //-------------
            //save
            //Parameter count: 3
            //Parameter types: [class java.lang.String, class java.lang.String, class java.lang.String]
            //Return type: boolean
            //Exception types: [class java.lang.IllegalAccessException, class java.lang.InterruptedException, class java.util.concurrent.ExecutionException]
            //-------------
            //save
            //Parameter count: 0
            //Parameter types: []
            //Return type: boolean
            //Exception types: [class java.lang.IllegalAccessException]
            //-------------
            //save
            //Parameter count: 1
            //Parameter types: [class java.lang.String]
            //Return type: boolean
            //Exception types: [class java.lang.IllegalAccessException, class java.lang.InterruptedException]
            //-------------
            //computeBonusInternal
            //Parameter count: 1
            //Parameter types: [float]
            //Return type: double
            //Exception types: []
            //-------------
            //createEmployee
            //Parameter count: 3
            //Parameter types: [class java.lang.String, class java.lang.String, double]
            //Return type: class com.skillsoft.reflection.Employee
            //Exception types: []
            //-------------
            //getEmployeeId
            //Parameter count: 0
            //Parameter types: []
            //Return type: int
            //Exception types: []
            //-------------
            //computeTotalSalary
            //Parameter count: 1
            //Parameter types: [float]
            //Return type: double
            //Exception types: []
            //-------------
            //incrementSalary
            //Parameter count: 1
            //Parameter types: [float]
            //Return type: void
            //Exception types: []
            //-------------
            //printEmployeeDetails
            //Parameter count: 0
            //Parameter types: []
            //Return type: void
            //Exception types: []
            //-------------
            //getTitle
            //Parameter count: 0
            //Parameter types: []
            //Return type: class java.lang.String
            //Exception types: []
            //-------------
            //setTitle
            //Parameter count: 1
            //Parameter types: [class java.lang.String]
            //Return type: void
            //Exception types: []
            //-------------
            //getSalary
            //Parameter count: 0
            //Parameter types: []
            //Return type: double
            //Exception types: []
            //-------------
            //setSalary
            //Parameter count: 1
            //Parameter types: [double]
            //Return type: void
            //Exception types: []
        }

        System.out.println();
    }
}

// https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/reflect/Constructor.html
// Java Docs for Reflection APIs for java.lang.reflect.Constructor

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Field.html
// Java Docs for Reflection APIs for java.lang.reflect.Field

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html
// Java Docs for Reflection APIs for java.lang.reflect.Method