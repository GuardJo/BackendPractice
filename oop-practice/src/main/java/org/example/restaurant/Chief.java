package org.example.restaurant;

public class Chief {

    public Food cook(MenuItem menuItem) {
        return new Food(menuItem.getName(), menuItem.getPrice());
    }
}
