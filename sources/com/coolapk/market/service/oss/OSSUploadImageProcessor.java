package com.coolapk.market.service.oss;

import android.net.Uri;
import com.coolapk.market.AppHolder;
import com.coolapk.market.model.ImageUploadOption;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.StringUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001a\u001a\u00020\u001bR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\u0005R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/service/oss/OSSUploadImageProcessor;", "", "urls", "", "Lcom/coolapk/market/model/ImageUploadOption;", "(Ljava/util/List;)V", "dataList", "", "Lcom/coolapk/market/service/oss/OSSUploadImageProcessor$OSSUploadData;", "getDataList$presentation_coolapkAppRelease", "()Ljava/util/List;", "dir", "", "getDir$presentation_coolapkAppRelease", "()Ljava/lang/String;", "setDir$presentation_coolapkAppRelease", "(Ljava/lang/String;)V", "fileInfoList", "Lorg/json/JSONObject;", "getFileInfoList$presentation_coolapkAppRelease", "setFileInfoList$presentation_coolapkAppRelease", "uploadPrepareInfo", "getUploadPrepareInfo$presentation_coolapkAppRelease", "()Lorg/json/JSONObject;", "setUploadPrepareInfo$presentation_coolapkAppRelease", "(Lorg/json/JSONObject;)V", "generateUploadJsonArray", "Lorg/json/JSONArray;", "OSSUploadData", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OssHelper.kt */
final class OSSUploadImageProcessor {
    private final List<OSSUploadData> dataList = new ArrayList();
    private String dir = "";
    private List<? extends JSONObject> fileInfoList;
    private JSONObject uploadPrepareInfo;

    public OSSUploadImageProcessor(List<? extends ImageUploadOption> list) {
        Intrinsics.checkNotNullParameter(list, "urls");
        for (T t : list) {
            String url = t.getUrl();
            if (!(url == null || url.length() == 0)) {
                Uri parse = Uri.parse(t.getUrl());
                Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(it.url)");
                if (Intrinsics.areEqual(parse.getScheme(), "file")) {
                    Uri parse2 = Uri.parse(t.getUrl());
                    Intrinsics.checkNotNullExpressionValue(parse2, "Uri.parse(it.url)");
                    String absolutePath = new File(parse2.getPath()).getAbsolutePath();
                    String imageSize = BitmapUtil.getImageSize(AppHolder.getApplication(), t.getUrl());
                    String imageFileType = CoolFileUtils.getImageFileType(absolutePath);
                    imageFileType = imageFileType == null ? "jpg" : imageFileType;
                    Intrinsics.checkNotNullExpressionValue(imageFileType, "CoolFileUtils.getImageFileType(absPath) ?: \"jpg\"");
                    String str = StringUtils.toMd5(absolutePath) + "." + imageFileType;
                    String fileMd5 = CoolFileUtils.getFileMd5(absolutePath);
                    List<OSSUploadData> list2 = this.dataList;
                    String url2 = t.getUrl();
                    Intrinsics.checkNotNullExpressionValue(url2, "it.url");
                    String api = t.getApi();
                    Intrinsics.checkNotNullExpressionValue(api, "it.api");
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "absPath");
                    Intrinsics.checkNotNullExpressionValue(imageSize, "resource");
                    Intrinsics.checkNotNullExpressionValue(fileMd5, "md5");
                    list2.add(new OSSUploadData(url2, api, str, absolutePath, imageSize, fileMd5));
                } else {
                    List<OSSUploadData> list3 = this.dataList;
                    String url3 = t.getUrl();
                    Intrinsics.checkNotNullExpressionValue(url3, "it.url");
                    String api2 = t.getApi();
                    Intrinsics.checkNotNullExpressionValue(api2, "it.api");
                    list3.add(new OSSUploadData(url3, api2, null, null, null, null, 60, null));
                }
                String uploadDir = t.getUploadDir();
                Intrinsics.checkNotNullExpressionValue(uploadDir, "it.uploadDir");
                this.dir = uploadDir;
            } else {
                throw new RuntimeException("图片地址为空, 请检查");
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/service/oss/OSSUploadImageProcessor$OSSUploadData;", "", "url", "", "api", "fileUploadName", "fileAbsPath", "fileResource", "fileMd5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApi", "()Ljava/lang/String;", "getFileAbsPath", "getFileMd5", "getFileResource", "getFileUploadName", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: OssHelper.kt */
    public static final class OSSUploadData {
        private final String api;
        private final String fileAbsPath;
        private final String fileMd5;
        private final String fileResource;
        private final String fileUploadName;
        private final String url;

        public static /* synthetic */ OSSUploadData copy$default(OSSUploadData oSSUploadData, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = oSSUploadData.url;
            }
            if ((i & 2) != 0) {
                str2 = oSSUploadData.api;
            }
            if ((i & 4) != 0) {
                str3 = oSSUploadData.fileUploadName;
            }
            if ((i & 8) != 0) {
                str4 = oSSUploadData.fileAbsPath;
            }
            if ((i & 16) != 0) {
                str5 = oSSUploadData.fileResource;
            }
            if ((i & 32) != 0) {
                str6 = oSSUploadData.fileMd5;
            }
            return oSSUploadData.copy(str, str2, str3, str4, str5, str6);
        }

        public final String component1() {
            return this.url;
        }

        public final String component2() {
            return this.api;
        }

        public final String component3() {
            return this.fileUploadName;
        }

        public final String component4() {
            return this.fileAbsPath;
        }

        public final String component5() {
            return this.fileResource;
        }

        public final String component6() {
            return this.fileMd5;
        }

        public final OSSUploadData copy(String str, String str2, String str3, String str4, String str5, String str6) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(str2, "api");
            Intrinsics.checkNotNullParameter(str3, "fileUploadName");
            Intrinsics.checkNotNullParameter(str4, "fileAbsPath");
            Intrinsics.checkNotNullParameter(str5, "fileResource");
            Intrinsics.checkNotNullParameter(str6, "fileMd5");
            return new OSSUploadData(str, str2, str3, str4, str5, str6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OSSUploadData)) {
                return false;
            }
            OSSUploadData oSSUploadData = (OSSUploadData) obj;
            return Intrinsics.areEqual(this.url, oSSUploadData.url) && Intrinsics.areEqual(this.api, oSSUploadData.api) && Intrinsics.areEqual(this.fileUploadName, oSSUploadData.fileUploadName) && Intrinsics.areEqual(this.fileAbsPath, oSSUploadData.fileAbsPath) && Intrinsics.areEqual(this.fileResource, oSSUploadData.fileResource) && Intrinsics.areEqual(this.fileMd5, oSSUploadData.fileMd5);
        }

