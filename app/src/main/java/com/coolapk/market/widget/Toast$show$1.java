package com.coolapk.market.widget;

import android.content.Context;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: Toast.kt */
final class Toast$show$1 implements Runnable {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $duration;
    final /* synthetic */ String $text;

    Toast$show$1(Context context, String str, int i) {
        this.$context = context;
        this.$text = str;
        this.$duration = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.show$default(this.$context, this.$text, this.$duration, false, 8, null);
    }
}
