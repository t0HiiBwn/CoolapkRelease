package com.coolapk.market.service.oss;

import android.os.Bundle;
import android.util.Pair;
import com.coolapk.market.local.DataConfig;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ImageUploadOption;
import com.coolapk.market.network.IOSSClientWrap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0002J\"\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\"\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J(\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00110\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0016R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/service/oss/OSSClientWrapImpl;", "Lcom/coolapk/market/network/IOSSClientWrap;", "()V", "apiHost", "", "kotlin.jvm.PlatformType", "getApiHost", "()Ljava/lang/String;", "realClient", "Lcom/coolapk/market/service/oss/RealOSSClientWrap;", "createSpiltImageGroup", "", "Lcom/coolapk/market/model/ImageUploadOption;", "urls", "", "sendImageResultAfterUpload", "Lrx/Observable;", "Landroid/util/Pair;", "processor", "Lcom/coolapk/market/service/oss/OSSUploadImageProcessor;", "sendImageResultFromFileInfo", "uploadImage", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OssHelper.kt */
public final class OSSClientWrapImpl implements IOSSClientWrap {
    public static final OSSClientWrapImpl INSTANCE = new OSSClientWrapImpl();
    private static RealOSSClientWrap realClient = new RealOSSClientWrap();

    private OSSClientWrapImpl() {
    }

