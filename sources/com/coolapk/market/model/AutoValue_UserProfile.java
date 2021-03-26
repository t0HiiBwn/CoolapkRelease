package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_UserProfile extends C$AutoValue_UserProfile {
    public static final Parcelable.Creator<AutoValue_UserProfile> CREATOR = new Parcelable.Creator<AutoValue_UserProfile>() {
        /* class com.coolapk.market.model.AutoValue_UserProfile.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_UserProfile createFromParcel(Parcel parcel) {
            return new AutoValue_UserProfile(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? parcel.readString() : null, (UserInfo) parcel.readParcelable(UserInfo.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readFloat(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readArrayList(Entity.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), (Tips) parcel.readParcelable(Tips.class.getClassLoader()), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(String.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_UserProfile[] newArray(int i) {
            return new AutoValue_UserProfile[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_UserProfile(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, Long l2, String str12, UserInfo userInfo, String str13, String str14, String str15, int i, String str16, String str17, int i2, String str18, int i3, int i4, float f, String str19, String str20, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, String str21, String str22, String str23, String str24, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, String str25, String str26, int i25, int i26, long j, long j2, int i27, List<Entity> list, String str27, String str28, int i28, Tips tips, int i29, String str29, String str30, String str31, List<String> list2) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, str11, l, l2, str12, userInfo, str13, str14, str15, i, str16, str17, i2, str18, i3, i4, f, str19, str20, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, str21, str22, str23, str24, i17, i18, i19, i20, i21, i22, i23, i24, str25, str26, i25, i26, j, j2, i27, list, str27, str28, i28, tips, i29, str29, str30, str31, list2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getEntityTypeName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityTypeName());
        }
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
        if (getTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTitle());
        }
        if (getUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUrl());
        }
        if (getDescription() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDescription());
        }
        if (getPic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPic());
        }
        if (getLogo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLogo());
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
        if (getDeprecatedUserAvatar() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDeprecatedUserAvatar());
        }
        parcel.writeParcelable(getUserInfo(), i);
        if (getDeprecatedUserName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDeprecatedUserName());
        }
        if (getDisplayUserName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDisplayUserName());
        }
        parcel.writeString(getUid());
        parcel.writeInt(getGender());
        if (getUserGroupName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUserGroupName());
        }
        if (getEMail() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEMail());
        }
        parcel.writeInt(getLevel());
        if (getSignature() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSignature());
        }
        parcel.writeInt(getLevelExperience());
        parcel.writeInt(getNextLevelExperience());
        parcel.writeFloat(getNextLevelPercentage());
        if (getLevelTodayMessage() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLevelTodayMessage());
        }
        if (getLevelDetailUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLevelDetailUrl());
        }
        parcel.writeInt(getApkFollowNum());
        parcel.writeInt(getApkCommentNum());
        parcel.writeInt(getApkRatingNum());
        parcel.writeInt(getAlbumNum());
        parcel.writeInt(getAlbumFavorNum());
        parcel.writeInt(getDiscoveryNum());
        parcel.writeInt(getIsFollow());
        parcel.writeInt(getBeLikeNum());
        parcel.writeInt(getFeedNum());
        parcel.writeInt(getFollowNum());
        parcel.writeInt(getFansNum());
        parcel.writeInt(getIsDeveloper());
        if (getWeibo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getWeibo());
        }
        if (getCity() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCity());
        }
        if (getProvince() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getProvince());
        }
        if (getCover() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCover());
        }
        parcel.writeInt(getBirthday());
        parcel.writeInt(getBirthmonth());
        parcel.writeInt(getBirthyear());
        parcel.writeInt(getApkDevNum());
        parcel.writeInt(getReplyNum());
        parcel.writeInt(getIsInBlackList());
        parcel.writeInt(getIsInIgnoreList());
        parcel.writeInt(getIsInLimitList());
        if (getPhoneNumber() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPhoneNumber());
        }
        if (getZodiacSign() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getZodiacSign());
        }
        parcel.writeInt(getMobileStatus());
        parcel.writeInt(getEmailStatus());
        parcel.writeLong(getRegDate());
        parcel.writeLong(getLoginTime());
        parcel.writeInt(getIsFans());
        parcel.writeList(getHomeTabCardRows());
        if (getSelectedTab() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSelectedTab());
        }
        if (getEntityType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityType());
        }
        parcel.writeInt(getUserNameStatus());
        parcel.writeParcelable(getTips(), i);
        parcel.writeInt(getVerifyStatus());
        if (getVerifyIcon() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getVerifyIcon());
        }
        if (getVerifyLabel() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getVerifyLabel());
        }
        if (getVerifyTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getVerifyTitle());
        }
        parcel.writeList(getTopIds());
    }
}
