package com.coolapk.market.view.album.albumv8;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumDetailActivity.kt */
final class AlbumDetailActivity$initUI$1 implements View.OnClickListener {
    final /* synthetic */ AlbumDetailActivity this$0;

    AlbumDetailActivity$initUI$1(AlbumDetailActivity albumDetailActivity) {
        this.this$0 = albumDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.this$0.getCurrentPage() == 1) {
            this.this$0.selectPage(0);
        } else {
            this.this$0.finish();
        }
    }
}
