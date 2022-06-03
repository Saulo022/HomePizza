package es.ulpgc.eite.homepizza.data;

/**
 * Created by Luis on mayo, 2022
 */
public class CartItem {

  public String name;
  public Integer price;
  public Integer amount;

  public CartItem(StoreItem item) {
    name=item.name;
    price=item.price;
    amount=1;
  }

}
