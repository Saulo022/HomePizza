package es.ulpgc.eite.homepizza.cart;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.homepizza.app.AppMediator;

/**
 * Created by Luis on mayo, 2022
 */
public class CartPresenter implements CartContract.Presenter {

  public static String TAG = "HomePizza.CartPresenter";

  private WeakReference<CartContract.View> view;
  private CartState state;
  private CartContract.Model model;
  private AppMediator mediator;

  public CartPresenter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // TODO: include some code if is necessary
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
  public void onButtonClicked() {
    Log.e(TAG, "onButtonClicked()");

    // TODO: include some code if is necessary
    view.get().navigateToStoreScreen();
  }

  @Override
  public void onItemClicked(Integer position) {
    Log.e(TAG, "onItemClicked()");

    // TODO: include some code if is necessary
  }


  @Override
  public void injectView(WeakReference<CartContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CartContract.Model model) {
    this.model = model;
  }

}