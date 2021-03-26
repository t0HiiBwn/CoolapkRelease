package com.coolapk.market.widget.video;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: IjkWrapMediaPlayer.kt */
final class IjkWrapMediaPlayer$setOption$1 implements Runnable {
    final /* synthetic */ int $category;
    final /* synthetic */ String $name;
    final /* synthetic */ String $value;
    final /* synthetic */ IjkWrapMediaPlayer this$0;

    IjkWrapMediaPlayer$setOption$1(IjkWrapMediaPlayer ijkWrapMediaPlayer, int i, String str, String str2) {
        this.this$0 = ijkWrapMediaPlayer;
        this.$category = i;
        this.$name = str;
        this.$value = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.getIjkPlayer().setOption(this.$category, this.$name, this.$value);
    }
}
