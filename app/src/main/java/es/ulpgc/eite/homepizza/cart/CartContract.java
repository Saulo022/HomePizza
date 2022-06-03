package es.ulpgc.eite.homepizza.cart;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.homepizza.data.CartItem;

/**
 * Created by Luis on mayo, 2022
 */
public interface CartContract {

  interface View {
    void injectPresenter(Presenter presenter);
    void onViewModelDataUpdated(CartViewModel viewModel);
    void navigateToStoreScreen();
    void navigateToAmountScreen();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void onResume();
    void onStart();
    void onRestart();
    void onBackPressed();
    void onPause();
    void onDestroy();
    void onButtonClicked();
    void onItemClicked(Integer position);
  }

  interface Model {
    List<CartItem> getStoredData();
  }

}