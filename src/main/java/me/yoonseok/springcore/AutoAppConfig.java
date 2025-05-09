package me.yoonseok.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import me.yoonseok.springcore.member.MemberRepository;
import me.yoonseok.springcore.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
    //basePackages = "me.yoonseok.springcore.member",
    basePackageClasses = AutoAppConfig.class, excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//  @Bean(name = "memoryMemberRepository")//충돌 테스트
//  MemberRepository memberRepository() {
//    return new MemoryMemberRepository();
//  }

}
