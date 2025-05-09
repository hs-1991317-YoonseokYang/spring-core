package me.yoonseok.springcore.order;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import me.yoonseok.springcore.AppConfig;
import me.yoonseok.springcore.member.Grade;
import me.yoonseok.springcore.member.Member;
import me.yoonseok.springcore.member.MemberService;

//단위테스트를 잘 만드는게 정말 중요합니다!! 빠르거덩요
// 스프링이나 컨테이너 도움 없이 순수한 자바로 테스트하는 것을 단위테스트라 하겠음
public class OrderServiceTest {


  @BeforeEach
  public void beforeEach(){
    AppConfig appConfig= new AppConfig();
    memberService=appConfig.memberService();
    orderService=appConfig.orderService();
  }

  MemberService memberService;
  OrderService orderService;

  @Test
  void createOrder(){
    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId,"itemA", 10000);
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }

//  @Test
//  void fieldInjectionTest(){
//    OrderServiceImpl orderService = new OrderServiceImpl();
//    orderService.createOrder(1L,"itemA",10000);
//  }
}
