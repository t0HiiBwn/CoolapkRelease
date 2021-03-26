package com.coolapk.market.view.feed.dialog;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SheetData.kt */
public final class SheetDataItem {
    public static final Companion Companion = new Companion(null);
    private final String bandageText;
    private final SheetCallback callback;
    private final ImageViewApplyer imageAppler;
    private final int maxLines;
    private final boolean rightDivider;
    private final boolean secondPageHint;
    private final SheetAction sheetAction;
    private final String title;

    public static /* synthetic */ SheetDataItem copy$default(SheetDataItem sheetDataItem, SheetAction sheetAction2, String str, ImageViewApplyer imageViewApplyer, SheetCallback sheetCallback, String str2, int i, boolean z, boolean z2, int i2, Object obj) {
        return sheetDataItem.copy((i2 & 1) != 0 ? sheetDataItem.sheetAction : sheetAction2, (i2 & 2) != 0 ? sheetDataItem.title : str, (i2 & 4) != 0 ? sheetDataItem.imageAppler : imageViewApplyer, (i2 & 8) != 0 ? sheetDataItem.callback : sheetCallback, (i2 & 16) != 0 ? sheetDataItem.bandageText : str2, (i2 & 32) != 0 ? sheetDataItem.maxLines : i, (i2 & 64) != 0 ? sheetDataItem.rightDivider : z, (i2 & 128) != 0 ? sheetDataItem.secondPageHint : z2);
    }

    public final SheetAction component1() {
        return this.sheetAction;
    }

    public final String component2() {
        return this.title;
    }

    public final ImageViewApplyer component3() {
        return this.imageAppler;
    }

    public final SheetCallback component4() {
        return this.callback;
    }

    public final String component5() {
        return this.bandageText;
    }

    public final int component6() {
        return this.maxLines;
    }

    public final boolean component7() {
        return this.rightDivider;
    }

    public final boolean component8() {
        return this.secondPageHint;
    }

    public final SheetDataItem copy(SheetAction sheetAction2, String str, ImageViewApplyer imageViewApplyer, SheetCallback sheetCallback, String str2, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(sheetAction2, "sheetAction");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(imageViewApplyer, "imageAppler");
        Intrinsics.checkNotNullParameter(sheetCallback, "callback");
        Intrinsics.checkNotNullParameter(str2, "bandageText");
        return new SheetDataItem(sheetAction2, str, imageViewApplyer, sheetCallback, str2, i, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SheetDataItem)) {
            return false;
        }
        SheetDataItem sheetDataItem = (SheetDataItem) obj;
        return Intrinsics.areEqual(this.sheetAction, sheetDataItem.sheetAction) && Intrinsics.areEqual(this.title, sheetDataItem.title) && Intrinsics.areEqual(this.imageAppler, sheetDataItem.imageAppler) && Intrinsics.areEqual(this.callback, sheetDataItem.callback) && Intrinsics.areEqual(this.bandageText, sheetDataItem.bandageText) && this.maxLines == sheetDataItem.maxLines && this.rightDivider == sheetDataItem.rightDivider && this.secondPageHint == sheetDataItem.secondPageHint;
    }

    public int hashCode() {
        SheetAction sheetAction2 = this.sheetAction;
        int i = 0;
        int hashCode = (sheetAction2 != null ? sheetAction2.hashCode() : 0) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        ImageViewApplyer imageViewApplyer = this.imageAppler;
        int hashCode3 = (hashCode2 + (imageViewApplyer != null ? imageViewApplyer.hashCode() : 0)) * 31;
        SheetCallback sheetCallback = this.callback;
        int hashCode4 = (hashCode3 + (sheetCallback != null ? sheetCallback.hashCode() : 0)) * 31;
        String str2 = this.bandageText;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (((hashCode4 + i) * 31) + this.maxLines) * 31;
        boolean z = this.rightDivider;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (i2 + i4) * 31;
        boolean z2 = this.secondPageHint;
        if (!z2) {
            i3 = z2 ? 1 : 0;
        }
        return i7 + i3;
    }

    public String toString() {
        return "SheetDataItem(sheetAction=" + this.sheetAction + ", title=" + this.title + ", imageAppler=" + this.imageAppler + ", callback=" + this.callback + ", bandageText=" + this.bandageText + ", maxLines=" + this.maxLines + ", rightDivider=" + this.rightDivider + ", secondPageHint=" + this.secondPageHint + ")";
    }

    public SheetDataItem(SheetAction sheetAction2, String str, ImageViewApplyer imageViewApplyer, SheetCallback sheetCallback, String str2, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(sheetAction2, "sheetAction");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(imageViewApplyer, "imageAppler");
        Intrinsics.checkNotNullParameter(sheetCallback, "callback");
        Intrinsics.checkNotNullParameter(str2, "bandageText");
        this.sheetAction = sheetAction2;
        this.title = str;
        this.imageAppler = imageViewApplyer;
        this.callback = sheetCallback;
        this.bandageText = str2;
        this.maxLines = i;
        this.rightDivider = z;
        this.secondPageHint = z2;
    }

    public final ImageViewApplyer getImageAppler() {
        return this.imageAppler;
    }

    public final SheetAction getSheetAction() {
        return this.sheetAction;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBandageText() {
        return this.bandageText;
    }

    public final SheetCallback getCallback() {
        return this.callback;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SheetDataItem(SheetAction sheetAction2, String str, ImageViewApplyer imageViewApplyer, SheetCallback sheetCallback, String str2, int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(sheetAction2, str, imageViewApplyer, sheetCallback, (i2 & 16) != 0 ? "" : str2, (i2 & 32) != 0 ? 1 : i, (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? false : z2);
    }

    public final boolean getRightDivider() {
        return this.rightDivider;
    }

    public final boolean getSecondPageHint() {
        return this.secondPageHint;
    }

    /* compiled from: SheetData.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImageViewApplyer createIconBgApplyer(int i, int i2, int i3) {
            return new SheetDataItem$Companion$createIconBgApplyer$1(i3, i, i2);
        }

        public final ImageViewApplyer createResourceApplyer(int i) {
            return new SheetDataItem$Companion$createResourceApplyer$1(i);
        }

        public final ImageViewApplyer create36dpIconApplyer(int i, int i2) {
            return new SheetDataItem$Companion$create36dpIconApplyer$1(i, i2);
        }
    }
}
