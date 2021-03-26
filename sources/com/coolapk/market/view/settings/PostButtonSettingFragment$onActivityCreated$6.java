package com.coolapk.market.view.settings;

import android.view.View;
import com.coolapk.market.manager.DataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: PostButtonSettingFragment.kt */
final class PostButtonSettingFragment$onActivityCreated$6 implements View.OnClickListener {
    final /* synthetic */ PostButtonSettingFragment this$0;

    PostButtonSettingFragment$onActivityCreated$6(PostButtonSettingFragment postButtonSettingFragment) {
        this.this$0 = postButtonSettingFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putString("POST_BUTTON_SETTING_LONG_CLICK_KEY", "APP_MANAGER").apply();
        PostButtonSettingFragment.access$getBinding$p(this.this$0).radioGroupLongClick.check(2131363177);
    }
}
