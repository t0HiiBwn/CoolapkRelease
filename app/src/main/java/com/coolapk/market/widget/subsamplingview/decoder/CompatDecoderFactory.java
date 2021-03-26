package com.coolapk.market.widget.subsamplingview.decoder;

public class CompatDecoderFactory<T> implements DecoderFactory<T> {
    private Class<? extends T> clazz;

    public CompatDecoderFactory(Class<? extends T> cls) {
        this.clazz = cls;
    }

    @Override // com.coolapk.market.widget.subsamplingview.decoder.DecoderFactory
    public T make() throws IllegalAccessException, InstantiationException {
        return (T) this.clazz.newInstance();
    }
}
