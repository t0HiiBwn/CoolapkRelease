package com.coolapk.market.view.block;

import com.coolapk.market.AppHolder;
import com.coolapk.market.network.Result;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/network/Result;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BlockContentManager.kt */
final class BlockContentManager$updateSpamConfig$1<T> implements Action1<Result<String>> {
    final /* synthetic */ List $items;

    BlockContentManager$updateSpamConfig$1(List list) {
        this.$items = list;
    }

    public final void call(Result<String> result) {
        Intrinsics.checkNotNullExpressionValue(result, "it");
        if (result.isSuccess()) {
            ArrayList<T> arrayList = new ArrayList();
            for (T t : this.$items) {
                if (t.getActive()) {
                    arrayList.add(t);
                }
            }
            boolean z = false;
            boolean z2 = false;
            for (T t2 : arrayList) {
                BlockContentManager blockContentManager = BlockContentManager.INSTANCE;
                BlockContentManager.loadedBlockItems.add(t2);
                z2 = true;
            }
            ArrayList<T> arrayList2 = new ArrayList();
            for (T t3 : this.$items) {
                if (!t3.getActive()) {
                    arrayList2.add(t3);
                }
            }
            for (T t4 : arrayList2) {
                BlockContentManager blockContentManager2 = BlockContentManager.INSTANCE;
                CollectionsKt.removeAll(BlockContentManager.loadedBlockItems, (Function1) new BlockContentManager$updateSpamConfig$1$4$1(t4));
                z = true;
            }
            if (z2) {
                EventBus.getDefault().post(new BlockItemChangeEvent());
                Toast.show$default(AppHolder.getApplication(), "屏蔽成功", 0, false, 12, null);
            } else if (z) {
                Toast.show$default(AppHolder.getApplication(), "取消成功", 0, false, 12, null);
            }
            if (z2 || z) {
                BlockContentManager.INSTANCE.updateLastModifyBlockItemsTimeMill();
            }
        }
    }
}
