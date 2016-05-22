package com.esafirm.adapterdelegateslistview.data;

import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by esa on 22/05/16, with awesomeness
 */
public class ListDataHandler<T> extends AbsAdapterDataHandler<T> {

  private List<T> items = new ArrayList<>();

  public ListDataHandler(BaseAdapter adapter) {
    super(adapter);
  }

  @Override public T getItem(int position) {
    return items.get(position);
  }

  @Override public int getCount() {
    return items.size();
  }

  @Override public void pushData(T t) {
    items.clear();
    items.add(t);
    notifyDataSetChanged();
  }

  @Override public void pushData(Iterable<T> data) {
    items.clear();
    for (T t : data) {
      items.add(t);
    }
    notifyDataSetChanged();
  }
}