    private final String getApiHost() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        DataConfig dataConfig = instance.getDataConfig();
        Intrinsics.checkNotNullExpressionValue(dataConfig, "DataManager.getInstance().dataConfig");
        return dataConfig.getApiHost();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        if (r0.equals("feed_cover") != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        if (r0.equals("feed") != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
        if (r0.equals("picture") != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        r2.element = "image";
     */
    @Override // com.coolapk.market.network.IOSSClientWrap
    public Observable<Pair<String, String>> uploadImage(List<ImageUploadOption> list) {
        Intrinsics.checkNotNullParameter(list, "urls");
        if (list.isEmpty()) {
            Observable<Pair<String, String>> empty = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
            return empty;
        }
        String uploadDir = ((ImageUploadOption) CollectionsKt.first((List<? extends Object>) list)).getUploadDir();
        Bundle bundle = ((ImageUploadOption) CollectionsKt.first((List<? extends Object>) list)).getBundle();
        boolean z = bundle != null ? bundle.getBoolean("extra_anonymous") : false;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (uploadDir != null) {
            switch (uploadDir.hashCode()) {
                case -577741570:
                    break;
                case 3138974:
                    break;
                case 94852023:
                    if (uploadDir.equals("cover")) {
                        objectRef.element = "avatar";
                        Observable<Pair<String, String>> flatMap = Observable.just(list).map(OSSClientWrapImpl$uploadImage$1.INSTANCE).flatMap(OSSClientWrapImpl$uploadImage$2.INSTANCE).map(OSSClientWrapImpl$uploadImage$3.INSTANCE).doOnNext(new OSSClientWrapImpl$uploadImage$4(z, objectRef)).flatMap(OSSClientWrapImpl$uploadImage$5.INSTANCE);
                        Intrinsics.checkNotNullExpressionValue(flatMap, "Observable.just(urls)\n  …      }\n                }");
                        return flatMap;
                    }
                    break;
                case 567045590:
                    break;
            }
        }
        Observable<Pair<String, String>> uploadImageOld = DataManager.getInstance().uploadImageOld(list);
        Intrinsics.checkNotNullExpressionValue(uploadImageOld, "DataManager.getInstance().uploadImageOld(urls)");
        return uploadImageOld;
    }

    /* access modifiers changed from: private */
    public final List<List<ImageUploadOption>> createSpiltImageGroup(List<ImageUploadOption> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        if (list.size() >= 2) {
            List<ImageUploadOption> list2 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().getUploadDir());
            }
            Iterator it3 = arrayList2.iterator();
            if (it3.hasNext()) {
                Object next = it3.next();
                while (it3.hasNext()) {
                    next = (String) next;
                    if (!Intrinsics.areEqual(next, (String) it3.next())) {
                        next = "ERROR";
                    }
                }
                z = true ^ Intrinsics.areEqual((String) next, "ERROR");
            } else {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
        }
        if (!z) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (T t : list) {
                String uploadDir = t.getUploadDir();
                Intrinsics.checkNotNullExpressionValue(uploadDir, "it.uploadDir");
                Object obj = linkedHashMap.get(uploadDir);
                if (obj == null) {
                    obj = (List) new ArrayList();
                    linkedHashMap.put(uploadDir, obj);
                }
                ((List) obj).add(t);
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                arrayList.addAll(INSTANCE.createSpiltImageGroup((List) entry.getValue()));
            }
            return arrayList;
        }
        int size = list.size() / 9;
        for (int i = 0; i <= size; i++) {
            if (i == size) {
                int i2 = i * 9;
                int size2 = list.size();
                if (i2 != size2) {
                    arrayList.add(list.subList(i2, size2));
                }
            } else {
                arrayList.add(list.subList(i * 9, (i + 1) * 9));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final Observable<Pair<String, String>> sendImageResultFromFileInfo(OSSUploadImageProcessor oSSUploadImageProcessor) {
        List<JSONObject> fileInfoList$presentation_coolapkAppRelease = oSSUploadImageProcessor.getFileInfoList$presentation_coolapkAppRelease();
        if (fileInfoList$presentation_coolapkAppRelease == null) {
            fileInfoList$presentation_coolapkAppRelease = CollectionsKt.emptyList();
        }
        Observable<Pair<String, String>> map = Observable.from(oSSUploadImageProcessor.getDataList$presentation_coolapkAppRelease()).map(new OSSClientWrapImpl$sendImageResultFromFileInfo$1(fileInfoList$presentation_coolapkAppRelease));
        Intrinsics.checkNotNullExpressionValue(map, "Observable.from(processo…      }\n                }");
        return map;
    }

    /* access modifiers changed from: private */
    public final Observable<Pair<String, String>> sendImageResultAfterUpload(OSSUploadImageProcessor oSSUploadImageProcessor) {
        HashMap hashMap;
        JSONObject uploadPrepareInfo$presentation_coolapkAppRelease = oSSUploadImageProcessor.getUploadPrepareInfo$presentation_coolapkAppRelease();
        Intrinsics.checkNotNull(uploadPrepareInfo$presentation_coolapkAppRelease);
        List<JSONObject> fileInfoList$presentation_coolapkAppRelease = oSSUploadImageProcessor.getFileInfoList$presentation_coolapkAppRelease();
        Intrinsics.checkNotNull(fileInfoList$presentation_coolapkAppRelease);
        JSONObject optJSONObject = uploadPrepareInfo$presentation_coolapkAppRelease.optJSONObject("process");
        if (optJSONObject != null) {
            hashMap = new HashMap();
            Iterator<String> keys = optJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "jsonObj.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNullExpressionValue(next, "it");
                String optString = optJSONObject.optString(next);
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObj.optString(it)");
                hashMap.put(next, optString);
            }
        } else {
            hashMap = null;
        }
        String optString2 = uploadPrepareInfo$presentation_coolapkAppRelease.optString("bucket");
        if (optString2 == null) {
            optString2 = "";
        }
        String optString3 = uploadPrepareInfo$presentation_coolapkAppRelease.optString("uploadImagePrefix");
        if (optString3 == null) {
            optString3 = "http://image.coolapk.com";
        }
        String optString4 = uploadPrepareInfo$presentation_coolapkAppRelease.optString("callbackUrl");
        if (optString4 == null) {
            optString4 = "https://" + getApiHost() + "/v6/callback/mobileOssUploadSuccessCallback?checkArticleCoverResolution=0";
        }
        realClient.updateConfig$presentation_coolapkAppRelease(OSSClientConfig.Companion.fromJSONObject(uploadPrepareInfo$presentation_coolapkAppRelease));
        Observable<Pair<String, String>> map = Observable.from(oSSUploadImageProcessor.getDataList$presentation_coolapkAppRelease()).map(new OSSClientWrapImpl$sendImageResultAfterUpload$1(fileInfoList$presentation_coolapkAppRelease, optString2, optJSONObject, optString4, hashMap, optString3));
        Intrinsics.checkNotNullExpressionValue(map, "Observable.from(processo…      }\n                }");
        return map;
    }
}
