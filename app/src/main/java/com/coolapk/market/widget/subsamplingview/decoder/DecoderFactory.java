package com.coolapk.market.widget.subsamplingview.decoder;

public interface DecoderFactory<T> {
    T make() throws IllegalAccessException, InstantiationException;
}
