package me.yoonseok.springcore.beanfind;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.yoonseok.springcore.AppConfig;
import me.yoonseok.springcore.member.MemberService;
import me.yoonseok.springcore.member.MemberServiceImpl;

public class ApplicationContextBasicFindTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("빈 이름으로 조회")
  void findBeanByName(){
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("이름 없이 타입으로 조회")
  void findBeanByType(){
    MemberService memberService = ac.getBean(MemberService.class);
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("구체 타입으로 조회")
  void findBeanByName2(){//하지만 이렇게 구체적으로 만들면 안 좋아요.
    //역할과 구현을 구분해야한다. 역할에 의존해야한다.
    MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("빈 이름으로 조회 x")
  void findBeanByNameX(){//하지만 이렇게 구체적으로 만들면 안 좋아요.
    //역할과 구현을 구분해야한다. 역할에 의존해야한다.
//    MemberService memberService = ;
//    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    Assertions.assertThrows(NoSuchBeanDefinitionException.class,()->ac.getBean("xxx", MemberService.class));
  }

}
