package com.coolapk.market.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.ResourceUtils;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/coolapk/market/widget/view/FollowStyleTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setSelected", "", "selected", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FollowStyleTextView.kt */
public final class FollowStyleTextView extends AppCompatTextView {
    public FollowStyleTextView(Context context) {
        super(context);
        ViewExtendsKt.setCompatForeground(this, ResourceUtils.getDrawable(getContext(), ResourceUtils.resolveResId(getContext(), 16843534)));
        setGravity(17);
        ViewExtendsKt.clipView$default(this, 2, 0.0f, 2, null);
        setSelected(isSelected());
    }

    public FollowStyleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewExtendsKt.setCompatForeground(this, ResourceUtils.getDrawable(getContext(), ResourceUtils.resolveResId(getContext(), 16843534)));
        setGravity(17);
        ViewExtendsKt.clipView$default(this, 2, 0.0f, 2, null);
        setSelected(isSelected());
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setText(getContext().getString(2131886114));
            setBackgroundColor(ResourceUtils.getColorInt(getContext(), 2131099911));
            setTextColor(ResourceUtils.getColorInt(getContext(), 2131099891));
            return;
        }
        setText(getContext().getString(2131886133));
        setBackgroundColor(AppHolder.getAppTheme().getColorAccent());
        setTextColor(ResourceUtils.getColorInt(getContext(), 2131099912));
    }
}
