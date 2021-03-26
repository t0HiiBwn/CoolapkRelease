package com.coolapk.market.viewholder;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.databinding.ItemCardDoubleBinding;
import com.coolapk.market.databinding.ItemCardDoubleItemBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Card;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.CircleRadiusTransform;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.ViewUtil;
import java.util.ArrayList;
import java.util.List;

public class CardDoubleViewHolder extends CardViewHolder {
    public static final int LAYOUT_ID = 2131558630;
    private List<ChildItemViewModel> viewModelList;

    public static class ChildItemViewModel extends BaseObservable {
        public ObservableField<String> actionText = new ObservableField<>();
        public ObservableField<String> info = new ObservableField<>();
        public ObservableField<Boolean> isAlbum = new ObservableField<>();
        public ObservableField<String> logo = new ObservableField<>();
        public ObservableField<String> title = new ObservableField<>();
        public ObservableField<OnBitmapTransformListener> transform = new ObservableField<>();
    }

    public CardDoubleViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        ArrayList arrayList = new ArrayList(2);
        this.viewModelList = arrayList;
        arrayList.add(null);
        this.viewModelList.add(null);
    }

    @Override // com.coolapk.market.viewholder.CardViewHolder, com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        super.bindTo(obj);
        ItemCardDoubleBinding itemCardDoubleBinding = (ItemCardDoubleBinding) getBinding();
        itemCardDoubleBinding.setCard((Card) obj);
        itemCardDoubleBinding.executePendingBindings();
        ViewUtil.clickListener(itemCardDoubleBinding.moreView, this);
    }

    @Override // com.coolapk.market.viewholder.CardViewHolder
    protected int getItemViewCount() {
        return this.viewModelList.size();
    }

    @Override // com.coolapk.market.viewholder.CardViewHolder
    protected View onFindChildView(View view, int i) {
        return view.findViewById(i != 0 ? i != 1 ? -1 : 2131362773 : 2131362769);
    }

    @Override // com.coolapk.market.viewholder.CardViewHolder
    protected void onChildBindTo(ViewDataBinding viewDataBinding, Object obj, int i) {
        ViewUtil.clickListener(viewDataBinding.getRoot(), this);
        viewDataBinding.getRoot().setTag(Integer.valueOf(i));
        ChildItemViewModel childItemViewModel = this.viewModelList.get(i);
        if (childItemViewModel == null) {
            childItemViewModel = new ChildItemViewModel();
            this.viewModelList.add(childItemViewModel);
        }
        ItemCardDoubleItemBinding itemCardDoubleItemBinding = (ItemCardDoubleItemBinding) viewDataBinding;
        Entity entity = (Entity) obj;
        String entityType = entity.getEntityType();
        entityType.hashCode();
        if (entityType.equals("apk")) {
            ServiceApp serviceApp = (ServiceApp) entity;
            childItemViewModel.title.set(serviceApp.getAppName());
            childItemViewModel.logo.set(serviceApp.getLogo());
            childItemViewModel.info.set(getContext().getString(2131886640, serviceApp.getScore()));
            childItemViewModel.actionText.set(StateUtils.getActionText(getContext(), true, serviceApp.getPackageName(), serviceApp.getPackageName(), serviceApp.getDownloadUrlMd5(0)));
            ViewUtil.directClickListener(itemCardDoubleItemBinding.actionButton, this);
            itemCardDoubleItemBinding.actionButton.setTag(Integer.valueOf(i));
            childItemViewModel.isAlbum.set(false);
            childItemViewModel.transform.set(null);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) itemCardDoubleItemBinding.infoView.getLayoutParams();
            layoutParams.addRule(14, 0);
            itemCardDoubleItemBinding.infoView.setLayoutParams(layoutParams);
        } else if (!entityType.equals("album")) {
            throw new RuntimeException("Unknown entity type " + entity.getEntityType());
        } else {
            Album album = (Album) entity;
            childItemViewModel.title.set(album.getTitle());
            childItemViewModel.logo.set(album.getIcon());
            childItemViewModel.info.set(getContext().getString(2131886638, Integer.valueOf(album.getTotalApkNum())));
            childItemViewModel.actionText.set(null);
            childItemViewModel.isAlbum.set(true);
            childItemViewModel.transform.set(new CircleRadiusTransform(NumberExtendsKt.getDpf(12), true));
            ViewUtil.directClickListener(itemCardDoubleItemBinding.actionButton, null);
            itemCardDoubleItemBinding.actionButton.setTag(null);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) itemCardDoubleItemBinding.infoView.getLayoutParams();
            layoutParams2.addRule(14, -1);
            itemCardDoubleItemBinding.infoView.setLayoutParams(layoutParams2);
        }
        itemCardDoubleItemBinding.setViewModel(childItemViewModel);
        itemCardDoubleItemBinding.actionButton.setOnClickListener(this);
        itemCardDoubleItemBinding.executePendingBindings();
    }
}
