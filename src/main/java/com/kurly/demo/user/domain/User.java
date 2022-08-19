package com.kurly.demo.user.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
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

    /*
    ToDo: 나중에 enum으로
    private String type;
    */
}
