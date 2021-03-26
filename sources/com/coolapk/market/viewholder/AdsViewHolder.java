package com.coolapk.market.viewholder;

import android.text.TextUtils;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemAdsBinding;
import com.coolapk.market.event.AdsFollowEvent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Ads;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.widget.Toast;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;
import rx.functions.Action0;

public class AdsViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558581;
    private Ads ads;
    private boolean isRequesting;

    public AdsViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        ItemAdsBinding itemAdsBinding = (ItemAdsBinding) getBinding();
        ViewUtil.clickListener(itemAdsBinding.getRoot(), this);
        ViewUtil.clickListener(itemAdsBinding.actionView, this);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        this.ads = (Ads) obj;
        ItemAdsBinding itemAdsBinding = (ItemAdsBinding) getBinding();
        itemAdsBinding.setCard(this.ads);
        boolean equals = TextUtils.equals(this.ads.getAdsType(), "user");
        itemAdsBinding.setShowAction(equals);
        itemAdsBinding.setCircleTransform(equals ? new CircleTransform() : null);
        itemAdsBinding.executePendingBindings();
        this.isRequesting = false;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id != 2131361982) {
            if (id == 2131362779) {
                ActionManager.startActivityByUrl(getContext(), this.ads.getUrl());
            }
        } else if ("user".equals(this.ads.getAdsType())) {
            followUser();
        }
    }

    private void followUser() {
        if (!this.isRequesting) {
            String uid = this.ads.getUid();
            this.isRequesting = true;
            DataManager.getInstance().followUser(uid).compose(RxUtils.applyIOSchedulers()).doOnCompleted(new Action0() {
                /* class com.coolapk.market.viewholder.AdsViewHolder.AnonymousClass2 */

                @Override // rx.functions.Action0
                public void call() {
                    AdsViewHolder.this.isRequesting = false;
                }
            }).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new Subscriber<Integer>() {
                /* class com.coolapk.market.viewholder.AdsViewHolder.AnonymousClass1 */

                @Override // rx.Observer
                public void onCompleted() {
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    Toast.error(AppHolder.getApplication(), th);
                }

                public void onNext(Integer num) {
                    EventBus.getDefault().post(new AdsFollowEvent(AdsViewHolder.this.ads, num.intValue()));
                }
            });
        }
    }
}
