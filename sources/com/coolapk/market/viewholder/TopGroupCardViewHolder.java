package com.coolapk.market.viewholder;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemTopGroupCardBinding;
import com.coolapk.market.databinding.ItemTopGroupCardItemBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.TopGroupCard;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.widget.TriangleDrawable;
import java.util.List;

public class TopGroupCardViewHolder extends StateViewHolder {
    public static final int LAYOUT_ID = 2131558966;
    private final DataAdapter adapter;
    private TopGroupCard card;
    private final DataBindingComponent component;
    private final ItemActionHandler itemActionHandler;
    private List<ServiceApp> serviceApps;
    private int spanCount;

    public TopGroupCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler2) {
        super(view, dataBindingComponent, itemActionHandler2);
        this.component = dataBindingComponent;
        this.itemActionHandler = itemActionHandler2;
        ItemTopGroupCardBinding itemTopGroupCardBinding = (ItemTopGroupCardBinding) getBinding();
        ViewUtil.clickListener(itemTopGroupCardBinding.itemViewTopLeft, this);
        ViewUtil.clickListener(itemTopGroupCardBinding.itemViewTopRight, this);
        ViewUtil.clickListener(itemTopGroupCardBinding.itemViewImageTopLeft, this);
        ViewUtil.clickListener(itemTopGroupCardBinding.itemViewImageTopRight, this);
        DataAdapter dataAdapter = new DataAdapter();
        this.adapter = dataAdapter;
        itemTopGroupCardBinding.gridView.setAdapter(dataAdapter);
        itemTopGroupCardBinding.gridView.setNestedScrollingEnabled(false);
        itemTopGroupCardBinding.gridView.setItemAnimator(null);
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        for (int i = 0; i < CollectionUtils.safeSize(this.serviceApps); i++) {
            if (isEventBelongTo(event, this.serviceApps.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        TopGroupCard topGroupCard = (TopGroupCard) obj;
        this.card = topGroupCard;
        this.serviceApps = topGroupCard.getEntities().get(2).getEntities();
        ItemTopGroupCardBinding itemTopGroupCardBinding = (ItemTopGroupCardBinding) getBinding();
        itemTopGroupCardBinding.setCard(this.card);
        int i = 3;
        if (CollectionUtils.safeSize(this.serviceApps) % 3 != 0) {
            i = 4;
        }
        this.spanCount = i;
        itemTopGroupCardBinding.gridView.setLayoutManager(new GridLayoutManager(getContext(), this.spanCount));
        this.adapter.notifyDataSetChanged();
        itemTopGroupCardBinding.setOnBitmapTransform(new CircleTransform());
        itemTopGroupCardBinding.executePendingBindings();
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        public DataAdapter() {
            setHasStableIds(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(TopGroupCardViewHolder.this.getContext()).inflate(2131558967, viewGroup, false);
            TopGroupCardViewHolder topGroupCardViewHolder = TopGroupCardViewHolder.this;
            return new DataViewHolder(topGroupCardViewHolder, inflate, topGroupCardViewHolder.component, TopGroupCardViewHolder.this.itemActionHandler);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            int i2;
            if (TopGroupCardViewHolder.this.spanCount == 3) {
                i2 = DisplayUtils.dp2px(TopGroupCardViewHolder.this.getContext(), 72.0f);
            } else {
                i2 = DisplayUtils.dp2px(TopGroupCardViewHolder.this.getContext(), 52.0f);
            }
            DataViewHolder dataViewHolder = (DataViewHolder) bindingViewHolder;
            dataViewHolder.width = i2;
            dataViewHolder.height = i2;
            bindingViewHolder.bindTo(TopGroupCardViewHolder.this.serviceApps.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CollectionUtils.safeSize(TopGroupCardViewHolder.this.serviceApps);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return Long.valueOf(((ServiceApp) TopGroupCardViewHolder.this.serviceApps.get(i)).getApkId()).longValue();
        }
    }

    public static class DataViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558967;
        public int height;
        public int width;

        public DataViewHolder(TopGroupCardViewHolder topGroupCardViewHolder, View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            ItemTopGroupCardItemBinding itemTopGroupCardItemBinding = (ItemTopGroupCardItemBinding) getBinding();
            ViewUtil.clickListener(itemTopGroupCardItemBinding.getRoot(), topGroupCardViewHolder);
            ViewUtil.directClickListener(itemTopGroupCardItemBinding.actionButton, topGroupCardViewHolder);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            TriangleDrawable triangleDrawable;
            ItemTopGroupCardItemBinding itemTopGroupCardItemBinding = (ItemTopGroupCardItemBinding) getBinding();
            ServiceApp serviceApp = (ServiceApp) obj;
            itemTopGroupCardItemBinding.getRoot().setTag(Integer.valueOf(getAdapterPosition()));
            itemTopGroupCardItemBinding.actionButton.setTag(Integer.valueOf(getAdapterPosition()));
            itemTopGroupCardItemBinding.setServiceApp(serviceApp);
            if (TextUtils.equals(serviceApp.getUpdateFlag(), "Hot")) {
                triangleDrawable = new TriangleDrawable(Color.parseColor("#F16C66"));
            } else {
                triangleDrawable = new TriangleDrawable(AppHolder.getAppTheme().getColorAccent());
            }
            String createUpdateFlag = createUpdateFlag(serviceApp);
            itemTopGroupCardItemBinding.flagTextView.setText(createUpdateFlag);
            itemTopGroupCardItemBinding.flagBgView.setBackground(triangleDrawable);
            itemTopGroupCardItemBinding.flagView.setVisibility(createUpdateFlag == null ? 8 : 0);
            ViewGroup.LayoutParams layoutParams = itemTopGroupCardItemBinding.iconView.getLayoutParams();
            layoutParams.width = this.width;
            layoutParams.height = this.height;
            itemTopGroupCardItemBinding.iconView.setLayoutParams(layoutParams);
            itemTopGroupCardItemBinding.getRoot().setTag(Integer.valueOf(getAdapterPosition()));
            itemTopGroupCardItemBinding.actionButton.setTag(Integer.valueOf(getAdapterPosition()));
            itemTopGroupCardItemBinding.executePendingBindings();
        }

        private String createUpdateFlag(ServiceApp serviceApp) {
            String updateFlag = serviceApp.getUpdateFlag();
            updateFlag.hashCode();
            char c = 65535;
            switch (updateFlag.hashCode()) {
                case 68597:
                    if (updateFlag.equals("Dev")) {
                        c = 0;
                        break;
                    }
                    break;
                case 72749:
                    if (updateFlag.equals("Hot")) {
                        c = 1;
                        break;
                    }
                    break;
                case 78208:
                    if (updateFlag.equals("New")) {
                        c = 2;
                        break;
                    }
                    break;
                case 26331666:
                    if (updateFlag.equals("有礼包")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return "DEV";
                case 1:
                    return "HOT";
                case 2:
                    return "NEW";
                case 3:
                    return "礼包";
                default:
                    return null;
            }
        }
    }
}
