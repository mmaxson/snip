package com.mmu.gen;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mu on 7/14/17.
 */
public class ProducerConsumer<T> {

    class MyProducer<T> implements Runnable {

        private final BlockingQueue<T> queue;

        public MyProducer(BlockingQueue<T> queue) {
            this.queue = queue;
        }

        public void run() {
            for(int i=0; i<10; i++){
                try {
                    System.out.println("Produced: " + i);
                    queue.put( (T) new Integer(i));
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyProducer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }


    class MyConsumer<T> implements Runnable{

        private final BlockingQueue<T> queue;

        public MyConsumer (BlockingQueue<T> queue) {
            this.queue = queue;
        }

        public void run() {
            while(true){
                try {
                    System.out.println("Consumed: "+ queue.take());
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyConsumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void startWork(){
        BlockingQueue<String> sharedQueue = new LinkedBlockingQueue<String>();

        Thread prodThread = new Thread(new MyProducer(sharedQueue));
        Thread consThread = new Thread(new MyConsumer(sharedQueue));

        prodThread.start();
        consThread.start();
    }

    public static void main(String args[]){

       ProducerConsumer pc = new ProducerConsumer();
       pc.startWork();

    }
}
