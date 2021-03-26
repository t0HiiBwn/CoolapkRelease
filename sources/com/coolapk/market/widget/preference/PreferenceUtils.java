package com.coolapk.market.widget.preference;

import android.view.View;
import androidx.preference.PreferenceViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/coolapk/market/widget/preference/PreferenceUtils;", "", "()V", "applyEnableEffect", "", "Landroidx/preference/PreferenceViewHolder;", "enabled", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PreferenceUtils.kt */
public final class PreferenceUtils {
    public static final PreferenceUtils INSTANCE = new PreferenceUtils();

    private PreferenceUtils() {
    }

    public final void applyEnableEffect(PreferenceViewHolder preferenceViewHolder, boolean z) {
        Intrinsics.checkNotNullParameter(preferenceViewHolder, "$this$applyEnableEffect");
        View findViewById = preferenceViewHolder.findViewById(16908310);
        View findViewById2 = preferenceViewHolder.findViewById(16908304);
        if (z) {
            if (findViewById != null) {
                findViewById.setAlpha(1.0f);
            }
            if (findViewById2 != null) {
                findViewById2.setAlpha(1.0f);
                return;
            }
            return;
        }
        if (findViewById != null) {
            findViewById.setAlpha(0.4f);
        }
        if (findViewById2 != null) {
            findViewById2.setAlpha(0.4f);
        }
    }
}
