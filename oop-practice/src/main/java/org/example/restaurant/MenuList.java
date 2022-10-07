package org.example.restaurant;

import java.util.List;

/**
 * 메뉴 목록 (메뉴의 1급 컬렉션)
 */
public class MenuList {
    private List<MenuItem> menuItems;

    public MenuList(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem selectMenu(String name) {
        MenuItem selectMenu = menuItems.stream()
                .filter((menuItem) -> menuItem.isSelect(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wrong Memu Name"));

        return selectMenu;
    }
}
