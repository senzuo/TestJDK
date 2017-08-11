package concurrent;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by 申卓 on 2017/8/11.
 */
public class TestCmpRunCall {
    public static void main(String[] args) throws Exception{
        new Thread(new Run()).start();
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> result = executor.submit(new Call());
        System.out.println(result.get());
    }
}

class Run implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println( Thread.currentThread().getName() +  "++++++++++run++++++++" + i);
        }
    }
}

class Call implements Callable<String> {
    public String call() {
        for (int i = 0; i < 10; i++){
            System.out.println("call  return a value");
        }
        return "returned" + new Date();
    }
}