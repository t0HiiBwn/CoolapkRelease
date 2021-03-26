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

/* renamed from: com.coolapk.market.model.$AutoValue_Album  reason: invalid class name */
abstract class C$AutoValue_Album extends C$$AutoValue_Album {
    C$AutoValue_Album(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, Long l2, Long l3, String str9, UserInfo userInfo, String str10, String str11, String str12, String str13, String str14, String str15, String str16, UserInfo userInfo2, String str17, String str18, long j, String str19, String str20, int i, String str21, int i2, int i3, int i4, int i5, int i6, int i7, String str22, int i8, String str23, int i9, String str24, int i10, String str25, String str26, List<AlbumItem> list, String str27, Collection collection, CollectionItem collectionItem, List<FeedReply> list2, UserAction userAction, List<FeedReply> list3, int i11, FeedStatus feedStatus, SimpleInfo simpleInfo, SimpleInfo simpleInfo2) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, l2, l3, str9, userInfo, str10, str11, str12, str13, str14, str15, str16, userInfo2, str17, str18, j, str19, str20, i, str21, i2, i3, i4, i5, i6, i7, str22, i8, str23, i9, str24, i10, str25, str26, list, str27, collection, collectionItem, list2, userAction, list3, i11, feedStatus, simpleInfo, simpleInfo2);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Album$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Album> {
        private final TypeAdapter<List<FeedReply>> albumHotRepliesAdapter;
        private final TypeAdapter<List<AlbumItem>> albumItemsAdapter;
        private final TypeAdapter<String> albumUrlAdapter;
        private final TypeAdapter<Collection> collectionInfoAdapter;
        private final TypeAdapter<CollectionItem> collectionItemAdapter;
        private final TypeAdapter<Integer> commentBlockNumAdapter;
        private final TypeAdapter<Integer> commentNumAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private List<FeedReply> defaultAlbumHotReplies = Collections.emptyList();
        private List<AlbumItem> defaultAlbumItems = null;
        private String defaultAlbumUrl = null;
        private Collection defaultCollectionInfo = null;
        private CollectionItem defaultCollectionItem = null;
        private int defaultCommentBlockNum = 0;
        private int defaultCommentNum = 0;
        private Long defaultDateline = null;
        private String defaultDeprecatedUserAvatar = null;
        private String defaultDeprecatedUserName = null;
        private String defaultDescription = null;
        private String defaultDeviceTitle = null;
        private String defaultDisplayUserName = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private int defaultFavoriteNum = 0;
        private String defaultFeedId = null;
        private FeedStatus defaultFeedStatus = null;
        private int defaultForwardNum = 0;
        private String defaultIcon = null;
        private String defaultId = null;
        private String defaultInfo = null;
        private String defaultInfoHtml = null;
        private SimpleInfo defaultInnerInfo = null;
        private String defaultIntroduce = null;
        private int defaultIsStickTop = 0;
        private String defaultKeyWords = null;
        private Long defaultLastUpdate = null;
        private String defaultLikeAvatar = null;
        private int defaultLikeNum = 0;
        private long defaultLikeTime = 0;
        private String defaultLikeUid = null;
        private UserInfo defaultLikeUserInfo = null;
        private String defaultLikeUserName = null;
        private String defaultLogo = null;
        private String defaultMoreCount = null;
        private String defaultPic = null;
        private int defaultRecommend = 0;
        private List<FeedReply> defaultReplyMeRows = Collections.emptyList();
        private int defaultReplyNum = 0;
        private int defaultShareNum = 0;
        private int defaultStatus = 0;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private SimpleInfo defaultTopInfo = null;
        private int defaultTotalApkNum = 0;
        private String defaultUid = null;
        private String defaultUrl = null;
        private UserAction defaultUserAction = null;
        private UserInfo defaultUserInfo = null;
        private final TypeAdapter<String> deprecatedUserAvatarAdapter;
        private final TypeAdapter<String> deprecatedUserNameAdapter;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<String> deviceTitleAdapter;
        private final TypeAdapter<String> displayUserNameAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<Integer> favoriteNumAdapter;
        private final TypeAdapter<String> feedIdAdapter;
        private final TypeAdapter<FeedStatus> feedStatusAdapter;
        private final TypeAdapter<Integer> forwardNumAdapter;
        private final TypeAdapter<String> iconAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> infoAdapter;
        private final TypeAdapter<String> infoHtmlAdapter;
        private final TypeAdapter<SimpleInfo> innerInfoAdapter;
        private final TypeAdapter<String> introduceAdapter;
        private final TypeAdapter<Integer> isStickTopAdapter;
        private final TypeAdapter<String> keyWordsAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> likeAvatarAdapter;
        private final TypeAdapter<Integer> likeNumAdapter;
        private final TypeAdapter<Long> likeTimeAdapter;
        private final TypeAdapter<String> likeUidAdapter;
        private final TypeAdapter<UserInfo> likeUserInfoAdapter;
        private final TypeAdapter<String> likeUserNameAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> moreCountAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<Integer> recommendAdapter;
        private final TypeAdapter<List<FeedReply>> replyMeRowsAdapter;
        private final TypeAdapter<Integer> replyNumAdapter;
        private final TypeAdapter<Integer> shareNumAdapter;
        private final TypeAdapter<Integer> statusAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<SimpleInfo> topInfoAdapter;
        private final TypeAdapter<Integer> totalApkNumAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<UserAction> userActionAdapter;
        private final TypeAdapter<UserInfo> userInfoAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.deprecatedUserAvatarAdapter = gson.getAdapter(String.class);
            this.userInfoAdapter = gson.getAdapter(UserInfo.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.deprecatedUserNameAdapter = gson.getAdapter(String.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.feedIdAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.likeAvatarAdapter = gson.getAdapter(String.class);
            this.likeUserInfoAdapter = gson.getAdapter(UserInfo.class);
            this.likeUserNameAdapter = gson.getAdapter(String.class);
            this.likeUidAdapter = gson.getAdapter(String.class);
            this.likeTimeAdapter = gson.getAdapter(Long.class);
            this.iconAdapter = gson.getAdapter(String.class);
            this.keyWordsAdapter = gson.getAdapter(String.class);
            this.shareNumAdapter = gson.getAdapter(Integer.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.recommendAdapter = gson.getAdapter(Integer.class);
            this.totalApkNumAdapter = gson.getAdapter(Integer.class);
            this.favoriteNumAdapter = gson.getAdapter(Integer.class);
            this.commentNumAdapter = gson.getAdapter(Integer.class);
            this.forwardNumAdapter = gson.getAdapter(Integer.class);
            this.replyNumAdapter = gson.getAdapter(Integer.class);
            this.deviceTitleAdapter = gson.getAdapter(String.class);
            this.statusAdapter = gson.getAdapter(Integer.class);
            this.albumUrlAdapter = gson.getAdapter(String.class);
            this.likeNumAdapter = gson.getAdapter(Integer.class);
            this.introduceAdapter = gson.getAdapter(String.class);
            this.commentBlockNumAdapter = gson.getAdapter(Integer.class);
            this.infoHtmlAdapter = gson.getAdapter(String.class);
            this.infoAdapter = gson.getAdapter(String.class);
            this.albumItemsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, AlbumItem.class));
            this.moreCountAdapter = gson.getAdapter(String.class);
            this.collectionInfoAdapter = gson.getAdapter(Collection.class);
            this.collectionItemAdapter = gson.getAdapter(CollectionItem.class);
            this.albumHotRepliesAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, FeedReply.class));
            this.userActionAdapter = gson.getAdapter(UserAction.class);
            this.replyMeRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, FeedReply.class));
            this.isStickTopAdapter = gson.getAdapter(Integer.class);
            this.feedStatusAdapter = gson.getAdapter(FeedStatus.class);
            this.topInfoAdapter = gson.getAdapter(SimpleInfo.class);
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

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPic(String str) {
            this.defaultPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSubTitle(String str) {
            this.defaultSubTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
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

        public GsonTypeAdapter setDefaultFeedId(String str) {
            this.defaultFeedId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLikeAvatar(String str) {
            this.defaultLikeAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLikeUserInfo(UserInfo userInfo) {
            this.defaultLikeUserInfo = userInfo;
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

        public GsonTypeAdapter setDefaultIcon(String str) {
            this.defaultIcon = str;
            return this;
        }

        public GsonTypeAdapter setDefaultKeyWords(String str) {
            this.defaultKeyWords = str;
            return this;
        }

        public GsonTypeAdapter setDefaultShareNum(int i) {
            this.defaultShareNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRecommend(int i) {
            this.defaultRecommend = i;
            return this;
        }

        public GsonTypeAdapter setDefaultTotalApkNum(int i) {
            this.defaultTotalApkNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFavoriteNum(int i) {
            this.defaultFavoriteNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentNum(int i) {
            this.defaultCommentNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultForwardNum(int i) {
            this.defaultForwardNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyNum(int i) {
            this.defaultReplyNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDeviceTitle(String str) {
            this.defaultDeviceTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultStatus(int i) {
            this.defaultStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultAlbumUrl(String str) {
            this.defaultAlbumUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLikeNum(int i) {
            this.defaultLikeNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIntroduce(String str) {
            this.defaultIntroduce = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentBlockNum(int i) {
            this.defaultCommentBlockNum = i;
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

        public GsonTypeAdapter setDefaultAlbumItems(List<AlbumItem> list) {
            this.defaultAlbumItems = list;
            return this;
        }

        public GsonTypeAdapter setDefaultMoreCount(String str) {
            this.defaultMoreCount = str;
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

        public GsonTypeAdapter setDefaultAlbumHotReplies(List<FeedReply> list) {
            this.defaultAlbumHotReplies = list;
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

        public GsonTypeAdapter setDefaultIsStickTop(int i) {
            this.defaultIsStickTop = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedStatus(FeedStatus feedStatus) {
            this.defaultFeedStatus = feedStatus;
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

        public void write(JsonWriter jsonWriter, Album album) throws IOException {
            if (album == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, album.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, album.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, album.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, album.getEntityFixed());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, album.getUrl());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, album.getPic());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, album.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, album.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, album.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, album.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, album.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, album.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, album.getUserInfo());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, album.getUid());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, album.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, album.getDisplayUserName());
            jsonWriter.name("feedid");
            this.feedIdAdapter.write(jsonWriter, album.getFeedId());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, album.getTitle());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, album.getLogo());
            jsonWriter.name("likeAvatar");
            this.likeAvatarAdapter.write(jsonWriter, album.getLikeAvatar());
            jsonWriter.name("likeUserInfo");
            this.likeUserInfoAdapter.write(jsonWriter, album.getLikeUserInfo());
            jsonWriter.name("likeUsername");
            this.likeUserNameAdapter.write(jsonWriter, album.getLikeUserName());
            jsonWriter.name("likeUid");
            this.likeUidAdapter.write(jsonWriter, album.getLikeUid());
            jsonWriter.name("likeTime");
            this.likeTimeAdapter.write(jsonWriter, Long.valueOf(album.getLikeTime()));
            jsonWriter.name("icon");
            this.iconAdapter.write(jsonWriter, album.getIcon());
            jsonWriter.name("keywords");
            this.keyWordsAdapter.write(jsonWriter, album.getKeyWords());
            jsonWriter.name("share_num");
            this.shareNumAdapter.write(jsonWriter, Integer.valueOf(album.getShareNum()));
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, album.getDescription());
            jsonWriter.name("recommend");
            this.recommendAdapter.write(jsonWriter, Integer.valueOf(album.getRecommend()));
            jsonWriter.name("apknum");
            this.totalApkNumAdapter.write(jsonWriter, Integer.valueOf(album.getTotalApkNum()));
            jsonWriter.name("favnum");
            this.favoriteNumAdapter.write(jsonWriter, Integer.valueOf(album.getFavoriteNum()));
            jsonWriter.name("commentnum");
            this.commentNumAdapter.write(jsonWriter, Integer.valueOf(album.getCommentNum()));
            jsonWriter.name("forwardnum");
            this.forwardNumAdapter.write(jsonWriter, Integer.valueOf(album.getForwardNum()));
            jsonWriter.name("replynum");
            this.replyNumAdapter.write(jsonWriter, Integer.valueOf(album.getReplyNum()));
            jsonWriter.name("device_title");
            this.deviceTitleAdapter.write(jsonWriter, album.getDeviceTitle());
            jsonWriter.name("status");
            this.statusAdapter.write(jsonWriter, Integer.valueOf(album.getStatus()));
            jsonWriter.name("albumUrl");
            this.albumUrlAdapter.write(jsonWriter, album.getAlbumUrl());
            jsonWriter.name("likenum");
            this.likeNumAdapter.write(jsonWriter, Integer.valueOf(album.getLikeNum()));
            jsonWriter.name("intro");
            this.introduceAdapter.write(jsonWriter, album.getIntroduce());
            jsonWriter.name("comment_block_num");
            this.commentBlockNumAdapter.write(jsonWriter, Integer.valueOf(album.getCommentBlockNum()));
            jsonWriter.name("infoHtml");
            this.infoHtmlAdapter.write(jsonWriter, album.getInfoHtml());
            jsonWriter.name("info");
            this.infoAdapter.write(jsonWriter, album.getInfo());
            jsonWriter.name("apkRows");
            this.albumItemsAdapter.write(jsonWriter, album.getAlbumItems());
            jsonWriter.name("apkRowsMoreCount");
            this.moreCountAdapter.write(jsonWriter, album.getMoreCount());
            jsonWriter.name("collection_info");
            this.collectionInfoAdapter.write(jsonWriter, album.getCollectionInfo());
            jsonWriter.name("collection_item_info");
            this.collectionItemAdapter.write(jsonWriter, album.getCollectionItem());
            jsonWriter.name("albumHotReplies");
            this.albumHotRepliesAdapter.write(jsonWriter, album.getAlbumHotReplies());
            jsonWriter.name("userAction");
            this.userActionAdapter.write(jsonWriter, album.getUserAction());
            jsonWriter.name("replyMeRows");
            this.replyMeRowsAdapter.write(jsonWriter, album.getReplyMeRows());
            jsonWriter.name("isStickTop");
            this.isStickTopAdapter.write(jsonWriter, Integer.valueOf(album.getIsStickTop()));
            jsonWriter.name("feedStatus");
            this.feedStatusAdapter.write(jsonWriter, album.getFeedStatus());
            jsonWriter.name("topInfo");
            this.topInfoAdapter.write(jsonWriter, album.getTopInfo());
            jsonWriter.name("innerInfo");
            this.innerInfoAdapter.write(jsonWriter, album.getInnerInfo());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Album read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityTemplate;
            String str3 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str4 = this.defaultUrl;
            String str5 = this.defaultPic;
            String str6 = this.defaultSubTitle;
            String str7 = this.defaultId;
            String str8 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str9 = this.defaultDeprecatedUserAvatar;
            UserInfo userInfo = this.defaultUserInfo;
            String str10 = this.defaultUid;
            String str11 = this.defaultDeprecatedUserName;
            String str12 = this.defaultDisplayUserName;
            String str13 = this.defaultFeedId;
            String str14 = this.defaultTitle;
            String str15 = this.defaultLogo;
            String str16 = this.defaultLikeAvatar;
            UserInfo userInfo2 = this.defaultLikeUserInfo;
            String str17 = this.defaultLikeUserName;
            String str18 = this.defaultLikeUid;
            long j = this.defaultLikeTime;
            String str19 = this.defaultIcon;
            String str20 = this.defaultKeyWords;
            int i = this.defaultShareNum;
            String str21 = this.defaultDescription;
            int i2 = this.defaultRecommend;
            int i3 = this.defaultTotalApkNum;
            int i4 = this.defaultFavoriteNum;
            int i5 = this.defaultCommentNum;
            int i6 = this.defaultForwardNum;
            int i7 = this.defaultReplyNum;
            String str22 = this.defaultDeviceTitle;
            int i8 = this.defaultStatus;
            String str23 = this.defaultAlbumUrl;
            int i9 = this.defaultLikeNum;
            String str24 = this.defaultIntroduce;
            int i10 = this.defaultCommentBlockNum;
            String str25 = this.defaultInfoHtml;
            String str26 = this.defaultInfo;
            List<AlbumItem> list = this.defaultAlbumItems;
            String str27 = this.defaultMoreCount;
            Collection collection = this.defaultCollectionInfo;
            CollectionItem collectionItem = this.defaultCollectionItem;
            List<FeedReply> list2 = this.defaultAlbumHotReplies;
            UserAction userAction = this.defaultUserAction;
            List<FeedReply> list3 = this.defaultReplyMeRows;
            int i11 = this.defaultIsStickTop;
            FeedStatus feedStatus = this.defaultFeedStatus;
            SimpleInfo simpleInfo = this.defaultTopInfo;
            SimpleInfo simpleInfo2 = this.defaultInnerInfo;
            String str28 = str20;
            String str29 = str3;
            Integer num2 = num;
            String str30 = str4;
            String str31 = str5;
            String str32 = str6;
            String str33 = str7;
            String str34 = str8;
            Long l4 = l2;
            Long l5 = l3;
            String str35 = str9;
            UserInfo userInfo3 = userInfo;
            String str36 = str10;
            String str37 = str;
            String str38 = str11;
            String str39 = str12;
            String str40 = str13;
            String str41 = str14;
            String str42 = str15;
            String str43 = str16;
            UserInfo userInfo4 = userInfo2;
            String str44 = str17;
            String str45 = str2;
            String str46 = str18;
            long j2 = j;
            String str47 = str19;
            int i12 = i;
            String str48 = str21;
            int i13 = i2;
            int i14 = i3;
            int i15 = i4;
            int i16 = i5;
            int i17 = i6;
            int i18 = i7;
            String str49 = str22;
            int i19 = i8;
            String str50 = str23;
            int i20 = i9;
            String str51 = str24;
            int i21 = i10;
            String str52 = str25;
            String str53 = str26;
            List<AlbumItem> list4 = list;
            String str54 = str27;
            Collection collection2 = collection;
            CollectionItem collectionItem2 = collectionItem;
            List<FeedReply> list5 = list2;
            UserAction userAction2 = userAction;
            List<FeedReply> list6 = list3;
            int i22 = i11;
            FeedStatus feedStatus2 = feedStatus;
            SimpleInfo simpleInfo3 = simpleInfo;
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
                        case -1724546052:
                            if (nextName.equals("description")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1634201648:
                            if (nextName.equals("likeAvatar")) {
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
                        case -1460853832:
                            if (nextName.equals("displayUsername")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1411208214:
                            if (nextName.equals("apknum")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1281587573:
                            if (nextName.equals("favnum")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -1278409927:
                            if (nextName.equals("feedid")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -1140201565:
                            if (nextName.equals("topInfo")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -1052862427:
                            if (nextName.equals("apkRowsMoreCount")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -892481550:
                            if (nextName.equals("status")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -798621163:
                            if (nextName.equals("apkRows")) {
                                c = 15;
                                break;
                            }
                            break;
                        case -584774865:
                            if (nextName.equals("device_title")) {
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
                        case -429606820:
                            if (nextName.equals("replynum")) {
                                c = 20;
                                break;
                            }
                            break;
                        case -374464741:
                            if (nextName.equals("replyMeRows")) {
                                c = 21;
                                break;
                            }
                            break;
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = 22;
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = 23;
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = 24;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 25;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 26;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 27;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 28;
                                break;
                            }
                            break;
                        case 3226745:
                            if (nextName.equals("icon")) {
                                c = 29;
                                break;
                            }
                            break;
                        case 3237038:
                            if (nextName.equals("info")) {
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
                        case 100361836:
                            if (nextName.equals("intro")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = '!';
                                break;
                            }
                            break;
                        case 174121273:
                            if (nextName.equals("likeUid")) {
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
                        case 177592697:
                            if (nextName.equals("infoHtml")) {
                                c = '$';
                                break;
                            }
                            break;
                        case 238777136:
                            if (nextName.equals("feedStatus")) {
                                c = '%';
                                break;
                            }
                            break;
                        case 406262265:
                            if (nextName.equals("collection_item_info")) {
                                c = '&';
                                break;
                            }
                            break;
                        case 523149226:
                            if (nextName.equals("keywords")) {
                                c = '\'';
                                break;
                            }
                            break;
                        case 607544993:
                            if (nextName.equals("forwardnum")) {
                                c = '(';
                                break;
                            }
                            break;
                        case 683233012:
                            if (nextName.equals("comment_block_num")) {
                                c = ')';
                                break;
                            }
                            break;
                        case 738428399:
                            if (nextName.equals("isStickTop")) {
                                c = '*';
                                break;
                            }
                            break;
                        case 899165383:
                            if (nextName.equals("commentnum")) {
                                c = '+';
                                break;
                            }
                            break;
                        case 989204668:
                            if (nextName.equals("recommend")) {
                                c = ',';
                                break;
                            }
                            break;
                        case 1060168111:
                            if (nextName.equals("collection_info")) {
                                c = '-';
                                break;
                            }
                            break;
                        case 1061163489:
                            if (nextName.equals("userAction")) {
                                c = '.';
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = '/';
                                break;
                            }
                            break;
                        case 1102762756:
                            if (nextName.equals("likeTime")) {
                                c = '0';
                                break;
                            }
                            break;
                        case 1111437258:
                            if (nextName.equals("albumHotReplies")) {
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
                        case 1532068992:
                            if (nextName.equals("albumUrl")) {
                                c = '3';
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = '4';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str29 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str32 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str48 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str43 = this.likeAvatarAdapter.read(jsonReader);
                            continue;
                        case 4:
                            i12 = this.shareNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 5:
                            str45 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str39 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            i14 = this.totalApkNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '\b':
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            i15 = this.favoriteNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '\n':
                            str40 = this.feedIdAdapter.read(jsonReader);
                            continue;
                        case 11:
                            simpleInfo3 = this.topInfoAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str54 = this.moreCountAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str37 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 14:
                            i19 = this.statusAdapter.read(jsonReader).intValue();
                            continue;
                        case 15:
                            list4 = this.albumItemsAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str49 = this.deviceTitleAdapter.read(jsonReader);
                            continue;
                        case 17:
                            userInfo4 = this.likeUserInfoAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str44 = this.likeUserNameAdapter.read(jsonReader);
                            continue;
                        case 19:
                            simpleInfo2 = this.innerInfoAdapter.read(jsonReader);
                            continue;
                        case 20:
                            i18 = this.replyNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 21:
                            list6 = this.replyMeRowsAdapter.read(jsonReader);
                            continue;
                        case 22:
                            userInfo3 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case 23:
                            str38 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str34 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 25:
                            str33 = this.idAdapter.read(jsonReader);
                            continue;
                        case 26:
                            str31 = this.picAdapter.read(jsonReader);
                            continue;
                        case 27:
                            str36 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 28:
                            str30 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 29:
                            str47 = this.iconAdapter.read(jsonReader);
                            continue;
                        case 30:
                            str53 = this.infoAdapter.read(jsonReader);
                            continue;
                        case 31:
                            str42 = this.logoAdapter.read(jsonReader);
                            continue;
                        case ' ':
                            str51 = this.introduceAdapter.read(jsonReader);
                            continue;
                        case '!':
                            str41 = this.titleAdapter.read(jsonReader);
                            continue;
                        case '\"':
                            str46 = this.likeUidAdapter.read(jsonReader);
                            continue;
                        case '#':
                            i20 = this.likeNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '$':
                            str52 = this.infoHtmlAdapter.read(jsonReader);
                            continue;
                        case '%':
                            feedStatus2 = this.feedStatusAdapter.read(jsonReader);
                            continue;
                        case '&':
                            collectionItem2 = this.collectionItemAdapter.read(jsonReader);
                            continue;
                        case '\'':
                            str28 = this.keyWordsAdapter.read(jsonReader);
                            continue;
                        case '(':
                            i17 = this.forwardNumAdapter.read(jsonReader).intValue();
                            continue;
                        case ')':
                            i21 = this.commentBlockNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '*':
                            i22 = this.isStickTopAdapter.read(jsonReader).intValue();
                            continue;
                        case '+':
                            i16 = this.commentNumAdapter.read(jsonReader).intValue();
                            continue;
                        case ',':
                            i13 = this.recommendAdapter.read(jsonReader).intValue();
                            continue;
                        case '-':
                            collection2 = this.collectionInfoAdapter.read(jsonReader);
                            continue;
                        case '.':
                            userAction2 = this.userActionAdapter.read(jsonReader);
                            continue;
                        case '/':
                            str35 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case '0':
                            j2 = this.likeTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case '1':
                            list5 = this.albumHotRepliesAdapter.read(jsonReader);
                            continue;
                        case '2':
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case '3':
                            str50 = this.albumUrlAdapter.read(jsonReader);
                            continue;
                        case '4':
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Album(str37, str45, str29, num2, str30, str31, str32, str33, str34, l4, l5, str35, userInfo3, str36, str38, str39, str40, str41, str42, str43, userInfo4, str44, str46, j2, str47, str28, i12, str48, i13, i14, i15, i16, i17, i18, str49, i19, str50, i20, str51, i21, str52, str53, list4, str54, collection2, collectionItem2, list5, userAction2, list6, i22, feedStatus2, simpleInfo3, simpleInfo2);
        }
    }
}
