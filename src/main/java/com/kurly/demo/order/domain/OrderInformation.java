package com.kurly.demo.order.domain;

import com.kurly.demo.item.domain.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "order_informations")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
public class OrderInformation {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    @Column(name="quantity", nullable = false)
    private Long quantity;

    private OrderInformation(Order order, Item item,Long quantity) {
        this.order = order;
        this.item = item;
        this.quantity = quantity;
    }

    public static OrderInformation of(Order order, Item item,Long quantity) {
        return new OrderInformation(order, item,quantity);
    }
}
