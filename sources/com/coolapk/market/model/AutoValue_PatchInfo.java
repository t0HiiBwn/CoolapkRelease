package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class AutoValue_PatchInfo extends C$AutoValue_PatchInfo {
    AutoValue_PatchInfo(String str, String str2, String str3, String str4, int i, String str5, long j, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Long l, String str13, String str14) {
        super(str, str2, str3, str4, i, str5, j, str6, str7, str8, str9, str10, str11, str12, l, str13, str14);
    }

    public static final class GsonTypeAdapter extends TypeAdapter<PatchInfo> {
        private final TypeAdapter<String> apkIdAdapter;
        private final TypeAdapter<String> apkSizeAdapter;
        private final TypeAdapter<String> appFullNameAdapter;
        private final TypeAdapter<String> appNameAdapter;
        private final TypeAdapter<String> changeLogAdapter;
        private String defaultApkId = null;
        private String defaultApkSize = null;
        private String defaultAppFullName = null;
        private String defaultAppName = null;
        private String defaultChangeLog = null;
        private String defaultDisplayVersionName = null;
        private String defaultExtraAnalysisData = null;
        private String defaultExtraFlag = null;
        private long defaultLastUpdate = 0;
        private String defaultLogo = null;
        private String defaultPackageName = null;
        private String defaultPatchKey = null;
        private Long defaultPatchLength = null;
        private String defaultPatchMd5 = null;
        private String defaultPatchSize = null;
        private int defaultVersionCode = 0;
        private String defaultVersionName = null;
        private final TypeAdapter<String> displayVersionNameAdapter;
        private final TypeAdapter<String> extraAnalysisDataAdapter;
        private final TypeAdapter<String> extraFlagAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> packageNameAdapter;
        private final TypeAdapter<String> patchKeyAdapter;
        private final TypeAdapter<Long> patchLengthAdapter;
        private final TypeAdapter<String> patchMd5Adapter;
        private final TypeAdapter<String> patchSizeAdapter;
        private final TypeAdapter<Integer> versionCodeAdapter;
        private final TypeAdapter<String> versionNameAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.packageNameAdapter = gson.getAdapter(String.class);
            this.apkIdAdapter = gson.getAdapter(String.class);
            this.displayVersionNameAdapter = gson.getAdapter(String.class);
            this.versionNameAdapter = gson.getAdapter(String.class);
            this.versionCodeAdapter = gson.getAdapter(Integer.class);
            this.apkSizeAdapter = gson.getAdapter(String.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.changeLogAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.appFullNameAdapter = gson.getAdapter(String.class);
            this.appNameAdapter = gson.getAdapter(String.class);
            this.extraAnalysisDataAdapter = gson.getAdapter(String.class);
            this.patchKeyAdapter = gson.getAdapter(String.class);
            this.patchSizeAdapter = gson.getAdapter(String.class);
            this.patchLengthAdapter = gson.getAdapter(Long.class);
            this.patchMd5Adapter = gson.getAdapter(String.class);
            this.extraFlagAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultPackageName(String str) {
            this.defaultPackageName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultApkId(String str) {
            this.defaultApkId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDisplayVersionName(String str) {
            this.defaultDisplayVersionName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVersionName(String str) {
            this.defaultVersionName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVersionCode(int i) {
            this.defaultVersionCode = i;
            return this;
        }

        public GsonTypeAdapter setDefaultApkSize(String str) {
            this.defaultApkSize = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLastUpdate(long j) {
            this.defaultLastUpdate = j;
            return this;
        }

        public GsonTypeAdapter setDefaultChangeLog(String str) {
            this.defaultChangeLog = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAppFullName(String str) {
            this.defaultAppFullName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAppName(String str) {
            this.defaultAppName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraAnalysisData(String str) {
            this.defaultExtraAnalysisData = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPatchKey(String str) {
            this.defaultPatchKey = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPatchSize(String str) {
            this.defaultPatchSize = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPatchLength(Long l) {
            this.defaultPatchLength = l;
            return this;
        }

        public GsonTypeAdapter setDefaultPatchMd5(String str) {
            this.defaultPatchMd5 = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraFlag(String str) {
            this.defaultExtraFlag = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, PatchInfo patchInfo) throws IOException {
            if (patchInfo == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("packageName");
            this.packageNameAdapter.write(jsonWriter, patchInfo.getPackageName());
            jsonWriter.name("id");
            this.apkIdAdapter.write(jsonWriter, patchInfo.getApkId());
            jsonWriter.name("version");
            this.displayVersionNameAdapter.write(jsonWriter, patchInfo.getDisplayVersionName());
            jsonWriter.name("apkversionname");
            this.versionNameAdapter.write(jsonWriter, patchInfo.getVersionName());
            jsonWriter.name("apkversioncode");
            this.versionCodeAdapter.write(jsonWriter, Integer.valueOf(patchInfo.getVersionCode()));
            jsonWriter.name("apksize");
            this.apkSizeAdapter.write(jsonWriter, patchInfo.getApkSize());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, Long.valueOf(patchInfo.getLastUpdate()));
            jsonWriter.name("changelog");
            this.changeLogAdapter.write(jsonWriter, patchInfo.getChangeLog());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, patchInfo.getLogo());
            jsonWriter.name("title");
            this.appFullNameAdapter.write(jsonWriter, patchInfo.getAppFullName());
            jsonWriter.name("shorttitle");
            this.appNameAdapter.write(jsonWriter, patchInfo.getAppName());
            jsonWriter.name("extraAnalysisData");
            this.extraAnalysisDataAdapter.write(jsonWriter, patchInfo.getExtraAnalysisData());
            jsonWriter.name("patchKey");
            this.patchKeyAdapter.write(jsonWriter, patchInfo.getPatchKey());
            jsonWriter.name("patchSize");
            this.patchSizeAdapter.write(jsonWriter, patchInfo.getPatchSize());
            jsonWriter.name("patchLength");
            this.patchLengthAdapter.write(jsonWriter, patchInfo.getPatchLength());
            jsonWriter.name("patchMd5");
            this.patchMd5Adapter.write(jsonWriter, patchInfo.getPatchMd5());
            jsonWriter.name("extraFlag");
            this.extraFlagAdapter.write(jsonWriter, patchInfo.getExtraFlag());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public PatchInfo read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultPackageName;
            String str2 = this.defaultApkId;
            String str3 = this.defaultDisplayVersionName;
            String str4 = this.defaultVersionName;
            int i = this.defaultVersionCode;
            String str5 = this.defaultApkSize;
            long j = this.defaultLastUpdate;
            String str6 = this.defaultChangeLog;
            String str7 = this.defaultLogo;
            String str8 = this.defaultAppFullName;
            String str9 = this.defaultAppName;
            String str10 = this.defaultExtraAnalysisData;
            String str11 = this.defaultPatchKey;
            String str12 = this.defaultPatchSize;
            Long l = this.defaultPatchLength;
            String str13 = this.defaultPatchMd5;
            String str14 = this.defaultExtraFlag;
            String str15 = str2;
            String str16 = str3;
            String str17 = str4;
            int i2 = i;
            String str18 = str5;
            long j2 = j;
            String str19 = str6;
            String str20 = str7;
            String str21 = str8;
            String str22 = str9;
            String str23 = str10;
            String str24 = str11;
            String str25 = str;
            String str26 = str12;
            Long l2 = l;
            String str27 = str13;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -797643747:
                            if (nextName.equals("apksize")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -590800682:
                            if (nextName.equals("extraAnalysisData")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -513404823:
                            if (nextName.equals("patchSize")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -253722724:
                            if (nextName.equals("extraFlag")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 334754126:
                            if (nextName.equals("patchLength")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 351608024:
                            if (nextName.equals("version")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 908759025:
                            if (nextName.equals("packageName")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 1230356727:
                            if (nextName.equals("patchKey")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 1230358550:
                            if (nextName.equals("patchMd5")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 1320549161:
                            if (nextName.equals("apkversioncode")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 1320863687:
                            if (nextName.equals("apkversionname")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 1455272340:
                            if (nextName.equals("changelog")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 1585056604:
                            if (nextName.equals("shorttitle")) {
                                c = 16;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            j2 = this.lastUpdateAdapter.read(jsonReader).longValue();
                            continue;
                        case 1:
                            str18 = this.apkSizeAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str23 = this.extraAnalysisDataAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str26 = this.patchSizeAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str14 = this.extraFlagAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str15 = this.apkIdAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str20 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str21 = this.appFullNameAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            l2 = this.patchLengthAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str16 = this.displayVersionNameAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str25 = this.packageNameAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str24 = this.patchKeyAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str27 = this.patchMd5Adapter.read(jsonReader);
                            continue;
                        case '\r':
                            i2 = this.versionCodeAdapter.read(jsonReader).intValue();
                            continue;
                        case 14:
                            str17 = this.versionNameAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str19 = this.changeLogAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str22 = this.appNameAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_PatchInfo(str25, str15, str16, str17, i2, str18, j2, str19, str20, str21, str22, str23, str24, str26, l2, str27, str14);
        }
    }
}
