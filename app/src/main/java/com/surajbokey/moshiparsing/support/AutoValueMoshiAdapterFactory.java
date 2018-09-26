package com.surajbokey.moshiparsing.support;


import com.ryanharter.auto.value.moshi.MoshiAdapterFactory;
import com.squareup.moshi.JsonAdapter;

@MoshiAdapterFactory
public abstract class AutoValueMoshiAdapterFactory implements JsonAdapter.Factory {

  static JsonAdapter.Factory create() {
    return new AutoValueMoshi_AutoValueMoshiAdapterFactory();
  }
}
