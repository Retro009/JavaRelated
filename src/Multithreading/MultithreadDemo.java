package Multithreading;

public class MultithreadDemo implements Runnable{
    private static int counter=0;
    public static void main(String[] args) {
        for(int i=0;i<2;i++){
            Thread t = new Thread(new MultithreadDemo());
            t.start();
        }
        System.out.println(counter);
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(counter);
            counter++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
