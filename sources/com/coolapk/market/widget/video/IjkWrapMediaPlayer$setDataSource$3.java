package com.coolapk.market.widget.video;

import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: IjkWrapMediaPlayer.kt */
final class IjkWrapMediaPlayer$setDataSource$3 implements Runnable {
    final /* synthetic */ Context $p0;
    final /* synthetic */ Uri $p1;
    final /* synthetic */ IjkWrapMediaPlayer this$0;

    IjkWrapMediaPlayer$setDataSource$3(IjkWrapMediaPlayer ijkWrapMediaPlayer, Context context, Uri uri) {
        this.this$0 = ijkWrapMediaPlayer;
        this.$p0 = context;
        this.$p1 = uri;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.getIjkPlayer().setDataSource(this.$p0, this.$p1);
    }
}
