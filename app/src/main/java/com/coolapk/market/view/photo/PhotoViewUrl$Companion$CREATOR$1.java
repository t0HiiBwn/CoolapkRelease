package com.coolapk.market.view.photo;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/coolapk/market/view/photo/PhotoViewUrl$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/coolapk/market/view/photo/PhotoViewUrl;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/coolapk/market/view/photo/PhotoViewUrl;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhotoViewUrl.kt */
public final class PhotoViewUrl$Companion$CREATOR$1 implements Parcelable.Creator<PhotoViewUrl> {
    PhotoViewUrl$Companion$CREATOR$1() {
    }

    @Override // android.os.Parcelable.Creator
    public PhotoViewUrl createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        Intrinsics.checkNotNullExpressionValue(readString, "parcel.readString()!!");
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        Integer valueOf = Integer.valueOf(parcel.readInt());
        String readString4 = parcel.readString();
        Intrinsics.checkNotNull(readString4);
        Intrinsics.checkNotNullExpressionValue(readString4, "parcel.readString()!!");
        return new PhotoViewUrl(readString, readString2, readString3, (Rect) parcel.readParcelable(currentThread.getContextClassLoader()), valueOf, readString4);
    }

    @Override // android.os.Parcelable.Creator
    public PhotoViewUrl[] newArray(int i) {
        return new PhotoViewUrl[i];
    }
}
