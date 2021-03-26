package com.coolapk.market.view.danmaku;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/danmaku/IDanmakuBehavior;", "", "addDanmaku", "", "danmakuText", "Lcom/coolapk/market/view/danmaku/DanmakuText;", "onLayoutSizeChanged", "pause", "release", "resume", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IDanmakuBehavior.kt */
public interface IDanmakuBehavior {
    void addDanmaku(DanmakuText danmakuText);

    void onLayoutSizeChanged();

    void pause();

    void release();

    void resume();
}
