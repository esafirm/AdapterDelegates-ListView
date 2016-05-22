package com.esafirm.adapterdelegateslistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class BaseListAdapter<T> extends BaseAdapter {

  protected Context mContext;
  protected LayoutInflater mInflater;

  private ViewGroup mParent;

  public BaseListAdapter(Context context) {
    mContext = context;
    mInflater = LayoutInflater.from(mContext);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    mParent = parent;
    return convertView;
  }

  /* --------------------------------------------------- */
  /* > Convenience Methods */
  /* --------------------------------------------------- */

  public ViewGroup getParent() {
    return mParent;
  }

  public boolean isEmpty() {
    return getCount() == 0;
  }
}

