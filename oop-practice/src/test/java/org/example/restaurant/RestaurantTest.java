package org.example.restaurant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 식당
 * 음식 주문 과정 테스트
 * 요구 사항
 * 1. 도메인 구성
 *  - 손님, 메뉴, 요리사, 요리
 * 2. 객체 관계 정의
 *  - 손님 --> 메뉴
 *  - 손님 --> 요리사
 *  - 요리사 --> 요리
 * 3. 도메인 모델링 (동적인 객체들을 정적 객체로 정의)
 *  - 메뉴들 (동적 객체 : 떡볶이, 탕수육 등) --> 메뉴 타입 (정적 객체)
 *  - 요리들 (동적 객체 : 메뉴와 동일함) --> 요리 타입 (정적 객체)
 *  - 손님들 (동적 객체 : 남, 녀 , 노, 소 등) --> 손님 타입 (정적 객체
 * 4. 협력 셜계
 * 5. 객체들을 포괄하는 적절한 책임 할당
 * 6. 구현
 */
public class RestaurantTest {
    @DisplayName("식당에 방문한 손님 생성 테스트")
    @Test
    public void testCreateCustomer() {
        assertThatCode(() -> new Customer("아무개"))
                .doesNotThrowAnyException();
    }

    @DisplayName("메뉴항목에 존재하는 메뉴 주문 테스트")
    @Test
    public void testOrder() {
        List<MenuItem> menuItems = List.of(
                new MenuItem("탕수육", 20000),
                new MenuItem("짜장면", 8000)
        );
        MenuList menuList = new MenuList(menuItems);
        Customer customer = new Customer("아무개");

        assertThatCode(() -> customer.order("탕수육", menuList, new Chief()))
                .doesNotThrowAnyException();
    }
}
