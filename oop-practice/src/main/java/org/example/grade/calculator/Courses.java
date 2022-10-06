package org.example.grade.calculator;

import java.util.List;

public class Courses {
    private List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double sumScore() {
        return courses.stream()
                .mapToDouble(course -> course.getActualScore())
                .sum();
    }

    public int totalCourseScore() {
        return courses.stream()
                .mapToInt(Course::getScore)
                .sum();
    }
}
