package es.ulpgc.eite.homepizza.data;

import androidx.annotation.NonNull;

/**
 * Created by Luis on mayo, 2022
 */
public class StoreItem {

  public String name;
  public Integer price;

  public StoreItem(String name, Integer price) {
    this.name = name;
    this.price = price;
  }


  @NonNull
  @Override
  public String toString() {
    return "Pizza " + name + ","+ "Price" + price;
  }
}
