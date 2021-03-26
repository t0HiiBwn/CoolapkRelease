package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_FileDetail  reason: invalid class name */
abstract class C$$AutoValue_FileDetail extends FileDetail {
    private final Long dateline;
    private final String fileExt;
    private final String fileMd5;
    private final String fileSize;
    private final String firstUid;
    private final String id;
    private final int isBanned;
    private final int isBlock;
    private final int isForbid;
    private final String lastUid;
    private final Long lastUpdateTime;
    private final int spamStatus;
    private final int uploadCount;
    private final String uploadDir;
    private final String uploadType;
    private final String url;
    private final String urlMd5;

    C$$AutoValue_FileDetail(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l2, String str10, Long l3, int i, int i2, int i3, int i4, int i5) {
        this.id = str;
        this.fileMd5 = str2;
        this.url = str3;
        this.urlMd5 = str4;
        this.uploadType = str5;
        this.uploadDir = str6;
        this.fileSize = str7;
        this.fileExt = str8;
        this.firstUid = str9;
        this.dateline = l2;
        this.lastUid = str10;
        this.lastUpdateTime = l3;
        this.uploadCount = i;
        this.isBlock = i2;
        this.isForbid = i3;
        this.isBanned = i4;
        this.spamStatus = i5;
    }

    @Override // com.coolapk.market.model.FileDetail
    public String id() {
        return this.id;
    }

    @Override // com.coolapk.market.model.FileDetail
    @SerializedName("file_md5")
    public String fileMd5() {
        return this.fileMd5;
    }

    @Override // com.coolapk.market.model.FileDetail
    public String url() {
        return this.url;
    }

    @Override // com.coolapk.market.model.FileDetail
    @SerializedName("url_md5")
    public String urlMd5() {
        return this.urlMd5;
    }

    @Override // com.coolapk.market.model.FileDetail
    @SerializedName("upload_type")
    public String uploadType() {
        return this.uploadType;
    }

    @Override // com.coolapk.market.model.FileDetail
    @SerializedName("upload_dir")
    public String uploadDir() {
        return this.uploadDir;
    }

    @Override // com.coolapk.market.model.FileDetail
    @SerializedName("file_size")
    public String fileSize() {
        return this.fileSize;
    }

    @Override // com.coolapk.market.model.FileDetail
    @SerializedName("file_ext")
    public String fileExt() {
        return this.fileExt;
    }

    @Override // com.coolapk.market.model.FileDetail
    @SerializedName("first_uid")
    public String firstUid() {
        return this.firstUid;
    }

    @Override // com.coolapk.market.model.FileDetail
    public Long dateline() {
        return this.dateline;
    }

    @Override // com.coolapk.market.model.FileDetail
    @SerializedName("last_uid")
    public String lastUid() {
        return this.lastUid;
    }

    @Override // com.coolapk.market.model.FileDetail
    @SerializedName("last_update_time")
    public Long lastUpdateTime() {
        return this.lastUpdateTime;
    }

    @Override // com.coolapk.market.model.FileDetail
    @SerializedName("upload_count")
    public int uploadCount() {
        return this.uploadCount;
    }

    @Override // com.coolapk.market.model.FileDetail
    @SerializedName("is_block")
    public int isBlock() {
        return this.isBlock;
    }

    @Override // com.coolapk.market.model.FileDetail
    @SerializedName("is_forbid")
    public int isForbid() {
        return this.isForbid;
    }

    @Override // com.coolapk.market.model.FileDetail
    @SerializedName("is_banned")
    public int isBanned() {
        return this.isBanned;
    }

    @Override // com.coolapk.market.model.FileDetail
    @SerializedName("spam_status")
    public int spamStatus() {
        return this.spamStatus;
    }

    @Override // java.lang.Object
    public String toString() {
        return "FileDetail{id=" + this.id + ", fileMd5=" + this.fileMd5 + ", url=" + this.url + ", urlMd5=" + this.urlMd5 + ", uploadType=" + this.uploadType + ", uploadDir=" + this.uploadDir + ", fileSize=" + this.fileSize + ", fileExt=" + this.fileExt + ", firstUid=" + this.firstUid + ", dateline=" + this.dateline + ", lastUid=" + this.lastUid + ", lastUpdateTime=" + this.lastUpdateTime + ", uploadCount=" + this.uploadCount + ", isBlock=" + this.isBlock + ", isForbid=" + this.isForbid + ", isBanned=" + this.isBanned + ", spamStatus=" + this.spamStatus + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileDetail)) {
            return false;
        }
        FileDetail fileDetail = (FileDetail) obj;
        String str = this.id;
        if (str != null ? str.equals(fileDetail.id()) : fileDetail.id() == null) {
            String str2 = this.fileMd5;
            if (str2 != null ? str2.equals(fileDetail.fileMd5()) : fileDetail.fileMd5() == null) {
                String str3 = this.url;
                if (str3 != null ? str3.equals(fileDetail.url()) : fileDetail.url() == null) {
                    String str4 = this.urlMd5;
                    if (str4 != null ? str4.equals(fileDetail.urlMd5()) : fileDetail.urlMd5() == null) {
                        String str5 = this.uploadType;
                        if (str5 != null ? str5.equals(fileDetail.uploadType()) : fileDetail.uploadType() == null) {
                            String str6 = this.uploadDir;
                            if (str6 != null ? str6.equals(fileDetail.uploadDir()) : fileDetail.uploadDir() == null) {
                                String str7 = this.fileSize;
                                if (str7 != null ? str7.equals(fileDetail.fileSize()) : fileDetail.fileSize() == null) {
                                    String str8 = this.fileExt;
                                    if (str8 != null ? str8.equals(fileDetail.fileExt()) : fileDetail.fileExt() == null) {
                                        String str9 = this.firstUid;
                                        if (str9 != null ? str9.equals(fileDetail.firstUid()) : fileDetail.firstUid() == null) {
                                            Long l2 = this.dateline;
                                            if (l2 != null ? l2.equals(fileDetail.dateline()) : fileDetail.dateline() == null) {
                                                String str10 = this.lastUid;
                                                if (str10 != null ? str10.equals(fileDetail.lastUid()) : fileDetail.lastUid() == null) {
                                                    Long l3 = this.lastUpdateTime;
                                                    if (l3 != null ? l3.equals(fileDetail.lastUpdateTime()) : fileDetail.lastUpdateTime() == null) {
                                                        if (this.uploadCount == fileDetail.uploadCount() && this.isBlock == fileDetail.isBlock() && this.isForbid == fileDetail.isForbid() && this.isBanned == fileDetail.isBanned() && this.spamStatus == fileDetail.spamStatus()) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.fileMd5;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.url;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.urlMd5;
        int hashCode4 = (hashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.uploadType;
        int hashCode5 = (hashCode4 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.uploadDir;
        int hashCode6 = (hashCode5 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.fileSize;
        int hashCode7 = (hashCode6 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.fileExt;
        int hashCode8 = (hashCode7 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.firstUid;
        int hashCode9 = (hashCode8 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode10 = (hashCode9 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str10 = this.lastUid;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        Long l3 = this.lastUpdateTime;
        if (l3 != null) {
            i = l3.hashCode();
        }
        return ((((((((((hashCode11 ^ i) * 1000003) ^ this.uploadCount) * 1000003) ^ this.isBlock) * 1000003) ^ this.isForbid) * 1000003) ^ this.isBanned) * 1000003) ^ this.spamStatus;
    }
}
