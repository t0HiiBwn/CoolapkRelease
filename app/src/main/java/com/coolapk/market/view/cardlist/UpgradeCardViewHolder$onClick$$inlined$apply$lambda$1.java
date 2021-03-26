package com.coolapk.market.view.cardlist;

import android.content.DialogInterface;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick", "com/coolapk/market/view/cardlist/UpgradeCardViewHolder$onClick$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: MainV8ListFragment.kt */
final class UpgradeCardViewHolder$onClick$$inlined$apply$lambda$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ MainV8ListFragment $fragment$inlined;

    UpgradeCardViewHolder$onClick$$inlined$apply$lambda$1(MainV8ListFragment mainV8ListFragment) {
        this.$fragment$inlined = mainV8ListFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.$fragment$inlined.removeUpgradeCard();
    }
}
