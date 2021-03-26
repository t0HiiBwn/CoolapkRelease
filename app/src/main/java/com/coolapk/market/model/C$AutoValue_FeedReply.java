package com.coolapk.market.model;

import com.coolapk.market.model.FeedReply;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* renamed from: com.coolapk.market.model.$AutoValue_FeedReply  reason: invalid class name */
abstract class C$AutoValue_FeedReply extends C$$AutoValue_FeedReply {
    C$AutoValue_FeedReply(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, Long l2, Long l3, String str9, String str10, String str11, String str12, String str13, String str14, UserInfo userInfo, int i, int i2, String str15, String str16, String str17, String str18, int i3, int i4, String str19, String str20, String str21, String str22, String str23, List<FeedReply> list, int i5, int i6, String str24, String str25, String str26, UserInfo userInfo2, int i7, String str27, int i8, int i9, int i10, int i11, String str28, String str29, String str30, String str31, String str32, String str33, String str34, FeedReply.ReplyUserAction replyUserAction, long j, String str35, String str36, long j2, String str37, String str38, String str39, FeedReply.ReplyFeed replyFeed, DyhArticle dyhArticle, SimpleInfo simpleInfo) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, l2, l3, str9, str10, str11, str12, str13, str14, userInfo, i, i2, str15, str16, str17, str18, i3, i4, str19, str20, str21, str22, str23, list, i5, i6, str24, str25, str26, userInfo2, i7, str27, i8, i9, i10, i11, str28, str29, str30, str31, str32, str33, str34, replyUserAction, j, str35, str36, j2, str37, str38, str39, replyFeed, dyhArticle, simpleInfo);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_FeedReply$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<FeedReply> {
        private final TypeAdapter<String> adminInfoAdapter;
        private final TypeAdapter<Integer> blockStatusAdapter;
        private final TypeAdapter<String> blockStatusTextAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private String defaultAdminInfo = null;
        private int defaultBlockStatus = 0;
        private String defaultBlockStatusText = null;
        private Long defaultDateline = null;
        private String defaultDeprecatedUserAvatar = null;
        private String defaultDeprecatedUserName = null;
        private String defaultDescription = null;
        private String defaultDisplayUserName = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultExtraFlag = null;
        private String defaultExtraPic = null;
        private String defaultExtraTitle = null;
        private String defaultExtraType = null;
        private String defaultExtraUrl = null;
        private String defaultFeedId = null;
        private String defaultFetchType = null;
        private int defaultFtype = 0;
        private String defaultId = null;
        private String defaultInfoHtml = null;
        private SimpleInfo defaultInnerInfo = null;
        private int defaultIsFeedAuthor = 0;
        private int defaultIsFolded = 0;
        private Long defaultLastUpdate = null;
        private String defaultLikeAvatar = null;
        private int defaultLikeNum = 0;
        private long defaultLikeTime = 0;
        private String defaultLikeUid = null;
        private UserInfo defaultLikeUserInfo = null;
        private String defaultLikeUserName = null;
        private String defaultLogo = null;
        private String defaultMessage = null;
        private String defaultMessageSource = null;
        private int defaultMessageStatus = 0;
        private String defaultMessageStatusText = null;
        private String defaultParentReplyId = null;
        private String defaultPic = null;
        private DyhArticle defaultReplyArticle = null;
        private FeedReply.ReplyFeed defaultReplyFeed = null;
        private int defaultReplyId = 0;
        private int defaultReplyNum = 0;
        private List<FeedReply> defaultReplyRows = Collections.emptyList();
        private int defaultReplyRowsCount = 0;
        private int defaultReplyRowsMore = 0;
        private String defaultReplyUid = null;
        private String defaultReplyUserAvatar = null;
        private String defaultReplyUserName = null;
        private String defaultSpamContent = null;
        private String defaultSpamReason = null;
        private long defaultSpamTime = 0;
        private int defaultStatus = 0;
        private String defaultStatusText = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUid = null;
        private String defaultUrl = null;
        private FeedReply.ReplyUserAction defaultUserAction = null;
        private String defaultUserAgent = null;
        private UserInfo defaultUserInfo = null;
        private final TypeAdapter<String> deprecatedUserAvatarAdapter;
        private final TypeAdapter<String> deprecatedUserNameAdapter;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<String> displayUserNameAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> extraFlagAdapter;
        private final TypeAdapter<String> extraPicAdapter;
        private final TypeAdapter<String> extraTitleAdapter;
        private final TypeAdapter<String> extraTypeAdapter;
        private final TypeAdapter<String> extraUrlAdapter;
        private final TypeAdapter<String> feedIdAdapter;
        private final TypeAdapter<String> fetchTypeAdapter;
        private final TypeAdapter<Integer> ftypeAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> infoHtmlAdapter;
        private final TypeAdapter<SimpleInfo> innerInfoAdapter;
        private final TypeAdapter<Integer> isFeedAuthorAdapter;
        private final TypeAdapter<Integer> isFoldedAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> likeAvatarAdapter;
        private final TypeAdapter<Integer> likeNumAdapter;
        private final TypeAdapter<Long> likeTimeAdapter;
        private final TypeAdapter<String> likeUidAdapter;
        private final TypeAdapter<UserInfo> likeUserInfoAdapter;
        private final TypeAdapter<String> likeUserNameAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> messageAdapter;
        private final TypeAdapter<String> messageSourceAdapter;
        private final TypeAdapter<Integer> messageStatusAdapter;
        private final TypeAdapter<String> messageStatusTextAdapter;
        private final TypeAdapter<String> parentReplyIdAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<DyhArticle> replyArticleAdapter;
        private final TypeAdapter<FeedReply.ReplyFeed> replyFeedAdapter;
        private final TypeAdapter<Integer> replyIdAdapter;
        private final TypeAdapter<Integer> replyNumAdapter;
        private final TypeAdapter<List<FeedReply>> replyRowsAdapter;
        private final TypeAdapter<Integer> replyRowsCountAdapter;
        private final TypeAdapter<Integer> replyRowsMoreAdapter;
        private final TypeAdapter<String> replyUidAdapter;
        private final TypeAdapter<String> replyUserAvatarAdapter;
        private final TypeAdapter<String> replyUserNameAdapter;
        private final TypeAdapter<String> spamContentAdapter;
        private final TypeAdapter<String> spamReasonAdapter;
        private final TypeAdapter<Long> spamTimeAdapter;
        private final TypeAdapter<Integer> statusAdapter;
        private final TypeAdapter<String> statusTextAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<FeedReply.ReplyUserAction> userActionAdapter;
        private final TypeAdapter<String> userAgentAdapter;
        private final TypeAdapter<UserInfo> userInfoAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.deprecatedUserAvatarAdapter = gson.getAdapter(String.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.feedIdAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.deprecatedUserNameAdapter = gson.getAdapter(String.class);
            this.userInfoAdapter = gson.getAdapter(UserInfo.class);
            this.ftypeAdapter = gson.getAdapter(Integer.class);
            this.replyIdAdapter = gson.getAdapter(Integer.class);
            this.replyUserNameAdapter = gson.getAdapter(String.class);
            this.replyUserAvatarAdapter = gson.getAdapter(String.class);
            this.replyUidAdapter = gson.getAdapter(String.class);
            this.messageAdapter = gson.getAdapter(String.class);
            this.replyNumAdapter = gson.getAdapter(Integer.class);
            this.isFeedAuthorAdapter = gson.getAdapter(Integer.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.messageSourceAdapter = gson.getAdapter(String.class);
            this.userAgentAdapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.fetchTypeAdapter = gson.getAdapter(String.class);
            this.replyRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, FeedReply.class));
            this.replyRowsCountAdapter = gson.getAdapter(Integer.class);
            this.replyRowsMoreAdapter = gson.getAdapter(Integer.class);
            this.parentReplyIdAdapter = gson.getAdapter(String.class);
            this.spamReasonAdapter = gson.getAdapter(String.class);
            this.spamContentAdapter = gson.getAdapter(String.class);
            this.likeUserInfoAdapter = gson.getAdapter(UserInfo.class);
            this.likeNumAdapter = gson.getAdapter(Integer.class);
            this.infoHtmlAdapter = gson.getAdapter(String.class);
            this.isFoldedAdapter = gson.getAdapter(Integer.class);
            this.blockStatusAdapter = gson.getAdapter(Integer.class);
            this.statusAdapter = gson.getAdapter(Integer.class);
            this.messageStatusAdapter = gson.getAdapter(Integer.class);
            this.statusTextAdapter = gson.getAdapter(String.class);
            this.messageStatusTextAdapter = gson.getAdapter(String.class);
            this.blockStatusTextAdapter = gson.getAdapter(String.class);
            this.extraTitleAdapter = gson.getAdapter(String.class);
            this.extraTypeAdapter = gson.getAdapter(String.class);
            this.extraPicAdapter = gson.getAdapter(String.class);
            this.extraUrlAdapter = gson.getAdapter(String.class);
            this.userActionAdapter = gson.getAdapter(FeedReply.ReplyUserAction.class);
            this.spamTimeAdapter = gson.getAdapter(Long.class);
            this.likeUserNameAdapter = gson.getAdapter(String.class);
            this.likeUidAdapter = gson.getAdapter(String.class);
            this.likeTimeAdapter = gson.getAdapter(Long.class);
            this.adminInfoAdapter = gson.getAdapter(String.class);
            this.likeAvatarAdapter = gson.getAdapter(String.class);
            this.extraFlagAdapter = gson.getAdapter(String.class);
            this.replyFeedAdapter = gson.getAdapter(FeedReply.ReplyFeed.class);
            this.replyArticleAdapter = gson.getAdapter(DyhArticle.class);
            this.innerInfoAdapter = gson.getAdapter(SimpleInfo.class);
        }

        public GsonTypeAdapter setDefaultEntityTypeName(String str) {
            this.defaultEntityTypeName = str;
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

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
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

        public GsonTypeAdapter setDefaultDisplayUserName(String str) {
            this.defaultDisplayUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedId(String str) {
            this.defaultFeedId = str;
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

        public GsonTypeAdapter setDefaultUserInfo(UserInfo userInfo) {
            this.defaultUserInfo = userInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultFtype(int i) {
            this.defaultFtype = i;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyId(int i) {
            this.defaultReplyId = i;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyUserName(String str) {
            this.defaultReplyUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyUserAvatar(String str) {
            this.defaultReplyUserAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyUid(String str) {
            this.defaultReplyUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessage(String str) {
            this.defaultMessage = str;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyNum(int i) {
            this.defaultReplyNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsFeedAuthor(int i) {
            this.defaultIsFeedAuthor = i;
            return this;
        }

        public GsonTypeAdapter setDefaultPic(String str) {
            this.defaultPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageSource(String str) {
            this.defaultMessageSource = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserAgent(String str) {
            this.defaultUserAgent = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
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

        public GsonTypeAdapter setDefaultReplyRowsCount(int i) {
            this.defaultReplyRowsCount = i;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyRowsMore(int i) {
            this.defaultReplyRowsMore = i;
            return this;
        }

        public GsonTypeAdapter setDefaultParentReplyId(String str) {
            this.defaultParentReplyId = str;
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

        public GsonTypeAdapter setDefaultLikeUserInfo(UserInfo userInfo) {
            this.defaultLikeUserInfo = userInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultLikeNum(int i) {
            this.defaultLikeNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultInfoHtml(String str) {
            this.defaultInfoHtml = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsFolded(int i) {
            this.defaultIsFolded = i;
            return this;
        }

        public GsonTypeAdapter setDefaultBlockStatus(int i) {
            this.defaultBlockStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultStatus(int i) {
            this.defaultStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageStatus(int i) {
            this.defaultMessageStatus = i;
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

        public GsonTypeAdapter setDefaultExtraTitle(String str) {
            this.defaultExtraTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraType(String str) {
            this.defaultExtraType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraPic(String str) {
            this.defaultExtraPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraUrl(String str) {
            this.defaultExtraUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserAction(FeedReply.ReplyUserAction replyUserAction) {
            this.defaultUserAction = replyUserAction;
            return this;
        }

        public GsonTypeAdapter setDefaultSpamTime(long j) {
            this.defaultSpamTime = j;
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

        public GsonTypeAdapter setDefaultAdminInfo(String str) {
            this.defaultAdminInfo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLikeAvatar(String str) {
            this.defaultLikeAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraFlag(String str) {
            this.defaultExtraFlag = str;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyFeed(FeedReply.ReplyFeed replyFeed) {
            this.defaultReplyFeed = replyFeed;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyArticle(DyhArticle dyhArticle) {
            this.defaultReplyArticle = dyhArticle;
            return this;
        }

        public GsonTypeAdapter setDefaultInnerInfo(SimpleInfo simpleInfo) {
            this.defaultInnerInfo = simpleInfo;
            return this;
        }

        public void write(JsonWriter jsonWriter, FeedReply feedReply) throws IOException {
            if (feedReply == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, feedReply.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, feedReply.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, feedReply.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, feedReply.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, feedReply.getTitle());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, feedReply.getDescription());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, feedReply.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, feedReply.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, feedReply.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, feedReply.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, feedReply.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, feedReply.getDeprecatedUserAvatar());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, feedReply.getDisplayUserName());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, feedReply.getId());
            jsonWriter.name("fid");
            this.feedIdAdapter.write(jsonWriter, feedReply.getFeedId());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, feedReply.getUid());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, feedReply.getDeprecatedUserName());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, feedReply.getUserInfo());
            jsonWriter.name("ftype");
            this.ftypeAdapter.write(jsonWriter, Integer.valueOf(feedReply.getFtype()));
            jsonWriter.name("rid");
            this.replyIdAdapter.write(jsonWriter, Integer.valueOf(feedReply.getReplyId()));
            jsonWriter.name("rusername");
            this.replyUserNameAdapter.write(jsonWriter, feedReply.getReplyUserName());
            jsonWriter.name("ravatar");
            this.replyUserAvatarAdapter.write(jsonWriter, feedReply.getReplyUserAvatar());
            jsonWriter.name("ruid");
            this.replyUidAdapter.write(jsonWriter, feedReply.getReplyUid());
            jsonWriter.name("message");
            this.messageAdapter.write(jsonWriter, feedReply.getMessage());
            jsonWriter.name("replynum");
            this.replyNumAdapter.write(jsonWriter, Integer.valueOf(feedReply.getReplyNum()));
            jsonWriter.name("isFeedAuthor");
            this.isFeedAuthorAdapter.write(jsonWriter, Integer.valueOf(feedReply.getIsFeedAuthor()));
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, feedReply.getPic());
            jsonWriter.name("messagesource");
            this.messageSourceAdapter.write(jsonWriter, feedReply.getMessageSource());
            jsonWriter.name("useragent");
            this.userAgentAdapter.write(jsonWriter, feedReply.getUserAgent());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, feedReply.getUrl());
            jsonWriter.name("fetchType");
            this.fetchTypeAdapter.write(jsonWriter, feedReply.getFetchType());
            jsonWriter.name("replyRows");
            this.replyRowsAdapter.write(jsonWriter, feedReply.getReplyRows());
            jsonWriter.name("replyRowsCount");
            this.replyRowsCountAdapter.write(jsonWriter, Integer.valueOf(feedReply.getReplyRowsCount()));
            jsonWriter.name("replyRowsMore");
            this.replyRowsMoreAdapter.write(jsonWriter, Integer.valueOf(feedReply.getReplyRowsMore()));
            jsonWriter.name("rrid");
            this.parentReplyIdAdapter.write(jsonWriter, feedReply.getParentReplyId());
            jsonWriter.name("spamReason");
            this.spamReasonAdapter.write(jsonWriter, feedReply.getSpamReason());
            jsonWriter.name("spamContent");
            this.spamContentAdapter.write(jsonWriter, feedReply.getSpamContent());
            jsonWriter.name("likeUserInfo");
            this.likeUserInfoAdapter.write(jsonWriter, feedReply.getLikeUserInfo());
            jsonWriter.name("likenum");
            this.likeNumAdapter.write(jsonWriter, Integer.valueOf(feedReply.getLikeNum()));
            jsonWriter.name("infoHtml");
            this.infoHtmlAdapter.write(jsonWriter, feedReply.getInfoHtml());
            jsonWriter.name("is_folded");
            this.isFoldedAdapter.write(jsonWriter, Integer.valueOf(feedReply.getIsFolded()));
            jsonWriter.name("block_status");
            this.blockStatusAdapter.write(jsonWriter, Integer.valueOf(feedReply.getBlockStatus()));
            jsonWriter.name("status");
            this.statusAdapter.write(jsonWriter, Integer.valueOf(feedReply.getStatus()));
            jsonWriter.name("message_status");
            this.messageStatusAdapter.write(jsonWriter, Integer.valueOf(feedReply.getMessageStatus()));
            jsonWriter.name("statusText");
            this.statusTextAdapter.write(jsonWriter, feedReply.getStatusText());
            jsonWriter.name("messageStatusText");
            this.messageStatusTextAdapter.write(jsonWriter, feedReply.getMessageStatusText());
            jsonWriter.name("blockStatusText");
            this.blockStatusTextAdapter.write(jsonWriter, feedReply.getBlockStatusText());
            jsonWriter.name("extra_title");
            this.extraTitleAdapter.write(jsonWriter, feedReply.getExtraTitle());
            jsonWriter.name("extra_type");
            this.extraTypeAdapter.write(jsonWriter, feedReply.getExtraType());
            jsonWriter.name("extra_pic");
            this.extraPicAdapter.write(jsonWriter, feedReply.getExtraPic());
            jsonWriter.name("extra_url");
            this.extraUrlAdapter.write(jsonWriter, feedReply.getExtraUrl());
            jsonWriter.name("userAction");
            this.userActionAdapter.write(jsonWriter, feedReply.getUserAction());
            jsonWriter.name("spamTime");
            this.spamTimeAdapter.write(jsonWriter, Long.valueOf(feedReply.getSpamTime()));
            jsonWriter.name("likeUsername");
            this.likeUserNameAdapter.write(jsonWriter, feedReply.getLikeUserName());
            jsonWriter.name("likeUid");
            this.likeUidAdapter.write(jsonWriter, feedReply.getLikeUid());
            jsonWriter.name("likeTime");
            this.likeTimeAdapter.write(jsonWriter, Long.valueOf(feedReply.getLikeTime()));
            jsonWriter.name("adminInfo");
            this.adminInfoAdapter.write(jsonWriter, feedReply.getAdminInfo());
            jsonWriter.name("likeAvatar");
            this.likeAvatarAdapter.write(jsonWriter, feedReply.getLikeAvatar());
            jsonWriter.name("extraFlag");
            this.extraFlagAdapter.write(jsonWriter, feedReply.getExtraFlag());
            jsonWriter.name("feed");
            this.replyFeedAdapter.write(jsonWriter, feedReply.getReplyFeed());
            jsonWriter.name("article");
            this.replyArticleAdapter.write(jsonWriter, feedReply.getReplyArticle());
            jsonWriter.name("innerInfo");
            this.innerInfoAdapter.write(jsonWriter, feedReply.getInnerInfo());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public FeedReply read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityTemplate;
            String str3 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str4 = this.defaultTitle;
            String str5 = this.defaultDescription;
            String str6 = this.defaultLogo;
            String str7 = this.defaultSubTitle;
            String str8 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str9 = this.defaultDeprecatedUserAvatar;
            String str10 = this.defaultDisplayUserName;
            String str11 = this.defaultId;
            String str12 = this.defaultFeedId;
            String str13 = this.defaultUid;
            String str14 = this.defaultDeprecatedUserName;
            UserInfo userInfo = this.defaultUserInfo;
            int i = this.defaultFtype;
            int i2 = this.defaultReplyId;
            String str15 = this.defaultReplyUserName;
            String str16 = this.defaultReplyUserAvatar;
            String str17 = this.defaultReplyUid;
            String str18 = this.defaultMessage;
            int i3 = this.defaultReplyNum;
            int i4 = this.defaultIsFeedAuthor;
            String str19 = this.defaultPic;
            String str20 = this.defaultMessageSource;
            String str21 = this.defaultUserAgent;
            String str22 = this.defaultUrl;
            String str23 = this.defaultFetchType;
            List<FeedReply> list = this.defaultReplyRows;
            int i5 = this.defaultReplyRowsCount;
            int i6 = this.defaultReplyRowsMore;
            String str24 = this.defaultParentReplyId;
            String str25 = this.defaultSpamReason;
            String str26 = this.defaultSpamContent;
            UserInfo userInfo2 = this.defaultLikeUserInfo;
            int i7 = this.defaultLikeNum;
            String str27 = this.defaultInfoHtml;
            int i8 = this.defaultIsFolded;
            int i9 = this.defaultBlockStatus;
            int i10 = this.defaultStatus;
            int i11 = this.defaultMessageStatus;
            String str28 = this.defaultStatusText;
            String str29 = this.defaultMessageStatusText;
            String str30 = this.defaultBlockStatusText;
            String str31 = this.defaultExtraTitle;
            String str32 = this.defaultExtraType;
            String str33 = this.defaultExtraPic;
            String str34 = this.defaultExtraUrl;
            FeedReply.ReplyUserAction replyUserAction = this.defaultUserAction;
            long j = this.defaultSpamTime;
            String str35 = this.defaultLikeUserName;
            String str36 = this.defaultLikeUid;
            long j2 = this.defaultLikeTime;
            String str37 = this.defaultAdminInfo;
            String str38 = this.defaultLikeAvatar;
            String str39 = this.defaultExtraFlag;
            FeedReply.ReplyFeed replyFeed = this.defaultReplyFeed;
            DyhArticle dyhArticle = this.defaultReplyArticle;
            SimpleInfo simpleInfo = this.defaultInnerInfo;
            String str40 = str38;
            String str41 = str3;
            Integer num2 = num;
            String str42 = str4;
            String str43 = str5;
            String str44 = str6;
            String str45 = str7;
            String str46 = str8;
            Long l4 = l2;
            Long l5 = l3;
            String str47 = str9;
            String str48 = str10;
            String str49 = str11;
            String str50 = str;
            String str51 = str12;
            String str52 = str13;
            String str53 = str14;
            UserInfo userInfo3 = userInfo;
            int i12 = i;
            int i13 = i2;
            String str54 = str15;
            String str55 = str16;
            String str56 = str17;
            String str57 = str18;
            int i14 = i3;
            int i15 = i4;
            String str58 = str19;
            String str59 = str20;
            String str60 = str21;
            String str61 = str22;
            String str62 = str23;
            List<FeedReply> list2 = list;
            int i16 = i5;
            int i17 = i6;
            String str63 = str24;
            String str64 = str25;
            String str65 = str26;
            UserInfo userInfo4 = userInfo2;
            int i18 = i7;
            String str66 = str27;
            int i19 = i8;
            int i20 = i9;
            int i21 = i10;
            int i22 = i11;
            String str67 = str28;
            String str68 = str29;
            String str69 = str30;
            String str70 = str31;
            String str71 = str32;
            String str72 = str33;
            String str73 = str34;
            String str74 = str2;
            FeedReply.ReplyUserAction replyUserAction2 = replyUserAction;
            long j3 = j;
            String str75 = str35;
            String str76 = str36;
            long j4 = j2;
            String str77 = str37;
            String str78 = str39;
            FeedReply.ReplyFeed replyFeed2 = replyFeed;
            DyhArticle dyhArticle2 = dyhArticle;
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
                        case -1907389992:
                            if (nextName.equals("replyRowsMore")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1724546052:
                            if (nextName.equals("description")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1634201648:
                            if (nextName.equals("likeAvatar")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1580301955:
                            if (nextName.equals("entityTemplate")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1460853832:
                            if (nextName.equals("displayUsername")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1237377772:
                            if (nextName.equals("fetchType")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -946093840:
                            if (nextName.equals("spamContent")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -892481550:
                            if (nextName.equals("status")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -804927211:
                            if (nextName.equals("is_folded")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -732377866:
                            if (nextName.equals("article")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -717007700:
                            if (nextName.equals("blockStatusText")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -645462302:
                            if (nextName.equals("messagesource")) {
                                c = 15;
                                break;
                            }
                            break;
                        case -601407516:
                            if (nextName.equals("block_status")) {
                                c = 16;
                                break;
                            }
                            break;
                        case -563842096:
                            if (nextName.equals("likeUserInfo")) {
                                c = 17;
                                break;
                            }
                            break;
                        case -562752115:
                            if (nextName.equals("likeUsername")) {
                                c = 18;
                                break;
                            }
                            break;
                        case -528282588:
                            if (nextName.equals("innerInfo")) {
                                c = 19;
                                break;
                            }
                            break;
                        case -433749021:
                            if (nextName.equals("replyRows")) {
                                c = 20;
                                break;
                            }
                            break;
                        case -429606820:
                            if (nextName.equals("replynum")) {
                                c = 21;
                                break;
                            }
                            break;
                        case -419037274:
                            if (nextName.equals("messageStatusText")) {
                                c = 22;
                                break;
                            }
                            break;
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = 23;
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = 24;
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = 25;
                                break;
                            }
                            break;
                        case -253722724:
                            if (nextName.equals("extraFlag")) {
                                c = 26;
                                break;
                            }
                            break;
                        case -252973861:
                            if (nextName.equals("extra_pic")) {
                                c = 27;
                                break;
                            }
                            break;
                        case -252968768:
                            if (nextName.equals("extra_url")) {
                                c = 28;
                                break;
                            }
                            break;
                        case -157092024:
                            if (nextName.equals("rusername")) {
                                c = 29;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 30;
                                break;
                            }
                            break;
                        case 101377:
                            if (nextName.equals("fid")) {
                                c = 31;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case 112909:
                            if (nextName.equals("rid")) {
                                c = '!';
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = '\"';
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = '#';
                                break;
                            }
                            break;
                        case 3138974:
                            if (nextName.equals("feed")) {
                                c = '$';
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = '%';
                                break;
                            }
                            break;
                        case 3509083:
                            if (nextName.equals("rrid")) {
                                c = '&';
                                break;
                            }
                            break;
                        case 3511966:
                            if (nextName.equals("ruid")) {
                                c = '\'';
                                break;
                            }
                            break;
                        case 21535901:
                            if (nextName.equals("adminInfo")) {
                                c = '(';
                                break;
                            }
                            break;
                        case 97774752:
                            if (nextName.equals("ftype")) {
                                c = ')';
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = '*';
                                break;
                            }
                            break;
                        case 174121273:
                            if (nextName.equals("likeUid")) {
                                c = '+';
                                break;
                            }
                            break;
                        case 174145679:
                            if (nextName.equals("likenum")) {
                                c = ',';
                                break;
                            }
                            break;
                        case 177592697:
                            if (nextName.equals("infoHtml")) {
                                c = '-';
                                break;
                            }
                            break;
                        case 248004671:
                            if (nextName.equals("statusText")) {
                                c = '.';
                                break;
                            }
                            break;
                        case 250747629:
                            if (nextName.equals("spamReason")) {
                                c = '/';
                                break;
                            }
                            break;
                        case 340983322:
                            if (nextName.equals("useragent")) {
                                c = '0';
                                break;
                            }
                            break;
                        case 747879945:
                            if (nextName.equals("extra_type")) {
                                c = '1';
                                break;
                            }
                            break;
                        case 954925063:
                            if (nextName.equals("message")) {
                                c = '2';
                                break;
                            }
                            break;
                        case 985211979:
                            if (nextName.equals("ravatar")) {
                                c = '3';
                                break;
                            }
                            break;
                        case 991220460:
                            if (nextName.equals("replyRowsCount")) {
                                c = '4';
                                break;
                            }
                            break;
                        case 1008404266:
                            if (nextName.equals("message_status")) {
                                c = '5';
                                break;
                            }
                            break;
                        case 1061163489:
                            if (nextName.equals("userAction")) {
                                c = '6';
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = '7';
                                break;
                            }
                            break;
                        case 1102762756:
                            if (nextName.equals("likeTime")) {
                                c = '8';
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = '9';
                                break;
                            }
                            break;
                        case 1708969321:
                            if (nextName.equals("extra_title")) {
                                c = ':';
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = ';';
                                break;
                            }
                            break;
                        case 1896202643:
                            if (nextName.equals("isFeedAuthor")) {
                                c = '<';
                                break;
                            }
                            break;
                        case 2056188342:
                            if (nextName.equals("spamTime")) {
                                c = '=';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str41 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str45 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            i17 = this.replyRowsMoreAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            str43 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str40 = this.likeAvatarAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str74 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str48 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str62 = this.fetchTypeAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str65 = this.spamContentAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str50 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 11:
                            i21 = this.statusAdapter.read(jsonReader).intValue();
                            continue;
                        case '\f':
                            i19 = this.isFoldedAdapter.read(jsonReader).intValue();
                            continue;
                        case '\r':
                            dyhArticle2 = this.replyArticleAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str69 = this.blockStatusTextAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str59 = this.messageSourceAdapter.read(jsonReader);
                            continue;
                        case 16:
                            i20 = this.blockStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 17:
                            userInfo4 = this.likeUserInfoAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str75 = this.likeUserNameAdapter.read(jsonReader);
                            continue;
                        case 19:
                            simpleInfo = this.innerInfoAdapter.read(jsonReader);
                            continue;
                        case 20:
                            list2 = this.replyRowsAdapter.read(jsonReader);
                            continue;
                        case 21:
                            i14 = this.replyNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 22:
                            str68 = this.messageStatusTextAdapter.read(jsonReader);
                            continue;
                        case 23:
                            userInfo3 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str53 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case 25:
                            str46 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 26:
                            str78 = this.extraFlagAdapter.read(jsonReader);
                            continue;
                        case 27:
                            str72 = this.extraPicAdapter.read(jsonReader);
                            continue;
                        case 28:
                            str73 = this.extraUrlAdapter.read(jsonReader);
                            continue;
                        case 29:
                            str54 = this.replyUserNameAdapter.read(jsonReader);
                            continue;
                        case 30:
                            str49 = this.idAdapter.read(jsonReader);
                            continue;
                        case 31:
                            str51 = this.feedIdAdapter.read(jsonReader);
                            continue;
                        case ' ':
                            str58 = this.picAdapter.read(jsonReader);
                            continue;
                        case '!':
                            i13 = this.replyIdAdapter.read(jsonReader).intValue();
                            continue;
                        case '\"':
                            str52 = this.uidAdapter.read(jsonReader);
                            continue;
                        case '#':
                            str61 = this.urlAdapter.read(jsonReader);
                            continue;
                        case '$':
                            replyFeed2 = this.replyFeedAdapter.read(jsonReader);
                            continue;
                        case '%':
                            str44 = this.logoAdapter.read(jsonReader);
                            continue;
                        case '&':
                            str63 = this.parentReplyIdAdapter.read(jsonReader);
                            continue;
                        case '\'':
                            str56 = this.replyUidAdapter.read(jsonReader);
                            continue;
                        case '(':
                            str77 = this.adminInfoAdapter.read(jsonReader);
                            continue;
                        case ')':
                            i12 = this.ftypeAdapter.read(jsonReader).intValue();
                            continue;
                        case '*':
                            str42 = this.titleAdapter.read(jsonReader);
                            continue;
                        case '+':
                            str76 = this.likeUidAdapter.read(jsonReader);
                            continue;
                        case ',':
                            i18 = this.likeNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '-':
                            str66 = this.infoHtmlAdapter.read(jsonReader);
                            continue;
                        case '.':
                            str67 = this.statusTextAdapter.read(jsonReader);
                            continue;
                        case '/':
                            str64 = this.spamReasonAdapter.read(jsonReader);
                            continue;
                        case '0':
                            str60 = this.userAgentAdapter.read(jsonReader);
                            continue;
                        case '1':
                            str71 = this.extraTypeAdapter.read(jsonReader);
                            continue;
                        case '2':
                            str57 = this.messageAdapter.read(jsonReader);
                            continue;
                        case '3':
                            str55 = this.replyUserAvatarAdapter.read(jsonReader);
                            continue;
                        case '4':
                            i16 = this.replyRowsCountAdapter.read(jsonReader).intValue();
                            continue;
                        case '5':
                            i22 = this.messageStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case '6':
                            replyUserAction2 = this.userActionAdapter.read(jsonReader);
                            continue;
                        case '7':
                            str47 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case '8':
                            j4 = this.likeTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case '9':
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case ':':
                            str70 = this.extraTitleAdapter.read(jsonReader);
                            continue;
                        case ';':
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case '<':
                            i15 = this.isFeedAuthorAdapter.read(jsonReader).intValue();
                            continue;
                        case '=':
                            j3 = this.spamTimeAdapter.read(jsonReader).longValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_FeedReply(str50, str74, str41, num2, str42, str43, str44, str45, str46, l4, l5, str47, str48, str49, str51, str52, str53, userInfo3, i12, i13, str54, str55, str56, str57, i14, i15, str58, str59, str60, str61, str62, list2, i16, i17, str63, str64, str65, userInfo4, i18, str66, i19, i20, i21, i22, str67, str68, str69, str70, str71, str72, str73, replyUserAction2, j3, str75, str76, j4, str77, str40, str78, replyFeed2, dyhArticle2, simpleInfo);
        }
    }
}
