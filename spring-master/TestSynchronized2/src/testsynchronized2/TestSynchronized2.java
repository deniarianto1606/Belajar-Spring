/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsynchronized2;

import synchronizedapi.SynchronizedAPI;

/**
 *
 * @author DeNiSa
 */
public class TestSynchronized2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String test = SynchronizedAPI.generatedNumber();
        Thread readBalanceInitialThread = new Thread(test);

        readBalanceInitialThread.start();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
