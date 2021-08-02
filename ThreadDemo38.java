package thread_0802;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-08-02
 * Time: 21:39
 */
public class ThreadDemo38 {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程进入等待状态");
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
