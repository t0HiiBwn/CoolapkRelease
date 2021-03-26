package com.coolapk.market.widget.multitype;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/widget/multitype/MultiTypeAdapter;", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "mDataList", "", "(Ljava/util/List;)V", "getItem", "", "position", "", "getItemCount", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MultiTypeAdapter.kt */
public final class MultiTypeAdapter extends BaseMultiTypeAdapter {
    public static final Companion Companion = new Companion(null);
    public static final int PRIORITY_HIGH = 0;
    public static final int PRIORITY_MAX = -1;
    public static final int PRIORITY_NORMAL = 1;
    private final List<?> mDataList;

    public MultiTypeAdapter(List<?> list) {
        Intrinsics.checkNotNullParameter(list, "mDataList");
        this.mDataList = list;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/widget/multitype/MultiTypeAdapter$Companion;", "", "()V", "PRIORITY_HIGH", "", "PRIORITY_MAX", "PRIORITY_NORMAL", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MultiTypeAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.widget.multitype.BaseMultiTypeAdapter
    public Object getItem(int i) {
        return this.mDataList.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDataList.size();
    }
}
