package com.wsp.study.concurrency.quickdemo;

import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

import java.io.File;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 一个累加计数示例.
 * <p>
 *
 * @author ship
 * @date 2023/7/4 0004 7:58
 */
public class CountUpDemo {

    /**
     * 需要设置日志输出到文件：Edit Run Configurations -> Logs -> save console output to file
     */
    public static final Log log = LogFactory.create().createLog(CountUpDemo.class);

    static {
        // 清理日志
        new File("/tmp/logs/idea-console.log").delete();
    }

    /**
     * 屏障，所有 parties 会互相等待，知道全部 parties 都准备好才继续执行
     */
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(12);

    /**
     * 记录开始时间
     */
    public static long startTime;

    /**
     * 合计次数
     */
    public static int count = 0;

    public static void main(String[] args) {

        // 同步执行的方案
//        syncProgramme();

        // 异步执行的方案
        asyncProgramme();

    }

    /**
     * 示例 - 拧螺丝的并发方案
     */
    private static void asyncProgramme() {

        ThreadPoolExecutor threadPoolExecutor = new ExecutorBuilder().setCorePoolSize(12).build();

        threadPoolExecutor.execute(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                log.info("小姬拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                log.info("大姬拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                log.info("小巴拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                log.info("大巴拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                log.info("小编拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                log.info("大编拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                log.info("小蔡拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                log.info("大蔡拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                log.info("小鲲拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                log.info("大鲲拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                log.info("小拉拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                log.info("大拉拧螺丝 + 1");
                count++;
            }
        });

        threadPoolExecutor.shutdown();

        while (true) {
            if (threadPoolExecutor.isTerminated()) {
                long time = System.currentTimeMillis() - startTime;
                log.info("=========== 合计：" + count);
                log.info("== 耗时：" + time);
                break;
            }
        }

        /** 查看日志
         grep "小姬拧螺丝" idea-console.log | wc -l
         grep "大姬拧螺丝" idea-console.log | wc -l
         grep "小巴拧螺丝" idea-console.log | wc -l
         grep "大巴拧螺丝" idea-console.log | wc -l
         grep "小编拧螺丝" idea-console.log | wc -l
         grep "大编拧螺丝" idea-console.log | wc -l
         grep "小蔡拧螺丝" idea-console.log | wc -l
         grep "大蔡拧螺丝" idea-console.log | wc -l
         grep "小鲲拧螺丝" idea-console.log | wc -l
         grep "大鲲拧螺丝" idea-console.log | wc -l
         grep "小拉拧螺丝" idea-console.log | wc -l
         grep "大拉拧螺丝" idea-console.log | wc -l
         */
    }

    /**
     * 示例 - 拧螺丝的同步方案
     */
    private static void syncProgramme() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println("小姬拧螺丝 + 1");
            count++;
        }
        for (int i = 0; i < 10000; i++) {
            System.out.println("大姬拧螺丝 + 1");
            count++;
        }
        for (int i = 0; i < 10000; i++) {
            System.out.println("小巴拧螺丝 + 1");
            count++;
        }
        for (int i = 0; i < 10000; i++) {
            System.out.println("大巴拧螺丝 + 1");
            count++;
        }
        for (int i = 0; i < 10000; i++) {
            System.out.println("小编拧螺丝 + 1");
            count++;
        }
        for (int i = 0; i < 10000; i++) {
            System.out.println("大编拧螺丝 + 1");
            count++;
        }
        for (int i = 0; i < 10000; i++) {
            System.out.println("小蔡拧螺丝 + 1");
            count++;
        }
        for (int i = 0; i < 10000; i++) {
            System.out.println("大蔡拧螺丝 + 1");
            count++;
        }
        for (int i = 0; i < 10000; i++) {
            System.out.println("小鲲拧螺丝 + 1");
            count++;
        }
        for (int i = 0; i < 10000; i++) {
            System.out.println("大鲲拧螺丝 + 1");
            count++;
        }
        for (int i = 0; i < 10000; i++) {
            System.out.println("小拉拧螺丝 + 1");
            count++;
        }
        for (int i = 0; i < 10000; i++) {
            System.out.println("大拉拧螺丝 + 1");
            count++;
        }
        System.out.println("=========== 合计：" + count);
        System.out.println("== 耗时：" + (System.currentTimeMillis() - startTime));
        System.exit(0);
    }
}
