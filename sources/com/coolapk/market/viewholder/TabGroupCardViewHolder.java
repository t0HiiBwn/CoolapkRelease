package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemTabGroupCardBinding;
import com.coolapk.market.databinding.ItemTabGroupCardItemBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.GridCard;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.TabGroupCard;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.ViewUtil;
import java.util.concurrent.atomic.AtomicInteger;

public class TabGroupCardViewHolder extends StateViewHolder {
    public static final int LAYOUT_ID = 2131558942;
    private final DataAdapter adapter;
    private final DataBindingComponent component;
    private GridCard gridCard;
    private final ItemActionHandler itemActionHandler;
    private final AtomicInteger tabIndex;

    public TabGroupCardViewHolder(View view, DataBindingComponent dataBindingComponent, AtomicInteger atomicInteger, ItemActionHandler itemActionHandler2) {
        super(view, dataBindingComponent, itemActionHandler2);
        this.component = dataBindingComponent;
        this.itemActionHandler = itemActionHandler2;
        this.tabIndex = atomicInteger;
        ItemTabGroupCardBinding itemTabGroupCardBinding = (ItemTabGroupCardBinding) getBinding();
        DataAdapter dataAdapter = new DataAdapter();
        this.adapter = dataAdapter;
        itemTabGroupCardBinding.gridView.setAdapter(dataAdapter);
        itemTabGroupCardBinding.gridView.setNestedScrollingEnabled(false);
        itemTabGroupCardBinding.gridView.setItemAnimator(null);
        itemTabGroupCardBinding.gridView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        ViewUtil.clickListener(itemTabGroupCardBinding.moreView, this);
        ViewUtil.clickListener(itemTabGroupCardBinding.tabView1, this);
        ViewUtil.clickListener(itemTabGroupCardBinding.tabView2, this);
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        for (int i = 0; i < CollectionUtils.safeSize(this.gridCard.getEntities()); i++) {
            if (isEventBelongTo(event, this.gridCard.getEntities().get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        int i;
        int i2;
        TabGroupCard tabGroupCard = (TabGroupCard) obj;
        this.gridCard = tabGroupCard.getEntities().get(this.tabIndex.get());
        this.adapter.notifyDataSetChanged();
        ItemTabGroupCardBinding itemTabGroupCardBinding = (ItemTabGroupCardBinding) getBinding();
        TextView textView = itemTabGroupCardBinding.tabViewText1;
        if (this.tabIndex.get() == 0) {
            i = AppHolder.getAppTheme().getTextColorSecondary();
        } else {
            i = AppHolder.getAppTheme().getTextColorTertiary();
        }
        textView.setTextColor(i);
        TextView textView2 = itemTabGroupCardBinding.tabViewText2;
        if (this.tabIndex.get() == 1) {
            i2 = AppHolder.getAppTheme().getTextColorSecondary();
        } else {
            i2 = AppHolder.getAppTheme().getTextColorTertiary();
        }
        textView2.setTextColor(i2);
        int i3 = 0;
        itemTabGroupCardBinding.tabViewIndicator1.setVisibility(this.tabIndex.get() == 0 ? 0 : 4);
        ImageView imageView = itemTabGroupCardBinding.tabViewIndicator2;
        if (this.tabIndex.get() != 1) {
            i3 = 4;
        }
        imageView.setVisibility(i3);
        itemTabGroupCardBinding.setCard(tabGroupCard);
        itemTabGroupCardBinding.executePendingBindings();
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        public DataAdapter() {
            setHasStableIds(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(TabGroupCardViewHolder.this.getContext()).inflate(2131558943, viewGroup, false);
            TabGroupCardViewHolder tabGroupCardViewHolder = TabGroupCardViewHolder.this;
            return new DataViewHolder(tabGroupCardViewHolder, inflate, tabGroupCardViewHolder.component, TabGroupCardViewHolder.this.tabIndex, TabGroupCardViewHolder.this.itemActionHandler);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(TabGroupCardViewHolder.this.gridCard.getEntities().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CollectionUtils.safeSize(TabGroupCardViewHolder.this.gridCard.getEntities());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return Long.valueOf(TabGroupCardViewHolder.this.gridCard.getEntities().get(i).getApkId()).longValue();
        }
    }

    public static class DataViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558943;
        private final AtomicInteger tabIndex;

        public DataViewHolder(TabGroupCardViewHolder tabGroupCardViewHolder, View view, DataBindingComponent dataBindingComponent, AtomicInteger atomicInteger, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            this.tabIndex = atomicInteger;
            ItemTabGroupCardItemBinding itemTabGroupCardItemBinding = (ItemTabGroupCardItemBinding) getBinding();
            ViewUtil.clickListener(itemTabGroupCardItemBinding.getRoot(), tabGroupCardViewHolder);
            ViewUtil.directClickListener(itemTabGroupCardItemBinding.actionButton, tabGroupCardViewHolder);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemTabGroupCardItemBinding itemTabGroupCardItemBinding = (ItemTabGroupCardItemBinding) getBinding();
            ServiceApp serviceApp = (ServiceApp) obj;
            int preferencesInt = DataManager.getInstance().getPreferencesInt("TAB_GROUP_CARD_INDEX", 0);
            if (preferencesInt == 0) {
                itemTabGroupCardItemBinding.infoView.setText(serviceApp.getApkSizeFormat());
            } else if (preferencesInt == 1) {
                itemTabGroupCardItemBinding.infoView.setText(getContext().getString(2131886639, serviceApp.getDownCount()));
            }
            itemTabGroupCardItemBinding.getRoot().setTag(Integer.valueOf(getAdapterPosition()));
            itemTabGroupCardItemBinding.actionButton.setTag(Integer.valueOf(getAdapterPosition()));
            itemTabGroupCardItemBinding.setServiceApp(serviceApp);
            itemTabGroupCardItemBinding.executePendingBindings();
        }
    }
}
