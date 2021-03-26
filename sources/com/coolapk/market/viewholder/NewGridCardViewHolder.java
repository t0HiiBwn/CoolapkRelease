package com.coolapk.market.viewholder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.databinding.ItemGridCardBinding;
import com.coolapk.market.databinding.ItemGridCardItemBinding;
import com.coolapk.market.databinding.ItemTitleViewBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Ads;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AppForum;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.CircleRadiusTransform;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ViewUtil;

public class NewGridCardViewHolder extends StateViewHolder {
    public static final int LAYOUT_ID = 2131558772;
    private final DataAdapter adapter;
    private final String apkType;
    private final ItemGridCardBinding binding;
    private EntityCard card;
    private final DataBindingComponent component;
    private final ItemActionHandler itemActionHandler;
    private int spanCount;
    private TitleViewPart viewPart;

    public NewGridCardViewHolder(View view, DataBindingComponent dataBindingComponent, String str, ItemActionHandler itemActionHandler2) {
        super(view, dataBindingComponent, itemActionHandler2);
        this.apkType = str;
        this.component = dataBindingComponent;
        this.itemActionHandler = itemActionHandler2;
        ItemGridCardBinding itemGridCardBinding = (ItemGridCardBinding) getBinding();
        this.binding = itemGridCardBinding;
        DataAdapter dataAdapter = new DataAdapter();
        this.adapter = dataAdapter;
        itemGridCardBinding.gridView.setAdapter(dataAdapter);
        itemGridCardBinding.gridView.setNestedScrollingEnabled(false);
        itemGridCardBinding.gridView.setItemAnimator(null);
        TitleViewPart newInstance = TitleViewPart.newInstance(itemGridCardBinding.gridView, this);
        this.viewPart = newInstance;
        ViewUtil.clickListener(((ItemTitleViewBinding) newInstance.getBinding()).closeView, this);
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        for (int i = 0; i < CollectionUtils.safeSize(this.card.getEntities()); i++) {
            Entity entity = this.card.getEntities().get(i);
            if ((entity instanceof ServiceApp) && isEventBelongTo(event, (ServiceApp) entity)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        EntityCard entityCard = (EntityCard) obj;
        this.card = entityCard;
        int i = 3;
        if (CollectionUtils.safeSize(entityCard.getEntities()) % 3 != 0) {
            i = 4;
        }
        this.spanCount = i;
        this.binding.gridView.setLayoutManager(new GridLayoutManager(getContext(), this.spanCount));
        this.adapter.notifyDataSetChanged();
        this.binding.setTitle(this.card.getTitle());
        int i2 = 0;
        boolean z = !CollectionUtils.isEmpty(this.card.getEntities()) ? this.card.getEntities().get(0) instanceof Ads : false;
        boolean z2 = !TextUtils.isEmpty(this.card.getUrl());
        this.viewPart.bindToContent(this.card);
        ((ItemTitleViewBinding) this.viewPart.getBinding()).closeView.setVisibility(z ? 0 : 8);
        ImageView imageView = ((ItemTitleViewBinding) this.viewPart.getBinding()).enterView;
        if (z || !z2) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        this.binding.executePendingBindings();
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        public DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(NewGridCardViewHolder.this.getContext()).inflate(2131558773, viewGroup, false);
            NewGridCardViewHolder newGridCardViewHolder = NewGridCardViewHolder.this;
            return new DataViewHolder(newGridCardViewHolder, inflate, newGridCardViewHolder.component, NewGridCardViewHolder.this.card.getUrl(), NewGridCardViewHolder.this.apkType, NewGridCardViewHolder.this.itemActionHandler);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            int i2;
            if (NewGridCardViewHolder.this.spanCount == 3) {
                i2 = DisplayUtils.dp2px(NewGridCardViewHolder.this.getContext(), 72.0f);
            } else {
                i2 = DisplayUtils.dp2px(NewGridCardViewHolder.this.getContext(), 52.0f);
            }
            DataViewHolder dataViewHolder = (DataViewHolder) bindingViewHolder;
            dataViewHolder.width = i2;
            dataViewHolder.height = i2;
            bindingViewHolder.bindTo(NewGridCardViewHolder.this.card.getEntities().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CollectionUtils.safeSize(NewGridCardViewHolder.this.card.getEntities());
        }
    }

    public static class DataViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558773;
        private final String apkType;
        public OnBitmapTransformListener circleTransform;
        public int follow = 0;
        public int height;
        public String info;
        public String logo;
        public ServiceApp serviceApp;
        public String title;
        public int titleLine;
        private final String url;
        public int width;

        public DataViewHolder(NewGridCardViewHolder newGridCardViewHolder, View view, DataBindingComponent dataBindingComponent, String str, String str2, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            this.url = str;
            this.apkType = str2;
            ItemGridCardItemBinding itemGridCardItemBinding = (ItemGridCardItemBinding) getBinding();
            ViewUtil.clickListener(itemGridCardItemBinding.getRoot(), newGridCardViewHolder);
            ViewUtil.directClickListener(itemGridCardItemBinding.actionButton, newGridCardViewHolder);
            ViewUtil.directClickListener(itemGridCardItemBinding.actionText, newGridCardViewHolder);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x00cc  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00d4  */
        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            boolean z;
            String str;
            ItemGridCardItemBinding itemGridCardItemBinding = (ItemGridCardItemBinding) getBinding();
            this.titleLine = 1;
            boolean z2 = false;
            if (obj instanceof ServiceApp) {
                ServiceApp serviceApp2 = (ServiceApp) obj;
                this.title = serviceApp2.getAppName();
                this.logo = serviceApp2.getLogo();
                if (TextUtils.equals(this.url, "/apk/newestList")) {
                    this.info = DateUtils.getTimeDescription(getContext(), serviceApp2.getLastUpdate());
                } else {
                    if (TextUtils.equals(this.apkType, "2")) {
                        str = serviceApp2.getApkSizeFormat();
                    } else {
                        str = getContext().getString(2131886701, serviceApp2.getDownCount());
                    }
                    this.info = str;
                }
                this.serviceApp = serviceApp2;
            } else if (obj instanceof Album) {
                Album album = (Album) obj;
                this.title = album.getTitle();
                this.logo = album.getIcon();
                this.info = null;
                this.serviceApp = null;
                this.titleLine = 2;
                z = true;
                if (!z2) {
                    this.circleTransform = new CircleTransform();
                } else if (z) {
                    this.circleTransform = new CircleRadiusTransform(NumberExtendsKt.getDpf(12), true);
                } else {
                    this.circleTransform = null;
                }
                itemGridCardItemBinding.setShowAction(z2);
                ViewGroup.LayoutParams layoutParams = itemGridCardItemBinding.iconView.getLayoutParams();
                layoutParams.width = this.width;
                layoutParams.height = this.height;
                itemGridCardItemBinding.iconView.setLayoutParams(layoutParams);
                itemGridCardItemBinding.getRoot().setTag(Integer.valueOf(getAdapterPosition()));
                itemGridCardItemBinding.actionButton.setTag(Integer.valueOf(getAdapterPosition()));
                itemGridCardItemBinding.actionText.setTag(Integer.valueOf(getAdapterPosition()));
                itemGridCardItemBinding.executePendingBindings();
            } else if (obj instanceof Ads) {
                Ads ads = (Ads) obj;
                this.title = ads.getTitle();
                this.logo = ads.getLogo();
                this.info = null;
                this.serviceApp = null;
                boolean equals = TextUtils.equals(ads.getAdsType(), "user");
                this.follow = ads.getFollow();
                z2 = equals;
            } else if (obj instanceof AppForum) {
                AppForum appForum = (AppForum) obj;
                this.title = appForum.title();
                this.logo = appForum.logo();
                this.info = getContext().getString(2131886669, appForum.commentCount());
                this.serviceApp = null;
            }
            z = false;
            if (!z2) {
            }
            itemGridCardItemBinding.setShowAction(z2);
            ViewGroup.LayoutParams layoutParams = itemGridCardItemBinding.iconView.getLayoutParams();
            layoutParams.width = this.width;
            layoutParams.height = this.height;
            itemGridCardItemBinding.iconView.setLayoutParams(layoutParams);
            itemGridCardItemBinding.getRoot().setTag(Integer.valueOf(getAdapterPosition()));
            itemGridCardItemBinding.actionButton.setTag(Integer.valueOf(getAdapterPosition()));
            itemGridCardItemBinding.actionText.setTag(Integer.valueOf(getAdapterPosition()));
            itemGridCardItemBinding.executePendingBindings();
        }
    }
}
