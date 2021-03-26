package com.coolapk.market.view.goodsList;

import android.content.Context;
import android.text.TextUtils;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.GoodsListItem;
import com.coolapk.market.util.DateUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010,\u001a\u0004\u0018\u00010\u000fJ\b\u0010-\u001a\u0004\u0018\u00010\u000fJ\b\u0010.\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010/\u001a\u00020\u001bJ\b\u00100\u001a\u0004\u0018\u00010\u000fJ\b\u00101\u001a\u0004\u0018\u00010\u000fJ\r\u00102\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u00103J\r\u00104\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u00103J\b\u00105\u001a\u0004\u0018\u00010\u000fJ\b\u00106\u001a\u0004\u0018\u00010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001c\u0010#\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001c\u0010&\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\u001c\u0010)\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013¨\u00067"}, d2 = {"Lcom/coolapk/market/view/goodsList/FunThingsViewModel;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "value", "Lcom/coolapk/market/model/Feed;", "feed", "getFeed", "()Lcom/coolapk/market/model/Feed;", "setFeed", "(Lcom/coolapk/market/model/Feed;)V", "funThingsCoverUrl", "", "getFunThingsCoverUrl", "()Ljava/lang/String;", "setFunThingsCoverUrl", "(Ljava/lang/String;)V", "funThingsDescription", "getFunThingsDescription", "setFunThingsDescription", "funThingsId", "getFunThingsId", "setFunThingsId", "funThingsIsEdit", "", "getFunThingsIsEdit", "()Z", "setFunThingsIsEdit", "(Z)V", "funThingsIsOpen", "getFunThingsIsOpen", "setFunThingsIsOpen", "funThingsTitle", "getFunThingsTitle", "setFunThingsTitle", "userAvatar", "getUserAvatar", "setUserAvatar", "userName", "getUserName", "setUserName", "funThingsUpdateTime", "getCoverUrl", "getDescription", "getHasPic", "getId", "getInfoText", "getIsEdit", "()Ljava/lang/Boolean;", "getIsOpen", "getTitle", "getUploadPic", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FunThingsViewModel.kt */
public final class FunThingsViewModel {
    private final Context context;
    private Feed feed;
    private String funThingsCoverUrl;
    private String funThingsDescription;
    private String funThingsId;
    private boolean funThingsIsEdit;
    private boolean funThingsIsOpen;
    private String funThingsTitle;
    private String userAvatar;
    private String userName;

    public FunThingsViewModel(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getFunThingsTitle() {
        return this.funThingsTitle;
    }

    public final void setFunThingsTitle(String str) {
        this.funThingsTitle = str;
    }

    public final String getFunThingsId() {
        return this.funThingsId;
    }

    public final void setFunThingsId(String str) {
        this.funThingsId = str;
    }

    public final String getFunThingsDescription() {
        return this.funThingsDescription;
    }

    public final void setFunThingsDescription(String str) {
        this.funThingsDescription = str;
    }

    public final String getFunThingsCoverUrl() {
        return this.funThingsCoverUrl;
    }

    public final void setFunThingsCoverUrl(String str) {
        this.funThingsCoverUrl = str;
    }

    public final String getUserAvatar() {
        return this.userAvatar;
    }

    public final void setUserAvatar(String str) {
        this.userAvatar = str;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    public final boolean getFunThingsIsOpen() {
        return this.funThingsIsOpen;
    }

    public final void setFunThingsIsOpen(boolean z) {
        this.funThingsIsOpen = z;
    }

    public final boolean getFunThingsIsEdit() {
        return this.funThingsIsEdit;
    }

    public final void setFunThingsIsEdit(boolean z) {
        this.funThingsIsEdit = z;
    }

    public final Feed getFeed() {
        return this.feed;
    }

    public final void setFeed(Feed feed2) {
        this.feed = feed2;
        String str = null;
        this.userAvatar = feed2 != null ? feed2.getUserAvatar() : null;
        Feed feed3 = this.feed;
        this.funThingsTitle = feed3 != null ? feed3.getTitle() : null;
        Feed feed4 = this.feed;
        this.funThingsDescription = feed4 != null ? feed4.getMessage() : null;
        Feed feed5 = this.feed;
        if (feed5 != null) {
            str = feed5.getUserName();
        }
        this.userName = str;
    }

    public final String funThingsUpdateTime() {
        Context context2 = this.context;
        Feed feed2 = this.feed;
        return DateUtils.getTimeDescription(context2, feed2 != null ? feed2.getLastUpdate() : null);
    }

    public final String getInfoText() {
        List<GoodsListItem> goodsListItem;
        StringBuilder sb = new StringBuilder();
        Feed feed2 = this.feed;
        Integer num = null;
        sb.append((feed2 == null || (goodsListItem = feed2.getGoodsListItem()) == null) ? null : Integer.valueOf(goodsListItem.size()));
        sb.append("个好物  ");
        Feed feed3 = this.feed;
        if (feed3 != null) {
            num = Integer.valueOf(feed3.getFavoriteNum());
        }
        sb.append(num);
        sb.append("个收藏");
        return sb.toString();
    }

    public final String getTitle() {
        return this.funThingsTitle;
    }

    public final String getId() {
        String id;
        Feed feed2 = this.feed;
        return (feed2 == null || (id = feed2.getId()) == null) ? this.funThingsId : id;
    }

    public final String getDescription() {
        String message;
        Feed feed2 = this.feed;
        return (feed2 == null || (message = feed2.getMessage()) == null) ? this.funThingsDescription : message;
    }

    public final String getCoverUrl() {
        String extraPic;
        Feed feed2 = this.feed;
        return (feed2 == null || (extraPic = feed2.getExtraPic()) == null) ? this.funThingsCoverUrl : extraPic;
    }

    public final String getUploadPic() {
        if (TextUtils.isEmpty(getCoverUrl())) {
            return "";
        }
        String coverUrl = getCoverUrl();
        Intrinsics.checkNotNull(coverUrl);
        return !StringsKt.startsWith$default(coverUrl, "http", false, 2, null) ? "" : getCoverUrl();
    }

    public final Boolean getIsOpen() {
        return Boolean.valueOf(this.funThingsIsOpen);
    }

    public final Boolean getIsEdit() {
        return Boolean.valueOf(this.funThingsIsOpen);
    }

    public final boolean getHasPic() {
        return !TextUtils.isEmpty(getCoverUrl());
    }
}
