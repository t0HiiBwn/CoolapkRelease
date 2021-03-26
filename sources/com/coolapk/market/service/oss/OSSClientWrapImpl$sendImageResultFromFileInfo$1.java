package com.coolapk.market.service.oss;

import android.util.Pair;
import com.coolapk.market.service.oss.OSSUploadImageProcessor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroid/util/Pair;", "", "kotlin.jvm.PlatformType", "data", "Lcom/coolapk/market/service/oss/OSSUploadImageProcessor$OSSUploadData;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: OssHelper.kt */
final class OSSClientWrapImpl$sendImageResultFromFileInfo$1<T, R> implements Func1<OSSUploadImageProcessor.OSSUploadData, Pair<String, String>> {
    final /* synthetic */ List $fileInfoList;

    OSSClientWrapImpl$sendImageResultFromFileInfo$1(List list) {
        this.$fileInfoList = list;
    }

    public final Pair<String, String> call(OSSUploadImageProcessor.OSSUploadData oSSUploadData) {
        String str;
        T t;
        if (oSSUploadData.getFileUploadName().length() == 0) {
            return Pair.create(oSSUploadData.getUrl(), oSSUploadData.getUrl());
        }
        Iterator<T> it2 = this.$fileInfoList.iterator();
        while (true) {
            str = null;
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (Intrinsics.areEqual(t.optString("name"), oSSUploadData.getFileUploadName())) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            str = t2.optString("url");
        }
        if (str == null) {
            str = "";
        }
        return Pair.create(oSSUploadData.getUrl(), str);
    }
}
