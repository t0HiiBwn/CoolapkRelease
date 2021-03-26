package com.coolapk.market.widget.multitype;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/coolapk/market/widget/multitype/SimpleViewHolderFactor;", "", "()V", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SimpleViewHolderFactor.kt */
public final class SimpleViewHolderFactor {
    public static final Companion Companion = new Companion(null);
    private static final Function2<RecyclerView.ViewHolder, Object, Unit> EMPTY_BIND_METHOD = SimpleViewHolderFactor$Companion$EMPTY_BIND_METHOD$1.INSTANCE;

    @JvmStatic
    public static final SimpleHolderFactorBuilder withLayoutId(int i) {
        return Companion.withLayoutId(i);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R%\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/coolapk/market/widget/multitype/SimpleViewHolderFactor$Companion;", "", "()V", "EMPTY_BIND_METHOD", "Lkotlin/Function2;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "getEMPTY_BIND_METHOD", "()Lkotlin/jvm/functions/Function2;", "withLayoutId", "Lcom/coolapk/market/widget/multitype/SimpleHolderFactorBuilder;", "layoutId", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SimpleViewHolderFactor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Function2<RecyclerView.ViewHolder, Object, Unit> getEMPTY_BIND_METHOD() {
            return SimpleViewHolderFactor.EMPTY_BIND_METHOD;
        }

        @JvmStatic
        public final SimpleHolderFactorBuilder withLayoutId(int i) {
            return new SimpleHolderFactorBuilder(i);
        }
    }
}
