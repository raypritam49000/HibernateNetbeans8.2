package com.hibernate.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Employee implements Serializable {

  @Id
  @GeneratedValue
  private long id;
  private String name;
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Task> tasks;

    public Employee() {
    }

    public Employee(String name, List<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", tasks=" + tasks + '}';
    }
}