package com.myapp.app;

import com.myapp.app.controller.MenuController;
import com.myapp.app.model.Menu;
import com.myapp.app.util.Util;
import java.io.IOException;

public class App
{
    public static void main( String[] args ) {
        Menu[] menus = MenuController.getMenus();

        while (true){
            MenuController.showMenu();

            Integer pilihan = Util.inputUser();

            switch (pilihan){
                case 1:
                    MenuController.showDetailOrderMenu(menus[0]);
                    MenuController.addOrderMenu(menus[0]);
                    break;
                case 2:
                    MenuController.showDetailOrderMenu(menus[1]);
                    MenuController.addOrderMenu(menus[1]);
                    break;
                case 3:
                    MenuController.showDetailOrderMenu(menus[2]);
                    MenuController.addOrderMenu(menus[2]);
                    break;
                case 4:
                    MenuController.showDetailOrderMenu(menus[3]);
                    MenuController.addOrderMenu(menus[3]);
                    break;
                case 5:
                    MenuController.showDetailOrderMenu(menus[4]);
                    MenuController.addOrderMenu(menus[4]);
                    break;
                case 99:
                    MenuController.showAllOrderMenu();
                    Integer pilihan1 = Util.inputUser();

                    switch (pilihan1){
                        case 1:
                            String filename = Util.getReceiptName();
                            try {
                                MenuController.printStruk(filename);
                            } catch (IOException e) {
                                System.out.println("Terjadi kesalahan. Gagal mencetak struk pembayaran!");
                            }
                            return;
                        case 2:
                            break;
                        case 0:
                            return;
                        default:
                            System.out.println();
                            System.out.println("Pilihan tidak tersedia. Kembali ke menu utama..");
                    }
                    break;
                case 0:
                    System.out.println("Keluar aplikasi...");
                    return;
                default:
                    System.out.println();
                    System.out.println("Pilihan tidak tersedia!");
            }
        }
    }
}
