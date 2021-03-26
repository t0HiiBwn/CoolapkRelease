package me.zhanghai.android.appiconloader.iconloaderlib;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;

public class BaseIconFactory implements AutoCloseable {
    static final boolean ATLEAST_OREO = (Build.VERSION.SDK_INT >= 26);
    static final boolean ATLEAST_P;
    private static final int DEFAULT_WRAPPER_BACKGROUND = -1;
    private static final float ICON_BADGE_SCALE = 0.444f;
    private static final String TAG = "BaseIconFactory";
    private final Canvas mCanvas;
    private final ColorExtractor mColorExtractor;
    protected final Context mContext;
    private boolean mDisableColorExtractor;
    protected final int mFillResIconDpi;
    protected final int mIconBitmapSize;
    private IconNormalizer mNormalizer;
    private final Rect mOldBounds;
    private final PackageManager mPm;
    private ShadowGenerator mShadowGenerator;
    private final boolean mShapeDetection;
    private int mWrapperBackgroundColor;
    private Drawable mWrapperIcon;

    public static int getBadgeSizeForIconSize(int i) {
        return (int) (((float) i) * 0.444f);
    }

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 28) {
            z = false;
        }
        ATLEAST_P = z;
    }

    protected BaseIconFactory(Context context, int i, int i2, boolean z) {
        this.mOldBounds = new Rect();
        this.mWrapperBackgroundColor = -1;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mShapeDetection = z;
        this.mFillResIconDpi = i;
        this.mIconBitmapSize = i2;
        this.mPm = applicationContext.getPackageManager();
        this.mColorExtractor = new ColorExtractor();
        Canvas canvas = new Canvas();
        this.mCanvas = canvas;
        canvas.setDrawFilter(new PaintFlagsDrawFilter(4, 2));
        clear();
    }

    protected BaseIconFactory(Context context, int i, int i2) {
        this(context, i, i2, false);
    }

    protected void clear() {
        this.mWrapperBackgroundColor = -1;
        this.mDisableColorExtractor = false;
    }

    public ShadowGenerator getShadowGenerator() {
        if (this.mShadowGenerator == null) {
            this.mShadowGenerator = new ShadowGenerator(this.mIconBitmapSize);
        }
        return this.mShadowGenerator;
    }

    public IconNormalizer getNormalizer() {
        if (this.mNormalizer == null) {
            this.mNormalizer = new IconNormalizer(this.mContext, this.mIconBitmapSize, this.mShapeDetection);
        }
        return this.mNormalizer;
    }

    public BitmapInfo createIconBitmap(Intent.ShortcutIconResource shortcutIconResource) {
        try {
            Resources resourcesForApplication = this.mPm.getResourcesForApplication(shortcutIconResource.packageName);
            if (resourcesForApplication != null) {
                return createBadgedIconBitmap(resourcesForApplication.getDrawableForDensity(resourcesForApplication.getIdentifier(shortcutIconResource.resourceName, null, null), this.mFillResIconDpi), Process.myUserHandle(), false);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public BitmapInfo createIconBitmap(Bitmap bitmap) {
        if (!(this.mIconBitmapSize == bitmap.getWidth() && this.mIconBitmapSize == bitmap.getHeight())) {
            bitmap = createIconBitmap(new BitmapDrawable(this.mContext.getResources(), bitmap), 1.0f);
        }
        return BitmapInfo.fromBitmap(bitmap, this.mDisableColorExtractor ? null : this.mColorExtractor);
    }

    public BitmapInfo createBadgedIconBitmap(Drawable drawable, UserHandle userHandle, boolean z) {
        return createBadgedIconBitmap(drawable, userHandle, z, false, (float[]) null);
    }

    public BitmapInfo createBadgedIconBitmap(Drawable drawable, UserHandle userHandle, int i) {
        return createBadgedIconBitmap(drawable, userHandle, i, false);
    }

    public BitmapInfo createBadgedIconBitmap(Drawable drawable, UserHandle userHandle, int i, boolean z) {
        return createBadgedIconBitmap(drawable, userHandle, i, z, (float[]) null);
    }

    public BitmapInfo createBadgedIconBitmap(Drawable drawable, UserHandle userHandle, int i, boolean z, float[] fArr) {
        return createBadgedIconBitmap(drawable, userHandle, ATLEAST_P || (ATLEAST_OREO && i >= 26), z, fArr);
    }

    public Bitmap createScaledBitmapWithoutShadow(Drawable drawable, int i) {
        return createScaledBitmapWithoutShadow(drawable, ATLEAST_P || (ATLEAST_OREO && i >= 26));
    }

    public BitmapInfo createBadgedIconBitmap(Drawable drawable, UserHandle userHandle, boolean z, boolean z2, float[] fArr) {
        if (fArr == null) {
            fArr = new float[1];
        }
        ColorExtractor colorExtractor = null;
        Drawable normalizeAndWrapToAdaptiveIcon = normalizeAndWrapToAdaptiveIcon(drawable, z, null, fArr);
        Bitmap createIconBitmap = createIconBitmap(normalizeAndWrapToAdaptiveIcon, fArr[0]);
        if (ATLEAST_OREO && (normalizeAndWrapToAdaptiveIcon instanceof AdaptiveIconDrawable)) {
            this.mCanvas.setBitmap(createIconBitmap);
            getShadowGenerator().recreateIcon(Bitmap.createBitmap(createIconBitmap), this.mCanvas);
            this.mCanvas.setBitmap(null);
        }
        if (z2) {
            badgeWithDrawable(createIconBitmap, this.mContext.getDrawable(R.drawable.ic_instant_app_badge));
        }
        if (userHandle != null) {
            Drawable userBadgedIcon = this.mPm.getUserBadgedIcon(new FixedSizeBitmapDrawable(createIconBitmap), userHandle);
            if (userBadgedIcon instanceof BitmapDrawable) {
                createIconBitmap = ((BitmapDrawable) userBadgedIcon).getBitmap();
            } else {
                createIconBitmap = createIconBitmap(userBadgedIcon, 1.0f);
            }
        }
        if (!this.mDisableColorExtractor) {
            colorExtractor = this.mColorExtractor;
        }
        return BitmapInfo.fromBitmap(createIconBitmap, colorExtractor);
    }

    public Bitmap createScaledBitmapWithoutShadow(Drawable drawable, boolean z) {
        RectF rectF = new RectF();
        float[] fArr = new float[1];
        return createIconBitmap(normalizeAndWrapToAdaptiveIcon(drawable, z, rectF, fArr), Math.min(fArr[0], ShadowGenerator.getScaleForBounds(rectF)));
    }

    public void setWrapperBackgroundColor(int i) {
        if (Color.alpha(i) < 255) {
            i = -1;
        }
        this.mWrapperBackgroundColor = i;
    }

    public void disableColorExtraction() {
        this.mDisableColorExtractor = true;
    }

    private Drawable normalizeAndWrapToAdaptiveIcon(Drawable drawable, boolean z, RectF rectF, float[] fArr) {
        float f;
        if (drawable == null) {
            return null;
        }
        if (!z || !ATLEAST_OREO) {
            f = getNormalizer().getScale(drawable, rectF, null, null);
        } else {
            if (this.mWrapperIcon == null) {
                this.mWrapperIcon = this.mContext.getDrawable(R.drawable.adaptive_icon_drawable_wrapper).mutate();
            }
            AdaptiveIconDrawable adaptiveIconDrawable = (AdaptiveIconDrawable) this.mWrapperIcon;
            adaptiveIconDrawable.setBounds(0, 0, 1, 1);
            boolean[] zArr = new boolean[1];
            f = getNormalizer().getScale(drawable, rectF, adaptiveIconDrawable.getIconMask(), zArr);
            if (!(drawable instanceof AdaptiveIconDrawable) && !zArr[0]) {
                FixedScaleDrawable fixedScaleDrawable = (FixedScaleDrawable) adaptiveIconDrawable.getForeground();
                fixedScaleDrawable.setDrawable(drawable);
                fixedScaleDrawable.setScale(f);
                f = getNormalizer().getScale(adaptiveIconDrawable, rectF, null, null);
                ((ColorDrawable) adaptiveIconDrawable.getBackground()).setColor(this.mWrapperBackgroundColor);
                drawable = adaptiveIconDrawable;
            }
        }
        fArr[0] = f;
        return drawable;
    }

    public void badgeWithDrawable(Bitmap bitmap, Drawable drawable) {
        this.mCanvas.setBitmap(bitmap);
        badgeWithDrawable(this.mCanvas, drawable);
        this.mCanvas.setBitmap(null);
    }

    public void badgeWithDrawable(Canvas canvas, Drawable drawable) {
        int badgeSizeForIconSize = getBadgeSizeForIconSize(this.mIconBitmapSize);
        int i = this.mIconBitmapSize;
        drawable.setBounds(i - badgeSizeForIconSize, i - badgeSizeForIconSize, i, i);
        drawable.draw(canvas);
    }

    private Bitmap createIconBitmap(Drawable drawable, float f) {
        return createIconBitmap(drawable, f, this.mIconBitmapSize);
    }

    public Bitmap createIconBitmap(Drawable drawable, float f, int i) {
        int i2;
        int i3;
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        if (drawable == null) {
            return createBitmap;
        }
        this.mCanvas.setBitmap(createBitmap);
        this.mOldBounds.set(drawable.getBounds());
        if (!ATLEAST_OREO || !(drawable instanceof AdaptiveIconDrawable)) {
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (createBitmap != null && bitmap.getDensity() == 0) {
                    bitmapDrawable.setTargetDensity(this.mContext.getResources().getDisplayMetrics());
                }
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float f2 = ((float) intrinsicWidth) / ((float) intrinsicHeight);
                if (intrinsicWidth > intrinsicHeight) {
                    i2 = (int) (((float) i) / f2);
                    i3 = i;
                } else if (intrinsicHeight > intrinsicWidth) {
                    i3 = (int) (((float) i) * f2);
                    i2 = i;
                }
                int i4 = (i - i3) / 2;
                int i5 = (i - i2) / 2;
                drawable.setBounds(i4, i5, i3 + i4, i2 + i5);
                this.mCanvas.save();
                float f3 = (float) (i / 2);
                this.mCanvas.scale(f, f, f3, f3);
                drawable.draw(this.mCanvas);
                this.mCanvas.restore();
            }
            i3 = i;
            i2 = i3;
            int i4 = (i - i3) / 2;
            int i5 = (i - i2) / 2;
            drawable.setBounds(i4, i5, i3 + i4, i2 + i5);
            this.mCanvas.save();
            float f3 = (float) (i / 2);
            this.mCanvas.scale(f, f, f3, f3);
            drawable.draw(this.mCanvas);
            this.mCanvas.restore();
        } else {
            float f4 = (float) i;
            int max = Math.max((int) Math.ceil((double) (0.010416667f * f4)), Math.round((f4 * (1.0f - f)) / 2.0f));
            int i6 = i - max;
            drawable.setBounds(max, max, i6, i6);
            drawable.draw(this.mCanvas);
        }
        drawable.setBounds(this.mOldBounds);
        this.mCanvas.setBitmap(null);
        return createBitmap;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        clear();
    }

    public BitmapInfo makeDefaultIcon(UserHandle userHandle) {
        return createBadgedIconBitmap(getFullResDefaultActivityIcon(this.mFillResIconDpi), userHandle, Build.VERSION.SDK_INT);
    }

    public static Drawable getFullResDefaultActivityIcon(int i) {
        return Resources.getSystem().getDrawableForDensity(Build.VERSION.SDK_INT >= 26 ? 17301651 : 17629184, i);
    }

    private static class FixedSizeBitmapDrawable extends BitmapDrawable {
        public FixedSizeBitmapDrawable(Bitmap bitmap) {
            super((Resources) null, bitmap);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return getBitmap().getWidth();
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return getBitmap().getWidth();
        }
    }
}
