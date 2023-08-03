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

        Field nameField = employeeClass.getField("name");
        nameField.set(employee, "Jason");

        Field titleField = employeeClass.getField("title");
        titleField.set(employee, "Analyst");

        System.out.println(employee); //  167349396, Name: Jason, Title: Analyst, Salary: 0.0, Dept: null, Committees: null, Type: FULLTIME

        System.out.println("Name: " + nameField.get(employee)); // Name: Jason
        System.out.println("Title: " + titleField.get(employee)); // Title: Analyst

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