package me.yoonseok.springcore.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.yoonseok.springcore.AutoAppConfig;
import me.yoonseok.springcore.member.MemberRepository;
import me.yoonseok.springcore.member.MemberService;
import me.yoonseok.springcore.order.OrderServiceImpl;

public class AutoAppConfiTest {

  @Test
  void basicScan() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    MemberService memberService = ac.getBean(MemberService.class);
    Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

      OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
    MemberRepository memberRepository = bean.getMemberRepository();
    System.out.println("memberRepository = "+ memberRepository);
  }
}
