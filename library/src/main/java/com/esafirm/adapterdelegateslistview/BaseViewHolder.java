package com.esafirm.adapterdelegateslistview;

import android.view.View;

/**
 * Created by esa on 03/02/16, with awesomeness
 */
public abstract class BaseViewHolder {

  public View itemView;

  public BaseViewHolder(View view) {
    view.setTag(this);
    itemView = view;
  }
}
