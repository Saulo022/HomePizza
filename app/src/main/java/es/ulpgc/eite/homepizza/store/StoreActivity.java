package es.ulpgc.eite.homepizza.store;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import es.ulpgc.eite.homepizza.R;
import es.ulpgc.eite.homepizza.data.StoreItem;

/**
 * Created by Luis on mayo, 2022
 */
public class StoreActivity
    extends AppCompatActivity implements StoreContract.View {

  public static String TAG = "HomePizza.StoreActivity";

  private StoreContract.Presenter presenter;
  private StoreAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_store);
    getSupportActionBar().setTitle(R.string.title_activity_store);


    adapter = new StoreAdapter(view -> {
      StoreItem item = (StoreItem) view.getTag();
      presenter.onItemClicked(item);
    });

    RecyclerView recyclerView = findViewById(R.id.storeRecycler);
    recyclerView.setAdapter(adapter);

    // Log.e(TAG, "onCreate()");

    // do the setup
    StoreScreen.configure(this);

    if (savedInstanceState == null) {
      presenter.onStart();

    } else {
      presenter.onRestart();
    }
  }

  @Override
  protected void onResume() {
    super.onResume();

    // Log.e(TAG, "onResume()");

    // load the data
    presenter.onResume();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();

    // Log.e(TAG, "onBackPressed()");

    presenter.onBackPressed();
  }

  @Override
  protected void onPause() {
    super.onPause();

    // Log.e(TAG, "onPause()");

    presenter.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    // Log.e(TAG, "onDestroy()");

    presenter.onDestroy();
  }

  @Override
  public void onViewModelDataUpdated(StoreViewModel viewModel) {
    //Log.e(TAG, "onViewModelDataUpdated()");

    // deal with the data
    adapter.setItems(viewModel.items);
  }


  @Override
  public void navigateToPreviousScreen() {
    // Log.e(TAG, "navigateToPreviousScreen()");

    finish();
  }

  @Override
  public void injectPresenter(StoreContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
