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

/* renamed from: com.coolapk.market.model.$AutoValue_Vote  reason: invalid class name */
abstract class C$AutoValue_Vote extends C$$AutoValue_Vote {
    C$AutoValue_Vote(int i, int i2, int i3, String str, long j, String str2, String str3, String str4, String str5, int i4, int i5, String str6, int i6, int i7, String str7, int i8, int i9, int i10, int i11, int i12, String str8, List<VoteOption> list, String str9, String str10, int i13, int i14, int i15, int i16, Topic topic) {
        super(i, i2, i3, str, j, str2, str3, str4, str5, i4, i5, str6, i6, i7, str7, i8, i9, i10, i11, i12, str8, list, str9, str10, i13, i14, i15, i16, topic);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Vote$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Vote> {
        private final TypeAdapter<Integer> anonymousStatusAdapter;
        private final TypeAdapter<Integer> blockStatusAdapter;
        private final TypeAdapter<Integer> createTimeAdapter;
        private final TypeAdapter<String> createUidAdapter;
        private int defaultAnonymousStatus = 0;
        private int defaultBlockStatus = 0;
        private int defaultCreateTime = 0;
        private String defaultCreateUid = null;
        private long defaultEndTime = 0;
        private String defaultId = null;
        private String defaultLastUpdate = null;
        private String defaultLinkPage = null;
        private String defaultLinkTag = null;
        private Topic defaultLinkTagEntity = null;
        private int defaultMaxSelectNum = 0;
        private String defaultMessageTitle = null;
        private int defaultMinSelectNum = 0;
        private String defaultRecommendIds = null;
        private int defaultShowAuthor = 0;
        private int defaultStartTime = 0;
        private int defaultStatus = 0;
        private String defaultTopIds = null;
        private int defaultTotalCommentNum = 0;
        private int defaultTotalOptionNum = 0;
        private int defaultTotalVoteNum = 0;
        private int defaultType = 0;
        private int defaultUpdateTime = 0;
        private String defaultUpdateUid = null;
        private int defaultUserAnonymousStatus = 0;
        private int defaultUserChangeVoteStatus = 0;
        private String defaultUserSelectedOptions = null;
        private int defaultUserVoteCommentStatus = 0;
        private List<VoteOption> defaultVoteOptions = Collections.emptyList();
        private final TypeAdapter<Long> endTimeAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> lastUpdateAdapter;
        private final TypeAdapter<String> linkPageAdapter;
        private final TypeAdapter<String> linkTagAdapter;
        private final TypeAdapter<Topic> linkTagEntityAdapter;
        private final TypeAdapter<Integer> maxSelectNumAdapter;
        private final TypeAdapter<String> messageTitleAdapter;
        private final TypeAdapter<Integer> minSelectNumAdapter;
        private final TypeAdapter<String> recommendIdsAdapter;
        private final TypeAdapter<Integer> showAuthorAdapter;
        private final TypeAdapter<Integer> startTimeAdapter;
        private final TypeAdapter<Integer> statusAdapter;
        private final TypeAdapter<String> topIdsAdapter;
        private final TypeAdapter<Integer> totalCommentNumAdapter;
        private final TypeAdapter<Integer> totalOptionNumAdapter;
        private final TypeAdapter<Integer> totalVoteNumAdapter;
        private final TypeAdapter<Integer> typeAdapter;
        private final TypeAdapter<Integer> updateTimeAdapter;
        private final TypeAdapter<String> updateUidAdapter;
        private final TypeAdapter<Integer> userAnonymousStatusAdapter;
        private final TypeAdapter<Integer> userChangeVoteStatusAdapter;
        private final TypeAdapter<String> userSelectedOptionsAdapter;
        private final TypeAdapter<Integer> userVoteCommentStatusAdapter;
        private final TypeAdapter<List<VoteOption>> voteOptionsAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.anonymousStatusAdapter = gson.getAdapter(Integer.class);
            this.blockStatusAdapter = gson.getAdapter(Integer.class);
            this.createTimeAdapter = gson.getAdapter(Integer.class);
            this.createUidAdapter = gson.getAdapter(String.class);
            this.endTimeAdapter = gson.getAdapter(Long.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.lastUpdateAdapter = gson.getAdapter(String.class);
            this.linkPageAdapter = gson.getAdapter(String.class);
            this.linkTagAdapter = gson.getAdapter(String.class);
            this.maxSelectNumAdapter = gson.getAdapter(Integer.class);
            this.minSelectNumAdapter = gson.getAdapter(Integer.class);
            this.recommendIdsAdapter = gson.getAdapter(String.class);
            this.startTimeAdapter = gson.getAdapter(Integer.class);
            this.statusAdapter = gson.getAdapter(Integer.class);
            this.topIdsAdapter = gson.getAdapter(String.class);
            this.totalCommentNumAdapter = gson.getAdapter(Integer.class);
            this.totalOptionNumAdapter = gson.getAdapter(Integer.class);
            this.totalVoteNumAdapter = gson.getAdapter(Integer.class);
            this.typeAdapter = gson.getAdapter(Integer.class);
            this.updateTimeAdapter = gson.getAdapter(Integer.class);
            this.updateUidAdapter = gson.getAdapter(String.class);
            this.voteOptionsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, VoteOption.class));
            this.messageTitleAdapter = gson.getAdapter(String.class);
            this.userSelectedOptionsAdapter = gson.getAdapter(String.class);
            this.userAnonymousStatusAdapter = gson.getAdapter(Integer.class);
            this.userVoteCommentStatusAdapter = gson.getAdapter(Integer.class);
            this.userChangeVoteStatusAdapter = gson.getAdapter(Integer.class);
            this.showAuthorAdapter = gson.getAdapter(Integer.class);
            this.linkTagEntityAdapter = gson.getAdapter(Topic.class);
        }

