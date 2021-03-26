package com.coolapk.market.view.center;

import android.content.DialogInterface;
import android.view.View;
import com.coolapk.market.manager.DataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: CenterUserMenuPresenter.kt */
final class CenterUserMenuPresenter$onMenuClick$4 implements DialogInterface.OnClickListener {
    final /* synthetic */ UserMenu $userMenu;
    final /* synthetic */ View $view;
    final /* synthetic */ CenterUserMenuPresenter this$0;

    CenterUserMenuPresenter$onMenuClick$4(CenterUserMenuPresenter centerUserMenuPresenter, View view, UserMenu userMenu) {
        this.this$0 = centerUserMenuPresenter;
        this.$view = view;
        this.$userMenu = userMenu;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putBoolean("follow_system_day_night_mode", false).apply();
        this.this$0.onMenuClick(this.$view, this.$userMenu);
    }
}
