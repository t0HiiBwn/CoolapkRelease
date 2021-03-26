package com.coolapk.market.imageloader;

import android.graphics.Bitmap;
import androidx.palette.graphics.Palette;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/imageloader/PaletteBitmap;", "", "bitmap", "Landroid/graphics/Bitmap;", "palette", "Landroidx/palette/graphics/Palette;", "(Landroid/graphics/Bitmap;Landroidx/palette/graphics/Palette;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getPalette", "()Landroidx/palette/graphics/Palette;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PaletteBitmap.kt */
public final class PaletteBitmap {
    private final Bitmap bitmap;
    private final Palette palette;

    public PaletteBitmap(Bitmap bitmap2, Palette palette2) {
        Intrinsics.checkNotNullParameter(bitmap2, "bitmap");
        Intrinsics.checkNotNullParameter(palette2, "palette");
        this.bitmap = bitmap2;
        this.palette = palette2;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Palette getPalette() {
        return this.palette;
    }
}
