package com.person;

public class Internal {
    public static void main(String[] args) {
        Person p = new Chinese();
        Person p2 = new American();
        p.say();
        p2.say();
    }
}
