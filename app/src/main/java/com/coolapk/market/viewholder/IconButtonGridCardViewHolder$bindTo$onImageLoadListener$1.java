package com.coolapk.market.viewholder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import com.coolapk.market.app.OnImageLoadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\f0\fH\n¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "", "uri", "", "kotlin.jvm.PlatformType", "drawable", "Landroid/graphics/drawable/Drawable;", "view", "Landroid/view/View;", "isFromMemory", "", "error", "", "onLoadComplete"}, k = 3, mv = {1, 4, 2})
/* compiled from: IconButtonGridCardViewHolder.kt */
final class IconButtonGridCardViewHolder$bindTo$onImageLoadListener$1 implements OnImageLoadListener {
    final /* synthetic */ IconButtonGridCardViewHolder this$0;

    IconButtonGridCardViewHolder$bindTo$onImageLoadListener$1(IconButtonGridCardViewHolder iconButtonGridCardViewHolder) {
        this.this$0 = iconButtonGridCardViewHolder;
    }

    @Override // com.coolapk.market.app.OnImageLoadListener
    public final void onLoadComplete(String str, Drawable drawable, View view, boolean z, Throwable th) {
        if (th == null) {
            LinearLayout linearLayout = this.this$0.binding.iconView0Layout;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.iconView0Layout");
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = this.this$0.binding.iconView1Layout;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.iconView1Layout");
            linearLayout2.setVisibility(0);
        }
    }
}
