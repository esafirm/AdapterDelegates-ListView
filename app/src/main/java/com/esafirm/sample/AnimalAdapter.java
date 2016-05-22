package com.esafirm.sample;

import android.content.Context;
import com.esafirm.adapterdelegateslistview.BaseListDelegatesAdapter;
import com.esafirm.sample.model.Animal;

/**
 * Created by esa on 21/05/16, with awesomeness
 */
public class AnimalAdapter extends BaseListDelegatesAdapter<Animal> {
  public AnimalAdapter(Context context) {
    super(context);
    addDelegate(new BirdDelegate(mContext, 0));
    addDelegate(new RabbitDelegate(mContext, 1));
  }
}
