package com.example.crudmysql.service;


import com.example.crudmysql.domain.Member;
import com.example.crudmysql.domain.Order;
import com.example.crudmysql.exception.NotExistMemberException;
import com.example.crudmysql.repositroy.MemberRepository;
import com.example.crudmysql.repositroy.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class OrderService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    OrderRepository orderRepository;

    public Long order(Long memberId, int count){
        // 회원정보 조회
        Optional<Member> member = memberRepository.findById(memberId);

        // 주문 생성
        if(!member.isPresent()) {
            throw new NotExistMemberException("회원정보가 없습니다.");
        }
        Order order = Order.createOrder(member.get());
        orderRepository.save(order);
        return order.getId(); // ID를 얻어온 다음에 해야할듯? ToDo : 엔티티 저장 후 ID 값 받아오는 로직 확인

    }
}
