package thread_0802;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-08-02
 * Time: 17:08
 */
public class ThreadDemo36 {
    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA){
                    System.out.println("线程1获取到锁A");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1尝试获取锁B");
                    synchronized (lockB){
                        System.out.println("线程1获取到锁B");
                    }
                }
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB){
                    System.out.println("线程2获取到锁B");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2尝试获取锁A");
                    synchronized (lockA){
                        System.out.println("线程2获取到锁A");
                    }
                }
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
