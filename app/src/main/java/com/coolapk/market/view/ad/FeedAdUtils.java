package com.coolapk.market.view.ad;

import android.view.View;
import com.coolapk.market.manager.DataManager;
import com.qq.e.ads.nativ.NativeExpressADView;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bJ(\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/ad/FeedAdUtils;", "", "()V", "banAds", "Lorg/json/JSONArray;", "banAd", "", "name", "", "adId", "checkName", "", "cleanBanAds", "containBandAd", "adMark", "getAdInfo", "Lcom/coolapk/market/view/ad/AdInfo;", "appId", "posId", "view", "Landroid/view/View;", "getBanAds", "removeInvalid", "ads", "setBanAds", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedAdUtils.kt */
public final class FeedAdUtils {
    public static final FeedAdUtils INSTANCE = new FeedAdUtils();
    private static JSONArray banAds;

    private FeedAdUtils() {
    }

    public final AdInfo getAdInfo(String str, String str2, String str3, View view) {
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, "posId");
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            if (!(view instanceof NativeExpressADView)) {
                return null;
            }
            Field declaredField = view.getClass().getDeclaredField("e");
            boolean z = true;
            declaredField.setAccessible(true);
            Object obj = declaredField.get(view);
            Field declaredField2 = obj.getClass().getDeclaredField("a");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Class<? super Object> superclass = obj2.getClass().getSuperclass();
            Intrinsics.checkNotNull(superclass);
            Field declaredField3 = superclass.getDeclaredField("a");
            declaredField3.setAccessible(true);
            Object obj3 = declaredField3.get(obj2);
            if (obj3 != null) {
                Map map = (Map) obj3;
                String str6 = (String) map.get("ad_id");
                String str7 = (String) map.get("ad_title");
                String str8 = (String) map.get("ad_desc");
                String str9 = str8 != null ? str8 : "";
                String str10 = (String) map.get("ad_info");
                if (str10 != null) {
                    str4 = str10;
                } else {
                    str4 = "";
                }
                if (str4.length() <= 0) {
                    z = false;
                }
                if (z) {
                    String optString = new JSONObject(str4).optString("img", "");
                    Intrinsics.checkNotNullExpressionValue(optString, "obj.optString(\"img\", \"\")");
                    str5 = optString;
                } else {
                    str5 = "";
                }
                if (str6 == null || str7 == null) {
                    return null;
                }
                return new AdInfo(str, str2, str3, str6, str7, str9, str5, str4);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public final boolean checkName(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        switch (str.hashCode()) {
            case -264365059:
                return str.equals("TT_FEED");
            case 2402104:
                if (str.equals("NONE")) {
                }
                break;
            case 1268689752:
                if (str.equals("TT_SELF_DRAW")) {
                }
                break;
            case 1282203741:
                if (str.equals("QQ_FEED")) {
                }
                break;
            case 1977328376:
                if (str.equals("QQ_SELF_DRAW")) {
                }
                break;
        }
    }

    public final synchronized void banAd(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "adId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", str + "_" + str2);
        jSONObject.put("timestamp", System.currentTimeMillis());
        JSONArray banAds2 = getBanAds();
        banAds2.put(jSONObject);
        removeInvalid(banAds2);
        setBanAds(banAds2);
    }

    public final boolean containBandAd(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "adMark");
        JSONArray banAds2 = getBanAds();
        String str3 = str + "_" + str2;
        int length = banAds2.length();
        for (int i = 0; i < length; i++) {
            if (Intrinsics.areEqual(banAds2.getJSONObject(i).getString("id"), str3)) {
                return true;
            }
        }
        return false;
    }

    public final synchronized JSONArray getBanAds() {
        JSONArray jSONArray;
        jSONArray = banAds;
        if (jSONArray == null) {
            try {
                String preferencesString = DataManager.getInstance().getPreferencesString("BAN_ADS", null);
                if (preferencesString != null) {
                    jSONArray = new JSONArray(preferencesString);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            removeInvalid(jSONArray);
            banAds = jSONArray;
        }
        return jSONArray;
    }

    private final synchronized void setBanAds(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String jSONArray2 = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "ads.toString()");
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putString("BAN_ADS", jSONArray2).apply();
        } else {
            DataManager instance2 = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
            instance2.getPreferencesEditor().remove("BAN_ADS").apply();
        }
        banAds = jSONArray;
    }

    public final void cleanBanAds() {
        setBanAds(new JSONArray());
    }

    private final void removeInvalid(JSONArray jSONArray) {
        long currentTimeMillis = System.currentTimeMillis();
        for (int length = jSONArray.length() - 1; length >= 0; length--) {
            if (length > 20) {
                jSONArray.remove(length);
            }
            if (jSONArray.getJSONObject(length).getLong("timestamp") + TimeUnit.DAYS.toMillis(7) < currentTimeMillis) {
                jSONArray.remove(length);
            }
        }
    }
}
