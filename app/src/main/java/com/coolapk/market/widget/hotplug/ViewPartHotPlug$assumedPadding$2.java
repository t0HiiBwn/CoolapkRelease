package com.coolapk.market.widget.hotplug;

import com.coolapk.market.AppHolder;
import com.coolapk.market.util.ResourceUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "VP", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "T", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ViewPartHotPlug.kt */
final class ViewPartHotPlug$assumedPadding$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ ViewPartHotPlug this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewPartHotPlug$assumedPadding$2(ViewPartHotPlug viewPartHotPlug) {
        super(0);
        this.this$0 = viewPartHotPlug;
    }

    /* Return type fixed from 'int' to match base method */
    /* JADX WARN: Type inference failed for: r0v4, types: [int, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int, java.lang.Integer] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        if (this.this$0.getUseListPadding()) {
            return ResourceUtils.getDimen(AppHolder.getApplication(), 2131165382);
        }
        return ResourceUtils.getDimen(AppHolder.getApplication(), 2131165381);
    }
}
