package com.wh.pojo;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

public class Teachers {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;
  private String name;
  private Integer age;
  @Transient
  private List<Students> students;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public List<Students> getStudents() {
    return students;
  }

  public void setStudents(List<Students> students) {
    this.students = students;
  }

  @Override
  public String toString() {
    return "Teachers{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", students=" + students +
            '}';
  }
}
