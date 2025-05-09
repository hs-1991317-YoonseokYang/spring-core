package me.yoonseok.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.yoonseok.springcore.member.Grade;
import me.yoonseok.springcore.member.Member;
import me.yoonseok.springcore.member.MemberService;
import me.yoonseok.springcore.order.Order;
import me.yoonseok.springcore.order.OrderService;

public class OrderApp {
  public static void main(String[] args) {

//    AppConfig appConfig = new AppConfig();
//    MemberService memberService = appConfig.memberService();
//    OrderService orderService = appConfig.orderService();

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

    Long memberId = 1L;
    Member member =new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 9000);

    System.out.println("order = " + order);
    System.out.println("order.calculatePrice = " + order.calculatePrice());

  }
}
