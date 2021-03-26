package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_Live extends C$AutoValue_Live {
    public static final Parcelable.Creator<AutoValue_Live> CREATOR = new Parcelable.Creator<AutoValue_Live>() {
        /* class com.coolapk.market.model.AutoValue_Live.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_Live createFromParcel(Parcel parcel) {
            return new AutoValue_Live(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, (LiveProduct) parcel.readParcelable(LiveProduct.class.getClassLoader()), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), (User) parcel.readParcelable(User.class.getClassLoader()), parcel.readInt(), parcel.readArrayList(User.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_Live[] newArray(int i) {
            return new AutoValue_Live[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_Live(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, Long l, Long l2, String str10, String str11, String str12, long j, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, LiveProduct liveProduct, int i, String str22, int i2, int i3, String str23, int i4, String str24, int i5, long j2, long j3, int i6, int i7, int i8, int i9, String str25, int i10, User user, int i11, List<User> list, String str26) {
        super(str, str2, str3, str4, num, str5, str6, str7, str8, str9, l, l2, str10, str11, str12, j, str13, str14, str15, str16, str17, str18, str19, str20, str21, liveProduct, i, str22, i2, i3, str23, i4, str24, i5, j2, j3, i6, i7, i8, i9, str25, i10, user, i11, list, str26);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getEntityTypeName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityTypeName());
        }
        parcel.writeString(getEntityType());
        if (getEntityTemplate() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityTemplate());
        }
        if (getEntityId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityId());
        }
        if (getEntityFixed() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(getEntityFixed().intValue());
        }
        if (getUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUrl());
        }
        if (getPic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPic());
        }
        if (getSubTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSubTitle());
        }
        if (getId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getId());
        }
        if (getExtraData() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraData());
        }
        if (getDateline() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeLong(getDateline().longValue());
        }
        if (getLastUpdate() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeLong(getLastUpdate().longValue());
        }
        parcel.writeString(getUid());
        parcel.writeString(getTitle());
        parcel.writeString(getPresenterUid());
        parcel.writeLong(getLiveTime());
        parcel.writeString(getShowLiveTime());
        parcel.writeString(getDescription());
        if (getPicUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPicUrl());
        }
        if (getVideoLiveUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getVideoLiveUrl());
        }
        if (getVideoLiveInfo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getVideoLiveInfo());
        }
        if (getVideoPlaybackUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getVideoPlaybackUrl());
        }
        if (getVideoPlaybackUInfo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getVideoPlaybackUInfo());
        }
        if (getRelationTag() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getRelationTag());
        }
        if (getRelationPageName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getRelationPageName());
        }
        parcel.writeParcelable(getRelationProduct(), i);
        parcel.writeInt(getIsShowBannerTitle());
        parcel.writeString(getFollowNumFormat());
        parcel.writeInt(getFollowNum());
        parcel.writeInt(getDiscussNum());
        parcel.writeString(getDiscussNumFormat());
        parcel.writeInt(getVisitNum());
        parcel.writeString(getVisitNumFormat());
        parcel.writeInt(getRankScore());
        parcel.writeLong(getLiveStartTime());
        parcel.writeLong(getLiveEndTime());
        parcel.writeInt(getLiveStatus());
        parcel.writeInt(getDisallowPost());
        parcel.writeInt(getDisallowPostPic());
        parcel.writeInt(getDisableDiscussTab());
        parcel.writeString(getShowTab());
        parcel.writeInt(getCloseDiscuss());
        parcel.writeParcelable(getUserInfo(), i);
        parcel.writeInt(getIsFollow());
        parcel.writeList(getPresenterUserInfo());
        parcel.writeString(getRelationGroupId());
    }
}
