package Multithreading;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count(0);
        for(int i=0;i<50;i++){
            Thread t1 = new Thread(()->{ synchronized (count){
                count.increase();
                System.out.println(count.counter);
            }});
            Thread t2 = new Thread(()->{ synchronized (count){
                count.increase();
                System.out.println(count.counter);
            }});
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        }
    }
}
