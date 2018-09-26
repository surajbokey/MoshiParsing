package com.surajbokey.moshiparsing.support;

import com.serjltt.moshi.adapters.FallbackEnum;
import com.squareup.moshi.Moshi;

public class Provider {

    public static Moshi provideMoshi() {
        return new Moshi.Builder()
                .add(AutoValueMoshiAdapterFactory.create())
                .add(MoshiOptionalAdapterFactory.create())
                .add(FallbackEnum.ADAPTER_FACTORY)
                .build();
    }
}
