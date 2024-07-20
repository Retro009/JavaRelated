package Multithreading;

import java.util.concurrent.*;

public class CallableDemo implements Callable<Integer> {
    int number;
    public CallableDemo(int number){
        this.number = number;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo c = new CallableDemo(2);
        CallableDemo c2 = new CallableDemo(4);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> s = executorService.submit(c);
        Future<Integer> s2 = executorService.submit(c2);
        System.out.println("Main Thread: "+ Thread.currentThread());
        System.out.println(s2.get());
        System.out.println(s.get());


        executorService.shutdown();

    }
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000*number);
        return number;
    }
}
