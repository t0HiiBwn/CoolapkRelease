package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_ServiceApp extends C$AutoValue_ServiceApp {
    public static final Parcelable.Creator<AutoValue_ServiceApp> CREATOR = new Parcelable.Creator<AutoValue_ServiceApp>() {
        /* class com.coolapk.market.model.AutoValue_ServiceApp.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_ServiceApp createFromParcel(Parcel parcel) {
            return new AutoValue_ServiceApp(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readFloat(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(String.class.getClassLoader()), parcel.readArrayList(String.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readArrayList(Gift.class.getClassLoader()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (UserAction) parcel.readParcelable(UserAction.class.getClassLoader()), parcel.readArrayList(RelatedData.class.getClassLoader()), parcel.readArrayList(RelatedData.class.getClassLoader()), parcel.readArrayList(User.class.getClassLoader()), parcel.readArrayList(RelatedData.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(String.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(String.class.getClassLoader()), parcel.readArrayList(ServiceApp.class.getClassLoader()), parcel.readArrayList(ServiceApp.class.getClassLoader()), parcel.readArrayList(Album.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), (User) parcel.readParcelable(User.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readArrayList(MenuCard.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), (Collection) parcel.readParcelable(Collection.class.getClassLoader()), (CollectionItem) parcel.readParcelable(CollectionItem.class.getClassLoader()), parcel.readInt() == 1, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(CouponInfo.class.getClassLoader()), parcel.readArrayList(ConfigPage.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(NewHeadLine.class.getClassLoader()), parcel.readArrayList(String.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null);
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_ServiceApp[] newArray(int i) {
            return new AutoValue_ServiceApp[i];
        }
    };

    AutoValue_ServiceApp(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, Long l2, Long l3, String str9, String str10, String str11, String str12, String str13, String str14, int i, String str15, long j, long j2, String str16, String str17, int i2, int i3, String str18, String str19, String str20, String str21, String str22, String str23, float f, String str24, String str25, String str26, String str27, List<String> list, List<String> list2, String str28, String str29, String str30, String str31, int i4, String str32, int i5, List<Gift> list3, int i6, int i7, int i8, int i9, int i10, int i11, UserAction userAction, List<RelatedData> list4, List<RelatedData> list5, List<User> list6, List<RelatedData> list7, String str33, String str34, List<String> list8, String str35, String str36, List<String> list9, List<ServiceApp> list10, List<ServiceApp> list11, List<Album> list12, String str37, int i12, User user, String str38, String str39, String str40, int i13, List<MenuCard> list13, String str41, int i14, int i15, int i16, Collection collection, CollectionItem collectionItem, boolean z, String str42, String str43, List<CouponInfo> list14, List<ConfigPage> list15, String str44, int i17, String str45, String str46, List<NewHeadLine> list16, List<String> list17, String str47) {
        super(str, str2, num, str3, str4, str5, str6, str7, str8, l2, l3, str9, str10, str11, str12, str13, str14, i, str15, j, j2, str16, str17, i2, i3, str18, str19, str20, str21, str22, str23, f, str24, str25, str26, str27, list, list2, str28, str29, str30, str31, i4, str32, i5, list3, i6, i7, i8, i9, i10, i11, userAction, list4, list5, list6, list7, str33, str34, list8, str35, str36, list9, list10, list11, list12, str37, i12, user, str38, str39, str40, i13, list13, str41, i14, i15, i16, collection, collectionItem, z, str42, str43, list14, list15, str44, i17, str45, str46, list16, list17, str47);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
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
        if (getEntityTypeName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityTypeName());
        }
        if (getPackageName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPackageName());
        }
        if (getTargetId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTargetId());
        }
        if (getApkType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getApkType());
        }
        parcel.writeString(getDisplayVersionName());
        parcel.writeString(getVersionName());
        parcel.writeInt(getVersionCode());
        parcel.writeString(getApkSize());
        parcel.writeLong(getPublicUpdate());
        parcel.writeLong(getApkLength());
        if (getExtraFlag() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraFlag());
        }
        parcel.writeString(getDescription());
        parcel.writeInt(getRecommend());
        parcel.writeInt(getDigest());
        if (getChangeLog() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getChangeLog());
        }
        parcel.writeString(getLogo());
        if (getCover() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCover());
        }
        if (getFollowCount() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getFollowCount());
        }
        if (getCommentCount() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCommentCount());
        }
        if (getDownCount() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDownCount());
        }
        parcel.writeFloat(getRatingStar());
        if (getScore() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getScore());
        }
        if (getUpdateFlag() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUpdateFlag());
        }
        if (getAppName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getAppName());
        }
        if (getApkRomVersion() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getApkRomVersion());
        }
        parcel.writeList(getThumbList());
        parcel.writeList(getScreenList());
        if (getIntroduce() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getIntroduce());
        }
        if (getLoginUserRate() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLoginUserRate());
        }
        if (getRemark() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getRemark());
        }
        if (getReviewer() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getReviewer());
        }
        parcel.writeInt(getSupportAndroidVersion());
        if (getLanguage() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLanguage());
        }
        parcel.writeInt(getGiftCount());
        parcel.writeList(getGiftRows());
        parcel.writeInt(getVotenum());
        parcel.writeInt(getVotenum1());
        parcel.writeInt(getVotenum2());
        parcel.writeInt(getVotenum3());
        parcel.writeInt(getVotenum4());
        parcel.writeInt(getVotenum5());
        parcel.writeParcelable(getUserAction(), i);
        parcel.writeList(getDiscoveryRows());
        parcel.writeList(getFollowerRows());
        parcel.writeList(getRecentFollowList());
        parcel.writeList(getRatingRows());
        if (getCategoryId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCategoryId());
        }
        if (getCategoryName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCategoryName());
        }
        parcel.writeList(getTagList());
        if (getApkUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getApkUrl());
        }
        if (getDeveloperName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDeveloperName());
        }
        parcel.writeList(getPermissions());
        parcel.writeList(getDeveloperRows());
        parcel.writeList(getRelatedRows());
        parcel.writeList(getAlbumRows());
        if (getKeywords() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getKeywords());
        }
        parcel.writeInt(getUpDown());
        parcel.writeParcelable(getDeveloperProfile(), i);
        if (getExtendFile() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtendFile());
        }
        if (getExtendName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtendName());
        }
        if (getChangeHistory() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getChangeHistory());
        }
        parcel.writeInt(getCommentBlockNum());
        parcel.writeList(getMenuCards());
        if (getExtraAnalysisData() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraAnalysisData());
        }
        parcel.writeInt(getIsDownloadApp());
        parcel.writeInt(getIsForumApp());
        parcel.writeInt(getCommentStatus());
        parcel.writeParcelable(getCollectionInfo(), i);
        parcel.writeParcelable(getCollectionItem(), i);
        parcel.writeInt(getHasCoupon() ? 1 : 0);
        if (getExtraFromApi() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraFromApi());
        }
        if (getApkSubTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getApkSubTitle());
        }
        parcel.writeList(getCouponInfo());
        parcel.writeList(getTabApiList());
        if (getSelectedTab() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSelectedTab());
        }
        parcel.writeInt(getHotNum());
        if (getBgColor() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getBgColor());
        }
        if (getRequestContext() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getRequestContext());
        }
        parcel.writeList(getRecommendRows());
        parcel.writeList(getTopIds());
        if (getOpenLink() == null) {
            parcel.writeInt(1);
            return;
        }
        parcel.writeInt(0);
        parcel.writeString(getOpenLink());
    }
}
