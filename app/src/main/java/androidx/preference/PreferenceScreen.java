package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.PreferenceManager;

public final class PreferenceScreen extends PreferenceGroup {
    private boolean mShouldUseGeneratedIds = true;

    @Override // androidx.preference.PreferenceGroup
    protected boolean isOnSameScreenAsChildren() {
        return false;
    }

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, TypedArrayUtils.getAttr(context, R.attr.preferenceScreenStyle, 16842891));
    }

    @Override // androidx.preference.Preference
    protected void onClick() {
        PreferenceManager.OnNavigateToScreenListener onNavigateToScreenListener;
        if (getIntent() == null && getFragment() == null && getPreferenceCount() != 0 && (onNavigateToScreenListener = getPreferenceManager().getOnNavigateToScreenListener()) != null) {
            onNavigateToScreenListener.onNavigateToScreen(this);
        }
    }

    public boolean shouldUseGeneratedIds() {
        return this.mShouldUseGeneratedIds;
    }

    public void setShouldUseGeneratedIds(boolean z) {
        if (!isAttached()) {
            this.mShouldUseGeneratedIds = z;
            return;
        }
        throw new IllegalStateException("Cannot change the usage of generated IDs while attached to the preference hierarchy");
    }
}
