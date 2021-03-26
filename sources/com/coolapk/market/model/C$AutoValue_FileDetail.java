package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_FileDetail  reason: invalid class name */
abstract class C$AutoValue_FileDetail extends C$$AutoValue_FileDetail {
    C$AutoValue_FileDetail(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l2, String str10, Long l3, int i, int i2, int i3, int i4, int i5) {
        super(str, str2, str3, str4, str5, str6, str7, str8, str9, l2, str10, l3, i, i2, i3, i4, i5);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_FileDetail$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<FileDetail> {
        private final TypeAdapter<Long> datelineAdapter;
        private Long defaultDateline = null;
        private String defaultFileExt = null;
        private String defaultFileMd5 = null;
        private String defaultFileSize = null;
        private String defaultFirstUid = null;
        private String defaultId = null;
        private int defaultIsBanned = 0;
        private int defaultIsBlock = 0;
        private int defaultIsForbid = 0;
        private String defaultLastUid = null;
        private Long defaultLastUpdateTime = null;
        private int defaultSpamStatus = 0;
        private int defaultUploadCount = 0;
        private String defaultUploadDir = null;
        private String defaultUploadType = null;
        private String defaultUrl = null;
        private String defaultUrlMd5 = null;
        private final TypeAdapter<String> fileExtAdapter;
        private final TypeAdapter<String> fileMd5Adapter;
        private final TypeAdapter<String> fileSizeAdapter;
        private final TypeAdapter<String> firstUidAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isBannedAdapter;
        private final TypeAdapter<Integer> isBlockAdapter;
        private final TypeAdapter<Integer> isForbidAdapter;
        private final TypeAdapter<String> lastUidAdapter;
        private final TypeAdapter<Long> lastUpdateTimeAdapter;
        private final TypeAdapter<Integer> spamStatusAdapter;
        private final TypeAdapter<Integer> uploadCountAdapter;
        private final TypeAdapter<String> uploadDirAdapter;
        private final TypeAdapter<String> uploadTypeAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<String> urlMd5Adapter;

        public GsonTypeAdapter(Gson gson) {
            this.idAdapter = gson.getAdapter(String.class);
            this.fileMd5Adapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.urlMd5Adapter = gson.getAdapter(String.class);
            this.uploadTypeAdapter = gson.getAdapter(String.class);
            this.uploadDirAdapter = gson.getAdapter(String.class);
            this.fileSizeAdapter = gson.getAdapter(String.class);
            this.fileExtAdapter = gson.getAdapter(String.class);
            this.firstUidAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUidAdapter = gson.getAdapter(String.class);
            this.lastUpdateTimeAdapter = gson.getAdapter(Long.class);
            this.uploadCountAdapter = gson.getAdapter(Integer.class);
            this.isBlockAdapter = gson.getAdapter(Integer.class);
            this.isForbidAdapter = gson.getAdapter(Integer.class);
            this.isBannedAdapter = gson.getAdapter(Integer.class);
            this.spamStatusAdapter = gson.getAdapter(Integer.class);
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFileMd5(String str) {
            this.defaultFileMd5 = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrlMd5(String str) {
            this.defaultUrlMd5 = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUploadType(String str) {
            this.defaultUploadType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUploadDir(String str) {
            this.defaultUploadDir = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFileSize(String str) {
            this.defaultFileSize = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFileExt(String str) {
            this.defaultFileExt = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFirstUid(String str) {
            this.defaultFirstUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDateline(Long l2) {
            this.defaultDateline = l2;
            return this;
        }

        public GsonTypeAdapter setDefaultLastUid(String str) {
            this.defaultLastUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLastUpdateTime(Long l2) {
            this.defaultLastUpdateTime = l2;
            return this;
        }

        public GsonTypeAdapter setDefaultUploadCount(int i) {
            this.defaultUploadCount = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsBlock(int i) {
            this.defaultIsBlock = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsForbid(int i) {
            this.defaultIsForbid = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsBanned(int i) {
            this.defaultIsBanned = i;
            return this;
        }

        public GsonTypeAdapter setDefaultSpamStatus(int i) {
            this.defaultSpamStatus = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, FileDetail fileDetail) throws IOException {
            if (fileDetail == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, fileDetail.id());
            jsonWriter.name("file_md5");
            this.fileMd5Adapter.write(jsonWriter, fileDetail.fileMd5());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, fileDetail.url());
            jsonWriter.name("url_md5");
            this.urlMd5Adapter.write(jsonWriter, fileDetail.urlMd5());
            jsonWriter.name("upload_type");
            this.uploadTypeAdapter.write(jsonWriter, fileDetail.uploadType());
            jsonWriter.name("upload_dir");
            this.uploadDirAdapter.write(jsonWriter, fileDetail.uploadDir());
            jsonWriter.name("file_size");
            this.fileSizeAdapter.write(jsonWriter, fileDetail.fileSize());
            jsonWriter.name("file_ext");
            this.fileExtAdapter.write(jsonWriter, fileDetail.fileExt());
            jsonWriter.name("first_uid");
            this.firstUidAdapter.write(jsonWriter, fileDetail.firstUid());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, fileDetail.dateline());
            jsonWriter.name("last_uid");
            this.lastUidAdapter.write(jsonWriter, fileDetail.lastUid());
            jsonWriter.name("last_update_time");
            this.lastUpdateTimeAdapter.write(jsonWriter, fileDetail.lastUpdateTime());
            jsonWriter.name("upload_count");
            this.uploadCountAdapter.write(jsonWriter, Integer.valueOf(fileDetail.uploadCount()));
            jsonWriter.name("is_block");
            this.isBlockAdapter.write(jsonWriter, Integer.valueOf(fileDetail.isBlock()));
            jsonWriter.name("is_forbid");
            this.isForbidAdapter.write(jsonWriter, Integer.valueOf(fileDetail.isForbid()));
            jsonWriter.name("is_banned");
            this.isBannedAdapter.write(jsonWriter, Integer.valueOf(fileDetail.isBanned()));
            jsonWriter.name("spam_status");
            this.spamStatusAdapter.write(jsonWriter, Integer.valueOf(fileDetail.spamStatus()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public FileDetail read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultId;
            String str2 = this.defaultFileMd5;
            String str3 = this.defaultUrl;
            String str4 = this.defaultUrlMd5;
            String str5 = this.defaultUploadType;
            String str6 = this.defaultUploadDir;
            String str7 = this.defaultFileSize;
            String str8 = this.defaultFileExt;
            String str9 = this.defaultFirstUid;
            Long l2 = this.defaultDateline;
            String str10 = this.defaultLastUid;
            Long l3 = this.defaultLastUpdateTime;
            int i = this.defaultUploadCount;
            int i2 = this.defaultIsBlock;
            int i3 = this.defaultIsForbid;
            int i4 = this.defaultIsBanned;
            int i5 = this.defaultSpamStatus;
            String str11 = str2;
            String str12 = str3;
            String str13 = str4;
            String str14 = str5;
            String str15 = str6;
            String str16 = str7;
            String str17 = str8;
            String str18 = str9;
            Long l4 = l2;
            String str19 = str10;
            Long l5 = l3;
            int i6 = i;
            int i7 = i2;
            String str20 = str;
            int i8 = i3;
            int i9 = i4;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1746288216:
                            if (nextName.equals("spam_status")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1459074265:
                            if (nextName.equals("last_uid")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1360298671:
                            if (nextName.equals("upload_count")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1316310812:
                            if (nextName.equals("file_size")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -932303917:
                            if (nextName.equals("is_banned")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -804750263:
                            if (nextName.equals("is_forbid")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -735211298:
                            if (nextName.equals("file_ext")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -735204293:
                            if (nextName.equals("file_md5")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -242755249:
                            if (nextName.equals("upload_dir")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -169850194:
                            if (nextName.equals("url_md5")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 108801336:
                            if (nextName.equals("is_block")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 133361217:
                            if (nextName.equals("first_uid")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 1065013944:
                            if (nextName.equals("upload_type")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 2020321370:
                            if (nextName.equals("last_update_time")) {
                                c = 16;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            i5 = this.spamStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 1:
                            str19 = this.lastUidAdapter.read(jsonReader);
                            continue;
                        case 2:
                            i6 = this.uploadCountAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            str16 = this.fileSizeAdapter.read(jsonReader);
                            continue;
                        case 4:
                            i9 = this.isBannedAdapter.read(jsonReader).intValue();
                            continue;
                        case 5:
                            i8 = this.isForbidAdapter.read(jsonReader).intValue();
                            continue;
                        case 6:
                            str17 = this.fileExtAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str11 = this.fileMd5Adapter.read(jsonReader);
                            continue;
                        case '\b':
                            str15 = this.uploadDirAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str13 = this.urlMd5Adapter.read(jsonReader);
                            continue;
                        case '\n':
                            str20 = this.idAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str12 = this.urlAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            i7 = this.isBlockAdapter.read(jsonReader).intValue();
                            continue;
                        case '\r':
                            str18 = this.firstUidAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str14 = this.uploadTypeAdapter.read(jsonReader);
                            continue;
                        case 15:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case 16:
                            l5 = this.lastUpdateTimeAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_FileDetail(str20, str11, str12, str13, str14, str15, str16, str17, str18, l4, str19, l5, i6, i7, i8, i9, i5);
        }
    }
}
