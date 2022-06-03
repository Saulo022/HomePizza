package es.ulpgc.eite.homepizza.store;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.homepizza.app.AppMediator;

/**
 * Created by Luis on mayo, 2022
 */
public class StoreScreen {

  public static void configure(StoreContract.View view) {

    /*
    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);
    */

    AppMediator mediator = AppMediator.getInstance();
    StoreContract.Presenter presenter = new StorePresenter(mediator);

    StoreContract.Model model = new StoreModel();

    presenter.injectModel(model);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}