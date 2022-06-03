package es.ulpgc.eite.homepizza.cart;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.homepizza.app.AppMediator;

/**
 * Created by Luis on mayo, 2022
 */
public class CartScreen {

  public static void configure(CartContract.View view) {

    /*
    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);
    */

    AppMediator mediator = AppMediator.getInstance();
    CartContract.Presenter presenter = new CartPresenter(mediator);

    CartContract.Model model = new CartModel();

    presenter.injectModel(model);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}