package com.coolapk.market.widget;

import android.widget.ImageView;
import android.widget.RadioGroup;
import com.coolapk.market.databinding.AppMainModelSelectBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "group", "Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "checkedId", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppMainModelDialog.kt */
final class AppMainModelDialog$onCreateDialog$3 implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ AppMainModelSelectBinding $binding;
    final /* synthetic */ float $shadow;

    AppMainModelDialog$onCreateDialog$3(AppMainModelSelectBinding appMainModelSelectBinding, float f) {
        this.$binding = appMainModelSelectBinding;
        this.$shadow = f;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        String str = "SOCIAL";
        if (i == 2131363172) {
            ImageView imageView = this.$binding.imageSocial;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageSocial");
            imageView.setElevation(0.0f);
            ImageView imageView2 = this.$binding.imageMarket;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.imageMarket");
            imageView2.setElevation(this.$shadow);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putString("APP_MAIN_MODE_KEY", "MARKET").apply();
        } else if (i == 2131363177) {
            ImageView imageView3 = this.$binding.imageSocial;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.imageSocial");
            imageView3.setElevation(this.$shadow);
            ImageView imageView4 = this.$binding.imageMarket;
            Intrinsics.checkNotNullExpressionValue(imageView4, "binding.imageMarket");
            imageView4.setElevation(0.0f);
            DataManager instance2 = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
            instance2.getPreferencesEditor().putString("APP_MAIN_MODE_KEY", str).apply();
        }
        if (i != 2131363177) {
            str = "MARKET";
        }
        SettingSynchronized.INSTANCE.uploadSetting("APP_MAIN_MODE_KEY", str, 1);
    }
}
