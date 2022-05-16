package com.example.threadsafetest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.logging.Logger;

public class MainThreadSafeComputer {
    private static Logger logger = Logger.getLogger(MainThreadSafeComputer.class.getName());

    public static Integer slipAndMultiply(Integer val) {
        try {
            Thread.sleep(val*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return val*val;
    }

//    public static void main1(String[] args) throws Exception {
//        ThreadSafeComputer tr = new ThreadSafeComputer();
//        Function<Integer, Integer> f = MainThreadSafeComputer::slipAndMultiply;
//        List<Integer> array = Arrays.asList(2,3,4,3,2,1);
//
//        List<Future<Integer>> list = new ArrayList<>(array.size());
//        for (Integer i : array) {
//            Future<Integer> compute = tr.compute(i, f);
//            list.add(compute);
//        }
//
//        logger.info("Waiting ...");
//        Thread.sleep(16000);
//
//        list.forEach(elem -> {
//            try {
//                logger.info("Value:" + elem.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        });
//
//        System.exit(0);
//    }

    public static void main(String[] args) {
        ThreadSafeComputer tr = new ThreadSafeComputer();
        Function<Integer, Integer> f = MainThreadSafeComputer::slipAndMultiply;
        Runnable r1 = () -> {
            List<Integer> array = Arrays.asList(1,2,3,4);
            for (Integer i : array) {
                Future<Integer> compute = tr.compute(i, f);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable r2 = () -> {
            List<Integer> array = Arrays.asList(1,3,5,7);
            for (Integer i : array) {
                Future<Integer> compute = tr.compute(i, f);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
