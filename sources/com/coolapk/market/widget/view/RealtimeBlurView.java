package com.coolapk.market.widget.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import com.coolapk.market.R;

public class RealtimeBlurView extends View {
    static Boolean DEBUG = null;
    private static int RENDERING_COUNT;
    private static StopException STOP_EXCEPTION = new StopException();
    private Bitmap mBitmapToBlur;
    private Allocation mBlurInput;
    private Allocation mBlurOutput;
    private float mBlurRadius;
    private ScriptIntrinsicBlur mBlurScript;
    private Bitmap mBlurredBitmap;
    private Canvas mBlurringCanvas;
    private View mDecorView;
    private boolean mDifferentRoot;
    private boolean mDirty;
    private float mDownsampleFactor;
    private boolean mIsRendering;
    private int mOverlayColor;
    private final Rect mRectDst = new Rect();
    private final Rect mRectSrc = new Rect();
    private RenderScript mRenderScript;
    private final ViewTreeObserver.OnPreDrawListener preDrawListener = new ViewTreeObserver.OnPreDrawListener() {
        /* class com.coolapk.market.widget.view.RealtimeBlurView.AnonymousClass1 */

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            int[] iArr = new int[2];
            Bitmap bitmap = RealtimeBlurView.this.mBlurredBitmap;
            View view = RealtimeBlurView.this.mDecorView;
            if (view != null && RealtimeBlurView.this.isShown() && RealtimeBlurView.this.prepare()) {
                boolean z = RealtimeBlurView.this.mBlurredBitmap != bitmap;
                view.getLocationOnScreen(iArr);
                RealtimeBlurView.this.getLocationOnScreen(iArr);
                int i = (-iArr[0]) + iArr[0];
                int i2 = (-iArr[1]) + iArr[1];
                RealtimeBlurView.this.mBitmapToBlur.eraseColor(RealtimeBlurView.this.mOverlayColor & 16777215);
                int save = RealtimeBlurView.this.mBlurringCanvas.save();
                RealtimeBlurView.this.mIsRendering = true;
                RealtimeBlurView.access$608();
                try {
                    RealtimeBlurView.this.mBlurringCanvas.scale((((float) RealtimeBlurView.this.mBitmapToBlur.getWidth()) * 1.0f) / ((float) RealtimeBlurView.this.getWidth()), (((float) RealtimeBlurView.this.mBitmapToBlur.getHeight()) * 1.0f) / ((float) RealtimeBlurView.this.getHeight()));
                    RealtimeBlurView.this.mBlurringCanvas.translate((float) (-i), (float) (-i2));
                    if (view.getBackground() != null) {
                        view.getBackground().draw(RealtimeBlurView.this.mBlurringCanvas);
                    }
                    view.draw(RealtimeBlurView.this.mBlurringCanvas);
                } catch (StopException unused) {
                } catch (Throwable th) {
                    RealtimeBlurView.this.mIsRendering = false;
                    RealtimeBlurView.access$610();
                    RealtimeBlurView.this.mBlurringCanvas.restoreToCount(save);
                    throw th;
                }
                RealtimeBlurView.this.mIsRendering = false;
                RealtimeBlurView.access$610();
                RealtimeBlurView.this.mBlurringCanvas.restoreToCount(save);
                RealtimeBlurView realtimeBlurView = RealtimeBlurView.this;
                realtimeBlurView.blur(realtimeBlurView.mBitmapToBlur, RealtimeBlurView.this.mBlurredBitmap);
                if (z || RealtimeBlurView.this.mDifferentRoot) {
                    RealtimeBlurView.this.invalidate();
                }
            }
            return true;
        }
    };

    static /* synthetic */ int access$608() {
        int i = RENDERING_COUNT;
        RENDERING_COUNT = i + 1;
        return i;
    }

    static /* synthetic */ int access$610() {
        int i = RENDERING_COUNT;
        RENDERING_COUNT = i - 1;
        return i;
    }

    public RealtimeBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RealtimeBlurView);
        this.mBlurRadius = obtainStyledAttributes.getDimension(0, TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()));
        this.mDownsampleFactor = obtainStyledAttributes.getFloat(1, 4.0f);
        this.mOverlayColor = obtainStyledAttributes.getColor(2, -1426063361);
        obtainStyledAttributes.recycle();
    }

    public void setBlurRadius(float f) {
        if (this.mBlurRadius != f) {
            this.mBlurRadius = f;
            this.mDirty = true;
            invalidate();
        }
    }

    public void setDownsampleFactor(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Downsample factor must be greater than 0.");
        } else if (this.mDownsampleFactor != f) {
            this.mDownsampleFactor = f;
            this.mDirty = true;
            releaseBitmap();
            invalidate();
        }
    }

    public void setOverlayColor(int i) {
        if (this.mOverlayColor != i) {
            this.mOverlayColor = i;
            invalidate();
        }
    }

    private void releaseBitmap() {
        Allocation allocation = this.mBlurInput;
        if (allocation != null) {
            allocation.destroy();
            this.mBlurInput = null;
        }
        Allocation allocation2 = this.mBlurOutput;
        if (allocation2 != null) {
            allocation2.destroy();
            this.mBlurOutput = null;
        }
        Bitmap bitmap = this.mBitmapToBlur;
        if (bitmap != null) {
            bitmap.recycle();
            this.mBitmapToBlur = null;
        }
        Bitmap bitmap2 = this.mBlurredBitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.mBlurredBitmap = null;
        }
    }

    private void releaseScript() {
        RenderScript renderScript = this.mRenderScript;
        if (renderScript != null) {
            renderScript.destroy();
            this.mRenderScript = null;
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.mBlurScript;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.mBlurScript = null;
        }
    }

    protected void release() {
        releaseBitmap();
        releaseScript();
    }

    protected boolean prepare() {
        Bitmap bitmap;
        if (this.mBlurRadius == 0.0f) {
            release();
            return false;
        }
        float f = this.mDownsampleFactor;
        if (this.mDirty || this.mRenderScript == null) {
            if (this.mRenderScript == null) {
                try {
                    RenderScript create = RenderScript.create(getContext());
                    this.mRenderScript = create;
                    this.mBlurScript = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                } catch (RSRuntimeException e) {
                    if (!isDebug(getContext())) {
                        releaseScript();
                        return false;
                    } else if (e.getMessage() == null || !e.getMessage().startsWith("Error loading RS jni library: java.lang.UnsatisfiedLinkError:")) {
                        throw e;
                    } else {
                        throw new RuntimeException("Error loading RS jni library, Upgrade buildToolsVersion=\"24.0.2\" or higher may solve this issue");
                    }
                }
            }
            this.mDirty = false;
            float f2 = this.mBlurRadius / f;
            if (f2 > 25.0f) {
                f = (f * f2) / 25.0f;
                f2 = 25.0f;
            }
            this.mBlurScript.setRadius(f2);
        }
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(1, (int) (((float) width) / f));
        int max2 = Math.max(1, (int) (((float) height) / f));
        if (this.mBlurringCanvas == null || (bitmap = this.mBlurredBitmap) == null || bitmap.getWidth() != max || this.mBlurredBitmap.getHeight() != max2) {
            releaseBitmap();
            try {
                Bitmap createBitmap = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.mBitmapToBlur = createBitmap;
                if (createBitmap == null) {
                    releaseBitmap();
                    return false;
                }
                this.mBlurringCanvas = new Canvas(this.mBitmapToBlur);
                Allocation createFromBitmap = Allocation.createFromBitmap(this.mRenderScript, this.mBitmapToBlur, Allocation.MipmapControl.MIPMAP_NONE, 1);
                this.mBlurInput = createFromBitmap;
                this.mBlurOutput = Allocation.createTyped(this.mRenderScript, createFromBitmap.getType());
                Bitmap createBitmap2 = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.mBlurredBitmap = createBitmap2;
                if (createBitmap2 == null) {
                    releaseBitmap();
                    return false;
                }
            } catch (OutOfMemoryError unused) {
                releaseBitmap();
                return false;
            } catch (Throwable unused2) {
                releaseBitmap();
                return false;
            }
        }
        return true;
    }

    protected void blur(Bitmap bitmap, Bitmap bitmap2) {
        this.mBlurInput.copyFrom(bitmap);
        this.mBlurScript.setInput(this.mBlurInput);
        this.mBlurScript.forEach(this.mBlurOutput);
        this.mBlurOutput.copyTo(bitmap2);
    }

    protected View getActivityDecorView() {
        Context context = getContext();
        for (int i = 0; i < 4 && context != null && !(context instanceof Activity) && (context instanceof ContextWrapper); i++) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView();
        }
        return null;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        View activityDecorView = getActivityDecorView();
        this.mDecorView = activityDecorView;
        boolean z = false;
        if (activityDecorView != null) {
            activityDecorView.getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
            if (this.mDecorView.getRootView() != getRootView()) {
                z = true;
            }
            this.mDifferentRoot = z;
            if (z) {
                this.mDecorView.postInvalidate();
                return;
            }
            return;
        }
        this.mDifferentRoot = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        View view = this.mDecorView;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this.preDrawListener);
        }
        release();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.mIsRendering) {
            throw STOP_EXCEPTION;
        } else if (RENDERING_COUNT <= 0) {
            super.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBlurredBitmap(canvas, this.mBlurredBitmap, this.mOverlayColor);
    }

    protected void drawBlurredBitmap(Canvas canvas, Bitmap bitmap, int i) {
        if (bitmap != null) {
            this.mRectSrc.right = bitmap.getWidth();
            this.mRectSrc.bottom = bitmap.getHeight();
            this.mRectDst.right = getWidth();
            this.mRectDst.bottom = getHeight();
            canvas.drawBitmap(bitmap, this.mRectSrc, this.mRectDst, (Paint) null);
        }
        canvas.drawColor(i);
    }

    private static class StopException extends RuntimeException {
        private StopException() {
        }
    }

    static {
        try {
            RealtimeBlurView.class.getClassLoader().loadClass("android.renderscript.RenderScript");
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("RenderScript support not enabled. Add \"android { defaultConfig { renderscriptSupportModeEnabled true }}\" in your build.gradle");
        }
    }

    static boolean isDebug(Context context) {
        if (DEBUG == null && context != null) {
            DEBUG = Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
        }
        if (DEBUG == Boolean.TRUE) {
            return true;
        }
        return false;
    }
}
