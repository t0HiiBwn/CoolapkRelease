package com.coolapk.market.view.app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemRelateAppCardBinding;
import com.coolapk.market.databinding.ItemTabGroupCardItemBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.StateViewHolder;

public class RelateAppViewHolder extends StateViewHolder {
    public static final int LAYOUT_ID = 2131558901;
    private final DataAdapter adapter;
    private final DataBindingComponent component;
    private RelatedAppCard gridCard;
    private final AppViewViewModel viewModel;

    public RelateAppViewHolder(View view, AppViewViewModel appViewViewModel, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        this.component = dataBindingComponent;
        this.viewModel = appViewViewModel;
        this.gridCard = new RelatedAppCard(getContext(), appViewViewModel.getServiceApp());
        ItemRelateAppCardBinding itemRelateAppCardBinding = (ItemRelateAppCardBinding) getBinding();
        DataAdapter dataAdapter = new DataAdapter();
        this.adapter = dataAdapter;
        itemRelateAppCardBinding.gridView.setAdapter(dataAdapter);
        itemRelateAppCardBinding.gridView.setNestedScrollingEnabled(false);
        itemRelateAppCardBinding.gridView.setItemAnimator(null);
        itemRelateAppCardBinding.gridView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        ViewUtil.clickListener(itemRelateAppCardBinding.moreView, this);
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
        this.adapter.notifyDataSetChanged();
        ItemRelateAppCardBinding itemRelateAppCardBinding = (ItemRelateAppCardBinding) getBinding();
        itemRelateAppCardBinding.setTitle(this.gridCard.getTitle());
        itemRelateAppCardBinding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == 2131362982) {
            ActionManager.startRelatedAppsActivity(getContext(), this.viewModel.getServiceApp().getKeywords());
        }
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        public DataAdapter() {
            setHasStableIds(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new DataViewHolder(RelateAppViewHolder.this.viewModel, LayoutInflater.from(RelateAppViewHolder.this.getContext()).inflate(2131558950, viewGroup, false), RelateAppViewHolder.this.component);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(RelateAppViewHolder.this.gridCard.getEntities().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CollectionUtils.safeSize(RelateAppViewHolder.this.gridCard.getEntities());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return Long.valueOf(RelateAppViewHolder.this.gridCard.getEntities().get(i).getApkId()).longValue();
        }
    }

    public static class DataViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558950;
        private final AppViewViewModel viewModel;

        public DataViewHolder(AppViewViewModel appViewViewModel, View view, DataBindingComponent dataBindingComponent) {
            super(view, dataBindingComponent, null);
            this.viewModel = appViewViewModel;
            ItemTabGroupCardItemBinding itemTabGroupCardItemBinding = (ItemTabGroupCardItemBinding) getBinding();
            ViewUtil.clickListener(itemTabGroupCardItemBinding.getRoot(), this);
            ViewUtil.directClickListener(itemTabGroupCardItemBinding.actionButton, this);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemTabGroupCardItemBinding itemTabGroupCardItemBinding = (ItemTabGroupCardItemBinding) getBinding();
            ServiceApp serviceApp = (ServiceApp) obj;
            itemTabGroupCardItemBinding.infoView.setText(getContext().getString(2131886701, serviceApp.getDownCount()));
            itemTabGroupCardItemBinding.getRoot().setTag(Integer.valueOf(getAdapterPosition()));
            itemTabGroupCardItemBinding.actionButton.setTag(Integer.valueOf(getAdapterPosition()));
            itemTabGroupCardItemBinding.setServiceApp(serviceApp);
            itemTabGroupCardItemBinding.executePendingBindings();
        }

        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00b5: APUT  (r4v2 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r10v7 java.lang.String) */
        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            super.onClick(view);
            int id = view.getId();
            if (id == 2131361877) {
                ServiceApp serviceApp = this.viewModel.getServiceApp().getRelatedRows().get(((Integer) view.getTag()).intValue());
                MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
                UpgradeInfo upgradeInfo = mobileAppExistFast != null ? mobileAppExistFast.getUpgradeInfo() : null;
                ClickInfo.Builder targetUrl = ClickInfo.newBuilder(serviceApp).packageName(serviceApp.getPackageName()).targetUrl(serviceApp.getDownloadUrl(0));
                String[] strArr = new String[4];
                strArr[0] = serviceApp.getDownloadUrlMd5(0);
                strArr[1] = serviceApp.getDownloadUrlMd5(2);
                strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
                strArr[3] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(1) : null;
                StateUtils.handleClick((Activity) getContext(), targetUrl.downloadKeys(strArr).build(), null);
            } else if (id == 2131362779) {
                View findViewById = view.findViewById(2131362683);
                ServiceApp serviceApp2 = this.viewModel.getServiceApp().getRelatedRows().get(((Integer) view.getTag()).intValue());
                ActionManager.startAppViewActivity((Activity) getContext(), findViewById, serviceApp2.getPackageName(), serviceApp2.getLogo(), serviceApp2.getAppName(), serviceApp2.getExtraAnalysisData(), serviceApp2.getRequestContext(), serviceApp2.getExtraFromApi());
            }
        }
    }
}
