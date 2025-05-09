package me.yoonseok.springcore.order;

import org.junit.jupiter.api.Test;

import me.yoonseok.springcore.discount.FixDiscountPolicy;
import me.yoonseok.springcore.member.Grade;
import me.yoonseok.springcore.member.Member;
import me.yoonseok.springcore.member.MemoryMemberRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

  @Test
  void createOrder() {
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    memberRepository.save(new Member(1L, "name", Grade.VIP));


    OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());// 생성자가 아니라 설정자로 연관관계 주입하면
    // 이렇게 의존관계를 파악하기도 어렵다.
    Order order = orderService.createOrder(1L, "itemA", 10000);
    assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}