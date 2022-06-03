package es.ulpgc.eite.homepizza.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.homepizza.R;
import es.ulpgc.eite.homepizza.data.StoreItem;

public class StoreAdapter
    extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

  private List<StoreItem> itemList;
  private final View.OnClickListener clickListener;


  public StoreAdapter(View.OnClickListener listener) {

    itemList = new ArrayList();
    clickListener = listener;
  }

  public void addItem(StoreItem item){
    itemList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<StoreItem> items){
    itemList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<StoreItem> items){
    itemList = items;
    notifyDataSetChanged();
  }

  public StoreItem getItem(int position) {
    return itemList.get(position);
  }

  @Override
  public int getItemCount() {
    return itemList.size();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.store_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    StoreItem item = itemList.get(position);

    holder.itemView.setTag(item);
    holder.itemView.setOnClickListener(clickListener);

    holder.itemNameView.setText("Pizza: " + item.name);
    holder.itemPriceView.setText("Price: " + item.price);

  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView itemNameView;
    final TextView itemPriceView;

    ViewHolder(View view) {
      super(view);
      itemNameView = view.findViewById(R.id.storeItemName);
      itemPriceView = view.findViewById(R.id.storeItemPrice);
    }
  }
}
