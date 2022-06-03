package es.ulpgc.eite.homepizza.amount;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.homepizza.app.AppMediator;

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

  }

  @Override
  public void onButtonClicked() {
    Log.e(TAG, "onButtonClicked()");

    // TODO: include some code if is necessary
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