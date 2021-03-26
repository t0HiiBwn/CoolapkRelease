package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.coolapk.market.model.FeedReply;
import java.util.List;

final class AutoValue_FeedReply extends C$AutoValue_FeedReply {
    public static final Parcelable.Creator<AutoValue_FeedReply> CREATOR = new Parcelable.Creator<AutoValue_FeedReply>() {
        /* class com.coolapk.market.model.AutoValue_FeedReply.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedReply createFromParcel(Parcel parcel) {
            return new AutoValue_FeedReply(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (UserInfo) parcel.readParcelable(UserInfo.class.getClassLoader()), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(FeedReply.class.getClassLoader()), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, (UserInfo) parcel.readParcelable(UserInfo.class.getClassLoader()), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, (FeedReply.ReplyUserAction) parcel.readParcelable(FeedReply.ReplyUserAction.class.getClassLoader()), parcel.readLong(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readLong(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, (FeedReply.ReplyFeed) parcel.readParcelable(FeedReply.ReplyFeed.class.getClassLoader()), (DyhArticle) parcel.readParcelable(DyhArticle.class.getClassLoader()), (SimpleInfo) parcel.readParcelable(SimpleInfo.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedReply[] newArray(int i) {
            return new AutoValue_FeedReply[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_FeedReply(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, Long l, Long l2, String str9, String str10, String str11, String str12, String str13, String str14, UserInfo userInfo, int i, int i2, String str15, String str16, String str17, String str18, int i3, int i4, String str19, String str20, String str21, String str22, String str23, List<FeedReply> list, int i5, int i6, String str24, String str25, String str26, UserInfo userInfo2, int i7, String str27, int i8, int i9, int i10, int i11, String str28, String str29, String str30, String str31, String str32, String str33, String str34, FeedReply.ReplyUserAction replyUserAction, long j, String str35, String str36, long j2, String str37, String str38, String str39, FeedReply.ReplyFeed replyFeed, DyhArticle dyhArticle, SimpleInfo simpleInfo) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, l, l2, str9, str10, str11, str12, str13, str14, userInfo, i, i2, str15, str16, str17, str18, i3, i4, str19, str20, str21, str22, str23, list, i5, i6, str24, str25, str26, userInfo2, i7, str27, i8, i9, i10, i11, str28, str29, str30, str31, str32, str33, str34, replyUserAction, j, str35, str36, j2, str37, str38, str39, replyFeed, dyhArticle, simpleInfo);
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
        if (getDescription() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDescription());
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
        if (getDisplayUserName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDisplayUserName());
        }
        parcel.writeString(getId());
        parcel.writeString(getFeedId());
        parcel.writeString(getUid());
        parcel.writeString(getDeprecatedUserName());
        parcel.writeParcelable(getUserInfo(), i);
        parcel.writeInt(getFtype());
        parcel.writeInt(getReplyId());
        if (getReplyUserName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getReplyUserName());
        }
        if (getReplyUserAvatar() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getReplyUserAvatar());
        }
        if (getReplyUid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getReplyUid());
        }
        parcel.writeString(getMessage());
        parcel.writeInt(getReplyNum());
        parcel.writeInt(getIsFeedAuthor());
        if (getPic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPic());
        }
        if (getMessageSource() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessageSource());
        }
        if (getUserAgent() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUserAgent());
        }
        if (getUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUrl());
        }
        if (getFetchType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getFetchType());
        }
        parcel.writeList(getReplyRows());
        parcel.writeInt(getReplyRowsCount());
        parcel.writeInt(getReplyRowsMore());
        if (getParentReplyId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getParentReplyId());
        }
        if (getSpamReason() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSpamReason());
        }
        if (getSpamContent() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSpamContent());
        }
        parcel.writeParcelable(getLikeUserInfo(), i);
        parcel.writeInt(getLikeNum());
        if (getInfoHtml() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getInfoHtml());
        }
        parcel.writeInt(getIsFolded());
        parcel.writeInt(getBlockStatus());
        parcel.writeInt(getStatus());
        parcel.writeInt(getMessageStatus());
        if (getStatusText() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getStatusText());
        }
        if (getMessageStatusText() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessageStatusText());
        }
        if (getBlockStatusText() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getBlockStatusText());
        }
        if (getExtraTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraTitle());
        }
        if (getExtraType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraType());
        }
        if (getExtraPic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraPic());
        }
        if (getExtraUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraUrl());
        }
        parcel.writeParcelable(getUserAction(), i);
        parcel.writeLong(getSpamTime());
        if (getLikeUserName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLikeUserName());
        }
        if (getLikeUid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLikeUid());
        }
        parcel.writeLong(getLikeTime());
        if (getAdminInfo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getAdminInfo());
        }
        if (getLikeAvatar() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLikeAvatar());
        }
        if (getExtraFlag() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraFlag());
        }
        parcel.writeParcelable(getReplyFeed(), i);
        parcel.writeParcelable(getReplyArticle(), i);
        parcel.writeParcelable(getInnerInfo(), i);
    }
}
