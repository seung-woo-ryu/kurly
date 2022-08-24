package com.kurly.demo.user.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
public class User {

    @Id
    @Column(name="id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email",unique = true,nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="age",nullable = false)
    private Long age;

    @Column(name = "role", nullable = false)
    private Role role;

    private User(String email, String password, String name, Long age,Role role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public static User of(String email, String password, String name, Long age,Role role) {
        return new User(email, password, name, age,role);
    }

    /*
    ToDo: 나중에 enum으로
    private String type;
    */
}
