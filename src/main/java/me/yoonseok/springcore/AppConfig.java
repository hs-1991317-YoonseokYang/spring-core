package me.yoonseok.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.yoonseok.springcore.discount.DiscountPolicy;
import me.yoonseok.springcore.discount.RateDiscountPolicy;
import me.yoonseok.springcore.member.MemberService;
import me.yoonseok.springcore.member.MemberServiceImpl;
import me.yoonseok.springcore.member.MemoryMemberRepository;
import me.yoonseok.springcore.order.OrderService;
import me.yoonseok.springcore.order.OrderServiceImpl;

@Configuration
public class AppConfig {//이로써!! 생성과 실행의 역할이 구분 되었다~

  @Bean
  public MemoryMemberRepository memberRepository() {
    System.out.println("call AppConfig.memberRepository");
    return new MemoryMemberRepository();
  }

  @Bean
  public DiscountPolicy discountPolicy(){
//    System.out.println("AppConfig.discountPolicy");
    return new RateDiscountPolicy();
  }

  @Bean
  public MemberService memberService() {
    System.out.println("call AppConfig.memberService");
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public OrderService orderService(){
    System.out.println("call AppConfig.orderService");

    return new OrderServiceImpl(memberRepository(), discountPolicy());
//    return null;
  }


}
