package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class UnPressableLinearLayout extends LinearLayout {
    @Override // android.view.View, android.view.ViewGroup
    protected void dispatchSetPressed(boolean z) {
    }

    public UnPressableLinearLayout(Context context) {
        this(context, null);
    }

    public UnPressableLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
