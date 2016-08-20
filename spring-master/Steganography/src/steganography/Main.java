/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

/**
 *
 * @author DeNiSa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //byte
        String a = "Kamilah Zahra Abqori";
        byte[] byteA = a.getBytes();
        for (byte c : byteA) {
            System.out.print(c + " - ");
        }
        System.out.println("");
        String decrypt = new String(byteA);
        System.out.println(decrypt);
        System.out.println("");
        // TODO code application logic here
        Steganography steganography = new Steganography();
        //steganography.encode("D:/Data/", "3840x2160-green_trees_road-7924", "jpg", "cihuy", "Kamilah Zahra Abqori");
        
        String decode = steganography.decode("D:/Data/", "cihuy");
        System.out.println(decode);
    }
    
}
