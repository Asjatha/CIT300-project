package model;

public class Patient {
    public int id;
    public String name;
    public int age;
    public String contact;
    public String condition;

    public Patient(int id, String name, int age, String contact, String condition) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.condition = condition;
    }

    public String toString() {
        return id + " | " + name + " | " + age + " | " + contact + " | " + condition;
    }
}