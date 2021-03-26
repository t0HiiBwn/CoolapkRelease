package com.bytedance.sdk.openadsdk.utils;

import com.bytedance.sdk.openadsdk.AdSlot;
import org.json.JSONObject;

/* compiled from: SlotUtils */
public class af {
    public static AdSlot a(String str) {
        try {
            return a(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static AdSlot a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AdSlot.Builder builder = new AdSlot.Builder();
        try {
            int optInt = jSONObject.optInt("width", 640);
            int optInt2 = jSONObject.optInt("height", 320);
            double optDouble = jSONObject.optDouble("expressWidth", 0.0d);
            double optDouble2 = jSONObject.optDouble("expressHeight", 0.0d);
            builder.setAdCount(jSONObject.optInt("adCount", 1));
            builder.setCodeId(jSONObject.optString("codeId", null));
            builder.setImageAcceptedSize(optInt, optInt2);
            builder.setMediaExtra(jSONObject.optString("extra", null));
            builder.setNativeAdType(jSONObject.optInt("adType"));
            builder.setOrientation(jSONObject.optInt("orientation"));
            builder.setSupportDeepLink(jSONObject.optBoolean("supportDeepLink", true));
            builder.setUserID(jSONObject.optString("userId", null));
            builder.setIsAutoPlay(jSONObject.optBoolean("autoPlay", true));
            builder.setExpressViewAcceptedSize(Double.valueOf(optDouble).floatValue(), Double.valueOf(optDouble2).floatValue());
            builder.setPrimeRit(jSONObject.optString("prime_rit", null));
            builder.setAdloadSeq(jSONObject.optInt("show_seq", 0));
            builder.setExtraParam(jSONObject.optString("extraSmartLookParam", null));
            builder.setExtraParam(jSONObject.optString("ad_id", null));
            builder.setExtraParam(jSONObject.optString("creative_id", null));
            builder.withBid(jSONObject.optString("mBidAdm"));
        } catch (Exception unused) {
        }
        return builder.build();
    }

    public static String a(AdSlot adSlot) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adCount", adSlot.getAdCount());
            jSONObject.put("codeId", adSlot.getCodeId());
            jSONObject.put("width", adSlot.getImgAcceptedWidth());
            jSONObject.put("height", adSlot.getImgAcceptedHeight());
            jSONObject.put("extra", adSlot.getMediaExtra());
            jSONObject.put("adType", adSlot.getNativeAdType());
            jSONObject.put("orientation", adSlot.getOrientation());
            jSONObject.put("supportDeepLink", adSlot.isSupportDeepLink());
            jSONObject.put("userId", adSlot.getUserID());
            jSONObject.put("expressWidth", (double) adSlot.getExpressViewAcceptedWidth());
            jSONObject.put("expressHeight", (double) adSlot.getExpressViewAcceptedHeight());
            jSONObject.put("autoPlay", adSlot.isAutoPlay());
            jSONObject.put("prime_rit", adSlot.getPrimeRit());
            jSONObject.put("show_seq", adSlot.getAdloadSeq());
            jSONObject.put("extraSmartLookParam", adSlot.getExtraSmartLookParam());
            jSONObject.put("ad_id", adSlot.getAdId());
            jSONObject.put("creative_id", adSlot.getCreativeId());
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }
}
