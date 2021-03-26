package com.coolapk.market.widget.binding;

import android.content.Context;
import android.view.View;
import com.coolapk.market.manager.ActionManagerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: BindingExtension.kt */
final class BindingExtensionKt$updateInfo$1 implements View.OnClickListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $url;

    BindingExtensionKt$updateInfo$1(Context context, String str) {
        this.$context = context;
        this.$url = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context = this.$context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ActionManagerCompat.startActivityByUrl$default(context, this.$url, null, null, 12, null);
    }
}
