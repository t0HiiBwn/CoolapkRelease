package com.coolapk.market.model;

import com.coolapk.market.model.FeedReply;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_FeedReply_ReplyUserAction  reason: invalid class name */
abstract class C$AutoValue_FeedReply_ReplyUserAction extends C$$AutoValue_FeedReply_ReplyUserAction {
    C$AutoValue_FeedReply_ReplyUserAction(int i) {
        super(i);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_FeedReply_ReplyUserAction$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<FeedReply.ReplyUserAction> {
        private int defaultLike = 0;
        private final TypeAdapter<Integer> likeAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.likeAdapter = gson.getAdapter(Integer.class);
        }

        public GsonTypeAdapter setDefaultLike(int i) {
            this.defaultLike = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, FeedReply.ReplyUserAction replyUserAction) throws IOException {
            if (replyUserAction == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("like");
            this.likeAdapter.write(jsonWriter, Integer.valueOf(replyUserAction.getLike()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public FeedReply.ReplyUserAction read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = this.defaultLike;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (!nextName.equals("like")) {
                        jsonReader.skipValue();
                    } else {
                        i = this.likeAdapter.read(jsonReader).intValue();
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_FeedReply_ReplyUserAction(i);
        }
    }
}
