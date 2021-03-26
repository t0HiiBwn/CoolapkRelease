package com.coolapk.market.widget.slidr.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import com.coolapk.market.widget.slidr.model.SlidrConfig;
import com.coolapk.market.widget.slidr.model.SlidrPosition;
import com.coolapk.market.widget.slidr.widget.ViewDragHelperS;

public class SliderPanel extends FrameLayout {
    private static final int MIN_FLING_VELOCITY = 400;
    private ViewDragHelperS.Callback mBottomCallback;
    private SlidrConfig mConfig;
    private View mDecorView;
    private View mDimView;
    private ViewDragHelperS mDragHelper;
    private int mEdgePosition;
    private ViewDragHelperS.Callback mHorizontalCallback;
    private boolean mIsEdgeTouched;
    private boolean mIsLocked;
    private ViewDragHelperS.Callback mLeftCallback;
    private OnPanelSlideListener mListener;
    private CanvasProxyView mProxyView;
    private ViewDragHelperS.Callback mRightCallback;
    private int mScreenHeight;
    private int mScreenWidth;
    private ViewDragHelperS.Callback mTopCallback;
    private ViewDragHelperS.Callback mVerticalCallback;

    public interface OnPanelSlideListener {
        void onClosed();

        void onOpened();

        void onSlideChange(float f);

        void onStateChanged(int i);
    }

