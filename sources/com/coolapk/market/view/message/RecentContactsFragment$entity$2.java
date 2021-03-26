package com.coolapk.market.view.message;

import android.os.Parcelable;
import com.coolapk.market.model.Entity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/model/Entity;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: RecentContactsFragment.kt */
final class RecentContactsFragment$entity$2 extends Lambda implements Function0<Entity> {
    final /* synthetic */ RecentContactsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecentContactsFragment$entity$2(RecentContactsFragment recentContactsFragment) {
        super(0);
        this.this$0 = recentContactsFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Entity invoke() {
        Parcelable parcelable = this.this$0.requireArguments().getParcelable("entity");
        Intrinsics.checkNotNull(parcelable);
        return (Entity) parcelable;
    }
}
