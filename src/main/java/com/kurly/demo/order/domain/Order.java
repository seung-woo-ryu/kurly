package com.kurly.demo.order.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Order {
    @Id
    @Column(name="id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "email",unique = true,nullable = false)
    private String email;
    @Column(name = "image_url",unique = true)
    private String imageUrl;
    @Column(name = "address",unique = true,nullable = false)
    private String address;
    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted;
}
