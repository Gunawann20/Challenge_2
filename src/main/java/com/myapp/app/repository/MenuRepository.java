package com.myapp.app.repository;

import com.myapp.app.model.Menu;
import com.myapp.app.model.Order;
import java.util.HashMap;
import java.util.Map;

public class MenuRepository {
    private final Map<String, Order> menuOrder;
    private final Menu[] menus = {
            new Menu("Nasi Goreng   ", 15_000),
            new Menu("Mie Goreng    ", 13_000),
            new Menu("Nasi + Ayam   ", 18_000),
            new Menu("Es teh Manis  ", 3_000),
            new Menu("Es Jeruk      ", 5_000),
    };

    public MenuRepository(){
        this.menuOrder = new HashMap<>();
    }

    public void setMenuOrder(String foodName, Order order){
        menuOrder.put(foodName, order);
    }

    public Map<String, Order> getMenuOrder() {
        return menuOrder;
    }

    public Menu[] getMenus() {
        return menus;
    }
}
