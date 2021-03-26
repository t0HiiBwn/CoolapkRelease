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

/* renamed from: com.coolapk.market.model.$AutoValue_DyhArticle  reason: invalid class name */
abstract class C$AutoValue_DyhArticle extends C$$AutoValue_DyhArticle {
    C$AutoValue_DyhArticle(String str, String str2, String str3, int i, String str4, Integer num, String str5, String str6, String str7, Long l, Long l2, String str8, UserInfo userInfo, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i2, String str18, String str19, String str20, int i3, String str21, String str22, String str23, String str24, int i4, String str25, List<String> list, String str26, String str27, int i5, int i6, int i7, int i8, int i9, int i10, int i11, DyhModel dyhModel, List<FeedReply> list2, int i12, String str28, String str29, String str30, int i13, String str31, String str32, int i14, UserAction userAction, int i15, Long l3, Collection collection, CollectionItem collectionItem) {
        super(str, str2, str3, i, str4, num, str5, str6, str7, l, l2, str8, userInfo, str9, str10, str11, str12, str13, str14, str15, str16, str17, i2, str18, str19, str20, i3, str21, str22, str23, str24, i4, str25, list, str26, str27, i5, i6, i7, i8, i9, i10, i11, dyhModel, list2, i12, str28, str29, str30, i13, str31, str32, i14, userAction, i15, l3, collection, collectionItem);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_DyhArticle$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<DyhArticle> {
        private final TypeAdapter<String> adminInfoAdapter;
        private final TypeAdapter<String> authorAdapter;
        private final TypeAdapter<Integer> blockStatusAdapter;
        private final TypeAdapter<String> blockStatusTextAdapter;
        private final TypeAdapter<Collection> collectionInfoAdapter;
        private final TypeAdapter<CollectionItem> collectionItemAdapter;
        private final TypeAdapter<Integer> commentNumAdapter;
        private final TypeAdapter<String> contentAdapter;
        private final TypeAdapter<Long> creatDateAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private String defaultAdminInfo = null;
        private String defaultAuthor = null;
        private int defaultBlockStatus = 0;
        private String defaultBlockStatusText = null;
        private Collection defaultCollectionInfo = null;
        private CollectionItem defaultCollectionItem = null;
        private int defaultCommentNum = 0;
        private String defaultContent = null;
        private Long defaultCreatDate = null;
        private Long defaultDateline = null;
        private String defaultDeprecatedUserAvatar = null;
        private String defaultDeprecatedUserName = null;
        private String defaultDescription = null;
        private String defaultDisplayUserName = null;
        private String defaultDyhId = null;
        private DyhModel defaultDyhModel = null;
        private String defaultDyhName = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityType = null;
        private int defaultEntityTypeId = 0;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private int defaultFavNum = 0;
        private String defaultFeedId = null;
        private int defaultForwardNum = 0;
        private String defaultFromInfo = null;
        private String defaultId = null;
        private int defaultIsHeadline = 0;
        private int defaultIsHeadlineV8 = 0;
        private int defaultIsHtmlArticle = 0;
        private int defaultIsStickTop = 0;
        private String defaultKeywords = null;
        private Long defaultLastUpdate = null;
        private int defaultLikeNum = 0;
        private String defaultLogo = null;
        private String defaultMessage = null;
        private int defaultMessageStatus = 0;
        private String defaultMessageStatusText = null;
        private String defaultPic = null;
        private List<String> defaultPicArr = null;
        private String defaultRawUrl = null;
        private int defaultRecommend = 0;
        private String defaultRedirectUrl = null;
        private List<FeedReply> defaultReplyMeRows = Collections.emptyList();
        private int defaultReplyNum = 0;
        private int defaultShareNum = 0;
        private int defaultStatus = 0;
        private String defaultStatusText = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUid = null;
        private String defaultUrl = null;
        private String defaultUrlMD5 = null;
        private UserAction defaultUserAction = null;
        private UserInfo defaultUserInfo = null;
        private String defaultVideoUrl = null;
        private final TypeAdapter<String> deprecatedUserAvatarAdapter;
        private final TypeAdapter<String> deprecatedUserNameAdapter;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<String> displayUserNameAdapter;
        private final TypeAdapter<String> dyhIdAdapter;
        private final TypeAdapter<DyhModel> dyhModelAdapter;
        private final TypeAdapter<String> dyhNameAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<Integer> entityTypeIdAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<Integer> favNumAdapter;
        private final TypeAdapter<String> feedIdAdapter;
        private final TypeAdapter<Integer> forwardNumAdapter;
        private final TypeAdapter<String> fromInfoAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isHeadlineAdapter;
        private final TypeAdapter<Integer> isHeadlineV8Adapter;
        private final TypeAdapter<Integer> isHtmlArticleAdapter;
        private final TypeAdapter<Integer> isStickTopAdapter;
        private final TypeAdapter<String> keywordsAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<Integer> likeNumAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> messageAdapter;
        private final TypeAdapter<Integer> messageStatusAdapter;
        private final TypeAdapter<String> messageStatusTextAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<List<String>> picArrAdapter;
        private final TypeAdapter<String> rawUrlAdapter;
        private final TypeAdapter<Integer> recommendAdapter;
        private final TypeAdapter<String> redirectUrlAdapter;
        private final TypeAdapter<List<FeedReply>> replyMeRowsAdapter;
        private final TypeAdapter<Integer> replyNumAdapter;
        private final TypeAdapter<Integer> shareNumAdapter;
        private final TypeAdapter<Integer> statusAdapter;
        private final TypeAdapter<String> statusTextAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<String> urlMD5Adapter;
        private final TypeAdapter<UserAction> userActionAdapter;
        private final TypeAdapter<UserInfo> userInfoAdapter;
        private final TypeAdapter<String> videoUrlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityTypeIdAdapter = gson.getAdapter(Integer.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.deprecatedUserAvatarAdapter = gson.getAdapter(String.class);
            this.userInfoAdapter = gson.getAdapter(UserInfo.class);
            this.deprecatedUserNameAdapter = gson.getAdapter(String.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.dyhIdAdapter = gson.getAdapter(String.class);
            this.dyhNameAdapter = gson.getAdapter(String.class);
            this.feedIdAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.authorAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.forwardNumAdapter = gson.getAdapter(Integer.class);
            this.keywordsAdapter = gson.getAdapter(String.class);
            this.messageAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.shareNumAdapter = gson.getAdapter(Integer.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.urlMD5Adapter = gson.getAdapter(String.class);
            this.videoUrlAdapter = gson.getAdapter(String.class);
            this.redirectUrlAdapter = gson.getAdapter(String.class);
            this.isStickTopAdapter = gson.getAdapter(Integer.class);
            this.rawUrlAdapter = gson.getAdapter(String.class);
            this.picArrAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.picAdapter = gson.getAdapter(String.class);
            this.contentAdapter = gson.getAdapter(String.class);
            this.isHtmlArticleAdapter = gson.getAdapter(Integer.class);
            this.commentNumAdapter = gson.getAdapter(Integer.class);
            this.replyNumAdapter = gson.getAdapter(Integer.class);
            this.likeNumAdapter = gson.getAdapter(Integer.class);
            this.favNumAdapter = gson.getAdapter(Integer.class);
            this.blockStatusAdapter = gson.getAdapter(Integer.class);
            this.recommendAdapter = gson.getAdapter(Integer.class);
            this.dyhModelAdapter = gson.getAdapter(DyhModel.class);
            this.replyMeRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, FeedReply.class));
            this.isHeadlineAdapter = gson.getAdapter(Integer.class);
            this.adminInfoAdapter = gson.getAdapter(String.class);
            this.statusTextAdapter = gson.getAdapter(String.class);
            this.messageStatusTextAdapter = gson.getAdapter(String.class);
            this.messageStatusAdapter = gson.getAdapter(Integer.class);
            this.blockStatusTextAdapter = gson.getAdapter(String.class);
            this.fromInfoAdapter = gson.getAdapter(String.class);
            this.isHeadlineV8Adapter = gson.getAdapter(Integer.class);
            this.userActionAdapter = gson.getAdapter(UserAction.class);
            this.statusAdapter = gson.getAdapter(Integer.class);
            this.creatDateAdapter = gson.getAdapter(Long.class);
            this.collectionInfoAdapter = gson.getAdapter(Collection.class);
            this.collectionItemAdapter = gson.getAdapter(CollectionItem.class);
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

        public GsonTypeAdapter setDefaultEntityTypeId(int i) {
            this.defaultEntityTypeId = i;
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

        public GsonTypeAdapter setDefaultDateline(Long l) {
            this.defaultDateline = l;
            return this;
        }

        public GsonTypeAdapter setDefaultLastUpdate(Long l) {
            this.defaultLastUpdate = l;
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

        public GsonTypeAdapter setDefaultDeprecatedUserName(String str) {
            this.defaultDeprecatedUserName = str;
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

        public GsonTypeAdapter setDefaultDyhId(String str) {
            this.defaultDyhId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDyhName(String str) {
            this.defaultDyhName = str;
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

        public GsonTypeAdapter setDefaultAuthor(String str) {
            this.defaultAuthor = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultForwardNum(int i) {
            this.defaultForwardNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultKeywords(String str) {
            this.defaultKeywords = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessage(String str) {
            this.defaultMessage = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultShareNum(int i) {
            this.defaultShareNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrlMD5(String str) {
            this.defaultUrlMD5 = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVideoUrl(String str) {
            this.defaultVideoUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRedirectUrl(String str) {
            this.defaultRedirectUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsStickTop(int i) {
            this.defaultIsStickTop = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRawUrl(String str) {
            this.defaultRawUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPicArr(List<String> list) {
            this.defaultPicArr = list;
            return this;
        }

        public GsonTypeAdapter setDefaultPic(String str) {
            this.defaultPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultContent(String str) {
            this.defaultContent = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsHtmlArticle(int i) {
            this.defaultIsHtmlArticle = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentNum(int i) {
            this.defaultCommentNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyNum(int i) {
            this.defaultReplyNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultLikeNum(int i) {
            this.defaultLikeNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFavNum(int i) {
            this.defaultFavNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultBlockStatus(int i) {
            this.defaultBlockStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRecommend(int i) {
            this.defaultRecommend = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDyhModel(DyhModel dyhModel) {
            this.defaultDyhModel = dyhModel;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyMeRows(List<FeedReply> list) {
            this.defaultReplyMeRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultIsHeadline(int i) {
            this.defaultIsHeadline = i;
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

        public GsonTypeAdapter setDefaultMessageStatus(int i) {
            this.defaultMessageStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultBlockStatusText(String str) {
            this.defaultBlockStatusText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFromInfo(String str) {
            this.defaultFromInfo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsHeadlineV8(int i) {
            this.defaultIsHeadlineV8 = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUserAction(UserAction userAction) {
            this.defaultUserAction = userAction;
            return this;
        }

        public GsonTypeAdapter setDefaultStatus(int i) {
            this.defaultStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCreatDate(Long l) {
            this.defaultCreatDate = l;
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

        public void write(JsonWriter jsonWriter, DyhArticle dyhArticle) throws IOException {
            if (dyhArticle == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, dyhArticle.getEntityTypeName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, dyhArticle.getEntityType());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, dyhArticle.getEntityTemplate());
            jsonWriter.name("entityTypeId");
            this.entityTypeIdAdapter.write(jsonWriter, Integer.valueOf(dyhArticle.getEntityTypeId()));
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, dyhArticle.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, dyhArticle.getEntityFixed());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, dyhArticle.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, dyhArticle.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, dyhArticle.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, dyhArticle.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, dyhArticle.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, dyhArticle.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, dyhArticle.getUserInfo());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, dyhArticle.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, dyhArticle.getDisplayUserName());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, dyhArticle.getId());
            jsonWriter.name("dyh_id");
            this.dyhIdAdapter.write(jsonWriter, dyhArticle.getDyhId());
            jsonWriter.name("dyh_name");
            this.dyhNameAdapter.write(jsonWriter, dyhArticle.getDyhName());
            jsonWriter.name("feed_id");
            this.feedIdAdapter.write(jsonWriter, dyhArticle.getFeedId());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, dyhArticle.getUid());
            jsonWriter.name("author");
            this.authorAdapter.write(jsonWriter, dyhArticle.getAuthor());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, dyhArticle.getTitle());
            jsonWriter.name("forwardnum");
            this.forwardNumAdapter.write(jsonWriter, Integer.valueOf(dyhArticle.getForwardNum()));
            jsonWriter.name("keywords");
            this.keywordsAdapter.write(jsonWriter, dyhArticle.getKeywords());
            jsonWriter.name("message");
            this.messageAdapter.write(jsonWriter, dyhArticle.getMessage());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, dyhArticle.getDescription());
            jsonWriter.name("share_num");
            this.shareNumAdapter.write(jsonWriter, Integer.valueOf(dyhArticle.getShareNum()));
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, dyhArticle.getUrl());
            jsonWriter.name("url_md5");
            this.urlMD5Adapter.write(jsonWriter, dyhArticle.getUrlMD5());
            jsonWriter.name("video_url");
            this.videoUrlAdapter.write(jsonWriter, dyhArticle.getVideoUrl());
            jsonWriter.name("redirectUrl");
            this.redirectUrlAdapter.write(jsonWriter, dyhArticle.getRedirectUrl());
            jsonWriter.name("isStickTop");
            this.isStickTopAdapter.write(jsonWriter, Integer.valueOf(dyhArticle.getIsStickTop()));
            jsonWriter.name("rawUrl");
            this.rawUrlAdapter.write(jsonWriter, dyhArticle.getRawUrl());
            jsonWriter.name("picArr");
            this.picArrAdapter.write(jsonWriter, dyhArticle.getPicArr());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, dyhArticle.getPic());
            jsonWriter.name("content");
            this.contentAdapter.write(jsonWriter, dyhArticle.getContent());
            jsonWriter.name("is_html_article");
            this.isHtmlArticleAdapter.write(jsonWriter, Integer.valueOf(dyhArticle.getIsHtmlArticle()));
            jsonWriter.name("commentnum");
            this.commentNumAdapter.write(jsonWriter, Integer.valueOf(dyhArticle.getCommentNum()));
            jsonWriter.name("replynum");
            this.replyNumAdapter.write(jsonWriter, Integer.valueOf(dyhArticle.getReplyNum()));
            jsonWriter.name("likenum");
            this.likeNumAdapter.write(jsonWriter, Integer.valueOf(dyhArticle.getLikeNum()));
            jsonWriter.name("favnum");
            this.favNumAdapter.write(jsonWriter, Integer.valueOf(dyhArticle.getFavNum()));
            jsonWriter.name("block_status");
            this.blockStatusAdapter.write(jsonWriter, Integer.valueOf(dyhArticle.getBlockStatus()));
            jsonWriter.name("recommend");
            this.recommendAdapter.write(jsonWriter, Integer.valueOf(dyhArticle.getRecommend()));
            jsonWriter.name("dyh_info");
            this.dyhModelAdapter.write(jsonWriter, dyhArticle.getDyhModel());
            jsonWriter.name("replyMeRows");
            this.replyMeRowsAdapter.write(jsonWriter, dyhArticle.getReplyMeRows());
            jsonWriter.name("isHeadline");
            this.isHeadlineAdapter.write(jsonWriter, Integer.valueOf(dyhArticle.getIsHeadline()));
            jsonWriter.name("adminInfo");
            this.adminInfoAdapter.write(jsonWriter, dyhArticle.getAdminInfo());
            jsonWriter.name("statusText");
            this.statusTextAdapter.write(jsonWriter, dyhArticle.getStatusText());
            jsonWriter.name("messageStatusText");
            this.messageStatusTextAdapter.write(jsonWriter, dyhArticle.getMessageStatusText());
            jsonWriter.name("message_status");
            this.messageStatusAdapter.write(jsonWriter, Integer.valueOf(dyhArticle.getMessageStatus()));
            jsonWriter.name("blockStatusText");
            this.blockStatusTextAdapter.write(jsonWriter, dyhArticle.getBlockStatusText());
            jsonWriter.name("fromInfo");
            this.fromInfoAdapter.write(jsonWriter, dyhArticle.getFromInfo());
            jsonWriter.name("isHeadlineV8");
            this.isHeadlineV8Adapter.write(jsonWriter, Integer.valueOf(dyhArticle.getIsHeadlineV8()));
            jsonWriter.name("userAction");
            this.userActionAdapter.write(jsonWriter, dyhArticle.getUserAction());
            jsonWriter.name("status");
            this.statusAdapter.write(jsonWriter, Integer.valueOf(dyhArticle.getStatus()));
            jsonWriter.name("createdate");
            this.creatDateAdapter.write(jsonWriter, dyhArticle.getCreatDate());
            jsonWriter.name("collection_info");
            this.collectionInfoAdapter.write(jsonWriter, dyhArticle.getCollectionInfo());
            jsonWriter.name("collection_item_info");
            this.collectionItemAdapter.write(jsonWriter, dyhArticle.getCollectionItem());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public DyhArticle read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityType;
            String str3 = this.defaultEntityTemplate;
            int i = this.defaultEntityTypeId;
            String str4 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str5 = this.defaultLogo;
            String str6 = this.defaultSubTitle;
            String str7 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str8 = this.defaultDeprecatedUserAvatar;
            UserInfo userInfo = this.defaultUserInfo;
            String str9 = this.defaultDeprecatedUserName;
            String str10 = this.defaultDisplayUserName;
            String str11 = this.defaultId;
            String str12 = this.defaultDyhId;
            String str13 = this.defaultDyhName;
            String str14 = this.defaultFeedId;
            String str15 = this.defaultUid;
            String str16 = this.defaultAuthor;
            String str17 = this.defaultTitle;
            int i2 = this.defaultForwardNum;
            String str18 = this.defaultKeywords;
            String str19 = this.defaultMessage;
            String str20 = this.defaultDescription;
            int i3 = this.defaultShareNum;
            String str21 = this.defaultUrl;
            String str22 = this.defaultUrlMD5;
            String str23 = this.defaultVideoUrl;
            String str24 = this.defaultRedirectUrl;
            int i4 = this.defaultIsStickTop;
            String str25 = this.defaultRawUrl;
            List<String> list = this.defaultPicArr;
            String str26 = this.defaultPic;
            String str27 = this.defaultContent;
            int i5 = this.defaultIsHtmlArticle;
            int i6 = this.defaultCommentNum;
            int i7 = this.defaultReplyNum;
            int i8 = this.defaultLikeNum;
            int i9 = this.defaultFavNum;
            int i10 = this.defaultBlockStatus;
            int i11 = this.defaultRecommend;
            DyhModel dyhModel = this.defaultDyhModel;
            List<FeedReply> list2 = this.defaultReplyMeRows;
            int i12 = this.defaultIsHeadline;
            String str28 = this.defaultAdminInfo;
            String str29 = this.defaultStatusText;
            String str30 = this.defaultMessageStatusText;
            int i13 = this.defaultMessageStatus;
            String str31 = this.defaultBlockStatusText;
            String str32 = this.defaultFromInfo;
            int i14 = this.defaultIsHeadlineV8;
            UserAction userAction = this.defaultUserAction;
            int i15 = this.defaultStatus;
            Long l3 = this.defaultCreatDate;
            Collection collection = this.defaultCollectionInfo;
            CollectionItem collectionItem = this.defaultCollectionItem;
            String str33 = str2;
            String str34 = str3;
            int i16 = i;
            String str35 = str4;
            Integer num2 = num;
            String str36 = str5;
            String str37 = str6;
            String str38 = str7;
            Long l4 = l;
            Long l5 = l2;
            String str39 = str8;
            UserInfo userInfo2 = userInfo;
            String str40 = str9;
            String str41 = str;
            String str42 = str10;
            String str43 = str11;
            String str44 = str12;
            String str45 = str13;
            String str46 = str14;
            String str47 = str15;
            String str48 = str16;
            String str49 = str17;
            int i17 = i2;
            String str50 = str18;
            String str51 = str19;
            String str52 = str20;
            int i18 = i3;
            String str53 = str21;
            String str54 = str22;
            String str55 = str23;
            String str56 = str24;
            int i19 = i4;
            String str57 = str25;
            List<String> list3 = list;
            String str58 = str26;
            String str59 = str27;
            int i20 = i5;
            int i21 = i6;
            int i22 = i7;
            int i23 = i8;
            int i24 = i9;
            int i25 = i10;
            int i26 = i11;
            DyhModel dyhModel2 = dyhModel;
            List<FeedReply> list4 = list2;
            int i27 = i12;
            String str60 = str28;
            String str61 = str29;
            String str62 = str30;
            int i28 = i13;
            String str63 = str31;
            String str64 = str32;
            int i29 = i14;
            UserAction userAction2 = userAction;
            int i30 = i15;
            Long l6 = l3;
            Collection collection2 = collection;
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
                        case -1908329186:
                            if (nextName.equals("isHeadline")) {
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
                        case -1581702362:
                            if (nextName.equals("share_num")) {
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
                        case -1482998339:
                            if (nextName.equals("entityType")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1460853832:
                            if (nextName.equals("displayUsername")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1406328437:
                            if (nextName.equals("author")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -1317113241:
                            if (nextName.equals("dyh_id")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -1281587573:
                            if (nextName.equals("favnum")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -1244984456:
                            if (nextName.equals("fromInfo")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -988517257:
                            if (nextName.equals("picArr")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -976011428:
                            if (nextName.equals("feed_id")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -938032089:
                            if (nextName.equals("rawUrl")) {
                                c = 15;
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = 16;
                                break;
                            }
                            break;
                        case -892481550:
                            if (nextName.equals("status")) {
                                c = 17;
                                break;
                            }
                            break;
                        case -717007700:
                            if (nextName.equals("blockStatusText")) {
                                c = 18;
                                break;
                            }
                            break;
                        case -601407516:
                            if (nextName.equals("block_status")) {
                                c = 19;
                                break;
                            }
                            break;
                        case -429606820:
                            if (nextName.equals("replynum")) {
                                c = 20;
                                break;
                            }
                            break;
                        case -419037274:
                            if (nextName.equals("messageStatusText")) {
                                c = 21;
                                break;
                            }
                            break;
                        case -374464741:
                            if (nextName.equals("replyMeRows")) {
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
                        case -169850194:
                            if (nextName.equals("url_md5")) {
                                c = 26;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 27;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 28;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 29;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 30;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 31;
                                break;
                            }
                            break;
                        case 21535901:
                            if (nextName.equals("adminInfo")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case 46690368:
                            if (nextName.equals("isHeadlineV8")) {
                                c = '!';
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = '\"';
                                break;
                            }
                            break;
                        case 174145679:
                            if (nextName.equals("likenum")) {
                                c = '#';
                                break;
                            }
                            break;
                        case 248004671:
                            if (nextName.equals("statusText")) {
                                c = '$';
                                break;
                            }
                            break;
                        case 406262265:
                            if (nextName.equals("collection_item_info")) {
                                c = '%';
                                break;
                            }
                            break;
                        case 523149226:
                            if (nextName.equals("keywords")) {
                                c = '&';
                                break;
                            }
                            break;
                        case 607544993:
                            if (nextName.equals("forwardnum")) {
                                c = '\'';
                                break;
                            }
                            break;
                        case 738428399:
                            if (nextName.equals("isStickTop")) {
                                c = '(';
                                break;
                            }
                            break;
                        case 767740856:
                            if (nextName.equals("entityTypeId")) {
                                c = ')';
                                break;
                            }
                            break;
                        case 899165383:
                            if (nextName.equals("commentnum")) {
                                c = '*';
                                break;
                            }
                            break;
                        case 951530617:
                            if (nextName.equals("content")) {
                                c = '+';
                                break;
                            }
                            break;
                        case 954925063:
                            if (nextName.equals("message")) {
                                c = ',';
                                break;
                            }
                            break;
                        case 989204668:
                            if (nextName.equals("recommend")) {
                                c = '-';
                                break;
                            }
                            break;
                        case 1008404266:
                            if (nextName.equals("message_status")) {
                                c = '.';
                                break;
                            }
                            break;
                        case 1060168111:
                            if (nextName.equals("collection_info")) {
                                c = '/';
                                break;
                            }
                            break;
                        case 1061163489:
                            if (nextName.equals("userAction")) {
                                c = '0';
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = '1';
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = '2';
                                break;
                            }
                            break;
                        case 1269540602:
                            if (nextName.equals("dyh_info")) {
                                c = '3';
                                break;
                            }
                            break;
                        case 1269677271:
                            if (nextName.equals("dyh_name")) {
                                c = '4';
                                break;
                            }
                            break;
                        case 1333285803:
                            if (nextName.equals("video_url")) {
                                c = '5';
                                break;
                            }
                            break;
                        case 1369682602:
                            if (nextName.equals("createdate")) {
                                c = '6';
                                break;
                            }
                            break;
                        case 1561866583:
                            if (nextName.equals("is_html_article")) {
                                c = '7';
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = '8';
                                break;
                            }
                            break;
                        case 1970337779:
                            if (nextName.equals("redirectUrl")) {
                                c = '9';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str35 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str37 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            i27 = this.isHeadlineAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            str52 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 4:
                            i18 = this.shareNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 5:
                            str34 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str33 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str42 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str48 = this.authorAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str44 = this.dyhIdAdapter.read(jsonReader);
                            continue;
                        case 11:
                            i24 = this.favNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '\f':
                            str64 = this.fromInfoAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            list3 = this.picArrAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str46 = this.feedIdAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str57 = this.rawUrlAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str41 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 17:
                            i30 = this.statusAdapter.read(jsonReader).intValue();
                            continue;
                        case 18:
                            str63 = this.blockStatusTextAdapter.read(jsonReader);
                            continue;
                        case 19:
                            i25 = this.blockStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 20:
                            i22 = this.replyNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 21:
                            str62 = this.messageStatusTextAdapter.read(jsonReader);
                            continue;
                        case 22:
                            list4 = this.replyMeRowsAdapter.read(jsonReader);
                            continue;
                        case 23:
                            userInfo2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str40 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case 25:
                            str38 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 26:
                            str54 = this.urlMD5Adapter.read(jsonReader);
                            continue;
                        case 27:
                            str43 = this.idAdapter.read(jsonReader);
                            continue;
                        case 28:
                            str58 = this.picAdapter.read(jsonReader);
                            continue;
                        case 29:
                            str47 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 30:
                            str53 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 31:
                            str36 = this.logoAdapter.read(jsonReader);
                            continue;
                        case ' ':
                            str60 = this.adminInfoAdapter.read(jsonReader);
                            continue;
                        case '!':
                            i29 = this.isHeadlineV8Adapter.read(jsonReader).intValue();
                            continue;
                        case '\"':
                            str49 = this.titleAdapter.read(jsonReader);
                            continue;
                        case '#':
                            i23 = this.likeNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '$':
                            str61 = this.statusTextAdapter.read(jsonReader);
                            continue;
                        case '%':
                            collectionItem = this.collectionItemAdapter.read(jsonReader);
                            continue;
                        case '&':
                            str50 = this.keywordsAdapter.read(jsonReader);
                            continue;
                        case '\'':
                            i17 = this.forwardNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '(':
                            i19 = this.isStickTopAdapter.read(jsonReader).intValue();
                            continue;
                        case ')':
                            i16 = this.entityTypeIdAdapter.read(jsonReader).intValue();
                            continue;
                        case '*':
                            i21 = this.commentNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '+':
                            str59 = this.contentAdapter.read(jsonReader);
                            continue;
                        case ',':
                            str51 = this.messageAdapter.read(jsonReader);
                            continue;
                        case '-':
                            i26 = this.recommendAdapter.read(jsonReader).intValue();
                            continue;
                        case '.':
                            i28 = this.messageStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case '/':
                            collection2 = this.collectionInfoAdapter.read(jsonReader);
                            continue;
                        case '0':
                            userAction2 = this.userActionAdapter.read(jsonReader);
                            continue;
                        case '1':
                            str39 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case '2':
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case '3':
                            dyhModel2 = this.dyhModelAdapter.read(jsonReader);
                            continue;
                        case '4':
                            str45 = this.dyhNameAdapter.read(jsonReader);
                            continue;
                        case '5':
                            str55 = this.videoUrlAdapter.read(jsonReader);
                            continue;
                        case '6':
                            l6 = this.creatDateAdapter.read(jsonReader);
                            continue;
                        case '7':
                            i20 = this.isHtmlArticleAdapter.read(jsonReader).intValue();
                            continue;
                        case '8':
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case '9':
                            str56 = this.redirectUrlAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_DyhArticle(str41, str33, str34, i16, str35, num2, str36, str37, str38, l4, l5, str39, userInfo2, str40, str42, str43, str44, str45, str46, str47, str48, str49, i17, str50, str51, str52, i18, str53, str54, str55, str56, i19, str57, list3, str58, str59, i20, i21, i22, i23, i24, i25, i26, dyhModel2, list4, i27, str60, str61, str62, i28, str63, str64, i29, userAction2, i30, l6, collection2, collectionItem);
        }
    }
}
