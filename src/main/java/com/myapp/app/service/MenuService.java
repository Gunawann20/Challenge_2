package com.myapp.app.service;

import com.myapp.app.model.Menu;
import com.myapp.app.model.Order;
import com.myapp.app.repository.MenuRepository;
import java.util.Map;

public class MenuService implements Service{

    MenuRepository menuRepository = new MenuRepository();

    /**
     * Method untuk menambahkan menu yang diorder
     * @param menu menu yang diorder
     * @param qty jumlah yang diorder
     */
    @Override
    public void addOrderMenu(Menu menu, Integer qty) {
        Order order = new Order();
        order.setPrice(((long) menu.getPrice() * qty));
        order.setQuantity(qty);

        menuRepository.setMenuOrder(menu.getName(), order);
    }

    /**
     * Method untuk mendapatkan data menu yang diorder
     * @return Map
     */
    @Override
    public Map<String, Order> getOrderMenu() {
        return menuRepository.getMenuOrder();
    }

    /**
     * Method untuk menghitung total kuantitas menus yang dipesan dan total harga yang dipesan
     * @return array
     */
    @Override
    public Long[] countOrder() {
        Map<String, Order> orders = menuRepository.getMenuOrder();

        Long sumFoodCount = 0L;
        Long sumFoodPrice = 0L;

        for (Map.Entry<String, Order> entry: orders.entrySet()){
            Order order = entry.getValue();
            sumFoodCount += order.getQuantity();
            sumFoodPrice += order.getPrice();
        }
        return new Long[]{
                sumFoodCount, sumFoodPrice,
        };
    }

    /**
     * Method untuk mendapatkan data menu dari repository
     * @return array
     */
    @Override
    public Menu[] getMenus() {
        return menuRepository.getMenus();
    }
}
