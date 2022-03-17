package kris.multithreading.ByExtendThread;

public class Multithriding extends Thread{
    int j = 20;
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(this.getName()+",i="+j--);
        }
    }
}
