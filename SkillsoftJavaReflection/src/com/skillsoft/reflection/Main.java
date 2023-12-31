package com.skillsoft.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    private static boolean isGetter(Method method) {

        if (!method.getName().startsWith("get")) {
            return false;
        }

        if (!((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)) {
            return false;
        }

        if (method.getReturnType().equals(void.class)) {
            return false;
        }

        if (method.getParameterCount() != 0) {
            return false;
        }

        return true;
    }

    private static boolean isSetter(Method method) {

        if (!method.getName().startsWith("set")) {
            return false;
        }

        if (!((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)) {
            return false;
        }

        if (!method.getReturnType().equals(void.class)) {
            return false;
        }

        if (method.getParameterCount() != 1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {

        Class<?> employeeClass = Class.forName("com.skillsoft.reflection.Employee");

        System.out.println("************** public static invocation");

        Method createrEmployeeMethod = employeeClass.getMethod("createEmployee",
                String.class, String.class, double.class);

        // NOTE: For static method invocation, pass in "null" as the first input argument, there
        // is no object against which the method is invoked
        Employee employee = (Employee) createrEmployeeMethod.invoke(
                null, "Nora", "Accounts Manager", 45000);

        System.out.println("Employee: " + employee); // Employee: ID: 212792334, Name: Nora, Title: Accounts Manager, Salary: 45000.0

        System.out.println();

        System.out.println("****************** getter invocation");

        for (Method method : employeeClass.getDeclaredMethods()) {
            if (isGetter(method)) {
                System.out.println(method.invoke(employee));
                //Nora
                //726270105
                //Accounts Manager
                //45000.0
            }
        }

        System.out.println();

        System.out.println("*************** setter invocation");

        for (Method method : employeeClass.getDeclaredMethods()) {
            if (isSetter(method)) {
                if (method.getName().equals("setName")) {
                    method.invoke(employee, "Nora Roberts");
                } else if (method.getName().equals("setTitle")) {
                    method.invoke(employee, "Accounts Director");
                } else if (method.getName().equals("setSalary")) {
                    method.invoke(employee, 50000);
                }
            }
        }

        System.out.println("Updated employee: " + employee); // Updated employee: ID: 130121672, Name: Nora Roberts, Title: Accounts Director, Salary: 50000.0

        System.out.println();

        System.out.println("************* protected invocation");

        Method saveMethod = employeeClass.getDeclaredMethod("save",
                String.class, String.class, String.class);

        saveMethod.setAccessible(true);

        saveMethod.invoke(employee, "<some connection string>", "<some username>", "some password");  // save(connectionString, username, password)

        Method computeBonusInternalMethod = employeeClass.getDeclaredMethod("computeBonusInternal",
                float.class);

        computeBonusInternalMethod.setAccessible(true);

        System.out.println(computeBonusInternalMethod.invoke(employee, 0.1f)); // 5000.000074505806

//        Class<?> employeeClass = Class.forName("com.skillsoft.reflection.Employee");
//
//        System.out.println("*************** accessing getters and setters");
//
//        Method[] methods = employeeClass.getDeclaredMethods();
//
//        for (Method method : methods) {
//            if (isGetter(method)) {
//                System.out.println(method.getName() + " getter");
//            } else if (isSetter(method)) {
//                System.out.println(method.getName() + " setter");
//            }
//            //getName getter
//            //setName setter
//            //getEmployeeId getter
//            //getTitle getter
//            //setTitle setter
//            //getSalary getter
//            //setSalary setter
//        }
    }
}

// https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/reflect/Constructor.html
// Java Docs for Reflection APIs for java.lang.reflect.Constructor

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Field.html
// Java Docs for Reflection APIs for java.lang.reflect.Field

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html
// Java Docs for Reflection APIs for java.lang.reflect.Method