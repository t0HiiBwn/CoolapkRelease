package com.coolapk.market.view.album.albumv8;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Rect;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumEditListFragment.kt */
final class AlbumEditListFragment$onActivityCreated$3 extends Lambda implements Function1<Rect, Unit> {
    final /* synthetic */ View $addView;
    final /* synthetic */ AlbumEditListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlbumEditListFragment$onActivityCreated$3(AlbumEditListFragment albumEditListFragment, View view) {
        super(1);
        this.this$0 = albumEditListFragment;
        this.$addView = view;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
        invoke(rect);
        return Unit.INSTANCE;
    }

    public final void invoke(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "it");
        this.this$0.getRecyclerView().setPadding(0, 0, 0, rect.bottom + NumberExtendsKt.getDp((Number) 64));
        ViewGroup.LayoutParams layoutParams = this.$addView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams);
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.bottomMargin = rect.bottom + NumberExtendsKt.getDp((Number) 24);
        }
    }
}
