package com.coolapk.market.widget.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import androidx.preference.PreferenceViewHolder;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.TintHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/widget/preference/CheckBoxPreference;", "Landroidx/preference/CheckBoxPreference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onBindViewHolder", "", "holder", "Landroidx/preference/PreferenceViewHolder;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CheckBoxPreference.kt */
public final class CheckBoxPreference extends androidx.preference.CheckBoxPreference {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setIconSpaceReserved(false);
    }

    @Override // androidx.preference.CheckBoxPreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        Intrinsics.checkNotNullParameter(preferenceViewHolder, "holder");
        super.onBindViewHolder(preferenceViewHolder);
        PreferenceUtils.INSTANCE.applyEnableEffect(preferenceViewHolder, isEnabled());
        View findViewById = preferenceViewHolder.findViewById(16908289);
        if (findViewById instanceof CheckBox) {
            TintHelper.setTint((CheckBox) findViewById, AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().isDarkTheme());
        }
    }
}
