package me.yoonseok.springcore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import me.yoonseok.springcore.annotation.MainDiscountPolicy;
import me.yoonseok.springcore.discount.DiscountPolicy;
import me.yoonseok.springcore.discount.FixDiscountPolicy;
import me.yoonseok.springcore.discount.RateDiscountPolicy;
import me.yoonseok.springcore.member.Member;
import me.yoonseok.springcore.member.MemberRepository;
import me.yoonseok.springcore.member.MemoryMemberRepository;


@Component
//@RequiredArgsConstructor//확실히 깔끔하긴 하네
public class OrderServiceImpl implements OrderService{

  private final MemberRepository memberRepository ;
  private final DiscountPolicy discountPolicy;//이런걸 외부에서 주입해야지..

  //디자인패턴 수업에서는 구현객체가 아닌 클래스의 main함수에서 객체들을 구현하고 주입하였다! 이렇게 ocp와 dip를 충족시켰음
  public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy DiscountPolicy) {
    System.out.println("생성자에서 의존관계 주입");
    this.memberRepository = memberRepository;
    this.discountPolicy = DiscountPolicy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice= discountPolicy.discount(member,itemPrice);//좋은 설계다. orderServuce는 어떤 할인 정책을
    //쓰는지 몰라도 되거든 <- 단일책임원칙, but new 키워드가 여기 있다는 점에서 ocp는 만족하지 않을 듯.

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

  //테스트 용도
  public  MemberRepository getMemberRepository(){
    return memberRepository;
  }

  //  @Autowired
  //  public void setMemberRepository(MemberRepository memberRepository){
  //    System.out.println("memberRepository = " + memberRepository);
  //    this.memberRepository=memberRepository;
  //  }
  //
  //  @Autowired
  //  public void setDiscountPolicy(DiscountPolicy discountPolicy){
  //    System.out.println("discountPolicy = " + discountPolicy);
  //    this.discountPolicy = discountPolicy;
  //  }
}
