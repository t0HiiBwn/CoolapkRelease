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
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.CircleRadiusTransform;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ViewUtil;

public class GridCardViewHolder extends StateViewHolder {
    public static final int LAYOUT_ID = 2131558772;
    private final DataAdapter adapter;
    private final ItemGridCardBinding binding;
    private EntityCard card;
    private final DataBindingComponent component;
    private final String entityType;
    private final ItemActionHandler itemActionHandler;
    private int spanCount;
    private TitleViewPart titleViewPart;

    public GridCardViewHolder(View view, DataBindingComponent dataBindingComponent, String str, ItemActionHandler itemActionHandler2) {
        super(view, dataBindingComponent, itemActionHandler2);
        this.entityType = str;
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
        this.titleViewPart = newInstance;
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
        this.titleViewPart.bindToContent(this.card);
        ((ItemTitleViewBinding) this.titleViewPart.getBinding()).closeView.setVisibility(z ? 0 : 8);
        ImageView imageView = ((ItemTitleViewBinding) this.titleViewPart.getBinding()).enterView;
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
            View inflate = LayoutInflater.from(GridCardViewHolder.this.getContext()).inflate(2131558773, viewGroup, false);
            GridCardViewHolder gridCardViewHolder = GridCardViewHolder.this;
            return new DataViewHolder(gridCardViewHolder, inflate, gridCardViewHolder.component, GridCardViewHolder.this.card.getUrl(), GridCardViewHolder.this.entityType, GridCardViewHolder.this.itemActionHandler);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            int i2;
            if (GridCardViewHolder.this.spanCount == 3) {
                i2 = DisplayUtils.dp2px(GridCardViewHolder.this.getContext(), 72.0f);
            } else {
                i2 = DisplayUtils.dp2px(GridCardViewHolder.this.getContext(), 52.0f);
            }
            DataViewHolder dataViewHolder = (DataViewHolder) bindingViewHolder;
            dataViewHolder.width = i2;
            dataViewHolder.height = i2;
            bindingViewHolder.bindTo(GridCardViewHolder.this.card.getEntities().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CollectionUtils.safeSize(GridCardViewHolder.this.card.getEntities());
        }
    }

    public static class DataViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558773;
        public OnBitmapTransformListener circleTransform;
        private final String entityType;
        public int follow = 0;
        public int height;
        public String info;
        public String logo;
        public ServiceApp serviceApp;
        public String title;
        public int titleLine;
        private final String url;
        public int width;

        public DataViewHolder(GridCardViewHolder gridCardViewHolder, View view, DataBindingComponent dataBindingComponent, String str, String str2, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            this.url = str;
            this.entityType = str2;
            ItemGridCardItemBinding itemGridCardItemBinding = (ItemGridCardItemBinding) getBinding();
            ViewUtil.clickListener(itemGridCardItemBinding.getRoot(), gridCardViewHolder);
            ViewUtil.directClickListener(itemGridCardItemBinding.actionButton, gridCardViewHolder);
            ViewUtil.directClickListener(itemGridCardItemBinding.actionText, gridCardViewHolder);
        }

        /* JADX WARNING: Removed duplicated region for block: B:36:0x0132  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x013a  */
        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            boolean z;
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
                    String str = this.entityType;
                    char c = 65535;
                    int hashCode = str.hashCode();
                    if (hashCode != 49) {
                        if (hashCode == 50 && str.equals("2")) {
                            c = 2;
                        }
                    } else if (str.equals("1")) {
                        c = 1;
                    }
                    if (c != 2) {
                        this.info = getContext().getString(2131886701, serviceApp2.getDownCount());
                    } else {
                        this.info = serviceApp2.getApkSizeFormat();
                    }
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
                itemGridCardItemBinding.setViewModel(this);
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
            } else if (obj instanceof DyhModel) {
                DyhModel dyhModel = (DyhModel) obj;
                this.title = dyhModel.getTitle();
                this.logo = dyhModel.getLogo();
                this.info = dyhModel.getFollowNum() + "人订阅";
                this.serviceApp = null;
            } else if (obj instanceof Entity) {
                Entity entity = (Entity) obj;
                this.title = entity.getTitle();
                this.logo = entity.getPic();
                this.info = entity.getSubTitle();
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
            itemGridCardItemBinding.setViewModel(this);
            itemGridCardItemBinding.executePendingBindings();
        }
    }
}
