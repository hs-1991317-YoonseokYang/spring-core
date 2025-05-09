package me.yoonseok.springcore.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("memberService")
@Component
public class MemberServiceImpl implements MemberService{

  private final MemberRepository memberRepository;

  @Autowired //ac.getBean(MemberRepository.class)
  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  // MemberRepository와 MemoryMemberRepository를 모두 참조하는 좋지 않은 코드입니다!
  //solid 원칙 중 DIP를 지키지 않은 것임

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }

  //테스트 용도
  public  MemberRepository getMemberRepository(){
    return memberRepository;
  }
}
