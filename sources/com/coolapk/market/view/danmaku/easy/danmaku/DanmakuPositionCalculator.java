package com.coolapk.market.view.danmaku.easy.danmaku;

import android.widget.FrameLayout;
import com.coolapk.market.view.danmaku.easy.danmaku.Danmaku;
import com.coolapk.market.view.danmaku.easy.danmaku.DanmakuView;
import java.util.ArrayList;
import java.util.List;

class DanmakuPositionCalculator {
    private static final String TAG = "DanPositionCalculator";
    private boolean[] mBottoms;
    private DanmakuManager mDanmakuManager;
    private List<DanmakuView> mLastDanmakus = new ArrayList();
    private boolean[] mTops;

    DanmakuPositionCalculator(DanmakuManager danmakuManager) {
        this.mDanmakuManager = danmakuManager;
        int maxDanmakuLine = danmakuManager.getConfig().getMaxDanmakuLine();
        this.mTops = new boolean[maxDanmakuLine];
        this.mBottoms = new boolean[maxDanmakuLine];
    }

    private int getLineHeightWithPadding() {
        return this.mDanmakuManager.getConfig().getLineSpace() + this.mDanmakuManager.getConfig().getLineHeight();
    }

    /* renamed from: com.coolapk.market.view.danmaku.easy.danmaku.DanmakuPositionCalculator$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode;

        static {
            int[] iArr = new int[Danmaku.Mode.values().length];
            $SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode = iArr;
            try {
                iArr[Danmaku.Mode.scroll.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode[Danmaku.Mode.top.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode[Danmaku.Mode.bottom.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    int getMarginTop(DanmakuView danmakuView) {
        int i = AnonymousClass1.$SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode[danmakuView.getDanmaku().mode.ordinal()];
        if (i == 1) {
            return getScrollY(danmakuView);
        }
        if (i == 2) {
            return getTopY(danmakuView);
        }
        if (i != 3) {
            return -1;
        }
        return getBottomY(danmakuView);
    }

    private int getScrollY(DanmakuView danmakuView) {
        int i = 0;
        if (this.mLastDanmakus.size() == 0) {
            this.mLastDanmakus.add(danmakuView);
            return 0;
        }
        while (i < this.mLastDanmakus.size()) {
            DanmakuView danmakuView2 = this.mLastDanmakus.get(i);
            int calTimeDisappear = calTimeDisappear(danmakuView2);
            int calTimeArrive = calTimeArrive(danmakuView);
            boolean isFullyShown = isFullyShown(danmakuView2);
            if (calTimeDisappear > calTimeArrive || !isFullyShown) {
                i++;
            } else {
                this.mLastDanmakus.set(i, danmakuView);
                return i * getLineHeightWithPadding();
            }
        }
        int maxDanmakuLine = this.mDanmakuManager.getConfig().getMaxDanmakuLine();
        if (maxDanmakuLine != 0 && i >= maxDanmakuLine) {
            return -1;
        }
        this.mLastDanmakus.add(danmakuView);
        return i * getLineHeightWithPadding();
    }

    private int getTopY(DanmakuView danmakuView) {
        int i = 0;
        while (true) {
            boolean[] zArr = this.mTops;
            if (i >= zArr.length) {
                return -1;
            }
            if (!zArr[i]) {
                zArr[i] = true;
                danmakuView.addOnExitListener(new DanmakuView.OnExitListener(i) {
                    /* class com.coolapk.market.view.danmaku.easy.danmaku.$$Lambda$DanmakuPositionCalculator$K4umdfKK0ubZekm7dWyugXiIGaw */
                    public final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    @Override // com.coolapk.market.view.danmaku.easy.danmaku.DanmakuView.OnExitListener
                    public final void onExit(DanmakuView danmakuView) {
                        DanmakuPositionCalculator.this.lambda$getTopY$0$DanmakuPositionCalculator(this.f$1, danmakuView);
                    }
                });
                return i * getLineHeightWithPadding();
            }
            i++;
        }
    }

    public /* synthetic */ void lambda$getTopY$0$DanmakuPositionCalculator(int i, DanmakuView danmakuView) {
        this.mTops[i] = false;
    }

    private int getBottomY(DanmakuView danmakuView) {
        int i = 0;
        while (true) {
            boolean[] zArr = this.mBottoms;
            if (i >= zArr.length) {
                return -1;
            }
            if (!zArr[i]) {
                zArr[i] = true;
                danmakuView.addOnExitListener(new DanmakuView.OnExitListener(i) {
                    /* class com.coolapk.market.view.danmaku.easy.danmaku.$$Lambda$DanmakuPositionCalculator$vmKYSYvHx_jHM2HVMY0wP87Pd4 */
                    public final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    @Override // com.coolapk.market.view.danmaku.easy.danmaku.DanmakuView.OnExitListener
                    public final void onExit(DanmakuView danmakuView) {
                        DanmakuPositionCalculator.this.lambda$getBottomY$1$DanmakuPositionCalculator(this.f$1, danmakuView);
                    }
                });
                return getParentHeight() - ((i + 1) * getLineHeightWithPadding());
            }
            i++;
        }
    }

    public /* synthetic */ void lambda$getBottomY$1$DanmakuPositionCalculator(int i, DanmakuView danmakuView) {
        this.mBottoms[i] = false;
    }

    private boolean isFullyShown(DanmakuView danmakuView) {
        if (danmakuView == null) {
            return true;
        }
        if (danmakuView.getTextLength() - danmakuView.getScrollX() < getParentWidth()) {
            return true;
        }
        return false;
    }

    private int calTimeDisappear(DanmakuView danmakuView) {
        if (danmakuView == null) {
            return 0;
        }
        return (int) (((float) (danmakuView.getTextLength() - danmakuView.getScrollX())) / calSpeed(danmakuView));
    }

    private int calTimeArrive(DanmakuView danmakuView) {
        return (int) (((float) getParentWidth()) / calSpeed(danmakuView));
    }

    private float calSpeed(DanmakuView danmakuView) {
        return (((float) (danmakuView.getTextLength() + getParentWidth())) + 0.0f) / ((float) this.mDanmakuManager.getDisplayDuration(danmakuView.getDanmaku()));
    }

    private int getParentHeight() {
        FrameLayout frameLayout = this.mDanmakuManager.mDanmakuContainer.get();
        if (frameLayout == null || frameLayout.getHeight() == 0) {
            return 1080;
        }
        return frameLayout.getHeight();
    }

    private int getParentWidth() {
        FrameLayout frameLayout = this.mDanmakuManager.mDanmakuContainer.get();
        if (frameLayout == null || frameLayout.getWidth() == 0) {
            return 1920;
        }
        return frameLayout.getWidth();
    }
}
