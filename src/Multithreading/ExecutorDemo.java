package Multithreading;

public class ExecutorDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(()-> System.out.println("Child Thread: "+Thread.currentThread()));
        t1.start();
        System.out.println("Main Thread: "+Thread.currentThread());
    }
}
