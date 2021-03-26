package com.coolapk.market.model;

import com.coolapk.market.model.FeedUIConfig;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_FeedUIConfig  reason: invalid class name */
abstract class C$AutoValue_FeedUIConfig extends FeedUIConfig {
    private final boolean addPhotoMenuEnable;
    private final boolean canAddMusic;
    private final boolean canAddVideo;
    private final boolean canUpdateVoteMode;
    private final boolean canUpdateVoteTime;
    private final String commentBoardTip1;
    private final String commentBoardTip2;
    private final String dyhTitle;
    private final String editTextHint;
    private final String editTitleHint;
    private final int editTitleMaxLength;
    private final List<Entity> extraEntities;
    private final int extraLinkType;
    private final String extraViewContent;
    private final String extraViewLogoUrl;
    private final String extraViewTitle;
    private final FeedGoods feedGoods;
    private final Entity forwardEntity;
    private final boolean fromPhoneBaToSecondHand;
    private final boolean isAddApkItemVisible;
    private final boolean isAddExtraItemVisible;
    private final boolean isAnonymousAnswerBarVisible;
    private final boolean isAnonymousQuestionViewVisible;
    private final boolean isCoolPicCategoryBarVisible;
    private final boolean isEditCoverViewVisible;
    private final boolean isEditTextViewVisible;
    private final boolean isEditTitleViewVisible;
    private final boolean isExtraViewVisible;
    private final boolean isFeedGoodsClosable;
    private final boolean isFeedTargetPhoneOrTablet;
    private final boolean isForward;
    private final boolean isForwardAndCommentViewVisible;
    private final boolean isForwardAndReplyChecked;
    private final boolean isLocationViewVisible;
    private final boolean isMenuItemEnabled;
    private final boolean isPickPhotoContainerVisible;
    private final boolean isPickPhotoItemVisible;
    private final boolean isPreviewable;
    private final boolean isProductPicked;
    private final boolean isPublicViewVisible;
    private final boolean isRatingBarBackgroundVisible;
    private final boolean isRatingBarVisible;
    private final boolean isRatingTextCollapsed;
    private final boolean isRemoveExtraViewVisible;
    private final boolean isRichTextItemVisible;
    private final boolean isSecondHandViewVisible;
    private final boolean isShareAppItemVisible;
    private final boolean isShowAddGoodsInMenuBar;
    private final boolean isShowInArticleMode;
    private final boolean isSubmitTargetBarVisible;
    private final boolean isSubmitToViewVisible;
    private final boolean isSwitchArticleViewVisible;
    private final String locationName;
    private final int maxPickPhotoCount;
    private final boolean openKeyboardWhenInit;
    private final List<ProductParams> productConfigCacheList;
    private final String productConfigShowText;
    private final String questionTitle;
    private final boolean relativeInfoPickable;
    private final String relativeLogo;
    private final String relativeTitle;
    private final int risePriceType;
    private final int secondHandDealType;
    private final int secondHandFaceDeal;
    private final String secondHandOutLink;
    private final String secondHandPrice;
    private final int secondHandType;
    private final boolean showParamsItem;
    private final String submitText;
    private final String submitToText;
    private final String subtitle;
    private final boolean tintMarkView;
    private final String title;
    private final String topicTitle;
    private final int version;
    private final int visibleState;

