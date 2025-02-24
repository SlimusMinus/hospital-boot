package aston.group86.hospitalboot.example;

public class Task4 {

    public static void main(String[] args) throws InterruptedException {

        /*
        Отрефакторить, чтобы вывод в консоль следующего вида:

        main
        Thread-1
        Thread-1
        main

         */
        System.out.println(Thread.currentThread().getName());


        Thread thread1 = new Thread( ()-> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName());
        }, "Thread-1");

        thread1.start();
        thread1.join();

        System.out.println(Thread.currentThread().getName());

    }

}
