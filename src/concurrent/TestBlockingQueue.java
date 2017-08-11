package concurrent;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by 申卓 on 2017/8/11.
 */

/**
 * 并发包  阻塞队列   ref API 经典 生产者消费者模式
 *
 * 阻塞队列  BlockingQueue
 *      多种形式
 *          Throws exception 、Special value、Blocks、Times out
 *      thread-safe
 *
 *
 */
public class TestBlockingQueue {
    public static void main(String[] args) throws Exception{
        BlockingQueue q = new ArrayBlockingQueue(5);
        Producer p = new Producer(q);
        Consumer c1 = new Consumer(q);
        Consumer c2 = new Consumer(q);
        new Thread(p).start();
        Thread.sleep(100);
        new Thread(c1).start();
        new Thread(c2).start();
    }
}

class Producer implements Runnable{
    private final BlockingQueue queue;
    Producer(BlockingQueue q){
        queue = q;
    }
    public void run() {
        try {
            while (true) {
                queue.put(produce());
                Thread.sleep(50);
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
    Integer produce() {
        Random random = new Random();
        int r =  random.nextInt();
        System.out.println("generate +++++" + Thread.currentThread().getName() + "!!!!!" + r);
        return r;
    }
}

class Consumer implements Runnable{
    private final BlockingQueue queue;
    Consumer(BlockingQueue queue){
        this.queue = queue;
    }
    public void run(){
        try{
            while (true) {
                consume(queue.take());
                Thread.sleep(50);
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
    void consume(Object integer){
        System.out.println("consume ------" + Thread.currentThread().getName() + "!!!!!" + integer);
    }
}
