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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "email",unique = true,nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="age",nullable = false)
    private Long age;

    private User(String email, String password, String name, Long age) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public static User of(String email, String password, String name, Long age) {
        return new User(email, password, name, age);
    }

    /*
    ToDo: 나중에 enum으로
    private String type;
    */
}
