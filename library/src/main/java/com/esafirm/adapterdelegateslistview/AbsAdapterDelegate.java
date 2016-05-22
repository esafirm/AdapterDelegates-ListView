package com.esafirm.adapterdelegateslistview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.esafirm.adapterdelegateslistview.util.Preconditions;
import java.lang.ref.WeakReference;

/**
 * Created by esa on 24/03/16, with awesomeness
 */
public abstract class AbsAdapterDelegate<T> implements AdapterDelegate<T> {

  protected Context mContext;

  private LayoutInflater mInflater;
  private WeakReference<BaseListAdapter<T>> adapter;

  private int mViewType;

  public AbsAdapterDelegate(Context context, int viewType) {
    Preconditions.checkNotNull(context);

    mViewType = viewType;
    mContext = context;
  }

  @Override
  public int getItemViewType() {
    return mViewType;
  }

  @Override
  public boolean isEnabled(int position) {
    return true;
  }

  /* --------------------------------------------------- */
  /* > Adapter */
  /* --------------------------------------------------- */

  public BaseListAdapter<T> getAdapter() {
    return adapter.get();
  }

  @Override
  public void setAdapter(BaseListAdapter<T> adapter) {
    this.adapter = new WeakReference<>(adapter);
  }

  @Override public void notifyDataSetChanged() {
  }

  /* --------------------------------------------------- */
  /* > Helper Method */
  /* --------------------------------------------------- */

  public LayoutInflater getLayoutInflater() {
    if (mInflater == null) {
      mInflater = LayoutInflater.from(mContext);
    }
    return mInflater;
  }

  protected View inflateView(@LayoutRes int resId, ViewGroup p) {
    return getLayoutInflater().inflate(resId, p, false);
  }
}
