package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;

/* renamed from: com.coolapk.market.model.$AutoValue_BackupInfo  reason: invalid class name */
abstract class C$AutoValue_BackupInfo extends C$$AutoValue_BackupInfo {
    C$AutoValue_BackupInfo(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, Long l2, Long l3, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i, int i2, Long l4, Long l5, List<ServiceApp> list, List<LocalApp> list2) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, l2, l3, str10, str11, str12, str13, str14, str15, str16, i, i2, l4, l5, list, list2);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_BackupInfo$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<BackupInfo> {
        private final TypeAdapter<Integer> apkNumAdapter;
        private final TypeAdapter<Integer> backNumAdapter;
        private final TypeAdapter<Long> createTimeAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private int defaultApkNum = 0;
        private int defaultBackNum = 0;
        private Long defaultCreateTime = null;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private String defaultDeviceName = null;
        private String defaultDeviceTitle = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultId = null;
        private Long defaultLastUpdate = null;
        private List<LocalApp> defaultLocalApps = null;
        private String defaultLogo = null;
        private String defaultPic = null;
        private Long defaultRecoveryTime = null;
        private List<ServiceApp> defaultServiceApps = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUid = null;
        private String defaultUrl = null;
        private String defaultUserName = null;
        private String defaultVersionMD5 = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<String> deviceNameAdapter;
        private final TypeAdapter<String> deviceTitleAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<List<LocalApp>> localAppsAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<Long> recoveryTimeAdapter;
        private final TypeAdapter<List<ServiceApp>> serviceAppsAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<String> userNameAdapter;
        private final TypeAdapter<String> versionMD5Adapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.userNameAdapter = gson.getAdapter(String.class);
            this.versionMD5Adapter = gson.getAdapter(String.class);
            this.deviceNameAdapter = gson.getAdapter(String.class);
            this.deviceTitleAdapter = gson.getAdapter(String.class);
            this.apkNumAdapter = gson.getAdapter(Integer.class);
            this.backNumAdapter = gson.getAdapter(Integer.class);
            this.recoveryTimeAdapter = gson.getAdapter(Long.class);
            this.createTimeAdapter = gson.getAdapter(Long.class);
            this.serviceAppsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, ServiceApp.class));
            this.localAppsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, LocalApp.class));
        }

        public GsonTypeAdapter setDefaultEntityTypeName(String str) {
            this.defaultEntityTypeName = str;
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

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPic(String str) {
            this.defaultPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
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

        public GsonTypeAdapter setDefaultDateline(Long l2) {
            this.defaultDateline = l2;
            return this;
        }

        public GsonTypeAdapter setDefaultLastUpdate(Long l2) {
            this.defaultLastUpdate = l2;
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

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserName(String str) {
            this.defaultUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVersionMD5(String str) {
            this.defaultVersionMD5 = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDeviceName(String str) {
            this.defaultDeviceName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDeviceTitle(String str) {
            this.defaultDeviceTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultApkNum(int i) {
            this.defaultApkNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultBackNum(int i) {
            this.defaultBackNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRecoveryTime(Long l2) {
            this.defaultRecoveryTime = l2;
            return this;
        }

        public GsonTypeAdapter setDefaultCreateTime(Long l2) {
            this.defaultCreateTime = l2;
            return this;
        }

        public GsonTypeAdapter setDefaultServiceApps(List<ServiceApp> list) {
            this.defaultServiceApps = list;
            return this;
        }

        public GsonTypeAdapter setDefaultLocalApps(List<LocalApp> list) {
            this.defaultLocalApps = list;
            return this;
        }

        public void write(JsonWriter jsonWriter, BackupInfo backupInfo) throws IOException {
            if (backupInfo == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, backupInfo.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, backupInfo.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, backupInfo.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, backupInfo.getEntityFixed());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, backupInfo.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, backupInfo.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, backupInfo.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, backupInfo.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, backupInfo.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, backupInfo.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, backupInfo.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, backupInfo.getLastUpdate());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, backupInfo.getId());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, backupInfo.getTitle());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, backupInfo.getUid());
            jsonWriter.name("username");
            this.userNameAdapter.write(jsonWriter, backupInfo.getUserName());
            jsonWriter.name("version_md5");
            this.versionMD5Adapter.write(jsonWriter, backupInfo.getVersionMD5());
            jsonWriter.name("device_name");
            this.deviceNameAdapter.write(jsonWriter, backupInfo.getDeviceName());
            jsonWriter.name("device_title");
            this.deviceTitleAdapter.write(jsonWriter, backupInfo.getDeviceTitle());
            jsonWriter.name("apk_num");
            this.apkNumAdapter.write(jsonWriter, Integer.valueOf(backupInfo.getApkNum()));
            jsonWriter.name("backNum");
            this.backNumAdapter.write(jsonWriter, Integer.valueOf(backupInfo.getBackNum()));
            jsonWriter.name("recovery_time");
            this.recoveryTimeAdapter.write(jsonWriter, backupInfo.getRecoveryTime());
            jsonWriter.name("createdate");
            this.createTimeAdapter.write(jsonWriter, backupInfo.getCreateTime());
            jsonWriter.name("localEntities");
            this.serviceAppsAdapter.write(jsonWriter, backupInfo.getServiceApps());
            jsonWriter.name("unLocalEntities");
            this.localAppsAdapter.write(jsonWriter, backupInfo.getLocalApps());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public BackupInfo read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityTemplate;
            String str3 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str4 = this.defaultUrl;
            String str5 = this.defaultDescription;
            String str6 = this.defaultPic;
            String str7 = this.defaultLogo;
            String str8 = this.defaultSubTitle;
            String str9 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str10 = this.defaultId;
            String str11 = this.defaultTitle;
            String str12 = this.defaultUid;
            String str13 = this.defaultUserName;
            String str14 = this.defaultVersionMD5;
            String str15 = this.defaultDeviceName;
            String str16 = this.defaultDeviceTitle;
            int i = this.defaultApkNum;
            int i2 = this.defaultBackNum;
            Long l4 = this.defaultRecoveryTime;
            Long l5 = this.defaultCreateTime;
            List<ServiceApp> list = this.defaultServiceApps;
            List<LocalApp> list2 = this.defaultLocalApps;
            String str17 = str2;
            String str18 = str3;
            Integer num2 = num;
            String str19 = str4;
            String str20 = str5;
            String str21 = str6;
            String str22 = str7;
            String str23 = str8;
            String str24 = str9;
            Long l6 = l2;
            Long l7 = l3;
            String str25 = str10;
            String str26 = str11;
            String str27 = str;
            String str28 = str12;
            String str29 = str13;
            String str30 = str14;
            String str31 = str15;
            String str32 = str16;
            int i3 = i;
            int i4 = i2;
            Long l8 = l4;
            Long l9 = l5;
            List<ServiceApp> list3 = list;
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
                        case -1724546052:
                            if (nextName.equals("description")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1580301955:
                            if (nextName.equals("entityTemplate")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1543071020:
                            if (nextName.equals("device_name")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -798234909:
                            if (nextName.equals("apk_num")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -584774865:
                            if (nextName.equals("device_title")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -347229921:
                            if (nextName.equals("backNum")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 689423767:
                            if (nextName.equals("version_md5")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 754970700:
                            if (nextName.equals("localEntities")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 1369682602:
                            if (nextName.equals("createdate")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 1972109623:
                            if (nextName.equals("recovery_time")) {
                                c = 23;
                                break;
                            }
                            break;
                        case 2066960947:
                            if (nextName.equals("unLocalEntities")) {
                                c = 24;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str18 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str23 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str20 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str17 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str31 = this.deviceNameAdapter.read(jsonReader);
                            continue;
                        case 5:
                            l7 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str27 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            i3 = this.apkNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '\b':
                            str32 = this.deviceTitleAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            i4 = this.backNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '\n':
                            str29 = this.userNameAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str24 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str25 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str21 = this.picAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str28 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str19 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str22 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str26 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str30 = this.versionMD5Adapter.read(jsonReader);
                            continue;
                        case 19:
                            list3 = this.serviceAppsAdapter.read(jsonReader);
                            continue;
                        case 20:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 21:
                            l9 = this.createTimeAdapter.read(jsonReader);
                            continue;
                        case 22:
                            l6 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case 23:
                            l8 = this.recoveryTimeAdapter.read(jsonReader);
                            continue;
                        case 24:
                            list2 = this.localAppsAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_BackupInfo(str27, str17, str18, num2, str19, str20, str21, str22, str23, str24, l6, l7, str25, str26, str28, str29, str30, str31, str32, i3, i4, l8, l9, list3, list2);
        }
    }
}
