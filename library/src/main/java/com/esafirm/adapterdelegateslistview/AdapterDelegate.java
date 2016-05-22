package com.esafirm.adapterdelegateslistview;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by esa on 24/03/16, with awesomeness
 */
public interface AdapterDelegate<T> {

  boolean isForType(T t, int position);

  int getItemViewType();

  BaseViewHolder getViewHolder(int position, View convertView, ViewGroup parent);

  void onBindData(BaseViewHolder viewHolder, T t, int position);

  void setAdapter(BaseListAdapter<T> adapter);

  boolean isEnabled(int position);

  void notifyDataSetChanged();
}
