package com.esafirm.sample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.esafirm.adapterdelegateslistview.AbsAdapterDelegate;
import com.esafirm.adapterdelegateslistview.BaseViewHolder;
import com.esafirm.sample.model.Animal;
import com.esafirm.sample.model.Bird;

/**
 * Created by esa on 21/05/16, with awesomeness
 */
public class BirdDelegate extends AbsAdapterDelegate<Animal> {

  public BirdDelegate(Context context, int viewType) {
    super(context, viewType);
  }

  @Override public boolean isForType(Animal animal, int position) {
    return animal instanceof Bird;
  }

  @Override public BaseViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
    TextView textView = new TextView(mContext); //mContext is protected field
    return new BirdViewHolder(textView);
  }

  @Override public void onBindData(BaseViewHolder viewHolder, Animal animal, int position) {
    ((TextView) viewHolder.itemView).setText("Bird");
  }

  static class BirdViewHolder extends BaseViewHolder {

    public BirdViewHolder(View view) {
      super(view);
    }
  }
}
