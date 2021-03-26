package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_VoteOption  reason: invalid class name */
abstract class C$AutoValue_VoteOption extends C$$AutoValue_VoteOption {
    C$AutoValue_VoteOption(String str, int i, String str2, String str3, int i2, int i3, String str4) {
        super(str, i, str2, str3, i2, i3, str4);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_VoteOption$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<VoteOption> {
        private final TypeAdapter<String> colorAdapter;
        private String defaultColor = null;
        private String defaultId = null;
        private int defaultOrder = 0;
        private String defaultTitle = null;
        private int defaultTotalCommentNum = 0;
        private int defaultTotalSelectNum = 0;
        private String defaultVoteId = null;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> orderAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<Integer> totalCommentNumAdapter;
        private final TypeAdapter<Integer> totalSelectNumAdapter;
        private final TypeAdapter<String> voteIdAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.colorAdapter = gson.getAdapter(String.class);
            this.orderAdapter = gson.getAdapter(Integer.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.totalCommentNumAdapter = gson.getAdapter(Integer.class);
            this.totalSelectNumAdapter = gson.getAdapter(Integer.class);
            this.voteIdAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultColor(String str) {
            this.defaultColor = str;
            return this;
        }

        public GsonTypeAdapter setDefaultOrder(int i) {
            this.defaultOrder = i;
            return this;
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTotalCommentNum(int i) {
            this.defaultTotalCommentNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultTotalSelectNum(int i) {
            this.defaultTotalSelectNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVoteId(String str) {
            this.defaultVoteId = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, VoteOption voteOption) throws IOException {
            if (voteOption == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("color");
            this.colorAdapter.write(jsonWriter, voteOption.getColor());
            jsonWriter.name("order");
            this.orderAdapter.write(jsonWriter, Integer.valueOf(voteOption.getOrder()));
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, voteOption.getId());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, voteOption.getTitle());
            jsonWriter.name("total_comment_num");
            this.totalCommentNumAdapter.write(jsonWriter, Integer.valueOf(voteOption.getTotalCommentNum()));
            jsonWriter.name("total_select_num");
            this.totalSelectNumAdapter.write(jsonWriter, Integer.valueOf(voteOption.getTotalSelectNum()));
            jsonWriter.name("vote_id");
            this.voteIdAdapter.write(jsonWriter, voteOption.getVoteId());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public VoteOption read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultColor;
            int i = this.defaultOrder;
            String str2 = this.defaultId;
            String str3 = this.defaultTitle;
            int i2 = this.defaultTotalCommentNum;
            String str4 = str;
            int i3 = i;
            String str5 = str2;
            String str6 = str3;
            int i4 = i2;
            int i5 = this.defaultTotalSelectNum;
            String str7 = this.defaultVoteId;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1622739669:
                            if (nextName.equals("total_comment_num")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 25278878:
                            if (nextName.equals("total_select_num")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 94842723:
                            if (nextName.equals("color")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 106006350:
                            if (nextName.equals("order")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 639319696:
                            if (nextName.equals("vote_id")) {
                                c = 6;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            i4 = this.totalCommentNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 1:
                            str5 = this.idAdapter.read(jsonReader);
                            continue;
                        case 2:
                            i5 = this.totalSelectNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            str4 = this.colorAdapter.read(jsonReader);
                            continue;
                        case 4:
                            i3 = this.orderAdapter.read(jsonReader).intValue();
                            continue;
                        case 5:
                            str6 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str7 = this.voteIdAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_VoteOption(str4, i3, str5, str6, i4, i5, str7);
        }
    }
}
