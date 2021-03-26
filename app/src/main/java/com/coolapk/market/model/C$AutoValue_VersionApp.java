package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_VersionApp  reason: invalid class name */
abstract class C$AutoValue_VersionApp extends C$$AutoValue_VersionApp {
    C$AutoValue_VersionApp(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(str, str2, str3, str4, str5, str6, str7, str8);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_VersionApp$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<VersionApp> {
        private final TypeAdapter<String> appNameAdapter;
        private String defaultAppName = null;
        private String defaultDownloadFrom = null;
        private String defaultPackageName = null;
        private String defaultVersionDate = null;
        private String defaultVersionId = null;
        private String defaultVersionLength = null;
        private String defaultVersionName = null;
        private String defaultVersionSize = null;
        private final TypeAdapter<String> downloadFromAdapter;
        private final TypeAdapter<String> packageNameAdapter;
        private final TypeAdapter<String> versionDateAdapter;
        private final TypeAdapter<String> versionIdAdapter;
        private final TypeAdapter<String> versionLengthAdapter;
        private final TypeAdapter<String> versionNameAdapter;
        private final TypeAdapter<String> versionSizeAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.packageNameAdapter = gson.getAdapter(String.class);
            this.versionNameAdapter = gson.getAdapter(String.class);
            this.appNameAdapter = gson.getAdapter(String.class);
            this.versionIdAdapter = gson.getAdapter(String.class);
            this.versionSizeAdapter = gson.getAdapter(String.class);
            this.versionLengthAdapter = gson.getAdapter(String.class);
            this.versionDateAdapter = gson.getAdapter(String.class);
            this.downloadFromAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultPackageName(String str) {
            this.defaultPackageName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVersionName(String str) {
            this.defaultVersionName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAppName(String str) {
            this.defaultAppName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVersionId(String str) {
            this.defaultVersionId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVersionSize(String str) {
            this.defaultVersionSize = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVersionLength(String str) {
            this.defaultVersionLength = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVersionDate(String str) {
            this.defaultVersionDate = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDownloadFrom(String str) {
            this.defaultDownloadFrom = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, VersionApp versionApp) throws IOException {
            if (versionApp == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("packageName");
            this.packageNameAdapter.write(jsonWriter, versionApp.getPackageName());
            jsonWriter.name("version");
            this.versionNameAdapter.write(jsonWriter, versionApp.getVersionName());
            jsonWriter.name("title");
            this.appNameAdapter.write(jsonWriter, versionApp.getAppName());
            jsonWriter.name("versionId");
            this.versionIdAdapter.write(jsonWriter, versionApp.getVersionId());
            jsonWriter.name("versionSize");
            this.versionSizeAdapter.write(jsonWriter, versionApp.getVersionSize());
            jsonWriter.name("versionLength");
            this.versionLengthAdapter.write(jsonWriter, versionApp.getVersionLength());
            jsonWriter.name("versionDate");
            this.versionDateAdapter.write(jsonWriter, versionApp.getVersionDate());
            jsonWriter.name("downloadFrom");
            this.downloadFromAdapter.write(jsonWriter, versionApp.getDownloadFrom());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public VersionApp read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultPackageName;
            String str2 = this.defaultVersionName;
            String str3 = this.defaultAppName;
            String str4 = this.defaultVersionId;
            String str5 = this.defaultVersionSize;
            String str6 = this.defaultVersionLength;
            String str7 = str;
            String str8 = str2;
            String str9 = str3;
            String str10 = str4;
            String str11 = str5;
            String str12 = str6;
            String str13 = this.defaultVersionDate;
            String str14 = this.defaultDownloadFrom;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1407102957:
                            if (nextName.equals("versionId")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 351608024:
                            if (nextName.equals("version")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 560284126:
                            if (nextName.equals("versionLength")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 688608422:
                            if (nextName.equals("versionDate")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 689063161:
                            if (nextName.equals("versionSize")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 908759025:
                            if (nextName.equals("packageName")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 1108660306:
                            if (nextName.equals("downloadFrom")) {
                                c = 7;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str10 = this.versionIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str9 = this.appNameAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str8 = this.versionNameAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str12 = this.versionLengthAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str13 = this.versionDateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str11 = this.versionSizeAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str7 = this.packageNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str14 = this.downloadFromAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_VersionApp(str7, str8, str9, str10, str11, str12, str13, str14);
        }
    }
}
