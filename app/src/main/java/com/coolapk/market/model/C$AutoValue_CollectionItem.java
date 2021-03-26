package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_CollectionItem  reason: invalid class name */
abstract class C$AutoValue_CollectionItem extends C$$AutoValue_CollectionItem {
    C$AutoValue_CollectionItem(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
        super(str, str2, str3, str4, str5, str6, i, i2);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_CollectionItem$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<CollectionItem> {
        private final TypeAdapter<String> collectionIdAdapter;
        private final TypeAdapter<String> contentAdapter;
        private String defaultCollectionId = null;
        private String defaultContent = null;
        private String defaultId = null;
        private int defaultIsDelete = 0;
        private int defaultIsTop = 0;
        private String defaultTargetType = null;
        private String defaultTargetUid = null;
        private String defaultUid = null;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isDeleteAdapter;
        private final TypeAdapter<Integer> isTopAdapter;
        private final TypeAdapter<String> targetTypeAdapter;
        private final TypeAdapter<String> targetUidAdapter;
        private final TypeAdapter<String> uidAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.idAdapter = gson.getAdapter(String.class);
            this.collectionIdAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.targetUidAdapter = gson.getAdapter(String.class);
            this.contentAdapter = gson.getAdapter(String.class);
            this.targetTypeAdapter = gson.getAdapter(String.class);
            this.isTopAdapter = gson.getAdapter(Integer.class);
            this.isDeleteAdapter = gson.getAdapter(Integer.class);
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCollectionId(String str) {
            this.defaultCollectionId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTargetUid(String str) {
            this.defaultTargetUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultContent(String str) {
            this.defaultContent = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTargetType(String str) {
            this.defaultTargetType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsTop(int i) {
            this.defaultIsTop = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsDelete(int i) {
            this.defaultIsDelete = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, CollectionItem collectionItem) throws IOException {
            if (collectionItem == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, collectionItem.getId());
            jsonWriter.name("collection_id");
            this.collectionIdAdapter.write(jsonWriter, collectionItem.getCollectionId());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, collectionItem.getUid());
            jsonWriter.name("target_uid");
            this.targetUidAdapter.write(jsonWriter, collectionItem.getTargetUid());
            jsonWriter.name("content");
            this.contentAdapter.write(jsonWriter, collectionItem.getContent());
            jsonWriter.name("target_type");
            this.targetTypeAdapter.write(jsonWriter, collectionItem.getTargetType());
            jsonWriter.name("is_top");
            this.isTopAdapter.write(jsonWriter, Integer.valueOf(collectionItem.getIsTop()));
            jsonWriter.name("is_delete");
            this.isDeleteAdapter.write(jsonWriter, Integer.valueOf(collectionItem.getIsDelete()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public CollectionItem read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultId;
            String str2 = this.defaultCollectionId;
            String str3 = this.defaultUid;
            String str4 = this.defaultTargetUid;
            String str5 = this.defaultContent;
            String str6 = this.defaultTargetType;
            String str7 = str;
            String str8 = str2;
            String str9 = str3;
            String str10 = str4;
            String str11 = str5;
            String str12 = str6;
            int i = this.defaultIsTop;
            int i2 = this.defaultIsDelete;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -2084558552:
                            if (nextName.equals("target_type")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1179756352:
                            if (nextName.equals("is_top")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -871419296:
                            if (nextName.equals("is_delete")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -821242276:
                            if (nextName.equals("collection_id")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 486945954:
                            if (nextName.equals("target_uid")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 951530617:
                            if (nextName.equals("content")) {
                                c = 7;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str12 = this.targetTypeAdapter.read(jsonReader);
                            continue;
                        case 1:
                            i = this.isTopAdapter.read(jsonReader).intValue();
                            continue;
                        case 2:
                            i2 = this.isDeleteAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            str8 = this.collectionIdAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str7 = this.idAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str9 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str10 = this.targetUidAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str11 = this.contentAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_CollectionItem(str7, str8, str9, str10, str11, str12, i, i2);
        }
    }
}
