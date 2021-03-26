package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_FeedUIConfig;
import java.util.ArrayList;
import java.util.List;

public abstract class FeedUIConfig implements Parcelable {
    public static final int CURRENT_VERSION = 0;

    public static abstract class Builder {
        public abstract Builder addPhotoMenuEnable(boolean z);

        public abstract FeedUIConfig build();

        public abstract Builder canAddMusic(boolean z);

        public abstract Builder canAddVideo(boolean z);

        public abstract Builder canUpdateVoteMode(boolean z);

        public abstract Builder canUpdateVoteTime(boolean z);

        public abstract Builder commentBoardTip1(String str);

        public abstract Builder commentBoardTip2(String str);

        public abstract Builder dyhTitle(String str);

        public abstract Builder editTextHint(String str);

        public abstract Builder editTitleHint(String str);

        public abstract Builder editTitleMaxLength(int i);

        public abstract Builder extraEntities(List<Entity> list);

        public abstract Builder extraLinkType(int i);

        public abstract Builder extraViewContent(String str);

        public abstract Builder extraViewLogoUrl(String str);

        public abstract Builder extraViewTitle(String str);

        public abstract Builder feedGoods(FeedGoods feedGoods);

        public abstract Builder forwardEntity(Entity entity);

        public abstract Builder fromPhoneBaToSecondHand(boolean z);

        public abstract Builder isAddApkItemVisible(boolean z);

        public abstract Builder isAddExtraItemVisible(boolean z);

        public abstract Builder isAnonymousAnswerBarVisible(boolean z);

        public abstract Builder isAnonymousQuestionViewVisible(boolean z);

        public abstract Builder isCoolPicCategoryBarVisible(boolean z);

        public abstract Builder isEditCoverViewVisible(boolean z);

        public abstract Builder isEditTextViewVisible(boolean z);

        public abstract Builder isEditTitleViewVisible(boolean z);

        public abstract Builder isExtraViewVisible(boolean z);

        public abstract Builder isFeedGoodsClosable(boolean z);

        public abstract Builder isFeedTargetPhoneOrTablet(boolean z);

        public abstract Builder isForward(boolean z);

        public abstract Builder isForwardAndCommentViewVisible(boolean z);

        public abstract Builder isForwardAndReplyChecked(boolean z);

        public abstract Builder isLocationViewVisible(boolean z);

        public abstract Builder isMenuItemEnabled(boolean z);

        public abstract Builder isPickPhotoContainerVisible(boolean z);

        public abstract Builder isPickPhotoItemVisible(boolean z);

        public abstract Builder isPreviewable(boolean z);

        public abstract Builder isProductPicked(boolean z);

        public abstract Builder isPublicViewVisible(boolean z);

        public abstract Builder isRatingBarBackgroundVisible(boolean z);

        public abstract Builder isRatingBarVisible(boolean z);

        public abstract Builder isRatingTextCollapsed(boolean z);

        public abstract Builder isRemoveExtraViewVisible(boolean z);

        public abstract Builder isRichTextItemVisible(boolean z);

        public abstract Builder isSecondHandViewVisible(boolean z);

        public abstract Builder isShareAppItemVisible(boolean z);

        public abstract Builder isShowAddGoodsInMenuBar(boolean z);

        public abstract Builder isShowInArticleMode(boolean z);

        public abstract Builder isSubmitTargetBarVisible(boolean z);

        public abstract Builder isSubmitToViewVisible(boolean z);

        public abstract Builder isSwitchArticleViewVisible(boolean z);

        public abstract Builder locationName(String str);

        public abstract Builder maxPickPhotoCount(int i);

        public abstract Builder openKeyboardWhenInit(boolean z);

        public abstract Builder productConfigCacheList(List<ProductParams> list);

        public abstract Builder productConfigShowText(String str);

        public abstract Builder questionTitle(String str);

        public abstract Builder relativeInfoPickable(boolean z);

        public abstract Builder relativeLogo(String str);

        public abstract Builder relativeTitle(String str);

        public abstract Builder risePriceType(int i);

        public abstract Builder secondHandDealType(int i);

        public abstract Builder secondHandFaceDeal(int i);

        public abstract Builder secondHandOutLink(String str);

        public abstract Builder secondHandPrice(String str);

        public abstract Builder secondHandType(int i);

        public abstract Builder showParamsItem(boolean z);

        public abstract Builder submitText(String str);

        public abstract Builder submitToText(String str);

        public abstract Builder subtitle(String str);

        public abstract Builder tintMarkView(boolean z);

        public abstract Builder title(String str);

        public abstract Builder topicTitle(String str);

        public abstract Builder version(int i);

        public abstract Builder visibleState(int i);
    }

    public abstract boolean addPhotoMenuEnable();

    public abstract boolean canAddMusic();

    public abstract boolean canAddVideo();

    public abstract boolean canUpdateVoteMode();

    public abstract boolean canUpdateVoteTime();

    public abstract String commentBoardTip1();

    public abstract String commentBoardTip2();

    public abstract String dyhTitle();

    public abstract String editTextHint();

    public abstract String editTitleHint();

    public abstract int editTitleMaxLength();

    public abstract List<Entity> extraEntities();

    public abstract int extraLinkType();

    public abstract String extraViewContent();

    public abstract String extraViewLogoUrl();

    public abstract String extraViewTitle();

    public abstract FeedGoods feedGoods();

