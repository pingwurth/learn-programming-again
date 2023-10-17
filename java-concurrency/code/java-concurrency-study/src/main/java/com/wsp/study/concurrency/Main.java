package com.wsp.study.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 主启动类，运行示例都可以放在这里来做.
 * <p>
 *
 * @author ship
 * @date 2023/7/4 0004 8:00
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AtomicInteger i = new AtomicInteger();
        i.getAndAdd(0x61c88647);
        i.getAndAdd(0x61c88647);
        ThreadLocal tl1 = new ThreadLocal();
        ThreadLocal tl2 = new ThreadLocal();
        ThreadLocal tl3 = new ThreadLocal();
        ThreadLocal tl4 = new ThreadLocal();
        ThreadLocal tl5 = new ThreadLocal();
        ThreadLocal tl6 = new ThreadLocal();
        ThreadLocal tl7 = new ThreadLocal();
        ThreadLocal tl8 = new ThreadLocal();
        ThreadLocal tl9 = new ThreadLocal();
        ThreadLocal tl10 = new ThreadLocal();
        ThreadLocal tl11 = new ThreadLocal();
        ThreadLocal tl12 = new ThreadLocal();
        ThreadLocal tl13 = new ThreadLocal();
        ThreadLocal tl14 = new ThreadLocal();
        ThreadLocal tl15 = new ThreadLocal();
        ThreadLocal tl16 = new ThreadLocal();
        ThreadLocal tl17 = new ThreadLocal();
        ThreadLocal tl18 = new ThreadLocal();
        ThreadLocal tl19 = new ThreadLocal();
        ThreadLocal tl20 = new ThreadLocal();
        ThreadLocal tl21 = new ThreadLocal();
        if (false == true) {
            // \u000a\u007d\u007b
            System.out.println("true is false");
        }
    }
}
