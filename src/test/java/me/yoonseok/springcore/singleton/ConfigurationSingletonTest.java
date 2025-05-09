package me.yoonseok.springcore.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.yoonseok.springcore.AppConfig;
import me.yoonseok.springcore.member.MemberRepository;
import me.yoonseok.springcore.member.MemberServiceImpl;
import me.yoonseok.springcore.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

  @Test
  void cofigurationTest() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberServiceImpl memberService =ac.getBean("memberService", MemberServiceImpl.class);
    OrderServiceImpl orderService = ac.getBean("orderService",OrderServiceImpl.class);

    MemberRepository memberRepository1 = memberService.getMemberRepository();
    MemberRepository memberRepository2 = orderService.getMemberRepository();
    MemberRepository memberRepository = ac.getBean("memberRepository",MemberRepository.class);

    System.out.println("memberService -> memberRepository = " + memberRepository1);
    System.out.println("orderService -> memberRepository2 = " + memberRepository2);
    System.out.println("memberRepository = " + memberRepository);

    Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
    Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);

  }

  @Test
  void configurationDeep() {//스프링이 아무리 날고 기어도 java 코드까지 건드릴 수는 없다
    //그래서 바이트코드를 건드려
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);//
    // <- 여기서 AppConfig가 스프링 빈으로 등록된다

    AppConfig bean = ac.getBean(AppConfig.class);//AppConfig@CHLIB를 AppConfig로 업캐스팅

    System.out.println("bean = " + bean.getClass());

  }

}
