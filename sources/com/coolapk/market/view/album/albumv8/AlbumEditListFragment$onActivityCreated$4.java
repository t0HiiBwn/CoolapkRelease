package com.coolapk.market.view.album.albumv8;

import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumEditListFragment.kt */
final class AlbumEditListFragment$onActivityCreated$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ View $addView;
    final /* synthetic */ FrameLayout $frameLayout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlbumEditListFragment$onActivityCreated$4(FrameLayout frameLayout, View view) {
        super(0);
        this.$frameLayout = frameLayout;
        this.$addView = view;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.$frameLayout.removeView(this.$addView);
    }
}
