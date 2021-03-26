package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;

public class DynamicTextView extends DynamicBaseWidgetImp {
    public DynamicTextView(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        this.n = new TextView(context);
        this.n.setTag(Integer.valueOf(getClickArea()));
        addView(this.n, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    boolean b() {
        super.b();
        if (Build.VERSION.SDK_INT >= 17) {
            this.n.setTextAlignment(this.j.h());
        }
        ((TextView) this.n).setText(this.j.f());
        ((TextView) this.n).setTextColor(this.j.g());
        ((TextView) this.n).setTextSize(this.j.e());
        if (Build.VERSION.SDK_INT >= 16) {
            this.n.setBackground(getBackgroundDrawable());
        }
        if (!this.j.o()) {
            ((TextView) this.n).setMaxLines(1);
            ((TextView) this.n).setEllipsize(TextUtils.TruncateAt.END);
        }
        return true;
    }
}
