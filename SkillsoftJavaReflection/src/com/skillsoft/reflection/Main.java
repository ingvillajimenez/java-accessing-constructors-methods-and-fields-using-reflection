package com.skillsoft.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

    private static void printMethodProperties(Method method) {

        System.out.println("-----------------");
        System.out.println(method.getName());
        System.out.println("Parameter count: " + method.getParameterCount());
        System.out.println("Parameter types: " + Arrays.toString(method.getParameterTypes()));
        System.out.println("Return type: " + method.getReturnType());

        System.out.println("Exception types: " + Arrays.toString(method.getExceptionTypes()));

        // NOTE: Returns annotations that are directly present on this element.
        // NOTE: The @Override and @SuppressWarnings annotation is not retained for
        // reflective access
        System.out.println("Annotations: " + Arrays.toString(method.getDeclaredAnnotations()));
        System.out.println("Check for @Override annotation: " +
                method.getAnnotation(Override.class)); // Annotation 'Override.class' is not retained for reflective access, retention policy is set to source
        System.out.println("Check for @SuppressWarnings annotation: " +
                method.getAnnotation(SuppressWarnings.class)); // Annotation 'SuppressWarning.class' is not retained for reflective access
        System.out.println("Check for @Deprecated annotation: " +
                method.getAnnotation(Deprecated.class)); // retention policy is set to runtime

        int modifiers = method.getModifiers();

        System.out.println("Modifiers: " + Integer.toBinaryString(modifiers));
        System.out.println("Modifiers (string representation): " + Modifier.toString(modifiers));

        System.out.println();
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {

        Class<?> employeeClass = Class.forName("com.skillsoft.reflection.Employee");

        System.out.println("*************** accessing method by name");

        Method toStringMethod = employeeClass.getMethod("toString");
        printMethodProperties(toStringMethod);
        // -----------------
        //toString
        //Parameter count: 0
        //Parameter types: []
        //Return type: class java.lang.String
        //Exception types: []
        //Annotations: []
        //Check for @Override annotation: null
        //Check for @SuppressWarnings annotation: null
        //Check for @Deprecated annotation: null
        //Modifiers: 1
        //Modifiers (string representation): public

        Method createEmployeeMethod = employeeClass.getMethod("createEmployee",
                String.class, String.class, double.class);
        printMethodProperties(createEmployeeMethod);
        // -----------------
        //createEmployee
        //Parameter count: 3
        //Parameter types: [class java.lang.String, class java.lang.String, double]
        //Return type: class com.skillsoft.reflection.Employee
        //Exception types: []
        //Annotations: []
        //Check for @Override annotation: null
        //Check for @SuppressWarnings annotation: null
        //Check for @Deprecated annotation: null
        //Modifiers: 1001
        //Modifiers (string representation): public static

        Method saveFilename = employeeClass.getMethod("save", String.class);
        printMethodProperties(saveFilename);
        // -----------------
        //save
        //Parameter count: 1
        //Parameter types: [class java.lang.String]
        //Return type: boolean
        //Exception types: [class java.lang.IllegalAccessException, class java.lang.InterruptedException]
        //Annotations: []
        //Check for @Override annotation: null
        //Check for @SuppressWarnings annotation: null
        //Check for @Deprecated annotation: null
        //Modifiers: 1
        //Modifiers (string representation): public

        // NOTE: The @Deprecated annotation is retained at runtime (retention policy set to RUNTIME)
        Method printEmployeeDetailsMethod = employeeClass.getMethod("printEmployeeDetails");
        printMethodProperties(printEmployeeDetailsMethod);
        //-----------------
        //printEmployeeDetails
        //Parameter count: 0
        //Parameter types: []
        //Return type: void
        //Exception types: []
        //Annotations: [@java.lang.Deprecated(forRemoval=false, since="")]
        //Check for @Override annotation: null
        //Check for @SuppressWarnings annotation: null
        //Check for @Deprecated annotation: @java.lang.Deprecated(forRemoval=false, since="")
        //Modifiers: 1
        //Modifiers (string representation): public

        Method saveDatabaseMethod = employeeClass.getDeclaredMethod("save",
                String.class, String.class, String.class);
        printMethodProperties(saveDatabaseMethod);
        //-----------------
        //save
        //Parameter count: 3
        //Parameter types: [class java.lang.String, class java.lang.String, class java.lang.String]
        //Return type: boolean
        //Exception types: [class java.lang.IllegalAccessException, class java.lang.InterruptedException, class java.util.concurrent.ExecutionException]
        //Annotations: []
        //Check for @Override annotation: null
        //Check for @SuppressWarnings annotation: null
        //Check for @Deprecated annotation: null
        //Modifiers: 100
        //Modifiers (string representation): protected

        // NOTE: The modifiers include strictfp for strict, floating point calculations
        Method toRadiansMethod = StrictMath.class.getMethod("toRadians", double.class);
        printMethodProperties(toRadiansMethod);
        //-----------------
        //toRadians
        //Parameter count: 1
        //Parameter types: [double]
        //Return type: double
        //Exception types: []
        //Annotations: []
        //Check for @Override annotation: null
        //Check for @SuppressWarnings annotation: null
        //Check for @Deprecated annotation: null
        //Modifiers: 100000001001
        //Modifiers (string representation): public static strictfp
    }
}

// https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/reflect/Constructor.html
// Java Docs for Reflection APIs for java.lang.reflect.Constructor

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Field.html
// Java Docs for Reflection APIs for java.lang.reflect.Field

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html
// Java Docs for Reflection APIs for java.lang.reflect.Method