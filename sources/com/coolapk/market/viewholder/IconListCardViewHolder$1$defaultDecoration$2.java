package com.coolapk.market.viewholder;

import android.app.Application;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.widget.recyclerviewdivider.RecyclerViewDivider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/widget/recyclerviewdivider/RecyclerViewDivider$Builder;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: IconListCardViewHolder.kt */
final class IconListCardViewHolder$1$defaultDecoration$2 extends Lambda implements Function0<RecyclerViewDivider.Builder> {
    public static final IconListCardViewHolder$1$defaultDecoration$2 INSTANCE = new IconListCardViewHolder$1$defaultDecoration$2();

    IconListCardViewHolder$1$defaultDecoration$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final RecyclerViewDivider.Builder invoke() {
        RecyclerViewDivider.Companion companion = RecyclerViewDivider.Companion;
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        return companion.with(application).asSpace().size(NumberExtendsKt.getDp((Number) 10)).hideLastDivider();
    }
}
