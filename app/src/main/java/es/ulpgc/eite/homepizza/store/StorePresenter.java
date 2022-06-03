package es.ulpgc.eite.homepizza.store;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.homepizza.app.AppMediator;
import es.ulpgc.eite.homepizza.app.StoreToCartState;
import es.ulpgc.eite.homepizza.data.CartItem;
import es.ulpgc.eite.homepizza.data.StoreItem;

/**
 * Created by Luis on mayo, 2022
 */
public class StorePresenter implements StoreContract.Presenter {

  public static String TAG = "HomePizza.StorePresenter";

  private WeakReference<StoreContract.View> view;
  private StoreState state;
  private StoreContract.Model model;
  private AppMediator mediator;

  public StorePresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getStoreScreenState();
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // TODO: include some code if is necessary
    List<StoreItem> storeItem = model.getStoredData();
    state.items =storeItem;
    Log.e(TAG, "onStart()" + storeItem);
  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // TODO: include some code if is necessary
    view.get().onViewModelDataUpdated(state);
  }

  @Override
  public void onBackPressed() {
    Log.e(TAG, "onBackPressed()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onItemClicked(StoreItem item) {
    Log.e(TAG, "onItemClicked()");

    // TODO: include some code if is necessary
    StoreItem item1 = new StoreItem(item.name, item.price);
    StoreToCartState state1 = new StoreToCartState();
    state1.item = item1;
    passStateToNextScreen(state1);
    view.get().navigateToPreviousScreen();
  }

  private void passStateToNextScreen(StoreToCartState state) {
    mediator.setStoreToCartScreenState(state);
  }

  @Override
  public void injectView(WeakReference<StoreContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(StoreContract.Model model) {
    this.model = model;
  }

}