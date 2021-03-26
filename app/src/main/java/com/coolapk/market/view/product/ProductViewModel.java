package com.coolapk.market.view.product;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.view.node.SavedStateListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010)\u001a\u00020\u001aJ\u0006\u0010*\u001a\u00020\u001aJ\u0006\u0010+\u001a\u00020\u001aJ\u0006\u0010,\u001a\u00020\u001aJ\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00101\u001a\u00020.2\u0006\u00102\u001a\u000200H\u0016R&\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u001a8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b!\u0010\fR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R&\u0010&\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000e¨\u00063"}, d2 = {"Lcom/coolapk/market/view/product/ProductViewModel;", "Landroidx/databinding/BaseObservable;", "Lcom/coolapk/market/view/node/SavedStateListener;", "context", "Landroid/content/Context;", "model", "Lcom/coolapk/market/model/Product;", "(Landroid/content/Context;Lcom/coolapk/market/model/Product;)V", "value", "", "buyStatus", "getBuyStatus", "()Z", "setBuyStatus", "(Z)V", "followState", "getFollowState", "setFollowState", "getModel", "()Lcom/coolapk/market/model/Product;", "ratingFeedUrl", "", "getRatingFeedUrl", "()Ljava/lang/String;", "setRatingFeedUrl", "(Ljava/lang/String;)V", "", "ratingScore", "getRatingScore", "()I", "setRatingScore", "(I)V", "ratingState", "getRatingState", "topIds", "", "getTopIds", "()Ljava/util/List;", "wishState", "getWishState", "setWishState", "getBuyCount", "getFollowCount", "getRatingNum", "getWishCount", "onInitSavedInstanceState", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductViewModel.kt */
public final class ProductViewModel extends BaseObservable implements SavedStateListener {
    @Bindable
    private boolean buyStatus;
    private final Context context;
    @Bindable
    private boolean followState;
    private final Product model;
    private String ratingFeedUrl;
    @Bindable
    private int ratingScore;
    private final List<String> topIds;
    @Bindable
    private boolean wishState;

    public ProductViewModel(Context context2, Product product) {
        String ratingFeedUrl2;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(product, "model");
        this.context = context2;
        this.model = product;
        ArrayList arrayList = new ArrayList();
        this.topIds = arrayList;
        String str = "";
        this.ratingFeedUrl = str;
        UserAction userAction = product.getUserAction();
        setFollowState(userAction != null && userAction.getFollow() == 1);
        UserAction userAction2 = product.getUserAction();
        setWishState(userAction2 != null && userAction2.getWish() == 1);
        UserAction userAction3 = product.getUserAction();
        setRatingScore(userAction3 != null ? userAction3.getRating() : 0);
        UserAction userAction4 = product.getUserAction();
        if (!(userAction4 == null || (ratingFeedUrl2 = userAction4.getRatingFeedUrl()) == null)) {
            str = ratingFeedUrl2;
        }
        this.ratingFeedUrl = str;
        UserAction userAction5 = product.getUserAction();
        setBuyStatus(userAction5 != null && userAction5.getBuy() == 1);
        List<String> topIds2 = product.getTopIds();
        Intrinsics.checkNotNullExpressionValue(topIds2, "model.topIds");
        ArrayList arrayList2 = new ArrayList();
        for (T t : topIds2) {
            T t2 = t;
            Intrinsics.checkNotNullExpressionValue(t2, "it");
            if (t2.length() > 0) {
                arrayList2.add(t);
            }
        }
        arrayList.addAll(arrayList2);
    }

    public final Product getModel() {
        return this.model;
    }

    public final List<String> getTopIds() {
        return this.topIds;
    }

    public final boolean getRatingState() {
        return this.ratingScore > 0;
    }

    public final String getRatingFeedUrl() {
        return this.ratingFeedUrl;
    }

    public final void setRatingFeedUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ratingFeedUrl = str;
    }

    public final int getRatingScore() {
        return this.ratingScore;
    }

    public final void setRatingScore(int i) {
        this.ratingScore = i;
        notifyPropertyChanged(228);
    }

    public final boolean getFollowState() {
        return this.followState;
    }

    public final void setFollowState(boolean z) {
        if (this.followState != z) {
            this.followState = z;
            notifyPropertyChanged(122);
        }
    }

    public final boolean getWishState() {
        return this.wishState;
    }

    public final void setWishState(boolean z) {
        if (this.wishState != z) {
            this.wishState = z;
            notifyPropertyChanged(321);
        }
    }

    public final boolean getBuyStatus() {
        return this.buyStatus;
    }

    public final void setBuyStatus(boolean z) {
        if (this.buyStatus != z) {
            this.buyStatus = z;
            notifyPropertyChanged(43);
        }
    }

    public final int getRatingNum() {
        UserAction userAction = this.model.getUserAction();
        if ((userAction == null || userAction.getRating() != 0) || !getRatingState()) {
            return this.model.getStarTotalCount();
        }
        return this.model.getStarTotalCount() + 1;
    }

    public final int getFollowCount() {
        UserAction userAction = this.model.getUserAction();
        boolean z = userAction != null && userAction.getFollow() == 1;
        if (z && !this.followState) {
            return this.model.getFollowNum() - 1;
        }
        if (z || !this.followState) {
            return this.model.getFollowNum();
        }
        return this.model.getFollowNum() + 1;
    }

    public final int getBuyCount() {
        UserAction userAction = this.model.getUserAction();
        boolean z = userAction != null && userAction.getBuy() == 1;
        if (z && !this.buyStatus) {
            return this.model.getBuyCount() - 1;
        }
        if (z || !this.buyStatus) {
            return this.model.getBuyCount();
        }
        return this.model.getBuyCount() + 1;
    }

    public final int getWishCount() {
        UserAction userAction = this.model.getUserAction();
        boolean z = userAction != null && userAction.getWish() == 1;
        if (z && !this.wishState) {
            return this.model.getWishCount() - 1;
        }
        if (z || !this.wishState) {
            return this.model.getWishCount();
        }
        return this.model.getWishCount() + 1;
    }

    @Override // com.coolapk.market.view.node.SavedStateListener
    public void onInitSavedInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.topIds.clear();
            List<String> list = this.topIds;
            ArrayList<String> stringArrayList = bundle.getStringArrayList("TOP_IDS");
            if (stringArrayList != null) {
                list.addAll(stringArrayList);
                setFollowState(bundle.getBoolean("FOLLOW_STATE"));
                setWishState(bundle.getBoolean("WISH_STATE"));
                setRatingScore(bundle.getInt("RATING_SCORE"));
                String string = bundle.getString("RATING_FEED_URL", "");
                Intrinsics.checkNotNullExpressionValue(string, "savedInstanceState.getSt…ng(\"RATING_FEED_URL\", \"\")");
                this.ratingFeedUrl = string;
                setBuyStatus(bundle.getBoolean("BUY_STATUS"));
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    @Override // com.coolapk.market.view.node.SavedStateListener
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        bundle.putStringArrayList("TOP_IDS", new ArrayList<>(this.topIds));
        bundle.putBoolean("FOLLOW_STATE", this.followState);
        bundle.putBoolean("WISH_STATE", this.wishState);
        bundle.putBoolean("BUY_STATUS", this.buyStatus);
        bundle.putInt("RATING_SCORE", this.ratingScore);
        bundle.putString("RATING_FEED_URL", this.ratingFeedUrl);
    }
}
