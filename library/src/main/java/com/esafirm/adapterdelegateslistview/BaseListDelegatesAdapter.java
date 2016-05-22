package com.esafirm.adapterdelegateslistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.esafirm.adapterdelegateslistview.data.AdapterDataHandler;
import com.esafirm.adapterdelegateslistview.data.ListDataHandler;
import com.esafirm.adapterdelegateslistview.util.Preconditions;
import java.util.List;

/**
 * Created by esa on 24/03/16, with awesomeness
 */
public abstract class BaseListDelegatesAdapter<T> extends BaseListAdapter<T> {

  protected AdapterDelegateManager<T> manager = new AdapterDelegateManager<>(this);
  protected AdapterDataHandler<T> dataHandler;

  public BaseListDelegatesAdapter(Context context) {
    super(context);
  }

  protected void addDelegate(AdapterDelegate<T> delegate) {
    manager.addDelegate(delegate);
  }

  @Override
  public int getItemViewType(int position) {
    return manager.getItemViewType(getItem(position), position);
  }

  @Override
  public int getViewTypeCount() {
    return manager.getViewTypeCount();
  }

  @Override
  public boolean isEnabled(int position) {
    return manager.isEnabled(getItemViewType(position), position);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    int viewType = getItemViewType(position);
    BaseViewHolder holder = manager.getViewHolder(position, convertView, parent, viewType);
    manager.onBindData(holder, getItem(position), position, viewType);
    return super.getView(position, holder.itemView, parent);
  }

  @Override public void notifyDataSetChanged() {
    super.notifyDataSetChanged();
    manager.notifyDataSetChanged();
  }

  /* --------------------------------------------------- */
  /* > Data Handler */
  /* --------------------------------------------------- */

  protected AdapterDataHandler<T> getDataHandler() {
    if (dataHandler == null) {
      dataHandler = new ListDataHandler<>(this);
    }
    return dataHandler;
  }

  public void setDataHandler(AdapterDataHandler<T> dataHandler) {
    Preconditions.checkNotNull(dataHandler);
    this.dataHandler = dataHandler;
  }

  @Override public T getItem(int position) {
    return getDataHandler().getItem(position);
  }

  @Override public int getCount() {
    return getDataHandler().getCount();
  }

  public void setData(List<T> data) {
    getDataHandler().pushData(data);
  }
}
