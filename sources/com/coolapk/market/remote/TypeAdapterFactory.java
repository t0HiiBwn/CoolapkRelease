package com.coolapk.market.remote;

public abstract class TypeAdapterFactory implements com.google.gson.TypeAdapterFactory {
    public static TypeAdapterFactory create() {
        return new AutoValueGson_TypeAdapterFactory();
    }
}
