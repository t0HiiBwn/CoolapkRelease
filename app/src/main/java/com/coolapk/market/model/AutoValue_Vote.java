package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_Vote extends C$AutoValue_Vote {
    public static final Parcelable.Creator<AutoValue_Vote> CREATOR = new Parcelable.Creator<AutoValue_Vote>() {
        /* class com.coolapk.market.model.AutoValue_Vote.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_Vote createFromParcel(Parcel parcel) {
            return new AutoValue_Vote(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readLong(), parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(VoteOption.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (Topic) parcel.readParcelable(Topic.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_Vote[] newArray(int i) {
            return new AutoValue_Vote[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_Vote(int i, int i2, int i3, String str, long j, String str2, String str3, String str4, String str5, int i4, int i5, String str6, int i6, int i7, String str7, int i8, int i9, int i10, int i11, int i12, String str8, List<VoteOption> list, String str9, String str10, int i13, int i14, int i15, int i16, Topic topic) {
        super(i, i2, i3, str, j, str2, str3, str4, str5, i4, i5, str6, i6, i7, str7, i8, i9, i10, i11, i12, str8, list, str9, str10, i13, i14, i15, i16, topic);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getAnonymousStatus());
        parcel.writeInt(getBlockStatus());
        parcel.writeInt(getCreateTime());
        if (getCreateUid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCreateUid());
        }
        parcel.writeLong(getEndTime());
        parcel.writeString(getId());
        if (getLastUpdate() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLastUpdate());
        }
        if (getLinkPage() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLinkPage());
        }
        if (getLinkTag() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLinkTag());
        }
        parcel.writeInt(getMaxSelectNum());
        parcel.writeInt(getMinSelectNum());
        if (getRecommendIds() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getRecommendIds());
        }
        parcel.writeInt(getStartTime());
        parcel.writeInt(getStatus());
        if (getTopIds() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTopIds());
        }
        parcel.writeInt(getTotalCommentNum());
        parcel.writeInt(getTotalOptionNum());
        parcel.writeInt(getTotalVoteNum());
        parcel.writeInt(getType());
        parcel.writeInt(getUpdateTime());
        if (getUpdateUid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUpdateUid());
        }
        parcel.writeList(getVoteOptions());
        if (getMessageTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessageTitle());
        }
        if (getUserSelectedOptions() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUserSelectedOptions());
        }
        parcel.writeInt(getUserAnonymousStatus());
        parcel.writeInt(getUserVoteCommentStatus());
        parcel.writeInt(getUserChangeVoteStatus());
        parcel.writeInt(getShowAuthor());
        parcel.writeParcelable(getLinkTagEntity(), i);
    }
}
