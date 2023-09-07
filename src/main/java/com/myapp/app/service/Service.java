package com.myapp.app.service;

import com.myapp.app.model.Menu;
import com.myapp.app.model.Order;

import java.util.Map;

public interface Service {
    void addOrderMenu(Menu menu, Integer qty);
    Map<String, Order> getOrderMenu();
    Long[] countOrder();
    Menu[] getMenus();
}
