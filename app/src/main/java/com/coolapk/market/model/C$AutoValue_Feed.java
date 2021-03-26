package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* renamed from: com.coolapk.market.model.$AutoValue_Feed  reason: invalid class name */
abstract class C$AutoValue_Feed extends C$$AutoValue_Feed {
    C$AutoValue_Feed(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Long l2, Long l3, String str8, UserInfo userInfo, String str9, String str10, String str11, String str12, String str13, String str14, int i, String str15, List<String> list, String str16, String str17, int i2, int i3, int i4, int i5, int i6, int i7, String str18, String str19, int i8, String str20, int i9, int i10, String str21, String str22, String str23, int i11, int i12, int i13, int i14, String str24, String str25, String str26, List<FeedReply> list2, int i15, List<RelatedData> list3, List<RelatedData> list4, List<RelatedData> list5, String str27, Collection collection, CollectionItem collectionItem, UserAction userAction, List<FeedReply> list6, List<FeedReply> list7, List<FeedReply> list8, List<String> list9, List<GoodsListItem> list10, Feed feed, DyhArticle dyhArticle, String str28, String str29, String str30, String str31, long j, UserInfo userInfo2, String str32, String str33, String str34, String str35, String str36, String str37, String str38, String str39, String str40, int i16, int i17, int i18, int i19, long j2, String str41, String str42, String str43, String str44, String str45, String str46, String str47, String str48, List<FeedRelation> list11, FeedTarget feedTarget, int i20, String str49, String str50, String str51, String str52, String str53, String str54, String str55, String str56, String str57, String str58, String str59, String str60, List<Entity> list12, String str61, String str62, String str63, String str64, String str65, String str66, String str67, int i21, String str68, String str69, int i22, DyhModel dyhModel, String str70, String str71, String str72, String str73, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, String str74, String str75, String str76, String str77, String str78, String str79, String str80, String str81, Entity entity, Entity entity2, Entity entity3, int i23, List<FeedReply> list13, FeedGoodsAction feedGoodsAction, String str82, int i24, int i25, int i26, Vote vote, SecondHandInfo secondHandInfo, int i27, SimpleInfo simpleInfo, SimpleInfo simpleInfo2, int i28, int i29, int i30) {
        super(str, str2, str3, str4, num, str5, str6, str7, l2, l3, str8, userInfo, str9, str10, str11, str12, str13, str14, i, str15, list, str16, str17, i2, i3, i4, i5, i6, i7, str18, str19, i8, str20, i9, i10, str21, str22, str23, i11, i12, i13, i14, str24, str25, str26, list2, i15, list3, list4, list5, str27, collection, collectionItem, userAction, list6, list7, list8, list9, list10, feed, dyhArticle, str28, str29, str30, str31, j, userInfo2, str32, str33, str34, str35, str36, str37, str38, str39, str40, i16, i17, i18, i19, j2, str41, str42, str43, str44, str45, str46, str47, str48, list11, feedTarget, i20, str49, str50, str51, str52, str53, str54, str55, str56, str57, str58, str59, str60, list12, str61, str62, str63, str64, str65, str66, str67, i21, str68, str69, i22, dyhModel, str70, str71, str72, str73, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, str74, str75, str76, str77, str78, str79, str80, str81, entity, entity2, entity3, i23, list13, feedGoodsAction, str82, i24, i25, i26, vote, secondHandInfo, i27, simpleInfo, simpleInfo2, i28, i29, i30);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Feed$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Feed> {
        private final TypeAdapter<String> TUrlAdapter;
        private final TypeAdapter<String> adminInfoAdapter;
        private final TypeAdapter<String> appNameAdapter;
        private final TypeAdapter<String> articleIdAdapter;
        private final TypeAdapter<Integer> blockStatusAdapter;
        private final TypeAdapter<String> blockStatusTextAdapter;
        private final TypeAdapter<Integer> buyStatusAdapter;
        private final TypeAdapter<Collection> collectionInfoAdapter;
        private final TypeAdapter<CollectionItem> collectionItemAdapter;
        private final TypeAdapter<String> commentBadAdapter;
        private final TypeAdapter<String> commentBadPicAdapter;
        private final TypeAdapter<Integer> commentBlockNumAdapter;
        private final TypeAdapter<String> commentGeneralAdapter;
        private final TypeAdapter<String> commentGeneralPicAdapter;
        private final TypeAdapter<String> commentGoodAdapter;
        private final TypeAdapter<String> commentGoodPicAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private String defaultAdminInfo = null;
        private String defaultAppName = null;
        private String defaultArticleId = null;
        private int defaultBlockStatus = 0;
        private String defaultBlockStatusText = null;
        private int defaultBuyStatus = 0;
        private Collection defaultCollectionInfo = null;
        private CollectionItem defaultCollectionItem = null;
        private String defaultCommentBad = null;
        private String defaultCommentBadPic = null;
        private int defaultCommentBlockNum = 0;
        private String defaultCommentGeneral = null;
        private String defaultCommentGeneralPic = null;
        private String defaultCommentGood = null;
        private String defaultCommentGoodPic = null;
        private Long defaultDateline = null;
        private String defaultDeprecatedUserAvatar = null;
        private String defaultDeprecatedUserName = null;
        private String defaultDescription = null;
        private Entity defaultDetailSponsorCard = null;
        private String defaultDeviceTitle = null;
        private String defaultDisplayUserName = null;
        private String defaultDyhId = null;
        private DyhModel defaultDyhModel = null;
        private String defaultDyhName = null;
        private String defaultEditorTitle = null;
        private int defaultEnableModify = 0;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityType = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private List<Entity> defaultExtraEntities = Collections.emptyList();
        private String defaultExtraFromApi = null;
        private String defaultExtraInfo = null;
        private String defaultExtraKey = null;
        private String defaultExtraLinkUrl = null;
        private String defaultExtraPic = null;
        private String defaultExtraTitle = null;
        private String defaultExtraType = null;
        private String defaultExtraUrl = null;
        private int defaultFavoriteNum = 0;
        private String defaultFeedFromType = null;
        private String defaultFeedType = null;
        private String defaultFeedTypeName = null;
        private String defaultFetchType = null;
        private String defaultFid = null;
        private int defaultFollowNum = 0;
        private String defaultForwardId = null;
        private int defaultForwardNum = 0;
        private DyhArticle defaultForwardSourceArticle = null;
        private Feed defaultForwardSourceFeed = null;
        private String defaultForwardSourceType = null;
        private FeedGoodsAction defaultGoodsAction = null;
        private List<GoodsListItem> defaultGoodsListItem = Collections.emptyList();
        private List<FeedReply> defaultHotReplyRows = Collections.emptyList();
        private Entity defaultHotSponsorCard = null;
        private String defaultId = null;
        private String defaultInfo = null;
        private String defaultInfoHtml = null;
        private SimpleInfo defaultInnerInfo = null;
        private int defaultIsAnonymous = 0;
        private int defaultIsHeadline = 0;
        private int defaultIsHeadlineCommentV8 = 0;
        private int defaultIsHeadlineV8 = 0;
        private int defaultIsHeadlined = 0;
        private int defaultIsHistory = 0;
        private int defaultIsHtmlArticle = 0;
        private int defaultIsModified = 0;
        private int defaultIsOwner = 0;
        private int defaultIsRecommendVoteComment = 0;
        private int defaultIsStickTop = 0;
        private String defaultKeywords = null;
        private String defaultLabel = null;
        private Long defaultLastUpdate = null;
        private String defaultLikeAvatar = null;
        private int defaultLikeNum = 0;
        private long defaultLikeTime = 0;
        private String defaultLikeUid = null;
        private UserInfo defaultLikeUserInfo = null;
        private String defaultLikeUserName = null;
        private String defaultLocation = null;
        private String defaultLongLocation = null;
        private String defaultMediaInfo = null;
        private String defaultMediaType = null;
        private String defaultMediaUrl = null;
        private String defaultMessage = null;
        private String defaultMessageCover = null;
        private String defaultMessageKeywords = null;
        private String defaultMessageRawInput = null;
        private String defaultMessageRawOutput = null;
        private String defaultMessageSource = null;
        private int defaultMessageStatus = 0;
        private String defaultMessageStatusText = null;
        private String defaultMessageTitle = null;
        private Entity defaultNoticeSponsorCard = null;
        private String defaultPic = null;
        private List<String> defaultPicArray = Collections.emptyList();
        private int defaultQuestionAnswerNum = 0;
        private int defaultQuestionFollowNum = 0;
        private float defaultRatingScore = 0.0f;
        private float defaultRatingScore1 = 0.0f;
        private float defaultRatingScore10 = 0.0f;
        private float defaultRatingScore2 = 0.0f;
        private float defaultRatingScore3 = 0.0f;
        private float defaultRatingScore4 = 0.0f;
        private float defaultRatingScore5 = 0.0f;
        private float defaultRatingScore6 = 0.0f;
        private float defaultRatingScore7 = 0.0f;
        private float defaultRatingScore8 = 0.0f;
        private float defaultRatingScore9 = 0.0f;
        private String defaultRatingType = null;
        private List<String> defaultRecentLikeList = Collections.emptyList();
        private List<FeedReply> defaultRecentReplyRows = Collections.emptyList();
        private int defaultRecommend = 0;
        private List<RelatedData> defaultRelatedData = null;
        private int defaultRelatedNum = 0;
        private List<FeedRelation> defaultRelationRows = Collections.emptyList();
        private List<FeedReply> defaultReplyMeRows = Collections.emptyList();
        private int defaultReplyNum = 0;
        private List<FeedReply> defaultReplyRows = null;
        private SecondHandInfo defaultSecondHandInfo = null;
        private int defaultShareNum = 0;
        private String defaultShareUrl = null;
        private int defaultShowOwner = 0;
        private String defaultSourceId = null;
        private String defaultSpamContent = null;
        private String defaultSpamReason = null;
        private long defaultSpamTime = 0;
        private int defaultStar = 0;
        private int defaultStatus = 0;
        private String defaultStatusText = null;
        private String defaultSubTitle = null;
        private String defaultTUrl = null;
        private String defaultTags = null;
        private FeedTarget defaultTargetRow = null;
        private String defaultTid = null;
        private String defaultTinfo = null;
        private String defaultTitle = null;
        private String defaultTkey = null;
        private String defaultTlink = null;
        private SimpleInfo defaultTopInfo = null;
        private List<FeedReply> defaultTopReplyRows = Collections.emptyList();
        private String defaultTpic = null;
        private String defaultTtype = null;
        private int defaultType = 0;
        private String defaultUid = null;
        private String defaultUrl = null;
        private UserAction defaultUserAction = null;
        private List<RelatedData> defaultUserFollowList = Collections.emptyList();
        private UserInfo defaultUserInfo = null;
        private List<RelatedData> defaultUserLikeList = null;
        private String defaultUserTags = null;
        private String defaultUseragent = null;
        private String defaultVideoPic = null;
        private String defaultVideoUrl = null;
        private Vote defaultVote = null;
        private final TypeAdapter<String> deprecatedUserAvatarAdapter;
        private final TypeAdapter<String> deprecatedUserNameAdapter;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Entity> detailSponsorCardAdapter;
        private final TypeAdapter<String> deviceTitleAdapter;
        private final TypeAdapter<String> displayUserNameAdapter;
        private final TypeAdapter<String> dyhIdAdapter;
        private final TypeAdapter<DyhModel> dyhModelAdapter;
        private final TypeAdapter<String> dyhNameAdapter;
        private final TypeAdapter<String> editorTitleAdapter;
        private final TypeAdapter<Integer> enableModifyAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<List<Entity>> extraEntitiesAdapter;
        private final TypeAdapter<String> extraFromApiAdapter;
        private final TypeAdapter<String> extraInfoAdapter;
        private final TypeAdapter<String> extraKeyAdapter;
        private final TypeAdapter<String> extraLinkUrlAdapter;
        private final TypeAdapter<String> extraPicAdapter;
        private final TypeAdapter<String> extraTitleAdapter;
        private final TypeAdapter<String> extraTypeAdapter;
        private final TypeAdapter<String> extraUrlAdapter;
        private final TypeAdapter<Integer> favoriteNumAdapter;
        private final TypeAdapter<String> feedFromTypeAdapter;
        private final TypeAdapter<String> feedTypeAdapter;
        private final TypeAdapter<String> feedTypeNameAdapter;
        private final TypeAdapter<String> fetchTypeAdapter;
        private final TypeAdapter<String> fidAdapter;
        private final TypeAdapter<Integer> followNumAdapter;
        private final TypeAdapter<String> forwardIdAdapter;
        private final TypeAdapter<Integer> forwardNumAdapter;
        private final TypeAdapter<DyhArticle> forwardSourceArticleAdapter;
        private final TypeAdapter<Feed> forwardSourceFeedAdapter;
        private final TypeAdapter<String> forwardSourceTypeAdapter;
        private final TypeAdapter<FeedGoodsAction> goodsActionAdapter;
        private final TypeAdapter<List<GoodsListItem>> goodsListItemAdapter;
        private final TypeAdapter<List<FeedReply>> hotReplyRowsAdapter;
        private final TypeAdapter<Entity> hotSponsorCardAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> infoAdapter;
        private final TypeAdapter<String> infoHtmlAdapter;
        private final TypeAdapter<SimpleInfo> innerInfoAdapter;
        private final TypeAdapter<Integer> isAnonymousAdapter;
        private final TypeAdapter<Integer> isHeadlineAdapter;
        private final TypeAdapter<Integer> isHeadlineCommentV8Adapter;
        private final TypeAdapter<Integer> isHeadlineV8Adapter;
        private final TypeAdapter<Integer> isHeadlinedAdapter;
        private final TypeAdapter<Integer> isHistoryAdapter;
        private final TypeAdapter<Integer> isHtmlArticleAdapter;
        private final TypeAdapter<Integer> isModifiedAdapter;
        private final TypeAdapter<Integer> isOwnerAdapter;
        private final TypeAdapter<Integer> isRecommendVoteCommentAdapter;
        private final TypeAdapter<Integer> isStickTopAdapter;
        private final TypeAdapter<String> keywordsAdapter;
        private final TypeAdapter<String> labelAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> likeAvatarAdapter;
        private final TypeAdapter<Integer> likeNumAdapter;
        private final TypeAdapter<Long> likeTimeAdapter;
        private final TypeAdapter<String> likeUidAdapter;
        private final TypeAdapter<UserInfo> likeUserInfoAdapter;
        private final TypeAdapter<String> likeUserNameAdapter;
        private final TypeAdapter<String> locationAdapter;
        private final TypeAdapter<String> longLocationAdapter;
        private final TypeAdapter<String> mediaInfoAdapter;
        private final TypeAdapter<String> mediaTypeAdapter;
        private final TypeAdapter<String> mediaUrlAdapter;
        private final TypeAdapter<String> messageAdapter;
        private final TypeAdapter<String> messageCoverAdapter;
        private final TypeAdapter<String> messageKeywordsAdapter;
        private final TypeAdapter<String> messageRawInputAdapter;
        private final TypeAdapter<String> messageRawOutputAdapter;
        private final TypeAdapter<String> messageSourceAdapter;
        private final TypeAdapter<Integer> messageStatusAdapter;
        private final TypeAdapter<String> messageStatusTextAdapter;
        private final TypeAdapter<String> messageTitleAdapter;
        private final TypeAdapter<Entity> noticeSponsorCardAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<List<String>> picArrayAdapter;
        private final TypeAdapter<Integer> questionAnswerNumAdapter;
        private final TypeAdapter<Integer> questionFollowNumAdapter;
        private final TypeAdapter<Float> ratingScore10Adapter;
        private final TypeAdapter<Float> ratingScore1Adapter;
        private final TypeAdapter<Float> ratingScore2Adapter;
        private final TypeAdapter<Float> ratingScore3Adapter;
        private final TypeAdapter<Float> ratingScore4Adapter;
        private final TypeAdapter<Float> ratingScore5Adapter;
        private final TypeAdapter<Float> ratingScore6Adapter;
        private final TypeAdapter<Float> ratingScore7Adapter;
        private final TypeAdapter<Float> ratingScore8Adapter;
        private final TypeAdapter<Float> ratingScore9Adapter;
        private final TypeAdapter<Float> ratingScoreAdapter;
        private final TypeAdapter<String> ratingTypeAdapter;
        private final TypeAdapter<List<String>> recentLikeListAdapter;
        private final TypeAdapter<List<FeedReply>> recentReplyRowsAdapter;
        private final TypeAdapter<Integer> recommendAdapter;
        private final TypeAdapter<List<RelatedData>> relatedDataAdapter;
        private final TypeAdapter<Integer> relatedNumAdapter;
        private final TypeAdapter<List<FeedRelation>> relationRowsAdapter;
        private final TypeAdapter<List<FeedReply>> replyMeRowsAdapter;
        private final TypeAdapter<Integer> replyNumAdapter;
        private final TypeAdapter<List<FeedReply>> replyRowsAdapter;
        private final TypeAdapter<SecondHandInfo> secondHandInfoAdapter;
        private final TypeAdapter<Integer> shareNumAdapter;
        private final TypeAdapter<String> shareUrlAdapter;
        private final TypeAdapter<Integer> showOwnerAdapter;
        private final TypeAdapter<String> sourceIdAdapter;
        private final TypeAdapter<String> spamContentAdapter;
        private final TypeAdapter<String> spamReasonAdapter;
        private final TypeAdapter<Long> spamTimeAdapter;
        private final TypeAdapter<Integer> starAdapter;
        private final TypeAdapter<Integer> statusAdapter;
        private final TypeAdapter<String> statusTextAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> tagsAdapter;
        private final TypeAdapter<FeedTarget> targetRowAdapter;
        private final TypeAdapter<String> tidAdapter;
        private final TypeAdapter<String> tinfoAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> tkeyAdapter;
        private final TypeAdapter<String> tlinkAdapter;
        private final TypeAdapter<SimpleInfo> topInfoAdapter;
        private final TypeAdapter<List<FeedReply>> topReplyRowsAdapter;
        private final TypeAdapter<String> tpicAdapter;
        private final TypeAdapter<String> ttypeAdapter;
        private final TypeAdapter<Integer> typeAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<UserAction> userActionAdapter;
        private final TypeAdapter<List<RelatedData>> userFollowListAdapter;
        private final TypeAdapter<UserInfo> userInfoAdapter;
        private final TypeAdapter<List<RelatedData>> userLikeListAdapter;
        private final TypeAdapter<String> userTagsAdapter;
        private final TypeAdapter<String> useragentAdapter;
        private final TypeAdapter<String> videoPicAdapter;
        private final TypeAdapter<String> videoUrlAdapter;
        private final TypeAdapter<Vote> voteAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.deprecatedUserAvatarAdapter = gson.getAdapter(String.class);
            this.userInfoAdapter = gson.getAdapter(UserInfo.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.deprecatedUserNameAdapter = gson.getAdapter(String.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.labelAdapter = gson.getAdapter(String.class);
            this.typeAdapter = gson.getAdapter(Integer.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.picArrayAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.infoHtmlAdapter = gson.getAdapter(String.class);
            this.infoAdapter = gson.getAdapter(String.class);
            this.forwardNumAdapter = gson.getAdapter(Integer.class);
            this.shareNumAdapter = gson.getAdapter(Integer.class);
            this.likeNumAdapter = gson.getAdapter(Integer.class);
            this.replyNumAdapter = gson.getAdapter(Integer.class);
            this.relatedNumAdapter = gson.getAdapter(Integer.class);
            this.followNumAdapter = gson.getAdapter(Integer.class);
            this.useragentAdapter = gson.getAdapter(String.class);
            this.articleIdAdapter = gson.getAdapter(String.class);
            this.statusAdapter = gson.getAdapter(Integer.class);
            this.messageAdapter = gson.getAdapter(String.class);
            this.isHtmlArticleAdapter = gson.getAdapter(Integer.class);
            this.isStickTopAdapter = gson.getAdapter(Integer.class);
            this.messageRawOutputAdapter = gson.getAdapter(String.class);
            this.messageRawInputAdapter = gson.getAdapter(String.class);
            this.feedTypeNameAdapter = gson.getAdapter(String.class);
            this.recommendAdapter = gson.getAdapter(Integer.class);
            this.favoriteNumAdapter = gson.getAdapter(Integer.class);
            this.commentBlockNumAdapter = gson.getAdapter(Integer.class);
            this.blockStatusAdapter = gson.getAdapter(Integer.class);
            this.feedFromTypeAdapter = gson.getAdapter(String.class);
            this.feedTypeAdapter = gson.getAdapter(String.class);
            this.fetchTypeAdapter = gson.getAdapter(String.class);
            this.replyRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, FeedReply.class));
            this.messageStatusAdapter = gson.getAdapter(Integer.class);
            this.relatedDataAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, RelatedData.class));
            this.userLikeListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, RelatedData.class));
            this.userFollowListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, RelatedData.class));
            this.deviceTitleAdapter = gson.getAdapter(String.class);
            this.collectionInfoAdapter = gson.getAdapter(Collection.class);
            this.collectionItemAdapter = gson.getAdapter(CollectionItem.class);
            this.userActionAdapter = gson.getAdapter(UserAction.class);
            this.replyMeRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, FeedReply.class));
            this.recentReplyRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, FeedReply.class));
            this.hotReplyRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, FeedReply.class));
            this.recentLikeListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.goodsListItemAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, GoodsListItem.class));
            this.forwardSourceFeedAdapter = gson.getAdapter(Feed.class);
            this.forwardSourceArticleAdapter = gson.getAdapter(DyhArticle.class);
            this.forwardSourceTypeAdapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.likeUserNameAdapter = gson.getAdapter(String.class);
            this.likeUidAdapter = gson.getAdapter(String.class);
            this.likeTimeAdapter = gson.getAdapter(Long.class);
            this.likeUserInfoAdapter = gson.getAdapter(UserInfo.class);
            this.likeAvatarAdapter = gson.getAdapter(String.class);
            this.forwardIdAdapter = gson.getAdapter(String.class);
            this.sourceIdAdapter = gson.getAdapter(String.class);
            this.spamReasonAdapter = gson.getAdapter(String.class);
            this.spamContentAdapter = gson.getAdapter(String.class);
            this.adminInfoAdapter = gson.getAdapter(String.class);
            this.statusTextAdapter = gson.getAdapter(String.class);
            this.messageStatusTextAdapter = gson.getAdapter(String.class);
            this.blockStatusTextAdapter = gson.getAdapter(String.class);
            this.isHeadlineAdapter = gson.getAdapter(Integer.class);
            this.isHeadlinedAdapter = gson.getAdapter(Integer.class);
            this.isHeadlineV8Adapter = gson.getAdapter(Integer.class);
            this.isHeadlineCommentV8Adapter = gson.getAdapter(Integer.class);
            this.spamTimeAdapter = gson.getAdapter(Long.class);
            this.appNameAdapter = gson.getAdapter(String.class);
            this.tkeyAdapter = gson.getAdapter(String.class);
            this.ttypeAdapter = gson.getAdapter(String.class);
            this.tidAdapter = gson.getAdapter(String.class);
            this.TUrlAdapter = gson.getAdapter(String.class);
            this.tpicAdapter = gson.getAdapter(String.class);
            this.tinfoAdapter = gson.getAdapter(String.class);
            this.tlinkAdapter = gson.getAdapter(String.class);
            this.relationRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, FeedRelation.class));
            this.targetRowAdapter = gson.getAdapter(FeedTarget.class);
            this.starAdapter = gson.getAdapter(Integer.class);
            this.fidAdapter = gson.getAdapter(String.class);
            this.dyhIdAdapter = gson.getAdapter(String.class);
            this.dyhNameAdapter = gson.getAdapter(String.class);
            this.userTagsAdapter = gson.getAdapter(String.class);
            this.keywordsAdapter = gson.getAdapter(String.class);
            this.extraKeyAdapter = gson.getAdapter(String.class);
            this.extraTitleAdapter = gson.getAdapter(String.class);
            this.extraTypeAdapter = gson.getAdapter(String.class);
            this.extraUrlAdapter = gson.getAdapter(String.class);
            this.extraInfoAdapter = gson.getAdapter(String.class);
            this.extraLinkUrlAdapter = gson.getAdapter(String.class);
            this.extraPicAdapter = gson.getAdapter(String.class);
            this.extraEntitiesAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, Entity.class));
            this.videoPicAdapter = gson.getAdapter(String.class);
            this.videoUrlAdapter = gson.getAdapter(String.class);
            this.locationAdapter = gson.getAdapter(String.class);
            this.longLocationAdapter = gson.getAdapter(String.class);
            this.messageTitleAdapter = gson.getAdapter(String.class);
            this.messageKeywordsAdapter = gson.getAdapter(String.class);
            this.messageCoverAdapter = gson.getAdapter(String.class);
            this.questionAnswerNumAdapter = gson.getAdapter(Integer.class);
            this.tagsAdapter = gson.getAdapter(String.class);
            this.messageSourceAdapter = gson.getAdapter(String.class);
            this.questionFollowNumAdapter = gson.getAdapter(Integer.class);
            this.dyhModelAdapter = gson.getAdapter(DyhModel.class);
            this.mediaInfoAdapter = gson.getAdapter(String.class);
            this.mediaUrlAdapter = gson.getAdapter(String.class);
            this.mediaTypeAdapter = gson.getAdapter(String.class);
            this.ratingTypeAdapter = gson.getAdapter(String.class);
            this.ratingScoreAdapter = gson.getAdapter(Float.class);
            this.ratingScore1Adapter = gson.getAdapter(Float.class);
            this.ratingScore2Adapter = gson.getAdapter(Float.class);
            this.ratingScore3Adapter = gson.getAdapter(Float.class);
            this.ratingScore4Adapter = gson.getAdapter(Float.class);
            this.ratingScore5Adapter = gson.getAdapter(Float.class);
            this.ratingScore6Adapter = gson.getAdapter(Float.class);
            this.ratingScore7Adapter = gson.getAdapter(Float.class);
            this.ratingScore8Adapter = gson.getAdapter(Float.class);
            this.ratingScore9Adapter = gson.getAdapter(Float.class);
            this.ratingScore10Adapter = gson.getAdapter(Float.class);
            this.commentGoodAdapter = gson.getAdapter(String.class);
            this.commentGoodPicAdapter = gson.getAdapter(String.class);
            this.commentBadAdapter = gson.getAdapter(String.class);
            this.commentBadPicAdapter = gson.getAdapter(String.class);
            this.commentGeneralAdapter = gson.getAdapter(String.class);
            this.commentGeneralPicAdapter = gson.getAdapter(String.class);
            this.extraFromApiAdapter = gson.getAdapter(String.class);
            this.shareUrlAdapter = gson.getAdapter(String.class);
            this.detailSponsorCardAdapter = gson.getAdapter(Entity.class);
            this.hotSponsorCardAdapter = gson.getAdapter(Entity.class);
            this.noticeSponsorCardAdapter = gson.getAdapter(Entity.class);
            this.buyStatusAdapter = gson.getAdapter(Integer.class);
            this.topReplyRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, FeedReply.class));
            this.goodsActionAdapter = gson.getAdapter(FeedGoodsAction.class);
            this.editorTitleAdapter = gson.getAdapter(String.class);
            this.isOwnerAdapter = gson.getAdapter(Integer.class);
            this.showOwnerAdapter = gson.getAdapter(Integer.class);
            this.isAnonymousAdapter = gson.getAdapter(Integer.class);
            this.voteAdapter = gson.getAdapter(Vote.class);
            this.secondHandInfoAdapter = gson.getAdapter(SecondHandInfo.class);
            this.isRecommendVoteCommentAdapter = gson.getAdapter(Integer.class);
            this.topInfoAdapter = gson.getAdapter(SimpleInfo.class);
            this.innerInfoAdapter = gson.getAdapter(SimpleInfo.class);
            this.isModifiedAdapter = gson.getAdapter(Integer.class);
            this.enableModifyAdapter = gson.getAdapter(Integer.class);
            this.isHistoryAdapter = gson.getAdapter(Integer.class);
        }

        public GsonTypeAdapter setDefaultEntityTypeName(String str) {
            this.defaultEntityTypeName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityType(String str) {
            this.defaultEntityType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityTemplate(String str) {
            this.defaultEntityTemplate = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityId(String str) {
            this.defaultEntityId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityFixed(Integer num) {
            this.defaultEntityFixed = num;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSubTitle(String str) {
            this.defaultSubTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraData(String str) {
            this.defaultExtraData = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDateline(Long l2) {
            this.defaultDateline = l2;
            return this;
        }

        public GsonTypeAdapter setDefaultLastUpdate(Long l2) {
            this.defaultLastUpdate = l2;
            return this;
        }

        public GsonTypeAdapter setDefaultDeprecatedUserAvatar(String str) {
            this.defaultDeprecatedUserAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserInfo(UserInfo userInfo) {
            this.defaultUserInfo = userInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDeprecatedUserName(String str) {
            this.defaultDeprecatedUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDisplayUserName(String str) {
            this.defaultDisplayUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLabel(String str) {
            this.defaultLabel = str;
            return this;
        }

        public GsonTypeAdapter setDefaultType(int i) {
            this.defaultType = i;
            return this;
        }

        public GsonTypeAdapter setDefaultPic(String str) {
            this.defaultPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPicArray(List<String> list) {
            this.defaultPicArray = list;
            return this;
        }

        public GsonTypeAdapter setDefaultInfoHtml(String str) {
            this.defaultInfoHtml = str;
            return this;
        }

        public GsonTypeAdapter setDefaultInfo(String str) {
            this.defaultInfo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultForwardNum(int i) {
            this.defaultForwardNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultShareNum(int i) {
            this.defaultShareNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultLikeNum(int i) {
            this.defaultLikeNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyNum(int i) {
            this.defaultReplyNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRelatedNum(int i) {
            this.defaultRelatedNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFollowNum(int i) {
            this.defaultFollowNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUseragent(String str) {
            this.defaultUseragent = str;
            return this;
        }

        public GsonTypeAdapter setDefaultArticleId(String str) {
            this.defaultArticleId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultStatus(int i) {
            this.defaultStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultMessage(String str) {
            this.defaultMessage = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsHtmlArticle(int i) {
            this.defaultIsHtmlArticle = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsStickTop(int i) {
            this.defaultIsStickTop = i;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageRawOutput(String str) {
            this.defaultMessageRawOutput = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageRawInput(String str) {
            this.defaultMessageRawInput = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedTypeName(String str) {
            this.defaultFeedTypeName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRecommend(int i) {
            this.defaultRecommend = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFavoriteNum(int i) {
            this.defaultFavoriteNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentBlockNum(int i) {
            this.defaultCommentBlockNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultBlockStatus(int i) {
            this.defaultBlockStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedFromType(String str) {
            this.defaultFeedFromType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedType(String str) {
            this.defaultFeedType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFetchType(String str) {
            this.defaultFetchType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyRows(List<FeedReply> list) {
            this.defaultReplyRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageStatus(int i) {
            this.defaultMessageStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRelatedData(List<RelatedData> list) {
            this.defaultRelatedData = list;
            return this;
        }

        public GsonTypeAdapter setDefaultUserLikeList(List<RelatedData> list) {
            this.defaultUserLikeList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultUserFollowList(List<RelatedData> list) {
            this.defaultUserFollowList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultDeviceTitle(String str) {
            this.defaultDeviceTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCollectionInfo(Collection collection) {
            this.defaultCollectionInfo = collection;
            return this;
        }

        public GsonTypeAdapter setDefaultCollectionItem(CollectionItem collectionItem) {
            this.defaultCollectionItem = collectionItem;
            return this;
        }

        public GsonTypeAdapter setDefaultUserAction(UserAction userAction) {
            this.defaultUserAction = userAction;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyMeRows(List<FeedReply> list) {
            this.defaultReplyMeRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultRecentReplyRows(List<FeedReply> list) {
            this.defaultRecentReplyRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultHotReplyRows(List<FeedReply> list) {
            this.defaultHotReplyRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultRecentLikeList(List<String> list) {
            this.defaultRecentLikeList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultGoodsListItem(List<GoodsListItem> list) {
            this.defaultGoodsListItem = list;
            return this;
        }

        public GsonTypeAdapter setDefaultForwardSourceFeed(Feed feed) {
            this.defaultForwardSourceFeed = feed;
            return this;
        }

        public GsonTypeAdapter setDefaultForwardSourceArticle(DyhArticle dyhArticle) {
            this.defaultForwardSourceArticle = dyhArticle;
            return this;
        }

        public GsonTypeAdapter setDefaultForwardSourceType(String str) {
            this.defaultForwardSourceType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLikeUserName(String str) {
            this.defaultLikeUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLikeUid(String str) {
            this.defaultLikeUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLikeTime(long j) {
            this.defaultLikeTime = j;
            return this;
        }

        public GsonTypeAdapter setDefaultLikeUserInfo(UserInfo userInfo) {
            this.defaultLikeUserInfo = userInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultLikeAvatar(String str) {
            this.defaultLikeAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultForwardId(String str) {
            this.defaultForwardId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSourceId(String str) {
            this.defaultSourceId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSpamReason(String str) {
            this.defaultSpamReason = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSpamContent(String str) {
            this.defaultSpamContent = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAdminInfo(String str) {
            this.defaultAdminInfo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultStatusText(String str) {
            this.defaultStatusText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageStatusText(String str) {
            this.defaultMessageStatusText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultBlockStatusText(String str) {
            this.defaultBlockStatusText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsHeadline(int i) {
            this.defaultIsHeadline = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsHeadlined(int i) {
            this.defaultIsHeadlined = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsHeadlineV8(int i) {
            this.defaultIsHeadlineV8 = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsHeadlineCommentV8(int i) {
            this.defaultIsHeadlineCommentV8 = i;
            return this;
        }

        public GsonTypeAdapter setDefaultSpamTime(long j) {
            this.defaultSpamTime = j;
            return this;
        }

        public GsonTypeAdapter setDefaultAppName(String str) {
            this.defaultAppName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTkey(String str) {
            this.defaultTkey = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTtype(String str) {
            this.defaultTtype = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTid(String str) {
            this.defaultTid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTUrl(String str) {
            this.defaultTUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTpic(String str) {
            this.defaultTpic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTinfo(String str) {
            this.defaultTinfo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTlink(String str) {
            this.defaultTlink = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRelationRows(List<FeedRelation> list) {
            this.defaultRelationRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultTargetRow(FeedTarget feedTarget) {
            this.defaultTargetRow = feedTarget;
            return this;
        }

        public GsonTypeAdapter setDefaultStar(int i) {
            this.defaultStar = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFid(String str) {
            this.defaultFid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDyhId(String str) {
            this.defaultDyhId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDyhName(String str) {
            this.defaultDyhName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserTags(String str) {
            this.defaultUserTags = str;
            return this;
        }

        public GsonTypeAdapter setDefaultKeywords(String str) {
            this.defaultKeywords = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraKey(String str) {
            this.defaultExtraKey = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraTitle(String str) {
            this.defaultExtraTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraType(String str) {
            this.defaultExtraType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraUrl(String str) {
            this.defaultExtraUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraInfo(String str) {
            this.defaultExtraInfo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraLinkUrl(String str) {
            this.defaultExtraLinkUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraPic(String str) {
            this.defaultExtraPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraEntities(List<Entity> list) {
            this.defaultExtraEntities = list;
            return this;
        }

        public GsonTypeAdapter setDefaultVideoPic(String str) {
            this.defaultVideoPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVideoUrl(String str) {
            this.defaultVideoUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLocation(String str) {
            this.defaultLocation = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLongLocation(String str) {
            this.defaultLongLocation = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageTitle(String str) {
            this.defaultMessageTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageKeywords(String str) {
            this.defaultMessageKeywords = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageCover(String str) {
            this.defaultMessageCover = str;
            return this;
        }

        public GsonTypeAdapter setDefaultQuestionAnswerNum(int i) {
            this.defaultQuestionAnswerNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultTags(String str) {
            this.defaultTags = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageSource(String str) {
            this.defaultMessageSource = str;
            return this;
        }

        public GsonTypeAdapter setDefaultQuestionFollowNum(int i) {
            this.defaultQuestionFollowNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDyhModel(DyhModel dyhModel) {
            this.defaultDyhModel = dyhModel;
            return this;
        }

        public GsonTypeAdapter setDefaultMediaInfo(String str) {
            this.defaultMediaInfo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMediaUrl(String str) {
            this.defaultMediaUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMediaType(String str) {
            this.defaultMediaType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingType(String str) {
            this.defaultRatingType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingScore(float f) {
            this.defaultRatingScore = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingScore1(float f) {
            this.defaultRatingScore1 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingScore2(float f) {
            this.defaultRatingScore2 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingScore3(float f) {
            this.defaultRatingScore3 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingScore4(float f) {
            this.defaultRatingScore4 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingScore5(float f) {
            this.defaultRatingScore5 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingScore6(float f) {
            this.defaultRatingScore6 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingScore7(float f) {
            this.defaultRatingScore7 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingScore8(float f) {
            this.defaultRatingScore8 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingScore9(float f) {
            this.defaultRatingScore9 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingScore10(float f) {
            this.defaultRatingScore10 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentGood(String str) {
            this.defaultCommentGood = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentGoodPic(String str) {
            this.defaultCommentGoodPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentBad(String str) {
            this.defaultCommentBad = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentBadPic(String str) {
            this.defaultCommentBadPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentGeneral(String str) {
            this.defaultCommentGeneral = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentGeneralPic(String str) {
            this.defaultCommentGeneralPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraFromApi(String str) {
            this.defaultExtraFromApi = str;
            return this;
        }

        public GsonTypeAdapter setDefaultShareUrl(String str) {
            this.defaultShareUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDetailSponsorCard(Entity entity) {
            this.defaultDetailSponsorCard = entity;
            return this;
        }

        public GsonTypeAdapter setDefaultHotSponsorCard(Entity entity) {
            this.defaultHotSponsorCard = entity;
            return this;
        }

        public GsonTypeAdapter setDefaultNoticeSponsorCard(Entity entity) {
            this.defaultNoticeSponsorCard = entity;
            return this;
        }

        public GsonTypeAdapter setDefaultBuyStatus(int i) {
            this.defaultBuyStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultTopReplyRows(List<FeedReply> list) {
            this.defaultTopReplyRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultGoodsAction(FeedGoodsAction feedGoodsAction) {
            this.defaultGoodsAction = feedGoodsAction;
            return this;
        }

        public GsonTypeAdapter setDefaultEditorTitle(String str) {
            this.defaultEditorTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsOwner(int i) {
            this.defaultIsOwner = i;
            return this;
        }

        public GsonTypeAdapter setDefaultShowOwner(int i) {
            this.defaultShowOwner = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsAnonymous(int i) {
            this.defaultIsAnonymous = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVote(Vote vote) {
            this.defaultVote = vote;
            return this;
        }

        public GsonTypeAdapter setDefaultSecondHandInfo(SecondHandInfo secondHandInfo) {
            this.defaultSecondHandInfo = secondHandInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultIsRecommendVoteComment(int i) {
            this.defaultIsRecommendVoteComment = i;
            return this;
        }

        public GsonTypeAdapter setDefaultTopInfo(SimpleInfo simpleInfo) {
            this.defaultTopInfo = simpleInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultInnerInfo(SimpleInfo simpleInfo) {
            this.defaultInnerInfo = simpleInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultIsModified(int i) {
            this.defaultIsModified = i;
            return this;
        }

        public GsonTypeAdapter setDefaultEnableModify(int i) {
            this.defaultEnableModify = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsHistory(int i) {
            this.defaultIsHistory = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, Feed feed) throws IOException {
            if (feed == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, feed.getEntityTypeName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, feed.getEntityType());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, feed.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, feed.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, feed.getEntityFixed());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, feed.getDescription());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, feed.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, feed.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, feed.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, feed.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, feed.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, feed.getUserInfo());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, feed.getUid());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, feed.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, feed.getDisplayUserName());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, feed.getTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, feed.getId());
            jsonWriter.name("label");
            this.labelAdapter.write(jsonWriter, feed.getLabel());
            jsonWriter.name("type");
            this.typeAdapter.write(jsonWriter, Integer.valueOf(feed.getType()));
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, feed.getPic());
            jsonWriter.name("picArr");
            this.picArrayAdapter.write(jsonWriter, feed.getPicArray());
            jsonWriter.name("infoHtml");
            this.infoHtmlAdapter.write(jsonWriter, feed.getInfoHtml());
            jsonWriter.name("info");
            this.infoAdapter.write(jsonWriter, feed.getInfo());
            jsonWriter.name("forwardnum");
            this.forwardNumAdapter.write(jsonWriter, Integer.valueOf(feed.getForwardNum()));
            jsonWriter.name("share_num");
            this.shareNumAdapter.write(jsonWriter, Integer.valueOf(feed.getShareNum()));
            jsonWriter.name("likenum");
            this.likeNumAdapter.write(jsonWriter, Integer.valueOf(feed.getLikeNum()));
            jsonWriter.name("replynum");
            this.replyNumAdapter.write(jsonWriter, Integer.valueOf(feed.getReplyNum()));
            jsonWriter.name("relatednum");
            this.relatedNumAdapter.write(jsonWriter, Integer.valueOf(feed.getRelatedNum()));
            jsonWriter.name("follownum");
            this.followNumAdapter.write(jsonWriter, Integer.valueOf(feed.getFollowNum()));
            jsonWriter.name("useragent");
            this.useragentAdapter.write(jsonWriter, feed.getUseragent());
            jsonWriter.name("articleId");
            this.articleIdAdapter.write(jsonWriter, feed.getArticleId());
            jsonWriter.name("status");
            this.statusAdapter.write(jsonWriter, Integer.valueOf(feed.getStatus()));
            jsonWriter.name("message");
            this.messageAdapter.write(jsonWriter, feed.getMessage());
            jsonWriter.name("is_html_article");
            this.isHtmlArticleAdapter.write(jsonWriter, Integer.valueOf(feed.getIsHtmlArticle()));
            jsonWriter.name("isStickTop");
            this.isStickTopAdapter.write(jsonWriter, Integer.valueOf(feed.getIsStickTop()));
            jsonWriter.name("message_raw_output");
            this.messageRawOutputAdapter.write(jsonWriter, feed.getMessageRawOutput());
            jsonWriter.name("message_raw_input");
            this.messageRawInputAdapter.write(jsonWriter, feed.getMessageRawInput());
            jsonWriter.name("feedTypeName");
            this.feedTypeNameAdapter.write(jsonWriter, feed.getFeedTypeName());
            jsonWriter.name("recommend");
            this.recommendAdapter.write(jsonWriter, Integer.valueOf(feed.getRecommend()));
            jsonWriter.name("favnum");
            this.favoriteNumAdapter.write(jsonWriter, Integer.valueOf(feed.getFavoriteNum()));
            jsonWriter.name("comment_block_num");
            this.commentBlockNumAdapter.write(jsonWriter, Integer.valueOf(feed.getCommentBlockNum()));
            jsonWriter.name("block_status");
            this.blockStatusAdapter.write(jsonWriter, Integer.valueOf(feed.getBlockStatus()));
            jsonWriter.name("feedFromType");
            this.feedFromTypeAdapter.write(jsonWriter, feed.getFeedFromType());
            jsonWriter.name("feedType");
            this.feedTypeAdapter.write(jsonWriter, feed.getFeedType());
            jsonWriter.name("fetchType");
            this.fetchTypeAdapter.write(jsonWriter, feed.getFetchType());
            jsonWriter.name("replyRows");
            this.replyRowsAdapter.write(jsonWriter, feed.getReplyRows());
            jsonWriter.name("message_status");
            this.messageStatusAdapter.write(jsonWriter, Integer.valueOf(feed.getMessageStatus()));
            jsonWriter.name("relatedata");
            this.relatedDataAdapter.write(jsonWriter, feed.getRelatedData());
            jsonWriter.name("userLikeList");
            this.userLikeListAdapter.write(jsonWriter, feed.getUserLikeList());
            jsonWriter.name("userFollowList");
            this.userFollowListAdapter.write(jsonWriter, feed.getUserFollowList());
            jsonWriter.name("device_title");
            this.deviceTitleAdapter.write(jsonWriter, feed.getDeviceTitle());
            jsonWriter.name("collection_info");
            this.collectionInfoAdapter.write(jsonWriter, feed.getCollectionInfo());
            jsonWriter.name("collection_item_info");
            this.collectionItemAdapter.write(jsonWriter, feed.getCollectionItem());
            jsonWriter.name("userAction");
            this.userActionAdapter.write(jsonWriter, feed.getUserAction());
            jsonWriter.name("replyMeRows");
            this.replyMeRowsAdapter.write(jsonWriter, feed.getReplyMeRows());
            jsonWriter.name("recentReplyRows");
            this.recentReplyRowsAdapter.write(jsonWriter, feed.getRecentReplyRows());
            jsonWriter.name("hotReplyRows");
            this.hotReplyRowsAdapter.write(jsonWriter, feed.getHotReplyRows());
            jsonWriter.name("recentLikeList");
            this.recentLikeListAdapter.write(jsonWriter, feed.getRecentLikeList());
            jsonWriter.name("goodsListItem");
            this.goodsListItemAdapter.write(jsonWriter, feed.getGoodsListItem());
            jsonWriter.name("forwardSourceFeed");
            this.forwardSourceFeedAdapter.write(jsonWriter, feed.getForwardSourceFeed());
            jsonWriter.name("forwardSourceArticle");
            this.forwardSourceArticleAdapter.write(jsonWriter, feed.getForwardSourceArticle());
            jsonWriter.name("forwardSourceType");
            this.forwardSourceTypeAdapter.write(jsonWriter, feed.getForwardSourceType());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, feed.getUrl());
            jsonWriter.name("likeUsername");
            this.likeUserNameAdapter.write(jsonWriter, feed.getLikeUserName());
            jsonWriter.name("likeUid");
            this.likeUidAdapter.write(jsonWriter, feed.getLikeUid());
            jsonWriter.name("likeTime");
            this.likeTimeAdapter.write(jsonWriter, Long.valueOf(feed.getLikeTime()));
            jsonWriter.name("likeUserInfo");
            this.likeUserInfoAdapter.write(jsonWriter, feed.getLikeUserInfo());
            jsonWriter.name("likeAvatar");
            this.likeAvatarAdapter.write(jsonWriter, feed.getLikeAvatar());
            jsonWriter.name("forwardid");
            this.forwardIdAdapter.write(jsonWriter, feed.getForwardId());
            jsonWriter.name("source_id");
            this.sourceIdAdapter.write(jsonWriter, feed.getSourceId());
            jsonWriter.name("spamReason");
            this.spamReasonAdapter.write(jsonWriter, feed.getSpamReason());
            jsonWriter.name("spamContent");
            this.spamContentAdapter.write(jsonWriter, feed.getSpamContent());
            jsonWriter.name("adminInfo");
            this.adminInfoAdapter.write(jsonWriter, feed.getAdminInfo());
            jsonWriter.name("statusText");
            this.statusTextAdapter.write(jsonWriter, feed.getStatusText());
            jsonWriter.name("messageStatusText");
            this.messageStatusTextAdapter.write(jsonWriter, feed.getMessageStatusText());
            jsonWriter.name("blockStatusText");
            this.blockStatusTextAdapter.write(jsonWriter, feed.getBlockStatusText());
            jsonWriter.name("isHeadline");
            this.isHeadlineAdapter.write(jsonWriter, Integer.valueOf(feed.getIsHeadline()));
            jsonWriter.name("is_headline");
            this.isHeadlinedAdapter.write(jsonWriter, Integer.valueOf(feed.getIsHeadlined()));
            jsonWriter.name("isHeadlineV8");
            this.isHeadlineV8Adapter.write(jsonWriter, Integer.valueOf(feed.getIsHeadlineV8()));
            jsonWriter.name("isHeadlineCommentV8");
            this.isHeadlineCommentV8Adapter.write(jsonWriter, Integer.valueOf(feed.getIsHeadlineCommentV8()));
            jsonWriter.name("spamTime");
            this.spamTimeAdapter.write(jsonWriter, Long.valueOf(feed.getSpamTime()));
            jsonWriter.name("ttitle");
            this.appNameAdapter.write(jsonWriter, feed.getAppName());
            jsonWriter.name("tkey");
            this.tkeyAdapter.write(jsonWriter, feed.getTkey());
            jsonWriter.name("ttype");
            this.ttypeAdapter.write(jsonWriter, feed.getTtype());
            jsonWriter.name("tid");
            this.tidAdapter.write(jsonWriter, feed.getTid());
            jsonWriter.name("turl");
            this.TUrlAdapter.write(jsonWriter, feed.getTUrl());
            jsonWriter.name("tpic");
            this.tpicAdapter.write(jsonWriter, feed.getTpic());
            jsonWriter.name("tinfo");
            this.tinfoAdapter.write(jsonWriter, feed.getTinfo());
            jsonWriter.name("tlink");
            this.tlinkAdapter.write(jsonWriter, feed.getTlink());
            jsonWriter.name("relationRows");
            this.relationRowsAdapter.write(jsonWriter, feed.getRelationRows());
            jsonWriter.name("targetRow");
            this.targetRowAdapter.write(jsonWriter, feed.getTargetRow());
            jsonWriter.name("star");
            this.starAdapter.write(jsonWriter, Integer.valueOf(feed.getStar()));
            jsonWriter.name("fid");
            this.fidAdapter.write(jsonWriter, feed.getFid());
            jsonWriter.name("dyh_id");
            this.dyhIdAdapter.write(jsonWriter, feed.getDyhId());
            jsonWriter.name("dyh_name");
            this.dyhNameAdapter.write(jsonWriter, feed.getDyhName());
            jsonWriter.name("user_tags");
            this.userTagsAdapter.write(jsonWriter, feed.getUserTags());
            jsonWriter.name("keywords");
            this.keywordsAdapter.write(jsonWriter, feed.getKeywords());
            jsonWriter.name("extra_key");
            this.extraKeyAdapter.write(jsonWriter, feed.getExtraKey());
            jsonWriter.name("extra_title");
            this.extraTitleAdapter.write(jsonWriter, feed.getExtraTitle());
            jsonWriter.name("extra_type");
            this.extraTypeAdapter.write(jsonWriter, feed.getExtraType());
            jsonWriter.name("extra_url");
            this.extraUrlAdapter.write(jsonWriter, feed.getExtraUrl());
            jsonWriter.name("extra_info");
            this.extraInfoAdapter.write(jsonWriter, feed.getExtraInfo());
            jsonWriter.name("extra_link_url");
            this.extraLinkUrlAdapter.write(jsonWriter, feed.getExtraLinkUrl());
            jsonWriter.name("extra_pic");
            this.extraPicAdapter.write(jsonWriter, feed.getExtraPic());
            jsonWriter.name("extra_entities");
            this.extraEntitiesAdapter.write(jsonWriter, feed.getExtraEntities());
            jsonWriter.name("video_pic");
            this.videoPicAdapter.write(jsonWriter, feed.getVideoPic());
            jsonWriter.name("video_url");
            this.videoUrlAdapter.write(jsonWriter, feed.getVideoUrl());
            jsonWriter.name("location");
            this.locationAdapter.write(jsonWriter, feed.getLocation());
            jsonWriter.name("long_location");
            this.longLocationAdapter.write(jsonWriter, feed.getLongLocation());
            jsonWriter.name("message_title");
            this.messageTitleAdapter.write(jsonWriter, feed.getMessageTitle());
            jsonWriter.name("message_keywords");
            this.messageKeywordsAdapter.write(jsonWriter, feed.getMessageKeywords());
            jsonWriter.name("message_cover");
            this.messageCoverAdapter.write(jsonWriter, feed.getMessageCover());
            jsonWriter.name("question_answer_num");
            this.questionAnswerNumAdapter.write(jsonWriter, Integer.valueOf(feed.getQuestionAnswerNum()));
            jsonWriter.name("tags");
            this.tagsAdapter.write(jsonWriter, feed.getTags());
            jsonWriter.name("messagesource");
            this.messageSourceAdapter.write(jsonWriter, feed.getMessageSource());
            jsonWriter.name("question_follow_num");
            this.questionFollowNumAdapter.write(jsonWriter, Integer.valueOf(feed.getQuestionFollowNum()));
            jsonWriter.name("dyh_info");
            this.dyhModelAdapter.write(jsonWriter, feed.getDyhModel());
            jsonWriter.name("media_info");
            this.mediaInfoAdapter.write(jsonWriter, feed.getMediaInfo());
            jsonWriter.name("media_url");
            this.mediaUrlAdapter.write(jsonWriter, feed.getMediaUrl());
            jsonWriter.name("media_type");
            this.mediaTypeAdapter.write(jsonWriter, feed.getMediaType());
            jsonWriter.name("rating_type");
            this.ratingTypeAdapter.write(jsonWriter, feed.getRatingType());
            jsonWriter.name("rating_score");
            this.ratingScoreAdapter.write(jsonWriter, Float.valueOf(feed.getRatingScore()));
            jsonWriter.name("rating_score_1");
            this.ratingScore1Adapter.write(jsonWriter, Float.valueOf(feed.getRatingScore1()));
            jsonWriter.name("rating_score_2");
            this.ratingScore2Adapter.write(jsonWriter, Float.valueOf(feed.getRatingScore2()));
            jsonWriter.name("rating_score_3");
            this.ratingScore3Adapter.write(jsonWriter, Float.valueOf(feed.getRatingScore3()));
            jsonWriter.name("rating_score_4");
            this.ratingScore4Adapter.write(jsonWriter, Float.valueOf(feed.getRatingScore4()));
            jsonWriter.name("rating_score_5");
            this.ratingScore5Adapter.write(jsonWriter, Float.valueOf(feed.getRatingScore5()));
            jsonWriter.name("rating_score_6");
            this.ratingScore6Adapter.write(jsonWriter, Float.valueOf(feed.getRatingScore6()));
            jsonWriter.name("rating_score_7");
            this.ratingScore7Adapter.write(jsonWriter, Float.valueOf(feed.getRatingScore7()));
            jsonWriter.name("rating_score_8");
            this.ratingScore8Adapter.write(jsonWriter, Float.valueOf(feed.getRatingScore8()));
            jsonWriter.name("rating_score_9");
            this.ratingScore9Adapter.write(jsonWriter, Float.valueOf(feed.getRatingScore9()));
            jsonWriter.name("rating_score_10");
            this.ratingScore10Adapter.write(jsonWriter, Float.valueOf(feed.getRatingScore10()));
            jsonWriter.name("comment_good");
            this.commentGoodAdapter.write(jsonWriter, feed.getCommentGood());
            jsonWriter.name("comment_good_pic");
            this.commentGoodPicAdapter.write(jsonWriter, feed.getCommentGoodPic());
            jsonWriter.name("comment_bad");
            this.commentBadAdapter.write(jsonWriter, feed.getCommentBad());
            jsonWriter.name("comment_bad_pic");
            this.commentBadPicAdapter.write(jsonWriter, feed.getCommentBadPic());
            jsonWriter.name("comment_general");
            this.commentGeneralAdapter.write(jsonWriter, feed.getCommentGeneral());
            jsonWriter.name("comment_general_pic");
            this.commentGeneralPicAdapter.write(jsonWriter, feed.getCommentGeneralPic());
            jsonWriter.name("extra_fromApi");
            this.extraFromApiAdapter.write(jsonWriter, feed.getExtraFromApi());
            jsonWriter.name("shareUrl");
            this.shareUrlAdapter.write(jsonWriter, feed.getShareUrl());
            jsonWriter.name("detailSponsorCard");
            this.detailSponsorCardAdapter.write(jsonWriter, feed.getDetailSponsorCard());
            jsonWriter.name("hotSponsorCard");
            this.hotSponsorCardAdapter.write(jsonWriter, feed.getHotSponsorCard());
            jsonWriter.name("noticeSponsorCard");
            this.noticeSponsorCardAdapter.write(jsonWriter, feed.getNoticeSponsorCard());
            jsonWriter.name("buy_status");
            this.buyStatusAdapter.write(jsonWriter, Integer.valueOf(feed.getBuyStatus()));
            jsonWriter.name("topReplyRows");
            this.topReplyRowsAdapter.write(jsonWriter, feed.getTopReplyRows());
            jsonWriter.name("goods");
            this.goodsActionAdapter.write(jsonWriter, feed.getGoodsAction());
            jsonWriter.name("editor_title");
            this.editorTitleAdapter.write(jsonWriter, feed.getEditorTitle());
            jsonWriter.name("is_owner");
            this.isOwnerAdapter.write(jsonWriter, Integer.valueOf(feed.getIsOwner()));
            jsonWriter.name("show_owner");
            this.showOwnerAdapter.write(jsonWriter, Integer.valueOf(feed.getShowOwner()));
            jsonWriter.name("is_anonymous");
            this.isAnonymousAdapter.write(jsonWriter, Integer.valueOf(feed.getIsAnonymous()));
            jsonWriter.name("vote");
            this.voteAdapter.write(jsonWriter, feed.getVote());
            jsonWriter.name("ershou_info");
            this.secondHandInfoAdapter.write(jsonWriter, feed.getSecondHandInfo());
            jsonWriter.name("is_recommend_vote_comment");
            this.isRecommendVoteCommentAdapter.write(jsonWriter, Integer.valueOf(feed.getIsRecommendVoteComment()));
            jsonWriter.name("topInfo");
            this.topInfoAdapter.write(jsonWriter, feed.getTopInfo());
            jsonWriter.name("innerInfo");
            this.innerInfoAdapter.write(jsonWriter, feed.getInnerInfo());
            jsonWriter.name("isModified");
            this.isModifiedAdapter.write(jsonWriter, Integer.valueOf(feed.getIsModified()));
            jsonWriter.name("enableModify");
            this.enableModifyAdapter.write(jsonWriter, Integer.valueOf(feed.getEnableModify()));
            jsonWriter.name("isHistory");
            this.isHistoryAdapter.write(jsonWriter, Integer.valueOf(feed.getIsHistory()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Feed read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityType;
            String str3 = this.defaultEntityTemplate;
            String str4 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str5 = this.defaultDescription;
            String str6 = this.defaultSubTitle;
            String str7 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str8 = this.defaultDeprecatedUserAvatar;
            UserInfo userInfo = this.defaultUserInfo;
            String str9 = this.defaultUid;
            String str10 = this.defaultDeprecatedUserName;
            String str11 = this.defaultDisplayUserName;
            String str12 = this.defaultTitle;
            String str13 = this.defaultId;
            String str14 = this.defaultLabel;
            int i = this.defaultType;
            String str15 = this.defaultPic;
            List<String> list = this.defaultPicArray;
            String str16 = this.defaultInfoHtml;
            String str17 = this.defaultInfo;
            int i2 = this.defaultForwardNum;
            int i3 = this.defaultShareNum;
            int i4 = this.defaultLikeNum;
            int i5 = this.defaultReplyNum;
            int i6 = this.defaultRelatedNum;
            int i7 = this.defaultFollowNum;
            String str18 = this.defaultUseragent;
            String str19 = this.defaultArticleId;
            int i8 = this.defaultStatus;
            String str20 = this.defaultMessage;
            int i9 = this.defaultIsHtmlArticle;
            int i10 = this.defaultIsStickTop;
            String str21 = this.defaultMessageRawOutput;
            String str22 = this.defaultMessageRawInput;
            String str23 = this.defaultFeedTypeName;
            int i11 = this.defaultRecommend;
            int i12 = this.defaultFavoriteNum;
            int i13 = this.defaultCommentBlockNum;
            int i14 = this.defaultBlockStatus;
            String str24 = this.defaultFeedFromType;
            String str25 = this.defaultFeedType;
            String str26 = this.defaultFetchType;
            List<FeedReply> list2 = this.defaultReplyRows;
            int i15 = this.defaultMessageStatus;
            List<RelatedData> list3 = this.defaultRelatedData;
            List<RelatedData> list4 = this.defaultUserLikeList;
            List<RelatedData> list5 = this.defaultUserFollowList;
            String str27 = this.defaultDeviceTitle;
            Collection collection = this.defaultCollectionInfo;
            CollectionItem collectionItem = this.defaultCollectionItem;
            UserAction userAction = this.defaultUserAction;
            List<FeedReply> list6 = this.defaultReplyMeRows;
            List<FeedReply> list7 = this.defaultRecentReplyRows;
            List<FeedReply> list8 = this.defaultHotReplyRows;
            List<String> list9 = this.defaultRecentLikeList;
            List<GoodsListItem> list10 = this.defaultGoodsListItem;
            Feed feed = this.defaultForwardSourceFeed;
            DyhArticle dyhArticle = this.defaultForwardSourceArticle;
            String str28 = this.defaultForwardSourceType;
            String str29 = this.defaultUrl;
            String str30 = this.defaultLikeUserName;
            String str31 = this.defaultLikeUid;
            long j = this.defaultLikeTime;
            UserInfo userInfo2 = this.defaultLikeUserInfo;
            String str32 = this.defaultLikeAvatar;
            String str33 = this.defaultForwardId;
            String str34 = this.defaultSourceId;
            String str35 = this.defaultSpamReason;
            String str36 = this.defaultSpamContent;
            String str37 = this.defaultAdminInfo;
            String str38 = this.defaultStatusText;
            String str39 = this.defaultMessageStatusText;
            String str40 = this.defaultBlockStatusText;
            int i16 = this.defaultIsHeadline;
            int i17 = this.defaultIsHeadlined;
            int i18 = this.defaultIsHeadlineV8;
            int i19 = this.defaultIsHeadlineCommentV8;
            long j2 = this.defaultSpamTime;
            String str41 = this.defaultAppName;
            String str42 = this.defaultTkey;
            String str43 = this.defaultTtype;
            String str44 = this.defaultTid;
            String str45 = this.defaultTUrl;
            String str46 = this.defaultTpic;
            String str47 = this.defaultTinfo;
            String str48 = this.defaultTlink;
            List<FeedRelation> list11 = this.defaultRelationRows;
            FeedTarget feedTarget = this.defaultTargetRow;
            int i20 = this.defaultStar;
            String str49 = this.defaultFid;
            String str50 = this.defaultDyhId;
            String str51 = this.defaultDyhName;
            String str52 = this.defaultUserTags;
            String str53 = this.defaultKeywords;
            String str54 = this.defaultExtraKey;
            String str55 = this.defaultExtraTitle;
            String str56 = this.defaultExtraType;
            String str57 = this.defaultExtraUrl;
            String str58 = this.defaultExtraInfo;
            String str59 = this.defaultExtraLinkUrl;
            String str60 = this.defaultExtraPic;
            List<Entity> list12 = this.defaultExtraEntities;
            String str61 = this.defaultVideoPic;
            String str62 = this.defaultVideoUrl;
            String str63 = this.defaultLocation;
            String str64 = this.defaultLongLocation;
            String str65 = this.defaultMessageTitle;
            String str66 = this.defaultMessageKeywords;
            String str67 = this.defaultMessageCover;
            int i21 = this.defaultQuestionAnswerNum;
            String str68 = this.defaultTags;
            String str69 = this.defaultMessageSource;
            int i22 = this.defaultQuestionFollowNum;
            DyhModel dyhModel = this.defaultDyhModel;
            String str70 = this.defaultMediaInfo;
            String str71 = this.defaultMediaUrl;
            String str72 = this.defaultMediaType;
            String str73 = this.defaultRatingType;
            float f = this.defaultRatingScore;
            float f2 = this.defaultRatingScore1;
            float f3 = this.defaultRatingScore2;
            float f4 = this.defaultRatingScore3;
            float f5 = this.defaultRatingScore4;
            float f6 = this.defaultRatingScore5;
            float f7 = this.defaultRatingScore6;
            float f8 = this.defaultRatingScore7;
            float f9 = this.defaultRatingScore8;
            float f10 = this.defaultRatingScore9;
            float f11 = this.defaultRatingScore10;
            String str74 = this.defaultCommentGood;
            String str75 = this.defaultCommentGoodPic;
            String str76 = this.defaultCommentBad;
            String str77 = this.defaultCommentBadPic;
            String str78 = this.defaultCommentGeneral;
            String str79 = this.defaultCommentGeneralPic;
            String str80 = this.defaultExtraFromApi;
            String str81 = this.defaultShareUrl;
            Entity entity = this.defaultDetailSponsorCard;
            Entity entity2 = this.defaultHotSponsorCard;
            Entity entity3 = this.defaultNoticeSponsorCard;
            int i23 = this.defaultBuyStatus;
            List<FeedReply> list13 = this.defaultTopReplyRows;
            FeedGoodsAction feedGoodsAction = this.defaultGoodsAction;
            String str82 = this.defaultEditorTitle;
            int i24 = this.defaultIsOwner;
            int i25 = this.defaultShowOwner;
            int i26 = this.defaultIsAnonymous;
            Vote vote = this.defaultVote;
            SecondHandInfo secondHandInfo = this.defaultSecondHandInfo;
            int i27 = this.defaultIsRecommendVoteComment;
            SimpleInfo simpleInfo = this.defaultTopInfo;
            SimpleInfo simpleInfo2 = this.defaultInnerInfo;
            int i28 = this.defaultIsModified;
            int i29 = this.defaultEnableModify;
            int i30 = this.defaultIsHistory;
            String str83 = str42;
            String str84 = str3;
            String str85 = str4;
            Integer num2 = num;
            String str86 = str5;
            String str87 = str6;
            String str88 = str7;
            Long l4 = l2;
            Long l5 = l3;
            String str89 = str8;
            UserInfo userInfo3 = userInfo;
            String str90 = str9;
            String str91 = str10;
            String str92 = str;
            String str93 = str11;
            String str94 = str12;
            String str95 = str13;
            String str96 = str14;
            int i31 = i;
            String str97 = str15;
            List<String> list14 = list;
            String str98 = str16;
            String str99 = str17;
            int i32 = i2;
            int i33 = i3;
            int i34 = i4;
            int i35 = i5;
            int i36 = i6;
            int i37 = i7;
            String str100 = str18;
            String str101 = str19;
            int i38 = i8;
            String str102 = str20;
            int i39 = i9;
            int i40 = i10;
            String str103 = str21;
            String str104 = str22;
            String str105 = str23;
            int i41 = i11;
            int i42 = i12;
            int i43 = i13;
            int i44 = i14;
            String str106 = str24;
            String str107 = str25;
            String str108 = str26;
            List<FeedReply> list15 = list2;
            int i45 = i15;
            List<RelatedData> list16 = list3;
            List<RelatedData> list17 = list4;
            List<RelatedData> list18 = list5;
            String str109 = str27;
            Collection collection2 = collection;
            CollectionItem collectionItem2 = collectionItem;
            UserAction userAction2 = userAction;
            List<FeedReply> list19 = list6;
            List<FeedReply> list20 = list7;
            List<FeedReply> list21 = list8;
            List<String> list22 = list9;
            List<GoodsListItem> list23 = list10;
            Feed feed2 = feed;
            DyhArticle dyhArticle2 = dyhArticle;
            String str110 = str28;
            String str111 = str29;
            String str112 = str30;
            String str113 = str2;
            String str114 = str31;
            long j3 = j;
            UserInfo userInfo4 = userInfo2;
            String str115 = str33;
            String str116 = str34;
            String str117 = str35;
            String str118 = str36;
            String str119 = str37;
            String str120 = str38;
            String str121 = str39;
            String str122 = str40;
            int i46 = i16;
            int i47 = i17;
            int i48 = i18;
            String str123 = str32;
            int i49 = i19;
            long j4 = j2;
            String str124 = str41;
            String str125 = str43;
            String str126 = str44;
            String str127 = str45;
            String str128 = str46;
            String str129 = str47;
            String str130 = str48;
            List<FeedRelation> list24 = list11;
            FeedTarget feedTarget2 = feedTarget;
            int i50 = i20;
            String str131 = str49;
            String str132 = str50;
            String str133 = str51;
            String str134 = str52;
            String str135 = str53;
            String str136 = str54;
            String str137 = str55;
            String str138 = str56;
            String str139 = str57;
            String str140 = str58;
            String str141 = str59;
            String str142 = str60;
            List<Entity> list25 = list12;
            String str143 = str61;
            String str144 = str62;
            String str145 = str63;
            String str146 = str64;
            String str147 = str65;
            String str148 = str66;
            String str149 = str67;
            int i51 = i21;
            String str150 = str68;
            String str151 = str69;
            int i52 = i22;
            DyhModel dyhModel2 = dyhModel;
            String str152 = str70;
            String str153 = str71;
            String str154 = str72;
            String str155 = str73;
            float f12 = f;
            float f13 = f2;
            float f14 = f3;
            float f15 = f4;
            float f16 = f5;
            float f17 = f6;
            float f18 = f7;
            float f19 = f8;
            float f20 = f9;
            float f21 = f10;
            float f22 = f11;
            String str156 = str74;
            String str157 = str75;
            String str158 = str76;
            String str159 = str77;
            String str160 = str78;
            String str161 = str79;
            String str162 = str80;
            String str163 = str81;
            Entity entity4 = entity;
            Entity entity5 = entity2;
            Entity entity6 = entity3;
            int i53 = i23;
            List<FeedReply> list26 = list13;
            FeedGoodsAction feedGoodsAction2 = feedGoodsAction;
            String str164 = str82;
            int i54 = i24;
            int i55 = i25;
            int i56 = i26;
            Vote vote2 = vote;
            SecondHandInfo secondHandInfo2 = secondHandInfo;
            int i57 = i27;
            SimpleInfo simpleInfo3 = simpleInfo;
            SimpleInfo simpleInfo4 = simpleInfo2;
            int i58 = i28;
            int i59 = i29;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -2102099874:
                            if (nextName.equals("entityId")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -2090050568:
                            if (nextName.equals("subTitle")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1940063007:
                            if (nextName.equals("extra_fromApi")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1908329186:
                            if (nextName.equals("isHeadline")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1867626759:
                            if (nextName.equals("extra_link_url")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1863967715:
                            if (nextName.equals("enableModify")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1850089143:
                            if (nextName.equals("is_headline")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1724546052:
                            if (nextName.equals("description")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1698410561:
                            if (nextName.equals("source_id")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1634201648:
                            if (nextName.equals("likeAvatar")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -1581702362:
                            if (nextName.equals("share_num")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -1580301955:
                            if (nextName.equals("entityTemplate")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -1559845903:
                            if (nextName.equals("question_follow_num")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -1482998339:
                            if (nextName.equals("entityType")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -1460853832:
                            if (nextName.equals("displayUsername")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -1433038149:
                            if (nextName.equals("message_raw_input")) {
                                c = 15;
                                break;
                            }
                            break;
                        case -1408783853:
                            if (nextName.equals("isModified")) {
                                c = 16;
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 17;
                                break;
                            }
                            break;
                        case -1345087976:
                            if (nextName.equals("long_location")) {
                                c = 18;
                                break;
                            }
                            break;
                        case -1317113241:
                            if (nextName.equals("dyh_id")) {
                                c = 19;
                                break;
                            }
                            break;
                        case -1303117998:
                            if (nextName.equals("noticeSponsorCard")) {
                                c = 20;
                                break;
                            }
                            break;
                        case -1296155600:
                            if (nextName.equals("message_raw_output")) {
                                c = 21;
                                break;
                            }
                            break;
                        case -1281587573:
                            if (nextName.equals("favnum")) {
                                c = 22;
                                break;
                            }
                            break;
                        case -1272781286:
                            if (nextName.equals("userFollowList")) {
                                c = 23;
                                break;
                            }
                            break;
                        case -1237377772:
                            if (nextName.equals("fetchType")) {
                                c = 24;
                                break;
                            }
                            break;
                        case -1229302401:
                            if (nextName.equals("message_cover")) {
                                c = 25;
                                break;
                            }
                            break;
                        case -1213783008:
                            if (nextName.equals("message_title")) {
                                c = 26;
                                break;
                            }
                            break;
                        case -1140201565:
                            if (nextName.equals("topInfo")) {
                                c = 27;
                                break;
                            }
                            break;
                        case -1103915498:
                            if (nextName.equals("hotReplyRows")) {
                                c = 28;
                                break;
                            }
                            break;
                        case -988517257:
                            if (nextName.equals("picArr")) {
                                c = 29;
                                break;
                            }
                            break;
                        case -946093840:
                            if (nextName.equals("spamContent")) {
                                c = 30;
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = 31;
                                break;
                            }
                            break;
                        case -892481550:
                            if (nextName.equals("status")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case -886838317:
                            if (nextName.equals("comment_general_pic")) {
                                c = '!';
                                break;
                            }
                            break;
                        case -869304560:
                            if (nextName.equals("extra_entities")) {
                                c = '\"';
                                break;
                            }
                            break;
                        case -863614364:
                            if (nextName.equals("ttitle")) {
                                c = '#';
                                break;
                            }
                            break;
                        case -854586421:
                            if (nextName.equals("buy_status")) {
                                c = '$';
                                break;
                            }
                            break;
                        case -815588727:
                            if (nextName.equals("targetRow")) {
                                c = '%';
                                break;
                            }
                            break;
                        case -763015088:
                            if (nextName.equals("recentLikeList")) {
                                c = '&';
                                break;
                            }
                            break;
                        case -743768816:
                            if (nextName.equals("shareUrl")) {
                                c = '\'';
                                break;
                            }
                            break;
                        case -731774526:
                            if (nextName.equals("feedFromType")) {
                                c = '(';
                                break;
                            }
                            break;
                        case -717007700:
                            if (nextName.equals("blockStatusText")) {
                                c = ')';
                                break;
                            }
                            break;
                        case -714661626:
                            if (nextName.equals("editor_title")) {
                                c = '*';
                                break;
                            }
                            break;
                        case -645462302:
                            if (nextName.equals("messagesource")) {
                                c = '+';
                                break;
                            }
                            break;
                        case -601407516:
                            if (nextName.equals("block_status")) {
                                c = ',';
                                break;
                            }
                            break;
                        case -584774865:
                            if (nextName.equals("device_title")) {
                                c = '-';
                                break;
                            }
                            break;
                        case -566515261:
                            if (nextName.equals("isHeadlineCommentV8")) {
                                c = '.';
                                break;
                            }
                            break;
                        case -563842096:
                            if (nextName.equals("likeUserInfo")) {
                                c = '/';
                                break;
                            }
                            break;
                        case -562752115:
                            if (nextName.equals("likeUsername")) {
                                c = '0';
                                break;
                            }
                            break;
                        case -534538128:
                            if (nextName.equals("comment_bad_pic")) {
                                c = '1';
                                break;
                            }
                            break;
                        case -528282588:
                            if (nextName.equals("innerInfo")) {
                                c = '2';
                                break;
                            }
                            break;
                        case -433749021:
                            if (nextName.equals("replyRows")) {
                                c = '3';
                                break;
                            }
                            break;
                        case -429606820:
                            if (nextName.equals("replynum")) {
                                c = '4';
                                break;
                            }
                            break;
                        case -419037274:
                            if (nextName.equals("messageStatusText")) {
                                c = '5';
                                break;
                            }
                            break;
                        case -374464741:
                            if (nextName.equals("replyMeRows")) {
                                c = '6';
                                break;
                            }
                            break;
                        case -316741264:
                            if (nextName.equals("rating_score")) {
                                c = '7';
                                break;
                            }
                            break;
                        case -268054776:
                            if (nextName.equals("comment_general")) {
                                c = '8';
                                break;
                            }
                            break;
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = '9';
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = ':';
                                break;
                            }
                            break;
                        case -262827531:
                            if (nextName.equals("relationRows")) {
                                c = ';';
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = '<';
                                break;
                            }
                            break;
                        case -252978768:
                            if (nextName.equals("extra_key")) {
                                c = '=';
                                break;
                            }
                            break;
                        case -252973861:
                            if (nextName.equals("extra_pic")) {
                                c = '>';
                                break;
                            }
                            break;
                        case -252968768:
                            if (nextName.equals("extra_url")) {
                                c = '?';
                                break;
                            }
                            break;
                        case -241177981:
                            if (nextName.equals("relatedata")) {
                                c = '@';
                                break;
                            }
                            break;
                        case -241165445:
                            if (nextName.equals("relatednum")) {
                                c = 'A';
                                break;
                            }
                            break;
                        case -191895048:
                            if (nextName.equals("feedType")) {
                                c = 'B';
                                break;
                            }
                            break;
                        case -163636061:
                            if (nextName.equals("feedTypeName")) {
                                c = 'C';
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 'D';
                                break;
                            }
                            break;
                        case 101377:
                            if (nextName.equals("fid")) {
                                c = 'E';
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 'F';
                                break;
                            }
                            break;
                        case 114831:
                            if (nextName.equals("tid")) {
                                c = 'G';
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 'H';
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 'I';
                                break;
                            }
                            break;
                        case 3237038:
                            if (nextName.equals("info")) {
                                c = 'J';
                                break;
                            }
                            break;
                        case 3540562:
                            if (nextName.equals("star")) {
                                c = 'K';
                                break;
                            }
                            break;
                        case 3552281:
                            if (nextName.equals("tags")) {
                                c = 'L';
                                break;
                            }
                            break;
                        case 3561835:
                            if (nextName.equals("tkey")) {
                                c = 'M';
                                break;
                            }
                            break;
                        case 3566742:
                            if (nextName.equals("tpic")) {
                                c = 'N';
                                break;
                            }
                            break;
                        case 3571835:
                            if (nextName.equals("turl")) {
                                c = 'O';
                                break;
                            }
                            break;
                        case 3575610:
                            if (nextName.equals("type")) {
                                c = 'P';
                                break;
                            }
                            break;
                        case 3625706:
                            if (nextName.equals("vote")) {
                                c = 'Q';
                                break;
                            }
                            break;
                        case 4246350:
                            if (nextName.equals("rating_score_10")) {
                                c = 'R';
                                break;
                            }
                            break;
                        case 21535901:
                            if (nextName.equals("adminInfo")) {
                                c = 'S';
                                break;
                            }
                            break;
                        case 46690368:
                            if (nextName.equals("isHeadlineV8")) {
                                c = 'T';
                                break;
                            }
                            break;
                        case 98539350:
                            if (nextName.equals("goods")) {
                                c = 'U';
                                break;
                            }
                            break;
                        case 102727412:
                            if (nextName.equals("label")) {
                                c = 'V';
                                break;
                            }
                            break;
                        case 110365474:
                            if (nextName.equals("tinfo")) {
                                c = 'W';
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 'X';
                                break;
                            }
                            break;
                        case 110450286:
                            if (nextName.equals("tlink")) {
                                c = 'Y';
                                break;
                            }
                            break;
                        case 110704046:
                            if (nextName.equals("ttype")) {
                                c = 'Z';
                                break;
                            }
                            break;
                        case 121133918:
                            if (nextName.equals("is_owner")) {
                                c = '[';
                                break;
                            }
                            break;
                        case 139881314:
                            if (nextName.equals("is_recommend_vote_comment")) {
                                c = '\\';
                                break;
                            }
                            break;
                        case 174121273:
                            if (nextName.equals("likeUid")) {
                                c = ']';
                                break;
                            }
                            break;
                        case 174145679:
                            if (nextName.equals("likenum")) {
                                c = '^';
                                break;
                            }
                            break;
                        case 177592697:
                            if (nextName.equals("infoHtml")) {
                                c = '_';
                                break;
                            }
                            break;
                        case 248004671:
                            if (nextName.equals("statusText")) {
                                c = '`';
                                break;
                            }
                            break;
                        case 250747629:
                            if (nextName.equals("spamReason")) {
                                c = 'a';
                                break;
                            }
                            break;
                        case 302894437:
                            if (nextName.equals("ershou_info")) {
                                c = 'b';
                                break;
                            }
                            break;
                        case 334595520:
                            if (nextName.equals("userLikeList")) {
                                c = 'c';
                                break;
                            }
                            break;
                        case 339519501:
                            if (nextName.equals("user_tags")) {
                                c = 'd';
                                break;
                            }
                            break;
                        case 340983322:
                            if (nextName.equals("useragent")) {
                                c = 'e';
                                break;
                            }
                            break;
                        case 347155466:
                            if (nextName.equals("isHistory")) {
                                c = 'f';
                                break;
                            }
                            break;
                        case 405475484:
                            if (nextName.equals("rating_type")) {
                                c = 'g';
                                break;
                            }
                            break;
                        case 406262265:
                            if (nextName.equals("collection_item_info")) {
                                c = 'h';
                                break;
                            }
                            break;
                        case 509524222:
                            if (nextName.equals("forwardSourceFeed")) {
                                c = 'i';
                                break;
                            }
                            break;
                        case 509960858:
                            if (nextName.equals("forwardSourceType")) {
                                c = 'j';
                                break;
                            }
                            break;
                        case 523149226:
                            if (nextName.equals("keywords")) {
                                c = 'k';
                                break;
                            }
                            break;
                        case 554326306:
                            if (nextName.equals("rating_score_1")) {
                                c = 'l';
                                break;
                            }
                            break;
                        case 554326307:
                            if (nextName.equals("rating_score_2")) {
                                c = 'm';
                                break;
                            }
                            break;
                        case 554326308:
                            if (nextName.equals("rating_score_3")) {
                                c = 'n';
                                break;
                            }
                            break;
                        case 554326309:
                            if (nextName.equals("rating_score_4")) {
                                c = 'o';
                                break;
                            }
                            break;
                        case 554326310:
                            if (nextName.equals("rating_score_5")) {
                                c = 'p';
                                break;
                            }
                            break;
                        case 554326311:
                            if (nextName.equals("rating_score_6")) {
                                c = 'q';
                                break;
                            }
                            break;
                        case 554326312:
                            if (nextName.equals("rating_score_7")) {
                                c = 'r';
                                break;
                            }
                            break;
                        case 554326313:
                            if (nextName.equals("rating_score_8")) {
                                c = 's';
                                break;
                            }
                            break;
                        case 554326314:
                            if (nextName.equals("rating_score_9")) {
                                c = 't';
                                break;
                            }
                            break;
                        case 559509681:
                            if (nextName.equals("articleId")) {
                                c = 'u';
                                break;
                            }
                            break;
                        case 592492776:
                            if (nextName.equals("comment_good_pic")) {
                                c = 'v';
                                break;
                            }
                            break;
                        case 607544993:
                            if (nextName.equals("forwardnum")) {
                                c = 'w';
                                break;
                            }
                            break;
                        case 683233012:
                            if (nextName.equals("comment_block_num")) {
                                c = 'x';
                                break;
                            }
                            break;
                        case 738428399:
                            if (nextName.equals("isStickTop")) {
                                c = 'y';
                                break;
                            }
                            break;
                        case 747541373:
                            if (nextName.equals("extra_info")) {
                                c = 'z';
                                break;
                            }
                            break;
                        case 747879945:
                            if (nextName.equals("extra_type")) {
                                c = '{';
                                break;
                            }
                            break;
                        case 765920821:
                            if (nextName.equals("follownum")) {
                                c = '|';
                                break;
                            }
                            break;
                        case 795242141:
                            if (nextName.equals("comment_good")) {
                                c = '}';
                                break;
                            }
                            break;
                        case 888049560:
                            if (nextName.equals("is_anonymous")) {
                                c = '~';
                                break;
                            }
                            break;
                        case 929064519:
                            if (nextName.equals("goodsListItem")) {
                                c = 127;
                                break;
                            }
                            break;
                        case 954925063:
                            if (nextName.equals("message")) {
                                c = 128;
                                break;
                            }
                            break;
                        case 989204668:
                            if (nextName.equals("recommend")) {
                                c = 129;
                                break;
                            }
                            break;
                        case 1008404266:
                            if (nextName.equals("message_status")) {
                                c = 130;
                                break;
                            }
                            break;
                        case 1060168111:
                            if (nextName.equals("collection_info")) {
                                c = 131;
                                break;
                            }
                            break;
                        case 1061163489:
                            if (nextName.equals("userAction")) {
                                c = 132;
                                break;
                            }
                            break;
                        case 1065401750:
                            if (nextName.equals("forwardSourceArticle")) {
                                c = 133;
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = 134;
                                break;
                            }
                            break;
                        case 1102762756:
                            if (nextName.equals("likeTime")) {
                                c = 135;
                                break;
                            }
                            break;
                        case 1122189041:
                            if (nextName.equals("show_owner")) {
                                c = 136;
                                break;
                            }
                            break;
                        case 1130002109:
                            if (nextName.equals("hotSponsorCard")) {
                                c = 137;
                                break;
                            }
                            break;
                        case 1231131150:
                            if (nextName.equals("topReplyRows")) {
                                c = 138;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 139;
                                break;
                            }
                            break;
                        case 1269540602:
                            if (nextName.equals("dyh_info")) {
                                c = 140;
                                break;
                            }
                            break;
                        case 1269677271:
                            if (nextName.equals("dyh_name")) {
                                c = 141;
                                break;
                            }
                            break;
                        case 1333280710:
                            if (nextName.equals("video_pic")) {
                                c = 142;
                                break;
                            }
                            break;
                        case 1333285803:
                            if (nextName.equals("video_url")) {
                                c = 143;
                                break;
                            }
                            break;
                        case 1426643326:
                            if (nextName.equals("question_answer_num")) {
                                c = 144;
                                break;
                            }
                            break;
                        case 1561866583:
                            if (nextName.equals("is_html_article")) {
                                c = 145;
                                break;
                            }
                            break;
                        case 1708969321:
                            if (nextName.equals("extra_title")) {
                                c = 146;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 147;
                                break;
                            }
                            break;
                        case 1864061896:
                            if (nextName.equals("recentReplyRows")) {
                                c = 148;
                                break;
                            }
                            break;
                        case 1901043637:
                            if (nextName.equals("location")) {
                                c = 149;
                                break;
                            }
                            break;
                        case 1913317602:
                            if (nextName.equals("message_keywords")) {
                                c = 150;
                                break;
                            }
                            break;
                        case 1939536937:
                            if (nextName.equals("media_info")) {
                                c = 151;
                                break;
                            }
                            break;
                        case 1939875509:
                            if (nextName.equals("media_type")) {
                                c = 152;
                                break;
                            }
                            break;
                        case 2046691385:
                            if (nextName.equals("detailSponsorCard")) {
                                c = 153;
                                break;
                            }
                            break;
                        case 2056188342:
                            if (nextName.equals("spamTime")) {
                                c = 154;
                                break;
                            }
                            break;
                        case 2097808032:
                            if (nextName.equals("forwardid")) {
                                c = 155;
                                break;
                            }
                            break;
                        case 2103857701:
                            if (nextName.equals("comment_bad")) {
                                c = 156;
                                break;
                            }
                            break;
                        case 2140787348:
                            if (nextName.equals("media_url")) {
                                c = 157;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str85 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str87 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str162 = this.extraFromApiAdapter.read(jsonReader);
                            continue;
                        case 3:
                            i46 = this.isHeadlineAdapter.read(jsonReader).intValue();
                            continue;
                        case 4:
                            str141 = this.extraLinkUrlAdapter.read(jsonReader);
                            continue;
                        case 5:
                            i59 = this.enableModifyAdapter.read(jsonReader).intValue();
                            continue;
                        case 6:
                            i47 = this.isHeadlinedAdapter.read(jsonReader).intValue();
                            continue;
                        case 7:
                            str86 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str116 = this.sourceIdAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str123 = this.likeAvatarAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            i33 = this.shareNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 11:
                            str84 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            i52 = this.questionFollowNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '\r':
                            str113 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str93 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str104 = this.messageRawInputAdapter.read(jsonReader);
                            continue;
                        case 16:
                            i58 = this.isModifiedAdapter.read(jsonReader).intValue();
                            continue;
                        case 17:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str146 = this.longLocationAdapter.read(jsonReader);
                            continue;
                        case 19:
                            str132 = this.dyhIdAdapter.read(jsonReader);
                            continue;
                        case 20:
                            entity6 = this.noticeSponsorCardAdapter.read(jsonReader);
                            continue;
                        case 21:
                            str103 = this.messageRawOutputAdapter.read(jsonReader);
                            continue;
                        case 22:
                            i42 = this.favoriteNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 23:
                            list18 = this.userFollowListAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str108 = this.fetchTypeAdapter.read(jsonReader);
                            continue;
                        case 25:
                            str149 = this.messageCoverAdapter.read(jsonReader);
                            continue;
                        case 26:
                            str147 = this.messageTitleAdapter.read(jsonReader);
                            continue;
                        case 27:
                            simpleInfo3 = this.topInfoAdapter.read(jsonReader);
                            continue;
                        case 28:
                            list21 = this.hotReplyRowsAdapter.read(jsonReader);
                            continue;
                        case 29:
                            list14 = this.picArrayAdapter.read(jsonReader);
                            continue;
                        case 30:
                            str118 = this.spamContentAdapter.read(jsonReader);
                            continue;
                        case 31:
                            str92 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case ' ':
                            i38 = this.statusAdapter.read(jsonReader).intValue();
                            continue;
                        case '!':
                            str161 = this.commentGeneralPicAdapter.read(jsonReader);
                            continue;
                        case '\"':
                            list25 = this.extraEntitiesAdapter.read(jsonReader);
                            continue;
                        case '#':
                            str124 = this.appNameAdapter.read(jsonReader);
                            continue;
                        case '$':
                            i53 = this.buyStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case '%':
                            feedTarget2 = this.targetRowAdapter.read(jsonReader);
                            continue;
                        case '&':
                            list22 = this.recentLikeListAdapter.read(jsonReader);
                            continue;
                        case '\'':
                            str163 = this.shareUrlAdapter.read(jsonReader);
                            continue;
                        case '(':
                            str106 = this.feedFromTypeAdapter.read(jsonReader);
                            continue;
                        case ')':
                            str122 = this.blockStatusTextAdapter.read(jsonReader);
                            continue;
                        case '*':
                            str164 = this.editorTitleAdapter.read(jsonReader);
                            continue;
                        case '+':
                            str151 = this.messageSourceAdapter.read(jsonReader);
                            continue;
                        case ',':
                            i44 = this.blockStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case '-':
                            str109 = this.deviceTitleAdapter.read(jsonReader);
                            continue;
                        case '.':
                            i49 = this.isHeadlineCommentV8Adapter.read(jsonReader).intValue();
                            continue;
                        case '/':
                            userInfo4 = this.likeUserInfoAdapter.read(jsonReader);
                            continue;
                        case '0':
                            str112 = this.likeUserNameAdapter.read(jsonReader);
                            continue;
                        case '1':
                            str159 = this.commentBadPicAdapter.read(jsonReader);
                            continue;
                        case '2':
                            simpleInfo4 = this.innerInfoAdapter.read(jsonReader);
                            continue;
                        case '3':
                            list15 = this.replyRowsAdapter.read(jsonReader);
                            continue;
                        case '4':
                            i35 = this.replyNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '5':
                            str121 = this.messageStatusTextAdapter.read(jsonReader);
                            continue;
                        case '6':
                            list19 = this.replyMeRowsAdapter.read(jsonReader);
                            continue;
                        case '7':
                            f12 = this.ratingScoreAdapter.read(jsonReader).floatValue();
                            continue;
                        case '8':
                            str160 = this.commentGeneralAdapter.read(jsonReader);
                            continue;
                        case '9':
                            userInfo3 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case ':':
                            str91 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case ';':
                            list24 = this.relationRowsAdapter.read(jsonReader);
                            continue;
                        case '<':
                            str88 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '=':
                            str136 = this.extraKeyAdapter.read(jsonReader);
                            continue;
                        case '>':
                            str142 = this.extraPicAdapter.read(jsonReader);
                            continue;
                        case '?':
                            str139 = this.extraUrlAdapter.read(jsonReader);
                            continue;
                        case '@':
                            list16 = this.relatedDataAdapter.read(jsonReader);
                            continue;
                        case 'A':
                            i36 = this.relatedNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 'B':
                            str107 = this.feedTypeAdapter.read(jsonReader);
                            continue;
                        case 'C':
                            str105 = this.feedTypeNameAdapter.read(jsonReader);
                            continue;
                        case 'D':
                            str95 = this.idAdapter.read(jsonReader);
                            continue;
                        case 'E':
                            str131 = this.fidAdapter.read(jsonReader);
                            continue;
                        case 'F':
                            str97 = this.picAdapter.read(jsonReader);
                            continue;
                        case 'G':
                            str126 = this.tidAdapter.read(jsonReader);
                            continue;
                        case 'H':
                            str90 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 'I':
                            str111 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 'J':
                            str99 = this.infoAdapter.read(jsonReader);
                            continue;
                        case 'K':
                            i50 = this.starAdapter.read(jsonReader).intValue();
                            continue;
                        case 'L':
                            str150 = this.tagsAdapter.read(jsonReader);
                            continue;
                        case 'M':
                            str83 = this.tkeyAdapter.read(jsonReader);
                            continue;
                        case 'N':
                            str128 = this.tpicAdapter.read(jsonReader);
                            continue;
                        case 'O':
                            str127 = this.TUrlAdapter.read(jsonReader);
                            continue;
                        case 'P':
                            i31 = this.typeAdapter.read(jsonReader).intValue();
                            continue;
                        case 'Q':
                            vote2 = this.voteAdapter.read(jsonReader);
                            continue;
                        case 'R':
                            f22 = this.ratingScore10Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'S':
                            str119 = this.adminInfoAdapter.read(jsonReader);
                            continue;
                        case 'T':
                            i48 = this.isHeadlineV8Adapter.read(jsonReader).intValue();
                            continue;
                        case 'U':
                            feedGoodsAction2 = this.goodsActionAdapter.read(jsonReader);
                            continue;
                        case 'V':
                            str96 = this.labelAdapter.read(jsonReader);
                            continue;
                        case 'W':
                            str129 = this.tinfoAdapter.read(jsonReader);
                            continue;
                        case 'X':
                            str94 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 'Y':
                            str130 = this.tlinkAdapter.read(jsonReader);
                            continue;
                        case 'Z':
                            str125 = this.ttypeAdapter.read(jsonReader);
                            continue;
                        case '[':
                            i54 = this.isOwnerAdapter.read(jsonReader).intValue();
                            continue;
                        case '\\':
                            i57 = this.isRecommendVoteCommentAdapter.read(jsonReader).intValue();
                            continue;
                        case ']':
                            str114 = this.likeUidAdapter.read(jsonReader);
                            continue;
                        case '^':
                            i34 = this.likeNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '_':
                            str98 = this.infoHtmlAdapter.read(jsonReader);
                            continue;
                        case '`':
                            str120 = this.statusTextAdapter.read(jsonReader);
                            continue;
                        case 'a':
                            str117 = this.spamReasonAdapter.read(jsonReader);
                            continue;
                        case 'b':
                            secondHandInfo2 = this.secondHandInfoAdapter.read(jsonReader);
                            continue;
                        case 'c':
                            list17 = this.userLikeListAdapter.read(jsonReader);
                            continue;
                        case 'd':
                            str134 = this.userTagsAdapter.read(jsonReader);
                            continue;
                        case 'e':
                            str100 = this.useragentAdapter.read(jsonReader);
                            continue;
                        case 'f':
                            i30 = this.isHistoryAdapter.read(jsonReader).intValue();
                            continue;
                        case 'g':
                            str155 = this.ratingTypeAdapter.read(jsonReader);
                            continue;
                        case 'h':
                            collectionItem2 = this.collectionItemAdapter.read(jsonReader);
                            continue;
                        case 'i':
                            feed2 = this.forwardSourceFeedAdapter.read(jsonReader);
                            continue;
                        case 'j':
                            str110 = this.forwardSourceTypeAdapter.read(jsonReader);
                            continue;
                        case 'k':
                            str135 = this.keywordsAdapter.read(jsonReader);
                            continue;
                        case 'l':
                            f13 = this.ratingScore1Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'm':
                            f14 = this.ratingScore2Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'n':
                            f15 = this.ratingScore3Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'o':
                            f16 = this.ratingScore4Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'p':
                            f17 = this.ratingScore5Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'q':
                            f18 = this.ratingScore6Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'r':
                            f19 = this.ratingScore7Adapter.read(jsonReader).floatValue();
                            continue;
                        case 's':
                            f20 = this.ratingScore8Adapter.read(jsonReader).floatValue();
                            continue;
                        case 't':
                            f21 = this.ratingScore9Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'u':
                            str101 = this.articleIdAdapter.read(jsonReader);
                            continue;
                        case 'v':
                            str157 = this.commentGoodPicAdapter.read(jsonReader);
                            continue;
                        case 'w':
                            i32 = this.forwardNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 'x':
                            i43 = this.commentBlockNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 'y':
                            i40 = this.isStickTopAdapter.read(jsonReader).intValue();
                            continue;
                        case 'z':
                            str140 = this.extraInfoAdapter.read(jsonReader);
                            continue;
                        case '{':
                            str138 = this.extraTypeAdapter.read(jsonReader);
                            continue;
                        case '|':
                            i37 = this.followNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '}':
                            str156 = this.commentGoodAdapter.read(jsonReader);
                            continue;
                        case '~':
                            i56 = this.isAnonymousAdapter.read(jsonReader).intValue();
                            continue;
                        case 127:
                            list23 = this.goodsListItemAdapter.read(jsonReader);
                            continue;
                        case 128:
                            str102 = this.messageAdapter.read(jsonReader);
                            continue;
                        case 129:
                            i41 = this.recommendAdapter.read(jsonReader).intValue();
                            continue;
                        case 130:
                            i45 = this.messageStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 131:
                            collection2 = this.collectionInfoAdapter.read(jsonReader);
                            continue;
                        case 132:
                            userAction2 = this.userActionAdapter.read(jsonReader);
                            continue;
                        case 133:
                            dyhArticle2 = this.forwardSourceArticleAdapter.read(jsonReader);
                            continue;
                        case 134:
                            str89 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case 135:
                            j3 = this.likeTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case 136:
                            i55 = this.showOwnerAdapter.read(jsonReader).intValue();
                            continue;
                        case 137:
                            entity5 = this.hotSponsorCardAdapter.read(jsonReader);
                            continue;
                        case 138:
                            list26 = this.topReplyRowsAdapter.read(jsonReader);
                            continue;
                        case 139:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 140:
                            dyhModel2 = this.dyhModelAdapter.read(jsonReader);
                            continue;
                        case 141:
                            str133 = this.dyhNameAdapter.read(jsonReader);
                            continue;
                        case 142:
                            str143 = this.videoPicAdapter.read(jsonReader);
                            continue;
                        case 143:
                            str144 = this.videoUrlAdapter.read(jsonReader);
                            continue;
                        case 144:
                            i51 = this.questionAnswerNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 145:
                            i39 = this.isHtmlArticleAdapter.read(jsonReader).intValue();
                            continue;
                        case 146:
                            str137 = this.extraTitleAdapter.read(jsonReader);
                            continue;
                        case 147:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case 148:
                            list20 = this.recentReplyRowsAdapter.read(jsonReader);
                            continue;
                        case 149:
                            str145 = this.locationAdapter.read(jsonReader);
                            continue;
                        case 150:
                            str148 = this.messageKeywordsAdapter.read(jsonReader);
                            continue;
                        case 151:
                            str152 = this.mediaInfoAdapter.read(jsonReader);
                            continue;
                        case 152:
                            str154 = this.mediaTypeAdapter.read(jsonReader);
                            continue;
                        case 153:
                            entity4 = this.detailSponsorCardAdapter.read(jsonReader);
                            continue;
                        case 154:
                            j4 = this.spamTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case 155:
                            str115 = this.forwardIdAdapter.read(jsonReader);
                            continue;
                        case 156:
                            str158 = this.commentBadAdapter.read(jsonReader);
                            continue;
                        case 157:
                            str153 = this.mediaUrlAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Feed(str92, str113, str84, str85, num2, str86, str87, str88, l4, l5, str89, userInfo3, str90, str91, str93, str94, str95, str96, i31, str97, list14, str98, str99, i32, i33, i34, i35, i36, i37, str100, str101, i38, str102, i39, i40, str103, str104, str105, i41, i42, i43, i44, str106, str107, str108, list15, i45, list16, list17, list18, str109, collection2, collectionItem2, userAction2, list19, list20, list21, list22, list23, feed2, dyhArticle2, str110, str111, str112, str114, j3, userInfo4, str123, str115, str116, str117, str118, str119, str120, str121, str122, i46, i47, i48, i49, j4, str124, str83, str125, str126, str127, str128, str129, str130, list24, feedTarget2, i50, str131, str132, str133, str134, str135, str136, str137, str138, str139, str140, str141, str142, list25, str143, str144, str145, str146, str147, str148, str149, i51, str150, str151, i52, dyhModel2, str152, str153, str154, str155, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, str156, str157, str158, str159, str160, str161, str162, str163, entity4, entity5, entity6, i53, list26, feedGoodsAction2, str164, i54, i55, i56, vote2, secondHandInfo2, i57, simpleInfo3, simpleInfo4, i58, i59, i30);
        }
    }
}
