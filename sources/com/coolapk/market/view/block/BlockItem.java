package com.coolapk.market.view.block;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 )2\u00020\u0001:\u0001)BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001eHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006*"}, d2 = {"Lcom/coolapk/market/view/block/BlockItem;", "Landroid/os/Parcelable;", "tid", "", "name", "title", "logo", "active", "", "url", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getActive", "()Z", "getLogo", "()Ljava/lang/String;", "getName", "getTid", "getTitle", "getType", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BlockContentManager.kt */
public final class BlockItem implements Parcelable {
    public static final Parcelable.Creator<BlockItem> CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    public static final String NODE_TYPE = "node";
    public static final String USER_TYPE = "user";
    public static final String WORD_TYPE = "word";
    private final boolean active;
    private final String logo;
    private final String name;
    private final String tid;
    private final String title;
    private final String type;
    private final String url;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BlockItem> {
        @Override // android.os.Parcelable.Creator
        public final BlockItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BlockItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final BlockItem[] newArray(int i) {
            return new BlockItem[i];
        }
    }

    public static /* synthetic */ BlockItem copy$default(BlockItem blockItem, String str, String str2, String str3, String str4, boolean z, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = blockItem.tid;
        }
        if ((i & 2) != 0) {
            str2 = blockItem.name;
        }
        if ((i & 4) != 0) {
            str3 = blockItem.title;
        }
        if ((i & 8) != 0) {
            str4 = blockItem.logo;
        }
        if ((i & 16) != 0) {
            z = blockItem.active;
        }
        if ((i & 32) != 0) {
            str5 = blockItem.url;
        }
        if ((i & 64) != 0) {
            str6 = blockItem.type;
        }
        return blockItem.copy(str, str2, str3, str4, z, str5, str6);
    }

    public final String component1() {
        return this.tid;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.logo;
    }

    public final boolean component5() {
        return this.active;
    }

    public final String component6() {
        return this.url;
    }

    public final String component7() {
        return this.type;
    }

    public final BlockItem copy(String str, String str2, String str3, String str4, boolean z, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "tid");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, "logo");
        Intrinsics.checkNotNullParameter(str5, "url");
        Intrinsics.checkNotNullParameter(str6, "type");
        return new BlockItem(str, str2, str3, str4, z, str5, str6);
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
        if (!(obj instanceof BlockItem)) {
            return false;
        }
        BlockItem blockItem = (BlockItem) obj;
        return Intrinsics.areEqual(this.tid, blockItem.tid) && Intrinsics.areEqual(this.name, blockItem.name) && Intrinsics.areEqual(this.title, blockItem.title) && Intrinsics.areEqual(this.logo, blockItem.logo) && this.active == blockItem.active && Intrinsics.areEqual(this.url, blockItem.url) && Intrinsics.areEqual(this.type, blockItem.type);
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.tid;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.logo;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z = this.active;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode4 + i2) * 31;
        String str5 = this.url;
        int hashCode5 = (i5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.type;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        return "BlockItem(tid=" + this.tid + ", name=" + this.name + ", title=" + this.title + ", logo=" + this.logo + ", active=" + this.active + ", url=" + this.url + ", type=" + this.type + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.tid);
        parcel.writeString(this.name);
        parcel.writeString(this.title);
        parcel.writeString(this.logo);
        parcel.writeInt(this.active ? 1 : 0);
        parcel.writeString(this.url);
        parcel.writeString(this.type);
    }

    public BlockItem(String str, String str2, String str3, String str4, boolean z, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "tid");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, "logo");
        Intrinsics.checkNotNullParameter(str5, "url");
        Intrinsics.checkNotNullParameter(str6, "type");
        this.tid = str;
        this.name = str2;
        this.title = str3;
        this.logo = str4;
        this.active = z;
        this.url = str5;
        this.type = str6;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BlockItem(String str, String str2, String str3, String str4, boolean z, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "0" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? false : z, (i & 32) != 0 ? "" : str5, str6);
    }

    public final boolean getActive() {
        return this.active;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTid() {
        return this.tid;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/block/BlockItem$Companion;", "", "()V", "NODE_TYPE", "", "USER_TYPE", "WORD_TYPE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BlockContentManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
