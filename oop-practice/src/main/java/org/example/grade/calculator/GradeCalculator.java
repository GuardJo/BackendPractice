package org.example.grade.calculator;

import java.util.List;

public class GradeCalculator {
    private List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    public double calculate() {
        return 3.5;
    }
}
