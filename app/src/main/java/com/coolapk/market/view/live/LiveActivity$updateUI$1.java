package com.coolapk.market.view.live;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveActivity.kt */
final class LiveActivity$updateUI$1 extends Lambda implements Function0<Fragment> {
    public static final LiveActivity$updateUI$1 INSTANCE = new LiveActivity$updateUI$1();

    LiveActivity$updateUI$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Fragment invoke() {
        return LiveIntroduceFragment.Companion.newInstance();
    }
}
