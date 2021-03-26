package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/viewholder/NodeTopContentViewHolder;", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "itemView", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "nodeType", "", "nodeId", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeTopContentViewHolder.kt */
public final class NodeTopContentViewHolder extends TitleRecycleViewCardViewHolder {
    public static final Companion Companion = new Companion(null);
    private static final int VIEW_TYPE = NodeTopContentViewHolder.class.hashCode();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NodeTopContentViewHolder(View view, DataBindingComponent dataBindingComponent, String str, String str2) {
        super(view, dataBindingComponent, new ItemActionHandler(), Companion.createCallback(str, str2));
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
        Intrinsics.checkNotNullParameter(str, "nodeType");
        Intrinsics.checkNotNullParameter(str2, "nodeId");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/coolapk/market/viewholder/NodeTopContentViewHolder$Companion;", "", "()V", "VIEW_TYPE", "", "getVIEW_TYPE", "()I", "createCallback", "com/coolapk/market/viewholder/NodeTopContentViewHolder$Companion$createCallback$1", "nodeType", "", "nodeId", "(Ljava/lang/String;Ljava/lang/String;)Lcom/coolapk/market/viewholder/NodeTopContentViewHolder$Companion$createCallback$1;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NodeTopContentViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getVIEW_TYPE() {
            return NodeTopContentViewHolder.VIEW_TYPE;
        }

        /* access modifiers changed from: private */
        public final NodeTopContentViewHolder$Companion$createCallback$1 createCallback(String str, String str2) {
            return new NodeTopContentViewHolder$Companion$createCallback$1(str, str2);
        }
    }
}
