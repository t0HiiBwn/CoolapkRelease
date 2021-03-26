package com.coolapk.market.service.action;

import android.content.Context;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: PackageAddedAction.kt */
final class PackageAddedAction$doPackageAddedAction$2 implements Runnable {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $title;

    PackageAddedAction$doPackageAddedAction$2(Context context, String str) {
        this.$context = context;
        this.$title = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.$context;
        Toast.show$default(context, context.getString(2131887187, this.$title), 0, false, 12, null);
    }
}
