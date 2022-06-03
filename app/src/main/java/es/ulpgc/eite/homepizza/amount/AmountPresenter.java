package es.ulpgc.eite.homepizza.amount;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.homepizza.app.AmountToCartState;
import es.ulpgc.eite.homepizza.app.AppMediator;
import es.ulpgc.eite.homepizza.app.CartToAmountState;
import es.ulpgc.eite.homepizza.data.CartItem;
import es.ulpgc.eite.homepizza.data.StoreItem;

/**
 * Created by Luis on mayo, 2022
 */
public class AmountPresenter implements AmountContract.Presenter {

  public static String TAG = "HomePizza.AmountPresenter";

  private WeakReference<AmountContract.View> view;
  private AmountState state;
  private AmountContract.Model model;
  private AppMediator mediator;

  public AmountPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getAmountScreenState();
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
    CartToAmountState cart = mediator.getCartToAmountScreenState();
    if(cart != null){
      StoreItem storeItem = new StoreItem(cart.item.name, cart.item.price);
      CartItem cartItem = new CartItem(storeItem);
      state.item = cartItem;
      state.subtotal = cart.subtotal;
      state.total = cart.total;
    }
    view.get().onViewModelDataUpdated(state);
  }

  @Override
  public void onBackPressed() {
    Log.e(TAG, "onBackPressed()");

    // TODO: include some code if is necessary
    AmountToCartState amount = new AmountToCartState();
    amount.item = state.item;
    passStateToNextScreen(amount);
    view.get().navigateToPreviousScreen();
  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy()");

  }

  @Override
  public void onButtonClicked() {
    Log.e(TAG, "onButtonClicked()");

    // TODO: include some code if is necessary
    state.item.amount = state.item.amount+1;
    state.subtotal = state.subtotal + state.item.price;
    state.total = state.total + state.item.price;
    view.get().onViewModelDataUpdated(state);
  }

  private void passStateToNextScreen(AmountToCartState state) {
    mediator.setAmountToCartScreenState(state);
  }

  @Override
  public void injectView(WeakReference<AmountContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AmountContract.Model model) {
    this.model = model;
  }

}