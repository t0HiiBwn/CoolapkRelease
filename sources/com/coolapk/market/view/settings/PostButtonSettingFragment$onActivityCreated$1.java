package com.coolapk.market.view.settings;

import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import com.coolapk.market.event.PostButtonEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.widget.RadioGroupPlus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "group", "Lcom/coolapk/market/widget/RadioGroupPlus;", "kotlin.jvm.PlatformType", "checkedId", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: PostButtonSettingFragment.kt */
final class PostButtonSettingFragment$onActivityCreated$1 implements RadioGroupPlus.OnCheckedChangeListener {
    final /* synthetic */ float $elevation;
    final /* synthetic */ PostButtonSettingFragment this$0;

    PostButtonSettingFragment$onActivityCreated$1(PostButtonSettingFragment postButtonSettingFragment, float f) {
        this.this$0 = postButtonSettingFragment;
        this.$elevation = f;
    }

    @Override // com.coolapk.market.widget.RadioGroupPlus.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroupPlus radioGroupPlus, int i) {
        String str;
        switch (i) {
            case 2131363176:
                LinearLayout linearLayout = PostButtonSettingFragment.access$getBinding$p(this.this$0).plusLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.plusLayout");
                linearLayout.setElevation(0.0f);
                LinearLayout linearLayout2 = PostButtonSettingFragment.access$getBinding$p(this.this$0).airplaneLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.airplaneLayout");
                linearLayout2.setElevation(this.$elevation);
                LinearLayout linearLayout3 = PostButtonSettingFragment.access$getBinding$p(this.this$0).coolapkLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.coolapkLayout");
                linearLayout3.setElevation(0.0f);
                LinearLayout linearLayout4 = PostButtonSettingFragment.access$getBinding$p(this.this$0).customLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.customLayout");
                linearLayout4.setElevation(0.0f);
                LinearLayout linearLayout5 = PostButtonSettingFragment.access$getBinding$p(this.this$0).plusLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.plusLayout");
                Drawable drawable = null;
                linearLayout5.setBackground(drawable);
                PostButtonSettingFragment.access$getBinding$p(this.this$0).airplaneLayout.setBackgroundResource(2131231828);
                LinearLayout linearLayout6 = PostButtonSettingFragment.access$getBinding$p(this.this$0).coolapkLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout6, "binding.coolapkLayout");
                linearLayout6.setBackground(drawable);
                LinearLayout linearLayout7 = PostButtonSettingFragment.access$getBinding$p(this.this$0).customLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout7, "binding.customLayout");
                linearLayout7.setBackground(drawable);
                str = "AIRPLANE";
                break;
            case 2131363178:
                LinearLayout linearLayout8 = PostButtonSettingFragment.access$getBinding$p(this.this$0).plusLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout8, "binding.plusLayout");
                linearLayout8.setElevation(0.0f);
                LinearLayout linearLayout9 = PostButtonSettingFragment.access$getBinding$p(this.this$0).airplaneLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout9, "binding.airplaneLayout");
                linearLayout9.setElevation(0.0f);
                LinearLayout linearLayout10 = PostButtonSettingFragment.access$getBinding$p(this.this$0).coolapkLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout10, "binding.coolapkLayout");
                linearLayout10.setElevation(this.$elevation);
                LinearLayout linearLayout11 = PostButtonSettingFragment.access$getBinding$p(this.this$0).customLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout11, "binding.customLayout");
                linearLayout11.setElevation(0.0f);
                LinearLayout linearLayout12 = PostButtonSettingFragment.access$getBinding$p(this.this$0).plusLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout12, "binding.plusLayout");
                Drawable drawable2 = null;
                linearLayout12.setBackground(drawable2);
                LinearLayout linearLayout13 = PostButtonSettingFragment.access$getBinding$p(this.this$0).airplaneLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout13, "binding.airplaneLayout");
                linearLayout13.setBackground(drawable2);
                PostButtonSettingFragment.access$getBinding$p(this.this$0).coolapkLayout.setBackgroundResource(2131231828);
                LinearLayout linearLayout14 = PostButtonSettingFragment.access$getBinding$p(this.this$0).customLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout14, "binding.customLayout");
                linearLayout14.setBackground(drawable2);
                str = "COOLAPK";
                break;
            case 2131363179:
                LinearLayout linearLayout15 = PostButtonSettingFragment.access$getBinding$p(this.this$0).plusLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout15, "binding.plusLayout");
                linearLayout15.setElevation(0.0f);
                LinearLayout linearLayout16 = PostButtonSettingFragment.access$getBinding$p(this.this$0).airplaneLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout16, "binding.airplaneLayout");
                linearLayout16.setElevation(0.0f);
                LinearLayout linearLayout17 = PostButtonSettingFragment.access$getBinding$p(this.this$0).coolapkLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout17, "binding.coolapkLayout");
                linearLayout17.setElevation(0.0f);
                LinearLayout linearLayout18 = PostButtonSettingFragment.access$getBinding$p(this.this$0).customLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout18, "binding.customLayout");
                linearLayout18.setElevation(this.$elevation);
                LinearLayout linearLayout19 = PostButtonSettingFragment.access$getBinding$p(this.this$0).plusLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout19, "binding.plusLayout");
                Drawable drawable3 = null;
                linearLayout19.setBackground(drawable3);
                LinearLayout linearLayout20 = PostButtonSettingFragment.access$getBinding$p(this.this$0).airplaneLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout20, "binding.airplaneLayout");
                linearLayout20.setBackground(drawable3);
                LinearLayout linearLayout21 = PostButtonSettingFragment.access$getBinding$p(this.this$0).coolapkLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout21, "binding.coolapkLayout");
                linearLayout21.setBackground(drawable3);
                PostButtonSettingFragment.access$getBinding$p(this.this$0).customLayout.setBackgroundResource(2131231828);
                str = "CUSTOM";
                break;
            case 2131363188:
                LinearLayout linearLayout22 = PostButtonSettingFragment.access$getBinding$p(this.this$0).plusLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout22, "binding.plusLayout");
                linearLayout22.setElevation(this.$elevation);
                LinearLayout linearLayout23 = PostButtonSettingFragment.access$getBinding$p(this.this$0).airplaneLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout23, "binding.airplaneLayout");
                linearLayout23.setElevation(0.0f);
                LinearLayout linearLayout24 = PostButtonSettingFragment.access$getBinding$p(this.this$0).coolapkLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout24, "binding.coolapkLayout");
                linearLayout24.setElevation(0.0f);
                LinearLayout linearLayout25 = PostButtonSettingFragment.access$getBinding$p(this.this$0).customLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout25, "binding.customLayout");
                linearLayout25.setElevation(0.0f);
                PostButtonSettingFragment.access$getBinding$p(this.this$0).plusLayout.setBackgroundResource(2131231828);
                LinearLayout linearLayout26 = PostButtonSettingFragment.access$getBinding$p(this.this$0).airplaneLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout26, "binding.airplaneLayout");
                Drawable drawable4 = null;
                linearLayout26.setBackground(drawable4);
                LinearLayout linearLayout27 = PostButtonSettingFragment.access$getBinding$p(this.this$0).coolapkLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout27, "binding.coolapkLayout");
                linearLayout27.setBackground(drawable4);
                LinearLayout linearLayout28 = PostButtonSettingFragment.access$getBinding$p(this.this$0).customLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout28, "binding.customLayout");
                linearLayout28.setBackground(drawable4);
            default:
                str = "PLUS";
                break;
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putString("POST_BUTTON_SETTING_KEY", str).apply();
        EventBus.getDefault().post(new PostButtonEvent());
    }
}
