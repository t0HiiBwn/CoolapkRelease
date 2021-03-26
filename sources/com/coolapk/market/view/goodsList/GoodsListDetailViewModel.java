package com.coolapk.market.view.goodsList;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.GoodsListItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0007J\n\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0007J\n\u0010 \u001a\u0004\u0018\u00010\nH\u0007J\n\u0010!\u001a\u0004\u0018\u00010\nH\u0007J\n\u0010\"\u001a\u0004\u0018\u00010\nH\u0007J\b\u0010#\u001a\u00020\nH\u0007R*\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\n8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\n8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR*\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\n8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00178\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0019\"\u0004\b\u001c\u0010\u001d¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodsListDetailViewModel;", "Landroidx/databinding/BaseObservable;", "()V", "value", "Lcom/coolapk/market/model/Feed;", "goodsList", "getGoodsList", "()Lcom/coolapk/market/model/Feed;", "setGoodsList", "(Lcom/coolapk/market/model/Feed;)V", "", "goodsListCover", "getGoodsListCover", "()Ljava/lang/String;", "setGoodsListCover", "(Ljava/lang/String;)V", "goodsListMessage", "getGoodsListMessage", "setGoodsListMessage", "goodsListTitle", "getGoodsListTitle", "setGoodsListTitle", "<set-?>", "", "isLoginUser", "()Z", "loading", "getLoading", "setLoading", "(Z)V", "getCoverUrl", "getGoodsListId", "getGoodsListInfo", "getGoodsShowMessage", "getGoodsShowTitle", "getUserAvatar", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsListDetailViewModel.kt */
public final class GoodsListDetailViewModel extends BaseObservable {
    @Bindable
    private Feed goodsList;
    @Bindable
    private String goodsListCover;
    @Bindable
    private String goodsListMessage;
    @Bindable
    private String goodsListTitle;
    private boolean isLoginUser;
    @Bindable
    private boolean loading;

    public final Feed getGoodsList() {
        return this.goodsList;
    }

    public final void setGoodsList(Feed feed) {
        boolean z;
        this.goodsList = feed;
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (loginSession.isLogin()) {
            String uid = loginSession.getUid();
            Feed feed2 = this.goodsList;
            if (Intrinsics.areEqual(uid, feed2 != null ? feed2.getUid() : null)) {
                z = true;
                this.isLoginUser = z;
                notifyPropertyChanged(142);
                notifyPropertyChanged(141);
                notifyPropertyChanged(135);
                notifyPropertyChanged(61);
                notifyPropertyChanged(138);
                notifyPropertyChanged(136);
                notifyPropertyChanged(144);
                notifyPropertyChanged(143);
            }
        }
        z = false;
        this.isLoginUser = z;
        notifyPropertyChanged(142);
        notifyPropertyChanged(141);
        notifyPropertyChanged(135);
        notifyPropertyChanged(61);
        notifyPropertyChanged(138);
        notifyPropertyChanged(136);
        notifyPropertyChanged(144);
        notifyPropertyChanged(143);
    }

    public final String getGoodsListTitle() {
        return this.goodsListTitle;
    }

    public final void setGoodsListTitle(String str) {
        this.goodsListTitle = str;
        notifyPropertyChanged(142);
        notifyPropertyChanged(144);
    }

    @Bindable
    public final String getCoverUrl() {
        String str = this.goodsListCover;
        if (str != null) {
            return str;
        }
        Feed feed = this.goodsList;
        if (feed != null) {
            return feed.getExtraPic();
        }
        return null;
    }

    public final String getGoodsListCover() {
        return this.goodsListCover;
    }

    public final void setGoodsListCover(String str) {
        this.goodsListCover = str;
        notifyPropertyChanged(136);
    }

    @Bindable
    public final String getGoodsListId() {
        Feed feed = this.goodsList;
        if (feed != null) {
            return feed.getId();
        }
        return null;
    }

    @Bindable
    public final String getGoodsShowTitle() {
        String str = this.goodsListTitle;
        if (str != null) {
            return str;
        }
        Feed feed = this.goodsList;
        if (feed != null) {
            return feed.getTitle();
        }
        return null;
    }

    @Bindable
    public final String getGoodsShowMessage() {
        String str = this.goodsListMessage;
        if (str != null) {
            return str;
        }
        Feed feed = this.goodsList;
        if (feed != null) {
            return feed.getMessage();
        }
        return null;
    }

    public final String getGoodsListMessage() {
        return this.goodsListMessage;
    }

    public final void setGoodsListMessage(String str) {
        this.goodsListMessage = str;
        notifyPropertyChanged(141);
        notifyPropertyChanged(143);
    }

    public final boolean getLoading() {
        return this.loading;
    }

    public final void setLoading(boolean z) {
        this.loading = z;
        notifyPropertyChanged(186);
    }

    @Bindable
    public final String getUserAvatar() {
        String userAvatar;
        Feed feed = this.goodsList;
        return (feed == null || (userAvatar = feed.getUserAvatar()) == null) ? "" : userAvatar;
    }

    @Bindable
    public final String getGoodsListInfo() {
        List<GoodsListItem> goodsListItem;
        StringBuilder sb = new StringBuilder();
        Feed feed = this.goodsList;
        Integer num = null;
        sb.append((feed == null || (goodsListItem = feed.getGoodsListItem()) == null) ? null : Integer.valueOf(goodsListItem.size()));
        sb.append("个好物 ");
        Feed feed2 = this.goodsList;
        if (feed2 != null) {
            num = Integer.valueOf(feed2.getFollowNum());
        }
        sb.append(num);
        sb.append("人关注");
        return sb.toString();
    }

    public final boolean isLoginUser() {
        return this.isLoginUser;
    }
}
