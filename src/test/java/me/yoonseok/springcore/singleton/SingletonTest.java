package me.yoonseok.springcore.singleton;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.yoonseok.springcore.AppConfig;
import me.yoonseok.springcore.member.MemberService;

public class SingletonTest {

  @Test
  @DisplayName("스프링 없는 순수한 DI 컨테이너")
  void pureContiner(){
    AppConfig appConfig = new AppConfig();
    //1. 조회: 호출할 때 마다 객체를 생성
    MemberService memberService1 = appConfig.memberService();
    //2. 조회: 호출할 때 마다 객체를 생성
    MemberService memberService2 = appConfig.memberService();

    //참조값이 다른 것을 확인
    System.out.println("memberService1 = " + memberService1);
    System.out.println("memberService2 = " + memberService2);

    Assertions.assertThat(memberService1).isNotSameAs(memberService2);
  }

  @Test
  @DisplayName("싱글톤 패턴을 적용한 객체 사용")
  void singletonServiceTest() {
     SingleTonService singleTonService1 = SingleTonService.getInstance();
     SingleTonService singleTonService2 = SingleTonService.getInstance();

    Assertions.assertThat(singleTonService1).isSameAs(singleTonService2);
    System.out.println("singleTonService1 = " + singleTonService1);
    System.out.println("singleTonService2 = " + singleTonService2);
  }


    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
      AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
      //1. 조회: 호출할 때 마다 객체를 생성
      MemberService memberService1 = ac.getBean("memberService",MemberService.class);
      //2. 조회: 호출할 때 마다 객체를 생성
      MemberService memberService2 = ac.getBean("memberService",MemberService.class);

      //참조값이 다른 것을 확인
      System.out.println("memberService1 = " + memberService1);
      System.out.println("memberService2 = " + memberService2);

      Assertions.assertThat(memberService1).isSameAs(memberService2);
    }

}