    C$AutoValue_FeedUIConfig(int i, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Entity entity, boolean z8, boolean z9, String str3, String str4, String str5, String str6, int i2, int i3, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, String str7, int i4, String str8, boolean z17, boolean z18, boolean z19, boolean z20, boolean z21, boolean z22, boolean z23, String str9, String str10, boolean z24, String str11, boolean z25, int i5, int i6, boolean z26, boolean z27, boolean z28, String str12, String str13, String str14, String str15, String str16, String str17, String str18, boolean z29, boolean z30, boolean z31, boolean z32, int i7, boolean z33, int i8, String str19, String str20, boolean z34, boolean z35, List<ProductParams> list, int i9, boolean z36, boolean z37, boolean z38, List<Entity> list2, FeedGoods feedGoods2, boolean z39, boolean z40, boolean z41, boolean z42, boolean z43) {
        this.version = i;
        Objects.requireNonNull(str, "Null title");
        this.title = str;
        Objects.requireNonNull(str2, "Null subtitle");
        this.subtitle = str2;
        this.isRatingBarVisible = z;
        this.isRatingBarBackgroundVisible = z2;
        this.isLocationViewVisible = z3;
        this.isSwitchArticleViewVisible = z4;
        this.isSecondHandViewVisible = z5;
        this.isPublicViewVisible = z6;
        this.isForward = z7;
        this.forwardEntity = entity;
        this.isForwardAndCommentViewVisible = z8;
        this.isExtraViewVisible = z9;
        this.extraViewLogoUrl = str3;
        this.extraViewTitle = str4;
        this.extraViewContent = str5;
        this.secondHandPrice = str6;
        this.risePriceType = i2;
        this.secondHandFaceDeal = i3;
        this.isCoolPicCategoryBarVisible = z10;
        this.isAnonymousAnswerBarVisible = z11;
        this.isSubmitTargetBarVisible = z12;
        this.isAnonymousQuestionViewVisible = z13;
        this.isEditCoverViewVisible = z14;
        this.isEditTitleViewVisible = z15;
        this.isEditTextViewVisible = z16;
        this.editTitleHint = str7;
        this.editTitleMaxLength = i4;
        this.editTextHint = str8;
        this.isAddApkItemVisible = z17;
        this.isAddExtraItemVisible = z18;
        this.isRichTextItemVisible = z19;
        this.isPickPhotoItemVisible = z20;
        this.isPickPhotoContainerVisible = z21;
        this.isShareAppItemVisible = z22;
        this.isMenuItemEnabled = z23;
        Objects.requireNonNull(str9, "Null submitText");
        this.submitText = str9;
        Objects.requireNonNull(str10, "Null submitToText");
        this.submitToText = str10;
        this.isSubmitToViewVisible = z24;
        Objects.requireNonNull(str11, "Null locationName");
        this.locationName = str11;
        this.tintMarkView = z25;
        this.visibleState = i5;
        this.extraLinkType = i6;
        this.isForwardAndReplyChecked = z26;
        this.isRemoveExtraViewVisible = z27;
        this.isShowInArticleMode = z28;
        Objects.requireNonNull(str12, "Null relativeLogo");
        this.relativeLogo = str12;
        Objects.requireNonNull(str13, "Null relativeTitle");
        this.relativeTitle = str13;
        Objects.requireNonNull(str14, "Null commentBoardTip1");
        this.commentBoardTip1 = str14;
        Objects.requireNonNull(str15, "Null commentBoardTip2");
        this.commentBoardTip2 = str15;
        Objects.requireNonNull(str16, "Null dyhTitle");
        this.dyhTitle = str16;
        Objects.requireNonNull(str17, "Null topicTitle");
        this.topicTitle = str17;
        Objects.requireNonNull(str18, "Null questionTitle");
        this.questionTitle = str18;
        this.isPreviewable = z29;
        this.canAddVideo = z30;
        this.canAddMusic = z31;
        this.addPhotoMenuEnable = z32;
        this.maxPickPhotoCount = i7;
        this.openKeyboardWhenInit = z33;
        this.secondHandType = i8;
        this.secondHandOutLink = str19;
        this.productConfigShowText = str20;
        this.showParamsItem = z34;
        this.fromPhoneBaToSecondHand = z35;
        Objects.requireNonNull(list, "Null productConfigCacheList");
        this.productConfigCacheList = list;
        this.secondHandDealType = i9;
        this.isProductPicked = z36;
        this.isRatingTextCollapsed = z37;
        this.relativeInfoPickable = z38;
        Objects.requireNonNull(list2, "Null extraEntities");
        this.extraEntities = list2;
        this.feedGoods = feedGoods2;
        this.isFeedGoodsClosable = z39;
        this.canUpdateVoteMode = z40;
        this.canUpdateVoteTime = z41;
        this.isFeedTargetPhoneOrTablet = z42;
        this.isShowAddGoodsInMenuBar = z43;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public int version() {
        return this.version;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String title() {
        return this.title;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String subtitle() {
        return this.subtitle;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isRatingBarVisible() {
        return this.isRatingBarVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isRatingBarBackgroundVisible() {
        return this.isRatingBarBackgroundVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isLocationViewVisible() {
        return this.isLocationViewVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isSwitchArticleViewVisible() {
        return this.isSwitchArticleViewVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isSecondHandViewVisible() {
        return this.isSecondHandViewVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isPublicViewVisible() {
        return this.isPublicViewVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isForward() {
        return this.isForward;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public Entity forwardEntity() {
        return this.forwardEntity;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isForwardAndCommentViewVisible() {
        return this.isForwardAndCommentViewVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isExtraViewVisible() {
        return this.isExtraViewVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String extraViewLogoUrl() {
        return this.extraViewLogoUrl;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String extraViewTitle() {
        return this.extraViewTitle;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String extraViewContent() {
        return this.extraViewContent;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String secondHandPrice() {
        return this.secondHandPrice;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public int risePriceType() {
        return this.risePriceType;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public int secondHandFaceDeal() {
        return this.secondHandFaceDeal;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isCoolPicCategoryBarVisible() {
        return this.isCoolPicCategoryBarVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isAnonymousAnswerBarVisible() {
        return this.isAnonymousAnswerBarVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isSubmitTargetBarVisible() {
        return this.isSubmitTargetBarVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isAnonymousQuestionViewVisible() {
        return this.isAnonymousQuestionViewVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isEditCoverViewVisible() {
        return this.isEditCoverViewVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isEditTitleViewVisible() {
        return this.isEditTitleViewVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isEditTextViewVisible() {
        return this.isEditTextViewVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String editTitleHint() {
        return this.editTitleHint;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public int editTitleMaxLength() {
        return this.editTitleMaxLength;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String editTextHint() {
        return this.editTextHint;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isAddApkItemVisible() {
        return this.isAddApkItemVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isAddExtraItemVisible() {
        return this.isAddExtraItemVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isRichTextItemVisible() {
        return this.isRichTextItemVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isPickPhotoItemVisible() {
        return this.isPickPhotoItemVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isPickPhotoContainerVisible() {
        return this.isPickPhotoContainerVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isShareAppItemVisible() {
        return this.isShareAppItemVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isMenuItemEnabled() {
        return this.isMenuItemEnabled;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String submitText() {
        return this.submitText;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String submitToText() {
        return this.submitToText;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isSubmitToViewVisible() {
        return this.isSubmitToViewVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String locationName() {
        return this.locationName;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean tintMarkView() {
        return this.tintMarkView;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public int visibleState() {
        return this.visibleState;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public int extraLinkType() {
        return this.extraLinkType;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isForwardAndReplyChecked() {
        return this.isForwardAndReplyChecked;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isRemoveExtraViewVisible() {
        return this.isRemoveExtraViewVisible;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isShowInArticleMode() {
        return this.isShowInArticleMode;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String relativeLogo() {
        return this.relativeLogo;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String relativeTitle() {
        return this.relativeTitle;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String commentBoardTip1() {
        return this.commentBoardTip1;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String commentBoardTip2() {
        return this.commentBoardTip2;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String dyhTitle() {
        return this.dyhTitle;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String topicTitle() {
        return this.topicTitle;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String questionTitle() {
        return this.questionTitle;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isPreviewable() {
        return this.isPreviewable;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean canAddVideo() {
        return this.canAddVideo;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean canAddMusic() {
        return this.canAddMusic;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean addPhotoMenuEnable() {
        return this.addPhotoMenuEnable;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public int maxPickPhotoCount() {
        return this.maxPickPhotoCount;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean openKeyboardWhenInit() {
        return this.openKeyboardWhenInit;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public int secondHandType() {
        return this.secondHandType;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String secondHandOutLink() {
        return this.secondHandOutLink;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public String productConfigShowText() {
        return this.productConfigShowText;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean showParamsItem() {
        return this.showParamsItem;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean fromPhoneBaToSecondHand() {
        return this.fromPhoneBaToSecondHand;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public List<ProductParams> productConfigCacheList() {
        return this.productConfigCacheList;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public int secondHandDealType() {
        return this.secondHandDealType;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isProductPicked() {
        return this.isProductPicked;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isRatingTextCollapsed() {
        return this.isRatingTextCollapsed;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean relativeInfoPickable() {
        return this.relativeInfoPickable;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public List<Entity> extraEntities() {
        return this.extraEntities;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public FeedGoods feedGoods() {
        return this.feedGoods;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isFeedGoodsClosable() {
        return this.isFeedGoodsClosable;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean canUpdateVoteMode() {
        return this.canUpdateVoteMode;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean canUpdateVoteTime() {
        return this.canUpdateVoteTime;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isFeedTargetPhoneOrTablet() {
        return this.isFeedTargetPhoneOrTablet;
    }

    @Override // com.coolapk.market.model.FeedUIConfig
    public boolean isShowAddGoodsInMenuBar() {
        return this.isShowAddGoodsInMenuBar;
    }

    @Override // java.lang.Object
    public String toString() {
        return "FeedUIConfig{version=" + this.version + ", title=" + this.title + ", subtitle=" + this.subtitle + ", isRatingBarVisible=" + this.isRatingBarVisible + ", isRatingBarBackgroundVisible=" + this.isRatingBarBackgroundVisible + ", isLocationViewVisible=" + this.isLocationViewVisible + ", isSwitchArticleViewVisible=" + this.isSwitchArticleViewVisible + ", isSecondHandViewVisible=" + this.isSecondHandViewVisible + ", isPublicViewVisible=" + this.isPublicViewVisible + ", isForward=" + this.isForward + ", forwardEntity=" + this.forwardEntity + ", isForwardAndCommentViewVisible=" + this.isForwardAndCommentViewVisible + ", isExtraViewVisible=" + this.isExtraViewVisible + ", extraViewLogoUrl=" + this.extraViewLogoUrl + ", extraViewTitle=" + this.extraViewTitle + ", extraViewContent=" + this.extraViewContent + ", secondHandPrice=" + this.secondHandPrice + ", risePriceType=" + this.risePriceType + ", secondHandFaceDeal=" + this.secondHandFaceDeal + ", isCoolPicCategoryBarVisible=" + this.isCoolPicCategoryBarVisible + ", isAnonymousAnswerBarVisible=" + this.isAnonymousAnswerBarVisible + ", isSubmitTargetBarVisible=" + this.isSubmitTargetBarVisible + ", isAnonymousQuestionViewVisible=" + this.isAnonymousQuestionViewVisible + ", isEditCoverViewVisible=" + this.isEditCoverViewVisible + ", isEditTitleViewVisible=" + this.isEditTitleViewVisible + ", isEditTextViewVisible=" + this.isEditTextViewVisible + ", editTitleHint=" + this.editTitleHint + ", editTitleMaxLength=" + this.editTitleMaxLength + ", editTextHint=" + this.editTextHint + ", isAddApkItemVisible=" + this.isAddApkItemVisible + ", isAddExtraItemVisible=" + this.isAddExtraItemVisible + ", isRichTextItemVisible=" + this.isRichTextItemVisible + ", isPickPhotoItemVisible=" + this.isPickPhotoItemVisible + ", isPickPhotoContainerVisible=" + this.isPickPhotoContainerVisible + ", isShareAppItemVisible=" + this.isShareAppItemVisible + ", isMenuItemEnabled=" + this.isMenuItemEnabled + ", submitText=" + this.submitText + ", submitToText=" + this.submitToText + ", isSubmitToViewVisible=" + this.isSubmitToViewVisible + ", locationName=" + this.locationName + ", tintMarkView=" + this.tintMarkView + ", visibleState=" + this.visibleState + ", extraLinkType=" + this.extraLinkType + ", isForwardAndReplyChecked=" + this.isForwardAndReplyChecked + ", isRemoveExtraViewVisible=" + this.isRemoveExtraViewVisible + ", isShowInArticleMode=" + this.isShowInArticleMode + ", relativeLogo=" + this.relativeLogo + ", relativeTitle=" + this.relativeTitle + ", commentBoardTip1=" + this.commentBoardTip1 + ", commentBoardTip2=" + this.commentBoardTip2 + ", dyhTitle=" + this.dyhTitle + ", topicTitle=" + this.topicTitle + ", questionTitle=" + this.questionTitle + ", isPreviewable=" + this.isPreviewable + ", canAddVideo=" + this.canAddVideo + ", canAddMusic=" + this.canAddMusic + ", addPhotoMenuEnable=" + this.addPhotoMenuEnable + ", maxPickPhotoCount=" + this.maxPickPhotoCount + ", openKeyboardWhenInit=" + this.openKeyboardWhenInit + ", secondHandType=" + this.secondHandType + ", secondHandOutLink=" + this.secondHandOutLink + ", productConfigShowText=" + this.productConfigShowText + ", showParamsItem=" + this.showParamsItem + ", fromPhoneBaToSecondHand=" + this.fromPhoneBaToSecondHand + ", productConfigCacheList=" + this.productConfigCacheList + ", secondHandDealType=" + this.secondHandDealType + ", isProductPicked=" + this.isProductPicked + ", isRatingTextCollapsed=" + this.isRatingTextCollapsed + ", relativeInfoPickable=" + this.relativeInfoPickable + ", extraEntities=" + this.extraEntities + ", feedGoods=" + this.feedGoods + ", isFeedGoodsClosable=" + this.isFeedGoodsClosable + ", canUpdateVoteMode=" + this.canUpdateVoteMode + ", canUpdateVoteTime=" + this.canUpdateVoteTime + ", isFeedTargetPhoneOrTablet=" + this.isFeedTargetPhoneOrTablet + ", isShowAddGoodsInMenuBar=" + this.isShowAddGoodsInMenuBar + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        Entity entity;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        FeedGoods feedGoods2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedUIConfig)) {
            return false;
        }
        FeedUIConfig feedUIConfig = (FeedUIConfig) obj;
        if (this.version == feedUIConfig.version() && this.title.equals(feedUIConfig.title()) && this.subtitle.equals(feedUIConfig.subtitle()) && this.isRatingBarVisible == feedUIConfig.isRatingBarVisible() && this.isRatingBarBackgroundVisible == feedUIConfig.isRatingBarBackgroundVisible() && this.isLocationViewVisible == feedUIConfig.isLocationViewVisible() && this.isSwitchArticleViewVisible == feedUIConfig.isSwitchArticleViewVisible() && this.isSecondHandViewVisible == feedUIConfig.isSecondHandViewVisible() && this.isPublicViewVisible == feedUIConfig.isPublicViewVisible() && this.isForward == feedUIConfig.isForward() && ((entity = this.forwardEntity) != null ? entity.equals(feedUIConfig.forwardEntity()) : feedUIConfig.forwardEntity() == null) && this.isForwardAndCommentViewVisible == feedUIConfig.isForwardAndCommentViewVisible() && this.isExtraViewVisible == feedUIConfig.isExtraViewVisible() && ((str = this.extraViewLogoUrl) != null ? str.equals(feedUIConfig.extraViewLogoUrl()) : feedUIConfig.extraViewLogoUrl() == null) && ((str2 = this.extraViewTitle) != null ? str2.equals(feedUIConfig.extraViewTitle()) : feedUIConfig.extraViewTitle() == null) && ((str3 = this.extraViewContent) != null ? str3.equals(feedUIConfig.extraViewContent()) : feedUIConfig.extraViewContent() == null) && ((str4 = this.secondHandPrice) != null ? str4.equals(feedUIConfig.secondHandPrice()) : feedUIConfig.secondHandPrice() == null) && this.risePriceType == feedUIConfig.risePriceType() && this.secondHandFaceDeal == feedUIConfig.secondHandFaceDeal() && this.isCoolPicCategoryBarVisible == feedUIConfig.isCoolPicCategoryBarVisible() && this.isAnonymousAnswerBarVisible == feedUIConfig.isAnonymousAnswerBarVisible() && this.isSubmitTargetBarVisible == feedUIConfig.isSubmitTargetBarVisible() && this.isAnonymousQuestionViewVisible == feedUIConfig.isAnonymousQuestionViewVisible() && this.isEditCoverViewVisible == feedUIConfig.isEditCoverViewVisible() && this.isEditTitleViewVisible == feedUIConfig.isEditTitleViewVisible() && this.isEditTextViewVisible == feedUIConfig.isEditTextViewVisible() && ((str5 = this.editTitleHint) != null ? str5.equals(feedUIConfig.editTitleHint()) : feedUIConfig.editTitleHint() == null) && this.editTitleMaxLength == feedUIConfig.editTitleMaxLength() && ((str6 = this.editTextHint) != null ? str6.equals(feedUIConfig.editTextHint()) : feedUIConfig.editTextHint() == null) && this.isAddApkItemVisible == feedUIConfig.isAddApkItemVisible() && this.isAddExtraItemVisible == feedUIConfig.isAddExtraItemVisible() && this.isRichTextItemVisible == feedUIConfig.isRichTextItemVisible() && this.isPickPhotoItemVisible == feedUIConfig.isPickPhotoItemVisible() && this.isPickPhotoContainerVisible == feedUIConfig.isPickPhotoContainerVisible() && this.isShareAppItemVisible == feedUIConfig.isShareAppItemVisible() && this.isMenuItemEnabled == feedUIConfig.isMenuItemEnabled() && this.submitText.equals(feedUIConfig.submitText()) && this.submitToText.equals(feedUIConfig.submitToText()) && this.isSubmitToViewVisible == feedUIConfig.isSubmitToViewVisible() && this.locationName.equals(feedUIConfig.locationName()) && this.tintMarkView == feedUIConfig.tintMarkView() && this.visibleState == feedUIConfig.visibleState() && this.extraLinkType == feedUIConfig.extraLinkType() && this.isForwardAndReplyChecked == feedUIConfig.isForwardAndReplyChecked() && this.isRemoveExtraViewVisible == feedUIConfig.isRemoveExtraViewVisible() && this.isShowInArticleMode == feedUIConfig.isShowInArticleMode() && this.relativeLogo.equals(feedUIConfig.relativeLogo()) && this.relativeTitle.equals(feedUIConfig.relativeTitle()) && this.commentBoardTip1.equals(feedUIConfig.commentBoardTip1()) && this.commentBoardTip2.equals(feedUIConfig.commentBoardTip2()) && this.dyhTitle.equals(feedUIConfig.dyhTitle()) && this.topicTitle.equals(feedUIConfig.topicTitle()) && this.questionTitle.equals(feedUIConfig.questionTitle()) && this.isPreviewable == feedUIConfig.isPreviewable() && this.canAddVideo == feedUIConfig.canAddVideo() && this.canAddMusic == feedUIConfig.canAddMusic() && this.addPhotoMenuEnable == feedUIConfig.addPhotoMenuEnable() && this.maxPickPhotoCount == feedUIConfig.maxPickPhotoCount() && this.openKeyboardWhenInit == feedUIConfig.openKeyboardWhenInit() && this.secondHandType == feedUIConfig.secondHandType() && ((str7 = this.secondHandOutLink) != null ? str7.equals(feedUIConfig.secondHandOutLink()) : feedUIConfig.secondHandOutLink() == null) && ((str8 = this.productConfigShowText) != null ? str8.equals(feedUIConfig.productConfigShowText()) : feedUIConfig.productConfigShowText() == null) && this.showParamsItem == feedUIConfig.showParamsItem() && this.fromPhoneBaToSecondHand == feedUIConfig.fromPhoneBaToSecondHand() && this.productConfigCacheList.equals(feedUIConfig.productConfigCacheList()) && this.secondHandDealType == feedUIConfig.secondHandDealType() && this.isProductPicked == feedUIConfig.isProductPicked() && this.isRatingTextCollapsed == feedUIConfig.isRatingTextCollapsed() && this.relativeInfoPickable == feedUIConfig.relativeInfoPickable() && this.extraEntities.equals(feedUIConfig.extraEntities()) && ((feedGoods2 = this.feedGoods) != null ? feedGoods2.equals(feedUIConfig.feedGoods()) : feedUIConfig.feedGoods() == null) && this.isFeedGoodsClosable == feedUIConfig.isFeedGoodsClosable() && this.canUpdateVoteMode == feedUIConfig.canUpdateVoteMode() && this.canUpdateVoteTime == feedUIConfig.canUpdateVoteTime() && this.isFeedTargetPhoneOrTablet == feedUIConfig.isFeedTargetPhoneOrTablet() && this.isShowAddGoodsInMenuBar == feedUIConfig.isShowAddGoodsInMenuBar()) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 1231;
        int hashCode = (((((((((((((((((((this.version ^ 1000003) * 1000003) ^ this.title.hashCode()) * 1000003) ^ this.subtitle.hashCode()) * 1000003) ^ (this.isRatingBarVisible ? 1231 : 1237)) * 1000003) ^ (this.isRatingBarBackgroundVisible ? 1231 : 1237)) * 1000003) ^ (this.isLocationViewVisible ? 1231 : 1237)) * 1000003) ^ (this.isSwitchArticleViewVisible ? 1231 : 1237)) * 1000003) ^ (this.isSecondHandViewVisible ? 1231 : 1237)) * 1000003) ^ (this.isPublicViewVisible ? 1231 : 1237)) * 1000003) ^ (this.isForward ? 1231 : 1237)) * 1000003;
        Entity entity = this.forwardEntity;
        int i2 = 0;
        int hashCode2 = (((((hashCode ^ (entity == null ? 0 : entity.hashCode())) * 1000003) ^ (this.isForwardAndCommentViewVisible ? 1231 : 1237)) * 1000003) ^ (this.isExtraViewVisible ? 1231 : 1237)) * 1000003;
        String str = this.extraViewLogoUrl;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.extraViewTitle;
        int hashCode4 = (hashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.extraViewContent;
        int hashCode5 = (hashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.secondHandPrice;
        int hashCode6 = (((((((((((((((((((hashCode5 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003) ^ this.risePriceType) * 1000003) ^ this.secondHandFaceDeal) * 1000003) ^ (this.isCoolPicCategoryBarVisible ? 1231 : 1237)) * 1000003) ^ (this.isAnonymousAnswerBarVisible ? 1231 : 1237)) * 1000003) ^ (this.isSubmitTargetBarVisible ? 1231 : 1237)) * 1000003) ^ (this.isAnonymousQuestionViewVisible ? 1231 : 1237)) * 1000003) ^ (this.isEditCoverViewVisible ? 1231 : 1237)) * 1000003) ^ (this.isEditTitleViewVisible ? 1231 : 1237)) * 1000003) ^ (this.isEditTextViewVisible ? 1231 : 1237)) * 1000003;
        String str5 = this.editTitleHint;
        int hashCode7 = (((hashCode6 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003) ^ this.editTitleMaxLength) * 1000003;
        String str6 = this.editTextHint;
        int hashCode8 = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode7 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003) ^ (this.isAddApkItemVisible ? 1231 : 1237)) * 1000003) ^ (this.isAddExtraItemVisible ? 1231 : 1237)) * 1000003) ^ (this.isRichTextItemVisible ? 1231 : 1237)) * 1000003) ^ (this.isPickPhotoItemVisible ? 1231 : 1237)) * 1000003) ^ (this.isPickPhotoContainerVisible ? 1231 : 1237)) * 1000003) ^ (this.isShareAppItemVisible ? 1231 : 1237)) * 1000003) ^ (this.isMenuItemEnabled ? 1231 : 1237)) * 1000003) ^ this.submitText.hashCode()) * 1000003) ^ this.submitToText.hashCode()) * 1000003) ^ (this.isSubmitToViewVisible ? 1231 : 1237)) * 1000003) ^ this.locationName.hashCode()) * 1000003) ^ (this.tintMarkView ? 1231 : 1237)) * 1000003) ^ this.visibleState) * 1000003) ^ this.extraLinkType) * 1000003) ^ (this.isForwardAndReplyChecked ? 1231 : 1237)) * 1000003) ^ (this.isRemoveExtraViewVisible ? 1231 : 1237)) * 1000003) ^ (this.isShowInArticleMode ? 1231 : 1237)) * 1000003) ^ this.relativeLogo.hashCode()) * 1000003) ^ this.relativeTitle.hashCode()) * 1000003) ^ this.commentBoardTip1.hashCode()) * 1000003) ^ this.commentBoardTip2.hashCode()) * 1000003) ^ this.dyhTitle.hashCode()) * 1000003) ^ this.topicTitle.hashCode()) * 1000003) ^ this.questionTitle.hashCode()) * 1000003) ^ (this.isPreviewable ? 1231 : 1237)) * 1000003) ^ (this.canAddVideo ? 1231 : 1237)) * 1000003) ^ (this.canAddMusic ? 1231 : 1237)) * 1000003) ^ (this.addPhotoMenuEnable ? 1231 : 1237)) * 1000003) ^ this.maxPickPhotoCount) * 1000003) ^ (this.openKeyboardWhenInit ? 1231 : 1237)) * 1000003) ^ this.secondHandType) * 1000003;
        String str7 = this.secondHandOutLink;
        int hashCode9 = (hashCode8 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.productConfigShowText;
        int hashCode10 = (((((((((((((((((hashCode9 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003) ^ (this.showParamsItem ? 1231 : 1237)) * 1000003) ^ (this.fromPhoneBaToSecondHand ? 1231 : 1237)) * 1000003) ^ this.productConfigCacheList.hashCode()) * 1000003) ^ this.secondHandDealType) * 1000003) ^ (this.isProductPicked ? 1231 : 1237)) * 1000003) ^ (this.isRatingTextCollapsed ? 1231 : 1237)) * 1000003) ^ (this.relativeInfoPickable ? 1231 : 1237)) * 1000003) ^ this.extraEntities.hashCode()) * 1000003;
        FeedGoods feedGoods2 = this.feedGoods;
        if (feedGoods2 != null) {
            i2 = feedGoods2.hashCode();
        }
        int i3 = (((((((((hashCode10 ^ i2) * 1000003) ^ (this.isFeedGoodsClosable ? 1231 : 1237)) * 1000003) ^ (this.canUpdateVoteMode ? 1231 : 1237)) * 1000003) ^ (this.canUpdateVoteTime ? 1231 : 1237)) * 1000003) ^ (this.isFeedTargetPhoneOrTablet ? 1231 : 1237)) * 1000003;
        if (!this.isShowAddGoodsInMenuBar) {
            i = 1237;
        }
        return i3 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_FeedUIConfig$Builder */
    static final class Builder extends FeedUIConfig.Builder {
        private Boolean addPhotoMenuEnable;
        private Boolean canAddMusic;
        private Boolean canAddVideo;
        private Boolean canUpdateVoteMode;
        private Boolean canUpdateVoteTime;
        private String commentBoardTip1;
        private String commentBoardTip2;
        private String dyhTitle;
        private String editTextHint;
        private String editTitleHint;
        private Integer editTitleMaxLength;
        private List<Entity> extraEntities;
        private Integer extraLinkType;
        private String extraViewContent;
        private String extraViewLogoUrl;
        private String extraViewTitle;
        private FeedGoods feedGoods;
        private Entity forwardEntity;
        private Boolean fromPhoneBaToSecondHand;
        private Boolean isAddApkItemVisible;
        private Boolean isAddExtraItemVisible;
        private Boolean isAnonymousAnswerBarVisible;
        private Boolean isAnonymousQuestionViewVisible;
        private Boolean isCoolPicCategoryBarVisible;
        private Boolean isEditCoverViewVisible;
        private Boolean isEditTextViewVisible;
        private Boolean isEditTitleViewVisible;
        private Boolean isExtraViewVisible;
        private Boolean isFeedGoodsClosable;
        private Boolean isFeedTargetPhoneOrTablet;
        private Boolean isForward;
        private Boolean isForwardAndCommentViewVisible;
        private Boolean isForwardAndReplyChecked;
        private Boolean isLocationViewVisible;
        private Boolean isMenuItemEnabled;
        private Boolean isPickPhotoContainerVisible;
        private Boolean isPickPhotoItemVisible;
        private Boolean isPreviewable;
        private Boolean isProductPicked;
        private Boolean isPublicViewVisible;
        private Boolean isRatingBarBackgroundVisible;
        private Boolean isRatingBarVisible;
        private Boolean isRatingTextCollapsed;
        private Boolean isRemoveExtraViewVisible;
        private Boolean isRichTextItemVisible;
        private Boolean isSecondHandViewVisible;
        private Boolean isShareAppItemVisible;
        private Boolean isShowAddGoodsInMenuBar;
        private Boolean isShowInArticleMode;
        private Boolean isSubmitTargetBarVisible;
        private Boolean isSubmitToViewVisible;
        private Boolean isSwitchArticleViewVisible;
        private String locationName;
        private Integer maxPickPhotoCount;
        private Boolean openKeyboardWhenInit;
        private List<ProductParams> productConfigCacheList;
        private String productConfigShowText;
        private String questionTitle;
        private Boolean relativeInfoPickable;
        private String relativeLogo;
        private String relativeTitle;
        private Integer risePriceType;
        private Integer secondHandDealType;
        private Integer secondHandFaceDeal;
        private String secondHandOutLink;
        private String secondHandPrice;
        private Integer secondHandType;
        private Boolean showParamsItem;
        private String submitText;
        private String submitToText;
        private String subtitle;
        private Boolean tintMarkView;
        private String title;
        private String topicTitle;
        private Integer version;
        private Integer visibleState;

        Builder() {
        }

        Builder(FeedUIConfig feedUIConfig) {
            this.version = Integer.valueOf(feedUIConfig.version());
            this.title = feedUIConfig.title();
            this.subtitle = feedUIConfig.subtitle();
            this.isRatingBarVisible = Boolean.valueOf(feedUIConfig.isRatingBarVisible());
            this.isRatingBarBackgroundVisible = Boolean.valueOf(feedUIConfig.isRatingBarBackgroundVisible());
            this.isLocationViewVisible = Boolean.valueOf(feedUIConfig.isLocationViewVisible());
            this.isSwitchArticleViewVisible = Boolean.valueOf(feedUIConfig.isSwitchArticleViewVisible());
            this.isSecondHandViewVisible = Boolean.valueOf(feedUIConfig.isSecondHandViewVisible());
            this.isPublicViewVisible = Boolean.valueOf(feedUIConfig.isPublicViewVisible());
            this.isForward = Boolean.valueOf(feedUIConfig.isForward());
            this.forwardEntity = feedUIConfig.forwardEntity();
            this.isForwardAndCommentViewVisible = Boolean.valueOf(feedUIConfig.isForwardAndCommentViewVisible());
            this.isExtraViewVisible = Boolean.valueOf(feedUIConfig.isExtraViewVisible());
            this.extraViewLogoUrl = feedUIConfig.extraViewLogoUrl();
            this.extraViewTitle = feedUIConfig.extraViewTitle();
            this.extraViewContent = feedUIConfig.extraViewContent();
            this.secondHandPrice = feedUIConfig.secondHandPrice();
            this.risePriceType = Integer.valueOf(feedUIConfig.risePriceType());
            this.secondHandFaceDeal = Integer.valueOf(feedUIConfig.secondHandFaceDeal());
            this.isCoolPicCategoryBarVisible = Boolean.valueOf(feedUIConfig.isCoolPicCategoryBarVisible());
            this.isAnonymousAnswerBarVisible = Boolean.valueOf(feedUIConfig.isAnonymousAnswerBarVisible());
            this.isSubmitTargetBarVisible = Boolean.valueOf(feedUIConfig.isSubmitTargetBarVisible());
            this.isAnonymousQuestionViewVisible = Boolean.valueOf(feedUIConfig.isAnonymousQuestionViewVisible());
            this.isEditCoverViewVisible = Boolean.valueOf(feedUIConfig.isEditCoverViewVisible());
            this.isEditTitleViewVisible = Boolean.valueOf(feedUIConfig.isEditTitleViewVisible());
            this.isEditTextViewVisible = Boolean.valueOf(feedUIConfig.isEditTextViewVisible());
            this.editTitleHint = feedUIConfig.editTitleHint();
            this.editTitleMaxLength = Integer.valueOf(feedUIConfig.editTitleMaxLength());
            this.editTextHint = feedUIConfig.editTextHint();
            this.isAddApkItemVisible = Boolean.valueOf(feedUIConfig.isAddApkItemVisible());
            this.isAddExtraItemVisible = Boolean.valueOf(feedUIConfig.isAddExtraItemVisible());
            this.isRichTextItemVisible = Boolean.valueOf(feedUIConfig.isRichTextItemVisible());
            this.isPickPhotoItemVisible = Boolean.valueOf(feedUIConfig.isPickPhotoItemVisible());
            this.isPickPhotoContainerVisible = Boolean.valueOf(feedUIConfig.isPickPhotoContainerVisible());
            this.isShareAppItemVisible = Boolean.valueOf(feedUIConfig.isShareAppItemVisible());
            this.isMenuItemEnabled = Boolean.valueOf(feedUIConfig.isMenuItemEnabled());
            this.submitText = feedUIConfig.submitText();
            this.submitToText = feedUIConfig.submitToText();
            this.isSubmitToViewVisible = Boolean.valueOf(feedUIConfig.isSubmitToViewVisible());
            this.locationName = feedUIConfig.locationName();
            this.tintMarkView = Boolean.valueOf(feedUIConfig.tintMarkView());
            this.visibleState = Integer.valueOf(feedUIConfig.visibleState());
            this.extraLinkType = Integer.valueOf(feedUIConfig.extraLinkType());
            this.isForwardAndReplyChecked = Boolean.valueOf(feedUIConfig.isForwardAndReplyChecked());
            this.isRemoveExtraViewVisible = Boolean.valueOf(feedUIConfig.isRemoveExtraViewVisible());
            this.isShowInArticleMode = Boolean.valueOf(feedUIConfig.isShowInArticleMode());
            this.relativeLogo = feedUIConfig.relativeLogo();
            this.relativeTitle = feedUIConfig.relativeTitle();
            this.commentBoardTip1 = feedUIConfig.commentBoardTip1();
            this.commentBoardTip2 = feedUIConfig.commentBoardTip2();
            this.dyhTitle = feedUIConfig.dyhTitle();
            this.topicTitle = feedUIConfig.topicTitle();
            this.questionTitle = feedUIConfig.questionTitle();
            this.isPreviewable = Boolean.valueOf(feedUIConfig.isPreviewable());
            this.canAddVideo = Boolean.valueOf(feedUIConfig.canAddVideo());
            this.canAddMusic = Boolean.valueOf(feedUIConfig.canAddMusic());
            this.addPhotoMenuEnable = Boolean.valueOf(feedUIConfig.addPhotoMenuEnable());
            this.maxPickPhotoCount = Integer.valueOf(feedUIConfig.maxPickPhotoCount());
            this.openKeyboardWhenInit = Boolean.valueOf(feedUIConfig.openKeyboardWhenInit());
            this.secondHandType = Integer.valueOf(feedUIConfig.secondHandType());
            this.secondHandOutLink = feedUIConfig.secondHandOutLink();
            this.productConfigShowText = feedUIConfig.productConfigShowText();
            this.showParamsItem = Boolean.valueOf(feedUIConfig.showParamsItem());
            this.fromPhoneBaToSecondHand = Boolean.valueOf(feedUIConfig.fromPhoneBaToSecondHand());
            this.productConfigCacheList = feedUIConfig.productConfigCacheList();
            this.secondHandDealType = Integer.valueOf(feedUIConfig.secondHandDealType());
            this.isProductPicked = Boolean.valueOf(feedUIConfig.isProductPicked());
            this.isRatingTextCollapsed = Boolean.valueOf(feedUIConfig.isRatingTextCollapsed());
            this.relativeInfoPickable = Boolean.valueOf(feedUIConfig.relativeInfoPickable());
            this.extraEntities = feedUIConfig.extraEntities();
            this.feedGoods = feedUIConfig.feedGoods();
            this.isFeedGoodsClosable = Boolean.valueOf(feedUIConfig.isFeedGoodsClosable());
            this.canUpdateVoteMode = Boolean.valueOf(feedUIConfig.canUpdateVoteMode());
            this.canUpdateVoteTime = Boolean.valueOf(feedUIConfig.canUpdateVoteTime());
            this.isFeedTargetPhoneOrTablet = Boolean.valueOf(feedUIConfig.isFeedTargetPhoneOrTablet());
            this.isShowAddGoodsInMenuBar = Boolean.valueOf(feedUIConfig.isShowAddGoodsInMenuBar());
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder version(int i) {
            this.version = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder subtitle(String str) {
            this.subtitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isRatingBarVisible(boolean z) {
            this.isRatingBarVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isRatingBarBackgroundVisible(boolean z) {
            this.isRatingBarBackgroundVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isLocationViewVisible(boolean z) {
            this.isLocationViewVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isSwitchArticleViewVisible(boolean z) {
            this.isSwitchArticleViewVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isSecondHandViewVisible(boolean z) {
            this.isSecondHandViewVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isPublicViewVisible(boolean z) {
            this.isPublicViewVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isForward(boolean z) {
            this.isForward = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder forwardEntity(Entity entity) {
            this.forwardEntity = entity;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isForwardAndCommentViewVisible(boolean z) {
            this.isForwardAndCommentViewVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isExtraViewVisible(boolean z) {
            this.isExtraViewVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder extraViewLogoUrl(String str) {
            this.extraViewLogoUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder extraViewTitle(String str) {
            this.extraViewTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder extraViewContent(String str) {
            this.extraViewContent = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder secondHandPrice(String str) {
            this.secondHandPrice = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder risePriceType(int i) {
            this.risePriceType = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder secondHandFaceDeal(int i) {
            this.secondHandFaceDeal = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isCoolPicCategoryBarVisible(boolean z) {
            this.isCoolPicCategoryBarVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isAnonymousAnswerBarVisible(boolean z) {
            this.isAnonymousAnswerBarVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isSubmitTargetBarVisible(boolean z) {
            this.isSubmitTargetBarVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isAnonymousQuestionViewVisible(boolean z) {
            this.isAnonymousQuestionViewVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isEditCoverViewVisible(boolean z) {
            this.isEditCoverViewVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isEditTitleViewVisible(boolean z) {
            this.isEditTitleViewVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isEditTextViewVisible(boolean z) {
            this.isEditTextViewVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder editTitleHint(String str) {
            this.editTitleHint = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder editTitleMaxLength(int i) {
            this.editTitleMaxLength = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder editTextHint(String str) {
            this.editTextHint = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isAddApkItemVisible(boolean z) {
            this.isAddApkItemVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isAddExtraItemVisible(boolean z) {
            this.isAddExtraItemVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isRichTextItemVisible(boolean z) {
            this.isRichTextItemVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isPickPhotoItemVisible(boolean z) {
            this.isPickPhotoItemVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isPickPhotoContainerVisible(boolean z) {
            this.isPickPhotoContainerVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isShareAppItemVisible(boolean z) {
            this.isShareAppItemVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isMenuItemEnabled(boolean z) {
            this.isMenuItemEnabled = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder submitText(String str) {
            this.submitText = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder submitToText(String str) {
            this.submitToText = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isSubmitToViewVisible(boolean z) {
            this.isSubmitToViewVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder locationName(String str) {
            this.locationName = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder tintMarkView(boolean z) {
            this.tintMarkView = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder visibleState(int i) {
            this.visibleState = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder extraLinkType(int i) {
            this.extraLinkType = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isForwardAndReplyChecked(boolean z) {
            this.isForwardAndReplyChecked = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isRemoveExtraViewVisible(boolean z) {
            this.isRemoveExtraViewVisible = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isShowInArticleMode(boolean z) {
            this.isShowInArticleMode = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder relativeLogo(String str) {
            this.relativeLogo = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder relativeTitle(String str) {
            this.relativeTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder commentBoardTip1(String str) {
            this.commentBoardTip1 = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder commentBoardTip2(String str) {
            this.commentBoardTip2 = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder dyhTitle(String str) {
            this.dyhTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder topicTitle(String str) {
            this.topicTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder questionTitle(String str) {
            this.questionTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isPreviewable(boolean z) {
            this.isPreviewable = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder canAddVideo(boolean z) {
            this.canAddVideo = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder canAddMusic(boolean z) {
            this.canAddMusic = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder addPhotoMenuEnable(boolean z) {
            this.addPhotoMenuEnable = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder maxPickPhotoCount(int i) {
            this.maxPickPhotoCount = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder openKeyboardWhenInit(boolean z) {
            this.openKeyboardWhenInit = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder secondHandType(int i) {
            this.secondHandType = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder secondHandOutLink(String str) {
            this.secondHandOutLink = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder productConfigShowText(String str) {
            this.productConfigShowText = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder showParamsItem(boolean z) {
            this.showParamsItem = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder fromPhoneBaToSecondHand(boolean z) {
            this.fromPhoneBaToSecondHand = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder productConfigCacheList(List<ProductParams> list) {
            this.productConfigCacheList = list;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder secondHandDealType(int i) {
            this.secondHandDealType = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isProductPicked(boolean z) {
            this.isProductPicked = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isRatingTextCollapsed(boolean z) {
            this.isRatingTextCollapsed = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder relativeInfoPickable(boolean z) {
            this.relativeInfoPickable = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder extraEntities(List<Entity> list) {
            this.extraEntities = list;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder feedGoods(FeedGoods feedGoods2) {
            this.feedGoods = feedGoods2;
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isFeedGoodsClosable(boolean z) {
            this.isFeedGoodsClosable = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder canUpdateVoteMode(boolean z) {
            this.canUpdateVoteMode = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder canUpdateVoteTime(boolean z) {
            this.canUpdateVoteTime = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isFeedTargetPhoneOrTablet(boolean z) {
            this.isFeedTargetPhoneOrTablet = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig.Builder isShowAddGoodsInMenuBar(boolean z) {
            this.isShowAddGoodsInMenuBar = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedUIConfig.Builder
        public FeedUIConfig build() {
            String str = "";
            if (this.version == null) {
                str = str + " version";
            }
            if (this.title == null) {
                str = str + " title";
            }
            if (this.subtitle == null) {
                str = str + " subtitle";
            }
            if (this.isRatingBarVisible == null) {
                str = str + " isRatingBarVisible";
            }
            if (this.isRatingBarBackgroundVisible == null) {
                str = str + " isRatingBarBackgroundVisible";
            }
            if (this.isLocationViewVisible == null) {
                str = str + " isLocationViewVisible";
            }
            if (this.isSwitchArticleViewVisible == null) {
                str = str + " isSwitchArticleViewVisible";
            }
            if (this.isSecondHandViewVisible == null) {
                str = str + " isSecondHandViewVisible";
            }
            if (this.isPublicViewVisible == null) {
                str = str + " isPublicViewVisible";
            }
            if (this.isForward == null) {
                str = str + " isForward";
            }
            if (this.isForwardAndCommentViewVisible == null) {
                str = str + " isForwardAndCommentViewVisible";
            }
            if (this.isExtraViewVisible == null) {
                str = str + " isExtraViewVisible";
            }
            if (this.risePriceType == null) {
                str = str + " risePriceType";
            }
            if (this.secondHandFaceDeal == null) {
                str = str + " secondHandFaceDeal";
            }
            if (this.isCoolPicCategoryBarVisible == null) {
                str = str + " isCoolPicCategoryBarVisible";
            }
            if (this.isAnonymousAnswerBarVisible == null) {
                str = str + " isAnonymousAnswerBarVisible";
            }
            if (this.isSubmitTargetBarVisible == null) {
                str = str + " isSubmitTargetBarVisible";
            }
            if (this.isAnonymousQuestionViewVisible == null) {
                str = str + " isAnonymousQuestionViewVisible";
            }
            if (this.isEditCoverViewVisible == null) {
                str = str + " isEditCoverViewVisible";
            }
            if (this.isEditTitleViewVisible == null) {
                str = str + " isEditTitleViewVisible";
            }
            if (this.isEditTextViewVisible == null) {
                str = str + " isEditTextViewVisible";
            }
            if (this.editTitleMaxLength == null) {
                str = str + " editTitleMaxLength";
            }
            if (this.isAddApkItemVisible == null) {
                str = str + " isAddApkItemVisible";
            }
            if (this.isAddExtraItemVisible == null) {
                str = str + " isAddExtraItemVisible";
            }
            if (this.isRichTextItemVisible == null) {
                str = str + " isRichTextItemVisible";
            }
            if (this.isPickPhotoItemVisible == null) {
                str = str + " isPickPhotoItemVisible";
            }
            if (this.isPickPhotoContainerVisible == null) {
                str = str + " isPickPhotoContainerVisible";
            }
            if (this.isShareAppItemVisible == null) {
                str = str + " isShareAppItemVisible";
            }
            if (this.isMenuItemEnabled == null) {
                str = str + " isMenuItemEnabled";
            }
            if (this.submitText == null) {
                str = str + " submitText";
            }
            if (this.submitToText == null) {
                str = str + " submitToText";
            }
            if (this.isSubmitToViewVisible == null) {
                str = str + " isSubmitToViewVisible";
            }
            if (this.locationName == null) {
                str = str + " locationName";
            }
            if (this.tintMarkView == null) {
                str = str + " tintMarkView";
            }
            if (this.visibleState == null) {
                str = str + " visibleState";
            }
            if (this.extraLinkType == null) {
                str = str + " extraLinkType";
            }
            if (this.isForwardAndReplyChecked == null) {
                str = str + " isForwardAndReplyChecked";
            }
            if (this.isRemoveExtraViewVisible == null) {
                str = str + " isRemoveExtraViewVisible";
            }
            if (this.isShowInArticleMode == null) {
                str = str + " isShowInArticleMode";
            }
            if (this.relativeLogo == null) {
                str = str + " relativeLogo";
            }
            if (this.relativeTitle == null) {
                str = str + " relativeTitle";
            }
            if (this.commentBoardTip1 == null) {
                str = str + " commentBoardTip1";
            }
            if (this.commentBoardTip2 == null) {
                str = str + " commentBoardTip2";
            }
            if (this.dyhTitle == null) {
                str = str + " dyhTitle";
            }
            if (this.topicTitle == null) {
                str = str + " topicTitle";
            }
            if (this.questionTitle == null) {
                str = str + " questionTitle";
            }
            if (this.isPreviewable == null) {
                str = str + " isPreviewable";
            }
            if (this.canAddVideo == null) {
                str = str + " canAddVideo";
            }
            if (this.canAddMusic == null) {
                str = str + " canAddMusic";
            }
            if (this.addPhotoMenuEnable == null) {
                str = str + " addPhotoMenuEnable";
            }
            if (this.maxPickPhotoCount == null) {
                str = str + " maxPickPhotoCount";
            }
            if (this.openKeyboardWhenInit == null) {
                str = str + " openKeyboardWhenInit";
            }
            if (this.secondHandType == null) {
                str = str + " secondHandType";
            }
            if (this.showParamsItem == null) {
                str = str + " showParamsItem";
            }
            if (this.fromPhoneBaToSecondHand == null) {
                str = str + " fromPhoneBaToSecondHand";
            }
            if (this.productConfigCacheList == null) {
                str = str + " productConfigCacheList";
            }
            if (this.secondHandDealType == null) {
                str = str + " secondHandDealType";
            }
            if (this.isProductPicked == null) {
                str = str + " isProductPicked";
            }
            if (this.isRatingTextCollapsed == null) {
                str = str + " isRatingTextCollapsed";
            }
            if (this.relativeInfoPickable == null) {
                str = str + " relativeInfoPickable";
            }
            if (this.extraEntities == null) {
                str = str + " extraEntities";
            }
            if (this.isFeedGoodsClosable == null) {
                str = str + " isFeedGoodsClosable";
            }
            if (this.canUpdateVoteMode == null) {
                str = str + " canUpdateVoteMode";
            }
            if (this.canUpdateVoteTime == null) {
                str = str + " canUpdateVoteTime";
            }
            if (this.isFeedTargetPhoneOrTablet == null) {
                str = str + " isFeedTargetPhoneOrTablet";
            }
            if (this.isShowAddGoodsInMenuBar == null) {
                str = str + " isShowAddGoodsInMenuBar";
            }
            if (str.isEmpty()) {
                return new AutoValue_FeedUIConfig(this.version.intValue(), this.title, this.subtitle, this.isRatingBarVisible.booleanValue(), this.isRatingBarBackgroundVisible.booleanValue(), this.isLocationViewVisible.booleanValue(), this.isSwitchArticleViewVisible.booleanValue(), this.isSecondHandViewVisible.booleanValue(), this.isPublicViewVisible.booleanValue(), this.isForward.booleanValue(), this.forwardEntity, this.isForwardAndCommentViewVisible.booleanValue(), this.isExtraViewVisible.booleanValue(), this.extraViewLogoUrl, this.extraViewTitle, this.extraViewContent, this.secondHandPrice, this.risePriceType.intValue(), this.secondHandFaceDeal.intValue(), this.isCoolPicCategoryBarVisible.booleanValue(), this.isAnonymousAnswerBarVisible.booleanValue(), this.isSubmitTargetBarVisible.booleanValue(), this.isAnonymousQuestionViewVisible.booleanValue(), this.isEditCoverViewVisible.booleanValue(), this.isEditTitleViewVisible.booleanValue(), this.isEditTextViewVisible.booleanValue(), this.editTitleHint, this.editTitleMaxLength.intValue(), this.editTextHint, this.isAddApkItemVisible.booleanValue(), this.isAddExtraItemVisible.booleanValue(), this.isRichTextItemVisible.booleanValue(), this.isPickPhotoItemVisible.booleanValue(), this.isPickPhotoContainerVisible.booleanValue(), this.isShareAppItemVisible.booleanValue(), this.isMenuItemEnabled.booleanValue(), this.submitText, this.submitToText, this.isSubmitToViewVisible.booleanValue(), this.locationName, this.tintMarkView.booleanValue(), this.visibleState.intValue(), this.extraLinkType.intValue(), this.isForwardAndReplyChecked.booleanValue(), this.isRemoveExtraViewVisible.booleanValue(), this.isShowInArticleMode.booleanValue(), this.relativeLogo, this.relativeTitle, this.commentBoardTip1, this.commentBoardTip2, this.dyhTitle, this.topicTitle, this.questionTitle, this.isPreviewable.booleanValue(), this.canAddVideo.booleanValue(), this.canAddMusic.booleanValue(), this.addPhotoMenuEnable.booleanValue(), this.maxPickPhotoCount.intValue(), this.openKeyboardWhenInit.booleanValue(), this.secondHandType.intValue(), this.secondHandOutLink, this.productConfigShowText, this.showParamsItem.booleanValue(), this.fromPhoneBaToSecondHand.booleanValue(), this.productConfigCacheList, this.secondHandDealType.intValue(), this.isProductPicked.booleanValue(), this.isRatingTextCollapsed.booleanValue(), this.relativeInfoPickable.booleanValue(), this.extraEntities, this.feedGoods, this.isFeedGoodsClosable.booleanValue(), this.canUpdateVoteMode.booleanValue(), this.canUpdateVoteTime.booleanValue(), this.isFeedTargetPhoneOrTablet.booleanValue(), this.isShowAddGoodsInMenuBar.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
