/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synchronizedapi;

/**
 *
 * @author DeNiSa
 */
public class SynchronizedAPI {

    public synchronized static String generatedNumber(){
        System.out.println("mulai dieksekusi");
        Thread readBalanceInitialThread = new Thread();

        readBalanceInitialThread.start();
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("selesai dieksekusi");
        return "success";
    }
}
