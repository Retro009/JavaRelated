package Multithreading;

public class SynchronizationDemo extends Thread{
    public static void main(String[] args){
        Thread t1 = new Thread(new SynchronizationDemo());
        SynchronizationDemo t2 = new SynchronizationDemo();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("thread created using Runnable interface "+Thread.currentThread());
            }
        };
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(()->{
            System.out.println("Thread created using Functional Programming "+Thread.currentThread());
        });

        t1.start();
        try{
            t1.join();
        }catch (InterruptedException e ){
            e.printStackTrace();
        }
        t2.start();
        try{
            t2.join();
        }catch (InterruptedException e ){
            e.printStackTrace();
        }
        t3.start();
        t4.start();
        System.out.println("Main Thread running:"+Thread.currentThread());
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Child Thread running:"+Thread.currentThread());
        for(int i=0;i<15;i++)
            System.out.println(i+1);
    }
}
