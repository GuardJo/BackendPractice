package org.example.restaurant;

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
}
