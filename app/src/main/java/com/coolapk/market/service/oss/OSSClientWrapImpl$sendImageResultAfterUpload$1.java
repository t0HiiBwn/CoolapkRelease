package com.coolapk.market.service.oss;

import android.net.Uri;
import android.util.Pair;
import com.coolapk.market.service.oss.OSSUploadImageProcessor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroid/util/Pair;", "", "kotlin.jvm.PlatformType", "data", "Lcom/coolapk/market/service/oss/OSSUploadImageProcessor$OSSUploadData;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: OssHelper.kt */
final class OSSClientWrapImpl$sendImageResultAfterUpload$1<T, R> implements Func1<OSSUploadImageProcessor.OSSUploadData, Pair<String, String>> {
    final /* synthetic */ String $bucket;
    final /* synthetic */ String $callbackUrl;
    final /* synthetic */ List $fileInfoList;
    final /* synthetic */ String $prefix;
    final /* synthetic */ JSONObject $processList;
    final /* synthetic */ HashMap $processMap;

    OSSClientWrapImpl$sendImageResultAfterUpload$1(List list, String str, JSONObject jSONObject, String str2, HashMap hashMap, String str3) {
        this.$fileInfoList = list;
        this.$bucket = str;
        this.$processList = jSONObject;
        this.$callbackUrl = str2;
        this.$processMap = hashMap;
        this.$prefix = str3;
    }

    public final Pair<String, String> call(OSSUploadImageProcessor.OSSUploadData oSSUploadData) {
        T t;
        boolean z = true;
        if (oSSUploadData.getFileUploadName().length() == 0) {
            return Pair.create(oSSUploadData.getUrl(), oSSUploadData.getUrl());
        }
        Iterator<T> it2 = this.$fileInfoList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (Intrinsics.areEqual(t.optString("name"), oSSUploadData.getFileUploadName())) {
                break;
            }
        }
        Intrinsics.checkNotNull(t);
        T t2 = t;
        String optString = t2.optString("url");
        String str = optString;
        if (!(str == null || str.length() == 0)) {
            return Pair.create(oSSUploadData.getUrl(), optString);
        }
        String optString2 = t2.optString("uploadFileName");
        String str2 = this.$bucket;
        Intrinsics.checkNotNullExpressionValue(optString2, "uploadFileName");
        OSSPutRequest oSSPutRequest = new OSSPutRequest(str2, optString2, oSSUploadData.getFileAbsPath());
        OSSClientWrapImpl oSSClientWrapImpl = OSSClientWrapImpl.INSTANCE;
        RealOSSClientWrap realOSSClientWrap = OSSClientWrapImpl.realClient;
        if (this.$processList == null) {
            z = false;
        }
        realOSSClientWrap.uploadImage(oSSPutRequest, z, this.$callbackUrl).toBlocking().first().toString();
        if (this.$processMap != null) {
            String str3 = this.$bucket;
            OSSImagePersist oSSImagePersist = new OSSImagePersist(str3, optString2, str3, "", "");
            for (Map.Entry entry : this.$processMap.entrySet()) {
                String str4 = (String) entry.getKey();
                OSSImagePersist copy$default = OSSImagePersist.copy$default(oSSImagePersist, null, null, null, optString2 + this.$processList.get(str4), str4, 7, null);
                OSSClientWrapImpl oSSClientWrapImpl2 = OSSClientWrapImpl.INSTANCE;
                OSSClientWrapImpl.realClient.imagePersist(copy$default).toBlocking().first();
            }
        }
        return Pair.create(oSSUploadData.getUrl(), Uri.parse(this.$prefix).buildUpon().appendEncodedPath(optString2).build().toString());
    }
}
