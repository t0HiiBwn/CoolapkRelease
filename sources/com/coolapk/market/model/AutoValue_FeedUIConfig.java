package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_FeedUIConfig extends C$AutoValue_FeedUIConfig {
    public static final Parcelable.Creator<AutoValue_FeedUIConfig> CREATOR = new Parcelable.Creator<AutoValue_FeedUIConfig>() {
        /* class com.coolapk.market.model.AutoValue_FeedUIConfig.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedUIConfig createFromParcel(Parcel parcel) {
            return new AutoValue_FeedUIConfig(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, (Entity) parcel.readParcelable(Entity.class.getClassLoader()), parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readString(), parcel.readString(), parcel.readInt() == 1, parcel.readString(), parcel.readInt() == 1, parcel.readInt(), parcel.readInt(), parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt(), parcel.readInt() == 1, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readArrayList(ProductParams.class.getClassLoader()), parcel.readInt(), parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readArrayList(Entity.class.getClassLoader()), (FeedGoods) parcel.readParcelable(FeedGoods.class.getClassLoader()), parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1);
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedUIConfig[] newArray(int i) {
            return new AutoValue_FeedUIConfig[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_FeedUIConfig(int i, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Entity entity, boolean z8, boolean z9, String str3, String str4, String str5, String str6, int i2, int i3, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, String str7, int i4, String str8, boolean z17, boolean z18, boolean z19, boolean z20, boolean z21, boolean z22, boolean z23, String str9, String str10, boolean z24, String str11, boolean z25, int i5, int i6, boolean z26, boolean z27, boolean z28, String str12, String str13, String str14, String str15, String str16, String str17, String str18, boolean z29, boolean z30, boolean z31, boolean z32, int i7, boolean z33, int i8, String str19, String str20, boolean z34, boolean z35, List<ProductParams> list, int i9, boolean z36, boolean z37, boolean z38, List<Entity> list2, FeedGoods feedGoods, boolean z39, boolean z40, boolean z41, boolean z42, boolean z43) {
        super(i, str, str2, z, z2, z3, z4, z5, z6, z7, entity, z8, z9, str3, str4, str5, str6, i2, i3, z10, z11, z12, z13, z14, z15, z16, str7, i4, str8, z17, z18, z19, z20, z21, z22, z23, str9, str10, z24, str11, z25, i5, i6, z26, z27, z28, str12, str13, str14, str15, str16, str17, str18, z29, z30, z31, z32, i7, z33, i8, str19, str20, z34, z35, list, i9, z36, z37, z38, list2, feedGoods, z39, z40, z41, z42, z43);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(version());
        parcel.writeString(title());
        parcel.writeString(subtitle());
        parcel.writeInt(isRatingBarVisible() ? 1 : 0);
        parcel.writeInt(isRatingBarBackgroundVisible() ? 1 : 0);
        parcel.writeInt(isLocationViewVisible() ? 1 : 0);
        parcel.writeInt(isSwitchArticleViewVisible() ? 1 : 0);
        parcel.writeInt(isSecondHandViewVisible() ? 1 : 0);
        parcel.writeInt(isPublicViewVisible() ? 1 : 0);
        parcel.writeInt(isForward() ? 1 : 0);
        parcel.writeParcelable(forwardEntity(), i);
        parcel.writeInt(isForwardAndCommentViewVisible() ? 1 : 0);
        parcel.writeInt(isExtraViewVisible() ? 1 : 0);
        if (extraViewLogoUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(extraViewLogoUrl());
        }
        if (extraViewTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(extraViewTitle());
        }
        if (extraViewContent() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(extraViewContent());
        }
        if (secondHandPrice() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(secondHandPrice());
        }
        parcel.writeInt(risePriceType());
        parcel.writeInt(secondHandFaceDeal());
        parcel.writeInt(isCoolPicCategoryBarVisible() ? 1 : 0);
        parcel.writeInt(isAnonymousAnswerBarVisible() ? 1 : 0);
        parcel.writeInt(isSubmitTargetBarVisible() ? 1 : 0);
        parcel.writeInt(isAnonymousQuestionViewVisible() ? 1 : 0);
        parcel.writeInt(isEditCoverViewVisible() ? 1 : 0);
        parcel.writeInt(isEditTitleViewVisible() ? 1 : 0);
        parcel.writeInt(isEditTextViewVisible() ? 1 : 0);
        if (editTitleHint() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(editTitleHint());
        }
        parcel.writeInt(editTitleMaxLength());
        if (editTextHint() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(editTextHint());
        }
        parcel.writeInt(isAddApkItemVisible() ? 1 : 0);
        parcel.writeInt(isAddExtraItemVisible() ? 1 : 0);
        parcel.writeInt(isRichTextItemVisible() ? 1 : 0);
        parcel.writeInt(isPickPhotoItemVisible() ? 1 : 0);
        parcel.writeInt(isPickPhotoContainerVisible() ? 1 : 0);
        parcel.writeInt(isShareAppItemVisible() ? 1 : 0);
        parcel.writeInt(isMenuItemEnabled() ? 1 : 0);
        parcel.writeString(submitText());
        parcel.writeString(submitToText());
        parcel.writeInt(isSubmitToViewVisible() ? 1 : 0);
        parcel.writeString(locationName());
        parcel.writeInt(tintMarkView() ? 1 : 0);
        parcel.writeInt(visibleState());
        parcel.writeInt(extraLinkType());
        parcel.writeInt(isForwardAndReplyChecked() ? 1 : 0);
        parcel.writeInt(isRemoveExtraViewVisible() ? 1 : 0);
        parcel.writeInt(isShowInArticleMode() ? 1 : 0);
        parcel.writeString(relativeLogo());
        parcel.writeString(relativeTitle());
        parcel.writeString(commentBoardTip1());
        parcel.writeString(commentBoardTip2());
        parcel.writeString(dyhTitle());
        parcel.writeString(topicTitle());
        parcel.writeString(questionTitle());
        parcel.writeInt(isPreviewable() ? 1 : 0);
        parcel.writeInt(canAddVideo() ? 1 : 0);
        parcel.writeInt(canAddMusic() ? 1 : 0);
        parcel.writeInt(addPhotoMenuEnable() ? 1 : 0);
        parcel.writeInt(maxPickPhotoCount());
        parcel.writeInt(openKeyboardWhenInit() ? 1 : 0);
        parcel.writeInt(secondHandType());
        if (secondHandOutLink() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(secondHandOutLink());
        }
        if (productConfigShowText() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(productConfigShowText());
        }
        parcel.writeInt(showParamsItem() ? 1 : 0);
        parcel.writeInt(fromPhoneBaToSecondHand() ? 1 : 0);
        parcel.writeList(productConfigCacheList());
        parcel.writeInt(secondHandDealType());
        parcel.writeInt(isProductPicked() ? 1 : 0);
        parcel.writeInt(isRatingTextCollapsed() ? 1 : 0);
        parcel.writeInt(relativeInfoPickable() ? 1 : 0);
        parcel.writeList(extraEntities());
        parcel.writeParcelable(feedGoods(), i);
        parcel.writeInt(isFeedGoodsClosable() ? 1 : 0);
        parcel.writeInt(canUpdateVoteMode() ? 1 : 0);
        parcel.writeInt(canUpdateVoteTime() ? 1 : 0);
        parcel.writeInt(isFeedTargetPhoneOrTablet() ? 1 : 0);
        parcel.writeInt(isShowAddGoodsInMenuBar() ? 1 : 0);
    }
}
