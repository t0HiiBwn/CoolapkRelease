package com.coolapk.market.view.cardlist;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.manager.ActionManagerCompat;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityDialogHelper.kt */
final class EntityDialogHelper$onDialogCardLoaded$2 implements DialogInterface.OnClickListener {
    final /* synthetic */ String $actionUrl;
    final /* synthetic */ FragmentActivity $activity;

    EntityDialogHelper$onDialogCardLoaded$2(FragmentActivity fragmentActivity, String str) {
        this.$activity = fragmentActivity;
        this.$actionUrl = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ActionManagerCompat.startActivityByUrl$default(this.$activity, this.$actionUrl, null, null, 12, null);
    }
}
