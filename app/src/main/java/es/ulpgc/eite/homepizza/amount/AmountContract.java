package es.ulpgc.eite.homepizza.amount;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.homepizza.data.CartItem;

/**
 * Created by Luis on mayo, 2022
 */
public interface AmountContract {

  interface View {
    void injectPresenter(Presenter presenter);
    void onViewModelDataUpdated(AmountViewModel viewModel);
    void navigateToPreviousScreen();
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
  }

  interface Model {
    CartItem getStoredData();
  }

}