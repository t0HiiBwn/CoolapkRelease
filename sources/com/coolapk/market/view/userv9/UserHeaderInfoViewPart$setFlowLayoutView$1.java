package com.coolapk.market.view.userv9;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/userv9/UserHeaderInfoViewPart$setFlowLayoutView$1", "Landroid/widget/ArrayAdapter;", "Landroid/view/View;", "getView", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserHeaderInfoViewPart.kt */
public final class UserHeaderInfoViewPart$setFlowLayoutView$1 extends ArrayAdapter<View> {
    final /* synthetic */ List $viewList;
    final /* synthetic */ UserHeaderInfoViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserHeaderInfoViewPart$setFlowLayoutView$1(UserHeaderInfoViewPart userHeaderInfoViewPart, List list, Context context, int i, List list2) {
        super(context, i, list2);
        this.this$0 = userHeaderInfoViewPart;
        this.$viewList = list;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Object item = getItem(i);
        Intrinsics.checkNotNull(item);
        return (View) item;
    }
}
