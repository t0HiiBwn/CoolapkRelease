package com.coolapk.market.widget.video;

import com.coolapk.market.widget.MainSpareHandler;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: VideoAutoPlayManager.kt */
final class VideoAutoPlayManager$autoResumeVisibleRunnable$1 implements Runnable {
    public static final VideoAutoPlayManager$autoResumeVisibleRunnable$1 INSTANCE = new VideoAutoPlayManager$autoResumeVisibleRunnable$1();

    VideoAutoPlayManager$autoResumeVisibleRunnable$1() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        MainSpareHandler.Companion.getSInstance().post(AnonymousClass1.INSTANCE);
    }
}
