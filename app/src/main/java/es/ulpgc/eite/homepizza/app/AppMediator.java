package es.ulpgc.eite.homepizza.app;

import es.ulpgc.eite.homepizza.amount.AmountState;
import es.ulpgc.eite.homepizza.cart.CartState;
import es.ulpgc.eite.homepizza.store.StoreState;

/**
 * Created by Luis on mayo, 2022
 */
@SuppressWarnings("unused")
public class AppMediator {

  private static AppMediator INSTANCE;

  private CartState mCartState;
  private StoreState mStoreState;
  private AmountState mAmountState;

  private StoreToCartState mStoreToCartState;
  private CartToAmountState mCartToAmountState;
  private AmountToCartState mAmountToCartState;

  private AppMediator() {
    mCartState = new CartState();
    mStoreState = new StoreState();
    mAmountState = new AmountState();
  }


  public static AppMediator getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new AppMediator();
    }

    return INSTANCE;
  }

  // to reset the state when testing
  public static void resetInstance() {
    INSTANCE = null;
  }


  public AmountState getAmountScreenState() {
    return mAmountState;
  }

  public void setAmountScreenState(AmountState state) {
    mAmountState= state;
  }

  public StoreState getStoreScreenState() {
    return mStoreState;
  }

  public void setStoreScreenState(StoreState state) {
    mStoreState = state;
  }

  public CartState getCartScreenState() {
    return mCartState;
  }

  public void setCartScreenState(CartState state) {
    mCartState = state;
  }


  public StoreToCartState getStoreToCartScreenState() {
    StoreToCartState state = mStoreToCartState;
    mStoreToCartState = null;
    return state;
  }


  public void setStoreToCartScreenState(StoreToCartState state) {
      mStoreToCartState = state;
  }

  public void setAmountToCartScreenState(AmountToCartState state) {
    mAmountToCartState= state;
  }

  public AmountToCartState getAmountToCartScreenState() {
    AmountToCartState state=mAmountToCartState;
    mAmountToCartState=null;
    return state;
  }

  public CartToAmountState getCartToAmountScreenState() {
    CartToAmountState state= mCartToAmountState;
    mCartToAmountState=null;
    return state;
  }


  public void setCartToAmountScreenState(CartToAmountState state) {
    mCartToAmountState= state;
  }

}