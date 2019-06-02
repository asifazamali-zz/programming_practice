package com.practice.programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private String Loc;
    private int salary;
    public int getId() {
        return id;
    }


    public static Comparator<Employee> salaryComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.salary - o2.salary;
        }
    };


    @Override
    public boolean equals(Object o) {
        System.out.println("equals called");
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return (getId()== employee.getId());
        //if (getSalary() != employee.getSalary()) return false;
        //if (getName() != null ? !getName().equals(employee.getName()) : employee.getName() != null) return false;
        //return getLoc() != null ? getLoc(.equals(employee.getLoc()) : employee.getLoc() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        //result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        //result = 31 * result + (getLoc() != null ? getLoc().hashCode() : 0);
        //result = 31 * result + getSalary();
        return result;
    }

    private void setId(int id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return Loc;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }

    public Employee(int id, String name, String loc, int salary) {
        this.id = id;
        this.name = name;
        Loc = loc;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Loc='" + Loc + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "asif", "blr", 1300);
        Employee emp2 = new Employee(2, "a", "blr", 1400);
        Employee emp3 = new Employee(3, "b", "lko", 1500);
        Employee emp4 = new Employee(4, "c", "raj", 1100);
        Employee emp5 = new Employee(1, "d", "blr", 1000);

        Employee[] employees = {emp1, emp2, emp3, emp5, emp4};
        Arrays.sort(employees);
        for(Employee emp : employees)
            System.out.println(emp);
        System.out.println();
        Arrays.sort(employees, Employee.salaryComparator);
        for(Employee emp : employees)
            System.out.println(emp);
        System.out.println();
        Arrays.sort(employees, Comparator.comparing(Employee::getName));
        for(Employee emp : employees)
            System.out.println(emp);
        System.out.println();

        HashSet<Employee> hashSet = new HashSet<>();
        for(Employee emp: employees)
            hashSet.add(emp);
        System.out.println(hashSet);

    }


    @Override
    public int compareTo(Employee o) {
        return this.id - o.id;
    }
}
