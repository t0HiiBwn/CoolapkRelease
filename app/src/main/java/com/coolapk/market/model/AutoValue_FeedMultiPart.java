package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_FeedMultiPart extends C$AutoValue_FeedMultiPart {
    public static final Parcelable.Creator<AutoValue_FeedMultiPart> CREATOR = new Parcelable.Creator<AutoValue_FeedMultiPart>() {
        /* class com.coolapk.market.model.AutoValue_FeedMultiPart.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedMultiPart createFromParcel(Parcel parcel) {
            return new AutoValue_FeedMultiPart(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() == 1, parcel.readArrayList(ImageUrl.class.getClassLoader()), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readString(), parcel.readInt() == 1, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt() == 1, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readArrayList(String.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readArrayList(String.class.getClassLoader()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 1, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedMultiPart[] newArray(int i) {
            return new AutoValue_FeedMultiPart[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_FeedMultiPart(String str, int i, String str2, String str3, boolean z, List<ImageUrl> list, String str4, int i2, String str5, String str6, double d, double d2, String str7, int i3, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, boolean z2, boolean z3, boolean z4, boolean z5, String str18, boolean z6, String str19, String str20, String str21, int i4, String str22, String str23, String str24, int i5, String str25, int i6, boolean z7, int i7, String str26, String str27, String str28, int i8, String str29, String str30, String str31, String str32, int i9, int i10, long j, int i11, int i12, List<String> list2, String str33, String str34, List<String> list3, int i13, int i14, int i15, int i16, String str35, String str36, String str37, String str38, String str39, String str40, boolean z8, int i17) {
        super(str, i, str2, str3, z, list, str4, i2, str5, str6, d, d2, str7, i3, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, z2, z3, z4, z5, str18, z6, str19, str20, str21, i4, str22, str23, str24, i5, str25, i6, z7, i7, str26, str27, str28, i8, str29, str30, str31, str32, i9, i10, j, i11, i12, list2, str33, str34, list3, i13, i14, i15, i16, str35, str36, str37, str38, str39, str40, z8, i17);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id());
        parcel.writeInt(version());
        parcel.writeString(message());
        parcel.writeString(type());
        parcel.writeInt(isHtmlArticle() ? 1 : 0);
        parcel.writeList(imageUriList());
        parcel.writeString(pic());
        parcel.writeInt(visibleStatus());
        parcel.writeString(location());
        parcel.writeString(longLocation());
        parcel.writeDouble(latitude());
        parcel.writeDouble(longitude());
        parcel.writeString(mediaUrl());
        parcel.writeInt(mediaType());
        parcel.writeString(mediaPic());
        parcel.writeString(messageTitle());
        parcel.writeString(messageBrief());
        parcel.writeString(extraTitle());
        parcel.writeString(extraUrl());
        parcel.writeString(extraKey());
        parcel.writeString(extraPic());
        parcel.writeString(extraInfo());
        parcel.writeString(messageCover());
        parcel.writeString(dyhId());
        parcel.writeInt(isDisallowRepost() ? 1 : 0);
        parcel.writeInt(isAnonymous() ? 1 : 0);
        parcel.writeInt(isDisallowReply() ? 1 : 0);
        parcel.writeInt(isEditInDyh() ? 1 : 0);
        parcel.writeString(forwardId());
        parcel.writeInt(isReplyWithForward() ? 1 : 0);
        parcel.writeString(feedId());
        parcel.writeString(targetType());
        parcel.writeString(targetId());
        parcel.writeInt(voteScore());
        parcel.writeString(uploadDir());
        parcel.writeString(locationCity());
        parcel.writeString(locationCountry());
        parcel.writeInt(compressFlag());
        parcel.writeString(mediaInfo());
        parcel.writeInt(ratingScore1());
        parcel.writeInt(insertProductMedia() ? 1 : 0);
        parcel.writeInt(secondHandType());
        parcel.writeString(secondHandOutLink());
        parcel.writeString(secondHandPrice());
        parcel.writeString(secondHandSthType());
        parcel.writeInt(agree());
        parcel.writeString(productConfig());
        parcel.writeString(productId());
        parcel.writeString(province());
        parcel.writeString(cityCode());
        parcel.writeInt(voteType());
        parcel.writeInt(voteAnonymousStatus());
        parcel.writeLong(voteEndTime());
        parcel.writeInt(voteMinSelectNum());
        parcel.writeInt(voteMaxSelectNum());
        parcel.writeList(voteOptions());
        parcel.writeString(voteTag());
        parcel.writeString(votePage());
        parcel.writeList(voteOptionColors());
        parcel.writeInt(voteShowAuthor());
        parcel.writeInt(secondHandDealType());
        parcel.writeInt(secondHandFaceDeal());
        parcel.writeInt(risePriceType());
        parcel.writeString(commentGood());
        parcel.writeString(commentGoodPic());
        parcel.writeString(commentBad());
        parcel.writeString(commentBadPic());
        parcel.writeString(commentGeneral());
        parcel.writeString(commentGeneralPic());
        parcel.writeInt(buyStatus() ? 1 : 0);
        parcel.writeInt(categoryId());
    }
}
