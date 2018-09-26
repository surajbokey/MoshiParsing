package com.surajbokey.moshiparsing.support;

import android.support.annotation.Nullable;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;

/**
 * Type adapter for reading and writing values wrapped in {@link Optional}.
 */
public class MoshiOptionalAdapterFactory implements JsonAdapter.Factory {

    public static MoshiOptionalAdapterFactory create() {
        return new MoshiOptionalAdapterFactory();
    }

    @Nullable
    @Override
    public JsonAdapter<?> create(Type type, Set<? extends Annotation> annotations, Moshi moshi) {
        if (type instanceof ParameterizedType && Optional.class == ((ParameterizedType) type).getRawType()) {
            return new OptionalAdapter(moshi, ((ParameterizedType) type).getActualTypeArguments()[0]);
        }
        return null;
    }

    private static class OptionalAdapter extends JsonAdapter<Optional<?>> {

        private final Moshi moshi;
        private final Type type;

        public OptionalAdapter(Moshi moshi, Type type) {
            this.moshi = moshi;
            this.type = type;
        }

        @Override
        public void toJson(JsonWriter out, @Nullable Optional<?> value) throws IOException {
            checkNotNull(value, "optional value == null");
            if (value.isPresent()) {
                moshi.adapter(type).toJson(out, value.get());
            } else {
                out.nullValue();
            }
        }

        @Override
        public Optional<?> fromJson(JsonReader in) throws IOException {
            //noinspection ConstantConditions
            return in.peek() == JsonReader.Token.NULL
                    ? Optional.empty()
                    : Optional.of(moshi.adapter(type).fromJson(in));
        }
    }

    public static <T> T checkNotNull(@Nullable T value, String message) {
        if (value == null) {
            throw new NullPointerException(message);
        }
        return value;
    }
}
