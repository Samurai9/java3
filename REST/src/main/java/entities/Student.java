package entities;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private short course;
    private int id;


    public Student(String name, int age, short course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public Student(int id, String name, int age, short course) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public short getCourse() {
        return course;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                course == student.course &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, course);
    }
}
