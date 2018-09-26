package com.surajbokey.moshiparsing;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.surajbokey.moshiparsing.support.Optional;

@AutoValue
abstract class ParsingDemo {
    abstract String name();

    abstract Optional<String> address();

    static JsonAdapter<ParsingDemo> jsonAdapter(Moshi moshi) {
        return new AutoValue_ParsingDemo.MoshiJsonAdapter(moshi);
    }
}
