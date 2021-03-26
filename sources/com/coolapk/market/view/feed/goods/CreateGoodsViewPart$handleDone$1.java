package com.coolapk.market.view.feed.goods;

import android.util.Pair;
import android.view.View;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.network.Result;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001ab\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002 \u0004*0\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012F\u0010\u0005\u001aB\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004* \u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/FeedGoods;", "kotlin.jvm.PlatformType", "it", "Landroid/util/Pair;", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CreateGoodsViewPart.kt */
final class CreateGoodsViewPart$handleDone$1<T, R> implements Func1<Pair<String, String>, Observable<? extends Result<FeedGoods>>> {
    final /* synthetic */ View $mallView;
    final /* synthetic */ String $sellUrl;
    final /* synthetic */ String $title;

    CreateGoodsViewPart$handleDone$1(View view, String str, String str2) {
        this.$mallView = view;
        this.$title = str;
        this.$sellUrl = str2;
    }

    public final Observable<? extends Result<FeedGoods>> call(Pair<String, String> pair) {
        return DataManager.getInstance().createGoods(0, this.$mallView.getTag().toString(), this.$title, this.$sellUrl, (String) pair.second);
    }
}
