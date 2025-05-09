package me.yoonseok.springcore.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import me.yoonseok.springcore.annotation.MainDiscountPolicy;
import me.yoonseok.springcore.member.Grade;
import me.yoonseok.springcore.member.Member;

@Component
//@Primary
//@Qualifier("mainDiscountPolicy")
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

  private int discountPrecent=10;

  //10% 할인 하는 로직은 실제로는 진짜 어렵습니다. 돈과 관련된 부분은 테스트를 정말 많이해요.(경계값 테스트?)
  //지금 프로젝트는 설계는 잘 되어 있어서 쉽게 테스트 했습니다.
  @Override
  public int discount(Member member, int price) {
    if(member.getGrade()== Grade.VIP){
      return price*discountPrecent/100;
    }
    else
      return 0;
  }
}
