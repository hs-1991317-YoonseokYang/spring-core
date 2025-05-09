package me.yoonseok.springcore.order;

public interface OrderService {

  /**
   * 
   * @param memberId
   * @param itemName
   * @param itemPrice
   * @return 주문내역
   */
  Order createOrder(Long memberId, String itemName, int itemPrice);
}
