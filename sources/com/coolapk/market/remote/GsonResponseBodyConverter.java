package com.coolapk.market.remote;

import com.google.gson.TypeAdapter;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;

    GsonResponseBodyConverter(TypeAdapter<T> typeAdapter) {
        this.adapter = typeAdapter;
    }

    public T convert(ResponseBody responseBody) throws IOException {
        try {
            return this.adapter.fromJson(responseBody.charStream());
        } finally {
            responseBody.close();
        }
    }
}
