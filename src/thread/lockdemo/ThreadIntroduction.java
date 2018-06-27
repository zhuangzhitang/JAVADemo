package thread.lockdemo;

public class ThreadIntroduction {

    public static void main(String[] args) {
        for (int index = 0 ; index < 3; index++){
            MyThread temp = new MyThread();
            temp.start();
        }
    }
}
class MyThread extends Thread{
    public void run(){
        for(int i = 0 ; i <5 ;i++){
            System.out.println(Thread.currentThread().getName()+":["+i+"]");
        }
    }
}
