package es.ulpgc.eite.homepizza.cart;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.homepizza.data.CartItem;
import es.ulpgc.eite.homepizza.data.StoreItem;

/**
 * Created by Luis on mayo, 2022
 */
public class CartModel implements CartContract.Model {

  public static String TAG = "HomePizza.CartModel";

  private List<CartItem> data;
  private int cuentaSubTotal;
  private int cuentaTotal;

  public CartModel() {
    this.data = new ArrayList();
  }

  @Override
  public List<CartItem> getStoredData() {
    // Log.e(TAG, "getStoredData()");

    return data;
  }

  @Override
  public int subTotal(CartItem cartItem){
    cuentaSubTotal = cartItem.amount * cartItem.price;
    return cuentaSubTotal;
  }

  @Override
  public int cuentaTotal(List<CartItem> lista){

    for (int i=0; i<lista.size(); i++){
      cuentaTotal = cuentaTotal + (lista.get(i).price * lista.get(i).amount);
    }
    return cuentaTotal;
  }
}
