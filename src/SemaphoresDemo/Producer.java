package SemaphoresDemo;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Object> queue;
    private int maxSize;
    private Semaphore producer;
    private Semaphore consumer;



    public Producer(Queue<Object> queue,int maxSize, Semaphore producer,Semaphore consumer){
        this.queue=queue;
        this.maxSize=maxSize;
        this.producer=producer;
        this.consumer=consumer;
    }


    @Override
    public void run() {
        while(true){
            try {
                producer.acquire();
                if(queue.size()<maxSize){
                    queue.add(new Object());
                    System.out.println("produced and added to the queue");
                }
                consumer.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