    public SliderPanel(Context context) {
        super(context);
        this.mIsLocked = false;
        this.mIsEdgeTouched = false;
        this.mLeftCallback = new ViewDragHelperS.Callback() {
            /* class com.coolapk.market.widget.slidr.widget.SliderPanel.AnonymousClass2 */

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public boolean tryCaptureView(View view, int i) {
                boolean z = !SliderPanel.this.mConfig.isEdgeOnly() || SliderPanel.this.mIsEdgeTouched;
                if (view.getId() != SliderPanel.this.mDecorView.getId() || !z) {
                    return false;
                }
                return true;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return SliderPanel.clamp(i, 0, SliderPanel.this.mScreenWidth);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int getViewHorizontalDragRange(View view) {
                return SliderPanel.this.mScreenWidth;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewReleased(View view, float f, float f2) {
                super.onViewReleased(view, f, f2);
                int translationX = (int) view.getTranslationX();
                int width = (int) (((float) SliderPanel.this.getWidth()) * SliderPanel.this.mConfig.getDistanceThreshold());
                int i = 0;
                boolean z = Math.abs(f2) > SliderPanel.this.mConfig.getVelocityThreshold();
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i2 > 0) {
                    if (Math.abs(f) > SliderPanel.this.mConfig.getVelocityThreshold() && !z) {
                        i = SliderPanel.this.mScreenWidth;
                    } else if (translationX > width) {
                        i = SliderPanel.this.mScreenWidth;
                    }
                } else if (i2 == 0 && translationX > width) {
                    i = SliderPanel.this.mScreenWidth;
                }
                SliderPanel.this.mDragHelper.settleCapturedViewAt(i, view.getTop());
                SliderPanel.this.invalidate();
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                float f = 1.0f - (((float) i) / ((float) SliderPanel.this.mScreenWidth));
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onSlideChange(f);
                }
                SliderPanel.this.applyScrim(f);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewDragStateChanged(int i) {
                super.onViewDragStateChanged(i);
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onStateChanged(i);
                }
                if (i == 0) {
                    if (SliderPanel.this.mDecorView.getTranslationX() == 0.0f) {
                        if (SliderPanel.this.mListener != null) {
                            SliderPanel.this.mListener.onOpened();
                        }
                    } else if (SliderPanel.this.mListener != null) {
                        SliderPanel.this.mListener.onClosed();
                    }
                }
            }
        };
        this.mRightCallback = new ViewDragHelperS.Callback() {
            /* class com.coolapk.market.widget.slidr.widget.SliderPanel.AnonymousClass3 */

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public boolean tryCaptureView(View view, int i) {
                boolean z = !SliderPanel.this.mConfig.isEdgeOnly() || SliderPanel.this.mDragHelper.isEdgeTouched(SliderPanel.this.mEdgePosition, i);
                if (view.getId() != SliderPanel.this.mDecorView.getId() || !z) {
                    return false;
                }
                return true;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return SliderPanel.clamp(i, -SliderPanel.this.mScreenWidth, 0);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int getViewHorizontalDragRange(View view) {
                return SliderPanel.this.mScreenWidth;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i;
                super.onViewReleased(view, f, f2);
                int translationX = (int) view.getTranslationX();
                int width = (int) (((float) SliderPanel.this.getWidth()) * SliderPanel.this.mConfig.getDistanceThreshold());
                int i2 = 0;
                boolean z = Math.abs(f2) > SliderPanel.this.mConfig.getVelocityThreshold();
                if (f >= 0.0f) {
                    if (f == 0.0f && translationX < (-width)) {
                        i = SliderPanel.this.mScreenWidth;
                    }
                    SliderPanel.this.mDragHelper.settleCapturedViewAt(i2, view.getTop());
                    SliderPanel.this.invalidate();
                } else if (Math.abs(f) <= SliderPanel.this.mConfig.getVelocityThreshold() || z) {
                    if (translationX < (-width)) {
                        i = SliderPanel.this.mScreenWidth;
                    }
                    SliderPanel.this.mDragHelper.settleCapturedViewAt(i2, view.getTop());
                    SliderPanel.this.invalidate();
                } else {
                    i = SliderPanel.this.mScreenWidth;
                }
                i2 = -i;
                SliderPanel.this.mDragHelper.settleCapturedViewAt(i2, view.getTop());
                SliderPanel.this.invalidate();
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                float abs = 1.0f - (((float) Math.abs(i)) / ((float) SliderPanel.this.mScreenWidth));
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onSlideChange(abs);
                }
                SliderPanel.this.applyScrim(abs);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewDragStateChanged(int i) {
                super.onViewDragStateChanged(i);
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onStateChanged(i);
                }
                if (i == 0) {
                    if (SliderPanel.this.mDecorView.getTranslationX() == 0.0f) {
                        if (SliderPanel.this.mListener != null) {
                            SliderPanel.this.mListener.onOpened();
                        }
                    } else if (SliderPanel.this.mListener != null) {
                        SliderPanel.this.mListener.onClosed();
                    }
                }
            }
        };
        this.mTopCallback = new ViewDragHelperS.Callback() {
            /* class com.coolapk.market.widget.slidr.widget.SliderPanel.AnonymousClass4 */

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public boolean tryCaptureView(View view, int i) {
                return view.getId() == SliderPanel.this.mDecorView.getId() && (!SliderPanel.this.mConfig.isEdgeOnly() || SliderPanel.this.mIsEdgeTouched);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return SliderPanel.clamp(i, 0, SliderPanel.this.mScreenHeight);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int getViewVerticalDragRange(View view) {
                return SliderPanel.this.mScreenHeight;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewReleased(View view, float f, float f2) {
                super.onViewReleased(view, f, f2);
                int top = view.getTop();
                int height = (int) (((float) SliderPanel.this.getHeight()) * SliderPanel.this.mConfig.getDistanceThreshold());
                int i = 0;
                boolean z = Math.abs(f) > SliderPanel.this.mConfig.getVelocityThreshold();
                int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i2 > 0) {
                    if (Math.abs(f2) > SliderPanel.this.mConfig.getVelocityThreshold() && !z) {
                        i = SliderPanel.this.mScreenHeight;
                    } else if (top > height) {
                        i = SliderPanel.this.mScreenHeight;
                    }
                } else if (i2 == 0 && top > height) {
                    i = SliderPanel.this.mScreenHeight;
                }
                SliderPanel.this.mDragHelper.settleCapturedViewAt((int) view.getTranslationX(), i);
                SliderPanel.this.invalidate();
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                float abs = 1.0f - (((float) Math.abs(i2)) / ((float) SliderPanel.this.mScreenHeight));
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onSlideChange(abs);
                }
                SliderPanel.this.applyScrim(abs);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewDragStateChanged(int i) {
                super.onViewDragStateChanged(i);
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onStateChanged(i);
                }
                if (i == 0) {
                    if (SliderPanel.this.mDecorView.getTop() == 0) {
                        if (SliderPanel.this.mListener != null) {
                            SliderPanel.this.mListener.onOpened();
                        }
                    } else if (SliderPanel.this.mListener != null) {
                        SliderPanel.this.mListener.onClosed();
                    }
                }
            }
        };
        this.mBottomCallback = new ViewDragHelperS.Callback() {
            /* class com.coolapk.market.widget.slidr.widget.SliderPanel.AnonymousClass5 */

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public boolean tryCaptureView(View view, int i) {
                return view.getId() == SliderPanel.this.mDecorView.getId() && (!SliderPanel.this.mConfig.isEdgeOnly() || SliderPanel.this.mIsEdgeTouched);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return SliderPanel.clamp(i, -SliderPanel.this.mScreenHeight, 0);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int getViewVerticalDragRange(View view) {
                return SliderPanel.this.mScreenHeight;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i;
                super.onViewReleased(view, f, f2);
                int top = view.getTop();
                int height = (int) (((float) SliderPanel.this.getHeight()) * SliderPanel.this.mConfig.getDistanceThreshold());
                int i2 = 0;
                boolean z = Math.abs(f) > SliderPanel.this.mConfig.getVelocityThreshold();
                if (f2 >= 0.0f) {
                    if (f2 == 0.0f && top < (-height)) {
                        i = SliderPanel.this.mScreenHeight;
                    }
                    SliderPanel.this.mDragHelper.settleCapturedViewAt((int) view.getTranslationX(), i2);
                    SliderPanel.this.invalidate();
                } else if (Math.abs(f2) <= SliderPanel.this.mConfig.getVelocityThreshold() || z) {
                    if (top < (-height)) {
                        i = SliderPanel.this.mScreenHeight;
                    }
                    SliderPanel.this.mDragHelper.settleCapturedViewAt((int) view.getTranslationX(), i2);
                    SliderPanel.this.invalidate();
                } else {
                    i = SliderPanel.this.mScreenHeight;
                }
                i2 = -i;
                SliderPanel.this.mDragHelper.settleCapturedViewAt((int) view.getTranslationX(), i2);
                SliderPanel.this.invalidate();
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                float abs = 1.0f - (((float) Math.abs(i2)) / ((float) SliderPanel.this.mScreenHeight));
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onSlideChange(abs);
                }
                SliderPanel.this.applyScrim(abs);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewDragStateChanged(int i) {
                super.onViewDragStateChanged(i);
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onStateChanged(i);
                }
                if (i == 0) {
                    if (SliderPanel.this.mDecorView.getTop() == 0) {
                        if (SliderPanel.this.mListener != null) {
                            SliderPanel.this.mListener.onOpened();
                        }
                    } else if (SliderPanel.this.mListener != null) {
                        SliderPanel.this.mListener.onClosed();
                    }
                }
            }
        };
        this.mVerticalCallback = new ViewDragHelperS.Callback() {
            /* class com.coolapk.market.widget.slidr.widget.SliderPanel.AnonymousClass6 */

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public boolean tryCaptureView(View view, int i) {
                return view.getId() == SliderPanel.this.mDecorView.getId() && (!SliderPanel.this.mConfig.isEdgeOnly() || SliderPanel.this.mIsEdgeTouched);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return SliderPanel.clamp(i, -SliderPanel.this.mScreenHeight, SliderPanel.this.mScreenHeight);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int getViewVerticalDragRange(View view) {
                return SliderPanel.this.mScreenHeight;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i;
                super.onViewReleased(view, f, f2);
                int top = view.getTop();
                int height = (int) (((float) SliderPanel.this.getHeight()) * SliderPanel.this.mConfig.getDistanceThreshold());
                int i2 = 0;
                boolean z = Math.abs(f) > SliderPanel.this.mConfig.getVelocityThreshold();
                if (f2 <= 0.0f) {
                    if (f2 < 0.0f) {
                        if (Math.abs(f2) > SliderPanel.this.mConfig.getVelocityThreshold() && !z) {
                            i = SliderPanel.this.mScreenHeight;
                        } else if (top < (-height)) {
                            i = SliderPanel.this.mScreenHeight;
                        }
                    } else if (top > height) {
                        i2 = SliderPanel.this.mScreenHeight;
                    } else if (top < (-height)) {
                        i = SliderPanel.this.mScreenHeight;
                    }
                    i2 = -i;
                } else if (Math.abs(f2) > SliderPanel.this.mConfig.getVelocityThreshold() && !z) {
                    i2 = SliderPanel.this.mScreenHeight;
                } else if (top > height) {
                    i2 = SliderPanel.this.mScreenHeight;
                }
                SliderPanel.this.mDragHelper.settleCapturedViewAt((int) view.getTranslationX(), i2);
                SliderPanel.this.invalidate();
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                float abs = 1.0f - (((float) Math.abs(i2)) / ((float) SliderPanel.this.mScreenHeight));
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onSlideChange(abs);
                }
                SliderPanel.this.applyScrim(abs);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewDragStateChanged(int i) {
                super.onViewDragStateChanged(i);
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onStateChanged(i);
                }
                if (i == 0) {
                    if (SliderPanel.this.mDecorView.getTop() == 0) {
                        if (SliderPanel.this.mListener != null) {
                            SliderPanel.this.mListener.onOpened();
                        }
                    } else if (SliderPanel.this.mListener != null) {
                        SliderPanel.this.mListener.onClosed();
                    }
                }
            }
        };
        this.mHorizontalCallback = new ViewDragHelperS.Callback() {
            /* class com.coolapk.market.widget.slidr.widget.SliderPanel.AnonymousClass7 */

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public boolean tryCaptureView(View view, int i) {
                boolean z = !SliderPanel.this.mConfig.isEdgeOnly() || SliderPanel.this.mDragHelper.isEdgeTouched(SliderPanel.this.mEdgePosition, i);
                if (view.getId() != SliderPanel.this.mDecorView.getId() || !z) {
                    return false;
                }
                return true;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return SliderPanel.clamp(i, -SliderPanel.this.mScreenWidth, SliderPanel.this.mScreenWidth);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int getViewHorizontalDragRange(View view) {
                return SliderPanel.this.mScreenWidth;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i;
                super.onViewReleased(view, f, f2);
                int translationX = (int) view.getTranslationX();
                int width = (int) (((float) SliderPanel.this.getWidth()) * SliderPanel.this.mConfig.getDistanceThreshold());
                int i2 = 0;
                boolean z = Math.abs(f2) > SliderPanel.this.mConfig.getVelocityThreshold();
                if (f <= 0.0f) {
                    if (f < 0.0f) {
                        if (Math.abs(f) > SliderPanel.this.mConfig.getVelocityThreshold() && !z) {
                            i = SliderPanel.this.mScreenWidth;
                        } else if (translationX < (-width)) {
                            i = SliderPanel.this.mScreenWidth;
                        }
                    } else if (translationX > width) {
                        i2 = SliderPanel.this.mScreenWidth;
                    } else if (translationX < (-width)) {
                        i = SliderPanel.this.mScreenWidth;
                    }
                    i2 = -i;
                } else if (Math.abs(f) > SliderPanel.this.mConfig.getVelocityThreshold() && !z) {
                    i2 = SliderPanel.this.mScreenWidth;
                } else if (translationX > width) {
                    i2 = SliderPanel.this.mScreenWidth;
                }
                SliderPanel.this.mDragHelper.settleCapturedViewAt(i2, view.getTop());
                SliderPanel.this.invalidate();
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                float abs = 1.0f - (((float) Math.abs(i)) / ((float) SliderPanel.this.mScreenWidth));
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onSlideChange(abs);
                }
                SliderPanel.this.applyScrim(abs);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewDragStateChanged(int i) {
                super.onViewDragStateChanged(i);
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onStateChanged(i);
                }
                if (i == 0) {
                    if (SliderPanel.this.mDecorView.getTranslationX() == 0.0f) {
                        if (SliderPanel.this.mListener != null) {
                            SliderPanel.this.mListener.onOpened();
                        }
                    } else if (SliderPanel.this.mListener != null) {
                        SliderPanel.this.mListener.onClosed();
                    }
                }
            }
        };
    }

