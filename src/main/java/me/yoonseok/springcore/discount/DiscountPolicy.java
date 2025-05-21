package me.yoonseok.springcore.discount;

import me.yoonseok.springcore.member.Member;

public interface DiscountPolicy {

  /**
   *
   * @param member
   * @param price
   * @return 할인 대상 금액
   */
  int discount(Member member, int price);
}
