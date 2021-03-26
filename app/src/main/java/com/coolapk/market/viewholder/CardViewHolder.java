package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.model.Card;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.ViewUtil;

public abstract class CardViewHolder extends StateViewHolder {
    private Card<Entity> card;
    private final DataBindingComponent component;
    private int emptyItemVisibility = 4;

    protected abstract int getItemViewCount();

    protected abstract void onChildBindTo(ViewDataBinding viewDataBinding, Object obj, int i);

    protected abstract View onFindChildView(View view, int i);

    public CardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        this.component = dataBindingComponent;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        if (obj instanceof Card) {
            this.card = (Card) obj;
            int itemViewCount = getItemViewCount();
            for (int i = 0; i < itemViewCount; i++) {
                View onFindChildView = onFindChildView(this.itemView, i);
                if (onFindChildView != null) {
                    if (i > this.card.getEntities().size() - 1) {
                        onFindChildView.setVisibility(this.emptyItemVisibility);
                        ViewUtil.clickListener(onFindChildView, null);
                    } else {
                        onFindChildView.setVisibility(0);
                        ViewUtil.clickListener(onFindChildView, this);
                        onChildBindTo(DataBindingUtil.bind(onFindChildView, this.component), this.card.getEntities().get(i), i);
                    }
                }
            }
            return;
        }
        throw new RuntimeException("You must bind card type data");
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        for (Entity entity : this.card.getEntities()) {
            if (EntityUtils.isApkType(entity.getEntityType()) && isEventBelongTo(event, (ServiceApp) entity)) {
                return true;
            }
        }
        return false;
    }

    public void setEmptyItemVisibility(int i) {
        this.emptyItemVisibility = i;
    }
}
