package org.example.restaurant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class MenuListTest {
    @DisplayName("메뉴 목록에 있는 메뉴 선택 시 해당 메뉴 반환 테스트")
    @Test
    public void testSelectMenu() {
        List<MenuItem> menuItems = List.of(
                new MenuItem("탕수육", 20000),
                new MenuItem("짜장면", 8000)
        );

        MenuList menuList = new MenuList(menuItems);
        MenuItem selectMenuItem = menuList.selectMenu("탕수육");

        assertThat(selectMenuItem).isEqualTo(new MenuItem("탕수육", 20000));
    }
    
    @DisplayName("메뉴 목록에 없는 메뉴 선택 시 IllegalArgumentException 반환 테스트")
    @Test
    public void testExceptionSelectMenu() {
        List<MenuItem> menuItems = List.of(
                new MenuItem("탕수육", 20000),
                new MenuItem("짜장면", 8000)
        );

        MenuList menuList = new MenuList(menuItems);

        assertThatCode(() -> menuList.selectMenu("짬뽕"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Wrong Memu Name");
    }
}
