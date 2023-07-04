package com.wsp.study.concurrency.quickdemo;

import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

import java.io.File;
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
     * 合计次数
     */
    public static int count = 0;

    public static void main(String[] args) throws Exception {

        ThreadPoolExecutor threadPoolExecutor = new ExecutorBuilder().setCorePoolSize(10).build();

        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                log.info("小姬拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                log.info("大姬拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                log.info("小巴拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                log.info("大巴拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                log.info("小编拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                log.info("大编拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                log.info("小蔡拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                log.info("大蔡拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                log.info("小鲲拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                log.info("大鲲拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                log.info("小拉拧螺丝 + 1");
                count++;
            }
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                log.info("大拉拧螺丝 + 1");
                count++;
            }
        });

        threadPoolExecutor.shutdown();

        while (true) {
            if (threadPoolExecutor.isTerminated()) {
                log.info("=========== 合计：" + count);
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
}