    public SliderPanel(Context context, View view) {
        this(context, view, null);
    }

    public SliderPanel(Context context, View view, SlidrConfig slidrConfig) {
        super(context);
        this.mIsLocked = false;
        this.mIsEdgeTouched = false;
        this.mLeftCallback = new ViewDragHelperS.Callback() {
            /* class com.coolapk.market.widget.slidr.widget.SliderPanel.AnonymousClass2 */

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public boolean tryCaptureView(View view, int i) {
                boolean z = !SliderPanel.this.mConfig.isEdgeOnly() || SliderPanel.this.mIsEdgeTouched;
                if (view.getId() != SliderPanel.this.mDecorView.getId() || !z) {
                    return false;
                }
                return true;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return SliderPanel.clamp(i, 0, SliderPanel.this.mScreenWidth);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int getViewHorizontalDragRange(View view) {
                return SliderPanel.this.mScreenWidth;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewReleased(View view, float f, float f2) {
                super.onViewReleased(view, f, f2);
                int translationX = (int) view.getTranslationX();
                int width = (int) (((float) SliderPanel.this.getWidth()) * SliderPanel.this.mConfig.getDistanceThreshold());
                int i = 0;
                boolean z = Math.abs(f2) > SliderPanel.this.mConfig.getVelocityThreshold();
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i2 > 0) {
                    if (Math.abs(f) > SliderPanel.this.mConfig.getVelocityThreshold() && !z) {
                        i = SliderPanel.this.mScreenWidth;
                    } else if (translationX > width) {
                        i = SliderPanel.this.mScreenWidth;
                    }
                } else if (i2 == 0 && translationX > width) {
                    i = SliderPanel.this.mScreenWidth;
                }
                SliderPanel.this.mDragHelper.settleCapturedViewAt(i, view.getTop());
                SliderPanel.this.invalidate();
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                float f = 1.0f - (((float) i) / ((float) SliderPanel.this.mScreenWidth));
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onSlideChange(f);
                }
                SliderPanel.this.applyScrim(f);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewDragStateChanged(int i) {
                super.onViewDragStateChanged(i);
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onStateChanged(i);
                }
                if (i == 0) {
                    if (SliderPanel.this.mDecorView.getTranslationX() == 0.0f) {
                        if (SliderPanel.this.mListener != null) {
                            SliderPanel.this.mListener.onOpened();
                        }
                    } else if (SliderPanel.this.mListener != null) {
                        SliderPanel.this.mListener.onClosed();
                    }
                }
            }
        };
        this.mRightCallback = new ViewDragHelperS.Callback() {
            /* class com.coolapk.market.widget.slidr.widget.SliderPanel.AnonymousClass3 */

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public boolean tryCaptureView(View view, int i) {
                boolean z = !SliderPanel.this.mConfig.isEdgeOnly() || SliderPanel.this.mDragHelper.isEdgeTouched(SliderPanel.this.mEdgePosition, i);
                if (view.getId() != SliderPanel.this.mDecorView.getId() || !z) {
                    return false;
                }
                return true;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return SliderPanel.clamp(i, -SliderPanel.this.mScreenWidth, 0);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int getViewHorizontalDragRange(View view) {
                return SliderPanel.this.mScreenWidth;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i;
                super.onViewReleased(view, f, f2);
                int translationX = (int) view.getTranslationX();
                int width = (int) (((float) SliderPanel.this.getWidth()) * SliderPanel.this.mConfig.getDistanceThreshold());
                int i2 = 0;
                boolean z = Math.abs(f2) > SliderPanel.this.mConfig.getVelocityThreshold();
                if (f >= 0.0f) {
                    if (f == 0.0f && translationX < (-width)) {
                        i = SliderPanel.this.mScreenWidth;
                    }
                    SliderPanel.this.mDragHelper.settleCapturedViewAt(i2, view.getTop());
                    SliderPanel.this.invalidate();
                } else if (Math.abs(f) <= SliderPanel.this.mConfig.getVelocityThreshold() || z) {
                    if (translationX < (-width)) {
                        i = SliderPanel.this.mScreenWidth;
                    }
                    SliderPanel.this.mDragHelper.settleCapturedViewAt(i2, view.getTop());
                    SliderPanel.this.invalidate();
                } else {
                    i = SliderPanel.this.mScreenWidth;
                }
                i2 = -i;
                SliderPanel.this.mDragHelper.settleCapturedViewAt(i2, view.getTop());
                SliderPanel.this.invalidate();
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                float abs = 1.0f - (((float) Math.abs(i)) / ((float) SliderPanel.this.mScreenWidth));
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onSlideChange(abs);
                }
                SliderPanel.this.applyScrim(abs);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewDragStateChanged(int i) {
                super.onViewDragStateChanged(i);
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onStateChanged(i);
                }
                if (i == 0) {
                    if (SliderPanel.this.mDecorView.getTranslationX() == 0.0f) {
                        if (SliderPanel.this.mListener != null) {
                            SliderPanel.this.mListener.onOpened();
                        }
                    } else if (SliderPanel.this.mListener != null) {
                        SliderPanel.this.mListener.onClosed();
                    }
                }
            }
        };
        this.mTopCallback = new ViewDragHelperS.Callback() {
            /* class com.coolapk.market.widget.slidr.widget.SliderPanel.AnonymousClass4 */

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public boolean tryCaptureView(View view, int i) {
                return view.getId() == SliderPanel.this.mDecorView.getId() && (!SliderPanel.this.mConfig.isEdgeOnly() || SliderPanel.this.mIsEdgeTouched);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return SliderPanel.clamp(i, 0, SliderPanel.this.mScreenHeight);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int getViewVerticalDragRange(View view) {
                return SliderPanel.this.mScreenHeight;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewReleased(View view, float f, float f2) {
                super.onViewReleased(view, f, f2);
                int top = view.getTop();
                int height = (int) (((float) SliderPanel.this.getHeight()) * SliderPanel.this.mConfig.getDistanceThreshold());
                int i = 0;
                boolean z = Math.abs(f) > SliderPanel.this.mConfig.getVelocityThreshold();
                int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i2 > 0) {
                    if (Math.abs(f2) > SliderPanel.this.mConfig.getVelocityThreshold() && !z) {
                        i = SliderPanel.this.mScreenHeight;
                    } else if (top > height) {
                        i = SliderPanel.this.mScreenHeight;
                    }
                } else if (i2 == 0 && top > height) {
                    i = SliderPanel.this.mScreenHeight;
                }
                SliderPanel.this.mDragHelper.settleCapturedViewAt((int) view.getTranslationX(), i);
                SliderPanel.this.invalidate();
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                float abs = 1.0f - (((float) Math.abs(i2)) / ((float) SliderPanel.this.mScreenHeight));
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onSlideChange(abs);
                }
                SliderPanel.this.applyScrim(abs);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewDragStateChanged(int i) {
                super.onViewDragStateChanged(i);
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onStateChanged(i);
                }
                if (i == 0) {
                    if (SliderPanel.this.mDecorView.getTop() == 0) {
                        if (SliderPanel.this.mListener != null) {
                            SliderPanel.this.mListener.onOpened();
                        }
                    } else if (SliderPanel.this.mListener != null) {
                        SliderPanel.this.mListener.onClosed();
                    }
                }
            }
        };
        this.mBottomCallback = new ViewDragHelperS.Callback() {
            /* class com.coolapk.market.widget.slidr.widget.SliderPanel.AnonymousClass5 */

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public boolean tryCaptureView(View view, int i) {
                return view.getId() == SliderPanel.this.mDecorView.getId() && (!SliderPanel.this.mConfig.isEdgeOnly() || SliderPanel.this.mIsEdgeTouched);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return SliderPanel.clamp(i, -SliderPanel.this.mScreenHeight, 0);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int getViewVerticalDragRange(View view) {
                return SliderPanel.this.mScreenHeight;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i;
                super.onViewReleased(view, f, f2);
                int top = view.getTop();
                int height = (int) (((float) SliderPanel.this.getHeight()) * SliderPanel.this.mConfig.getDistanceThreshold());
                int i2 = 0;
                boolean z = Math.abs(f) > SliderPanel.this.mConfig.getVelocityThreshold();
                if (f2 >= 0.0f) {
                    if (f2 == 0.0f && top < (-height)) {
                        i = SliderPanel.this.mScreenHeight;
                    }
                    SliderPanel.this.mDragHelper.settleCapturedViewAt((int) view.getTranslationX(), i2);
                    SliderPanel.this.invalidate();
                } else if (Math.abs(f2) <= SliderPanel.this.mConfig.getVelocityThreshold() || z) {
                    if (top < (-height)) {
                        i = SliderPanel.this.mScreenHeight;
                    }
                    SliderPanel.this.mDragHelper.settleCapturedViewAt((int) view.getTranslationX(), i2);
                    SliderPanel.this.invalidate();
                } else {
                    i = SliderPanel.this.mScreenHeight;
                }
                i2 = -i;
                SliderPanel.this.mDragHelper.settleCapturedViewAt((int) view.getTranslationX(), i2);
                SliderPanel.this.invalidate();
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                float abs = 1.0f - (((float) Math.abs(i2)) / ((float) SliderPanel.this.mScreenHeight));
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onSlideChange(abs);
                }
                SliderPanel.this.applyScrim(abs);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewDragStateChanged(int i) {
                super.onViewDragStateChanged(i);
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onStateChanged(i);
                }
                if (i == 0) {
                    if (SliderPanel.this.mDecorView.getTop() == 0) {
                        if (SliderPanel.this.mListener != null) {
                            SliderPanel.this.mListener.onOpened();
                        }
                    } else if (SliderPanel.this.mListener != null) {
                        SliderPanel.this.mListener.onClosed();
                    }
                }
            }
        };
        this.mVerticalCallback = new ViewDragHelperS.Callback() {
            /* class com.coolapk.market.widget.slidr.widget.SliderPanel.AnonymousClass6 */

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public boolean tryCaptureView(View view, int i) {
                return view.getId() == SliderPanel.this.mDecorView.getId() && (!SliderPanel.this.mConfig.isEdgeOnly() || SliderPanel.this.mIsEdgeTouched);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return SliderPanel.clamp(i, -SliderPanel.this.mScreenHeight, SliderPanel.this.mScreenHeight);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int getViewVerticalDragRange(View view) {
                return SliderPanel.this.mScreenHeight;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i;
                super.onViewReleased(view, f, f2);
                int top = view.getTop();
                int height = (int) (((float) SliderPanel.this.getHeight()) * SliderPanel.this.mConfig.getDistanceThreshold());
                int i2 = 0;
                boolean z = Math.abs(f) > SliderPanel.this.mConfig.getVelocityThreshold();
                if (f2 <= 0.0f) {
                    if (f2 < 0.0f) {
                        if (Math.abs(f2) > SliderPanel.this.mConfig.getVelocityThreshold() && !z) {
                            i = SliderPanel.this.mScreenHeight;
                        } else if (top < (-height)) {
                            i = SliderPanel.this.mScreenHeight;
                        }
                    } else if (top > height) {
                        i2 = SliderPanel.this.mScreenHeight;
                    } else if (top < (-height)) {
                        i = SliderPanel.this.mScreenHeight;
                    }
                    i2 = -i;
                } else if (Math.abs(f2) > SliderPanel.this.mConfig.getVelocityThreshold() && !z) {
                    i2 = SliderPanel.this.mScreenHeight;
                } else if (top > height) {
                    i2 = SliderPanel.this.mScreenHeight;
                }
                SliderPanel.this.mDragHelper.settleCapturedViewAt((int) view.getTranslationX(), i2);
                SliderPanel.this.invalidate();
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                float abs = 1.0f - (((float) Math.abs(i2)) / ((float) SliderPanel.this.mScreenHeight));
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onSlideChange(abs);
                }
                SliderPanel.this.applyScrim(abs);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewDragStateChanged(int i) {
                super.onViewDragStateChanged(i);
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onStateChanged(i);
                }
                if (i == 0) {
                    if (SliderPanel.this.mDecorView.getTop() == 0) {
                        if (SliderPanel.this.mListener != null) {
                            SliderPanel.this.mListener.onOpened();
                        }
                    } else if (SliderPanel.this.mListener != null) {
                        SliderPanel.this.mListener.onClosed();
                    }
                }
            }
        };
        this.mHorizontalCallback = new ViewDragHelperS.Callback() {
            /* class com.coolapk.market.widget.slidr.widget.SliderPanel.AnonymousClass7 */

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public boolean tryCaptureView(View view, int i) {
                boolean z = !SliderPanel.this.mConfig.isEdgeOnly() || SliderPanel.this.mDragHelper.isEdgeTouched(SliderPanel.this.mEdgePosition, i);
                if (view.getId() != SliderPanel.this.mDecorView.getId() || !z) {
                    return false;
                }
                return true;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return SliderPanel.clamp(i, -SliderPanel.this.mScreenWidth, SliderPanel.this.mScreenWidth);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public int getViewHorizontalDragRange(View view) {
                return SliderPanel.this.mScreenWidth;
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i;
                super.onViewReleased(view, f, f2);
                int translationX = (int) view.getTranslationX();
                int width = (int) (((float) SliderPanel.this.getWidth()) * SliderPanel.this.mConfig.getDistanceThreshold());
                int i2 = 0;
                boolean z = Math.abs(f2) > SliderPanel.this.mConfig.getVelocityThreshold();
                if (f <= 0.0f) {
                    if (f < 0.0f) {
                        if (Math.abs(f) > SliderPanel.this.mConfig.getVelocityThreshold() && !z) {
                            i = SliderPanel.this.mScreenWidth;
                        } else if (translationX < (-width)) {
                            i = SliderPanel.this.mScreenWidth;
                        }
                    } else if (translationX > width) {
                        i2 = SliderPanel.this.mScreenWidth;
                    } else if (translationX < (-width)) {
                        i = SliderPanel.this.mScreenWidth;
                    }
                    i2 = -i;
                } else if (Math.abs(f) > SliderPanel.this.mConfig.getVelocityThreshold() && !z) {
                    i2 = SliderPanel.this.mScreenWidth;
                } else if (translationX > width) {
                    i2 = SliderPanel.this.mScreenWidth;
                }
                SliderPanel.this.mDragHelper.settleCapturedViewAt(i2, view.getTop());
                SliderPanel.this.invalidate();
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                float abs = 1.0f - (((float) Math.abs(i)) / ((float) SliderPanel.this.mScreenWidth));
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onSlideChange(abs);
                }
                SliderPanel.this.applyScrim(abs);
            }

            @Override // com.coolapk.market.widget.slidr.widget.ViewDragHelperS.Callback
            public void onViewDragStateChanged(int i) {
                super.onViewDragStateChanged(i);
                if (SliderPanel.this.mListener != null) {
                    SliderPanel.this.mListener.onStateChanged(i);
                }
                if (i == 0) {
                    if (SliderPanel.this.mDecorView.getTranslationX() == 0.0f) {
                        if (SliderPanel.this.mListener != null) {
                            SliderPanel.this.mListener.onOpened();
                        }
                    } else if (SliderPanel.this.mListener != null) {
                        SliderPanel.this.mListener.onClosed();
                    }
                }
            }
        };
        this.mDecorView = view;
        this.mConfig = slidrConfig == null ? new SlidrConfig.Builder().build() : slidrConfig;
        init();
    }

