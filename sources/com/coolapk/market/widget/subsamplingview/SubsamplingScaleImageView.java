package com.coolapk.market.widget.subsamplingview;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.coolapk.market.R;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.widget.subsamplingview.decoder.CompatDecoderFactory;
import com.coolapk.market.widget.subsamplingview.decoder.DecoderFactory;
import com.coolapk.market.widget.subsamplingview.decoder.ImageDecoder;
import com.coolapk.market.widget.subsamplingview.decoder.ImageRegionDecoder;
import com.coolapk.market.widget.subsamplingview.decoder.SkiaImageDecoder;
import com.coolapk.market.widget.subsamplingview.decoder.SkiaImageRegionDecoder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

public class SubsamplingScaleImageView extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    private static final String TAG = "SubsamplingScaleImageView";
    public static int TILE_SIZE_AUTO = Integer.MAX_VALUE;
    private static final List<Integer> VALID_EASING_STYLES = Arrays.asList(2, 1);
    private static final List<Integer> VALID_ORIENTATIONS = Arrays.asList(0, 90, 180, 270, -1);
    private static final List<Integer> VALID_PAN_LIMITS = Arrays.asList(1, 2, 3);
    private static final List<Integer> VALID_SCALE_TYPES = Arrays.asList(2, 1, 3);
    private static final List<Integer> VALID_ZOOM_STYLES = Arrays.asList(1, 2, 3);
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private Anim anim;
    private Bitmap bitmap;
    private DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugPaint;
    private ImageRegionDecoder decoder;
    private final Object decoderLock;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private float[] dstArray;
    private int fullImageSampleSize;
    private Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    private boolean isQuickScaling;
    private boolean isZooming;
    private Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    private int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    private OnImageEventListener onImageEventListener;
    private View.OnLongClickListener onLongClickListener;
    private int orientation;
    private Rect pRegion;
    private boolean panEnabled;
    private int panLimit;
    private boolean parallelLoadingEnabled;
    private Float pendingScale;
    private PointF quickScaleCenter;
    private boolean quickScaleEnabled;
    private float quickScaleLastDistance;
    private PointF quickScaleLastPoint;
    private boolean quickScaleMoved;
    private final float quickScaleThreshold;
    private boolean readySent;
    private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    private Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    private float scale;
    private float scaleStart;
    private float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    private PointF vCenterStart;
    private float vDistStart;
    private PointF vTranslate;
    private PointF vTranslateStart;
    private boolean zoomEnabled;

    public static class DefaultOnAnimationEventListener implements OnAnimationEventListener {
        @Override // com.coolapk.market.widget.subsamplingview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onComplete() {
        }

        @Override // com.coolapk.market.widget.subsamplingview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByNewAnim() {
        }

        @Override // com.coolapk.market.widget.subsamplingview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByUser() {
        }
    }

    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    private float easeInOutQuad(long j, float f, float f2, long j2) {
        float f3;
        float f4 = ((float) j) / (((float) j2) / 2.0f);
        if (f4 < 1.0f) {
            f3 = (f2 / 2.0f) * f4;
        } else {
            float f5 = f4 - 1.0f;
            f3 = (-f2) / 2.0f;
            f4 = (f5 * (f5 - 2.0f)) - 1.0f;
        }
        return (f3 * f4) + f;
    }

    private float easeOutQuad(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / ((float) j2);
        return ((-f2) * f3 * (f3 - 2.0f)) + f;
    }

    protected void onImageLoaded() {
    }

    protected void onReady() {
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        this.decoderLock = new Object();
        this.orientation = -1;
        this.maxScale = 2.0f;
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        int i = TILE_SIZE_AUTO;
        this.maxTileWidth = i;
        this.maxTileHeight = i;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 500;
        this.minScale = minScale();
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setWillNotDraw(false);
        setGestureDetector(context);
        this.handler = new Handler(new Handler.Callback() {
            /* class com.coolapk.market.widget.subsamplingview.SubsamplingScaleImageView.AnonymousClass1 */

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 1 && SubsamplingScaleImageView.this.onLongClickListener != null) {
                    SubsamplingScaleImageView.this.maxTouchCount = 0;
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.onLongClickListener);
                    SubsamplingScaleImageView.this.performLongClick();
                    SubsamplingScaleImageView.super.setOnLongClickListener(null);
                }
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SubsamplingScaleImageView);
            if (obtainStyledAttributes.hasValue(0) && (string = obtainStyledAttributes.getString(0)) != null && string.length() > 0) {
                setImage(ImageSource.asset(string).tilingEnabled());
            }
            if (obtainStyledAttributes.hasValue(3) && (resourceId = obtainStyledAttributes.getResourceId(3, 0)) > 0) {
                setImage(ImageSource.resource(resourceId).tilingEnabled());
            }
            if (obtainStyledAttributes.hasValue(1)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(1, true));
            }
            if (obtainStyledAttributes.hasValue(5)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(5, true));
            }
            if (obtainStyledAttributes.hasValue(2)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(2, true));
            }
            if (obtainStyledAttributes.hasValue(4)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(4, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }

    public final void setImage(ImageSource imageSource) {
        setImage(imageSource, null, null);
    }

    public final void setImage(ImageSource imageSource, ImageViewState imageViewState) {
        setImage(imageSource, null, imageViewState);
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2) {
        setImage(imageSource, imageSource2, null);
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2, ImageViewState imageViewState) {
        String str = TAG;
        LogUtils.d(str, "setImageuri:" + imageSource.getUri().toString() + "id" + System.identityHashCode(this));
        Objects.requireNonNull(imageSource, "imageSource must not be null");
        reset(true);
        if (imageViewState != null) {
            restoreState(imageViewState);
        }
        if (imageSource2 != null) {
            if (imageSource.getBitmap() != null) {
                throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            } else if (imageSource.getSWidth() <= 0 || imageSource.getSHeight() <= 0) {
                throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
            } else {
                this.sWidth = imageSource.getSWidth();
                this.sHeight = imageSource.getSHeight();
                this.pRegion = imageSource2.getSRegion();
                if (imageSource2.getBitmap() != null) {
                    this.bitmapIsCached = imageSource2.isCached();
                    onPreviewLoaded(imageSource2.getBitmap());
                } else {
                    Uri uri2 = imageSource2.getUri();
                    if (uri2 == null && imageSource2.getResource() != null) {
                        uri2 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource2.getResource());
                    }
                    execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, uri2, true));
                }
            }
        }
        if (imageSource.getBitmap() != null && imageSource.getSRegion() != null) {
            onImageLoaded(Bitmap.createBitmap(imageSource.getBitmap(), imageSource.getSRegion().left, imageSource.getSRegion().top, imageSource.getSRegion().width(), imageSource.getSRegion().height()), 0, false);
        } else if (imageSource.getBitmap() != null) {
            onImageLoaded(imageSource.getBitmap(), 0, imageSource.isCached());
        } else {
            this.sRegion = imageSource.getSRegion();
            Uri uri3 = imageSource.getUri();
            this.uri = uri3;
            if (uri3 == null && imageSource.getResource() != null) {
                this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource.getResource());
            }
            if (imageSource.getTile() || this.sRegion != null) {
                execute(new TilesInitTask(this, getContext(), this.regionDecoderFactory, this.uri));
            } else {
                execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
            }
        }
    }

    private void reset(boolean z) {
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.pendingScale = Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleCenter = null;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleLastPoint = null;
        this.quickScaleMoved = false;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z) {
            this.uri = null;
            if (this.decoder != null) {
                synchronized (this.decoderLock) {
                    this.decoder.recycle();
                    this.decoder = null;
                }
            }
            Bitmap bitmap2 = this.bitmap;
            if (bitmap2 != null && !this.bitmapIsCached) {
                bitmap2.recycle();
            }
            this.sWidth = 0;
            this.sHeight = 0;
            this.sOrientation = 0;
            this.sRegion = null;
            this.pRegion = null;
            this.readySent = false;
            this.imageLoadedSent = false;
            this.bitmap = null;
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map != null) {
            for (Map.Entry<Integer, List<Tile>> entry : map.entrySet()) {
                for (Tile tile : entry.getValue()) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    /* access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            /* class com.coolapk.market.widget.subsamplingview.SubsamplingScaleImageView.AnonymousClass2 */

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (!SubsamplingScaleImageView.this.panEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f) <= 500.0f && Math.abs(f2) <= 500.0f) || SubsamplingScaleImageView.this.isZooming))) {
                    return super.onFling(motionEvent, motionEvent2, f, f2);
                }
                PointF pointF = new PointF(SubsamplingScaleImageView.this.vTranslate.x + (f * 0.25f), SubsamplingScaleImageView.this.vTranslate.y + (f2 * 0.25f));
                new AnimationBuilder(new PointF((((float) (SubsamplingScaleImageView.this.getWidth() / 2)) - pointF.x) / SubsamplingScaleImageView.this.scale, (((float) (SubsamplingScaleImageView.this.getHeight() / 2)) - pointF.y) / SubsamplingScaleImageView.this.scale)).withEasing(1).withPanLimited(false).start();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (!SubsamplingScaleImageView.this.zoomEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null) {
                    return super.onDoubleTapEvent(motionEvent);
                }
                SubsamplingScaleImageView.this.setGestureDetector(context);
                if (SubsamplingScaleImageView.this.quickScaleEnabled) {
                    SubsamplingScaleImageView.this.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                    SubsamplingScaleImageView.this.vTranslateStart = new PointF(SubsamplingScaleImageView.this.vTranslate.x, SubsamplingScaleImageView.this.vTranslate.y);
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    subsamplingScaleImageView.scaleStart = subsamplingScaleImageView.scale;
                    SubsamplingScaleImageView.this.isQuickScaling = true;
                    SubsamplingScaleImageView.this.isZooming = true;
                    SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
                    subsamplingScaleImageView2.quickScaleCenter = subsamplingScaleImageView2.viewToSourceCoord(subsamplingScaleImageView2.vCenterStart);
                    SubsamplingScaleImageView.this.quickScaleLastDistance = -1.0f;
                    SubsamplingScaleImageView.this.quickScaleLastPoint = new PointF(SubsamplingScaleImageView.this.quickScaleCenter.x, SubsamplingScaleImageView.this.quickScaleCenter.y);
                    SubsamplingScaleImageView.this.quickScaleMoved = false;
                    return false;
                }
                SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
                subsamplingScaleImageView3.doubleTapZoom(subsamplingScaleImageView3.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                return true;
            }
        });
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        PointF center = getCenter();
        if (this.readySent && center != null) {
            this.anim = null;
            this.pendingScale = Float.valueOf(this.scale);
            this.sPendingCenter = center;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0087, code lost:
        if (r6 != 262) goto L_0x036d;
     */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        GestureDetector gestureDetector;
        Anim anim2 = this.anim;
        if (anim2 == null || anim2.interruptible) {
            Anim anim3 = this.anim;
            boolean z2 = false;
            if (!(anim3 == null || anim3.listener == null)) {
                try {
                    this.anim.listener.onInterruptedByUser();
                } catch (Exception e) {
                    LogUtils.w(TAG, "Error thrown by animation listener", e);
                }
            }
            this.anim = null;
            if (this.vTranslate == null) {
                return true;
            }
            if (this.isQuickScaling || ((gestureDetector = this.detector) != null && !gestureDetector.onTouchEvent(motionEvent))) {
                if (this.vTranslateStart == null) {
                    this.vTranslateStart = new PointF(0.0f, 0.0f);
                }
                if (this.vCenterStart == null) {
                    this.vCenterStart = new PointF(0.0f, 0.0f);
                }
                int pointerCount = motionEvent.getPointerCount();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (this.maxTouchCount > 0) {
                                if (pointerCount >= 2) {
                                    float distance = distance(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                                    float x = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                                    float y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                                    if (this.zoomEnabled && (distance(this.vCenterStart.x, x, this.vCenterStart.y, y) > 5.0f || Math.abs(distance - this.vDistStart) > 5.0f || this.isPanning)) {
                                        this.isZooming = true;
                                        this.isPanning = true;
                                        float min = Math.min(this.maxScale, (distance / this.vDistStart) * this.scaleStart);
                                        this.scale = min;
                                        if (min <= minScale()) {
                                            this.vDistStart = distance;
                                            this.scaleStart = minScale();
                                            this.vCenterStart.set(x, y);
                                            this.vTranslateStart.set(this.vTranslate);
                                        } else if (this.panEnabled) {
                                            float f = this.vCenterStart.x - this.vTranslateStart.x;
                                            float f2 = this.vCenterStart.y - this.vTranslateStart.y;
                                            float f3 = this.scale;
                                            float f4 = this.scaleStart;
                                            this.vTranslate.x = x - (f * (f3 / f4));
                                            this.vTranslate.y = y - (f2 * (f3 / f4));
                                        } else if (this.sRequestedCenter != null) {
                                            this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * this.sRequestedCenter.x);
                                            this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * this.sRequestedCenter.y);
                                        } else {
                                            this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (sWidth() / 2)));
                                            this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (sHeight() / 2)));
                                        }
                                        fitToBounds(true);
                                        refreshRequiredTiles(false);
                                    }
                                } else if (this.isQuickScaling) {
                                    float abs = (Math.abs(this.vCenterStart.y - motionEvent.getY()) * 2.0f) + this.quickScaleThreshold;
                                    if (this.quickScaleLastDistance == -1.0f) {
                                        this.quickScaleLastDistance = abs;
                                    }
                                    boolean z3 = motionEvent.getY() > this.quickScaleLastPoint.y;
                                    this.quickScaleLastPoint.set(0.0f, motionEvent.getY());
                                    float f5 = 1.0f;
                                    float abs2 = Math.abs(1.0f - (abs / this.quickScaleLastDistance)) * 0.5f;
                                    if (abs2 > 0.03f || this.quickScaleMoved) {
                                        this.quickScaleMoved = true;
                                        if (this.quickScaleLastDistance > 0.0f) {
                                            f5 = z3 ? abs2 + 1.0f : 1.0f - abs2;
                                        }
                                        this.scale = Math.max(minScale(), Math.min(this.maxScale, this.scale * f5));
                                        if (this.panEnabled) {
                                            float f6 = this.vCenterStart.x - this.vTranslateStart.x;
                                            float f7 = this.vCenterStart.y - this.vTranslateStart.y;
                                            float f8 = this.scale;
                                            float f9 = this.scaleStart;
                                            this.vTranslate.x = this.vCenterStart.x - (f6 * (f8 / f9));
                                            this.vTranslate.y = this.vCenterStart.y - (f7 * (f8 / f9));
                                        } else if (this.sRequestedCenter != null) {
                                            this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * this.sRequestedCenter.x);
                                            this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * this.sRequestedCenter.y);
                                        } else {
                                            this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (sWidth() / 2)));
                                            this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (sHeight() / 2)));
                                        }
                                    }
                                    this.quickScaleLastDistance = abs;
                                    fitToBounds(true);
                                    refreshRequiredTiles(false);
                                } else if (!this.isZooming) {
                                    float abs3 = Math.abs(motionEvent.getX() - this.vCenterStart.x);
                                    float abs4 = Math.abs(motionEvent.getY() - this.vCenterStart.y);
                                    int i = (abs3 > 5.0f ? 1 : (abs3 == 5.0f ? 0 : -1));
                                    if (i > 0 || abs4 > 5.0f || this.isPanning) {
                                        this.vTranslate.x = this.vTranslateStart.x + (motionEvent.getX() - this.vCenterStart.x);
                                        this.vTranslate.y = this.vTranslateStart.y + (motionEvent.getY() - this.vCenterStart.y);
                                        float f10 = this.vTranslate.x;
                                        float f11 = this.vTranslate.y;
                                        fitToBounds(true);
                                        boolean z4 = f10 != this.vTranslate.x;
                                        boolean z5 = z4 && abs3 > abs4 && !this.isPanning;
                                        boolean z6 = f11 == this.vTranslate.y && abs4 > 15.0f;
                                        if (!z5 && (!z4 || z6 || this.isPanning)) {
                                            this.isPanning = true;
                                        } else if (i > 0) {
                                            this.maxTouchCount = 0;
                                            this.handler.removeMessages(1);
                                            getParent().requestDisallowInterceptTouchEvent(false);
                                        }
                                        if (!this.panEnabled) {
                                            this.vTranslate.x = this.vTranslateStart.x;
                                            this.vTranslate.y = this.vTranslateStart.y;
                                            getParent().requestDisallowInterceptTouchEvent(false);
                                        }
                                        refreshRequiredTiles(false);
                                    }
                                }
                                z2 = true;
                            }
                            if (z2) {
                                this.handler.removeMessages(1);
                                invalidate();
                                return true;
                            }
                        } else if (action != 5) {
                            if (action != 6) {
                                if (action != 261) {
                                }
                            }
                        }
                        return super.onTouchEvent(motionEvent);
                    }
                    this.handler.removeMessages(1);
                    if (this.isQuickScaling) {
                        this.isQuickScaling = false;
                        if (!this.quickScaleMoved) {
                            doubleTapZoom(this.quickScaleCenter, this.vCenterStart);
                        }
                    }
                    if (this.maxTouchCount <= 0 || (!(z = this.isZooming) && !this.isPanning)) {
                        if (pointerCount == 1) {
                            this.isZooming = false;
                            this.isPanning = false;
                            this.maxTouchCount = 0;
                        }
                        return true;
                    }
                    if (z && pointerCount == 2) {
                        this.isPanning = true;
                        this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
                        if (motionEvent.getActionIndex() == 1) {
                            this.vCenterStart.set(motionEvent.getX(0), motionEvent.getY(0));
                        } else {
                            this.vCenterStart.set(motionEvent.getX(1), motionEvent.getY(1));
                        }
                    }
                    if (pointerCount < 3) {
                        this.isZooming = false;
                    }
                    if (pointerCount < 2) {
                        this.isPanning = false;
                        this.maxTouchCount = 0;
                    }
                    refreshRequiredTiles(true);
                    return true;
                }
                this.anim = null;
                getParent().requestDisallowInterceptTouchEvent(true);
                this.maxTouchCount = Math.max(this.maxTouchCount, pointerCount);
                if (pointerCount >= 2) {
                    if (this.zoomEnabled) {
                        float distance2 = distance(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                        this.scaleStart = this.scale;
                        this.vDistStart = distance2;
                        this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
                        this.vCenterStart.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
                    } else {
                        this.maxTouchCount = 0;
                    }
                    this.handler.removeMessages(1);
                } else if (!this.isQuickScaling) {
                    this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
                    this.vCenterStart.set(motionEvent.getX(), motionEvent.getY());
                    this.handler.sendEmptyMessageDelayed(1, 600);
                }
                return true;
            }
            this.isZooming = false;
            this.isPanning = false;
            this.maxTouchCount = 0;
            return true;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    /* access modifiers changed from: private */
    public void doubleTapZoom(PointF pointF, PointF pointF2) {
        if (!this.panEnabled) {
            PointF pointF3 = this.sRequestedCenter;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = this.sRequestedCenter.y;
            } else {
                pointF.x = (float) (sWidth() / 2);
                pointF.y = (float) (sHeight() / 2);
            }
        }
        float min = Math.min(this.maxScale, this.doubleTapZoomScale);
        float f = this.scale;
        boolean z = ((double) f) <= ((double) min) * 0.9d;
        float f2 = 1.0f;
        if (((double) f) > ((double) minScale()) + 0.01d) {
            if (this.scale > 1.0f) {
                min = minScale();
            } else if (!z) {
                min = minScale();
            }
            f2 = min;
        }
        int i = this.doubleTapZoomStyle;
        if (i == 3) {
            setScaleAndCenter(f2, pointF);
        } else if (i == 2 || !z || !this.panEnabled) {
            new AnimationBuilder(f2, pointF).withInterruptible(false).withDuration((long) this.doubleTapZoomDuration).start();
        } else if (i == 1) {
            new AnimationBuilder(f2, pointF, pointF2).withInterruptible(false).withDuration((long) this.doubleTapZoomDuration).start();
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        LogUtils.d(TAG, "onDraw" + this.uri + " id" + System.identityHashCode(this));
        createPaints();
        if (!(this.sWidth == 0 || this.sHeight == 0 || getWidth() == 0 || getHeight() == 0)) {
            if (this.tileMap == null && this.decoder != null) {
                initialiseBaseLayer(getMaxBitmapDimensions(canvas));
            }
            if (checkReady()) {
                preDraw();
                if (this.anim != null) {
                    long currentTimeMillis = System.currentTimeMillis() - this.anim.time;
                    boolean z = currentTimeMillis > this.anim.duration;
                    long min = Math.min(currentTimeMillis, this.anim.duration);
                    this.scale = ease(this.anim.easing, min, this.anim.scaleStart, this.anim.scaleEnd - this.anim.scaleStart, this.anim.duration);
                    float ease = ease(this.anim.easing, min, this.anim.vFocusStart.x, this.anim.vFocusEnd.x - this.anim.vFocusStart.x, this.anim.duration);
                    float ease2 = ease(this.anim.easing, min, this.anim.vFocusStart.y, this.anim.vFocusEnd.y - this.anim.vFocusStart.y, this.anim.duration);
                    this.vTranslate.x -= sourceToViewX(this.anim.sCenterEnd.x) - ease;
                    this.vTranslate.y -= sourceToViewY(this.anim.sCenterEnd.y) - ease2;
                    fitToBounds(z || this.anim.scaleStart == this.anim.scaleEnd);
                    refreshRequiredTiles(z);
                    if (z) {
                        if (this.anim.listener != null) {
                            try {
                                this.anim.listener.onComplete();
                            } catch (Exception e) {
                                LogUtils.w(TAG, "Error thrown by animation listener", e);
                            }
                        }
                        this.anim = null;
                    }
                    invalidate();
                }
                if (this.tileMap == null || !isBaseLayerReady()) {
                    Bitmap bitmap2 = this.bitmap;
                    if (bitmap2 != null) {
                        float f2 = this.scale;
                        if (this.bitmapIsPreview) {
                            f2 *= ((float) this.sWidth) / ((float) bitmap2.getWidth());
                            f = this.scale * (((float) this.sHeight) / ((float) this.bitmap.getHeight()));
                        } else {
                            f = f2;
                        }
                        if (this.matrix == null) {
                            this.matrix = new Matrix();
                        }
                        this.matrix.reset();
                        this.matrix.postScale(f2, f);
                        this.matrix.postRotate((float) getRequiredRotation());
                        this.matrix.postTranslate(this.vTranslate.x, this.vTranslate.y);
                        if (getRequiredRotation() == 180) {
                            Matrix matrix2 = this.matrix;
                            float f3 = this.scale;
                            matrix2.postTranslate(((float) this.sWidth) * f3, f3 * ((float) this.sHeight));
                        } else if (getRequiredRotation() == 90) {
                            this.matrix.postTranslate(this.scale * ((float) this.sHeight), 0.0f);
                        } else if (getRequiredRotation() == 270) {
                            this.matrix.postTranslate(0.0f, this.scale * ((float) this.sWidth));
                        }
                        if (this.tileBgPaint != null) {
                            if (this.sRect == null) {
                                this.sRect = new RectF();
                            }
                            this.sRect.set(0.0f, 0.0f, (float) this.sWidth, (float) this.sHeight);
                            this.matrix.mapRect(this.sRect);
                            canvas.drawRect(this.sRect, this.tileBgPaint);
                        }
                        canvas.drawBitmap(this.bitmap, this.matrix, this.bitmapPaint);
                        return;
                    }
                    return;
                }
                int min2 = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
                boolean z2 = false;
                for (Map.Entry<Integer, List<Tile>> entry : this.tileMap.entrySet()) {
                    if (entry.getKey().intValue() == min2) {
                        for (Tile tile : entry.getValue()) {
                            if (tile.visible && (tile.loading || tile.bitmap == null)) {
                                z2 = true;
                            }
                        }
                    }
                }
                for (Map.Entry<Integer, List<Tile>> entry2 : this.tileMap.entrySet()) {
                    if (entry2.getKey().intValue() == min2 || z2) {
                        for (Tile tile2 : entry2.getValue()) {
                            sourceToViewRect(tile2.sRect, tile2.vRect);
                            if (!tile2.loading && tile2.bitmap != null) {
                                if (this.tileBgPaint != null) {
                                    canvas.drawRect(tile2.vRect, this.tileBgPaint);
                                }
                                if (this.matrix == null) {
                                    this.matrix = new Matrix();
                                }
                                this.matrix.reset();
                                setMatrixArray(this.srcArray, 0.0f, 0.0f, (float) tile2.bitmap.getWidth(), 0.0f, (float) tile2.bitmap.getWidth(), (float) tile2.bitmap.getHeight(), 0.0f, (float) tile2.bitmap.getHeight());
                                if (getRequiredRotation() == 0) {
                                    setMatrixArray(this.dstArray, (float) tile2.vRect.left, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.bottom);
                                } else if (getRequiredRotation() == 90) {
                                    setMatrixArray(this.dstArray, (float) tile2.vRect.right, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.top);
                                } else if (getRequiredRotation() == 180) {
                                    setMatrixArray(this.dstArray, (float) tile2.vRect.right, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.top);
                                } else if (getRequiredRotation() == 270) {
                                    setMatrixArray(this.dstArray, (float) tile2.vRect.left, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.bottom);
                                }
                                this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
                                canvas.drawBitmap(tile2.bitmap, this.matrix, this.bitmapPaint);
                                if (this.debug) {
                                    canvas.drawRect(tile2.vRect, this.debugPaint);
                                }
                            } else if (tile2.loading && this.debug) {
                                canvas.drawText("LOADING", (float) (tile2.vRect.left + 5), (float) (tile2.vRect.top + 35), this.debugPaint);
                            }
                            if (tile2.visible && this.debug) {
                                canvas.drawText("ISS " + tile2.sampleSize + " RECT " + tile2.sRect.top + "," + tile2.sRect.left + "," + tile2.sRect.bottom + "," + tile2.sRect.right, (float) (tile2.vRect.left + 5), (float) (tile2.vRect.top + 15), this.debugPaint);
                            }
                        }
                    }
                }
                if (this.debug) {
                    canvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.scale)), 5.0f, 15.0f, this.debugPaint);
                    canvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.vTranslate.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.vTranslate.y)), 5.0f, 35.0f, this.debugPaint);
                    PointF center = getCenter();
                    canvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.y)), 5.0f, 55.0f, this.debugPaint);
                    Anim anim2 = this.anim;
                    if (anim2 != null) {
                        PointF sourceToViewCoord = sourceToViewCoord(anim2.sCenterStart);
                        PointF sourceToViewCoord2 = sourceToViewCoord(this.anim.sCenterEndRequested);
                        PointF sourceToViewCoord3 = sourceToViewCoord(this.anim.sCenterEnd);
                        canvas.drawCircle(sourceToViewCoord.x, sourceToViewCoord.y, 10.0f, this.debugPaint);
                        canvas.drawCircle(sourceToViewCoord2.x, sourceToViewCoord2.y, 20.0f, this.debugPaint);
                        canvas.drawCircle(sourceToViewCoord3.x, sourceToViewCoord3.y, 25.0f, this.debugPaint);
                        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), 30.0f, this.debugPaint);
                    }
                }
            }
        }
    }

    private void setMatrixArray(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        fArr[6] = f7;
        fArr[7] = f8;
    }

    private boolean isBaseLayerReady() {
        boolean z = true;
        if (!(this.bitmap == null || this.bitmapIsPreview)) {
            return true;
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map == null) {
            return false;
        }
        for (Map.Entry<Integer, List<Tile>> entry : map.entrySet()) {
            if (entry.getKey().intValue() == this.fullImageSampleSize) {
                for (Tile tile : entry.getValue()) {
                    if (tile.loading || tile.bitmap == null) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    private boolean checkReady() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || isBaseLayerReady());
        if (!this.readySent && z) {
            preDraw();
            this.readySent = true;
            onReady();
            OnImageEventListener onImageEventListener2 = this.onImageEventListener;
            if (onImageEventListener2 != null) {
                onImageEventListener2.onReady();
            }
        }
        return z;
    }

    private boolean checkImageLoaded() {
        boolean isBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && isBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
            OnImageEventListener onImageEventListener2 = this.onImageEventListener;
            if (onImageEventListener2 != null) {
                onImageEventListener2.onImageLoaded(this.sWidth, this.sHeight);
            }
        }
        return isBaseLayerReady;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            Paint paint = new Paint();
            this.bitmapPaint = paint;
            paint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if (this.debugPaint == null && this.debug) {
            Paint paint2 = new Paint();
            this.debugPaint = paint2;
            paint2.setTextSize(18.0f);
            this.debugPaint.setColor(-65281);
            this.debugPaint.setStyle(Paint.Style.STROKE);
        }
    }

    private synchronized void initialiseBaseLayer(Point point) {
        ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        this.satTemp = scaleAndTranslate;
        fitToBounds(true, scaleAndTranslate);
        int calculateInSampleSize = calculateInSampleSize(this.satTemp.scale);
        this.fullImageSampleSize = calculateInSampleSize;
        if (calculateInSampleSize != 1 || this.sRegion != null || sWidth() >= point.x || sHeight() >= point.y) {
            initialiseTileMap(point);
            for (Tile tile : this.tileMap.get(Integer.valueOf(this.fullImageSampleSize))) {
                execute(new TileLoadTask(this, this.decoder, tile));
            }
            refreshRequiredTiles(true);
        } else {
            this.decoder.recycle();
            this.decoder = null;
            execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
        }
    }

    private void refreshRequiredTiles(boolean z) {
        if (!(this.decoder == null || this.tileMap == null)) {
            int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
            for (Map.Entry<Integer, List<Tile>> entry : this.tileMap.entrySet()) {
                for (Tile tile : entry.getValue()) {
                    if (tile.sampleSize < min || (tile.sampleSize > min && tile.sampleSize != this.fullImageSampleSize)) {
                        tile.visible = false;
                        if (tile.bitmap != null) {
                            tile.bitmap.recycle();
                            tile.bitmap = null;
                        }
                    }
                    if (tile.sampleSize == min) {
                        if (tileVisible(tile)) {
                            tile.visible = true;
                            if (!tile.loading && tile.bitmap == null && z) {
                                execute(new TileLoadTask(this, this.decoder, tile));
                            }
                        } else if (tile.sampleSize != this.fullImageSampleSize) {
                            tile.visible = false;
                            if (tile.bitmap != null) {
                                tile.bitmap.recycle();
                                tile.bitmap = null;
                            }
                        }
                    } else if (tile.sampleSize == this.fullImageSampleSize) {
                        tile.visible = true;
                    }
                }
            }
        }
    }

    private boolean tileVisible(Tile tile) {
        return viewToSourceX(0.0f) <= ((float) tile.sRect.right) && ((float) tile.sRect.left) <= viewToSourceX((float) getWidth()) && viewToSourceY(0.0f) <= ((float) tile.sRect.bottom) && ((float) tile.sRect.top) <= viewToSourceY((float) getHeight());
    }

    private void preDraw() {
        Float f;
        if (getWidth() != 0 && getHeight() != 0 && this.sWidth > 0 && this.sHeight > 0) {
            if (!(this.sPendingCenter == null || (f = this.pendingScale) == null)) {
                this.scale = f.floatValue();
                if (this.vTranslate == null) {
                    this.vTranslate = new PointF();
                }
                this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * this.sPendingCenter.x);
                this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * this.sPendingCenter.y);
                this.sPendingCenter = null;
                this.pendingScale = null;
                fitToBounds(true);
                refreshRequiredTiles(true);
            }
            fitToBounds(false);
        }
    }

    private int calculateInSampleSize(float f) {
        int i;
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f *= ((float) this.minimumTileDpi) / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int sWidth2 = (int) (((float) sWidth()) * f);
        int sHeight2 = (int) (((float) sHeight()) * f);
        if (sWidth2 == 0 || sHeight2 == 0) {
            return 32;
        }
        int i2 = 1;
        if (sHeight() > sHeight2 || sWidth() > sWidth2) {
            i = Math.round(((float) sHeight()) / ((float) sHeight2));
            int round = Math.round(((float) sWidth()) / ((float) sWidth2));
            if (i >= round) {
                i = round;
            }
        } else {
            i = 1;
        }
        while (true) {
            int i3 = i2 * 2;
            if (i3 >= i) {
                return i2;
            }
            i2 = i3;
        }
    }

    /* access modifiers changed from: private */
    public void fitToBounds(boolean z, ScaleAndTranslate scaleAndTranslate) {
        float f;
        float f2;
        float f3;
        int i;
        if (this.panLimit == 2 && isReady()) {
            z = false;
        }
        PointF pointF = scaleAndTranslate.vTranslate;
        float limitedScale = limitedScale(scaleAndTranslate.scale);
        float sWidth2 = ((float) sWidth()) * limitedScale;
        float sHeight2 = ((float) sHeight()) * limitedScale;
        if (this.panLimit == 3 && isReady()) {
            pointF.x = Math.max(pointF.x, ((float) (getWidth() / 2)) - sWidth2);
            pointF.y = Math.max(pointF.y, ((float) (getHeight() / 2)) - sHeight2);
        } else if (z) {
            pointF.x = Math.max(pointF.x, ((float) getWidth()) - sWidth2);
            pointF.y = Math.max(pointF.y, ((float) getHeight()) - sHeight2);
        } else {
            pointF.x = Math.max(pointF.x, -sWidth2);
            pointF.y = Math.max(pointF.y, -sHeight2);
        }
        float f4 = 0.5f;
        if (getPaddingLeft() > 0 || getPaddingRight() > 0) {
            f = ((float) getPaddingLeft()) / ((float) (getPaddingLeft() + getPaddingRight()));
        } else {
            f = 0.5f;
        }
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f4 = ((float) getPaddingTop()) / ((float) (getPaddingTop() + getPaddingBottom()));
        }
        if (this.panLimit == 3 && isReady()) {
            f2 = (float) Math.max(0, getWidth() / 2);
            i = Math.max(0, getHeight() / 2);
        } else if (z) {
            f2 = Math.max(0.0f, (((float) getWidth()) - sWidth2) * f);
            f3 = Math.max(0.0f, (((float) getHeight()) - sHeight2) * f4);
            pointF.x = Math.min(pointF.x, f2);
            pointF.y = Math.min(pointF.y, f3);
            scaleAndTranslate.scale = limitedScale;
        } else {
            f2 = (float) Math.max(0, getWidth());
            i = Math.max(0, getHeight());
        }
        f3 = (float) i;
        pointF.x = Math.min(pointF.x, f2);
        pointF.y = Math.min(pointF.y, f3);
        scaleAndTranslate.scale = limitedScale;
    }

    private void fitToBounds(boolean z) {
        boolean z2;
        if (this.vTranslate == null) {
            z2 = true;
            this.vTranslate = new PointF(0.0f, 0.0f);
        } else {
            z2 = false;
        }
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = this.scale;
        this.satTemp.vTranslate.set(this.vTranslate);
        fitToBounds(z, this.satTemp);
        this.scale = this.satTemp.scale;
        this.vTranslate.set(this.satTemp.vTranslate);
        if (z2) {
            this.vTranslate.set(vTranslateForSCenter((float) (sWidth() / 2), (float) (sHeight() / 2), this.scale));
        }
    }

    private void initialiseTileMap(Point point) {
        this.tileMap = new LinkedHashMap();
        int i = this.fullImageSampleSize;
        int i2 = 1;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            int sWidth2 = sWidth() / i3;
            int sHeight2 = sHeight() / i4;
            int i5 = sWidth2 / i;
            int i6 = sHeight2 / i;
            while (true) {
                if (i5 + i3 + i2 > point.x || (((double) i5) > ((double) getWidth()) * 1.25d && i < this.fullImageSampleSize)) {
                    i3++;
                    sWidth2 = sWidth() / i3;
                    i5 = sWidth2 / i;
                }
            }
            while (true) {
                if (i6 + i4 + i2 > point.y || (((double) i6) > ((double) getHeight()) * 1.25d && i < this.fullImageSampleSize)) {
                    i4++;
                    sHeight2 = sHeight() / i4;
                    i6 = sHeight2 / i;
                }
            }
            ArrayList arrayList = new ArrayList(i3 * i4);
            int i7 = 0;
            while (i7 < i3) {
                int i8 = 0;
                while (i8 < i4) {
                    Tile tile = new Tile();
                    tile.sampleSize = i;
                    tile.visible = i == this.fullImageSampleSize;
                    tile.sRect = new Rect(i7 * sWidth2, i8 * sHeight2, i7 == i3 + -1 ? sWidth() : (i7 + 1) * sWidth2, i8 == i4 + -1 ? sHeight() : (i8 + 1) * sHeight2);
                    tile.vRect = new Rect(0, 0, 0, 0);
                    tile.fileSRect = new Rect(tile.sRect);
                    arrayList.add(tile);
                    i8++;
                }
                i7++;
            }
            this.tileMap.put(Integer.valueOf(i), arrayList);
            i2 = 1;
            if (i != 1) {
                i /= 2;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onTilesInited(ImageRegionDecoder imageRegionDecoder, int i, int i2, int i3) {
        int i4;
        int i5 = this.sWidth;
        if (i5 > 0 && (i4 = this.sHeight) > 0 && !(i5 == i && i4 == i2)) {
            reset(false);
            Bitmap bitmap2 = this.bitmap;
            if (bitmap2 != null) {
                if (!this.bitmapIsCached) {
                    bitmap2.recycle();
                }
                this.bitmap = null;
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
        }
        this.decoder = imageRegionDecoder;
        this.sWidth = i;
        this.sHeight = i2;
        this.sOrientation = i3;
        checkReady();
        checkImageLoaded();
        invalidate();
        LogUtils.d(TAG, "onTilesInited");
    }

    /* access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        Bitmap bitmap2;
        checkReady();
        checkImageLoaded();
        if (isBaseLayerReady() && (bitmap2 = this.bitmap) != null) {
            if (!this.bitmapIsCached) {
                bitmap2.recycle();
            }
            this.bitmap = null;
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        invalidate();
    }

    /* access modifiers changed from: private */
    public synchronized void onPreviewLoaded(Bitmap bitmap2) {
        if (this.bitmap == null) {
            if (!this.imageLoadedSent) {
                Rect rect = this.pRegion;
                if (rect != null) {
                    this.bitmap = Bitmap.createBitmap(bitmap2, rect.left, this.pRegion.top, this.pRegion.width(), this.pRegion.height());
                } else {
                    this.bitmap = bitmap2;
                }
                this.bitmapIsPreview = true;
                if (checkReady()) {
                    invalidate();
                }
                return;
            }
        }
        bitmap2.recycle();
    }

    /* access modifiers changed from: private */
    public synchronized void onImageLoaded(Bitmap bitmap2, int i, boolean z) {
        int i2 = this.sWidth;
        if (i2 > 0 && this.sHeight > 0 && !(i2 == bitmap2.getWidth() && this.sHeight == bitmap2.getHeight())) {
            reset(false);
        }
        Bitmap bitmap3 = this.bitmap;
        if (bitmap3 != null && !this.bitmapIsCached) {
            bitmap3.recycle();
        }
        this.bitmapIsPreview = false;
        this.bitmapIsCached = z;
        this.bitmap = bitmap2;
        this.sWidth = bitmap2.getWidth();
        this.sHeight = bitmap2.getHeight();
        this.sOrientation = i;
        boolean checkReady = checkReady();
        boolean checkImageLoaded = checkImageLoaded();
        if (checkReady || checkImageLoaded) {
            invalidate();
            LogUtils.d(TAG, "ready and invalidate");
        }
    }

    /* access modifiers changed from: private */
    public int getExifOrientation(String str) {
        int i;
        if (str.startsWith("content")) {
            try {
                Cursor query = getContext().getContentResolver().query(Uri.parse(str), new String[]{"orientation"}, null, null, null);
                if (query == null) {
                    return 0;
                }
                if (query.moveToFirst()) {
                    i = query.getInt(0);
                    if (!VALID_ORIENTATIONS.contains(Integer.valueOf(i)) || i == -1) {
                        String str2 = TAG;
                        LogUtils.w(str2, "Unsupported orientation: " + i);
                    } else {
                        query.close();
                        return i;
                    }
                }
                i = 0;
                try {
                    query.close();
                } catch (Exception unused) {
                }
                return i;
            } catch (Exception unused2) {
                i = 0;
                LogUtils.w(TAG, "Could not get orientation of image from media store");
                return i;
            }
        } else if (!str.startsWith("file:///") || str.startsWith("file:///android_asset/")) {
            return 0;
        } else {
            try {
                int attributeInt = new ExifInterface(str.substring(7)).getAttributeInt("Orientation", 1);
                if (attributeInt == 1) {
                    return 0;
                }
                if (attributeInt == 0) {
                    return 0;
                }
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 3) {
                    return 180;
                }
                if (attributeInt == 8) {
                    return 270;
                }
                String str3 = TAG;
                LogUtils.w(str3, "Unsupported EXIF orientation: " + attributeInt);
                return 0;
            } catch (Exception unused3) {
                LogUtils.w(TAG, "Could not get EXIF orientation of image");
                return 0;
            }
        }
    }

    private void execute(AsyncTask<Void, Void, ?> asyncTask) {
        if (this.parallelLoadingEnabled && Build.VERSION.SDK_INT >= 11) {
            try {
                AsyncTask.class.getMethod("executeOnExecutor", Executor.class, Object[].class).invoke(asyncTask, (Executor) AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null), null);
                return;
            } catch (Exception e) {
                LogUtils.i(TAG, "Failed to execute AsyncTask on thread pool executor, falling back to single threaded executor", e);
            }
        }
        asyncTask.execute(new Void[0]);
    }

    private void restoreState(ImageViewState imageViewState) {
        if (imageViewState != null && imageViewState.getCenter() != null && VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.orientation = imageViewState.getOrientation();
            this.pendingScale = Float.valueOf(imageViewState.getScale());
            this.sPendingCenter = imageViewState.getCenter();
            invalidate();
        }
    }

    public void setMaxTileSize(int i) {
        this.maxTileWidth = i;
        this.maxTileHeight = i;
    }

    public void setMaxTileSize(int i, int i2) {
        this.maxTileWidth = i;
        this.maxTileHeight = i2;
    }

    private Point getMaxBitmapDimensions(Canvas canvas) {
        int i;
        int i2;
        int i3 = 2048;
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                i2 = ((Integer) Canvas.class.getMethod("getMaximumBitmapWidth", new Class[0]).invoke(canvas, new Object[0])).intValue();
                try {
                    i = ((Integer) Canvas.class.getMethod("getMaximumBitmapHeight", new Class[0]).invoke(canvas, new Object[0])).intValue();
                    i3 = i2;
                } catch (Exception unused) {
                    i3 = i2;
                    i = 2048;
                    return new Point(Math.min(i3, this.maxTileWidth), Math.min(i, this.maxTileHeight));
                }
            } catch (Exception unused2) {
                i2 = 2048;
                i3 = i2;
                i = 2048;
                return new Point(Math.min(i3, this.maxTileWidth), Math.min(i, this.maxTileHeight));
            }
            return new Point(Math.min(i3, this.maxTileWidth), Math.min(i, this.maxTileHeight));
        }
        i = 2048;
        return new Point(Math.min(i3, this.maxTileWidth), Math.min(i, this.maxTileHeight));
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.sHeight;
        }
        return this.sWidth;
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.sWidth;
        }
        return this.sHeight;
    }

    /* access modifiers changed from: private */
    public void fileSRect(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
        } else if (getRequiredRotation() == 90) {
            rect2.set(rect.top, this.sHeight - rect.right, rect.bottom, this.sHeight - rect.left);
        } else if (getRequiredRotation() == 180) {
            rect2.set(this.sWidth - rect.right, this.sHeight - rect.bottom, this.sWidth - rect.left, this.sHeight - rect.top);
        } else {
            rect2.set(this.sWidth - rect.bottom, rect.left, this.sWidth - rect.top, rect.right);
        }
    }

    private int getRequiredRotation() {
        int i = this.orientation;
        return i == -1 ? this.sOrientation : i;
    }

    private float distance(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    public void recycle() {
        String str = TAG;
        LogUtils.d(str, "recycle" + this.uri + " id" + System.identityHashCode(this));
        reset(true);
        this.bitmapPaint = null;
        this.debugPaint = null;
        this.tileBgPaint = null;
        setOnImageEventListener(null);
    }

    private float viewToSourceX(float f) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f - pointF.x) / this.scale;
    }

    private float viewToSourceY(float f) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f - pointF.y) / this.scale;
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF viewToSourceCoord(float f, float f2) {
        return viewToSourceCoord(f, f2, new PointF());
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF viewToSourceCoord(float f, float f2, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f), viewToSourceY(f2));
        return pointF;
    }

    private float sourceToViewX(float f) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f * this.scale) + pointF.x;
    }

    private float sourceToViewY(float f) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f * this.scale) + pointF.y;
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF sourceToViewCoord(float f, float f2) {
        return sourceToViewCoord(f, f2, new PointF());
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF sourceToViewCoord(float f, float f2, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f), sourceToViewY(f2));
        return pointF;
    }

    private Rect sourceToViewRect(Rect rect, Rect rect2) {
        rect2.set((int) sourceToViewX((float) rect.left), (int) sourceToViewY((float) rect.top), (int) sourceToViewX((float) rect.right), (int) sourceToViewY((float) rect.bottom));
        return rect2;
    }

    private PointF vTranslateForSCenter(float f, float f2, float f3) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = f3;
        this.satTemp.vTranslate.set(((float) paddingLeft) - (f * f3), ((float) paddingTop) - (f2 * f3));
        fitToBounds(true, this.satTemp);
        return this.satTemp.vTranslate;
    }

    /* access modifiers changed from: private */
    public PointF limitedSCenter(float f, float f2, float f3, PointF pointF) {
        PointF vTranslateForSCenter = vTranslateForSCenter(f, f2, f3);
        pointF.set((((float) (getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2))) - vTranslateForSCenter.x) / f3, (((float) (getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2))) - vTranslateForSCenter.y) / f3);
        return pointF;
    }

    private float minScale() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i = this.minimumScaleType;
        if (i == 2) {
            return Math.max(((float) (getWidth() - paddingLeft)) / ((float) sWidth()), ((float) (getHeight() - paddingBottom)) / ((float) sHeight()));
        }
        if (i == 3) {
            float f = this.minScale;
            if (f > 0.0f) {
                return f;
            }
        }
        return Math.min(((float) (getWidth() - paddingLeft)) / ((float) sWidth()), ((float) (getHeight() - paddingBottom)) / ((float) sHeight()));
    }

    /* access modifiers changed from: private */
    public float limitedScale(float f) {
        return Math.min(this.maxScale, Math.max(minScale(), f));
    }

    private float ease(int i, long j, float f, float f2, long j2) {
        if (i == 1) {
            return easeOutQuad(j, f, f2, j2);
        }
        if (i == 2) {
            return easeInOutQuad(j, f, f2, j2);
        }
        throw new IllegalStateException("Unexpected easing type: " + i);
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> cls) {
        if (cls != null) {
            this.regionDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.regionDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> cls) {
        if (cls != null) {
            this.bitmapDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.bitmapDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setPanLimit(int i) {
        if (VALID_PAN_LIMITS.contains(Integer.valueOf(i))) {
            this.panLimit = i;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid pan limit: " + i);
    }

    public final void setMinimumScaleType(int i) {
        if (VALID_SCALE_TYPES.contains(Integer.valueOf(i))) {
            this.minimumScaleType = i;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid scale type: " + i);
    }

    public final void setMinimumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i));
    }

    public final void setMaximumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i));
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final void setMaxScale(float f) {
        this.maxScale = f;
    }

    public final float getMinScale() {
        return minScale();
    }

    public final void setMinScale(float f) {
        this.minScale = f;
    }

    public void setMinimumTileDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, (float) i);
        if (isReady()) {
            reset(false);
            invalidate();
        }
    }

    public final PointF getCenter() {
        return viewToSourceCoord((float) (getWidth() / 2), (float) (getHeight() / 2));
    }

    public final float getScale() {
        return this.scale;
    }

    public final void setScaleAndCenter(float f, PointF pointF) {
        this.anim = null;
        this.pendingScale = Float.valueOf(f);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void setScaleAndCenterWithAnim(float f, PointF pointF) {
        new AnimationBuilder(f, pointF).withInterruptible(false).withDuration((long) this.doubleTapZoomDuration).start();
        invalidate();
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(limitedScale(0.0f));
        if (isReady()) {
            this.sPendingCenter = new PointF((float) (sWidth() / 2), (float) (sHeight() / 2));
        } else {
            this.sPendingCenter = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void setOrientation(int i) {
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(i))) {
            this.orientation = i;
            reset(false);
            invalidate();
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i);
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final ImageViewState getState() {
        if (this.vTranslate == null || this.sWidth <= 0 || this.sHeight <= 0) {
            return null;
        }
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    public final void setZoomEnabled(boolean z) {
        this.zoomEnabled = z;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.quickScaleEnabled = z;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
        this.panEnabled = z;
        if (!z && (pointF = this.vTranslate) != null) {
            pointF.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (sWidth() / 2)));
            this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (sHeight() / 2)));
            if (isReady()) {
                refreshRequiredTiles(true);
                invalidate();
            }
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtils.d(TAG, "onAttachedToWindow");
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtils.d(TAG, "onDetachedFromWindow");
        recycle();
    }

    public final void setTileBackgroundColor(int i) {
        if (Color.alpha(i) == 0) {
            this.tileBgPaint = null;
        } else {
            Paint paint = new Paint();
            this.tileBgPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.tileBgPaint.setColor(i);
        }
        invalidate();
    }

    public final void setDoubleTapZoomScale(float f) {
        this.doubleTapZoomScale = f;
    }

    public final void setDoubleTapZoomDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i));
    }

    public final void setDoubleTapZoomStyle(int i) {
        if (VALID_ZOOM_STYLES.contains(Integer.valueOf(i))) {
            this.doubleTapZoomStyle = i;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i);
    }

    public final void setDoubleTapZoomDuration(int i) {
        this.doubleTapZoomDuration = Math.max(0, i);
    }

    public void setParallelLoadingEnabled(boolean z) {
        this.parallelLoadingEnabled = z;
    }

    public final void setDebug(boolean z) {
        this.debug = z;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener2) {
        this.onLongClickListener = onLongClickListener2;
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener2) {
        this.onImageEventListener = onImageEventListener2;
    }

    public AnimationBuilder animateCenter(PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(pointF);
    }

    public AnimationBuilder animateScale(float f) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f);
    }

    public AnimationBuilder animateScaleAndCenter(float f, PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f, pointF);
    }

    private static class TilesInitTask extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private ImageRegionDecoder decoder;
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        private Exception exception;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        public TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
        }

        /* access modifiers changed from: protected */
        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                String str = SubsamplingScaleImageView.TAG;
                LogUtils.d(str, "TilesInitTask" + uri);
                Context context = this.contextRef.get();
                DecoderFactory<? extends ImageRegionDecoder> decoderFactory = this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                ImageRegionDecoder imageRegionDecoder = (ImageRegionDecoder) decoderFactory.make();
                this.decoder = imageRegionDecoder;
                Point init = imageRegionDecoder.init(context, this.source);
                int i = init.x;
                int i2 = init.y;
                String str2 = SubsamplingScaleImageView.TAG;
                LogUtils.d(str2, "bitmap width" + i + " bitmap height" + i2);
                int exifOrientation = subsamplingScaleImageView.getExifOrientation(uri);
                if (subsamplingScaleImageView.sRegion != null) {
                    i = subsamplingScaleImageView.sRegion.width();
                    i2 = subsamplingScaleImageView.sRegion.height();
                }
                return new int[]{i, i2, exifOrientation};
            } catch (Exception e) {
                LogUtils.e(SubsamplingScaleImageView.TAG, "Failed to initialise bitmap decoder", e);
                this.exception = e;
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.onTilesInited(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    private static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageRegionDecoder> decoderRef;
        private Exception exception;
        private final WeakReference<Tile> tileRef;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        public TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.decoderRef = new WeakReference<>(imageRegionDecoder);
            this.tileRef = new WeakReference<>(tile);
            tile.loading = true;
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap decodeRegion;
            try {
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                ImageRegionDecoder imageRegionDecoder = this.decoderRef.get();
                Tile tile = this.tileRef.get();
                if (imageRegionDecoder != null && tile != null && subsamplingScaleImageView != null && imageRegionDecoder.isReady() && tile.visible) {
                    synchronized (subsamplingScaleImageView.decoderLock) {
                        subsamplingScaleImageView.fileSRect(tile.sRect, tile.fileSRect);
                        if (subsamplingScaleImageView.sRegion != null) {
                            tile.fileSRect.offset(subsamplingScaleImageView.sRegion.left, subsamplingScaleImageView.sRegion.top);
                        }
                        String str = SubsamplingScaleImageView.TAG;
                        LogUtils.d(str, "TileLoadTask load" + tile.fileSRect);
                        decodeRegion = imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                    }
                    return decodeRegion;
                } else if (tile == null) {
                    return null;
                } else {
                    tile.loading = false;
                    return null;
                }
            } catch (Exception e) {
                LogUtils.e(SubsamplingScaleImageView.TAG, "Failed to decode tile", e);
                this.exception = e;
                return null;
            } catch (OutOfMemoryError e2) {
                LogUtils.e(SubsamplingScaleImageView.TAG, "Failed to decode tile - OutOfMemoryError", e2);
                this.exception = new RuntimeException(e2);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            Tile tile = this.tileRef.get();
            if (subsamplingScaleImageView != null && tile != null) {
                if (bitmap != null) {
                    tile.bitmap = bitmap;
                    tile.loading = false;
                    subsamplingScaleImageView.onTileLoaded();
                } else if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                    subsamplingScaleImageView.onImageEventListener.onTileLoadError(this.exception);
                }
            }
        }
    }

    private static class BitmapLoadTask extends AsyncTask<Void, Void, Integer> {
        private Bitmap bitmap;
        private final WeakReference<Context> contextRef;
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        public BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
            this.preview = z;
        }

        /* access modifiers changed from: protected */
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                String str = SubsamplingScaleImageView.TAG;
                LogUtils.d(str, "BitmapLoadTask" + uri);
                Context context = this.contextRef.get();
                DecoderFactory<? extends ImageDecoder> decoderFactory = this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                this.bitmap = ((ImageDecoder) decoderFactory.make()).decode(context, this.source);
                return Integer.valueOf(subsamplingScaleImageView.getExifOrientation(uri));
            } catch (Exception e) {
                LogUtils.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap", e);
                this.exception = e;
                return null;
            } catch (OutOfMemoryError e2) {
                LogUtils.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap - OutOfMemoryError", e2);
                this.exception = new RuntimeException(e2);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 == null || num == null) {
                    if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                        if (this.preview) {
                            subsamplingScaleImageView.onImageEventListener.onPreviewLoadError(this.exception);
                        } else {
                            subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                        }
                    }
                } else if (this.preview) {
                    subsamplingScaleImageView.onPreviewLoaded(bitmap2);
                } else {
                    subsamplingScaleImageView.onImageLoaded(bitmap2, num.intValue(), false);
                }
            }
        }
    }

    private static class Tile {
        private Bitmap bitmap;
        private Rect fileSRect;
        private boolean loading;
        private Rect sRect;
        private int sampleSize;
        private Rect vRect;
        private boolean visible;

        private Tile() {
        }
    }

    private static class Anim {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private PointF sCenterEnd;
        private PointF sCenterEndRequested;
        private PointF sCenterStart;
        private float scaleEnd;
        private float scaleStart;
        private long time;
        private PointF vFocusEnd;
        private PointF vFocusStart;

        private Anim() {
            this.duration = 500;
            this.interruptible = true;
            this.easing = 2;
            this.time = System.currentTimeMillis();
        }
    }

    private static class ScaleAndTranslate {
        private float scale;
        private PointF vTranslate;

        private ScaleAndTranslate(float f, PointF pointF) {
            this.scale = f;
            this.vTranslate = pointF;
        }
    }

    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        private final PointF vFocus;

        private AnimationBuilder(PointF pointF) {
            this.duration = 500;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = SubsamplingScaleImageView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f) {
            this.duration = 500;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = SubsamplingScaleImageView.this.getCenter();
            this.vFocus = null;
        }

        private AnimationBuilder(float f, PointF pointF) {
            this.duration = 500;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f, PointF pointF, PointF pointF2) {
            this.duration = 500;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }

        public AnimationBuilder withDuration(long j) {
            this.duration = j;
            return this;
        }

        public AnimationBuilder withInterruptible(boolean z) {
            this.interruptible = z;
            return this;
        }

        public AnimationBuilder withEasing(int i) {
            if (SubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(i))) {
                this.easing = i;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i);
        }

        public AnimationBuilder withOnAnimationEventListener(OnAnimationEventListener onAnimationEventListener) {
            this.listener = onAnimationEventListener;
            return this;
        }

        /* access modifiers changed from: private */
        public AnimationBuilder withPanLimited(boolean z) {
            this.panLimited = z;
            return this;
        }

        public void start() {
            if (!(SubsamplingScaleImageView.this.anim == null || SubsamplingScaleImageView.this.anim.listener == null)) {
                try {
                    SubsamplingScaleImageView.this.anim.listener.onInterruptedByNewAnim();
                } catch (Exception e) {
                    LogUtils.w(SubsamplingScaleImageView.TAG, "Error thrown by animation listener", e);
                }
            }
            int paddingLeft = SubsamplingScaleImageView.this.getPaddingLeft() + (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = SubsamplingScaleImageView.this.getPaddingTop() + (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float limitedScale = SubsamplingScaleImageView.this.limitedScale(this.targetScale);
            PointF limitedSCenter = this.panLimited ? SubsamplingScaleImageView.this.limitedSCenter(this.targetSCenter.x, this.targetSCenter.y, limitedScale, new PointF()) : this.targetSCenter;
            SubsamplingScaleImageView.this.anim = new Anim();
            SubsamplingScaleImageView.this.anim.scaleStart = SubsamplingScaleImageView.this.scale;
            SubsamplingScaleImageView.this.anim.scaleEnd = limitedScale;
            SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            SubsamplingScaleImageView.this.anim.sCenterEndRequested = limitedSCenter;
            SubsamplingScaleImageView.this.anim.sCenterStart = SubsamplingScaleImageView.this.getCenter();
            SubsamplingScaleImageView.this.anim.sCenterEnd = limitedSCenter;
            SubsamplingScaleImageView.this.anim.vFocusStart = SubsamplingScaleImageView.this.sourceToViewCoord(limitedSCenter);
            SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF((float) paddingLeft, (float) paddingTop);
            SubsamplingScaleImageView.this.anim.duration = this.duration;
            SubsamplingScaleImageView.this.anim.interruptible = this.interruptible;
            SubsamplingScaleImageView.this.anim.easing = this.easing;
            SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            SubsamplingScaleImageView.this.anim.listener = this.listener;
            PointF pointF = this.vFocus;
            if (pointF != null) {
                float f = pointF.x - (SubsamplingScaleImageView.this.anim.sCenterStart.x * limitedScale);
                float f2 = this.vFocus.y - (SubsamplingScaleImageView.this.anim.sCenterStart.y * limitedScale);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(limitedScale, new PointF(f, f2));
                SubsamplingScaleImageView.this.fitToBounds(true, scaleAndTranslate);
                SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(this.vFocus.x + (scaleAndTranslate.vTranslate.x - f), this.vFocus.y + (scaleAndTranslate.vTranslate.y - f2));
            }
            SubsamplingScaleImageView.this.invalidate();
        }
    }
}
