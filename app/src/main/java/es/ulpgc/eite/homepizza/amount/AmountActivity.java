package es.ulpgc.eite.homepizza.amount;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.homepizza.R;
import es.ulpgc.eite.homepizza.data.CartItem;

/**
 * Created by Luis on mayo, 2022
 */
public class AmountActivity
    extends AppCompatActivity implements AmountContract.View {

  public static String TAG = "HomePizza.AmountActivity";

  private AmountContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_amount);
    getSupportActionBar().setTitle(R.string.title_activity_amount);

    findViewById(R.id.amountButton).setOnClickListener(view -> {
      presenter.onButtonClicked();
    });

    // Log.e(TAG, "onCreate()");

    // do the setup
    AmountScreen.configure(this);

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
  public void onViewModelDataUpdated(AmountViewModel viewModel) {
    //Log.e(TAG, "onViewModelDataUpdated()");

    // deal with the data
    CartItem item = viewModel.item;
    ((TextView) findViewById(R.id.itemName)).setText("Pizza: " + item.name);
    ((TextView) findViewById(R.id.itemPrice)).setText("Price: " + item.price);
    ((TextView) findViewById(R.id.itemAmount)).setText("Amount: " + item.amount);

    ((TextView) findViewById(R.id.cartSubtotal)).setText("Subtotal: " + viewModel.subtotal);
    ((TextView) findViewById(R.id.cartTotal)).setText("Total: " + viewModel.total);
  }


  @Override
  public void navigateToPreviousScreen() {
    // Log.e(TAG, "navigateToPreviousScreen()");

    finish();
  }

  @Override
  public void injectPresenter(AmountContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