        public int hashCode() {
            String str = this.url;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.api;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.fileUploadName;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.fileAbsPath;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.fileResource;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.fileMd5;
            if (str6 != null) {
                i = str6.hashCode();
            }
            return hashCode5 + i;
        }

        public String toString() {
            return "OSSUploadData(url=" + this.url + ", api=" + this.api + ", fileUploadName=" + this.fileUploadName + ", fileAbsPath=" + this.fileAbsPath + ", fileResource=" + this.fileResource + ", fileMd5=" + this.fileMd5 + ")";
        }

        public OSSUploadData(String str, String str2, String str3, String str4, String str5, String str6) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(str2, "api");
            Intrinsics.checkNotNullParameter(str3, "fileUploadName");
            Intrinsics.checkNotNullParameter(str4, "fileAbsPath");
            Intrinsics.checkNotNullParameter(str5, "fileResource");
            Intrinsics.checkNotNullParameter(str6, "fileMd5");
            this.url = str;
            this.api = str2;
            this.fileUploadName = str3;
            this.fileAbsPath = str4;
            this.fileResource = str5;
            this.fileMd5 = str6;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ OSSUploadData(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6);
        }

        public final String getApi() {
            return this.api;
        }

        public final String getFileAbsPath() {
            return this.fileAbsPath;
        }

        public final String getFileMd5() {
            return this.fileMd5;
        }

        public final String getFileResource() {
            return this.fileResource;
        }

        public final String getFileUploadName() {
            return this.fileUploadName;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    public final List<OSSUploadData> getDataList$presentation_coolapkAppRelease() {
        return this.dataList;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends org.json.JSONObject>, java.util.List<org.json.JSONObject> */
    public final List<JSONObject> getFileInfoList$presentation_coolapkAppRelease() {
        return this.fileInfoList;
    }

    public final void setFileInfoList$presentation_coolapkAppRelease(List<? extends JSONObject> list) {
        this.fileInfoList = list;
    }

    public final JSONObject getUploadPrepareInfo$presentation_coolapkAppRelease() {
        return this.uploadPrepareInfo;
    }

    public final void setUploadPrepareInfo$presentation_coolapkAppRelease(JSONObject jSONObject) {
        this.uploadPrepareInfo = jSONObject;
    }

    public final String getDir$presentation_coolapkAppRelease() {
        return this.dir;
    }

    public final void setDir$presentation_coolapkAppRelease(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dir = str;
    }

    public final JSONArray generateUploadJsonArray() {
        JSONArray jSONArray = new JSONArray();
        ArrayList<OSSUploadData> arrayList = new ArrayList();
        for (T t : this.dataList) {
            if (t.getFileUploadName().length() > 0) {
                arrayList.add(t);
            }
        }
        for (OSSUploadData oSSUploadData : arrayList) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", oSSUploadData.getFileUploadName());
            jSONObject.put("resolution", oSSUploadData.getFileResource());
            jSONObject.put("md5", oSSUploadData.getFileMd5());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}
