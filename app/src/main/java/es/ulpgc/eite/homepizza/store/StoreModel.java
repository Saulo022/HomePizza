package es.ulpgc.eite.homepizza.store;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.homepizza.data.StoreItem;

/**
 * Created by Luis on mayo, 2022
 */
public class StoreModel implements StoreContract.Model {

  public static String TAG = "HomePizza.StoreModel";

  private List<StoreItem> data;

  public StoreModel() {
    this.data = new ArrayList();

    this.data.add(new StoreItem("Cheese", 10));
    this.data.add(new StoreItem("Veggie", 9));
    this.data.add(new StoreItem("Pepperoni", 14));
    this.data.add(new StoreItem("Meat", 13));
    this.data.add(new StoreItem("Margherita", 8));
    this.data.add(new StoreItem("BBQ Chicken", 12));
    this.data.add(new StoreItem("Hawaiian", 11));
    this.data.add(new StoreItem("Buffalo", 15));
    this.data.add(new StoreItem("Supreme", 16));

  }

  @Override
  public List<StoreItem> getStoredData() {
    // Log.e(TAG, "getStoredData()");

    return data;
  }

  @Override
  public List<StoreItem> getUpdatedDataDuringPause() {
    // Log.e(TAG, "getUpdatedDataDuringPause()");

    // TODO: include some code if is necessary

    return data;
  }

}
