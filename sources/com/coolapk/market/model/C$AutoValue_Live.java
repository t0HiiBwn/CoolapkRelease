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

/* renamed from: com.coolapk.market.model.$AutoValue_Live  reason: invalid class name */
abstract class C$AutoValue_Live extends C$$AutoValue_Live {
    C$AutoValue_Live(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, Long l2, Long l3, String str10, String str11, String str12, long j, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, LiveProduct liveProduct, int i, String str22, int i2, int i3, String str23, int i4, String str24, int i5, long j2, long j3, int i6, int i7, int i8, int i9, String str25, int i10, User user, int i11, List<User> list) {
        super(str, str2, str3, str4, num, str5, str6, str7, str8, str9, l2, l3, str10, str11, str12, j, str13, str14, str15, str16, str17, str18, str19, str20, str21, liveProduct, i, str22, i2, i3, str23, i4, str24, i5, j2, j3, i6, i7, i8, i9, str25, i10, user, i11, list);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Live$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Live> {
        private final TypeAdapter<Integer> closeDiscussAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private int defaultCloseDiscuss = 0;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private int defaultDisableDiscussTab = 0;
        private int defaultDisallowPost = 0;
        private int defaultDisallowPostPic = 0;
        private int defaultDiscussNum = 0;
        private String defaultDiscussNumFormat = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityType = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private int defaultFollowNum = 0;
        private String defaultFollowNumFormat = null;
        private String defaultId = null;
        private int defaultIsFollow = 0;
        private int defaultIsShowBannerTitle = 0;
        private Long defaultLastUpdate = null;
        private long defaultLiveEndTime = 0;
        private long defaultLiveStartTime = 0;
        private int defaultLiveStatus = 0;
        private long defaultLiveTime = 0;
        private String defaultPic = null;
        private String defaultPicUrl = null;
        private String defaultPresenterUid = null;
        private List<User> defaultPresenterUserInfo = Collections.emptyList();
        private int defaultRankScore = 0;
        private String defaultRelationPageName = null;
        private LiveProduct defaultRelationProduct = null;
        private String defaultRelationTag = null;
        private String defaultShowLiveTime = null;
        private String defaultShowTab = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUid = null;
        private String defaultUrl = null;
        private User defaultUserInfo = null;
        private String defaultVideoLiveInfo = null;
        private String defaultVideoLiveUrl = null;
        private String defaultVideoPlaybackUInfo = null;
        private String defaultVideoPlaybackUrl = null;
        private int defaultVisitNum = 0;
        private String defaultVisitNumFormat = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> disableDiscussTabAdapter;
        private final TypeAdapter<Integer> disallowPostAdapter;
        private final TypeAdapter<Integer> disallowPostPicAdapter;
        private final TypeAdapter<Integer> discussNumAdapter;
        private final TypeAdapter<String> discussNumFormatAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<Integer> followNumAdapter;
        private final TypeAdapter<String> followNumFormatAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isFollowAdapter;
        private final TypeAdapter<Integer> isShowBannerTitleAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<Long> liveEndTimeAdapter;
        private final TypeAdapter<Long> liveStartTimeAdapter;
        private final TypeAdapter<Integer> liveStatusAdapter;
        private final TypeAdapter<Long> liveTimeAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> picUrlAdapter;
        private final TypeAdapter<String> presenterUidAdapter;
        private final TypeAdapter<List<User>> presenterUserInfoAdapter;
        private final TypeAdapter<Integer> rankScoreAdapter;
        private final TypeAdapter<String> relationPageNameAdapter;
        private final TypeAdapter<LiveProduct> relationProductAdapter;
        private final TypeAdapter<String> relationTagAdapter;
        private final TypeAdapter<String> showLiveTimeAdapter;
        private final TypeAdapter<String> showTabAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<User> userInfoAdapter;
        private final TypeAdapter<String> videoLiveInfoAdapter;
        private final TypeAdapter<String> videoLiveUrlAdapter;
        private final TypeAdapter<String> videoPlaybackUInfoAdapter;
        private final TypeAdapter<String> videoPlaybackUrlAdapter;
        private final TypeAdapter<Integer> visitNumAdapter;
        private final TypeAdapter<String> visitNumFormatAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
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
            this.uidAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.presenterUidAdapter = gson.getAdapter(String.class);
            this.liveTimeAdapter = gson.getAdapter(Long.class);
            this.showLiveTimeAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.picUrlAdapter = gson.getAdapter(String.class);
            this.videoLiveUrlAdapter = gson.getAdapter(String.class);
            this.videoLiveInfoAdapter = gson.getAdapter(String.class);
            this.videoPlaybackUrlAdapter = gson.getAdapter(String.class);
            this.videoPlaybackUInfoAdapter = gson.getAdapter(String.class);
            this.relationTagAdapter = gson.getAdapter(String.class);
            this.relationPageNameAdapter = gson.getAdapter(String.class);
            this.relationProductAdapter = gson.getAdapter(LiveProduct.class);
            this.isShowBannerTitleAdapter = gson.getAdapter(Integer.class);
            this.followNumFormatAdapter = gson.getAdapter(String.class);
            this.followNumAdapter = gson.getAdapter(Integer.class);
            this.discussNumAdapter = gson.getAdapter(Integer.class);
            this.discussNumFormatAdapter = gson.getAdapter(String.class);
            this.visitNumAdapter = gson.getAdapter(Integer.class);
            this.visitNumFormatAdapter = gson.getAdapter(String.class);
            this.rankScoreAdapter = gson.getAdapter(Integer.class);
            this.liveStartTimeAdapter = gson.getAdapter(Long.class);
            this.liveEndTimeAdapter = gson.getAdapter(Long.class);
            this.liveStatusAdapter = gson.getAdapter(Integer.class);
            this.disallowPostAdapter = gson.getAdapter(Integer.class);
            this.disallowPostPicAdapter = gson.getAdapter(Integer.class);
            this.disableDiscussTabAdapter = gson.getAdapter(Integer.class);
            this.showTabAdapter = gson.getAdapter(String.class);
            this.closeDiscussAdapter = gson.getAdapter(Integer.class);
            this.userInfoAdapter = gson.getAdapter(User.class);
            this.isFollowAdapter = gson.getAdapter(Integer.class);
            this.presenterUserInfoAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, User.class));
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

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPresenterUid(String str) {
            this.defaultPresenterUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLiveTime(long j) {
            this.defaultLiveTime = j;
            return this;
        }

        public GsonTypeAdapter setDefaultShowLiveTime(String str) {
            this.defaultShowLiveTime = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPicUrl(String str) {
            this.defaultPicUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVideoLiveUrl(String str) {
            this.defaultVideoLiveUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVideoLiveInfo(String str) {
            this.defaultVideoLiveInfo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVideoPlaybackUrl(String str) {
            this.defaultVideoPlaybackUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVideoPlaybackUInfo(String str) {
            this.defaultVideoPlaybackUInfo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRelationTag(String str) {
            this.defaultRelationTag = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRelationPageName(String str) {
            this.defaultRelationPageName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRelationProduct(LiveProduct liveProduct) {
            this.defaultRelationProduct = liveProduct;
            return this;
        }

        public GsonTypeAdapter setDefaultIsShowBannerTitle(int i) {
            this.defaultIsShowBannerTitle = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFollowNumFormat(String str) {
            this.defaultFollowNumFormat = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFollowNum(int i) {
            this.defaultFollowNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDiscussNum(int i) {
            this.defaultDiscussNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDiscussNumFormat(String str) {
            this.defaultDiscussNumFormat = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVisitNum(int i) {
            this.defaultVisitNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVisitNumFormat(String str) {
            this.defaultVisitNumFormat = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRankScore(int i) {
            this.defaultRankScore = i;
            return this;
        }

        public GsonTypeAdapter setDefaultLiveStartTime(long j) {
            this.defaultLiveStartTime = j;
            return this;
        }

        public GsonTypeAdapter setDefaultLiveEndTime(long j) {
            this.defaultLiveEndTime = j;
            return this;
        }

        public GsonTypeAdapter setDefaultLiveStatus(int i) {
            this.defaultLiveStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDisallowPost(int i) {
            this.defaultDisallowPost = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDisallowPostPic(int i) {
            this.defaultDisallowPostPic = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDisableDiscussTab(int i) {
            this.defaultDisableDiscussTab = i;
            return this;
        }

        public GsonTypeAdapter setDefaultShowTab(String str) {
            this.defaultShowTab = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCloseDiscuss(int i) {
            this.defaultCloseDiscuss = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUserInfo(User user) {
            this.defaultUserInfo = user;
            return this;
        }

        public GsonTypeAdapter setDefaultIsFollow(int i) {
            this.defaultIsFollow = i;
            return this;
        }

        public GsonTypeAdapter setDefaultPresenterUserInfo(List<User> list) {
            this.defaultPresenterUserInfo = list;
            return this;
        }

        public void write(JsonWriter jsonWriter, Live live) throws IOException {
            if (live == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, live.getEntityTypeName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, live.getEntityType());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, live.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, live.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, live.getEntityFixed());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, live.getUrl());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, live.getPic());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, live.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, live.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, live.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, live.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, live.getLastUpdate());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, live.getUid());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, live.getTitle());
            jsonWriter.name("presenter_uid");
            this.presenterUidAdapter.write(jsonWriter, live.getPresenterUid());
            jsonWriter.name("live_time");
            this.liveTimeAdapter.write(jsonWriter, Long.valueOf(live.getLiveTime()));
            jsonWriter.name("show_live_time");
            this.showLiveTimeAdapter.write(jsonWriter, live.getShowLiveTime());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, live.getDescription());
            jsonWriter.name("pic_url");
            this.picUrlAdapter.write(jsonWriter, live.getPicUrl());
            jsonWriter.name("video_live_url");
            this.videoLiveUrlAdapter.write(jsonWriter, live.getVideoLiveUrl());
            jsonWriter.name("video_live_info");
            this.videoLiveInfoAdapter.write(jsonWriter, live.getVideoLiveInfo());
            jsonWriter.name("video_playback_url");
            this.videoPlaybackUrlAdapter.write(jsonWriter, live.getVideoPlaybackUrl());
            jsonWriter.name("video_playback_info");
            this.videoPlaybackUInfoAdapter.write(jsonWriter, live.getVideoPlaybackUInfo());
            jsonWriter.name("relation_tag");
            this.relationTagAdapter.write(jsonWriter, live.getRelationTag());
            jsonWriter.name("relation_page_name");
            this.relationPageNameAdapter.write(jsonWriter, live.getRelationPageName());
            jsonWriter.name("relation_product");
            this.relationProductAdapter.write(jsonWriter, live.getRelationProduct());
            jsonWriter.name("show_banner_title");
            this.isShowBannerTitleAdapter.write(jsonWriter, Integer.valueOf(live.getIsShowBannerTitle()));
            jsonWriter.name("follow_num_format");
            this.followNumFormatAdapter.write(jsonWriter, live.getFollowNumFormat());
            jsonWriter.name("follow_num");
            this.followNumAdapter.write(jsonWriter, Integer.valueOf(live.getFollowNum()));
            jsonWriter.name("discuss_num");
            this.discussNumAdapter.write(jsonWriter, Integer.valueOf(live.getDiscussNum()));
            jsonWriter.name("discuss_num_format");
            this.discussNumFormatAdapter.write(jsonWriter, live.getDiscussNumFormat());
            jsonWriter.name("visit_num");
            this.visitNumAdapter.write(jsonWriter, Integer.valueOf(live.getVisitNum()));
            jsonWriter.name("visit_num_format");
            this.visitNumFormatAdapter.write(jsonWriter, live.getVisitNumFormat());
            jsonWriter.name("rank_scrore");
            this.rankScoreAdapter.write(jsonWriter, Integer.valueOf(live.getRankScore()));
            jsonWriter.name("live_start_time");
            this.liveStartTimeAdapter.write(jsonWriter, Long.valueOf(live.getLiveStartTime()));
            jsonWriter.name("live_end_time");
            this.liveEndTimeAdapter.write(jsonWriter, Long.valueOf(live.getLiveEndTime()));
            jsonWriter.name("live_status");
            this.liveStatusAdapter.write(jsonWriter, Integer.valueOf(live.getLiveStatus()));
            jsonWriter.name("disallow_post");
            this.disallowPostAdapter.write(jsonWriter, Integer.valueOf(live.getDisallowPost()));
            jsonWriter.name("disallow_post_pic");
            this.disallowPostPicAdapter.write(jsonWriter, Integer.valueOf(live.getDisallowPostPic()));
            jsonWriter.name("disable_discuss_tab");
            this.disableDiscussTabAdapter.write(jsonWriter, Integer.valueOf(live.getDisableDiscussTab()));
            jsonWriter.name("show_tab");
            this.showTabAdapter.write(jsonWriter, live.getShowTab());
            jsonWriter.name("close_discuss");
            this.closeDiscussAdapter.write(jsonWriter, Integer.valueOf(live.getCloseDiscuss()));
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, live.getUserInfo());
            jsonWriter.name("isFollow");
            this.isFollowAdapter.write(jsonWriter, Integer.valueOf(live.getIsFollow()));
            jsonWriter.name("presenterUserInfo");
            this.presenterUserInfoAdapter.write(jsonWriter, live.getPresenterUserInfo());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Live read(JsonReader jsonReader) throws IOException {
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
            String str5 = this.defaultUrl;
            String str6 = this.defaultPic;
            String str7 = this.defaultSubTitle;
            String str8 = this.defaultId;
            String str9 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str10 = this.defaultUid;
            String str11 = this.defaultTitle;
            String str12 = this.defaultPresenterUid;
            long j = this.defaultLiveTime;
            String str13 = this.defaultShowLiveTime;
            String str14 = this.defaultDescription;
            String str15 = this.defaultPicUrl;
            String str16 = this.defaultVideoLiveUrl;
            String str17 = this.defaultVideoLiveInfo;
            String str18 = this.defaultVideoPlaybackUrl;
            String str19 = this.defaultVideoPlaybackUInfo;
            String str20 = this.defaultRelationTag;
            String str21 = this.defaultRelationPageName;
            LiveProduct liveProduct = this.defaultRelationProduct;
            int i = this.defaultIsShowBannerTitle;
            String str22 = this.defaultFollowNumFormat;
            int i2 = this.defaultFollowNum;
            int i3 = this.defaultDiscussNum;
            String str23 = this.defaultDiscussNumFormat;
            int i4 = this.defaultVisitNum;
            String str24 = this.defaultVisitNumFormat;
            int i5 = this.defaultRankScore;
            long j2 = this.defaultLiveStartTime;
            long j3 = this.defaultLiveEndTime;
            int i6 = this.defaultLiveStatus;
            int i7 = this.defaultDisallowPost;
            int i8 = this.defaultDisallowPostPic;
            int i9 = this.defaultDisableDiscussTab;
            String str25 = this.defaultShowTab;
            int i10 = this.defaultCloseDiscuss;
            User user = this.defaultUserInfo;
            int i11 = this.defaultIsFollow;
            List<User> list = this.defaultPresenterUserInfo;
            int i12 = i7;
            String str26 = str3;
            String str27 = str4;
            Integer num2 = num;
            String str28 = str5;
            String str29 = str6;
            String str30 = str7;
            String str31 = str8;
            String str32 = str9;
            Long l4 = l2;
            Long l5 = l3;
            String str33 = str10;
            String str34 = str11;
            String str35 = str;
            String str36 = str2;
            String str37 = str12;
            long j4 = j;
            String str38 = str13;
            String str39 = str15;
            String str40 = str16;
            String str41 = str17;
            String str42 = str18;
            String str43 = str19;
            String str44 = str20;
            String str45 = str21;
            LiveProduct liveProduct2 = liveProduct;
            int i13 = i;
            String str46 = str22;
            int i14 = i2;
            int i15 = i3;
            String str47 = str23;
            int i16 = i4;
            String str48 = str24;
            String str49 = str14;
            int i17 = i5;
            long j5 = j2;
            long j6 = j3;
            int i18 = i6;
            int i19 = i8;
            int i20 = i9;
            String str50 = str25;
            int i21 = i10;
            User user2 = user;
            int i22 = i11;
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
                        case -2026711560:
                            if (nextName.equals("follow_num")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1827076729:
                            if (nextName.equals("show_banner_title")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1724546052:
                            if (nextName.equals("description")) {
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
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1361643490:
                            if (nextName.equals("follow_num_format")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1243016867:
                            if (nextName.equals("video_live_info")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -1036354907:
                            if (nextName.equals("live_status")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -879293570:
                            if (nextName.equals("show_live_time")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -594924165:
                            if (nextName.equals("isFollow")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -578367174:
                            if (nextName.equals("pic_url")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -494508575:
                            if (nextName.equals("presenterUserInfo")) {
                                c = 15;
                                break;
                            }
                            break;
                        case -439550236:
                            if (nextName.equals("disallow_post")) {
                                c = 16;
                                break;
                            }
                            break;
                        case -367150152:
                            if (nextName.equals("relation_page_name")) {
                                c = 17;
                                break;
                            }
                            break;
                        case -338492589:
                            if (nextName.equals("show_tab")) {
                                c = 18;
                                break;
                            }
                            break;
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = 19;
                                break;
                            }
                            break;
                        case -262436137:
                            if (nextName.equals("relation_tag")) {
                                c = 20;
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = 21;
                                break;
                            }
                            break;
                        case -178632992:
                            if (nextName.equals("video_live_url")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 23;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 24;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 25;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 26;
                                break;
                            }
                            break;
                        case 68156047:
                            if (nextName.equals("video_playback_url")) {
                                c = 27;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 28;
                                break;
                            }
                            break;
                        case 243769913:
                            if (nextName.equals("presenter_uid")) {
                                c = 29;
                                break;
                            }
                            break;
                        case 440352423:
                            if (nextName.equals("discuss_num")) {
                                c = 30;
                                break;
                            }
                            break;
                        case 662487620:
                            if (nextName.equals("visit_num_format")) {
                                c = 31;
                                break;
                            }
                            break;
                        case 668454319:
                            if (nextName.equals("disallow_post_pic")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case 902208932:
                            if (nextName.equals("live_end_time")) {
                                c = '!';
                                break;
                            }
                            break;
                        case 921919641:
                            if (nextName.equals("close_discuss")) {
                                c = '\"';
                                break;
                            }
                            break;
                        case 962965932:
                            if (nextName.equals("relation_product")) {
                                c = '#';
                                break;
                            }
                            break;
                        case 1008995904:
                            if (nextName.equals("live_time")) {
                                c = '$';
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = '%';
                                break;
                            }
                            break;
                        case 1400061071:
                            if (nextName.equals("discuss_num_format")) {
                                c = '&';
                                break;
                            }
                            break;
                        case 1763560893:
                            if (nextName.equals("live_start_time")) {
                                c = '\'';
                                break;
                            }
                            break;
                        case 1768208351:
                            if (nextName.equals("disable_discuss_tab")) {
                                c = '(';
                                break;
                            }
                            break;
                        case 1770442483:
                            if (nextName.equals("rank_scrore")) {
                                c = ')';
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = '*';
                                break;
                            }
                            break;
                        case 1880066706:
                            if (nextName.equals("visit_num")) {
                                c = '+';
                                break;
                            }
                            break;
                        case 2112476046:
                            if (nextName.equals("video_playback_info")) {
                                c = ',';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str27 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str30 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            i14 = this.followNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            i13 = this.isShowBannerTitleAdapter.read(jsonReader).intValue();
                            continue;
                        case 4:
                            str49 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str26 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str36 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 7:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str46 = this.followNumFormatAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str41 = this.videoLiveInfoAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            i18 = this.liveStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 11:
                            str35 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str38 = this.showLiveTimeAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            i22 = this.isFollowAdapter.read(jsonReader).intValue();
                            continue;
                        case 14:
                            str39 = this.picUrlAdapter.read(jsonReader);
                            continue;
                        case 15:
                            list = this.presenterUserInfoAdapter.read(jsonReader);
                            continue;
                        case 16:
                            i12 = this.disallowPostAdapter.read(jsonReader).intValue();
                            continue;
                        case 17:
                            str45 = this.relationPageNameAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str50 = this.showTabAdapter.read(jsonReader);
                            continue;
                        case 19:
                            user2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case 20:
                            str44 = this.relationTagAdapter.read(jsonReader);
                            continue;
                        case 21:
                            str32 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 22:
                            str40 = this.videoLiveUrlAdapter.read(jsonReader);
                            continue;
                        case 23:
                            str31 = this.idAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str29 = this.picAdapter.read(jsonReader);
                            continue;
                        case 25:
                            str33 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 26:
                            str28 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 27:
                            str42 = this.videoPlaybackUrlAdapter.read(jsonReader);
                            continue;
                        case 28:
                            str34 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 29:
                            str37 = this.presenterUidAdapter.read(jsonReader);
                            continue;
                        case 30:
                            i15 = this.discussNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 31:
                            str48 = this.visitNumFormatAdapter.read(jsonReader);
                            continue;
                        case ' ':
                            i19 = this.disallowPostPicAdapter.read(jsonReader).intValue();
                            continue;
                        case '!':
                            j6 = this.liveEndTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case '\"':
                            i21 = this.closeDiscussAdapter.read(jsonReader).intValue();
                            continue;
                        case '#':
                            liveProduct2 = this.relationProductAdapter.read(jsonReader);
                            continue;
                        case '$':
                            j4 = this.liveTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case '%':
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case '&':
                            str47 = this.discussNumFormatAdapter.read(jsonReader);
                            continue;
                        case '\'':
                            j5 = this.liveStartTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case '(':
                            i20 = this.disableDiscussTabAdapter.read(jsonReader).intValue();
                            continue;
                        case ')':
                            i17 = this.rankScoreAdapter.read(jsonReader).intValue();
                            continue;
                        case '*':
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case '+':
                            i16 = this.visitNumAdapter.read(jsonReader).intValue();
                            continue;
                        case ',':
                            str43 = this.videoPlaybackUInfoAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Live(str35, str36, str26, str27, num2, str28, str29, str30, str31, str32, l4, l5, str33, str34, str37, j4, str38, str49, str39, str40, str41, str42, str43, str44, str45, liveProduct2, i13, str46, i14, i15, str47, i16, str48, i17, j5, j6, i18, i12, i19, i20, str50, i21, user2, i22, list);
        }
    }
}
