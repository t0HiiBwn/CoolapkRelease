package com.coolapk.market.viewholder;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemCardTripleBinding;
import com.coolapk.market.databinding.ItemCardTripleItemBinding;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Card;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.ViewUtil;
import java.util.ArrayList;
import java.util.List;

public class CardTripleViewHolder extends CardViewHolder {
    public static final int LAYOUT_ID = 2131558640;
    private List<ChildItemViewModel> viewModelList;

    public static class ChildItemViewModel extends BaseObservable {
        public ObservableField<String> actionText = new ObservableField<>();
        public ObservableField<String> info = new ObservableField<>();
        public ObservableField<String> logo = new ObservableField<>();
        public ObservableField<String> title = new ObservableField<>();
    }

    public CardTripleViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        ArrayList arrayList = new ArrayList(3);
        this.viewModelList = arrayList;
        arrayList.add(null);
        this.viewModelList.add(null);
        this.viewModelList.add(null);
    }

    @Override // com.coolapk.market.viewholder.CardViewHolder, com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        super.bindTo(obj);
        ItemCardTripleBinding itemCardTripleBinding = (ItemCardTripleBinding) getBinding();
        itemCardTripleBinding.setCard((Card) obj);
        itemCardTripleBinding.executePendingBindings();
        ViewUtil.clickListener(itemCardTripleBinding.moreView, this);
    }

    @Override // com.coolapk.market.viewholder.CardViewHolder
    protected int getItemViewCount() {
        return this.viewModelList.size();
    }

    @Override // com.coolapk.market.viewholder.CardViewHolder
    protected View onFindChildView(View view, int i) {
        return view.findViewById(i != 0 ? i != 1 ? i != 2 ? -1 : 2131362785 : 2131362784 : 2131362780);
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
        ItemCardTripleItemBinding itemCardTripleItemBinding = (ItemCardTripleItemBinding) viewDataBinding;
        Entity entity = (Entity) obj;
        String entityType = entity.getEntityType();
        entityType.hashCode();
        if (entityType.equals("apk")) {
            ServiceApp serviceApp = (ServiceApp) entity;
            childItemViewModel.title.set(serviceApp.getAppName());
            childItemViewModel.logo.set(serviceApp.getLogo());
            childItemViewModel.info.set(getContext().getString(2131886702, serviceApp.getScore()));
            childItemViewModel.actionText.set(StateUtils.getActionText(getContext(), true, serviceApp.getPackageName(), serviceApp.getPackageName(), serviceApp.getDownloadUrlMd5(0)));
            ViewUtil.directClickListener(itemCardTripleItemBinding.actionButton, this);
            itemCardTripleItemBinding.actionButton.setTag(Integer.valueOf(i));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) itemCardTripleItemBinding.infoView.getLayoutParams();
            layoutParams.addRule(14, 0);
            itemCardTripleItemBinding.infoView.setLayoutParams(layoutParams);
        } else if (!entityType.equals("album")) {
            throw new RuntimeException("Unknown entity type " + entity.getEntityType());
        } else {
            Album album = (Album) entity;
            childItemViewModel.title.set(album.getTitle());
            childItemViewModel.logo.set(album.getLogo());
            childItemViewModel.info.set(getContext().getString(2131886700, Integer.valueOf(album.getTotalApkNum())));
            childItemViewModel.actionText.set(null);
            ViewUtil.directClickListener(itemCardTripleItemBinding.actionButton, null);
            itemCardTripleItemBinding.actionButton.setTag(null);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) itemCardTripleItemBinding.infoView.getLayoutParams();
            layoutParams2.addRule(14, -1);
            itemCardTripleItemBinding.infoView.setLayoutParams(layoutParams2);
        }
        itemCardTripleItemBinding.setViewModel(childItemViewModel);
        ViewUtil.directClickListener(itemCardTripleItemBinding.actionButton, this);
        itemCardTripleItemBinding.executePendingBindings();
    }
}
