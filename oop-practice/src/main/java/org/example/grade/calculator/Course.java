package org.example.grade.calculator;

public class Course {
    private String subject;
    private int score;
    private String grade;

    public Course(String subject, int score, String grade) {
        this.subject = subject;
        this.score = score;
        this.grade = grade;
    }

    public double getNumberOfGrade() {
        double numberOfGrade = 0.0;

        switch (this.grade) {
            case "A+":
                numberOfGrade = 4.5;
                break;
            case "A":
                numberOfGrade = 4.0;
                break;
            case "B+":
                numberOfGrade = 3.5;
                break;
            case "B":
                numberOfGrade = 3.0;
                break;
            case "C+":
                numberOfGrade = 2.5;
                break;
            case "C":
                numberOfGrade = 2.0;
                break;
            case "D":
                numberOfGrade = 1.5;
                break;
            default:
                numberOfGrade = 0;
        }

        return numberOfGrade;
    }

    public int getScore() {
        return this.score;
    }

    public double getActualScore() {
        return this.score * getNumberOfGrade();
    }
}
