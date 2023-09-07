package com.myapp.app.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
    private Util(){

    }

    /**
     * method yang digunakan untuk menggenerate nama file pada struk pembayaran
     * @return String
     */
    public static String getReceiptName(){
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        String formattedDateTime = currentDateTime.format(formatter);

        return "/home/"+formattedDateTime + " - Struk pembayaran.txt";
    }

    /**
     * Method recursive untuk meminta inputan dari user. Jika input user bukan angka (menimbulkan exception) maka akan kembali memanggil method ini hingga inputan benar
     * @return Integer inputan user
     */
    public static Integer inputUser(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("=> ");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Masukan pilihan yang tersedia!");
            return inputUser();
        }
    }

    /**
     * Method recursive untuk meminta inputan dari user. Jika input user bukan angka (menimbulkan exception) maka akan kembali memanggil method ini hingga inputan benar
     * @return Integer inputan user
     */
    public static Integer inputUserqTY(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("QTY=> ");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Masukan jumlah menu dengan angka!");
            return inputUser();
        }
    }
}
