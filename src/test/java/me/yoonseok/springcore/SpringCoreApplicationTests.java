package me.yoonseok.springcore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.yoonseok.springcore.order.OrderService;

@SpringBootTest
class SpringCoreApplicationTests {

  @Autowired
  OrderService orderService; //springBoot를 띄워서 테스트를 하면 @AutoWired도 사용이 가능하다.


  @Test
  void contextLoads() {
  }

}
