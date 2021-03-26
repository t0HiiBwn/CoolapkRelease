package com.coolapk.market.widget.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.PreferenceViewHolder;
import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/widget/preference/Preference;", "Landroidx/preference/Preference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "holder", "Landroidx/preference/PreferenceViewHolder;", "onBindViewHolder", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: Preference.kt */
public final class Preference extends androidx.preference.Preference {
    private PreferenceViewHolder holder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Preference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setIconSpaceReserved(false);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        Intrinsics.checkNotNullParameter(preferenceViewHolder, "holder");
        super.onBindViewHolder(preferenceViewHolder);
        this.holder = preferenceViewHolder;
        preferenceViewHolder.itemView.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        PreferenceUtils.INSTANCE.applyEnableEffect(preferenceViewHolder, isEnabled());
    }
}
