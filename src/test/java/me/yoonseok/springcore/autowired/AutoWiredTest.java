package me.yoonseok.springcore.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

import jakarta.annotation.Nullable;
import me.yoonseok.springcore.member.Member;

public class AutoWiredTest {

  @Test
  void AutoWiredOption() {//이건 스프링부트 테스트가 아니니까 이렇게 하겠네 음음
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
  }

  static class TestBean {

    @Autowired(required = false)
    public void setNoBean1(Member noBean1){
        System.out.println("noBean1 = " + noBean1);
    }

    @Autowired
    public void setNoBean2(@Nullable Member noBean2) {
      System.out.println("noBean2 = "+ noBean2);
    }

    @Autowired
    public void setNoBean3(Optional<Member> noBean3){
      System.out.println("noBean3 = " + noBean3);
    }


  }

}
