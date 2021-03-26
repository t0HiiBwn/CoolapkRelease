package com.coolapk.market.view.product;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.model.Product;
import com.coolapk.market.view.feed.CancelFollowItemDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductViewHolder.kt */
final class ProductViewHolder$bindToContent$1 implements View.OnLongClickListener {
    final /* synthetic */ Product $data;
    final /* synthetic */ ProductViewHolder this$0;

    ProductViewHolder$bindToContent$1(ProductViewHolder productViewHolder, Product product) {
        this.this$0 = productViewHolder;
        this.$data = product;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        CancelFollowItemDialog newInstance = CancelFollowItemDialog.Companion.newInstance(this.$data);
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        return true;
    }
}
