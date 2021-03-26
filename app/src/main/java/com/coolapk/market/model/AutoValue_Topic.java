package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_Topic extends C$AutoValue_Topic {
    public static final Parcelable.Creator<AutoValue_Topic> CREATOR = new Parcelable.Creator<AutoValue_Topic>() {
        /* class com.coolapk.market.model.AutoValue_Topic.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_Topic createFromParcel(Parcel parcel) {
            return new AutoValue_Topic(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, (UserAction) parcel.readParcelable(UserAction.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(RelatedData.class.getClassLoader()), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(NewHeadLine.class.getClassLoader()), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(String.class.getClassLoader()), parcel.readArrayList(String.class.getClassLoader()), parcel.readArrayList(ConfigPage.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null);
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_Topic[] newArray(int i) {
            return new AutoValue_Topic[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_Topic(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Long l2, Long l3, String str8, String str9, String str10, int i, int i2, int i3, int i4, String str11, UserAction userAction, String str12, int i5, String str13, List<RelatedData> list, int i6, long j, long j2, String str14, List<NewHeadLine> list2, int i7, String str15, String str16, int i8, int i9, int i10, int i11, int i12, int i13, String str17, String str18, String str19, String str20, String str21, String str22, List<String> list3, List<String> list4, List<ConfigPage> list5, String str23, int i14, String str24, String str25) {
        super(str, str2, str3, str4, num, str5, str6, str7, l2, l3, str8, str9, str10, i, i2, i3, i4, str11, userAction, str12, i5, str13, list, i6, j, j2, str14, list2, i7, str15, str16, i8, i9, i10, i11, i12, i13, str17, str18, str19, str20, str21, str22, list3, list4, list5, str23, i14, str24, str25);
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
        parcel.writeString(getId());
        if (getLogo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLogo());
        }
        if (getDescription() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDescription());
        }
        parcel.writeInt(getFollowNum());
        parcel.writeInt(getCommentNum());
        parcel.writeInt(getClick());
        parcel.writeInt(getIsRecommend());
        if (getTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTitle());
        }
        parcel.writeParcelable(getUserAction(), i);
        if (getIntro() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getIntro());
        }
        parcel.writeInt(getIsLive());
        if (getLivePresenterNames() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLivePresenterNames());
        }
        parcel.writeList(getRecentFollowList());
        parcel.writeInt(getLivingStatus());
        parcel.writeLong(getLiveStartAt());
        parcel.writeLong(getLiveEndAt());
        if (getUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUrl());
        }
        parcel.writeList(getRecommendRows());
        parcel.writeInt(getTagType());
        if (getCover() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCover());
        }
        if (getTagCategory() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTagCategory());
        }
        parcel.writeInt(getTopFeedId());
        parcel.writeInt(getVoteNum1());
        parcel.writeInt(getVoteNum2());
        parcel.writeInt(getVoteNum3());
        parcel.writeInt(getVoteNum4());
        parcel.writeInt(getVoteNum5());
        if (getPhoneInfo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPhoneInfo());
        }
        if (getAdLinkUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getAdLinkUrl());
        }
        if (getAdPicUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getAdPicUrl());
        }
        if (getShowDate() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getShowDate());
        }
        if (getPhonePrice() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPhonePrice());
        }
        if (getVideoUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getVideoUrl());
        }
        parcel.writeList(getTagPics());
        parcel.writeList(getTopIds());
        parcel.writeList(getTabApiList());
        if (getSelectedTab() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSelectedTab());
        }
        parcel.writeInt(getHotNum());
        if (getHotNumText() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getHotNumText());
        }
        if (getBgColor() == null) {
            parcel.writeInt(1);
            return;
        }
        parcel.writeInt(0);
        parcel.writeString(getBgColor());
    }
}
