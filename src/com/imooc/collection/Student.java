package com.imooc.collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 学生类
 */

public class Student {
    private String id;
    private String name;
    private Set courses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new HashSet();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set getCourses() {
        return courses;
    }
}
