package com.coolapk.market.view.goodsList;

import com.coolapk.market.event.GoodsItemEditEvent;
import com.coolapk.market.view.goodsList.GoodGoodsEditListFragment$onRegisterCards$4;
import com.coolapk.market.widget.Toast;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.TypeIntrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "s", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodGoodsEditListFragment.kt */
final class GoodGoodsEditListFragment$onRegisterCards$4$1$itemClear$1<T> implements Action1<String> {
    final /* synthetic */ List $list;
    final /* synthetic */ GoodGoodsEditListFragment$onRegisterCards$4.AnonymousClass1 this$0;

    GoodGoodsEditListFragment$onRegisterCards$4$1$itemClear$1(GoodGoodsEditListFragment$onRegisterCards$4.AnonymousClass1 r1, List list) {
        this.this$0 = r1;
        this.$list = list;
    }

    public final void call(String str) {
        Toast.show$default(this.this$0.this$0.this$0.getActivity(), str, 0, false, 12, null);
        EventBus eventBus = EventBus.getDefault();
        List list = this.$list;
        if (!TypeIntrinsics.isMutableList(list)) {
            list = null;
        }
        eventBus.post(new GoodsItemEditEvent(list));
    }
}
