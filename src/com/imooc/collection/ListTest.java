package com.imooc.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 备选课程类
 */
public class ListTest {
    /**
     * 用于存放备选课程的List
     */
    private List coursesToSelect;

    public ListTest() {
        this.coursesToSelect = new ArrayList();
    }
    public void testAdd(){
        // 创建一个课程对象，并通过调用add方法，添加到备选课程List中
        Course cr1 = new Course("1", "数据结构");
        coursesToSelect.add(cr1);
        Course temp = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程：" + temp.getId() + ":" + temp.getName());
    }
    public static void main(String[] args) {
        ListTest lt = new ListTest();
        lt.testAdd();
    }
}
