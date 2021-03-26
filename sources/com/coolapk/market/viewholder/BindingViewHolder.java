package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.util.UiUtils;

public abstract class BindingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener, Observable {
    private final ViewDataBinding binding;
    private transient PropertyChangeRegistry callbacks;
    private final DataBindingComponent component;
    private final Context context;
    private final ItemActionHandler itemActionHandler;

    public abstract void bindTo(Object obj);

    public void onViewAttachedToWindow() {
    }

    public void onViewDetachedFromWindow() {
    }

    public BindingViewHolder(View view) {
        this(view, null, null);
    }

    public BindingViewHolder(View view, ItemActionHandler itemActionHandler2) {
        this(view, null, itemActionHandler2);
    }

    public BindingViewHolder(View view, DataBindingComponent dataBindingComponent) {
        this(view, dataBindingComponent, null);
    }

    public BindingViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler2) {
        super(view);
        dataBindingComponent = dataBindingComponent == null ? DataBindingUtil.getDefaultComponent() : dataBindingComponent;
        this.component = dataBindingComponent;
        this.binding = DataBindingUtil.bind(view, dataBindingComponent);
        this.context = UiUtils.getActivity(view.getContext());
        this.itemActionHandler = itemActionHandler2;
    }

    public <T extends ViewDataBinding> T getBinding() {
        return (T) this.binding;
    }

    public Context getContext() {
        return this.context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ItemActionHandler itemActionHandler2 = this.itemActionHandler;
        if (itemActionHandler2 != null) {
            itemActionHandler2.onItemClick(this, view);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ItemActionHandler itemActionHandler2 = this.itemActionHandler;
        return itemActionHandler2 != null && itemActionHandler2.onItemLongClick(this, view);
    }

    public ItemActionHandler getItemActionHandler() {
        return this.itemActionHandler;
    }

    public DataBindingComponent getComponent() {
        return this.component;
    }

    @Override // androidx.databinding.Observable
    public synchronized void addOnPropertyChangedCallback(Observable.OnPropertyChangedCallback onPropertyChangedCallback) {
        if (this.callbacks == null) {
            this.callbacks = new PropertyChangeRegistry();
        }
        this.callbacks.add(onPropertyChangedCallback);
    }

    @Override // androidx.databinding.Observable
    public synchronized void removeOnPropertyChangedCallback(Observable.OnPropertyChangedCallback onPropertyChangedCallback) {
        PropertyChangeRegistry propertyChangeRegistry = this.callbacks;
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry.remove(onPropertyChangedCallback);
        }
    }

    public synchronized void notifyChange() {
        PropertyChangeRegistry propertyChangeRegistry = this.callbacks;
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry.notifyCallbacks(this, 0, null);
        }
    }

    public void notifyPropertyChanged(int i) {
        PropertyChangeRegistry propertyChangeRegistry = this.callbacks;
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry.notifyCallbacks(this, i, null);
        }
    }
}
