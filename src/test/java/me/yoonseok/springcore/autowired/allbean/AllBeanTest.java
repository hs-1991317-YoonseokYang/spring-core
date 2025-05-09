package me.yoonseok.springcore.autowired.allbean;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import me.yoonseok.springcore.AutoAppConfig;
import me.yoonseok.springcore.discount.DiscountPolicy;
import me.yoonseok.springcore.member.Grade;
import me.yoonseok.springcore.member.Member;

public class AllBeanTest {

  @Test
  void findAllBean() {//다형성 코드를 만들 수 있당께
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

    DiscountService discountService = ac.getBean(DiscountService.class);
    Member member = new Member(1L, "userA", Grade.VIP);
    int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");

    Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
    Assertions.assertThat(discountPrice).isEqualTo(1000);

    int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");
    Assertions.assertThat(rateDiscountPrice).isEqualTo(2000);

  }


  static class DiscountService {
    private final Map<String, DiscountPolicy> policyMap;
    private final List<DiscountPolicy> policies;

    @Autowired // 이렇게 Map과 List로 Bean을 받을 수 있다!!! <- component가 안 붙어 있어서 빨간 줄 but 위에서 수동으로 등록하죠잉
    public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
      this.policyMap=policyMap;
      this.policies=policies;
      System.out.println("policyMap = " + policyMap);
      System.out.println("policies = " + policies);
    }

    public int discount(Member member, int price, String discountCode){
      DiscountPolicy discountPolicy = policyMap.get(discountCode);//ㅇㅎ
      return discountPolicy.discount(member, price);
    }


  }
}
