package com.coolapk.market.view.danmaku.easy.danmaku;

import android.content.Context;
import android.widget.FrameLayout;
import com.coolapk.market.view.danmaku.easy.danmaku.CachedDanmakuViewPool;
import com.coolapk.market.view.danmaku.easy.danmaku.Danmaku;
import com.coolapk.market.view.danmaku.easy.utils.EasyL;
import com.coolapk.market.view.danmaku.easy.utils.ScreenUtil;
import java.lang.ref.WeakReference;
import java.util.Objects;

public class DanmakuManager {
    private static final int RESULT_FULL_POOL = 2;
    private static final int RESULT_NULL_ROOT_VIEW = 1;
    private static final int RESULT_OK = 0;
    private static final String TAG = "DanmakuManager";
    private static final int TOO_MANY_DANMAKU = 2;
    private static DanmakuManager sInstance;
    private Config mConfig;
    WeakReference<FrameLayout> mDanmakuContainer;
    private Pool<DanmakuView> mDanmakuViewPool;
    private DanmakuPositionCalculator mPositionCal;

    private DanmakuManager() {
    }

    public static DanmakuManager getInstance() {
        if (sInstance == null) {
            sInstance = new DanmakuManager();
        }
        return sInstance;
    }

    public void init(Context context, FrameLayout frameLayout) {
        if (this.mDanmakuViewPool == null) {
            this.mDanmakuViewPool = new CachedDanmakuViewPool(60000, 100, new CachedDanmakuViewPool.ViewCreator(context, frameLayout) {
                /* class com.coolapk.market.view.danmaku.easy.danmaku.$$Lambda$DanmakuManager$3uYYOM9u2mhRhKjM8nJpT2ocsw */
                public final /* synthetic */ Context f$0;
                public final /* synthetic */ FrameLayout f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                @Override // com.coolapk.market.view.danmaku.easy.danmaku.CachedDanmakuViewPool.ViewCreator
                public final Object create() {
                    return DanmakuViewFactory.createDanmakuView(this.f$0, this.f$1);
                }
            });
        }
        setDanmakuContainer(frameLayout);
        ScreenUtil.init(context);
        this.mConfig = new Config();
        this.mPositionCal = new DanmakuPositionCalculator(this);
    }

    public Config getConfig() {
        if (this.mConfig == null) {
            this.mConfig = new Config();
        }
        return this.mConfig;
    }

    private DanmakuPositionCalculator getPositionCalculator() {
        if (this.mPositionCal == null) {
            this.mPositionCal = new DanmakuPositionCalculator(this);
        }
        return this.mPositionCal;
    }

    public void setDanmakuViewPool(Pool<DanmakuView> pool) {
        Pool<DanmakuView> pool2 = this.mDanmakuViewPool;
        if (pool2 != null) {
            pool2.release();
        }
        this.mDanmakuViewPool = pool;
    }

    public void setMaxDanmakuSize(int i) {
        Pool<DanmakuView> pool = this.mDanmakuViewPool;
        if (pool != null) {
            pool.setMaxSize(i);
        }
    }

    public void setDanmakuContainer(FrameLayout frameLayout) {
        Objects.requireNonNull(frameLayout, "Danmaku container cannot be null!");
        this.mDanmakuContainer = new WeakReference<>(frameLayout);
    }

    public int send(Danmaku danmaku) {
        Pool<DanmakuView> pool = this.mDanmakuViewPool;
        Objects.requireNonNull(pool, "Danmaku view pool is null. Did you call init() first?");
        DanmakuView danmakuView = pool.get();
        if (danmakuView == null) {
            EasyL.w(TAG, "show: Too many danmaku, discard");
            return 2;
        }
        WeakReference<FrameLayout> weakReference = this.mDanmakuContainer;
        if (weakReference == null || weakReference.get() == null) {
            EasyL.w(TAG, "show: Root view is null.");
            return 1;
        }
        danmakuView.setDanmaku(danmaku);
        danmakuView.setTextSize(0, (float) danmaku.size);
        danmakuView.setTextColor(danmaku.color);
        int marginTop = getPositionCalculator().getMarginTop(danmakuView);
        if (marginTop == -1) {
            String str = TAG;
            EasyL.d(str, "send: screen is full, too many danmaku [" + danmaku + "]");
            return 2;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) danmakuView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        }
        layoutParams.topMargin = marginTop;
        layoutParams.height = getConfig().getLineHeight();
        danmakuView.setLayoutParams(layoutParams);
        danmakuView.show(this.mDanmakuContainer.get(), getDisplayDuration(danmaku));
        return 0;
    }

    int getDisplayDuration(Danmaku danmaku) {
        Config config = getConfig();
        int i = AnonymousClass1.$SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode[danmaku.mode.ordinal()];
        if (i == 1) {
            return config.getDurationTop();
        }
        if (i != 2) {
            return config.getDurationScroll();
        }
        return config.getDurationBottom();
    }

    /* renamed from: com.coolapk.market.view.danmaku.easy.danmaku.DanmakuManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode;

        static {
            int[] iArr = new int[Danmaku.Mode.values().length];
            $SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode = iArr;
            try {
                iArr[Danmaku.Mode.top.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode[Danmaku.Mode.bottom.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode[Danmaku.Mode.scroll.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Config {
        private int durationBottom;
        private int durationScroll;
        private int durationTop;
        private int lineHeight;
        private int lineSpace;
        private int maxScrollLine;

        public int getLineSpace() {
            return this.lineSpace;
        }

        public void setLineSpace(int i) {
            this.lineSpace = i;
        }

        public int getLineHeight() {
            return this.lineHeight;
        }

        public void setLineHeight(int i) {
            this.lineHeight = i;
        }

        public int getMaxScrollLine() {
            return this.maxScrollLine;
        }

        public int getDurationScroll() {
            if (this.durationScroll == 0) {
                this.durationScroll = 10000;
            }
            return this.durationScroll;
        }

        public void setDurationScroll(int i) {
            this.durationScroll = i;
        }

        public int getDurationTop() {
            if (this.durationTop == 0) {
                this.durationTop = 5000;
            }
            return this.durationTop;
        }

        public void setDurationTop(int i) {
            this.durationTop = i;
        }

        public int getDurationBottom() {
            if (this.durationBottom == 0) {
                this.durationBottom = 5000;
            }
            return this.durationBottom;
        }

        public void setDurationBottom(int i) {
            this.durationBottom = i;
        }

        public int getMaxDanmakuLine() {
            if (this.maxScrollLine == 0) {
                this.maxScrollLine = 12;
            }
            return this.maxScrollLine;
        }

        public void setMaxScrollLine(int i) {
            this.maxScrollLine = i;
        }
    }
}
