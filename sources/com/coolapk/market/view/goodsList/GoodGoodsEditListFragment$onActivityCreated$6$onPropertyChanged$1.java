package com.coolapk.market.view.goodsList;

import com.coolapk.market.event.GoodsEditEvent;
import com.coolapk.market.model.Feed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodGoodsEditListFragment.kt */
final class GoodGoodsEditListFragment$onActivityCreated$6$onPropertyChanged$1<T> implements Action1<String> {
    final /* synthetic */ GoodGoodsEditListFragment$onActivityCreated$6 this$0;

    GoodGoodsEditListFragment$onActivityCreated$6$onPropertyChanged$1(GoodGoodsEditListFragment$onActivityCreated$6 goodGoodsEditListFragment$onActivityCreated$6) {
        this.this$0 = goodGoodsEditListFragment$onActivityCreated$6;
    }

    public final void call(String str) {
        Feed build = Feed.newBuilder(this.this$0.this$0.viewModel.getGoodsList()).extraPic(this.this$0.this$0.viewModel.getCoverUrl()).title(this.this$0.this$0.viewModel.getGoodsShowTitle()).message(this.this$0.this$0.viewModel.getGoodsShowMessage()).build();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(build, "feed");
        eventBus.post(new GoodsEditEvent(build));
    }
}
