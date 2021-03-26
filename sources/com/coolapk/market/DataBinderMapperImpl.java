package com.coolapk.market;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.AboutBindingImpl;
import com.coolapk.market.databinding.ActionItemAppManagerViewBindingImpl;
import com.coolapk.market.databinding.ActionItemBadgeViewBindingImpl;
import com.coolapk.market.databinding.ActionItemPostBindingImpl;
import com.coolapk.market.databinding.ActivityAlbumDetailbetaBindingImpl;
import com.coolapk.market.databinding.ActivityWallpaperBetaBindingImpl;
import com.coolapk.market.databinding.ActivityWallpaperBindingImpl;
import com.coolapk.market.databinding.AddGoodsItemDialogBindingImpl;
import com.coolapk.market.databinding.AddToAlbumEditBindingImpl;
import com.coolapk.market.databinding.AlbumActionBarBindingImpl;
import com.coolapk.market.databinding.AlbumActionViewBindingImpl;
import com.coolapk.market.databinding.AlbumAppBindingImpl;
import com.coolapk.market.databinding.AlbumBaseInfoBindingImpl;
import com.coolapk.market.databinding.AlbumCommentBarBindingImpl;
import com.coolapk.market.databinding.AlbumDetailBindingImpl;
import com.coolapk.market.databinding.AlbumDetailV8V2BindingImpl;
import com.coolapk.market.databinding.AlbumDetailtViewBindingImpl;
import com.coolapk.market.databinding.AlbumHeaderViewV2BindingImpl;
import com.coolapk.market.databinding.AlbumItemBaseInfoBindingImpl;
import com.coolapk.market.databinding.AlbumListItemCardNonupleBindingImpl;
import com.coolapk.market.databinding.AlbumListItemCardNonupleItemBindingImpl;
import com.coolapk.market.databinding.AlbumTestViewBindingImpl;
import com.coolapk.market.databinding.AlbumUserInfoBindingImpl;
import com.coolapk.market.databinding.AlbumV8DetailBindingImpl;
import com.coolapk.market.databinding.AlphaToolbarBindingImpl;
import com.coolapk.market.databinding.AppDetailBindingImpl;
import com.coolapk.market.databinding.AppExtensionBarV3BindingImpl;
import com.coolapk.market.databinding.AppExtensionItemBindingImpl;
import com.coolapk.market.databinding.AppExtensionItemPostBindingImpl;
import com.coolapk.market.databinding.AppMainModelSelectBindingImpl;
import com.coolapk.market.databinding.AppNodeCommunityHeaderBindingImpl;
import com.coolapk.market.databinding.AppNodeHeaderBindingImpl;
import com.coolapk.market.databinding.AppNodeToolbarContentBindingImpl;
import com.coolapk.market.databinding.AppPhotoThumbnailBindingImpl;
import com.coolapk.market.databinding.AppViewBaseInfoBindingImpl;
import com.coolapk.market.databinding.AppViewBindingImpl;
import com.coolapk.market.databinding.AppViewRecyclerBindingImpl;
import com.coolapk.market.databinding.AppViewV8BindingImpl;
import com.coolapk.market.databinding.ArticleDetailImagePartBindingImpl;
import com.coolapk.market.databinding.ArticleDetailTextPartBindingImpl;
import com.coolapk.market.databinding.BaseChattingBindingImpl;
import com.coolapk.market.databinding.BaseNewChattingBindingImpl;
import com.coolapk.market.databinding.CenterV9SocialDialogBindingImpl;
import com.coolapk.market.databinding.CollectionSelectBindingImpl;
import com.coolapk.market.databinding.CommentBarBindingImpl;
import com.coolapk.market.databinding.CoolBrowserBindingImpl;
import com.coolapk.market.databinding.CoolPicFullScreenBindingImpl;
import com.coolapk.market.databinding.CoolPicImgLayoutBindingImpl;
import com.coolapk.market.databinding.CreateCollectListBindingImpl;
import com.coolapk.market.databinding.CreateFunThingsBindingImpl;
import com.coolapk.market.databinding.CreateGoodsBindingImpl;
import com.coolapk.market.databinding.CustomThemeBindingImpl;
import com.coolapk.market.databinding.DialogAddBlockWordBindingImpl;
import com.coolapk.market.databinding.DialogAddToGoodsListBindingImpl;
import com.coolapk.market.databinding.DialogAlbumCreateBindingImpl;
import com.coolapk.market.databinding.DialogAlbumMobileappNoteBindingImpl;
import com.coolapk.market.databinding.DialogAlbumitemNoteBindingImpl;
import com.coolapk.market.databinding.DialogAlbumitemPxBindingImpl;
import com.coolapk.market.databinding.DialogAppRatingBindingImpl;
import com.coolapk.market.databinding.DialogBackupCreateBindingImpl;
import com.coolapk.market.databinding.DialogBlockNodeBindingImpl;
import com.coolapk.market.databinding.DialogCityPickerBindingImpl;
import com.coolapk.market.databinding.DialogCompleteNavBindingImpl;
import com.coolapk.market.databinding.DialogDatePickerBindingImpl;
import com.coolapk.market.databinding.DialogEditBindingImpl;
import com.coolapk.market.databinding.DialogEditSubmitBindingImpl;
import com.coolapk.market.databinding.DialogGenderPickerBindingImpl;
import com.coolapk.market.databinding.DialogGoodsListEditBindingImpl;
import com.coolapk.market.databinding.DialogItemTextViewBindingImpl;
import com.coolapk.market.databinding.DialogListItemViewBindingImpl;
import com.coolapk.market.databinding.DialogMessageCardBindingImpl;
import com.coolapk.market.databinding.DialogPrograssViewBindingImpl;
import com.coolapk.market.databinding.DialogSecondHandAgreementBindingImpl;
import com.coolapk.market.databinding.DialogSecondHandEditBindingImpl;
import com.coolapk.market.databinding.DialogSecondHandPriceBindingImpl;
import com.coolapk.market.databinding.DialogSelectItemBindingImpl;
import com.coolapk.market.databinding.DialogSeletorContainerBindingImpl;
import com.coolapk.market.databinding.DialogShareBindingImpl;
import com.coolapk.market.databinding.DialogTimePickerBindingImpl;
import com.coolapk.market.databinding.DiscoveryBindingImpl;
import com.coolapk.market.databinding.DiscoverySubmitBindingImpl;
import com.coolapk.market.databinding.DyhHeaderViewBindingImpl;
import com.coolapk.market.databinding.DyhIncludBindingImpl;
import com.coolapk.market.databinding.EditUserViewBindingImpl;
import com.coolapk.market.databinding.EmotionPanelBindingImpl;
import com.coolapk.market.databinding.EmotionPanelBottomTextBindingImpl;
import com.coolapk.market.databinding.FabBindingImpl;
import com.coolapk.market.databinding.FeedActionBarBindingImpl;
import com.coolapk.market.databinding.FeedAnswerViewPartBindingImpl;
import com.coolapk.market.databinding.FeedBindGoodsMainBindingImpl;
import com.coolapk.market.databinding.FeedBlockItemsBindingImpl;
import com.coolapk.market.databinding.FeedCommentBarBindingImpl;
import com.coolapk.market.databinding.FeedCommentCountViewPartBindingImpl;
import com.coolapk.market.databinding.FeedEntranceItemsBindingImpl;
import com.coolapk.market.databinding.FeedEntranceLongItemsBindingImpl;
import com.coolapk.market.databinding.FeedEntranceV8BindingImpl;
import com.coolapk.market.databinding.FeedReplyDetailBindingImpl;
import com.coolapk.market.databinding.FeedReplyDetailHeaderBindingImpl;
import com.coolapk.market.databinding.FeedTopBindingImpl;
import com.coolapk.market.databinding.FeedWarningBindingImpl;
import com.coolapk.market.databinding.FetchGiftBindingImpl;
import com.coolapk.market.databinding.FixedTablayoutBindingImpl;
import com.coolapk.market.databinding.ForwardPreviewBindingImpl;
import com.coolapk.market.databinding.GoodsCouponSearchBindingImpl;
import com.coolapk.market.databinding.GoodsDetailBindingImpl;
import com.coolapk.market.databinding.GoodsSearchBindingImpl;
import com.coolapk.market.databinding.HomeBindingImpl;
import com.coolapk.market.databinding.ItemAccountTipsBindingImpl;
import com.coolapk.market.databinding.ItemActionSheetDialogBindingImpl;
import com.coolapk.market.databinding.ItemAddToAlbumBindingImpl;
import com.coolapk.market.databinding.ItemAddToAlbumHeaderBindingImpl;
import com.coolapk.market.databinding.ItemAddToGoodsListBindingImpl;
import com.coolapk.market.databinding.ItemAdsBindingImpl;
import com.coolapk.market.databinding.ItemAlbumAppEditBindingImpl;
import com.coolapk.market.databinding.ItemAlbumBindingImpl;
import com.coolapk.market.databinding.ItemAlbumEditHeaderBindingImpl;
import com.coolapk.market.databinding.ItemAlbumExpandCardBindingImpl;
import com.coolapk.market.databinding.ItemAlbumFeedBaseBindingImpl;
import com.coolapk.market.databinding.ItemAlbumIconBindingImpl;
import com.coolapk.market.databinding.ItemAlbumWithAvatarBindingImpl;
import com.coolapk.market.databinding.ItemAlertMessageCardBindingImpl;
import com.coolapk.market.databinding.ItemAnswerViewBindingImpl;
import com.coolapk.market.databinding.ItemApkScrollWithBackgroundBindingImpl;
import com.coolapk.market.databinding.ItemAppCategoryBindingImpl;
import com.coolapk.market.databinding.ItemAppDetailBindingImpl;
import com.coolapk.market.databinding.ItemAppForumBindingImpl;
import com.coolapk.market.databinding.ItemAppInsideImageCardBindingImpl;
import com.coolapk.market.databinding.ItemAppNodeCouponBindingImpl;
import com.coolapk.market.databinding.ItemAppNodeGiftBindingImpl;
import com.coolapk.market.databinding.ItemAppNodeTagBindingImpl;
import com.coolapk.market.databinding.ItemAppNodeThumbnailBindingImpl;
import com.coolapk.market.databinding.ItemAppUpdataManagerBindingImpl;
import com.coolapk.market.databinding.ItemAppViewBaseInfoBindingImpl;
import com.coolapk.market.databinding.ItemAppViewBaseInfoCouponItemBindingImpl;
import com.coolapk.market.databinding.ItemAppViewBaseInfoGiftBindingImpl;
import com.coolapk.market.databinding.ItemAppViewCommentTitleBindingImpl;
import com.coolapk.market.databinding.ItemAppViewDownloadBindingImpl;
import com.coolapk.market.databinding.ItemAppViewGiftBindingImpl;
import com.coolapk.market.databinding.ItemAppViewHolderBindingImpl;
import com.coolapk.market.databinding.ItemAppViewInteractiveBindingImpl;
import com.coolapk.market.databinding.ItemAppViewRatingBindingImpl;
import com.coolapk.market.databinding.ItemArticleAnswerPreviewTopBindingImpl;
import com.coolapk.market.databinding.ItemArticleCardGoodsBindingImpl;
import com.coolapk.market.databinding.ItemArticleDetailAnswerTopBindingImpl;
import com.coolapk.market.databinding.ItemArticleDetailTopBindingImpl;
import com.coolapk.market.databinding.ItemArticleEditShareUrlBindingImpl;
import com.coolapk.market.databinding.ItemArticleEditShareUrlContainerBindingImpl;
import com.coolapk.market.databinding.ItemArticleFeedPreviewTopBindingImpl;
import com.coolapk.market.databinding.ItemArticleViewImageBindingImpl;
import com.coolapk.market.databinding.ItemArticleViewTextBindingImpl;
import com.coolapk.market.databinding.ItemBackAppSwitchBindingImpl;
import com.coolapk.market.databinding.ItemBackupAppBindingImpl;
import com.coolapk.market.databinding.ItemBackupBindingImpl;
import com.coolapk.market.databinding.ItemBackupHeaderBindingImpl;
import com.coolapk.market.databinding.ItemBackupHeaderInfoBindingImpl;
import com.coolapk.market.databinding.ItemBackupHeaderTitleBindingImpl;
import com.coolapk.market.databinding.ItemBindGoodsChildBindingImpl;
import com.coolapk.market.databinding.ItemBlackListBindingImpl;
import com.coolapk.market.databinding.ItemBlockHeaderBindingImpl;
import com.coolapk.market.databinding.ItemBlockNodeBindingImpl;
import com.coolapk.market.databinding.ItemBlockUserBindingImpl;
import com.coolapk.market.databinding.ItemBlockWordBindingImpl;
import com.coolapk.market.databinding.ItemCapsuleListBindingImpl;
import com.coolapk.market.databinding.ItemCardAddBindingImpl;
import com.coolapk.market.databinding.ItemCardDoubleBindingImpl;
import com.coolapk.market.databinding.ItemCardDoubleItemBindingImpl;
import com.coolapk.market.databinding.ItemCardManagerBindingImpl;
import com.coolapk.market.databinding.ItemCardManagerTitleBindingImpl;
import com.coolapk.market.databinding.ItemCardTripleBindingImpl;
import com.coolapk.market.databinding.ItemCardTripleItemBindingImpl;
import com.coolapk.market.databinding.ItemCategoryDetailRankBindingImpl;
import com.coolapk.market.databinding.ItemCategoryHeaderBindingImpl;
import com.coolapk.market.databinding.ItemCenterLoginBindingImpl;
import com.coolapk.market.databinding.ItemCenterMoreEntranceBindingImpl;
import com.coolapk.market.databinding.ItemCenterMoreEntranceChildBindingImpl;
import com.coolapk.market.databinding.ItemCenterMoreMenuBindingImpl;
import com.coolapk.market.databinding.ItemCenterMoreTitleBindingImpl;
import com.coolapk.market.databinding.ItemCenterUserInfoBindingImpl;
import com.coolapk.market.databinding.ItemCenterUserMenuBindingImpl;
import com.coolapk.market.databinding.ItemCenterUserMenuChildBindingImpl;
import com.coolapk.market.databinding.ItemChannelTabBindingImpl;
import com.coolapk.market.databinding.ItemChannelTitleBindingImpl;
import com.coolapk.market.databinding.ItemChatingMineBindingImpl;
import com.coolapk.market.databinding.ItemChatingMineCardBindingImpl;
import com.coolapk.market.databinding.ItemChatingUserBindingImpl;
import com.coolapk.market.databinding.ItemChatingUserCardBindingImpl;
import com.coolapk.market.databinding.ItemCircleFeedTopBindingImpl;
import com.coolapk.market.databinding.ItemCollectionBindingImpl;
import com.coolapk.market.databinding.ItemCollectionFootBindingImpl;
import com.coolapk.market.databinding.ItemCollectionHeaderBindingImpl;
import com.coolapk.market.databinding.ItemCollectionSelectBindingImpl;
import com.coolapk.market.databinding.ItemColorfulFatScrollCardChildBindingImpl;
import com.coolapk.market.databinding.ItemColorfulScrollCardChildBindingImpl;
import com.coolapk.market.databinding.ItemCommentbarChildViewBindingImpl;
import com.coolapk.market.databinding.ItemContactBindingImpl;
import com.coolapk.market.databinding.ItemCoolPicImageBindingImpl;
import com.coolapk.market.databinding.ItemCoolPicImageViewBindingImpl;
import com.coolapk.market.databinding.ItemCoolpicDetailBindingImpl;
import com.coolapk.market.databinding.ItemCoolpicFallBindingImpl;
import com.coolapk.market.databinding.ItemCoverViewBindingImpl;
import com.coolapk.market.databinding.ItemCreateGoodsListBindingImpl;
import com.coolapk.market.databinding.ItemDeveloperAppBindingImpl;
import com.coolapk.market.databinding.ItemDeveloperCardBindingImpl;
import com.coolapk.market.databinding.ItemDeviceParamsBindingImpl;
import com.coolapk.market.databinding.ItemDiscoveryImageViewV8BindingImpl;
import com.coolapk.market.databinding.ItemDiscoveryViewBindingImpl;
import com.coolapk.market.databinding.ItemDocListCardBindingImpl;
import com.coolapk.market.databinding.ItemDocListCardItemBindingImpl;
import com.coolapk.market.databinding.ItemDocMarqueeCardBindingImpl;
import com.coolapk.market.databinding.ItemDownloadBindingImpl;
import com.coolapk.market.databinding.ItemDyhArticleContentBindingImpl;
import com.coolapk.market.databinding.ItemDyhArticleHeaderBindingImpl;
import com.coolapk.market.databinding.ItemDyhArticleV8BindingImpl;
import com.coolapk.market.databinding.ItemDyhDetailV8BindingImpl;
import com.coolapk.market.databinding.ItemDyhIncludBindingImpl;
import com.coolapk.market.databinding.ItemDyhMiniHeaderBindingImpl;
import com.coolapk.market.databinding.ItemDyhSimpleHeaderBindingImpl;
import com.coolapk.market.databinding.ItemDyhSourcePartBindingImpl;
import com.coolapk.market.databinding.ItemDyhSourceTitleBindingImpl;
import com.coolapk.market.databinding.ItemDyharticleActionBindingImpl;
import com.coolapk.market.databinding.ItemEditGoodsBindingImpl;
import com.coolapk.market.databinding.ItemEmptyViewBindingImpl;
import com.coolapk.market.databinding.ItemEntityVideoDetailViewPartBindingImpl;
import com.coolapk.market.databinding.ItemFavoriteBindingImpl;
import com.coolapk.market.databinding.ItemFeedActionViewBindingImpl;
import com.coolapk.market.databinding.ItemFeedAlbumLayoutBindingImpl;
import com.coolapk.market.databinding.ItemFeedBaseBindingImpl;
import com.coolapk.market.databinding.ItemFeedBindGoodsBindingImpl;
import com.coolapk.market.databinding.ItemFeedCoolPicDetailBindingImpl;
import com.coolapk.market.databinding.ItemFeedCoolPicLayoutBindingImpl;
import com.coolapk.market.databinding.ItemFeedCoverViewBindingImpl;
import com.coolapk.market.databinding.ItemFeedDetailViewV8BindingImpl;
import com.coolapk.market.databinding.ItemFeedDiscoveryDetailBindingImpl;
import com.coolapk.market.databinding.ItemFeedExtraTypePartBindingImpl;
import com.coolapk.market.databinding.ItemFeedFilterBindingImpl;
import com.coolapk.market.databinding.ItemFeedFollowableHeaderViewBindingImpl;
import com.coolapk.market.databinding.ItemFeedForwardViewBindingImpl;
import com.coolapk.market.databinding.ItemFeedGoodsBindingImpl;
import com.coolapk.market.databinding.ItemFeedGoodsDetailBindingImpl;
import com.coolapk.market.databinding.ItemFeedGoodsDetailImageBindingImpl;
import com.coolapk.market.databinding.ItemFeedGoodsInfoBindingImpl;
import com.coolapk.market.databinding.ItemFeedHeaderViewBindingImpl;
import com.coolapk.market.databinding.ItemFeedImageBindingImpl;
import com.coolapk.market.databinding.ItemFeedLayoutV8BindingImpl;
import com.coolapk.market.databinding.ItemFeedNewsBottomBindingImpl;
import com.coolapk.market.databinding.ItemFeedNewsViewBindingImpl;
import com.coolapk.market.databinding.ItemFeedRatingBindingImpl;
import com.coolapk.market.databinding.ItemFeedRatingDataBindingImpl;
import com.coolapk.market.databinding.ItemFeedRatingDetailBindingImpl;
import com.coolapk.market.databinding.ItemFeedRatingHeaderBindingImpl;
import com.coolapk.market.databinding.ItemFeedRatingViewBindingImpl;
import com.coolapk.market.databinding.ItemFeedReplyBindingImpl;
import com.coolapk.market.databinding.ItemFeedReplyHotBindingImpl;
import com.coolapk.market.databinding.ItemFeedReplyMeBindingImpl;
import com.coolapk.market.databinding.ItemFeedReplyPartBindingImpl;
import com.coolapk.market.databinding.ItemFeedReplyTextBindingImpl;
import com.coolapk.market.databinding.ItemFeedReplyTitleBindingImpl;
import com.coolapk.market.databinding.ItemFeedRoughDraftBindingImpl;
import com.coolapk.market.databinding.ItemFeedScrollItemBindingImpl;
import com.coolapk.market.databinding.ItemFeedSecondHandHeaderViewPartBindingImpl;
import com.coolapk.market.databinding.ItemFeedSecondHandViewPartBindingImpl;
import com.coolapk.market.databinding.ItemFeedShareActionViewBindingImpl;
import com.coolapk.market.databinding.ItemFeedSmallHeaderViewBindingImpl;
import com.coolapk.market.databinding.ItemFeedSmallTitleBindingImpl;
import com.coolapk.market.databinding.ItemFeedSourceDeletedBindingImpl;
import com.coolapk.market.databinding.ItemFeedSourcePartBindingImpl;
import com.coolapk.market.databinding.ItemFeedStackItemBindingImpl;
import com.coolapk.market.databinding.ItemFeedTargetViewBindingImpl;
import com.coolapk.market.databinding.ItemFeedTitleBindingImpl;
import com.coolapk.market.databinding.ItemFeedVideoDetailViewPartBindingImpl;
import com.coolapk.market.databinding.ItemFeedVoteBindingImpl;
import com.coolapk.market.databinding.ItemFeedVoteCommentBindingImpl;
import com.coolapk.market.databinding.ItemFeedVoteCommentDetailBindingImpl;
import com.coolapk.market.databinding.ItemFeedVoteCommentSmallBindingImpl;
import com.coolapk.market.databinding.ItemFeedVoteCommentViewPartBindingImpl;
import com.coolapk.market.databinding.ItemFeedVoteHeaderBindingImpl;
import com.coolapk.market.databinding.ItemFeedVoteMultiBindingImpl;
import com.coolapk.market.databinding.ItemFeedVotePkBindingImpl;
import com.coolapk.market.databinding.ItemFeedVotePkResultBindingImpl;
import com.coolapk.market.databinding.ItemFileBindingImpl;
import com.coolapk.market.databinding.ItemFileTitleBindingImpl;
import com.coolapk.market.databinding.ItemFoldedViewBindingImpl;
import com.coolapk.market.databinding.ItemFollowDyhBindingImpl;
import com.coolapk.market.databinding.ItemFootBindingImpl;
import com.coolapk.market.databinding.ItemForwardEntityShareAppBindingImpl;
import com.coolapk.market.databinding.ItemFunThingBindingImpl;
import com.coolapk.market.databinding.ItemGiftItemBindingImpl;
import com.coolapk.market.databinding.ItemGoodGoodsAddBindingImpl;
import com.coolapk.market.databinding.ItemGoodGoodsBindingImpl;
import com.coolapk.market.databinding.ItemGoodGoodsListHeaderBindingImpl;
import com.coolapk.market.databinding.ItemGoodsBindingImpl;
import com.coolapk.market.databinding.ItemGoodsFallBindingImpl;
import com.coolapk.market.databinding.ItemGoodsListBindingImpl;
import com.coolapk.market.databinding.ItemGoodsListEditHeaderBindingImpl;
import com.coolapk.market.databinding.ItemGoodsListFeedBindingImpl;
import com.coolapk.market.databinding.ItemGoodsListSimpleBindingImpl;
import com.coolapk.market.databinding.ItemGoodsParamsBindingImpl;
import com.coolapk.market.databinding.ItemGoodsV10BindingImpl;
import com.coolapk.market.databinding.ItemGridAlbumCardBindingImpl;
import com.coolapk.market.databinding.ItemGridCardBindingImpl;
import com.coolapk.market.databinding.ItemGridCardItemBindingImpl;
import com.coolapk.market.databinding.ItemGridCardViewBindingImpl;
import com.coolapk.market.databinding.ItemGridDyhCardBindingImpl;
import com.coolapk.market.databinding.ItemGridDyhCardItemBindingImpl;
import com.coolapk.market.databinding.ItemGridItemLongTitleBindingImpl;
import com.coolapk.market.databinding.ItemGroupListCardBindingImpl;
import com.coolapk.market.databinding.ItemHeadCardBindingImpl;
import com.coolapk.market.databinding.ItemHeadlineTitleBindingImpl;
import com.coolapk.market.databinding.ItemHotFeedReplyViewPartBindingImpl;
import com.coolapk.market.databinding.ItemHotSearchListBindingImpl;
import com.coolapk.market.databinding.ItemHotSearchUserBindingImpl;
import com.coolapk.market.databinding.ItemIconButtonGridCardBindingImpl;
import com.coolapk.market.databinding.ItemIconGridCardItemBindingImpl;
import com.coolapk.market.databinding.ItemIconLinkGridCardBindingImpl;
import com.coolapk.market.databinding.ItemIconLinkGridCardItemBindingImpl;
import com.coolapk.market.databinding.ItemIconLinkMiniGridCardItemBindingImpl;
import com.coolapk.market.databinding.ItemIconMiniGridCardBindingImpl;
import com.coolapk.market.databinding.ItemIconMiniGridCardItemBindingImpl;
import com.coolapk.market.databinding.ItemIconTitleViewBindingImpl;
import com.coolapk.market.databinding.ItemImageAppBigCardBindingImpl;
import com.coolapk.market.databinding.ItemImageAppCardBindingImpl;
import com.coolapk.market.databinding.ItemImageCardBindingImpl;
import com.coolapk.market.databinding.ItemImageCarouselCard1ItemBindingImpl;
import com.coolapk.market.databinding.ItemImageCarouselCard2BindingImpl;
import com.coolapk.market.databinding.ItemImageCarouselCard2ItemBindingImpl;
import com.coolapk.market.databinding.ItemImageListCardBindingImpl;
import com.coolapk.market.databinding.ItemImageScrollCardBindingImpl;
import com.coolapk.market.databinding.ItemImageScrollCardItemBindingImpl;
import com.coolapk.market.databinding.ItemImageTextCardChildBindingImpl;
import com.coolapk.market.databinding.ItemLargeScrollCardGoodsItemBindingImpl;
import com.coolapk.market.databinding.ItemLargeScrollCardItemBindingImpl;
import com.coolapk.market.databinding.ItemLargeTextBindingImpl;
import com.coolapk.market.databinding.ItemLayoutDyhIncludBindingImpl;
import com.coolapk.market.databinding.ItemLibraryShowBindingImpl;
import com.coolapk.market.databinding.ItemLinkCardBindingImpl;
import com.coolapk.market.databinding.ItemLinkCardTabBindingImpl;
import com.coolapk.market.databinding.ItemLinkCardV8BindingImpl;
import com.coolapk.market.databinding.ItemListCardBindingImpl;
import com.coolapk.market.databinding.ItemLiveCardBindingImpl;
import com.coolapk.market.databinding.ItemLiveImageTextCardBindingImpl;
import com.coolapk.market.databinding.ItemLiveItemCardBindingImpl;
import com.coolapk.market.databinding.ItemLiveLineViewPartBindingImpl;
import com.coolapk.market.databinding.ItemLiveMessageBindingImpl;
import com.coolapk.market.databinding.ItemLiveSystemMessageBindingImpl;
import com.coolapk.market.databinding.ItemLiveVideoViewPartBindingImpl;
import com.coolapk.market.databinding.ItemLocalApkBindingImpl;
import com.coolapk.market.databinding.ItemLocalAppBindingImpl;
import com.coolapk.market.databinding.ItemLocationBindingImpl;
import com.coolapk.market.databinding.ItemLogFileBindingImpl;
import com.coolapk.market.databinding.ItemLoginCardBindingImpl;
import com.coolapk.market.databinding.ItemLoginUserNodeRatingSelectorBindingImpl;
import com.coolapk.market.databinding.ItemMainCategoryChildBindingImpl;
import com.coolapk.market.databinding.ItemMainCategoryDetailSBindingImpl;
import com.coolapk.market.databinding.ItemMainCategoryLinkBindingImpl;
import com.coolapk.market.databinding.ItemMainCatogoryTypeBindingImpl;
import com.coolapk.market.databinding.ItemMarketAppsBindingImpl;
import com.coolapk.market.databinding.ItemMenuItemBindingImpl;
import com.coolapk.market.databinding.ItemMessageBindingImpl;
import com.coolapk.market.databinding.ItemMessageCardBindingImpl;
import com.coolapk.market.databinding.ItemMessageExtraBindingImpl;
import com.coolapk.market.databinding.ItemMessageSelectViewBindingImpl;
import com.coolapk.market.databinding.ItemMobileAlbumAppNewBindingImpl;
import com.coolapk.market.databinding.ItemMobileAppBindingImpl;
import com.coolapk.market.databinding.ItemMobileAppSwitchBindingImpl;
import com.coolapk.market.databinding.ItemMoreActionBindingImpl;
import com.coolapk.market.databinding.ItemMyEmptyCardBindingImpl;
import com.coolapk.market.databinding.ItemNewAddBindingImpl;
import com.coolapk.market.databinding.ItemNewFeedImageBindingImpl;
import com.coolapk.market.databinding.ItemNewGridCardBindingImpl;
import com.coolapk.market.databinding.ItemNoLoginTitelBindingImpl;
import com.coolapk.market.databinding.ItemNoMoreDataViewBindingImpl;
import com.coolapk.market.databinding.ItemNodePickItemBindingImpl;
import com.coolapk.market.databinding.ItemNodeRatingBindingImpl;
import com.coolapk.market.databinding.ItemNodeRatingSelectorBindingImpl;
import com.coolapk.market.databinding.ItemNodeTopContenItemBindingImpl;
import com.coolapk.market.databinding.ItemNotificationAlbumLikeBindingImpl;
import com.coolapk.market.databinding.ItemNotificationBindingImpl;
import com.coolapk.market.databinding.ItemNotificationFeedLikeBindingImpl;
import com.coolapk.market.databinding.ItemNotificationFeedreplyLikeBindingImpl;
import com.coolapk.market.databinding.ItemNotificationNaviBindingImpl;
import com.coolapk.market.databinding.ItemOptionsTitleBindingImpl;
import com.coolapk.market.databinding.ItemPermissionBindingImpl;
import com.coolapk.market.databinding.ItemPermissionsBindingImpl;
import com.coolapk.market.databinding.ItemPhotoDirectoryBindingImpl;
import com.coolapk.market.databinding.ItemPhotoPickerBindingImpl;
import com.coolapk.market.databinding.ItemPhotoViewBindingImpl;
import com.coolapk.market.databinding.ItemPicCategoryBindingImpl;
import com.coolapk.market.databinding.ItemPicTypeTabBindingImpl;
import com.coolapk.market.databinding.ItemPickAppBindingImpl;
import com.coolapk.market.databinding.ItemPickServiceAppBindingImpl;
import com.coolapk.market.databinding.ItemPictureSwitchBindingImpl;
import com.coolapk.market.databinding.ItemPlaceHolderBindingImpl;
import com.coolapk.market.databinding.ItemPodiumCardBindingImpl;
import com.coolapk.market.databinding.ItemPodiumCardItemBindingImpl;
import com.coolapk.market.databinding.ItemProductBrandLeftItemBindingImpl;
import com.coolapk.market.databinding.ItemProductConfigItemBindingImpl;
import com.coolapk.market.databinding.ItemProductConfigTitleBindingImpl;
import com.coolapk.market.databinding.ItemProductCouponBindingImpl;
import com.coolapk.market.databinding.ItemProductCouponDeviceBindingImpl;
import com.coolapk.market.databinding.ItemProductDescriptionBindingImpl;
import com.coolapk.market.databinding.ItemProductExtraParamsBindingImpl;
import com.coolapk.market.databinding.ItemProductMediaBindingImpl;
import com.coolapk.market.databinding.ItemProductMultiRatingMapBindingImpl;
import com.coolapk.market.databinding.ItemProductParamsBindingImpl;
import com.coolapk.market.databinding.ItemProductScoreViewBindingImpl;
import com.coolapk.market.databinding.ItemProductSeriesBindingImpl;
import com.coolapk.market.databinding.ItemProductSeriesChildBindingImpl;
import com.coolapk.market.databinding.ItemProductSeriesErshouBindingImpl;
import com.coolapk.market.databinding.ItemProductSeriesHorizontalBindingImpl;
import com.coolapk.market.databinding.ItemProductSeriesListMoreBindingImpl;
import com.coolapk.market.databinding.ItemProductSeriesListTitleBindingImpl;
import com.coolapk.market.databinding.ItemProductSeriesVerticalBindingImpl;
import com.coolapk.market.databinding.ItemProductSmallRatingArticleBindingImpl;
import com.coolapk.market.databinding.ItemProductSmallRatingFeedBindingImpl;
import com.coolapk.market.databinding.ItemProductTimelineChildBindingImpl;
import com.coolapk.market.databinding.ItemProductViewBindingImpl;
import com.coolapk.market.databinding.ItemProgressHintBindingImpl;
import com.coolapk.market.databinding.ItemQuestionDetailBottomBindingImpl;
import com.coolapk.market.databinding.ItemQuestionDetailViewBindingImpl;
import com.coolapk.market.databinding.ItemQuestionTitleViewBindingImpl;
import com.coolapk.market.databinding.ItemQuestionViewBindingImpl;
import com.coolapk.market.databinding.ItemRankHeaderBindingImpl;
import com.coolapk.market.databinding.ItemRatingCardBindingImpl;
import com.coolapk.market.databinding.ItemReceiverdReplyBindingImpl;
import com.coolapk.market.databinding.ItemRecentHistoryBindingImpl;
import com.coolapk.market.databinding.ItemRecentLoginBindingImpl;
import com.coolapk.market.databinding.ItemRefreshCardBindingImpl;
import com.coolapk.market.databinding.ItemRelateAppCardBindingImpl;
import com.coolapk.market.databinding.ItemRelatedDataBindingImpl;
import com.coolapk.market.databinding.ItemRelativeChildBindingImpl;
import com.coolapk.market.databinding.ItemReplyLikeListBindingImpl;
import com.coolapk.market.databinding.ItemReplyListBindingImpl;
import com.coolapk.market.databinding.ItemReplyMoreBindingImpl;
import com.coolapk.market.databinding.ItemReplyPhotoAddBindingImpl;
import com.coolapk.market.databinding.ItemReplyPhotoBindingImpl;
import com.coolapk.market.databinding.ItemRightCoverViewBindingImpl;
import com.coolapk.market.databinding.ItemSceneRelatedBindingImpl;
import com.coolapk.market.databinding.ItemScrollCardBindingImpl;
import com.coolapk.market.databinding.ItemSearchAppFilterBindingImpl;
import com.coolapk.market.databinding.ItemSearchAskFilterBindingImpl;
import com.coolapk.market.databinding.ItemSearchDropdownBindingImpl;
import com.coolapk.market.databinding.ItemSearchExtendBindingImpl;
import com.coolapk.market.databinding.ItemSearchExtendFooterBindingImpl;
import com.coolapk.market.databinding.ItemSearchExtendHeaderBindingImpl;
import com.coolapk.market.databinding.ItemSearchFeedFilterBindingImpl;
import com.coolapk.market.databinding.ItemSearchHistoryBindingImpl;
import com.coolapk.market.databinding.ItemSearchHotBindingImpl;
import com.coolapk.market.databinding.ItemSearchRecommendBindingImpl;
import com.coolapk.market.databinding.ItemSearchSceneBindingImpl;
import com.coolapk.market.databinding.ItemSearchShFilterBindingImpl;
import com.coolapk.market.databinding.ItemSearchViewBindingImpl;
import com.coolapk.market.databinding.ItemSecondHandDetailBindingImpl;
import com.coolapk.market.databinding.ItemSecondHandFallBindingImpl;
import com.coolapk.market.databinding.ItemSecondHandSearchBindingImpl;
import com.coolapk.market.databinding.ItemSectionDemoTitleBindingImpl;
import com.coolapk.market.databinding.ItemSeeMoreBindingImpl;
import com.coolapk.market.databinding.ItemSelectorLinkViewBindingImpl;
import com.coolapk.market.databinding.ItemServiceAppTimeBindingImpl;
import com.coolapk.market.databinding.ItemSettingBindingImpl;
import com.coolapk.market.databinding.ItemShareAppBindingImpl;
import com.coolapk.market.databinding.ItemSimpleDividerBindingImpl;
import com.coolapk.market.databinding.ItemSimpleEntityHolderBindingImpl;
import com.coolapk.market.databinding.ItemSimpleFeedBindingImpl;
import com.coolapk.market.databinding.ItemSimpleTitleBindingImpl;
import com.coolapk.market.databinding.ItemSimpleUserViewBindingImpl;
import com.coolapk.market.databinding.ItemSingleRatingBindingImpl;
import com.coolapk.market.databinding.ItemSmallScrollCardItemBindingImpl;
import com.coolapk.market.databinding.ItemSortSelectBindingImpl;
import com.coolapk.market.databinding.ItemSpaceBindingImpl;
import com.coolapk.market.databinding.ItemSponsorBindingImpl;
import com.coolapk.market.databinding.ItemSponsorSelfDrawBindingImpl;
import com.coolapk.market.databinding.ItemSponsorSelfDrawNewsBindingImpl;
import com.coolapk.market.databinding.ItemSubmitGoodsCardBindingImpl;
import com.coolapk.market.databinding.ItemTabGroupCardBindingImpl;
import com.coolapk.market.databinding.ItemTabGroupCardItemBindingImpl;
import com.coolapk.market.databinding.ItemTabViewBindingImpl;
import com.coolapk.market.databinding.ItemTextBindingImpl;
import com.coolapk.market.databinding.ItemTextCardBindingImpl;
import com.coolapk.market.databinding.ItemTextCarouselCardBindingImpl;
import com.coolapk.market.databinding.ItemTextImageCardBindingImpl;
import com.coolapk.market.databinding.ItemTextLinkCardItemBindingImpl;
import com.coolapk.market.databinding.ItemTextLinkItemBindingImpl;
import com.coolapk.market.databinding.ItemTextTitleScrollChildBindingImpl;
import com.coolapk.market.databinding.ItemTipEmptyBindingImpl;
import com.coolapk.market.databinding.ItemTitleBindingImpl;
import com.coolapk.market.databinding.ItemTitleCardBindingImpl;
import com.coolapk.market.databinding.ItemTitleListBindingImpl;
import com.coolapk.market.databinding.ItemTitleSectionBindingImpl;
import com.coolapk.market.databinding.ItemTitleViewBindingImpl;
import com.coolapk.market.databinding.ItemTopGroupCardBindingImpl;
import com.coolapk.market.databinding.ItemTopGroupCardItemBindingImpl;
import com.coolapk.market.databinding.ItemTopicBindingImpl;
import com.coolapk.market.databinding.ItemTopicViewBindingImpl;
import com.coolapk.market.databinding.ItemTripleAvatarViewPartBindingImpl;
import com.coolapk.market.databinding.ItemTripleCoolPicBindingImpl;
import com.coolapk.market.databinding.ItemUpgradeBindingImpl;
import com.coolapk.market.databinding.ItemUpgradeCardBindingImpl;
import com.coolapk.market.databinding.ItemUserBindingImpl;
import com.coolapk.market.databinding.ItemUserCoverAddBindingImpl;
import com.coolapk.market.databinding.ItemUserCoverImageBindingImpl;
import com.coolapk.market.databinding.ItemUserCoverTitleBindingImpl;
import com.coolapk.market.databinding.ItemUserDeleteRecentBindingImpl;
import com.coolapk.market.databinding.ItemUserGiftBindingImpl;
import com.coolapk.market.databinding.ItemUserHistoryBindingImpl;
import com.coolapk.market.databinding.ItemUserInfoHeaderViewBindingImpl;
import com.coolapk.market.databinding.ItemUserInfoNumBindingImpl;
import com.coolapk.market.databinding.ItemUserInfoPartBindingImpl;
import com.coolapk.market.databinding.ItemUserNavigationBindingImpl;
import com.coolapk.market.databinding.ItemUserNodeRatingBindingImpl;
import com.coolapk.market.databinding.ItemUserProfileAvatarBindingImpl;
import com.coolapk.market.databinding.ItemUserProfileItemBindingImpl;
import com.coolapk.market.databinding.ItemUserRatingBindingImpl;
import com.coolapk.market.databinding.ItemUserSpaceCountBindingImpl;
import com.coolapk.market.databinding.ItemVersionAppBindingImpl;
import com.coolapk.market.databinding.ItemVideoDetailViewPartBindingImpl;
import com.coolapk.market.databinding.ItemVideoViewBindingImpl;
import com.coolapk.market.databinding.ItemVideoViewPartBindingImpl;
import com.coolapk.market.databinding.ItemVoteCommentEmptyBindingImpl;
import com.coolapk.market.databinding.ItemVoteDetailSplitedTitleBindingImpl;
import com.coolapk.market.databinding.ItemVoteUserBindingImpl;
import com.coolapk.market.databinding.ItemWebViewBindingImpl;
import com.coolapk.market.databinding.ItemWebviewPageBindingImpl;
import com.coolapk.market.databinding.ItemWeuiBindingImpl;
import com.coolapk.market.databinding.KkViewBindingImpl;
import com.coolapk.market.databinding.LayoutImageModeBindingImpl;
import com.coolapk.market.databinding.LayoutListEditButtonBindingImpl;
import com.coolapk.market.databinding.LayoutMessageCardBindingImpl;
import com.coolapk.market.databinding.LayoutPrivacyClauseBindingImpl;
import com.coolapk.market.databinding.LayoutTabConfigBindingImpl;
import com.coolapk.market.databinding.LayoutWaterMarkBindingImpl;
import com.coolapk.market.databinding.LiveActivityBindingImpl;
import com.coolapk.market.databinding.LiveFloatNewMessageBindingImpl;
import com.coolapk.market.databinding.LiveIntroduceBindingImpl;
import com.coolapk.market.databinding.LiveReplyListBindingImpl;
import com.coolapk.market.databinding.LoadingViewBindingImpl;
import com.coolapk.market.databinding.LogItemBindingImpl;
import com.coolapk.market.databinding.MainBindingImpl;
import com.coolapk.market.databinding.MainCategoryLayoutBindingImpl;
import com.coolapk.market.databinding.MainCenterUserPartBindingImpl;
import com.coolapk.market.databinding.MainFragmentBindingImpl;
import com.coolapk.market.databinding.MarketBindingImpl;
import com.coolapk.market.databinding.MessageTopTipBindingImpl;
import com.coolapk.market.databinding.MorePageBindingImpl;
import com.coolapk.market.databinding.NetworkDiagnosisBindingImpl;
import com.coolapk.market.databinding.NewAlbumViewBindingImpl;
import com.coolapk.market.databinding.NewV8AlbumBindingImpl;
import com.coolapk.market.databinding.NightTimePickerBindingImpl;
import com.coolapk.market.databinding.NodePickerBindingImpl;
import com.coolapk.market.databinding.NodeRatingFeedLikeViewBindingImpl;
import com.coolapk.market.databinding.NormalFeedContentV8BindingImpl;
import com.coolapk.market.databinding.PermissionBindingImpl;
import com.coolapk.market.databinding.PhotoBindingImpl;
import com.coolapk.market.databinding.PhotoPickerBindingImpl;
import com.coolapk.market.databinding.PicReplyListBindingImpl;
import com.coolapk.market.databinding.PictureDetailWrapBindingImpl;
import com.coolapk.market.databinding.PoiListBindingImpl;
import com.coolapk.market.databinding.PostButtonSettingBindingImpl;
import com.coolapk.market.databinding.PostMorePanelBindingImpl;
import com.coolapk.market.databinding.ProductBrandListBindingImpl;
import com.coolapk.market.databinding.ProductCouponActivityBindingImpl;
import com.coolapk.market.databinding.ProductNodeHeaderBindingImpl;
import com.coolapk.market.databinding.ProductNodeToolbarContentBindingImpl;
import com.coolapk.market.databinding.ProductPostViewBindingImpl;
import com.coolapk.market.databinding.QrCodeBindingImpl;
import com.coolapk.market.databinding.QuestionTitleBindingImpl;
import com.coolapk.market.databinding.RefreshRecyclerBindingImpl;
import com.coolapk.market.databinding.RefreshRecyclerTabsBindingImpl;
import com.coolapk.market.databinding.ReplyBindingImpl;
import com.coolapk.market.databinding.RvInFragmentLayoutBindingImpl;
import com.coolapk.market.databinding.ScrollableTablayoutBindingImpl;
import com.coolapk.market.databinding.SearchBackHeaderBindingImpl;
import com.coolapk.market.databinding.SearchBindingImpl;
import com.coolapk.market.databinding.SearchDropdownItemBindingImpl;
import com.coolapk.market.databinding.SearchExtendBindingImpl;
import com.coolapk.market.databinding.SearchHistoryBindingImpl;
import com.coolapk.market.databinding.SearchHotBindingImpl;
import com.coolapk.market.databinding.SearchListBindingImpl;
import com.coolapk.market.databinding.SearchListCardBindingImpl;
import com.coolapk.market.databinding.SearchResultBindingImpl;
import com.coolapk.market.databinding.SearchSceneItemBindingImpl;
import com.coolapk.market.databinding.SearchSceneListBindingImpl;
import com.coolapk.market.databinding.SecondHandCommentBarBindingImpl;
import com.coolapk.market.databinding.SecondHandContentV8BindingImpl;
import com.coolapk.market.databinding.SecondHandExtraChildBindingImpl;
import com.coolapk.market.databinding.ServiceAppBindingImpl;
import com.coolapk.market.databinding.ShareFeedV8BindingImpl;
import com.coolapk.market.databinding.ShareGoodDialogBindingImpl;
import com.coolapk.market.databinding.ShareListBindingImpl;
import com.coolapk.market.databinding.ShareListViewBindingImpl;
import com.coolapk.market.databinding.ShareWebviewBindingImpl;
import com.coolapk.market.databinding.SplashBindingImpl;
import com.coolapk.market.databinding.SplashV9BindingImpl;
import com.coolapk.market.databinding.SplashViewBindingImpl;
import com.coolapk.market.databinding.StaticDialogViewBindingImpl;
import com.coolapk.market.databinding.SubmitFeedAddMoreItemDialogBindingImpl;
import com.coolapk.market.databinding.SubmitFeedAddVideoItemDialogBindingImpl;
import com.coolapk.market.databinding.SubmitFeedArticleBottomBindingImpl;
import com.coolapk.market.databinding.SubmitFeedArticleHolder2BindingImpl;
import com.coolapk.market.databinding.SubmitFeedArticleImagePartBindingImpl;
import com.coolapk.market.databinding.SubmitFeedArticleTextPartBindingImpl;
import com.coolapk.market.databinding.SubmitFeedArticleTopAnswerBindingImpl;
import com.coolapk.market.databinding.SubmitFeedArticleTopPartBindingImpl;
import com.coolapk.market.databinding.SubmitFeedBottomAddMoreV8BindingImpl;
import com.coolapk.market.databinding.SubmitFeedBottomSetVisibilityBindingImpl;
import com.coolapk.market.databinding.SubmitFeedExtraChildBindingImpl;
import com.coolapk.market.databinding.SubmitFeedExtraLogoBindingImpl;
import com.coolapk.market.databinding.SubmitFeedGoodsBindingImpl;
import com.coolapk.market.databinding.SubmitFeedNewGoodsBindingImpl;
import com.coolapk.market.databinding.SubmitFeedRelativeInfoPickerBindingImpl;
import com.coolapk.market.databinding.SubmitFeedV8BindingImpl;
import com.coolapk.market.databinding.SubmitPickColorBindingImpl;
import com.coolapk.market.databinding.SubmitProductArticleBottomBindingImpl;
import com.coolapk.market.databinding.SubmitProductArticleTopPartBindingImpl;
import com.coolapk.market.databinding.SubmitProductContentRatingBarBindingImpl;
import com.coolapk.market.databinding.SubmitProductRatingBindingImpl;
import com.coolapk.market.databinding.SubmitRatingNoramlContentBindingImpl;
import com.coolapk.market.databinding.SubmitSecondHandDealExtraChildBindingImpl;
import com.coolapk.market.databinding.SubmitSecondHandExtraChildBindingImpl;
import com.coolapk.market.databinding.SubmitVerifyMobileCodeDialogBindingImpl;
import com.coolapk.market.databinding.SubmitVertfiyCaptchaDialogBindingImpl;
import com.coolapk.market.databinding.SubmitViewArticleAddLinkBindingImpl;
import com.coolapk.market.databinding.SubmitVoteExtraChildBindingImpl;
import com.coolapk.market.databinding.TabLayoutBindingImpl;
import com.coolapk.market.databinding.TagProductOwnerBindingImpl;
import com.coolapk.market.databinding.TestBindingImpl;
import com.coolapk.market.databinding.TextViewBindingImpl;
import com.coolapk.market.databinding.ThemePickDialogBindingImpl;
import com.coolapk.market.databinding.ThemePickerListItemBindingImpl;
import com.coolapk.market.databinding.TipLayoutBindingImpl;
import com.coolapk.market.databinding.ToolbarLayoutBindingImpl;
import com.coolapk.market.databinding.TopicDetailDescriptionBindingImpl;
import com.coolapk.market.databinding.TopicDetailHeadlineBindingImpl;
import com.coolapk.market.databinding.TopicNodeHeaderBindingImpl;
import com.coolapk.market.databinding.TopicNodeHeaderLineBindingImpl;
import com.coolapk.market.databinding.TopicNodePageBindingImpl;
import com.coolapk.market.databinding.TopicPickerBindingImpl;
import com.coolapk.market.databinding.UserAvatarBindingImpl;
import com.coolapk.market.databinding.UserDataBindingImpl;
import com.coolapk.market.databinding.UserKeyInputBindingImpl;
import com.coolapk.market.databinding.UserPickBindingImpl;
import com.coolapk.market.databinding.UserQrcodeBindingImpl;
import com.coolapk.market.databinding.UserSpaceV9BindingImpl;
import com.coolapk.market.databinding.UserToolbarBindingImpl;
import com.coolapk.market.databinding.VideoCompleteBindingImpl;
import com.coolapk.market.databinding.VideoControllerBindingImpl;
import com.coolapk.market.databinding.VideoErrorBindingImpl;
import com.coolapk.market.databinding.VideoFloatingBindingImpl;
import com.coolapk.market.databinding.VideoFullScreenBindingImpl;
import com.coolapk.market.databinding.VideoGestureBindingImpl;
import com.coolapk.market.databinding.VideoLoadingBindingImpl;
import com.coolapk.market.databinding.VideoSimpleControllerBindingImpl;
import com.coolapk.market.databinding.VoteFeedContentBindingImpl;
import com.coolapk.market.databinding.VxLayoutBindingImpl;
import com.coolapk.market.databinding.WebViewBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(654);
    private static final int LAYOUT_ABOUT = 1;
    private static final int LAYOUT_ACTIONITEMAPPMANAGERVIEW = 2;
    private static final int LAYOUT_ACTIONITEMBADGEVIEW = 3;
    private static final int LAYOUT_ACTIONITEMPOST = 4;
    private static final int LAYOUT_ACTIVITYALBUMDETAILBETA = 5;
    private static final int LAYOUT_ACTIVITYWALLPAPER = 6;
    private static final int LAYOUT_ACTIVITYWALLPAPERBETA = 7;
    private static final int LAYOUT_ADDGOODSITEMDIALOG = 8;
    private static final int LAYOUT_ADDTOALBUMEDIT = 9;
    private static final int LAYOUT_ALBUMACTIONBAR = 10;
    private static final int LAYOUT_ALBUMACTIONVIEW = 11;
    private static final int LAYOUT_ALBUMBASEINFO = 12;
    private static final int LAYOUT_ALBUMCOMMENTBAR = 13;
    private static final int LAYOUT_ALBUMDETAIL = 14;
    private static final int LAYOUT_ALBUMDETAILTVIEW = 16;
    private static final int LAYOUT_ALBUMDETAILV8V2 = 15;
    private static final int LAYOUT_ALBUMHEADERVIEWV2 = 17;
    private static final int LAYOUT_ALBUMITEMBASEINFO = 18;
    private static final int LAYOUT_ALBUMLISTITEMCARDNONUPLE = 19;
    private static final int LAYOUT_ALBUMLISTITEMCARDNONUPLEITEM = 20;
    private static final int LAYOUT_ALBUMTESTVIEW = 21;
    private static final int LAYOUT_ALBUMUSERINFO = 22;
    private static final int LAYOUT_ALBUMV8DETAIL = 23;
    private static final int LAYOUT_ALPHATOOLBAR = 24;
    private static final int LAYOUT_APPDETAIL = 25;
    private static final int LAYOUT_APPEXTENSIONBARV3 = 26;
    private static final int LAYOUT_APPEXTENSIONITEM = 27;
    private static final int LAYOUT_APPEXTENSIONITEMPOST = 28;
    private static final int LAYOUT_APPMAINMODELSELECT = 29;
    private static final int LAYOUT_APPNODECOMMUNITYHEADER = 30;
    private static final int LAYOUT_APPNODEHEADER = 31;
    private static final int LAYOUT_APPNODETOOLBARCONTENT = 32;
    private static final int LAYOUT_APPVIEW = 33;
    private static final int LAYOUT_APPVIEWBASEINFO = 34;
    private static final int LAYOUT_APPVIEWRECYCLER = 35;
    private static final int LAYOUT_APPVIEWV8 = 36;
    private static final int LAYOUT_ARTICLEDETAILIMAGEPART = 37;
    private static final int LAYOUT_ARTICLEDETAILTEXTPART = 38;
    private static final int LAYOUT_BASECHATTING = 39;
    private static final int LAYOUT_BASENEWCHATTING = 40;
    private static final int LAYOUT_CENTERV9SOCIALDIALOG = 41;
    private static final int LAYOUT_COLLECTIONSELECT = 42;
    private static final int LAYOUT_COMMENTBAR = 43;
    private static final int LAYOUT_COOLBROWSER = 44;
    private static final int LAYOUT_COOLPICFULLSCREEN = 45;
    private static final int LAYOUT_COOLPICIMGLAYOUT = 46;
    private static final int LAYOUT_CREATECOLLECTLIST = 47;
    private static final int LAYOUT_CREATEFUNTHINGS = 48;
    private static final int LAYOUT_CREATEGOODS = 49;
    private static final int LAYOUT_CUSTOMTHEME = 50;
    private static final int LAYOUT_DIALOGADDBLOCKWORD = 51;
    private static final int LAYOUT_DIALOGADDTOGOODSLIST = 52;
    private static final int LAYOUT_DIALOGALBUMCREATE = 53;
    private static final int LAYOUT_DIALOGALBUMITEMNOTE = 55;
    private static final int LAYOUT_DIALOGALBUMITEMPX = 56;
    private static final int LAYOUT_DIALOGALBUMMOBILEAPPNOTE = 54;
    private static final int LAYOUT_DIALOGAPPRATING = 57;
    private static final int LAYOUT_DIALOGBACKUPCREATE = 58;
    private static final int LAYOUT_DIALOGBLOCKNODE = 59;
    private static final int LAYOUT_DIALOGCITYPICKER = 60;
    private static final int LAYOUT_DIALOGCOMPLETENAV = 61;
    private static final int LAYOUT_DIALOGDATEPICKER = 62;
    private static final int LAYOUT_DIALOGEDIT = 63;
    private static final int LAYOUT_DIALOGEDITSUBMIT = 64;
    private static final int LAYOUT_DIALOGGENDERPICKER = 65;
    private static final int LAYOUT_DIALOGGOODSLISTEDIT = 66;
    private static final int LAYOUT_DIALOGITEMTEXTVIEW = 67;
    private static final int LAYOUT_DIALOGLISTITEMVIEW = 68;
    private static final int LAYOUT_DIALOGMESSAGECARD = 69;
    private static final int LAYOUT_DIALOGPROGRASSVIEW = 70;
    private static final int LAYOUT_DIALOGSECONDHANDAGREEMENT = 71;
    private static final int LAYOUT_DIALOGSECONDHANDEDIT = 72;
    private static final int LAYOUT_DIALOGSECONDHANDPRICE = 73;
    private static final int LAYOUT_DIALOGSELECTITEM = 74;
    private static final int LAYOUT_DIALOGSELETORCONTAINER = 75;
    private static final int LAYOUT_DIALOGSHARE = 76;
    private static final int LAYOUT_DIALOGTIMEPICKER = 77;
    private static final int LAYOUT_DISCOVERY = 78;
    private static final int LAYOUT_DISCOVERYSUBMIT = 79;
    private static final int LAYOUT_DYHHEADERVIEW = 80;
    private static final int LAYOUT_DYHINCLUD = 81;
    private static final int LAYOUT_EDITUSERVIEW = 82;
    private static final int LAYOUT_EMOTIONPANEL = 83;
    private static final int LAYOUT_EMOTIONPANELBOTTOMTEXT = 84;
    private static final int LAYOUT_FAB = 85;
    private static final int LAYOUT_FEEDACTIONBAR = 86;
    private static final int LAYOUT_FEEDANSWERVIEWPART = 87;
    private static final int LAYOUT_FEEDBINDGOODSMAIN = 88;
    private static final int LAYOUT_FEEDBLOCKITEMS = 89;
    private static final int LAYOUT_FEEDCOMMENTBAR = 90;
    private static final int LAYOUT_FEEDCOMMENTCOUNTVIEWPART = 91;
    private static final int LAYOUT_FEEDENTRANCEITEMS = 92;
    private static final int LAYOUT_FEEDENTRANCELONGITEMS = 93;
    private static final int LAYOUT_FEEDENTRANCEV8 = 94;
    private static final int LAYOUT_FEEDREPLYDETAIL = 95;
    private static final int LAYOUT_FEEDREPLYDETAILHEADER = 96;
    private static final int LAYOUT_FEEDTOP = 97;
    private static final int LAYOUT_FEEDWARNING = 98;
    private static final int LAYOUT_FETCHGIFT = 99;
    private static final int LAYOUT_FIXEDTABLAYOUT = 100;
    private static final int LAYOUT_FORWARDPREVIEW = 101;
    private static final int LAYOUT_GOODSCOUPONSEARCH = 102;
    private static final int LAYOUT_GOODSDETAIL = 103;
    private static final int LAYOUT_GOODSSEARCH = 104;
    private static final int LAYOUT_HOME = 105;
    private static final int LAYOUT_ITEMACCOUNTTIPS = 106;
    private static final int LAYOUT_ITEMACTIONSHEETDIALOG = 107;
    private static final int LAYOUT_ITEMADDTOALBUM = 108;
    private static final int LAYOUT_ITEMADDTOALBUMHEADER = 109;
    private static final int LAYOUT_ITEMADDTOGOODSLIST = 110;
    private static final int LAYOUT_ITEMADS = 111;
    private static final int LAYOUT_ITEMALBUM = 112;
    private static final int LAYOUT_ITEMALBUMAPP = 113;
    private static final int LAYOUT_ITEMALBUMAPPEDIT = 114;
    private static final int LAYOUT_ITEMALBUMEDITHEADER = 115;
    private static final int LAYOUT_ITEMALBUMEXPANDCARD = 116;
    private static final int LAYOUT_ITEMALBUMFEEDBASE = 117;
    private static final int LAYOUT_ITEMALBUMICON = 118;
    private static final int LAYOUT_ITEMALBUMWITHAVATAR = 119;
    private static final int LAYOUT_ITEMALERTMESSAGECARD = 120;
    private static final int LAYOUT_ITEMANSWERVIEW = 121;
    private static final int LAYOUT_ITEMAPKSCROLLWITHBACKGROUND = 122;
    private static final int LAYOUT_ITEMAPPCATEGORY = 123;
    private static final int LAYOUT_ITEMAPPDETAIL = 124;
    private static final int LAYOUT_ITEMAPPFORUM = 125;
    private static final int LAYOUT_ITEMAPPINSIDEIMAGECARD = 126;
    private static final int LAYOUT_ITEMAPPNODECOUPON = 127;
    private static final int LAYOUT_ITEMAPPNODEGIFT = 128;
    private static final int LAYOUT_ITEMAPPNODETAG = 129;
    private static final int LAYOUT_ITEMAPPNODETHUMBNAIL = 130;
    private static final int LAYOUT_ITEMAPPPHOTOTHUMBNAIL = 131;
    private static final int LAYOUT_ITEMAPPUPDATAMANAGER = 132;
    private static final int LAYOUT_ITEMAPPVIEWBASEINFO = 133;
    private static final int LAYOUT_ITEMAPPVIEWBASEINFOCOUPONITEM = 134;
    private static final int LAYOUT_ITEMAPPVIEWBASEINFOGIFT = 135;
    private static final int LAYOUT_ITEMAPPVIEWCOMMENTTITLE = 136;
    private static final int LAYOUT_ITEMAPPVIEWDOWNLOAD = 137;
    private static final int LAYOUT_ITEMAPPVIEWGIFT = 138;
    private static final int LAYOUT_ITEMAPPVIEWHOLDER = 139;
    private static final int LAYOUT_ITEMAPPVIEWINTERACTIVE = 140;
    private static final int LAYOUT_ITEMAPPVIEWRATING = 141;
    private static final int LAYOUT_ITEMARTICLEANSWERPREVIEWTOP = 142;
    private static final int LAYOUT_ITEMARTICLECARDGOODS = 143;
    private static final int LAYOUT_ITEMARTICLEDETAILANSWERTOP = 144;
    private static final int LAYOUT_ITEMARTICLEDETAILTOP = 145;
    private static final int LAYOUT_ITEMARTICLEEDITSHAREURL = 146;
    private static final int LAYOUT_ITEMARTICLEEDITSHAREURLCONTAINER = 147;
    private static final int LAYOUT_ITEMARTICLEFEEDPREVIEWTOP = 148;
    private static final int LAYOUT_ITEMARTICLEVIEWIMAGE = 149;
    private static final int LAYOUT_ITEMARTICLEVIEWTEXT = 150;
    private static final int LAYOUT_ITEMBACKAPPSWITCH = 151;
    private static final int LAYOUT_ITEMBACKUP = 152;
    private static final int LAYOUT_ITEMBACKUPAPP = 153;
    private static final int LAYOUT_ITEMBACKUPHEADER = 154;
    private static final int LAYOUT_ITEMBACKUPHEADERINFO = 155;
    private static final int LAYOUT_ITEMBACKUPHEADERTITLE = 156;
    private static final int LAYOUT_ITEMBINDGOODSCHILD = 157;
    private static final int LAYOUT_ITEMBLACKLIST = 158;
    private static final int LAYOUT_ITEMBLOCKHEADER = 159;
    private static final int LAYOUT_ITEMBLOCKNODE = 160;
    private static final int LAYOUT_ITEMBLOCKUSER = 161;
    private static final int LAYOUT_ITEMBLOCKWORD = 162;
    private static final int LAYOUT_ITEMCAPSULELIST = 163;
    private static final int LAYOUT_ITEMCARDADD = 164;
    private static final int LAYOUT_ITEMCARDDOUBLE = 165;
    private static final int LAYOUT_ITEMCARDDOUBLEITEM = 166;
    private static final int LAYOUT_ITEMCARDMANAGER = 167;
    private static final int LAYOUT_ITEMCARDMANAGERTITLE = 168;
    private static final int LAYOUT_ITEMCARDTRIPLE = 169;
    private static final int LAYOUT_ITEMCARDTRIPLEITEM = 170;
    private static final int LAYOUT_ITEMCATEGORYDETAILRANK = 171;
    private static final int LAYOUT_ITEMCATEGORYHEADER = 172;
    private static final int LAYOUT_ITEMCENTERLOGIN = 173;
    private static final int LAYOUT_ITEMCENTERMOREENTRANCE = 174;
    private static final int LAYOUT_ITEMCENTERMOREENTRANCECHILD = 175;
    private static final int LAYOUT_ITEMCENTERMOREMENU = 176;
    private static final int LAYOUT_ITEMCENTERMORETITLE = 177;
    private static final int LAYOUT_ITEMCENTERUSERINFO = 178;
    private static final int LAYOUT_ITEMCENTERUSERMENU = 179;
    private static final int LAYOUT_ITEMCENTERUSERMENUCHILD = 180;
    private static final int LAYOUT_ITEMCHANNELTAB = 181;
    private static final int LAYOUT_ITEMCHANNELTITLE = 182;
    private static final int LAYOUT_ITEMCHATINGMINE = 183;
    private static final int LAYOUT_ITEMCHATINGMINECARD = 184;
    private static final int LAYOUT_ITEMCHATINGUSER = 185;
    private static final int LAYOUT_ITEMCHATINGUSERCARD = 186;
    private static final int LAYOUT_ITEMCIRCLEFEEDTOP = 187;
    private static final int LAYOUT_ITEMCOLLECTION = 188;
    private static final int LAYOUT_ITEMCOLLECTIONFOOT = 189;
    private static final int LAYOUT_ITEMCOLLECTIONHEADER = 190;
    private static final int LAYOUT_ITEMCOLLECTIONSELECT = 191;
    private static final int LAYOUT_ITEMCOLORFULFATSCROLLCARDCHILD = 192;
    private static final int LAYOUT_ITEMCOLORFULSCROLLCARDCHILD = 193;
    private static final int LAYOUT_ITEMCOMMENTBARCHILDVIEW = 194;
    private static final int LAYOUT_ITEMCONTACT = 195;
    private static final int LAYOUT_ITEMCOOLPICDETAIL = 198;
    private static final int LAYOUT_ITEMCOOLPICFALL = 199;
    private static final int LAYOUT_ITEMCOOLPICIMAGE = 196;
    private static final int LAYOUT_ITEMCOOLPICIMAGEVIEW = 197;
    private static final int LAYOUT_ITEMCOVERVIEW = 200;
    private static final int LAYOUT_ITEMCREATEGOODSLIST = 201;
    private static final int LAYOUT_ITEMDEVELOPERAPP = 202;
    private static final int LAYOUT_ITEMDEVELOPERCARD = 203;
    private static final int LAYOUT_ITEMDEVICEPARAMS = 204;
    private static final int LAYOUT_ITEMDISCOVERYIMAGEVIEWV8 = 205;
    private static final int LAYOUT_ITEMDISCOVERYVIEW = 206;
    private static final int LAYOUT_ITEMDOCLISTCARD = 207;
    private static final int LAYOUT_ITEMDOCLISTCARDITEM = 208;
    private static final int LAYOUT_ITEMDOCMARQUEECARD = 209;
    private static final int LAYOUT_ITEMDOWNLOAD = 210;
    private static final int LAYOUT_ITEMDYHARTICLEACTION = 220;
    private static final int LAYOUT_ITEMDYHARTICLECONTENT = 211;
    private static final int LAYOUT_ITEMDYHARTICLEHEADER = 212;
    private static final int LAYOUT_ITEMDYHARTICLEV8 = 213;
    private static final int LAYOUT_ITEMDYHDETAILV8 = 214;
    private static final int LAYOUT_ITEMDYHINCLUD = 215;
    private static final int LAYOUT_ITEMDYHMINIHEADER = 216;
    private static final int LAYOUT_ITEMDYHSIMPLEHEADER = 217;
    private static final int LAYOUT_ITEMDYHSOURCEPART = 218;
    private static final int LAYOUT_ITEMDYHSOURCETITLE = 219;
    private static final int LAYOUT_ITEMEDITGOODS = 221;
    private static final int LAYOUT_ITEMEMPTYVIEW = 222;
    private static final int LAYOUT_ITEMENTITYVIDEODETAILVIEWPART = 223;
    private static final int LAYOUT_ITEMFAVORITE = 224;
    private static final int LAYOUT_ITEMFEEDACTIONVIEW = 225;
    private static final int LAYOUT_ITEMFEEDALBUMLAYOUT = 226;
    private static final int LAYOUT_ITEMFEEDBASE = 227;
    private static final int LAYOUT_ITEMFEEDBINDGOODS = 228;
    private static final int LAYOUT_ITEMFEEDCOOLPICDETAIL = 229;
    private static final int LAYOUT_ITEMFEEDCOOLPICLAYOUT = 230;
    private static final int LAYOUT_ITEMFEEDCOVERVIEW = 231;
    private static final int LAYOUT_ITEMFEEDDETAILVIEWV8 = 232;
    private static final int LAYOUT_ITEMFEEDDISCOVERYDETAIL = 233;
    private static final int LAYOUT_ITEMFEEDEXTRATYPEPART = 234;
    private static final int LAYOUT_ITEMFEEDFILTER = 235;
    private static final int LAYOUT_ITEMFEEDFOLLOWABLEHEADERVIEW = 236;
    private static final int LAYOUT_ITEMFEEDFORWARDVIEW = 237;
    private static final int LAYOUT_ITEMFEEDGOODS = 238;
    private static final int LAYOUT_ITEMFEEDGOODSDETAIL = 239;
    private static final int LAYOUT_ITEMFEEDGOODSDETAILIMAGE = 240;
    private static final int LAYOUT_ITEMFEEDGOODSINFO = 241;
    private static final int LAYOUT_ITEMFEEDHEADERVIEW = 242;
    private static final int LAYOUT_ITEMFEEDIMAGE = 243;
    private static final int LAYOUT_ITEMFEEDLAYOUTV8 = 244;
    private static final int LAYOUT_ITEMFEEDNEWSBOTTOM = 245;
    private static final int LAYOUT_ITEMFEEDNEWSVIEW = 246;
    private static final int LAYOUT_ITEMFEEDRATING = 247;
    private static final int LAYOUT_ITEMFEEDRATINGDATA = 248;
    private static final int LAYOUT_ITEMFEEDRATINGDETAIL = 249;
    private static final int LAYOUT_ITEMFEEDRATINGHEADER = 250;
    private static final int LAYOUT_ITEMFEEDRATINGVIEW = 251;
    private static final int LAYOUT_ITEMFEEDREPLY = 252;
    private static final int LAYOUT_ITEMFEEDREPLYHOT = 253;
    private static final int LAYOUT_ITEMFEEDREPLYME = 254;
    private static final int LAYOUT_ITEMFEEDREPLYPART = 255;
    private static final int LAYOUT_ITEMFEEDREPLYTEXT = 256;
    private static final int LAYOUT_ITEMFEEDREPLYTITLE = 257;
    private static final int LAYOUT_ITEMFEEDROUGHDRAFT = 258;
    private static final int LAYOUT_ITEMFEEDSCROLLITEM = 259;
    private static final int LAYOUT_ITEMFEEDSECONDHANDHEADERVIEWPART = 260;
    private static final int LAYOUT_ITEMFEEDSECONDHANDVIEWPART = 261;
    private static final int LAYOUT_ITEMFEEDSHAREACTIONVIEW = 262;
    private static final int LAYOUT_ITEMFEEDSMALLHEADERVIEW = 263;
    private static final int LAYOUT_ITEMFEEDSMALLTITLE = 264;
    private static final int LAYOUT_ITEMFEEDSOURCEDELETED = 265;
    private static final int LAYOUT_ITEMFEEDSOURCEPART = 266;
    private static final int LAYOUT_ITEMFEEDSTACKITEM = 267;
    private static final int LAYOUT_ITEMFEEDTARGETVIEW = 268;
    private static final int LAYOUT_ITEMFEEDTITLE = 269;
    private static final int LAYOUT_ITEMFEEDVIDEODETAILVIEWPART = 270;
    private static final int LAYOUT_ITEMFEEDVOTE = 271;
    private static final int LAYOUT_ITEMFEEDVOTECOMMENT = 272;
    private static final int LAYOUT_ITEMFEEDVOTECOMMENTDETAIL = 273;
    private static final int LAYOUT_ITEMFEEDVOTECOMMENTSMALL = 274;
    private static final int LAYOUT_ITEMFEEDVOTECOMMENTVIEWPART = 275;
    private static final int LAYOUT_ITEMFEEDVOTEHEADER = 276;
    private static final int LAYOUT_ITEMFEEDVOTEMULTI = 277;
    private static final int LAYOUT_ITEMFEEDVOTEPK = 278;
    private static final int LAYOUT_ITEMFEEDVOTEPKRESULT = 279;
    private static final int LAYOUT_ITEMFILE = 280;
    private static final int LAYOUT_ITEMFILETITLE = 281;
    private static final int LAYOUT_ITEMFOLDEDVIEW = 282;
    private static final int LAYOUT_ITEMFOLLOWDYH = 283;
    private static final int LAYOUT_ITEMFOOT = 284;
    private static final int LAYOUT_ITEMFORWARDENTITYSHAREAPP = 285;
    private static final int LAYOUT_ITEMFUNTHING = 286;
    private static final int LAYOUT_ITEMGIFTITEM = 287;
    private static final int LAYOUT_ITEMGOODGOODS = 288;
    private static final int LAYOUT_ITEMGOODGOODSADD = 289;
    private static final int LAYOUT_ITEMGOODGOODSLISTHEADER = 290;
    private static final int LAYOUT_ITEMGOODS = 291;
    private static final int LAYOUT_ITEMGOODSFALL = 292;
    private static final int LAYOUT_ITEMGOODSLIST = 293;
    private static final int LAYOUT_ITEMGOODSLISTEDITHEADER = 294;
    private static final int LAYOUT_ITEMGOODSLISTFEED = 295;
    private static final int LAYOUT_ITEMGOODSLISTSIMPLE = 296;
    private static final int LAYOUT_ITEMGOODSPARAMS = 297;
    private static final int LAYOUT_ITEMGOODSV10 = 298;
    private static final int LAYOUT_ITEMGRIDALBUMCARD = 299;
    private static final int LAYOUT_ITEMGRIDCARD = 300;
    private static final int LAYOUT_ITEMGRIDCARDITEM = 301;
    private static final int LAYOUT_ITEMGRIDCARDVIEW = 302;
    private static final int LAYOUT_ITEMGRIDDYHCARD = 303;
    private static final int LAYOUT_ITEMGRIDDYHCARDITEM = 304;
    private static final int LAYOUT_ITEMGRIDITEMLONGTITLE = 305;
    private static final int LAYOUT_ITEMGROUPLISTCARD = 306;
    private static final int LAYOUT_ITEMHEADCARD = 307;
    private static final int LAYOUT_ITEMHEADLINETITLE = 308;
    private static final int LAYOUT_ITEMHOTFEEDREPLYVIEWPART = 309;
    private static final int LAYOUT_ITEMHOTSEARCHLIST = 310;
    private static final int LAYOUT_ITEMHOTSEARCHUSER = 311;
    private static final int LAYOUT_ITEMICONBUTTONGRIDCARD = 312;
    private static final int LAYOUT_ITEMICONGRIDCARDITEM = 313;
    private static final int LAYOUT_ITEMICONLINKGRIDCARD = 314;
    private static final int LAYOUT_ITEMICONLINKGRIDCARDITEM = 315;
    private static final int LAYOUT_ITEMICONLINKMINIGRIDCARDITEM = 316;
    private static final int LAYOUT_ITEMICONMINIGRIDCARD = 317;
    private static final int LAYOUT_ITEMICONMINIGRIDCARDITEM = 318;
    private static final int LAYOUT_ITEMICONTITLEVIEW = 319;
    private static final int LAYOUT_ITEMIMAGEAPPBIGCARD = 320;
    private static final int LAYOUT_ITEMIMAGEAPPCARD = 321;
    private static final int LAYOUT_ITEMIMAGECARD = 322;
    private static final int LAYOUT_ITEMIMAGECAROUSELCARD1ITEM = 323;
    private static final int LAYOUT_ITEMIMAGECAROUSELCARD2 = 324;
    private static final int LAYOUT_ITEMIMAGECAROUSELCARD2ITEM = 325;
    private static final int LAYOUT_ITEMIMAGELISTCARD = 326;
    private static final int LAYOUT_ITEMIMAGESCROLLCARD = 327;
    private static final int LAYOUT_ITEMIMAGESCROLLCARDITEM = 328;
    private static final int LAYOUT_ITEMIMAGETEXTCARDCHILD = 329;
    private static final int LAYOUT_ITEMLARGESCROLLCARDGOODSITEM = 330;
    private static final int LAYOUT_ITEMLARGESCROLLCARDITEM = 331;
    private static final int LAYOUT_ITEMLARGETEXT = 332;
    private static final int LAYOUT_ITEMLAYOUTDYHINCLUD = 333;
    private static final int LAYOUT_ITEMLIBRARYSHOW = 334;
    private static final int LAYOUT_ITEMLINKCARD = 335;
    private static final int LAYOUT_ITEMLINKCARDTAB = 336;
    private static final int LAYOUT_ITEMLINKCARDV8 = 337;
    private static final int LAYOUT_ITEMLISTCARD = 338;
    private static final int LAYOUT_ITEMLIVECARD = 339;
    private static final int LAYOUT_ITEMLIVEIMAGETEXTCARD = 340;
    private static final int LAYOUT_ITEMLIVEITEMCARD = 341;
    private static final int LAYOUT_ITEMLIVELINEVIEWPART = 342;
    private static final int LAYOUT_ITEMLIVEMESSAGE = 343;
    private static final int LAYOUT_ITEMLIVESYSTEMMESSAGE = 344;
    private static final int LAYOUT_ITEMLIVEVIDEOVIEWPART = 345;
    private static final int LAYOUT_ITEMLOCALAPK = 346;
    private static final int LAYOUT_ITEMLOCALAPP = 347;
    private static final int LAYOUT_ITEMLOCATION = 348;
    private static final int LAYOUT_ITEMLOGFILE = 349;
    private static final int LAYOUT_ITEMLOGINCARD = 350;
    private static final int LAYOUT_ITEMLOGINUSERNODERATINGSELECTOR = 351;
    private static final int LAYOUT_ITEMMAINCATEGORYCHILD = 352;
    private static final int LAYOUT_ITEMMAINCATEGORYDETAILS = 353;
    private static final int LAYOUT_ITEMMAINCATEGORYLINK = 354;
    private static final int LAYOUT_ITEMMAINCATOGORYTYPE = 355;
    private static final int LAYOUT_ITEMMARKETAPPS = 356;
    private static final int LAYOUT_ITEMMENUITEM = 357;
    private static final int LAYOUT_ITEMMESSAGE = 358;
    private static final int LAYOUT_ITEMMESSAGECARD = 359;
    private static final int LAYOUT_ITEMMESSAGEEXTRA = 360;
    private static final int LAYOUT_ITEMMESSAGESELECTVIEW = 361;
    private static final int LAYOUT_ITEMMOBILEALBUMAPPNEW = 362;
    private static final int LAYOUT_ITEMMOBILEAPP = 363;
    private static final int LAYOUT_ITEMMOBILEAPPSWITCH = 364;
    private static final int LAYOUT_ITEMMOREACTION = 365;
    private static final int LAYOUT_ITEMMYEMPTYCARD = 366;
    private static final int LAYOUT_ITEMNEWADD = 367;
    private static final int LAYOUT_ITEMNEWFEEDIMAGE = 368;
    private static final int LAYOUT_ITEMNEWGRIDCARD = 369;
    private static final int LAYOUT_ITEMNODEPICKITEM = 372;
    private static final int LAYOUT_ITEMNODERATING = 373;
    private static final int LAYOUT_ITEMNODERATINGSELECTOR = 374;
    private static final int LAYOUT_ITEMNODETOPCONTENITEM = 375;
    private static final int LAYOUT_ITEMNOLOGINTITEL = 370;
    private static final int LAYOUT_ITEMNOMOREDATAVIEW = 371;
    private static final int LAYOUT_ITEMNOTIFICATION = 376;
    private static final int LAYOUT_ITEMNOTIFICATIONALBUMLIKE = 377;
    private static final int LAYOUT_ITEMNOTIFICATIONFEEDLIKE = 378;
    private static final int LAYOUT_ITEMNOTIFICATIONFEEDREPLYLIKE = 379;
    private static final int LAYOUT_ITEMNOTIFICATIONNAVI = 380;
    private static final int LAYOUT_ITEMOPTIONSTITLE = 381;
    private static final int LAYOUT_ITEMPERMISSION = 382;
    private static final int LAYOUT_ITEMPERMISSIONS = 383;
    private static final int LAYOUT_ITEMPHOTODIRECTORY = 384;
    private static final int LAYOUT_ITEMPHOTOPICKER = 385;
    private static final int LAYOUT_ITEMPHOTOVIEW = 386;
    private static final int LAYOUT_ITEMPICCATEGORY = 387;
    private static final int LAYOUT_ITEMPICKAPP = 389;
    private static final int LAYOUT_ITEMPICKSERVICEAPP = 390;
    private static final int LAYOUT_ITEMPICTURESWITCH = 391;
    private static final int LAYOUT_ITEMPICTYPETAB = 388;
    private static final int LAYOUT_ITEMPLACEHOLDER = 392;
    private static final int LAYOUT_ITEMPODIUMCARD = 393;
    private static final int LAYOUT_ITEMPODIUMCARDITEM = 394;
    private static final int LAYOUT_ITEMPRODUCTBRANDLEFTITEM = 395;
    private static final int LAYOUT_ITEMPRODUCTCONFIGITEM = 396;
    private static final int LAYOUT_ITEMPRODUCTCONFIGTITLE = 397;
    private static final int LAYOUT_ITEMPRODUCTCOUPON = 398;
    private static final int LAYOUT_ITEMPRODUCTCOUPONDEVICE = 399;
    private static final int LAYOUT_ITEMPRODUCTDESCRIPTION = 400;
    private static final int LAYOUT_ITEMPRODUCTEXTRAPARAMS = 401;
    private static final int LAYOUT_ITEMPRODUCTMEDIA = 402;
    private static final int LAYOUT_ITEMPRODUCTMULTIRATINGMAP = 403;
    private static final int LAYOUT_ITEMPRODUCTPARAMS = 404;
    private static final int LAYOUT_ITEMPRODUCTSCOREVIEW = 405;
    private static final int LAYOUT_ITEMPRODUCTSERIES = 406;
    private static final int LAYOUT_ITEMPRODUCTSERIESCHILD = 407;
    private static final int LAYOUT_ITEMPRODUCTSERIESERSHOU = 408;
    private static final int LAYOUT_ITEMPRODUCTSERIESHORIZONTAL = 409;
    private static final int LAYOUT_ITEMPRODUCTSERIESLISTMORE = 410;
    private static final int LAYOUT_ITEMPRODUCTSERIESLISTTITLE = 411;
    private static final int LAYOUT_ITEMPRODUCTSERIESVERTICAL = 412;
    private static final int LAYOUT_ITEMPRODUCTSMALLRATINGARTICLE = 413;
    private static final int LAYOUT_ITEMPRODUCTSMALLRATINGFEED = 414;
    private static final int LAYOUT_ITEMPRODUCTTIMELINECHILD = 415;
    private static final int LAYOUT_ITEMPRODUCTVIEW = 416;
    private static final int LAYOUT_ITEMPROGRESSHINT = 417;
    private static final int LAYOUT_ITEMQUESTIONDETAILBOTTOM = 418;
    private static final int LAYOUT_ITEMQUESTIONDETAILVIEW = 419;
    private static final int LAYOUT_ITEMQUESTIONTITLEVIEW = 420;
    private static final int LAYOUT_ITEMQUESTIONVIEW = 421;
    private static final int LAYOUT_ITEMRANKHEADER = 422;
    private static final int LAYOUT_ITEMRATINGCARD = 423;
    private static final int LAYOUT_ITEMRECEIVERDREPLY = 424;
    private static final int LAYOUT_ITEMRECENTHISTORY = 425;
    private static final int LAYOUT_ITEMRECENTLOGIN = 426;
    private static final int LAYOUT_ITEMREFRESHCARD = 427;
    private static final int LAYOUT_ITEMRELATEAPPCARD = 428;
    private static final int LAYOUT_ITEMRELATEDDATA = 429;
    private static final int LAYOUT_ITEMRELATIVECHILD = 430;
    private static final int LAYOUT_ITEMREPLYLIKELIST = 431;
    private static final int LAYOUT_ITEMREPLYLIST = 432;
    private static final int LAYOUT_ITEMREPLYMORE = 433;
    private static final int LAYOUT_ITEMREPLYPHOTO = 434;
    private static final int LAYOUT_ITEMREPLYPHOTOADD = 435;
    private static final int LAYOUT_ITEMRIGHTCOVERVIEW = 436;
    private static final int LAYOUT_ITEMSCENERELATED = 437;
    private static final int LAYOUT_ITEMSCROLLCARD = 438;
    private static final int LAYOUT_ITEMSEARCHAPPFILTER = 439;
    private static final int LAYOUT_ITEMSEARCHASKFILTER = 440;
    private static final int LAYOUT_ITEMSEARCHDROPDOWN = 441;
    private static final int LAYOUT_ITEMSEARCHEXTEND = 442;
    private static final int LAYOUT_ITEMSEARCHEXTENDFOOTER = 443;
    private static final int LAYOUT_ITEMSEARCHEXTENDHEADER = 444;
    private static final int LAYOUT_ITEMSEARCHFEEDFILTER = 445;
    private static final int LAYOUT_ITEMSEARCHHISTORY = 446;
    private static final int LAYOUT_ITEMSEARCHHOT = 447;
    private static final int LAYOUT_ITEMSEARCHRECOMMEND = 448;
    private static final int LAYOUT_ITEMSEARCHSCENE = 449;
    private static final int LAYOUT_ITEMSEARCHSHFILTER = 450;
    private static final int LAYOUT_ITEMSEARCHVIEW = 451;
    private static final int LAYOUT_ITEMSECONDHANDDETAIL = 452;
    private static final int LAYOUT_ITEMSECONDHANDFALL = 453;
    private static final int LAYOUT_ITEMSECONDHANDSEARCH = 454;
    private static final int LAYOUT_ITEMSECTIONDEMOTITLE = 455;
    private static final int LAYOUT_ITEMSEEMORE = 456;
    private static final int LAYOUT_ITEMSELECTORLINKVIEW = 457;
    private static final int LAYOUT_ITEMSERVICEAPP = 458;
    private static final int LAYOUT_ITEMSERVICEAPPTIME = 459;
    private static final int LAYOUT_ITEMSETTING = 460;
    private static final int LAYOUT_ITEMSHAREAPP = 461;
    private static final int LAYOUT_ITEMSIMPLEDIVIDER = 462;
    private static final int LAYOUT_ITEMSIMPLEENTITYHOLDER = 463;
    private static final int LAYOUT_ITEMSIMPLEFEED = 464;
    private static final int LAYOUT_ITEMSIMPLETITLE = 465;
    private static final int LAYOUT_ITEMSIMPLEUSERVIEW = 466;
    private static final int LAYOUT_ITEMSINGLERATING = 467;
    private static final int LAYOUT_ITEMSMALLSCROLLCARDITEM = 468;
    private static final int LAYOUT_ITEMSORTSELECT = 469;
    private static final int LAYOUT_ITEMSPACE = 470;
    private static final int LAYOUT_ITEMSPONSOR = 471;
    private static final int LAYOUT_ITEMSPONSORSELFDRAW = 472;
    private static final int LAYOUT_ITEMSPONSORSELFDRAWNEWS = 473;
    private static final int LAYOUT_ITEMSUBMITGOODSCARD = 474;
    private static final int LAYOUT_ITEMTABGROUPCARD = 475;
    private static final int LAYOUT_ITEMTABGROUPCARDITEM = 476;
    private static final int LAYOUT_ITEMTABVIEW = 477;
    private static final int LAYOUT_ITEMTEXT = 478;
    private static final int LAYOUT_ITEMTEXTCARD = 479;
    private static final int LAYOUT_ITEMTEXTCAROUSELCARD = 480;
    private static final int LAYOUT_ITEMTEXTIMAGECARD = 481;
    private static final int LAYOUT_ITEMTEXTLINKCARDITEM = 482;
    private static final int LAYOUT_ITEMTEXTLINKITEM = 483;
    private static final int LAYOUT_ITEMTEXTTITLESCROLLCHILD = 484;
    private static final int LAYOUT_ITEMTIPEMPTY = 485;
    private static final int LAYOUT_ITEMTITLE = 486;
    private static final int LAYOUT_ITEMTITLECARD = 487;
    private static final int LAYOUT_ITEMTITLELIST = 488;
    private static final int LAYOUT_ITEMTITLESECTION = 489;
    private static final int LAYOUT_ITEMTITLEVIEW = 490;
    private static final int LAYOUT_ITEMTOPGROUPCARD = 491;
    private static final int LAYOUT_ITEMTOPGROUPCARDITEM = 492;
    private static final int LAYOUT_ITEMTOPIC = 493;
    private static final int LAYOUT_ITEMTOPICVIEW = 494;
    private static final int LAYOUT_ITEMTRIPLEAVATARVIEWPART = 495;
    private static final int LAYOUT_ITEMTRIPLECOOLPIC = 496;
    private static final int LAYOUT_ITEMUPGRADE = 497;
    private static final int LAYOUT_ITEMUPGRADECARD = 498;
    private static final int LAYOUT_ITEMUSER = 499;
    private static final int LAYOUT_ITEMUSERCOVERADD = 500;
    private static final int LAYOUT_ITEMUSERCOVERIMAGE = 501;
    private static final int LAYOUT_ITEMUSERCOVERTITLE = 502;
    private static final int LAYOUT_ITEMUSERDELETERECENT = 503;
    private static final int LAYOUT_ITEMUSERGIFT = 504;
    private static final int LAYOUT_ITEMUSERHISTORY = 505;
    private static final int LAYOUT_ITEMUSERINFOHEADERVIEW = 506;
    private static final int LAYOUT_ITEMUSERINFONUM = 507;
    private static final int LAYOUT_ITEMUSERINFOPART = 508;
    private static final int LAYOUT_ITEMUSERNAVIGATION = 509;
    private static final int LAYOUT_ITEMUSERNODERATING = 510;
    private static final int LAYOUT_ITEMUSERPROFILEAVATAR = 511;
    private static final int LAYOUT_ITEMUSERPROFILEITEM = 512;
    private static final int LAYOUT_ITEMUSERRATING = 513;
    private static final int LAYOUT_ITEMUSERSPACECOUNT = 514;
    private static final int LAYOUT_ITEMVERSIONAPP = 515;
    private static final int LAYOUT_ITEMVIDEODETAILVIEWPART = 516;
    private static final int LAYOUT_ITEMVIDEOVIEW = 517;
    private static final int LAYOUT_ITEMVIDEOVIEWPART = 518;
    private static final int LAYOUT_ITEMVOTECOMMENTEMPTY = 519;
    private static final int LAYOUT_ITEMVOTEDETAILSPLITEDTITLE = 520;
    private static final int LAYOUT_ITEMVOTEUSER = 521;
    private static final int LAYOUT_ITEMWEBVIEW = 522;
    private static final int LAYOUT_ITEMWEBVIEWPAGE = 523;
    private static final int LAYOUT_ITEMWEUI = 524;
    private static final int LAYOUT_KKVIEW = 525;
    private static final int LAYOUT_LAYOUTIMAGEMODE = 526;
    private static final int LAYOUT_LAYOUTLISTEDITBUTTON = 527;
    private static final int LAYOUT_LAYOUTMESSAGECARD = 528;
    private static final int LAYOUT_LAYOUTPRIVACYCLAUSE = 529;
    private static final int LAYOUT_LAYOUTTABCONFIG = 530;
    private static final int LAYOUT_LAYOUTWATERMARK = 531;
    private static final int LAYOUT_LIVEACTIVITY = 532;
    private static final int LAYOUT_LIVEFLOATNEWMESSAGE = 533;
    private static final int LAYOUT_LIVEINTRODUCE = 534;
    private static final int LAYOUT_LIVEREPLYLIST = 535;
    private static final int LAYOUT_LOADINGVIEW = 536;
    private static final int LAYOUT_LOGITEM = 537;
    private static final int LAYOUT_MAIN = 538;
    private static final int LAYOUT_MAINCATEGORYLAYOUT = 539;
    private static final int LAYOUT_MAINCENTERUSERPART = 540;
    private static final int LAYOUT_MAINFRAGMENT = 541;
    private static final int LAYOUT_MARKET = 542;
    private static final int LAYOUT_MESSAGETOPTIP = 543;
    private static final int LAYOUT_MOREPAGE = 544;
    private static final int LAYOUT_NETWORKDIAGNOSIS = 545;
    private static final int LAYOUT_NEWALBUMVIEW = 546;
    private static final int LAYOUT_NEWV8ALBUM = 547;
    private static final int LAYOUT_NIGHTTIMEPICKER = 548;
    private static final int LAYOUT_NODEPICKER = 549;
    private static final int LAYOUT_NODERATINGFEEDLIKEVIEW = 550;
    private static final int LAYOUT_NORMALFEEDCONTENTV8 = 551;
    private static final int LAYOUT_PERMISSION = 552;
    private static final int LAYOUT_PHOTO = 553;
    private static final int LAYOUT_PHOTOPICKER = 554;
    private static final int LAYOUT_PICREPLYLIST = 555;
    private static final int LAYOUT_PICTUREDETAILWRAP = 556;
    private static final int LAYOUT_POILIST = 557;
    private static final int LAYOUT_POSTBUTTONSETTING = 558;
    private static final int LAYOUT_POSTMOREPANEL = 559;
    private static final int LAYOUT_PRODUCTBRANDLIST = 560;
    private static final int LAYOUT_PRODUCTCOUPONACTIVITY = 561;
    private static final int LAYOUT_PRODUCTNODEHEADER = 562;
    private static final int LAYOUT_PRODUCTNODETOOLBARCONTENT = 563;
    private static final int LAYOUT_PRODUCTPOSTVIEW = 564;
    private static final int LAYOUT_QRCODE = 565;
    private static final int LAYOUT_QUESTIONTITLE = 566;
    private static final int LAYOUT_REFRESHRECYCLER = 567;
    private static final int LAYOUT_REFRESHRECYCLERTABS = 568;
    private static final int LAYOUT_REPLY = 569;
    private static final int LAYOUT_RVINFRAGMENTLAYOUT = 570;
    private static final int LAYOUT_SCROLLABLETABLAYOUT = 571;
    private static final int LAYOUT_SEARCH = 572;
    private static final int LAYOUT_SEARCHBACKHEADER = 573;
    private static final int LAYOUT_SEARCHDROPDOWNITEM = 574;
    private static final int LAYOUT_SEARCHEXTEND = 575;
    private static final int LAYOUT_SEARCHHISTORY = 576;
    private static final int LAYOUT_SEARCHHOT = 577;
    private static final int LAYOUT_SEARCHLIST = 578;
    private static final int LAYOUT_SEARCHLISTCARD = 579;
    private static final int LAYOUT_SEARCHRESULT = 580;
    private static final int LAYOUT_SEARCHSCENEITEM = 581;
    private static final int LAYOUT_SEARCHSCENELIST = 582;
    private static final int LAYOUT_SECONDHANDCOMMENTBAR = 583;
    private static final int LAYOUT_SECONDHANDCONTENTV8 = 584;
    private static final int LAYOUT_SECONDHANDEXTRACHILD = 585;
    private static final int LAYOUT_SHAREFEEDV8 = 586;
    private static final int LAYOUT_SHAREGOODDIALOG = 587;
    private static final int LAYOUT_SHARELIST = 588;
    private static final int LAYOUT_SHARELISTVIEW = 589;
    private static final int LAYOUT_SHAREWEBVIEW = 590;
    private static final int LAYOUT_SPLASH = 591;
    private static final int LAYOUT_SPLASHV9 = 592;
    private static final int LAYOUT_SPLASHVIEW = 593;
    private static final int LAYOUT_STATICDIALOGVIEW = 594;
    private static final int LAYOUT_SUBMITFEEDADDMOREITEMDIALOG = 595;
    private static final int LAYOUT_SUBMITFEEDADDVIDEOITEMDIALOG = 596;
    private static final int LAYOUT_SUBMITFEEDARTICLEBOTTOM = 597;
    private static final int LAYOUT_SUBMITFEEDARTICLEHOLDER2 = 598;
    private static final int LAYOUT_SUBMITFEEDARTICLEIMAGEPART = 599;
    private static final int LAYOUT_SUBMITFEEDARTICLETEXTPART = 600;
    private static final int LAYOUT_SUBMITFEEDARTICLETOPANSWER = 601;
    private static final int LAYOUT_SUBMITFEEDARTICLETOPPART = 602;
    private static final int LAYOUT_SUBMITFEEDBOTTOMADDMOREV8 = 603;
    private static final int LAYOUT_SUBMITFEEDBOTTOMSETVISIBILITY = 604;
    private static final int LAYOUT_SUBMITFEEDEXTRACHILD = 605;
    private static final int LAYOUT_SUBMITFEEDEXTRALOGO = 606;
    private static final int LAYOUT_SUBMITFEEDGOODS = 607;
    private static final int LAYOUT_SUBMITFEEDNEWGOODS = 608;
    private static final int LAYOUT_SUBMITFEEDRELATIVEINFOPICKER = 609;
    private static final int LAYOUT_SUBMITFEEDV8 = 610;
    private static final int LAYOUT_SUBMITPICKCOLOR = 611;
    private static final int LAYOUT_SUBMITPRODUCTARTICLEBOTTOM = 612;
    private static final int LAYOUT_SUBMITPRODUCTARTICLETOPPART = 613;
    private static final int LAYOUT_SUBMITPRODUCTCONTENTRATINGBAR = 614;
    private static final int LAYOUT_SUBMITPRODUCTRATING = 615;
    private static final int LAYOUT_SUBMITRATINGNORAMLCONTENT = 616;
    private static final int LAYOUT_SUBMITSECONDHANDDEALEXTRACHILD = 617;
    private static final int LAYOUT_SUBMITSECONDHANDEXTRACHILD = 618;
    private static final int LAYOUT_SUBMITVERIFYMOBILECODEDIALOG = 619;
    private static final int LAYOUT_SUBMITVERTFIYCAPTCHADIALOG = 620;
    private static final int LAYOUT_SUBMITVIEWARTICLEADDLINK = 621;
    private static final int LAYOUT_SUBMITVOTEEXTRACHILD = 622;
    private static final int LAYOUT_TABLAYOUT = 623;
    private static final int LAYOUT_TAGPRODUCTOWNER = 624;
    private static final int LAYOUT_TEST = 625;
    private static final int LAYOUT_TEXTVIEW = 626;
    private static final int LAYOUT_THEMEPICKDIALOG = 627;
    private static final int LAYOUT_THEMEPICKERLISTITEM = 628;
    private static final int LAYOUT_TIPLAYOUT = 629;
    private static final int LAYOUT_TOOLBARLAYOUT = 630;
    private static final int LAYOUT_TOPICDETAILDESCRIPTION = 631;
    private static final int LAYOUT_TOPICDETAILHEADLINE = 632;
    private static final int LAYOUT_TOPICNODEHEADER = 633;
    private static final int LAYOUT_TOPICNODEHEADERLINE = 634;
    private static final int LAYOUT_TOPICNODEPAGE = 635;
    private static final int LAYOUT_TOPICPICKER = 636;
    private static final int LAYOUT_USERAVATAR = 637;
    private static final int LAYOUT_USERDATA = 638;
    private static final int LAYOUT_USERKEYINPUT = 639;
    private static final int LAYOUT_USERPICK = 640;
    private static final int LAYOUT_USERQRCODE = 641;
    private static final int LAYOUT_USERSPACEV9 = 642;
    private static final int LAYOUT_USERTOOLBAR = 643;
    private static final int LAYOUT_VIDEOCOMPLETE = 644;
    private static final int LAYOUT_VIDEOCONTROLLER = 645;
    private static final int LAYOUT_VIDEOERROR = 646;
    private static final int LAYOUT_VIDEOFLOATING = 647;
    private static final int LAYOUT_VIDEOFULLSCREEN = 648;
    private static final int LAYOUT_VIDEOGESTURE = 649;
    private static final int LAYOUT_VIDEOLOADING = 650;
    private static final int LAYOUT_VIDEOSIMPLECONTROLLER = 651;
    private static final int LAYOUT_VOTEFEEDCONTENT = 652;
    private static final int LAYOUT_VXLAYOUT = 653;
    private static final int LAYOUT_WEBVIEW = 654;

    static {
        internalPopulateLayoutIdLookup0();
        internalPopulateLayoutIdLookup1();
    }

    private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 1:
                if ("layout/about_0".equals(obj)) {
                    return new AboutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for about is invalid. Received: " + obj);
            case 2:
                if ("layout/action_item_app_manager_view_0".equals(obj)) {
                    return new ActionItemAppManagerViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for action_item_app_manager_view is invalid. Received: " + obj);
            case 3:
                if ("layout/action_item_badge_view_0".equals(obj)) {
                    return new ActionItemBadgeViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for action_item_badge_view is invalid. Received: " + obj);
            case 4:
                if ("layout/action_item_post_0".equals(obj)) {
                    return new ActionItemPostBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for action_item_post is invalid. Received: " + obj);
            case 5:
                if ("layout/activity_album_detailbeta_0".equals(obj)) {
                    return new ActivityAlbumDetailbetaBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_album_detailbeta is invalid. Received: " + obj);
            case 6:
                if ("layout/activity_wallpaper_0".equals(obj)) {
                    return new ActivityWallpaperBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_wallpaper is invalid. Received: " + obj);
            case 7:
                if ("layout/activity_wallpaper_beta_0".equals(obj)) {
                    return new ActivityWallpaperBetaBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_wallpaper_beta is invalid. Received: " + obj);
            case 8:
                if ("layout/add_goods_item_dialog_0".equals(obj)) {
                    return new AddGoodsItemDialogBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for add_goods_item_dialog is invalid. Received: " + obj);
            case 9:
                if ("layout/add_to_album_edit_0".equals(obj)) {
                    return new AddToAlbumEditBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for add_to_album_edit is invalid. Received: " + obj);
            case 10:
                if ("layout/album_action_bar_0".equals(obj)) {
                    return new AlbumActionBarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for album_action_bar is invalid. Received: " + obj);
            case 11:
                if ("layout/album_action_view_0".equals(obj)) {
                    return new AlbumActionViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for album_action_view is invalid. Received: " + obj);
            case 12:
                if ("layout/album_base_info_0".equals(obj)) {
                    return new AlbumBaseInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for album_base_info is invalid. Received: " + obj);
            case 13:
                if ("layout/album_comment_bar_0".equals(obj)) {
                    return new AlbumCommentBarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for album_comment_bar is invalid. Received: " + obj);
            case 14:
                if ("layout/album_detail_0".equals(obj)) {
                    return new AlbumDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for album_detail is invalid. Received: " + obj);
            case 15:
                if ("layout/album_detail_v8_v2_0".equals(obj)) {
                    return new AlbumDetailV8V2BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for album_detail_v8_v2 is invalid. Received: " + obj);
            case 16:
                if ("layout/album_detailt_view_0".equals(obj)) {
                    return new AlbumDetailtViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for album_detailt_view is invalid. Received: " + obj);
            case 17:
                if ("layout/album_header_view_v2_0".equals(obj)) {
                    return new AlbumHeaderViewV2BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for album_header_view_v2 is invalid. Received: " + obj);
            case 18:
                if ("layout/album_item_base_info_0".equals(obj)) {
                    return new AlbumItemBaseInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for album_item_base_info is invalid. Received: " + obj);
            case 19:
                if ("layout/album_list_item_card_nonuple_0".equals(obj)) {
                    return new AlbumListItemCardNonupleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for album_list_item_card_nonuple is invalid. Received: " + obj);
            case 20:
                if ("layout/album_list_item_card_nonuple_item_0".equals(obj)) {
                    return new AlbumListItemCardNonupleItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for album_list_item_card_nonuple_item is invalid. Received: " + obj);
            case 21:
                if ("layout/album_test_view_0".equals(obj)) {
                    return new AlbumTestViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for album_test_view is invalid. Received: " + obj);
            case 22:
                if ("layout/album_user_info_0".equals(obj)) {
                    return new AlbumUserInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for album_user_info is invalid. Received: " + obj);
            case 23:
                if ("layout/album_v8_detail_0".equals(obj)) {
                    return new AlbumV8DetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for album_v8_detail is invalid. Received: " + obj);
            case 24:
                if ("layout/alpha_toolbar_0".equals(obj)) {
                    return new AlphaToolbarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for alpha_toolbar is invalid. Received: " + obj);
            case 25:
                if ("layout/app_detail_0".equals(obj)) {
                    return new AppDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for app_detail is invalid. Received: " + obj);
            case 26:
                if ("layout/app_extension_bar_v3_0".equals(obj)) {
                    return new AppExtensionBarV3BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for app_extension_bar_v3 is invalid. Received: " + obj);
            case 27:
                if ("layout/app_extension_item_0".equals(obj)) {
                    return new AppExtensionItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for app_extension_item is invalid. Received: " + obj);
            case 28:
                if ("layout/app_extension_item_post_0".equals(obj)) {
                    return new AppExtensionItemPostBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for app_extension_item_post is invalid. Received: " + obj);
            case 29:
                if ("layout/app_main_model_select_0".equals(obj)) {
                    return new AppMainModelSelectBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for app_main_model_select is invalid. Received: " + obj);
            case 30:
                if ("layout/app_node_community_header_0".equals(obj)) {
                    return new AppNodeCommunityHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for app_node_community_header is invalid. Received: " + obj);
            case 31:
                if ("layout/app_node_header_0".equals(obj)) {
                    return new AppNodeHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for app_node_header is invalid. Received: " + obj);
            case 32:
                if ("layout/app_node_toolbar_content_0".equals(obj)) {
                    return new AppNodeToolbarContentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for app_node_toolbar_content is invalid. Received: " + obj);
            case 33:
                if ("layout/app_view_0".equals(obj)) {
                    return new AppViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for app_view is invalid. Received: " + obj);
            case 34:
                if ("layout/app_view_base_info_0".equals(obj)) {
                    return new AppViewBaseInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for app_view_base_info is invalid. Received: " + obj);
            case 35:
                if ("layout/app_view_recycler_0".equals(obj)) {
                    return new AppViewRecyclerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for app_view_recycler is invalid. Received: " + obj);
            case 36:
                if ("layout/app_view_v8_0".equals(obj)) {
                    return new AppViewV8BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for app_view_v8 is invalid. Received: " + obj);
            case 37:
                if ("layout/article_detail_image_part_0".equals(obj)) {
                    return new ArticleDetailImagePartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for article_detail_image_part is invalid. Received: " + obj);
            case 38:
                if ("layout/article_detail_text_part_0".equals(obj)) {
                    return new ArticleDetailTextPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for article_detail_text_part is invalid. Received: " + obj);
            case 39:
                if ("layout/base_chatting_0".equals(obj)) {
                    return new BaseChattingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for base_chatting is invalid. Received: " + obj);
            case 40:
                if ("layout/base_new_chatting_0".equals(obj)) {
                    return new BaseNewChattingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for base_new_chatting is invalid. Received: " + obj);
            case 41:
                if ("layout/center_v9_social_dialog_0".equals(obj)) {
                    return new CenterV9SocialDialogBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for center_v9_social_dialog is invalid. Received: " + obj);
            case 42:
                if ("layout/collection_select_0".equals(obj)) {
                    return new CollectionSelectBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for collection_select is invalid. Received: " + obj);
            case 43:
                if ("layout/comment_bar_0".equals(obj)) {
                    return new CommentBarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for comment_bar is invalid. Received: " + obj);
            case 44:
                if ("layout/cool_browser_0".equals(obj)) {
                    return new CoolBrowserBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for cool_browser is invalid. Received: " + obj);
            case 45:
                if ("layout/cool_pic_full_screen_0".equals(obj)) {
                    return new CoolPicFullScreenBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for cool_pic_full_screen is invalid. Received: " + obj);
            case 46:
                if ("layout/cool_pic_img_layout_0".equals(obj)) {
                    return new CoolPicImgLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for cool_pic_img_layout is invalid. Received: " + obj);
            case 47:
                if ("layout/create_collect_list_0".equals(obj)) {
                    return new CreateCollectListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for create_collect_list is invalid. Received: " + obj);
            case 48:
                if ("layout/create_fun_things_0".equals(obj)) {
                    return new CreateFunThingsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for create_fun_things is invalid. Received: " + obj);
            case 49:
                if ("layout/create_goods_0".equals(obj)) {
                    return new CreateGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for create_goods is invalid. Received: " + obj);
            case 50:
                if ("layout/custom_theme_0".equals(obj)) {
                    return new CustomThemeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for custom_theme is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 51:
                if ("layout/dialog_add_block_word_0".equals(obj)) {
                    return new DialogAddBlockWordBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_block_word is invalid. Received: " + obj);
            case 52:
                if ("layout/dialog_add_to_goods_list_0".equals(obj)) {
                    return new DialogAddToGoodsListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_to_goods_list is invalid. Received: " + obj);
            case 53:
                if ("layout/dialog_album_create_0".equals(obj)) {
                    return new DialogAlbumCreateBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_album_create is invalid. Received: " + obj);
            case 54:
                if ("layout/dialog_album_mobileapp_note_0".equals(obj)) {
                    return new DialogAlbumMobileappNoteBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_album_mobileapp_note is invalid. Received: " + obj);
            case 55:
                if ("layout/dialog_albumitem_note_0".equals(obj)) {
                    return new DialogAlbumitemNoteBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_albumitem_note is invalid. Received: " + obj);
            case 56:
                if ("layout/dialog_albumitem_px_0".equals(obj)) {
                    return new DialogAlbumitemPxBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_albumitem_px is invalid. Received: " + obj);
            case 57:
                if ("layout/dialog_app_rating_0".equals(obj)) {
                    return new DialogAppRatingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_app_rating is invalid. Received: " + obj);
            case 58:
                if ("layout/dialog_backup_create_0".equals(obj)) {
                    return new DialogBackupCreateBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_backup_create is invalid. Received: " + obj);
            case 59:
                if ("layout/dialog_block_node_0".equals(obj)) {
                    return new DialogBlockNodeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_block_node is invalid. Received: " + obj);
            case 60:
                if ("layout/dialog_city_picker_0".equals(obj)) {
                    return new DialogCityPickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_city_picker is invalid. Received: " + obj);
            case 61:
                if ("layout/dialog_complete_nav_0".equals(obj)) {
                    return new DialogCompleteNavBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_complete_nav is invalid. Received: " + obj);
            case 62:
                if ("layout/dialog_date_picker_0".equals(obj)) {
                    return new DialogDatePickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_date_picker is invalid. Received: " + obj);
            case 63:
                if ("layout/dialog_edit_0".equals(obj)) {
                    return new DialogEditBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_edit is invalid. Received: " + obj);
            case 64:
                if ("layout/dialog_edit_submit_0".equals(obj)) {
                    return new DialogEditSubmitBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_edit_submit is invalid. Received: " + obj);
            case 65:
                if ("layout/dialog_gender_picker_0".equals(obj)) {
                    return new DialogGenderPickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_gender_picker is invalid. Received: " + obj);
            case 66:
                if ("layout/dialog_goods_list_edit_0".equals(obj)) {
                    return new DialogGoodsListEditBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_goods_list_edit is invalid. Received: " + obj);
            case 67:
                if ("layout/dialog_item_text_view_0".equals(obj)) {
                    return new DialogItemTextViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_item_text_view is invalid. Received: " + obj);
            case 68:
                if ("layout/dialog_list_item_view_0".equals(obj)) {
                    return new DialogListItemViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_list_item_view is invalid. Received: " + obj);
            case 69:
                if ("layout/dialog_message_card_0".equals(obj)) {
                    return new DialogMessageCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_message_card is invalid. Received: " + obj);
            case 70:
                if ("layout/dialog_prograss_view_0".equals(obj)) {
                    return new DialogPrograssViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_prograss_view is invalid. Received: " + obj);
            case 71:
                if ("layout/dialog_second_hand_agreement_0".equals(obj)) {
                    return new DialogSecondHandAgreementBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_second_hand_agreement is invalid. Received: " + obj);
            case 72:
                if ("layout/dialog_second_hand_edit_0".equals(obj)) {
                    return new DialogSecondHandEditBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_second_hand_edit is invalid. Received: " + obj);
            case 73:
                if ("layout/dialog_second_hand_price_0".equals(obj)) {
                    return new DialogSecondHandPriceBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_second_hand_price is invalid. Received: " + obj);
            case 74:
                if ("layout/dialog_select_item_0".equals(obj)) {
                    return new DialogSelectItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_select_item is invalid. Received: " + obj);
            case 75:
                if ("layout/dialog_seletor_container_0".equals(obj)) {
                    return new DialogSeletorContainerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_seletor_container is invalid. Received: " + obj);
            case 76:
                if ("layout/dialog_share_0".equals(obj)) {
                    return new DialogShareBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_share is invalid. Received: " + obj);
            case 77:
                if ("layout/dialog_time_picker_0".equals(obj)) {
                    return new DialogTimePickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_time_picker is invalid. Received: " + obj);
            case 78:
                if ("layout/discovery_0".equals(obj)) {
                    return new DiscoveryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for discovery is invalid. Received: " + obj);
            case 79:
                if ("layout/discovery_submit_0".equals(obj)) {
                    return new DiscoverySubmitBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for discovery_submit is invalid. Received: " + obj);
            case 80:
                if ("layout/dyh_header_view_0".equals(obj)) {
                    return new DyhHeaderViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dyh_header_view is invalid. Received: " + obj);
            case 81:
                if ("layout/dyh_includ_0".equals(obj)) {
                    return new DyhIncludBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dyh_includ is invalid. Received: " + obj);
            case 82:
                if ("layout/edit_user_view_0".equals(obj)) {
                    return new EditUserViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for edit_user_view is invalid. Received: " + obj);
            case 83:
                if ("layout/emotion_panel_0".equals(obj)) {
                    return new EmotionPanelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for emotion_panel is invalid. Received: " + obj);
            case 84:
                if ("layout/emotion_panel_bottom_text_0".equals(obj)) {
                    return new EmotionPanelBottomTextBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for emotion_panel_bottom_text is invalid. Received: " + obj);
            case 85:
                if ("layout/fab_0".equals(obj)) {
                    return new FabBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fab is invalid. Received: " + obj);
            case 86:
                if ("layout/feed_action_bar_0".equals(obj)) {
                    return new FeedActionBarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for feed_action_bar is invalid. Received: " + obj);
            case 87:
                if ("layout/feed_answer_view_part_0".equals(obj)) {
                    return new FeedAnswerViewPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for feed_answer_view_part is invalid. Received: " + obj);
            case 88:
                if ("layout/feed_bind_goods_main_0".equals(obj)) {
                    return new FeedBindGoodsMainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for feed_bind_goods_main is invalid. Received: " + obj);
            case 89:
                if ("layout/feed_block_items_0".equals(obj)) {
                    return new FeedBlockItemsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for feed_block_items is invalid. Received: " + obj);
            case 90:
                if ("layout/feed_comment_bar_0".equals(obj)) {
                    return new FeedCommentBarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for feed_comment_bar is invalid. Received: " + obj);
            case 91:
                if ("layout/feed_comment_count_view_part_0".equals(obj)) {
                    return new FeedCommentCountViewPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for feed_comment_count_view_part is invalid. Received: " + obj);
            case 92:
                if ("layout/feed_entrance_items_0".equals(obj)) {
                    return new FeedEntranceItemsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for feed_entrance_items is invalid. Received: " + obj);
            case 93:
                if ("layout/feed_entrance_long_items_0".equals(obj)) {
                    return new FeedEntranceLongItemsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for feed_entrance_long_items is invalid. Received: " + obj);
            case 94:
                if ("layout/feed_entrance_v8_0".equals(obj)) {
                    return new FeedEntranceV8BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for feed_entrance_v8 is invalid. Received: " + obj);
            case 95:
                if ("layout/feed_reply_detail_0".equals(obj)) {
                    return new FeedReplyDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for feed_reply_detail is invalid. Received: " + obj);
            case 96:
                if ("layout/feed_reply_detail_header_0".equals(obj)) {
                    return new FeedReplyDetailHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for feed_reply_detail_header is invalid. Received: " + obj);
            case 97:
                if ("layout/feed_top_0".equals(obj)) {
                    return new FeedTopBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for feed_top is invalid. Received: " + obj);
            case 98:
                if ("layout/feed_warning_0".equals(obj)) {
                    return new FeedWarningBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for feed_warning is invalid. Received: " + obj);
            case 99:
                if ("layout/fetch_gift_0".equals(obj)) {
                    return new FetchGiftBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fetch_gift is invalid. Received: " + obj);
            case 100:
                if ("layout/fixed_tablayout_0".equals(obj)) {
                    return new FixedTablayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fixed_tablayout is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding2(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 101:
                if ("layout/forward_preview_0".equals(obj)) {
                    return new ForwardPreviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for forward_preview is invalid. Received: " + obj);
            case 102:
                if ("layout/goods_coupon_search_0".equals(obj)) {
                    return new GoodsCouponSearchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for goods_coupon_search is invalid. Received: " + obj);
            case 103:
                if ("layout/goods_detail_0".equals(obj)) {
                    return new GoodsDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for goods_detail is invalid. Received: " + obj);
            case 104:
                if ("layout/goods_search_0".equals(obj)) {
                    return new GoodsSearchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for goods_search is invalid. Received: " + obj);
            case 105:
                if ("layout/home_0".equals(obj)) {
                    return new HomeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home is invalid. Received: " + obj);
            case 106:
                if ("layout/item_account_tips_0".equals(obj)) {
                    return new ItemAccountTipsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_account_tips is invalid. Received: " + obj);
            case 107:
                if ("layout/item_action_sheet_dialog_0".equals(obj)) {
                    return new ItemActionSheetDialogBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_action_sheet_dialog is invalid. Received: " + obj);
            case 108:
                if ("layout/item_add_to_album_0".equals(obj)) {
                    return new ItemAddToAlbumBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_add_to_album is invalid. Received: " + obj);
            case 109:
                if ("layout/item_add_to_album_header_0".equals(obj)) {
                    return new ItemAddToAlbumHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_add_to_album_header is invalid. Received: " + obj);
            case 110:
                if ("layout/item_add_to_goods_list_0".equals(obj)) {
                    return new ItemAddToGoodsListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_add_to_goods_list is invalid. Received: " + obj);
            case 111:
                if ("layout/item_ads_0".equals(obj)) {
                    return new ItemAdsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_ads is invalid. Received: " + obj);
            case 112:
                if ("layout/item_album_0".equals(obj)) {
                    return new ItemAlbumBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_album is invalid. Received: " + obj);
            case 113:
                if ("layout/item_album_app_0".equals(obj)) {
                    return new AlbumAppBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_album_app is invalid. Received: " + obj);
            case 114:
                if ("layout/item_album_app_edit_0".equals(obj)) {
                    return new ItemAlbumAppEditBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_album_app_edit is invalid. Received: " + obj);
            case 115:
                if ("layout/item_album_edit_header_0".equals(obj)) {
                    return new ItemAlbumEditHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_album_edit_header is invalid. Received: " + obj);
            case 116:
                if ("layout/item_album_expand_card_0".equals(obj)) {
                    return new ItemAlbumExpandCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_album_expand_card is invalid. Received: " + obj);
            case 117:
                if ("layout/item_album_feed_base_0".equals(obj)) {
                    return new ItemAlbumFeedBaseBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_album_feed_base is invalid. Received: " + obj);
            case 118:
                if ("layout/item_album_icon_0".equals(obj)) {
                    return new ItemAlbumIconBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_album_icon is invalid. Received: " + obj);
            case 119:
                if ("layout/item_album_with_avatar_0".equals(obj)) {
                    return new ItemAlbumWithAvatarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_album_with_avatar is invalid. Received: " + obj);
            case 120:
                if ("layout/item_alert_message_card_0".equals(obj)) {
                    return new ItemAlertMessageCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_alert_message_card is invalid. Received: " + obj);
            case 121:
                if ("layout/item_answer_view_0".equals(obj)) {
                    return new ItemAnswerViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_answer_view is invalid. Received: " + obj);
            case 122:
                if ("layout/item_apk_scroll_with_background_0".equals(obj)) {
                    return new ItemApkScrollWithBackgroundBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_apk_scroll_with_background is invalid. Received: " + obj);
            case 123:
                if ("layout/item_app_category_0".equals(obj)) {
                    return new ItemAppCategoryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_category is invalid. Received: " + obj);
            case 124:
                if ("layout/item_app_detail_0".equals(obj)) {
                    return new ItemAppDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_detail is invalid. Received: " + obj);
            case 125:
                if ("layout/item_app_forum_0".equals(obj)) {
                    return new ItemAppForumBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_forum is invalid. Received: " + obj);
            case 126:
                if ("layout/item_app_inside_image_card_0".equals(obj)) {
                    return new ItemAppInsideImageCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_inside_image_card is invalid. Received: " + obj);
            case 127:
                if ("layout/item_app_node_coupon_0".equals(obj)) {
                    return new ItemAppNodeCouponBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_node_coupon is invalid. Received: " + obj);
            case 128:
                if ("layout/item_app_node_gift_0".equals(obj)) {
                    return new ItemAppNodeGiftBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_node_gift is invalid. Received: " + obj);
            case 129:
                if ("layout/item_app_node_tag_0".equals(obj)) {
                    return new ItemAppNodeTagBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_node_tag is invalid. Received: " + obj);
            case 130:
                if ("layout/item_app_node_thumbnail_0".equals(obj)) {
                    return new ItemAppNodeThumbnailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_node_thumbnail is invalid. Received: " + obj);
            case 131:
                if ("layout/item_app_photo_thumbnail_0".equals(obj)) {
                    return new AppPhotoThumbnailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_photo_thumbnail is invalid. Received: " + obj);
            case 132:
                if ("layout/item_app_updata_manager_0".equals(obj)) {
                    return new ItemAppUpdataManagerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_updata_manager is invalid. Received: " + obj);
            case 133:
                if ("layout/item_app_view_base_info_0".equals(obj)) {
                    return new ItemAppViewBaseInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_view_base_info is invalid. Received: " + obj);
            case 134:
                if ("layout/item_app_view_base_info_coupon_item_0".equals(obj)) {
                    return new ItemAppViewBaseInfoCouponItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_view_base_info_coupon_item is invalid. Received: " + obj);
            case 135:
                if ("layout/item_app_view_base_info_gift_0".equals(obj)) {
                    return new ItemAppViewBaseInfoGiftBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_view_base_info_gift is invalid. Received: " + obj);
            case 136:
                if ("layout/item_app_view_comment_title_0".equals(obj)) {
                    return new ItemAppViewCommentTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_view_comment_title is invalid. Received: " + obj);
            case 137:
                if ("layout/item_app_view_download_0".equals(obj)) {
                    return new ItemAppViewDownloadBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_view_download is invalid. Received: " + obj);
            case 138:
                if ("layout/item_app_view_gift_0".equals(obj)) {
                    return new ItemAppViewGiftBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_view_gift is invalid. Received: " + obj);
            case 139:
                if ("layout/item_app_view_holder_0".equals(obj)) {
                    return new ItemAppViewHolderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_view_holder is invalid. Received: " + obj);
            case 140:
                if ("layout/item_app_view_interactive_0".equals(obj)) {
                    return new ItemAppViewInteractiveBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_view_interactive is invalid. Received: " + obj);
            case 141:
                if ("layout/item_app_view_rating_0".equals(obj)) {
                    return new ItemAppViewRatingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_app_view_rating is invalid. Received: " + obj);
            case 142:
                if ("layout/item_article_answer_preview_top_0".equals(obj)) {
                    return new ItemArticleAnswerPreviewTopBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_article_answer_preview_top is invalid. Received: " + obj);
            case 143:
                if ("layout/item_article_card_goods_0".equals(obj)) {
                    return new ItemArticleCardGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_article_card_goods is invalid. Received: " + obj);
            case 144:
                if ("layout/item_article_detail_answer_top_0".equals(obj)) {
                    return new ItemArticleDetailAnswerTopBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_article_detail_answer_top is invalid. Received: " + obj);
            case 145:
                if ("layout/item_article_detail_top_0".equals(obj)) {
                    return new ItemArticleDetailTopBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_article_detail_top is invalid. Received: " + obj);
            case 146:
                if ("layout/item_article_edit_share_url_0".equals(obj)) {
                    return new ItemArticleEditShareUrlBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_article_edit_share_url is invalid. Received: " + obj);
            case 147:
                if ("layout/item_article_edit_share_url_container_0".equals(obj)) {
                    return new ItemArticleEditShareUrlContainerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_article_edit_share_url_container is invalid. Received: " + obj);
            case 148:
                if ("layout/item_article_feed_preview_top_0".equals(obj)) {
                    return new ItemArticleFeedPreviewTopBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_article_feed_preview_top is invalid. Received: " + obj);
            case 149:
                if ("layout/item_article_view_image_0".equals(obj)) {
                    return new ItemArticleViewImageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_article_view_image is invalid. Received: " + obj);
            case 150:
                if ("layout/item_article_view_text_0".equals(obj)) {
                    return new ItemArticleViewTextBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_article_view_text is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding3(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 151:
                if ("layout/item_back_app_switch_0".equals(obj)) {
                    return new ItemBackAppSwitchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_back_app_switch is invalid. Received: " + obj);
            case 152:
                if ("layout/item_backup_0".equals(obj)) {
                    return new ItemBackupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_backup is invalid. Received: " + obj);
            case 153:
                if ("layout/item_backup_app_0".equals(obj)) {
                    return new ItemBackupAppBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_backup_app is invalid. Received: " + obj);
            case 154:
                if ("layout/item_backup_header_0".equals(obj)) {
                    return new ItemBackupHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_backup_header is invalid. Received: " + obj);
            case 155:
                if ("layout/item_backup_header_info_0".equals(obj)) {
                    return new ItemBackupHeaderInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_backup_header_info is invalid. Received: " + obj);
            case 156:
                if ("layout/item_backup_header_title_0".equals(obj)) {
                    return new ItemBackupHeaderTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_backup_header_title is invalid. Received: " + obj);
            case 157:
                if ("layout/item_bind_goods_child_0".equals(obj)) {
                    return new ItemBindGoodsChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_bind_goods_child is invalid. Received: " + obj);
            case 158:
                if ("layout/item_black_list_0".equals(obj)) {
                    return new ItemBlackListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_black_list is invalid. Received: " + obj);
            case 159:
                if ("layout/item_block_header_0".equals(obj)) {
                    return new ItemBlockHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_block_header is invalid. Received: " + obj);
            case 160:
                if ("layout/item_block_node_0".equals(obj)) {
                    return new ItemBlockNodeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_block_node is invalid. Received: " + obj);
            case 161:
                if ("layout/item_block_user_0".equals(obj)) {
                    return new ItemBlockUserBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_block_user is invalid. Received: " + obj);
            case 162:
                if ("layout/item_block_word_0".equals(obj)) {
                    return new ItemBlockWordBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_block_word is invalid. Received: " + obj);
            case 163:
                if ("layout/item_capsule_list_0".equals(obj)) {
                    return new ItemCapsuleListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_capsule_list is invalid. Received: " + obj);
            case 164:
                if ("layout/item_card_add_0".equals(obj)) {
                    return new ItemCardAddBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_card_add is invalid. Received: " + obj);
            case 165:
                if ("layout/item_card_double_0".equals(obj)) {
                    return new ItemCardDoubleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_card_double is invalid. Received: " + obj);
            case 166:
                if ("layout/item_card_double_item_0".equals(obj)) {
                    return new ItemCardDoubleItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_card_double_item is invalid. Received: " + obj);
            case 167:
                if ("layout/item_card_manager_0".equals(obj)) {
                    return new ItemCardManagerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_card_manager is invalid. Received: " + obj);
            case 168:
                if ("layout/item_card_manager_title_0".equals(obj)) {
                    return new ItemCardManagerTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_card_manager_title is invalid. Received: " + obj);
            case 169:
                if ("layout/item_card_triple_0".equals(obj)) {
                    return new ItemCardTripleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_card_triple is invalid. Received: " + obj);
            case 170:
                if ("layout/item_card_triple_item_0".equals(obj)) {
                    return new ItemCardTripleItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_card_triple_item is invalid. Received: " + obj);
            case 171:
                if ("layout/item_category_detail_rank_0".equals(obj)) {
                    return new ItemCategoryDetailRankBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_category_detail_rank is invalid. Received: " + obj);
            case 172:
                if ("layout/item_category_header_0".equals(obj)) {
                    return new ItemCategoryHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_category_header is invalid. Received: " + obj);
            case 173:
                if ("layout/item_center_login_0".equals(obj)) {
                    return new ItemCenterLoginBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_center_login is invalid. Received: " + obj);
            case 174:
                if ("layout/item_center_more_entrance_0".equals(obj)) {
                    return new ItemCenterMoreEntranceBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_center_more_entrance is invalid. Received: " + obj);
            case 175:
                if ("layout/item_center_more_entrance_child_0".equals(obj)) {
                    return new ItemCenterMoreEntranceChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_center_more_entrance_child is invalid. Received: " + obj);
            case 176:
                if ("layout/item_center_more_menu_0".equals(obj)) {
                    return new ItemCenterMoreMenuBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_center_more_menu is invalid. Received: " + obj);
            case 177:
                if ("layout/item_center_more_title_0".equals(obj)) {
                    return new ItemCenterMoreTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_center_more_title is invalid. Received: " + obj);
            case 178:
                if ("layout/item_center_user_info_0".equals(obj)) {
                    return new ItemCenterUserInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_center_user_info is invalid. Received: " + obj);
            case 179:
                if ("layout/item_center_user_menu_0".equals(obj)) {
                    return new ItemCenterUserMenuBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_center_user_menu is invalid. Received: " + obj);
            case 180:
                if ("layout/item_center_user_menu_child_0".equals(obj)) {
                    return new ItemCenterUserMenuChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_center_user_menu_child is invalid. Received: " + obj);
            case 181:
                if ("layout/item_channel_tab_0".equals(obj)) {
                    return new ItemChannelTabBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_channel_tab is invalid. Received: " + obj);
            case 182:
                if ("layout/item_channel_title_0".equals(obj)) {
                    return new ItemChannelTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_channel_title is invalid. Received: " + obj);
            case 183:
                if ("layout/item_chating_mine_0".equals(obj)) {
                    return new ItemChatingMineBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_chating_mine is invalid. Received: " + obj);
            case 184:
                if ("layout/item_chating_mine_card_0".equals(obj)) {
                    return new ItemChatingMineCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_chating_mine_card is invalid. Received: " + obj);
            case 185:
                if ("layout/item_chating_user_0".equals(obj)) {
                    return new ItemChatingUserBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_chating_user is invalid. Received: " + obj);
            case 186:
                if ("layout/item_chating_user_card_0".equals(obj)) {
                    return new ItemChatingUserCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_chating_user_card is invalid. Received: " + obj);
            case 187:
                if ("layout/item_circle_feed_top_0".equals(obj)) {
                    return new ItemCircleFeedTopBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_circle_feed_top is invalid. Received: " + obj);
            case 188:
                if ("layout/item_collection_0".equals(obj)) {
                    return new ItemCollectionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_collection is invalid. Received: " + obj);
            case 189:
                if ("layout/item_collection_foot_0".equals(obj)) {
                    return new ItemCollectionFootBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_collection_foot is invalid. Received: " + obj);
            case 190:
                if ("layout/item_collection_header_0".equals(obj)) {
                    return new ItemCollectionHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_collection_header is invalid. Received: " + obj);
            case 191:
                if ("layout/item_collection_select_0".equals(obj)) {
                    return new ItemCollectionSelectBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_collection_select is invalid. Received: " + obj);
            case 192:
                if ("layout/item_colorful_fat_scroll_card_child_0".equals(obj)) {
                    return new ItemColorfulFatScrollCardChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_colorful_fat_scroll_card_child is invalid. Received: " + obj);
            case 193:
                if ("layout/item_colorful_scroll_card_child_0".equals(obj)) {
                    return new ItemColorfulScrollCardChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_colorful_scroll_card_child is invalid. Received: " + obj);
            case 194:
                if ("layout/item_commentbar_child_view_0".equals(obj)) {
                    return new ItemCommentbarChildViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_commentbar_child_view is invalid. Received: " + obj);
            case 195:
                if ("layout/item_contact_0".equals(obj)) {
                    return new ItemContactBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_contact is invalid. Received: " + obj);
            case 196:
                if ("layout/item_cool_pic_image_0".equals(obj)) {
                    return new ItemCoolPicImageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_cool_pic_image is invalid. Received: " + obj);
            case 197:
                if ("layout/item_cool_pic_image_view_0".equals(obj)) {
                    return new ItemCoolPicImageViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_cool_pic_image_view is invalid. Received: " + obj);
            case 198:
                if ("layout/item_coolpic_detail_0".equals(obj)) {
                    return new ItemCoolpicDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_coolpic_detail is invalid. Received: " + obj);
            case 199:
                if ("layout/item_coolpic_fall_0".equals(obj)) {
                    return new ItemCoolpicFallBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_coolpic_fall is invalid. Received: " + obj);
            case 200:
                if ("layout/item_cover_view_0".equals(obj)) {
                    return new ItemCoverViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_cover_view is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding4(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 201:
                if ("layout/item_create_goods_list_0".equals(obj)) {
                    return new ItemCreateGoodsListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_create_goods_list is invalid. Received: " + obj);
            case 202:
                if ("layout/item_developer_app_0".equals(obj)) {
                    return new ItemDeveloperAppBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_developer_app is invalid. Received: " + obj);
            case 203:
                if ("layout/item_developer_card_0".equals(obj)) {
                    return new ItemDeveloperCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_developer_card is invalid. Received: " + obj);
            case 204:
                if ("layout/item_device_params_0".equals(obj)) {
                    return new ItemDeviceParamsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_device_params is invalid. Received: " + obj);
            case 205:
                if ("layout/item_discovery_image_view_v8_0".equals(obj)) {
                    return new ItemDiscoveryImageViewV8BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_discovery_image_view_v8 is invalid. Received: " + obj);
            case 206:
                if ("layout/item_discovery_view_0".equals(obj)) {
                    return new ItemDiscoveryViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_discovery_view is invalid. Received: " + obj);
            case 207:
                if ("layout/item_doc_list_card_0".equals(obj)) {
                    return new ItemDocListCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_doc_list_card is invalid. Received: " + obj);
            case 208:
                if ("layout/item_doc_list_card_item_0".equals(obj)) {
                    return new ItemDocListCardItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_doc_list_card_item is invalid. Received: " + obj);
            case 209:
                if ("layout/item_doc_marquee_card_0".equals(obj)) {
                    return new ItemDocMarqueeCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_doc_marquee_card is invalid. Received: " + obj);
            case 210:
                if ("layout/item_download_0".equals(obj)) {
                    return new ItemDownloadBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_download is invalid. Received: " + obj);
            case 211:
                if ("layout/item_dyh_article_content_0".equals(obj)) {
                    return new ItemDyhArticleContentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_dyh_article_content is invalid. Received: " + obj);
            case 212:
                if ("layout/item_dyh_article_header_0".equals(obj)) {
                    return new ItemDyhArticleHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_dyh_article_header is invalid. Received: " + obj);
            case 213:
                if ("layout/item_dyh_article_v8_0".equals(obj)) {
                    return new ItemDyhArticleV8BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_dyh_article_v8 is invalid. Received: " + obj);
            case 214:
                if ("layout/item_dyh_detail_v8_0".equals(obj)) {
                    return new ItemDyhDetailV8BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_dyh_detail_v8 is invalid. Received: " + obj);
            case 215:
                if ("layout/item_dyh_includ_0".equals(obj)) {
                    return new ItemDyhIncludBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_dyh_includ is invalid. Received: " + obj);
            case 216:
                if ("layout/item_dyh_mini_header_0".equals(obj)) {
                    return new ItemDyhMiniHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_dyh_mini_header is invalid. Received: " + obj);
            case 217:
                if ("layout/item_dyh_simple_header_0".equals(obj)) {
                    return new ItemDyhSimpleHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_dyh_simple_header is invalid. Received: " + obj);
            case 218:
                if ("layout/item_dyh_source_part_0".equals(obj)) {
                    return new ItemDyhSourcePartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_dyh_source_part is invalid. Received: " + obj);
            case 219:
                if ("layout/item_dyh_source_title_0".equals(obj)) {
                    return new ItemDyhSourceTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_dyh_source_title is invalid. Received: " + obj);
            case 220:
                if ("layout/item_dyharticle_action_0".equals(obj)) {
                    return new ItemDyharticleActionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_dyharticle_action is invalid. Received: " + obj);
            case 221:
                if ("layout/item_edit_goods_0".equals(obj)) {
                    return new ItemEditGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_edit_goods is invalid. Received: " + obj);
            case 222:
                if ("layout/item_empty_view_0".equals(obj)) {
                    return new ItemEmptyViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_empty_view is invalid. Received: " + obj);
            case 223:
                if ("layout/item_entity_video_detail_view_part_0".equals(obj)) {
                    return new ItemEntityVideoDetailViewPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_entity_video_detail_view_part is invalid. Received: " + obj);
            case 224:
                if ("layout/item_favorite_0".equals(obj)) {
                    return new ItemFavoriteBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_favorite is invalid. Received: " + obj);
            case 225:
                if ("layout/item_feed_action_view_0".equals(obj)) {
                    return new ItemFeedActionViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_action_view is invalid. Received: " + obj);
            case 226:
                if ("layout/item_feed_album_layout_0".equals(obj)) {
                    return new ItemFeedAlbumLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_album_layout is invalid. Received: " + obj);
            case 227:
                if ("layout/item_feed_base_0".equals(obj)) {
                    return new ItemFeedBaseBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_base is invalid. Received: " + obj);
            case 228:
                if ("layout/item_feed_bind_goods_0".equals(obj)) {
                    return new ItemFeedBindGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_bind_goods is invalid. Received: " + obj);
            case 229:
                if ("layout/item_feed_cool_pic_detail_0".equals(obj)) {
                    return new ItemFeedCoolPicDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_cool_pic_detail is invalid. Received: " + obj);
            case 230:
                if ("layout/item_feed_cool_pic_layout_0".equals(obj)) {
                    return new ItemFeedCoolPicLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_cool_pic_layout is invalid. Received: " + obj);
            case 231:
                if ("layout/item_feed_cover_view_0".equals(obj)) {
                    return new ItemFeedCoverViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_cover_view is invalid. Received: " + obj);
            case 232:
                if ("layout/item_feed_detail_view_v8_0".equals(obj)) {
                    return new ItemFeedDetailViewV8BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_detail_view_v8 is invalid. Received: " + obj);
            case 233:
                if ("layout/item_feed_discovery_detail_0".equals(obj)) {
                    return new ItemFeedDiscoveryDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_discovery_detail is invalid. Received: " + obj);
            case 234:
                if ("layout/item_feed_extra_type_part_0".equals(obj)) {
                    return new ItemFeedExtraTypePartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_extra_type_part is invalid. Received: " + obj);
            case 235:
                if ("layout/item_feed_filter_0".equals(obj)) {
                    return new ItemFeedFilterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_filter is invalid. Received: " + obj);
            case 236:
                if ("layout/item_feed_followable_header_view_0".equals(obj)) {
                    return new ItemFeedFollowableHeaderViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_followable_header_view is invalid. Received: " + obj);
            case 237:
                if ("layout/item_feed_forward_view_0".equals(obj)) {
                    return new ItemFeedForwardViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_forward_view is invalid. Received: " + obj);
            case 238:
                if ("layout/item_feed_goods_0".equals(obj)) {
                    return new ItemFeedGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_goods is invalid. Received: " + obj);
            case 239:
                if ("layout/item_feed_goods_detail_0".equals(obj)) {
                    return new ItemFeedGoodsDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_goods_detail is invalid. Received: " + obj);
            case 240:
                if ("layout/item_feed_goods_detail_image_0".equals(obj)) {
                    return new ItemFeedGoodsDetailImageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_goods_detail_image is invalid. Received: " + obj);
            case 241:
                if ("layout/item_feed_goods_info_0".equals(obj)) {
                    return new ItemFeedGoodsInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_goods_info is invalid. Received: " + obj);
            case 242:
                if ("layout/item_feed_header_view_0".equals(obj)) {
                    return new ItemFeedHeaderViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_header_view is invalid. Received: " + obj);
            case 243:
                if ("layout/item_feed_image_0".equals(obj)) {
                    return new ItemFeedImageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_image is invalid. Received: " + obj);
            case 244:
                if ("layout/item_feed_layout_v8_0".equals(obj)) {
                    return new ItemFeedLayoutV8BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_layout_v8 is invalid. Received: " + obj);
            case 245:
                if ("layout/item_feed_news_bottom_0".equals(obj)) {
                    return new ItemFeedNewsBottomBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_news_bottom is invalid. Received: " + obj);
            case 246:
                if ("layout/item_feed_news_view_0".equals(obj)) {
                    return new ItemFeedNewsViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_news_view is invalid. Received: " + obj);
            case 247:
                if ("layout/item_feed_rating_0".equals(obj)) {
                    return new ItemFeedRatingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_rating is invalid. Received: " + obj);
            case 248:
                if ("layout/item_feed_rating_data_0".equals(obj)) {
                    return new ItemFeedRatingDataBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_rating_data is invalid. Received: " + obj);
            case 249:
                if ("layout/item_feed_rating_detail_0".equals(obj)) {
                    return new ItemFeedRatingDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_rating_detail is invalid. Received: " + obj);
            case 250:
                if ("layout/item_feed_rating_header_0".equals(obj)) {
                    return new ItemFeedRatingHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_rating_header is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding5(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 251:
                if ("layout/item_feed_rating_view_0".equals(obj)) {
                    return new ItemFeedRatingViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_rating_view is invalid. Received: " + obj);
            case 252:
                if ("layout/item_feed_reply_0".equals(obj)) {
                    return new ItemFeedReplyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_reply is invalid. Received: " + obj);
            case 253:
                if ("layout/item_feed_reply_hot_0".equals(obj)) {
                    return new ItemFeedReplyHotBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_reply_hot is invalid. Received: " + obj);
            case 254:
                if ("layout/item_feed_reply_me_0".equals(obj)) {
                    return new ItemFeedReplyMeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_reply_me is invalid. Received: " + obj);
            case 255:
                if ("layout/item_feed_reply_part_0".equals(obj)) {
                    return new ItemFeedReplyPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_reply_part is invalid. Received: " + obj);
            case 256:
                if ("layout/item_feed_reply_text_0".equals(obj)) {
                    return new ItemFeedReplyTextBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_reply_text is invalid. Received: " + obj);
            case 257:
                if ("layout/item_feed_reply_title_0".equals(obj)) {
                    return new ItemFeedReplyTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_reply_title is invalid. Received: " + obj);
            case 258:
                if ("layout/item_feed_rough_draft_0".equals(obj)) {
                    return new ItemFeedRoughDraftBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_rough_draft is invalid. Received: " + obj);
            case 259:
                if ("layout/item_feed_scroll_item_0".equals(obj)) {
                    return new ItemFeedScrollItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_scroll_item is invalid. Received: " + obj);
            case 260:
                if ("layout/item_feed_second_hand_header_view_part_0".equals(obj)) {
                    return new ItemFeedSecondHandHeaderViewPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_second_hand_header_view_part is invalid. Received: " + obj);
            case 261:
                if ("layout/item_feed_second_hand_view_part_0".equals(obj)) {
                    return new ItemFeedSecondHandViewPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_second_hand_view_part is invalid. Received: " + obj);
            case 262:
                if ("layout/item_feed_share_action_view_0".equals(obj)) {
                    return new ItemFeedShareActionViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_share_action_view is invalid. Received: " + obj);
            case 263:
                if ("layout/item_feed_small_header_view_0".equals(obj)) {
                    return new ItemFeedSmallHeaderViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_small_header_view is invalid. Received: " + obj);
            case 264:
                if ("layout/item_feed_small_title_0".equals(obj)) {
                    return new ItemFeedSmallTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_small_title is invalid. Received: " + obj);
            case 265:
                if ("layout/item_feed_source_deleted_0".equals(obj)) {
                    return new ItemFeedSourceDeletedBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_source_deleted is invalid. Received: " + obj);
            case 266:
                if ("layout/item_feed_source_part_0".equals(obj)) {
                    return new ItemFeedSourcePartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_source_part is invalid. Received: " + obj);
            case 267:
                if ("layout/item_feed_stack_item_0".equals(obj)) {
                    return new ItemFeedStackItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_stack_item is invalid. Received: " + obj);
            case 268:
                if ("layout/item_feed_target_view_0".equals(obj)) {
                    return new ItemFeedTargetViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_target_view is invalid. Received: " + obj);
            case 269:
                if ("layout/item_feed_title_0".equals(obj)) {
                    return new ItemFeedTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_title is invalid. Received: " + obj);
            case 270:
                if ("layout/item_feed_video_detail_view_part_0".equals(obj)) {
                    return new ItemFeedVideoDetailViewPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_video_detail_view_part is invalid. Received: " + obj);
            case 271:
                if ("layout/item_feed_vote_0".equals(obj)) {
                    return new ItemFeedVoteBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_vote is invalid. Received: " + obj);
            case 272:
                if ("layout/item_feed_vote_comment_0".equals(obj)) {
                    return new ItemFeedVoteCommentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_vote_comment is invalid. Received: " + obj);
            case 273:
                if ("layout/item_feed_vote_comment_detail_0".equals(obj)) {
                    return new ItemFeedVoteCommentDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_vote_comment_detail is invalid. Received: " + obj);
            case 274:
                if ("layout/item_feed_vote_comment_small_0".equals(obj)) {
                    return new ItemFeedVoteCommentSmallBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_vote_comment_small is invalid. Received: " + obj);
            case 275:
                if ("layout/item_feed_vote_comment_view_part_0".equals(obj)) {
                    return new ItemFeedVoteCommentViewPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_vote_comment_view_part is invalid. Received: " + obj);
            case 276:
                if ("layout/item_feed_vote_header_0".equals(obj)) {
                    return new ItemFeedVoteHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_vote_header is invalid. Received: " + obj);
            case 277:
                if ("layout/item_feed_vote_multi_0".equals(obj)) {
                    return new ItemFeedVoteMultiBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_vote_multi is invalid. Received: " + obj);
            case 278:
                if ("layout/item_feed_vote_pk_0".equals(obj)) {
                    return new ItemFeedVotePkBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_vote_pk is invalid. Received: " + obj);
            case 279:
                if ("layout/item_feed_vote_pk_result_0".equals(obj)) {
                    return new ItemFeedVotePkResultBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feed_vote_pk_result is invalid. Received: " + obj);
            case 280:
                if ("layout/item_file_0".equals(obj)) {
                    return new ItemFileBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_file is invalid. Received: " + obj);
            case 281:
                if ("layout/item_file_title_0".equals(obj)) {
                    return new ItemFileTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_file_title is invalid. Received: " + obj);
            case 282:
                if ("layout/item_folded_view_0".equals(obj)) {
                    return new ItemFoldedViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_folded_view is invalid. Received: " + obj);
            case 283:
                if ("layout/item_follow_dyh_0".equals(obj)) {
                    return new ItemFollowDyhBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_follow_dyh is invalid. Received: " + obj);
            case 284:
                if ("layout/item_foot_0".equals(obj)) {
                    return new ItemFootBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_foot is invalid. Received: " + obj);
            case 285:
                if ("layout/item_forward_entity_share_app_0".equals(obj)) {
                    return new ItemForwardEntityShareAppBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_forward_entity_share_app is invalid. Received: " + obj);
            case 286:
                if ("layout/item_fun_thing_0".equals(obj)) {
                    return new ItemFunThingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_fun_thing is invalid. Received: " + obj);
            case 287:
                if ("layout/item_gift_item_0".equals(obj)) {
                    return new ItemGiftItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_gift_item is invalid. Received: " + obj);
            case 288:
                if ("layout/item_good_goods_0".equals(obj)) {
                    return new ItemGoodGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_good_goods is invalid. Received: " + obj);
            case 289:
                if ("layout/item_good_goods_add_0".equals(obj)) {
                    return new ItemGoodGoodsAddBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_good_goods_add is invalid. Received: " + obj);
            case 290:
                if ("layout/item_good_goods_list_header_0".equals(obj)) {
                    return new ItemGoodGoodsListHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_good_goods_list_header is invalid. Received: " + obj);
            case 291:
                if ("layout/item_goods_0".equals(obj)) {
                    return new ItemGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_goods is invalid. Received: " + obj);
            case 292:
                if ("layout/item_goods_fall_0".equals(obj)) {
                    return new ItemGoodsFallBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_goods_fall is invalid. Received: " + obj);
            case 293:
                if ("layout/item_goods_list_0".equals(obj)) {
                    return new ItemGoodsListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_goods_list is invalid. Received: " + obj);
            case 294:
                if ("layout/item_goods_list_edit_header_0".equals(obj)) {
                    return new ItemGoodsListEditHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_goods_list_edit_header is invalid. Received: " + obj);
            case 295:
                if ("layout/item_goods_list_feed_0".equals(obj)) {
                    return new ItemGoodsListFeedBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_goods_list_feed is invalid. Received: " + obj);
            case 296:
                if ("layout/item_goods_list_simple_0".equals(obj)) {
                    return new ItemGoodsListSimpleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_goods_list_simple is invalid. Received: " + obj);
            case 297:
                if ("layout/item_goods_params_0".equals(obj)) {
                    return new ItemGoodsParamsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_goods_params is invalid. Received: " + obj);
            case 298:
                if ("layout/item_goods_v10_0".equals(obj)) {
                    return new ItemGoodsV10BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_goods_v10 is invalid. Received: " + obj);
            case 299:
                if ("layout/item_grid_album_card_0".equals(obj)) {
                    return new ItemGridAlbumCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_grid_album_card is invalid. Received: " + obj);
            case 300:
                if ("layout/item_grid_card_0".equals(obj)) {
                    return new ItemGridCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_grid_card is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding6(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 301:
                if ("layout/item_grid_card_item_0".equals(obj)) {
                    return new ItemGridCardItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_grid_card_item is invalid. Received: " + obj);
            case 302:
                if ("layout/item_grid_card_view_0".equals(obj)) {
                    return new ItemGridCardViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_grid_card_view is invalid. Received: " + obj);
            case 303:
                if ("layout/item_grid_dyh_card_0".equals(obj)) {
                    return new ItemGridDyhCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_grid_dyh_card is invalid. Received: " + obj);
            case 304:
                if ("layout/item_grid_dyh_card_item_0".equals(obj)) {
                    return new ItemGridDyhCardItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_grid_dyh_card_item is invalid. Received: " + obj);
            case 305:
                if ("layout/item_grid_item_long_title_0".equals(obj)) {
                    return new ItemGridItemLongTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_grid_item_long_title is invalid. Received: " + obj);
            case 306:
                if ("layout/item_group_list_card_0".equals(obj)) {
                    return new ItemGroupListCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_group_list_card is invalid. Received: " + obj);
            case 307:
                if ("layout/item_head_card_0".equals(obj)) {
                    return new ItemHeadCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_head_card is invalid. Received: " + obj);
            case 308:
                if ("layout/item_headline_title_0".equals(obj)) {
                    return new ItemHeadlineTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_headline_title is invalid. Received: " + obj);
            case 309:
                if ("layout/item_hot_feed_reply_view_part_0".equals(obj)) {
                    return new ItemHotFeedReplyViewPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_hot_feed_reply_view_part is invalid. Received: " + obj);
            case 310:
                if ("layout/item_hot_search_list_0".equals(obj)) {
                    return new ItemHotSearchListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_hot_search_list is invalid. Received: " + obj);
            case 311:
                if ("layout/item_hot_search_user_0".equals(obj)) {
                    return new ItemHotSearchUserBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_hot_search_user is invalid. Received: " + obj);
            case 312:
                if ("layout/item_icon_button_grid_card_0".equals(obj)) {
                    return new ItemIconButtonGridCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_icon_button_grid_card is invalid. Received: " + obj);
            case 313:
                if ("layout/item_icon_grid_card_item_0".equals(obj)) {
                    return new ItemIconGridCardItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_icon_grid_card_item is invalid. Received: " + obj);
            case 314:
                if ("layout/item_icon_link_grid_card_0".equals(obj)) {
                    return new ItemIconLinkGridCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_icon_link_grid_card is invalid. Received: " + obj);
            case 315:
                if ("layout/item_icon_link_grid_card_item_0".equals(obj)) {
                    return new ItemIconLinkGridCardItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_icon_link_grid_card_item is invalid. Received: " + obj);
            case 316:
                if ("layout/item_icon_link_mini_grid_card_item_0".equals(obj)) {
                    return new ItemIconLinkMiniGridCardItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_icon_link_mini_grid_card_item is invalid. Received: " + obj);
            case 317:
                if ("layout/item_icon_mini_grid_card_0".equals(obj)) {
                    return new ItemIconMiniGridCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_icon_mini_grid_card is invalid. Received: " + obj);
            case 318:
                if ("layout/item_icon_mini_grid_card_item_0".equals(obj)) {
                    return new ItemIconMiniGridCardItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_icon_mini_grid_card_item is invalid. Received: " + obj);
            case 319:
                if ("layout/item_icon_title_view_0".equals(obj)) {
                    return new ItemIconTitleViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_icon_title_view is invalid. Received: " + obj);
            case 320:
                if ("layout/item_image_app_big_card_0".equals(obj)) {
                    return new ItemImageAppBigCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_image_app_big_card is invalid. Received: " + obj);
            case 321:
                if ("layout/item_image_app_card_0".equals(obj)) {
                    return new ItemImageAppCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_image_app_card is invalid. Received: " + obj);
            case 322:
                if ("layout/item_image_card_0".equals(obj)) {
                    return new ItemImageCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_image_card is invalid. Received: " + obj);
            case 323:
                if ("layout/item_image_carousel_card1_item_0".equals(obj)) {
                    return new ItemImageCarouselCard1ItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_image_carousel_card1_item is invalid. Received: " + obj);
            case 324:
                if ("layout/item_image_carousel_card2_0".equals(obj)) {
                    return new ItemImageCarouselCard2BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_image_carousel_card2 is invalid. Received: " + obj);
            case 325:
                if ("layout/item_image_carousel_card2_item_0".equals(obj)) {
                    return new ItemImageCarouselCard2ItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_image_carousel_card2_item is invalid. Received: " + obj);
            case 326:
                if ("layout/item_image_list_card_0".equals(obj)) {
                    return new ItemImageListCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_image_list_card is invalid. Received: " + obj);
            case 327:
                if ("layout/item_image_scroll_card_0".equals(obj)) {
                    return new ItemImageScrollCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_image_scroll_card is invalid. Received: " + obj);
            case 328:
                if ("layout/item_image_scroll_card_item_0".equals(obj)) {
                    return new ItemImageScrollCardItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_image_scroll_card_item is invalid. Received: " + obj);
            case 329:
                if ("layout/item_image_text_card_child_0".equals(obj)) {
                    return new ItemImageTextCardChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_image_text_card_child is invalid. Received: " + obj);
            case 330:
                if ("layout/item_large_scroll_card_goods_item_0".equals(obj)) {
                    return new ItemLargeScrollCardGoodsItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_large_scroll_card_goods_item is invalid. Received: " + obj);
            case 331:
                if ("layout/item_large_scroll_card_item_0".equals(obj)) {
                    return new ItemLargeScrollCardItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_large_scroll_card_item is invalid. Received: " + obj);
            case 332:
                if ("layout/item_large_text_0".equals(obj)) {
                    return new ItemLargeTextBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_large_text is invalid. Received: " + obj);
            case 333:
                if ("layout/item_layout_dyh_includ_0".equals(obj)) {
                    return new ItemLayoutDyhIncludBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_layout_dyh_includ is invalid. Received: " + obj);
            case 334:
                if ("layout/item_library_show_0".equals(obj)) {
                    return new ItemLibraryShowBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_library_show is invalid. Received: " + obj);
            case 335:
                if ("layout/item_link_card_0".equals(obj)) {
                    return new ItemLinkCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_link_card is invalid. Received: " + obj);
            case 336:
                if ("layout/item_link_card_tab_0".equals(obj)) {
                    return new ItemLinkCardTabBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_link_card_tab is invalid. Received: " + obj);
            case 337:
                if ("layout/item_link_card_v8_0".equals(obj)) {
                    return new ItemLinkCardV8BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_link_card_v8 is invalid. Received: " + obj);
            case 338:
                if ("layout/item_list_card_0".equals(obj)) {
                    return new ItemListCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_list_card is invalid. Received: " + obj);
            case 339:
                if ("layout/item_live_card_0".equals(obj)) {
                    return new ItemLiveCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_live_card is invalid. Received: " + obj);
            case 340:
                if ("layout/item_live_image_text_card_0".equals(obj)) {
                    return new ItemLiveImageTextCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_live_image_text_card is invalid. Received: " + obj);
            case 341:
                if ("layout/item_live_item_card_0".equals(obj)) {
                    return new ItemLiveItemCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_live_item_card is invalid. Received: " + obj);
            case 342:
                if ("layout/item_live_line_view_part_0".equals(obj)) {
                    return new ItemLiveLineViewPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_live_line_view_part is invalid. Received: " + obj);
            case 343:
                if ("layout/item_live_message_0".equals(obj)) {
                    return new ItemLiveMessageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_live_message is invalid. Received: " + obj);
            case 344:
                if ("layout/item_live_system_message_0".equals(obj)) {
                    return new ItemLiveSystemMessageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_live_system_message is invalid. Received: " + obj);
            case 345:
                if ("layout/item_live_video_view_part_0".equals(obj)) {
                    return new ItemLiveVideoViewPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_live_video_view_part is invalid. Received: " + obj);
            case 346:
                if ("layout/item_local_apk_0".equals(obj)) {
                    return new ItemLocalApkBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_local_apk is invalid. Received: " + obj);
            case 347:
                if ("layout/item_local_app_0".equals(obj)) {
                    return new ItemLocalAppBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_local_app is invalid. Received: " + obj);
            case 348:
                if ("layout/item_location_0".equals(obj)) {
                    return new ItemLocationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_location is invalid. Received: " + obj);
            case 349:
                if ("layout/item_log_file_0".equals(obj)) {
                    return new ItemLogFileBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_log_file is invalid. Received: " + obj);
            case 350:
                if ("layout/item_login_card_0".equals(obj)) {
                    return new ItemLoginCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_login_card is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding7(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 351:
                if ("layout/item_login_user_node_rating_selector_0".equals(obj)) {
                    return new ItemLoginUserNodeRatingSelectorBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_login_user_node_rating_selector is invalid. Received: " + obj);
            case 352:
                if ("layout/item_main_category_child_0".equals(obj)) {
                    return new ItemMainCategoryChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_main_category_child is invalid. Received: " + obj);
            case 353:
                if ("layout/item_main_category_detail_s_0".equals(obj)) {
                    return new ItemMainCategoryDetailSBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_main_category_detail_s is invalid. Received: " + obj);
            case 354:
                if ("layout/item_main_category_link_0".equals(obj)) {
                    return new ItemMainCategoryLinkBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_main_category_link is invalid. Received: " + obj);
            case 355:
                if ("layout/item_main_catogory_type_0".equals(obj)) {
                    return new ItemMainCatogoryTypeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_main_catogory_type is invalid. Received: " + obj);
            case 356:
                if ("layout/item_market_apps_0".equals(obj)) {
                    return new ItemMarketAppsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_market_apps is invalid. Received: " + obj);
            case 357:
                if ("layout/item_menu_item_0".equals(obj)) {
                    return new ItemMenuItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_menu_item is invalid. Received: " + obj);
            case 358:
                if ("layout/item_message_0".equals(obj)) {
                    return new ItemMessageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_message is invalid. Received: " + obj);
            case 359:
                if ("layout/item_message_card_0".equals(obj)) {
                    return new ItemMessageCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_message_card is invalid. Received: " + obj);
            case 360:
                if ("layout/item_message_extra_0".equals(obj)) {
                    return new ItemMessageExtraBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_message_extra is invalid. Received: " + obj);
            case 361:
                if ("layout/item_message_select_view_0".equals(obj)) {
                    return new ItemMessageSelectViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_message_select_view is invalid. Received: " + obj);
            case 362:
                if ("layout/item_mobile_album_app_new_0".equals(obj)) {
                    return new ItemMobileAlbumAppNewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_mobile_album_app_new is invalid. Received: " + obj);
            case 363:
                if ("layout/item_mobile_app_0".equals(obj)) {
                    return new ItemMobileAppBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_mobile_app is invalid. Received: " + obj);
            case 364:
                if ("layout/item_mobile_app_switch_0".equals(obj)) {
                    return new ItemMobileAppSwitchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_mobile_app_switch is invalid. Received: " + obj);
            case 365:
                if ("layout/item_more_action_0".equals(obj)) {
                    return new ItemMoreActionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_more_action is invalid. Received: " + obj);
            case 366:
                if ("layout/item_my_empty_card_0".equals(obj)) {
                    return new ItemMyEmptyCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_my_empty_card is invalid. Received: " + obj);
            case 367:
                if ("layout/item_new_add_0".equals(obj)) {
                    return new ItemNewAddBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_new_add is invalid. Received: " + obj);
            case 368:
                if ("layout/item_new_feed_image_0".equals(obj)) {
                    return new ItemNewFeedImageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_new_feed_image is invalid. Received: " + obj);
            case 369:
                if ("layout/item_new_grid_card_0".equals(obj)) {
                    return new ItemNewGridCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_new_grid_card is invalid. Received: " + obj);
            case 370:
                if ("layout/item_no_login_titel_0".equals(obj)) {
                    return new ItemNoLoginTitelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_no_login_titel is invalid. Received: " + obj);
            case 371:
                if ("layout/item_no_more_data_view_0".equals(obj)) {
                    return new ItemNoMoreDataViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_no_more_data_view is invalid. Received: " + obj);
            case 372:
                if ("layout/item_node_pick_item_0".equals(obj)) {
                    return new ItemNodePickItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_node_pick_item is invalid. Received: " + obj);
            case 373:
                if ("layout/item_node_rating_0".equals(obj)) {
                    return new ItemNodeRatingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_node_rating is invalid. Received: " + obj);
            case 374:
                if ("layout/item_node_rating_selector_0".equals(obj)) {
                    return new ItemNodeRatingSelectorBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_node_rating_selector is invalid. Received: " + obj);
            case 375:
                if ("layout/item_node_top_conten_item_0".equals(obj)) {
                    return new ItemNodeTopContenItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_node_top_conten_item is invalid. Received: " + obj);
            case 376:
                if ("layout/item_notification_0".equals(obj)) {
                    return new ItemNotificationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_notification is invalid. Received: " + obj);
            case 377:
                if ("layout/item_notification_album_like_0".equals(obj)) {
                    return new ItemNotificationAlbumLikeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_notification_album_like is invalid. Received: " + obj);
            case 378:
                if ("layout/item_notification_feed_like_0".equals(obj)) {
                    return new ItemNotificationFeedLikeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_notification_feed_like is invalid. Received: " + obj);
            case 379:
                if ("layout/item_notification_feedreply_like_0".equals(obj)) {
                    return new ItemNotificationFeedreplyLikeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_notification_feedreply_like is invalid. Received: " + obj);
            case 380:
                if ("layout/item_notification_navi_0".equals(obj)) {
                    return new ItemNotificationNaviBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_notification_navi is invalid. Received: " + obj);
            case 381:
                if ("layout/item_options_title_0".equals(obj)) {
                    return new ItemOptionsTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_options_title is invalid. Received: " + obj);
            case 382:
                if ("layout/item_permission_0".equals(obj)) {
                    return new ItemPermissionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_permission is invalid. Received: " + obj);
            case 383:
                if ("layout/item_permissions_0".equals(obj)) {
                    return new ItemPermissionsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_permissions is invalid. Received: " + obj);
            case 384:
                if ("layout/item_photo_directory_0".equals(obj)) {
                    return new ItemPhotoDirectoryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_photo_directory is invalid. Received: " + obj);
            case 385:
                if ("layout/item_photo_picker_0".equals(obj)) {
                    return new ItemPhotoPickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_photo_picker is invalid. Received: " + obj);
            case 386:
                if ("layout/item_photo_view_0".equals(obj)) {
                    return new ItemPhotoViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_photo_view is invalid. Received: " + obj);
            case 387:
                if ("layout/item_pic_category_0".equals(obj)) {
                    return new ItemPicCategoryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_pic_category is invalid. Received: " + obj);
            case 388:
                if ("layout/item_pic_type_tab_0".equals(obj)) {
                    return new ItemPicTypeTabBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_pic_type_tab is invalid. Received: " + obj);
            case 389:
                if ("layout/item_pick_app_0".equals(obj)) {
                    return new ItemPickAppBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_pick_app is invalid. Received: " + obj);
            case 390:
                if ("layout/item_pick_service_app_0".equals(obj)) {
                    return new ItemPickServiceAppBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_pick_service_app is invalid. Received: " + obj);
            case 391:
                if ("layout/item_picture_switch_0".equals(obj)) {
                    return new ItemPictureSwitchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_picture_switch is invalid. Received: " + obj);
            case 392:
                if ("layout/item_place_holder_0".equals(obj)) {
                    return new ItemPlaceHolderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_place_holder is invalid. Received: " + obj);
            case 393:
                if ("layout/item_podium_card_0".equals(obj)) {
                    return new ItemPodiumCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_podium_card is invalid. Received: " + obj);
            case 394:
                if ("layout/item_podium_card_item_0".equals(obj)) {
                    return new ItemPodiumCardItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_podium_card_item is invalid. Received: " + obj);
            case 395:
                if ("layout/item_product_brand_left_item_0".equals(obj)) {
                    return new ItemProductBrandLeftItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_brand_left_item is invalid. Received: " + obj);
            case 396:
                if ("layout/item_product_config_item_0".equals(obj)) {
                    return new ItemProductConfigItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_config_item is invalid. Received: " + obj);
            case 397:
                if ("layout/item_product_config_title_0".equals(obj)) {
                    return new ItemProductConfigTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_config_title is invalid. Received: " + obj);
            case 398:
                if ("layout/item_product_coupon_0".equals(obj)) {
                    return new ItemProductCouponBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_coupon is invalid. Received: " + obj);
            case 399:
                if ("layout/item_product_coupon_device_0".equals(obj)) {
                    return new ItemProductCouponDeviceBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_coupon_device is invalid. Received: " + obj);
            case 400:
                if ("layout/item_product_description_0".equals(obj)) {
                    return new ItemProductDescriptionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_description is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding8(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 401:
                if ("layout/item_product_extra_params_0".equals(obj)) {
                    return new ItemProductExtraParamsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_extra_params is invalid. Received: " + obj);
            case 402:
                if ("layout/item_product_media_0".equals(obj)) {
                    return new ItemProductMediaBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_media is invalid. Received: " + obj);
            case 403:
                if ("layout/item_product_multi_rating_map_0".equals(obj)) {
                    return new ItemProductMultiRatingMapBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_multi_rating_map is invalid. Received: " + obj);
            case 404:
                if ("layout/item_product_params_0".equals(obj)) {
                    return new ItemProductParamsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_params is invalid. Received: " + obj);
            case 405:
                if ("layout/item_product_score_view_0".equals(obj)) {
                    return new ItemProductScoreViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_score_view is invalid. Received: " + obj);
            case 406:
                if ("layout/item_product_series_0".equals(obj)) {
                    return new ItemProductSeriesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_series is invalid. Received: " + obj);
            case 407:
                if ("layout/item_product_series_child_0".equals(obj)) {
                    return new ItemProductSeriesChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_series_child is invalid. Received: " + obj);
            case 408:
                if ("layout/item_product_series_ershou_0".equals(obj)) {
                    return new ItemProductSeriesErshouBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_series_ershou is invalid. Received: " + obj);
            case 409:
                if ("layout/item_product_series_horizontal_0".equals(obj)) {
                    return new ItemProductSeriesHorizontalBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_series_horizontal is invalid. Received: " + obj);
            case 410:
                if ("layout/item_product_series_list_more_0".equals(obj)) {
                    return new ItemProductSeriesListMoreBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_series_list_more is invalid. Received: " + obj);
            case 411:
                if ("layout/item_product_series_list_title_0".equals(obj)) {
                    return new ItemProductSeriesListTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_series_list_title is invalid. Received: " + obj);
            case 412:
                if ("layout/item_product_series_vertical_0".equals(obj)) {
                    return new ItemProductSeriesVerticalBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_series_vertical is invalid. Received: " + obj);
            case 413:
                if ("layout/item_product_small_rating_article_0".equals(obj)) {
                    return new ItemProductSmallRatingArticleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_small_rating_article is invalid. Received: " + obj);
            case 414:
                if ("layout/item_product_small_rating_feed_0".equals(obj)) {
                    return new ItemProductSmallRatingFeedBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_small_rating_feed is invalid. Received: " + obj);
            case 415:
                if ("layout/item_product_timeline_child_0".equals(obj)) {
                    return new ItemProductTimelineChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_timeline_child is invalid. Received: " + obj);
            case 416:
                if ("layout/item_product_view_0".equals(obj)) {
                    return new ItemProductViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product_view is invalid. Received: " + obj);
            case 417:
                if ("layout/item_progress_hint_0".equals(obj)) {
                    return new ItemProgressHintBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_progress_hint is invalid. Received: " + obj);
            case 418:
                if ("layout/item_question_detail_bottom_0".equals(obj)) {
                    return new ItemQuestionDetailBottomBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_question_detail_bottom is invalid. Received: " + obj);
            case 419:
                if ("layout/item_question_detail_view_0".equals(obj)) {
                    return new ItemQuestionDetailViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_question_detail_view is invalid. Received: " + obj);
            case 420:
                if ("layout/item_question_title_view_0".equals(obj)) {
                    return new ItemQuestionTitleViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_question_title_view is invalid. Received: " + obj);
            case 421:
                if ("layout/item_question_view_0".equals(obj)) {
                    return new ItemQuestionViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_question_view is invalid. Received: " + obj);
            case 422:
                if ("layout/item_rank_header_0".equals(obj)) {
                    return new ItemRankHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_rank_header is invalid. Received: " + obj);
            case 423:
                if ("layout/item_rating_card_0".equals(obj)) {
                    return new ItemRatingCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_rating_card is invalid. Received: " + obj);
            case 424:
                if ("layout/item_receiverd_reply_0".equals(obj)) {
                    return new ItemReceiverdReplyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_receiverd_reply is invalid. Received: " + obj);
            case 425:
                if ("layout/item_recent_history_0".equals(obj)) {
                    return new ItemRecentHistoryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_recent_history is invalid. Received: " + obj);
            case 426:
                if ("layout/item_recent_login_0".equals(obj)) {
                    return new ItemRecentLoginBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_recent_login is invalid. Received: " + obj);
            case 427:
                if ("layout/item_refresh_card_0".equals(obj)) {
                    return new ItemRefreshCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_refresh_card is invalid. Received: " + obj);
            case 428:
                if ("layout/item_relate_app_card_0".equals(obj)) {
                    return new ItemRelateAppCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_relate_app_card is invalid. Received: " + obj);
            case 429:
                if ("layout/item_related_data_0".equals(obj)) {
                    return new ItemRelatedDataBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_related_data is invalid. Received: " + obj);
            case 430:
                if ("layout/item_relative_child_0".equals(obj)) {
                    return new ItemRelativeChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_relative_child is invalid. Received: " + obj);
            case 431:
                if ("layout/item_reply_like_list_0".equals(obj)) {
                    return new ItemReplyLikeListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_reply_like_list is invalid. Received: " + obj);
            case 432:
                if ("layout/item_reply_list_0".equals(obj)) {
                    return new ItemReplyListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_reply_list is invalid. Received: " + obj);
            case 433:
                if ("layout/item_reply_more_0".equals(obj)) {
                    return new ItemReplyMoreBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_reply_more is invalid. Received: " + obj);
            case 434:
                if ("layout/item_reply_photo_0".equals(obj)) {
                    return new ItemReplyPhotoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_reply_photo is invalid. Received: " + obj);
            case 435:
                if ("layout/item_reply_photo_add_0".equals(obj)) {
                    return new ItemReplyPhotoAddBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_reply_photo_add is invalid. Received: " + obj);
            case 436:
                if ("layout/item_right_cover_view_0".equals(obj)) {
                    return new ItemRightCoverViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_right_cover_view is invalid. Received: " + obj);
            case 437:
                if ("layout/item_scene_related_0".equals(obj)) {
                    return new ItemSceneRelatedBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_scene_related is invalid. Received: " + obj);
            case 438:
                if ("layout/item_scroll_card_0".equals(obj)) {
                    return new ItemScrollCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_scroll_card is invalid. Received: " + obj);
            case 439:
                if ("layout/item_search_app_filter_0".equals(obj)) {
                    return new ItemSearchAppFilterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_app_filter is invalid. Received: " + obj);
            case 440:
                if ("layout/item_search_ask_filter_0".equals(obj)) {
                    return new ItemSearchAskFilterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_ask_filter is invalid. Received: " + obj);
            case 441:
                if ("layout/item_search_dropdown_0".equals(obj)) {
                    return new ItemSearchDropdownBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_dropdown is invalid. Received: " + obj);
            case 442:
                if ("layout/item_search_extend_0".equals(obj)) {
                    return new ItemSearchExtendBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_extend is invalid. Received: " + obj);
            case 443:
                if ("layout/item_search_extend_footer_0".equals(obj)) {
                    return new ItemSearchExtendFooterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_extend_footer is invalid. Received: " + obj);
            case 444:
                if ("layout/item_search_extend_header_0".equals(obj)) {
                    return new ItemSearchExtendHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_extend_header is invalid. Received: " + obj);
            case 445:
                if ("layout/item_search_feed_filter_0".equals(obj)) {
                    return new ItemSearchFeedFilterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_feed_filter is invalid. Received: " + obj);
            case 446:
                if ("layout/item_search_history_0".equals(obj)) {
                    return new ItemSearchHistoryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_history is invalid. Received: " + obj);
            case 447:
                if ("layout/item_search_hot_0".equals(obj)) {
                    return new ItemSearchHotBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_hot is invalid. Received: " + obj);
            case 448:
                if ("layout/item_search_recommend_0".equals(obj)) {
                    return new ItemSearchRecommendBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_recommend is invalid. Received: " + obj);
            case 449:
                if ("layout/item_search_scene_0".equals(obj)) {
                    return new ItemSearchSceneBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_scene is invalid. Received: " + obj);
            case 450:
                if ("layout/item_search_sh_filter_0".equals(obj)) {
                    return new ItemSearchShFilterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_sh_filter is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding9(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 451:
                if ("layout/item_search_view_0".equals(obj)) {
                    return new ItemSearchViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_view is invalid. Received: " + obj);
            case 452:
                if ("layout/item_second_hand_detail_0".equals(obj)) {
                    return new ItemSecondHandDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_second_hand_detail is invalid. Received: " + obj);
            case 453:
                if ("layout/item_second_hand_fall_0".equals(obj)) {
                    return new ItemSecondHandFallBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_second_hand_fall is invalid. Received: " + obj);
            case 454:
                if ("layout/item_second_hand_search_0".equals(obj)) {
                    return new ItemSecondHandSearchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_second_hand_search is invalid. Received: " + obj);
            case 455:
                if ("layout/item_section_demo_title_0".equals(obj)) {
                    return new ItemSectionDemoTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_section_demo_title is invalid. Received: " + obj);
            case 456:
                if ("layout/item_see_more_0".equals(obj)) {
                    return new ItemSeeMoreBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_see_more is invalid. Received: " + obj);
            case 457:
                if ("layout/item_selector_link_view_0".equals(obj)) {
                    return new ItemSelectorLinkViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_selector_link_view is invalid. Received: " + obj);
            case 458:
                if ("layout/item_service_app_0".equals(obj)) {
                    return new ServiceAppBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_service_app is invalid. Received: " + obj);
            case 459:
                if ("layout/item_service_app_time_0".equals(obj)) {
                    return new ItemServiceAppTimeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_service_app_time is invalid. Received: " + obj);
            case 460:
                if ("layout/item_setting_0".equals(obj)) {
                    return new ItemSettingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_setting is invalid. Received: " + obj);
            case 461:
                if ("layout/item_share_app_0".equals(obj)) {
                    return new ItemShareAppBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_share_app is invalid. Received: " + obj);
            case 462:
                if ("layout/item_simple_divider_0".equals(obj)) {
                    return new ItemSimpleDividerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_simple_divider is invalid. Received: " + obj);
            case 463:
                if ("layout/item_simple_entity_holder_0".equals(obj)) {
                    return new ItemSimpleEntityHolderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_simple_entity_holder is invalid. Received: " + obj);
            case 464:
                if ("layout/item_simple_feed_0".equals(obj)) {
                    return new ItemSimpleFeedBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_simple_feed is invalid. Received: " + obj);
            case 465:
                if ("layout/item_simple_title_0".equals(obj)) {
                    return new ItemSimpleTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_simple_title is invalid. Received: " + obj);
            case 466:
                if ("layout/item_simple_user_view_0".equals(obj)) {
                    return new ItemSimpleUserViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_simple_user_view is invalid. Received: " + obj);
            case 467:
                if ("layout/item_single_rating_0".equals(obj)) {
                    return new ItemSingleRatingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_single_rating is invalid. Received: " + obj);
            case 468:
                if ("layout/item_small_scroll_card_item_0".equals(obj)) {
                    return new ItemSmallScrollCardItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_small_scroll_card_item is invalid. Received: " + obj);
            case 469:
                if ("layout/item_sort_select_0".equals(obj)) {
                    return new ItemSortSelectBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_sort_select is invalid. Received: " + obj);
            case 470:
                if ("layout/item_space_0".equals(obj)) {
                    return new ItemSpaceBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_space is invalid. Received: " + obj);
            case 471:
                if ("layout/item_sponsor_0".equals(obj)) {
                    return new ItemSponsorBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_sponsor is invalid. Received: " + obj);
            case 472:
                if ("layout/item_sponsor_self_draw_0".equals(obj)) {
                    return new ItemSponsorSelfDrawBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_sponsor_self_draw is invalid. Received: " + obj);
            case 473:
                if ("layout/item_sponsor_self_draw_news_0".equals(obj)) {
                    return new ItemSponsorSelfDrawNewsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_sponsor_self_draw_news is invalid. Received: " + obj);
            case 474:
                if ("layout/item_submit_goods_card_0".equals(obj)) {
                    return new ItemSubmitGoodsCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_submit_goods_card is invalid. Received: " + obj);
            case 475:
                if ("layout/item_tab_group_card_0".equals(obj)) {
                    return new ItemTabGroupCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_tab_group_card is invalid. Received: " + obj);
            case 476:
                if ("layout/item_tab_group_card_item_0".equals(obj)) {
                    return new ItemTabGroupCardItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_tab_group_card_item is invalid. Received: " + obj);
            case 477:
                if ("layout/item_tab_view_0".equals(obj)) {
                    return new ItemTabViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_tab_view is invalid. Received: " + obj);
            case 478:
                if ("layout/item_text_0".equals(obj)) {
                    return new ItemTextBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_text is invalid. Received: " + obj);
            case 479:
                if ("layout/item_text_card_0".equals(obj)) {
                    return new ItemTextCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_text_card is invalid. Received: " + obj);
            case 480:
                if ("layout/item_text_carousel_card_0".equals(obj)) {
                    return new ItemTextCarouselCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_text_carousel_card is invalid. Received: " + obj);
            case 481:
                if ("layout/item_text_image_card_0".equals(obj)) {
                    return new ItemTextImageCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_text_image_card is invalid. Received: " + obj);
            case 482:
                if ("layout/item_text_link_card_item_0".equals(obj)) {
                    return new ItemTextLinkCardItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_text_link_card_item is invalid. Received: " + obj);
            case 483:
                if ("layout/item_text_link_item_0".equals(obj)) {
                    return new ItemTextLinkItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_text_link_item is invalid. Received: " + obj);
            case 484:
                if ("layout/item_text_title_scroll_child_0".equals(obj)) {
                    return new ItemTextTitleScrollChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_text_title_scroll_child is invalid. Received: " + obj);
            case 485:
                if ("layout/item_tip_empty_0".equals(obj)) {
                    return new ItemTipEmptyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_tip_empty is invalid. Received: " + obj);
            case 486:
                if ("layout/item_title_0".equals(obj)) {
                    return new ItemTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_title is invalid. Received: " + obj);
            case 487:
                if ("layout/item_title_card_0".equals(obj)) {
                    return new ItemTitleCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_title_card is invalid. Received: " + obj);
            case 488:
                if ("layout/item_title_list_0".equals(obj)) {
                    return new ItemTitleListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_title_list is invalid. Received: " + obj);
            case 489:
                if ("layout/item_title_section_0".equals(obj)) {
                    return new ItemTitleSectionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_title_section is invalid. Received: " + obj);
            case 490:
                if ("layout/item_title_view_0".equals(obj)) {
                    return new ItemTitleViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_title_view is invalid. Received: " + obj);
            case 491:
                if ("layout/item_top_group_card_0".equals(obj)) {
                    return new ItemTopGroupCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_top_group_card is invalid. Received: " + obj);
            case 492:
                if ("layout/item_top_group_card_item_0".equals(obj)) {
                    return new ItemTopGroupCardItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_top_group_card_item is invalid. Received: " + obj);
            case 493:
                if ("layout/item_topic_0".equals(obj)) {
                    return new ItemTopicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_topic is invalid. Received: " + obj);
            case 494:
                if ("layout/item_topic_view_0".equals(obj)) {
                    return new ItemTopicViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_topic_view is invalid. Received: " + obj);
            case 495:
                if ("layout/item_triple_avatar_view_part_0".equals(obj)) {
                    return new ItemTripleAvatarViewPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_triple_avatar_view_part is invalid. Received: " + obj);
            case 496:
                if ("layout/item_triple_cool_pic_0".equals(obj)) {
                    return new ItemTripleCoolPicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_triple_cool_pic is invalid. Received: " + obj);
            case 497:
                if ("layout/item_upgrade_0".equals(obj)) {
                    return new ItemUpgradeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_upgrade is invalid. Received: " + obj);
            case 498:
                if ("layout/item_upgrade_card_0".equals(obj)) {
                    return new ItemUpgradeCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_upgrade_card is invalid. Received: " + obj);
            case 499:
                if ("layout/item_user_0".equals(obj)) {
                    return new ItemUserBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user is invalid. Received: " + obj);
            case 500:
                if ("layout/item_user_cover_add_0".equals(obj)) {
                    return new ItemUserCoverAddBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user_cover_add is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding10(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 501:
                if ("layout/item_user_cover_image_0".equals(obj)) {
                    return new ItemUserCoverImageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user_cover_image is invalid. Received: " + obj);
            case 502:
                if ("layout/item_user_cover_title_0".equals(obj)) {
                    return new ItemUserCoverTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user_cover_title is invalid. Received: " + obj);
            case 503:
                if ("layout/item_user_delete_recent_0".equals(obj)) {
                    return new ItemUserDeleteRecentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user_delete_recent is invalid. Received: " + obj);
            case 504:
                if ("layout/item_user_gift_0".equals(obj)) {
                    return new ItemUserGiftBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user_gift is invalid. Received: " + obj);
            case 505:
                if ("layout/item_user_history_0".equals(obj)) {
                    return new ItemUserHistoryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user_history is invalid. Received: " + obj);
            case 506:
                if ("layout/item_user_info_header_view_0".equals(obj)) {
                    return new ItemUserInfoHeaderViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user_info_header_view is invalid. Received: " + obj);
            case 507:
                if ("layout/item_user_info_num_0".equals(obj)) {
                    return new ItemUserInfoNumBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user_info_num is invalid. Received: " + obj);
            case 508:
                if ("layout/item_user_info_part_0".equals(obj)) {
                    return new ItemUserInfoPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user_info_part is invalid. Received: " + obj);
            case 509:
                if ("layout/item_user_navigation_0".equals(obj)) {
                    return new ItemUserNavigationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user_navigation is invalid. Received: " + obj);
            case 510:
                if ("layout/item_user_node_rating_0".equals(obj)) {
                    return new ItemUserNodeRatingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user_node_rating is invalid. Received: " + obj);
            case 511:
                if ("layout/item_user_profile_avatar_0".equals(obj)) {
                    return new ItemUserProfileAvatarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user_profile_avatar is invalid. Received: " + obj);
            case 512:
                if ("layout/item_user_profile_item_0".equals(obj)) {
                    return new ItemUserProfileItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user_profile_item is invalid. Received: " + obj);
            case 513:
                if ("layout/item_user_rating_0".equals(obj)) {
                    return new ItemUserRatingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user_rating is invalid. Received: " + obj);
            case 514:
                if ("layout/item_user_space_count_0".equals(obj)) {
                    return new ItemUserSpaceCountBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_user_space_count is invalid. Received: " + obj);
            case 515:
                if ("layout/item_version_app_0".equals(obj)) {
                    return new ItemVersionAppBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_version_app is invalid. Received: " + obj);
            case 516:
                if ("layout/item_video_detail_view_part_0".equals(obj)) {
                    return new ItemVideoDetailViewPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_video_detail_view_part is invalid. Received: " + obj);
            case 517:
                if ("layout/item_video_view_0".equals(obj)) {
                    return new ItemVideoViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_video_view is invalid. Received: " + obj);
            case 518:
                if ("layout/item_video_view_part_0".equals(obj)) {
                    return new ItemVideoViewPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_video_view_part is invalid. Received: " + obj);
            case 519:
                if ("layout/item_vote_comment_empty_0".equals(obj)) {
                    return new ItemVoteCommentEmptyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_vote_comment_empty is invalid. Received: " + obj);
            case 520:
                if ("layout/item_vote_detail_splited_title_0".equals(obj)) {
                    return new ItemVoteDetailSplitedTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_vote_detail_splited_title is invalid. Received: " + obj);
            case 521:
                if ("layout/item_vote_user_0".equals(obj)) {
                    return new ItemVoteUserBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_vote_user is invalid. Received: " + obj);
            case 522:
                if ("layout/item_web_view_0".equals(obj)) {
                    return new ItemWebViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_web_view is invalid. Received: " + obj);
            case 523:
                if ("layout/item_webview_page_0".equals(obj)) {
                    return new ItemWebviewPageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_webview_page is invalid. Received: " + obj);
            case 524:
                if ("layout/item_weui_0".equals(obj)) {
                    return new ItemWeuiBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_weui is invalid. Received: " + obj);
            case 525:
                if ("layout/kk_view_0".equals(obj)) {
                    return new KkViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for kk_view is invalid. Received: " + obj);
            case 526:
                if ("layout/layout_image_mode_0".equals(obj)) {
                    return new LayoutImageModeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_image_mode is invalid. Received: " + obj);
            case 527:
                if ("layout/layout_list_edit_button_0".equals(obj)) {
                    return new LayoutListEditButtonBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_list_edit_button is invalid. Received: " + obj);
            case 528:
                if ("layout/layout_message_card_0".equals(obj)) {
                    return new LayoutMessageCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_message_card is invalid. Received: " + obj);
            case 529:
                if ("layout/layout_privacy_clause_0".equals(obj)) {
                    return new LayoutPrivacyClauseBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_privacy_clause is invalid. Received: " + obj);
            case 530:
                if ("layout/layout_tab_config_0".equals(obj)) {
                    return new LayoutTabConfigBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_tab_config is invalid. Received: " + obj);
            case 531:
                if ("layout/layout_water_mark_0".equals(obj)) {
                    return new LayoutWaterMarkBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_water_mark is invalid. Received: " + obj);
            case 532:
                if ("layout/live_activity_0".equals(obj)) {
                    return new LiveActivityBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for live_activity is invalid. Received: " + obj);
            case 533:
                if ("layout/live_float_new_message_0".equals(obj)) {
                    return new LiveFloatNewMessageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for live_float_new_message is invalid. Received: " + obj);
            case 534:
                if ("layout/live_introduce_0".equals(obj)) {
                    return new LiveIntroduceBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for live_introduce is invalid. Received: " + obj);
            case 535:
                if ("layout/live_reply_list_0".equals(obj)) {
                    return new LiveReplyListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for live_reply_list is invalid. Received: " + obj);
            case 536:
                if ("layout/loading_view_0".equals(obj)) {
                    return new LoadingViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for loading_view is invalid. Received: " + obj);
            case 537:
                if ("layout/log_item_0".equals(obj)) {
                    return new LogItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for log_item is invalid. Received: " + obj);
            case 538:
                if ("layout/main_0".equals(obj)) {
                    return new MainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for main is invalid. Received: " + obj);
            case 539:
                if ("layout/main_category_layout_0".equals(obj)) {
                    return new MainCategoryLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for main_category_layout is invalid. Received: " + obj);
            case 540:
                if ("layout/main_center_user_part_0".equals(obj)) {
                    return new MainCenterUserPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for main_center_user_part is invalid. Received: " + obj);
            case 541:
                if ("layout/main_fragment_0".equals(obj)) {
                    return new MainFragmentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for main_fragment is invalid. Received: " + obj);
            case 542:
                if ("layout/market_0".equals(obj)) {
                    return new MarketBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for market is invalid. Received: " + obj);
            case 543:
                if ("layout/message_top_tip_0".equals(obj)) {
                    return new MessageTopTipBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for message_top_tip is invalid. Received: " + obj);
            case 544:
                if ("layout/more_page_0".equals(obj)) {
                    return new MorePageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for more_page is invalid. Received: " + obj);
            case 545:
                if ("layout/network_diagnosis_0".equals(obj)) {
                    return new NetworkDiagnosisBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for network_diagnosis is invalid. Received: " + obj);
            case 546:
                if ("layout/new_album_view_0".equals(obj)) {
                    return new NewAlbumViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for new_album_view is invalid. Received: " + obj);
            case 547:
                if ("layout/new_v8_album_0".equals(obj)) {
                    return new NewV8AlbumBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for new_v8_album is invalid. Received: " + obj);
            case 548:
                if ("layout/night_time_picker_0".equals(obj)) {
                    return new NightTimePickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for night_time_picker is invalid. Received: " + obj);
            case 549:
                if ("layout/node_picker_0".equals(obj)) {
                    return new NodePickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for node_picker is invalid. Received: " + obj);
            case 550:
                if ("layout/node_rating_feed_like_view_0".equals(obj)) {
                    return new NodeRatingFeedLikeViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for node_rating_feed_like_view is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding11(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 551:
                if ("layout/normal_feed_content_v8_0".equals(obj)) {
                    return new NormalFeedContentV8BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for normal_feed_content_v8 is invalid. Received: " + obj);
            case 552:
                if ("layout/permission_0".equals(obj)) {
                    return new PermissionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for permission is invalid. Received: " + obj);
            case 553:
                if ("layout/photo_0".equals(obj)) {
                    return new PhotoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for photo is invalid. Received: " + obj);
            case 554:
                if ("layout/photo_picker_0".equals(obj)) {
                    return new PhotoPickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for photo_picker is invalid. Received: " + obj);
            case 555:
                if ("layout/pic_reply_list_0".equals(obj)) {
                    return new PicReplyListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for pic_reply_list is invalid. Received: " + obj);
            case 556:
                if ("layout/picture_detail_wrap_0".equals(obj)) {
                    return new PictureDetailWrapBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for picture_detail_wrap is invalid. Received: " + obj);
            case 557:
                if ("layout/poi_list_0".equals(obj)) {
                    return new PoiListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for poi_list is invalid. Received: " + obj);
            case 558:
                if ("layout/post_button_setting_0".equals(obj)) {
                    return new PostButtonSettingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for post_button_setting is invalid. Received: " + obj);
            case 559:
                if ("layout/post_more_panel_0".equals(obj)) {
                    return new PostMorePanelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for post_more_panel is invalid. Received: " + obj);
            case 560:
                if ("layout/product_brand_list_0".equals(obj)) {
                    return new ProductBrandListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for product_brand_list is invalid. Received: " + obj);
            case 561:
                if ("layout/product_coupon_activity_0".equals(obj)) {
                    return new ProductCouponActivityBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for product_coupon_activity is invalid. Received: " + obj);
            case 562:
                if ("layout/product_node_header_0".equals(obj)) {
                    return new ProductNodeHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for product_node_header is invalid. Received: " + obj);
            case 563:
                if ("layout/product_node_toolbar_content_0".equals(obj)) {
                    return new ProductNodeToolbarContentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for product_node_toolbar_content is invalid. Received: " + obj);
            case 564:
                if ("layout/product_post_view_0".equals(obj)) {
                    return new ProductPostViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for product_post_view is invalid. Received: " + obj);
            case 565:
                if ("layout/qr_code_0".equals(obj)) {
                    return new QrCodeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for qr_code is invalid. Received: " + obj);
            case 566:
                if ("layout/question_title_0".equals(obj)) {
                    return new QuestionTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for question_title is invalid. Received: " + obj);
            case 567:
                if ("layout/refresh_recycler_0".equals(obj)) {
                    return new RefreshRecyclerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for refresh_recycler is invalid. Received: " + obj);
            case 568:
                if ("layout/refresh_recycler_tabs_0".equals(obj)) {
                    return new RefreshRecyclerTabsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for refresh_recycler_tabs is invalid. Received: " + obj);
            case 569:
                if ("layout/reply_0".equals(obj)) {
                    return new ReplyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for reply is invalid. Received: " + obj);
            case 570:
                if ("layout/rv_in_fragment_layout_0".equals(obj)) {
                    return new RvInFragmentLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for rv_in_fragment_layout is invalid. Received: " + obj);
            case 571:
                if ("layout/scrollable_tablayout_0".equals(obj)) {
                    return new ScrollableTablayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for scrollable_tablayout is invalid. Received: " + obj);
            case 572:
                if ("layout/search_0".equals(obj)) {
                    return new SearchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for search is invalid. Received: " + obj);
            case 573:
                if ("layout/search_back_header_0".equals(obj)) {
                    return new SearchBackHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for search_back_header is invalid. Received: " + obj);
            case 574:
                if ("layout/search_dropdown_item_0".equals(obj)) {
                    return new SearchDropdownItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for search_dropdown_item is invalid. Received: " + obj);
            case 575:
                if ("layout/search_extend_0".equals(obj)) {
                    return new SearchExtendBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for search_extend is invalid. Received: " + obj);
            case 576:
                if ("layout/search_history_0".equals(obj)) {
                    return new SearchHistoryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for search_history is invalid. Received: " + obj);
            case 577:
                if ("layout/search_hot_0".equals(obj)) {
                    return new SearchHotBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for search_hot is invalid. Received: " + obj);
            case 578:
                if ("layout/search_list_0".equals(obj)) {
                    return new SearchListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for search_list is invalid. Received: " + obj);
            case 579:
                if ("layout/search_list_card_0".equals(obj)) {
                    return new SearchListCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for search_list_card is invalid. Received: " + obj);
            case 580:
                if ("layout/search_result_0".equals(obj)) {
                    return new SearchResultBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for search_result is invalid. Received: " + obj);
            case 581:
                if ("layout/search_scene_item_0".equals(obj)) {
                    return new SearchSceneItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for search_scene_item is invalid. Received: " + obj);
            case 582:
                if ("layout/search_scene_list_0".equals(obj)) {
                    return new SearchSceneListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for search_scene_list is invalid. Received: " + obj);
            case 583:
                if ("layout/second_hand_comment_bar_0".equals(obj)) {
                    return new SecondHandCommentBarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for second_hand_comment_bar is invalid. Received: " + obj);
            case 584:
                if ("layout/second_hand_content_v8_0".equals(obj)) {
                    return new SecondHandContentV8BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for second_hand_content_v8 is invalid. Received: " + obj);
            case 585:
                if ("layout/second_hand_extra_child_0".equals(obj)) {
                    return new SecondHandExtraChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for second_hand_extra_child is invalid. Received: " + obj);
            case 586:
                if ("layout/share_feed_v8_0".equals(obj)) {
                    return new ShareFeedV8BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for share_feed_v8 is invalid. Received: " + obj);
            case 587:
                if ("layout/share_good_dialog_0".equals(obj)) {
                    return new ShareGoodDialogBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for share_good_dialog is invalid. Received: " + obj);
            case 588:
                if ("layout/share_list_0".equals(obj)) {
                    return new ShareListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for share_list is invalid. Received: " + obj);
            case 589:
                if ("layout/share_list_view_0".equals(obj)) {
                    return new ShareListViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for share_list_view is invalid. Received: " + obj);
            case 590:
                if ("layout/share_webview_0".equals(obj)) {
                    return new ShareWebviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for share_webview is invalid. Received: " + obj);
            case 591:
                if ("layout/splash_0".equals(obj)) {
                    return new SplashBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for splash is invalid. Received: " + obj);
            case 592:
                if ("layout/splash_v9_0".equals(obj)) {
                    return new SplashV9BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for splash_v9 is invalid. Received: " + obj);
            case 593:
                if ("layout/splash_view_0".equals(obj)) {
                    return new SplashViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for splash_view is invalid. Received: " + obj);
            case 594:
                if ("layout/static_dialog_view_0".equals(obj)) {
                    return new StaticDialogViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for static_dialog_view is invalid. Received: " + obj);
            case 595:
                if ("layout/submit_feed_add_more_item_dialog_0".equals(obj)) {
                    return new SubmitFeedAddMoreItemDialogBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_add_more_item_dialog is invalid. Received: " + obj);
            case 596:
                if ("layout/submit_feed_add_video_item_dialog_0".equals(obj)) {
                    return new SubmitFeedAddVideoItemDialogBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_add_video_item_dialog is invalid. Received: " + obj);
            case 597:
                if ("layout/submit_feed_article_bottom_0".equals(obj)) {
                    return new SubmitFeedArticleBottomBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_article_bottom is invalid. Received: " + obj);
            case 598:
                if ("layout/submit_feed_article_holder2_0".equals(obj)) {
                    return new SubmitFeedArticleHolder2BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_article_holder2 is invalid. Received: " + obj);
            case 599:
                if ("layout/submit_feed_article_image_part_0".equals(obj)) {
                    return new SubmitFeedArticleImagePartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_article_image_part is invalid. Received: " + obj);
            case 600:
                if ("layout/submit_feed_article_text_part_0".equals(obj)) {
                    return new SubmitFeedArticleTextPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_article_text_part is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding12(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 601:
                if ("layout/submit_feed_article_top_answer_0".equals(obj)) {
                    return new SubmitFeedArticleTopAnswerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_article_top_answer is invalid. Received: " + obj);
            case 602:
                if ("layout/submit_feed_article_top_part_0".equals(obj)) {
                    return new SubmitFeedArticleTopPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_article_top_part is invalid. Received: " + obj);
            case 603:
                if ("layout/submit_feed_bottom_add_more_v8_0".equals(obj)) {
                    return new SubmitFeedBottomAddMoreV8BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_bottom_add_more_v8 is invalid. Received: " + obj);
            case 604:
                if ("layout/submit_feed_bottom_set_visibility_0".equals(obj)) {
                    return new SubmitFeedBottomSetVisibilityBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_bottom_set_visibility is invalid. Received: " + obj);
            case 605:
                if ("layout/submit_feed_extra_child_0".equals(obj)) {
                    return new SubmitFeedExtraChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_extra_child is invalid. Received: " + obj);
            case 606:
                if ("layout/submit_feed_extra_logo_0".equals(obj)) {
                    return new SubmitFeedExtraLogoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_extra_logo is invalid. Received: " + obj);
            case 607:
                if ("layout/submit_feed_goods_0".equals(obj)) {
                    return new SubmitFeedGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_goods is invalid. Received: " + obj);
            case 608:
                if ("layout/submit_feed_new_goods_0".equals(obj)) {
                    return new SubmitFeedNewGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_new_goods is invalid. Received: " + obj);
            case 609:
                if ("layout/submit_feed_relative_info_picker_0".equals(obj)) {
                    return new SubmitFeedRelativeInfoPickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_relative_info_picker is invalid. Received: " + obj);
            case 610:
                if ("layout/submit_feed_v8_0".equals(obj)) {
                    return new SubmitFeedV8BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_feed_v8 is invalid. Received: " + obj);
            case 611:
                if ("layout/submit_pick_color_0".equals(obj)) {
                    return new SubmitPickColorBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_pick_color is invalid. Received: " + obj);
            case 612:
                if ("layout/submit_product_article_bottom_0".equals(obj)) {
                    return new SubmitProductArticleBottomBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_product_article_bottom is invalid. Received: " + obj);
            case 613:
                if ("layout/submit_product_article_top_part_0".equals(obj)) {
                    return new SubmitProductArticleTopPartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_product_article_top_part is invalid. Received: " + obj);
            case 614:
                if ("layout/submit_product_content_rating_bar_0".equals(obj)) {
                    return new SubmitProductContentRatingBarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_product_content_rating_bar is invalid. Received: " + obj);
            case 615:
                if ("layout/submit_product_rating_0".equals(obj)) {
                    return new SubmitProductRatingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_product_rating is invalid. Received: " + obj);
            case 616:
                if ("layout/submit_rating_noraml_content_0".equals(obj)) {
                    return new SubmitRatingNoramlContentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_rating_noraml_content is invalid. Received: " + obj);
            case 617:
                if ("layout/submit_second_hand_deal_extra_child_0".equals(obj)) {
                    return new SubmitSecondHandDealExtraChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_second_hand_deal_extra_child is invalid. Received: " + obj);
            case 618:
                if ("layout/submit_second_hand_extra_child_0".equals(obj)) {
                    return new SubmitSecondHandExtraChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_second_hand_extra_child is invalid. Received: " + obj);
            case 619:
                if ("layout/submit_verify_mobile_code_dialog_0".equals(obj)) {
                    return new SubmitVerifyMobileCodeDialogBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_verify_mobile_code_dialog is invalid. Received: " + obj);
            case 620:
                if ("layout/submit_vertfiy_captcha_dialog_0".equals(obj)) {
                    return new SubmitVertfiyCaptchaDialogBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_vertfiy_captcha_dialog is invalid. Received: " + obj);
            case 621:
                if ("layout/submit_view_article_add_link_0".equals(obj)) {
                    return new SubmitViewArticleAddLinkBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_view_article_add_link is invalid. Received: " + obj);
            case 622:
                if ("layout/submit_vote_extra_child_0".equals(obj)) {
                    return new SubmitVoteExtraChildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for submit_vote_extra_child is invalid. Received: " + obj);
            case 623:
                if ("layout/tab_layout_0".equals(obj)) {
                    return new TabLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for tab_layout is invalid. Received: " + obj);
            case 624:
                if ("layout/tag_product_owner_0".equals(obj)) {
                    return new TagProductOwnerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for tag_product_owner is invalid. Received: " + obj);
            case 625:
                if ("layout/test_0".equals(obj)) {
                    return new TestBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for test is invalid. Received: " + obj);
            case 626:
                if ("layout/text_view_0".equals(obj)) {
                    return new TextViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for text_view is invalid. Received: " + obj);
            case 627:
                if ("layout/theme_pick_dialog_0".equals(obj)) {
                    return new ThemePickDialogBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for theme_pick_dialog is invalid. Received: " + obj);
            case 628:
                if ("layout/theme_picker_list_item_0".equals(obj)) {
                    return new ThemePickerListItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for theme_picker_list_item is invalid. Received: " + obj);
            case 629:
                if ("layout/tip_layout_0".equals(obj)) {
                    return new TipLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for tip_layout is invalid. Received: " + obj);
            case 630:
                if ("layout/toolbar_layout_0".equals(obj)) {
                    return new ToolbarLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for toolbar_layout is invalid. Received: " + obj);
            case 631:
                if ("layout/topic_detail_description_0".equals(obj)) {
                    return new TopicDetailDescriptionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for topic_detail_description is invalid. Received: " + obj);
            case 632:
                if ("layout/topic_detail_headline_0".equals(obj)) {
                    return new TopicDetailHeadlineBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for topic_detail_headline is invalid. Received: " + obj);
            case 633:
                if ("layout/topic_node_header_0".equals(obj)) {
                    return new TopicNodeHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for topic_node_header is invalid. Received: " + obj);
            case 634:
                if ("layout/topic_node_header_line_0".equals(obj)) {
                    return new TopicNodeHeaderLineBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for topic_node_header_line is invalid. Received: " + obj);
            case 635:
                if ("layout/topic_node_page_0".equals(obj)) {
                    return new TopicNodePageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for topic_node_page is invalid. Received: " + obj);
            case 636:
                if ("layout/topic_picker_0".equals(obj)) {
                    return new TopicPickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for topic_picker is invalid. Received: " + obj);
            case 637:
                if ("layout/user_avatar_0".equals(obj)) {
                    return new UserAvatarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for user_avatar is invalid. Received: " + obj);
            case 638:
                if ("layout/user_data_0".equals(obj)) {
                    return new UserDataBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for user_data is invalid. Received: " + obj);
            case 639:
                if ("layout/user_key_input_0".equals(obj)) {
                    return new UserKeyInputBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for user_key_input is invalid. Received: " + obj);
            case 640:
                if ("layout/user_pick_0".equals(obj)) {
                    return new UserPickBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for user_pick is invalid. Received: " + obj);
            case 641:
                if ("layout/user_qrcode_0".equals(obj)) {
                    return new UserQrcodeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for user_qrcode is invalid. Received: " + obj);
            case 642:
                if ("layout/user_space_v9_0".equals(obj)) {
                    return new UserSpaceV9BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for user_space_v9 is invalid. Received: " + obj);
            case 643:
                if ("layout/user_toolbar_0".equals(obj)) {
                    return new UserToolbarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for user_toolbar is invalid. Received: " + obj);
            case 644:
                if ("layout/video_complete_0".equals(obj)) {
                    return new VideoCompleteBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for video_complete is invalid. Received: " + obj);
            case 645:
                if ("layout/video_controller_0".equals(obj)) {
                    return new VideoControllerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for video_controller is invalid. Received: " + obj);
            case 646:
                if ("layout/video_error_0".equals(obj)) {
                    return new VideoErrorBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for video_error is invalid. Received: " + obj);
            case 647:
                if ("layout/video_floating_0".equals(obj)) {
                    return new VideoFloatingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for video_floating is invalid. Received: " + obj);
            case 648:
                if ("layout/video_full_screen_0".equals(obj)) {
                    return new VideoFullScreenBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for video_full_screen is invalid. Received: " + obj);
            case 649:
                if ("layout/video_gesture_0".equals(obj)) {
                    return new VideoGestureBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for video_gesture is invalid. Received: " + obj);
            case 650:
                if ("layout/video_loading_0".equals(obj)) {
                    return new VideoLoadingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for video_loading is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding13(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 651:
                if ("layout/video_simple_controller_0".equals(obj)) {
                    return new VideoSimpleControllerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for video_simple_controller is invalid. Received: " + obj);
            case 652:
                if ("layout/vote_feed_content_0".equals(obj)) {
                    return new VoteFeedContentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for vote_feed_content is invalid. Received: " + obj);
            case 653:
                if ("layout/vx_layout_0".equals(obj)) {
                    return new VxLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for vx_layout is invalid. Received: " + obj);
            case 654:
                if ("layout/web_view_0".equals(obj)) {
                    return new WebViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for web_view is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch ((i2 - 1) / 50) {
                case 0:
                    return internalGetViewDataBinding0(dataBindingComponent, view, i2, tag);
                case 1:
                    return internalGetViewDataBinding1(dataBindingComponent, view, i2, tag);
                case 2:
                    return internalGetViewDataBinding2(dataBindingComponent, view, i2, tag);
                case 3:
                    return internalGetViewDataBinding3(dataBindingComponent, view, i2, tag);
                case 4:
                    return internalGetViewDataBinding4(dataBindingComponent, view, i2, tag);
                case 5:
                    return internalGetViewDataBinding5(dataBindingComponent, view, i2, tag);
                case 6:
                    return internalGetViewDataBinding6(dataBindingComponent, view, i2, tag);
                case 7:
                    return internalGetViewDataBinding7(dataBindingComponent, view, i2, tag);
                case 8:
                    return internalGetViewDataBinding8(dataBindingComponent, view, i2, tag);
                case 9:
                    return internalGetViewDataBinding9(dataBindingComponent, view, i2, tag);
                case 10:
                    return internalGetViewDataBinding10(dataBindingComponent, view, i2, tag);
                case 11:
                    return internalGetViewDataBinding11(dataBindingComponent, view, i2, tag);
                case 12:
                    return internalGetViewDataBinding12(dataBindingComponent, view, i2, tag);
                case 13:
                    return internalGetViewDataBinding13(dataBindingComponent, view, i2, tag);
                default:
                    return null;
            }
        } else {
            throw new RuntimeException("view must have a tag");
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    private static void internalPopulateLayoutIdLookup0() {
        SparseIntArray sparseIntArray = INTERNAL_LAYOUT_ID_LOOKUP;
        sparseIntArray.put(2131558428, 1);
        sparseIntArray.put(2131558429, 2);
        sparseIntArray.put(2131558430, 3);
        sparseIntArray.put(2131558431, 4);
        sparseIntArray.put(2131558432, 5);
        sparseIntArray.put(2131558435, 6);
        sparseIntArray.put(2131558436, 7);
        sparseIntArray.put(2131558437, 8);
        sparseIntArray.put(2131558438, 9);
        sparseIntArray.put(2131558439, 10);
        sparseIntArray.put(2131558441, 11);
        sparseIntArray.put(2131558442, 12);
        sparseIntArray.put(2131558443, 13);
        sparseIntArray.put(2131558444, 14);
        sparseIntArray.put(2131558445, 15);
        sparseIntArray.put(2131558446, 16);
        sparseIntArray.put(2131558447, 17);
        sparseIntArray.put(2131558448, 18);
        sparseIntArray.put(2131558449, 19);
        sparseIntArray.put(2131558450, 20);
        sparseIntArray.put(2131558451, 21);
        sparseIntArray.put(2131558452, 22);
        sparseIntArray.put(2131558453, 23);
        sparseIntArray.put(2131558457, 24);
        sparseIntArray.put(2131558458, 25);
        sparseIntArray.put(2131558459, 26);
        sparseIntArray.put(2131558460, 27);
        sparseIntArray.put(2131558461, 28);
        sparseIntArray.put(2131558463, 29);
        sparseIntArray.put(2131558464, 30);
        sparseIntArray.put(2131558465, 31);
        sparseIntArray.put(2131558466, 32);
        sparseIntArray.put(2131558467, 33);
        sparseIntArray.put(2131558468, 34);
        sparseIntArray.put(2131558469, 35);
        sparseIntArray.put(2131558470, 36);
        sparseIntArray.put(2131558471, 37);
        sparseIntArray.put(2131558472, 38);
        sparseIntArray.put(2131558474, 39);
        sparseIntArray.put(2131558475, 40);
        sparseIntArray.put(2131558480, 41);
        sparseIntArray.put(2131558481, 42);
        sparseIntArray.put(2131558486, 43);
        sparseIntArray.put(2131558487, 44);
        sparseIntArray.put(2131558488, 45);
        sparseIntArray.put(2131558489, 46);
        sparseIntArray.put(2131558490, 47);
        sparseIntArray.put(2131558491, 48);
        sparseIntArray.put(2131558492, 49);
        sparseIntArray.put(2131558496, 50);
        sparseIntArray.put(2131558513, 51);
        sparseIntArray.put(2131558514, 52);
        sparseIntArray.put(2131558515, 53);
        sparseIntArray.put(2131558516, 54);
        sparseIntArray.put(2131558517, 55);
        sparseIntArray.put(2131558518, 56);
        sparseIntArray.put(2131558519, 57);
        sparseIntArray.put(2131558520, 58);
        sparseIntArray.put(2131558521, 59);
        sparseIntArray.put(2131558522, 60);
        sparseIntArray.put(2131558523, 61);
        sparseIntArray.put(2131558524, 62);
        sparseIntArray.put(2131558525, 63);
        sparseIntArray.put(2131558526, 64);
        sparseIntArray.put(2131558527, 65);
        sparseIntArray.put(2131558528, 66);
        sparseIntArray.put(2131558529, 67);
        sparseIntArray.put(2131558530, 68);
        sparseIntArray.put(2131558532, 69);
        sparseIntArray.put(2131558533, 70);
        sparseIntArray.put(2131558534, 71);
        sparseIntArray.put(2131558535, 72);
        sparseIntArray.put(2131558536, 73);
        sparseIntArray.put(2131558537, 74);
        sparseIntArray.put(2131558538, 75);
        sparseIntArray.put(2131558539, 76);
        sparseIntArray.put(2131558540, 77);
        sparseIntArray.put(2131558541, 78);
        sparseIntArray.put(2131558542, 79);
        sparseIntArray.put(2131558545, 80);
        sparseIntArray.put(2131558546, 81);
        sparseIntArray.put(2131558547, 82);
        sparseIntArray.put(2131558548, 83);
        sparseIntArray.put(2131558549, 84);
        sparseIntArray.put(2131558551, 85);
        sparseIntArray.put(2131558552, 86);
        sparseIntArray.put(2131558555, 87);
        sparseIntArray.put(2131558556, 88);
        sparseIntArray.put(2131558557, 89);
        sparseIntArray.put(2131558558, 90);
        sparseIntArray.put(2131558559, 91);
        sparseIntArray.put(2131558560, 92);
        sparseIntArray.put(2131558561, 93);
        sparseIntArray.put(2131558562, 94);
        sparseIntArray.put(2131558563, 95);
        sparseIntArray.put(2131558564, 96);
        sparseIntArray.put(2131558565, 97);
        sparseIntArray.put(2131558566, 98);
        sparseIntArray.put(2131558567, 99);
        sparseIntArray.put(2131558568, 100);
        sparseIntArray.put(2131558569, 101);
        sparseIntArray.put(2131558570, 102);
        sparseIntArray.put(2131558571, 103);
        sparseIntArray.put(2131558572, 104);
        sparseIntArray.put(2131558574, 105);
        sparseIntArray.put(2131558576, 106);
        sparseIntArray.put(2131558577, 107);
        sparseIntArray.put(2131558578, 108);
        sparseIntArray.put(2131558579, 109);
        sparseIntArray.put(2131558580, 110);
        sparseIntArray.put(2131558581, 111);
        sparseIntArray.put(2131558582, 112);
        sparseIntArray.put(2131558583, 113);
        sparseIntArray.put(2131558584, 114);
        sparseIntArray.put(2131558585, 115);
        sparseIntArray.put(2131558586, 116);
        sparseIntArray.put(2131558587, 117);
        sparseIntArray.put(2131558588, 118);
        sparseIntArray.put(2131558589, 119);
        sparseIntArray.put(2131558590, 120);
        sparseIntArray.put(2131558591, 121);
        sparseIntArray.put(2131558592, 122);
        sparseIntArray.put(2131558593, 123);
        sparseIntArray.put(2131558594, 124);
        sparseIntArray.put(2131558595, 125);
        sparseIntArray.put(2131558596, 126);
        sparseIntArray.put(2131558597, 127);
        sparseIntArray.put(2131558598, 128);
        sparseIntArray.put(2131558599, 129);
        sparseIntArray.put(2131558600, 130);
        sparseIntArray.put(2131558601, 131);
        sparseIntArray.put(2131558602, 132);
        sparseIntArray.put(2131558603, 133);
        sparseIntArray.put(2131558604, 134);
        sparseIntArray.put(2131558605, 135);
        sparseIntArray.put(2131558606, 136);
        sparseIntArray.put(2131558607, 137);
        sparseIntArray.put(2131558608, 138);
        sparseIntArray.put(2131558609, 139);
        sparseIntArray.put(2131558610, 140);
        sparseIntArray.put(2131558611, 141);
        sparseIntArray.put(2131558612, 142);
        sparseIntArray.put(2131558613, 143);
        sparseIntArray.put(2131558614, 144);
        sparseIntArray.put(2131558615, 145);
        sparseIntArray.put(2131558616, 146);
        sparseIntArray.put(2131558617, 147);
        sparseIntArray.put(2131558618, 148);
        sparseIntArray.put(2131558620, 149);
        sparseIntArray.put(2131558621, 150);
        sparseIntArray.put(2131558622, 151);
        sparseIntArray.put(2131558623, 152);
        sparseIntArray.put(2131558624, 153);
        sparseIntArray.put(2131558625, 154);
        sparseIntArray.put(2131558626, 155);
        sparseIntArray.put(2131558627, 156);
        sparseIntArray.put(2131558628, 157);
        sparseIntArray.put(2131558629, 158);
        sparseIntArray.put(2131558630, 159);
        sparseIntArray.put(2131558631, 160);
        sparseIntArray.put(2131558632, 161);
        sparseIntArray.put(2131558633, 162);
        sparseIntArray.put(2131558634, 163);
        sparseIntArray.put(2131558635, 164);
        sparseIntArray.put(2131558636, 165);
        sparseIntArray.put(2131558637, 166);
        sparseIntArray.put(2131558638, 167);
        sparseIntArray.put(2131558639, 168);
        sparseIntArray.put(2131558640, 169);
        sparseIntArray.put(2131558641, 170);
        sparseIntArray.put(2131558642, 171);
        sparseIntArray.put(2131558643, 172);
        sparseIntArray.put(2131558644, 173);
        sparseIntArray.put(2131558645, 174);
        sparseIntArray.put(2131558646, 175);
        sparseIntArray.put(2131558647, 176);
        sparseIntArray.put(2131558648, 177);
        sparseIntArray.put(2131558649, 178);
        sparseIntArray.put(2131558650, 179);
        sparseIntArray.put(2131558651, 180);
        sparseIntArray.put(2131558652, 181);
        sparseIntArray.put(2131558653, 182);
        sparseIntArray.put(2131558654, 183);
        sparseIntArray.put(2131558655, 184);
        sparseIntArray.put(2131558656, 185);
        sparseIntArray.put(2131558657, 186);
        sparseIntArray.put(2131558658, 187);
        sparseIntArray.put(2131558659, 188);
        sparseIntArray.put(2131558660, 189);
        sparseIntArray.put(2131558661, 190);
        sparseIntArray.put(2131558662, 191);
        sparseIntArray.put(2131558663, 192);
        sparseIntArray.put(2131558664, 193);
        sparseIntArray.put(2131558665, 194);
        sparseIntArray.put(2131558666, 195);
        sparseIntArray.put(2131558667, 196);
        sparseIntArray.put(2131558668, 197);
        sparseIntArray.put(2131558669, 198);
        sparseIntArray.put(2131558670, 199);
        sparseIntArray.put(2131558671, 200);
        sparseIntArray.put(2131558672, 201);
        sparseIntArray.put(2131558673, 202);
        sparseIntArray.put(2131558674, 203);
        sparseIntArray.put(2131558675, 204);
        sparseIntArray.put(2131558676, 205);
        sparseIntArray.put(2131558677, 206);
        sparseIntArray.put(2131558678, 207);
        sparseIntArray.put(2131558679, 208);
        sparseIntArray.put(2131558680, 209);
        sparseIntArray.put(2131558681, 210);
        sparseIntArray.put(2131558682, 211);
        sparseIntArray.put(2131558683, 212);
        sparseIntArray.put(2131558684, 213);
        sparseIntArray.put(2131558685, 214);
        sparseIntArray.put(2131558686, 215);
        sparseIntArray.put(2131558687, 216);
        sparseIntArray.put(2131558688, 217);
        sparseIntArray.put(2131558689, 218);
        sparseIntArray.put(2131558690, 219);
        sparseIntArray.put(2131558691, 220);
        sparseIntArray.put(2131558692, 221);
        sparseIntArray.put(2131558693, 222);
        sparseIntArray.put(2131558694, 223);
        sparseIntArray.put(2131558695, 224);
        sparseIntArray.put(2131558696, 225);
        sparseIntArray.put(2131558697, 226);
        sparseIntArray.put(2131558698, 227);
        sparseIntArray.put(2131558699, 228);
        sparseIntArray.put(2131558700, 229);
        sparseIntArray.put(2131558701, 230);
        sparseIntArray.put(2131558702, 231);
        sparseIntArray.put(2131558703, 232);
        sparseIntArray.put(2131558704, 233);
        sparseIntArray.put(2131558705, 234);
        sparseIntArray.put(2131558706, 235);
        sparseIntArray.put(2131558707, 236);
        sparseIntArray.put(2131558708, 237);
        sparseIntArray.put(2131558709, 238);
        sparseIntArray.put(2131558710, 239);
        sparseIntArray.put(2131558711, 240);
        sparseIntArray.put(2131558712, 241);
        sparseIntArray.put(2131558713, 242);
        sparseIntArray.put(2131558714, 243);
        sparseIntArray.put(2131558715, 244);
        sparseIntArray.put(2131558716, 245);
        sparseIntArray.put(2131558717, 246);
        sparseIntArray.put(2131558718, 247);
        sparseIntArray.put(2131558719, 248);
        sparseIntArray.put(2131558720, 249);
        sparseIntArray.put(2131558721, 250);
        sparseIntArray.put(2131558722, 251);
        sparseIntArray.put(2131558723, 252);
        sparseIntArray.put(2131558724, 253);
        sparseIntArray.put(2131558725, 254);
        sparseIntArray.put(2131558726, 255);
        sparseIntArray.put(2131558727, 256);
        sparseIntArray.put(2131558728, 257);
        sparseIntArray.put(2131558729, 258);
        sparseIntArray.put(2131558730, 259);
        sparseIntArray.put(2131558731, 260);
        sparseIntArray.put(2131558732, 261);
        sparseIntArray.put(2131558733, 262);
        sparseIntArray.put(2131558734, 263);
        sparseIntArray.put(2131558735, 264);
        sparseIntArray.put(2131558736, 265);
        sparseIntArray.put(2131558737, 266);
        sparseIntArray.put(2131558738, 267);
        sparseIntArray.put(2131558739, 268);
        sparseIntArray.put(2131558740, 269);
        sparseIntArray.put(2131558741, 270);
        sparseIntArray.put(2131558742, 271);
        sparseIntArray.put(2131558743, 272);
        sparseIntArray.put(2131558744, 273);
        sparseIntArray.put(2131558745, 274);
        sparseIntArray.put(2131558746, 275);
        sparseIntArray.put(2131558747, 276);
        sparseIntArray.put(2131558748, 277);
        sparseIntArray.put(2131558749, 278);
        sparseIntArray.put(2131558750, 279);
        sparseIntArray.put(2131558751, 280);
        sparseIntArray.put(2131558752, 281);
        sparseIntArray.put(2131558753, 282);
        sparseIntArray.put(2131558754, 283);
        sparseIntArray.put(2131558755, 284);
        sparseIntArray.put(2131558756, 285);
        sparseIntArray.put(2131558757, 286);
        sparseIntArray.put(2131558758, 287);
        sparseIntArray.put(2131558759, 288);
        sparseIntArray.put(2131558760, 289);
        sparseIntArray.put(2131558761, 290);
        sparseIntArray.put(2131558762, 291);
        sparseIntArray.put(2131558763, 292);
        sparseIntArray.put(2131558765, 293);
        sparseIntArray.put(2131558766, 294);
        sparseIntArray.put(2131558767, 295);
        sparseIntArray.put(2131558768, 296);
        sparseIntArray.put(2131558769, 297);
        sparseIntArray.put(2131558770, 298);
        sparseIntArray.put(2131558771, 299);
        sparseIntArray.put(2131558772, 300);
        sparseIntArray.put(2131558773, 301);
        sparseIntArray.put(2131558774, 302);
        sparseIntArray.put(2131558775, 303);
        sparseIntArray.put(2131558776, 304);
        sparseIntArray.put(2131558777, 305);
        sparseIntArray.put(2131558778, 306);
        sparseIntArray.put(2131558779, 307);
        sparseIntArray.put(2131558780, 308);
        sparseIntArray.put(2131558781, 309);
        sparseIntArray.put(2131558782, 310);
        sparseIntArray.put(2131558783, 311);
        sparseIntArray.put(2131558784, 312);
        sparseIntArray.put(2131558785, 313);
        sparseIntArray.put(2131558786, 314);
        sparseIntArray.put(2131558787, 315);
        sparseIntArray.put(2131558788, 316);
        sparseIntArray.put(2131558789, 317);
        sparseIntArray.put(2131558790, 318);
        sparseIntArray.put(2131558791, 319);
        sparseIntArray.put(2131558792, 320);
        sparseIntArray.put(2131558793, 321);
        sparseIntArray.put(2131558794, 322);
        sparseIntArray.put(2131558795, 323);
        sparseIntArray.put(2131558796, 324);
        sparseIntArray.put(2131558797, 325);
        sparseIntArray.put(2131558798, 326);
        sparseIntArray.put(2131558799, 327);
        sparseIntArray.put(2131558800, 328);
        sparseIntArray.put(2131558801, 329);
        sparseIntArray.put(2131558802, 330);
        sparseIntArray.put(2131558803, 331);
        sparseIntArray.put(2131558804, 332);
        sparseIntArray.put(2131558805, 333);
        sparseIntArray.put(2131558806, 334);
        sparseIntArray.put(2131558807, 335);
        sparseIntArray.put(2131558808, 336);
        sparseIntArray.put(2131558809, 337);
        sparseIntArray.put(2131558810, 338);
        sparseIntArray.put(2131558811, 339);
        sparseIntArray.put(2131558812, 340);
        sparseIntArray.put(2131558813, 341);
        sparseIntArray.put(2131558814, 342);
        sparseIntArray.put(2131558815, 343);
        sparseIntArray.put(2131558816, 344);
        sparseIntArray.put(2131558817, 345);
        sparseIntArray.put(2131558818, 346);
        sparseIntArray.put(2131558819, 347);
        sparseIntArray.put(2131558820, 348);
        sparseIntArray.put(2131558821, 349);
        sparseIntArray.put(2131558822, 350);
        sparseIntArray.put(2131558823, 351);
        sparseIntArray.put(2131558824, 352);
        sparseIntArray.put(2131558826, 353);
        sparseIntArray.put(2131558827, 354);
        sparseIntArray.put(2131558828, 355);
        sparseIntArray.put(2131558829, 356);
        sparseIntArray.put(2131558830, 357);
        sparseIntArray.put(2131558831, 358);
        sparseIntArray.put(2131558832, 359);
        sparseIntArray.put(2131558833, 360);
        sparseIntArray.put(2131558834, 361);
        sparseIntArray.put(2131558835, 362);
        sparseIntArray.put(2131558836, 363);
        sparseIntArray.put(2131558837, 364);
        sparseIntArray.put(2131558838, 365);
        sparseIntArray.put(2131558839, 366);
        sparseIntArray.put(2131558840, 367);
        sparseIntArray.put(2131558841, 368);
        sparseIntArray.put(2131558842, 369);
        sparseIntArray.put(2131558843, 370);
        sparseIntArray.put(2131558844, 371);
        sparseIntArray.put(2131558845, 372);
        sparseIntArray.put(2131558846, 373);
        sparseIntArray.put(2131558847, 374);
        sparseIntArray.put(2131558848, 375);
        sparseIntArray.put(2131558849, 376);
        sparseIntArray.put(2131558850, 377);
        sparseIntArray.put(2131558851, 378);
        sparseIntArray.put(2131558852, 379);
        sparseIntArray.put(2131558853, 380);
        sparseIntArray.put(2131558854, 381);
        sparseIntArray.put(2131558855, 382);
        sparseIntArray.put(2131558856, 383);
        sparseIntArray.put(2131558857, 384);
        sparseIntArray.put(2131558858, 385);
        sparseIntArray.put(2131558859, 386);
        sparseIntArray.put(2131558860, 387);
        sparseIntArray.put(2131558861, 388);
        sparseIntArray.put(2131558862, 389);
        sparseIntArray.put(2131558863, 390);
        sparseIntArray.put(2131558864, 391);
        sparseIntArray.put(2131558865, 392);
        sparseIntArray.put(2131558866, 393);
        sparseIntArray.put(2131558867, 394);
        sparseIntArray.put(2131558868, 395);
        sparseIntArray.put(2131558869, 396);
        sparseIntArray.put(2131558870, 397);
        sparseIntArray.put(2131558871, 398);
        sparseIntArray.put(2131558872, 399);
        sparseIntArray.put(2131558873, 400);
        sparseIntArray.put(2131558874, 401);
        sparseIntArray.put(2131558875, 402);
        sparseIntArray.put(2131558876, 403);
        sparseIntArray.put(2131558877, 404);
        sparseIntArray.put(2131558878, 405);
        sparseIntArray.put(2131558879, 406);
        sparseIntArray.put(2131558880, 407);
        sparseIntArray.put(2131558881, 408);
        sparseIntArray.put(2131558882, 409);
        sparseIntArray.put(2131558883, 410);
        sparseIntArray.put(2131558884, 411);
        sparseIntArray.put(2131558885, 412);
        sparseIntArray.put(2131558886, 413);
        sparseIntArray.put(2131558887, 414);
        sparseIntArray.put(2131558888, 415);
        sparseIntArray.put(2131558889, 416);
        sparseIntArray.put(2131558890, 417);
        sparseIntArray.put(2131558891, 418);
        sparseIntArray.put(2131558892, 419);
        sparseIntArray.put(2131558893, 420);
        sparseIntArray.put(2131558894, 421);
        sparseIntArray.put(2131558895, 422);
        sparseIntArray.put(2131558896, 423);
        sparseIntArray.put(2131558897, 424);
        sparseIntArray.put(2131558898, 425);
        sparseIntArray.put(2131558899, 426);
        sparseIntArray.put(2131558900, 427);
        sparseIntArray.put(2131558901, 428);
        sparseIntArray.put(2131558902, 429);
        sparseIntArray.put(2131558903, 430);
        sparseIntArray.put(2131558904, 431);
        sparseIntArray.put(2131558905, 432);
        sparseIntArray.put(2131558906, 433);
        sparseIntArray.put(2131558907, 434);
        sparseIntArray.put(2131558908, 435);
        sparseIntArray.put(2131558909, 436);
        sparseIntArray.put(2131558910, 437);
        sparseIntArray.put(2131558911, 438);
        sparseIntArray.put(2131558912, 439);
        sparseIntArray.put(2131558913, 440);
        sparseIntArray.put(2131558914, 441);
        sparseIntArray.put(2131558915, 442);
        sparseIntArray.put(2131558916, 443);
        sparseIntArray.put(2131558917, 444);
        sparseIntArray.put(2131558918, 445);
        sparseIntArray.put(2131558919, 446);
        sparseIntArray.put(2131558920, 447);
        sparseIntArray.put(2131558921, 448);
        sparseIntArray.put(2131558922, 449);
        sparseIntArray.put(2131558923, 450);
        sparseIntArray.put(2131558924, 451);
        sparseIntArray.put(2131558925, 452);
        sparseIntArray.put(2131558926, 453);
        sparseIntArray.put(2131558927, 454);
        sparseIntArray.put(2131558928, 455);
        sparseIntArray.put(2131558929, 456);
        sparseIntArray.put(2131558930, 457);
        sparseIntArray.put(2131558931, 458);
        sparseIntArray.put(2131558932, 459);
        sparseIntArray.put(2131558933, 460);
        sparseIntArray.put(2131558934, 461);
        sparseIntArray.put(2131558935, 462);
        sparseIntArray.put(2131558936, 463);
        sparseIntArray.put(2131558937, 464);
        sparseIntArray.put(2131558939, 465);
        sparseIntArray.put(2131558940, 466);
        sparseIntArray.put(2131558941, 467);
        sparseIntArray.put(2131558942, 468);
        sparseIntArray.put(2131558943, 469);
        sparseIntArray.put(2131558944, 470);
        sparseIntArray.put(2131558945, 471);
        sparseIntArray.put(2131558946, 472);
        sparseIntArray.put(2131558947, 473);
        sparseIntArray.put(2131558948, 474);
        sparseIntArray.put(2131558949, 475);
        sparseIntArray.put(2131558950, 476);
        sparseIntArray.put(2131558952, 477);
        sparseIntArray.put(2131558953, 478);
        sparseIntArray.put(2131558954, 479);
        sparseIntArray.put(2131558955, 480);
        sparseIntArray.put(2131558956, 481);
        sparseIntArray.put(2131558957, 482);
        sparseIntArray.put(2131558958, 483);
        sparseIntArray.put(2131558959, 484);
        sparseIntArray.put(2131558960, 485);
        sparseIntArray.put(2131558961, 486);
        sparseIntArray.put(2131558962, 487);
        sparseIntArray.put(2131558963, 488);
        sparseIntArray.put(2131558964, 489);
        sparseIntArray.put(2131558965, 490);
        sparseIntArray.put(2131558966, 491);
        sparseIntArray.put(2131558967, 492);
        sparseIntArray.put(2131558968, 493);
        sparseIntArray.put(2131558969, 494);
        sparseIntArray.put(2131558970, 495);
        sparseIntArray.put(2131558971, 496);
        sparseIntArray.put(2131558972, 497);
        sparseIntArray.put(2131558973, 498);
        sparseIntArray.put(2131558974, 499);
        sparseIntArray.put(2131558975, 500);
    }

    private static void internalPopulateLayoutIdLookup1() {
        SparseIntArray sparseIntArray = INTERNAL_LAYOUT_ID_LOOKUP;
        sparseIntArray.put(2131558976, 501);
        sparseIntArray.put(2131558977, 502);
        sparseIntArray.put(2131558978, 503);
        sparseIntArray.put(2131558979, 504);
        sparseIntArray.put(2131558980, 505);
        sparseIntArray.put(2131558981, 506);
        sparseIntArray.put(2131558982, 507);
        sparseIntArray.put(2131558983, 508);
        sparseIntArray.put(2131558984, 509);
        sparseIntArray.put(2131558985, 510);
        sparseIntArray.put(2131558986, 511);
        sparseIntArray.put(2131558987, 512);
        sparseIntArray.put(2131558988, 513);
        sparseIntArray.put(2131558989, 514);
        sparseIntArray.put(2131558990, 515);
        sparseIntArray.put(2131558991, 516);
        sparseIntArray.put(2131558992, 517);
        sparseIntArray.put(2131558993, 518);
        sparseIntArray.put(2131558994, 519);
        sparseIntArray.put(2131558995, 520);
        sparseIntArray.put(2131558996, 521);
        sparseIntArray.put(2131558997, 522);
        sparseIntArray.put(2131558998, 523);
        sparseIntArray.put(2131558999, 524);
        sparseIntArray.put(2131559002, 525);
        sparseIntArray.put(2131559003, 526);
        sparseIntArray.put(2131559004, 527);
        sparseIntArray.put(2131559005, 528);
        sparseIntArray.put(2131559006, 529);
        sparseIntArray.put(2131559010, 530);
        sparseIntArray.put(2131559015, 531);
        sparseIntArray.put(2131559016, 532);
        sparseIntArray.put(2131559017, 533);
        sparseIntArray.put(2131559018, 534);
        sparseIntArray.put(2131559019, 535);
        sparseIntArray.put(2131559020, 536);
        sparseIntArray.put(2131559021, 537);
        sparseIntArray.put(2131559022, 538);
        sparseIntArray.put(2131559023, 539);
        sparseIntArray.put(2131559024, 540);
        sparseIntArray.put(2131559025, 541);
        sparseIntArray.put(2131559026, 542);
        sparseIntArray.put(2131559027, 543);
        sparseIntArray.put(2131559028, 544);
        sparseIntArray.put(2131559059, 545);
        sparseIntArray.put(2131559060, 546);
        sparseIntArray.put(2131559061, 547);
        sparseIntArray.put(2131559062, 548);
        sparseIntArray.put(2131559063, 549);
        sparseIntArray.put(2131559064, 550);
        sparseIntArray.put(2131559065, 551);
        sparseIntArray.put(2131559085, 552);
        sparseIntArray.put(2131559086, 553);
        sparseIntArray.put(2131559087, 554);
        sparseIntArray.put(2131559088, 555);
        sparseIntArray.put(2131559094, 556);
        sparseIntArray.put(2131559095, 557);
        sparseIntArray.put(2131559096, 558);
        sparseIntArray.put(2131559097, 559);
        sparseIntArray.put(2131559114, 560);
        sparseIntArray.put(2131559115, 561);
        sparseIntArray.put(2131559116, 562);
        sparseIntArray.put(2131559117, 563);
        sparseIntArray.put(2131559118, 564);
        sparseIntArray.put(2131559119, 565);
        sparseIntArray.put(2131559120, 566);
        sparseIntArray.put(2131559121, 567);
        sparseIntArray.put(2131559122, 568);
        sparseIntArray.put(2131559123, 569);
        sparseIntArray.put(2131559125, 570);
        sparseIntArray.put(2131559126, 571);
        sparseIntArray.put(2131559128, 572);
        sparseIntArray.put(2131559129, 573);
        sparseIntArray.put(2131559130, 574);
        sparseIntArray.put(2131559131, 575);
        sparseIntArray.put(2131559132, 576);
        sparseIntArray.put(2131559133, 577);
        sparseIntArray.put(2131559134, 578);
        sparseIntArray.put(2131559135, 579);
        sparseIntArray.put(2131559136, 580);
        sparseIntArray.put(2131559137, 581);
        sparseIntArray.put(2131559138, 582);
        sparseIntArray.put(2131559139, 583);
        sparseIntArray.put(2131559140, 584);
        sparseIntArray.put(2131559141, 585);
        sparseIntArray.put(2131559145, 586);
        sparseIntArray.put(2131559146, 587);
        sparseIntArray.put(2131559147, 588);
        sparseIntArray.put(2131559148, 589);
        sparseIntArray.put(2131559149, 590);
        sparseIntArray.put(2131559151, 591);
        sparseIntArray.put(2131559152, 592);
        sparseIntArray.put(2131559153, 593);
        sparseIntArray.put(2131559154, 594);
        sparseIntArray.put(2131559155, 595);
        sparseIntArray.put(2131559156, 596);
        sparseIntArray.put(2131559157, 597);
        sparseIntArray.put(2131559158, 598);
        sparseIntArray.put(2131559159, 599);
        sparseIntArray.put(2131559160, 600);
        sparseIntArray.put(2131559161, 601);
        sparseIntArray.put(2131559162, 602);
        sparseIntArray.put(2131559163, 603);
        sparseIntArray.put(2131559164, 604);
        sparseIntArray.put(2131559165, 605);
        sparseIntArray.put(2131559166, 606);
        sparseIntArray.put(2131559167, 607);
        sparseIntArray.put(2131559168, 608);
        sparseIntArray.put(2131559169, 609);
        sparseIntArray.put(2131559170, 610);
        sparseIntArray.put(2131559171, 611);
        sparseIntArray.put(2131559172, 612);
        sparseIntArray.put(2131559173, 613);
        sparseIntArray.put(2131559174, 614);
        sparseIntArray.put(2131559175, 615);
        sparseIntArray.put(2131559176, 616);
        sparseIntArray.put(2131559177, 617);
        sparseIntArray.put(2131559178, 618);
        sparseIntArray.put(2131559179, 619);
        sparseIntArray.put(2131559180, 620);
        sparseIntArray.put(2131559181, 621);
        sparseIntArray.put(2131559182, 622);
        sparseIntArray.put(2131559184, 623);
        sparseIntArray.put(2131559185, 624);
        sparseIntArray.put(2131559186, 625);
        sparseIntArray.put(2131559196, 626);
        sparseIntArray.put(2131559203, 627);
        sparseIntArray.put(2131559204, 628);
        sparseIntArray.put(2131559206, 629);
        sparseIntArray.put(2131559207, 630);
        sparseIntArray.put(2131559208, 631);
        sparseIntArray.put(2131559209, 632);
        sparseIntArray.put(2131559210, 633);
        sparseIntArray.put(2131559211, 634);
        sparseIntArray.put(2131559212, 635);
        sparseIntArray.put(2131559213, 636);
        sparseIntArray.put(2131559290, 637);
        sparseIntArray.put(2131559291, 638);
        sparseIntArray.put(2131559292, 639);
        sparseIntArray.put(2131559293, 640);
        sparseIntArray.put(2131559294, 641);
        sparseIntArray.put(2131559295, 642);
        sparseIntArray.put(2131559296, 643);
        sparseIntArray.put(2131559298, 644);
        sparseIntArray.put(2131559299, 645);
        sparseIntArray.put(2131559300, 646);
        sparseIntArray.put(2131559301, 647);
        sparseIntArray.put(2131559302, 648);
        sparseIntArray.put(2131559303, 649);
        sparseIntArray.put(2131559304, 650);
        sparseIntArray.put(2131559305, 651);
        sparseIntArray.put(2131559309, 652);
        sparseIntArray.put(2131559310, 653);
        sparseIntArray.put(2131559312, 654);
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(323);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "actionButtonBackground");
            sparseArray.put(2, "actionButtonTextColor");
            sparseArray.put(3, "actionText");
            sparseArray.put(4, "actionTextColor");
            sparseArray.put(5, "actionTextUseProcess");
            sparseArray.put(6, "actionTitle");
            sparseArray.put(7, "actionType");
            sparseArray.put(8, "album");
            sparseArray.put(9, "albumApkNum");
            sparseArray.put(10, "albumFavNum");
            sparseArray.put(11, "albumFavState");
            sparseArray.put(12, "albumId");
            sparseArray.put(13, "albumInfo");
            sparseArray.put(14, "albumIntro");
            sparseArray.put(15, "albumItem");
            sparseArray.put(16, "albumItems");
            sparseArray.put(17, "albumLikeNum");
            sparseArray.put(18, "albumLikeState");
            sparseArray.put(19, "albumMaxWords");
            sparseArray.put(20, "albumRecommend");
            sparseArray.put(21, "albumTitle");
            sparseArray.put(22, "albumUserFollow");
            sparseArray.put(23, "albumUserName");
            sparseArray.put(24, "apk");
            sparseArray.put(25, "apkName");
            sparseArray.put(26, "apkSizePainFlags");
            sparseArray.put(27, "app");
            sparseArray.put(28, "appCat");
            sparseArray.put(29, "appCategory");
            sparseArray.put(30, "appName");
            sparseArray.put(31, "appSort");
            sparseArray.put(32, "appSubtitle");
            sparseArray.put(33, "apps");
            sparseArray.put(34, "articleFeedTemplate");
            sparseArray.put(35, "articleItemTemplate");
            sparseArray.put(36, "articleNewsTemplate");
            sparseArray.put(37, "articleTemplate");
            sparseArray.put(38, "askFeedType");
            sparseArray.put(39, "avatar");
            sparseArray.put(40, "avatar1");
            sparseArray.put(41, "avatar2");
            sparseArray.put(42, "avatar3");
            sparseArray.put(43, "buyStatus");
            sparseArray.put(44, "card");
            sparseArray.put(45, "card1");
            sparseArray.put(46, "card2");
            sparseArray.put(47, "changeLogSubtitle");
            sparseArray.put(48, "checked");
            sparseArray.put(49, "circleTransform");
            sparseArray.put(50, "click");
            sparseArray.put(51, "collectionFollowNumber");
            sparseArray.put(52, "commentCount");
            sparseArray.put(53, "commentNum");
            sparseArray.put(54, "contact");
            sparseArray.put(55, "content");
            sparseArray.put(56, "contentPic");
            sparseArray.put(57, "contentTitle");
            sparseArray.put(58, "count");
            sparseArray.put(59, "coupon");
            sparseArray.put(60, "cover");
            sparseArray.put(61, "coverUrl");
            sparseArray.put(62, "currentLength");
            sparseArray.put(63, "dateAndReply");
            sparseArray.put(64, "datelineVisible");
            sparseArray.put(65, "dealType");
            sparseArray.put(66, "dealTypeText");
            sparseArray.put(67, "description");
            sparseArray.put(68, "developerAvatar");
            sparseArray.put(69, "developerCard");
            sparseArray.put(70, "developerName");
            sparseArray.put(71, "developerTitle");
            sparseArray.put(72, "developerUserInfo");
            sparseArray.put(73, "deviceTitle");
            sparseArray.put(74, "dialogTitle");
            sparseArray.put(75, "downloadCount");
            sparseArray.put(76, "downloadIconPlaceHolder");
            sparseArray.put(77, "downloadSize");
            sparseArray.put(78, "dyhArticle");
            sparseArray.put(79, "dyhAuthor");
            sparseArray.put(80, "dyhDescription");
            sparseArray.put(81, "dyhFollowNum");
            sparseArray.put(82, "dyhIncludInfo");
            sparseArray.put(83, "dyhListType");
            sparseArray.put(84, "dyhLogo");
            sparseArray.put(85, "dyhModel");
            sparseArray.put(86, "dyhTitle");
            sparseArray.put(87, "dyhUnreadTitle");
            sparseArray.put(88, "editLevel");
            sparseArray.put(89, "editing");
            sparseArray.put(90, "emptyImageRes");
            sparseArray.put(91, "emptyText");
            sparseArray.put(92, "emptyViewVisibility");
            sparseArray.put(93, "entity");
            sparseArray.put(94, "entity1");
            sparseArray.put(95, "entity2");
            sparseArray.put(96, "entityTemplate");
            sparseArray.put(97, "entityTypeName");
            sparseArray.put(98, "error");
            sparseArray.put(99, "errorMessage");
            sparseArray.put(100, "extendTitle");
            sparseArray.put(101, "extraPic");
            sparseArray.put(102, "fans");
            sparseArray.put(103, "favor");
            sparseArray.put(104, "feed");
            sparseArray.put(105, "feed1");
            sparseArray.put(106, "feed2");
            sparseArray.put(107, "feed3");
            sparseArray.put(108, "feedFeedType");
            sparseArray.put(109, "feedGoods");
            sparseArray.put(110, "feedSort");
            sparseArray.put(111, "file");
            sparseArray.put(112, "filterType");
            sparseArray.put(113, "firstArticle");
            sparseArray.put(114, "firstGift");
            sparseArray.put(115, "foldText");
            sparseArray.put(116, "follow");
            sparseArray.put(117, "followCount");
            sparseArray.put(118, "followDeveloper");
            sparseArray.put(119, "followDyhLoading");
            sparseArray.put(120, "followList");
            sparseArray.put(121, "followNum");
            sparseArray.put(122, "followState");
            sparseArray.put(123, "followText");
            sparseArray.put(124, "followedDyhHeader");
            sparseArray.put(125, "fromAvatar");
            sparseArray.put(126, "fromInfo");
            sparseArray.put(127, "fromTitle");
            sparseArray.put(128, "gameCat");
            sparseArray.put(129, "gameSort");
            sparseArray.put(130, "gifImage");
            sparseArray.put(131, "gift");
            sparseArray.put(132, "giftCount");
            sparseArray.put(133, "goodsItemLogo");
            sparseArray.put(134, "goodsItemTitle");
            sparseArray.put(135, "goodsList");
            sparseArray.put(136, "goodsListCover");
            sparseArray.put(137, "goodsListId");
            sparseArray.put(138, "goodsListInfo");
            sparseArray.put(139, "goodsListItem");
            sparseArray.put(140, "goodsListItemNote");
            sparseArray.put(141, "goodsListMessage");
            sparseArray.put(142, "goodsListTitle");
            sparseArray.put(143, "goodsShowMessage");
            sparseArray.put(144, "goodsShowTitle");
            sparseArray.put(145, "hasGift");
            sparseArray.put(146, "hasPermission");
            sparseArray.put(147, "holder");
            sparseArray.put(148, "holderItem");
            sparseArray.put(149, "icon");
            sparseArray.put(150, "icon0");
            sparseArray.put(151, "icon1");
            sparseArray.put(152, "icon2");
            sparseArray.put(153, "icon3");
            sparseArray.put(154, "icon5");
            sparseArray.put(155, "ignoreTagShow");
            sparseArray.put(156, "image");
            sparseArray.put(157, "imageCard");
            sparseArray.put(158, "imageUrl");
            sparseArray.put(159, "img");
            sparseArray.put(160, "imgUrl");
            sparseArray.put(161, "inLikeList");
            sparseArray.put(162, "introduce");
            sparseArray.put(163, "introduceMaxWords");
            sparseArray.put(164, "isBlackList");
            sparseArray.put(165, "isCheck");
            sparseArray.put(166, "isDyhEditor");
            sparseArray.put(167, "isDyhFollowList");
            sparseArray.put(168, "isFollowDyh");
            sparseArray.put(169, "isGift");
            sparseArray.put(170, "isInForward");
            sparseArray.put(171, "isLoading");
            sparseArray.put(172, "isMyAlbum");
            sparseArray.put(173, "isShowActionView");
            sparseArray.put(174, "isShowFirstIcon");
            sparseArray.put(175, "isShowSecondIcon");
            sparseArray.put(176, "itemNote");
            sparseArray.put(177, "key");
            sparseArray.put(178, "keyBoardShow");
            sparseArray.put(179, "language");
            sparseArray.put(180, "lastUpdateFormat");
            sparseArray.put(181, "lastUpdateTime");
            sparseArray.put(182, "level");
            sparseArray.put(183, "linkCard");
            sparseArray.put(184, "listType");
            sparseArray.put(185, "live");
            sparseArray.put(186, "loadListener");
            sparseArray.put(187, "loading");
            sparseArray.put(188, "locationText");
            sparseArray.put(189, "loginTime");
            sparseArray.put(190, "logo");
            sparseArray.put(191, "logoList");
            sparseArray.put(192, "logoUrl");
            sparseArray.put(193, "logos");
            sparseArray.put(194, "longClick");
            sparseArray.put(195, "maxArticleWords");
            sparseArray.put(196, "me");
            sparseArray.put(197, "message");
            sparseArray.put(198, "model");
            sparseArray.put(199, "model1");
            sparseArray.put(200, "model2");
            sparseArray.put(201, "model3");
            sparseArray.put(202, "myAlbum");
            sparseArray.put(203, "myScore");
            sparseArray.put(204, "myScoreText");
            sparseArray.put(205, "name");
            sparseArray.put(206, "needXposedFramework");
            sparseArray.put(207, "newBuildEntityTemplate");
            sparseArray.put(208, "note");
            sparseArray.put(209, "notification");
            sparseArray.put(210, "nullApkId");
            sparseArray.put(211, "onBitmapTransform");
            sparseArray.put(212, "onClick");
            sparseArray.put(213, "onImageLoad");
            sparseArray.put(214, "option1");
            sparseArray.put(215, "option2");
            sparseArray.put(216, "packageName");
            sparseArray.put(217, "path");
            sparseArray.put(218, "permission");
            sparseArray.put(219, "permissionCount");
            sparseArray.put(220, "permissionString");
            sparseArray.put(221, "pic");
            sparseArray.put(222, "pickApp");
            sparseArray.put(223, "pickAppName");
            sparseArray.put(224, "pickAppNote");
            sparseArray.put(225, "placeHolder");
            sparseArray.put(226, "posting");
            sparseArray.put(227, "productGoodsLogo");
            sparseArray.put(228, "productGoodsTitle");
            sparseArray.put(229, "ratingScore");
            sparseArray.put(230, "recyclerViewVisibility");
            sparseArray.put(231, "relatedAlbumCard");
            sparseArray.put(232, "relatedAppCard");
            sparseArray.put(233, "replyNum");
            sparseArray.put(234, "score");
            sparseArray.put(235, "scoreNum");
            sparseArray.put(236, "scores");
            sparseArray.put(237, "secondGift");
            sparseArray.put(238, "secondHandChangeSort");
            sparseArray.put(239, "secondHandFilterInBuy");
            sparseArray.put(240, "secondHandOther");
            sparseArray.put(241, "secondHandSort");
            sparseArray.put(242, "selected");
            sparseArray.put(243, "serviceApp");
            sparseArray.put(244, "shortTitle");
            sparseArray.put(245, "showAction");
            sparseArray.put(246, "showChangeLogAll");
            sparseArray.put(247, "showContent");
            sparseArray.put(248, "showContentView");
            sparseArray.put(249, "showDeveloper");
            sparseArray.put(250, "showError");
            sparseArray.put(251, "showFromView");
            sparseArray.put(252, "showImapick");
            sparseArray.put(253, "showMiniHeader");
            sparseArray.put(254, "showNews");
            sparseArray.put(255, "showPic");
            sparseArray.put(256, "showPostView");
            sparseArray.put(257, "showRedPoint");
            sparseArray.put(258, "showSpamInfo");
            sparseArray.put(259, "showSpeed");
            sparseArray.put(260, "showSubTile");
            sparseArray.put(261, "showTime");
            sparseArray.put(262, "showVersion");
            sparseArray.put(263, "shrinkChangeLog");
            sparseArray.put(264, "singleImg");
            sparseArray.put(265, "size");
            sparseArray.put(266, "sourceMsg");
            sparseArray.put(267, "sourceName");
            sparseArray.put(268, "sourcePic");
            sparseArray.put(269, "sourceTitle");
            sparseArray.put(270, "sourceUrl");
            sparseArray.put(271, "speed");
            sparseArray.put(272, "subTitle");
            sparseArray.put(273, "subtitle");
            sparseArray.put(274, "text");
            sparseArray.put(275, "textColor");
            sparseArray.put(276, "themeItem");
            sparseArray.put(277, "time");
            sparseArray.put(278, "timeDescription");
            sparseArray.put(279, "title");
            sparseArray.put(280, "titleText");
            sparseArray.put(281, "titles");
            sparseArray.put(282, "toAvatar");
            sparseArray.put(283, "toTitle");
            sparseArray.put(284, "toolbarTitle");
            sparseArray.put(285, "topIds");
            sparseArray.put(286, "totalLength");
            sparseArray.put(287, "transform");
            sparseArray.put(288, "transformer");
            sparseArray.put(289, "uiConfig");
            sparseArray.put(290, "uid");
            sparseArray.put(291, "updateTime");
            sparseArray.put(292, "url");
            sparseArray.put(293, "userActionInfo");
            sparseArray.put(294, "userAvatar");
            sparseArray.put(295, "userHistory");
            sparseArray.put(296, "userInfo");
            sparseArray.put(297, "userInfoText");
            sparseArray.put(298, "userName");
            sparseArray.put(299, "userProfile");
            sparseArray.put(300, "userVerifyStatusIcon");
            sparseArray.put(301, "verifyLabel");
            sparseArray.put(302, "verifyStatusIcon");
            sparseArray.put(303, "versionApp");
            sparseArray.put(304, "versionCode");
            sparseArray.put(305, "versionInfo");
            sparseArray.put(306, "versionName");
            sparseArray.put(307, "vh");
            sparseArray.put(308, "viewHolder");
            sparseArray.put(309, "viewModel");
            sparseArray.put(310, "voteNumString");
            sparseArray.put(311, "votePercent1");
            sparseArray.put(312, "votePercent2");
            sparseArray.put(313, "votePercent3");
            sparseArray.put(314, "votePercent4");
            sparseArray.put(315, "votePercent5");
            sparseArray.put(316, "votenum");
            sparseArray.put(317, "votenum1");
            sparseArray.put(318, "votenum2");
            sparseArray.put(319, "votenum3");
            sparseArray.put(320, "votenum4");
            sparseArray.put(321, "votenum5");
            sparseArray.put(322, "wishState");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys = new HashMap<>(654);

        private InnerLayoutIdLookup() {
        }

        static {
            internalPopulateLayoutIdLookup0();
            internalPopulateLayoutIdLookup1();
        }

        private static void internalPopulateLayoutIdLookup0() {
            HashMap<String, Integer> hashMap = sKeys;
            hashMap.put("layout/about_0", 2131558428);
            hashMap.put("layout/action_item_app_manager_view_0", 2131558429);
            hashMap.put("layout/action_item_badge_view_0", 2131558430);
            hashMap.put("layout/action_item_post_0", 2131558431);
            hashMap.put("layout/activity_album_detailbeta_0", 2131558432);
            hashMap.put("layout/activity_wallpaper_0", 2131558435);
            hashMap.put("layout/activity_wallpaper_beta_0", 2131558436);
            hashMap.put("layout/add_goods_item_dialog_0", 2131558437);
            hashMap.put("layout/add_to_album_edit_0", 2131558438);
            hashMap.put("layout/album_action_bar_0", 2131558439);
            hashMap.put("layout/album_action_view_0", 2131558441);
            hashMap.put("layout/album_base_info_0", 2131558442);
            hashMap.put("layout/album_comment_bar_0", 2131558443);
            hashMap.put("layout/album_detail_0", 2131558444);
            hashMap.put("layout/album_detail_v8_v2_0", 2131558445);
            hashMap.put("layout/album_detailt_view_0", 2131558446);
            hashMap.put("layout/album_header_view_v2_0", 2131558447);
            hashMap.put("layout/album_item_base_info_0", 2131558448);
            hashMap.put("layout/album_list_item_card_nonuple_0", 2131558449);
            hashMap.put("layout/album_list_item_card_nonuple_item_0", 2131558450);
            hashMap.put("layout/album_test_view_0", 2131558451);
            hashMap.put("layout/album_user_info_0", 2131558452);
            hashMap.put("layout/album_v8_detail_0", 2131558453);
            hashMap.put("layout/alpha_toolbar_0", 2131558457);
            hashMap.put("layout/app_detail_0", 2131558458);
            hashMap.put("layout/app_extension_bar_v3_0", 2131558459);
            hashMap.put("layout/app_extension_item_0", 2131558460);
            hashMap.put("layout/app_extension_item_post_0", 2131558461);
            hashMap.put("layout/app_main_model_select_0", 2131558463);
            hashMap.put("layout/app_node_community_header_0", 2131558464);
            hashMap.put("layout/app_node_header_0", 2131558465);
            hashMap.put("layout/app_node_toolbar_content_0", 2131558466);
            hashMap.put("layout/app_view_0", 2131558467);
            hashMap.put("layout/app_view_base_info_0", 2131558468);
            hashMap.put("layout/app_view_recycler_0", 2131558469);
            hashMap.put("layout/app_view_v8_0", 2131558470);
            hashMap.put("layout/article_detail_image_part_0", 2131558471);
            hashMap.put("layout/article_detail_text_part_0", 2131558472);
            hashMap.put("layout/base_chatting_0", 2131558474);
            hashMap.put("layout/base_new_chatting_0", 2131558475);
            hashMap.put("layout/center_v9_social_dialog_0", 2131558480);
            hashMap.put("layout/collection_select_0", 2131558481);
            hashMap.put("layout/comment_bar_0", 2131558486);
            hashMap.put("layout/cool_browser_0", 2131558487);
            hashMap.put("layout/cool_pic_full_screen_0", 2131558488);
            hashMap.put("layout/cool_pic_img_layout_0", 2131558489);
            hashMap.put("layout/create_collect_list_0", 2131558490);
            hashMap.put("layout/create_fun_things_0", 2131558491);
            hashMap.put("layout/create_goods_0", 2131558492);
            hashMap.put("layout/custom_theme_0", 2131558496);
            hashMap.put("layout/dialog_add_block_word_0", 2131558513);
            hashMap.put("layout/dialog_add_to_goods_list_0", 2131558514);
            hashMap.put("layout/dialog_album_create_0", 2131558515);
            hashMap.put("layout/dialog_album_mobileapp_note_0", 2131558516);
            hashMap.put("layout/dialog_albumitem_note_0", 2131558517);
            hashMap.put("layout/dialog_albumitem_px_0", 2131558518);
            hashMap.put("layout/dialog_app_rating_0", 2131558519);
            hashMap.put("layout/dialog_backup_create_0", 2131558520);
            hashMap.put("layout/dialog_block_node_0", 2131558521);
            hashMap.put("layout/dialog_city_picker_0", 2131558522);
            hashMap.put("layout/dialog_complete_nav_0", 2131558523);
            hashMap.put("layout/dialog_date_picker_0", 2131558524);
            hashMap.put("layout/dialog_edit_0", 2131558525);
            hashMap.put("layout/dialog_edit_submit_0", 2131558526);
            hashMap.put("layout/dialog_gender_picker_0", 2131558527);
            hashMap.put("layout/dialog_goods_list_edit_0", 2131558528);
            hashMap.put("layout/dialog_item_text_view_0", 2131558529);
            hashMap.put("layout/dialog_list_item_view_0", 2131558530);
            hashMap.put("layout/dialog_message_card_0", 2131558532);
            hashMap.put("layout/dialog_prograss_view_0", 2131558533);
            hashMap.put("layout/dialog_second_hand_agreement_0", 2131558534);
            hashMap.put("layout/dialog_second_hand_edit_0", 2131558535);
            hashMap.put("layout/dialog_second_hand_price_0", 2131558536);
            hashMap.put("layout/dialog_select_item_0", 2131558537);
            hashMap.put("layout/dialog_seletor_container_0", 2131558538);
            hashMap.put("layout/dialog_share_0", 2131558539);
            hashMap.put("layout/dialog_time_picker_0", 2131558540);
            hashMap.put("layout/discovery_0", 2131558541);
            hashMap.put("layout/discovery_submit_0", 2131558542);
            hashMap.put("layout/dyh_header_view_0", 2131558545);
            hashMap.put("layout/dyh_includ_0", 2131558546);
            hashMap.put("layout/edit_user_view_0", 2131558547);
            hashMap.put("layout/emotion_panel_0", 2131558548);
            hashMap.put("layout/emotion_panel_bottom_text_0", 2131558549);
            hashMap.put("layout/fab_0", 2131558551);
            hashMap.put("layout/feed_action_bar_0", 2131558552);
            hashMap.put("layout/feed_answer_view_part_0", 2131558555);
            hashMap.put("layout/feed_bind_goods_main_0", 2131558556);
            hashMap.put("layout/feed_block_items_0", 2131558557);
            hashMap.put("layout/feed_comment_bar_0", 2131558558);
            hashMap.put("layout/feed_comment_count_view_part_0", 2131558559);
            hashMap.put("layout/feed_entrance_items_0", 2131558560);
            hashMap.put("layout/feed_entrance_long_items_0", 2131558561);
            hashMap.put("layout/feed_entrance_v8_0", 2131558562);
            hashMap.put("layout/feed_reply_detail_0", 2131558563);
            hashMap.put("layout/feed_reply_detail_header_0", 2131558564);
            hashMap.put("layout/feed_top_0", 2131558565);
            hashMap.put("layout/feed_warning_0", 2131558566);
            hashMap.put("layout/fetch_gift_0", 2131558567);
            hashMap.put("layout/fixed_tablayout_0", 2131558568);
            hashMap.put("layout/forward_preview_0", 2131558569);
            hashMap.put("layout/goods_coupon_search_0", 2131558570);
            hashMap.put("layout/goods_detail_0", 2131558571);
            hashMap.put("layout/goods_search_0", 2131558572);
            hashMap.put("layout/home_0", 2131558574);
            hashMap.put("layout/item_account_tips_0", 2131558576);
            hashMap.put("layout/item_action_sheet_dialog_0", 2131558577);
            hashMap.put("layout/item_add_to_album_0", 2131558578);
            hashMap.put("layout/item_add_to_album_header_0", 2131558579);
            hashMap.put("layout/item_add_to_goods_list_0", 2131558580);
            hashMap.put("layout/item_ads_0", 2131558581);
            hashMap.put("layout/item_album_0", 2131558582);
            hashMap.put("layout/item_album_app_0", 2131558583);
            hashMap.put("layout/item_album_app_edit_0", 2131558584);
            hashMap.put("layout/item_album_edit_header_0", 2131558585);
            hashMap.put("layout/item_album_expand_card_0", 2131558586);
            hashMap.put("layout/item_album_feed_base_0", 2131558587);
            hashMap.put("layout/item_album_icon_0", 2131558588);
            hashMap.put("layout/item_album_with_avatar_0", 2131558589);
            hashMap.put("layout/item_alert_message_card_0", 2131558590);
            hashMap.put("layout/item_answer_view_0", 2131558591);
            hashMap.put("layout/item_apk_scroll_with_background_0", 2131558592);
            hashMap.put("layout/item_app_category_0", 2131558593);
            hashMap.put("layout/item_app_detail_0", 2131558594);
            hashMap.put("layout/item_app_forum_0", 2131558595);
            hashMap.put("layout/item_app_inside_image_card_0", 2131558596);
            hashMap.put("layout/item_app_node_coupon_0", 2131558597);
            hashMap.put("layout/item_app_node_gift_0", 2131558598);
            hashMap.put("layout/item_app_node_tag_0", 2131558599);
            hashMap.put("layout/item_app_node_thumbnail_0", 2131558600);
            hashMap.put("layout/item_app_photo_thumbnail_0", 2131558601);
            hashMap.put("layout/item_app_updata_manager_0", 2131558602);
            hashMap.put("layout/item_app_view_base_info_0", 2131558603);
            hashMap.put("layout/item_app_view_base_info_coupon_item_0", 2131558604);
            hashMap.put("layout/item_app_view_base_info_gift_0", 2131558605);
            hashMap.put("layout/item_app_view_comment_title_0", 2131558606);
            hashMap.put("layout/item_app_view_download_0", 2131558607);
            hashMap.put("layout/item_app_view_gift_0", 2131558608);
            hashMap.put("layout/item_app_view_holder_0", 2131558609);
            hashMap.put("layout/item_app_view_interactive_0", 2131558610);
            hashMap.put("layout/item_app_view_rating_0", 2131558611);
            hashMap.put("layout/item_article_answer_preview_top_0", 2131558612);
            hashMap.put("layout/item_article_card_goods_0", 2131558613);
            hashMap.put("layout/item_article_detail_answer_top_0", 2131558614);
            hashMap.put("layout/item_article_detail_top_0", 2131558615);
            hashMap.put("layout/item_article_edit_share_url_0", 2131558616);
            hashMap.put("layout/item_article_edit_share_url_container_0", 2131558617);
            hashMap.put("layout/item_article_feed_preview_top_0", 2131558618);
            hashMap.put("layout/item_article_view_image_0", 2131558620);
            hashMap.put("layout/item_article_view_text_0", 2131558621);
            hashMap.put("layout/item_back_app_switch_0", 2131558622);
            hashMap.put("layout/item_backup_0", 2131558623);
            hashMap.put("layout/item_backup_app_0", 2131558624);
            hashMap.put("layout/item_backup_header_0", 2131558625);
            hashMap.put("layout/item_backup_header_info_0", 2131558626);
            hashMap.put("layout/item_backup_header_title_0", 2131558627);
            hashMap.put("layout/item_bind_goods_child_0", 2131558628);
            hashMap.put("layout/item_black_list_0", 2131558629);
            hashMap.put("layout/item_block_header_0", 2131558630);
            hashMap.put("layout/item_block_node_0", 2131558631);
            hashMap.put("layout/item_block_user_0", 2131558632);
            hashMap.put("layout/item_block_word_0", 2131558633);
            hashMap.put("layout/item_capsule_list_0", 2131558634);
            hashMap.put("layout/item_card_add_0", 2131558635);
            hashMap.put("layout/item_card_double_0", 2131558636);
            hashMap.put("layout/item_card_double_item_0", 2131558637);
            hashMap.put("layout/item_card_manager_0", 2131558638);
            hashMap.put("layout/item_card_manager_title_0", 2131558639);
            hashMap.put("layout/item_card_triple_0", 2131558640);
            hashMap.put("layout/item_card_triple_item_0", 2131558641);
            hashMap.put("layout/item_category_detail_rank_0", 2131558642);
            hashMap.put("layout/item_category_header_0", 2131558643);
            hashMap.put("layout/item_center_login_0", 2131558644);
            hashMap.put("layout/item_center_more_entrance_0", 2131558645);
            hashMap.put("layout/item_center_more_entrance_child_0", 2131558646);
            hashMap.put("layout/item_center_more_menu_0", 2131558647);
            hashMap.put("layout/item_center_more_title_0", 2131558648);
            hashMap.put("layout/item_center_user_info_0", 2131558649);
            hashMap.put("layout/item_center_user_menu_0", 2131558650);
            hashMap.put("layout/item_center_user_menu_child_0", 2131558651);
            hashMap.put("layout/item_channel_tab_0", 2131558652);
            hashMap.put("layout/item_channel_title_0", 2131558653);
            hashMap.put("layout/item_chating_mine_0", 2131558654);
            hashMap.put("layout/item_chating_mine_card_0", 2131558655);
            hashMap.put("layout/item_chating_user_0", 2131558656);
            hashMap.put("layout/item_chating_user_card_0", 2131558657);
            hashMap.put("layout/item_circle_feed_top_0", 2131558658);
            hashMap.put("layout/item_collection_0", 2131558659);
            hashMap.put("layout/item_collection_foot_0", 2131558660);
            hashMap.put("layout/item_collection_header_0", 2131558661);
            hashMap.put("layout/item_collection_select_0", 2131558662);
            hashMap.put("layout/item_colorful_fat_scroll_card_child_0", 2131558663);
            hashMap.put("layout/item_colorful_scroll_card_child_0", 2131558664);
            hashMap.put("layout/item_commentbar_child_view_0", 2131558665);
            hashMap.put("layout/item_contact_0", 2131558666);
            hashMap.put("layout/item_cool_pic_image_0", 2131558667);
            hashMap.put("layout/item_cool_pic_image_view_0", 2131558668);
            hashMap.put("layout/item_coolpic_detail_0", 2131558669);
            hashMap.put("layout/item_coolpic_fall_0", 2131558670);
            hashMap.put("layout/item_cover_view_0", 2131558671);
            hashMap.put("layout/item_create_goods_list_0", 2131558672);
            hashMap.put("layout/item_developer_app_0", 2131558673);
            hashMap.put("layout/item_developer_card_0", 2131558674);
            hashMap.put("layout/item_device_params_0", 2131558675);
            hashMap.put("layout/item_discovery_image_view_v8_0", 2131558676);
            hashMap.put("layout/item_discovery_view_0", 2131558677);
            hashMap.put("layout/item_doc_list_card_0", 2131558678);
            hashMap.put("layout/item_doc_list_card_item_0", 2131558679);
            hashMap.put("layout/item_doc_marquee_card_0", 2131558680);
            hashMap.put("layout/item_download_0", 2131558681);
            hashMap.put("layout/item_dyh_article_content_0", 2131558682);
            hashMap.put("layout/item_dyh_article_header_0", 2131558683);
            hashMap.put("layout/item_dyh_article_v8_0", 2131558684);
            hashMap.put("layout/item_dyh_detail_v8_0", 2131558685);
            hashMap.put("layout/item_dyh_includ_0", 2131558686);
            hashMap.put("layout/item_dyh_mini_header_0", 2131558687);
            hashMap.put("layout/item_dyh_simple_header_0", 2131558688);
            hashMap.put("layout/item_dyh_source_part_0", 2131558689);
            hashMap.put("layout/item_dyh_source_title_0", 2131558690);
            hashMap.put("layout/item_dyharticle_action_0", 2131558691);
            hashMap.put("layout/item_edit_goods_0", 2131558692);
            hashMap.put("layout/item_empty_view_0", 2131558693);
            hashMap.put("layout/item_entity_video_detail_view_part_0", 2131558694);
            hashMap.put("layout/item_favorite_0", 2131558695);
            hashMap.put("layout/item_feed_action_view_0", 2131558696);
            hashMap.put("layout/item_feed_album_layout_0", 2131558697);
            hashMap.put("layout/item_feed_base_0", 2131558698);
            hashMap.put("layout/item_feed_bind_goods_0", 2131558699);
            hashMap.put("layout/item_feed_cool_pic_detail_0", 2131558700);
            hashMap.put("layout/item_feed_cool_pic_layout_0", 2131558701);
            hashMap.put("layout/item_feed_cover_view_0", 2131558702);
            hashMap.put("layout/item_feed_detail_view_v8_0", 2131558703);
            hashMap.put("layout/item_feed_discovery_detail_0", 2131558704);
            hashMap.put("layout/item_feed_extra_type_part_0", 2131558705);
            hashMap.put("layout/item_feed_filter_0", 2131558706);
            hashMap.put("layout/item_feed_followable_header_view_0", 2131558707);
            hashMap.put("layout/item_feed_forward_view_0", 2131558708);
            hashMap.put("layout/item_feed_goods_0", 2131558709);
            hashMap.put("layout/item_feed_goods_detail_0", 2131558710);
            hashMap.put("layout/item_feed_goods_detail_image_0", 2131558711);
            hashMap.put("layout/item_feed_goods_info_0", 2131558712);
            hashMap.put("layout/item_feed_header_view_0", 2131558713);
            hashMap.put("layout/item_feed_image_0", 2131558714);
            hashMap.put("layout/item_feed_layout_v8_0", 2131558715);
            hashMap.put("layout/item_feed_news_bottom_0", 2131558716);
            hashMap.put("layout/item_feed_news_view_0", 2131558717);
            hashMap.put("layout/item_feed_rating_0", 2131558718);
            hashMap.put("layout/item_feed_rating_data_0", 2131558719);
            hashMap.put("layout/item_feed_rating_detail_0", 2131558720);
            hashMap.put("layout/item_feed_rating_header_0", 2131558721);
            hashMap.put("layout/item_feed_rating_view_0", 2131558722);
            hashMap.put("layout/item_feed_reply_0", 2131558723);
            hashMap.put("layout/item_feed_reply_hot_0", 2131558724);
            hashMap.put("layout/item_feed_reply_me_0", 2131558725);
            hashMap.put("layout/item_feed_reply_part_0", 2131558726);
            hashMap.put("layout/item_feed_reply_text_0", 2131558727);
            hashMap.put("layout/item_feed_reply_title_0", 2131558728);
            hashMap.put("layout/item_feed_rough_draft_0", 2131558729);
            hashMap.put("layout/item_feed_scroll_item_0", 2131558730);
            hashMap.put("layout/item_feed_second_hand_header_view_part_0", 2131558731);
            hashMap.put("layout/item_feed_second_hand_view_part_0", 2131558732);
            hashMap.put("layout/item_feed_share_action_view_0", 2131558733);
            hashMap.put("layout/item_feed_small_header_view_0", 2131558734);
            hashMap.put("layout/item_feed_small_title_0", 2131558735);
            hashMap.put("layout/item_feed_source_deleted_0", 2131558736);
            hashMap.put("layout/item_feed_source_part_0", 2131558737);
            hashMap.put("layout/item_feed_stack_item_0", 2131558738);
            hashMap.put("layout/item_feed_target_view_0", 2131558739);
            hashMap.put("layout/item_feed_title_0", 2131558740);
            hashMap.put("layout/item_feed_video_detail_view_part_0", 2131558741);
            hashMap.put("layout/item_feed_vote_0", 2131558742);
            hashMap.put("layout/item_feed_vote_comment_0", 2131558743);
            hashMap.put("layout/item_feed_vote_comment_detail_0", 2131558744);
            hashMap.put("layout/item_feed_vote_comment_small_0", 2131558745);
            hashMap.put("layout/item_feed_vote_comment_view_part_0", 2131558746);
            hashMap.put("layout/item_feed_vote_header_0", 2131558747);
            hashMap.put("layout/item_feed_vote_multi_0", 2131558748);
            hashMap.put("layout/item_feed_vote_pk_0", 2131558749);
            hashMap.put("layout/item_feed_vote_pk_result_0", 2131558750);
            hashMap.put("layout/item_file_0", 2131558751);
            hashMap.put("layout/item_file_title_0", 2131558752);
            hashMap.put("layout/item_folded_view_0", 2131558753);
            hashMap.put("layout/item_follow_dyh_0", 2131558754);
            hashMap.put("layout/item_foot_0", 2131558755);
            hashMap.put("layout/item_forward_entity_share_app_0", 2131558756);
            hashMap.put("layout/item_fun_thing_0", 2131558757);
            hashMap.put("layout/item_gift_item_0", 2131558758);
            hashMap.put("layout/item_good_goods_0", 2131558759);
            hashMap.put("layout/item_good_goods_add_0", 2131558760);
            hashMap.put("layout/item_good_goods_list_header_0", 2131558761);
            hashMap.put("layout/item_goods_0", 2131558762);
            hashMap.put("layout/item_goods_fall_0", 2131558763);
            hashMap.put("layout/item_goods_list_0", 2131558765);
            hashMap.put("layout/item_goods_list_edit_header_0", 2131558766);
            hashMap.put("layout/item_goods_list_feed_0", 2131558767);
            hashMap.put("layout/item_goods_list_simple_0", 2131558768);
            hashMap.put("layout/item_goods_params_0", 2131558769);
            hashMap.put("layout/item_goods_v10_0", 2131558770);
            hashMap.put("layout/item_grid_album_card_0", 2131558771);
            hashMap.put("layout/item_grid_card_0", 2131558772);
            hashMap.put("layout/item_grid_card_item_0", 2131558773);
            hashMap.put("layout/item_grid_card_view_0", 2131558774);
            hashMap.put("layout/item_grid_dyh_card_0", 2131558775);
            hashMap.put("layout/item_grid_dyh_card_item_0", 2131558776);
            hashMap.put("layout/item_grid_item_long_title_0", 2131558777);
            hashMap.put("layout/item_group_list_card_0", 2131558778);
            hashMap.put("layout/item_head_card_0", 2131558779);
            hashMap.put("layout/item_headline_title_0", 2131558780);
            hashMap.put("layout/item_hot_feed_reply_view_part_0", 2131558781);
            hashMap.put("layout/item_hot_search_list_0", 2131558782);
            hashMap.put("layout/item_hot_search_user_0", 2131558783);
            hashMap.put("layout/item_icon_button_grid_card_0", 2131558784);
            hashMap.put("layout/item_icon_grid_card_item_0", 2131558785);
            hashMap.put("layout/item_icon_link_grid_card_0", 2131558786);
            hashMap.put("layout/item_icon_link_grid_card_item_0", 2131558787);
            hashMap.put("layout/item_icon_link_mini_grid_card_item_0", 2131558788);
            hashMap.put("layout/item_icon_mini_grid_card_0", 2131558789);
            hashMap.put("layout/item_icon_mini_grid_card_item_0", 2131558790);
            hashMap.put("layout/item_icon_title_view_0", 2131558791);
            hashMap.put("layout/item_image_app_big_card_0", 2131558792);
            hashMap.put("layout/item_image_app_card_0", 2131558793);
            hashMap.put("layout/item_image_card_0", 2131558794);
            hashMap.put("layout/item_image_carousel_card1_item_0", 2131558795);
            hashMap.put("layout/item_image_carousel_card2_0", 2131558796);
            hashMap.put("layout/item_image_carousel_card2_item_0", 2131558797);
            hashMap.put("layout/item_image_list_card_0", 2131558798);
            hashMap.put("layout/item_image_scroll_card_0", 2131558799);
            hashMap.put("layout/item_image_scroll_card_item_0", 2131558800);
            hashMap.put("layout/item_image_text_card_child_0", 2131558801);
            hashMap.put("layout/item_large_scroll_card_goods_item_0", 2131558802);
            hashMap.put("layout/item_large_scroll_card_item_0", 2131558803);
            hashMap.put("layout/item_large_text_0", 2131558804);
            hashMap.put("layout/item_layout_dyh_includ_0", 2131558805);
            hashMap.put("layout/item_library_show_0", 2131558806);
            hashMap.put("layout/item_link_card_0", 2131558807);
            hashMap.put("layout/item_link_card_tab_0", 2131558808);
            hashMap.put("layout/item_link_card_v8_0", 2131558809);
            hashMap.put("layout/item_list_card_0", 2131558810);
            hashMap.put("layout/item_live_card_0", 2131558811);
            hashMap.put("layout/item_live_image_text_card_0", 2131558812);
            hashMap.put("layout/item_live_item_card_0", 2131558813);
            hashMap.put("layout/item_live_line_view_part_0", 2131558814);
            hashMap.put("layout/item_live_message_0", 2131558815);
            hashMap.put("layout/item_live_system_message_0", 2131558816);
            hashMap.put("layout/item_live_video_view_part_0", 2131558817);
            hashMap.put("layout/item_local_apk_0", 2131558818);
            hashMap.put("layout/item_local_app_0", 2131558819);
            hashMap.put("layout/item_location_0", 2131558820);
            hashMap.put("layout/item_log_file_0", 2131558821);
            hashMap.put("layout/item_login_card_0", 2131558822);
            hashMap.put("layout/item_login_user_node_rating_selector_0", 2131558823);
            hashMap.put("layout/item_main_category_child_0", 2131558824);
            hashMap.put("layout/item_main_category_detail_s_0", 2131558826);
            hashMap.put("layout/item_main_category_link_0", 2131558827);
            hashMap.put("layout/item_main_catogory_type_0", 2131558828);
            hashMap.put("layout/item_market_apps_0", 2131558829);
            hashMap.put("layout/item_menu_item_0", 2131558830);
            hashMap.put("layout/item_message_0", 2131558831);
            hashMap.put("layout/item_message_card_0", 2131558832);
            hashMap.put("layout/item_message_extra_0", 2131558833);
            hashMap.put("layout/item_message_select_view_0", 2131558834);
            hashMap.put("layout/item_mobile_album_app_new_0", 2131558835);
            hashMap.put("layout/item_mobile_app_0", 2131558836);
            hashMap.put("layout/item_mobile_app_switch_0", 2131558837);
            hashMap.put("layout/item_more_action_0", 2131558838);
            hashMap.put("layout/item_my_empty_card_0", 2131558839);
            hashMap.put("layout/item_new_add_0", 2131558840);
            hashMap.put("layout/item_new_feed_image_0", 2131558841);
            hashMap.put("layout/item_new_grid_card_0", 2131558842);
            hashMap.put("layout/item_no_login_titel_0", 2131558843);
            hashMap.put("layout/item_no_more_data_view_0", 2131558844);
            hashMap.put("layout/item_node_pick_item_0", 2131558845);
            hashMap.put("layout/item_node_rating_0", 2131558846);
            hashMap.put("layout/item_node_rating_selector_0", 2131558847);
            hashMap.put("layout/item_node_top_conten_item_0", 2131558848);
            hashMap.put("layout/item_notification_0", 2131558849);
            hashMap.put("layout/item_notification_album_like_0", 2131558850);
            hashMap.put("layout/item_notification_feed_like_0", 2131558851);
            hashMap.put("layout/item_notification_feedreply_like_0", 2131558852);
            hashMap.put("layout/item_notification_navi_0", 2131558853);
            hashMap.put("layout/item_options_title_0", 2131558854);
            hashMap.put("layout/item_permission_0", 2131558855);
            hashMap.put("layout/item_permissions_0", 2131558856);
            hashMap.put("layout/item_photo_directory_0", 2131558857);
            hashMap.put("layout/item_photo_picker_0", 2131558858);
            hashMap.put("layout/item_photo_view_0", 2131558859);
            hashMap.put("layout/item_pic_category_0", 2131558860);
            hashMap.put("layout/item_pic_type_tab_0", 2131558861);
            hashMap.put("layout/item_pick_app_0", 2131558862);
            hashMap.put("layout/item_pick_service_app_0", 2131558863);
            hashMap.put("layout/item_picture_switch_0", 2131558864);
            hashMap.put("layout/item_place_holder_0", 2131558865);
            hashMap.put("layout/item_podium_card_0", 2131558866);
            hashMap.put("layout/item_podium_card_item_0", 2131558867);
            hashMap.put("layout/item_product_brand_left_item_0", 2131558868);
            hashMap.put("layout/item_product_config_item_0", 2131558869);
            hashMap.put("layout/item_product_config_title_0", 2131558870);
            hashMap.put("layout/item_product_coupon_0", 2131558871);
            hashMap.put("layout/item_product_coupon_device_0", 2131558872);
            hashMap.put("layout/item_product_description_0", 2131558873);
            hashMap.put("layout/item_product_extra_params_0", 2131558874);
            hashMap.put("layout/item_product_media_0", 2131558875);
            hashMap.put("layout/item_product_multi_rating_map_0", 2131558876);
            hashMap.put("layout/item_product_params_0", 2131558877);
            hashMap.put("layout/item_product_score_view_0", 2131558878);
            hashMap.put("layout/item_product_series_0", 2131558879);
            hashMap.put("layout/item_product_series_child_0", 2131558880);
            hashMap.put("layout/item_product_series_ershou_0", 2131558881);
            hashMap.put("layout/item_product_series_horizontal_0", 2131558882);
            hashMap.put("layout/item_product_series_list_more_0", 2131558883);
            hashMap.put("layout/item_product_series_list_title_0", 2131558884);
            hashMap.put("layout/item_product_series_vertical_0", 2131558885);
            hashMap.put("layout/item_product_small_rating_article_0", 2131558886);
            hashMap.put("layout/item_product_small_rating_feed_0", 2131558887);
            hashMap.put("layout/item_product_timeline_child_0", 2131558888);
            hashMap.put("layout/item_product_view_0", 2131558889);
            hashMap.put("layout/item_progress_hint_0", 2131558890);
            hashMap.put("layout/item_question_detail_bottom_0", 2131558891);
            hashMap.put("layout/item_question_detail_view_0", 2131558892);
            hashMap.put("layout/item_question_title_view_0", 2131558893);
            hashMap.put("layout/item_question_view_0", 2131558894);
            hashMap.put("layout/item_rank_header_0", 2131558895);
            hashMap.put("layout/item_rating_card_0", 2131558896);
            hashMap.put("layout/item_receiverd_reply_0", 2131558897);
            hashMap.put("layout/item_recent_history_0", 2131558898);
            hashMap.put("layout/item_recent_login_0", 2131558899);
            hashMap.put("layout/item_refresh_card_0", 2131558900);
            hashMap.put("layout/item_relate_app_card_0", 2131558901);
            hashMap.put("layout/item_related_data_0", 2131558902);
            hashMap.put("layout/item_relative_child_0", 2131558903);
            hashMap.put("layout/item_reply_like_list_0", 2131558904);
            hashMap.put("layout/item_reply_list_0", 2131558905);
            hashMap.put("layout/item_reply_more_0", 2131558906);
            hashMap.put("layout/item_reply_photo_0", 2131558907);
            hashMap.put("layout/item_reply_photo_add_0", 2131558908);
            hashMap.put("layout/item_right_cover_view_0", 2131558909);
            hashMap.put("layout/item_scene_related_0", 2131558910);
            hashMap.put("layout/item_scroll_card_0", 2131558911);
            hashMap.put("layout/item_search_app_filter_0", 2131558912);
            hashMap.put("layout/item_search_ask_filter_0", 2131558913);
            hashMap.put("layout/item_search_dropdown_0", 2131558914);
            hashMap.put("layout/item_search_extend_0", 2131558915);
            hashMap.put("layout/item_search_extend_footer_0", 2131558916);
            hashMap.put("layout/item_search_extend_header_0", 2131558917);
            hashMap.put("layout/item_search_feed_filter_0", 2131558918);
            hashMap.put("layout/item_search_history_0", 2131558919);
            hashMap.put("layout/item_search_hot_0", 2131558920);
            hashMap.put("layout/item_search_recommend_0", 2131558921);
            hashMap.put("layout/item_search_scene_0", 2131558922);
            hashMap.put("layout/item_search_sh_filter_0", 2131558923);
            hashMap.put("layout/item_search_view_0", 2131558924);
            hashMap.put("layout/item_second_hand_detail_0", 2131558925);
            hashMap.put("layout/item_second_hand_fall_0", 2131558926);
            hashMap.put("layout/item_second_hand_search_0", 2131558927);
            hashMap.put("layout/item_section_demo_title_0", 2131558928);
            hashMap.put("layout/item_see_more_0", 2131558929);
            hashMap.put("layout/item_selector_link_view_0", 2131558930);
            hashMap.put("layout/item_service_app_0", 2131558931);
            hashMap.put("layout/item_service_app_time_0", 2131558932);
            hashMap.put("layout/item_setting_0", 2131558933);
            hashMap.put("layout/item_share_app_0", 2131558934);
            hashMap.put("layout/item_simple_divider_0", 2131558935);
            hashMap.put("layout/item_simple_entity_holder_0", 2131558936);
            hashMap.put("layout/item_simple_feed_0", 2131558937);
            hashMap.put("layout/item_simple_title_0", 2131558939);
            hashMap.put("layout/item_simple_user_view_0", 2131558940);
            hashMap.put("layout/item_single_rating_0", 2131558941);
            hashMap.put("layout/item_small_scroll_card_item_0", 2131558942);
            hashMap.put("layout/item_sort_select_0", 2131558943);
            hashMap.put("layout/item_space_0", 2131558944);
            hashMap.put("layout/item_sponsor_0", 2131558945);
            hashMap.put("layout/item_sponsor_self_draw_0", 2131558946);
            hashMap.put("layout/item_sponsor_self_draw_news_0", 2131558947);
            hashMap.put("layout/item_submit_goods_card_0", 2131558948);
            hashMap.put("layout/item_tab_group_card_0", 2131558949);
            hashMap.put("layout/item_tab_group_card_item_0", 2131558950);
            hashMap.put("layout/item_tab_view_0", 2131558952);
            hashMap.put("layout/item_text_0", 2131558953);
            hashMap.put("layout/item_text_card_0", 2131558954);
            hashMap.put("layout/item_text_carousel_card_0", 2131558955);
            hashMap.put("layout/item_text_image_card_0", 2131558956);
            hashMap.put("layout/item_text_link_card_item_0", 2131558957);
            hashMap.put("layout/item_text_link_item_0", 2131558958);
            hashMap.put("layout/item_text_title_scroll_child_0", 2131558959);
            hashMap.put("layout/item_tip_empty_0", 2131558960);
            hashMap.put("layout/item_title_0", 2131558961);
            hashMap.put("layout/item_title_card_0", 2131558962);
            hashMap.put("layout/item_title_list_0", 2131558963);
            hashMap.put("layout/item_title_section_0", 2131558964);
            hashMap.put("layout/item_title_view_0", 2131558965);
            hashMap.put("layout/item_top_group_card_0", 2131558966);
            hashMap.put("layout/item_top_group_card_item_0", 2131558967);
            hashMap.put("layout/item_topic_0", 2131558968);
            hashMap.put("layout/item_topic_view_0", 2131558969);
            hashMap.put("layout/item_triple_avatar_view_part_0", 2131558970);
            hashMap.put("layout/item_triple_cool_pic_0", 2131558971);
            hashMap.put("layout/item_upgrade_0", 2131558972);
            hashMap.put("layout/item_upgrade_card_0", 2131558973);
            hashMap.put("layout/item_user_0", 2131558974);
            hashMap.put("layout/item_user_cover_add_0", 2131558975);
        }

        private static void internalPopulateLayoutIdLookup1() {
            HashMap<String, Integer> hashMap = sKeys;
            hashMap.put("layout/item_user_cover_image_0", 2131558976);
            hashMap.put("layout/item_user_cover_title_0", 2131558977);
            hashMap.put("layout/item_user_delete_recent_0", 2131558978);
            hashMap.put("layout/item_user_gift_0", 2131558979);
            hashMap.put("layout/item_user_history_0", 2131558980);
            hashMap.put("layout/item_user_info_header_view_0", 2131558981);
            hashMap.put("layout/item_user_info_num_0", 2131558982);
            hashMap.put("layout/item_user_info_part_0", 2131558983);
            hashMap.put("layout/item_user_navigation_0", 2131558984);
            hashMap.put("layout/item_user_node_rating_0", 2131558985);
            hashMap.put("layout/item_user_profile_avatar_0", 2131558986);
            hashMap.put("layout/item_user_profile_item_0", 2131558987);
            hashMap.put("layout/item_user_rating_0", 2131558988);
            hashMap.put("layout/item_user_space_count_0", 2131558989);
            hashMap.put("layout/item_version_app_0", 2131558990);
            hashMap.put("layout/item_video_detail_view_part_0", 2131558991);
            hashMap.put("layout/item_video_view_0", 2131558992);
            hashMap.put("layout/item_video_view_part_0", 2131558993);
            hashMap.put("layout/item_vote_comment_empty_0", 2131558994);
            hashMap.put("layout/item_vote_detail_splited_title_0", 2131558995);
            hashMap.put("layout/item_vote_user_0", 2131558996);
            hashMap.put("layout/item_web_view_0", 2131558997);
            hashMap.put("layout/item_webview_page_0", 2131558998);
            hashMap.put("layout/item_weui_0", 2131558999);
            hashMap.put("layout/kk_view_0", 2131559002);
            hashMap.put("layout/layout_image_mode_0", 2131559003);
            hashMap.put("layout/layout_list_edit_button_0", 2131559004);
            hashMap.put("layout/layout_message_card_0", 2131559005);
            hashMap.put("layout/layout_privacy_clause_0", 2131559006);
            hashMap.put("layout/layout_tab_config_0", 2131559010);
            hashMap.put("layout/layout_water_mark_0", 2131559015);
            hashMap.put("layout/live_activity_0", 2131559016);
            hashMap.put("layout/live_float_new_message_0", 2131559017);
            hashMap.put("layout/live_introduce_0", 2131559018);
            hashMap.put("layout/live_reply_list_0", 2131559019);
            hashMap.put("layout/loading_view_0", 2131559020);
            hashMap.put("layout/log_item_0", 2131559021);
            hashMap.put("layout/main_0", 2131559022);
            hashMap.put("layout/main_category_layout_0", 2131559023);
            hashMap.put("layout/main_center_user_part_0", 2131559024);
            hashMap.put("layout/main_fragment_0", 2131559025);
            hashMap.put("layout/market_0", 2131559026);
            hashMap.put("layout/message_top_tip_0", 2131559027);
            hashMap.put("layout/more_page_0", 2131559028);
            hashMap.put("layout/network_diagnosis_0", 2131559059);
            hashMap.put("layout/new_album_view_0", 2131559060);
            hashMap.put("layout/new_v8_album_0", 2131559061);
            hashMap.put("layout/night_time_picker_0", 2131559062);
            hashMap.put("layout/node_picker_0", 2131559063);
            hashMap.put("layout/node_rating_feed_like_view_0", 2131559064);
            hashMap.put("layout/normal_feed_content_v8_0", 2131559065);
            hashMap.put("layout/permission_0", 2131559085);
            hashMap.put("layout/photo_0", 2131559086);
            hashMap.put("layout/photo_picker_0", 2131559087);
            hashMap.put("layout/pic_reply_list_0", 2131559088);
            hashMap.put("layout/picture_detail_wrap_0", 2131559094);
            hashMap.put("layout/poi_list_0", 2131559095);
            hashMap.put("layout/post_button_setting_0", 2131559096);
            hashMap.put("layout/post_more_panel_0", 2131559097);
            hashMap.put("layout/product_brand_list_0", 2131559114);
            hashMap.put("layout/product_coupon_activity_0", 2131559115);
            hashMap.put("layout/product_node_header_0", 2131559116);
            hashMap.put("layout/product_node_toolbar_content_0", 2131559117);
            hashMap.put("layout/product_post_view_0", 2131559118);
            hashMap.put("layout/qr_code_0", 2131559119);
            hashMap.put("layout/question_title_0", 2131559120);
            hashMap.put("layout/refresh_recycler_0", 2131559121);
            hashMap.put("layout/refresh_recycler_tabs_0", 2131559122);
            hashMap.put("layout/reply_0", 2131559123);
            hashMap.put("layout/rv_in_fragment_layout_0", 2131559125);
            hashMap.put("layout/scrollable_tablayout_0", 2131559126);
            hashMap.put("layout/search_0", 2131559128);
            hashMap.put("layout/search_back_header_0", 2131559129);
            hashMap.put("layout/search_dropdown_item_0", 2131559130);
            hashMap.put("layout/search_extend_0", 2131559131);
            hashMap.put("layout/search_history_0", 2131559132);
            hashMap.put("layout/search_hot_0", 2131559133);
            hashMap.put("layout/search_list_0", 2131559134);
            hashMap.put("layout/search_list_card_0", 2131559135);
            hashMap.put("layout/search_result_0", 2131559136);
            hashMap.put("layout/search_scene_item_0", 2131559137);
            hashMap.put("layout/search_scene_list_0", 2131559138);
            hashMap.put("layout/second_hand_comment_bar_0", 2131559139);
            hashMap.put("layout/second_hand_content_v8_0", 2131559140);
            hashMap.put("layout/second_hand_extra_child_0", 2131559141);
            hashMap.put("layout/share_feed_v8_0", 2131559145);
            hashMap.put("layout/share_good_dialog_0", 2131559146);
            hashMap.put("layout/share_list_0", 2131559147);
            hashMap.put("layout/share_list_view_0", 2131559148);
            hashMap.put("layout/share_webview_0", 2131559149);
            hashMap.put("layout/splash_0", 2131559151);
            hashMap.put("layout/splash_v9_0", 2131559152);
            hashMap.put("layout/splash_view_0", 2131559153);
            hashMap.put("layout/static_dialog_view_0", 2131559154);
            hashMap.put("layout/submit_feed_add_more_item_dialog_0", 2131559155);
            hashMap.put("layout/submit_feed_add_video_item_dialog_0", 2131559156);
            hashMap.put("layout/submit_feed_article_bottom_0", 2131559157);
            hashMap.put("layout/submit_feed_article_holder2_0", 2131559158);
            hashMap.put("layout/submit_feed_article_image_part_0", 2131559159);
            hashMap.put("layout/submit_feed_article_text_part_0", 2131559160);
            hashMap.put("layout/submit_feed_article_top_answer_0", 2131559161);
            hashMap.put("layout/submit_feed_article_top_part_0", 2131559162);
            hashMap.put("layout/submit_feed_bottom_add_more_v8_0", 2131559163);
            hashMap.put("layout/submit_feed_bottom_set_visibility_0", 2131559164);
            hashMap.put("layout/submit_feed_extra_child_0", 2131559165);
            hashMap.put("layout/submit_feed_extra_logo_0", 2131559166);
            hashMap.put("layout/submit_feed_goods_0", 2131559167);
            hashMap.put("layout/submit_feed_new_goods_0", 2131559168);
            hashMap.put("layout/submit_feed_relative_info_picker_0", 2131559169);
            hashMap.put("layout/submit_feed_v8_0", 2131559170);
            hashMap.put("layout/submit_pick_color_0", 2131559171);
            hashMap.put("layout/submit_product_article_bottom_0", 2131559172);
            hashMap.put("layout/submit_product_article_top_part_0", 2131559173);
            hashMap.put("layout/submit_product_content_rating_bar_0", 2131559174);
            hashMap.put("layout/submit_product_rating_0", 2131559175);
            hashMap.put("layout/submit_rating_noraml_content_0", 2131559176);
            hashMap.put("layout/submit_second_hand_deal_extra_child_0", 2131559177);
            hashMap.put("layout/submit_second_hand_extra_child_0", 2131559178);
            hashMap.put("layout/submit_verify_mobile_code_dialog_0", 2131559179);
            hashMap.put("layout/submit_vertfiy_captcha_dialog_0", 2131559180);
            hashMap.put("layout/submit_view_article_add_link_0", 2131559181);
            hashMap.put("layout/submit_vote_extra_child_0", 2131559182);
            hashMap.put("layout/tab_layout_0", 2131559184);
            hashMap.put("layout/tag_product_owner_0", 2131559185);
            hashMap.put("layout/test_0", 2131559186);
            hashMap.put("layout/text_view_0", 2131559196);
            hashMap.put("layout/theme_pick_dialog_0", 2131559203);
            hashMap.put("layout/theme_picker_list_item_0", 2131559204);
            hashMap.put("layout/tip_layout_0", 2131559206);
            hashMap.put("layout/toolbar_layout_0", 2131559207);
            hashMap.put("layout/topic_detail_description_0", 2131559208);
            hashMap.put("layout/topic_detail_headline_0", 2131559209);
            hashMap.put("layout/topic_node_header_0", 2131559210);
            hashMap.put("layout/topic_node_header_line_0", 2131559211);
            hashMap.put("layout/topic_node_page_0", 2131559212);
            hashMap.put("layout/topic_picker_0", 2131559213);
            hashMap.put("layout/user_avatar_0", 2131559290);
            hashMap.put("layout/user_data_0", 2131559291);
            hashMap.put("layout/user_key_input_0", 2131559292);
            hashMap.put("layout/user_pick_0", 2131559293);
            hashMap.put("layout/user_qrcode_0", 2131559294);
            hashMap.put("layout/user_space_v9_0", 2131559295);
            hashMap.put("layout/user_toolbar_0", 2131559296);
            hashMap.put("layout/video_complete_0", 2131559298);
            hashMap.put("layout/video_controller_0", 2131559299);
            hashMap.put("layout/video_error_0", 2131559300);
            hashMap.put("layout/video_floating_0", 2131559301);
            hashMap.put("layout/video_full_screen_0", 2131559302);
            hashMap.put("layout/video_gesture_0", 2131559303);
            hashMap.put("layout/video_loading_0", 2131559304);
            hashMap.put("layout/video_simple_controller_0", 2131559305);
            hashMap.put("layout/vote_feed_content_0", 2131559309);
            hashMap.put("layout/vx_layout_0", 2131559310);
            hashMap.put("layout/web_view_0", 2131559312);
        }
    }
}
