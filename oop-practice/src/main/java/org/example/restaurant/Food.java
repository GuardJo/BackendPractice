package org.example.restaurant;

import java.util.Objects;

/**
 * 식당 요리
 */
public class Food {
    private String name;
    private int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return price == food.price && Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
