package com.esafirm.adapterdelegateslistview.data;

import android.widget.BaseAdapter;
import java.util.Collections;

import static com.esafirm.adapterdelegateslistview.util.Preconditions.checkNotNull;

/**
 * Created by esa on 22/05/16, with awesomeness
 */
public abstract class AbsAdapterDataHandler<T> implements AdapterDataHandler<T> {

  private final BaseAdapter adapter;

  public AbsAdapterDataHandler(BaseAdapter adapter) {
    checkNotNull(adapter);
    this.adapter = adapter;
  }

  @Override public void pushData(T t) {
    pushData(Collections.singletonList(t));
  }

  protected void notifyDataSetChanged() {
    adapter.notifyDataSetChanged();
  }
}
