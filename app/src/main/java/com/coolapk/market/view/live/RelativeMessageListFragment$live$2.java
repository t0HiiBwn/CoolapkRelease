package com.coolapk.market.view.live;

import android.os.Bundle;
import android.os.Parcelable;
import com.coolapk.market.model.Live;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/model/Live;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: RelativeMessageListFragment.kt */
final class RelativeMessageListFragment$live$2 extends Lambda implements Function0<Live> {
    final /* synthetic */ RelativeMessageListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RelativeMessageListFragment$live$2(RelativeMessageListFragment relativeMessageListFragment) {
        super(0);
        this.this$0 = relativeMessageListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Live invoke() {
        Bundle arguments = this.this$0.getArguments();
        Intrinsics.checkNotNull(arguments);
        Parcelable parcelable = arguments.getParcelable("LIVE");
        Intrinsics.checkNotNull(parcelable);
        return (Live) parcelable;
    }
}
