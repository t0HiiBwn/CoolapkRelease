package com.coolapk.market.view.goodsList;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.coolapk.market.model.GoodsListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0007J\b\u0010\u0017\u001a\u00020\u0004H\u0007J\b\u0010\u0018\u001a\u00020\u0004H\u0007R*\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodsListItemViewModel;", "Landroidx/databinding/BaseObservable;", "()V", "value", "", "goodsItemLogo", "getGoodsItemLogo", "()Ljava/lang/String;", "setGoodsItemLogo", "(Ljava/lang/String;)V", "goodsItemTitle", "getGoodsItemTitle", "setGoodsItemTitle", "Lcom/coolapk/market/model/GoodsListItem;", "goodsListItem", "getGoodsListItem", "()Lcom/coolapk/market/model/GoodsListItem;", "setGoodsListItem", "(Lcom/coolapk/market/model/GoodsListItem;)V", "itemNote", "getItemNote", "setItemNote", "getGoodsListItemNote", "getProductGoodsLogo", "getProductGoodsTitle", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsListItemViewModel.kt */
public final class GoodsListItemViewModel extends BaseObservable {
    @Bindable
    private String goodsItemLogo;
    @Bindable
    private String goodsItemTitle;
    @Bindable
    private GoodsListItem goodsListItem;
    @Bindable
    private String itemNote;

    public final GoodsListItem getGoodsListItem() {
        return this.goodsListItem;
    }

    public final void setGoodsListItem(GoodsListItem goodsListItem2) {
        this.goodsListItem = goodsListItem2;
        notifyPropertyChanged(139);
        notifyPropertyChanged(176);
        notifyPropertyChanged(140);
        notifyPropertyChanged(133);
    }

    @Bindable
    public final String getGoodsListItemNote() {
        String str = this.itemNote;
        if (str == null) {
            GoodsListItem goodsListItem2 = this.goodsListItem;
            str = goodsListItem2 != null ? goodsListItem2.getNote() : null;
            Intrinsics.checkNotNull(str);
            Intrinsics.checkNotNullExpressionValue(str, "goodsListItem?.note!!");
        }
        return str;
    }

    public final String getItemNote() {
        return this.itemNote;
    }

    public final void setItemNote(String str) {
        this.itemNote = str;
        notifyPropertyChanged(176);
        notifyPropertyChanged(140);
    }

    @Bindable
    public final String getProductGoodsLogo() {
        String str = this.goodsItemLogo;
        if (str == null) {
            GoodsListItem goodsListItem2 = this.goodsListItem;
            str = goodsListItem2 != null ? goodsListItem2.getProductGoodsLogo() : null;
            Intrinsics.checkNotNull(str);
            Intrinsics.checkNotNullExpressionValue(str, "goodsListItem?.productGoodsLogo!!");
        }
        return str;
    }

    public final String getGoodsItemLogo() {
        return this.goodsItemLogo;
    }

    public final void setGoodsItemLogo(String str) {
        this.goodsItemLogo = str;
        notifyPropertyChanged(133);
    }

    @Bindable
    public final String getProductGoodsTitle() {
        String str = this.goodsItemTitle;
        if (str == null) {
            GoodsListItem goodsListItem2 = this.goodsListItem;
            str = goodsListItem2 != null ? goodsListItem2.getProductGoodsTitle() : null;
            Intrinsics.checkNotNull(str);
            Intrinsics.checkNotNullExpressionValue(str, "goodsListItem?.productGoodsTitle!!");
        }
        return str;
    }

    public final String getGoodsItemTitle() {
        return this.goodsItemTitle;
    }

    public final void setGoodsItemTitle(String str) {
        this.goodsItemTitle = str;
        notifyPropertyChanged(134);
    }
}
