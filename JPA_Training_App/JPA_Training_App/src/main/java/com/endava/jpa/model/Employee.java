package com.endava.jpa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by btesila on 5/16/2014.
 */

@NamedQuery(name = "findEmployeesByCity",
        query = "Select e from Employee e where e.address.city = :city")

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private int id;

    private String name;
    private double salary;
    private Date birthday;

    @Embedded
    private Address address;

    @ManyToOne
    private Department department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", address=" + address +
                ", department=" + department +
                '}';
    }


}

