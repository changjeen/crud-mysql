package com.example.crudmysql.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS", catalog = "test")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    // 주문 회원
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    // 주문 상세

    // 배송정보

    // 주문시간
    private Date orderDate;

    // 주문 상태
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // 주문 생성
    public static Order createOrder(Member member) {
        Order order = new Order();
        order.setMember(member);
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(new Date());
        return order;
    }

    public void setMember(Member member) {
        //기존 관계 제거
        if (this.member != null) {
            this.member.getOrders().remove(this);
        }
        this.member = member;
        member.getOrders().add(this);
    }

    /*
        Getter , Setter
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
