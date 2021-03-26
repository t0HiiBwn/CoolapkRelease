package com.coolapk.market.view.settings;

import android.widget.RadioGroup;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "group", "Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "checkedId", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: WaterMarkDialog.kt */
final class WaterMarkDialog$onCreateDialog$5 implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ Ref.ObjectRef $value;
    final /* synthetic */ WaterMarkDialog this$0;

    WaterMarkDialog$onCreateDialog$5(WaterMarkDialog waterMarkDialog, Ref.ObjectRef objectRef) {
        this.this$0 = waterMarkDialog;
        this.$value = objectRef;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case 2131363181:
                if (!(this.this$0.isPosition())) {
                    this.$value.element = "0";
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    instance.getPreferencesEditor().putString("watermark_icon_type", this.$value.element).apply();
                    break;
                } else {
                    this.$value.element = "5";
                    DataManager instance2 = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                    instance2.getPreferencesEditor().putString("picture_watermark_position", this.$value.element).apply();
                    break;
                }
            case 2131363183:
                this.$value.element = "9";
                DataManager instance3 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance3, "DataManager.getInstance()");
                instance3.getPreferencesEditor().putString("picture_watermark_position", this.$value.element).apply();
                break;
            case 2131363189:
                if (!(this.this$0.isPosition())) {
                    this.$value.element = "1";
                    DataManager instance4 = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance4, "DataManager.getInstance()");
                    instance4.getPreferencesEditor().putString("watermark_icon_type", this.$value.element).apply();
                    break;
                } else {
                    this.$value.element = "7";
                    DataManager instance5 = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance5, "DataManager.getInstance()");
                    instance5.getPreferencesEditor().putString("picture_watermark_position", this.$value.element).apply();
                    break;
                }
            case 2131363192:
                this.$value.element = "8";
                DataManager instance6 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance6, "DataManager.getInstance()");
                instance6.getPreferencesEditor().putString("picture_watermark_position", this.$value.element).apply();
                break;
        }
        SettingSynchronized.INSTANCE.uploadSetting(this.this$0.key, this.$value.element, 1);
    }
}