        public GsonTypeAdapter setDefaultAnonymousStatus(int i) {
            this.defaultAnonymousStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultBlockStatus(int i) {
            this.defaultBlockStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCreateTime(int i) {
            this.defaultCreateTime = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCreateUid(String str) {
            this.defaultCreateUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEndTime(long j) {
            this.defaultEndTime = j;
            return this;
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLastUpdate(String str) {
            this.defaultLastUpdate = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLinkPage(String str) {
            this.defaultLinkPage = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLinkTag(String str) {
            this.defaultLinkTag = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMaxSelectNum(int i) {
            this.defaultMaxSelectNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultMinSelectNum(int i) {
            this.defaultMinSelectNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRecommendIds(String str) {
            this.defaultRecommendIds = str;
            return this;
        }

        public GsonTypeAdapter setDefaultStartTime(int i) {
            this.defaultStartTime = i;
            return this;
        }

        public GsonTypeAdapter setDefaultStatus(int i) {
            this.defaultStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultTopIds(String str) {
            this.defaultTopIds = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTotalCommentNum(int i) {
            this.defaultTotalCommentNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultTotalOptionNum(int i) {
            this.defaultTotalOptionNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultTotalVoteNum(int i) {
            this.defaultTotalVoteNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultType(int i) {
            this.defaultType = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUpdateTime(int i) {
            this.defaultUpdateTime = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUpdateUid(String str) {
            this.defaultUpdateUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVoteOptions(List<VoteOption> list) {
            this.defaultVoteOptions = list;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageTitle(String str) {
            this.defaultMessageTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserSelectedOptions(String str) {
            this.defaultUserSelectedOptions = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserAnonymousStatus(int i) {
            this.defaultUserAnonymousStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUserVoteCommentStatus(int i) {
            this.defaultUserVoteCommentStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUserChangeVoteStatus(int i) {
            this.defaultUserChangeVoteStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultShowAuthor(int i) {
            this.defaultShowAuthor = i;
            return this;
        }

        public GsonTypeAdapter setDefaultLinkTagEntity(Topic topic) {
            this.defaultLinkTagEntity = topic;
            return this;
        }

        public void write(JsonWriter jsonWriter, Vote vote) throws IOException {
            if (vote == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("anonymous_status");
            this.anonymousStatusAdapter.write(jsonWriter, Integer.valueOf(vote.getAnonymousStatus()));
            jsonWriter.name("block_status");
            this.blockStatusAdapter.write(jsonWriter, Integer.valueOf(vote.getBlockStatus()));
            jsonWriter.name("create_time");
            this.createTimeAdapter.write(jsonWriter, Integer.valueOf(vote.getCreateTime()));
            jsonWriter.name("create_uid");
            this.createUidAdapter.write(jsonWriter, vote.getCreateUid());
            jsonWriter.name("end_time");
            this.endTimeAdapter.write(jsonWriter, Long.valueOf(vote.getEndTime()));
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, vote.getId());
            jsonWriter.name("last_update");
            this.lastUpdateAdapter.write(jsonWriter, vote.getLastUpdate());
            jsonWriter.name("link_page");
            this.linkPageAdapter.write(jsonWriter, vote.getLinkPage());
            jsonWriter.name("link_tag");
            this.linkTagAdapter.write(jsonWriter, vote.getLinkTag());
            jsonWriter.name("max_select_num");
            this.maxSelectNumAdapter.write(jsonWriter, Integer.valueOf(vote.getMaxSelectNum()));
            jsonWriter.name("min_select_num");
            this.minSelectNumAdapter.write(jsonWriter, Integer.valueOf(vote.getMinSelectNum()));
            jsonWriter.name("recommend_ids");
            this.recommendIdsAdapter.write(jsonWriter, vote.getRecommendIds());
            jsonWriter.name("start_time");
            this.startTimeAdapter.write(jsonWriter, Integer.valueOf(vote.getStartTime()));
            jsonWriter.name("status");
            this.statusAdapter.write(jsonWriter, Integer.valueOf(vote.getStatus()));
            jsonWriter.name("top_ids");
            this.topIdsAdapter.write(jsonWriter, vote.getTopIds());
            jsonWriter.name("total_comment_num");
            this.totalCommentNumAdapter.write(jsonWriter, Integer.valueOf(vote.getTotalCommentNum()));
            jsonWriter.name("total_option_num");
            this.totalOptionNumAdapter.write(jsonWriter, Integer.valueOf(vote.getTotalOptionNum()));
            jsonWriter.name("total_vote_num");
            this.totalVoteNumAdapter.write(jsonWriter, Integer.valueOf(vote.getTotalVoteNum()));
            jsonWriter.name("type");
            this.typeAdapter.write(jsonWriter, Integer.valueOf(vote.getType()));
            jsonWriter.name("update_time");
            this.updateTimeAdapter.write(jsonWriter, Integer.valueOf(vote.getUpdateTime()));
            jsonWriter.name("update_uid");
            this.updateUidAdapter.write(jsonWriter, vote.getUpdateUid());
            jsonWriter.name("options");
            this.voteOptionsAdapter.write(jsonWriter, vote.getVoteOptions());
            jsonWriter.name("message_title");
            this.messageTitleAdapter.write(jsonWriter, vote.getMessageTitle());
            jsonWriter.name("user_selected_option");
            this.userSelectedOptionsAdapter.write(jsonWriter, vote.getUserSelectedOptions());
            jsonWriter.name("user_anonymous_status");
            this.userAnonymousStatusAdapter.write(jsonWriter, Integer.valueOf(vote.getUserAnonymousStatus()));
            jsonWriter.name("user_vote_comment_status");
            this.userVoteCommentStatusAdapter.write(jsonWriter, Integer.valueOf(vote.getUserVoteCommentStatus()));
            jsonWriter.name("user_change_vote_status");
            this.userChangeVoteStatusAdapter.write(jsonWriter, Integer.valueOf(vote.getUserChangeVoteStatus()));
            jsonWriter.name("show_author");
            this.showAuthorAdapter.write(jsonWriter, Integer.valueOf(vote.getShowAuthor()));
            jsonWriter.name("link_tag_entity");
            this.linkTagEntityAdapter.write(jsonWriter, vote.getLinkTagEntity());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Vote read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = this.defaultAnonymousStatus;
            int i2 = this.defaultBlockStatus;
            int i3 = this.defaultCreateTime;
            String str = this.defaultCreateUid;
            long j = this.defaultEndTime;
            String str2 = this.defaultId;
            String str3 = this.defaultLastUpdate;
            String str4 = this.defaultLinkPage;
            String str5 = this.defaultLinkTag;
            int i4 = this.defaultMaxSelectNum;
            int i5 = this.defaultMinSelectNum;
            String str6 = this.defaultRecommendIds;
            int i6 = this.defaultStartTime;
            int i7 = this.defaultStatus;
            String str7 = this.defaultTopIds;
            int i8 = this.defaultTotalCommentNum;
            int i9 = this.defaultTotalOptionNum;
            int i10 = this.defaultTotalVoteNum;
            int i11 = this.defaultType;
            int i12 = this.defaultUpdateTime;
            String str8 = this.defaultUpdateUid;
            List<VoteOption> list = this.defaultVoteOptions;
            String str9 = this.defaultMessageTitle;
            String str10 = this.defaultUserSelectedOptions;
            int i13 = this.defaultUserAnonymousStatus;
            int i14 = this.defaultUserVoteCommentStatus;
            int i15 = this.defaultUserChangeVoteStatus;
            int i16 = this.defaultShowAuthor;
            Topic topic = this.defaultLinkTagEntity;
            int i17 = i2;
            int i18 = i3;
            String str11 = str;
            long j2 = j;
            String str12 = str2;
            String str13 = str3;
            String str14 = str4;
            String str15 = str5;
            int i19 = i4;
            int i20 = i5;
            String str16 = str6;
            int i21 = i6;
            int i22 = i;
            int i23 = i7;
            String str17 = str7;
            int i24 = i8;
            int i25 = i9;
            int i26 = i10;
            int i27 = i11;
            int i28 = i12;
            String str18 = str8;
            List<VoteOption> list2 = list;
            String str19 = str9;
            String str20 = str10;
            int i29 = i13;
            int i30 = i14;
            int i31 = i15;
            int i32 = i16;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1634786868:
                            if (nextName.equals("user_change_vote_status")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1624418380:
                            if (nextName.equals("link_page")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1622739669:
                            if (nextName.equals("total_comment_num")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1573145462:
                            if (nextName.equals("start_time")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1249474914:
                            if (nextName.equals("options")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1240160105:
                            if (nextName.equals("total_option_num")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1213783008:
                            if (nextName.equals("message_title")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1179444744:
                            if (nextName.equals("user_anonymous_status")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1141630795:
                            if (nextName.equals("recommend_ids")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1139551026:
                            if (nextName.equals("top_ids")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -892481550:
                            if (nextName.equals("status")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -601407516:
                            if (nextName.equals("block_status")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -573446013:
                            if (nextName.equals("update_time")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -493574096:
                            if (nextName.equals("create_time")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -295591974:
                            if (nextName.equals("update_uid")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 3575610:
                            if (nextName.equals("type")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 25648397:
                            if (nextName.equals("show_author")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 76110718:
                            if (nextName.equals("max_select_num")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 350754131:
                            if (nextName.equals("user_vote_comment_status")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 733026768:
                            if (nextName.equals("min_select_num")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 1194529237:
                            if (nextName.equals("link_tag")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 1306457092:
                            if (nextName.equals("anonymous_status")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 1328269861:
                            if (nextName.equals("user_selected_option")) {
                                c = 23;
                                break;
                            }
                            break;
                        case 1369552525:
                            if (nextName.equals("create_uid")) {
                                c = 24;
                                break;
                            }
                            break;
                        case 1545825100:
                            if (nextName.equals("total_vote_num")) {
                                c = 25;
                                break;
                            }
                            break;
                        case 1725551537:
                            if (nextName.equals("end_time")) {
                                c = 26;
                                break;
                            }
                            break;
                        case 2089135762:
                            if (nextName.equals("last_update")) {
                                c = 27;
                                break;
                            }
                            break;
                        case 2144339341:
                            if (nextName.equals("link_tag_entity")) {
                                c = 28;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            i31 = this.userChangeVoteStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 1:
                            str14 = this.linkPageAdapter.read(jsonReader);
                            continue;
                        case 2:
                            i24 = this.totalCommentNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            i21 = this.startTimeAdapter.read(jsonReader).intValue();
                            continue;
                        case 4:
                            list2 = this.voteOptionsAdapter.read(jsonReader);
                            continue;
                        case 5:
                            i25 = this.totalOptionNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 6:
                            str19 = this.messageTitleAdapter.read(jsonReader);
                            continue;
                        case 7:
                            i29 = this.userAnonymousStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case '\b':
                            str16 = this.recommendIdsAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str17 = this.topIdsAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            i23 = this.statusAdapter.read(jsonReader).intValue();
                            continue;
                        case 11:
                            i17 = this.blockStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case '\f':
                            i28 = this.updateTimeAdapter.read(jsonReader).intValue();
                            continue;
                        case '\r':
                            i18 = this.createTimeAdapter.read(jsonReader).intValue();
                            continue;
                        case 14:
                            str18 = this.updateUidAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str12 = this.idAdapter.read(jsonReader);
                            continue;
                        case 16:
                            i27 = this.typeAdapter.read(jsonReader).intValue();
                            continue;
                        case 17:
                            i32 = this.showAuthorAdapter.read(jsonReader).intValue();
                            continue;
                        case 18:
                            i19 = this.maxSelectNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 19:
                            i30 = this.userVoteCommentStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 20:
                            i20 = this.minSelectNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 21:
                            str15 = this.linkTagAdapter.read(jsonReader);
                            continue;
                        case 22:
                            i22 = this.anonymousStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 23:
                            str20 = this.userSelectedOptionsAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str11 = this.createUidAdapter.read(jsonReader);
                            continue;
                        case 25:
                            i26 = this.totalVoteNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 26:
                            j2 = this.endTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case 27:
                            str13 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 28:
                            topic = this.linkTagEntityAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Vote(i22, i17, i18, str11, j2, str12, str13, str14, str15, i19, i20, str16, i21, i23, str17, i24, i25, i26, i27, i28, str18, list2, str19, str20, i29, i30, i31, i32, topic);
        }
    }
}
