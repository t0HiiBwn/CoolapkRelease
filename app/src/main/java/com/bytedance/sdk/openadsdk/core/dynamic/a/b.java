package com.bytedance.sdk.openadsdk.core.dynamic.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicButton;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicDislike;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicImageView;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicLogoAd;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicLogoUnion;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicTextView;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicVideoView;

/* compiled from: DynamicViewFactory */
public class b {
    public static DynamicBaseWidget a(Context context, DynamicRootView dynamicRootView, f fVar) {
        if (context == null || dynamicRootView == null || fVar == null || fVar.e() == null) {
            return null;
        }
        switch (fVar.e().a()) {
            case 0:
                return new DynamicTextView(context, dynamicRootView, fVar);
            case 1:
                return new DynamicImageView(context, dynamicRootView, fVar);
            case 2:
                return new DynamicButton(context, dynamicRootView, fVar);
            case 3:
                return new DynamicDislike(context, dynamicRootView, fVar);
            case 4:
                return new DynamicLogoAd(context, dynamicRootView, fVar);
            case 5:
                return new DynamicLogoUnion(context, dynamicRootView, fVar);
            case 6:
                return new DynamicBaseWidgetImp(context, dynamicRootView, fVar);
            case 7:
                return new DynamicVideoView(context, dynamicRootView, fVar);
            default:
                return null;
        }
    }
}
