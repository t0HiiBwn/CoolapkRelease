package com.coolapk.market.view.danmaku;

import android.text.Annotation;
import android.text.SpannableStringBuilder;
import android.widget.FrameLayout;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.danmaku.easy.danmaku.Danmaku;
import com.coolapk.market.view.danmaku.easy.danmaku.DanmakuManager;
import com.coolapk.market.view.danmaku.easy.utils.ScreenUtil;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/danmaku/EasyDanmakuBehavior;", "Lcom/coolapk/market/view/danmaku/IDanmakuBehavior;", "container", "Landroid/widget/FrameLayout;", "(Landroid/widget/FrameLayout;)V", "manager", "Lcom/coolapk/market/view/danmaku/easy/danmaku/DanmakuManager;", "kotlin.jvm.PlatformType", "addDanmaku", "", "danmakuText", "Lcom/coolapk/market/view/danmaku/DanmakuText;", "onLayoutSizeChanged", "pause", "release", "resume", "updateConfig", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EasyDanmakuBehavior.kt */
public final class EasyDanmakuBehavior implements IDanmakuBehavior {
    private final FrameLayout container;
    private final DanmakuManager manager;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DanmakuTextStyle.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DanmakuTextStyle.NORMAL.ordinal()] = 1;
            iArr[DanmakuTextStyle.MYSELF.ordinal()] = 2;
            iArr[DanmakuTextStyle.PRESENTER.ordinal()] = 3;
            iArr[DanmakuTextStyle.ALL.ordinal()] = 4;
        }
    }

    @Override // com.coolapk.market.view.danmaku.IDanmakuBehavior
    public void pause() {
    }

    @Override // com.coolapk.market.view.danmaku.IDanmakuBehavior
    public void release() {
    }

    @Override // com.coolapk.market.view.danmaku.IDanmakuBehavior
    public void resume() {
    }

    public EasyDanmakuBehavior(FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "container");
        this.container = frameLayout;
        DanmakuManager instance = DanmakuManager.getInstance();
        this.manager = instance;
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        instance.init(frameLayout.getContext(), frameLayout);
        instance.setMaxDanmakuSize(120);
        updateConfig();
    }

    @Override // com.coolapk.market.view.danmaku.IDanmakuBehavior
    public void onLayoutSizeChanged() {
        ScreenUtil.init(this.container.getContext());
        updateConfig();
    }

    @Override // com.coolapk.market.view.danmaku.IDanmakuBehavior
    public void addDanmaku(DanmakuText danmakuText) {
        Intrinsics.checkNotNullParameter(danmakuText, "danmakuText");
        Danmaku danmaku = new Danmaku();
        danmaku.size = NumberExtendsKt.getSp(Integer.valueOf(ScreenUtil.isPortrait() ? 15 : 18));
        danmaku.mode = Danmaku.Mode.scroll;
        danmaku.color = (int) 4294967295L;
        SpannableStringBuilder convert = LinkTextUtils.convert(danmakuText.getText(), danmaku.color, null);
        int i = WhenMappings.$EnumSwitchMapping$0[danmakuText.getDanmakuTextStyle().ordinal()];
        if (i == 1) {
            danmaku.text = convert;
        } else if (i == 2) {
            convert.setSpan(new Annotation("rounded", "rounded"), 0, convert.length(), 33);
            danmaku.text = convert;
        } else if (i == 3) {
            danmaku.text = convert.insert(0, (CharSequence) "主持人: ");
        } else if (i == 4) {
            SpannableStringBuilder insert = convert.insert(0, (CharSequence) "主持人: ");
            insert.setSpan(new Annotation("rounded", "rounded"), 0, convert.length(), 33);
            danmaku.text = insert;
        }
        this.manager.send(danmaku);
    }

    private final void updateConfig() {
        DanmakuManager danmakuManager = this.manager;
        Intrinsics.checkNotNullExpressionValue(danmakuManager, "manager");
        DanmakuManager.Config config = danmakuManager.getConfig();
        boolean isPortrait = ScreenUtil.isPortrait();
        Intrinsics.checkNotNullExpressionValue(config, "config");
        config.setDurationScroll((int) TimeUnit.SECONDS.toMillis(isPortrait ? 6 : 8));
        config.setLineHeight(NumberExtendsKt.getDp(Integer.valueOf(ScreenUtil.isPortrait() ? 22 : 26)));
        config.setLineSpace(NumberExtendsKt.getDp(Integer.valueOf(ScreenUtil.isPortrait() ? 1 : 2)));
        int i = this.container.getLayoutParams().height;
        int lineSpace = i > 0 ? (i + config.getLineSpace()) / (config.getLineHeight() + config.getLineSpace()) : 5;
        config.setMaxScrollLine(lineSpace);
        LogUtils.d("弹幕最大行数: " + lineSpace, new Object[0]);
    }
}
