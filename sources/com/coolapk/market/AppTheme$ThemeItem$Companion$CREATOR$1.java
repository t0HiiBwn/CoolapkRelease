package com.coolapk.market;

import android.os.Parcel;
import android.os.Parcelable;
import com.coolapk.market.AppTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/coolapk/market/AppTheme$ThemeItem$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/coolapk/market/AppTheme$ThemeItem;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/coolapk/market/AppTheme$ThemeItem;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppTheme.kt */
public final class AppTheme$ThemeItem$Companion$CREATOR$1 implements Parcelable.Creator<AppTheme.ThemeItem> {
    AppTheme$ThemeItem$Companion$CREATOR$1() {
    }

    @Override // android.os.Parcelable.Creator
    public AppTheme.ThemeItem createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return new AppTheme.ThemeItem(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public AppTheme.ThemeItem[] newArray(int i) {
        return new AppTheme.ThemeItem[i];
    }
}
