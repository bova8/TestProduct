package com.example.threadsafetest;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.logging.Logger;

public class ThreadSafeComputer<K, V> {
    private static Logger logger = Logger.getLogger(ThreadSafeComputer.class.getName());

    private Map<K, Future<V>> map = new HashMap<>();
    private ExecutorService executor = Executors.newFixedThreadPool(10);

    public Future<V> compute(K k, Function<K, V> f) {
        logger.info("compute start: " + k);
        Future<V> res;
        synchronized (map) {
            if (map.containsKey(k)) {
                res = map.get(k);
                logger.info("compute already done for " + k);
            } else {
                res = executor.submit(() -> f.apply(k));
                map.put(k, res);
                logger.info("computing " + k + " ...");
            }
        }

        return res;
    }
}
