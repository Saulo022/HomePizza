package es.ulpgc.eite.homepizza.amount;

import es.ulpgc.eite.homepizza.data.CartItem;

/**
 * Created by Luis on mayo, 2022
 */
public class AmountModel implements AmountContract.Model {

  public static String TAG = "HomePizza.AmountModel";

  private CartItem data;

  public AmountModel() {
    this.data = null;
  }

  @Override
  public CartItem getStoredData() {
    // Log.e(TAG, "getStoredData()");

    return data;
  }

}
