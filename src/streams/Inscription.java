package streams;

import java.math.BigDecimal;

public class Inscription {
    private Long year;
    private String course;
    private String student;
    private Double calification;

    public Inscription(Long year, String course, String student, Double calification) {
        this.year=year;
        this.course = course;
        this.student = student;
        this.calification = calification;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Double getCalification() {
        return calification;
    }

    public void setCalification(Double calification) {
        this.calification = calification;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }
}
