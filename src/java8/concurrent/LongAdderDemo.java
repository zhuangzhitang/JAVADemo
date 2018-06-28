package java8.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author zhitang
 * @date 2018/6/28
 */
public class LongAdderDemo {
    private static final int MAX_THREADS =8;
    private static final int TASK_COUNT = 8;
    private static final int TARGET_COUNT = 100000000;

    private AtomicLong account = new AtomicLong(0L);
    private LongAdder lacount = new LongAdder();
    private long count =0;

    private static CountDownLatch cdlsync = new CountDownLatch(TASK_COUNT);
    private static CountDownLatch cdlatomic = new CountDownLatch(TASK_COUNT);
    private static CountDownLatch cdladdr = new CountDownLatch(TASK_COUNT);

    protected  synchronized  long inc(){
        return ++count;
    }

    protected  synchronized long getCount(){
        return count;
    }

    public class SyncThread  implements Runnable{
        protected  String name;
        private long startTime;
        LongAdderDemo out;

        public SyncThread (long startTime,LongAdderDemo out){
            this.startTime = startTime;
            this.out = out;
        }

        @Override
        public void run() {
            long v = out.getCount();
            while (v<TARGET_COUNT){
                v = out.inc();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("SyncThread spend:" + (endTime - startTime) + "ms" + " v" + v);
            cdlsync.countDown();
        }
    }
    public void testSync() throws InterruptedException {
        ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
        long starttime = System.currentTimeMillis();
        SyncThread sync = new SyncThread(starttime, this);
        for (int i = 0; i < TASK_COUNT; i++) {
            exe.submit(sync);
        }
        cdlsync.await();
        exe.shutdown();
    }

    public class AtomicThread implements Runnable {
        protected String name;
        protected long starttime;

        public AtomicThread(long starttime) {
            this.starttime = starttime;
        }

        @Override
        public void run() {
            long v = account.get();
            while (v < TARGET_COUNT) {
                v = account.incrementAndGet();
            }
            long endtime = System.currentTimeMillis();
            System.out.println("AtomicThread spend:" + (endtime - starttime) + "ms" + " v" + v);
            cdlatomic.countDown();
        }
    }

    public void testAtomic() throws InterruptedException {
        ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
        long starttime = System.currentTimeMillis();
        AtomicThread atomic = new AtomicThread(starttime);
        for (int i = 0; i < TASK_COUNT; i++) {
            exe.submit(atomic);
        }
        cdlatomic.await();
        exe.shutdown();
    }

    public class LongAdderThread implements Runnable {
        protected String name;
        protected long starttime;

        public LongAdderThread(long starttime) {
            this.starttime = starttime;
        }

        @Override
        public void run() {
            long v = lacount.sum();
            while (v < TARGET_COUNT) {
                lacount.increment();
                v = lacount.sum();
            }
            long endtime = System.currentTimeMillis();
            System.out.println("LongAdderThread spend:" + (endtime - starttime) + "ms" + " v" + v);
            cdladdr.countDown();
        }

    }

    public void testLongAdder() throws InterruptedException {
        ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
        long starttime = System.currentTimeMillis();
        LongAdderThread atomic = new LongAdderThread(starttime);
        for (int i = 0; i < TASK_COUNT; i++) {
            exe.submit(atomic);
        }
        cdladdr.await();
        exe.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        LongAdderDemo demo = new LongAdderDemo();
        demo.testSync();
        demo.testLongAdder();
        demo.testAtomic();

    }

}
