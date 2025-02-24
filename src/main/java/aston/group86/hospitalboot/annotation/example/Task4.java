package aston.group86.hospitalboot.annotation.example;

public class Task4 {

    public static void main(String[] args) throws InterruptedException {

        /*
        Отрефакторить, что вывод в консоль следующего вида:

        main
        Thread-1
        Thread-1
        main

         */

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());

    }

}
