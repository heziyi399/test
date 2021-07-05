package ch1;

public class Thread2 implements Runnable {
    static int num = 0;
    @Override
    public void run(){
        for(int i=0;i<4;i++) {
            System.out.println(num);
            for (int j = 0; j <= 6; j++) {
                if (j == 5) {
                    try {
                        num++;
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
             //   System.out.println(Thread.currentThread().getName() + "[" + j + "]");

                notify();

            }
        }
    }

    public static void main(String[]args){
        Thread new1 = new Thread(new Main());
        Thread new2 = new Thread(new Main());
        new1.start();
        new2.start();
    }

}
