package com.mmu.gen;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mu on 7/14/17.
 */
public class ProducerConsumer {

    class Producer implements Runnable {

        private final BlockingQueue sharedQueue;

        public Producer(BlockingQueue sharedQueue) {
            this.sharedQueue = sharedQueue;
        }

        public void run() {
            for(int i=0; i<10; i++){
                try {
                    System.out.println("Produced: " + i);
                    sharedQueue.put(i);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    class Consumer implements Runnable{

        private final BlockingQueue sharedQueue;

        public Consumer (BlockingQueue sharedQueue) {
            this.sharedQueue = sharedQueue;
        }

        public void run() {
            while(true){
                try {
                    System.out.println("Consumed: "+ sharedQueue.take());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void startWork(){
        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        Thread prodThread = new Thread(new Producer(sharedQueue));
        Thread consThread = new Thread(new Consumer(sharedQueue));

        prodThread.start();
        consThread.start();
    }

    public static void main(String args[]){

       ProducerConsumer pc = new ProducerConsumer();
       pc.startWork();

    }
}
