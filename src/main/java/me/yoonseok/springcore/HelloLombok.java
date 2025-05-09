package me.yoonseok.springcore;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString//객체를 출력할 수 있게 해주는군
public class HelloLombok {

  private String name;
  private int age;

  public static void main(String[] args) {
    HelloLombok helloLombok = new HelloLombok();
    helloLombok.setName("yoon");

    System.out.println("helloLombok = " + helloLombok);

  }
}
