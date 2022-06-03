package es.ulpgc.eite.homepizza.store;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.homepizza.data.StoreItem;

/**
 * Created by Luis on mayo, 2022
 */
public interface StoreContract {

  interface View {
    void injectPresenter(Presenter presenter);
    void onViewModelDataUpdated(StoreViewModel viewModel);
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
    void onItemClicked(StoreItem item);
  }

  interface Model {
    List<StoreItem> getStoredData();
    List<StoreItem> getUpdatedDataDuringPause();
  }

}