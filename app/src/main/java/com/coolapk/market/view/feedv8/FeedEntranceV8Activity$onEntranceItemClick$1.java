package com.coolapk.market.view.feedv8;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.view.album.AlbumCreateDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedEntranceV8Activity.kt */
final class FeedEntranceV8Activity$onEntranceItemClick$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ FeedEntranceV8Activity this$0;

    FeedEntranceV8Activity$onEntranceItemClick$1(FeedEntranceV8Activity feedEntranceV8Activity) {
        this.this$0 = feedEntranceV8Activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AlbumCreateDialog newInstance = AlbumCreateDialog.newInstance();
        FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        StatisticHelper.Companion.getInstance().recordFeedEntranceClickEvent("应用集");
    }
}
