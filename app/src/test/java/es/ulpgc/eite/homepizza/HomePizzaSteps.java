package es.ulpgc.eite.homepizza;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;

import es.ulpgc.eite.homepizza.amount.AmountActivity;
import es.ulpgc.eite.homepizza.app.AppMediator;
import es.ulpgc.eite.homepizza.cart.CartActivity;
import es.ulpgc.eite.homepizza.cart.CartAdapter;
import es.ulpgc.eite.homepizza.data.CartItem;
import es.ulpgc.eite.homepizza.data.StoreItem;
import es.ulpgc.eite.homepizza.store.StoreActivity;
import es.ulpgc.eite.homepizza.store.StoreAdapter;

/**
 * Created by Luis on mayo, 2022
 */
public class HomePizzaSteps {


  private ActivityController<CartActivity> cartTestCtrl;
  private ActivityController<StoreActivity> storeTestCtrl;
  private ActivityController<AmountActivity> amountTestCtrl;

  public void appStartScreen(String screen) {

    if(screen.equals("Cart")) {

      cartTestCtrl = Robolectric.buildActivity(CartActivity.class);
      cartTestCtrl.create().resume().visible();

    }

    if(screen.equals("Store")) {
      cartTestCtrl.pause();

      storeTestCtrl = Robolectric.buildActivity(StoreActivity.class);
      storeTestCtrl.create().resume().visible();

    }

    if(screen.equals("Amount")) {
      cartTestCtrl.pause();

      amountTestCtrl = Robolectric.buildActivity(AmountActivity.class);
      amountTestCtrl.create().resume().visible();

    }

  }


  public void appResumeScreen(String screen) {

    if(screen.equals("Cart")) {
      cartTestCtrl.resume();
    }
  }

  public void userPressBackOnScreen(String screen) {

    if(screen.equals("Amount")) {
      AmountActivity activity = amountTestCtrl.get();
      activity.onBackPressed();
    }

    if(screen.equals("Store")) {
      StoreActivity activity = storeTestCtrl.get();
      activity.onBackPressed();
    }
  }


  public void userPressButton(String screen) {

    if(screen.equals("Store")) {
      CartActivity activity = cartTestCtrl.get();
      activity.findViewById(R.id.storeButton).performClick();
    }

    if(screen.equals("Amount")) {
      AmountActivity activity = amountTestCtrl.get();
      activity.findViewById(R.id.amountButton).performClick();
    }

  }

  public void userPressItem(String screen, int position) {

    if(screen.equals("Cart")) {
      CartActivity activity = cartTestCtrl.get();
      RecyclerView recycler = activity.findViewById(R.id.cartRecycler);

      recycler.measure(0,0);
      recycler.layout(0,0,100,1000);

      recycler.findViewHolderForAdapterPosition(position).itemView.performClick();
    }

    if(screen.equals("Store")) {
      StoreActivity activity = storeTestCtrl.get();
      RecyclerView recycler = activity.findViewById(R.id.storeRecycler);

      recycler.measure(0,0);
      recycler.layout(0,0,100,1000);

      recycler.findViewHolderForAdapterPosition(position).itemView.performClick();
    }

  }


  public void appShowNumOfItems(String screen, int size) {

    if(screen.equals("Cart")) {
      CartActivity activity = cartTestCtrl.get();

      RecyclerView recycler = activity.findViewById(R.id.cartRecycler);
      CartAdapter adapter = (CartAdapter) recycler.getAdapter();


      assertThat(adapter.getItemCount(), equalTo(size));

    }

    if(screen.equals("Store")) {
      StoreActivity activity = storeTestCtrl.get();

      RecyclerView recycler = activity.findViewById(R.id.storeRecycler);
      StoreAdapter adapter = (StoreAdapter) recycler.getAdapter();


      assertThat(adapter.getItemCount(), equalTo(size));

    }
  }

  public void appShowNumOnSection(
      String screen, int position, String section, int val
  ) {
    appShowTextOnSection(screen, position, section, String.valueOf(val));
  }

  public void appShowTextOnSection(
      String screen, int position, String section, String text
  ) {

    if(screen.equals("Cart")) {
      CartActivity activity = cartTestCtrl.get();

      RecyclerView recycler = activity.findViewById(R.id.cartRecycler);
      CartAdapter adapter = (CartAdapter) recycler.getAdapter();
      CartItem item = adapter.getItem(position);


      if (section.equals("Pizza")) {
        assertThat(item.name, equalTo(text));
      }

      if (section.equals("Price")) {
        assertThat(String.valueOf(item.price), equalTo(text));
      }

      if (section.equals("Amount")) {
        assertThat(String.valueOf(item.amount), equalTo(text));
      }

    }

    if(screen.equals("Store")) {
      StoreActivity activity = storeTestCtrl.get();

      RecyclerView recycler = activity.findViewById(R.id.storeRecycler);
      StoreAdapter adapter = (StoreAdapter) recycler.getAdapter();
      StoreItem item = adapter.getItem(position);


      if (section.equals("Pizza")) {
        assertThat(item.name, equalTo(text));
      }

      if (section.equals("Price")) {
        assertThat(String.valueOf(item.price), equalTo(text));
      }

    }
  }

  public void appShowNumOnSection(String screen, String section, int val) {
    appShowTextOnSection(screen, section, String.valueOf(val));
  }

  public void appShowTextOnSection(String screen, String section, String text) {

    if(screen.equals("Amount")) {
      AmountActivity activity = amountTestCtrl.get();


      String text1 = section + ": " + text;

      if (section.equals("Pizza")) {
        TextView tv = activity.findViewById(R.id.itemName);
        assertThat(tv.getText().toString(), equalTo(text1));
      }

      if (section.equals("Price")) {
        TextView tv = activity.findViewById(R.id.itemPrice);
        assertThat(tv.getText().toString(), equalTo(text1));
      }

      if (section.equals("Amount")) {
        TextView tv = activity.findViewById(R.id.itemAmount);
        assertThat(tv.getText().toString(), equalTo(text1));
      }

      if (section.equals("Subtotal")) {
        TextView tv = activity.findViewById(R.id.cartSubtotal);
        assertThat(tv.getText().toString(), equalTo(text1));
      }

      if (section.equals("Total")) {
        TextView tv = activity.findViewById(R.id.cartTotal);
        assertThat(tv.getText().toString(), equalTo(text1));
      }
    }
  }


  public void userRotateScreen(String screen) {


    Bundle bundle = new Bundle();

    if(screen.equals("Store")) {
      storeTestCtrl
          .saveInstanceState(bundle)
          .pause()
          .stop()
          .destroy();

      storeTestCtrl = Robolectric.buildActivity(StoreActivity.class)
          .create(bundle)
          .restoreInstanceState(bundle)
          .resume()
          .visible();
    }

    if(screen.equals("Cart")) {
      cartTestCtrl
          .saveInstanceState(bundle)
          .pause()
          .stop()
          .destroy();

      cartTestCtrl = Robolectric.buildActivity(CartActivity.class)
          .create(bundle)
          .restoreInstanceState(bundle)
          .resume()
          .visible();

    }

    if(screen.equals("Amount")) {
      amountTestCtrl
          .saveInstanceState(bundle)
          .pause()
          .stop()
          .destroy();

      amountTestCtrl = Robolectric.buildActivity(AmountActivity.class)
          .create(bundle)
          .restoreInstanceState(bundle)
          .resume()
          .visible();

    }
  }


  public void resetTest() {
      AppMediator.resetInstance();
  }

}
