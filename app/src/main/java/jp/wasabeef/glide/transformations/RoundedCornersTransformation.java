package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class RoundedCornersTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.RoundedCornersTransformation.1";
    private static final int VERSION = 1;
    private final CornerType cornerType;
    private final int diameter;
    private final int margin;
    private final int radius;

    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public RoundedCornersTransformation(int i, int i2) {
        this(i, i2, CornerType.ALL);
    }

    public RoundedCornersTransformation(int i, int i2, CornerType cornerType2) {
        this.radius = i;
        this.diameter = i * 2;
        this.margin = i2;
        this.cornerType = cornerType2;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    protected Bitmap transform(Context context, BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmap2 = bitmapPool.get(width, height, Bitmap.Config.ARGB_8888);
        bitmap2.setHasAlpha(true);
        setCanvasBitmapDensity(bitmap, bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        drawRoundRect(canvas, paint, (float) width, (float) height);
        return bitmap2;
    }

    private void drawRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        float f3 = f - ((float) i);
        float f4 = f2 - ((float) i);
        switch (AnonymousClass1.$SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[this.cornerType.ordinal()]) {
            case 1:
                int i2 = this.margin;
                RectF rectF = new RectF((float) i2, (float) i2, f3, f4);
                int i3 = this.radius;
                canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
                return;
            case 2:
                drawTopLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 3:
                drawTopRightRoundRect(canvas, paint, f3, f4);
                return;
            case 4:
                drawBottomLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 5:
                drawBottomRightRoundRect(canvas, paint, f3, f4);
                return;
            case 6:
                drawTopRoundRect(canvas, paint, f3, f4);
                return;
            case 7:
                drawBottomRoundRect(canvas, paint, f3, f4);
                return;
            case 8:
                drawLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 9:
                drawRightRoundRect(canvas, paint, f3, f4);
                return;
            case 10:
                drawOtherTopLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 11:
                drawOtherTopRightRoundRect(canvas, paint, f3, f4);
                return;
            case 12:
                drawOtherBottomLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 13:
                drawOtherBottomRightRoundRect(canvas, paint, f3, f4);
                return;
            case 14:
                drawDiagonalFromTopLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 15:
                drawDiagonalFromTopRightRoundRect(canvas, paint, f3, f4);
                return;
            default:
                int i4 = this.margin;
                RectF rectF2 = new RectF((float) i4, (float) i4, f3, f4);
                int i5 = this.radius;
                canvas.drawRoundRect(rectF2, (float) i5, (float) i5, paint);
                return;
        }
    }

    /* renamed from: jp.wasabeef.glide.transformations.RoundedCornersTransformation$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType;

        static {
            int[] iArr = new int[CornerType.values().length];
            $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType = iArr;
            try {
                iArr[CornerType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    private void drawTopLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        int i2 = this.diameter;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + i2), (float) (i + i2));
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        int i5 = this.radius;
        canvas.drawRect(new RectF((float) i4, (float) (i4 + i5), (float) (i4 + i5), f2), paint);
        int i6 = this.margin;
        canvas.drawRect(new RectF((float) (this.radius + i6), (float) i6, f, f2), paint);
    }

    private void drawTopRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.diameter;
        int i2 = this.margin;
        RectF rectF = new RectF(f - ((float) i), (float) i2, f, (float) (i2 + i));
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        canvas.drawRect(new RectF((float) i4, (float) i4, f - ((float) this.radius), f2), paint);
        int i5 = this.radius;
        canvas.drawRect(new RectF(f - ((float) i5), (float) (this.margin + i5), f, f2), paint);
    }

    private void drawBottomLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        int i2 = this.diameter;
        RectF rectF = new RectF((float) i, f2 - ((float) i2), (float) (i + i2), f2);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        canvas.drawRect(new RectF((float) i4, (float) i4, (float) (i4 + this.diameter), f2 - ((float) this.radius)), paint);
        int i5 = this.margin;
        canvas.drawRect(new RectF((float) (this.radius + i5), (float) i5, f, f2), paint);
    }

    private void drawBottomRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.diameter;
        RectF rectF = new RectF(f - ((float) i), f2 - ((float) i), f, f2);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF((float) i3, (float) i3, f - ((float) this.radius), f2), paint);
        int i4 = this.radius;
        canvas.drawRect(new RectF(f - ((float) i4), (float) this.margin, f, f2 - ((float) i4)), paint);
    }

    private void drawTopRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        RectF rectF = new RectF((float) i, (float) i, f, (float) (i + this.diameter));
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF((float) i3, (float) (i3 + this.radius), f, f2), paint);
    }

    private void drawBottomRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF((float) this.margin, f2 - ((float) this.diameter), f, f2);
        int i = this.radius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        int i2 = this.margin;
        canvas.drawRect(new RectF((float) i2, (float) i2, f, f2 - ((float) this.radius)), paint);
    }

    private void drawLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + this.diameter), f2);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF((float) (this.radius + i3), (float) i3, f, f2), paint);
    }

    private void drawRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(f - ((float) this.diameter), (float) this.margin, f, f2);
        int i = this.radius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        int i2 = this.margin;
        canvas.drawRect(new RectF((float) i2, (float) i2, f - ((float) this.radius), f2), paint);
    }

    private void drawOtherTopLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF((float) this.margin, f2 - ((float) this.diameter), f, f2);
        int i = this.radius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        RectF rectF2 = new RectF(f - ((float) this.diameter), (float) this.margin, f, f2);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i2, (float) i2, paint);
        int i3 = this.margin;
        int i4 = this.radius;
        canvas.drawRect(new RectF((float) i3, (float) i3, f - ((float) i4), f2 - ((float) i4)), paint);
    }

    private void drawOtherTopRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + this.diameter), f2);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        RectF rectF2 = new RectF((float) this.margin, f2 - ((float) this.diameter), f, f2);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        int i5 = this.radius;
        canvas.drawRect(new RectF((float) (i4 + i5), (float) i4, f, f2 - ((float) i5)), paint);
    }

    private void drawOtherBottomLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        RectF rectF = new RectF((float) i, (float) i, f, (float) (i + this.diameter));
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        RectF rectF2 = new RectF(f - ((float) this.diameter), (float) this.margin, f, f2);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        int i5 = this.radius;
        canvas.drawRect(new RectF((float) i4, (float) (i4 + i5), f - ((float) i5), f2), paint);
    }

    private void drawOtherBottomRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        RectF rectF = new RectF((float) i, (float) i, f, (float) (i + this.diameter));
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.margin;
        RectF rectF2 = new RectF((float) i3, (float) i3, (float) (i3 + this.diameter), f2);
        int i4 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i4, (float) i4, paint);
        int i5 = this.margin;
        int i6 = this.radius;
        canvas.drawRect(new RectF((float) (i5 + i6), (float) (i5 + i6), f, f2), paint);
    }

    private void drawDiagonalFromTopLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        int i2 = this.diameter;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + i2), (float) (i + i2));
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.diameter;
        RectF rectF2 = new RectF(f - ((float) i4), f2 - ((float) i4), f, f2);
        int i5 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i5, (float) i5, paint);
        int i6 = this.margin;
        int i7 = this.radius;
        canvas.drawRect(new RectF((float) i6, (float) (i6 + i7), f - ((float) i7), f2), paint);
        int i8 = this.margin;
        int i9 = this.radius;
        canvas.drawRect(new RectF((float) (i8 + i9), (float) i8, f, f2 - ((float) i9)), paint);
    }

    private void drawDiagonalFromTopRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.diameter;
        int i2 = this.margin;
        RectF rectF = new RectF(f - ((float) i), (float) i2, f, (float) (i2 + i));
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        int i5 = this.diameter;
        RectF rectF2 = new RectF((float) i4, f2 - ((float) i5), (float) (i4 + i5), f2);
        int i6 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i6, (float) i6, paint);
        int i7 = this.margin;
        int i8 = this.radius;
        canvas.drawRect(new RectF((float) i7, (float) i7, f - ((float) i8), f2 - ((float) i8)), paint);
        int i9 = this.margin;
        int i10 = this.radius;
        canvas.drawRect(new RectF((float) (i9 + i10), (float) (i9 + i10), f, f2), paint);
    }

    public String toString() {
        return "RoundedTransformation(radius=" + this.radius + ", margin=" + this.margin + ", diameter=" + this.diameter + ", cornerType=" + this.cornerType.name() + ")";
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof RoundedCornersTransformation) {
            RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) obj;
            if (roundedCornersTransformation.radius == this.radius && roundedCornersTransformation.diameter == this.diameter && roundedCornersTransformation.margin == this.margin && roundedCornersTransformation.cornerType == this.cornerType) {
                return true;
            }
        }
        return false;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return 425235636 + (this.radius * 10000) + (this.diameter * 1000) + (this.margin * 100) + (this.cornerType.ordinal() * 10);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.RoundedCornersTransformation.1" + this.radius + this.diameter + this.margin + this.cornerType).getBytes(CHARSET));
    }
}
