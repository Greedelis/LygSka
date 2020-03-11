package app;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * Barrier
 */
public class Barrier {
    private int n; // number of threads
    private int calledThreads;
    private int sum;
    private int calls;

    public Barrier(int n){
        this.n = n;
        this.calledThreads = 0;
        sum = 0;
    }
    public synchronized int waitBarrier(int reiksme) throws InterruptedException{
        calledThreads++;
        sum+=reiksme;
        if(calledThreads != n){
            wait();
        }
        else{
            notifyAll();
            calls = n;
            calledThreads = 0;
        }
        calls--;
        if (calls !=0){
            wait();
        }else{
            notifyAll();
        }
        return sum;
    } 
}