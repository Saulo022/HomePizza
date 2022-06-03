package es.ulpgc.eite.homepizza.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.homepizza.R;
import es.ulpgc.eite.homepizza.data.CartItem;

public class CartAdapter
    extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

  private List<CartItem> itemList;
  private final View.OnClickListener clickListener;


  public CartAdapter(View.OnClickListener listener) {

    itemList = new ArrayList();
    clickListener = listener;
  }

  public void addItem(CartItem item){
    itemList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<CartItem> items){
    itemList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<CartItem> items){
    itemList = items;
    notifyDataSetChanged();
  }

  public CartItem getItem(int position) {
    return itemList.get(position);
  }

  @Override
  public int getItemCount() {
    return itemList.size();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.cart_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    CartItem item = itemList.get(position);

    holder.itemView.setTag(position);
    holder.itemView.setOnClickListener(clickListener);

    holder.itemNameView.setText("Pizza: " + item.name);
    holder.itemPriceView.setText("Price: " + item.price);
    holder.itemAmountView.setText("Amount: " + item.amount);

  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView itemNameView;
    final TextView itemPriceView;
    final TextView itemAmountView;

    ViewHolder(View view) {
      super(view);
      itemNameView = view.findViewById(R.id.cartItemName);
      itemPriceView = view.findViewById(R.id.cartItemPrice);
      itemAmountView = view.findViewById(R.id.cartItemAmount);
    }
  }
}
