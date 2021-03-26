package com.coolapk.market.view.settings;

import com.coolapk.market.model.HolderItem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/view/settings/VXSettingsFragment;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: VXSettingsFragment.kt */
final class VXSettingsFragment$initData$2 extends Lambda implements Function1<VXSettingsFragment, Object> {
    final /* synthetic */ ArrayList $holderItems;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VXSettingsFragment$initData$2(ArrayList arrayList) {
        super(1);
        this.$holderItems = arrayList;
    }

    public final Object invoke(VXSettingsFragment vXSettingsFragment) {
        Intrinsics.checkNotNullParameter(vXSettingsFragment, "it");
        return Boolean.valueOf(this.$holderItems.add(HolderItem.newBuilder().entityType("holder_item").string("下载安装").intValue(4).build()));
    }
}
