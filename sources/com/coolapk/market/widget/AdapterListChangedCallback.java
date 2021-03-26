package com.coolapk.market.widget;

import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterListChangedCallback<T extends ObservableList> extends ObservableList.OnListChangedCallback<T> {
    private RecyclerView.Adapter adapter;

    public AdapterListChangedCallback(RecyclerView.Adapter adapter2) {
        this.adapter = adapter2;
    }

    @Override // androidx.databinding.ObservableList.OnListChangedCallback
    public void onChanged(T t) {
        this.adapter.notifyDataSetChanged();
    }

    @Override // androidx.databinding.ObservableList.OnListChangedCallback
    public void onItemRangeChanged(T t, int i, int i2) {
        this.adapter.notifyItemRangeChanged(i, i2);
    }

    @Override // androidx.databinding.ObservableList.OnListChangedCallback
    public void onItemRangeInserted(T t, int i, int i2) {
        this.adapter.notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.databinding.ObservableList.OnListChangedCallback
    public void onItemRangeMoved(T t, int i, int i2, int i3) {
        this.adapter.notifyItemMoved(i, i2);
    }

    @Override // androidx.databinding.ObservableList.OnListChangedCallback
    public void onItemRangeRemoved(T t, int i, int i2) {
        this.adapter.notifyItemRangeRemoved(i, i2);
    }
}
