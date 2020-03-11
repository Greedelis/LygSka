package app;
/**
 * MyThread
 */
public class MyThread extends Thread{
    private Barrier barrier;

    public MyThread(Barrier barrier){
        this.barrier = barrier;
    }


    public void run(){
        try{
            for(int i = 0; i < 10; i ++){
                System.out.println("Sum is: "+this.barrier.waitBarrier(1));
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
}