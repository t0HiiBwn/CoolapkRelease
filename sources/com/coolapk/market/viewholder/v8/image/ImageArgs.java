package com.coolapk.market.viewholder.v8.image;

import android.net.Uri;
import com.coolapk.market.manager.AppPictureSizeManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u0000 ;2\u00020\u0001:\u0001;BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003JO\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010(\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001e\u0010*\u001a\u00020\u00032\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030,j\u0002`-J\u000e\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u000bJ\t\u00100\u001a\u00020\u000bHÖ\u0001J\u0006\u00101\u001a\u00020\u001fJ\b\u00102\u001a\u00020\u001fH\u0002J\u0006\u00103\u001a\u00020\u001fJ\u001a\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00052\b\b\u0002\u00107\u001a\u00020\u0005J\u000e\u00108\u001a\u0002052\u0006\u0010/\u001a\u00020\u000bJ8\u00109\u001a\u0002052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bJ\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0017¨\u0006<"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/ImageArgs;", "", "inSource", "", "inRatio", "", "outWidth", "outHeight", "outOffsetX", "outOffsetY", "outFlags", "", "(Ljava/lang/String;FFFFFI)V", "getInRatio", "()F", "getInSource", "()Ljava/lang/String;", "getOutFlags", "()I", "setOutFlags", "(I)V", "getOutHeight", "setOutHeight", "(F)V", "getOutOffsetX", "setOutOffsetX", "getOutOffsetY", "setOutOffsetY", "getOutWidth", "setOutWidth", "canBeShow", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "getSuitableUrl", "transformer", "Lkotlin/Function1;", "Lcom/coolapk/market/viewholder/v8/image/ThumbUrlProvider;", "hasFlag", "flag", "hashCode", "isGifUrl", "isSuitForSmallSize", "isVertical", "offset", "", "x", "y", "setFlag", "setResult", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BinderHelper.kt */
public final class ImageArgs {
    public static final Companion Companion = new Companion(null);
    public static final int FLAG_CLIP_ALL = 15;
    public static final int FLAG_CLIP_BOTTOM = 12;
    public static final int FLAG_CLIP_LEFT = 5;
    public static final int FLAG_CLIP_LEFT_BOTTOM = 4;
    public static final int FLAG_CLIP_LEFT_TOP = 1;
    public static final int FLAG_CLIP_NONE = 0;
    public static final int FLAG_CLIP_RIGHT = 10;
    public static final int FLAG_CLIP_RIGHT_BOTTOM = 8;
    public static final int FLAG_CLIP_RIGHT_TOP = 2;
    public static final int FLAG_CLIP_TOP = 3;
    private static final Regex PicDataPattern = new Regex(".+/\\w+/(\\d{4})/(\\d{4})/.+");
    private final float inRatio;
    private final String inSource;
    private int outFlags;
    private float outHeight;
    private float outOffsetX;
    private float outOffsetY;
    private float outWidth;

    public static /* synthetic */ ImageArgs copy$default(ImageArgs imageArgs, String str, float f, float f2, float f3, float f4, float f5, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = imageArgs.inSource;
        }
        if ((i2 & 2) != 0) {
            f = imageArgs.inRatio;
        }
        if ((i2 & 4) != 0) {
            f2 = imageArgs.outWidth;
        }
        if ((i2 & 8) != 0) {
            f3 = imageArgs.outHeight;
        }
        if ((i2 & 16) != 0) {
            f4 = imageArgs.outOffsetX;
        }
        if ((i2 & 32) != 0) {
            f5 = imageArgs.outOffsetY;
        }
        if ((i2 & 64) != 0) {
            i = imageArgs.outFlags;
        }
        return imageArgs.copy(str, f, f2, f3, f4, f5, i);
    }

    public final String component1() {
        return this.inSource;
    }

    public final float component2() {
        return this.inRatio;
    }

    public final float component3() {
        return this.outWidth;
    }

    public final float component4() {
        return this.outHeight;
    }

    public final float component5() {
        return this.outOffsetX;
    }

    public final float component6() {
        return this.outOffsetY;
    }

    public final int component7() {
        return this.outFlags;
    }

    public final ImageArgs copy(String str, float f, float f2, float f3, float f4, float f5, int i) {
        Intrinsics.checkNotNullParameter(str, "inSource");
        return new ImageArgs(str, f, f2, f3, f4, f5, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageArgs)) {
            return false;
        }
        ImageArgs imageArgs = (ImageArgs) obj;
        return Intrinsics.areEqual(this.inSource, imageArgs.inSource) && Float.compare(this.inRatio, imageArgs.inRatio) == 0 && Float.compare(this.outWidth, imageArgs.outWidth) == 0 && Float.compare(this.outHeight, imageArgs.outHeight) == 0 && Float.compare(this.outOffsetX, imageArgs.outOffsetX) == 0 && Float.compare(this.outOffsetY, imageArgs.outOffsetY) == 0 && this.outFlags == imageArgs.outFlags;
    }

    public int hashCode() {
        String str = this.inSource;
        return ((((((((((((str != null ? str.hashCode() : 0) * 31) + Float.floatToIntBits(this.inRatio)) * 31) + Float.floatToIntBits(this.outWidth)) * 31) + Float.floatToIntBits(this.outHeight)) * 31) + Float.floatToIntBits(this.outOffsetX)) * 31) + Float.floatToIntBits(this.outOffsetY)) * 31) + this.outFlags;
    }

    public String toString() {
        return "ImageArgs(inSource=" + this.inSource + ", inRatio=" + this.inRatio + ", outWidth=" + this.outWidth + ", outHeight=" + this.outHeight + ", outOffsetX=" + this.outOffsetX + ", outOffsetY=" + this.outOffsetY + ", outFlags=" + this.outFlags + ")";
    }

    public ImageArgs(String str, float f, float f2, float f3, float f4, float f5, int i) {
        Intrinsics.checkNotNullParameter(str, "inSource");
        this.inSource = str;
        this.inRatio = f;
        this.outWidth = f2;
        this.outHeight = f3;
        this.outOffsetX = f4;
        this.outOffsetY = f5;
        this.outFlags = i;
    }

    public final float getInRatio() {
        return this.inRatio;
    }

    public final String getInSource() {
        return this.inSource;
    }

    public final float getOutWidth() {
        return this.outWidth;
    }

    public final void setOutWidth(float f) {
        this.outWidth = f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageArgs(String str, float f, float f2, float f3, float f4, float f5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f, (i2 & 4) != 0 ? 0.0f : f2, (i2 & 8) != 0 ? 0.0f : f3, (i2 & 16) != 0 ? 0.0f : f4, (i2 & 32) != 0 ? 0.0f : f5, (i2 & 64) != 0 ? 0 : i);
    }

    public final int getOutFlags() {
        return this.outFlags;
    }

    public final float getOutHeight() {
        return this.outHeight;
    }

    public final float getOutOffsetX() {
        return this.outOffsetX;
    }

    public final float getOutOffsetY() {
        return this.outOffsetY;
    }

    public final void setOutFlags(int i) {
        this.outFlags = i;
    }

    public final void setOutHeight(float f) {
        this.outHeight = f;
    }

    public final void setOutOffsetX(float f) {
        this.outOffsetX = f;
    }

    public final void setOutOffsetY(float f) {
        this.outOffsetY = f;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0011J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/ImageArgs$Companion;", "", "()V", "FLAG_CLIP_ALL", "", "FLAG_CLIP_BOTTOM", "FLAG_CLIP_LEFT", "FLAG_CLIP_LEFT_BOTTOM", "FLAG_CLIP_LEFT_TOP", "FLAG_CLIP_NONE", "FLAG_CLIP_RIGHT", "FLAG_CLIP_RIGHT_BOTTOM", "FLAG_CLIP_RIGHT_TOP", "FLAG_CLIP_TOP", "PicDataPattern", "Lkotlin/text/Regex;", "extraSmallSizeProvider", "", "source", "isCoolApkHostImage", "", "isGifPicture", "url", "isLongPicture", "isSupportS2X", "middleSizeProvider", "noneProvider", "s2xSizeCompatProvider", "s2xSizeProvider", "smallSizeProvider", "smartThumbnailProvider", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BinderHelper.kt */
    public static final class Companion {
        public final String noneProvider(String str) {
            Intrinsics.checkNotNullParameter(str, "source");
            return str;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String middleSizeProvider(String str) {
            Intrinsics.checkNotNullParameter(str, "source");
            if (str.length() == 0) {
                return str;
            }
            return str + ".m.jpg";
        }

        public final String extraSmallSizeProvider(String str) {
            Intrinsics.checkNotNullParameter(str, "source");
            if (str.length() == 0) {
                return str;
            }
            return str + ".xs.jpg";
        }

        public final String smallSizeProvider(String str) {
            Intrinsics.checkNotNullParameter(str, "source");
            if (str.length() == 0) {
                return str;
            }
            return str + ".s.jpg";
        }

        public final String s2xSizeProvider(String str) {
            Intrinsics.checkNotNullParameter(str, "source");
            if (str.length() == 0) {
                return str;
            }
            return str + ".s2x.jpg";
        }

        public final String s2xSizeCompatProvider(String str) {
            Intrinsics.checkNotNullParameter(str, "source");
            Companion companion = this;
            return companion.isSupportS2X(str) ? companion.s2xSizeProvider(str) : companion.smallSizeProvider(str);
        }

        public final String smartThumbnailProvider(String str) {
            float f;
            Intrinsics.checkNotNullParameter(str, "source");
            boolean z = true;
            if (str.length() == 0) {
                return str;
            }
            AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(str);
            if (size != null) {
                Intrinsics.checkNotNullExpressionValue(size, "it");
                f = ((float) size.getWidth()) / ((float) size.getHeight());
            } else {
                f = 1.0f;
            }
            if (((double) f) > 0.333d && f <= ((float) 3)) {
                z = false;
            }
            if (z) {
                return extraSmallSizeProvider(str);
            }
            return smallSizeProvider(str);
        }

        public final boolean isLongPicture(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(str);
            return size != null && ((float) size.getWidth()) / ((float) size.getHeight()) < 0.45f;
        }

        public final boolean isCoolApkHostImage(String str) {
            Intrinsics.checkNotNullParameter(str, "source");
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            return Intrinsics.areEqual(parse.getHost(), "image.coolapk.com");
        }

        public final boolean isGifPicture(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return StringsKt.endsWith$default(str, ".gif", false, 2, null) || StringsKt.contains$default(str, ".gif.", false, 2, null);
        }

        private final boolean isSupportS2X(String str) {
            MatchResult matchEntire = ImageArgs.PicDataPattern.matchEntire(str);
            List<String> groupValues = matchEntire != null ? matchEntire.getGroupValues() : null;
            if (groupValues == null) {
                return false;
            }
            if (Integer.parseInt(groupValues.get(1) + groupValues.get(2)) >= 20180105) {
                return true;
            }
            return false;
        }
    }

    public static /* synthetic */ void offset$default(ImageArgs imageArgs, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        imageArgs.offset(f, f2);
    }

    public final void offset(float f, float f2) {
        this.outOffsetX += f;
        this.outOffsetY += f2;
    }

    public final void setFlag(int i) {
        this.outFlags = i;
    }

    public static /* synthetic */ void setResult$default(ImageArgs imageArgs, float f, float f2, float f3, float f4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 16) != 0) {
            i = 0;
        }
        imageArgs.setResult(f, f2, f3, f4, i);
    }

    public final void setResult(float f, float f2, float f3, float f4, int i) {
        this.outWidth = f;
        this.outHeight = f2;
        this.outOffsetX = f3;
        this.outOffsetY = f4;
        this.outFlags = i;
    }

    private final boolean isSuitForSmallSize() {
        float f = this.outWidth / this.outHeight;
        if (Math.abs(f - this.inRatio) >= Math.abs(f - ((float) 1))) {
            float f2 = (float) 640;
            if (this.outWidth < f2 && this.outHeight < f2) {
                return true;
            }
        }
        return false;
    }

    public final String getSuitableUrl(Function1<? super String, String> function1) {
        Intrinsics.checkNotNullParameter(function1, "transformer");
        if (isSuitForSmallSize()) {
            return Companion.extraSmallSizeProvider(this.inSource);
        }
        return function1.invoke(this.inSource);
    }

    public final boolean canBeShow() {
        float f = (float) 0;
        return this.outWidth > f && this.outHeight > f;
    }

    public final boolean isGifUrl() {
        return StringsKt.endsWith(this.inSource, ".gif", true);
    }

    public final boolean isVertical() {
        return ((double) this.inRatio) < 0.88d;
    }

    public final boolean hasFlag(int i) {
        return (i & this.outFlags) > 0;
    }
}
