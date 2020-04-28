package net.javaguides.springboot.tutorial.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "t_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, message = "Не меньше 5 знаков")
    private String username;
    @Size(min = 2, message = "Не меньше 5 знаков")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "serName")
    private String serName;

    public User() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSerName() {
        return serName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
