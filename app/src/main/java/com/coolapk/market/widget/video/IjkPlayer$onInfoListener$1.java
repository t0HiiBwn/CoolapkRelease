package com.coolapk.market.widget.video;

import android.os.Bundle;
import com.kk.taurus.playerbase.event.BundlePool;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IMediaPlayer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "mp", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "arg1", "", "arg2", "onInfo"}, k = 3, mv = {1, 4, 2})
/* compiled from: IjkPlayer.kt */
final class IjkPlayer$onInfoListener$1 implements IMediaPlayer.OnInfoListener {
    final /* synthetic */ IjkPlayer this$0;

    IjkPlayer$onInfoListener$1(IjkPlayer ijkPlayer) {
        this.this$0 = ijkPlayer;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public final boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
        if (i == 3) {
            this.this$0.startSeekPos = 0;
            this.this$0.submitPlayerEvent(-99015, null);
            return true;
        } else if (i == 10009) {
            this.this$0.submitPlayerEvent(-99023, null);
            return true;
        } else if (i == 701) {
            this.this$0.submitPlayerEvent(-99010, null);
            return true;
        } else if (i != 702) {
            switch (i) {
                case 800:
                    this.this$0.submitPlayerEvent(-99025, null);
                    return true;
                case 801:
                    this.this$0.submitPlayerEvent(-99026, null);
                    return true;
                case 802:
                    this.this$0.submitPlayerEvent(-99027, null);
                    return true;
                default:
                    switch (i) {
                        case 900:
                            this.this$0.submitPlayerEvent(-99028, null);
                            return true;
                        case 901:
                            this.this$0.submitPlayerEvent(-99029, null);
                            return true;
                        case 902:
                            this.this$0.submitPlayerEvent(-99030, null);
                            return true;
                        default:
                            switch (i) {
                                case 10001:
                                    Bundle obtain = BundlePool.obtain();
                                    obtain.putInt("int_data", i2);
                                    this.this$0.submitPlayerEvent(99020, obtain);
                                    return true;
                                case 10002:
                                    this.this$0.submitPlayerEvent(-99021, null);
                                    return true;
                                case 10003:
                                    this.this$0.submitPlayerEvent(-99022, null);
                                    return true;
                                default:
                                    return true;
                            }
                    }
            }
        } else {
            this.this$0.submitPlayerEvent(-99011, null);
            return true;
        }
    }
}
