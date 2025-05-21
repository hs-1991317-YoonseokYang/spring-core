package me.yoonseok.springcore.singleton;

public class StatefulService {

  private int price; //상태를 유지하는 필드, 스프링빈은 항상 무상태로 설계하자!!

  public int order(String name, int price){
    System.out.println("name = "+ name + "price = " + price);
    this.price = price;//여기가 문제!
    return price;
  }
//
//  public int getPrice(){
//    return price;
//  }
}
