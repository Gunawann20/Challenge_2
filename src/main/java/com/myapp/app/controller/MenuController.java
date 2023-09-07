package com.myapp.app.controller;

import com.myapp.app.model.Menu;
import com.myapp.app.model.Order;
import com.myapp.app.service.MenuService;
import com.myapp.app.service.Service;
import com.myapp.app.util.Util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class MenuController {

    private MenuController(){

    }
    private static final Service menuService = new MenuService();

    protected static final Menu[] menus = menuService.getMenus();

    public static Menu[] getMenus(){
        return menus;
    }

    /**
     * Method untuk menampilkan daftar menu
     */
    public static void showMenu(){
        System.out.println("============================");
        System.out.println(" Selamat datang di BinarFud");
        System.out.println("============================");
        System.out.println();
        System.out.println("Silahkan pilih makanan :");
        short i = 1;
        for (Menu menu: menus) {
            System.out.println(i+". "+menu.getName()+"   | "+ menu.getPrice());
            i++;
        }
        System.out.println("99. Pesan dan Bayar");
        System.out.println("0.  Keluar aplikasi");
    }

    /**
     * Method untuk menampilkan detail menu yang akan diorder
     * @param menu menu yang akan diorder
     */
    public static void showDetailOrderMenu(Menu menu){
        System.out.println("==========================");
        System.out.println("Berapa pesanan anda");
        System.out.println("==========================");
        System.out.println(menu.getName() + "   | " + menu.getPrice());
        System.out.println("(input 0 untuk kembali)");
    }

    /**
     * Method untuk mendapatkan jumlah dari menu yang akan diorder
     * @param menu menu yang akan diorder
     */
    public static void addOrderMenu(Menu menu){
        Integer quantity = Util.inputUserqTY();

        if (quantity > 0){
            menuService.addOrderMenu(menu, quantity);
        }
    }

    /**
     * Method untuk menampilkan semua menu yang telah diorder beserta total harga yang harus dibayar
     */
    public static void showAllOrderMenu(){
        Map<String, Order> orders = menuService.getOrderMenu();
        Long[] countOrder = menuService.countOrder();

        if (orders.isEmpty()){
            System.out.println("Silahkan order menu terlebih dahulu!");
        }else {
            System.out.println("================================");
            System.out.println("Konfirmasi dan Pembayaran");
            System.out.println("================================");
            System.out.println();

            for (Map.Entry<String, Order> entry: orders.entrySet()) {
                Order order = entry.getValue();
                System.out.println(entry.getKey() + "  " + order.getQuantity() + "  " + order.getPrice());
            }
            System.out.println("-----------------------------+");
            System.out.println("Total"+"           "+countOrder[0]+"  "+countOrder[1]);

            System.out.println();
            System.out.println("1. Konfirmasi dan Bayar");
            System.out.println("2. Kembali ke menu utama");
            System.out.println("0. Keluar aplikasi");
        }
    }

    /**
     * Method untuk mencetak struk pembayaran
     * @param fileName nama file atau lokasi directory file berupa string
     */
    public static void printStruk(String fileName) throws IOException {
        Map<String, Order> orders = menuService.getOrderMenu();
        Long[] countOrder = menuService.countOrder();
        File file = new File(fileName);
        if (file.createNewFile()){
            System.out.println("Mencetak struk pembayaran....");
            System.out.println("Struk pembayaran berhasil dicetak.");
        }
        try(FileWriter writer = new FileWriter(file);
            BufferedWriter bwr = new BufferedWriter(writer)) {

            bwr.write("========================================\n");
            bwr.write("BinarFud\n");
            bwr.write("========================================\n\n");
            bwr.write("Terima kasih sudah memesan di BinarFud\n\n");
            bwr.write("Dibawah ini adalah pesanan anda\n\n");
            for (Map.Entry<String, Order> entry: orders.entrySet()){
                Order order = entry.getValue();
                bwr.write(entry.getKey()+ "  " + order.getQuantity()+ "  "+ order.getPrice()+"\n");
            }
            bwr.write("----------------------------------------+\n");
            bwr.write("Total"+"           "+countOrder[0]+"  "+countOrder[1]+"\n\n\n");
            bwr.write("Pembayaran: BinarCash\n");
            bwr.write("Simpan struk ini sebagai bukti pembayaran\n");
            bwr.write("========================================");
            bwr.flush();
        }catch (IOException e){
            System.out.println("Terjadi kesalahan. Gagal mencetak struk pembayaran!");
        }
    }
}
