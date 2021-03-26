package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/coolapk/market/viewholder/FeedStackCardViewHolder;", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "itemView", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "removeAction", "Lkotlin/Function1;", "", "", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lkotlin/jvm/functions/Function1;)V", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedStackCardViewHolder.kt */
public final class FeedStackCardViewHolder extends TitleRecycleViewCardViewHolder {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedStackCardViewHolder(View view, DataBindingComponent dataBindingComponent, Function1<? super Integer, Unit> function1) {
        super(view, dataBindingComponent, new ItemActionHandler(), Companion.createCallback(function1));
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
        Intrinsics.checkNotNullParameter(function1, "removeAction");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/coolapk/market/viewholder/FeedStackCardViewHolder$Companion;", "", "()V", "createCallback", "com/coolapk/market/viewholder/FeedStackCardViewHolder$Companion$createCallback$1", "removeAction", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)Lcom/coolapk/market/viewholder/FeedStackCardViewHolder$Companion$createCallback$1;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedStackCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final FeedStackCardViewHolder$Companion$createCallback$1 createCallback(Function1<? super Integer, Unit> function1) {
            return new FeedStackCardViewHolder$Companion$createCallback$1(function1);
        }
    }
}
