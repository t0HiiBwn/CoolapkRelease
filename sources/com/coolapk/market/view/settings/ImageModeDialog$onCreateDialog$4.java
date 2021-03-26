package com.coolapk.market.view.settings;

import android.widget.RadioGroup;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "group", "Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "checkedId", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: ImageModeDialog.kt */
final class ImageModeDialog$onCreateDialog$4 implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ Ref.ObjectRef $value;

    ImageModeDialog$onCreateDialog$4(Ref.ObjectRef objectRef) {
        this.$value = objectRef;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == 2131363181) {
            this.$value.element = "AUTO";
        } else if (i == 2131363189) {
            this.$value.element = "SOURCE";
        } else if (i == 2131363192) {
            this.$value.element = "NORMAL";
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putString("photo_view_options", this.$value.element).apply();
        SettingSynchronized.INSTANCE.uploadSetting("photo_view_options", this.$value.element, 1);
    }
}
