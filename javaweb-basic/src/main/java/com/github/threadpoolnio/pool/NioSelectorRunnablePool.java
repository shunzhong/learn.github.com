package com.github.threadpoolnio.pool;

import com.github.threadpoolnio.NioServerBoss;
import com.github.threadpoolnio.NioServerWorker;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * selector线程管理者
 *
 * @author -琴兽-
 */
public class NioSelectorRunnablePool {

    /**
     * boss线程数组
     */
    private final AtomicInteger bossIndex = new AtomicInteger();
    /**
     * worker线程数组
     */
    private final AtomicInteger workerIndex = new AtomicInteger();
    private Boss[] bosses;
    private Worker[] workers;


    public NioSelectorRunnablePool(Executor boss, Executor worker) {
        initBoss(boss, 1);
        initWorker(worker, Runtime.getRuntime().availableProcessors() * 2);
    }

    /**
     * 初始化boss线程
     *
     * @param boss
     * @param count
     */
    private void initBoss(Executor boss, int count) {
        this.bosses = new NioServerBoss[count];
        for (int i = 0; i < bosses.length; i++) {
            bosses[i] = new NioServerBoss(boss, "boss thread " + (i + 1), this);
        }

    }

    /**
     * 初始化worker线程
     *
     * @param worker
     * @param count
     */
    private void initWorker(Executor worker, int count) {
        this.workers = new NioServerWorker[count];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new NioServerWorker(worker, "worker thread " + (i + 1), this);
        }
    }

    /**
     * 获取一个worker，均匀的给每个worker分配工作
     *
     * @return
     */
    public Worker nextWorker() {
        return workers[Math.abs(workerIndex.getAndIncrement() % workers.length)];

    }

    /**
     * 获取一个boss
     *
     * @return
     */
    public Boss nextBoss() {
        return bosses[Math.abs(bossIndex.getAndIncrement() % bosses.length)];
    }

}
