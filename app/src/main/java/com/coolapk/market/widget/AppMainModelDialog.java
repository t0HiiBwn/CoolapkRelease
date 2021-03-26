package com.coolapk.market.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.RadioButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.databinding.DataBindingUtil;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.AppMainModelSelectBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.base.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/coolapk/market/widget/AppMainModelDialog;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "()V", "createIcon", "Landroid/graphics/drawable/StateListDrawable;", "createTextColor", "Landroid/content/res/ColorStateList;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppMainModelDialog.kt */
public final class AppMainModelDialog extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final AppMainModelDialog newInstance() {
        return Companion.newInstance();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/widget/AppMainModelDialog$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/widget/AppMainModelDialog;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppMainModelDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AppMainModelDialog newInstance() {
            return new AppMainModelDialog();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AppMainModelSelectBinding appMainModelSelectBinding = (AppMainModelSelectBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558462, null, false);
        RadioButton radioButton = appMainModelSelectBinding.radioSocial;
        Intrinsics.checkNotNullExpressionValue(radioButton, "binding.radioSocial");
        radioButton.setButtonDrawable(createIcon());
        RadioButton radioButton2 = appMainModelSelectBinding.radioMarket;
        Intrinsics.checkNotNullExpressionValue(radioButton2, "binding.radioMarket");
        radioButton2.setButtonDrawable(createIcon());
        appMainModelSelectBinding.radioSocial.setTextColor(createTextColor());
        appMainModelSelectBinding.radioMarket.setTextColor(createTextColor());
        appMainModelSelectBinding.imageSocial.setOnClickListener(new AppMainModelDialog$onCreateDialog$1(appMainModelSelectBinding));
        appMainModelSelectBinding.imageMarket.setOnClickListener(new AppMainModelDialog$onCreateDialog$2(appMainModelSelectBinding));
        appMainModelSelectBinding.radioGroup.setOnCheckedChangeListener(new AppMainModelDialog$onCreateDialog$3(appMainModelSelectBinding, (float) ConvertUtils.dp2px(6.0f)));
        String preferencesString = DataManager.getInstance().getPreferencesString("APP_MAIN_MODE_KEY", "SOCIAL");
        if (preferencesString != null) {
            int hashCode = preferencesString.hashCode();
            if (hashCode != -2027976644) {
                if (hashCode == -1843721363 && preferencesString.equals("SOCIAL")) {
                    appMainModelSelectBinding.radioGroup.check(2131363177);
                }
            } else if (preferencesString.equals("MARKET")) {
                appMainModelSelectBinding.radioGroup.check(2131363172);
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        Intrinsics.checkNotNullExpressionValue(appMainModelSelectBinding, "binding");
        AlertDialog create = builder.setView(appMainModelSelectBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        return create;
    }

    private final ColorStateList createTextColor() {
        return new ColorStateList(new int[][]{new int[]{16842912}, new int[0]}, new int[]{AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().getTextColorPrimary()});
    }

    private final StateListDrawable createIcon() {
        Drawable drawable = ResourceUtils.getDrawable(getActivity(), 2131231508);
        DrawableCompat.setTint(drawable, AppHolder.getAppTheme().getColorAccent());
        Drawable drawable2 = ResourceUtils.getDrawable(getActivity(), 2131231506);
        DrawableCompat.setTint(drawable2, AppHolder.getAppTheme().getColorAccent());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, drawable);
        stateListDrawable.addState(new int[]{-16842912}, drawable2);
        stateListDrawable.addState(new int[0], drawable2);
        return stateListDrawable;
    }
}
