package es.ulpgc.eite.homepizza.cart;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import es.ulpgc.eite.homepizza.R;
import es.ulpgc.eite.homepizza.amount.AmountActivity;
import es.ulpgc.eite.homepizza.store.StoreActivity;

/**
 * Created by Luis on mayo, 2022
 */
public class CartActivity
    extends AppCompatActivity implements CartContract.View {

  public static String TAG = "HomePizza.CartActivity";

  private CartContract.Presenter presenter;
  private CartAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cart);
    getSupportActionBar().setTitle(R.string.title_activity_cart);

    adapter = new CartAdapter(view -> {
      Integer position = (Integer) view.getTag();
      presenter.onItemClicked(position);
    });

    RecyclerView recyclerView = findViewById(R.id.cartRecycler);
    recyclerView.setAdapter(adapter);

    findViewById(R.id.storeButton).setOnClickListener(view -> {
      presenter.onButtonClicked();
    });

    // Log.e(TAG, "onCreate()");

    // do the setup
    CartScreen.configure(this);

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
  public void onViewModelDataUpdated(CartViewModel viewModel) {
    //Log.e(TAG, "onViewModelDataUpdated()");

    // deal with the data
    adapter.setItems(viewModel.items);
  }


  @Override
  public void navigateToStoreScreen() {
    // Log.e(TAG, "navigateToStoreScreen()");

    Intent intent = new Intent(this, StoreActivity.class);
    startActivity(intent);
  }

  @Override
  public void navigateToAmountScreen() {
    // Log.e(TAG, "navigateToAmountScreen()");

    Intent intent = new Intent(this, AmountActivity.class);
    startActivity(intent);
  }

  @Override
  public void injectPresenter(CartContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
