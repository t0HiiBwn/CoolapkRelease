package com.coolapk.market.view.photo;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JR\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\tH\u0016J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\tHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u001a\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\tH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006+"}, d2 = {"Lcom/coolapk/market/view/photo/PhotoViewUrl;", "Landroid/os/Parcelable;", "source", "", "compress", "currentDisplay", "rect", "Landroid/graphics/Rect;", "needCoolapkHeader", "", "mediaID", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Rect;Ljava/lang/Integer;Ljava/lang/String;)V", "getCompress", "()Ljava/lang/String;", "getCurrentDisplay", "getMediaID", "getNeedCoolapkHeader", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRect", "()Landroid/graphics/Rect;", "getSource", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Rect;Ljava/lang/Integer;Ljava/lang/String;)Lcom/coolapk/market/view/photo/PhotoViewUrl;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhotoViewUrl.kt */
public final class PhotoViewUrl implements Parcelable {
    public static final Parcelable.Creator<PhotoViewUrl> CREATOR = new PhotoViewUrl$Companion$CREATOR$1();
    public static final Companion Companion = new Companion(null);
    private final String compress;
    private final String currentDisplay;
    private final String mediaID;
    private final Integer needCoolapkHeader;
    private final Rect rect;
    private final String source;

    public static /* synthetic */ PhotoViewUrl copy$default(PhotoViewUrl photoViewUrl, String str, String str2, String str3, Rect rect2, Integer num, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = photoViewUrl.source;
        }
        if ((i & 2) != 0) {
            str2 = photoViewUrl.compress;
        }
        if ((i & 4) != 0) {
            str3 = photoViewUrl.currentDisplay;
        }
        if ((i & 8) != 0) {
            rect2 = photoViewUrl.rect;
        }
        if ((i & 16) != 0) {
            num = photoViewUrl.needCoolapkHeader;
        }
        if ((i & 32) != 0) {
            str4 = photoViewUrl.mediaID;
        }
        return photoViewUrl.copy(str, str2, str3, rect2, num, str4);
    }

    @JvmStatic
    public static final ArrayList<PhotoViewUrl> from(String[] strArr, String[] strArr2, String[] strArr3, Rect[] rectArr, int i) {
        return Companion.from(strArr, strArr2, strArr3, rectArr, i);
    }

    @JvmStatic
    public static final ArrayList<PhotoViewUrl> from(String[] strArr, String[] strArr2, String[] strArr3, Rect[] rectArr, int i, String[] strArr4) {
        return Companion.from(strArr, strArr2, strArr3, rectArr, i, strArr4);
    }

    public final String component1() {
        return this.source;
    }

    public final String component2() {
        return this.compress;
    }

    public final String component3() {
        return this.currentDisplay;
    }

    public final Rect component4() {
        return this.rect;
    }

    public final Integer component5() {
        return this.needCoolapkHeader;
    }

    public final String component6() {
        return this.mediaID;
    }

    public final PhotoViewUrl copy(String str, String str2, String str3, Rect rect2, Integer num, String str4) {
        Intrinsics.checkNotNullParameter(str, "source");
        Intrinsics.checkNotNullParameter(str4, "mediaID");
        return new PhotoViewUrl(str, str2, str3, rect2, num, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotoViewUrl)) {
            return false;
        }
        PhotoViewUrl photoViewUrl = (PhotoViewUrl) obj;
        return Intrinsics.areEqual(this.source, photoViewUrl.source) && Intrinsics.areEqual(this.compress, photoViewUrl.compress) && Intrinsics.areEqual(this.currentDisplay, photoViewUrl.currentDisplay) && Intrinsics.areEqual(this.rect, photoViewUrl.rect) && Intrinsics.areEqual(this.needCoolapkHeader, photoViewUrl.needCoolapkHeader) && Intrinsics.areEqual(this.mediaID, photoViewUrl.mediaID);
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.source;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.compress;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.currentDisplay;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Rect rect2 = this.rect;
        int hashCode4 = (hashCode3 + (rect2 != null ? rect2.hashCode() : 0)) * 31;
        Integer num = this.needCoolapkHeader;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        String str4 = this.mediaID;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        return "PhotoViewUrl(source=" + this.source + ", compress=" + this.compress + ", currentDisplay=" + this.currentDisplay + ", rect=" + this.rect + ", needCoolapkHeader=" + this.needCoolapkHeader + ", mediaID=" + this.mediaID + ")";
    }

    public PhotoViewUrl(String str, String str2, String str3, Rect rect2, Integer num, String str4) {
        Intrinsics.checkNotNullParameter(str, "source");
        Intrinsics.checkNotNullParameter(str4, "mediaID");
        this.source = str;
        this.compress = str2;
        this.currentDisplay = str3;
        this.rect = rect2;
        this.needCoolapkHeader = num;
        this.mediaID = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoViewUrl(String str, String str2, String str3, Rect rect2, Integer num, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, rect2, num, (i & 32) != 0 ? "" : str4);
    }

    public final String getCompress() {
        return this.compress;
    }

    public final String getCurrentDisplay() {
        return this.currentDisplay;
    }

    public final String getMediaID() {
        return this.mediaID;
    }

    public final Integer getNeedCoolapkHeader() {
        return this.needCoolapkHeader;
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final String getSource() {
        return this.source;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Ji\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012J}\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u0014R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/photo/PhotoViewUrl$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/coolapk/market/view/photo/PhotoViewUrl;", "from", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sources", "", "", "thumbnails", "displayUrls", "rects", "Landroid/graphics/Rect;", "needCoolapkHeader", "", "([Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[Landroid/graphics/Rect;I)Ljava/util/ArrayList;", "mediaIds", "([Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[Landroid/graphics/Rect;I[Ljava/lang/String;)Ljava/util/ArrayList;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PhotoViewUrl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ArrayList<PhotoViewUrl> from(String[] strArr, String[] strArr2, String[] strArr3, Rect[] rectArr, int i) {
            Intrinsics.checkNotNullParameter(strArr, "sources");
            return from(strArr, strArr2, strArr3, rectArr, i, null);
        }

        public static /* synthetic */ ArrayList from$default(Companion companion, String[] strArr, String[] strArr2, String[] strArr3, Rect[] rectArr, int i, String[] strArr4, int i2, Object obj) {
            if ((i2 & 32) != 0) {
                strArr4 = null;
            }
            return companion.from(strArr, strArr2, strArr3, rectArr, i, strArr4);
        }

        @JvmStatic
        public final ArrayList<PhotoViewUrl> from(String[] strArr, String[] strArr2, String[] strArr3, Rect[] rectArr, int i, String[] strArr4) {
            Intrinsics.checkNotNullParameter(strArr, "sources");
            if (strArr2 != null && strArr2.length != strArr.length) {
                throw new IllegalArgumentException("thumbnails with incompatible length");
            } else if (strArr3 != null && strArr3.length != strArr.length) {
                throw new IllegalArgumentException("displayUrls with incompatible length");
            } else if (rectArr == null || rectArr.length == strArr.length) {
                ArrayList<PhotoViewUrl> arrayList = new ArrayList<>(strArr.length);
                int length = strArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    String str = strArr[i2];
                    String str2 = null;
                    String str3 = strArr2 != null ? (String) ArraysKt.getOrNull(strArr2, i2) : null;
                    String str4 = strArr3 != null ? (String) ArraysKt.getOrNull(strArr3, i2) : null;
                    Rect rect = rectArr != null ? (Rect) ArraysKt.getOrNull(rectArr, i2) : null;
                    Integer valueOf = Integer.valueOf(i);
                    if (strArr4 != null) {
                        str2 = (String) ArraysKt.getOrNull(strArr4, i2);
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    arrayList.add(new PhotoViewUrl(str, str3, str4, rect, valueOf, str2));
                }
                return arrayList;
            } else {
                throw new IllegalArgumentException("rects with incompatible length");
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeString(this.source);
        }
        if (parcel != null) {
            parcel.writeString(this.compress);
        }
        if (parcel != null) {
            parcel.writeString(this.currentDisplay);
        }
        if (parcel != null) {
            parcel.writeParcelable(this.rect, i);
        }
        if (parcel != null) {
            Integer num = this.needCoolapkHeader;
            Intrinsics.checkNotNull(num);
            parcel.writeInt(num.intValue());
        }
        if (parcel != null) {
            parcel.writeString(this.mediaID);
        }
    }
}
