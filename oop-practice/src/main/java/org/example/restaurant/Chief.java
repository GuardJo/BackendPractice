package org.example.restaurant;

/**
 * 요리사
 */
public class Chief {

    public Food cook(MenuItem menuItem) {
        return new Food(menuItem.getName(), menuItem.getPrice());
    }
}
