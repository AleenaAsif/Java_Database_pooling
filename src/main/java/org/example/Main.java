package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.setName("Aleena");
        emp1.setJob("Software Engineer");
        emp1.setSalary(150000.0);

        Employee emp2 = new Employee();
        emp2.setName("Aleena2");
        emp2.setJob("Data Analyst");
        emp2.setSalary(120000.0);

        Employee emp3 = new Employee();
        emp3.setName("Aleena3");
        emp3.setJob("HR Manager");
        emp3.setSalary(180000.0);

        try {

            DBConnection.addEmployee(emp1);
            DBConnection.addEmployee(emp2);
            DBConnection.addEmployee(emp3);
            System.out.println("Three employees created successfully.");

            Employee retrievedEmployee1 = DBConnection.getEmployee(1);
            Employee retrievedEmployee2 = DBConnection.getEmployee(2);
            Employee retrievedEmployee3 = DBConnection.getEmployee(3);

            if (retrievedEmployee1 != null) {
                System.out.println("Retrieved employee 1: " + retrievedEmployee1.getName());
            } else {
                System.out.println("Employee 1 not found.");
            }
            if (retrievedEmployee2 != null) {
                System.out.println("Retrieved employee 2: " + retrievedEmployee2.getName());
            } else {
                System.out.println("Employee 2 not found.");
            }
            if (retrievedEmployee3 != null) {
                System.out.println("Retrieved employee 3: " + retrievedEmployee3.getName());
            } else {
                System.out.println("Employee 3 not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
