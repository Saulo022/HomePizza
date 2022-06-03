package es.ulpgc.eite.homepizza.cart;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.homepizza.data.CartItem;

/**
 * Created by Luis on mayo, 2022
 */
public class CartModel implements CartContract.Model {

  public static String TAG = "HomePizza.CartModel";

  private List<CartItem> data;

  public CartModel() {
    this.data = new ArrayList();
  }

  @Override
  public List<CartItem> getStoredData() {
    // Log.e(TAG, "getStoredData()");

    return data;
  }

}
