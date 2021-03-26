package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0006H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/model/DataItem;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "itemType", "", "(I)V", "getItemType", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DataItem.kt */
public final class DataItem implements Parcelable {
    public static final Parcelable.Creator<DataItem> CREATOR = new DataItem$Companion$CREATOR$1();
    public static final Companion Companion = new Companion(null);
    private final int itemType;

    public static /* synthetic */ DataItem copy$default(DataItem dataItem, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dataItem.itemType;
        }
        return dataItem.copy(i);
    }

    public final int component1() {
        return this.itemType;
    }

    public final DataItem copy(int i) {
        return new DataItem(i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof DataItem) && this.itemType == ((DataItem) obj).itemType;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.itemType;
    }

    @Override // java.lang.Object
    public String toString() {
        return "DataItem(itemType=" + this.itemType + ")";
    }

    public DataItem(int i) {
        this.itemType = i;
    }

    public final int getItemType() {
        return this.itemType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DataItem(Parcel parcel) {
        this(parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.itemType);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/model/DataItem$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/coolapk/market/model/DataItem;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DataItem.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
