package me.yoonseok.springcore.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import me.yoonseok.springcore.AppConfig;

public class MemberServiceTest {

  @BeforeEach
  public void beforeEach(){
    AppConfig appConfig= new AppConfig();
    memberService=appConfig.memberService();
  }


  MemberService memberService;

  @Test
  void join() {
    //given
    Member member = new Member(1L,"meberA",Grade.VIP);

    //when
    memberService.join(member);
    Member findMember = memberService.findMember(1L);

    //then
    Assertions.assertThat(member).isEqualTo(findMember);

  }
}
