package org.example.grade.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GradeCalculatorTest {
    // 학점 계산기 구조
    // 필요 도메인 : 이수 과목, 학점 계산기
    // 시나리오
    // 학점 계산 요청 --> 학점 계산기 --> 과목

    @DisplayName("평균 학점 계산")
    @Test
    public void testCalculateGrade() {
        List<Course> courses = List.of(
                new Course("객체지향프로그래밍", 3, "B+"),
                new Course("컴퓨터개론", 3, "B+")
        );

        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        double gradeAvg = gradeCalculator.calculate();

        assertThat(gradeAvg).isEqualTo(3.5);
    }
}
