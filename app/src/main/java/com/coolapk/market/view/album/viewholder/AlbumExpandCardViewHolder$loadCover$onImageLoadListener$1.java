package com.coolapk.market.view.album.viewholder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.databinding.ItemAlbumExpandCardBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\f0\fH\n¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "", "uri", "", "kotlin.jvm.PlatformType", "drawable", "Landroid/graphics/drawable/Drawable;", "view", "Landroid/view/View;", "isFromMemory", "", "error", "", "onLoadComplete"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumExpandCardViewHolder.kt */
final class AlbumExpandCardViewHolder$loadCover$onImageLoadListener$1 implements OnImageLoadListener {
    final /* synthetic */ AlbumExpandCardViewHolder this$0;

    AlbumExpandCardViewHolder$loadCover$onImageLoadListener$1(AlbumExpandCardViewHolder albumExpandCardViewHolder) {
        this.this$0 = albumExpandCardViewHolder;
    }

    @Override // com.coolapk.market.app.OnImageLoadListener
    public final void onLoadComplete(String str, Drawable drawable, View view, boolean z, Throwable th) {
        TextView textView = ((ItemAlbumExpandCardBinding) this.this$0.getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setVisibility(0);
        TextView textView2 = ((ItemAlbumExpandCardBinding) this.this$0.getBinding()).infoView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.infoView");
        textView2.setVisibility(0);
        LinearLayout linearLayout = ((ItemAlbumExpandCardBinding) this.this$0.getBinding()).iconList;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.iconList");
        linearLayout.setVisibility(0);
    }
}
