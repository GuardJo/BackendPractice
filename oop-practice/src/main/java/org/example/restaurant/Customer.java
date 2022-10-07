package org.example.restaurant;

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void order(String orderMenuName, MenuList menuList, Chief chief) {
        MenuItem menuItem = menuList.selectMenu(orderMenuName);
        chief.cook(menuItem);
    }
}
