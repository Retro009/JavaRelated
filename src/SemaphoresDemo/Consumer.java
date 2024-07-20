package SemaphoresDemo;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Queue<Object> queue;
    private int maxSize;
    private Semaphore producer;
    private Semaphore consumer;

    public Consumer(Queue<Object> queue,int maxSize, Semaphore producer,Semaphore consumer){
        this.queue=queue;
        this.maxSize=maxSize;
        this.producer=producer;
        this.consumer=consumer;
    }


    @Override
    public void run() {
        while(true){
            try {
                consumer.acquire();
                if(queue.size()>0){
                    queue.remove();
                    System.out.println("Removed from the queue and consumed");
                }
                producer.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
