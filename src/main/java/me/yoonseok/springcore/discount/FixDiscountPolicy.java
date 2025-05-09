package me.yoonseok.springcore.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import me.yoonseok.springcore.member.Grade;
import me.yoonseok.springcore.member.Member;

@Component
//@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy{

  private int discountFixAmount = 1000;


  @Override
  public int discount(Member member, int price) {
    if(member.getGrade()== Grade.VIP)
      return discountFixAmount;
    else
      return 0;
  }
}
