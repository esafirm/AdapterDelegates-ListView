package com.esafirm.adapterdelegateslistview.util;

public class Preconditions {
  public Preconditions() {
  }

  public static <T> T checkNotNull(T reference) {
    if (reference == null) {
      throw new NullPointerException();
    } else {
      return reference;
    }
  }
}
