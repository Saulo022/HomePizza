package es.ulpgc.eite.homepizza.amount;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.homepizza.app.AppMediator;

/**
 * Created by Luis on mayo, 2022
 */
public class AmountScreen {

  public static void configure(AmountContract.View view) {

    /*
    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);
    */

    AppMediator mediator = AppMediator.getInstance();
    AmountContract.Presenter presenter = new AmountPresenter(mediator);

    AmountContract.Model model = new AmountModel();

    presenter.injectModel(model);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}