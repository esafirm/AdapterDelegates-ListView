package com.esafirm.adapterdelegateslistview.data;

/**
 * Created by esa on 22/05/16, with awesomeness
 */
public interface AdapterDataHandler<T> {
  T getItem(int position);
  int getCount();

  void pushData(T t);
  void pushData(Iterable<T> data);
}
