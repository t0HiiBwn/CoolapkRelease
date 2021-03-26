package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Entity;

public abstract class GenericBindHolder<BIND extends ViewDataBinding, DATA extends Entity> extends BindingViewHolder {
    public abstract void bindToContent(DATA data);

    public GenericBindHolder(View view) {
        super(view);
    }

    public GenericBindHolder(View view, ItemActionHandler itemActionHandler) {
        super(view, itemActionHandler);
    }

    public GenericBindHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
    }

    public GenericBindHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.viewholder.GenericBindHolder<BIND extends androidx.databinding.ViewDataBinding, DATA extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public final void bindTo(Object obj) {
        bindToContent((Entity) obj);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public final BIND getBinding() {
        return (BIND) super.getBinding();
    }
}
