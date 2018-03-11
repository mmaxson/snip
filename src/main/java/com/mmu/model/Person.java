package com.mmu.model;

import java.util.Objects;

public class Person {
    private String lastName;
    private String firstName;
    private int age;


    public Person(String lastName, String firstName, int age) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public String getLastName() {

        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                Objects.equals(getLastName(), person.getLastName()) &&
                Objects.equals(getFirstName(), person.getFirstName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLastName(), getFirstName(), getAge());
    }
}
