package com.skillsoft.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> objectClass = Class.forName("java.lang.Object");

        System.out.println("************** accessing method properties");

        Method[] methods = objectClass.getMethods();

        for (Method method : methods) {
            System.out.println("------------------");
            System.out.println(method.getName());
            System.out.println("Parameter count: " + method.getParameterCount());
            System.out.println("Parameter types: " + Arrays.toString(method.getParameterTypes()));
            System.out.println("Return type: " + method.getReturnType());
            // ------------------
            //wait
            //Parameter count: 1
            //Parameter types: [long]
            //Return type: void
            //------------------
            //wait
            //Parameter count: 2
            //Parameter types: [long, int]
            //Return type: void
            //------------------
            //wait
            //Parameter count: 0
            //Parameter types: []
            //Return type: void
            //------------------
            //equals
            //Parameter count: 1
            //Parameter types: [class java.lang.Object]
            //Return type: boolean
            //------------------
            //toString
            //Parameter count: 0
            //Parameter types: []
            //Return type: class java.lang.String
            //------------------
            //hashCode
            //Parameter count: 0
            //Parameter types: []
            //Return type: int
            //------------------
            //getClass
            //Parameter count: 0
            //Parameter types: []
            //Return type: class java.lang.Class
            //------------------
            //notify
            //Parameter count: 0
            //Parameter types: []
            //Return type: void
            //------------------
            //notifyAll
            //Parameter count: 0
            //Parameter types: []
            //Return type: void
        }

        System.out.println();

//        System.out.println("************** accessing public methods");
//
//        Method[] methods = objectClass.getMethods(); // returns the public methods
//
//        for (Method method : methods) {
//            System.out.println(method);
//            // public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
//            // public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
//            // public final void java.lang.Object.wait() throws java.lang.InterruptedException
//            // public boolean java.lang.Object.equals(java.lang.Object)
//            // public java.lang.String java.lang.Object.toString()
//            // public native int java.lang.Object.hashCode()
//            // public final native java.lang.Class java.lang.Object.getClass()
//            // public final native void java.lang.Object.notify()
//            // public final native void java.lang.Object.notifyAll()
//        }
//
//        System.out.println();
//
//        System.out.println("************** accessing public + protected + private methods");
//
//        methods = objectClass.getDeclaredMethods(); // returns public + protected + private methods
//
//        for (Method method : methods) {
//            System.out.println(method);
//            // protected void java.lang.Object.finalize() throws java.lang.Throwable
//            // public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
//            // public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
//            // public final void java.lang.Object.wait() throws java.lang.InterruptedException
//            // public boolean java.lang.Object.equals(java.lang.Object)
//            // public java.lang.String java.lang.Object.toString()
//            // public native int java.lang.Object.hashCode()
//            // public final native java.lang.Class java.lang.Object.getClass()
//            // protected native java.lang.Object java.lang.Object.clone() throws java.lang.CloneNotSupportedException
//            // public final native void java.lang.Object.notify()
//            // public final native void java.lang.Object.notifyAll()
//            // private static native void java.lang.Object.registerNatives()
//        }
//
//        System.out.println();
    }
}

// https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/reflect/Constructor.html
// Java Docs for Reflection APIs for java.lang.reflect.Constructor

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Field.html
// Java Docs for Reflection APIs for java.lang.reflect.Field

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html
// Java Docs for Reflection APIs for java.lang.reflect.Method