package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University{
    private String name;

    private int age;

    private List<Student> students = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student studentWithMaxAvgGr = students.get(0);
        for (Student student : students) {
            if (student.getAverageGrade() > studentWithMaxAvgGr.getAverageGrade()) studentWithMaxAvgGr = student;
        }
        return studentWithMaxAvgGr;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Student studentWithMinAvgGr = students.get(0);
        for (Student student : students) {
            if (student.getAverageGrade() < studentWithMinAvgGr.getAverageGrade()) studentWithMinAvgGr = student;
        }
        return studentWithMinAvgGr;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}