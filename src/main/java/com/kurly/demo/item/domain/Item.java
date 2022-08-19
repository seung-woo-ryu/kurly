package com.kurly.demo.item.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="items")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Item {
    @Id
    @Column(name="id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name",unique = true,nullable = false)
    private String name;

    private Item(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item of(Long id, String name) {
        return new Item(id, name);
    }
}
