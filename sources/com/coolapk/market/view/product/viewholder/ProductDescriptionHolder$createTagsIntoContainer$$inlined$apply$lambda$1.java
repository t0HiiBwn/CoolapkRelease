package com.coolapk.market.view.product.viewholder;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/coolapk/market/view/product/viewholder/ProductDescriptionHolder$createTagsIntoContainer$textView$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductDescriptionHolder.kt */
final class ProductDescriptionHolder$createTagsIntoContainer$$inlined$apply$lambda$1 implements View.OnClickListener {
    final /* synthetic */ int $color$inlined;
    final /* synthetic */ int $padding$inlined;
    final /* synthetic */ String $tag$inlined;
    final /* synthetic */ TextView $this_apply;
    final /* synthetic */ ProductDescriptionHolder this$0;

    ProductDescriptionHolder$createTagsIntoContainer$$inlined$apply$lambda$1(TextView textView, ProductDescriptionHolder productDescriptionHolder, int i, int i2, String str) {
        this.$this_apply = textView;
        this.this$0 = productDescriptionHolder;
        this.$padding$inlined = i;
        this.$color$inlined = i2;
        this.$tag$inlined = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.onTagClick(this.$this_apply, this.$tag$inlined);
    }
}
