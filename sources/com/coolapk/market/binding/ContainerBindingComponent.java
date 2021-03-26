package com.coolapk.market.binding;

import androidx.databinding.DataBindingComponent;
import java.lang.ref.WeakReference;

public class ContainerBindingComponent<T> implements DataBindingComponent {
    private WeakReference<T> containerRef;

    public ContainerBindingComponent(T t) {
        this.containerRef = new WeakReference<>(t);
    }

    public T getContainer() {
        return this.containerRef.get();
    }
}
