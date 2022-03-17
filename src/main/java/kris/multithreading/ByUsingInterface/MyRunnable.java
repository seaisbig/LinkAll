package kris.multithreading.ByUsingInterface;

public class MyRunnable implements Runnable{
    int j=20;
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+",j="+this.j--);
        }
    }
}
