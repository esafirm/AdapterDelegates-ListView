package com.esafirm.adapterdelegateslistview;

import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by esa on 24/03/16, with awesomeness
 */
public class AdapterDelegateManager<T> {

  public static final int DEFAULT_VIEW_TYPE = 0;

  private SparseArrayCompat<AdapterDelegate<T>> delegates = new SparseArrayCompat<>();
  private BaseListAdapter<T> mBaseAdapter;

  public AdapterDelegateManager(BaseListAdapter<T> baseAdapter) {
    mBaseAdapter = baseAdapter;
  }

  public void addDelegate(AdapterDelegate<T> delegate) {
    delegate.setAdapter(mBaseAdapter);
    delegates.put(delegate.getItemViewType(), delegate);
  }

  public BaseViewHolder getViewHolder(int position, View convertView, ViewGroup parent,
      int viewType) {
    AdapterDelegate delegate = delegates.get(viewType);

    if (convertView != null && convertView.getTag() != null) {
      if (convertView.getTag() instanceof BaseViewHolder) {
        return (BaseViewHolder) convertView.getTag();
      }
    }
    return delegate.getViewHolder(position, convertView, parent);
  }

  public void onBindData(BaseViewHolder viewHolder, T t, int position, int viewType) {
    AdapterDelegate<T> delegate = delegates.get(viewType);
    delegate.onBindData(viewHolder, t, position);
  }

  public int getItemViewType(T t, int position) {
    if (t == null) {
      throw new NullPointerException("Items datasource is null!");
    }

    int delegatesCount = delegates.size();
    for (int i = 0; i < delegatesCount; i++) {
      AdapterDelegate<T> delegate = delegates.valueAt(i);
      if (delegate.isForType(t, position)) {
        return delegate.getItemViewType();
      }
    }
    return DEFAULT_VIEW_TYPE;
  }

  public int getViewTypeCount() {
    return delegates.size();
  }

  public boolean isEnabled(int viewType, int position) {
    return delegates.get(viewType).isEnabled(position);
  }

  public void notifyDataSetChanged() {
    int delegatesCount = delegates.size();
    for (int i = 0; i < delegatesCount; i++) {
      AdapterDelegate<T> delegate = delegates.valueAt(i);
      delegate.notifyDataSetChanged();
    }
  }
}
