package org.example.grade.calculator;

import java.util.List;

public class GradeCalculator {
    private List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * 평균 학점 계산
     * @return (학점 수 * 교과목 평점) 합계 / 수강 신청 총 학점 수
     */
    public double calculate() {
        double sumScore = courses.stream()
                .mapToDouble(course -> course.getActualScore())
                .sum();

        int totalCourseScore = courses.stream()
                .mapToInt(Course::getScore)
                .sum();

        return  sumScore / totalCourseScore;
    }
}
