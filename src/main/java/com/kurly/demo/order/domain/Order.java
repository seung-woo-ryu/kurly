package com.kurly.demo.order.domain;

import com.kurly.demo.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
public class Order {
    @Id
    @Column(name="id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "delivery_man_id", referencedColumnName = "id")
    private User deliveryUser;

    @Column(name = "image_url",unique = true)
    private String imageUrl;
    @Column(name = "address",unique = false,nullable = false)
    private String address;
    @Column(name = "request_information", unique = false, nullable = false)
    private String requestInformation;
    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted;

    private Order(User user, String imageUrl, String address,String requestInformation, boolean isCompleted,User deliveryUser) {
        this.user = user;
        this.imageUrl = imageUrl;
        this.address = address;
        this.requestInformation = requestInformation;
        this.isCompleted = isCompleted;
        this.deliveryUser = deliveryUser;
    }

    public static Order of(User user, String imageUrl, String address,String requestInformation, boolean isCompleted,User deliveryUser) {
        return new Order(user, imageUrl, address,requestInformation, isCompleted,deliveryUser);
    }
}
