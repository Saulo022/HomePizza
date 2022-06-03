package es.ulpgc.eite.homepizza.cart;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.homepizza.app.AmountToCartState;
import es.ulpgc.eite.homepizza.app.AppMediator;
import es.ulpgc.eite.homepizza.app.CartToAmountState;
import es.ulpgc.eite.homepizza.app.StoreToCartState;
import es.ulpgc.eite.homepizza.data.CartItem;

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
    state = mediator.getCartScreenState();
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
    StoreToCartState newState = mediator.getStoreToCartScreenState();
    if (newState != null){
      CartItem cartItem = new CartItem(newState.item);
      state.items.add(cartItem);
    }

    AmountToCartState newState2 = mediator.getAmountToCartScreenState();
    if(newState2 != null){
      for (int i=0; i<state.items.size(); i++){
          if(state.items.get(i).price == newState2.item.price){
            state.items.get(i).amount = newState2.item.amount;
          }
      }
    }
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
  public void onButtonClicked() {
    Log.e(TAG, "onButtonClicked()");

    // TODO: include some code if is necessary
    view.get().navigateToStoreScreen();
  }

  @Override
  public void onItemClicked(Integer position) {
    Log.e(TAG, "onItemClicked()");

    // TODO: include some code if is necessary
    CartToAmountState cartToAmountState = new CartToAmountState();
    cartToAmountState.item = state.items.get(position);
    cartToAmountState.subtotal = model.subTotal(state.items.get(position));
    cartToAmountState.total = model.cuentaTotal(state.items);
    passStateToNextScreen(cartToAmountState);
    view.get().navigateToAmountScreen();
  }

  private void passStateToNextScreen(CartToAmountState state) {
    mediator.setCartToAmountScreenState(state);
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