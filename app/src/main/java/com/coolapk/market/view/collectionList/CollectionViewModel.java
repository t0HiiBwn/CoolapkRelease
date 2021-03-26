package com.coolapk.market.view.collectionList;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.util.DateUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR&\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionViewModel;", "Landroidx/databinding/BaseObservable;", "context", "Landroid/content/Context;", "collection", "Lcom/coolapk/market/model/Collection;", "(Landroid/content/Context;Lcom/coolapk/market/model/Collection;)V", "getCollection", "()Lcom/coolapk/market/model/Collection;", "value", "", "collectionFollowNumber", "getCollectionFollowNumber", "()I", "setCollectionFollowNumber", "(I)V", "getContext", "()Landroid/content/Context;", "collectionCover", "", "collectionDescription", "collectionFollowNum", "collectionTitle", "collectionUpdateTime", "collectionUserAvatar", "collectionUserName", "hasCover", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CollectionViewModel.kt */
public final class CollectionViewModel extends BaseObservable {
    private final Collection collection;
    @Bindable
    private int collectionFollowNumber;
    private final Context context;

    public CollectionViewModel(Context context2, Collection collection2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(collection2, "collection");
        this.context = context2;
        this.collection = collection2;
        this.collectionFollowNumber = collection2.getFollowNum();
    }

    public final Collection getCollection() {
        return this.collection;
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getCollectionFollowNumber() {
        return this.collectionFollowNumber;
    }

    public final void setCollectionFollowNumber(int i) {
        this.collectionFollowNumber = i;
        notifyPropertyChanged(51);
    }

    public final String collectionTitle() {
        return this.collection.getTitle();
    }

    public final String collectionUserName() {
        UserInfo userInfo = this.collection.getUserInfo();
        Intrinsics.checkNotNull(userInfo);
        Intrinsics.checkNotNullExpressionValue(userInfo, "collection.userInfo!!");
        return userInfo.getDisplayUserName();
    }

    public final String collectionUserAvatar() {
        UserInfo userInfo = this.collection.getUserInfo();
        Intrinsics.checkNotNull(userInfo);
        Intrinsics.checkNotNullExpressionValue(userInfo, "collection.userInfo!!");
        return userInfo.getUserAvatar();
    }

    public final String collectionUpdateTime() {
        return DateUtils.getTimeDescription(this.context, this.collection.getLastUpdate()) + "更新";
    }

    public final String collectionFollowNum() {
        return this.collectionFollowNumber + "人关注";
    }

    public final String collectionDescription() {
        return this.collection.getDescription();
    }

    public final String collectionCover() {
        return this.collection.getCoverPic();
    }

    public final Collection collection() {
        return this.collection;
    }

    public final boolean hasCover() {
        return !TextUtils.isEmpty(this.collection.getCoverPic());
    }
}
