package com.coolapk.market.service.oss;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.RxUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/service/oss/OSSUploadImageProcessor;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: OssHelper.kt */
final class OSSClientWrapImpl$uploadImage$4<T> implements Action1<OSSUploadImageProcessor> {
    final /* synthetic */ boolean $anonymous;
    final /* synthetic */ String $toUid;
    final /* synthetic */ Ref.ObjectRef $uploadBucket;

    OSSClientWrapImpl$uploadImage$4(boolean z, Ref.ObjectRef objectRef, String str) {
        this.$anonymous = z;
        this.$uploadBucket = objectRef;
        this.$toUid = str;
    }

    public final void call(OSSUploadImageProcessor oSSUploadImageProcessor) {
        JSONArray generateUploadJsonArray = oSSUploadImageProcessor.generateUploadJsonArray();
        if (generateUploadJsonArray.length() > 0) {
            boolean z = this.$anonymous;
            R first = DataManager.getInstance().ossUploadPrepare(this.$uploadBucket.element, oSSUploadImageProcessor.getDir$presentation_coolapkAppRelease(), z ? 1 : 0, generateUploadJsonArray.toString(), this.$toUid).map(RxUtils.checkResultToData()).toBlocking().first();
            JSONObject optJSONObject = first.optJSONObject("uploadPrepareInfo");
            JSONArray optJSONArray = first.optJSONArray("fileInfo");
            oSSUploadImageProcessor.setUploadPrepareInfo$presentation_coolapkAppRelease(optJSONObject);
            Intrinsics.checkNotNullExpressionValue(optJSONArray, "fileInfoArray");
            oSSUploadImageProcessor.setFileInfoList$presentation_coolapkAppRelease(KotlinExtendKt.toJSONObjectList(optJSONArray));
        }
    }
}
