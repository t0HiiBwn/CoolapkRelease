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

/* renamed from: com.coolapk.market.model.$AutoValue_Topic  reason: invalid class name */
abstract class C$AutoValue_Topic extends C$$AutoValue_Topic {
    C$AutoValue_Topic(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Long l, Long l2, String str8, String str9, String str10, int i, int i2, int i3, int i4, String str11, UserAction userAction, String str12, int i5, String str13, List<RelatedData> list, int i6, long j, long j2, String str14, List<NewHeadLine> list2, int i7, String str15, String str16, int i8, int i9, int i10, int i11, int i12, int i13, String str17, String str18, String str19, String str20, String str21, String str22, List<String> list3, List<String> list4, List<ConfigPage> list5, String str23, int i14, String str24, String str25) {
        super(str, str2, str3, str4, num, str5, str6, str7, l, l2, str8, str9, str10, i, i2, i3, i4, str11, userAction, str12, i5, str13, list, i6, j, j2, str14, list2, i7, str15, str16, i8, i9, i10, i11, i12, i13, str17, str18, str19, str20, str21, str22, list3, list4, list5, str23, i14, str24, str25);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Topic$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Topic> {
        private final TypeAdapter<String> adLinkUrlAdapter;
        private final TypeAdapter<String> adPicUrlAdapter;
        private final TypeAdapter<String> bgColorAdapter;
        private final TypeAdapter<Integer> clickAdapter;
        private final TypeAdapter<Integer> commentNumAdapter;
        private final TypeAdapter<String> coverAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private String defaultAdLinkUrl = null;
        private String defaultAdPicUrl = null;
        private String defaultBgColor = null;
        private int defaultClick = 0;
        private int defaultCommentNum = 0;
        private String defaultCover = null;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityType = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private int defaultFollowNum = 0;
        private int defaultHotNum = 0;
        private String defaultHotNumText = null;
        private String defaultId = null;
        private String defaultIntro = null;
        private int defaultIsLive = 0;
        private int defaultIsRecommend = 0;
        private Long defaultLastUpdate = null;
        private long defaultLiveEndAt = 0;
        private String defaultLivePresenterNames = null;
        private long defaultLiveStartAt = 0;
        private int defaultLivingStatus = 0;
        private String defaultLogo = null;
        private String defaultPhoneInfo = null;
        private String defaultPhonePrice = null;
        private String defaultPic = null;
        private List<RelatedData> defaultRecentFollowList = Collections.emptyList();
        private List<NewHeadLine> defaultRecommendRows = Collections.emptyList();
        private String defaultSelectedTab = null;
        private String defaultShowDate = null;
        private String defaultSubTitle = null;
        private List<ConfigPage> defaultTabApiList = Collections.emptyList();
        private String defaultTagCategory = null;
        private List<String> defaultTagPics = Collections.emptyList();
        private int defaultTagType = 0;
        private String defaultTitle = null;
        private int defaultTopFeedId = 0;
        private List<String> defaultTopIds = Collections.emptyList();
        private String defaultUrl = null;
        private UserAction defaultUserAction = null;
        private String defaultVideoUrl = null;
        private int defaultVoteNum1 = 0;
        private int defaultVoteNum2 = 0;
        private int defaultVoteNum3 = 0;
        private int defaultVoteNum4 = 0;
        private int defaultVoteNum5 = 0;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<Integer> followNumAdapter;
        private final TypeAdapter<Integer> hotNumAdapter;
        private final TypeAdapter<String> hotNumTextAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> introAdapter;
        private final TypeAdapter<Integer> isLiveAdapter;
        private final TypeAdapter<Integer> isRecommendAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<Long> liveEndAtAdapter;
        private final TypeAdapter<String> livePresenterNamesAdapter;
        private final TypeAdapter<Long> liveStartAtAdapter;
        private final TypeAdapter<Integer> livingStatusAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> phoneInfoAdapter;
        private final TypeAdapter<String> phonePriceAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<List<RelatedData>> recentFollowListAdapter;
        private final TypeAdapter<List<NewHeadLine>> recommendRowsAdapter;
        private final TypeAdapter<String> selectedTabAdapter;
        private final TypeAdapter<String> showDateAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<List<ConfigPage>> tabApiListAdapter;
        private final TypeAdapter<String> tagCategoryAdapter;
        private final TypeAdapter<List<String>> tagPicsAdapter;
        private final TypeAdapter<Integer> tagTypeAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<Integer> topFeedIdAdapter;
        private final TypeAdapter<List<String>> topIdsAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<UserAction> userActionAdapter;
        private final TypeAdapter<String> videoUrlAdapter;
        private final TypeAdapter<Integer> voteNum1Adapter;
        private final TypeAdapter<Integer> voteNum2Adapter;
        private final TypeAdapter<Integer> voteNum3Adapter;
        private final TypeAdapter<Integer> voteNum4Adapter;
        private final TypeAdapter<Integer> voteNum5Adapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.followNumAdapter = gson.getAdapter(Integer.class);
            this.commentNumAdapter = gson.getAdapter(Integer.class);
            this.clickAdapter = gson.getAdapter(Integer.class);
            this.isRecommendAdapter = gson.getAdapter(Integer.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.userActionAdapter = gson.getAdapter(UserAction.class);
            this.introAdapter = gson.getAdapter(String.class);
            this.isLiveAdapter = gson.getAdapter(Integer.class);
            this.livePresenterNamesAdapter = gson.getAdapter(String.class);
            this.recentFollowListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, RelatedData.class));
            this.livingStatusAdapter = gson.getAdapter(Integer.class);
            this.liveStartAtAdapter = gson.getAdapter(Long.class);
            this.liveEndAtAdapter = gson.getAdapter(Long.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.recommendRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, NewHeadLine.class));
            this.tagTypeAdapter = gson.getAdapter(Integer.class);
            this.coverAdapter = gson.getAdapter(String.class);
            this.tagCategoryAdapter = gson.getAdapter(String.class);
            this.topFeedIdAdapter = gson.getAdapter(Integer.class);
            this.voteNum1Adapter = gson.getAdapter(Integer.class);
            this.voteNum2Adapter = gson.getAdapter(Integer.class);
            this.voteNum3Adapter = gson.getAdapter(Integer.class);
            this.voteNum4Adapter = gson.getAdapter(Integer.class);
            this.voteNum5Adapter = gson.getAdapter(Integer.class);
            this.phoneInfoAdapter = gson.getAdapter(String.class);
            this.adLinkUrlAdapter = gson.getAdapter(String.class);
            this.adPicUrlAdapter = gson.getAdapter(String.class);
            this.showDateAdapter = gson.getAdapter(String.class);
            this.phonePriceAdapter = gson.getAdapter(String.class);
            this.videoUrlAdapter = gson.getAdapter(String.class);
            this.tagPicsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.topIdsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.tabApiListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, ConfigPage.class));
            this.selectedTabAdapter = gson.getAdapter(String.class);
            this.hotNumAdapter = gson.getAdapter(Integer.class);
            this.hotNumTextAdapter = gson.getAdapter(String.class);
            this.bgColorAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultPic(String str) {
            this.defaultPic = str;
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

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFollowNum(int i) {
            this.defaultFollowNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentNum(int i) {
            this.defaultCommentNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultClick(int i) {
            this.defaultClick = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsRecommend(int i) {
            this.defaultIsRecommend = i;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserAction(UserAction userAction) {
            this.defaultUserAction = userAction;
            return this;
        }

        public GsonTypeAdapter setDefaultIntro(String str) {
            this.defaultIntro = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsLive(int i) {
            this.defaultIsLive = i;
            return this;
        }

        public GsonTypeAdapter setDefaultLivePresenterNames(String str) {
            this.defaultLivePresenterNames = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRecentFollowList(List<RelatedData> list) {
            this.defaultRecentFollowList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultLivingStatus(int i) {
            this.defaultLivingStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultLiveStartAt(long j) {
            this.defaultLiveStartAt = j;
            return this;
        }

        public GsonTypeAdapter setDefaultLiveEndAt(long j) {
            this.defaultLiveEndAt = j;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRecommendRows(List<NewHeadLine> list) {
            this.defaultRecommendRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultTagType(int i) {
            this.defaultTagType = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCover(String str) {
            this.defaultCover = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTagCategory(String str) {
            this.defaultTagCategory = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTopFeedId(int i) {
            this.defaultTopFeedId = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVoteNum1(int i) {
            this.defaultVoteNum1 = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVoteNum2(int i) {
            this.defaultVoteNum2 = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVoteNum3(int i) {
            this.defaultVoteNum3 = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVoteNum4(int i) {
            this.defaultVoteNum4 = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVoteNum5(int i) {
            this.defaultVoteNum5 = i;
            return this;
        }

        public GsonTypeAdapter setDefaultPhoneInfo(String str) {
            this.defaultPhoneInfo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAdLinkUrl(String str) {
            this.defaultAdLinkUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAdPicUrl(String str) {
            this.defaultAdPicUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultShowDate(String str) {
            this.defaultShowDate = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPhonePrice(String str) {
            this.defaultPhonePrice = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVideoUrl(String str) {
            this.defaultVideoUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTagPics(List<String> list) {
            this.defaultTagPics = list;
            return this;
        }

        public GsonTypeAdapter setDefaultTopIds(List<String> list) {
            this.defaultTopIds = list;
            return this;
        }

        public GsonTypeAdapter setDefaultTabApiList(List<ConfigPage> list) {
            this.defaultTabApiList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultSelectedTab(String str) {
            this.defaultSelectedTab = str;
            return this;
        }

        public GsonTypeAdapter setDefaultHotNum(int i) {
            this.defaultHotNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultHotNumText(String str) {
            this.defaultHotNumText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultBgColor(String str) {
            this.defaultBgColor = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, Topic topic) throws IOException {
            if (topic == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, topic.getEntityTypeName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, topic.getEntityType());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, topic.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, topic.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, topic.getEntityFixed());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, topic.getPic());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, topic.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, topic.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, topic.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, topic.getLastUpdate());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, topic.getId());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, topic.getLogo());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, topic.getDescription());
            jsonWriter.name("follownum");
            this.followNumAdapter.write(jsonWriter, Integer.valueOf(topic.getFollowNum()));
            jsonWriter.name("commentnum");
            this.commentNumAdapter.write(jsonWriter, Integer.valueOf(topic.getCommentNum()));
            jsonWriter.name("click");
            this.clickAdapter.write(jsonWriter, Integer.valueOf(topic.getClick()));
            jsonWriter.name("is_recommend");
            this.isRecommendAdapter.write(jsonWriter, Integer.valueOf(topic.getIsRecommend()));
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, topic.getTitle());
            jsonWriter.name("userAction");
            this.userActionAdapter.write(jsonWriter, topic.getUserAction());
            jsonWriter.name("intro");
            this.introAdapter.write(jsonWriter, topic.getIntro());
            jsonWriter.name("is_live");
            this.isLiveAdapter.write(jsonWriter, Integer.valueOf(topic.getIsLive()));
            jsonWriter.name("livePresenterNames");
            this.livePresenterNamesAdapter.write(jsonWriter, topic.getLivePresenterNames());
            jsonWriter.name("recent_follow_list");
            this.recentFollowListAdapter.write(jsonWriter, topic.getRecentFollowList());
            jsonWriter.name("live_status");
            this.livingStatusAdapter.write(jsonWriter, Integer.valueOf(topic.getLivingStatus()));
            jsonWriter.name("live_start_at");
            this.liveStartAtAdapter.write(jsonWriter, Long.valueOf(topic.getLiveStartAt()));
            jsonWriter.name("live_end_at");
            this.liveEndAtAdapter.write(jsonWriter, Long.valueOf(topic.getLiveEndAt()));
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, topic.getUrl());
            jsonWriter.name("recommendRows");
            this.recommendRowsAdapter.write(jsonWriter, topic.getRecommendRows());
            jsonWriter.name("tag_type");
            this.tagTypeAdapter.write(jsonWriter, Integer.valueOf(topic.getTagType()));
            jsonWriter.name("cover");
            this.coverAdapter.write(jsonWriter, topic.getCover());
            jsonWriter.name("tag_category");
            this.tagCategoryAdapter.write(jsonWriter, topic.getTagCategory());
            jsonWriter.name("top_feed_id");
            this.topFeedIdAdapter.write(jsonWriter, Integer.valueOf(topic.getTopFeedId()));
            jsonWriter.name("votenum1");
            this.voteNum1Adapter.write(jsonWriter, Integer.valueOf(topic.getVoteNum1()));
            jsonWriter.name("votenum2");
            this.voteNum2Adapter.write(jsonWriter, Integer.valueOf(topic.getVoteNum2()));
            jsonWriter.name("votenum3");
            this.voteNum3Adapter.write(jsonWriter, Integer.valueOf(topic.getVoteNum3()));
            jsonWriter.name("votenum4");
            this.voteNum4Adapter.write(jsonWriter, Integer.valueOf(topic.getVoteNum4()));
            jsonWriter.name("votenum5");
            this.voteNum5Adapter.write(jsonWriter, Integer.valueOf(topic.getVoteNum5()));
            jsonWriter.name("phone_info");
            this.phoneInfoAdapter.write(jsonWriter, topic.getPhoneInfo());
            jsonWriter.name("ad_link_url");
            this.adLinkUrlAdapter.write(jsonWriter, topic.getAdLinkUrl());
            jsonWriter.name("ad_pic_url");
            this.adPicUrlAdapter.write(jsonWriter, topic.getAdPicUrl());
            jsonWriter.name("show_date");
            this.showDateAdapter.write(jsonWriter, topic.getShowDate());
            jsonWriter.name("phone_price");
            this.phonePriceAdapter.write(jsonWriter, topic.getPhonePrice());
            jsonWriter.name("video_url");
            this.videoUrlAdapter.write(jsonWriter, topic.getVideoUrl());
            jsonWriter.name("tag_pics");
            this.tagPicsAdapter.write(jsonWriter, topic.getTagPics());
            jsonWriter.name("top_ids");
            this.topIdsAdapter.write(jsonWriter, topic.getTopIds());
            jsonWriter.name("tabList");
            this.tabApiListAdapter.write(jsonWriter, topic.getTabApiList());
            jsonWriter.name("selectedTab");
            this.selectedTabAdapter.write(jsonWriter, topic.getSelectedTab());
            jsonWriter.name("hot_num");
            this.hotNumAdapter.write(jsonWriter, Integer.valueOf(topic.getHotNum()));
            jsonWriter.name("hot_num_txt");
            this.hotNumTextAdapter.write(jsonWriter, topic.getHotNumText());
            jsonWriter.name("bgColor");
            this.bgColorAdapter.write(jsonWriter, topic.getBgColor());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Topic read(JsonReader jsonReader) throws IOException {
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
            String str5 = this.defaultPic;
            String str6 = this.defaultSubTitle;
            String str7 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str8 = this.defaultId;
            String str9 = this.defaultLogo;
            String str10 = this.defaultDescription;
            int i = this.defaultFollowNum;
            int i2 = this.defaultCommentNum;
            int i3 = this.defaultClick;
            int i4 = this.defaultIsRecommend;
            String str11 = this.defaultTitle;
            UserAction userAction = this.defaultUserAction;
            String str12 = this.defaultIntro;
            int i5 = this.defaultIsLive;
            String str13 = this.defaultLivePresenterNames;
            List<RelatedData> list = this.defaultRecentFollowList;
            int i6 = this.defaultLivingStatus;
            long j = this.defaultLiveStartAt;
            long j2 = this.defaultLiveEndAt;
            String str14 = this.defaultUrl;
            List<NewHeadLine> list2 = this.defaultRecommendRows;
            int i7 = this.defaultTagType;
            String str15 = this.defaultCover;
            String str16 = this.defaultTagCategory;
            int i8 = this.defaultTopFeedId;
            int i9 = this.defaultVoteNum1;
            int i10 = this.defaultVoteNum2;
            int i11 = this.defaultVoteNum3;
            int i12 = this.defaultVoteNum4;
            int i13 = this.defaultVoteNum5;
            String str17 = this.defaultPhoneInfo;
            String str18 = this.defaultAdLinkUrl;
            String str19 = this.defaultAdPicUrl;
            String str20 = this.defaultShowDate;
            String str21 = this.defaultPhonePrice;
            String str22 = this.defaultVideoUrl;
            List<String> list3 = this.defaultTagPics;
            List<String> list4 = this.defaultTopIds;
            List<ConfigPage> list5 = this.defaultTabApiList;
            String str23 = this.defaultSelectedTab;
            int i14 = this.defaultHotNum;
            String str24 = this.defaultHotNumText;
            String str25 = this.defaultBgColor;
            List<NewHeadLine> list6 = list2;
            String str26 = str3;
            String str27 = str4;
            Integer num2 = num;
            String str28 = str5;
            String str29 = str6;
            String str30 = str7;
            Long l3 = l;
            Long l4 = l2;
            String str31 = str8;
            String str32 = str9;
            String str33 = str10;
            int i15 = i;
            String str34 = str;
            int i16 = i2;
            int i17 = i3;
            int i18 = i4;
            String str35 = str11;
            UserAction userAction2 = userAction;
            String str36 = str12;
            int i19 = i5;
            String str37 = str13;
            List<RelatedData> list7 = list;
            String str38 = str2;
            int i20 = i6;
            long j3 = j;
            long j4 = j2;
            String str39 = str14;
            int i21 = i7;
            String str40 = str15;
            String str41 = str16;
            int i22 = i8;
            int i23 = i9;
            int i24 = i10;
            int i25 = i11;
            int i26 = i12;
            int i27 = i13;
            String str42 = str17;
            String str43 = str18;
            String str44 = str19;
            String str45 = str20;
            String str46 = str21;
            String str47 = str22;
            List<String> list8 = list3;
            List<String> list9 = list4;
            List<ConfigPage> list10 = list5;
            String str48 = str23;
            int i28 = i14;
            String str49 = str24;
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
                        case -1903811664:
                            if (nextName.equals("show_date")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1824254753:
                            if (nextName.equals("phone_info")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1815313806:
                            if (nextName.equals("top_feed_id")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1724546052:
                            if (nextName.equals("description")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1655467179:
                            if (nextName.equals("votenum1")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1655467178:
                            if (nextName.equals("votenum2")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1655467177:
                            if (nextName.equals("votenum3")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1655467176:
                            if (nextName.equals("votenum4")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -1655467175:
                            if (nextName.equals("votenum5")) {
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
                        case -1553853997:
                            if (nextName.equals("tabList")) {
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
                        case -1442635574:
                            if (nextName.equals("live_end_at")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -1391196091:
                            if (nextName.equals("hot_num_txt")) {
                                c = 15;
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 16;
                                break;
                            }
                            break;
                        case -1142011723:
                            if (nextName.equals("recommendRows")) {
                                c = 17;
                                break;
                            }
                            break;
                        case -1139551026:
                            if (nextName.equals("top_ids")) {
                                c = 18;
                                break;
                            }
                            break;
                        case -1036354907:
                            if (nextName.equals("live_status")) {
                                c = 19;
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = 20;
                                break;
                            }
                            break;
                        case -763942482:
                            if (nextName.equals("tag_pics")) {
                                c = 21;
                                break;
                            }
                            break;
                        case -763807553:
                            if (nextName.equals("tag_type")) {
                                c = 22;
                                break;
                            }
                            break;
                        case -710736072:
                            if (nextName.equals("phone_price")) {
                                c = 23;
                                break;
                            }
                            break;
                        case -458903266:
                            if (nextName.equals("ad_pic_url")) {
                                c = 24;
                                break;
                            }
                            break;
                        case -321901593:
                            if (nextName.equals("is_recommend")) {
                                c = 25;
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = 26;
                                break;
                            }
                            break;
                        case -204859874:
                            if (nextName.equals("bgColor")) {
                                c = 27;
                                break;
                            }
                            break;
                        case -171999860:
                            if (nextName.equals("livePresenterNames")) {
                                c = 28;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 29;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 30;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 31;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case 94750088:
                            if (nextName.equals("click")) {
                                c = '!';
                                break;
                            }
                            break;
                        case 94852023:
                            if (nextName.equals("cover")) {
                                c = '\"';
                                break;
                            }
                            break;
                        case 100361836:
                            if (nextName.equals("intro")) {
                                c = '#';
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = '$';
                                break;
                            }
                            break;
                        case 220498682:
                            if (nextName.equals("selectedTab")) {
                                c = '%';
                                break;
                            }
                            break;
                        case 493454115:
                            if (nextName.equals("live_start_at")) {
                                c = '&';
                                break;
                            }
                            break;
                        case 602944582:
                            if (nextName.equals("ad_link_url")) {
                                c = '\'';
                                break;
                            }
                            break;
                        case 765920821:
                            if (nextName.equals("follownum")) {
                                c = '(';
                                break;
                            }
                            break;
                        case 899165383:
                            if (nextName.equals("commentnum")) {
                                c = ')';
                                break;
                            }
                            break;
                        case 958077955:
                            if (nextName.equals("tag_category")) {
                                c = '*';
                                break;
                            }
                            break;
                        case 1061163489:
                            if (nextName.equals("userAction")) {
                                c = '+';
                                break;
                            }
                            break;
                        case 1099006100:
                            if (nextName.equals("hot_num")) {
                                c = ',';
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = '-';
                                break;
                            }
                            break;
                        case 1333285803:
                            if (nextName.equals("video_url")) {
                                c = '.';
                                break;
                            }
                            break;
                        case 1706281096:
                            if (nextName.equals("recent_follow_list")) {
                                c = '/';
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = '0';
                                break;
                            }
                            break;
                        case 2082014945:
                            if (nextName.equals("is_live")) {
                                c = '1';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str27 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str29 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str45 = this.showDateAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str42 = this.phoneInfoAdapter.read(jsonReader);
                            continue;
                        case 4:
                            i22 = this.topFeedIdAdapter.read(jsonReader).intValue();
                            continue;
                        case 5:
                            str33 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 6:
                            i23 = this.voteNum1Adapter.read(jsonReader).intValue();
                            continue;
                        case 7:
                            i24 = this.voteNum2Adapter.read(jsonReader).intValue();
                            continue;
                        case '\b':
                            i25 = this.voteNum3Adapter.read(jsonReader).intValue();
                            continue;
                        case '\t':
                            i26 = this.voteNum4Adapter.read(jsonReader).intValue();
                            continue;
                        case '\n':
                            i27 = this.voteNum5Adapter.read(jsonReader).intValue();
                            continue;
                        case 11:
                            str26 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            list10 = this.tabApiListAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str38 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 14:
                            j4 = this.liveEndAtAdapter.read(jsonReader).longValue();
                            continue;
                        case 15:
                            str49 = this.hotNumTextAdapter.read(jsonReader);
                            continue;
                        case 16:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 17:
                            list6 = this.recommendRowsAdapter.read(jsonReader);
                            continue;
                        case 18:
                            list9 = this.topIdsAdapter.read(jsonReader);
                            continue;
                        case 19:
                            i20 = this.livingStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 20:
                            str34 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 21:
                            list8 = this.tagPicsAdapter.read(jsonReader);
                            continue;
                        case 22:
                            i21 = this.tagTypeAdapter.read(jsonReader).intValue();
                            continue;
                        case 23:
                            str46 = this.phonePriceAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str44 = this.adPicUrlAdapter.read(jsonReader);
                            continue;
                        case 25:
                            i18 = this.isRecommendAdapter.read(jsonReader).intValue();
                            continue;
                        case 26:
                            str30 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 27:
                            str25 = this.bgColorAdapter.read(jsonReader);
                            continue;
                        case 28:
                            str37 = this.livePresenterNamesAdapter.read(jsonReader);
                            continue;
                        case 29:
                            str31 = this.idAdapter.read(jsonReader);
                            continue;
                        case 30:
                            str28 = this.picAdapter.read(jsonReader);
                            continue;
                        case 31:
                            str39 = this.urlAdapter.read(jsonReader);
                            continue;
                        case ' ':
                            str32 = this.logoAdapter.read(jsonReader);
                            continue;
                        case '!':
                            i17 = this.clickAdapter.read(jsonReader).intValue();
                            continue;
                        case '\"':
                            str40 = this.coverAdapter.read(jsonReader);
                            continue;
                        case '#':
                            str36 = this.introAdapter.read(jsonReader);
                            continue;
                        case '$':
                            str35 = this.titleAdapter.read(jsonReader);
                            continue;
                        case '%':
                            str48 = this.selectedTabAdapter.read(jsonReader);
                            continue;
                        case '&':
                            j3 = this.liveStartAtAdapter.read(jsonReader).longValue();
                            continue;
                        case '\'':
                            str43 = this.adLinkUrlAdapter.read(jsonReader);
                            continue;
                        case '(':
                            i15 = this.followNumAdapter.read(jsonReader).intValue();
                            continue;
                        case ')':
                            i16 = this.commentNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '*':
                            str41 = this.tagCategoryAdapter.read(jsonReader);
                            continue;
                        case '+':
                            userAction2 = this.userActionAdapter.read(jsonReader);
                            continue;
                        case ',':
                            i28 = this.hotNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '-':
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case '.':
                            str47 = this.videoUrlAdapter.read(jsonReader);
                            continue;
                        case '/':
                            list7 = this.recentFollowListAdapter.read(jsonReader);
                            continue;
                        case '0':
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case '1':
                            i19 = this.isLiveAdapter.read(jsonReader).intValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Topic(str34, str38, str26, str27, num2, str28, str29, str30, l3, l4, str31, str32, str33, i15, i16, i17, i18, str35, userAction2, str36, i19, str37, list7, i20, j3, j4, str39, list6, i21, str40, str41, i22, i23, i24, i25, i26, i27, str42, str43, str44, str45, str46, str47, list8, list9, list10, str48, i28, str49, str25);
        }
    }
}
