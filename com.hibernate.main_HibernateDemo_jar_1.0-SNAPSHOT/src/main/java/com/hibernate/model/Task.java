package com.hibernate.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task implements Serializable {
  @Id
  @GeneratedValue
  private long id;
  private String description;
  private String supervisor;

  public Task() {
  }

    public Task(String description, String supervisor) {
        this.description = description;
        this.supervisor = supervisor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", description=" + description + ", supervisor=" + supervisor + '}';
    }
    
    
   
}