    public abstract Entity forwardEntity();

    public abstract boolean fromPhoneBaToSecondHand();

    public abstract boolean isAddApkItemVisible();

    public abstract boolean isAddExtraItemVisible();

    public abstract boolean isAnonymousAnswerBarVisible();

    public abstract boolean isAnonymousQuestionViewVisible();

    public abstract boolean isCoolPicCategoryBarVisible();

    public abstract boolean isEditCoverViewVisible();

    public abstract boolean isEditTextViewVisible();

    public abstract boolean isEditTitleViewVisible();

    public abstract boolean isExtraViewVisible();

    public abstract boolean isFeedGoodsClosable();

    public abstract boolean isFeedTargetPhoneOrTablet();

    public abstract boolean isForward();

    public abstract boolean isForwardAndCommentViewVisible();

    public abstract boolean isForwardAndReplyChecked();

    public abstract boolean isLocationViewVisible();

    public abstract boolean isMenuItemEnabled();

    public abstract boolean isPickPhotoContainerVisible();

    public abstract boolean isPickPhotoItemVisible();

    public abstract boolean isPreviewable();

    public abstract boolean isProductPicked();

    public abstract boolean isPublicViewVisible();

    public abstract boolean isRatingBarBackgroundVisible();

    public abstract boolean isRatingBarVisible();

    public abstract boolean isRatingTextCollapsed();

    public abstract boolean isRemoveExtraViewVisible();

    public abstract boolean isRichTextItemVisible();

    public abstract boolean isSecondHandViewVisible();

    public abstract boolean isShareAppItemVisible();

    public abstract boolean isShowAddGoodsInMenuBar();

    public abstract boolean isShowInArticleMode();

    public abstract boolean isSubmitTargetBarVisible();

    public abstract boolean isSubmitToViewVisible();

    public abstract boolean isSwitchArticleViewVisible();

    public abstract String locationName();

    public abstract int maxPickPhotoCount();

    public abstract boolean openKeyboardWhenInit();

    public abstract List<ProductParams> productConfigCacheList();

    public abstract String productConfigShowText();

    public abstract String questionTitle();

    public abstract boolean relativeInfoPickable();

    public abstract String relativeLogo();

    public abstract String relativeTitle();

    public abstract int risePriceType();

    public abstract int secondHandDealType();

    public abstract int secondHandFaceDeal();

    public abstract String secondHandOutLink();

    public abstract String secondHandPrice();

    public abstract int secondHandType();

    public abstract boolean showParamsItem();

    public abstract String submitText();

    public abstract String submitToText();

    public abstract String subtitle();

    public abstract boolean tintMarkView();

    public abstract String title();

    public abstract String topicTitle();

    public abstract int version();

    public abstract int visibleState();

    public Builder newBuilder() {
        return builder(this);
    }

    public static Builder builder() {
        return new C$AutoValue_FeedUIConfig.Builder().title("").subtitle("").isRatingBarVisible(false).isRatingBarBackgroundVisible(false).isLocationViewVisible(true).isSwitchArticleViewVisible(false).isPublicViewVisible(true).isSecondHandViewVisible(false).isForward(false).forwardEntity(null).isForwardAndCommentViewVisible(false).isExtraViewVisible(false).extraViewLogoUrl(null).extraViewTitle(null).isCoolPicCategoryBarVisible(false).isAnonymousAnswerBarVisible(true).isSubmitTargetBarVisible(false).isAnonymousQuestionViewVisible(false).isEditCoverViewVisible(false).isEditTitleViewVisible(false).isEditTextViewVisible(false).editTitleHint(null).editTextHint(null).isAddApkItemVisible(true).isPickPhotoItemVisible(true).isPickPhotoContainerVisible(true).isShareAppItemVisible(true).isAddExtraItemVisible(true).isRichTextItemVisible(false).submitText("").submitToText("").isSubmitToViewVisible(false).extraViewContent("").locationName("").secondHandPrice("").tintMarkView(false).visibleState(1).extraLinkType(0).isForwardAndReplyChecked(true).isRemoveExtraViewVisible(false).isMenuItemEnabled(true).isShowInArticleMode(false).topicTitle("").questionTitle("").isPreviewable(false).dyhTitle("").relativeLogo("").relativeTitle("").canAddVideo(false).canAddMusic(false).addPhotoMenuEnable(true).maxPickPhotoCount(9).secondHandType(0).editTitleMaxLength(50).secondHandOutLink("").productConfigShowText("").showParamsItem(true).fromPhoneBaToSecondHand(false).productConfigCacheList(new ArrayList()).openKeyboardWhenInit(true).secondHandDealType(0).secondHandFaceDeal(0).isProductPicked(false).risePriceType(0).commentBoardTip1("长按图片可拖动排序").commentBoardTip2("发无关图、色情图将会被禁言").version(0).isRatingTextCollapsed(false).relativeInfoPickable(false).feedGoods(null).extraEntities(new ArrayList()).isFeedGoodsClosable(true).canUpdateVoteMode(true).canUpdateVoteTime(true).isFeedTargetPhoneOrTablet(false).isShowAddGoodsInMenuBar(true);
    }

    public static Builder builder(FeedUIConfig feedUIConfig) {
        if (feedUIConfig == null) {
            return builder();
        }
        return new C$AutoValue_FeedUIConfig.Builder(feedUIConfig);
    }
}
