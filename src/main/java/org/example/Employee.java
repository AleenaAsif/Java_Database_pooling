package org.example;

public class Employee {

    private int id;
    private String name;
    private String job;
    private double salary;

    public Employee() {

    }

    public Employee(int id, String name, String job, double salary) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setJob(String job) {
        this.job=job;
    }

    public String getJob(){
        return job;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }
}



