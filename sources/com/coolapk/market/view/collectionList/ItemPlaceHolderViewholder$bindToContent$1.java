package com.coolapk.market.view.collectionList;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.model.ItemPlaceHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ItemPlaceHolderViewholder.kt */
final class ItemPlaceHolderViewholder$bindToContent$1 implements View.OnLongClickListener {
    final /* synthetic */ ItemPlaceHolder $entity;
    final /* synthetic */ ItemPlaceHolderViewholder this$0;

    ItemPlaceHolderViewholder$bindToContent$1(ItemPlaceHolderViewholder itemPlaceHolderViewholder, ItemPlaceHolder itemPlaceHolder) {
        this.this$0 = itemPlaceHolderViewholder;
        this.$entity = itemPlaceHolder;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        AppViewForCollectionItemDialog newInstance = AppViewForCollectionItemDialog.Companion.newInstance(this.$entity);
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        return true;
    }
}
