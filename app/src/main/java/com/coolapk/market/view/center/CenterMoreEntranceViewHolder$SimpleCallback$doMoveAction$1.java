package com.coolapk.market.view.center;

import androidx.databinding.ObservableArrayList;
import com.coolapk.market.view.center.CenterMoreEntranceViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CenterMoreEntranceViewHolder.kt */
final class CenterMoreEntranceViewHolder$SimpleCallback$doMoveAction$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $fromPosition;
    final /* synthetic */ int $toPosition;
    final /* synthetic */ CenterMoreEntranceViewHolder.SimpleCallback this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CenterMoreEntranceViewHolder$SimpleCallback$doMoveAction$1(CenterMoreEntranceViewHolder.SimpleCallback simpleCallback, int i, int i2) {
        super(0);
        this.this$0 = simpleCallback;
        this.$fromPosition = i;
        this.$toPosition = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ObservableArrayList access$getUserMenuList$p = CenterMoreEntranceViewHolder.access$getUserMenuList$p(CenterMoreEntranceViewHolder.this);
        access$getUserMenuList$p.add(this.$toPosition, (UserMenu) access$getUserMenuList$p.remove(this.$fromPosition));
    }
}
