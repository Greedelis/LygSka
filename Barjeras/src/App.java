import java.util.Scanner;

import app.Barrier;
import app.MyThread;

/*
*Author: Andrius Bagaliūnas
*Informatika
*3 kursas
*4 grupė
*
*Užduotis:
*0*. Barjeras - su duomenų apsikeitimu
*Objektas inicializuojamas "sąveikoje" dalyvaujančių gijų skaiciumi (N).
*Pagrindinė operacija -
*    int  waitBarier(int reikšmė).
*Kiekviena šį metodą iškvietusi giją laukia, kol kvietėjų skaičius taps lygus N.
*Tada visos N gijos "paleidžiamos" - metodas gražina asociatyvios operacijos (pvz. sumos)
*su visomis "reikšmėmis" rezultatą - o barjeras reinicializuojamas, t.y., paruošiamas
*sekančiam waitBarier() kvietiniui.
*/



public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the number of threads: ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        Barrier barrier = new Barrier(num);
        MyThread[] threads;
        threads = new MyThread[num];

        for(int i = 0; i < num; i++){
            threads[i] = new MyThread(barrier);
            threads[i].start();
        } 
        for(int i = 0; i < num; i++){
            threads[i].join();
        }
       
        /* MyThread t1 = new MyThread(barrier);
        MyThread t2 = new MyThread(barrier);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        */

    }
}

