package org.example.exceptions.exo4;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) throws InvalidAgeException {
        if(age < 0) throw new InvalidAgeException("L'age ne peut pas être négatif.");
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.age + " ans";
    }
}
