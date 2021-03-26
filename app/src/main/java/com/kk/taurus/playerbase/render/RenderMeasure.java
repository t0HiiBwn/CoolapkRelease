package com.kk.taurus.playerbase.render;

import android.view.View;
import com.kk.taurus.playerbase.log.PLog;

public final class RenderMeasure {
    private final String TAG = "RenderMeasure";
    private AspectRatio mCurrAspectRatio = AspectRatio.AspectRatio_FIT_PARENT;
    private int mMeasureHeight;
    private int mMeasureWidth;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00cf, code lost:
        if (r2 != false) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d2, code lost:
        if (r2 != false) goto L_0x00cb;
     */
    public void doMeasure(int i, int i2) {
        int i3;
        float f;
        int i4;
        int i5 = this.mVideoRotationDegree;
        if (i5 == 90 || i5 == 270) {
            i2 = i;
            i = i2;
        }
        int defaultSize = View.getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = View.getDefaultSize(this.mVideoHeight, i2);
        if (this.mCurrAspectRatio != AspectRatio.AspectRatio_MATCH_PARENT) {
            if (this.mVideoWidth <= 0 || this.mVideoHeight <= 0) {
                i = defaultSize;
                i2 = defaultSize2;
            } else {
                int mode = View.MeasureSpec.getMode(i);
                i = View.MeasureSpec.getSize(i);
                int mode2 = View.MeasureSpec.getMode(i2);
                i2 = View.MeasureSpec.getSize(i2);
                if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                    float f2 = (float) i;
                    float f3 = (float) i2;
                    float f4 = f2 / f3;
                    int i6 = AnonymousClass1.$SwitchMap$com$kk$taurus$playerbase$render$AspectRatio[this.mCurrAspectRatio.ordinal()];
                    if (i6 == 1) {
                        int i7 = this.mVideoRotationDegree;
                        f = (i7 == 90 || i7 == 270) ? 0.5625f : 1.7777778f;
                    } else if (i6 != 2) {
                        f = ((float) this.mVideoWidth) / ((float) this.mVideoHeight);
                        int i8 = this.mVideoSarNum;
                        if (i8 > 0 && (i4 = this.mVideoSarDen) > 0) {
                            f = (f * ((float) i8)) / ((float) i4);
                        }
                    } else {
                        int i9 = this.mVideoRotationDegree;
                        f = (i9 == 90 || i9 == 270) ? 0.75f : 1.3333334f;
                    }
                    boolean z = f > f4;
                    int i10 = AnonymousClass1.$SwitchMap$com$kk$taurus$playerbase$render$AspectRatio[this.mCurrAspectRatio.ordinal()];
                    if (i10 != 1 && i10 != 2 && i10 != 3) {
                        if (i10 != 4) {
                            if (i10 != 6) {
                                if (i10 != 7) {
                                    if (z) {
                                        i = Math.min(this.mVideoWidth, i);
                                        i2 = (int) (((float) i) / f);
                                    } else {
                                        int min = Math.min(this.mVideoHeight, i2);
                                        i2 = min;
                                        i = (int) (((float) min) * f);
                                    }
                                }
                            }
                            i2 = (int) (f2 / f);
                        }
                    }
                    i = (int) (f3 * f);
                } else if (mode == 1073741824 && mode2 == 1073741824) {
                    int i11 = this.mVideoWidth;
                    int i12 = i11 * i2;
                    int i13 = this.mVideoHeight;
                    if (i12 < i * i13) {
                        i = (i11 * i2) / i13;
                    } else if (i11 * i2 > i * i13) {
                        i2 = (i13 * i) / i11;
                    }
                } else if (mode == 1073741824) {
                    int i14 = (this.mVideoHeight * i) / this.mVideoWidth;
                    if (mode2 != Integer.MIN_VALUE || i14 <= i2) {
                        i2 = i14;
                    }
                } else if (mode2 == 1073741824) {
                    int i15 = (this.mVideoWidth * i2) / this.mVideoHeight;
                    if (mode != Integer.MIN_VALUE || i15 <= i) {
                        i = i15;
                    }
                } else {
                    int i16 = this.mVideoWidth;
                    int i17 = this.mVideoHeight;
                    if (mode2 != Integer.MIN_VALUE || i17 <= i2) {
                        i3 = i16;
                        i2 = i17;
                    } else {
                        i3 = (i2 * i16) / i17;
                    }
                    if (mode != Integer.MIN_VALUE || i3 <= i) {
                        i = i3;
                    } else {
                        i2 = (i17 * i) / i16;
                    }
                }
            }
        }
        this.mMeasureWidth = i;
        this.mMeasureHeight = i2;
    }

    /* renamed from: com.kk.taurus.playerbase.render.RenderMeasure$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$kk$taurus$playerbase$render$AspectRatio;

        static {
            int[] iArr = new int[AspectRatio.values().length];
            $SwitchMap$com$kk$taurus$playerbase$render$AspectRatio = iArr;
            try {
                iArr[AspectRatio.AspectRatio_16_9.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kk$taurus$playerbase$render$AspectRatio[AspectRatio.AspectRatio_4_3.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kk$taurus$playerbase$render$AspectRatio[AspectRatio.AspectRatio_FIT_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kk$taurus$playerbase$render$AspectRatio[AspectRatio.AspectRatio_FILL_PARENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kk$taurus$playerbase$render$AspectRatio[AspectRatio.AspectRatio_ORIGIN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$kk$taurus$playerbase$render$AspectRatio[AspectRatio.AspectRatio_FILL_WIDTH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$kk$taurus$playerbase$render$AspectRatio[AspectRatio.AspectRatio_FILL_HEIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        this.mVideoSarNum = i;
        this.mVideoSarDen = i2;
    }

    public void setVideoSize(int i, int i2) {
        PLog.d("RenderMeasure", "videoWidth = " + i + " videoHeight = " + i2);
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    public void setVideoRotation(int i) {
        this.mVideoRotationDegree = i;
    }

    public void setAspectRatio(AspectRatio aspectRatio) {
        if (aspectRatio == null) {
            aspectRatio = AspectRatio.AspectRatio_FIT_PARENT;
        }
        this.mCurrAspectRatio = aspectRatio;
    }

    public int getMeasureWidth() {
        return this.mMeasureWidth;
    }

    public int getMeasureHeight() {
        return this.mMeasureHeight;
    }
}
