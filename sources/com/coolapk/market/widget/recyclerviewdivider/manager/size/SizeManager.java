package com.coolapk.market.widget.recyclerviewdivider.manager.size;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nJ(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/widget/recyclerviewdivider/manager/size/SizeManager;", "", "itemSize", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/size/SizeManager$SizeCompat;", "drawable", "Landroid/graphics/drawable/Drawable;", "orientation", "", "groupCount", "groupIndex", "SizeCompat", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SizeManager.kt */
public interface SizeManager {
    SizeCompat itemSize(Drawable drawable, int i, int i2, int i3);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/widget/recyclerviewdivider/manager/size/SizeManager$SizeCompat;", "", "size", "", "firstMarginInGroup", "lastMarginInGroup", "(III)V", "getFirstMarginInGroup", "()I", "getLastMarginInGroup", "getSize", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SizeManager.kt */
    public static final class SizeCompat {
        private final int firstMarginInGroup;
        private final int lastMarginInGroup;
        private final int size;

        public SizeCompat(int i, int i2, int i3) {
            this.size = i;
            this.firstMarginInGroup = i2;
            this.lastMarginInGroup = i3;
        }

        public final int getSize() {
            return this.size;
        }

        public final int getFirstMarginInGroup() {
            return this.firstMarginInGroup;
        }

        public final int getLastMarginInGroup() {
            return this.lastMarginInGroup;
        }
    }
}
