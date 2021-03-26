package com.coolapk.market.view.feed.vote;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B1\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\tHÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u0018\u001a\u00020\u000bHÆ\u0003J<\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\u001cH\u0016J\u0006\u0010\"\u001a\u00020\u001eJ\t\u0010#\u001a\u00020\u0006HÖ\u0001J\u001a\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u00032\u0006\u0010'\u001a\u00020\u001cH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "fid", "", "optionId", "pkOptionId", "", "pkOptionColor", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[I)V", "getFid", "()Ljava/lang/String;", "getOptionId", "getPkOptionColor", "()[I", "getPkOptionId", "()[Ljava/lang/String;", "[Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[I)Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;", "describeContents", "", "equals", "", "other", "", "hashCode", "shouldDisplayInMultiPage", "toString", "writeToParcel", "", "dest", "flags", "CREATOR", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVotePresenter.kt */
public final class VoteCommentConfig implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    private final String fid;
    private final String optionId;
    private final int[] pkOptionColor;
    private final String[] pkOptionId;

    public static /* synthetic */ VoteCommentConfig copy$default(VoteCommentConfig voteCommentConfig, String str, String str2, String[] strArr, int[] iArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = voteCommentConfig.fid;
        }
        if ((i & 2) != 0) {
            str2 = voteCommentConfig.optionId;
        }
        if ((i & 4) != 0) {
            strArr = voteCommentConfig.pkOptionId;
        }
        if ((i & 8) != 0) {
            iArr = voteCommentConfig.pkOptionColor;
        }
        return voteCommentConfig.copy(str, str2, strArr, iArr);
    }

    public final String component1() {
        return this.fid;
    }

    public final String component2() {
        return this.optionId;
    }

    public final String[] component3() {
        return this.pkOptionId;
    }

    public final int[] component4() {
        return this.pkOptionColor;
    }

    public final VoteCommentConfig copy(String str, String str2, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(str, "fid");
        Intrinsics.checkNotNullParameter(str2, "optionId");
        Intrinsics.checkNotNullParameter(strArr, "pkOptionId");
        Intrinsics.checkNotNullParameter(iArr, "pkOptionColor");
        return new VoteCommentConfig(str, str2, strArr, iArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return "VoteCommentConfig(fid=" + this.fid + ", optionId=" + this.optionId + ", pkOptionId=" + Arrays.toString(this.pkOptionId) + ", pkOptionColor=" + Arrays.toString(this.pkOptionColor) + ")";
    }

    public VoteCommentConfig(String str, String str2, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(str, "fid");
        Intrinsics.checkNotNullParameter(str2, "optionId");
        Intrinsics.checkNotNullParameter(strArr, "pkOptionId");
        Intrinsics.checkNotNullParameter(iArr, "pkOptionColor");
        this.fid = str;
        this.optionId = str2;
        this.pkOptionId = strArr;
        this.pkOptionColor = iArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VoteCommentConfig(String str, String str2, String[] strArr, int[] iArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? new String[0] : strArr, (i & 8) != 0 ? new int[0] : iArr);
    }

    public final String getFid() {
        return this.fid;
    }

    public final String getOptionId() {
        return this.optionId;
    }

    public final int[] getPkOptionColor() {
        return this.pkOptionColor;
    }

    public final String[] getPkOptionId() {
        return this.pkOptionId;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public VoteCommentConfig(Parcel parcel) {
        this(r0, r2, r1, r5);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        Intrinsics.checkNotNullExpressionValue(readString, "parcel.readString()!!");
        String readString2 = parcel.readString();
        Intrinsics.checkNotNull(readString2);
        Intrinsics.checkNotNullExpressionValue(readString2, "parcel.readString()!!");
        String[] createStringArray = parcel.createStringArray();
        Intrinsics.checkNotNull(createStringArray);
        Intrinsics.checkNotNullExpressionValue(createStringArray, "parcel.createStringArray()!!");
        int[] createIntArray = parcel.createIntArray();
        Intrinsics.checkNotNull(createIntArray);
        Intrinsics.checkNotNullExpressionValue(createIntArray, "parcel.createIntArray()!!");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeString(this.fid);
        }
        if (parcel != null) {
            parcel.writeString(this.optionId);
        }
        if (parcel != null) {
            parcel.writeStringArray(this.pkOptionId);
        }
        if (parcel != null) {
            parcel.writeIntArray(this.pkOptionColor);
        }
    }

    public final boolean shouldDisplayInMultiPage() {
        return (this.optionId.length() == 0) && this.pkOptionId.length >= 2;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.feed.vote.VoteCommentConfig");
        VoteCommentConfig voteCommentConfig = (VoteCommentConfig) obj;
        if (!(!Intrinsics.areEqual(this.fid, voteCommentConfig.fid)) && !(!Intrinsics.areEqual(this.optionId, voteCommentConfig.optionId)) && Arrays.equals(this.pkOptionId, voteCommentConfig.pkOptionId) && Arrays.equals(this.pkOptionColor, voteCommentConfig.pkOptionColor)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (((((this.fid.hashCode() * 31) + this.optionId.hashCode()) * 31) + Arrays.hashCode(this.pkOptionId)) * 31) + Arrays.hashCode(this.pkOptionColor);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedVotePresenter.kt */
    public static final class CREATOR implements Parcelable.Creator<VoteCommentConfig> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public VoteCommentConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VoteCommentConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public VoteCommentConfig[] newArray(int i) {
            return new VoteCommentConfig[i];
        }
    }
}
