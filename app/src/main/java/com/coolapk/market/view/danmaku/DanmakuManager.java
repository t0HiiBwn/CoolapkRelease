package com.coolapk.market.view.danmaku;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/danmaku/DanmakuManager;", "", "danmakuBehavior", "Lcom/coolapk/market/view/danmaku/IDanmakuBehavior;", "(Lcom/coolapk/market/view/danmaku/IDanmakuBehavior;)V", "addDanmaku", "", "text", "Lcom/coolapk/market/view/danmaku/DanmakuText;", "onLayoutSizeChanged", "pause", "release", "resume", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DanmakuManager.kt */
public final class DanmakuManager {
    private final IDanmakuBehavior danmakuBehavior;

    public DanmakuManager(IDanmakuBehavior iDanmakuBehavior) {
        Intrinsics.checkNotNullParameter(iDanmakuBehavior, "danmakuBehavior");
        this.danmakuBehavior = iDanmakuBehavior;
    }

    public final void pause() {
        this.danmakuBehavior.pause();
    }

    public final void resume() {
        this.danmakuBehavior.resume();
    }

    public final void release() {
        this.danmakuBehavior.release();
    }

    public final void onLayoutSizeChanged() {
        this.danmakuBehavior.onLayoutSizeChanged();
    }

    public final void addDanmaku(DanmakuText danmakuText) {
        Intrinsics.checkNotNullParameter(danmakuText, "text");
        this.danmakuBehavior.addDanmaku(danmakuText);
    }
}
