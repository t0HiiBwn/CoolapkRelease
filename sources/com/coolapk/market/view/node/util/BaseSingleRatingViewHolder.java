package com.coolapk.market.view.node.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemSingleRatingBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.view.BadBadRatingBar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000fH&J\b\u0010\u0013\u001a\u00020\nH\u0004¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/node/util/BaseSingleRatingViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemSingleRatingBinding;", "Lcom/coolapk/market/model/Entity;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bindToContent", "", "data", "getRatingFeedUrl", "", "getStarCount", "", "onClick", "onRequestRatingFeed", "rating", "requestStarCountChanged", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseSingleRatingViewHolder.kt */
public abstract class BaseSingleRatingViewHolder extends GenericBindHolder<ItemSingleRatingBinding, Entity> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558941;

    public abstract String getRatingFeedUrl();

    public abstract int getStarCount();

    public abstract void onRequestRatingFeed(int i);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseSingleRatingViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ((ItemSingleRatingBinding) getBinding()).itemView.setOnClickListener(this);
        BadBadRatingBar badBadRatingBar = ((ItemSingleRatingBinding) getBinding()).ratingBar;
        badBadRatingBar.setProgressBar(NumberExtendsKt.getDp((Number) 18), false);
        badBadRatingBar.setProgressBackgroundTintList(ColorStateList.valueOf((int) 4292335575L));
        badBadRatingBar.setProgressTintList(ColorStateList.valueOf((int) 4294948626L));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/node/util/BaseSingleRatingViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BaseSingleRatingViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final void requestStarCountChanged() {
        int starCount = getStarCount();
        BadBadRatingBar badBadRatingBar = ((ItemSingleRatingBinding) getBinding()).ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar, "binding.ratingBar");
        badBadRatingBar.setRating((float) starCount);
        if (starCount <= 0) {
            TextView textView = ((ItemSingleRatingBinding) getBinding()).scoreTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.scoreTitle");
            textView.setText("点击星星评分");
            ((ItemSingleRatingBinding) getBinding()).ratingBar.setIsIndicator(false);
            ((ItemSingleRatingBinding) getBinding()).ratingBar.setOnRatingBarChangeListener(new BaseSingleRatingViewHolder$requestStarCountChanged$1(this));
            return;
        }
        TextView textView2 = ((ItemSingleRatingBinding) getBinding()).scoreTitle;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.scoreTitle");
        textView2.setText("我的打分");
        ((ItemSingleRatingBinding) getBinding()).ratingBar.setIsIndicator(true);
        ((ItemSingleRatingBinding) getBinding()).ratingBar.setOnRatingBarChangeListener(null);
    }

    @Override // com.coolapk.market.viewholder.GenericBindHolder
    public void bindToContent(Entity entity) {
        ItemSingleRatingBinding itemSingleRatingBinding = (ItemSingleRatingBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSingleRatingBinding, "binding");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        itemSingleRatingBinding.setLogo(loginSession.getUserAvatar());
        requestStarCountChanged();
        ((ItemSingleRatingBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == 2131362779) {
            String ratingFeedUrl = getRatingFeedUrl();
            if (getStarCount() > 0) {
                if (ratingFeedUrl.length() > 0) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    ActionManagerCompat.startActivityByUrl$default(context, ratingFeedUrl, null, null, 12, null);
                    return;
                }
            }
            BadBadRatingBar badBadRatingBar = ((ItemSingleRatingBinding) getBinding()).ratingBar;
            Intrinsics.checkNotNullExpressionValue(badBadRatingBar, "binding.ratingBar");
            onRequestRatingFeed((int) badBadRatingBar.getRating());
        }
    }
}
