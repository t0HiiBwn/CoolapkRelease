package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_FeedStatus  reason: invalid class name */
abstract class C$AutoValue_FeedStatus extends C$$AutoValue_FeedStatus {
    C$AutoValue_FeedStatus(int i, int i2, int i3, int i4, int i5, String str, String str2, String str3) {
        super(i, i2, i3, i4, i5, str, str2, str3);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_FeedStatus$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<FeedStatus> {
        private final TypeAdapter<Integer> blockStatusAdapter;
        private final TypeAdapter<String> blockStatusTextAdapter;
        private int defaultBlockStatus = 0;
        private String defaultBlockStatusText = null;
        private int defaultIsHeadlineV8 = 0;
        private int defaultMessageStatus = 0;
        private String defaultMessageStatusText = null;
        private int defaultRecommend = 0;
        private int defaultStatus = 0;
        private String defaultStatusText = null;
        private final TypeAdapter<Integer> isHeadlineV8Adapter;
        private final TypeAdapter<Integer> messageStatusAdapter;
        private final TypeAdapter<String> messageStatusTextAdapter;
        private final TypeAdapter<Integer> recommendAdapter;
        private final TypeAdapter<Integer> statusAdapter;
        private final TypeAdapter<String> statusTextAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.recommendAdapter = gson.getAdapter(Integer.class);
            this.statusAdapter = gson.getAdapter(Integer.class);
            this.messageStatusAdapter = gson.getAdapter(Integer.class);
            this.blockStatusAdapter = gson.getAdapter(Integer.class);
            this.isHeadlineV8Adapter = gson.getAdapter(Integer.class);
            this.statusTextAdapter = gson.getAdapter(String.class);
            this.messageStatusTextAdapter = gson.getAdapter(String.class);
            this.blockStatusTextAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultRecommend(int i) {
            this.defaultRecommend = i;
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

        public GsonTypeAdapter setDefaultBlockStatus(int i) {
            this.defaultBlockStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsHeadlineV8(int i) {
            this.defaultIsHeadlineV8 = i;
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

        public void write(JsonWriter jsonWriter, FeedStatus feedStatus) throws IOException {
            if (feedStatus == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("recommend");
            this.recommendAdapter.write(jsonWriter, Integer.valueOf(feedStatus.getRecommend()));
            jsonWriter.name("status");
            this.statusAdapter.write(jsonWriter, Integer.valueOf(feedStatus.getStatus()));
            jsonWriter.name("message_status");
            this.messageStatusAdapter.write(jsonWriter, Integer.valueOf(feedStatus.getMessageStatus()));
            jsonWriter.name("block_status");
            this.blockStatusAdapter.write(jsonWriter, Integer.valueOf(feedStatus.getBlockStatus()));
            jsonWriter.name("isHeadlineV8");
            this.isHeadlineV8Adapter.write(jsonWriter, Integer.valueOf(feedStatus.getIsHeadlineV8()));
            jsonWriter.name("statusText");
            this.statusTextAdapter.write(jsonWriter, feedStatus.getStatusText());
            jsonWriter.name("messageStatusText");
            this.messageStatusTextAdapter.write(jsonWriter, feedStatus.getMessageStatusText());
            jsonWriter.name("blockStatusText");
            this.blockStatusTextAdapter.write(jsonWriter, feedStatus.getBlockStatusText());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public FeedStatus read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = this.defaultRecommend;
            int i2 = this.defaultStatus;
            int i3 = this.defaultMessageStatus;
            int i4 = this.defaultBlockStatus;
            int i5 = this.defaultIsHeadlineV8;
            String str = this.defaultStatusText;
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            int i10 = i5;
            String str2 = str;
            String str3 = this.defaultMessageStatusText;
            String str4 = this.defaultBlockStatusText;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -892481550:
                            if (nextName.equals("status")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -717007700:
                            if (nextName.equals("blockStatusText")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -601407516:
                            if (nextName.equals("block_status")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -419037274:
                            if (nextName.equals("messageStatusText")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 46690368:
                            if (nextName.equals("isHeadlineV8")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 248004671:
                            if (nextName.equals("statusText")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 989204668:
                            if (nextName.equals("recommend")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 1008404266:
                            if (nextName.equals("message_status")) {
                                c = 7;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            i7 = this.statusAdapter.read(jsonReader).intValue();
                            continue;
                        case 1:
                            str4 = this.blockStatusTextAdapter.read(jsonReader);
                            continue;
                        case 2:
                            i9 = this.blockStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            str3 = this.messageStatusTextAdapter.read(jsonReader);
                            continue;
                        case 4:
                            i10 = this.isHeadlineV8Adapter.read(jsonReader).intValue();
                            continue;
                        case 5:
                            str2 = this.statusTextAdapter.read(jsonReader);
                            continue;
                        case 6:
                            i6 = this.recommendAdapter.read(jsonReader).intValue();
                            continue;
                        case 7:
                            i8 = this.messageStatusAdapter.read(jsonReader).intValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_FeedStatus(i6, i7, i8, i9, i10, str2, str3, str4);
        }
    }
}
