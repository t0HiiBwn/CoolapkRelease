package com.coolapk.market.view.dyhv8;

import android.view.View;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.util.RxUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhIncludActivity.kt */
final class DyhIncludActivity$ActionDone$1 implements View.OnClickListener {
    final /* synthetic */ DyhIncludActivity this$0;

    DyhIncludActivity$ActionDone$1(DyhIncludActivity dyhIncludActivity) {
        this.this$0 = dyhIncludActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        StringBuilder sb = new StringBuilder();
        LinkedHashMap linkedHashMap = this.this$0.dyhMap;
        Intrinsics.checkNotNull(linkedHashMap);
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        LinkedHashMap linkedHashMap2 = this.this$0.dyhMap;
        Intrinsics.checkNotNull(linkedHashMap2);
        if (!linkedHashMap2.isEmpty()) {
            LinkedHashMap linkedHashMap3 = this.this$0.dyhMap;
            Intrinsics.checkNotNull(linkedHashMap3);
            arrayList.addAll(linkedHashMap3.values());
            int i2 = 0;
            int size = arrayList.size();
            while (true) {
                i = 1;
                if (i2 >= size) {
                    break;
                }
                Object obj = arrayList.get(i2);
                Intrinsics.checkNotNullExpressionValue(obj, "dyhList[i]");
                sb.append(((DyhModel) obj).getId());
                if (i2 >= arrayList.size() - 1) {
                    break;
                }
                sb.append(",");
                i2++;
            }
            DataManager instance = DataManager.getInstance();
            String sb2 = sb.toString();
            String str = this.this$0.feedId;
            if (this.this$0.getPage() != 0) {
                i = 2;
            }
            instance.includFeed(sb2, str, i).compose(RxUtils.apiCommonToData()).subscribe(AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE);
        }
        DyhIncludActivity.access$getBinding$p(this.this$0).bottomSheet.dismissView();
    }
}