    public void setOnPanelSlideListener(OnPanelSlideListener onPanelSlideListener) {
        this.mListener = onPanelSlideListener;
    }

    private void init() {
        ViewDragHelperS.Callback callback;
        this.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        float f = getResources().getDisplayMetrics().density * 400.0f;
        switch (AnonymousClass8.$SwitchMap$com$coolapk$market$widget$slidr$model$SlidrPosition[this.mConfig.getPosition().ordinal()]) {
            case 1:
                callback = this.mLeftCallback;
                this.mEdgePosition = 1;
                break;
            case 2:
                callback = this.mRightCallback;
                this.mEdgePosition = 2;
                break;
            case 3:
                callback = this.mTopCallback;
                this.mEdgePosition = 4;
                break;
            case 4:
                callback = this.mBottomCallback;
                this.mEdgePosition = 8;
                break;
            case 5:
                callback = this.mVerticalCallback;
                this.mEdgePosition = 12;
                break;
            case 6:
                callback = this.mHorizontalCallback;
                this.mEdgePosition = 3;
                break;
            default:
                callback = this.mLeftCallback;
                this.mEdgePosition = 1;
                break;
        }
        ViewDragHelperS create = ViewDragHelperS.create(this, this.mConfig.getSensitivity(), callback);
        this.mDragHelper = create;
        create.setMinVelocity(f);
        this.mDragHelper.setEdgeTrackingEnabled(this.mEdgePosition);
        ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
        CanvasProxyView canvasProxyView = new CanvasProxyView(getContext());
        this.mProxyView = canvasProxyView;
        addView(canvasProxyView);
        View view = new View(getContext());
        this.mDimView = view;
        view.setBackgroundColor(this.mConfig.getScrimColor());
        this.mDimView.setAlpha(this.mConfig.getScrimStartAlpha());
        addView(this.mDimView);
        post(new Runnable() {
            /* class com.coolapk.market.widget.slidr.widget.SliderPanel.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                SliderPanel sliderPanel = SliderPanel.this;
                sliderPanel.mScreenHeight = sliderPanel.getHeight();
            }
        });
    }

    /* renamed from: com.coolapk.market.widget.slidr.widget.SliderPanel$8  reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$coolapk$market$widget$slidr$model$SlidrPosition;

        static {
            int[] iArr = new int[SlidrPosition.values().length];
            $SwitchMap$com$coolapk$market$widget$slidr$model$SlidrPosition = iArr;
            try {
                iArr[SlidrPosition.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$coolapk$market$widget$slidr$model$SlidrPosition[SlidrPosition.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$coolapk$market$widget$slidr$model$SlidrPosition[SlidrPosition.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$coolapk$market$widget$slidr$model$SlidrPosition[SlidrPosition.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$coolapk$market$widget$slidr$model$SlidrPosition[SlidrPosition.VERTICAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$coolapk$market$widget$slidr$model$SlidrPosition[SlidrPosition.HORIZONTAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public View getDimView() {
        return this.mDimView;
    }

    public CanvasProxyView getCanvasProxyView() {
        return this.mProxyView;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mIsLocked) {
            return false;
        }
        if (this.mConfig.isEdgeOnly()) {
            this.mIsEdgeTouched = canDragFromEdge(motionEvent);
        }
        try {
            z = this.mDragHelper.shouldInterceptTouchEvent(motionEvent);
        } catch (Exception unused) {
            z = false;
        }
        if (!z || this.mIsLocked) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mIsLocked) {
            return false;
        }
        try {
            this.mDragHelper.processTouchEvent(motionEvent);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void lock() {
        this.mDragHelper.abort();
        this.mIsLocked = true;
    }

    public void unlock() {
        this.mDragHelper.abort();
        this.mIsLocked = false;
    }

    private boolean canDragFromEdge(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (AnonymousClass8.$SwitchMap$com$coolapk$market$widget$slidr$model$SlidrPosition[this.mConfig.getPosition().ordinal()]) {
            case 1:
                if (x < this.mConfig.getEdgeSize((float) getWidth())) {
                    return true;
                }
                return false;
            case 2:
                if (x > ((float) getWidth()) - this.mConfig.getEdgeSize((float) getWidth())) {
                    return true;
                }
                return false;
            case 3:
                if (y < this.mConfig.getEdgeSize((float) getHeight())) {
                    return true;
                }
                return false;
            case 4:
                if (y > ((float) getHeight()) - this.mConfig.getEdgeSize((float) getHeight())) {
                    return true;
                }
                return false;
            case 5:
                if (y < this.mConfig.getEdgeSize((float) getHeight()) || y > ((float) getHeight()) - this.mConfig.getEdgeSize((float) getHeight())) {
                    return true;
                }
                return false;
            case 6:
                if (x < this.mConfig.getEdgeSize((float) getWidth()) || x > ((float) getWidth()) - this.mConfig.getEdgeSize((float) getWidth())) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public void applyScrim(float f) {
        this.mDimView.setAlpha((f * (this.mConfig.getScrimStartAlpha() - this.mConfig.getScrimEndAlpha())) + this.mConfig.getScrimEndAlpha());
    }

    public static int clamp(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }
}
