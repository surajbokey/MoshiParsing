package com.surajbokey.moshiparsing.support;

import com.google.auto.value.AutoValue;

/**
 * This class exists because support library's Pair allows Nullable fields.
 */
@AutoValue
public abstract class Pair<F, S> {

    public abstract F first();

    public abstract S second();

    public static <F, S> Pair<F, S> create(F first, S second) {
        return new AutoValue_Pair<>(first, second);
    }
}
